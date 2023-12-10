package com.baidu.tieba;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.jy7;
import com.baidu.tieba.p05;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public class iy7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public sq6 C;
    public EditorScrollView D;
    public List<jy7> E;
    public ForumRuleBaseData F;
    public BdTopToast G;
    public boolean H;
    public int I;
    public n05 J;
    public p05 K;
    public boolean L;
    public Runnable M;
    public p05.e N;
    public p05.e O;
    public final TbPageContext<?> a;
    public final String b;
    public final String c;
    public final String d;
    public ay7 e;
    public ForumRulesEditActivity f;
    public View g;
    public View h;
    public View i;
    public RelativeLayout j;
    public RelativeLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EditText u;
    public EditText v;
    public LinearLayout w;
    public LinearLayout x;
    public NavigationBar y;
    public TextView z;

    /* loaded from: classes6.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

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

        /* loaded from: classes6.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public f(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.u(length);
                iy7.R(this.a.s, length, 500);
                this.a.M();
                if (this.a.v.getLineCount() > 6) {
                    this.a.v.setOnTouchListener(new a(this));
                } else {
                    this.a.v.setOnTouchListener(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy7 a;
        public final /* synthetic */ iy7 b;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    g gVar = this.a;
                    gVar.b.O(gVar.a);
                }
            }
        }

        public g(iy7 iy7Var, jy7 jy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var, jy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iy7Var;
            this.a = jy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k().getText().toString().length() != 0 || this.a.l().getText().toString().length() != 0) {
                    this.b.V(new a(this));
                } else {
                    this.b.O(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public a(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
                if (this.a.f != null) {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        public b(iy7 iy7Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public c(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.t(true, null, false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public d(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.F();
            BdUtilHelper.hideSoftKeyPad(this.a.a.getPageActivity(), this.a.u);
            BdUtilHelper.hideSoftKeyPad(this.a.a.getPageActivity(), this.a.v);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

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

        public e(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.X(length);
                iy7.R(this.a.q, length, 50);
                this.a.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements jy7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public h(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // com.baidu.tieba.jy7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.M();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public i(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D.fullScroll(130);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements p05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public j(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // com.baidu.tieba.p05.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7 a;

        public k(iy7 iy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iy7Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.A();
        }
    }

    public iy7(TbPageContext<?> tbPageContext, ay7 ay7Var, View view2, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ay7Var, view2, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new ArrayList();
        this.F = new ForumRuleBaseData();
        this.H = true;
        this.L = false;
        this.M = new c(this);
        this.N = new k(this);
        this.O = new a(this);
        this.a = tbPageContext;
        this.b = str;
        this.c = str2;
        this.d = str4;
        this.I = i2;
        this.f = forumRulesEditActivity;
        this.e = ay7Var;
        G(view2, str3);
    }

    public static void R(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0301);
            } else {
                EMManager.from(textView).setTextColor(R.color.CAM_X0111);
            }
        }
    }

    public final void O(jy7 jy7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, jy7Var) == null) && jy7Var != null) {
            this.x.removeView(jy7Var.m());
            this.E.remove(jy7Var);
            S();
            L();
            N();
            M();
        }
    }

    public final void P(jy7 jy7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jy7Var) == null) && jy7Var != null) {
            jy7Var.o(new g(this, jy7Var));
            jy7Var.p(new h(this));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            K();
            if (z()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    E();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07db), this.a.getString(R.string.obfuscated_res_0x7f0f07cc), 50));
                    return;
                }
                if (this.F.getList() != null) {
                    for (int i2 = 0; i2 < this.F.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                E();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07db), this.a.getString(R.string.obfuscated_res_0x7f0f07cb), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                E();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07db), this.a.getString(R.string.obfuscated_res_0x7f0f07ca), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.F.getPreface().length() > 600) {
                    E();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07db), this.a.getString(R.string.obfuscated_res_0x7f0f07d0), 600));
                    return;
                }
            }
            this.e.f0(this.F, true);
        }
    }

    public final void L() {
        List<jy7> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (list = this.E) != null) {
            if (list.size() >= 20) {
                this.t.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07e2));
                this.k.setEnabled(false);
                this.t.setEnabled(false);
                this.H = false;
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b67, uua.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
                EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.t.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07de), Integer.valueOf(20 - this.E.size())));
            this.k.setEnabled(true);
            this.t.setEnabled(true);
            this.H = true;
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b67, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07).setAlpha(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.A == null || (editText = this.u) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().trim().length() <= 0) {
                return false;
            }
            List<jy7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    jy7 jy7Var = this.E.get(i2);
                    EditText l = jy7Var.l();
                    SpanGroupEditText k2 = jy7Var.k();
                    if (l == null || l.getText().toString().trim().length() <= 0 || k2 == null || k2.getText().toString().trim().length() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.F == null) {
                this.F = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<jy7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    jy7 jy7Var = this.E.get(i2);
                    EditText l = jy7Var.l();
                    SpanGroupEditText k2 = jy7Var.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().H());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.F.setTitle(this.u.getText().toString());
            this.F.setPreface(this.v.getText().toString());
            this.F.setList(arrayList);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle() != null) {
                    i2 = this.F.getTitle().length();
                } else {
                    i2 = 0;
                }
                if (this.F.getList() != null && this.F.getList().size() > 0) {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.F.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i6);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle() != null) {
                                i4 += forumRuleItemData.getTitle().length();
                            }
                            if (forumRuleItemData.getContent() != null) {
                                i5 += forumRuleItemData.getContent().length();
                            }
                        }
                    }
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (this.F.getPreface() != null) {
                    i3 = this.F.getPreface().length();
                } else {
                    i3 = 0;
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 <= 5000) {
                return false;
            }
            E();
            W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07dd), 5000));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07d3), this.c, rd.getDateStringMouth(new Date()));
            this.u.setText(format);
            this.u.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.width = -1;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            R(this.q, 0, 50);
            R(this.s, 0, 500);
            this.D.setListener(new d(this));
            this.u.addTextChangedListener(new e(this));
            this.v.addTextChangedListener(new f(this));
        }
    }

    public final void U() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.C == null && (relativeLayout = this.j) != null) {
            sq6 sq6Var = new sq6(this.a, relativeLayout);
            this.C = sq6Var;
            sq6Var.L(R.drawable.bg_tip_blue_up_left);
            this.C.o(16);
            this.C.x(true);
            this.C.N(true);
            this.C.n(3000);
            this.C.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.C.T(this.a.getString(R.string.obfuscated_res_0x7f0f07d8), "key_forum_rule_first_edit");
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.E.size() > 0 && this.x != null) {
            jy7 jy7Var = this.E.get(0);
            this.x.removeView(jy7Var.m());
            this.E.remove(jy7Var);
            L();
            N();
        }
    }

    public final void N() {
        List<jy7> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (list = this.E) != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.E.size(); i2++) {
                jy7 jy7Var = this.E.get(i2);
                jy7Var.t(i2);
                jy7Var.s(i2);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.E.get(0) != null) {
            if (this.E.size() == 1) {
                this.E.get(0).q(false);
            } else {
                this.E.get(0).q(true);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            D();
            r(R.string.obfuscated_res_0x7f0f07ce, R.string.obfuscated_res_0x7f0f07cd);
            r(R.string.obfuscated_res_0x7f0f07da, R.string.obfuscated_res_0x7f0f07d9);
            r(R.string.obfuscated_res_0x7f0f07d2, R.string.obfuscated_res_0x7f0f07d1);
            r(R.string.obfuscated_res_0x7f0f07c7, R.string.obfuscated_res_0x7f0f07c6);
            t(false, null, false);
        }
    }

    public void E() {
        n05 n05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (n05Var = this.J) != null && n05Var.isShowing()) {
            this.J.dismiss();
        }
    }

    public final void F() {
        sq6 sq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (sq6Var = this.C) != null) {
            sq6Var.h();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.G = null;
            this.F = null;
            this.e = null;
            this.f = null;
            E();
            this.J = null;
            this.K = null;
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.A == null) {
            return;
        }
        if (B()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
    }

    public void T() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.J != null && (forumRulesEditActivity = this.f) != null && !forumRulesEditActivity.isFinishing()) {
            this.J.l();
        }
    }

    public final void G(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, str) == null) {
            this.g = view2;
            this.y = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0919c6);
            this.w = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092098);
            this.D = (EditorScrollView) view2.findViewById(R.id.obfuscated_res_0x7f0921df);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c1c);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c8d);
            this.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c1b);
            this.o = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c1d);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090c8c);
            this.u = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f090aa3);
            this.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09289e);
            this.q = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0926a4);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090c8a);
            this.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091e14);
            this.v = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f091e12);
            this.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091e13);
            this.x = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916cf);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090861);
            this.t = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090860);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090862);
            TextView addTextButton = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getString(R.string.obfuscated_res_0x7f0f05a0), null);
            this.B = addTextButton;
            addTextButton.setId(R.id.negative_feedback_view);
            this.B.setOnClickListener(this);
            this.y.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f07d6));
            EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
            this.z = eMTextView;
            eMTextView.setText(this.a.getString(R.string.video_preview));
            this.z.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.z.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            this.z.setLayoutParams(layoutParams);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.z, this);
            EMTextView eMTextView2 = new EMTextView(this.a.getPageActivity());
            this.A = eMTextView2;
            eMTextView2.setText(this.a.getString(R.string.push_commit));
            this.A.setEnabled(false);
            this.A.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            this.A.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
            this.A.setLayoutParams(layoutParams2);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, this);
            H();
            U();
            t(false, null, false);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.J == null) {
                p05 p05Var = new p05(this.a.getPageActivity());
                this.K = p05Var;
                p05Var.u(this.a.getString(R.string.obfuscated_res_0x7f0f07dc));
                this.J = new n05(this.a, this.K);
                ArrayList arrayList = new ArrayList();
                l05 l05Var = new l05(this.a.getString(R.string.obfuscated_res_0x7f0f1328), this.K);
                l05Var.s(R.color.CAM_X0302);
                l05Var.n(this.N);
                arrayList.add(l05Var);
                l05 l05Var2 = new l05(this.a.getString(R.string.not_save), this.K);
                l05Var2.n(this.O);
                arrayList.add(l05Var2);
                this.K.p(new j(this));
                this.K.m(arrayList);
            }
            T();
        }
    }

    public void Q(ForumRuleBaseData forumRuleBaseData, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, forumRuleBaseData, z) == null) && this.g != null && forumRuleBaseData != null) {
            this.u.setText(forumRuleBaseData.getTitle());
            EditText editText = this.u;
            if (forumRuleBaseData.getTitle() != null) {
                i2 = forumRuleBaseData.getTitle().length();
            } else {
                i2 = 0;
            }
            editText.setSelection(i2);
            this.v.setText(forumRuleBaseData.getPreface());
            EditText editText2 = this.v;
            if (forumRuleBaseData.getPreface() != null) {
                i3 = forumRuleBaseData.getPreface().length();
            } else {
                i3 = 0;
            }
            editText2.setSelection(i3);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                jy7 jy7Var = this.E.get(0);
                this.x.removeView(jy7Var.m());
                this.E.remove(jy7Var);
                for (int i4 = 0; i4 < forumRuleBaseData.getPbDataList().size(); i4++) {
                    t(false, forumRuleBaseData.getPbDataList().get(i4), !z);
                }
                return;
            }
            D();
        }
    }

    public final void V(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            new TBAlertBuilder(this.a.getPageActivity()).setTitle(R.string.obfuscated_res_0x7f0f07e1).setDesc(R.string.obfuscated_res_0x7f0f07e0).setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.del_post, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener))).setAutoClose().setCancelable(false).show();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 == 0 && !this.L) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    hy7.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.v);
                    this.L = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    hy7.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.v);
                    this.L = true;
                }
            } else if (this.L) {
                this.L = false;
                hy7.c(0, 0, this.v);
            }
        }
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            BdTopToast bdTopToast = this.G;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast content = new BdTopToast(this.a.getPageActivity(), 2000).setIcon(false).setContent(str);
                this.G = content;
                content.show((ViewGroup) this.g.findViewById(R.id.obfuscated_res_0x7f0916e4));
            }
        }
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 > 0) {
                this.p.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
                layoutParams.width = -1;
                this.u.setLayoutParams(layoutParams);
                return;
            }
            this.p.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
            layoutParams2.width = -2;
            this.u.setLayoutParams(layoutParams2);
        }
    }

    public final void s(jy7 jy7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, jy7Var) == null) && jy7Var != null) {
            this.x.addView(jy7Var.m());
            this.E.add(jy7Var);
            S();
            if (this.E.indexOf(jy7Var) != -1) {
                jy7Var.t(this.E.indexOf(jy7Var));
                jy7Var.s(this.E.indexOf(jy7Var));
            }
            M();
            L();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (view2 == this.B) {
                J();
            } else if (view2 == this.A) {
                y();
            } else if (view2 == this.z) {
                K();
                this.a.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.a.getPageActivity(), this.b, this.c, this.F, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.d, this.I)));
            } else if (view2 == this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(this.c, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view2 == this.p) {
                C();
            } else if (view2 != this.w && view2 != this.y) {
                if (view2 == this.k) {
                    SafeHandler.getInst().removeCallbacks(this.M);
                    SafeHandler.getInst().postDelayed(this.M, 300L);
                }
            } else {
                BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.u);
                BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.v);
            }
        }
    }

    public final void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) && this.x != null) {
            jy7 jy7Var = new jy7(this.a.getPageActivity());
            P(jy7Var);
            s(jy7Var);
            String string = TbadkApplication.getInst().getResources().getString(i2);
            String string2 = TbadkApplication.getInst().getResources().getString(i3);
            jy7Var.l().setText(string);
            jy7Var.l().setSelection(string.length());
            jy7Var.k().g(string2);
            jy7Var.k().setSelection(jy7Var.k().getText().toString().length());
        }
    }

    public final void t(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) && this.x != null) {
            jy7 jy7Var = new jy7(this.a.getPageActivity());
            P(jy7Var);
            s(jy7Var);
            if (forumRuleItemPbData != null) {
                jy7Var.l().setText(forumRuleItemPbData.title);
                EditText l = jy7Var.l();
                String str = forumRuleItemPbData.title;
                if (str != null) {
                    i2 = str.length();
                } else {
                    i2 = 0;
                }
                l.setSelection(i2);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i3 = 0; i3 < forumRuleItemPbData.mContent.size(); i3++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i3);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText k2 = jy7Var.k();
                                tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                                tbLinkSpanGroup.E(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.C(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.t();
                                k2.getSpanGroupManager().L(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                jy7Var.k().g(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                jy7Var.k().g("\r\n");
                            }
                        }
                    }
                }
                jy7Var.k().setSelection(jy7Var.k().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    jy7Var.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    jy7Var.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    jy7Var.r(true);
                }
            }
            if (z) {
                SafeHandler.getInst().post(new i(this));
            }
        }
    }

    public void x(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i2) == null) && this.g != null) {
            EMManager.from(this.w).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.h).setBackGroundColor(R.color.CAM_X0210);
            EMManager.from(this.i).setBackGroundColor(R.color.CAM_X0210);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0111);
            EMManager.from(this.s).setTextColor(R.color.CAM_X0111);
            EMManager.from(this.p).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X02);
            EMManager.from(this.r).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X02);
            EMManager.from(this.B).setTextSelectorColor(R.color.CAM_X0105);
            EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0302).setTextSize(R.dimen.T_X05);
            EMManager.from(this.A).setTextSize(R.dimen.T_X05);
            this.A.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.t.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.u.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b77, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.H) {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b67, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b67, uua.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            NavigationBar navigationBar = this.y;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            p05 p05Var = this.K;
            if (p05Var != null) {
                p05Var.k();
            }
            if (i2 == 0) {
                WriteVideoUtil.setCursorColor(this.u, R.drawable.edittext_cursor);
                WriteVideoUtil.setCursorColor(this.v, R.drawable.edittext_cursor);
            } else {
                WriteVideoUtil.setCursorColor(this.u, R.drawable.edittext_cursor_2);
                WriteVideoUtil.setCursorColor(this.v, R.drawable.edittext_cursor_2);
            }
            EMManager corner = EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07);
            if (this.H) {
                i3 = R.string.A_X01;
            } else {
                i3 = R.string.A_X09;
            }
            corner.setAlpha(i3).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            EditText editText = this.u;
            if (editText != null && editText.getText().toString().length() > 50) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c3), this.a.getString(R.string.obfuscated_res_0x7f0f07cc)));
                return;
            }
            List<jy7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    jy7 jy7Var = this.E.get(i2);
                    EditText l = jy7Var.l();
                    SpanGroupEditText k2 = jy7Var.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c3), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c9), hy7.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f07e4))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c3), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c9), hy7.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f07c4))));
                        return;
                    }
                }
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c3), this.a.getString(R.string.obfuscated_res_0x7f0f07d0)));
                return;
            }
            K();
            this.e.f0(this.F, false);
        }
    }
}
