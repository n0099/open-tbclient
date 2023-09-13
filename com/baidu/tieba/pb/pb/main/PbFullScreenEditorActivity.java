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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.aj5;
import com.baidu.tieba.ao9;
import com.baidu.tieba.ed5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.f47;
import com.baidu.tieba.fj5;
import com.baidu.tieba.fl5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nm9;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.si5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ti5;
import com.baidu.tieba.vb;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wm9;
import com.baidu.tieba.xi5;
import com.baidu.tieba.xm9;
import com.baidu.tieba.zk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements nm9.c, VoiceManager.j, ti5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector A;
    public String B;
    public hz4.d C;
    public NavigationBar a;
    public View b;
    public View c;
    public TextView d;
    public TextView e;
    public EditorScrollView f;
    public PbFullScreenEditorInputView g;
    public SpanGroupManager h;
    public WholeDisplayGridView i;
    public nm9 j;
    public LinearLayout k;
    public PlayVoiceBntNew l;
    public LinearLayout m;
    public ImageView n;
    public LinearLayout o;
    public EditorTools p;
    public xm9 q;
    public wm9 r;
    public Context s;
    public WriteImagesInfo t;
    public PbEditorData u;
    public PbEditorData.ThreadData v;
    public VoiceManager w;
    public ao9 x;
    public PostWriteCallBackData y;
    public View z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        /* renamed from: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0447a implements zk5.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0447a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.zk5.c
            public void a() {
                fj5 fj5Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ej5 p = this.a.a.p.p(8);
                    if (p != null && (fj5Var = p.m) != null) {
                        fj5Var.U(new si5(68, 8, null));
                    }
                    SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_ying_has_show", false);
                }
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 1;
                boolean z = SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_ying_has_show", true);
                ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                int i2 = 2;
                if (z && (profileVirtualImageInfo == null || profileVirtualImageInfo.getIsSetVirtualImage() != 1)) {
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21);
                    if (this.a.u != null && this.a.u.getEditorType() == 1) {
                        i = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    zk5.c(new C0447a(this));
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 17).param("obj_type", (this.a.u == null || this.a.u.getEditorType() != 1) ? 1 : 1).param("obj_source", this.a.getPreExtraPageKey()));
                this.a.N1(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PbFullScreenEditorActivity b;

        public b(PbFullScreenEditorActivity pbFullScreenEditorActivity, String str) {
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

    /* loaded from: classes7.dex */
    public class c implements hz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        @Override // com.baidu.tieba.hz4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setPbReply" : (String) invokeV.objValue;
        }

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

        @Override // com.baidu.tieba.hz4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFullScreenEditor", "收到H5通知，更新全屏回帖内容：" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str = new JSONObject(str).optString("data", str);
                    } catch (Exception e) {
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.i("PbFullScreenEditor", "更新全屏回帖内容失败" + e);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.a.g.k(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null && !this.a.p.x()) {
                BdUtilHelper.showSoftKeyPad(TbadkCoreApplication.getInst(), this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

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
            this.a = pbFullScreenEditorActivity;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.p != null) {
                    this.a.p.t();
                    this.a.p.B();
                }
                BdUtilHelper.hideSoftKeyPad(this.a.s, this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p != null) {
                this.a.p.t();
                this.a.p.B();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.z1();
                ao9 ao9Var = this.a.x;
                if (ao9Var != null && ao9Var.e() != null) {
                    if (!this.a.x.e().e()) {
                        this.a.x.a(false);
                    }
                    this.a.x.e().l(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.A1();
        }
    }

    /* loaded from: classes7.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public final /* synthetic */ PbFullScreenEditorActivity b;

        public i(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
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
                BdUtilHelper.hideSoftKeyPad(TbadkCoreApplication.getInst(), this.b.getCurrentFocus());
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
                        this.b.p.t();
                        this.b.p.B();
                        BdUtilHelper.showSoftKeyPad(TbadkCoreApplication.getInst(), this.b.g);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public j(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
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
                    this.a.p.t();
                    this.a.p.B();
                }
                BdUtilHelper.showSoftKeyPad(TbadkCoreApplication.getInst(), this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFullScreenEditorActivity a;

        public k(PbFullScreenEditorActivity pbFullScreenEditorActivity) {
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
        this.C = new c(this);
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.t == null) {
            this.t = new WriteImagesInfo();
        }
    }

    public final String C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                return spanGroupManager.A();
            }
            return this.g.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbEditorData pbEditorData = this.u;
            if (pbEditorData != null && pbEditorData.getEditorType() == 1) {
                return Cea708Decoder.COMMAND_DLW;
            }
            return 2000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.w;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.A = new GestureDetector(new i(this));
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092142);
            this.z = findViewById;
            findViewById.setOnClickListener(new j(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            N1(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            BdUtilHelper.hideSoftKeyPad(this, getCurrentFocus());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            SafeHandler.getInst().postDelayed(new d(this), 500L);
        }
    }

    public final void G1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            E1(intent, true);
        }
    }

    public final void I1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            E1(intent, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            GestureDetector gestureDetector = this.A;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void A1() {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.r.b() != null) {
                wb5.a(wb5.b(this.r.b().getVoiceId()));
            }
            this.r.i(null);
            this.k.setVisibility(8);
            this.l.setVoiceModel(null);
            ej5 p = this.p.p(6);
            if (p != null && (fj5Var = p.m) != null) {
                fj5Var.G(new si5(52, 0, null));
            }
            z1();
        }
    }

    public final void z1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            WriteImagesInfo writeImagesInfo = this.t;
            boolean z3 = false;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            boolean z4 = !TextUtils.isEmpty(this.g.getText());
            wm9 wm9Var = this.r;
            if (wm9Var != null && wm9Var.b() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = (z || z4 || z2) ? true : true;
            TextView textView = this.d;
            if (textView != null) {
                textView.setEnabled(z3);
            }
            if (z3) {
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

    public final void E1(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, intent, z) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            B1();
            this.t.parseJson(stringExtra);
            this.t.updateQuality();
        }
    }

    @Override // com.baidu.tieba.ti5
    public void G(si5 si5Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, si5Var) != null) || si5Var == null) {
            return;
        }
        int i2 = si5Var.a;
        if (i2 != 3) {
            if (i2 != 14) {
                if (i2 != 16) {
                    if (i2 != 24) {
                        if (i2 != 77) {
                            if (i2 != 10) {
                                if (i2 == 11) {
                                    A1();
                                    return;
                                }
                                return;
                            }
                            Object obj = si5Var.c;
                            if (obj instanceof VoiceData.VoiceModel) {
                                x1((VoiceData.VoiceModel) obj);
                                return;
                            }
                            return;
                        }
                        String C1 = C1();
                        PbEditorData.ThreadData threadData = this.v;
                        if (threadData != null) {
                            str = threadData.getForumId();
                        } else {
                            str = "";
                        }
                        xi5.e(C1, str);
                        return;
                    }
                    Object obj2 = si5Var.c;
                    if (obj2 instanceof ed5) {
                        ed5 ed5Var = (ed5) obj2;
                        if (EmotionGroupType.isSendAsPic(ed5Var.getType())) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                            }
                            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                                return;
                            }
                            if (this.t.size() >= this.t.getMaxImagesAllowed()) {
                                showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.t.getMaxImagesAllowed())));
                                return;
                            }
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setImageType(1);
                            imageFileInfo.setFilePath(ed5Var.d());
                            imageFileInfo.width = ed5Var.h();
                            imageFileInfo.height = ed5Var.b();
                            B1();
                            this.t.addChooseFile(imageFileInfo);
                            this.t.updateQuality();
                            this.j.c(this.t.getChosedFiles());
                            this.j.notifyDataSetChanged();
                            z1();
                            return;
                        }
                        this.g.m(ed5Var);
                        return;
                    }
                    return;
                } else if (!y1(getPageContext(), 11025)) {
                    return;
                } else {
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
                    return;
                }
            }
            B1();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.s, this.t.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "pb");
            PbEditorData.ThreadData threadData4 = this.v;
            if (threadData4 != null && !TextUtils.isEmpty(threadData4.getForumId())) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
            }
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            if (sk5.a().b() == 1) {
                albumFloatActivityConfig.setRequestFrom(2);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            return;
        }
        f47.a(this.g);
    }

    public final void H1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, BdUtilHelper.dip2px(this.s, BdUtilHelper.getEquipmentWidth(this.s)), BdUtilHelper.dip2px(this.s, BdUtilHelper.getEquipmentHeight(this.s)));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                B1();
                this.t.addChooseFile(imageFileInfo);
                this.t.updateQuality();
            }
        }
    }

    public void N1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Intent intent = new Intent();
            if (this.u == null) {
                this.u = new PbEditorData();
            }
            this.u.setContent(C1());
            this.u.setSubPbReplyPrefix(this.B);
            this.u.setWriteImagesInfo(this.t);
            this.u.setVoiceModel(this.r.b());
            int i2 = 1;
            this.u.setShowCustomFigure(SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_ying_has_show", true));
            intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.u);
            if (z) {
                ao9 ao9Var = this.x;
                if (ao9Var != null && ao9Var.e() != null && this.x.e().d()) {
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

    public final void J1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09098f);
            xm9 xm9Var = new xm9();
            this.q = xm9Var;
            xm9Var.j(z);
            PbEditorData pbEditorData = this.u;
            if (pbEditorData != null && pbEditorData.getThreadData() != null) {
                this.q.i(this.u.getThreadData().isBJH);
            }
            wm9 wm9Var = (wm9) this.q.a(this.s);
            this.r = wm9Var;
            this.p = wm9Var.a();
            this.r.g(this);
            this.q.k(this);
            this.o.addView(this.p, new LinearLayout.LayoutParams(-1, -2));
            this.p.z(TbadkCoreApplication.getInst().getSkinType());
            this.r.d(this);
            this.p.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            this.g.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.n, R.drawable.icon_edit_close_n);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            if (this.a.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            z1();
            ao9 ao9Var = this.x;
            if (ao9Var != null) {
                ao9Var.i();
            }
            EditorTools editorTools = this.p;
            if (editorTools != null) {
                editorTools.z(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PbFullScreenEditorInputView pbFullScreenEditorInputView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onCreate(bundle);
            this.s = getPageContext().getPageActivity();
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0547);
            VoiceManager voiceManager = new VoiceManager();
            this.w = voiceManager;
            voiceManager.onCreate(getPageContext());
            initView();
            initData();
            PbEditorData pbEditorData = this.u;
            if (pbEditorData != null && pbEditorData.getEditorType() == 1 && (pbFullScreenEditorInputView = this.g) != null) {
                pbFullScreenEditorInputView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Cea708Decoder.COMMAND_DLW)});
            }
            ao9 ao9Var = new ao9();
            this.x = ao9Var;
            PbFullScreenEditorInputView pbFullScreenEditorInputView2 = this.g;
            if (pbFullScreenEditorInputView2 != null) {
                ao9Var.m(pbFullScreenEditorInputView2);
            }
            PostWriteCallBackData postWriteCallBackData = this.y;
            if (postWriteCallBackData != null) {
                this.x.k(postWriteCallBackData);
            }
            hz4.a().c(this.C);
            adjustResizeForSoftInput();
        }
    }

    public final void L1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.showBottomLine();
            this.c = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1012));
            this.e = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            this.d = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
            ImageView backImageView = this.a.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && (view2 = this.c) != null && this.d != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
                layoutParams.leftMargin = BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070383);
                backImageView.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams2.width = -2;
                this.c.setLayoutParams(layoutParams2);
                if (this.a.getBackImageView() != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                this.c.setOnClickListener(new k(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.rightMargin = BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f0701b2);
                this.d.setLayoutParams(layoutParams3);
                this.d.setOnClickListener(new a(this));
            }
        }
    }

    public final void initData() {
        boolean z;
        String forumId;
        fj5 fj5Var;
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
                if (pbEditorData.getEditorType() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                J1(z);
                String disableVoiceMessage = this.u.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && (editorTools = this.p) != null) {
                    aj5 o = editorTools.o(6);
                    if (o instanceof View) {
                        ((View) o).setOnClickListener(new b(this, disableVoiceMessage));
                    }
                }
                PbEditorData.ThreadData threadData = this.u.getThreadData();
                this.v = threadData;
                xm9 xm9Var = this.q;
                if (xm9Var != null) {
                    xm9Var.l(threadData);
                }
                wm9 wm9Var = this.r;
                if (wm9Var != null) {
                    wm9Var.h(this.v);
                }
                String content = this.u.getContent();
                if (this.u.getEditorType() == 1) {
                    String subPbReplyPrefix = this.u.getSubPbReplyPrefix();
                    this.B = subPbReplyPrefix;
                    this.g.l(subPbReplyPrefix, content);
                } else {
                    this.g.k(content);
                }
                WriteImagesInfo writeImagesInfo = this.u.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.t = writeImagesInfo;
                    this.j.c(writeImagesInfo.getChosedFiles());
                    this.j.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.u.getVoiceModel();
                if (voiceModel != null && voiceModel.getDuration() > 0 && !TextUtils.isEmpty(voiceModel.getVoiceId()) && this.r != null) {
                    this.k.setVisibility(0);
                    this.l.setVoiceModel(voiceModel);
                    this.r.i(voiceModel);
                    ej5 p = this.p.p(6);
                    if (p != null && (fj5Var = p.m) != null) {
                        fj5Var.G(new si5(52, 0, voiceModel));
                    }
                    EditorTools editorTools2 = this.p;
                    editorTools2.A((View) editorTools2.o(6));
                }
                if (fl5.isOn()) {
                    EditorTools editorTools3 = this.p;
                    PbEditorData.ThreadData threadData2 = this.v;
                    if (threadData2 == null) {
                        forumId = null;
                    } else {
                        forumId = threadData2.getForumId();
                    }
                    editorTools3.D(new si5(76, 8, forumId));
                }
            }
            if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
                this.y = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            }
            z1();
        }
    }

    public final boolean M1(PbFullScreenEditorInputView pbFullScreenEditorInputView, @NonNull ArrayList<AtSelectData> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, pbFullScreenEditorInputView, arrayList)) == null) {
            if (pbFullScreenEditorInputView == null) {
                return false;
            }
            int length = pbFullScreenEditorInputView.length();
            int D1 = D1();
            ArrayList<AtSelectData> arrayList2 = new ArrayList<>();
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                arrayList2 = spanGroupManager.w();
            }
            if (arrayList != null && arrayList2 != null) {
                arrayList.removeAll(arrayList2);
            }
            Iterator<AtSelectData> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                AtSelectData next = it.next();
                if (next != null && next.getNameShow() != null) {
                    i2 += next.getNameShow().length();
                }
            }
            if (D1 - length <= i2 + 1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.nm9.c
    public void W(int i2) {
        ImageFileInfo imageInfoAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && (imageInfoAt = this.t.getImageInfoAt(i2)) != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.t, i2)));
        }
    }

    public final void x1(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, voiceModel) == null) && voiceModel != null && !TextUtils.isEmpty(voiceModel.getVoiceId()) && voiceModel.getDuration() > 0) {
            this.r.i(voiceModel);
            this.k.setVisibility(0);
            this.l.setVoiceModel(voiceModel);
            z1();
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            L1();
            this.b = findViewById(R.id.obfuscated_res_0x7f0929b3);
            EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.obfuscated_res_0x7f092141);
            this.f = editorScrollView;
            editorScrollView.setListener(new e(this));
            K1();
            PbFullScreenEditorInputView pbFullScreenEditorInputView = (PbFullScreenEditorInputView) findViewById(R.id.obfuscated_res_0x7f090977);
            this.g = pbFullScreenEditorInputView;
            pbFullScreenEditorInputView.setOnClickListener(new f(this));
            this.g.addTextChangedListener(new g(this));
            this.h = this.g.getSpanGroupManager();
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914d5);
            this.l = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f0904f1);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914ac);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091222);
            this.m.setOnClickListener(new h(this));
            this.i = (WholeDisplayGridView) findViewById(R.id.obfuscated_res_0x7f090e8b);
            nm9 nm9Var = new nm9(this.s);
            this.j = nm9Var;
            nm9Var.b(this);
            this.j.d(getUniqueId());
            this.i.setAdapter((ListAdapter) this.j);
        }
    }

    @Override // com.baidu.tieba.nm9.c
    public void n1(int i2) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i2) == null) && (writeImagesInfo = this.t) != null && writeImagesInfo.getChosedFiles() != null) {
            if (i2 >= 0 && i2 < this.t.size()) {
                ImageFileInfo remove = this.t.getChosedFiles().remove(i2);
                if (remove.isTempFile()) {
                    vb.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.j.notifyDataSetChanged();
            }
            z1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            wm9 wm9Var = this.r;
            if (wm9Var != null) {
                wm9Var.e(i2, i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 11025) {
                    if (i2 != 12002) {
                        if (i2 != 12004) {
                            if (i2 != 12012) {
                                if (i2 == 25004 && intent != null) {
                                    this.g.j(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                                    return;
                                }
                                return;
                            }
                            B1();
                            I1(intent);
                            this.j.c(this.t.getChosedFiles());
                            this.j.notifyDataSetChanged();
                            z1();
                            return;
                        } else if (intent != null) {
                            ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                            int selectionStart = this.g.getSelectionStart();
                            if (selectionStart > 0) {
                                int i4 = selectionStart - 1;
                                if (this.g.getText().toString().charAt(i4) == '@') {
                                    this.g.getEditableText().delete(i4, selectionStart);
                                }
                            }
                            this.g.e(parcelableArrayListExtra);
                            if (parcelableArrayListExtra != null && !M1(this.g, parcelableArrayListExtra)) {
                                BdUtilHelper.showToast(this.s, (int) R.string.over_limit_tip);
                                return;
                            } else if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                                this.g.getText().delete(this.g.getSelectionStart(), this.g.getSelectionEnd());
                                this.g.b(parcelableArrayListExtra);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (intent == null) {
                        return;
                    } else {
                        B1();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            H1(intent);
                        } else {
                            G1(intent);
                        }
                        this.j.c(this.t.getChosedFiles());
                        this.j.notifyDataSetChanged();
                        z1();
                        return;
                    }
                }
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
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            ao9 ao9Var = this.x;
            if (ao9Var != null) {
                ao9Var.j();
            }
            VoiceManager voiceManager = this.w;
            if (voiceManager != null) {
                voiceManager.removeBlackScreen();
            }
            hz4.a().e(this.C);
            EditorTools editorTools = this.p;
            if (editorTools != null) {
                editorTools.s(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048604, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public final boolean y1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
