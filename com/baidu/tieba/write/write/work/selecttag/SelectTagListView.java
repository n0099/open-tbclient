package com.baidu.tieba.write.write.work.selecttag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h09;
import com.repackage.h95;
import com.repackage.oi;
import com.repackage.wr4;
import com.repackage.zi8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectTagListView extends LinearLayout implements h95, View.OnClickListener, AutoChangeLineView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<SelectTagActivity> a;
    public NavigationBar b;
    public TextView c;
    public View d;
    public LinearLayout e;
    public EMTextView f;
    public EMTextView g;
    public EMTextView h;
    public EMTextView i;
    public RelativeLayout j;
    public ScrollView k;
    public AutoChangeLineView l;
    public AutoChangeLineView m;
    public List<String> n;
    public ArrayList<String> o;
    public EditText p;
    public String q;
    public EMTextView r;
    public boolean s;
    public int t;
    public int u;
    public AutoChangeLineView.b<String> v;
    public AutoChangeLineView.b<String> w;

    /* loaded from: classes4.dex */
    public class a implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public a(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void a(TextView textView, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i) == null) {
                if (this.a.n.size() != 0 && this.a.n.contains(obj)) {
                    if (this.a.o.contains(obj)) {
                        this.a.l.setSelects(this.a.o.indexOf(obj));
                    }
                    this.a.n.remove(obj);
                    SelectTagListView selectTagListView = this.a;
                    selectTagListView.m.setLabels(selectTagListView.n, selectTagListView.v);
                    AutoChangeLineView autoChangeLineView = this.a.l;
                    SelectTagListView selectTagListView2 = this.a;
                    autoChangeLineView.setLabels(selectTagListView2.o, selectTagListView2.w);
                    this.a.y();
                    this.a.n();
                    this.a.requestLayout();
                    this.a.setFinishSelectType();
                }
                this.a.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public b(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        public /* bridge */ /* synthetic */ CharSequence a(TextView textView, int i, String str) {
            String str2 = str;
            b(textView, i, str2);
            return str2;
        }

        public CharSequence b(TextView textView, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080918, R.color.CAM_X0304, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    textView.setCompoundDrawables(null, null, pureDrawable, null);
                }
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X008), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 0);
                wr4 d = wr4.d(textView);
                d.v(R.color.CAM_X0304);
                d.z(R.dimen.T_X08);
                d.n(R.string.J_X01);
                d.l(R.dimen.L_X01);
                d.k(R.color.CAM_X0302);
                d.f(R.color.CAM_X0905);
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public c(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        public /* bridge */ /* synthetic */ CharSequence a(TextView textView, int i, String str) {
            String str2 = str;
            b(textView, i, str2);
            return str2;
        }

        public CharSequence b(TextView textView, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i, str)) == null) {
                if (this.a.n.contains(str)) {
                    wr4 d = wr4.d(textView);
                    d.v(R.color.CAM_X0304);
                    d.z(R.dimen.T_X08);
                    d.n(R.string.J_X01);
                    d.l(R.dimen.L_X01);
                    d.k(R.color.CAM_X0302);
                    d.f(R.color.CAM_X0905);
                } else {
                    wr4 d2 = wr4.d(textView);
                    d2.v(R.color.CAM_X0105);
                    d2.z(R.dimen.T_X08);
                    d2.n(R.string.J_X01);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0109);
                    d2.f(R.color.CAM_X0201);
                }
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public d(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n.size() >= this.a.t) {
                    this.a.p.setInputType(0);
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f036a));
                    bdTopToast.j((ViewGroup) this.a.d);
                    return;
                }
                this.a.p.setInputType(1);
                oi.L(this.a.a.getPageActivity(), this.a.p);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public e(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    oi.L(this.a.a.getPageActivity(), textView);
                    if (this.a.q != null && this.a.q.trim().length() > 0) {
                        if (this.a.n.size() < this.a.t) {
                            SelectTagListView selectTagListView = this.a;
                            if (selectTagListView.n.contains(selectTagListView.q)) {
                                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                                bdTopToast.i(false);
                                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0369));
                                bdTopToast.j((ViewGroup) this.a.d);
                            } else {
                                SelectTagListView selectTagListView2 = this.a;
                                if (selectTagListView2.o.contains(selectTagListView2.q)) {
                                    AutoChangeLineView autoChangeLineView = this.a.l;
                                    SelectTagListView selectTagListView3 = this.a;
                                    autoChangeLineView.setUnSelects(selectTagListView3.o.indexOf(selectTagListView3.q));
                                }
                                SelectTagListView selectTagListView4 = this.a;
                                selectTagListView4.x(selectTagListView4.q);
                                SelectTagListView selectTagListView5 = this.a;
                                selectTagListView5.m.setLabels(selectTagListView5.n, selectTagListView5.v);
                                AutoChangeLineView autoChangeLineView2 = this.a.l;
                                SelectTagListView selectTagListView6 = this.a;
                                autoChangeLineView2.setLabels(selectTagListView6.o, selectTagListView6.w);
                                this.a.p.setText("");
                                this.a.r.setVisibility(8);
                                this.a.n();
                                this.a.y();
                            }
                        } else {
                            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                            bdTopToast2.i(false);
                            bdTopToast2.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f036a));
                            bdTopToast2.j((ViewGroup) this.a.d);
                        }
                    }
                    this.a.setFinishSelectType();
                    return true;
                }
                this.a.setFinishSelectType();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public f(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.q = editable.toString();
                if (this.a.q == null || this.a.q.trim().length() <= 0) {
                    this.a.r.setVisibility(8);
                } else {
                    this.a.r.setVisibility(0);
                }
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

    /* loaded from: classes4.dex */
    public class g implements h09.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public g(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // com.repackage.h09.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0367));
                bdTopToast.j((ViewGroup) this.a.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public h(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.q != null && this.a.q.trim().length() > 0) {
                    if (this.a.n.size() < this.a.t) {
                        SelectTagListView selectTagListView = this.a;
                        if (selectTagListView.n.contains(selectTagListView.q)) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(false);
                            bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0369));
                            bdTopToast.j((ViewGroup) this.a.d);
                        } else {
                            SelectTagListView selectTagListView2 = this.a;
                            if (selectTagListView2.o.contains(selectTagListView2.q)) {
                                AutoChangeLineView autoChangeLineView = this.a.l;
                                SelectTagListView selectTagListView3 = this.a;
                                autoChangeLineView.setUnSelects(selectTagListView3.o.indexOf(selectTagListView3.q));
                            }
                            SelectTagListView selectTagListView4 = this.a;
                            selectTagListView4.x(selectTagListView4.q);
                            SelectTagListView selectTagListView5 = this.a;
                            selectTagListView5.m.setLabels(selectTagListView5.n, selectTagListView5.v);
                            AutoChangeLineView autoChangeLineView2 = this.a.l;
                            SelectTagListView selectTagListView6 = this.a;
                            autoChangeLineView2.setLabels(selectTagListView6.o, selectTagListView6.w);
                            this.a.p.setText("");
                            this.a.r.setVisibility(8);
                            this.a.n();
                            this.a.y();
                        }
                    } else {
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f036a));
                        bdTopToast2.j((ViewGroup) this.a.d);
                    }
                    this.a.setFinishSelectType();
                }
                this.a.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public i(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 && ((SelectTagActivity) this.a.a.getOrignalPage()).isKeybordVisible()) {
                    oi.w(this.a.a.getPageActivity(), this.a.p);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagListView a;

        public j(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void a(TextView textView, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i) == null) {
                if (this.a.n.size() < this.a.t) {
                    if (!this.a.n.contains(obj)) {
                        this.a.x((String) obj);
                    } else {
                        this.a.n.remove(obj);
                    }
                } else if (!this.a.n.contains(obj)) {
                    this.a.l.setSelects(i);
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f036a));
                    bdTopToast.j((ViewGroup) this.a.d);
                } else {
                    this.a.n.remove(obj);
                }
                SelectTagListView selectTagListView = this.a;
                selectTagListView.m.setLabels(selectTagListView.n, selectTagListView.v);
                AutoChangeLineView autoChangeLineView = this.a.l;
                SelectTagListView selectTagListView2 = this.a;
                autoChangeLineView.setLabels(selectTagListView2.o, selectTagListView2.w);
                this.a.n();
                this.a.requestLayout();
                this.a.setFinishSelectType();
                this.a.y();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"InflateParams"})
    public SelectTagListView(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        super(linearLayout.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 6;
        this.u = 16;
        this.v = new b(this);
        this.w = new c(this);
        this.a = tbPageContext;
        this.e = linearLayout;
        this.b = navigationBar;
        this.n = new ArrayList();
        this.o = new ArrayList<>();
        LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0899, (ViewGroup) this.e, true);
        o();
        s();
        r();
        u();
        t();
        m();
    }

    @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
    public void a(TextView textView, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
        }
    }

    public List<String> getHadSelectTagList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    @Override // com.repackage.h95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.repackage.h95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h95
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ScrollView scrollView = this.k;
            return (scrollView == null || scrollView.getScrollY() != 0 || this.a.getOrignalPage().isKeybordVisible()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.setInputType(0);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m = (AutoChangeLineView) this.e.findViewById(R.id.obfuscated_res_0x7f090d19);
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMTextView eMTextView = this.f;
            eMTextView.setText("(" + this.n.size() + "/" + this.t + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0099));
            this.c = this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0413));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
        }
    }

    @Override // com.repackage.h95
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            s();
            r();
            u();
            t();
            m();
            wr4 d2 = wr4.d(this.p);
            d2.v(R.color.CAM_X0105);
            d2.f(R.color.CAM_X0209);
            this.m.setLabels(this.n, this.v);
            this.l.setLabels(this.o, this.w);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.n == null) {
            return;
        }
        this.m.setOnLabelClickListener(new a(this));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09162a);
            EditText editText = (EditText) this.e.findViewById(R.id.obfuscated_res_0x7f090f01);
            this.p = editText;
            editText.setMaxLines(1);
            this.r = (EMTextView) this.e.findViewById(R.id.obfuscated_res_0x7f090efc);
            this.p.setOnClickListener(new d(this));
            this.p.setOnEditorActionListener(new e(this));
            this.p.addTextChangedListener(new f(this));
            this.p.setFilters(new InputFilter[]{new h09.a(this.u, new g(this))});
            this.r.setOnClickListener(new h(this));
            wr4 d2 = wr4.d(this.j);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f = (EMTextView) this.e.findViewById(R.id.obfuscated_res_0x7f0923b7);
            EMTextView eMTextView = (EMTextView) this.e.findViewById(R.id.obfuscated_res_0x7f0923b5);
            this.g = eMTextView;
            wr4 d2 = wr4.d(eMTextView);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
    }

    public void setFinishSelectType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<String> list = this.n;
            if (list != null && list.size() != 0) {
                wr4.d(this.c).x(R.color.CAM_X0302);
            } else {
                this.c.setTextColor(zi8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    public void setHadSelectTagList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.n = list;
            this.m.setLabels(list, this.v);
            this.l.setLabels(this.o, this.w);
            this.m.setTextBold(false);
            setFinishSelectType();
            n();
        }
    }

    public void setRecommendTagList(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.o = arrayList;
            this.l.setTextBold(false);
            this.l.setLabels(this.o, this.w);
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                if (this.o.contains(this.n.get(i2))) {
                    this.l.setUnSelects(this.o.indexOf(this.n.get(i2)));
                }
            }
            setFinishSelectType();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.l = (AutoChangeLineView) this.e.findViewById(R.id.obfuscated_res_0x7f091e94);
            ScrollView scrollView = (ScrollView) this.e.findViewById(R.id.obfuscated_res_0x7f091e88);
            this.k = scrollView;
            scrollView.setOnTouchListener(new i(this));
            this.l.setOnLabelClickListener(new j(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.h = (EMTextView) this.e.findViewById(R.id.obfuscated_res_0x7f090753);
            this.i = (EMTextView) this.e.findViewById(R.id.obfuscated_res_0x7f091a07);
            wr4 d2 = wr4.d(this.h);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            wr4 d3 = wr4.d(this.i);
            d3.A(R.string.F_X02);
            d3.z(R.dimen.T_X06);
            this.h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            List<String> list = this.n;
            if (list != null && list.size() != 0) {
                this.s = true;
            } else {
                this.s = false;
            }
            setFinishSelectType();
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.n.add(str);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.n.size() >= this.t) {
                this.p.setInputType(0);
            } else {
                this.p.setInputType(1);
            }
        }
    }
}
