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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f<PaymentConfirmActivity> {
    private ViewGroup Yg;
    private PaymentConfirmActivity cAK;
    private ViewGroup cAL;
    private TbImageView cAM;
    private TextView cAN;
    private TextView cAO;
    private TextView cAP;
    private TextView cAQ;
    private TextView cAR;
    private TextView cAS;
    private CheckBox cAT;
    private ViewGroup cAU;
    private TbImageView cAV;
    private TextView cAW;
    private TextView cAX;
    private ViewGroup cAY;
    private EditText cAZ;
    private ViewGroup cBa;
    private TextView cBb;
    private TextView cBc;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public s(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.cAK = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(n.h.payment_confirm_activity);
        j(paymentConfirmActivity);
        k(paymentConfirmActivity);
    }

    private void j(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.cAK.findViewById(n.g.payment_root);
        this.mNavigationBar = (NavigationBar) this.cAK.findViewById(n.g.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.cAK.getPageContext().getString(n.j.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void k(PaymentConfirmActivity paymentConfirmActivity) {
        this.Yg = (ViewGroup) paymentConfirmActivity.findViewById(n.g.payment_view_content);
        this.cAL = (ViewGroup) paymentConfirmActivity.findViewById(n.g.payment_view_operate);
        this.cAM = (TbImageView) paymentConfirmActivity.findViewById(n.g.payment_goods_pic);
        this.cAN = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_name);
        this.cAO = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_num);
        this.cAP = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_timelength);
        this.cAQ = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_price);
        this.cAR = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_name_tip);
        this.cAS = (TextView) paymentConfirmActivity.findViewById(n.g.payment_goods_price_tip);
        this.cAT = (CheckBox) paymentConfirmActivity.findViewById(n.g.payment_page_show);
        this.cAU = (ViewGroup) paymentConfirmActivity.findViewById(n.g.payment_member_show);
        this.cAV = (TbImageView) paymentConfirmActivity.findViewById(n.g.payment_member_icon);
        this.cAW = (TextView) paymentConfirmActivity.findViewById(n.g.payment_member_desc);
        this.cAX = (TextView) paymentConfirmActivity.findViewById(n.g.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.cAL.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.cAM.d(goods_info.getGoods_pic(), 10, false);
                this.cAN.setText(goods_info.getGoods_name());
                String x = ax.x(goods_info.getGoods_num());
                this.cAO.setText(i(String.valueOf(this.cAK.getResources().getString(n.j.payment_confirm_goods_num, x)) + goods_info.getGoods_unit(), x, as.getColor(n.d.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String x2 = ax.x(goods_duration);
                    this.cAP.setText(i(this.cAK.getResources().getString(n.j.payment_confirm_goods_timelength, x2), x2, as.getColor(n.d.cp_link_tip_d)));
                } else {
                    this.cAP.setText(a(this.cAK.getResources().getString(n.j.payment_confirm_goods_timelength_default), 3, 5, as.getColor(n.d.cp_link_tip_d)));
                }
                this.cAQ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cAQ.setText(ax.z(goods_info.getTdou_num()));
                this.cAR.setText(this.cAK.getResources().getString(n.j.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    as.b(this.cAS, n.d.cp_cont_b, 1);
                    this.cAS.setText(bj(goods_info.getTdou_num()));
                } else {
                    as.b(this.cAS, n.d.cp_cont_h, 1);
                    this.cAS.setText(n.j.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.cAU.setVisibility(0);
                        this.cAV.d(icon, 10, false);
                        this.cAW.setText(desc);
                    } else {
                        this.cAU.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.cAT.setButtonDrawable(as.getDrawable(n.f.payment_confirm_price_tip_check_button));
                    this.cAT.setVisibility(0);
                    this.cAT.setText(this.cAK.getResources().getString(n.j.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.cAT.setVisibility(8);
                }
            }
            if (z) {
                this.cAX.setText(n.j.payment_confirm_performance_exchange);
            } else {
                this.cAX.setText(n.j.payment_confirm_performance_purchase);
            }
        }
    }

    public void bi(long j) {
        as.b(this.cAS, n.d.cp_cont_b, 1);
        this.cAS.setText(bj(j));
        this.cAX.setText(n.j.payment_confirm_performance_exchange);
    }

    private SpannableStringBuilder bj(long j) {
        String x = ax.x(j);
        String string = this.cAK.getResources().getString(n.j.payment_confirm_goods_price_tip, x);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(x);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(getPageContext().getPageActivity(), as.cx(n.f.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, x.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private SpannableString a(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    private SpannableString i(String str, String str2, int i) {
        int indexOf;
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || (indexOf = str.indexOf(str2)) < 0) ? new SpannableString(str) : a(str, indexOf, str2.length() + indexOf, i);
    }

    public ViewGroup akj() {
        if (this.cAY == null) {
            this.cAY = (ViewGroup) LayoutInflater.from(this.cAK.getPageContext().getPageActivity()).inflate(n.h.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.i.a.a(this.cAK.getPageContext(), this.cAY);
            this.cAZ = (EditText) this.cAY.findViewById(n.g.dialog_input);
            this.cBa = (ViewGroup) this.cAY.findViewById(n.g.password_tip_layout);
            this.cBb = (TextView) this.cAY.findViewById(n.g.password_input_tip);
            this.cBc = (TextView) this.cAY.findViewById(n.g.password_use_tip);
        }
        return this.cAY;
    }

    public void kg(int i) {
        if (this.cBa != null) {
            if (i == 5) {
                this.cBa.setVisibility(0);
                this.cBb.setText("");
                this.cBc.setText(n.j.payment_input_password_forget);
            } else if (i > 0) {
                this.cBa.setVisibility(0);
                this.cBb.setText(this.cAK.getResources().getString(n.j.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.cBc.setText(n.j.payment_input_password_forget);
            } else {
                this.cBa.setVisibility(0);
                this.cBb.setText(this.cAK.getResources().getString(n.j.payment_input_password_remainder_no_time));
                this.cBc.setText(n.j.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.cAZ != null) {
            this.cAZ.setText("");
        }
    }

    public void akk() {
        if (this.cAY != null && this.cAY.getParent() != null) {
            ((ViewGroup) this.cAY.getParent()).removeAllViews();
        }
    }

    public ViewGroup Sl() {
        return this.Yg;
    }

    public CheckBox akl() {
        return this.cAT;
    }

    public TextView akm() {
        return this.cAX;
    }

    public void eK(boolean z) {
        this.cAX.setEnabled(z);
    }

    public TextView akn() {
        return this.cBc;
    }

    public String ako() {
        return this.cAZ != null ? this.cAZ.getText().toString() : "";
    }

    public void eL(boolean z) {
        if (this.cAZ != null) {
            this.cAZ.setEnabled(z);
        }
    }

    public EditText akp() {
        return this.cAZ;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cAK.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cAK.getPageContext(), i);
    }
}
