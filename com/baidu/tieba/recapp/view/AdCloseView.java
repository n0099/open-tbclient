package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.r0.r.f0.m.b;
import d.a.s0.n1.o.k.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
public class AdCloseView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public long C;
    public boolean D;
    public int E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public PopupWindow.OnDismissListener I;
    public final CustomMessageListener J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public Context f20552e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f20553f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f20554g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f20555h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f20556i;
    public b j;
    public TextView k;
    public RelativeLayout l;
    public EMTextView m;
    public ImageView n;
    public ImageView o;
    public int p;
    public List<CheckBox> q;
    public AdvertAppInfo r;
    public ActionControl s;
    public List<String> t;
    public String u;
    public String v;
    public int w;
    public int x;
    public View y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f20552e = null;
        this.f20553f = null;
        this.f20554g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20557e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20557e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f20557e.C > 500) {
                        this.f20557e.r();
                        this.f20557e.C = currentTimeMillis;
                    }
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20558e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20558e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f20558e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f20558e;
                        adCloseView.f20556i.setText(adCloseView.f20552e.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f20558e.k.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f20558e;
                    adCloseView2.f20556i.setText(adCloseView2.f20552e.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f20558e;
                    adCloseView3.k.setText(adCloseView3.u);
                }
            }
        };
        this.H = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20559e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20559e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f20559e.r == null) {
                    return;
                }
                AdCloseView adCloseView = this.f20559e;
                if (adCloseView.f20553f == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f20559e.r.L3));
                this.f20559e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i4 = this.f20559e.E;
                if (i4 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i4 == 2 || i4 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i4 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f20559e.r.S3);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.I = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20560e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20560e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f20560e.f20554g) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f20560e.f20554g = null;
            }
        };
        this.J = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20561a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20561a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20561a.o();
                }
            }
        };
        this.K = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20562e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20562e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f20562e.p();
                }
            }
        };
        this.f20552e = context;
        q();
    }

    private View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.f20552e;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
            this.k = (TextView) inflate.findViewById(R.id.head_text);
            this.l = (RelativeLayout) inflate.findViewById(R.id.top_area);
            View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
            this.m = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
            this.n = (ImageView) inflate.findViewById(R.id.arrow_right);
            if (!TextUtils.isEmpty(this.u)) {
                this.k.setText(this.u);
            }
            this.f20556i = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
            b bVar = new b();
            this.j = bVar;
            bVar.q(R.color.CAM_X0304);
            this.f20556i.setConfig(this.j);
            if (!TextUtils.isEmpty(this.v)) {
                this.f20556i.setText(this.v);
            } else {
                this.f20556i.setText(this.f20552e.getResources().getString(R.string.ad_no_interest));
            }
            this.f20556i.setOnClickListener(this.H);
            if (m()) {
                this.m.setText(this.s.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.K);
            }
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            this.n.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.f20555h = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
            this.q = new ArrayList();
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.r == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!a.e(this.q)) {
                for (int i2 = 0; i2 < a.k(this.q); i2++) {
                    CheckBox checkBox = (CheckBox) a.d(this.q, i2);
                    if (checkBox != null && checkBox.isChecked() && a.k(this.t) > i2) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) a.d(this.t, i2));
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private int getWindowMeasuredHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            View view = this.y;
            if (view == null) {
                return 0;
            }
            try {
                view.measure(0, 0);
                return this.y.getMeasuredHeight();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public View getAdCloseView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getCloseViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.g(this.f20552e, R.dimen.tbds72) : invokeV.intValue;
    }

    public int getCloseViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l.g(this.f20552e, R.dimen.tbds72) : invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || a.e(this.t)) {
            return;
        }
        int k = a.k(this.t);
        this.f20555h.setVisibility(0);
        int i2 = 0;
        for (int i3 = 0; i3 < Math.ceil(k / 2.0d); i3++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f20552e).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i3 != 0) {
                layoutParams.topMargin = l.g(this.f20552e, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.f20555h.addView(linearLayout);
            for (int i4 = 0; i4 < linearLayout.getChildCount() && (i2 = i2 + 1) <= k; i4++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                checkBox.setOnClickListener(this.G);
                checkBox.setVisibility(0);
                a.a(this.q, checkBox);
            }
        }
        for (int i5 = 0; i5 < a.k(this.t); i5++) {
            String str = (String) a.d(this.t, i5);
            CheckBox checkBox2 = (CheckBox) a.d(this.q, i5);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean l(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i6 = l.i(context);
            int k = l.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k - i3;
            if (z) {
                iArr[1] = (iArr2[1] - i2) - i5;
            } else {
                iArr[1] = iArr2[1] + height + i5;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ActionControl actionControl = this.s;
            return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.s.name)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (a.e(this.q)) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < a.k(this.q); i3++) {
                CheckBox checkBox = (CheckBox) a.d(this.q, i3);
                if (checkBox != null && checkBox.isChecked()) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PopupWindow popupWindow = this.f20553f;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f20553f = null;
            }
            PopupWindow popupWindow2 = this.f20554g;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.f20554g = null;
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.o.setImageDrawable(WebPManager.getPureDrawable(this.p, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            if (this.D) {
                MessageManager.getInstance().unRegisterListener(this.J);
                this.D = false;
            }
            if (this.f20554g != null) {
                PopupWindow popupWindow = this.f20553f;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    this.f20554g.dismiss();
                    this.f20554g = null;
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && m()) {
            d.a.s0.q.a.l().c(getContext(), new String[]{this.s.url}, null);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
            layoutParams.gravity = 21;
            addView(this.o, layoutParams);
            this.A = l.g(this.f20552e, R.dimen.M_W_X004);
            this.B = l.g(this.f20552e, R.dimen.ds10);
            this.w = l.g(this.f20552e, R.dimen.ds278);
            this.x = l.k(this.f20552e) - (this.A * 2);
            this.z = l.g(this.f20552e, R.dimen.ds120);
            setOnClickListener(this.F);
            this.o.setImageDrawable(WebPManager.getPureDrawable(this.p, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f20552e == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(j.a(getContext()), null)) {
            return;
        }
        o();
        View contentView = getContentView();
        k();
        this.y = contentView;
        this.w = getWindowMeasuredHeight();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.f20552e, R.dimen.tbds31));
        this.y.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(contentView, this.x, this.w);
        this.f20553f = popupWindow;
        popupWindow.setFocusable(true);
        this.f20553f.setTouchable(true);
        this.f20553f.setOnDismissListener(this.I);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f20553f.setAttachedInDecor(false);
        }
        if (!this.D) {
            MessageManager.getInstance().registerListener(this.J);
            this.D = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f20552e).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f20554g = popupWindow2;
        popupWindow2.setFocusable(false);
        this.f20554g.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.f20554g.setAttachedInDecor(false);
        }
        this.f20554g.showAtLocation(this, 0, 0, 0);
        int[] iArr = new int[2];
        boolean l = l(this.f20552e, this, this.w, this.x, this.z, this.B, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f20553f.setBackgroundDrawable(new ColorDrawable(0));
        if (l) {
            this.f20553f.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f20553f.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f20553f.showAtLocation(getRootView(), 0, iArr[0] - this.A, iArr[1]);
    }

    public void setData(AdvertAppInfo advertAppInfo, AdCloseInfo adCloseInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, adCloseInfo) == null) || advertAppInfo == null) {
            return;
        }
        this.r = advertAppInfo;
        a.c(this.t);
        if (adCloseInfo != null) {
            this.s = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                a.a(this.t, str);
            }
            String str2 = adCloseInfo.title;
            this.u = str2;
            if (TextUtils.isEmpty(str2)) {
                this.u = this.f20552e.getString(R.string.tell_us_reason);
            }
            this.v = adCloseInfo.confirm_title;
        }
    }

    public void setPage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.E = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20552e = null;
        this.f20553f = null;
        this.f20554g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20557e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20557e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f20557e.C > 500) {
                        this.f20557e.r();
                        this.f20557e.C = currentTimeMillis;
                    }
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20558e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20558e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f20558e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f20558e;
                        adCloseView.f20556i.setText(adCloseView.f20552e.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f20558e.k.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f20558e;
                    adCloseView2.f20556i.setText(adCloseView2.f20552e.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f20558e;
                    adCloseView3.k.setText(adCloseView3.u);
                }
            }
        };
        this.H = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20559e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20559e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f20559e.r == null) {
                    return;
                }
                AdCloseView adCloseView = this.f20559e;
                if (adCloseView.f20553f == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f20559e.r.L3));
                this.f20559e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i4 = this.f20559e.E;
                if (i4 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i4 == 2 || i4 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i4 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f20559e.r.S3);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.I = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20560e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20560e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f20560e.f20554g) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f20560e.f20554g = null;
            }
        };
        this.J = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20561a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20561a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20561a.o();
                }
            }
        };
        this.K = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20562e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20562e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f20562e.p();
                }
            }
        };
        this.f20552e = context;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f20552e = null;
        this.f20553f = null;
        this.f20554g = null;
        this.p = R.drawable.icon_pure_card_close22;
        this.q = null;
        this.r = null;
        this.t = new ArrayList();
        this.C = 0L;
        this.D = false;
        this.F = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20557e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20557e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f20557e.C > 500) {
                        this.f20557e.r();
                        this.f20557e.C = currentTimeMillis;
                    }
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20558e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20558e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f20558e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f20558e;
                        adCloseView.f20556i.setText(adCloseView.f20552e.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f20558e.f20552e.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f20558e.k.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f20558e;
                    adCloseView2.f20556i.setText(adCloseView2.f20552e.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f20558e;
                    adCloseView3.k.setText(adCloseView3.u);
                }
            }
        };
        this.H = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20559e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20559e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f20559e.r == null) {
                    return;
                }
                AdCloseView adCloseView = this.f20559e;
                if (adCloseView.f20553f == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f20559e.r.L3));
                this.f20559e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i42 = this.f20559e.E;
                if (i42 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i42 == 2 || i42 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i42 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f20559e.r.S3);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.I = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20560e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20560e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f20560e.f20554g) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f20560e.f20554g = null;
            }
        };
        this.J = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20561a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20561a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20561a.o();
                }
            }
        };
        this.K = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f20562e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20562e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f20562e.p();
                }
            }
        };
        this.f20552e = context;
        q();
    }
}
