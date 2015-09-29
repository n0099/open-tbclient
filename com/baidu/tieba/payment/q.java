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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f<PaymentConfirmActivity> {
    private ViewGroup WL;
    private PaymentConfirmActivity cdU;
    private ViewGroup cdV;
    private TbImageView cdW;
    private TextView cdX;
    private TextView cdY;
    private TextView cdZ;
    private TextView cea;
    private TextView ceb;
    private TextView cec;
    private CheckBox ced;
    private ViewGroup cee;
    private TbImageView cef;
    private TextView ceg;
    private TextView ceh;
    private ViewGroup cei;
    private EditText cej;
    private ViewGroup cek;
    private TextView cel;
    private TextView cem;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public q(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.cdU = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(i.g.payment_confirm_activity);
        g(paymentConfirmActivity);
        h(paymentConfirmActivity);
    }

    private void g(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.cdU.findViewById(i.f.payment_root);
        this.mNavigationBar = (NavigationBar) this.cdU.findViewById(i.f.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.cdU.getPageContext().getString(i.h.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void h(PaymentConfirmActivity paymentConfirmActivity) {
        this.WL = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_content);
        this.cdV = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_operate);
        this.cdW = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_goods_pic);
        this.cdX = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name);
        this.cdY = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_num);
        this.cdZ = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_timelength);
        this.cea = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price);
        this.ceb = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name_tip);
        this.cec = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price_tip);
        this.ced = (CheckBox) paymentConfirmActivity.findViewById(i.f.payment_page_show);
        this.cee = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_member_show);
        this.cef = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_member_icon);
        this.ceg = (TextView) paymentConfirmActivity.findViewById(i.f.payment_member_desc);
        this.ceh = (TextView) paymentConfirmActivity.findViewById(i.f.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.cdV.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.cdW.d(goods_info.getGoods_pic(), 10, false);
                this.cdX.setText(goods_info.getGoods_name());
                String s = ar.s(goods_info.getGoods_num());
                this.cdY.setText(h(String.valueOf(this.cdU.getResources().getString(i.h.payment_confirm_goods_num, s)) + goods_info.getGoods_unit(), s, am.getColor(i.c.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String s2 = ar.s(goods_duration);
                    this.cdZ.setText(h(this.cdU.getResources().getString(i.h.payment_confirm_goods_timelength, s2), s2, am.getColor(i.c.cp_link_tip_d)));
                } else {
                    this.cdZ.setText(a(this.cdU.getResources().getString(i.h.payment_confirm_goods_timelength_default), 3, 5, am.getColor(i.c.cp_link_tip_d)));
                }
                this.cea.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cea.setText(ar.t(goods_info.getTdou_num()));
                this.ceb.setText(this.cdU.getResources().getString(i.h.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    am.b(this.cec, i.c.cp_cont_b, 1);
                    this.cec.setText(aH(goods_info.getTdou_num()));
                } else {
                    am.b(this.cec, i.c.cp_cont_h, 1);
                    this.cec.setText(i.h.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.cee.setVisibility(0);
                        this.cef.d(icon, 10, false);
                        this.ceg.setText(desc);
                    } else {
                        this.cee.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.ced.setButtonDrawable(am.getDrawable(i.e.payment_confirm_price_tip_check_button));
                    this.ced.setVisibility(0);
                    this.ced.setText(this.cdU.getResources().getString(i.h.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.ced.setVisibility(8);
                }
            }
            if (z) {
                this.ceh.setText(i.h.payment_confirm_performance_exchange);
            } else {
                this.ceh.setText(i.h.payment_confirm_performance_purchase);
            }
        }
    }

    private SpannableStringBuilder aH(long j) {
        String s = ar.s(j);
        String string = this.cdU.getResources().getString(i.h.payment_confirm_goods_price_tip, s);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(s);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(i.c.cp_link_tip_d));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(getPageContext().getPageActivity(), am.cw(i.e.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, s.length() + indexOf + 1, 33);
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

    public ViewGroup aet() {
        if (this.cei == null) {
            this.cei = (ViewGroup) LayoutInflater.from(this.cdU.getPageContext().getPageActivity()).inflate(i.g.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.h.a.a(this.cdU.getPageContext(), this.cei);
            this.cej = (EditText) this.cei.findViewById(i.f.dialog_input);
            this.cek = (ViewGroup) this.cei.findViewById(i.f.password_tip_layout);
            this.cel = (TextView) this.cei.findViewById(i.f.password_input_tip);
            this.cem = (TextView) this.cei.findViewById(i.f.password_use_tip);
        }
        return this.cei;
    }

    public void iE(int i) {
        if (this.cek != null) {
            if (i == 5) {
                this.cek.setVisibility(4);
            } else if (i > 0) {
                this.cek.setVisibility(0);
                this.cel.setText(this.cdU.getResources().getString(i.h.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.cem.setText(i.h.payment_input_password_forget);
            } else {
                this.cek.setVisibility(0);
                this.cel.setText(this.cdU.getResources().getString(i.h.payment_input_password_remainder_no_time));
                this.cem.setText(i.h.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.cej != null) {
            this.cej.setText("");
        }
    }

    public void aeu() {
        if (this.cei != null && this.cei.getParent() != null) {
            ((ViewGroup) this.cei.getParent()).removeAllViews();
        }
    }

    public ViewGroup aev() {
        return this.WL;
    }

    public CheckBox aew() {
        return this.ced;
    }

    public TextView aex() {
        return this.ceh;
    }

    public void eh(boolean z) {
        this.ceh.setEnabled(z);
    }

    public TextView aey() {
        return this.cem;
    }

    public String aez() {
        return this.cej != null ? this.cej.getText().toString() : "";
    }

    public void ei(boolean z) {
        if (this.cej != null) {
            this.cej.setEnabled(z);
        }
    }

    public EditText aeA() {
        return this.cej;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cdU.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cdU.getPageContext(), i);
    }
}
