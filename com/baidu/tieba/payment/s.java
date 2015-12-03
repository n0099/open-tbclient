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
    private ViewGroup XD;
    private PaymentConfirmActivity cxg;
    private ViewGroup cxh;
    private TbImageView cxi;
    private TextView cxj;
    private TextView cxk;
    private TextView cxl;
    private TextView cxm;
    private TextView cxn;
    private TextView cxo;
    private CheckBox cxp;
    private ViewGroup cxq;
    private TbImageView cxr;
    private TextView cxs;
    private TextView cxt;
    private ViewGroup cxu;
    private EditText cxv;
    private ViewGroup cxw;
    private TextView cxx;
    private TextView cxy;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public s(PaymentConfirmActivity paymentConfirmActivity) {
        super(paymentConfirmActivity.getPageContext());
        this.cxg = paymentConfirmActivity;
        paymentConfirmActivity.setContentView(n.g.payment_confirm_activity);
        j(paymentConfirmActivity);
        k(paymentConfirmActivity);
    }

    private void j(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.cxg.findViewById(n.f.payment_root);
        this.mNavigationBar = (NavigationBar) this.cxg.findViewById(n.f.payment_navigation_bar);
        this.mNavigationBar.setTitleText(this.cxg.getPageContext().getString(n.i.payment_confirm_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void k(PaymentConfirmActivity paymentConfirmActivity) {
        this.XD = (ViewGroup) paymentConfirmActivity.findViewById(n.f.payment_view_content);
        this.cxh = (ViewGroup) paymentConfirmActivity.findViewById(n.f.payment_view_operate);
        this.cxi = (TbImageView) paymentConfirmActivity.findViewById(n.f.payment_goods_pic);
        this.cxj = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_name);
        this.cxk = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_num);
        this.cxl = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_timelength);
        this.cxm = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_price);
        this.cxn = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_name_tip);
        this.cxo = (TextView) paymentConfirmActivity.findViewById(n.f.payment_goods_price_tip);
        this.cxp = (CheckBox) paymentConfirmActivity.findViewById(n.f.payment_page_show);
        this.cxq = (ViewGroup) paymentConfirmActivity.findViewById(n.f.payment_member_show);
        this.cxr = (TbImageView) paymentConfirmActivity.findViewById(n.f.payment_member_icon);
        this.cxs = (TextView) paymentConfirmActivity.findViewById(n.f.payment_member_desc);
        this.cxt = (TextView) paymentConfirmActivity.findViewById(n.f.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.cxh.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.cxi.d(goods_info.getGoods_pic(), 10, false);
                this.cxj.setText(goods_info.getGoods_name());
                String w = ax.w(goods_info.getGoods_num());
                this.cxk.setText(j(String.valueOf(this.cxg.getResources().getString(n.i.payment_confirm_goods_num, w)) + goods_info.getGoods_unit(), w, as.getColor(n.c.cp_link_tip_d)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String w2 = ax.w(goods_duration);
                    this.cxl.setText(j(this.cxg.getResources().getString(n.i.payment_confirm_goods_timelength, w2), w2, as.getColor(n.c.cp_link_tip_d)));
                } else {
                    this.cxl.setText(a(this.cxg.getResources().getString(n.i.payment_confirm_goods_timelength_default), 3, 5, as.getColor(n.c.cp_link_tip_d)));
                }
                this.cxm.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.cxm.setText(ax.y(goods_info.getTdou_num()));
                this.cxn.setText(this.cxg.getResources().getString(n.i.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    as.b(this.cxo, n.c.cp_cont_b, 1);
                    this.cxo.setText(be(goods_info.getTdou_num()));
                } else {
                    as.b(this.cxo, n.c.cp_cont_h, 1);
                    this.cxo.setText(n.i.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.cxq.setVisibility(0);
                        this.cxr.d(icon, 10, false);
                        this.cxs.setText(desc);
                    } else {
                        this.cxq.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.cxp.setButtonDrawable(as.getDrawable(n.e.payment_confirm_price_tip_check_button));
                    this.cxp.setVisibility(0);
                    this.cxp.setText(this.cxg.getResources().getString(n.i.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.cxp.setVisibility(8);
                }
            }
            if (z) {
                this.cxt.setText(n.i.payment_confirm_performance_exchange);
            } else {
                this.cxt.setText(n.i.payment_confirm_performance_purchase);
            }
        }
    }

    public void bd(long j) {
        as.b(this.cxo, n.c.cp_cont_b, 1);
        this.cxo.setText(be(j));
        this.cxt.setText(n.i.payment_confirm_performance_exchange);
    }

    private SpannableStringBuilder be(long j) {
        String w = ax.w(j);
        String string = this.cxg.getResources().getString(n.i.payment_confirm_goods_price_tip, w);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(w);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(getPageContext().getPageActivity(), as.cE(n.e.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, w.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private SpannableString a(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    private SpannableString j(String str, String str2, int i) {
        int indexOf;
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || (indexOf = str.indexOf(str2)) < 0) ? new SpannableString(str) : a(str, indexOf, str2.length() + indexOf, i);
    }

    public ViewGroup ajd() {
        if (this.cxu == null) {
            this.cxu = (ViewGroup) LayoutInflater.from(this.cxg.getPageContext().getPageActivity()).inflate(n.g.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.i.a.a(this.cxg.getPageContext(), this.cxu);
            this.cxv = (EditText) this.cxu.findViewById(n.f.dialog_input);
            this.cxw = (ViewGroup) this.cxu.findViewById(n.f.password_tip_layout);
            this.cxx = (TextView) this.cxu.findViewById(n.f.password_input_tip);
            this.cxy = (TextView) this.cxu.findViewById(n.f.password_use_tip);
        }
        return this.cxu;
    }

    public void jJ(int i) {
        if (this.cxw != null) {
            if (i == 5) {
                this.cxw.setVisibility(4);
            } else if (i > 0) {
                this.cxw.setVisibility(0);
                this.cxx.setText(this.cxg.getResources().getString(n.i.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.cxy.setText(n.i.payment_input_password_forget);
            } else {
                this.cxw.setVisibility(0);
                this.cxx.setText(this.cxg.getResources().getString(n.i.payment_input_password_remainder_no_time));
                this.cxy.setText(n.i.payment_input_password_find);
            }
        }
    }

    public void clearPassword() {
        if (this.cxv != null) {
            this.cxv.setText("");
        }
    }

    public void aje() {
        if (this.cxu != null && this.cxu.getParent() != null) {
            ((ViewGroup) this.cxu.getParent()).removeAllViews();
        }
    }

    public ViewGroup RT() {
        return this.XD;
    }

    public CheckBox ajf() {
        return this.cxp;
    }

    public TextView ajg() {
        return this.cxt;
    }

    public void eL(boolean z) {
        this.cxt.setEnabled(z);
    }

    public TextView ajh() {
        return this.cxy;
    }

    public String aji() {
        return this.cxv != null ? this.cxv.getText().toString() : "";
    }

    public void eM(boolean z) {
        if (this.cxv != null) {
            this.cxv.setEnabled(z);
        }
    }

    public EditText ajj() {
        return this.cxv;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.cxg.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cxg.getPageContext(), i);
    }
}
