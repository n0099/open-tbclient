package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.a.c.e.p.l;
import d.a.r0.w.m;
import d.a.r0.w.n;
import d.a.s0.h2.k.e.r;
import d.a.s0.h2.k.e.v;
import d.a.s0.h2.k.e.v0;
import d.a.s0.h2.k.e.w;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements r.c, VoiceManager.j, d.a.r0.w.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REPLY_MAX_SIZE = 140;
    public transient /* synthetic */ FieldHolder $fh;
    public View mBackBtn;
    public v0 mContentProcessController;
    public Context mContext;
    public PbFullScreenEditorInputView mEditContent;
    public SpanGroupManager mEditContentSpanGroupManager;
    public w mEditorBuilder;
    public LinearLayout mEditorContainer;
    public EditorTools mEditorTools;
    public v mFullScreenEditor;
    public GestureDetector mGestureDetector;
    public r mImgsAdapter;
    public WholeDisplayGridView mImgsGridView;
    public ImageView mIvDeleteVoice;
    public LinearLayout mLayoutDelVoice;
    public LinearLayout mLayoutVoicePlay;
    public NavigationBar mNavigationBar;
    public PbEditorData mPbEditorData;
    public TextView mPostBtn;
    public PostWriteCallBackData mPostWriteCallBackData;
    public EditorScrollView mScrollView;
    public View mScrollViewChild;
    public String mSubPbReplyPrefix;
    public PbEditorData.ThreadData mThreadData;
    public View mTopLine;
    public TextView mTvName;
    public VoiceManager mVoiceManager;
    public PlayVoiceBntNew mVoicePlayButton;
    public WriteImagesInfo mWriteImagesInfo;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19323a;

        public a(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19323a = pbFullScreenEditorActivity;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19323a.mEditorTools != null) {
                    this.f19323a.mEditorTools.q();
                    this.f19323a.mEditorTools.y();
                }
                l.x(this.f19323a.mContext, this.f19323a.mEditContent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19324e;

        public b(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19324e = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19324e.mEditorTools == null) {
                return;
            }
            this.f19324e.mEditorTools.q();
            this.f19324e.mEditorTools.y();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19325e;

        public c(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19325e = pbFullScreenEditorActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f19325e.checkPostBtnEnabled();
                v0 v0Var = this.f19325e.mContentProcessController;
                if (v0Var == null || v0Var.e() == null) {
                    return;
                }
                if (!this.f19325e.mContentProcessController.e().e()) {
                    this.f19325e.mContentProcessController.a(false);
                }
                this.f19325e.mContentProcessController.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19326e;

        public d(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19326e = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19326e.deleteVoice();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int[] f19327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19328f;

        public e(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19328f = pbFullScreenEditorActivity;
            this.f19327e = new int[2];
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                l.x(TbadkCoreApplication.getInst(), this.f19328f.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            WholeDisplayGridView wholeDisplayGridView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (motionEvent != null && (wholeDisplayGridView = this.f19328f.mImgsGridView) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.f19327e);
                    int x = ((int) motionEvent.getX()) - this.f19327e[0];
                    int y = ((int) motionEvent.getY()) - this.f19327e[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        this.f19328f.mEditorTools.q();
                        this.f19328f.mEditorTools.y();
                        l.K(TbadkCoreApplication.getInst(), this.f19328f.mEditContent);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19329e;

        public f(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19329e = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19329e.mEditorTools != null) {
                    this.f19329e.mEditorTools.q();
                    this.f19329e.mEditorTools.y();
                }
                l.K(TbadkCoreApplication.getInst(), this.f19329e.mEditContent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19330e;

        public g(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19330e = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19330e.onBackPressed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19331e;

        public h(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19331e = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19331e.onBack(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFullScreenEditorActivity f19333f;

        public i(PbFullScreenEditorActivity pbFullScreenEditorActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19333f = pbFullScreenEditorActivity;
            this.f19332e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19333f.showToast(this.f19332e);
            }
        }
    }

    public PbFullScreenEditorActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackBtn = null;
        this.mPostBtn = null;
        this.mTvName = null;
    }

    private void addVoice(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || voiceData$VoiceModel.duration <= 0) {
            return;
        }
        this.mFullScreenEditor.r(voiceData$VoiceModel);
        this.mLayoutVoicePlay.setVisibility(0);
        this.mVoicePlayButton.setVoiceModel(voiceData$VoiceModel);
        checkPostBtnEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPostBtnEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
            boolean z = false;
            boolean z2 = writeImagesInfo != null && writeImagesInfo.size() > 0;
            boolean z3 = !TextUtils.isEmpty(this.mEditContent.getText().toString());
            v vVar = this.mFullScreenEditor;
            z = (z2 || z3 || (vVar != null && vVar.h() != null)) ? true : true;
            TextView textView = this.mPostBtn;
            if (textView != null) {
                textView.setEnabled(z);
            }
            if (z) {
                TextView textView2 = this.mPostBtn;
                if (textView2 != null) {
                    SkinManager.setViewTextColor(textView2, R.color.CAM_X0302);
                    return;
                }
                return;
            }
            TextView textView3 = this.mPostBtn;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVoice() {
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.mFullScreenEditor.h() != null) {
                d.a.r0.r.g0.a.a(d.a.r0.r.g0.a.b(this.mFullScreenEditor.h().voiceId));
            }
            this.mFullScreenEditor.r(null);
            this.mLayoutVoicePlay.setVisibility(8);
            this.mVoicePlayButton.setVoiceModel(null);
            m n = this.mEditorTools.n(6);
            if (n != null && (nVar = n.k) != null) {
                nVar.onAction(new d.a.r0.w.a(52, 0, null));
            }
            checkPostBtnEnabled();
        }
    }

    private void ensureWriteImagesInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void getResData(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65547, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        ensureWriteImagesInfo();
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
    }

    private void handleAlbumResultData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, intent) == null) {
            getResData(intent, true);
        }
    }

    private void handleCameraResultData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, intent) == null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.mContext, l.k(this.mContext)), l.e(this.mContext, l.i(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            ensureWriteImagesInfo();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void handleMotuResultData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, intent) == null) {
            getResData(intent, false);
        }
    }

    private void initData() {
        n nVar;
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            Intent intent = getIntent();
            if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
                this.mPbEditorData = pbEditorData;
                if (pbEditorData == null) {
                    return;
                }
                initEditTools(pbEditorData.getEditorType() == 1);
                String disableVoiceMessage = this.mPbEditorData.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && (editorTools = this.mEditorTools) != null) {
                    d.a.r0.w.h m = editorTools.m(6);
                    if (m instanceof View) {
                        ((View) m).setOnClickListener(new i(this, disableVoiceMessage));
                    }
                }
                PbEditorData.ThreadData threadData = this.mPbEditorData.getThreadData();
                this.mThreadData = threadData;
                w wVar = this.mEditorBuilder;
                if (wVar != null) {
                    wVar.l(threadData);
                }
                v vVar = this.mFullScreenEditor;
                if (vVar != null) {
                    vVar.q(this.mThreadData);
                }
                String content = this.mPbEditorData.getContent();
                if (this.mPbEditorData.getEditorType() == 1) {
                    String subPbReplyPrefix = this.mPbEditorData.getSubPbReplyPrefix();
                    this.mSubPbReplyPrefix = subPbReplyPrefix;
                    this.mEditContent.k(subPbReplyPrefix, content);
                } else {
                    this.mEditContent.j(content);
                }
                WriteImagesInfo writeImagesInfo = this.mPbEditorData.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.mImgsAdapter.c(writeImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                }
                VoiceData$VoiceModel voiceModel = this.mPbEditorData.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.mLayoutVoicePlay.setVisibility(0);
                    this.mVoicePlayButton.setVoiceModel(voiceModel);
                    this.mFullScreenEditor.r(voiceModel);
                    m n = this.mEditorTools.n(6);
                    if (n != null && (nVar = n.k) != null) {
                        nVar.onAction(new d.a.r0.w.a(52, 0, voiceModel));
                    }
                    EditorTools editorTools2 = this.mEditorTools;
                    editorTools2.x((View) editorTools2.m(6));
                }
            }
            if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
                this.mPostWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            checkPostBtnEnabled();
        }
    }

    private void initEditTools(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, this, z) == null) {
            this.mEditorContainer = (LinearLayout) findViewById(R.id.editbar_container);
            w wVar = new w();
            this.mEditorBuilder = wVar;
            wVar.j(z);
            PbEditorData pbEditorData = this.mPbEditorData;
            if (pbEditorData != null && pbEditorData.getThreadData() != null) {
                this.mEditorBuilder.i(this.mPbEditorData.getThreadData().isBJH);
            }
            v vVar = (v) this.mEditorBuilder.a(this.mContext);
            this.mFullScreenEditor = vVar;
            this.mEditorTools = vVar.a();
            this.mFullScreenEditor.p(this);
            this.mEditorBuilder.k(this);
            this.mEditorContainer.addView(this.mEditorTools, new LinearLayout.LayoutParams(-1, -2));
            this.mEditorTools.w(TbadkCoreApplication.getInst().getSkinType());
            this.mFullScreenEditor.j(this);
            this.mEditorTools.j();
        }
    }

    private void initGestureControl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mGestureDetector = new GestureDetector(new e(this));
            View findViewById = findViewById(R.id.scroll_view_child);
            this.mScrollViewChild = findViewById;
            findViewById.setOnClickListener(new f(this));
        }
    }

    private void initNavigationBar() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBackBtn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
            this.mTvName = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, R.color.CAM_X0105);
            this.mPostBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView == null || !(backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) || (view = this.mBackBtn) == null || this.mPostBtn == null) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBackBtn.getLayoutParams();
            layoutParams2.width = -2;
            this.mBackBtn.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.mBackBtn.setOnClickListener(new g(this));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPostBtn.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = l.g(getActivity(), R.dimen.ds14);
            this.mPostBtn.setLayoutParams(layoutParams3);
            this.mPostBtn.setOnClickListener(new h(this));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            initNavigationBar();
            this.mTopLine = findViewById(R.id.view_line);
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.scroll_view);
            this.mScrollView = editorScrollView;
            editorScrollView.setListener(new a(this));
            initGestureControl();
            PbFullScreenEditorInputView pbFullScreenEditorInputView = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
            this.mEditContent = pbFullScreenEditorInputView;
            pbFullScreenEditorInputView.setOnClickListener(new b(this));
            this.mEditContent.addTextChangedListener(new c(this));
            this.mEditContentSpanGroupManager = this.mEditContent.getSpanGroupManager();
            this.mLayoutVoicePlay = (LinearLayout) findViewById(R.id.layout_voice_play);
            this.mVoicePlayButton = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
            this.mLayoutDelVoice = (LinearLayout) findViewById(R.id.layout_del_voice);
            this.mIvDeleteVoice = (ImageView) findViewById(R.id.iv_delete_voice);
            this.mLayoutDelVoice.setOnClickListener(new d(this));
            this.mImgsGridView = (WholeDisplayGridView) findViewById(R.id.gridview);
            r rVar = new r(this.mContext);
            this.mImgsAdapter = rVar;
            rVar.b(this);
            this.mImgsGridView.setAdapter((ListAdapter) this.mImgsAdapter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.r0.w.b
    public void onAction(d.a.r0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f56766a;
        if (i2 == 3) {
            d.a.s0.o0.b.a(this.mEditContent);
        } else if (i2 == 14) {
            ensureWriteImagesInfo();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "pb");
            PbEditorData.ThreadData threadData = this.mThreadData;
            if (threadData != null && !TextUtils.isEmpty(threadData.getForumId())) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
            }
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (d.a.r0.w.w.a.a().b() == 1) {
                albumFloatActivityConfig.setRequestFrom(2);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        } else if (i2 != 24) {
            if (i2 != 10) {
                if (i2 != 11) {
                    return;
                }
                deleteVoice();
                return;
            }
            Object obj = aVar.f56768c;
            if (obj instanceof VoiceData$VoiceModel) {
                addVoice((VoiceData$VoiceModel) obj);
            }
        } else {
            Object obj2 = aVar.f56768c;
            if (obj2 instanceof d.a.r0.s.c.v) {
                d.a.r0.s.c.v vVar = (d.a.r0.s.c.v) obj2;
                if (vVar.f() != EmotionGroupType.BIG_EMOTION && vVar.f() != EmotionGroupType.USER_COLLECT) {
                    this.mEditContent.l(vVar);
                    return;
                }
                if (this.mCurrentPermissionJudgePolicy == null) {
                    this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                }
                this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                    return;
                }
                if (this.mWriteImagesInfo.size() >= this.mWriteImagesInfo.getMaxImagesAllowed()) {
                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                    return;
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(vVar.c());
                imageFileInfo.width = vVar.h();
                imageFileInfo.height = vVar.b();
                ensureWriteImagesInfo();
                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                this.mWriteImagesInfo.updateQuality();
                this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                this.mImgsAdapter.notifyDataSetChanged();
                checkPostBtnEnabled();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            v vVar = this.mFullScreenEditor;
            if (vVar != null) {
                vVar.k(i2, i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 12002) {
                    if (intent == null) {
                        return;
                    }
                    ensureWriteImagesInfo();
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        handleCameraResultData(intent);
                    } else {
                        handleAlbumResultData(intent);
                    }
                    this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                    checkPostBtnEnabled();
                } else if (i2 == 12004) {
                    if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                        return;
                    }
                    this.mEditContent.g(stringArrayListExtra);
                } else if (i2 != 12012) {
                    if (i2 == 25004 && intent != null) {
                        this.mEditContent.h(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                    }
                } else {
                    ensureWriteImagesInfo();
                    handleMotuResultData(intent);
                    this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                    checkPostBtnEnabled();
                }
            }
        }
    }

    public void onBack(boolean z) {
        String editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            Intent intent = new Intent();
            if (this.mPbEditorData == null) {
                this.mPbEditorData = new PbEditorData();
            }
            SpanGroupManager spanGroupManager = this.mEditContentSpanGroupManager;
            if (spanGroupManager != null) {
                editText = spanGroupManager.p();
            } else {
                editText = this.mEditContent.toString();
            }
            this.mPbEditorData.setContent(editText);
            this.mPbEditorData.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
            this.mPbEditorData.setWriteImagesInfo(this.mWriteImagesInfo);
            this.mPbEditorData.setVoiceModel(this.mFullScreenEditor.h());
            intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.mPbEditorData);
            if (z) {
                v0 v0Var = this.mContentProcessController;
                if (v0Var != null && v0Var.e() != null && this.mContentProcessController.e().d()) {
                    showToast(this.mContentProcessController.e().c());
                    this.mContentProcessController.a(true);
                    return;
                }
                setResult(-1, intent);
            } else {
                setResult(0, intent);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onBack(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.mEditContent, R.color.CAM_X0105);
            this.mEditContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.mIvDeleteVoice, R.drawable.icon_edit_close_n);
            SkinManager.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.mTvName, R.color.CAM_X0105);
            checkPostBtnEnabled();
            v0 v0Var = this.mContentProcessController;
            if (v0Var != null) {
                v0Var.i();
            }
            EditorTools editorTools = this.mEditorTools;
            if (editorTools != null) {
                editorTools.w(i2);
            }
        }
    }

    @Override // d.a.s0.h2.k.e.r.c
    public void onClickImage(int i2) {
        ImageFileInfo imageInfoAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, i2)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PbFullScreenEditorInputView pbFullScreenEditorInputView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getPageContext().getPageActivity();
            setSwipeBackEnabled(false);
            setContentView(R.layout.layout_pb_editor_activity);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            initView();
            initData();
            PbEditorData pbEditorData = this.mPbEditorData;
            if (pbEditorData != null && pbEditorData.getEditorType() == 1 && (pbFullScreenEditorInputView = this.mEditContent) != null) {
                pbFullScreenEditorInputView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(REPLY_MAX_SIZE)});
            }
            v0 v0Var = new v0();
            this.mContentProcessController = v0Var;
            PbFullScreenEditorInputView pbFullScreenEditorInputView2 = this.mEditContent;
            if (pbFullScreenEditorInputView2 != null) {
                v0Var.m(pbFullScreenEditorInputView2);
            }
            PostWriteCallBackData postWriteCallBackData = this.mPostWriteCallBackData;
            if (postWriteCallBackData != null) {
                this.mContentProcessController.k(postWriteCallBackData);
            }
            adjustResizeForSoftInput();
        }
    }

    @Override // d.a.s0.h2.k.e.r.c
    public void onDeleteImage(int i2) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (writeImagesInfo = this.mWriteImagesInfo) == null || writeImagesInfo.getChosedFiles() == null) {
            return;
        }
        if (i2 >= 0 && i2 < this.mWriteImagesInfo.size()) {
            ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            this.mImgsAdapter.notifyDataSetChanged();
        }
        checkPostBtnEnabled();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            v0 v0Var = this.mContentProcessController;
            if (v0Var != null) {
                v0Var.j();
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.removeBlackScreen();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l.x(this, getCurrentFocus());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        v vVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, strArr, iArr) == null) {
            if (i2 == 0 && (vVar = this.mFullScreenEditor) != null) {
                vVar.t();
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }
}
