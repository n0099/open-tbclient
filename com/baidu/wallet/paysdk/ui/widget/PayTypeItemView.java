package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.BorderTipTextView;
import com.baidu.wallet.base.widget.LinkNoScrollMovementMethod;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PayTypeItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f26909a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26910b;

    /* renamed from: c  reason: collision with root package name */
    public BorderTipTextView f26911c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26912d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f26913e;
    public Context mContext;
    public PayTypeItemViewData mData;
    public ProgressBar mProgress;

    /* loaded from: classes5.dex */
    public enum ItemViewType implements Serializable {
        BANKCARD,
        BALANCE,
        CREDIT,
        ADD_NEWCARD
    }

    /* loaded from: classes5.dex */
    public static class PayTypeItemViewData implements Serializable {
        public static final String MASK_FLAG = "^";
        public CardData.BondCard card;
        public boolean highlight;
        public String hintMsg;
        public String hintUrl;
        public boolean isAvaible;
        public boolean isChecked;
        public boolean isRecommended;
        public String jump_url;
        public String logoUrl;
        public String name;
        public String tips;
        public ItemViewType type;

        public int getEndIndex(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.lastIndexOf(MASK_FLAG);
        }

        public int getStartIndex(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.indexOf(MASK_FLAG);
        }

        public boolean isNeedToColored() {
            int startIndex = getStartIndex(this.tips);
            int endIndex = getEndIndex(this.tips);
            return (-1 == startIndex || -1 == endIndex || startIndex >= endIndex) ? false : true;
        }

        public String removeSeparator(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int startIndex = getStartIndex(str);
            int endIndex = getEndIndex(str);
            if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
                return str;
            }
            return str.substring(0, startIndex) + str.substring(startIndex + 1, endIndex) + str.substring(endIndex + 1);
        }
    }

    public PayTypeItemView(Context context) {
        super(context.getApplicationContext());
        this.mContext = context.getApplicationContext();
    }

    private void a(PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        boolean z;
        this.mData = payTypeItemViewData;
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_paytype_item_view"), this);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
        this.mProgress = progressBar;
        progressBar.setVisibility(8);
        this.f26913e = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "paytype_select"));
        this.f26909a = (NetImageView) findViewById(ResUtils.id(this.mContext, "ebpay_paytype_logo"));
        this.f26910b = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_name"));
        if (!TextUtils.isEmpty(payTypeItemViewData.name)) {
            this.f26910b.setText(payTypeItemViewData.name);
        }
        TextView textView = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
        if (ItemViewType.BANKCARD == payTypeItemViewData.type) {
            CardData.BondCard bondCard = payTypeItemViewData.card;
            z = (bondCard == null || TextUtils.isEmpty(bondCard.channelDiscountDesc)) ? false : true;
            if (z) {
                textView.setVisibility(0);
                textView.setText(payTypeItemViewData.card.channelDiscountDesc);
            }
        } else {
            z = false;
        }
        inflate.findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(payTypeItemViewData.isRecommended ? 0 : 4);
        this.f26911c = (BorderTipTextView) findViewById(ResUtils.id(this.mContext, "paytype_tip"));
        if (!TextUtils.isEmpty(payTypeItemViewData.tips) && (!z || !payTypeItemViewData.tips.equals(textView.getText()))) {
            this.f26911c.setVisibility(0);
            if (payTypeItemViewData.isNeedToColored()) {
                a(payTypeItemViewData, onClickListener);
            } else {
                this.f26911c.setText(payTypeItemViewData.tips, payTypeItemViewData.highlight);
            }
        } else {
            this.f26911c.setVisibility(8);
        }
        this.f26912d = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_hint"));
        if (!TextUtils.isEmpty(payTypeItemViewData.hintMsg)) {
            this.f26912d.setVisibility(0);
            this.f26912d.setText(payTypeItemViewData.hintMsg);
            LinearLayout linearLayout = (LinearLayout) this.f26912d.getParent();
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), 0);
            if (onClickListener2 != null) {
                this.f26912d.setOnClickListener(onClickListener2);
            }
        } else {
            this.f26912d.setVisibility(8);
        }
        ItemViewType itemViewType = payTypeItemViewData.type;
        if (itemViewType == ItemViewType.ADD_NEWCARD) {
            this.f26913e.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_item_right_arrow"));
            this.f26913e.setVisibility(0);
            this.f26909a.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_add_newcard"));
            this.f26911c.setVisibility(8);
        } else if (itemViewType == ItemViewType.BALANCE) {
            this.f26909a.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_balance"));
        } else if (itemViewType == ItemViewType.CREDIT) {
            this.f26909a.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_credit"));
        } else if (itemViewType == ItemViewType.BANKCARD && !TextUtils.isEmpty(payTypeItemViewData.logoUrl)) {
            this.f26909a.setImageUrl(payTypeItemViewData.logoUrl);
        }
        if (payTypeItemViewData.isAvaible) {
            ViewHelper.setAlpha(inflate, 1.0f);
            if (payTypeItemViewData.type == ItemViewType.ADD_NEWCARD) {
                this.f26913e.setVisibility(0);
                return;
            } else if (payTypeItemViewData.isChecked) {
                this.f26913e.setVisibility(0);
                this.f26913e.setSelected(true);
                return;
            } else {
                this.f26913e.setSelected(false);
                this.f26913e.setVisibility(4);
                return;
            }
        }
        ViewHelper.setAlphaPartly(inflate, 0.4f, this.f26911c);
        if (payTypeItemViewData.isNeedToColored()) {
            inflate.setEnabled(false);
        } else {
            inflate.setEnabled(true);
        }
        this.f26913e.setVisibility(8);
    }

    public static PayTypeItemView generateItemView(Context context, PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (context == null) {
            return null;
        }
        PayTypeItemView payTypeItemView = new PayTypeItemView(context);
        payTypeItemView.a(payTypeItemViewData, onClickListener, onClickListener2);
        return payTypeItemView;
    }

    public void setItemState(boolean z) {
        this.f26913e.setVisibility(8);
        if (z) {
            this.mProgress.setVisibility(0);
        } else {
            this.mProgress.setVisibility(8);
        }
    }

    private void a(PayTypeItemViewData payTypeItemViewData, final View.OnClickListener onClickListener) {
        if (payTypeItemViewData == null || TextUtils.isEmpty(payTypeItemViewData.tips) || !payTypeItemViewData.isNeedToColored()) {
            return;
        }
        int startIndex = payTypeItemViewData.getStartIndex(payTypeItemViewData.tips);
        int endIndex = payTypeItemViewData.getEndIndex(payTypeItemViewData.tips);
        SpannableString spannableString = new SpannableString(payTypeItemViewData.removeSeparator(payTypeItemViewData.tips));
        int i2 = endIndex - 1;
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                onClickListener.onClick(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, startIndex, i2, 18);
        spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.mContext, "wallet_base_mainColor")), startIndex, i2, 18);
        if (!TextUtils.isEmpty(payTypeItemViewData.jump_url)) {
            this.f26911c.setClickable(true);
            this.f26911c.setEnabled(true);
        } else {
            this.f26911c.setClickable(false);
            this.f26911c.setEnabled(false);
        }
        this.f26911c.setMovementMethod(new LinkNoScrollMovementMethod());
        this.f26911c.setText(spannableString);
    }
}
