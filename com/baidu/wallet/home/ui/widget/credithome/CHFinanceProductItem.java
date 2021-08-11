package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes8.dex */
public class CHFinanceProductItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float TAG_HEIGHT_DP = 24.0f;
    public static final int TAG_LIMIT = 3;
    public static final float TAG_MARGIN_DP = 5.0f;
    public static final float TAG_MAX_WIDTH_DP = 108.5f;
    public static final float TAG_PADDING_DP = 7.5f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f61009a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f61010b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f61011c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f61012d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f61013e;

    /* renamed from: f  reason: collision with root package name */
    public MaskTextView f61014f;

    /* renamed from: g  reason: collision with root package name */
    public MaskTextView f61015g;

    /* renamed from: h  reason: collision with root package name */
    public MaskTextView f61016h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f61017i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHFinanceProductItem(Context context) {
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
    }

    private void a(LinearLayout linearLayout, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, linearLayout, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = new TextView(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 7.5f);
        textView.setGravity(17);
        textView.setPadding(dip2px, 0, dip2px, 0);
        textView.setText(str);
        textView.setMaxLines(1);
        textView.setMaxWidth(DisplayUtils.dip2px(getContext(), 108.5f));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_extend_home_nh_separate_bright"));
        textView.setTextColor(ResUtils.getColor(getContext(), "wallet_home_nh_text13Color"));
        textView.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, DisplayUtils.dip2px(getContext(), 24.0f));
        layoutParams.setMargins(0, 0, DisplayUtils.dip2px(getContext(), 5.0f), 0);
        linearLayout.addView(textView, layoutParams);
    }

    public void addTags() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        if (getData().icons != null && getData().icons.length > 0) {
            int i2 = 0;
            this.f61017i.setVisibility(0);
            while (true) {
                if (i2 >= (3 >= getData().icons.length ? getData().icons.length : 3)) {
                    return;
                }
                a(this.f61017i, getData().icons[i2].name);
                i2++;
            }
        } else {
            this.f61017i.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_product_item"), this);
            this.f61009a = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_title"));
            this.f61010b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_rate"));
            this.f61011c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_percent"));
            this.f61012d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_desc"));
            this.f61013e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_date"));
            this.f61014f = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_date_unit"));
            this.f61015g = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_amount"));
            this.f61016h = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_amount_unit"));
            this.f61017i = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_fp_tags"));
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getData() == null) {
            return;
        }
        this.f61009a.setMaskText(getData().name);
        this.f61010b.setMaskText(getData().value1);
        this.f61011c.setVisibility(TextUtils.isEmpty(getData().value1) ? 8 : 0);
        this.f61012d.setMaskText(getData().desc);
        this.f61013e.setMaskText(getData().value2);
        this.f61014f.setMaskText(getData().unit);
        this.f61015g.setMaskText(getData().value3);
        this.f61016h.setMaskText(getData().detail);
        addTags();
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHFinanceProductItem(Context context, AttributeSet attributeSet) {
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
    }
}
