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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f<PaymentConfirmActivity> {
    private ViewGroup Ye;
    private ViewGroup Yt;
    private ViewGroup cHA;
    private TbImageView cHB;
    private TextView cHC;
    private TextView cHD;
    private ViewGroup cHE;
    private EditText cHF;
    private ViewGroup cHG;
    private TextView cHH;
    private TextView cHI;
    private PaymentConfirmActivity cHq;
    private ViewGroup cHr;
    private TbImageView cHs;
    private TextView cHt;
    private TextView cHu;
    private TextView cHv;
    private TextView cHw;
    private TextView cHx;
    private TextView cHy;
    private CheckBox cHz;
    private NavigationBar mNavigationBar;

    public s(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.cHq = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(t.h.payment_confirm_activity);
        j(paymentConfirmActivity);
        k(paymentConfirmActivity);
    }

    private void j(PaymentConfirmActivity paymentConfirmActivity) {
        this.Ye = (ViewGroup) this.cHq.findViewById(t.g.payment_root);
        this.mNavigationBar = (NavigationBar) this.cHq.findViewById(t.g.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.cHq.getPageContext().getString(t.j.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void k(PaymentConfirmActivity paymentConfirmActivity) {
        this.Yt = (ViewGroup) paymentConfirmActivity.findViewById(t.g.payment_view_content);
        this.cHr = (ViewGroup) paymentConfirmActivity.findViewById(t.g.payment_view_operate);
        this.cHs = (TbImageView) paymentConfirmActivity.findViewById(t.g.payment_goods_pic);
        this.cHt = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_name);
        this.cHu = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_num);
        this.cHv = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_timelength);
        this.cHw = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_price);
        this.cHx = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_name_tip);
        this.cHy = (TextView) paymentConfirmActivity.findViewById(t.g.payment_goods_price_tip);
        this.cHz = (CheckBox) paymentConfirmActivity.findViewById(t.g.payment_page_show);
        this.cHA = (ViewGroup) paymentConfirmActivity.findViewById(t.g.payment_member_show);
        this.cHB = (TbImageView) paymentConfirmActivity.findViewById(t.g.payment_member_icon);
        this.cHC = (TextView) paymentConfirmActivity.findViewById(t.g.payment_member_desc);
        this.cHD = (TextView) paymentConfirmActivity.findViewById(t.g.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.cHr.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.cHs.d(goods_info.getGoods_pic(), 10, false);
                this.cHt.setText(goods_info.getGoods_name());
                String y = aw.y(goods_info.getGoods_num());
                this.cHu.setText(i(String.valueOf(this.cHq.getResources().getString(t.j.payment_confirm_goods_num, y)) + goods_info.getGoods_unit(), y, ar.getColor(t.d.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String y2 = aw.y(goods_duration);
                    this.cHv.setText(i(this.cHq.getResources().getString(t.j.payment_confirm_goods_timelength, y2), y2, ar.getColor(t.d.cp_link_tip_d)));
                } else {
                    this.cHv.setText(a(this.cHq.getResources().getString(t.j.payment_confirm_goods_timelength_default), 3, 5, ar.getColor(t.d.cp_link_tip_d)));
                }
                this.cHw.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cHw.setText(aw.A(goods_info.getTdou_num()));
                this.cHx.setText(this.cHq.getResources().getString(t.j.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ar.b(this.cHy, t.d.cp_cont_b, 1);
                    this.cHy.setText(bl(goods_info.getTdou_num()));
                } else {
                    ar.b(this.cHy, t.d.cp_cont_h, 1);
                    this.cHy.setText(t.j.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.cHA.setVisibility(0);
                        this.cHB.d(icon, 10, false);
                        this.cHC.setText(desc);
                    } else {
                        this.cHA.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.cHz.setButtonDrawable(ar.getDrawable(t.f.payment_confirm_price_tip_check_button));
                    this.cHz.setVisibility(0);
                    this.cHz.setText(this.cHq.getResources().getString(t.j.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.cHz.setVisibility(8);
                }
            }
            if (z) {
                this.cHD.setText(t.j.payment_confirm_performance_exchange);
            } else {
                this.cHD.setText(t.j.payment_confirm_performance_purchase);
            }
        }
    }

    public void bk(long j) {
        ar.b(this.cHy, t.d.cp_cont_b, 1);
        this.cHy.setText(bl(j));
        this.cHD.setText(t.j.payment_confirm_performance_exchange);
    }

    private SpannableStringBuilder bl(long j) {
        String y = aw.y(j);
        String string = this.cHq.getResources().getString(t.j.payment_confirm_goods_price_tip, y);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(y);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(getPageContext().getPageActivity(), ar.cO(t.f.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, y.length() + indexOf + 1, 33);
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

    public ViewGroup aoh() {
        if (this.cHE == null) {
            this.cHE = (ViewGroup) LayoutInflater.from(this.cHq.getPageContext().getPageActivity()).inflate(t.h.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.i.a.a(this.cHq.getPageContext(), this.cHE);
            this.cHF = (EditText) this.cHE.findViewById(t.g.dialog_input);
            this.cHG = (ViewGroup) this.cHE.findViewById(t.g.password_tip_layout);
            this.cHH = (TextView) this.cHE.findViewById(t.g.password_input_tip);
            this.cHI = (TextView) this.cHE.findViewById(t.g.password_use_tip);
        }
        return this.cHE;
    }

    public void kG(int i) {
        if (this.cHG != null) {
            if (i == 5) {
                this.cHG.setVisibility(0);
                this.cHH.setText("");
                this.cHI.setText(t.j.payment_input_password_forget);
            } else if (i > 0) {
                this.cHG.setVisibility(0);
                this.cHH.setText(this.cHq.getResources().getString(t.j.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.cHI.setText(t.j.payment_input_password_forget);
            } else {
                this.cHG.setVisibility(0);
                this.cHH.setText(this.cHq.getResources().getString(t.j.payment_input_password_remainder_no_time));
                this.cHI.setText(t.j.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.cHF != null) {
            this.cHF.setText("");
        }
    }

    public void aoi() {
        if (this.cHE != null && this.cHE.getParent() != null) {
            ((ViewGroup) this.cHE.getParent()).removeAllViews();
        }
    }

    public ViewGroup Us() {
        return this.Yt;
    }

    public CheckBox aoj() {
        return this.cHz;
    }

    public TextView aok() {
        return this.cHD;
    }

    public void eY(boolean z) {
        this.cHD.setEnabled(z);
    }

    public TextView aol() {
        return this.cHI;
    }

    public String aom() {
        return this.cHF != null ? this.cHF.getText().toString() : "";
    }

    public void eZ(boolean z) {
        if (this.cHF != null) {
            this.cHF.setEnabled(z);
        }
    }

    public EditText aon() {
        return this.cHF;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cHq.getPageContext(), this.Ye);
        this.mNavigationBar.onChangeSkinType(this.cHq.getPageContext(), i);
    }
}
