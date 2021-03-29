package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.BorderTipTextView;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SelectBindCardLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f26426a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26427b;

    /* renamed from: c  reason: collision with root package name */
    public b f26428c;

    /* loaded from: classes5.dex */
    public class BindCardItemView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public NetImageView f26435b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26436c;

        /* renamed from: d  reason: collision with root package name */
        public BorderTipTextView f26437d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f26438e;

        public BindCardItemView(Context context) {
            super(context);
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_select_bindcard_list_item_view"), this);
            this.f26435b = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"));
            this.f26436c = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_name"));
            this.f26437d = (BorderTipTextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_tip"));
            ProgressBar progressBar = (ProgressBar) findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
            this.f26438e = progressBar;
            progressBar.setVisibility(8);
        }

        public void setData(CardData.BondCard bondCard) {
            this.f26435b.setImageUrl(bondCard.bank_url);
            findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(bondCard != null && "1".equals(bondCard.is_recommended) ? 0 : 4);
            this.f26436c.setText(bondCard.getCardDesc(getContext(), true));
            if (SelectBindCardLayout.this.f26426a.mBindFrom != 4 && SelectBindCardLayout.this.f26426a.mBindFrom != 5) {
                if ("1".equals(bondCard.card_state) && !TextUtils.isEmpty(bondCard.channelDiscountDesc)) {
                    TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
                    textView.setVisibility(0);
                    textView.setText(bondCard.channelDiscountDesc);
                }
                if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                    this.f26437d.setVisibility(0);
                    this.f26437d.setText(bondCard.bank_card_msg);
                    this.f26437d.setVisibility(0);
                    return;
                }
                this.f26437d.setVisibility(8);
            } else if (!bondCard.getCanFindPWDBySms() && !TextUtils.isEmpty(bondCard.unsupport_find_pwd_msg)) {
                this.f26437d.setVisibility(0);
                this.f26437d.setText(bondCard.unsupport_find_pwd_msg);
            } else {
                this.f26437d.setVisibility(8);
            }
        }

        public void setProgressBarVisible(boolean z) {
            ProgressBar progressBar = this.f26438e;
            if (progressBar != null) {
                progressBar.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RelativeLayout {
        public a(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_select_bindcard_list_item_view"), this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "paytype_select"));
            imageView.setImageDrawable(ResUtils.getDrawable(context, "wallet_base_paytype_item_right_arrow"));
            imageView.setVisibility(0);
            ((NetImageView) findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"))).setImageDrawable(ResUtils.getDrawable(context, "wallet_base_paytype_add_newcard"));
            ((TextView) findViewById(ResUtils.id(getContext(), "paytype_tip"))).setVisibility(8);
            ((TextView) findViewById(ResUtils.id(getContext(), "paytype_name"))).setText(ResUtils.getString(getContext(), "wallet_bindcard_usenewcard_tip"));
            findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar")).setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void addNewCardClick();

        void enableCardClick(BindCardItemView bindCardItemView, CardData.BondCard bondCard);
    }

    public SelectBindCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdaptetr(CardData.BondCard[] bondCardArr, boolean z) {
        CardData.BondCard[] a2 = a(bondCardArr);
        this.f26427b = false;
        removeAllViews();
        if (a2 == null || a2.length <= 0) {
            return;
        }
        if (this.f26426a.mBindFrom == 2) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_title_left"), (ViewGroup) null);
            textView.setText(ResUtils.getString(getContext(), "wallet_bindcard_selectcard_tip"));
            int dimension = (int) ResUtils.getDimension(getContext(), "wallet_base_margin");
            textView.setPadding(dimension, (int) ResUtils.getDimension(getContext(), "wallet_base_margin"), dimension, 0);
            addView(textView);
        }
        ScrollView scrollView = new ScrollView(getContext());
        addView(scrollView);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout);
        for (int i = 0; i < a2.length; i++) {
            final CardData.BondCard bondCard = a2[i];
            if (a(bondCard)) {
                final BindCardItemView bindCardItemView = new BindCardItemView(getContext());
                bindCardItemView.setData(a2[i]);
                bindCardItemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SelectBindCardLayout.this.f26428c != null) {
                            SelectBindCardLayout.this.f26428c.enableCardClick(bindCardItemView, bondCard);
                        }
                    }
                });
                linearLayout.addView(bindCardItemView);
            } else {
                a(linearLayout, z);
                BindCardItemView bindCardItemView2 = new BindCardItemView(getContext());
                bindCardItemView2.setData(a2[i]);
                ViewHelper.setAlpha(bindCardItemView2, 0.4f);
                bindCardItemView2.setEnabled(false);
                bindCardItemView2.setClickable(false);
                linearLayout.addView(bindCardItemView2);
            }
        }
        a(linearLayout, z);
    }

    public void setBindCardItemClickListener(b bVar) {
        this.f26428c = bVar;
    }

    public void setBindFrom(int i) {
        this.f26426a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BindFastRequest.categoryToId(BindFastRequest.getCategory(i)));
    }

    private void a(ViewGroup viewGroup, final boolean z) {
        if (this.f26427b) {
            return;
        }
        a aVar = new a(getContext());
        aVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (!z) {
            ViewHelper.setAlpha(aVar, 0.4f);
        }
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    if (SelectBindCardLayout.this.f26428c != null) {
                        SelectBindCardLayout.this.f26428c.addNewCardClick();
                        return;
                    }
                    return;
                }
                GlobalUtils.toast(SelectBindCardLayout.this.getContext(), ResUtils.getString(SelectBindCardLayout.this.getContext(), "ebpay_bank_count_beyond"));
            }
        });
        viewGroup.addView(aVar);
        this.f26427b = true;
    }

    private CardData.BondCard[] a(CardData.BondCard[] bondCardArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (bondCardArr == null || bondCardArr.length <= 0) {
            return null;
        }
        for (CardData.BondCard bondCard : bondCardArr) {
            if (a(bondCard)) {
                arrayList.add(bondCard);
            } else {
                arrayList2.add(bondCard);
            }
        }
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        return (CardData.BondCard[]) arrayList3.toArray(new CardData.BondCard[arrayList3.size()]);
    }

    private boolean a(CardData.BondCard bondCard) {
        int i = this.f26426a.mBindFrom;
        if (i != 4 && i != 5) {
            if ("1".equals(bondCard.card_state)) {
                return true;
            }
        } else if (bondCard.getCanFindPWDBySms()) {
            return true;
        }
        return false;
    }
}
