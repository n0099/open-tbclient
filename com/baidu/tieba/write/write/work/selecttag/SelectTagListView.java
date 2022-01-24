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
import c.a.d.f.p.n;
import c.a.t0.p4.b0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class SelectTagListView extends LinearLayout implements c.a.s0.y0.b, View.OnClickListener, AutoChangeLineView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectTagActivity> f49998e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f49999f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f50000g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f50001h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f50002i;
    public boolean isCanSelectFinish;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f50003j;
    public EMTextView k;
    public RelativeLayout l;
    public ScrollView m;
    public TextView mFinishSelectTag;
    public List<String> mHadSelectTagData;
    public AutoChangeLineView mHadSelectTagView;
    public AutoChangeLineView.b<String> mLabelHadSelectTextProvider;
    public AutoChangeLineView.b<String> mLabelRecommendSelectTextProvider;
    public ArrayList<String> mRecommendSelectTagData;
    public View mRootView;
    public AutoChangeLineView n;
    public EditText o;
    public String p;
    public EMTextView q;
    public int r;
    public int s;

    /* loaded from: classes13.dex */
    public class a implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50004e;

        public a(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50004e = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
                if (this.f50004e.mHadSelectTagData.size() != 0 && this.f50004e.mHadSelectTagData.contains(obj)) {
                    if (this.f50004e.mRecommendSelectTagData.contains(obj)) {
                        this.f50004e.n.setSelects(this.f50004e.mRecommendSelectTagData.indexOf(obj));
                    }
                    this.f50004e.mHadSelectTagData.remove(obj);
                    SelectTagListView selectTagListView = this.f50004e;
                    selectTagListView.mHadSelectTagView.setLabels(selectTagListView.mHadSelectTagData, selectTagListView.mLabelHadSelectTextProvider);
                    AutoChangeLineView autoChangeLineView = this.f50004e.n;
                    SelectTagListView selectTagListView2 = this.f50004e;
                    autoChangeLineView.setLabels(selectTagListView2.mRecommendSelectTagData, selectTagListView2.mLabelRecommendSelectTextProvider);
                    this.f50004e.u();
                    this.f50004e.m();
                    this.f50004e.requestLayout();
                    this.f50004e.setFinishSelectType();
                }
                this.f50004e.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        public /* bridge */ /* synthetic */ CharSequence a(TextView textView, int i2, String str) {
            String str2 = str;
            b(textView, i2, str2);
            return str2;
        }

        public CharSequence b(TextView textView, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i2, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(c.a.t0.p4.f.icon_pure_interested_close12, c.a.t0.p4.d.CAM_X0304, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds32);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    textView.setCompoundDrawables(null, null, pureDrawable, null);
                }
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X002));
                textView.setPadding(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X008), 0, UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X006), 0);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
                d2.v(c.a.t0.p4.d.CAM_X0304);
                d2.z(c.a.t0.p4.e.T_X08);
                d2.n(c.a.t0.p4.j.J_X01);
                d2.l(c.a.t0.p4.e.L_X01);
                d2.k(c.a.t0.p4.d.CAM_X0302);
                d2.f(c.a.t0.p4.d.CAM_X0905);
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        public /* bridge */ /* synthetic */ CharSequence a(TextView textView, int i2, String str) {
            String str2 = str;
            b(textView, i2, str2);
            return str2;
        }

        public CharSequence b(TextView textView, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i2, str)) == null) {
                if (this.a.mHadSelectTagData.contains(str)) {
                    c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
                    d2.v(c.a.t0.p4.d.CAM_X0304);
                    d2.z(c.a.t0.p4.e.T_X08);
                    d2.n(c.a.t0.p4.j.J_X01);
                    d2.l(c.a.t0.p4.e.L_X01);
                    d2.k(c.a.t0.p4.d.CAM_X0302);
                    d2.f(c.a.t0.p4.d.CAM_X0905);
                } else {
                    c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(textView);
                    d3.v(c.a.t0.p4.d.CAM_X0105);
                    d3.z(c.a.t0.p4.e.T_X08);
                    d3.n(c.a.t0.p4.j.J_X01);
                    d3.l(c.a.t0.p4.e.L_X01);
                    d3.k(c.a.t0.p4.d.CAM_X0109);
                    d3.f(c.a.t0.p4.d.CAM_X0201);
                }
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50005e;

        public d(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50005e = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50005e.mHadSelectTagData.size() >= this.f50005e.r) {
                    this.f50005e.o.setInputType(0);
                    new BdTopToast(this.f50005e.getContext()).setIcon(false).setContent(this.f50005e.getResources().getString(c.a.t0.p4.j.can_not_select_tag_more)).show((ViewGroup) this.f50005e.mRootView);
                    return;
                }
                this.f50005e.o.setInputType(1);
                n.L(this.f50005e.f49998e.getPageActivity(), this.f50005e.o);
            }
        }
    }

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    n.L(this.a.f49998e.getPageActivity(), textView);
                    if (this.a.p != null && this.a.p.trim().length() > 0) {
                        if (this.a.mHadSelectTagData.size() < this.a.r) {
                            SelectTagListView selectTagListView = this.a;
                            if (selectTagListView.mHadSelectTagData.contains(selectTagListView.p)) {
                                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getResources().getString(c.a.t0.p4.j.can_not_select_tag_again)).show((ViewGroup) this.a.mRootView);
                            } else {
                                SelectTagListView selectTagListView2 = this.a;
                                if (selectTagListView2.mRecommendSelectTagData.contains(selectTagListView2.p)) {
                                    AutoChangeLineView autoChangeLineView = this.a.n;
                                    SelectTagListView selectTagListView3 = this.a;
                                    autoChangeLineView.setUnSelects(selectTagListView3.mRecommendSelectTagData.indexOf(selectTagListView3.p));
                                }
                                SelectTagListView selectTagListView4 = this.a;
                                selectTagListView4.t(selectTagListView4.p);
                                SelectTagListView selectTagListView5 = this.a;
                                selectTagListView5.mHadSelectTagView.setLabels(selectTagListView5.mHadSelectTagData, selectTagListView5.mLabelHadSelectTextProvider);
                                AutoChangeLineView autoChangeLineView2 = this.a.n;
                                SelectTagListView selectTagListView6 = this.a;
                                autoChangeLineView2.setLabels(selectTagListView6.mRecommendSelectTagData, selectTagListView6.mLabelRecommendSelectTextProvider);
                                this.a.o.setText("");
                                this.a.q.setVisibility(8);
                                this.a.m();
                                this.a.u();
                            }
                        } else {
                            new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getResources().getString(c.a.t0.p4.j.can_not_select_tag_more)).show((ViewGroup) this.a.mRootView);
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

    /* loaded from: classes13.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50006e;

        public f(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50006e = selectTagListView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f50006e.p = editable.toString();
                if (this.f50006e.p == null || this.f50006e.p.trim().length() <= 0) {
                    this.f50006e.q.setVisibility(8);
                } else {
                    this.f50006e.q.setVisibility(0);
                }
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

    /* loaded from: classes13.dex */
    public class g implements a.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagListView;
        }

        @Override // c.a.t0.p4.b0.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getResources().getString(c.a.t0.p4.j.can_not_input_tag_more)).show((ViewGroup) this.a.mRootView);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50007e;

        public h(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50007e = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50007e.p != null && this.f50007e.p.trim().length() > 0) {
                    if (this.f50007e.mHadSelectTagData.size() < this.f50007e.r) {
                        SelectTagListView selectTagListView = this.f50007e;
                        if (selectTagListView.mHadSelectTagData.contains(selectTagListView.p)) {
                            new BdTopToast(this.f50007e.getContext()).setIcon(false).setContent(this.f50007e.getResources().getString(c.a.t0.p4.j.can_not_select_tag_again)).show((ViewGroup) this.f50007e.mRootView);
                        } else {
                            SelectTagListView selectTagListView2 = this.f50007e;
                            if (selectTagListView2.mRecommendSelectTagData.contains(selectTagListView2.p)) {
                                AutoChangeLineView autoChangeLineView = this.f50007e.n;
                                SelectTagListView selectTagListView3 = this.f50007e;
                                autoChangeLineView.setUnSelects(selectTagListView3.mRecommendSelectTagData.indexOf(selectTagListView3.p));
                            }
                            SelectTagListView selectTagListView4 = this.f50007e;
                            selectTagListView4.t(selectTagListView4.p);
                            SelectTagListView selectTagListView5 = this.f50007e;
                            selectTagListView5.mHadSelectTagView.setLabels(selectTagListView5.mHadSelectTagData, selectTagListView5.mLabelHadSelectTextProvider);
                            AutoChangeLineView autoChangeLineView2 = this.f50007e.n;
                            SelectTagListView selectTagListView6 = this.f50007e;
                            autoChangeLineView2.setLabels(selectTagListView6.mRecommendSelectTagData, selectTagListView6.mLabelRecommendSelectTextProvider);
                            this.f50007e.o.setText("");
                            this.f50007e.q.setVisibility(8);
                            this.f50007e.m();
                            this.f50007e.u();
                        }
                    } else {
                        new BdTopToast(this.f50007e.getContext()).setIcon(false).setContent(this.f50007e.getResources().getString(c.a.t0.p4.j.can_not_select_tag_more)).show((ViewGroup) this.f50007e.mRootView);
                    }
                    this.f50007e.setFinishSelectType();
                }
                this.f50007e.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50008e;

        public i(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50008e = selectTagListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 && ((SelectTagActivity) this.f50008e.f49998e.getOrignalPage()).isKeybordVisible()) {
                    n.w(this.f50008e.f49998e.getPageActivity(), this.f50008e.o);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class j implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f50009e;

        public j(SelectTagListView selectTagListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50009e = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
                if (this.f50009e.mHadSelectTagData.size() < this.f50009e.r) {
                    if (!this.f50009e.mHadSelectTagData.contains(obj)) {
                        this.f50009e.t((String) obj);
                    } else {
                        this.f50009e.mHadSelectTagData.remove(obj);
                    }
                } else if (!this.f50009e.mHadSelectTagData.contains(obj)) {
                    this.f50009e.n.setSelects(i2);
                    new BdTopToast(this.f50009e.getContext()).setIcon(false).setContent(this.f50009e.getResources().getString(c.a.t0.p4.j.can_not_select_tag_more)).show((ViewGroup) this.f50009e.mRootView);
                } else {
                    this.f50009e.mHadSelectTagData.remove(obj);
                }
                SelectTagListView selectTagListView = this.f50009e;
                selectTagListView.mHadSelectTagView.setLabels(selectTagListView.mHadSelectTagData, selectTagListView.mLabelHadSelectTextProvider);
                AutoChangeLineView autoChangeLineView = this.f50009e.n;
                SelectTagListView selectTagListView2 = this.f50009e;
                autoChangeLineView.setLabels(selectTagListView2.mRecommendSelectTagData, selectTagListView2.mLabelRecommendSelectTextProvider);
                this.f50009e.m();
                this.f50009e.requestLayout();
                this.f50009e.setFinishSelectType();
                this.f50009e.u();
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
        this.r = 6;
        this.s = 16;
        this.mLabelHadSelectTextProvider = new b(this);
        this.mLabelRecommendSelectTextProvider = new c(this);
        this.f49998e = tbPageContext;
        this.f50000g = linearLayout;
        this.f49999f = navigationBar;
        this.mHadSelectTagData = new ArrayList();
        this.mRecommendSelectTagData = new ArrayList<>();
        LayoutInflater.from(this.f49998e.getPageActivity()).inflate(c.a.t0.p4.h.view_select_tag_list, (ViewGroup) this.f50000g, true);
        n();
        q();
        p();
        s();
        r();
        l();
    }

    public List<String> getHadSelectTagList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHadSelectTagData : (List) invokeV.objValue;
    }

    @Override // c.a.s0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public void hideSoftKeyAndCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o.setInputType(0);
        }
    }

    public boolean isCanSelectFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.mHadSelectTagData;
            if (list != null && list.size() != 0) {
                this.isCanSelectFinish = true;
            } else {
                this.isCanSelectFinish = false;
            }
            setFinishSelectType();
            return this.isCanSelectFinish;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ScrollView scrollView = this.m;
            return (scrollView == null || scrollView.getScrollY() != 0 || this.f49998e.getOrignalPage().isKeybordVisible()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHadSelectTagView = (AutoChangeLineView) this.f50000g.findViewById(c.a.t0.p4.g.had_select_tag_view);
            o();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMTextView eMTextView = this.f50001h;
            eMTextView.setText("(" + this.mHadSelectTagData.size() + "/" + this.r + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f49999f.setCenterTextTitle(this.f49998e.getResources().getString(c.a.t0.p4.j.activity_select_tag_title));
            this.mFinishSelectTag = this.f49999f.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f49998e.getResources().getString(c.a.t0.p4.j.complete));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mHadSelectTagData == null) {
            return;
        }
        this.mHadSelectTagView.setOnLabelClickListener(new a(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
    public void onLabelClick(TextView textView, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, textView, obj, i2) == null) {
        }
    }

    @Override // c.a.s0.y0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            q();
            p();
            s();
            r();
            l();
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.o);
            d2.v(c.a.t0.p4.d.CAM_X0105);
            d2.f(c.a.t0.p4.d.CAM_X0209);
            this.mHadSelectTagView.setLabels(this.mHadSelectTagData, this.mLabelHadSelectTextProvider);
            this.n.setLabels(this.mRecommendSelectTagData, this.mLabelRecommendSelectTextProvider);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l = (RelativeLayout) this.f50000g.findViewById(c.a.t0.p4.g.outside_tag_input_box);
            EditText editText = (EditText) this.f50000g.findViewById(c.a.t0.p4.g.inside_tag_input_box);
            this.o = editText;
            editText.setMaxLines(1);
            this.q = (EMTextView) this.f50000g.findViewById(c.a.t0.p4.g.input_tag);
            this.o.setOnClickListener(new d(this));
            this.o.setOnEditorActionListener(new e(this));
            this.o.addTextChangedListener(new f(this));
            this.o.setFilters(new InputFilter[]{new a.C1329a(this.s, new g(this))});
            this.q.setOnClickListener(new h(this));
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.l);
            d2.n(c.a.t0.p4.j.J_X07);
            d2.f(c.a.t0.p4.d.CAM_X0209);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f50001h = (EMTextView) this.f50000g.findViewById(c.a.t0.p4.g.view_tag_counter);
            EMTextView eMTextView = (EMTextView) this.f50000g.findViewById(c.a.t0.p4.g.view_select_tag_title);
            this.f50002i = eMTextView;
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(eMTextView);
            d2.A(c.a.t0.p4.j.F_X02);
            d2.z(c.a.t0.p4.e.T_X06);
            this.f50002i.setTextColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0105));
            this.f50001h.setTextColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0109));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = (AutoChangeLineView) this.f50000g.findViewById(c.a.t0.p4.g.tag_select_view);
            ScrollView scrollView = (ScrollView) this.f50000g.findViewById(c.a.t0.p4.g.tag_recommend_tag_list);
            this.m = scrollView;
            scrollView.setOnTouchListener(new i(this));
            this.n.setOnLabelClickListener(new j(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f50003j = (EMTextView) this.f50000g.findViewById(c.a.t0.p4.g.custom_tag_title);
            this.k = (EMTextView) this.f50000g.findViewById(c.a.t0.p4.g.recommend_tag_title);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f50003j);
            d2.A(c.a.t0.p4.j.F_X02);
            d2.z(c.a.t0.p4.e.T_X06);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.k);
            d3.A(c.a.t0.p4.j.F_X02);
            d3.z(c.a.t0.p4.e.T_X06);
            this.f50003j.setTextColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0105));
            this.k.setTextColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0105));
        }
    }

    public void setFinishSelectType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<String> list = this.mHadSelectTagData;
            if (list != null && list.size() != 0) {
                c.a.s0.s.u.c.d(this.mFinishSelectTag).x(c.a.t0.p4.d.CAM_X0302);
            } else {
                this.mFinishSelectTag.setTextColor(c.a.t0.x3.c.a(SkinManager.getColor(c.a.t0.p4.d.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    public void setHadSelectTagList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.mHadSelectTagData = list;
            this.mHadSelectTagView.setLabels(list, this.mLabelHadSelectTextProvider);
            this.n.setLabels(this.mRecommendSelectTagData, this.mLabelRecommendSelectTextProvider);
            this.mHadSelectTagView.setTextBold(false);
            setFinishSelectType();
            m();
        }
    }

    public void setRecommendTagList(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            this.mRecommendSelectTagData = arrayList;
            this.n.setTextBold(false);
            this.n.setLabels(this.mRecommendSelectTagData, this.mLabelRecommendSelectTextProvider);
            for (int i2 = 0; i2 < this.mHadSelectTagData.size(); i2++) {
                if (this.mRecommendSelectTagData.contains(this.mHadSelectTagData.get(i2))) {
                    this.n.setUnSelects(this.mRecommendSelectTagData.indexOf(this.mHadSelectTagData.get(i2)));
                }
            }
            setFinishSelectType();
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mHadSelectTagData.add(str);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.mHadSelectTagData.size() >= this.r) {
                this.o.setInputType(0);
            } else {
                this.o.setInputType(1);
            }
        }
    }
}
