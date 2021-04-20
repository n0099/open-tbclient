package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHFinanceProductItem extends BaseItemView {
    public static final float TAG_HEIGHT_DP = 24.0f;
    public static final int TAG_LIMIT = 3;
    public static final float TAG_MARGIN_DP = 5.0f;
    public static final float TAG_MAX_WIDTH_DP = 108.5f;
    public static final float TAG_PADDING_DP = 7.5f;

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f24345a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24346b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24347c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f24348d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f24349e;

    /* renamed from: f  reason: collision with root package name */
    public MaskTextView f24350f;

    /* renamed from: g  reason: collision with root package name */
    public MaskTextView f24351g;

    /* renamed from: h  reason: collision with root package name */
    public MaskTextView f24352h;
    public LinearLayout i;

    public CHFinanceProductItem(Context context) {
        super(context);
    }

    private void a(LinearLayout linearLayout, String str) {
        if (TextUtils.isEmpty(str)) {
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
        if (getData().icons != null && getData().icons.length > 0) {
            int i = 0;
            this.i.setVisibility(0);
            while (true) {
                if (i >= (3 >= getData().icons.length ? getData().icons.length : 3)) {
                    return;
                }
                a(this.i, getData().icons[i].name);
                i++;
            }
        } else {
            this.i.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_product_item"), this);
        this.f24345a = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_title"));
        this.f24346b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_rate"));
        this.f24347c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_percent"));
        this.f24348d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_desc"));
        this.f24349e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_date"));
        this.f24350f = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_date_unit"));
        this.f24351g = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_amount"));
        this.f24352h = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fp_amount_unit"));
        this.i = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_fp_tags"));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        this.f24345a.setMaskText(getData().name);
        this.f24346b.setMaskText(getData().value1);
        this.f24347c.setVisibility(TextUtils.isEmpty(getData().value1) ? 8 : 0);
        this.f24348d.setMaskText(getData().desc);
        this.f24349e.setMaskText(getData().value2);
        this.f24350f.setMaskText(getData().unit);
        this.f24351g.setMaskText(getData().value3);
        this.f24352h.setMaskText(getData().detail);
        addTags();
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        initView();
        refresh();
    }

    public CHFinanceProductItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
