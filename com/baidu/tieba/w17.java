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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.k05;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.x17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public class w17 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public ch6 C;
    public EditorScrollView D;
    public List<x17> E;
    public ForumRuleBaseData F;
    public BdTopToast G;
    public boolean H;
    public int I;
    public i05 J;
    public k05 K;
    public boolean L;
    public Runnable M;
    public k05.e N;
    public k05.e O;
    public final TbPageContext<?> a;
    public final String b;
    public final String c;
    public final String d;
    public o17 e;
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
        public final /* synthetic */ w17 a;

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

        public f(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.t(length);
                w17.R(this.a.s, length, 500);
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
        public final /* synthetic */ x17 a;
        public final /* synthetic */ w17 b;

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

        public g(w17 w17Var, x17 x17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var, x17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w17Var;
            this.a = x17Var;
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
    public class a implements k05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

        public a(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // com.baidu.tieba.k05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
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

        public b(w17 w17Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var, onClickListener};
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
        public final /* synthetic */ w17 a;

        public c(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.s(true, null, false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

        public d(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.E();
            hi.z(this.a.a.getPageActivity(), this.a.u);
            hi.z(this.a.a.getPageActivity(), this.a.v);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

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

        public e(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.X(length);
                w17.R(this.a.q, length, 50);
                this.a.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements x17.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

        public h(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // com.baidu.tieba.x17.e
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
        public final /* synthetic */ w17 a;

        public i(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
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
    public class j implements k05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

        public j(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // com.baidu.tieba.k05.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements k05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w17 a;

        public k(w17 w17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w17Var;
        }

        @Override // com.baidu.tieba.k05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z();
        }
    }

    public w17(TbPageContext<?> tbPageContext, o17 o17Var, View view2, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, o17Var, view2, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
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
        this.e = o17Var;
        F(view2, str3);
    }

    public static void R(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                n15.d(textView).w(R.color.CAM_X0301);
            } else {
                n15.d(textView).w(R.color.CAM_X0111);
            }
        }
    }

    public final void O(x17 x17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, x17Var) == null) && x17Var != null) {
            this.x.removeView(x17Var.m());
            this.E.remove(x17Var);
            S();
            L();
            N();
            M();
        }
    }

    public final void P(x17 x17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, x17Var) == null) && x17Var != null) {
            x17Var.o(new g(this, x17Var));
            x17Var.p(new h(this));
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.A == null || (editText = this.u) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().trim().length() <= 0) {
                return false;
            }
            List<x17> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    x17 x17Var = this.E.get(i2);
                    EditText l = x17Var.l();
                    SpanGroupEditText k2 = x17Var.k();
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

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.F == null) {
                this.F = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<x17> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    x17 x17Var = this.E.get(i2);
                    EditText l = x17Var.l();
                    SpanGroupEditText k2 = x17Var.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().G());
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

    public final boolean y() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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
            D();
            W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f070a), 5000));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0700), this.c, gi.getDateStringMouth(new Date()));
            this.u.setText(format);
            this.u.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.width = -1;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.C == null && (relativeLayout = this.j) != null) {
            ch6 ch6Var = new ch6(this.a, relativeLayout);
            this.C = ch6Var;
            ch6Var.C(R.drawable.bg_tip_blue_up_left);
            this.C.k(16);
            this.C.q(true);
            this.C.E(true);
            this.C.j(3000);
            this.C.H(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.C.K(this.a.getString(R.string.obfuscated_res_0x7f0f0705), "key_forum_rule_first_edit");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.E.size() > 0 && this.x != null) {
            x17 x17Var = this.E.get(0);
            this.x.removeView(x17Var.m());
            this.E.remove(x17Var);
            L();
            N();
        }
    }

    public final void N() {
        List<x17> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (list = this.E) != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.E.size(); i2++) {
                x17 x17Var = this.E.get(i2);
                x17Var.t(i2);
                x17Var.s(i2);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.E.get(0) != null) {
            if (this.E.size() == 1) {
                this.E.get(0).q(false);
            } else {
                this.E.get(0).q(true);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            C();
            q(R.string.obfuscated_res_0x7f0f06fb, R.string.obfuscated_res_0x7f0f06fa);
            q(R.string.obfuscated_res_0x7f0f0707, R.string.obfuscated_res_0x7f0f0706);
            q(R.string.obfuscated_res_0x7f0f06ff, R.string.obfuscated_res_0x7f0f06fe);
            q(R.string.obfuscated_res_0x7f0f06f4, R.string.obfuscated_res_0x7f0f06f3);
            s(false, null, false);
        }
    }

    public void D() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (i05Var = this.J) != null && i05Var.isShowing()) {
            this.J.dismiss();
        }
    }

    public final void E() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ch6Var = this.C) != null) {
            ch6Var.d();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.G = null;
            this.F = null;
            this.e = null;
            this.f = null;
            D();
            this.J = null;
            this.K = null;
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.A == null) {
            return;
        }
        if (A()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
    }

    public void T() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.J != null && (forumRulesEditActivity = this.f) != null && !forumRulesEditActivity.isFinishing()) {
            this.J.k();
        }
    }

    public final void F(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, str) == null) {
            this.g = view2;
            this.y = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0917c0);
            this.w = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e59);
            this.D = (EditorScrollView) view2.findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b52);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bbb);
            this.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b51);
            this.o = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090b53);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090bba);
            this.u = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f0909ed);
            this.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092620);
            this.q = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09241d);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090bb8);
            this.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c01);
            this.v = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f091bff);
            this.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c00);
            this.x = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09154e);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907d5);
            this.t = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0907d4);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907d6);
            TextView addTextButton = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getString(R.string.obfuscated_res_0x7f0f051b), null);
            this.B = addTextButton;
            addTextButton.setId(R.id.negative_feedback_view);
            this.B.setOnClickListener(this);
            this.y.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0703));
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
            G();
            U();
            s(false, null, false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.J == null) {
                k05 k05Var = new k05(this.a.getPageActivity());
                this.K = k05Var;
                k05Var.s(this.a.getString(R.string.obfuscated_res_0x7f0f0709));
                this.J = new i05(this.a, this.K);
                ArrayList arrayList = new ArrayList();
                g05 g05Var = new g05(this.a.getString(R.string.obfuscated_res_0x7f0f1168), this.K);
                g05Var.q(R.color.CAM_X0302);
                g05Var.m(this.N);
                arrayList.add(g05Var);
                g05 g05Var2 = new g05(this.a.getString(R.string.not_save), this.K);
                g05Var2.m(this.O);
                arrayList.add(g05Var2);
                this.K.n(new j(this));
                this.K.k(arrayList);
            }
            T();
        }
    }

    public final void L() {
        List<x17> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (list = this.E) != null) {
            if (list.size() >= 20) {
                this.t.setText(this.a.getString(R.string.obfuscated_res_0x7f0f070f));
                this.k.setEnabled(false);
                this.t.setEnabled(false);
                this.H = false;
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, ga9.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
                n15 d2 = n15.d(this.k);
                d2.l(R.color.CAM_X0902);
                d2.m(R.dimen.L_X02);
                d2.o(R.string.J_X07);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0201);
                return;
            }
            this.t.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f070b), Integer.valueOf(20 - this.E.size())));
            this.k.setEnabled(true);
            this.t.setEnabled(true);
            this.H = true;
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            n15 d3 = n15.d(this.k);
            d3.l(R.color.CAM_X0902);
            d3.m(R.dimen.L_X02);
            d3.o(R.string.J_X07);
            d3.e(R.string.A_X01);
            d3.f(R.color.CAM_X0201);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            J();
            if (y()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    D();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0708), this.a.getString(R.string.obfuscated_res_0x7f0f06f9), 50));
                    return;
                }
                if (this.F.getList() != null) {
                    for (int i2 = 0; i2 < this.F.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                D();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0708), this.a.getString(R.string.obfuscated_res_0x7f0f06f8), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                D();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0708), this.a.getString(R.string.obfuscated_res_0x7f0f06f7), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.F.getPreface().length() > 600) {
                    D();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0708), this.a.getString(R.string.obfuscated_res_0x7f0f06fd), 600));
                    return;
                }
            }
            this.e.a1(this.F, true);
        }
    }

    public void Q(ForumRuleBaseData forumRuleBaseData, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, forumRuleBaseData, z) == null) && this.g != null && forumRuleBaseData != null) {
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
                x17 x17Var = this.E.get(0);
                this.x.removeView(x17Var.m());
                this.E.remove(x17Var);
                for (int i4 = 0; i4 < forumRuleBaseData.getPbDataList().size(); i4++) {
                    s(false, forumRuleBaseData.getPbDataList().get(i4), !z);
                }
                return;
            }
            C();
        }
    }

    public final void V(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageActivity());
            tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f070e);
            tBAlertBuilder.m(R.string.obfuscated_res_0x7f0f070d);
            tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.del_post, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener)));
            tBAlertBuilder.i();
            tBAlertBuilder.j(false);
            tBAlertBuilder.z();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 == 0 && !this.L) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    v17.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.v);
                    this.L = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    v17.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.v);
                    this.L = true;
                }
            } else if (this.L) {
                this.L = false;
                v17.c(0, 0, this.v);
            }
        }
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            BdTopToast bdTopToast = this.G;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getPageActivity(), 2000);
                bdTopToast2.h(false);
                bdTopToast2.g(str);
                this.G = bdTopToast2;
                bdTopToast2.i((ViewGroup) this.g.findViewById(R.id.obfuscated_res_0x7f091564));
            }
        }
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
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

    public final void r(x17 x17Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, x17Var) == null) && x17Var != null) {
            this.x.addView(x17Var.m());
            this.E.add(x17Var);
            S();
            if (this.E.indexOf(x17Var) != -1) {
                x17Var.t(this.E.indexOf(x17Var));
                x17Var.s(this.E.indexOf(x17Var));
            }
            M();
            L();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            if (view2 == this.B) {
                I();
            } else if (view2 == this.A) {
                x();
            } else if (view2 == this.z) {
                J();
                this.a.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.a.getPageActivity(), this.b, this.c, this.F, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.d, this.I)));
            } else if (view2 == this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(this.c, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view2 == this.p) {
                B();
            } else if (view2 != this.w && view2 != this.y) {
                if (view2 == this.k) {
                    jg.a().removeCallbacks(this.M);
                    jg.a().postDelayed(this.M, 300L);
                }
            } else {
                hi.z(this.a.getPageActivity(), this.u);
                hi.z(this.a.getPageActivity(), this.v);
            }
        }
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) && this.x != null) {
            x17 x17Var = new x17(this.a.getPageActivity());
            P(x17Var);
            r(x17Var);
            String string = TbadkApplication.getInst().getResources().getString(i2);
            String string2 = TbadkApplication.getInst().getResources().getString(i3);
            x17Var.l().setText(string);
            x17Var.l().setSelection(string.length());
            x17Var.k().insert(string2);
            x17Var.k().setSelection(x17Var.k().getText().toString().length());
        }
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) && this.x != null) {
            x17 x17Var = new x17(this.a.getPageActivity());
            P(x17Var);
            r(x17Var);
            if (forumRuleItemPbData != null) {
                x17Var.l().setText(forumRuleItemPbData.title);
                EditText l = x17Var.l();
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
                                SpanGroupEditText k2 = x17Var.k();
                                tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                                tbLinkSpanGroup.E(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.C(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.t();
                                k2.getSpanGroupManager().K(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                x17Var.k().insert(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                x17Var.k().insert("\r\n");
                            }
                        }
                    }
                }
                x17Var.k().setSelection(x17Var.k().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    x17Var.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    x17Var.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    x17Var.r(true);
                }
            }
            if (z) {
                jg.a().post(new i(this));
            }
        }
    }

    public void u(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && this.g != null) {
            n15.d(this.w).f(R.color.CAM_X0201);
            n15.d(this.o).w(R.color.CAM_X0105);
            n15.d(this.h).f(R.color.CAM_X0210);
            n15.d(this.i).f(R.color.CAM_X0210);
            n15.d(this.q).w(R.color.CAM_X0111);
            n15.d(this.s).w(R.color.CAM_X0111);
            n15 d2 = n15.d(this.p);
            d2.w(R.color.CAM_X0304);
            d2.B(R.string.F_X02);
            n15 d3 = n15.d(this.r);
            d3.w(R.color.CAM_X0107);
            d3.B(R.string.F_X02);
            n15.d(this.B).y(R.color.CAM_X0105);
            n15 d4 = n15.d(this.z);
            d4.y(R.color.CAM_X0302);
            d4.A(R.dimen.T_X05);
            n15.d(this.A).A(R.dimen.T_X05);
            this.A.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.t.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.u.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bf, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.H) {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, ga9.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            NavigationBar navigationBar = this.y;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            k05 k05Var = this.K;
            if (k05Var != null) {
                k05Var.j();
            }
            if (i2 == 0) {
                ur9.l(this.u, R.drawable.edittext_cursor);
                ur9.l(this.v, R.drawable.edittext_cursor);
            } else {
                ur9.l(this.u, R.drawable.edittext_cursor_2);
                ur9.l(this.v, R.drawable.edittext_cursor_2);
            }
            n15 d5 = n15.d(this.k);
            d5.l(R.color.CAM_X0902);
            d5.m(R.dimen.L_X02);
            d5.o(R.string.J_X07);
            if (this.H) {
                i3 = R.string.A_X01;
            } else {
                i3 = R.string.A_X09;
            }
            d5.e(i3);
            d5.f(R.color.CAM_X0201);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            EditText editText = this.u;
            if (editText != null && editText.getText().toString().length() > 50) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f0), this.a.getString(R.string.obfuscated_res_0x7f0f06f9)));
                return;
            }
            List<x17> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    x17 x17Var = this.E.get(i2);
                    EditText l = x17Var.l();
                    SpanGroupEditText k2 = x17Var.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f0), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f6), v17.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f0711))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f0), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f6), v17.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f06f1))));
                        return;
                    }
                }
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06f0), this.a.getString(R.string.obfuscated_res_0x7f0f06fd)));
                return;
            }
            J();
            this.e.a1(this.F, false);
        }
    }
}
