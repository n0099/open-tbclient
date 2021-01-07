package com.baidu.tieba.payment;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.d<PaymentConfirmActivity> {
    private TextView lDA;
    private TextView lDB;
    private TextView lDC;
    private TextView lDD;
    private TextView lDE;
    private TextView lDF;
    private CheckBox lDG;
    private ViewGroup lDH;
    private TbImageView lDI;
    private TextView lDJ;
    private TextView lDK;
    private ViewGroup lDL;
    private EditText lDM;
    private ViewGroup lDN;
    private TextView lDO;
    private TextView lDP;
    private boolean lDQ;
    private PaymentConfirmActivity lDx;
    private ViewGroup lDy;
    private TbImageView lDz;
    private ViewGroup mContentView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.lDQ = false;
        this.lDx = paymentConfirmActivity;
        this.lDQ = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        o(paymentConfirmActivity);
        p(paymentConfirmActivity);
    }

    private void o(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.lDx.findViewById(R.id.payment_root);
        this.mNavigationBar = (NavigationBar) this.lDx.findViewById(R.id.payment_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.lDQ) {
            this.mNavigationBar.setTitleText(this.lDx.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.mNavigationBar.setTitleText(this.lDx.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    private void p(PaymentConfirmActivity paymentConfirmActivity) {
        this.mContentView = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.lDy = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.lDz = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.lDA = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.lDB = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.lDC = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.lDD = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.lDE = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.lDF = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.lDG = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.lDH = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.lDI = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.lDJ = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.lDK = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.lDy.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.lDz.startLoad(goods_info.getGoods_pic(), 10, false);
                this.lDA.setText(goods_info.getGoods_name());
                String numFormatOver10000 = at.numFormatOver10000(goods_info.getGoods_num());
                this.lDB.setText(v(this.lDx.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, ao.getColor(R.color.CAM_X0305)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String numFormatOver100002 = at.numFormatOver10000(goods_duration);
                    this.lDC.setText(v(this.lDx.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, ao.getColor(R.color.CAM_X0305)));
                } else {
                    this.lDC.setText(e(this.lDx.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, ao.getColor(R.color.CAM_X0305)));
                }
                this.lDD.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.lDD.setText(at.numFormatOver10000wan(goods_info.getTdou_num()));
                this.lDE.setText(this.lDx.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ao.setViewTextColor(this.lDF, R.color.CAM_X0105, 1);
                    this.lDF.setText(hl(goods_info.getTdou_num()));
                } else {
                    ao.setViewTextColor(this.lDF, R.color.CAM_X0301, 1);
                    this.lDF.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.lDH.setVisibility(0);
                        this.lDI.startLoad(icon, 10, false);
                        this.lDJ.setText(desc);
                    } else {
                        this.lDH.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.lDG.setButtonDrawable(ao.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                    this.lDG.setVisibility(0);
                    this.lDG.setText(this.lDx.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.lDG.setVisibility(8);
                }
            }
            if (z) {
                if (this.lDQ) {
                    this.lDK.setText(R.string.buy_now);
                    return;
                } else {
                    this.lDK.setText(R.string.goto_exchange);
                    return;
                }
            }
            this.lDK.setText(R.string.get_tdou);
        }
    }

    public void hk(long j) {
        ao.setViewTextColor(this.lDF, R.color.CAM_X0105, 1);
        this.lDF.setText(hl(j));
        this.lDK.setText(R.string.goto_exchange);
    }

    private SpannableStringBuilder hl(long j) {
        String str = "" + j;
        String Pt = Pt(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Pt);
        int indexOf = Pt.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(getPageContext().getPageActivity(), ao.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, str.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private String Pt(String str) {
        return this.lDQ ? this.lDx.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.lDx.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
    }

    private SpannableString e(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    private SpannableString v(String str, String str2, int i) {
        int indexOf;
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || (indexOf = str.indexOf(str2)) < 0) ? new SpannableString(str) : e(str, indexOf, str2.length() + indexOf, i);
    }

    public ViewGroup dmi() {
        if (this.lDL == null) {
            this.lDL = (ViewGroup) LayoutInflater.from(this.lDx.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.r.a.a(this.lDx.getPageContext(), this.lDL);
            this.lDM = (EditText) this.lDL.findViewById(R.id.dialog_input);
            this.lDN = (ViewGroup) this.lDL.findViewById(R.id.password_tip_layout);
            this.lDO = (TextView) this.lDL.findViewById(R.id.password_input_tip);
            this.lDP = (TextView) this.lDL.findViewById(R.id.password_use_tip);
        }
        return this.lDL;
    }

    public void GC(int i) {
        if (this.lDN != null) {
            if (i == 5) {
                this.lDN.setVisibility(0);
                this.lDO.setText("");
                this.lDP.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                this.lDN.setVisibility(0);
                this.lDO.setText(this.lDx.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.lDP.setText(R.string.payment_input_password_forget);
            } else {
                this.lDN.setVisibility(0);
                this.lDO.setText(this.lDx.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.lDP.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void bMt() {
        if (this.lDM != null) {
            this.lDM.setText("");
        }
    }

    public void dmj() {
        if (this.lDL != null && this.lDL.getParent() != null) {
            ((ViewGroup) this.lDL.getParent()).removeAllViews();
        }
    }

    public ViewGroup getContentView() {
        return this.mContentView;
    }

    public CheckBox dmk() {
        return this.lDG;
    }

    public TextView dml() {
        return this.lDK;
    }

    public void ur(boolean z) {
        this.lDK.setEnabled(z);
    }

    public TextView dmm() {
        return this.lDP;
    }

    public String dmn() {
        return this.lDM != null ? this.lDM.getText().toString() : "";
    }

    public void us(boolean z) {
        if (this.lDM != null) {
            this.lDM.setEnabled(z);
        }
    }

    public EditText dmo() {
        return this.lDM;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lDx.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lDx.getPageContext(), i);
    }
}
