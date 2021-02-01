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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.d<PaymentConfirmActivity> {
    private PaymentConfirmActivity lHF;
    private ViewGroup lHG;
    private TbImageView lHH;
    private TextView lHI;
    private TextView lHJ;
    private TextView lHK;
    private TextView lHL;
    private TextView lHM;
    private TextView lHN;
    private CheckBox lHO;
    private ViewGroup lHP;
    private TbImageView lHQ;
    private TextView lHR;
    private TextView lHS;
    private ViewGroup lHT;
    private EditText lHU;
    private ViewGroup lHV;
    private TextView lHW;
    private TextView lHX;
    private boolean lHY;
    private ViewGroup mContentView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.lHY = false;
        this.lHF = paymentConfirmActivity;
        this.lHY = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        o(paymentConfirmActivity);
        p(paymentConfirmActivity);
    }

    private void o(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.lHF.findViewById(R.id.payment_root);
        this.mNavigationBar = (NavigationBar) this.lHF.findViewById(R.id.payment_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.lHY) {
            this.mNavigationBar.setTitleText(this.lHF.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.mNavigationBar.setTitleText(this.lHF.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    private void p(PaymentConfirmActivity paymentConfirmActivity) {
        this.mContentView = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.lHG = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.lHH = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.lHI = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.lHJ = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.lHK = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.lHL = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.lHM = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.lHN = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.lHO = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.lHP = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.lHQ = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.lHR = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.lHS = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.lHG.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.lHH.startLoad(goods_info.getGoods_pic(), 10, false);
                this.lHI.setText(goods_info.getGoods_name());
                String numFormatOver10000 = au.numFormatOver10000(goods_info.getGoods_num());
                this.lHJ.setText(v(this.lHF.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, ap.getColor(R.color.CAM_X0305)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String numFormatOver100002 = au.numFormatOver10000(goods_duration);
                    this.lHK.setText(v(this.lHF.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, ap.getColor(R.color.CAM_X0305)));
                } else {
                    this.lHK.setText(e(this.lHF.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, ap.getColor(R.color.CAM_X0305)));
                }
                this.lHL.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.lHL.setText(au.numFormatOver10000wan(goods_info.getTdou_num()));
                this.lHM.setText(this.lHF.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ap.setViewTextColor(this.lHN, R.color.CAM_X0105, 1);
                    this.lHN.setText(hq(goods_info.getTdou_num()));
                } else {
                    ap.setViewTextColor(this.lHN, R.color.CAM_X0301, 1);
                    this.lHN.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.lHP.setVisibility(0);
                        this.lHQ.startLoad(icon, 10, false);
                        this.lHR.setText(desc);
                    } else {
                        this.lHP.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.lHO.setButtonDrawable(ap.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                    this.lHO.setVisibility(0);
                    this.lHO.setText(this.lHF.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.lHO.setVisibility(8);
                }
            }
            if (z) {
                if (this.lHY) {
                    this.lHS.setText(R.string.buy_now);
                    return;
                } else {
                    this.lHS.setText(R.string.goto_exchange);
                    return;
                }
            }
            this.lHS.setText(R.string.get_tdou);
        }
    }

    public void hp(long j) {
        ap.setViewTextColor(this.lHN, R.color.CAM_X0105, 1);
        this.lHN.setText(hq(j));
        this.lHS.setText(R.string.goto_exchange);
    }

    private SpannableStringBuilder hq(long j) {
        String str = "" + j;
        String Pd = Pd(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Pd);
        int indexOf = Pd.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(getPageContext().getPageActivity(), ap.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, str.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private String Pd(String str) {
        return this.lHY ? this.lHF.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.lHF.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
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

    public ViewGroup dkC() {
        if (this.lHT == null) {
            this.lHT = (ViewGroup) LayoutInflater.from(this.lHF.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.r.a.a(this.lHF.getPageContext(), this.lHT);
            this.lHU = (EditText) this.lHT.findViewById(R.id.dialog_input);
            this.lHV = (ViewGroup) this.lHT.findViewById(R.id.password_tip_layout);
            this.lHW = (TextView) this.lHT.findViewById(R.id.password_input_tip);
            this.lHX = (TextView) this.lHT.findViewById(R.id.password_use_tip);
        }
        return this.lHT;
    }

    public void Fp(int i) {
        if (this.lHV != null) {
            if (i == 5) {
                this.lHV.setVisibility(0);
                this.lHW.setText("");
                this.lHX.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                this.lHV.setVisibility(0);
                this.lHW.setText(this.lHF.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.lHX.setText(R.string.payment_input_password_forget);
            } else {
                this.lHV.setVisibility(0);
                this.lHW.setText(this.lHF.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.lHX.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void bIU() {
        if (this.lHU != null) {
            this.lHU.setText("");
        }
    }

    public void dkD() {
        if (this.lHT != null && this.lHT.getParent() != null) {
            ((ViewGroup) this.lHT.getParent()).removeAllViews();
        }
    }

    public ViewGroup getContentView() {
        return this.mContentView;
    }

    public CheckBox dkE() {
        return this.lHO;
    }

    public TextView dkF() {
        return this.lHS;
    }

    public void uA(boolean z) {
        this.lHS.setEnabled(z);
    }

    public TextView dkG() {
        return this.lHX;
    }

    public String dkH() {
        return this.lHU != null ? this.lHU.getText().toString() : "";
    }

    public void uB(boolean z) {
        if (this.lHU != null) {
            this.lHU.setEnabled(z);
        }
    }

    public EditText dkI() {
        return this.lHU;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lHF.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lHF.getPageContext(), i);
    }
}
