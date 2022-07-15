package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.au4;
import com.repackage.cr4;
import com.repackage.d25;
import com.repackage.eu4;
import com.repackage.fy4;
import com.repackage.hy8;
import com.repackage.id5;
import com.repackage.j15;
import com.repackage.jx8;
import com.repackage.k15;
import com.repackage.l86;
import com.repackage.lx4;
import com.repackage.ly8;
import com.repackage.m86;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nj8;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.q15;
import com.repackage.rk8;
import com.repackage.rw8;
import com.repackage.sg;
import com.repackage.ud6;
import com.repackage.ut8;
import com.repackage.vd6;
import com.repackage.ve5;
import com.repackage.vt8;
import com.repackage.wd6;
import com.repackage.xe6;
import com.repackage.xt4;
import com.repackage.ym;
import com.repackage.z25;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public abstract class AbsBaseWriteActivity<T> extends BaseActivity<T> implements rw8.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ud6> A;
    public final LocationModel.e A0;
    public List<HotTopicBussinessData> B;
    public final CustomMessageListener B0;
    public HotTopicBussinessData C;
    public final CustomMessageListener C0;
    public FrsTabInfoData D;
    public final View.OnClickListener D0;
    public String E;
    public final View.OnFocusChangeListener E0;
    public String F;
    public final k15 F0;
    public LocationModel G;
    public ut8 G0;
    public FeedBackModel H;
    public View I;
    public NavigationBar J;
    public View K;
    public TextView L;
    public TextView M;
    public EditText N;
    public View O;
    public LinearLayout P;
    public LinearLayout Q;
    public LinearLayout R;
    public SpanGroupEditText S;
    public View T;
    public ArrayList<WritePrefixItemLayout> U;
    public RelativeLayout V;
    public Toast W;
    public RelativeLayout X;
    public TextView Y;
    public TextView Z;
    public final hy8 a;
    public final KeyEvent b;
    public final Handler c;
    public PostPrefixData d;
    public String e;
    public String f;
    public String g;
    public TextView g0;
    public String h;
    public TextView h0;
    public String i;
    public rw8 i0;
    public int j;
    public ImageView j0;
    public int k;
    public View k0;
    public int l;
    public PostCategoryView l0;
    public int m;
    public ScrollView m0;
    public int n;
    public au4 n0;
    public String o;
    public TextView o0;
    public boolean p;
    public ForumTabSelectedView p0;
    public boolean q;
    public GestureDetector q0;
    public boolean r;
    public EditorTools r0;
    public boolean s;
    public InputMethodManager s0;
    public boolean t;
    public jx8 t0;
    public boolean u;
    public ly8 u0;
    public WriteData v;
    public TextWatcher v0;
    public AdditionData w;
    public TextWatcher w0;
    public PostTopicData x;
    public TbFaceManager.a x0;
    public WriteImagesInfo y;
    public final AntiHelper.k y0;
    public ud6 z;
    public final NewWriteModel.e z0;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public a(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (view2 == absBaseWriteActivity.N || view2 == absBaseWriteActivity.K || view2 == absBaseWriteActivity.L) {
                    if (z) {
                        AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                        absBaseWriteActivity2.p = true;
                        absBaseWriteActivity2.M1();
                        EditorTools editorTools = this.a.r0;
                        if (editorTools != null) {
                            editorTools.q();
                        }
                        pi.M(this.a.getActivity(), this.a.N);
                    } else {
                        AbsBaseWriteActivity absBaseWriteActivity3 = this.a;
                        if (view2 == absBaseWriteActivity3.N) {
                            absBaseWriteActivity3.h0.setVisibility(0);
                        }
                    }
                }
                AbsBaseWriteActivity absBaseWriteActivity4 = this.a;
                if (view2 == absBaseWriteActivity4.S && z) {
                    absBaseWriteActivity4.p = false;
                    absBaseWriteActivity4.M1();
                    EditorTools editorTools2 = this.a.r0;
                    if (editorTools2 != null) {
                        editorTools2.q();
                    }
                    pi.M(this.a.getActivity(), this.a.S);
                }
                this.a.X2(view2);
                this.a.V2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public b(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.showToast(absBaseWriteActivity.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

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
                    xt4.k().u("key_post_thread_has_request_location", true);
                }
            }
        }

        public c(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || j15Var == null) {
                return;
            }
            this.a.v2(j15Var);
            int i = j15Var.a;
            if (i == 16) {
                if (!this.a.u2()) {
                    this.a.Q2();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d07);
                }
            } else if (i == 3) {
                this.a.P1();
            } else if (i == 18) {
                boolean h = xt4.k().h("key_post_thread_has_request_location", false);
                if (j15Var.c != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.w == null) {
                        absBaseWriteActivity.A2(h);
                        return;
                    }
                }
                AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                int i2 = absBaseWriteActivity2.n;
                if (i2 != 0) {
                    if (i2 != 2) {
                        return;
                    }
                    absBaseWriteActivity2.X1();
                    return;
                }
                Activity pageActivity = absBaseWriteActivity2.getPageContext().getPageActivity();
                if (PermissionUtil.checkLocationForTieba(pageActivity) && h) {
                    this.a.x2();
                } else {
                    PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                }
            } else if (i == 20) {
                LocationModel locationModel = this.a.G;
                if (locationModel != null) {
                    locationModel.Q(true);
                }
            } else if (i != 29) {
                if (i == 55) {
                    Object obj = j15Var.c;
                    if (obj instanceof Boolean) {
                        this.a.q = ((Boolean) obj).booleanValue();
                    }
                }
            } else {
                this.a.r0.A(new j15(2, 19, null));
                this.a.r0.A(new j15(1, 2, null));
                this.a.D2();
                SpanGroupEditText spanGroupEditText = this.a.S;
                if (spanGroupEditText != null) {
                    spanGroupEditText.requestFocus();
                }
                this.a.r0.q();
                this.a.r0.A(new j15(5, -1, null));
                AbsBaseWriteActivity absBaseWriteActivity3 = this.a;
                absBaseWriteActivity3.ShowSoftKeyPad(absBaseWriteActivity3.s0, absBaseWriteActivity3.S);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public d(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.S != null) {
                        pi.x(absBaseWriteActivity.getPageContext().getContext(), this.a.S);
                    }
                    EditorTools editorTools = this.a.r0;
                    if (editorTools != null) {
                        editorTools.q();
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public e(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.requestFocus();
                this.a.r0.A(new j15(5, -1, null));
                this.a.S.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public f(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public g(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, xe6 xe6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, xe6Var) == null) || xe6Var == null) {
                return;
            }
            this.a.l0.setText(xe6Var.a);
            this.a.v.setCategoryTo(xe6Var.b);
            AbsBaseWriteActivity absBaseWriteActivity = this.a;
            absBaseWriteActivity.k = xe6Var.b;
            absBaseWriteActivity.l0.c();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public h(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l0.e();
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.HidenSoftKeyPad(absBaseWriteActivity.s0, absBaseWriteActivity.W1());
                AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                absBaseWriteActivity2.HidenSoftKeyPad(absBaseWriteActivity2.s0, absBaseWriteActivity2.V1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public i(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public j(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.I2(0, true, null);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ AbsBaseWriteActivity c;

        public k(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absBaseWriteActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.D2();
                EditText V1 = this.c.V1();
                if (editable == null || V1 == null || V1.getText() == null) {
                    return;
                }
                int selectionEnd = V1.getSelectionEnd();
                String str = this.a;
                if (str != null && str.equals(editable.toString())) {
                    V1.setSelection(selectionEnd);
                    return;
                }
                if (this.c.a != null) {
                    this.a = V1.getText().toString();
                    this.c.a.i(V1, false);
                }
                this.c.F1(editable);
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
                    this.c.Z1(charSequence, i, i3, "from_content");
                    this.c.Y1(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public l(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (ni.z()) {
                    this.a.I2(1, true, null);
                    this.a.G.O();
                } else {
                    this.a.A0.a();
                }
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public m(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.D2();
                this.a.W2();
                EditText W1 = this.a.W1();
                if (editable == null || W1 == null || W1.getText() == null) {
                    return;
                }
                String str = this.a.E;
                if (str != null && str.equals(editable.toString())) {
                    W1.setSelection(W1.getSelectionEnd());
                    return;
                }
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (absBaseWriteActivity.a != null) {
                    absBaseWriteActivity.E = W1.getText().toString();
                    this.a.a.i(W1, true);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.F = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a.F;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                    this.a.Z1(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public n(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage<T> runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), ym.class);
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
                return new eu4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public o(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            public b(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public p(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                this.a.J1();
                this.a.closeLoadingDialog();
                if (postWriteCallBackData != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.v == null) {
                        return;
                    }
                    absBaseWriteActivity.a.m(null);
                    if (z) {
                        this.a.K2(postWriteCallBackData);
                        this.a.z2(postWriteCallBackData, writeData);
                    } else if (postWriteCallBackData.isSensitiveError()) {
                        this.a.showToast(postWriteCallBackData.getErrorString());
                        this.a.a.n(postWriteCallBackData.getErrorString());
                        this.a.a.m(postWriteCallBackData.getSensitiveWords());
                        AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                        absBaseWriteActivity2.a.h(absBaseWriteActivity2.N, absBaseWriteActivity2.S);
                    } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        }
                    } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        cr4 cr4Var = new cr4(this.a.getActivity());
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce1));
                        } else {
                            cr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new a(this));
                        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce3, new b(this));
                        cr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                    } else if ((fy4Var == null || writeData == null || fy4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && this.a.R1(postWriteCallBackData)) {
                        this.a.T2(false, postWriteCallBackData);
                    } else if (fy4Var != null && writeData != null && fy4Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(fy4Var.b());
                        writeData.setVcodeUrl(fy4Var.c());
                        writeData.setVcodeExtra(fy4Var.a());
                        if (ve5.b(fy4Var.d())) {
                            NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, fy4Var.d());
                            this.a.I1(newVcodeActivityConfig);
                            this.a.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                            return;
                        }
                        this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    } else if (postWriteCallBackData.getErrorCode() == 227001) {
                        this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public q(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c64);
                this.a.I2(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.I2(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a40);
                }
                absBaseWriteActivity.showToast(str);
                this.a.I2(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(AbsBaseWriteActivity absBaseWriteActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity, Integer.valueOf(i)};
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
            this.a = absBaseWriteActivity;
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
                    this.a.I2(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.a.G.Q(true);
                this.a.I2(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(AbsBaseWriteActivity absBaseWriteActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity, Integer.valueOf(i)};
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
            this.a = absBaseWriteActivity;
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
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public t(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r0.A(new j15(5, -1, null));
                int Q1 = this.a.Q1();
                if (Q1 < 0 || Q1 >= this.a.S.getText().length()) {
                    return;
                }
                this.a.S.setSelection(Q1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public u(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
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

        public /* synthetic */ u(AbsBaseWriteActivity absBaseWriteActivity, k kVar) {
            this(absBaseWriteActivity);
        }
    }

    public AbsBaseWriteActivity() {
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
        this.a = new hy8();
        this.b = new KeyEvent(0, 67);
        this.c = new Handler();
        this.e = null;
        this.f = AlbumActivityConfig.FROM_WRITE;
        this.g = "";
        this.j = -1;
        this.k = -1;
        this.n = 0;
        this.o = "2";
        this.p = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = null;
        this.y = new WriteImagesInfo();
        new SpannableStringBuilder();
        this.E = "";
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.R = null;
        this.S = null;
        this.U = new ArrayList<>();
        this.V = null;
        this.m0 = null;
        this.n0 = null;
        this.s0 = null;
        this.v0 = new k(this);
        this.w0 = new m(this);
        this.x0 = new n(this);
        this.y0 = new o(this);
        this.z0 = new p(this);
        this.A0 = new q(this);
        this.B0 = new r(this, 2001226);
        this.C0 = new s(this, 2016554);
        this.D0 = new t(this);
        this.E0 = new a(this);
        this.F0 = new c(this);
    }

    public abstract void A2(boolean z);

    public void B2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            WriteData writeData = this.v;
            if (writeData != null) {
                hotSelectActivityConfig.setForumExtra(ng.g(writeData.getForumId(), 0L), this.v.getFirstDir(), this.v.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void D1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.g)) {
            this.g = "";
            V1().requestFocus();
            if (V1().getText() != null && V1().getText().length() + str.length() > 5000) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d07);
                return;
            } else {
                i2 = V1().getSelectionStart();
                editable = V1().getText();
            }
        } else if ("from_title".equals(this.g)) {
            this.g = "";
            W1().requestFocus();
            if (W1().getText() != null && W1().getText().length() + str.length() > 31) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d07);
                return;
            } else {
                i2 = W1().getSelectionStart();
                editable = W1().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    public abstract void D2();

    public void E1() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (writeData = this.v) == null || this.p0 == null) {
            return;
        }
        FrsTabInfoData frsTabInfoData = this.D;
        writeData.setIsForumBusinessAccount(frsTabInfoData != null && frsTabInfoData.isForumBusinessAccount);
        FrsTabItemData selectedTabItemData = this.p0.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        this.v.setTabId(selectedTabItemData.tabId);
        this.v.setTabName(selectedTabItemData.name);
        this.v.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    public void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.G.D()) {
                if (this.G.H()) {
                    I2(2, true, nj8.a().b().getFormatted_address());
                    return;
                }
                I2(1, true, null);
                this.G.M();
                return;
            }
            I2(0, true, null);
        }
    }

    public void F1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, editable) == null) {
        }
    }

    public void F2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.A(new j15(54, 15, null));
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void G2(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 >= this.U.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            this.U.get(i3).b(false);
        }
        this.U.get(i2).b(true);
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void H2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.A(new j15(9, -1, Boolean.TRUE));
    }

    public void I1(@NonNull NewVcodeActivityConfig newVcodeActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, newVcodeActivityConfig) == null) {
        }
    }

    public void I2(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.n = i2;
            EditorTools editorTools = this.r0;
            if (editorTools != null) {
                editorTools.A(new j15(19, 15, new z25(i2, z, str)));
            }
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.t) {
                return false;
            }
            EditorTools editorTools = this.r0;
            if (editorTools != null) {
                editorTools.A(new j15(12, -1, new d25(this.y, true)));
                this.r0.A(new j15(12, 11, new d25(this.y, true)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
        }
    }

    public void K2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public boolean L1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, writeData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, postWriteCallBackData) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    public void M1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (editorTools = this.r0) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.p);
        this.r0.setToolEnabled(true, 26);
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public boolean N1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || oi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.r0.setBarMaxLauCount(U1());
            this.r0.setMoreButtonAtEnd(true);
            this.r0.setBarLauncherType(1);
            this.r0.C(true);
            this.r0.D(R2());
            this.r0.setBackgroundColorId(T1());
        }
    }

    public boolean O2() {
        InterceptResult invokeV;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            WriteData writeData = this.v;
            return (writeData == null || writeData.getType() != 0 || this.v.getType() != 9 || this.s || (postTopicData = this.x) == null || StringUtils.isNull(postTopicData.getTitleTopic())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || V1().getSelectionStart() <= 0) {
            return;
        }
        String substring = V1().getText().toString().substring(0, V1().getSelectionStart());
        Matcher matcher = l86.b.matcher(substring);
        if (matcher.find()) {
            V1().getText().delete(V1().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), V1().getSelectionStart());
            return;
        }
        V1().onKeyDown(67, this.b);
    }

    public void P2(boolean z, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048604, this, z, str) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
            }
            if (z) {
                AdditionData additionData = this.w;
                if (additionData != null) {
                    i2 = additionData.getTotalCount();
                    i3 = this.w.getAlreadyCount() + 1;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (i2 > i3) {
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15d0), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            pi.O(getPageContext().getPageActivity(), sb.toString());
        }
    }

    public int Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int selectionEnd = V1().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = V1().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = V1().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            S1(atListActivityConfig);
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean R1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, postWriteCallBackData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean R2();

    public void S1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, atListActivityConfig) == null) {
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a3e).setPositiveButton(R.string.obfuscated_res_0x7f0f097e, new l(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new j(this)).create(getPageContext());
            cr4Var.show();
        }
    }

    public abstract int T1();

    public void T2(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048612, this, z, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        String errorString = postWriteCallBackData.getErrorString();
        if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
            if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.y0) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            if (postWriteCallBackData.getErrorCode() == 230278) {
                return;
            }
            String errorString2 = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString2)) {
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1023);
            }
            showToast(errorString2);
        } else if (this.v.getType() != 7) {
            if (this.w == null) {
                if (N1(postWriteCallBackData)) {
                    return;
                }
                rk8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            P2(z, errorString);
        }
    }

    @Override // com.repackage.rw8.a
    public void U0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.l = i2;
            this.i0.c(i2);
            G2(i2);
            this.h0.setText(this.d.getPrefixs().get(i2));
            D2();
            sg.d(this.i0, getPageContext().getPageActivity());
        }
    }

    public abstract int U1();

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public abstract EditText V1();

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.N.hasFocus()) {
                this.N.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.N.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            if (this.S.hasFocus()) {
                this.S.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.S.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
        }
    }

    public abstract EditText W1();

    public final void W2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (editText = this.N) == null || editText.getText() == null || this.N.getText().toString() == null || this.N.getPaint() == null) {
            return;
        }
        if (this.N.getText().toString().length() == 0) {
            this.N.getPaint().setFakeBoldText(true);
        } else if (this.N.getText().toString().length() > 0) {
            this.N.getPaint().setFakeBoldText(true);
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public void X2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, view2) == null) {
        }
    }

    public void Y1(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048622, this, charSequence, i2, i3) == null) && this.u && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            Q2();
        }
    }

    public void Z1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || !this.u || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.r = false;
        this.g = "";
        if ("from_content".equals(str)) {
            this.g = "from_content";
        } else if ("from_title".equals(str)) {
            this.g = "from_title";
        }
        if (id5.f(String.valueOf(charSequence.charAt(i2)))) {
            B2(false);
        }
    }

    public void a2() {
        ly8 ly8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (ly8Var = this.u0) == null) {
            return;
        }
        ly8Var.b();
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.X = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090123);
            this.Y = (TextView) findViewById(R.id.obfuscated_res_0x7f090124);
            this.Z = (TextView) findViewById(R.id.obfuscated_res_0x7f090128);
            this.g0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090127);
            if (this.w != null) {
                this.X.setVisibility(0);
                TextView textView = this.Y;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cd) + StringHelper.getFormatTime(this.w.getCreateTime() * 1000));
                if (this.w.getAlreadyCount() == 0) {
                    this.Z.setVisibility(8);
                } else {
                    TextView textView2 = this.Z;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15cf) + StringHelper.getFormatTime(this.w.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.w.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.g0.setText(lastAdditionContent);
                } else {
                    this.g0.setVisibility(8);
                }
                V1().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15ce), Integer.valueOf(this.w.getAlreadyCount()), Integer.valueOf(this.w.getTotalCount())));
                this.M.setText(R.string.obfuscated_res_0x7f0f15d1);
                return;
            }
            this.X.setVisibility(8);
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.A = null;
            this.j = -1;
            this.k = -1;
            wd6 b2 = vd6.a().b(1);
            if (b2 == null) {
                return;
            }
            List<ud6> list = b2.b;
            this.A = list;
            if (list == null || list.isEmpty() || this.j < 0) {
                return;
            }
            ud6 ud6Var = new ud6();
            this.z = ud6Var;
            ud6Var.b = 0;
            ud6Var.a = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0384);
            ud6 ud6Var2 = this.z;
            this.k = ud6Var2.b;
            this.h = ud6Var2.a;
            for (ud6 ud6Var3 : this.A) {
                int i2 = ud6Var3.b;
                if (i2 == this.j) {
                    this.k = i2;
                    this.h = ud6Var3.a;
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (au4Var = this.n0) == null) {
            return;
        }
        au4Var.h(false);
    }

    public void d2() {
        List<ud6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (list = this.A) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918f9);
        linearLayout.setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090f09).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090586);
        this.l0 = postCategoryView;
        postCategoryView.setText(this.h);
        this.l0.setCategoryContainerData(this.A, this.z, this.k);
        this.l0.setCategoryContainerClickCallback(new g(this));
        linearLayout.setOnClickListener(new h(this));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, motionEvent)) == null) {
            if (this.q0.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bundle) == null) {
            WriteData writeData = new WriteData();
            this.v = writeData;
            if (bundle != null) {
                writeData.setType(bundle.getInt("type", 0));
                this.v.setForumId(bundle.getString("forum_id"));
                this.v.setForumName(bundle.getString("forum_name"));
                this.v.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
                this.v.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
                this.v.setThreadId(bundle.getString("thread_id"));
                String string = bundle.getString(BaseWriteConfig.ADDITION_DATA);
                if (!StringUtils.isNull(string)) {
                    this.w = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
                }
                this.v.setIsAddition(this.w != null);
                this.i = bundle.getString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                String string2 = bundle.getString("prefix_data");
                if (!StringUtils.isNull(string2)) {
                    this.d = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
                }
                String string3 = bundle.getString("hot_topic");
                if (!StringUtils.isNull(string3)) {
                    this.x = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
                }
                this.f = bundle.getString("from");
                this.m = bundle.getInt(BaseWriteConfig.PRIVATE_THREAD);
                this.v.setTitle(bundle.getString(BaseWriteConfig.TITLE));
                this.v.setContent(bundle.getString(BaseWriteConfig.CONTENT));
                this.B = (List) bundle.getSerializable(BaseWriteConfig.HOT_TOPIC_POST_FORUM);
                this.o = bundle.getString(BaseWriteConfig.KEY_CALL_FROM);
                this.D = (FrsTabInfoData) bundle.getSerializable("tab_list");
            } else {
                Intent intent = getIntent();
                this.v.setType(intent.getIntExtra("type", 9));
                this.v.setForumId(intent.getStringExtra("forum_id"));
                this.v.setForumName(intent.getStringExtra("forum_name"));
                this.v.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.v.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.v.setThreadId(intent.getStringExtra("thread_id"));
                AdditionData additionData = (AdditionData) intent.getSerializableExtra(BaseWriteConfig.ADDITION_DATA);
                this.w = additionData;
                this.v.setIsAddition(additionData != null);
                this.v.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
                this.v.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
                this.d = (PostPrefixData) intent.getSerializableExtra("prefix_data");
                this.x = (PostTopicData) intent.getSerializableExtra("hot_topic");
                this.f = intent.getStringExtra("from");
                this.m = intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0);
                this.B = (List) intent.getSerializableExtra(BaseWriteConfig.HOT_TOPIC_POST_FORUM);
                this.o = intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM);
                this.i = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                this.D = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.j = getIntent().getIntExtra("category_id", -1);
            }
            if (this.y == null) {
                this.y = new WriteImagesInfo();
            }
            String str = this.i;
            if (str != null) {
                this.y.parseJson(str);
                this.y.updateQuality();
            }
            this.y.setMaxImagesAllowed(this.v.getType() == 4 ? 6 : 9);
            this.v.setWriteImagesInfo(this.y);
            WriteData writeData2 = this.v;
            if (writeData2 == null || writeData2.getForumName() == null || TbadkCoreApplication.getInst().getYijianfankuiFname() == null || !this.v.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
                return;
            }
            this.s = true;
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.r0 = new EditorTools(getActivity());
            O1();
            this.r0.f();
            LinearLayout linearLayout = this.P;
            if (linearLayout != null) {
                linearLayout.addView(this.r0);
            }
            g2();
            this.r0.j();
            q15 m2 = this.r0.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.e)) {
                ((View) m2).setOnClickListener(new b(this));
            }
            if (!this.t) {
                this.r0.A(new j15(34, 5, 1));
            }
            this.r0.q();
            if (xt4.k().h("hot_topic_has_click", false)) {
                return;
            }
            this.r0.A(new j15(2, 26, " "));
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.r0.setActionListener(16, this.F0);
            this.r0.setActionListener(14, this.F0);
            this.r0.setActionListener(24, this.F0);
            this.r0.setActionListener(3, this.F0);
            this.r0.setActionListener(10, this.F0);
            this.r0.setActionListener(11, this.F0);
            this.r0.setActionListener(12, this.F0);
            this.r0.setActionListener(13, this.F0);
            this.r0.setActionListener(15, this.F0);
            this.r0.setActionListener(18, this.F0);
            this.r0.setActionListener(20, this.F0);
            this.r0.setActionListener(25, this.F0);
            this.r0.setActionListener(27, this.F0);
            this.r0.setActionListener(29, this.F0);
            this.r0.setActionListener(43, this.F0);
            this.r0.setActionListener(48, this.F0);
            this.r0.setActionListener(46, this.F0);
            this.r0.setActionListener(49, this.F0);
            this.r0.setActionListener(47, this.F0);
            this.r0.setActionListener(55, this.F0);
        }
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && N2()) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bba);
            this.p0 = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.p0.setData(this.D);
            this.p0.setActivity(this);
            h2();
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            registerListener(this.B0);
            registerListener(this.C0);
        }
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && O2()) {
            String cutStringWithSuffix = StringHelper.cutStringWithSuffix(this.x.getTitleTopic(), 31, null);
            if (StringUtils.isNull(cutStringWithSuffix) || W1() == null) {
                return;
            }
            W1().setText(cutStringWithSuffix);
            W1().setSelection(cutStringWithSuffix.length());
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.k0 = findViewById(R.id.obfuscated_res_0x7f09195a);
            this.h0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091959);
            this.T = findViewById(R.id.obfuscated_res_0x7f091978);
            this.j0 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091979);
            m2();
        }
    }

    public void m2() {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (postPrefixData = this.d) == null || postPrefixData.getPrefixs().size() <= 1) {
            return;
        }
        rw8 rw8Var = new rw8(getPageContext().getPageActivity());
        this.i0 = rw8Var;
        rw8Var.e(this);
        this.i0.d(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d8));
        this.i0.setOutsideTouchable(true);
        this.i0.setFocusable(true);
        this.i0.setOnDismissListener(this);
        this.i0.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
    }

    public abstract void n2();

    public void o2() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.B, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.N.setText(id5.i(id5.a(hotTopicBussinessData.mTopicName)));
        this.N.setMovementMethod(vt8.a());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.V);
            this.J.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0105);
            this.L.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            M1();
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0204);
            D2();
            this.r0.w(i2);
            PostCategoryView postCategoryView = this.l0;
            if (postCategoryView != null) {
                postCategoryView.b();
            }
            V2();
            W2();
            hy8 hy8Var = this.a;
            if (hy8Var != null) {
                hy8Var.l(W1(), V1());
            }
            ForumTabSelectedView forumTabSelectedView = this.p0;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.m(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, bundle) == null) {
            K1(bundle);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.q0 = new GestureDetector(getPageContext().getPageActivity(), new u(this, null));
            this.s0 = (InputMethodManager) getSystemService("input_method");
            e2(bundle);
            LocationModel locationModel = new LocationModel(getPageContext());
            this.G = locationModel;
            locationModel.R(this.A0);
            j2();
            H1();
            p2();
            G1();
            f2();
            n2();
            J2();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
            ut8 ut8Var = new ut8(getPageContext().getPageActivity(), new i(this), new Date().getHours(), new Date().getMinutes(), false);
            this.G0 = ut8Var;
            ut8Var.setTitle(R.string.obfuscated_res_0x7f0f0c49);
            this.G0.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0262), this.G0);
            this.G0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), this.G0);
            return this.G0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            a2();
            TiebaPrepareImageService.StopService();
            super.onDestroy();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.k0.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048646, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                return w2();
            }
            if (i2 == 67 && (text = V1().getText()) != null && V1().getSelectionStart() - 1 > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                V1().onKeyDown(67, this.b);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.u = z;
            jx8 jx8Var = this.t0;
            if (jx8Var != null && !z) {
                jx8Var.h();
            }
            if (this.u0 == null || z) {
                return;
            }
            a2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            HidenSoftKeyPad(this.s0, W1());
            HidenSoftKeyPad(this.s0, V1());
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048649, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048650, this, i2, strArr, iArr) == null) && i2 == 0) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            x2();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = V1().getEditableText().toString();
            if (obj != null) {
                V1().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.x0));
                V1().setSelection(V1().getText().length());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            super.onResume();
            if (this.t) {
                this.N.setVisibility(8);
                D2();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bundle) == null) {
            bundle.putInt("type", this.v.getType());
            bundle.putString("forum_id", this.v.getForumId());
            bundle.putString("forum_name", this.v.getForumName());
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.v.getFirstDir());
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.v.getSecondDir());
            bundle.putString("thread_id", this.v.getThreadId());
            bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.m);
            bundle.putString("from", this.f);
            bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.o);
            bundle.putSerializable("tab_list", this.D);
            WriteImagesInfo writeImagesInfo = this.y;
            if (writeImagesInfo != null) {
                bundle.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, writeImagesInfo.toJsonString());
            }
            AdditionData additionData = this.w;
            if (additionData != null) {
                bundle.putString(BaseWriteConfig.ADDITION_DATA, OrmObject.jsonStrWithObject(additionData));
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null) {
                bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
            }
            PostTopicData postTopicData = this.x;
            if (postTopicData != null) {
                bundle.putString("hot_topic", OrmObject.jsonStrWithObject(postTopicData));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    public void p2() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.n0 = new au4((TbPageContext<?>) getPageContext());
            this.t = this.v.getType() == 4 || 5 == this.v.getType();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08e0, (ViewGroup) null);
            this.I = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092437);
            this.J = navigationBar;
            navigationBar.showBottomLine();
            this.K = this.J.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.J.setCenterTextTitle("");
            this.M = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            M2();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092532);
            this.m0 = scrollView;
            scrollView.setOnTouchListener(new d(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.V = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0916ba);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092125);
            this.P = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.Q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0920ee);
            this.O = findViewById(R.id.obfuscated_res_0x7f090f08);
            this.o0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090daa);
            r2();
            q2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09194f);
            this.R = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.R.setOnClickListener(new e(this));
            this.K.setOnFocusChangeListener(this.E0);
            this.K.setOnClickListener(new f(this));
            d2();
            t2();
            U2();
            M1();
            b2();
            l2();
            o2();
            i2();
            if (this.v.getType() == 4 && (view2 = this.k0) != null && this.T != null) {
                view2.setVisibility(8);
                this.T.setVisibility(8);
            }
            D2();
        }
    }

    public abstract void q2();

    public abstract void r2();

    public void s2(lx4 lx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, lx4Var) == null) {
            if (((ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.W == null) {
                    this.W = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1444, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.W.getView().isShown()) {
                    this.W.cancel();
                }
                this.W.show();
                return;
            }
            m86.b(this, lx4Var, V1());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048659, this, str, onCancelListener) == null) || (au4Var = this.n0) == null) {
            return;
        }
        au4Var.e(null);
        this.n0.i(R.string.obfuscated_res_0x7f0f111c);
        this.n0.h(true);
    }

    public abstract void t2();

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return V1().getText() != null && V1().getText().length() >= (this.w != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    public void v2(@NonNull j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, j15Var) == null) {
        }
    }

    public final boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            rw8 rw8Var = this.i0;
            if (rw8Var != null && rw8Var.isShowing()) {
                sg.d(this.i0, getPageContext().getPageActivity());
                return true;
            } else if (this.r0.u()) {
                this.r0.q();
                return true;
            } else {
                return C2();
            }
        }
        return invokeV.booleanValue;
    }

    public void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if (!this.G.I(getPageContext().getPageActivity())) {
                showToast((int) R.string.obfuscated_res_0x7f0f0a45);
                I2(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                S2();
            } else if (this.G.H()) {
                X1();
            } else {
                this.G.Q(false);
                I2(1, true, null);
                this.G.M();
            }
        }
    }

    public void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
        }
    }

    public void z2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, postWriteCallBackData, writeData) == null) {
            H2();
            if (L1(writeData)) {
                T2(true, postWriteCallBackData);
            }
        }
    }
}
