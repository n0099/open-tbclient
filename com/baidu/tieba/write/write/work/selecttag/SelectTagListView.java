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
import c.a.e.e.p.l;
import c.a.q0.b4.r.a;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SelectTagListView extends LinearLayout implements c.a.p0.v0.a, View.OnClickListener, AutoChangeLineView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectTagActivity> f59026e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f59027f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f59028g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f59029h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f59030i;
    public boolean isCanSelectFinish;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f59031j;
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

    /* loaded from: classes7.dex */
    public class a implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59032e;

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
            this.f59032e = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
                if (this.f59032e.mHadSelectTagData.size() != 0 && this.f59032e.mHadSelectTagData.contains(obj)) {
                    if (this.f59032e.mRecommendSelectTagData.contains(obj)) {
                        this.f59032e.n.setSelects(this.f59032e.mRecommendSelectTagData.indexOf(obj));
                    }
                    this.f59032e.mHadSelectTagData.remove(obj);
                    SelectTagListView selectTagListView = this.f59032e;
                    selectTagListView.mHadSelectTagView.setLabels(selectTagListView.mHadSelectTagData, selectTagListView.mLabelHadSelectTextProvider);
                    AutoChangeLineView autoChangeLineView = this.f59032e.n;
                    SelectTagListView selectTagListView2 = this.f59032e;
                    autoChangeLineView.setLabels(selectTagListView2.mRecommendSelectTagData, selectTagListView2.mLabelRecommendSelectTextProvider);
                    this.f59032e.t();
                    this.f59032e.l();
                    this.f59032e.requestLayout();
                    this.f59032e.setFinishSelectType();
                }
                this.f59032e.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59033a;

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
            this.f59033a = selectTagListView;
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
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_interested_close12, R.color.CAM_X0304, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                textView.setCompoundDrawables(null, null, pureDrawable, null);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X008), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 0);
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
                d2.u(R.color.CAM_X0304);
                d2.y(R.dimen.T_X08);
                d2.n(R.string.J_X01);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(R.color.CAM_X0905);
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59034a;

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
            this.f59034a = selectTagListView;
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
                if (this.f59034a.mHadSelectTagData.contains(str)) {
                    c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
                    d2.u(R.color.CAM_X0304);
                    d2.y(R.dimen.T_X08);
                    d2.n(R.string.J_X01);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                    d2.f(R.color.CAM_X0905);
                } else {
                    c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(textView);
                    d3.u(R.color.CAM_X0105);
                    d3.y(R.dimen.T_X08);
                    d3.n(R.string.J_X01);
                    d3.l(R.dimen.L_X01);
                    d3.k(R.color.CAM_X0109);
                    d3.f(R.color.CAM_X0201);
                }
                return str;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59035e;

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
            this.f59035e = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59035e.mHadSelectTagData.size() >= this.f59035e.r) {
                    this.f59035e.o.setInputType(0);
                    new BdTopToast(this.f59035e.getContext()).setIcon(false).setContent(this.f59035e.getResources().getString(R.string.can_not_select_tag_more)).show((ViewGroup) this.f59035e.mRootView);
                    return;
                }
                this.f59035e.o.setInputType(1);
                l.K(this.f59035e.f59026e.getPageActivity(), this.f59035e.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59036a;

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
            this.f59036a = selectTagListView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    l.K(this.f59036a.f59026e.getPageActivity(), textView);
                    if (this.f59036a.p != null && this.f59036a.p.trim().length() > 0) {
                        if (this.f59036a.mHadSelectTagData.size() < this.f59036a.r) {
                            SelectTagListView selectTagListView = this.f59036a;
                            if (selectTagListView.mHadSelectTagData.contains(selectTagListView.p)) {
                                new BdTopToast(this.f59036a.getContext()).setIcon(false).setContent(this.f59036a.getResources().getString(R.string.can_not_select_tag_again)).show((ViewGroup) this.f59036a.mRootView);
                            } else {
                                SelectTagListView selectTagListView2 = this.f59036a;
                                if (selectTagListView2.mRecommendSelectTagData.contains(selectTagListView2.p)) {
                                    AutoChangeLineView autoChangeLineView = this.f59036a.n;
                                    SelectTagListView selectTagListView3 = this.f59036a;
                                    autoChangeLineView.setUnSelects(selectTagListView3.mRecommendSelectTagData.indexOf(selectTagListView3.p));
                                }
                                SelectTagListView selectTagListView4 = this.f59036a;
                                selectTagListView4.s(selectTagListView4.p);
                                SelectTagListView selectTagListView5 = this.f59036a;
                                selectTagListView5.mHadSelectTagView.setLabels(selectTagListView5.mHadSelectTagData, selectTagListView5.mLabelHadSelectTextProvider);
                                AutoChangeLineView autoChangeLineView2 = this.f59036a.n;
                                SelectTagListView selectTagListView6 = this.f59036a;
                                autoChangeLineView2.setLabels(selectTagListView6.mRecommendSelectTagData, selectTagListView6.mLabelRecommendSelectTextProvider);
                                this.f59036a.o.setText("");
                                this.f59036a.q.setVisibility(8);
                                this.f59036a.l();
                                this.f59036a.t();
                            }
                        } else {
                            new BdTopToast(this.f59036a.getContext()).setIcon(false).setContent(this.f59036a.getResources().getString(R.string.can_not_select_tag_more)).show((ViewGroup) this.f59036a.mRootView);
                        }
                    }
                    this.f59036a.setFinishSelectType();
                    return true;
                }
                this.f59036a.setFinishSelectType();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59037e;

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
            this.f59037e = selectTagListView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f59037e.p = editable.toString();
                if (this.f59037e.p == null || this.f59037e.p.trim().length() <= 0) {
                    this.f59037e.q.setVisibility(8);
                } else {
                    this.f59037e.q.setVisibility(0);
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

    /* loaded from: classes7.dex */
    public class g implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59038a;

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
            this.f59038a = selectTagListView;
        }

        @Override // c.a.q0.b4.r.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new BdTopToast(this.f59038a.getContext()).setIcon(false).setContent(this.f59038a.getResources().getString(R.string.can_not_input_tag_more)).show((ViewGroup) this.f59038a.mRootView);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59039e;

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
            this.f59039e = selectTagListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59039e.p != null && this.f59039e.p.trim().length() > 0) {
                    if (this.f59039e.mHadSelectTagData.size() < this.f59039e.r) {
                        SelectTagListView selectTagListView = this.f59039e;
                        if (selectTagListView.mHadSelectTagData.contains(selectTagListView.p)) {
                            new BdTopToast(this.f59039e.getContext()).setIcon(false).setContent(this.f59039e.getResources().getString(R.string.can_not_select_tag_again)).show((ViewGroup) this.f59039e.mRootView);
                        } else {
                            SelectTagListView selectTagListView2 = this.f59039e;
                            if (selectTagListView2.mRecommendSelectTagData.contains(selectTagListView2.p)) {
                                AutoChangeLineView autoChangeLineView = this.f59039e.n;
                                SelectTagListView selectTagListView3 = this.f59039e;
                                autoChangeLineView.setUnSelects(selectTagListView3.mRecommendSelectTagData.indexOf(selectTagListView3.p));
                            }
                            SelectTagListView selectTagListView4 = this.f59039e;
                            selectTagListView4.s(selectTagListView4.p);
                            SelectTagListView selectTagListView5 = this.f59039e;
                            selectTagListView5.mHadSelectTagView.setLabels(selectTagListView5.mHadSelectTagData, selectTagListView5.mLabelHadSelectTextProvider);
                            AutoChangeLineView autoChangeLineView2 = this.f59039e.n;
                            SelectTagListView selectTagListView6 = this.f59039e;
                            autoChangeLineView2.setLabels(selectTagListView6.mRecommendSelectTagData, selectTagListView6.mLabelRecommendSelectTextProvider);
                            this.f59039e.o.setText("");
                            this.f59039e.q.setVisibility(8);
                            this.f59039e.l();
                            this.f59039e.t();
                        }
                    } else {
                        new BdTopToast(this.f59039e.getContext()).setIcon(false).setContent(this.f59039e.getResources().getString(R.string.can_not_select_tag_more)).show((ViewGroup) this.f59039e.mRootView);
                    }
                    this.f59039e.setFinishSelectType();
                }
                this.f59039e.setFinishSelectType();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59040e;

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
            this.f59040e = selectTagListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 && ((SelectTagActivity) this.f59040e.f59026e.getOrignalPage()).isKeybordVisible()) {
                    l.x(this.f59040e.f59026e.getPageActivity(), this.f59040e.o);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagListView f59041e;

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
            this.f59041e = selectTagListView;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) {
                if (this.f59041e.mHadSelectTagData.size() < this.f59041e.r) {
                    if (!this.f59041e.mHadSelectTagData.contains(obj)) {
                        this.f59041e.s((String) obj);
                    } else {
                        this.f59041e.mHadSelectTagData.remove(obj);
                    }
                } else if (!this.f59041e.mHadSelectTagData.contains(obj)) {
                    this.f59041e.n.setSelects(i2);
                    new BdTopToast(this.f59041e.getContext()).setIcon(false).setContent(this.f59041e.getResources().getString(R.string.can_not_select_tag_more)).show((ViewGroup) this.f59041e.mRootView);
                } else {
                    this.f59041e.mHadSelectTagData.remove(obj);
                }
                SelectTagListView selectTagListView = this.f59041e;
                selectTagListView.mHadSelectTagView.setLabels(selectTagListView.mHadSelectTagData, selectTagListView.mLabelHadSelectTextProvider);
                AutoChangeLineView autoChangeLineView = this.f59041e.n;
                SelectTagListView selectTagListView2 = this.f59041e;
                autoChangeLineView.setLabels(selectTagListView2.mRecommendSelectTagData, selectTagListView2.mLabelRecommendSelectTextProvider);
                this.f59041e.l();
                this.f59041e.requestLayout();
                this.f59041e.setFinishSelectType();
                this.f59041e.t();
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
        this.f59026e = tbPageContext;
        this.f59028g = linearLayout;
        this.f59027f = navigationBar;
        this.mHadSelectTagData = new ArrayList();
        this.mRecommendSelectTagData = new ArrayList<>();
        LayoutInflater.from(this.f59026e.getPageActivity()).inflate(R.layout.view_select_tag_list, (ViewGroup) this.f59028g, true);
        m();
        p();
        o();
        r();
        q();
        k();
    }

    public List<String> getHadSelectTagList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHadSelectTagData : (List) invokeV.objValue;
    }

    @Override // c.a.p0.v0.a
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

    @Override // c.a.p0.v0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ScrollView scrollView = this.m;
            return (scrollView == null || scrollView.getScrollY() != 0 || this.f59026e.getOrignalPage().isKeybordVisible()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHadSelectTagView = (AutoChangeLineView) this.f59028g.findViewById(R.id.had_select_tag_view);
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMTextView eMTextView = this.f59029h;
            eMTextView.setText("(" + this.mHadSelectTagData.size() + "/" + this.r + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f59027f.setCenterTextTitle(this.f59026e.getResources().getString(R.string.activity_select_tag_title));
            this.mFinishSelectTag = this.f59027f.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f59026e.getResources().getString(R.string.complete));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mHadSelectTagData == null) {
            return;
        }
        this.mHadSelectTagView.setOnLabelClickListener(new a(this));
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = (RelativeLayout) this.f59028g.findViewById(R.id.outside_tag_input_box);
            EditText editText = (EditText) this.f59028g.findViewById(R.id.inside_tag_input_box);
            this.o = editText;
            editText.setMaxLines(1);
            this.q = (EMTextView) this.f59028g.findViewById(R.id.input_tag);
            this.o.setOnClickListener(new d(this));
            this.o.setOnEditorActionListener(new e(this));
            this.o.addTextChangedListener(new f(this));
            this.o.setFilters(new InputFilter[]{new a.C0777a(this.s, new g(this))});
            this.q.setOnClickListener(new h(this));
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.l);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
    public void onLabelClick(TextView textView, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, textView, obj, i2) == null) {
        }
    }

    @Override // c.a.p0.v0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            p();
            o();
            r();
            q();
            k();
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.o);
            d2.u(R.color.CAM_X0105);
            d2.f(R.color.CAM_X0209);
            this.mHadSelectTagView.setLabels(this.mHadSelectTagData, this.mLabelHadSelectTextProvider);
            this.n.setLabels(this.mRecommendSelectTagData, this.mLabelRecommendSelectTextProvider);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f59029h = (EMTextView) this.f59028g.findViewById(R.id.view_tag_counter);
            EMTextView eMTextView = (EMTextView) this.f59028g.findViewById(R.id.view_select_tag_title);
            this.f59030i = eMTextView;
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(eMTextView);
            d2.z(R.string.F_X02);
            d2.y(R.dimen.T_X06);
            this.f59030i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f59029h.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = (AutoChangeLineView) this.f59028g.findViewById(R.id.tag_select_view);
            ScrollView scrollView = (ScrollView) this.f59028g.findViewById(R.id.tag_recommend_tag_list);
            this.m = scrollView;
            scrollView.setOnTouchListener(new i(this));
            this.n.setOnLabelClickListener(new j(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f59031j = (EMTextView) this.f59028g.findViewById(R.id.custom_tag_title);
            this.k = (EMTextView) this.f59028g.findViewById(R.id.recommend_tag_title);
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f59031j);
            d2.z(R.string.F_X02);
            d2.y(R.dimen.T_X06);
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(this.k);
            d3.z(R.string.F_X02);
            d3.y(R.dimen.T_X06);
            this.f59031j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mHadSelectTagData.add(str);
        }
    }

    public void setFinishSelectType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            List<String> list = this.mHadSelectTagData;
            if (list != null && list.size() != 0) {
                c.a.p0.s.u.c.d(this.mFinishSelectTag).w(R.color.CAM_X0302);
            } else {
                this.mFinishSelectTag.setTextColor(c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    public void setHadSelectTagList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.mHadSelectTagData = list;
            this.mHadSelectTagView.setLabels(list, this.mLabelHadSelectTextProvider);
            this.n.setLabels(this.mRecommendSelectTagData, this.mLabelRecommendSelectTextProvider);
            this.mHadSelectTagView.setTextBold(false);
            setFinishSelectType();
            l();
        }
    }

    public void setRecommendTagList(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) {
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

    public final void t() {
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
