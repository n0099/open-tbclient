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
    private ViewGroup WQ;
    private PaymentConfirmActivity ceG;
    private ViewGroup ceH;
    private TbImageView ceI;
    private TextView ceJ;
    private TextView ceK;
    private TextView ceL;
    private TextView ceM;
    private TextView ceN;
    private TextView ceO;
    private CheckBox ceP;
    private ViewGroup ceQ;
    private TbImageView ceR;
    private TextView ceS;
    private TextView ceT;
    private ViewGroup ceU;
    private EditText ceV;
    private ViewGroup ceW;
    private TextView ceX;
    private TextView ceY;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public q(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.ceG = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(i.g.payment_confirm_activity);
        g(paymentConfirmActivity);
        h(paymentConfirmActivity);
    }

    private void g(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.ceG.findViewById(i.f.payment_root);
        this.mNavigationBar = (NavigationBar) this.ceG.findViewById(i.f.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.ceG.getPageContext().getString(i.h.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void h(PaymentConfirmActivity paymentConfirmActivity) {
        this.WQ = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_content);
        this.ceH = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_view_operate);
        this.ceI = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_goods_pic);
        this.ceJ = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name);
        this.ceK = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_num);
        this.ceL = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_timelength);
        this.ceM = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price);
        this.ceN = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_name_tip);
        this.ceO = (TextView) paymentConfirmActivity.findViewById(i.f.payment_goods_price_tip);
        this.ceP = (CheckBox) paymentConfirmActivity.findViewById(i.f.payment_page_show);
        this.ceQ = (ViewGroup) paymentConfirmActivity.findViewById(i.f.payment_member_show);
        this.ceR = (TbImageView) paymentConfirmActivity.findViewById(i.f.payment_member_icon);
        this.ceS = (TextView) paymentConfirmActivity.findViewById(i.f.payment_member_desc);
        this.ceT = (TextView) paymentConfirmActivity.findViewById(i.f.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.ceH.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.ceI.d(goods_info.getGoods_pic(), 10, false);
                this.ceJ.setText(goods_info.getGoods_name());
                String q = as.q(goods_info.getGoods_num());
                this.ceK.setText(h(String.valueOf(this.ceG.getResources().getString(i.h.payment_confirm_goods_num, q)) + goods_info.getGoods_unit(), q, an.getColor(i.c.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String q2 = as.q(goods_duration);
                    this.ceL.setText(h(this.ceG.getResources().getString(i.h.payment_confirm_goods_timelength, q2), q2, an.getColor(i.c.cp_link_tip_d)));
                } else {
                    this.ceL.setText(a(this.ceG.getResources().getString(i.h.payment_confirm_goods_timelength_default), 3, 5, an.getColor(i.c.cp_link_tip_d)));
                }
                this.ceM.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.ceM.setText(as.r(goods_info.getTdou_num()));
                this.ceN.setText(this.ceG.getResources().getString(i.h.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    an.b(this.ceO, i.c.cp_cont_b, 1);
                    this.ceO.setText(aP(goods_info.getTdou_num()));
                } else {
                    an.b(this.ceO, i.c.cp_cont_h, 1);
                    this.ceO.setText(i.h.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.ceQ.setVisibility(0);
                        this.ceR.d(icon, 10, false);
                        this.ceS.setText(desc);
                    } else {
                        this.ceQ.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.ceP.setButtonDrawable(an.getDrawable(i.e.payment_confirm_price_tip_check_button));
                    this.ceP.setVisibility(0);
                    this.ceP.setText(this.ceG.getResources().getString(i.h.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.ceP.setVisibility(8);
                }
            }
            if (z) {
                this.ceT.setText(i.h.payment_confirm_performance_exchange);
            } else {
                this.ceT.setText(i.h.payment_confirm_performance_purchase);
            }
        }
    }

    private SpannableStringBuilder aP(long j) {
        String q = as.q(j);
        String string = this.ceG.getResources().getString(i.h.payment_confirm_goods_price_tip, q);
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

    public ViewGroup aeK() {
        if (this.ceU == null) {
            this.ceU = (ViewGroup) LayoutInflater.from(this.ceG.getPageContext().getPageActivity()).inflate(i.g.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.h.a.a(this.ceG.getPageContext(), this.ceU);
            this.ceV = (EditText) this.ceU.findViewById(i.f.dialog_input);
            this.ceW = (ViewGroup) this.ceU.findViewById(i.f.password_tip_layout);
            this.ceX = (TextView) this.ceU.findViewById(i.f.password_input_tip);
            this.ceY = (TextView) this.ceU.findViewById(i.f.password_use_tip);
        }
        return this.ceU;
    }

    public void iR(int i) {
        if (this.ceW != null) {
            if (i == 5) {
                this.ceW.setVisibility(4);
            } else if (i > 0) {
                this.ceW.setVisibility(0);
                this.ceX.setText(this.ceG.getResources().getString(i.h.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.ceY.setText(i.h.payment_input_password_forget);
            } else {
                this.ceW.setVisibility(0);
                this.ceX.setText(this.ceG.getResources().getString(i.h.payment_input_password_remainder_no_time));
                this.ceY.setText(i.h.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.ceV != null) {
            this.ceV.setText("");
        }
    }

    public void aeL() {
        if (this.ceU != null && this.ceU.getParent() != null) {
            ((ViewGroup) this.ceU.getParent()).removeAllViews();
        }
    }

    public ViewGroup aeM() {
        return this.WQ;
    }

    public CheckBox aeN() {
        return this.ceP;
    }

    public TextView aeO() {
        return this.ceT;
    }

    public void ej(boolean z) {
        this.ceT.setEnabled(z);
    }

    public TextView aeP() {
        return this.ceY;
    }

    public String aeQ() {
        return this.ceV != null ? this.ceV.getText().toString() : "";
    }

    public void ek(boolean z) {
        if (this.ceV != null) {
            this.ceV.setEnabled(z);
        }
    }

    public EditText aeR() {
        return this.ceV;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.ceG.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ceG.getPageContext(), i);
    }
}
