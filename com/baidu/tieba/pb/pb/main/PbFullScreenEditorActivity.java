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
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.cx4;
import com.baidu.tieba.jy4;
import com.baidu.tieba.lw7;
import com.baidu.tieba.m45;
import com.baidu.tieba.ma6;
import com.baidu.tieba.n25;
import com.baidu.tieba.o25;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.pw7;
import com.baidu.tieba.qw7;
import com.baidu.tieba.ri;
import com.baidu.tieba.s28;
import com.baidu.tieba.t45;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tu4;
import com.baidu.tieba.u25;
import com.baidu.tieba.wb;
import com.baidu.tieba.xx7;
import com.baidu.tieba.y25;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements lw7.c, VoiceManager.j, o25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector A;
    public String B;
    public NavigationBar a;
    public View b;
    public View c;
    public TextView d;
    public TextView e;
    public EditorScrollView f;
    public PbFullScreenEditorInputView g;
    public SpanGroupManager h;
    public WholeDisplayGridView i;
    public lw7 j;
    public LinearLayout k;
    public PlayVoiceBntNew l;
    public LinearLayout m;
    public ImageView n;
    public LinearLayout o;
    public EditorTools p;
    public qw7 q;
    public pw7 r;
    public Context s;
    public WriteImagesInfo t;
    public PbEditorData u;
    public PbEditorData.ThreadData v;
    public VoiceManager w;
    public xx7 x;
    public PostWriteCallBackData y;
    public View z;

    /* loaded from: classes5.dex */
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
                if (this.a.p != null) {
                    this.a.p.q();
                    this.a.p.y();
                }
                ri.x(this.a.s, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.p == null) {
                return;
            }
            this.a.p.q();
            this.a.p.y();
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.I1();
                xx7 xx7Var = this.a.x;
                if (xx7Var == null || xx7Var.e() == null) {
                    return;
                }
                if (!this.a.x.e().e()) {
                    this.a.x.a(false);
                }
                this.a.x.e().l(false);
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

    /* loaded from: classes5.dex */
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
                this.a.J1();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                ri.x(TbadkCoreApplication.getInst(), this.b.getCurrentFocus());
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
                if (motionEvent != null && (wholeDisplayGridView = this.b.i) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.a);
                    int x = ((int) motionEvent.getX()) - this.a[0];
                    int y = ((int) motionEvent.getY()) - this.a[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        this.b.p.q();
                        this.b.p.y();
                        ri.L(TbadkCoreApplication.getInst(), this.b.g);
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
                if (this.a.p != null) {
                    this.a.p.q();
                    this.a.p.y();
                }
                ri.L(TbadkCoreApplication.getInst(), this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        /* loaded from: classes5.dex */
        public class a implements t45.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.t45.c
            public void a() {
                z25 z25Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    y25 n = this.a.a.p.n(8);
                    if (n != null && (z25Var = n.m) != null) {
                        z25Var.J(new n25(68, 8, null));
                    }
                    tu4.k().u("key_virtual_image_and_state_ying_has_show", false);
                }
            }
        }

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
                int i = 1;
                boolean h = tu4.k().h("key_virtual_image_and_state_ying_has_show", true);
                s28 a2 = s28.a();
                int i2 = 2;
                if (h && (a2 == null || a2.b() != 1)) {
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21);
                    if (this.a.u != null && this.a.u.getEditorType() == 1) {
                        i = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    t45.c(new a(this));
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 17).param("obj_type", (this.a.u == null || this.a.u.getEditorType() != 1) ? 1 : 1).param("obj_source", this.a.getPreExtraPageKey()));
                this.a.T1(true);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.baidu.tieba.o25
    public void A(n25 n25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, n25Var) == null) || n25Var == null) {
            return;
        }
        int i2 = n25Var.a;
        if (i2 == 3) {
            ma6.a(this.g);
        } else if (i2 == 14) {
            K1();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.s, this.t.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "pb");
            PbEditorData.ThreadData threadData = this.v;
            if (threadData != null && !TextUtils.isEmpty(threadData.getForumId())) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
            }
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            if (m45.a().b() == 1) {
                albumFloatActivityConfig.setRequestFrom(2);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        } else if (i2 == 16) {
            if (H1(getPageContext(), 11025)) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this, 12004, true);
                PbFullScreenEditorInputView pbFullScreenEditorInputView = this.g;
                if (pbFullScreenEditorInputView != null) {
                    atListActivityConfig.setSelectedAtList(pbFullScreenEditorInputView.getAtDataInText());
                }
                PbEditorData.ThreadData threadData2 = this.v;
                if (threadData2 != null) {
                    atListActivityConfig.setFromTid(threadData2.getThreadId());
                    atListActivityConfig.setFromFid(this.v.getForumId());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                PbEditorData.ThreadData threadData3 = this.v;
                if (threadData3 != null) {
                    statisticItem.addParam("tid", threadData3.getThreadId());
                    statisticItem.addParam("fid", this.v.getForumId());
                }
                TiebaStatic.log(statisticItem);
            }
        } else if (i2 != 24) {
            if (i2 != 10) {
                if (i2 != 11) {
                    return;
                }
                J1();
                return;
            }
            Object obj = n25Var.c;
            if (obj instanceof VoiceData.VoiceModel) {
                G1((VoiceData.VoiceModel) obj);
            }
        } else {
            Object obj2 = n25Var.c;
            if (obj2 instanceof jy4) {
                jy4 jy4Var = (jy4) obj2;
                if (EmotionGroupType.isSendAsPic(jy4Var.getType())) {
                    if (this.mCurrentPermissionJudgePolicy == null) {
                        this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                    }
                    this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                    this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                        return;
                    }
                    if (this.t.size() >= this.t.getMaxImagesAllowed()) {
                        showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0aa8), Integer.valueOf(this.t.getMaxImagesAllowed())));
                        return;
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setImageType(1);
                    imageFileInfo.setFilePath(jy4Var.d());
                    imageFileInfo.width = jy4Var.h();
                    imageFileInfo.height = jy4Var.b();
                    K1();
                    this.t.addChooseFile(imageFileInfo);
                    this.t.updateQuality();
                    this.j.c(this.t.getChosedFiles());
                    this.j.notifyDataSetChanged();
                    I1();
                    return;
                }
                this.g.n(jy4Var);
            }
        }
    }

    public final void G1(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.r.q(voiceModel);
        this.k.setVisibility(0);
        this.l.setVoiceModel(voiceModel);
        I1();
    }

    public final boolean H1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WriteImagesInfo writeImagesInfo = this.t;
            boolean z = false;
            boolean z2 = writeImagesInfo != null && writeImagesInfo.size() > 0;
            boolean z3 = !TextUtils.isEmpty(this.g.getText().toString());
            pw7 pw7Var = this.r;
            z = (z2 || z3 || (pw7Var != null && pw7Var.g() != null)) ? true : true;
            TextView textView = this.d;
            if (textView != null) {
                textView.setEnabled(z);
            }
            if (z) {
                TextView textView2 = this.d;
                if (textView2 != null) {
                    SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0302);
                    return;
                }
                return;
            }
            TextView textView3 = this.d;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
        }
    }

    public final void J1() {
        z25 z25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r.g() != null) {
                cx4.a(cx4.b(this.r.g().voiceId));
            }
            this.r.q(null);
            this.k.setVisibility(8);
            this.l.setVoiceModel(null);
            y25 n = this.p.n(6);
            if (n != null && (z25Var = n.m) != null) {
                z25Var.A(new n25(52, 0, null));
            }
            I1();
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.t == null) {
            this.t = new WriteImagesInfo();
        }
    }

    public final void L1(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        K1();
        this.t.parseJson(stringExtra);
        this.t.updateQuality();
    }

    public final void M1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            L1(intent, true);
        }
    }

    public final void N1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, ri.d(this.s, ri.k(this.s)), ri.d(this.s, ri.i(this.s)));
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
            K1();
            this.t.addChooseFile(imageFileInfo);
            this.t.updateQuality();
        }
    }

    public final void O1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            L1(intent, false);
        }
    }

    public final void P1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090870);
            qw7 qw7Var = new qw7();
            this.q = qw7Var;
            qw7Var.j(z);
            PbEditorData pbEditorData = this.u;
            if (pbEditorData != null && pbEditorData.getThreadData() != null) {
                this.q.i(this.u.getThreadData().isBJH);
            }
            pw7 pw7Var = (pw7) this.q.a(this.s);
            this.r = pw7Var;
            this.p = pw7Var.a();
            this.r.o(this);
            this.q.k(this);
            this.o.addView(this.p, new LinearLayout.LayoutParams(-1, -2));
            this.p.w(TbadkCoreApplication.getInst().getSkinType());
            this.r.i(this);
            this.p.j();
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.A = new GestureDetector(new e(this));
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091d84);
            this.z = findViewById;
            findViewById.setOnClickListener(new f(this));
        }
    }

    public final void R1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091626);
            this.a = navigationBar;
            navigationBar.showBottomLine();
            this.c = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0dee));
            this.e = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            this.d = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f110f));
            ImageView backImageView = this.a.getBackImageView();
            if (backImageView == null || !(backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) || (view2 = this.c) == null || this.d == null) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.leftMargin = ri.f(getActivity(), R.dimen.obfuscated_res_0x7f070259);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams2.width = -2;
            this.c.setLayoutParams(layoutParams2);
            if (this.a.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.getBackImageView(), R.drawable.obfuscated_res_0x7f0809f5, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.c.setOnClickListener(new g(this));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = ri.f(getActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.d.setLayoutParams(layoutParams3);
            this.d.setOnClickListener(new h(this));
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            R1();
            this.b = findViewById(R.id.obfuscated_res_0x7f092560);
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.obfuscated_res_0x7f091d83);
            this.f = editorScrollView;
            editorScrollView.setListener(new a(this));
            Q1();
            PbFullScreenEditorInputView pbFullScreenEditorInputView = (PbFullScreenEditorInputView) findViewById(R.id.obfuscated_res_0x7f090858);
            this.g = pbFullScreenEditorInputView;
            pbFullScreenEditorInputView.setOnClickListener(new b(this));
            this.g.addTextChangedListener(new c(this));
            this.h = this.g.getSpanGroupManager();
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091292);
            this.l = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f090447);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091268);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe7);
            this.m.setOnClickListener(new d(this));
            this.i = (WholeDisplayGridView) findViewById(R.id.obfuscated_res_0x7f090cde);
            lw7 lw7Var = new lw7(this.s);
            this.j = lw7Var;
            lw7Var.b(this);
            this.i.setAdapter((ListAdapter) this.j);
        }
    }

    public void T1(boolean z) {
        String editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Intent intent = new Intent();
            if (this.u == null) {
                this.u = new PbEditorData();
            }
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                editText = spanGroupManager.A();
            } else {
                editText = this.g.toString();
            }
            this.u.setContent(editText);
            this.u.setSubPbReplyPrefix(this.B);
            this.u.setWriteImagesInfo(this.t);
            this.u.setVoiceModel(this.r.g());
            int i2 = 1;
            this.u.setShowCustomFigure(tu4.k().h("key_virtual_image_and_state_ying_has_show", true));
            intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.u);
            if (z) {
                xx7 xx7Var = this.x;
                if (xx7Var != null && xx7Var.e() != null && this.x.e().d()) {
                    showToast(this.x.e().c());
                    this.x.a(true);
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13);
                    PbEditorData pbEditorData = this.u;
                    if (pbEditorData != null && pbEditorData.getEditorType() == 1) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i2).param("obj_source", getPreExtraPageKey()));
                    return;
                }
                setResult(-1, intent);
            } else {
                setResult(0, intent);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            GestureDetector gestureDetector = this.A;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    public final void initData() {
        z25 z25Var;
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Intent intent = getIntent();
            if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
                this.u = pbEditorData;
                if (pbEditorData == null) {
                    return;
                }
                P1(pbEditorData.getEditorType() == 1);
                String disableVoiceMessage = this.u.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && (editorTools = this.p) != null) {
                    u25 m = editorTools.m(6);
                    if (m instanceof View) {
                        ((View) m).setOnClickListener(new i(this, disableVoiceMessage));
                    }
                }
                PbEditorData.ThreadData threadData = this.u.getThreadData();
                this.v = threadData;
                qw7 qw7Var = this.q;
                if (qw7Var != null) {
                    qw7Var.l(threadData);
                }
                pw7 pw7Var = this.r;
                if (pw7Var != null) {
                    pw7Var.p(this.v);
                }
                String content = this.u.getContent();
                if (this.u.getEditorType() == 1) {
                    String subPbReplyPrefix = this.u.getSubPbReplyPrefix();
                    this.B = subPbReplyPrefix;
                    this.g.m(subPbReplyPrefix, content);
                } else {
                    this.g.l(content);
                }
                WriteImagesInfo writeImagesInfo = this.u.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.t = writeImagesInfo;
                    this.j.c(writeImagesInfo.getChosedFiles());
                    this.j.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.u.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.k.setVisibility(0);
                    this.l.setVoiceModel(voiceModel);
                    this.r.q(voiceModel);
                    y25 n = this.p.n(6);
                    if (n != null && (z25Var = n.m) != null) {
                        z25Var.A(new n25(52, 0, voiceModel));
                    }
                    EditorTools editorTools2 = this.p;
                    editorTools2.x((View) editorTools2.m(6));
                }
            }
            if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
                this.y = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            I1();
        }
    }

    @Override // com.baidu.tieba.lw7.c
    public void n0(int i2) {
        ImageFileInfo imageInfoAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (imageInfoAt = this.t.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.t, i2)));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            pw7 pw7Var = this.r;
            if (pw7Var != null) {
                pw7Var.j(i2, i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11025) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this, 12004, true);
                    SpanGroupManager spanGroupManager = this.h;
                    if (spanGroupManager != null) {
                        atListActivityConfig.setSelectedAtList(spanGroupManager.w());
                    }
                    PbEditorData.ThreadData threadData = this.v;
                    if (threadData != null) {
                        atListActivityConfig.setFromTid(threadData.getThreadId());
                        atListActivityConfig.setFromFid(this.v.getForumId());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    PbEditorData.ThreadData threadData2 = this.v;
                    if (threadData2 != null) {
                        statisticItem.addParam("tid", threadData2.getThreadId());
                        statisticItem.addParam("fid", this.v.getForumId());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (i2 == 12002) {
                    if (intent == null) {
                        return;
                    }
                    K1();
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        N1(intent);
                    } else {
                        M1(intent);
                    }
                    this.j.c(this.t.getChosedFiles());
                    this.j.notifyDataSetChanged();
                    I1();
                } else if (i2 != 12004) {
                    if (i2 != 12012) {
                        if (i2 == 25004 && intent != null) {
                            this.g.j(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                            return;
                        }
                        return;
                    }
                    K1();
                    O1(intent);
                    this.j.c(this.t.getChosedFiles());
                    this.j.notifyDataSetChanged();
                    I1();
                } else if (intent != null) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    int selectionStart = this.g.getSelectionStart();
                    if (selectionStart > 0) {
                        int i4 = selectionStart - 1;
                        if (this.g.getText().toString().charAt(i4) == '@') {
                            this.g.getEditableText().delete(i4, selectionStart);
                        }
                    }
                    this.g.e(parcelableArrayListExtra);
                    if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                        return;
                    }
                    this.g.getText().delete(this.g.getSelectionStart(), this.g.getSelectionEnd());
                    this.g.b(parcelableArrayListExtra);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            T1(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            this.g.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.n, R.drawable.icon_edit_close_n);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            if (this.a.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.getBackImageView(), R.drawable.obfuscated_res_0x7f0809f5, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            I1();
            xx7 xx7Var = this.x;
            if (xx7Var != null) {
                xx7Var.i();
            }
            EditorTools editorTools = this.p;
            if (editorTools != null) {
                editorTools.w(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PbFullScreenEditorInputView pbFullScreenEditorInputView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            this.s = getPageContext().getPageActivity();
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d04af);
            VoiceManager voiceManager = new VoiceManager();
            this.w = voiceManager;
            voiceManager.onCreate(getPageContext());
            S1();
            initData();
            PbEditorData pbEditorData = this.u;
            if (pbEditorData != null && pbEditorData.getEditorType() == 1 && (pbFullScreenEditorInputView = this.g) != null) {
                pbFullScreenEditorInputView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Cea708Decoder.COMMAND_DLW)});
            }
            xx7 xx7Var = new xx7();
            this.x = xx7Var;
            PbFullScreenEditorInputView pbFullScreenEditorInputView2 = this.g;
            if (pbFullScreenEditorInputView2 != null) {
                xx7Var.m(pbFullScreenEditorInputView2);
            }
            PostWriteCallBackData postWriteCallBackData = this.y;
            if (postWriteCallBackData != null) {
                this.x.k(postWriteCallBackData);
            }
            adjustResizeForSoftInput();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            xx7 xx7Var = this.x;
            if (xx7Var != null) {
                xx7Var.j();
            }
            VoiceManager voiceManager = this.w;
            if (voiceManager != null) {
                voiceManager.removeBlackScreen();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ri.x(this, getCurrentFocus());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        pw7 pw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048603, this, i2, strArr, iArr) == null) {
            if (i2 == 0 && (pw7Var = this.r) != null) {
                pw7Var.s();
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.w : (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lw7.c
    public void x1(int i2) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || (writeImagesInfo = this.t) == null || writeImagesInfo.getChosedFiles() == null) {
            return;
        }
        if (i2 >= 0 && i2 < this.t.size()) {
            ImageFileInfo remove = this.t.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                wb.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            this.j.notifyDataSetChanged();
        }
        I1();
    }
}
