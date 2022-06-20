package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ae6;
import com.repackage.c15;
import com.repackage.fc5;
import com.repackage.fx8;
import com.repackage.h05;
import com.repackage.hd5;
import com.repackage.ht4;
import com.repackage.hw8;
import com.repackage.hx4;
import com.repackage.i05;
import com.repackage.jt4;
import com.repackage.jx8;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nq4;
import com.repackage.nt4;
import com.repackage.nw4;
import com.repackage.o05;
import com.repackage.o76;
import com.repackage.oi;
import com.repackage.p76;
import com.repackage.pi;
import com.repackage.qv8;
import com.repackage.ri8;
import com.repackage.sd5;
import com.repackage.sg;
import com.repackage.t05;
import com.repackage.uj8;
import com.repackage.v05;
import com.repackage.xc6;
import com.repackage.xs8;
import com.repackage.y15;
import com.repackage.yc6;
import com.repackage.ym;
import com.repackage.ys8;
import com.repackage.zc6;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements qv8.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final int M0;
    public static final int N0;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TbFaceManager.a A0;
    public Toast B;
    public final AntiHelper.k B0;
    public String C;
    public final NewWriteModel.e C0;
    public EditorTools D;
    public final LocationModel.e D0;
    public WriteImagesInfo E;
    public final CustomMessageListener E0;
    public NewWriteModel F;
    public CustomMessageListener F0;
    public LocationModel G;
    public final View.OnClickListener G0;
    public int H;
    public boolean H0;
    public AdditionData I;
    public final View.OnFocusChangeListener I0;
    public RelativeLayout J;
    public TextWatcher J0;
    public TextView K;
    public TextWatcher K0;
    public TextView L;
    public xs8 L0;
    public TextView M;
    public PostPrefixData N;
    public PostTopicData O;
    public TextView P;
    public qv8 Q;
    public ImageView R;
    public View S;
    public int T;
    public GestureDetector U;
    public int V;
    public List<xc6> W;
    public xc6 X;
    public int Y;
    public String Z;
    public String a;
    public boolean b;
    public WriteData c;
    public BaijiahaoData d;
    public OriginalThreadInfo.ShareInfo e;
    public boolean f;
    public InputMethodManager g;
    public int g0;
    public EditText h;
    public PostCategoryView h0;
    public View i;
    public View i0;
    public LinearLayout j;
    public ScrollView j0;
    public LinearLayout k;
    public boolean k0;
    public LinearLayout l;
    public jt4 l0;
    public SpanGroupEditText m;
    public String m0;
    public OriginalThreadCardView n;
    public String n0;
    public FeedBackModel o;
    public boolean o0;
    public View p;
    public String p0;
    public ArrayList<WritePrefixItemLayout> q;
    public List<HotTopicBussinessData> q0;
    public String r;
    public HotTopicBussinessData r0;
    public String s;
    public TextView s0;
    public final KeyEvent t;
    public hw8 t0;
    public NavigationBar u;
    public boolean u0;
    public View v;
    public final fx8 v0;
    public TextView w;
    public jx8 w0;
    public TextView x;
    public ForumTabSelectedView x0;
    public DialogInterface.OnCancelListener y;
    public FrsTabInfoData y0;
    public final Handler z;
    public boolean z0;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public a(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (view2 == this.a.h || view2 == this.a.v || view2 == this.a.w) {
                    if (z) {
                        this.a.H0 = true;
                        this.a.A2();
                        if (this.a.D != null) {
                            this.a.D.q();
                        }
                        pi.M(this.a.getActivity(), this.a.h);
                    } else if (view2 == this.a.h) {
                        this.a.P.setVisibility(0);
                    }
                }
                if (view2 == this.a.m && z) {
                    this.a.H0 = false;
                    this.a.A2();
                    this.a.D.q();
                    pi.M(this.a.getActivity(), this.a.m);
                }
                this.a.D3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public b(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.showToast(transmitPostEditActivity.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements i05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* loaded from: classes4.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ht4.k().u("key_post_thread_has_request_location", true);
                }
            }
        }

        public c(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.repackage.i05
        public void C(h05 h05Var) {
            Object obj;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) || h05Var == null) {
                return;
            }
            if (h05Var.a == 31) {
                Object obj2 = h05Var.c;
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    int i = intValue == 5 ? 4 : intValue == 9 ? 3 : intValue == 26 ? 1 : intValue == 7 ? 2 : 0;
                    if (i > 0) {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", i));
                    }
                }
            }
            int i2 = h05Var.a;
            if (i2 == 16) {
                if (this.a.g3()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d13);
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageContext().getPageActivity(), 12004, true);
                if (this.a.E2() instanceof SpanGroupEditText) {
                    atListActivityConfig.setSelectedAtList(((SpanGroupEditText) this.a.E2()).getAtDataInText());
                }
                this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            } else if (i2 == 24) {
                if (this.a.g3()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d13);
                    return;
                }
                Object obj3 = h05Var.c;
                if (obj3 == null || !(obj3 instanceof nw4)) {
                    return;
                }
                this.a.c3((nw4) obj3);
            } else if (i2 == 3) {
                this.a.C2();
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                this.a.m3();
            } else if (i2 == 18) {
                boolean h = ht4.k().h("key_post_thread_has_request_location", false);
                if (h05Var.c != null && this.a.I == null) {
                    if (h) {
                        this.a.n3();
                        return;
                    }
                    return;
                }
                int i3 = this.a.H;
                if (i3 != 0) {
                    if (i3 != 2) {
                        return;
                    }
                    this.a.I2();
                    return;
                }
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                if (PermissionUtil.checkLocationForGoogle(pageActivity) && h) {
                    this.a.h3();
                } else {
                    PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                }
            } else if (i2 == 20) {
                if (this.a.G != null) {
                    this.a.G.Q(true);
                }
            } else if (i2 == 29) {
                this.a.D.A(new h05(2, 19, null));
                this.a.D.A(new h05(1, 2, null));
                this.a.c.setVideoInfo(null);
                this.a.m3();
                if (this.a.m != null) {
                    this.a.m.requestFocus();
                }
                this.a.D.q();
                this.a.D.A(new h05(5, -1, null));
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.ShowSoftKeyPad(transmitPostEditActivity.g, this.a.m);
            } else if (i2 == 43) {
                ht4.k().u("hot_topic_has_click", true);
                this.a.D.A(new h05(2, 26, null));
                this.a.b = true;
                this.a.i3(true);
                if (this.a.F2().isFocused()) {
                    this.a.a = "from_title";
                } else if (this.a.E2().isFocused()) {
                    this.a.a = "from_content";
                }
            } else if (i2 == 45) {
                this.a.k.setVisibility(0);
                this.a.k.requestFocus();
            } else if (i2 == 53) {
                if (this.a.k.hasFocus()) {
                    this.a.m.requestFocus();
                    this.a.m.setSelection(this.a.m.getText().toString().length());
                }
                this.a.k.setVisibility(8);
            } else if (i2 == 55 && (obj = h05Var.c) != null && (obj instanceof Boolean)) {
                this.a.o0 = ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ TransmitPostEditActivity c;

        public d(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = transmitPostEditActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.m3();
                this.c.E3();
                EditText F2 = this.c.F2();
                if (editable == null || F2 == null || F2.getText() == null) {
                    return;
                }
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.v0 != null) {
                        this.a = F2.getText().toString();
                        this.c.v0.i(F2, true);
                        return;
                    }
                    return;
                }
                F2.setSelection(F2.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.c.K2(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ TransmitPostEditActivity c;

        public e(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = transmitPostEditActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.m3();
                EditText E2 = this.c.E2();
                if (editable == null || E2 == null || E2.getText() == null) {
                    return;
                }
                int selectionEnd = E2.getSelectionEnd();
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.v0 != null) {
                        this.a = E2.getText().toString();
                        this.c.v0.i(E2, false);
                        return;
                    }
                    return;
                }
                E2.setSelection(selectionEnd);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.c.K2(charSequence, i, i3, "from_content");
                    this.c.J2(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public f(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    if (this.a.m != null) {
                        pi.x(this.a.getPageContext().getContext(), this.a.m);
                    }
                    if (this.a.D != null) {
                        this.a.D.q();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public g(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.requestFocus();
                this.a.D.A(new h05(5, -1, null));
                this.a.m.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public h(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B3();
                this.a.j3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public i(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, ae6 ae6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, ae6Var) == null) || ae6Var == null) {
                return;
            }
            this.a.h0.setText(ae6Var.a);
            this.a.c.setCategoryTo(ae6Var.b);
            this.a.g0 = ae6Var.b;
            this.a.h0.c();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public j(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h0.e();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.g, this.a.F2());
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.g, this.a.E2());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public k(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), ym.class);
                ym ymVar = runTask != null ? (ym) runTask.getData() : null;
                if (ymVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ymVar.p());
                int r = ymVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, ymVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new nt4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public l(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public m(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P.setVisibility(0);
                this.a.S.setSelected(true);
                sg.l(this.a.Q, view2, 0, pi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.D.q();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.g, this.a.h);
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.g, this.a.m);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public n(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P.setSelected(true);
                sg.l(this.a.Q, view2, 0, pi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.D.q();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.g, this.a.F2());
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.g, this.a.E2());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public o(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"StringFormatInvalid"})
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                }
                if (hd5.b() || this.a.e3()) {
                    return;
                }
                if (!this.a.f3()) {
                    if (this.a.v0.b(this.a.h, this.a.m)) {
                        TransmitPostEditActivity transmitPostEditActivity = this.a;
                        transmitPostEditActivity.showToast(transmitPostEditActivity.v0.e());
                        return;
                    }
                    TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                    transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.g, this.a.F2());
                    TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                    transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.g, this.a.E2());
                    this.a.D.q();
                    TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                    if (this.a.z0) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                    }
                    this.a.l3();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getActivity());
                bdTopToast.i(false);
                bdTopToast.h(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f1163), this.a.x0.getSelectedTabItemData().name));
                bdTopToast.j((ViewGroup) this.a.i0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public p(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    this.a.D.A(new h05(5, -1, null));
                    this.a.m.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public q(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                this.a.B3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public r(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* loaded from: classes4.dex */
        public class a implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public b(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public s(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                this.a.closeLoadingDialog();
                if (postWriteCallBackData == null || this.a.c == null) {
                    return;
                }
                this.a.v0.m(null);
                if (z) {
                    this.a.q3(z);
                    this.a.A3(true, postWriteCallBackData);
                    this.a.t3();
                    this.a.u3(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    this.a.showToast(postWriteCallBackData.getErrorString());
                    this.a.v0.n(postWriteCallBackData.getErrorString());
                    this.a.v0.m(postWriteCallBackData.getSensitiveWords());
                    this.a.v0.h(this.a.h, this.a.m);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nq4 nq4Var = new nq4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        nq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ced));
                    } else {
                        nq4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new a(this));
                    nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new b(this));
                    nq4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                } else if ((hx4Var == null || writeData == null || hx4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    this.a.A3(false, postWriteCallBackData);
                } else if (hx4Var != null && writeData != null && hx4Var.c() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(hx4Var.b());
                    writeData.setVcodeUrl(hx4Var.c());
                    writeData.setVcodeExtra(hx4Var.a());
                    if (sd5.b(hx4Var.d())) {
                        this.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, hx4Var.d())));
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public t(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c70);
                this.a.r3(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.r3(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a53);
                }
                transmitPostEditActivity.showToast(str);
                this.a.r3(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(TransmitPostEditActivity transmitPostEditActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.a.G.Q(false);
                    this.a.G.P(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.a.r3(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.a.G.Q(true);
                this.a.r3(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(TransmitPostEditActivity transmitPostEditActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public w(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D.A(new h05(5, -1, null));
                int D2 = this.a.D2();
                if (D2 < 0 || D2 >= this.a.m.getText().length()) {
                    return;
                }
                this.a.m.setSelection(D2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public x(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.r3(0, true, null);
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public y(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                if (ni.z()) {
                    this.a.r3(1, true, null);
                    this.a.G.O();
                } else {
                    this.a.D0.a();
                }
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public z(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                pi.x(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ z(TransmitPostEditActivity transmitPostEditActivity, k kVar) {
            this(transmitPostEditActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;");
                return;
            }
        }
        M0 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        N0 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    }

    public TransmitPostEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = false;
        this.c = null;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.q = new ArrayList<>();
        this.t = new KeyEvent(0, 67);
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new Handler();
        this.A = null;
        this.C = null;
        this.E = new WriteImagesInfo();
        this.H = 0;
        this.i0 = null;
        this.j0 = null;
        this.k0 = false;
        this.l0 = null;
        this.m0 = AlbumActivityConfig.FROM_WRITE;
        this.n0 = "2";
        new SpannableStringBuilder();
        this.u0 = false;
        this.v0 = new fx8();
        this.z0 = false;
        this.A0 = new k(this);
        this.B0 = new r(this);
        this.C0 = new s(this);
        this.D0 = new t(this);
        this.E0 = new u(this, 2001226);
        this.F0 = new v(this, 2016554);
        this.G0 = new w(this);
        this.H0 = true;
        this.I0 = new a(this);
        this.J0 = new d(this);
        this.K0 = new e(this);
    }

    public final void A2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (editorTools = this.D) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.H0);
        this.D.setToolEnabled(true, 26);
    }

    public final void A3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        String errorString = postWriteCallBackData.getErrorString();
        if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
            if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.B0) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString2 = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString2)) {
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1121);
            }
            showToast(errorString2);
        } else if (this.c.getType() != 7) {
            if (this.I == null) {
                if (B2(postWriteCallBackData)) {
                    return;
                }
                uj8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            x3(z2, errorString);
        }
    }

    public final boolean B2(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || oi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NewWriteModel newWriteModel = this.F;
            if (newWriteModel != null) {
                newWriteModel.cancelLoadData();
            }
            FeedBackModel feedBackModel = this.o;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.G;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    public void C2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || E2().getSelectionStart() <= 0) {
            return;
        }
        String substring = E2().getText().toString().substring(0, E2().getSelectionStart());
        Matcher matcher = o76.b.matcher(substring);
        if (matcher.find()) {
            E2().getText().delete(E2().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), E2().getSelectionStart());
            return;
        }
        E2().onKeyDown(67, this.t);
    }

    public final void C3() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (writeData = this.c) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 4) {
                this.x.setText(R.string.obfuscated_res_0x7f0f0f25);
                this.m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                return;
            } else if (type != 9) {
                this.x.setText(R.string.obfuscated_res_0x7f0f1120);
                this.m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.h.setVisibility(8);
                return;
            }
        }
        String str3 = this.n0;
        if (str3 != null && str3.equals("1")) {
            this.x.setText(R.string.obfuscated_res_0x7f0f1180);
        } else {
            String str4 = this.n0;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f117d) + this.c.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02d1);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02d1);
                }
                this.x.setText(str2);
            } else {
                this.x.setText("");
            }
        }
        this.h.setVisibility(0);
        this.m.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    public final int D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int selectionEnd = E2().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) E2().getText().getSpans(0, E2().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = E2().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = E2().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h.hasFocus()) {
                this.h.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.h.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            if (this.m.hasFocus()) {
                this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        }
    }

    public final EditText E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (EditText) invokeV.objValue;
    }

    public final void E3() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (editText = this.h) == null) {
            return;
        }
        if (editText.getText().toString().length() == 0) {
            this.h.getPaint().setFakeBoldText(false);
        } else if (this.h.getText().toString().length() > 0) {
            this.h.getPaint().setFakeBoldText(true);
        }
    }

    public final EditText F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (EditText) invokeV.objValue;
    }

    public final String G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (E2() == null || E2().getText() == null) {
                return "";
            }
            String obj = E2().getText().toString();
            if (StringUtils.isNull(obj)) {
                OriginalThreadInfo.ShareInfo shareInfo = this.e;
                if (shareInfo != null && shareInfo.showType == 3) {
                    return getString(R.string.obfuscated_res_0x7f0f1184);
                }
                return getString(R.string.obfuscated_res_0x7f0f1183);
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    public final String H2() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.c == null || F2() == null || F2().getVisibility() != 0 || F2().getText() == null) {
                return "";
            }
            String obj = F2().getText().toString();
            PostPrefixData postPrefixData = this.N;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.T != 0 && this.c.getType() != 4 && (textView = this.P) != null && textView.getText() != null) {
                obj = this.P.getText().toString() + obj;
            }
            PostPrefixData postPrefixData2 = this.N;
            if (postPrefixData2 != null && !StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                obj = this.N.getImplicitTitle() + this.c.getTitle();
            }
            if (TextUtils.isEmpty(obj)) {
                if (TextUtils.isEmpty(this.c.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f1183);
                }
                if (getString(R.string.obfuscated_res_0x7f0f1183).equals(this.c.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f1183);
                }
                return getString(R.string.obfuscated_res_0x7f0f1184).equals(this.c.getContent()) ? getString(R.string.obfuscated_res_0x7f0f1184) : obj;
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public final void J2(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048590, this, charSequence, i2, i3) == null) && this.u0 && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            if (E2() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) E2()).getAtDataInText());
            }
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void K2(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || !this.u0 || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.b = false;
        this.a = "";
        if ("from_content".equals(str)) {
            this.a = "from_content";
        } else if ("from_title".equals(str)) {
            this.a = "from_title";
        }
        if (fc5.f(String.valueOf(charSequence.charAt(i2)))) {
            i3(false);
        }
    }

    public final void L2() {
        jx8 jx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (jx8Var = this.w0) == null) {
            return;
        }
        jx8Var.b();
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.J = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090122);
            this.K = (TextView) findViewById(R.id.obfuscated_res_0x7f090123);
            this.L = (TextView) findViewById(R.id.obfuscated_res_0x7f090127);
            this.M = (TextView) findViewById(R.id.obfuscated_res_0x7f090126);
            if (this.I != null) {
                this.J.setVisibility(0);
                TextView textView = this.K;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cb) + StringHelper.getFormatTime(this.I.getCreateTime() * 1000));
                if (this.I.getAlreadyCount() == 0) {
                    this.L.setVisibility(8);
                } else {
                    TextView textView2 = this.L;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cd) + StringHelper.getFormatTime(this.I.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.I.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.M.setText(lastAdditionContent);
                } else {
                    this.M.setVisibility(8);
                }
                E2().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cc), Integer.valueOf(this.I.getAlreadyCount()), Integer.valueOf(this.I.getTotalCount())));
                this.x.setText(R.string.obfuscated_res_0x7f0f15cf);
                return;
            }
            this.J.setVisibility(8);
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.W = null;
            this.Y = -1;
            this.g0 = -1;
            zc6 b2 = yc6.a().b(1);
            if (b2 == null) {
                return;
            }
            this.W = b2.b;
            this.Y = getIntent().getIntExtra("category_id", -1);
            List<xc6> list = this.W;
            if (list == null || list.isEmpty() || this.Y < 0) {
                return;
            }
            xc6 xc6Var = new xc6();
            this.X = xc6Var;
            xc6Var.b = 0;
            xc6Var.a = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0380);
            xc6 xc6Var2 = this.X;
            this.g0 = xc6Var2.b;
            this.Z = xc6Var2.a;
            for (xc6 xc6Var3 : this.W) {
                int i2 = xc6Var3.b;
                if (i2 == this.Y) {
                    this.g0 = i2;
                    this.Z = xc6Var3.a;
                    return;
                }
            }
        }
    }

    public final void O2() {
        List<xc6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (list = this.W) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091850);
        linearLayout.setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090ef8).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090584);
        this.h0 = postCategoryView;
        postCategoryView.setText(this.Z);
        this.h0.setCategoryContainerData(this.W, this.X, this.g0);
        this.h0.setCategoryContainerClickCallback(new i(this));
        linearLayout.setOnClickListener(new j(this));
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.D.d(new v05(getActivity(), 2));
            if (this.I == null) {
                if (this.t0 == null) {
                    hw8 hw8Var = new hw8(getActivity(), this.n0);
                    this.t0 = hw8Var;
                    hw8Var.i();
                    this.t0.m("from_share_write");
                    this.t0.j(this.c.getForumId(), this.V);
                }
                this.D.d(this.t0);
            }
            this.D.h(arrayList);
            t05 n2 = this.D.n(5);
            if (n2 != null) {
                n2.l = 1;
            }
        }
    }

    public final void Q2(Bundle bundle) {
        String stringExtra;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.F = newWriteModel;
            newWriteModel.c0(this.C0);
            this.y = new q(this);
            WriteData writeData = new WriteData();
            this.c = writeData;
            if (bundle != null) {
                writeData.setType(bundle.getInt("type", 0));
                this.c.setForumId(bundle.getString("forum_id"));
                this.c.setForumName(bundle.getString("forum_name"));
                this.c.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
                this.c.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
                this.c.setThreadId(bundle.getString("thread_id"));
                stringExtra = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
                String string = bundle.getString("addition_data");
                if (!StringUtils.isNull(string)) {
                    this.I = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
                }
                this.c.setIsAddition(this.I != null);
                String string2 = bundle.getString("prefix_data");
                if (!StringUtils.isNull(string2)) {
                    this.N = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
                }
                String string3 = bundle.getString("hot_topic");
                if (!StringUtils.isNull(string3)) {
                    this.O = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
                }
                this.m0 = bundle.getString("from");
                this.V = bundle.getInt("private_thread");
                this.c.setTitle(bundle.getString("write_title"));
                this.c.setContent(bundle.getString("write_content"));
                this.q0 = (List) bundle.getSerializable("hot_topic_forum_list");
                this.n0 = bundle.getString("KEY_CALL_FROM");
                String string4 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                if (!StringUtils.isNull(string4)) {
                    this.e = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string4, OriginalThreadInfo.ShareInfo.class);
                }
                this.d = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.r = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.s = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.y0 = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.p0 = bundle.getString("topic_id");
            } else {
                Intent intent = getIntent();
                this.c.setType(intent.getIntExtra("type", 0));
                this.c.setForumId(intent.getStringExtra("forum_id"));
                this.c.setForumName(intent.getStringExtra("forum_name"));
                this.c.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.c.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.c.setThreadId(intent.getStringExtra("thread_id"));
                AdditionData additionData = (AdditionData) intent.getSerializableExtra("addition_data");
                this.I = additionData;
                this.c.setIsAddition(additionData != null);
                this.N = (PostPrefixData) intent.getSerializableExtra("prefix_data");
                this.O = (PostTopicData) intent.getSerializableExtra("hot_topic");
                this.m0 = intent.getStringExtra("from");
                this.V = intent.getIntExtra("private_thread", 0);
                this.c.setTitle(intent.getStringExtra("write_title"));
                this.c.setContent(intent.getStringExtra("write_content"));
                this.q0 = (List) intent.getSerializableExtra("hot_topic_forum_list");
                this.n0 = intent.getStringExtra("KEY_CALL_FROM");
                stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
                this.d = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.e = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                this.r = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.s = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.y0 = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.z0 = intent.getBooleanExtra("from_share", false);
                this.p0 = intent.getStringExtra("topic_id");
            }
            if (this.E == null) {
                this.E = new WriteImagesInfo();
            }
            if (stringExtra != null) {
                this.E.parseJson(stringExtra);
                this.E.updateQuality();
            }
            this.E.setMaxImagesAllowed(this.c.getType() == 4 ? 6 : 9);
            this.c.setWriteImagesInfo(this.E);
            PostPrefixData postPrefixData = this.N;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.N.getPrefixs().add(0, getPageContext().getString(R.string.obfuscated_res_0x7f0f15d7));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.e;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.c.setVideoId(str);
                this.c.setOriginalVideoCover(this.e.showPicUrl);
                this.c.setOriginalVideoTitle(this.e.showText);
            }
            if (!oi.isEmpty(this.r)) {
                if (!oi.isEmpty(this.s)) {
                    WriteData writeData2 = this.c;
                    writeData2.setContent("//@" + this.s + " :" + this.r);
                } else {
                    this.c.setContent(this.r);
                }
            }
            WriteData writeData3 = this.c;
            if (writeData3 != null && writeData3.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.c.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
                this.f = true;
            }
            N2();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            EditorTools editorTools = new EditorTools(getActivity());
            this.D = editorTools;
            editorTools.setBarMaxLauCount(4);
            this.D.setMoreButtonAtEnd(true);
            this.D.setBarLauncherType(1);
            this.D.C(true);
            this.D.D(true);
            this.D.setBackgroundColorId(R.color.CAM_X0207);
            P2();
            this.D.f();
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.addView(this.D);
            }
            S2();
            this.D.j();
            o05 m2 = this.D.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.C)) {
                ((View) m2).setOnClickListener(new b(this));
            }
            if (!this.k0) {
                this.D.A(new h05(34, 5, 1));
            }
            this.D.q();
            if (!ht4.k().h("hot_topic_has_click", false)) {
                this.D.A(new h05(2, 26, " "));
            }
            if (this.c.getType() == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.E.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", this.c.getForumId());
                albumActivityConfig.getIntent().putExtra("from", this.m0);
                albumActivityConfig.setCanEditImage(false);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
            y3();
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c cVar = new c(this);
            this.D.setActionListener(31, cVar);
            this.D.setActionListener(16, cVar);
            this.D.setActionListener(14, cVar);
            this.D.setActionListener(24, cVar);
            this.D.setActionListener(3, cVar);
            this.D.setActionListener(10, cVar);
            this.D.setActionListener(11, cVar);
            this.D.setActionListener(12, cVar);
            this.D.setActionListener(13, cVar);
            this.D.setActionListener(15, cVar);
            this.D.setActionListener(18, cVar);
            this.D.setActionListener(20, cVar);
            this.D.setActionListener(25, cVar);
            this.D.setActionListener(27, cVar);
            this.D.setActionListener(29, cVar);
            this.D.setActionListener(43, cVar);
            this.D.setActionListener(45, cVar);
            this.D.setActionListener(53, cVar);
            this.D.setActionListener(48, cVar);
            this.D.setActionListener(46, cVar);
            this.D.setActionListener(49, cVar);
            this.D.setActionListener(47, cVar);
            this.D.setActionListener(55, cVar);
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bb1);
            this.x0 = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.x0.setData(this.y0);
            this.x0.setActivity(this);
        }
    }

    @Override // com.repackage.qv8.a
    public void U0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.T = i2;
            this.Q.c(i2);
            p3(i2);
            this.P.setText(this.N.getPrefixs().get(i2));
            m3();
            sg.d(this.Q, getPageContext().getPageActivity());
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f092465);
            this.n = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= M0;
            int i2 = N0;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
            this.n.g(this.e);
            this.n.setEnabled(false);
        }
    }

    public final void V2() {
        WriteData writeData;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (writeData = this.c) == null || writeData.getType() != 0 || this.c.getType() != 9 || this.f || (postTopicData = this.O) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
            return;
        }
        String cutStringWithSuffix = StringHelper.cutStringWithSuffix(this.O.getTitleTopic(), 31, null);
        if (StringUtils.isNull(cutStringWithSuffix) || F2() == null) {
            return;
        }
        F2().setText(cutStringWithSuffix);
        F2().setSelection(cutStringWithSuffix.length());
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.S = findViewById(R.id.obfuscated_res_0x7f0918b1);
            this.P = (TextView) findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.p = findViewById(R.id.obfuscated_res_0x7f0918cf);
            this.R = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d0);
            PostPrefixData postPrefixData = this.N;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.S.setVisibility(0);
                ArrayList<String> prefixs = this.N.getPrefixs();
                int size = prefixs.size();
                this.T = 1;
                this.S.setOnClickListener(new m(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d0);
                this.R = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.P.setOnClickListener(new n(this));
                }
                qv8 qv8Var = new qv8(getPageContext().getPageActivity());
                this.Q = qv8Var;
                qv8Var.e(this);
                this.Q.d(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d9));
                this.Q.setOutsideTouchable(true);
                this.Q.setFocusable(true);
                this.Q.setOnDismissListener(this);
                this.Q.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                int color2 = SkinManager.getColor(R.color.CAM_X0108);
                SkinManager.setBackgroundResource(this.P, R.color.CAM_X0201);
                SkinManager.setImageResource(this.R, R.drawable.icon_frs_arrow_n);
                this.P.setTextColor(color);
                this.q.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.q.add(writePrefixItemLayout);
                    writePrefixItemLayout.setPrefixText(prefixs.get(i2));
                    if (i2 == 0) {
                        writePrefixItemLayout.setPrefixTextColor(color2);
                    } else {
                        writePrefixItemLayout.setPrefixTextColor(color);
                    }
                    if (i2 != size - 1) {
                        writePrefixItemLayout.setDividerStyle(false);
                    }
                    this.Q.a(writePrefixItemLayout);
                }
                this.Q.c(0);
                this.P.setText(prefixs.get(1));
                p3(1);
                return;
            }
            this.S.setVisibility(8);
        }
    }

    public void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!ListUtils.isEmpty(this.q0)) {
                this.k.setVisibility(0);
                this.k.requestFocus();
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public final void Y2() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.q0, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.h.setText(fc5.i(fc5.a(hotTopicBussinessData.mTopicName)));
        this.h.setMovementMethod(ys8.a());
    }

    public final void Z2() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.l0 = new jt4(getPageContext());
            this.k0 = this.c.getType() == 4 || 5 == this.c.getType();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08c0, (ViewGroup) null);
            this.i0 = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09238f);
            this.u = navigationBar;
            navigationBar.showBottomLine();
            this.v = this.u.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.u.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u.getBackImageView(), R.drawable.obfuscated_res_0x7f0809c8, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView centerTextTitle = this.u.setCenterTextTitle("");
            this.x = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            w3();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092466);
            this.j0 = scrollView;
            scrollView.setOnTouchListener(new f(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.A = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091611);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092082);
            this.j = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092049);
            this.i = findViewById(R.id.obfuscated_res_0x7f090ef7);
            this.s0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090d9c);
            b3();
            if (this.k0) {
                this.j0.setVisibility(8);
                this.E.setMaxImagesAllowed(6);
            }
            a3();
            U2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918a6);
            this.l = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.l.setOnClickListener(new g(this));
            this.v.setOnFocusChangeListener(this.I0);
            this.v.setOnClickListener(new h(this));
            O2();
            d3();
            C3();
            A2();
            M2();
            W2();
            Y2();
            T2();
            if (this.c.getType() == 4 && (view2 = this.S) != null && this.p != null) {
                view2.setVisibility(8);
                this.p.setVisibility(8);
            }
            m3();
            ShowSoftKeyPad(this.g, this.h);
        }
    }

    public void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0918a4);
            this.m = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.m.setOnClickListener(this.G0);
            NewWriteModel newWriteModel = this.F;
            if (newWriteModel != null) {
                newWriteModel.setSpanGroupManager(this.m.getSpanGroupManager());
            }
            WriteData writeData = this.c;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.m.getSpanGroupManager());
            }
            if (this.c.getContent() != null && this.c.getContent().length() > 0) {
                this.m.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.c.getContent()));
                SpanGroupEditText spanGroupEditText2 = this.m;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
            if (!oi.isEmpty(this.r)) {
                this.m.setSelection(0);
            }
            this.m.setOnFocusChangeListener(this.I0);
            this.m.setOnTouchListener(new p(this));
            this.m.addTextChangedListener(this.K0);
            OriginalThreadInfo.ShareInfo shareInfo = this.e;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.m.setHint(R.string.obfuscated_res_0x7f0f1184);
            } else {
                this.m.setHint(R.string.obfuscated_res_0x7f0f1183);
            }
        }
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0918c1);
            this.h = editText;
            editText.setOnClickListener(this.G0);
            this.h.setOnFocusChangeListener(this.I0);
            if ((this.c.getType() == 0 || this.c.getType() == 9 || this.c.getType() == 7) && this.c.getTitle() != null) {
                this.h.setText(this.c.getTitle());
                this.h.setSelection(this.c.getTitle().length());
            }
            this.h.addTextChangedListener(this.J0);
            if (!this.c.getHaveDraft()) {
                V2();
            }
            this.h.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0ecf));
        }
    }

    public void c3(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, nw4Var) == null) {
            if (((ImageSpan[]) E2().getText().getSpans(0, E2().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.B == null) {
                    this.B = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f144a, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.B.getView().isShown()) {
                    this.B.cancel();
                }
                this.B.show();
                return;
            }
            p76.b(this, nw4Var, E2());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.l0.h(false);
        }
    }

    public void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.w.setOnClickListener(new o(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            if (this.U.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (((ImageSpan[]) E2().getText().getSpans(0, E2().getText().length(), ImageSpan.class)).length > 10) {
                if (this.B == null) {
                    this.B = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f144a, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.B.getView().isShown()) {
                    this.B.cancel();
                }
                this.B.show();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f3() {
        InterceptResult invokeV;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ForumTabSelectedView forumTabSelectedView = this.x0;
            return forumTabSelectedView != null && (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) != null && selectedTabItemData.tabType == 102 && selectedTabItemData.isGeneralTab == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return E2().getText() != null && E2().getText().length() >= (this.I != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            WriteData writeData = this.c;
            if (writeData != null) {
                if (writeData.getType() == 4) {
                    return "a015";
                }
                if (this.c.getType() == 5) {
                    return "a016";
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (!this.G.H(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a58);
                r3(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                z3();
            } else if (this.G.G()) {
                I2();
            } else {
                this.G.Q(false);
                r3(1, true, null);
                this.G.L();
            }
        }
    }

    public final void i3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) || fc5.c(getPageContext(), z2, false)) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.c;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(ng.g(writeData.getForumId(), 0L), this.c.getFirstDir(), this.c.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            WriteData writeData = this.c;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(F2().getText().toString());
            this.c.setContent(E2().getText().toString());
            finish();
        }
    }

    public final void k3() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            B3();
            this.c.setContent(G2());
            this.c.setTitle(H2());
            int i2 = this.Y;
            if (i2 >= 0) {
                this.c.setCategoryFrom(i2);
            }
            int i3 = this.g0;
            if (i3 >= 0) {
                this.c.setCategoryTo(i3);
            }
            this.c.setWriteImagesInfo(this.E);
            WriteData writeData = this.c;
            LocationModel locationModel = this.G;
            writeData.setHasLocationData(locationModel != null && locationModel.C());
            this.F.a0(this.E.size() > 0);
            if (!ListUtils.isEmpty(this.q0) && (hotTopicBussinessData = this.r0) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.c.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.c.setForumName(this.r0.mForumName);
            }
            y2();
            this.F.setWriteData(this.c);
            WriteData writeData2 = this.c;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.c;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.c.setVcode(null);
            this.F.T().setVoice(null);
            this.F.T().setVoiceDuringTime(-1);
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c37);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1125), this.y);
            this.F.f0();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if ("1".equals(this.n0)) {
                this.c.setCanNoForum(true);
                this.c.setTransmitForumData("[]");
            } else if ("2".equals(this.n0)) {
                this.c.setCanNoForum(false);
            }
            o3();
            this.c.setPrivacy(this.o0);
            this.c.setIsShareThread(true);
            OriginalThreadInfo.ShareInfo shareInfo = this.e;
            if (shareInfo != null && !StringUtils.isNull(shareInfo.threadId)) {
                this.c.setOriginalThreadId(this.e.threadId);
            }
            this.c.setBaijiahaoData(this.d);
            OriginalThreadInfo.ShareInfo shareInfo2 = this.e;
            if (shareInfo2 != null) {
                this.c.setOriBaijiahaoData(shareInfo2.oriUgcInfo);
            }
            this.c.setCallFrom(this.n0);
            k3();
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.c == null) {
            return;
        }
        String obj = F2() != null ? F2().getText().toString() : "";
        String trim = E2() != null ? E2().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.c.getType() == 0 || this.c.getType() == 9 || this.c.getType() == 7) {
            PostPrefixData postPrefixData = this.N;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.N.getPrefixs();
                if (this.T == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.c.setIsNoTitle(true);
                    } else {
                        this.c.setIsNoTitle(false);
                        v3(true);
                        return;
                    }
                } else {
                    this.c.setIsNoTitle(false);
                    v3(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.c.setIsNoTitle(true);
            } else {
                this.c.setIsNoTitle(false);
                v3(true);
                return;
            }
        }
        if (this.E.getChosedFiles() != null && this.E.size() > 0) {
            if (!this.k0) {
                v3(true);
                return;
            } else if (this.E.size() >= 1) {
                v3(true);
            }
        }
        if (!TextUtils.isEmpty(trim)) {
            v3(true);
        } else if (this.c.getVideoInfo() != null) {
            v3(true);
        } else {
            v3(false);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.G.C()) {
                if (this.G.G()) {
                    r3(2, true, ri8.a().b().getFormatted_address());
                    return;
                }
                r3(1, true, null);
                this.G.L();
                return;
            }
            r3(0, true, null);
        }
    }

    public final void o3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (editorTools = this.D) == null) {
            return;
        }
        editorTools.A(new h05(54, 15, null));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048626, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0) {
                    EditorTools editorTools = this.D;
                    if (editorTools != null && !editorTools.u()) {
                        this.m.requestFocus();
                        this.g.toggleSoftInput(0, 2);
                    }
                    if (i2 == 12002) {
                        if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                            return;
                        }
                        this.E.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    } else if (i2 != 12006) {
                        if (i2 != 25004) {
                            return;
                        }
                        if ("from_title".equals(this.a)) {
                            F2().requestFocus();
                            return;
                        } else if ("from_content".equals(this.a)) {
                            E2().requestFocus();
                            return;
                        } else {
                            return;
                        }
                    } else if (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) == null || !postWriteCallBackData.isSensitiveError()) {
                        return;
                    } else {
                        showToast(postWriteCallBackData.getErrorString());
                        this.v0.n(postWriteCallBackData.getErrorString());
                        this.v0.m(postWriteCallBackData.getSensitiveWords());
                        this.v0.h(this.h, this.m);
                        return;
                    }
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            if (i2 == 12004) {
                EditorTools editorTools2 = this.D;
                if (editorTools2 != null && !editorTools2.u()) {
                    E2().requestFocus();
                    this.g.toggleSoftInput(0, 2);
                }
                ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                int selectionStart = E2().getSelectionStart();
                if (selectionStart > 0) {
                    int i4 = selectionStart - 1;
                    if (E2().getText().toString().charAt(i4) == '@') {
                        E2().getEditableText().delete(i4, selectionStart);
                    }
                }
                if (E2() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) E2()).e(parcelableArrayListExtra);
                }
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                    return;
                }
                E2().getText().delete(E2().getSelectionStart(), E2().getSelectionEnd());
                if (E2() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) E2()).b(parcelableArrayListExtra);
                }
            } else if (i2 == 12006) {
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                u3(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i2 != 25004) {
                if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.q0) || ListUtils.isEmpty(this.q0) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.q0.size()) {
                    return;
                }
                HotTopicBussinessData hotTopicBussinessData = this.q0.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                this.r0 = hotTopicBussinessData;
                z2(hotTopicBussinessData);
            } else if (intent == null) {
            } else {
                String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                if (StringUtils.isNull(stringExtra)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (this.b) {
                    sb.append("#");
                    this.b = false;
                }
                sb.append(stringExtra);
                x2(sb.toString());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.A);
            this.u.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0302, 1);
            A2();
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(F2(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(E2(), R.color.CAM_X0201);
            m3();
            this.D.w(i2);
            PostCategoryView postCategoryView = this.h0;
            if (postCategoryView != null) {
                postCategoryView.b();
            }
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            D3();
            E3();
            fx8 fx8Var = this.v0;
            if (fx8Var != null) {
                fx8Var.l(F2(), E2());
            }
            OriginalThreadCardView originalThreadCardView = this.n;
            if (originalThreadCardView != null) {
                originalThreadCardView.r();
            }
            ForumTabSelectedView forumTabSelectedView = this.x0;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.m(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.U = new GestureDetector(getPageContext().getPageActivity(), new z(this, null));
            this.g = (InputMethodManager) getSystemService("input_method");
            Q2(bundle);
            Z2();
            LocationModel locationModel = new LocationModel(getPageContext());
            this.G = locationModel;
            locationModel.R(this.D0);
            registerListener(this.E0);
            registerListener(this.F0);
            R2();
            this.m.requestFocus();
            X2();
            s3();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            xs8 xs8Var = new xs8(getPageContext().getPageActivity(), new l(this), new Date().getHours(), new Date().getMinutes(), false);
            this.L0 = xs8Var;
            xs8Var.setTitle(R.string.obfuscated_res_0x7f0f0c55);
            this.L0.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0260), this.L0);
            this.L0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0366), this.L0);
            return this.L0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            L2();
            TiebaPrepareImageService.StopService();
            B3();
            super.onDestroy();
            this.z.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.S.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048632, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                qv8 qv8Var = this.Q;
                if (qv8Var != null && qv8Var.isShowing()) {
                    sg.d(this.Q, getPageContext().getPageActivity());
                    return true;
                } else if (this.D.u()) {
                    this.D.q();
                    return true;
                } else {
                    B3();
                    j3();
                    return true;
                }
            }
            if (i2 == 67 && (text = E2().getText()) != null && (selectionStart = E2().getSelectionStart() - 1) > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                E2().onKeyDown(67, this.t);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            this.u0 = z2;
            hw8 hw8Var = this.t0;
            if (hw8Var != null && !z2) {
                hw8Var.h();
            }
            if (this.w0 == null || z2) {
                return;
            }
            L2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            HidenSoftKeyPad(this.g, F2());
            HidenSoftKeyPad(this.g, E2());
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048635, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048636, this, i2, strArr, iArr) == null) && i2 == 0) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            h3();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = E2().getEditableText().toString();
            if (obj != null) {
                E2().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.A0));
                E2().setSelection(E2().getText().length());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.onResume();
            if (this.k0) {
                this.h.setVisibility(8);
                m3();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            bundle.putInt("type", this.c.getType());
            bundle.putString("forum_id", this.c.getForumId());
            bundle.putString("forum_name", this.c.getForumName());
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.c.getFirstDir());
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.c.getSecondDir());
            bundle.putString("thread_id", this.c.getThreadId());
            bundle.putInt("private_thread", this.V);
            bundle.putString("from", this.m0);
            bundle.putString("KEY_CALL_FROM", this.n0);
            bundle.putSerializable("tab_list", this.y0);
            WriteImagesInfo writeImagesInfo = this.E;
            if (writeImagesInfo != null) {
                bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
            }
            AdditionData additionData = this.I;
            if (additionData != null) {
                bundle.putString("addition_data", OrmObject.jsonStrWithObject(additionData));
            }
            PostPrefixData postPrefixData = this.N;
            if (postPrefixData != null) {
                bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
            }
            PostTopicData postTopicData = this.O;
            if (postTopicData != null) {
                bundle.putString("hot_topic", OrmObject.jsonStrWithObject(postTopicData));
            }
            bundle.putString("from", this.m0);
            bundle.putString("KEY_CALL_FROM", this.n0);
            OriginalThreadInfo.ShareInfo shareInfo = this.e;
            if (shareInfo != null) {
                bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(shareInfo));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    public final void p3(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || i2 >= this.q.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            this.q.get(i3).b(false);
        }
        this.q.get(i2).b(true);
    }

    public final void q3(boolean z2) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z2) == null) || (editorTools = this.D) == null) {
            return;
        }
        editorTools.A(new h05(9, -1, Boolean.valueOf(z2)));
    }

    public final void r3(int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str}) == null) {
            this.H = i2;
            EditorTools editorTools = this.D;
            if (editorTools != null) {
                editorTools.A(new h05(19, 15, new y15(i2, z2, str)));
            }
        }
    }

    public final void s3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || this.k0 || (editorTools = this.D) == null) {
            return;
        }
        editorTools.A(new h05(12, -1, new c15(this.E, true)));
        this.D.A(new h05(12, 11, new c15(this.E, true)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, str, onCancelListener) == null) {
            this.l0.e(null);
            this.l0.i(R.string.obfuscated_res_0x7f0f1125);
            this.l0.h(true);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || StringUtils.isNull(this.p0)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.p0));
    }

    public final void u3(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public final void v3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            SkinManager.setNavbarTitleColor(this.w, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            TextView addTextButton = this.u.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f1145));
            this.w = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.w.setLayoutParams(layoutParams);
            this.w.setOnFocusChangeListener(this.I0);
        }
    }

    public final void x2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.a)) {
            this.a = "";
            E2().requestFocus();
            if (E2().getText() != null && E2().getText().length() + str.length() > 5000) {
                showToast(R.string.obfuscated_res_0x7f0f0d13);
                return;
            } else {
                i2 = E2().getSelectionStart();
                editable = E2().getText();
            }
        } else if ("from_title".equals(this.a)) {
            this.a = "";
            F2().requestFocus();
            if (F2().getText() != null && F2().getText().length() + str.length() > 31) {
                showToast(R.string.obfuscated_res_0x7f0f0d13);
                return;
            } else {
                i2 = F2().getSelectionStart();
                editable = F2().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    public final void x3(boolean z2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048652, this, z2, str) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
            }
            if (z2) {
                AdditionData additionData = this.I;
                if (additionData != null) {
                    i2 = additionData.getTotalCount();
                    i3 = this.I.getAlreadyCount() + 1;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (i2 > i3) {
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15ce), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            pi.O(getPageContext().getPageActivity(), sb.toString());
        }
    }

    public final void y2() {
        ForumTabSelectedView forumTabSelectedView;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || this.c == null || (forumTabSelectedView = this.x0) == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null) {
            return;
        }
        this.c.setTabId(selectedTabItemData.tabId);
        this.c.setTabName(selectedTabItemData.name);
        this.c.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.w0 == null) {
                this.w0 = new jx8(getPageContext());
            }
            this.w0.c(this.D);
        }
    }

    public final void z2(HotTopicBussinessData hotTopicBussinessData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048655, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null) {
            return;
        }
        SpannableString i2 = fc5.i(fc5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.h.setText(i2);
        }
        this.s0.setText(hotTopicBussinessData.mForumName);
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            nq4 nq4Var = new nq4(getPageContext().getPageActivity());
            nq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a51).setPositiveButton(R.string.obfuscated_res_0x7f0f0973, new y(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new x(this)).create(getPageContext());
            nq4Var.show();
        }
    }
}
