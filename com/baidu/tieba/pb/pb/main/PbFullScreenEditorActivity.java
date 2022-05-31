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
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.repackage.cw4;
import com.repackage.e05;
import com.repackage.f05;
import com.repackage.hs7;
import com.repackage.li;
import com.repackage.ls7;
import com.repackage.ms7;
import com.repackage.p66;
import com.repackage.qt7;
import com.repackage.rb;
import com.repackage.sz4;
import com.repackage.t15;
import com.repackage.tz4;
import com.repackage.wu4;
import com.repackage.zz4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements hs7.c, VoiceManager.j, tz4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REPLY_MAX_SIZE = 140;
    public transient /* synthetic */ FieldHolder $fh;
    public View mBackBtn;
    public qt7 mContentProcessController;
    public Context mContext;
    public PbFullScreenEditorInputView mEditContent;
    public SpanGroupManager mEditContentSpanGroupManager;
    public ms7 mEditorBuilder;
    public LinearLayout mEditorContainer;
    public EditorTools mEditorTools;
    public ls7 mFullScreenEditor;
    public GestureDetector mGestureDetector;
    public hs7 mImgsAdapter;
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

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public a(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.mEditorTools != null) {
                    this.a.mEditorTools.q();
                    this.a.mEditorTools.y();
                }
                li.x(this.a.mContext, this.a.mEditContent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public b(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mEditorTools == null) {
                return;
            }
            this.a.mEditorTools.q();
            this.a.mEditorTools.y();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public c(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.checkPostBtnEnabled();
                qt7 qt7Var = this.a.mContentProcessController;
                if (qt7Var == null || qt7Var.e() == null) {
                    return;
                }
                if (!this.a.mContentProcessController.e().e()) {
                    this.a.mContentProcessController.a(false);
                }
                this.a.mContentProcessController.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public d(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.deleteVoice();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public final /* synthetic */ PbFullScreenEditorActivity b;

        public e(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFullScreenEditorActivity;
            this.a = new int[2];
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                li.x(TbadkCoreApplication.getInst(), this.b.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            WholeDisplayGridView wholeDisplayGridView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (motionEvent != null && (wholeDisplayGridView = this.b.mImgsGridView) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.a);
                    int x = ((int) motionEvent.getX()) - this.a[0];
                    int y = ((int) motionEvent.getY()) - this.a[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        this.b.mEditorTools.q();
                        this.b.mEditorTools.y();
                        li.M(TbadkCoreApplication.getInst(), this.b.mEditContent);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public f(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mEditorTools != null) {
                    this.a.mEditorTools.q();
                    this.a.mEditorTools.y();
                }
                li.M(TbadkCoreApplication.getInst(), this.a.mEditContent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public g(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBackPressed();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public h(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBack(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PbFullScreenEditorActivity b;

        public i(PbFullScreenEditorActivity pbFullScreenEditorActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFullScreenEditorActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFullScreenEditorActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.showToast(this.a);
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

    private void addVoice(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.mFullScreenEditor.q(voiceModel);
        this.mLayoutVoicePlay.setVisibility(0);
        this.mVoicePlayButton.setVoiceModel(voiceModel);
        checkPostBtnEnabled();
    }

    private boolean checkLogin(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPostBtnEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
            boolean z = false;
            boolean z2 = writeImagesInfo != null && writeImagesInfo.size() > 0;
            boolean z3 = !TextUtils.isEmpty(this.mEditContent.getText().toString());
            ls7 ls7Var = this.mFullScreenEditor;
            z = (z2 || z3 || (ls7Var != null && ls7Var.g() != null)) ? true : true;
            TextView textView = this.mPostBtn;
            if (textView != null) {
                textView.setEnabled(z);
            }
            if (z) {
                TextView textView2 = this.mPostBtn;
                if (textView2 != null) {
                    SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                    return;
                }
                return;
            }
            TextView textView3 = this.mPostBtn;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVoice() {
        f05 f05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.mFullScreenEditor.g() != null) {
                wu4.a(wu4.b(this.mFullScreenEditor.g().voiceId));
            }
            this.mFullScreenEditor.q(null);
            this.mLayoutVoicePlay.setVisibility(8);
            this.mVoicePlayButton.setVoiceModel(null);
            e05 n = this.mEditorTools.n(6);
            if (n != null && (f05Var = n.m) != null) {
                f05Var.onAction(new sz4(52, 0, null));
            }
            checkPostBtnEnabled();
        }
    }

    private void ensureWriteImagesInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void getResData(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65548, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        ensureWriteImagesInfo();
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
    }

    private void handleAlbumResultData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, intent) == null) {
            getResData(intent, true);
        }
    }

    private void handleCameraResultData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, intent) == null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, li.d(this.mContext, li.k(this.mContext)), li.d(this.mContext, li.i(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
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
        if (interceptable == null || interceptable.invokeL(65551, this, intent) == null) {
            getResData(intent, false);
        }
    }

    private void initData() {
        f05 f05Var;
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
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
                    zz4 m = editorTools.m(6);
                    if (m instanceof View) {
                        ((View) m).setOnClickListener(new i(this, disableVoiceMessage));
                    }
                }
                PbEditorData.ThreadData threadData = this.mPbEditorData.getThreadData();
                this.mThreadData = threadData;
                ms7 ms7Var = this.mEditorBuilder;
                if (ms7Var != null) {
                    ms7Var.l(threadData);
                }
                ls7 ls7Var = this.mFullScreenEditor;
                if (ls7Var != null) {
                    ls7Var.p(this.mThreadData);
                }
                String content = this.mPbEditorData.getContent();
                if (this.mPbEditorData.getEditorType() == 1) {
                    String subPbReplyPrefix = this.mPbEditorData.getSubPbReplyPrefix();
                    this.mSubPbReplyPrefix = subPbReplyPrefix;
                    this.mEditContent.l(subPbReplyPrefix, content);
                } else {
                    this.mEditContent.k(content);
                }
                WriteImagesInfo writeImagesInfo = this.mPbEditorData.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.mImgsAdapter.c(writeImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.mPbEditorData.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.mLayoutVoicePlay.setVisibility(0);
                    this.mVoicePlayButton.setVoiceModel(voiceModel);
                    this.mFullScreenEditor.q(voiceModel);
                    e05 n = this.mEditorTools.n(6);
                    if (n != null && (f05Var = n.m) != null) {
                        f05Var.onAction(new sz4(52, 0, voiceModel));
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
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            this.mEditorContainer = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090848);
            ms7 ms7Var = new ms7();
            this.mEditorBuilder = ms7Var;
            ms7Var.j(z);
            PbEditorData pbEditorData = this.mPbEditorData;
            if (pbEditorData != null && pbEditorData.getThreadData() != null) {
                this.mEditorBuilder.i(this.mPbEditorData.getThreadData().isBJH);
            }
            ls7 ls7Var = (ls7) this.mEditorBuilder.a(this.mContext);
            this.mFullScreenEditor = ls7Var;
            this.mEditorTools = ls7Var.a();
            this.mFullScreenEditor.o(this);
            this.mEditorBuilder.k(this);
            this.mEditorContainer.addView(this.mEditorTools, new LinearLayout.LayoutParams(-1, -2));
            this.mEditorTools.w(TbadkCoreApplication.getInst().getSkinType());
            this.mFullScreenEditor.i(this);
            this.mEditorTools.j();
        }
    }

    private void initGestureControl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mGestureDetector = new GestureDetector(new e(this));
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091bfb);
            this.mScrollViewChild = findViewById;
            findViewById.setOnClickListener(new f(this));
        }
    }

    private void initNavigationBar() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBackBtn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0ddc));
            this.mTvName = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            this.mPostBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f1113));
            ImageView backImageView = this.mNavigationBar.getBackImageView();
            if (backImageView == null || !(backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) || (view2 = this.mBackBtn) == null || this.mPostBtn == null) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.leftMargin = li.f(getActivity(), R.dimen.obfuscated_res_0x7f07025c);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBackBtn.getLayoutParams();
            layoutParams2.width = -2;
            this.mBackBtn.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809dd, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.mBackBtn.setOnClickListener(new g(this));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPostBtn.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = li.f(getActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.mPostBtn.setLayoutParams(layoutParams3);
            this.mPostBtn.setOnClickListener(new h(this));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            initNavigationBar();
            this.mTopLine = findViewById(R.id.obfuscated_res_0x7f09239c);
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.obfuscated_res_0x7f091bfa);
            this.mScrollView = editorScrollView;
            editorScrollView.setListener(new a(this));
            initGestureControl();
            PbFullScreenEditorInputView pbFullScreenEditorInputView = (PbFullScreenEditorInputView) findViewById(R.id.obfuscated_res_0x7f090830);
            this.mEditContent = pbFullScreenEditorInputView;
            pbFullScreenEditorInputView.setOnClickListener(new b(this));
            this.mEditContent.addTextChangedListener(new c(this));
            this.mEditContentSpanGroupManager = this.mEditContent.getSpanGroupManager();
            this.mLayoutVoicePlay = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911c4);
            this.mVoicePlayButton = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f090430);
            this.mLayoutDelVoice = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09119b);
            this.mIvDeleteVoice = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f98);
            this.mLayoutDelVoice.setOnClickListener(new d(this));
            this.mImgsGridView = (WholeDisplayGridView) findViewById(R.id.obfuscated_res_0x7f090ca8);
            hs7 hs7Var = new hs7(this.mContext);
            this.mImgsAdapter = hs7Var;
            hs7Var.b(this);
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
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceModel)) == null) {
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

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i2 = sz4Var.a;
        if (i2 == 3) {
            p66.a(this.mEditContent);
        } else if (i2 == 14) {
            ensureWriteImagesInfo();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "pb");
            PbEditorData.ThreadData threadData = this.mThreadData;
            if (threadData != null && !TextUtils.isEmpty(threadData.getForumId())) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
            }
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            if (t15.a().b() == 1) {
                albumFloatActivityConfig.setRequestFrom(2);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        } else if (i2 == 16) {
            if (checkLogin(getPageContext(), 11025)) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this, 12004, true);
                PbFullScreenEditorInputView pbFullScreenEditorInputView = this.mEditContent;
                if (pbFullScreenEditorInputView != null) {
                    atListActivityConfig.setSelectedAtList(pbFullScreenEditorInputView.getAtDataInText());
                }
                PbEditorData.ThreadData threadData2 = this.mThreadData;
                if (threadData2 != null) {
                    atListActivityConfig.setFromTid(threadData2.getThreadId());
                    atListActivityConfig.setFromFid(this.mThreadData.getForumId());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                PbEditorData.ThreadData threadData3 = this.mThreadData;
                if (threadData3 != null) {
                    statisticItem.addParam("tid", threadData3.getThreadId());
                    statisticItem.addParam("fid", this.mThreadData.getForumId());
                }
                TiebaStatic.log(statisticItem);
            }
        } else if (i2 != 24) {
            if (i2 != 10) {
                if (i2 != 11) {
                    return;
                }
                deleteVoice();
                return;
            }
            Object obj = sz4Var.c;
            if (obj instanceof VoiceData.VoiceModel) {
                addVoice((VoiceData.VoiceModel) obj);
            }
        } else {
            Object obj2 = sz4Var.c;
            if (obj2 instanceof cw4) {
                cw4 cw4Var = (cw4) obj2;
                if (EmotionGroupType.isSendAsPic(cw4Var.getType())) {
                    if (this.mCurrentPermissionJudgePolicy == null) {
                        this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                    }
                    this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                    this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                        return;
                    }
                    if (this.mWriteImagesInfo.size() >= this.mWriteImagesInfo.getMaxImagesAllowed()) {
                        showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0aa2), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                        return;
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setImageType(1);
                    imageFileInfo.setFilePath(cw4Var.d());
                    imageFileInfo.width = cw4Var.h();
                    imageFileInfo.height = cw4Var.b();
                    ensureWriteImagesInfo();
                    this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                    this.mWriteImagesInfo.updateQuality();
                    this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                    checkPostBtnEnabled();
                    return;
                }
                this.mEditContent.m(cw4Var);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            ls7 ls7Var = this.mFullScreenEditor;
            if (ls7Var != null) {
                ls7Var.j(i2, i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11025) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this, 12004, true);
                    SpanGroupManager spanGroupManager = this.mEditContentSpanGroupManager;
                    if (spanGroupManager != null) {
                        atListActivityConfig.setSelectedAtList(spanGroupManager.u());
                    }
                    PbEditorData.ThreadData threadData = this.mThreadData;
                    if (threadData != null) {
                        atListActivityConfig.setFromTid(threadData.getThreadId());
                        atListActivityConfig.setFromFid(this.mThreadData.getForumId());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    PbEditorData.ThreadData threadData2 = this.mThreadData;
                    if (threadData2 != null) {
                        statisticItem.addParam("tid", threadData2.getThreadId());
                        statisticItem.addParam("fid", this.mThreadData.getForumId());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (i2 == 12002) {
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
                } else if (i2 != 12004) {
                    if (i2 != 12012) {
                        if (i2 == 25004 && intent != null) {
                            this.mEditContent.i(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                            return;
                        }
                        return;
                    }
                    ensureWriteImagesInfo();
                    handleMotuResultData(intent);
                    this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                    this.mImgsAdapter.notifyDataSetChanged();
                    checkPostBtnEnabled();
                } else if (intent != null) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    int selectionStart = this.mEditContent.getSelectionStart();
                    if (selectionStart > 0) {
                        int i4 = selectionStart - 1;
                        if (this.mEditContent.getText().toString().charAt(i4) == '@') {
                            this.mEditContent.getEditableText().delete(i4, selectionStart);
                        }
                    }
                    this.mEditContent.e(parcelableArrayListExtra);
                    if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                        return;
                    }
                    this.mEditContent.getText().delete(this.mEditContent.getSelectionStart(), this.mEditContent.getSelectionEnd());
                    this.mEditContent.b(parcelableArrayListExtra);
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
                editText = spanGroupManager.y();
            } else {
                editText = this.mEditContent.toString();
            }
            this.mPbEditorData.setContent(editText);
            this.mPbEditorData.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
            this.mPbEditorData.setWriteImagesInfo(this.mWriteImagesInfo);
            this.mPbEditorData.setVoiceModel(this.mFullScreenEditor.g());
            intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.mPbEditorData);
            if (z) {
                qt7 qt7Var = this.mContentProcessController;
                if (qt7Var != null && qt7Var.e() != null && this.mContentProcessController.e().d()) {
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
            SkinManager.setViewTextColor(this.mEditContent, (int) R.color.CAM_X0105);
            this.mEditContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.mIvDeleteVoice, R.drawable.icon_edit_close_n);
            SkinManager.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809dd, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.mTvName, (int) R.color.CAM_X0105);
            checkPostBtnEnabled();
            qt7 qt7Var = this.mContentProcessController;
            if (qt7Var != null) {
                qt7Var.i();
            }
            EditorTools editorTools = this.mEditorTools;
            if (editorTools != null) {
                editorTools.w(i2);
            }
        }
    }

    @Override // com.repackage.hs7.c
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
            setContentView(R.layout.obfuscated_res_0x7f0d0492);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            initView();
            initData();
            PbEditorData pbEditorData = this.mPbEditorData;
            if (pbEditorData != null && pbEditorData.getEditorType() == 1 && (pbFullScreenEditorInputView = this.mEditContent) != null) {
                pbFullScreenEditorInputView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
            }
            qt7 qt7Var = new qt7();
            this.mContentProcessController = qt7Var;
            PbFullScreenEditorInputView pbFullScreenEditorInputView2 = this.mEditContent;
            if (pbFullScreenEditorInputView2 != null) {
                qt7Var.m(pbFullScreenEditorInputView2);
            }
            PostWriteCallBackData postWriteCallBackData = this.mPostWriteCallBackData;
            if (postWriteCallBackData != null) {
                this.mContentProcessController.k(postWriteCallBackData);
            }
            adjustResizeForSoftInput();
        }
    }

    @Override // com.repackage.hs7.c
    public void onDeleteImage(int i2) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (writeImagesInfo = this.mWriteImagesInfo) == null || writeImagesInfo.getChosedFiles() == null) {
            return;
        }
        if (i2 >= 0 && i2 < this.mWriteImagesInfo.size()) {
            ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                rb.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
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
            qt7 qt7Var = this.mContentProcessController;
            if (qt7Var != null) {
                qt7Var.j();
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
            li.x(this, getCurrentFocus());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        ls7 ls7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, strArr, iArr) == null) {
            if (i2 == 0 && (ls7Var = this.mFullScreenEditor) != null) {
                ls7Var.s();
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }
}
