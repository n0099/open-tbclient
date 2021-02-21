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
    private PaymentConfirmActivity lHT;
    private ViewGroup lHU;
    private TbImageView lHV;
    private TextView lHW;
    private TextView lHX;
    private TextView lHY;
    private TextView lHZ;
    private TextView lIa;
    private TextView lIb;
    private CheckBox lIc;
    private ViewGroup lId;
    private TbImageView lIe;
    private TextView lIf;
    private TextView lIg;
    private ViewGroup lIh;
    private EditText lIi;
    private ViewGroup lIj;
    private TextView lIk;
    private TextView lIl;
    private boolean lIm;
    private ViewGroup mContentView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.lIm = false;
        this.lHT = paymentConfirmActivity;
        this.lIm = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        o(paymentConfirmActivity);
        p(paymentConfirmActivity);
    }

    private void o(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.lHT.findViewById(R.id.payment_root);
        this.mNavigationBar = (NavigationBar) this.lHT.findViewById(R.id.payment_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.lIm) {
            this.mNavigationBar.setTitleText(this.lHT.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.mNavigationBar.setTitleText(this.lHT.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    private void p(PaymentConfirmActivity paymentConfirmActivity) {
        this.mContentView = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.lHU = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.lHV = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.lHW = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.lHX = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.lHY = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.lHZ = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.lIa = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.lIb = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.lIc = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.lId = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.lIe = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.lIf = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.lIg = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.lHU.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.lHV.startLoad(goods_info.getGoods_pic(), 10, false);
                this.lHW.setText(goods_info.getGoods_name());
                String numFormatOver10000 = au.numFormatOver10000(goods_info.getGoods_num());
                this.lHX.setText(v(this.lHT.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, ap.getColor(R.color.CAM_X0305)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String numFormatOver100002 = au.numFormatOver10000(goods_duration);
                    this.lHY.setText(v(this.lHT.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, ap.getColor(R.color.CAM_X0305)));
                } else {
                    this.lHY.setText(e(this.lHT.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, ap.getColor(R.color.CAM_X0305)));
                }
                this.lHZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.lHZ.setText(au.numFormatOver10000wan(goods_info.getTdou_num()));
                this.lIa.setText(this.lHT.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ap.setViewTextColor(this.lIb, R.color.CAM_X0105, 1);
                    this.lIb.setText(hq(goods_info.getTdou_num()));
                } else {
                    ap.setViewTextColor(this.lIb, R.color.CAM_X0301, 1);
                    this.lIb.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.lId.setVisibility(0);
                        this.lIe.startLoad(icon, 10, false);
                        this.lIf.setText(desc);
                    } else {
                        this.lId.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.lIc.setButtonDrawable(ap.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                    this.lIc.setVisibility(0);
                    this.lIc.setText(this.lHT.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.lIc.setVisibility(8);
                }
            }
            if (z) {
                if (this.lIm) {
                    this.lIg.setText(R.string.buy_now);
                    return;
                } else {
                    this.lIg.setText(R.string.goto_exchange);
                    return;
                }
            }
            this.lIg.setText(R.string.get_tdou);
        }
    }

    public void hp(long j) {
        ap.setViewTextColor(this.lIb, R.color.CAM_X0105, 1);
        this.lIb.setText(hq(j));
        this.lIg.setText(R.string.goto_exchange);
    }

    private SpannableStringBuilder hq(long j) {
        String str = "" + j;
        String Pe = Pe(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Pe);
        int indexOf = Pe.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(getPageContext().getPageActivity(), ap.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, str.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private String Pe(String str) {
        return this.lIm ? this.lHT.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.lHT.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
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

    public ViewGroup dkJ() {
        if (this.lIh == null) {
            this.lIh = (ViewGroup) LayoutInflater.from(this.lHT.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.r.a.a(this.lHT.getPageContext(), this.lIh);
            this.lIi = (EditText) this.lIh.findViewById(R.id.dialog_input);
            this.lIj = (ViewGroup) this.lIh.findViewById(R.id.password_tip_layout);
            this.lIk = (TextView) this.lIh.findViewById(R.id.password_input_tip);
            this.lIl = (TextView) this.lIh.findViewById(R.id.password_use_tip);
        }
        return this.lIh;
    }

    public void Fp(int i) {
        if (this.lIj != null) {
            if (i == 5) {
                this.lIj.setVisibility(0);
                this.lIk.setText("");
                this.lIl.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                this.lIj.setVisibility(0);
                this.lIk.setText(this.lHT.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.lIl.setText(R.string.payment_input_password_forget);
            } else {
                this.lIj.setVisibility(0);
                this.lIk.setText(this.lHT.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.lIl.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void bIU() {
        if (this.lIi != null) {
            this.lIi.setText("");
        }
    }

    public void dkK() {
        if (this.lIh != null && this.lIh.getParent() != null) {
            ((ViewGroup) this.lIh.getParent()).removeAllViews();
        }
    }

    public ViewGroup getContentView() {
        return this.mContentView;
    }

    public CheckBox dkL() {
        return this.lIc;
    }

    public TextView dkM() {
        return this.lIg;
    }

    public void uA(boolean z) {
        this.lIg.setEnabled(z);
    }

    public TextView dkN() {
        return this.lIl;
    }

    public String dkO() {
        return this.lIi != null ? this.lIi.getText().toString() : "";
    }

    public void uB(boolean z) {
        if (this.lIi != null) {
            this.lIi.setEnabled(z);
        }
    }

    public EditText dkP() {
        return this.lIi;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lHT.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lHT.getPageContext(), i);
    }
}
