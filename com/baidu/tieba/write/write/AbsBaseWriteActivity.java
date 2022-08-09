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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.repackage.az4;
import com.repackage.b19;
import com.repackage.c35;
import com.repackage.da6;
import com.repackage.dn8;
import com.repackage.ea6;
import com.repackage.gy4;
import com.repackage.h25;
import com.repackage.hz8;
import com.repackage.i25;
import com.repackage.ie5;
import com.repackage.lw8;
import com.repackage.mw8;
import com.repackage.o25;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.tg;
import com.repackage.uf5;
import com.repackage.ur4;
import com.repackage.uu4;
import com.repackage.w35;
import com.repackage.x09;
import com.repackage.yu4;
import com.repackage.zl8;
import com.repackage.zm;
import com.repackage.zz8;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public abstract class AbsBaseWriteActivity<T> extends BaseActivity<T> implements hz8.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationModel A;
    public FeedBackModel B;
    public View C;
    public NavigationBar D;
    public View E;
    public TextView F;
    public TextView G;
    public EditText H;
    public LinearLayout I;
    public ConstraintLayout J;
    public LinearLayout K;
    public SpanGroupEditText L;
    public View M;
    public ArrayList<WritePrefixItemLayout> N;
    public RelativeLayout O;
    public Toast P;
    public RelativeLayout Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public hz8 V;
    public ImageView W;
    public View X;
    public PostCategoryView Y;
    public ScrollView Z;
    public final x09 a;
    public uu4 a0;
    public final KeyEvent b;
    public TextView b0;
    public final Handler c;
    public ForumTabSelectedView c0;
    public PostPrefixData d;
    public GestureDetector d0;
    public String e;
    public EditorTools e0;
    public String f;
    public InputMethodManager f0;
    public String g;
    public zz8 g0;
    public String h;
    public b19 h0;
    public int i;
    public TextWatcher i0;
    public int j;
    public TextWatcher j0;
    public int k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public TbFaceManager.a q0;
    public WriteData r;
    public final AntiHelper.k r0;
    public AdditionData s;
    public final NewWriteModel.e s0;
    public PostTopicData t;
    public final LocationModel.e t0;
    public WriteImagesInfo u;
    public final CustomMessageListener u0;
    public List<HotTopicBussinessData> v;
    public final CustomMessageListener v0;
    public HotTopicBussinessData w;
    public final View.OnClickListener w0;
    public FrsTabInfoData x;
    public final View.OnFocusChangeListener x0;
    public String y;
    public final i25 y0;
    public String z;
    public lw8 z0;

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
                if (view2 == absBaseWriteActivity.H || view2 == absBaseWriteActivity.E || view2 == absBaseWriteActivity.F) {
                    if (z) {
                        AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                        absBaseWriteActivity2.m = true;
                        absBaseWriteActivity2.N1();
                        EditorTools editorTools = this.a.e0;
                        if (editorTools != null) {
                            editorTools.q();
                        }
                        qi.M(this.a.getActivity(), this.a.H);
                    } else {
                        AbsBaseWriteActivity absBaseWriteActivity3 = this.a;
                        if (view2 == absBaseWriteActivity3.H) {
                            absBaseWriteActivity3.U.setVisibility(0);
                        }
                    }
                }
                AbsBaseWriteActivity absBaseWriteActivity4 = this.a;
                if (view2 == absBaseWriteActivity4.L && z) {
                    absBaseWriteActivity4.m = false;
                    absBaseWriteActivity4.N1();
                    EditorTools editorTools2 = this.a.e0;
                    if (editorTools2 != null) {
                        editorTools2.q();
                    }
                    qi.M(this.a.getActivity(), this.a.L);
                }
                this.a.X2(view2, z);
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
    public class c implements i25 {
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
                    ru4.k().u("key_post_thread_has_request_location", true);
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

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) || h25Var == null) {
                return;
            }
            this.a.u2(h25Var);
            int i = h25Var.a;
            if (i == 16) {
                if (!this.a.t2()) {
                    this.a.Q2();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d19);
                }
            } else if (i == 3) {
                this.a.Q1();
            } else if (i == 18) {
                boolean h = ru4.k().h("key_post_thread_has_request_location", false);
                if (h25Var.c != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.s == null) {
                        absBaseWriteActivity.z2(h);
                        return;
                    }
                }
                AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                int i2 = absBaseWriteActivity2.k;
                if (i2 != 0) {
                    if (i2 != 2) {
                        return;
                    }
                    absBaseWriteActivity2.Y1();
                    return;
                }
                Activity pageActivity = absBaseWriteActivity2.getPageContext().getPageActivity();
                if (PermissionUtil.checkLocationForTieba(pageActivity) && h) {
                    this.a.w2();
                } else {
                    PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                }
            } else if (i == 20) {
                LocationModel locationModel = this.a.A;
                if (locationModel != null) {
                    locationModel.P(true);
                }
            } else if (i != 29) {
                if (i == 55) {
                    Object obj = h25Var.c;
                    if (obj instanceof Boolean) {
                        this.a.n = ((Boolean) obj).booleanValue();
                    }
                }
            } else {
                this.a.e0.A(new h25(2, 19, null));
                this.a.e0.A(new h25(1, 2, null));
                this.a.C2();
                SpanGroupEditText spanGroupEditText = this.a.L;
                if (spanGroupEditText != null) {
                    spanGroupEditText.requestFocus();
                }
                this.a.e0.q();
                this.a.e0.A(new h25(5, -1, null));
                AbsBaseWriteActivity absBaseWriteActivity3 = this.a;
                absBaseWriteActivity3.ShowSoftKeyPad(absBaseWriteActivity3.f0, absBaseWriteActivity3.L);
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
                    if (absBaseWriteActivity.L != null) {
                        qi.x(absBaseWriteActivity.getPageContext().getContext(), this.a.L);
                    }
                    EditorTools editorTools = this.a.e0;
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
                this.a.e0.A(new h25(5, -1, null));
                this.a.L.requestFocus();
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPadDelay(absBaseWriteActivity.L);
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
                this.a.x2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TimePickerDialog.OnTimeSetListener {
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

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.H2(0, true, null);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (oi.z()) {
                    this.a.H2(1, true, null);
                    this.a.A.N();
                } else {
                    this.a.t0.a();
                }
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ AbsBaseWriteActivity c;

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
            this.c = absBaseWriteActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.C2();
                EditText W1 = this.c.W1();
                if (editable == null || W1 == null || W1.getText() == null) {
                    return;
                }
                int selectionEnd = W1.getSelectionEnd();
                String str = this.a;
                if (str != null && str.equals(editable.toString())) {
                    W1.setSelection(selectionEnd);
                    return;
                }
                if (this.c.a != null) {
                    this.a = W1.getText().toString();
                    this.c.a.i(W1, false);
                }
                this.c.E1(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
                this.c.H1(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.c.a2(charSequence, i, i3, "from_content");
                    this.c.Z1(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

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
            this.a = absBaseWriteActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.C2();
                this.a.G1(editable);
                this.a.W2();
                EditText X1 = this.a.X1();
                if (editable == null || X1 == null || X1.getText() == null) {
                    return;
                }
                String str = this.a.y;
                if (str != null && str.equals(editable.toString())) {
                    X1.setSelection(X1.getSelectionEnd());
                    return;
                }
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (absBaseWriteActivity.a != null) {
                    absBaseWriteActivity.y = X1.getText().toString();
                    this.a.a.i(X1, true);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.z = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a.z;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                    this.a.a2(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbFaceManager.a {
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

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage<T> runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), zm.class);
                zm zmVar = runTask != null ? (zm) runTask.getData() : null;
                if (zmVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(zmVar.p());
                int r = zmVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, zmVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new yu4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public b(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                this.a.K1();
                this.a.closeLoadingDialog();
                if (postWriteCallBackData != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.r == null) {
                        return;
                    }
                    absBaseWriteActivity.a.m(null);
                    if (z) {
                        this.a.J2(postWriteCallBackData);
                        this.a.y2(postWriteCallBackData, writeData);
                    } else if (postWriteCallBackData.isSensitiveError()) {
                        this.a.showToast(postWriteCallBackData.getErrorString());
                        this.a.a.n(postWriteCallBackData.getErrorString());
                        this.a.a.m(postWriteCallBackData.getSensitiveWords());
                        AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                        absBaseWriteActivity2.a.h(absBaseWriteActivity2.H, absBaseWriteActivity2.L);
                    } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        }
                    } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        ur4 ur4Var = new ur4(this.a.getActivity());
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf3));
                        } else {
                            ur4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new a(this));
                        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new b(this));
                        ur4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                    } else if ((az4Var == null || writeData == null || az4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && this.a.S1(postWriteCallBackData)) {
                        this.a.T2(false, postWriteCallBackData);
                    } else if (az4Var != null && writeData != null && az4Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(az4Var.b());
                        writeData.setVcodeUrl(az4Var.c());
                        writeData.setVcodeExtra(az4Var.a());
                        if (uf5.b(az4Var.d())) {
                            NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, az4Var.d());
                            this.a.J1(newVcodeActivityConfig);
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
    public class o implements LocationModel.e {
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

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c75);
                this.a.H2(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.H2(2, true, locationData.getFormatted_address());
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
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a50);
                }
                absBaseWriteActivity.showToast(str);
                this.a.H2(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(AbsBaseWriteActivity absBaseWriteActivity, int i) {
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
                    this.a.A.P(false);
                    this.a.A.O(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.a.H2(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.a.A.P(true);
                this.a.H2(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(AbsBaseWriteActivity absBaseWriteActivity, int i) {
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
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public r(AbsBaseWriteActivity absBaseWriteActivity) {
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
                this.a.e0.A(new h25(5, -1, null));
                int R1 = this.a.R1();
                if (R1 < 0 || R1 >= this.a.L.getText().length()) {
                    return;
                }
                this.a.L.setSelection(R1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public s(AbsBaseWriteActivity absBaseWriteActivity) {
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
                qi.x(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ s(AbsBaseWriteActivity absBaseWriteActivity, j jVar) {
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
        this.a = new x09();
        this.b = new KeyEvent(0, 67);
        this.c = new Handler();
        this.e = null;
        this.f = AlbumActivityConfig.FROM_WRITE;
        this.g = "";
        this.k = 0;
        this.l = "2";
        this.m = true;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.u = new WriteImagesInfo();
        this.y = "";
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.N = new ArrayList<>();
        this.O = null;
        this.Z = null;
        this.a0 = null;
        this.f0 = null;
        this.i0 = new j(this);
        this.j0 = new k(this);
        this.q0 = new l(this);
        this.r0 = new m(this);
        this.s0 = new n(this);
        this.t0 = new o(this);
        this.u0 = new p(this, 2001226);
        this.v0 = new q(this, 2016554);
        this.w0 = new r(this);
        this.x0 = new a(this);
        this.y0 = new c(this);
    }

    public void A2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            WriteData writeData = this.r;
            if (writeData != null) {
                hotSelectActivityConfig.setForumExtra(og.g(writeData.getForumId(), 0L), this.r.getFirstDir(), this.r.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.g)) {
            this.g = "";
            W1().requestFocus();
            if (W1().getText() != null && W1().getText().length() + str.length() > 5000) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d19);
                return;
            } else {
                i2 = W1().getSelectionStart();
                editable = W1().getText();
            }
        } else if ("from_title".equals(this.g)) {
            this.g = "";
            X1().requestFocus();
            if (X1().getText() != null && X1().getText().length() + str.length() > 31) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d19);
                return;
            } else {
                i2 = X1().getSelectionStart();
                editable = X1().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    public abstract void C2();

    public void D1() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (writeData = this.r) == null || this.c0 == null) {
            return;
        }
        FrsTabInfoData frsTabInfoData = this.x;
        writeData.setIsForumBusinessAccount(frsTabInfoData != null && frsTabInfoData.isForumBusinessAccount);
        FrsTabItemData selectedTabItemData = this.c0.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        this.r.setTabId(selectedTabItemData.tabId);
        this.r.setTabName(selectedTabItemData.name);
        this.r.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.A.C()) {
                if (this.A.G()) {
                    H2(2, true, zl8.a().b().getFormatted_address());
                    return;
                }
                H2(1, true, null);
                this.A.L();
                return;
            }
            H2(0, true, null);
        }
    }

    public void E1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editable) == null) {
        }
    }

    public void E2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.A(new h25(54, 15, null));
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void F2(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 >= this.N.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.N.size(); i3++) {
            this.N.get(i3).b(false);
        }
        this.N.get(i2).b(true);
    }

    public void G1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editable) == null) {
        }
    }

    public void G2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.A(new h25(9, -1, Boolean.TRUE));
    }

    public void H1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public void H2(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.k = i2;
            EditorTools editorTools = this.e0;
            if (editorTools != null) {
                editorTools.A(new h25(19, 15, new w35(i2, z, str)));
            }
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            EditorTools editorTools = this.e0;
            if (editorTools != null) {
                editorTools.A(new h25(12, -1, new c35(this.u, true)));
                this.e0.A(new h25(12, 11, new c35(this.u, true)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J1(@NonNull NewVcodeActivityConfig newVcodeActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, newVcodeActivityConfig) == null) {
        }
    }

    public void J2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void K2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, postWriteCallBackData) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    public void L1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
        }
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public boolean M1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, writeData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void N1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (editorTools = this.e0) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.m);
        this.e0.setToolEnabled(true, 26);
    }

    public boolean N2() {
        InterceptResult invokeV;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            WriteData writeData = this.r;
            return (writeData == null || writeData.getType() != 0 || this.r.getType() != 9 || this.p || (postTopicData = this.t) == null || StringUtils.isNull(postTopicData.getTitleTopic())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean O1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || pi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.e0.setBarMaxLauCount(V1());
            this.e0.setMoreButtonAtEnd(true);
            this.e0.setBarLauncherType(1);
            this.e0.C(true);
            this.e0.D(R2());
            this.e0.setBackgroundColorId(U1());
        }
    }

    public void P2(boolean z, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048605, this, z, str) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
            }
            if (z) {
                AdditionData additionData = this.s;
                if (additionData != null) {
                    i2 = additionData.getTotalCount();
                    i3 = this.s.getAlreadyCount() + 1;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (i2 > i3) {
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15c6), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            qi.O(getPageContext().getPageActivity(), sb.toString());
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || W1().getSelectionStart() <= 0) {
            return;
        }
        String substring = W1().getText().toString().substring(0, W1().getSelectionStart());
        Matcher matcher = da6.b.matcher(substring);
        if (matcher.find()) {
            W1().getText().delete(W1().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), W1().getSelectionStart());
            return;
        }
        W1().onKeyDown(67, this.b);
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            T1(atListActivityConfig);
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            int selectionEnd = W1().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) W1().getText().getSpans(0, W1().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = W1().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = W1().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract boolean R2();

    public boolean S1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, postWriteCallBackData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a4e).setPositiveButton(R.string.obfuscated_res_0x7f0f0980, new i(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new h(this)).create(getPageContext());
            ur4Var.show();
        }
    }

    @Override // com.repackage.hz8.a
    public void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.i = i2;
            this.V.c(i2);
            F2(i2);
            this.U.setText(this.d.getPrefixs().get(i2));
            C2();
            tg.d(this.V, getPageContext().getPageActivity());
        }
    }

    public void T1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, atListActivityConfig) == null) {
        }
    }

    public void T2(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048614, this, z, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        String errorString = postWriteCallBackData.getErrorString();
        if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
            if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.r0) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            if (postWriteCallBackData.getErrorCode() == 230278) {
                return;
            }
            String errorString2 = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString2)) {
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1043);
            }
            showToast(errorString2);
        } else if (this.s == null) {
            if (O1(postWriteCallBackData)) {
                return;
            }
            dn8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            P2(z, errorString);
        }
    }

    public abstract int U1();

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public abstract int V1();

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.H.hasFocus()) {
                this.H.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.H.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            if (this.L.hasFocus()) {
                this.L.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.L.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
        }
    }

    public abstract EditText W1();

    public final void W2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (editText = this.H) == null || editText.getText() == null || this.H.getText().toString() == null || this.H.getPaint() == null) {
            return;
        }
        if (this.H.getText().toString().length() == 0) {
            this.H.getPaint().setFakeBoldText(true);
        } else if (this.H.getText().toString().length() > 0) {
            this.H.getPaint().setFakeBoldText(true);
        }
    }

    public abstract EditText X1();

    public void X2(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, view2, z) == null) {
        }
    }

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    public void Z1(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048624, this, charSequence, i2, i3) == null) && this.q && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            Q2();
        }
    }

    public void a2(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && O2() && this.q && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0) {
            this.o = false;
            this.g = "";
            if ("from_content".equals(str)) {
                this.g = "from_content";
            } else if ("from_title".equals(str)) {
                this.g = "from_title";
            }
            if (ie5.f(String.valueOf(charSequence.charAt(i2)))) {
                A2(false);
            }
        }
    }

    public void b2() {
        b19 b19Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (b19Var = this.h0) == null) {
            return;
        }
        b19Var.b();
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.Q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090129);
            this.R = (TextView) findViewById(R.id.obfuscated_res_0x7f09012a);
            this.S = (TextView) findViewById(R.id.obfuscated_res_0x7f09012e);
            this.T = (TextView) findViewById(R.id.obfuscated_res_0x7f09012d);
            if (this.s != null) {
                this.Q.setVisibility(0);
                TextView textView = this.R;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15c3) + StringHelper.getFormatTime(this.s.getCreateTime() * 1000));
                if (this.s.getAlreadyCount() == 0) {
                    this.S.setVisibility(8);
                } else {
                    TextView textView2 = this.S;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f15c5) + StringHelper.getFormatTime(this.s.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.s.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.T.setText(lastAdditionContent);
                } else {
                    this.T.setVisibility(8);
                }
                W1().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f15c4), Integer.valueOf(this.s.getAlreadyCount()), Integer.valueOf(this.s.getTotalCount())));
                this.G.setText(R.string.obfuscated_res_0x7f0f15c7);
                return;
            }
            this.Q.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (uu4Var = this.a0) == null) {
            return;
        }
        uu4Var.h(false);
    }

    @CallSuper
    public void d2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            WriteData writeData = new WriteData();
            this.r = writeData;
            if (bundle != null) {
                writeData.setType(bundle.getInt("type", 0));
                this.r.setForumId(bundle.getString("forum_id"));
                this.r.setForumName(bundle.getString("forum_name"));
                this.r.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
                this.r.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
                this.r.setThreadId(bundle.getString("thread_id"));
                String string = bundle.getString(BaseWriteConfig.ADDITION_DATA);
                if (!StringUtils.isNull(string)) {
                    this.s = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
                }
                this.r.setIsAddition(this.s != null);
                this.h = bundle.getString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                String string2 = bundle.getString("prefix_data");
                if (!StringUtils.isNull(string2)) {
                    this.d = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
                }
                String string3 = bundle.getString("hot_topic");
                if (!StringUtils.isNull(string3)) {
                    this.t = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
                }
                this.f = bundle.getString("from");
                this.j = bundle.getInt(BaseWriteConfig.PRIVATE_THREAD);
                this.r.setTitle(bundle.getString(BaseWriteConfig.TITLE));
                this.r.setContent(bundle.getString(BaseWriteConfig.CONTENT));
                this.v = (List) bundle.getSerializable(BaseWriteConfig.HOT_TOPIC_POST_FORUM);
                this.l = bundle.getString(BaseWriteConfig.KEY_CALL_FROM);
                this.x = (FrsTabInfoData) bundle.getSerializable("tab_list");
            } else {
                Intent intent = getIntent();
                this.r.setType(intent.getIntExtra("type", 9));
                this.r.setForumId(intent.getStringExtra("forum_id"));
                this.r.setForumName(intent.getStringExtra("forum_name"));
                this.r.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.r.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.r.setThreadId(intent.getStringExtra("thread_id"));
                AdditionData additionData = (AdditionData) intent.getSerializableExtra(BaseWriteConfig.ADDITION_DATA);
                this.s = additionData;
                this.r.setIsAddition(additionData != null);
                this.r.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
                this.r.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
                this.d = (PostPrefixData) intent.getSerializableExtra("prefix_data");
                this.t = (PostTopicData) intent.getSerializableExtra("hot_topic");
                this.f = intent.getStringExtra("from");
                this.j = intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0);
                this.v = (List) intent.getSerializableExtra(BaseWriteConfig.HOT_TOPIC_POST_FORUM);
                this.l = intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM);
                this.h = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                this.x = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
            if (this.u == null) {
                this.u = new WriteImagesInfo();
            }
            String str = this.h;
            if (str != null) {
                this.u.parseJson(str);
                this.u.updateQuality();
            }
            this.u.setMaxImagesAllowed(9);
            this.r.setWriteImagesInfo(this.u);
            WriteData writeData2 = this.r;
            if (writeData2 == null || writeData2.getForumName() == null || TbadkCoreApplication.getInst().getYijianfankuiFname() == null || !this.r.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
                return;
            }
            this.p = true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, motionEvent)) == null) {
            if (this.d0.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.e0 = new EditorTools(getActivity());
            P1();
            this.e0.f();
            LinearLayout linearLayout = this.I;
            if (linearLayout != null) {
                linearLayout.addView(this.e0);
            }
            f2();
            this.e0.j();
            o25 m2 = this.e0.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.e)) {
                ((View) m2).setOnClickListener(new b(this));
            }
            this.e0.A(new h25(34, 5, 1));
            this.e0.q();
            if (ru4.k().h("hot_topic_has_click", false)) {
                return;
            }
            this.e0.A(new h25(2, 26, " "));
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.e0.setActionListener(16, this.y0);
            this.e0.setActionListener(14, this.y0);
            this.e0.setActionListener(24, this.y0);
            this.e0.setActionListener(3, this.y0);
            this.e0.setActionListener(10, this.y0);
            this.e0.setActionListener(11, this.y0);
            this.e0.setActionListener(12, this.y0);
            this.e0.setActionListener(13, this.y0);
            this.e0.setActionListener(15, this.y0);
            this.e0.setActionListener(18, this.y0);
            this.e0.setActionListener(20, this.y0);
            this.e0.setActionListener(25, this.y0);
            this.e0.setActionListener(27, this.y0);
            this.e0.setActionListener(29, this.y0);
            this.e0.setActionListener(43, this.y0);
            this.e0.setActionListener(48, this.y0);
            this.e0.setActionListener(46, this.y0);
            this.e0.setActionListener(49, this.y0);
            this.e0.setActionListener(47, this.y0);
            this.e0.setActionListener(55, this.y0);
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && M2()) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bee);
            this.c0 = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.c0.setData(this.x);
            this.c0.setActivity(this);
            g2();
        }
    }

    @CallSuper
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            registerListener(this.u0);
            registerListener(this.v0);
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && N2()) {
            String cutStringWithSuffix = StringHelper.cutStringWithSuffix(this.t.getTitleTopic(), 31, null);
            if (StringUtils.isNull(cutStringWithSuffix) || X1() == null) {
                return;
            }
            X1().setText(cutStringWithSuffix);
            X1().setSelection(cutStringWithSuffix.length());
        }
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.X = findViewById(R.id.obfuscated_res_0x7f091a08);
            this.U = (TextView) findViewById(R.id.obfuscated_res_0x7f091a07);
            this.M = findViewById(R.id.obfuscated_res_0x7f091a26);
            this.W = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a27);
            l2();
        }
    }

    public void l2() {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (postPrefixData = this.d) == null || postPrefixData.getPrefixs().size() <= 1) {
            return;
        }
        hz8 hz8Var = new hz8(getPageContext().getPageActivity());
        this.V = hz8Var;
        hz8Var.e(this);
        this.V.d(qi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d6));
        this.V.setOutsideTouchable(true);
        this.V.setFocusable(true);
        this.V.setOnDismissListener(this);
        this.V.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
    }

    public abstract void m2();

    public void n2() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.v, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.H.setText(ie5.i(ie5.a(hotTopicBussinessData.mTopicName)));
        this.H.setMovementMethod(mw8.a());
    }

    @CallSuper
    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.a0 = new uu4((TbPageContext<?>) getPageContext());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0916, (ViewGroup) null);
            this.C = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09255b);
            this.D = navigationBar;
            navigationBar.showBottomLine();
            this.E = this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.D.setCenterTextTitle("");
            this.G = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            L2();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092655);
            this.Z = scrollView;
            scrollView.setOnTouchListener(new d(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.O = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09175b);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092226);
            this.I = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.J = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f0921ec);
            this.b0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090dec);
            q2();
            p2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0919fd);
            this.K = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.K.setOnClickListener(new e(this));
            this.E.setOnFocusChangeListener(this.x0);
            this.E.setOnClickListener(new f(this));
            s2();
            U2();
            N1();
            c2();
            k2();
            n2();
            h2();
            C2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().l(i2 == 1);
            getLayoutMode().k(this.O);
            this.D.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0105);
            this.F.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            N1();
            C2();
            this.e0.w(i2);
            PostCategoryView postCategoryView = this.Y;
            if (postCategoryView != null) {
                postCategoryView.a();
            }
            V2();
            W2();
            x09 x09Var = this.a;
            if (x09Var != null) {
                x09Var.l(X1(), W1());
            }
            ForumTabSelectedView forumTabSelectedView = this.c0;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.m(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            L1(bundle);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.d0 = new GestureDetector(getPageContext().getPageActivity(), new s(this, null));
            this.f0 = (InputMethodManager) getSystemService("input_method");
            d2(bundle);
            LocationModel locationModel = new LocationModel(getPageContext());
            this.A = locationModel;
            locationModel.Q(this.t0);
            i2();
            I1();
            o2();
            F1();
            e2();
            m2();
            I2();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i2)) == null) {
            lw8 lw8Var = new lw8(getPageContext().getPageActivity(), new g(this), new Date().getHours(), new Date().getMinutes(), false);
            this.z0 = lw8Var;
            lw8Var.setTitle(R.string.obfuscated_res_0x7f0f0c5a);
            this.z0.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f0265), this.z0);
            this.z0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0370), this.z0);
            return this.z0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            b2();
            TiebaPrepareImageService.StopService();
            super.onDestroy();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.X.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048647, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                return v2();
            }
            if (i2 == 67 && (text = W1().getText()) != null && W1().getSelectionStart() - 1 > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                W1().onKeyDown(67, this.b);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.q = z;
            zz8 zz8Var = this.g0;
            if (zz8Var != null && !z) {
                zz8Var.h();
            }
            if (this.h0 == null || z) {
                return;
            }
            b2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            HidenSoftKeyPad(this.f0, X1());
            HidenSoftKeyPad(this.f0, W1());
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048650, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048651, this, i2, strArr, iArr) == null) && i2 == 0) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            w2();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = W1().getEditableText().toString();
            if (obj != null) {
                W1().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.q0));
                W1().setSelection(W1().getText().length());
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bundle) == null) {
            bundle.putInt("type", this.r.getType());
            bundle.putString("forum_id", this.r.getForumId());
            bundle.putString("forum_name", this.r.getForumName());
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.r.getFirstDir());
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.r.getSecondDir());
            bundle.putString("thread_id", this.r.getThreadId());
            bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.j);
            bundle.putString("from", this.f);
            bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.l);
            bundle.putSerializable("tab_list", this.x);
            WriteImagesInfo writeImagesInfo = this.u;
            if (writeImagesInfo != null) {
                bundle.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, writeImagesInfo.toJsonString());
            }
            AdditionData additionData = this.s;
            if (additionData != null) {
                bundle.putString(BaseWriteConfig.ADDITION_DATA, OrmObject.jsonStrWithObject(additionData));
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null) {
                bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
            }
            PostTopicData postTopicData = this.t;
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

    public abstract void p2();

    public abstract void q2();

    public void r2(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, gy4Var) == null) {
            if (((ImageSpan[]) W1().getText().getSpans(0, W1().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.P == null) {
                    this.P = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1431, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.P.getView().isShown()) {
                    this.P.cancel();
                }
                this.P.show();
                return;
            }
            ea6.b(this, gy4Var, W1());
        }
    }

    public abstract void s2();

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048659, this, str, onCancelListener) == null) || (uu4Var = this.a0) == null) {
            return;
        }
        uu4Var.e(null);
        this.a0.i(R.string.obfuscated_res_0x7f0f1112);
        this.a0.h(true);
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return W1().getText() != null && W1().getText().length() >= (this.s != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    public void u2(@NonNull h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, h25Var) == null) {
        }
    }

    public final boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            hz8 hz8Var = this.V;
            if (hz8Var != null && hz8Var.isShowing()) {
                tg.d(this.V, getPageContext().getPageActivity());
                return true;
            } else if (this.e0.u()) {
                this.e0.q();
                return true;
            } else {
                return B2();
            }
        }
        return invokeV.booleanValue;
    }

    public void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            if (!this.A.H(getPageContext().getPageActivity())) {
                showToast((int) R.string.obfuscated_res_0x7f0f0a55);
                H2(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                S2();
            } else if (this.A.G()) {
                Y1();
            } else {
                this.A.P(false);
                H2(1, true, null);
                this.A.L();
            }
        }
    }

    public void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
        }
    }

    public void y2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048665, this, postWriteCallBackData, writeData) == null) {
            G2();
            if (M1(writeData)) {
                T2(true, postWriteCallBackData);
            }
        }
    }

    public abstract void z2(boolean z);
}
