package com.baidu.tieba.payment;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f<PaymentConfirmActivity> {
    private ViewGroup WN;
    private PaymentConfirmActivity cef;
    private ViewGroup ceg;
    private TbImageView ceh;
    private TextView cei;
    private TextView cej;
    private TextView cek;
    private TextView cel;
    private TextView cem;
    private TextView cen;
    private CheckBox ceo;
    private ViewGroup cep;
    private TbImageView ceq;
    private TextView cer;
    private TextView ces;
    private ViewGroup cet;
    private EditText ceu;
    private ViewGroup cev;
    private TextView cew;
    private TextView cex;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public q(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.cef = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(i.g.payment_confirm_activity);
        g(paymentConfirmActivity);
        h(paymentConfirmActivity);
    }

    private void g(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.cef.findViewById(i.f.payment_root);
        this.mNavigationBar = (NavigationBar) this.cef.findViewById(i.f.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.cef.getPageContext().getString(i.h.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void h(PaymentConfirmActivity paymentConfirmActivity) {
        this.WN = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_content);
        this.ceg = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_operate);
        this.ceh = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_goods_pic);
        this.cei = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name);
        this.cej = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_num);
        this.cek = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_timelength);
        this.cel = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price);
        this.cem = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name_tip);
        this.cen = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price_tip);
        this.ceo = (CheckBox) paymentConfirmActivity.findViewById(i.f.payment_page_show);
        this.cep = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_member_show);
        this.ceq = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_member_icon);
        this.cer = (TextView) paymentConfirmActivity.findViewById(i.f.payment_member_desc);
        this.ces = (TextView) paymentConfirmActivity.findViewById(i.f.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.ceg.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.ceh.d(goods_info.getGoods_pic(), 10, false);
                this.cei.setText(goods_info.getGoods_name());
                String q = as.q(goods_info.getGoods_num());
                this.cej.setText(h(String.valueOf(this.cef.getResources().getString(i.h.payment_confirm_goods_num, q)) + goods_info.getGoods_unit(), q, an.getColor(i.c.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String q2 = as.q(goods_duration);
                    this.cek.setText(h(this.cef.getResources().getString(i.h.payment_confirm_goods_timelength, q2), q2, an.getColor(i.c.cp_link_tip_d)));
                } else {
                    this.cek.setText(a(this.cef.getResources().getString(i.h.payment_confirm_goods_timelength_default), 3, 5, an.getColor(i.c.cp_link_tip_d)));
                }
                this.cel.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cel.setText(as.r(goods_info.getTdou_num()));
                this.cem.setText(this.cef.getResources().getString(i.h.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    an.b(this.cen, i.c.cp_cont_b, 1);
                    this.cen.setText(aP(goods_info.getTdou_num()));
                } else {
                    an.b(this.cen, i.c.cp_cont_h, 1);
                    this.cen.setText(i.h.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.cep.setVisibility(0);
                        this.ceq.d(icon, 10, false);
                        this.cer.setText(desc);
                    } else {
                        this.cep.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.ceo.setButtonDrawable(an.getDrawable(i.e.payment_confirm_price_tip_check_button));
                    this.ceo.setVisibility(0);
                    this.ceo.setText(this.cef.getResources().getString(i.h.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.ceo.setVisibility(8);
                }
            }
            if (z) {
                this.ces.setText(i.h.payment_confirm_performance_exchange);
            } else {
                this.ces.setText(i.h.payment_confirm_performance_purchase);
            }
        }
    }

    private SpannableStringBuilder aP(long j) {
        String q = as.q(j);
        String string = this.cef.getResources().getString(i.h.payment_confirm_goods_price_tip, q);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(q);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(an.getColor(i.c.cp_link_tip_d));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(getPageContext().getPageActivity(), an.cw(i.e.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, q.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private SpannableString a(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    private SpannableString h(String str, String str2, int i) {
        int indexOf;
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || (indexOf = str.indexOf(str2)) < 0) ? new SpannableString(str) : a(str, indexOf, str2.length() + indexOf, i);
    }

    public ViewGroup aep() {
        if (this.cet == null) {
            this.cet = (ViewGroup) LayoutInflater.from(this.cef.getPageContext().getPageActivity()).inflate(i.g.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.h.a.a(this.cef.getPageContext(), this.cet);
            this.ceu = (EditText) this.cet.findViewById(i.f.dialog_input);
            this.cev = (ViewGroup) this.cet.findViewById(i.f.password_tip_layout);
            this.cew = (TextView) this.cet.findViewById(i.f.password_input_tip);
            this.cex = (TextView) this.cet.findViewById(i.f.password_use_tip);
        }
        return this.cet;
    }

    public void iE(int i) {
        if (this.cev != null) {
            if (i == 5) {
                this.cev.setVisibility(4);
            } else if (i > 0) {
                this.cev.setVisibility(0);
                this.cew.setText(this.cef.getResources().getString(i.h.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.cex.setText(i.h.payment_input_password_forget);
            } else {
                this.cev.setVisibility(0);
                this.cew.setText(this.cef.getResources().getString(i.h.payment_input_password_remainder_no_time));
                this.cex.setText(i.h.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.ceu != null) {
            this.ceu.setText("");
        }
    }

    public void aeq() {
        if (this.cet != null && this.cet.getParent() != null) {
            ((ViewGroup) this.cet.getParent()).removeAllViews();
        }
    }

    public ViewGroup aer() {
        return this.WN;
    }

    public CheckBox aes() {
        return this.ceo;
    }

    public TextView aet() {
        return this.ces;
    }

    public void eh(boolean z) {
        this.ces.setEnabled(z);
    }

    public TextView aeu() {
        return this.cex;
    }

    public String aev() {
        return this.ceu != null ? this.ceu.getText().toString() : "";
    }

    public void ei(boolean z) {
        if (this.ceu != null) {
            this.ceu.setEnabled(z);
        }
    }

    public EditText aew() {
        return this.ceu;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cef.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cef.getPageContext(), i);
    }
}
