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
import com.baidu.nadcore.stats.request.ClogBuilder;
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
import com.repackage.ez0;
import com.repackage.f9;
import com.repackage.jd7;
import com.repackage.lu4;
import com.repackage.oi;
import com.repackage.wi5;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public PopupWindow.OnDismissListener E;
    public final CustomMessageListener F;
    public View.OnClickListener G;
    public Context a;
    public PopupWindow b;
    public PopupWindow c;
    public LinearLayout d;
    public TBSpecificationBtn e;
    public lu4 f;
    public TextView g;
    public RelativeLayout h;
    public EMTextView i;
    public ImageView j;
    public ImageView k;
    public int l;
    public List<CheckBox> m;
    public AdvertAppInfo n;
    public ActionControl o;
    public List<String> p;
    public String q;
    public String r;
    public int s;
    public int t;
    public View u;
    public int v;
    public int w;
    public int x;
    public long y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.l = R.drawable.icon_pure_card_close22;
        this.m = null;
        this.n = null;
        this.p = new ArrayList();
        this.y = 0L;
        this.z = false;
        this.B = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.a.y > 500) {
                        this.a.r();
                        this.a.y = currentTimeMillis;
                    }
                    if (this.a.n != null) {
                        ez0.b(new ClogBuilder().t(String.valueOf(105)).r(this.a.n.k).h("dislike").n(this.a.n.h));
                    }
                }
            }
        };
        this.C = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int n = this.a.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.a;
                        adCloseView.e.setText(adCloseView.a.getResources().getString(R.string.obfuscated_res_0x7f0f0421));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a4));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a3));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.a.g.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.a;
                    adCloseView2.e.setText(adCloseView2.a.getResources().getString(R.string.obfuscated_res_0x7f0f00b3));
                    AdCloseView adCloseView3 = this.a;
                    adCloseView3.g.setText(adCloseView3.q);
                }
            }
        };
        this.D = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.n == null) {
                    return;
                }
                AdCloseView adCloseView = this.a;
                if (adCloseView.b == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.a.n.a));
                this.a.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i3 = this.a.A;
                if (i3 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i3 == 2 || i3 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i3 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.a.n.h);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.E = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.a.c) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.a.c = null;
            }
        };
        this.F = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.o();
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    this.a.p();
                }
            }
        };
        this.a = context;
        q();
    }

    private View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d006c, (ViewGroup) null);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090d2f);
            this.h = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092089);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0900e7);
            this.i = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e6);
            this.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902b2);
            if (!TextUtils.isEmpty(this.q)) {
                this.g.setText(this.q);
            }
            this.e = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f090a17);
            lu4 lu4Var = new lu4();
            this.f = lu4Var;
            lu4Var.r(R.color.CAM_X0304);
            this.e.setConfig(this.f);
            if (!TextUtils.isEmpty(this.r)) {
                this.e.setText(this.r);
            } else {
                this.e.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f00b3));
            }
            this.e.setOnClickListener(this.D);
            if (m()) {
                this.i.setText(this.o.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.G);
            }
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            this.j.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0919bc);
            this.m = new ArrayList();
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.n == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!jd7.e(this.m)) {
                for (int i = 0; i < jd7.k(this.m); i++) {
                    CheckBox checkBox = (CheckBox) jd7.d(this.m, i);
                    if (checkBox != null && checkBox.isChecked() && jd7.k(this.p) > i) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) jd7.d(this.p, i));
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
            View view2 = this.u;
            if (view2 == null) {
                return 0;
            }
            try {
                view2.measure(0, 0);
                return this.u.getMeasuredHeight();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? oi.f(this.a, R.dimen.tbds72) : invokeV.intValue;
    }

    public int getCloseViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? oi.f(this.a, R.dimen.tbds72) : invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || jd7.e(this.p)) {
            return;
        }
        int k = jd7.k(this.p);
        this.d.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < Math.ceil(k / 2.0d); i2++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d006d, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i2 != 0) {
                layoutParams.topMargin = oi.f(this.a, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.d.addView(linearLayout);
            for (int i3 = 0; i3 < linearLayout.getChildCount() && (i = i + 1) <= k; i3++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                checkBox.setOnClickListener(this.C);
                checkBox.setVisibility(0);
                jd7.a(this.m, checkBox);
            }
        }
        for (int i4 = 0; i4 < jd7.k(this.p); i4++) {
            String str = (String) jd7.d(this.p, i4);
            CheckBox checkBox2 = (CheckBox) jd7.d(this.m, i4);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean l(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int i5 = oi.i(context);
            int k = oi.k(context);
            boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
            iArr[0] = k - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ActionControl actionControl = this.o;
            return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.o.name)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (jd7.e(this.m)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < jd7.k(this.m); i2++) {
                CheckBox checkBox = (CheckBox) jd7.d(this.m, i2);
                if (checkBox != null && checkBox.isChecked()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PopupWindow popupWindow = this.b;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.b = null;
            }
            PopupWindow popupWindow2 = this.c;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.c = null;
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.setImageDrawable(WebPManager.getPureDrawable(this.l, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            o();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            if (this.z) {
                MessageManager.getInstance().unRegisterListener(this.F);
                this.z = false;
            }
            if (this.c != null) {
                PopupWindow popupWindow = this.b;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    this.c.dismiss();
                    this.c = null;
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && m()) {
            wi5.l().c(getContext(), new String[]{this.o.url}, null);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
            layoutParams.gravity = 21;
            addView(this.k, layoutParams);
            this.w = oi.f(this.a, R.dimen.M_W_X004);
            this.x = oi.f(this.a, R.dimen.obfuscated_res_0x7f070234);
            this.s = oi.f(this.a, R.dimen.obfuscated_res_0x7f070294);
            this.t = oi.k(this.a) - (this.w * 2);
            this.v = oi.f(this.a, R.dimen.obfuscated_res_0x7f07023f);
            setOnClickListener(this.B);
            this.k.setImageDrawable(WebPManager.getPureDrawable(this.l, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(f9.a(getContext()), null)) {
            return;
        }
        o();
        View contentView = getContentView();
        k();
        this.u = contentView;
        this.s = getWindowMeasuredHeight();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(oi.f(this.a, R.dimen.tbds31));
        this.u.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(contentView, this.t, this.s);
        this.b = popupWindow;
        popupWindow.setFocusable(true);
        this.b.setTouchable(true);
        this.b.setOnDismissListener(this.E);
        if (Build.VERSION.SDK_INT >= 22) {
            this.b.setAttachedInDecor(false);
        }
        if (!this.z) {
            MessageManager.getInstance().registerListener(this.F);
            this.z = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0892, (ViewGroup) null), -1, -1);
        this.c = popupWindow2;
        popupWindow2.setFocusable(false);
        this.c.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.c.setAttachedInDecor(false);
        }
        this.c.showAtLocation(this, 0, 0, 0);
        int[] iArr = new int[2];
        boolean l = l(this.a, this, this.s, this.t, this.v, this.x, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.b.setBackgroundDrawable(new ColorDrawable(0));
        if (l) {
            this.b.setAnimationStyle(R.style.obfuscated_res_0x7f1003e4);
        } else {
            this.b.setAnimationStyle(R.style.obfuscated_res_0x7f1003e5);
        }
        this.b.showAtLocation(getRootView(), 0, iArr[0] - this.w, iArr[1]);
    }

    public void setData(AdvertAppInfo advertAppInfo, AdCloseInfo adCloseInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, adCloseInfo) == null) || advertAppInfo == null) {
            return;
        }
        this.n = advertAppInfo;
        jd7.c(this.p);
        if (adCloseInfo != null) {
            this.o = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                jd7.a(this.p, str);
            }
            String str2 = adCloseInfo.title;
            this.q = str2;
            if (TextUtils.isEmpty(str2)) {
                this.q = this.a.getString(R.string.obfuscated_res_0x7f0f1387);
            }
            this.r = adCloseInfo.confirm_title;
        }
    }

    public void setPage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.A = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.l = R.drawable.icon_pure_card_close22;
        this.m = null;
        this.n = null;
        this.p = new ArrayList();
        this.y = 0L;
        this.z = false;
        this.B = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.a.y > 500) {
                        this.a.r();
                        this.a.y = currentTimeMillis;
                    }
                    if (this.a.n != null) {
                        ez0.b(new ClogBuilder().t(String.valueOf(105)).r(this.a.n.k).h("dislike").n(this.a.n.h));
                    }
                }
            }
        };
        this.C = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int n = this.a.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.a;
                        adCloseView.e.setText(adCloseView.a.getResources().getString(R.string.obfuscated_res_0x7f0f0421));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a4));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a3));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.a.g.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.a;
                    adCloseView2.e.setText(adCloseView2.a.getResources().getString(R.string.obfuscated_res_0x7f0f00b3));
                    AdCloseView adCloseView3 = this.a;
                    adCloseView3.g.setText(adCloseView3.q);
                }
            }
        };
        this.D = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.n == null) {
                    return;
                }
                AdCloseView adCloseView = this.a;
                if (adCloseView.b == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.a.n.a));
                this.a.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i3 = this.a.A;
                if (i3 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i3 == 2 || i3 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i3 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.a.n.h);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.E = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.a.c) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.a.c = null;
            }
        };
        this.F = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.o();
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    this.a.p();
                }
            }
        };
        this.a = context;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.l = R.drawable.icon_pure_card_close22;
        this.m = null;
        this.n = null;
        this.p = new ArrayList();
        this.y = 0L;
        this.z = false;
        this.B = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.a.y > 500) {
                        this.a.r();
                        this.a.y = currentTimeMillis;
                    }
                    if (this.a.n != null) {
                        ez0.b(new ClogBuilder().t(String.valueOf(105)).r(this.a.n.k).h("dislike").n(this.a.n.h));
                    }
                }
            }
        };
        this.C = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int n = this.a.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.a;
                        adCloseView.e.setText(adCloseView.a.getResources().getString(R.string.obfuscated_res_0x7f0f0421));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a4));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.a.a.getString(R.string.obfuscated_res_0x7f0f00a3));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.a.g.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.a;
                    adCloseView2.e.setText(adCloseView2.a.getResources().getString(R.string.obfuscated_res_0x7f0f00b3));
                    AdCloseView adCloseView3 = this.a;
                    adCloseView3.g.setText(adCloseView3.q);
                }
            }
        };
        this.D = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.n == null) {
                    return;
                }
                AdCloseView adCloseView = this.a;
                if (adCloseView.b == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.a.n.a));
                this.a.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i32 = this.a.A;
                if (i32 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i32 == 2 || i32 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i32 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.a.n.h);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.E = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.a.c) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.a.c = null;
            }
        };
        this.F = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.o();
                }
            }
        };
        this.G = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdCloseView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    this.a.p();
                }
            }
        };
        this.a = context;
        q();
    }
}
