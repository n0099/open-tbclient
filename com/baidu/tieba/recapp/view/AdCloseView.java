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
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.q0.s.g0.n.b;
import b.a.r0.q1.o.k.a;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes9.dex */
public class AdCloseView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_CLICK_ENABLE_DELAY = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public int closeImageResId;

    /* renamed from: e  reason: collision with root package name */
    public b f53627e;

    /* renamed from: f  reason: collision with root package name */
    public List<CheckBox> f53628f;

    /* renamed from: g  reason: collision with root package name */
    public AdvertAppInfo f53629g;

    /* renamed from: h  reason: collision with root package name */
    public ActionControl f53630h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f53631i;
    public String j;
    public String k;
    public View l;
    public RotateAnimation m;
    public EMTextView mAdShowReasonTextView;
    public ImageView mArrowRight;
    public int mBottomHeight;
    public PopupWindow mBottomWindow;
    public TBSpecificationBtn mCloseBtn;
    public ImageView mCloseImage;
    public Context mContext;
    public View.OnClickListener mOnPopupWindowClickListener;
    public PopupWindow mPopupWindow;
    public LinearLayout mReasonRootContainer;
    public TextView mTitleTextView;
    public RelativeLayout mTopLayout;
    public int mWindowHeight;
    public int mWindowWidth;
    public int mXOffset;
    public int mYOffset;
    public RotateAnimation n;
    public long o;
    public boolean p;
    public int q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public PopupWindow.OnDismissListener t;
    public final CustomMessageListener u;
    public View.OnClickListener v;

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
        this.mContext = null;
        this.mPopupWindow = null;
        this.mBottomWindow = null;
        this.closeImageResId = R.drawable.icon_pure_card_close22;
        this.f53628f = null;
        this.f53629g = null;
        this.f53631i = new ArrayList();
        this.o = 0L;
        this.p = false;
        this.mOnPopupWindowClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53632e;

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
                this.f53632e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f53632e.o > 500) {
                        this.f53632e.q();
                        this.f53632e.o = currentTimeMillis;
                    }
                }
            }
        };
        this.r = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53633e;

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
                this.f53633e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f53633e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f53633e;
                        adCloseView.mCloseBtn.setText(adCloseView.mContext.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f53633e.mTitleTextView.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f53633e;
                    adCloseView2.mCloseBtn.setText(adCloseView2.mContext.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f53633e;
                    adCloseView3.mTitleTextView.setText(adCloseView3.j);
                }
            }
        };
        this.s = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53634e;

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
                this.f53634e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f53634e.f53629g == null) {
                    return;
                }
                AdCloseView adCloseView = this.f53634e;
                if (adCloseView.mPopupWindow == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f53634e.f53629g.X3));
                this.f53634e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i4 = this.f53634e.q;
                if (i4 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i4 == 2 || i4 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i4 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f53634e.f53629g.e4);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.t = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53635e;

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
                this.f53635e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f53635e.mBottomWindow) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f53635e.mBottomWindow = null;
            }
        };
        this.u = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53636a;

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
                this.f53636a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f53636a.o();
                }
            }
        };
        this.v = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53637e;

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
                this.f53637e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f53637e.p();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
            this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
            this.mTopLayout = (RelativeLayout) inflate.findViewById(R.id.top_area);
            View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
            this.mAdShowReasonTextView = (EMTextView) inflate.findViewById(R.id.ad_show_reason);
            this.mArrowRight = (ImageView) inflate.findViewById(R.id.arrow_right);
            if (!TextUtils.isEmpty(this.j)) {
                this.mTitleTextView.setText(this.j);
            }
            this.mCloseBtn = (TBSpecificationBtn) inflate.findViewById(R.id.forbid_thread_btn);
            b bVar = new b();
            this.f53627e = bVar;
            bVar.r(R.color.CAM_X0304);
            this.mCloseBtn.setConfig(this.f53627e);
            if (!TextUtils.isEmpty(this.k)) {
                this.mCloseBtn.setText(this.k);
            } else {
                this.mCloseBtn.setText(this.mContext.getResources().getString(R.string.ad_no_interest));
            }
            this.mCloseBtn.setOnClickListener(this.s);
            if (m()) {
                this.mAdShowReasonTextView.setText(this.f53630h.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.v);
            }
            SkinManager.setViewTextColor(this.mTitleTextView, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.mAdShowReasonTextView, R.color.CAM_X0107, 1);
            this.mArrowRight.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.mReasonRootContainer = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
            this.f53628f = new ArrayList();
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.f53629g == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!a.e(this.f53628f)) {
                for (int i2 = 0; i2 < a.k(this.f53628f); i2++) {
                    CheckBox checkBox = (CheckBox) a.d(this.f53628f, i2);
                    if (checkBox != null && checkBox.isChecked() && a.k(this.f53631i) > i2) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) a.d(this.f53631i, i2));
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
            View view = this.l;
            if (view == null) {
                return 0;
            }
            try {
                view.measure(0, 0);
                return this.l.getMeasuredHeight();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.g(this.mContext, R.dimen.tbds72) : invokeV.intValue;
    }

    public int getCloseViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l.g(this.mContext, R.dimen.tbds72) : invokeV.intValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mCloseImage = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
            layoutParams.gravity = 21;
            addView(this.mCloseImage, layoutParams);
            this.mXOffset = l.g(this.mContext, R.dimen.M_W_X004);
            this.mYOffset = l.g(this.mContext, R.dimen.ds10);
            this.mWindowHeight = l.g(this.mContext, R.dimen.ds278);
            this.mWindowWidth = l.k(this.mContext) - (this.mXOffset * 2);
            this.mBottomHeight = l.g(this.mContext, R.dimen.ds120);
            setOnClickListener(this.mOnPopupWindowClickListener);
            this.mCloseImage.setImageDrawable(WebPManager.getPureDrawable(this.closeImageResId, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || a.e(this.f53631i)) {
            return;
        }
        int k = a.k(this.f53631i);
        this.mReasonRootContainer.setVisibility(0);
        int i2 = 0;
        for (int i3 = 0; i3 < Math.ceil(k / 2.0d); i3++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i3 != 0) {
                layoutParams.topMargin = l.g(this.mContext, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.mReasonRootContainer.addView(linearLayout);
            for (int i4 = 0; i4 < linearLayout.getChildCount() && (i2 = i2 + 1) <= k; i4++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                checkBox.setOnClickListener(this.r);
                checkBox.setVisibility(0);
                a.a(this.f53628f, checkBox);
            }
        }
        for (int i5 = 0; i5 < a.k(this.f53631i); i5++) {
            String str = (String) a.d(this.f53631i, i5);
            CheckBox checkBox2 = (CheckBox) a.d(this.f53628f, i5);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean l(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ActionControl actionControl = this.f53630h;
            return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.f53630h.name)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a.e(this.f53628f)) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < a.k(this.f53628f); i3++) {
                CheckBox checkBox = (CheckBox) a.d(this.f53628f, i3);
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.mPopupWindow = null;
            }
            PopupWindow popupWindow2 = this.mBottomWindow;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.mBottomWindow = null;
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mCloseImage.setImageDrawable(WebPManager.getPureDrawable(this.closeImageResId, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            o();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            if (this.p) {
                MessageManager.getInstance().unRegisterListener(this.u);
                this.p = false;
            }
            if (this.mBottomWindow != null) {
                PopupWindow popupWindow = this.mPopupWindow;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    this.mBottomWindow.dismiss();
                    this.mBottomWindow = null;
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && m()) {
            b.a.r0.r.a.l().c(getContext(), new String[]{this.f53630h.url}, null);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.mContext == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(j.a(getContext()), null)) {
            return;
        }
        o();
        View contentView = getContentView();
        k();
        this.l = contentView;
        this.mWindowHeight = getWindowMeasuredHeight();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.mContext, R.dimen.tbds31));
        this.l.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(contentView, this.mWindowWidth, this.mWindowHeight);
        this.mPopupWindow = popupWindow;
        popupWindow.setFocusable(true);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setOnDismissListener(this.t);
        if (Build.VERSION.SDK_INT >= 22) {
            this.mPopupWindow.setAttachedInDecor(false);
        }
        if (!this.p) {
            MessageManager.getInstance().registerListener(this.u);
            this.p = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.mBottomWindow = popupWindow2;
        popupWindow2.setFocusable(false);
        this.mBottomWindow.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.mBottomWindow.setAttachedInDecor(false);
        }
        this.mBottomWindow.showAtLocation(this, 0, 0, 0);
        int[] iArr = new int[2];
        boolean l = l(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.mBottomHeight, this.mYOffset, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (l) {
            this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.mPopupWindow.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
    }

    public void setData(AdvertAppInfo advertAppInfo, AdCloseInfo adCloseInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, adCloseInfo) == null) || advertAppInfo == null) {
            return;
        }
        this.f53629g = advertAppInfo;
        a.c(this.f53631i);
        if (adCloseInfo != null) {
            this.f53630h = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                a.a(this.f53631i, str);
            }
            String str2 = adCloseInfo.title;
            this.j = str2;
            if (TextUtils.isEmpty(str2)) {
                this.j = this.mContext.getString(R.string.tell_us_reason);
            }
            this.k = adCloseInfo.confirm_title;
        }
    }

    public void setPage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
            OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
            this.m.setInterpolator(overshootInterpolator);
            this.m.setDuration(250L);
            this.m.setFillAfter(true);
            RotateAnimation rotateAnimation = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.n = rotateAnimation;
            rotateAnimation.setInterpolator(overshootInterpolator);
            this.n.setDuration(250L);
            this.n.setFillAfter(true);
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
        this.mContext = null;
        this.mPopupWindow = null;
        this.mBottomWindow = null;
        this.closeImageResId = R.drawable.icon_pure_card_close22;
        this.f53628f = null;
        this.f53629g = null;
        this.f53631i = new ArrayList();
        this.o = 0L;
        this.p = false;
        this.mOnPopupWindowClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53632e;

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
                this.f53632e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f53632e.o > 500) {
                        this.f53632e.q();
                        this.f53632e.o = currentTimeMillis;
                    }
                }
            }
        };
        this.r = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53633e;

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
                this.f53633e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f53633e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f53633e;
                        adCloseView.mCloseBtn.setText(adCloseView.mContext.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f53633e.mTitleTextView.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f53633e;
                    adCloseView2.mCloseBtn.setText(adCloseView2.mContext.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f53633e;
                    adCloseView3.mTitleTextView.setText(adCloseView3.j);
                }
            }
        };
        this.s = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53634e;

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
                this.f53634e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f53634e.f53629g == null) {
                    return;
                }
                AdCloseView adCloseView = this.f53634e;
                if (adCloseView.mPopupWindow == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f53634e.f53629g.X3));
                this.f53634e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i4 = this.f53634e.q;
                if (i4 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i4 == 2 || i4 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i4 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f53634e.f53629g.e4);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.t = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53635e;

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
                this.f53635e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f53635e.mBottomWindow) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f53635e.mBottomWindow = null;
            }
        };
        this.u = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53636a;

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
                this.f53636a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f53636a.o();
                }
            }
        };
        this.v = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53637e;

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
                this.f53637e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f53637e.p();
                }
            }
        };
        this.mContext = context;
        init();
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
        this.mContext = null;
        this.mPopupWindow = null;
        this.mBottomWindow = null;
        this.closeImageResId = R.drawable.icon_pure_card_close22;
        this.f53628f = null;
        this.f53629g = null;
        this.f53631i = new ArrayList();
        this.o = 0L;
        this.p = false;
        this.mOnPopupWindowClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53632e;

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
                this.f53632e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f53632e.o > 500) {
                        this.f53632e.q();
                        this.f53632e.o = currentTimeMillis;
                    }
                }
            }
        };
        this.r = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53633e;

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
                this.f53633e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int n = this.f53633e.n();
                    if (n > 0) {
                        AdCloseView adCloseView = this.f53633e;
                        adCloseView.mCloseBtn.setText(adCloseView.mContext.getResources().getString(R.string.confirm));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_prefix));
                        int color = SkinManager.getColor(R.color.CAM_X0105);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) String.valueOf(n));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) this.f53633e.mContext.getString(R.string.ad_close_title_postfix));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                        this.f53633e.mTitleTextView.setText(spannableStringBuilder);
                        return;
                    }
                    AdCloseView adCloseView2 = this.f53633e;
                    adCloseView2.mCloseBtn.setText(adCloseView2.mContext.getResources().getString(R.string.ad_no_interest));
                    AdCloseView adCloseView3 = this.f53633e;
                    adCloseView3.mTitleTextView.setText(adCloseView3.j);
                }
            }
        };
        this.s = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53634e;

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
                this.f53634e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f53634e.f53629g == null) {
                    return;
                }
                AdCloseView adCloseView = this.f53634e;
                if (adCloseView.mPopupWindow == null) {
                    return;
                }
                String selectedResultJsonObj = adCloseView.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.f53634e.f53629g.X3));
                this.f53634e.o();
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                int i42 = this.f53634e.q;
                if (i42 == 1) {
                    httpMessage.addParam("pi", PlaceId.FRS.value);
                } else if (i42 == 2 || i42 == 3) {
                    httpMessage.addParam("pi", PlaceId.HOMEPAGE.value);
                } else if (i42 == 4) {
                    httpMessage.addParam("pi", PlaceId.PB_BANNER.value);
                }
                httpMessage.addParam("cr", selectedResultJsonObj);
                httpMessage.addParam("ext", this.f53634e.f53629g.e4);
                httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
            }
        };
        this.t = new PopupWindow.OnDismissListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53635e;

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
                this.f53635e = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupWindow popupWindow;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (popupWindow = this.f53635e.mBottomWindow) == null) {
                    return;
                }
                popupWindow.dismiss();
                this.f53635e.mBottomWindow = null;
            }
        };
        this.u = new CustomMessageListener(this, 2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53636a;

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
                this.f53636a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f53636a.o();
                }
            }
        };
        this.v = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdCloseView f53637e;

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
                this.f53637e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f53637e.p();
                }
            }
        };
        this.mContext = context;
        init();
    }
}
