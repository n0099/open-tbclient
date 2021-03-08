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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<PaymentConfirmActivity> {
    private PaymentConfirmActivity lJV;
    private ViewGroup lJW;
    private TbImageView lJX;
    private TextView lJY;
    private TextView lJZ;
    private TextView lKa;
    private TextView lKb;
    private TextView lKc;
    private TextView lKd;
    private CheckBox lKe;
    private ViewGroup lKf;
    private TbImageView lKg;
    private TextView lKh;
    private TextView lKi;
    private ViewGroup lKj;
    private EditText lKk;
    private ViewGroup lKl;
    private TextView lKm;
    private TextView lKn;
    private boolean lKo;
    private ViewGroup mContentView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.lKo = false;
        this.lJV = paymentConfirmActivity;
        this.lKo = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        o(paymentConfirmActivity);
        p(paymentConfirmActivity);
    }

    private void o(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.lJV.findViewById(R.id.payment_root);
        this.mNavigationBar = (NavigationBar) this.lJV.findViewById(R.id.payment_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.lKo) {
            this.mNavigationBar.setTitleText(this.lJV.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.mNavigationBar.setTitleText(this.lJV.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    private void p(PaymentConfirmActivity paymentConfirmActivity) {
        this.mContentView = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.lJW = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.lJX = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.lJY = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.lJZ = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.lKa = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.lKb = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.lKc = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.lKd = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.lKe = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.lKf = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.lKg = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.lKh = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.lKi = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.lJW.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.lJX.startLoad(goods_info.getGoods_pic(), 10, false);
                this.lJY.setText(goods_info.getGoods_name());
                String numFormatOver10000 = au.numFormatOver10000(goods_info.getGoods_num());
                this.lJZ.setText(v(this.lJV.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, ap.getColor(R.color.CAM_X0305)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String numFormatOver100002 = au.numFormatOver10000(goods_duration);
                    this.lKa.setText(v(this.lJV.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, ap.getColor(R.color.CAM_X0305)));
                } else {
                    this.lKa.setText(e(this.lJV.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, ap.getColor(R.color.CAM_X0305)));
                }
                this.lKb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.lKb.setText(au.numFormatOver10000wan(goods_info.getTdou_num()));
                this.lKc.setText(this.lJV.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ap.setViewTextColor(this.lKd, R.color.CAM_X0105, 1);
                    this.lKd.setText(hq(goods_info.getTdou_num()));
                } else {
                    ap.setViewTextColor(this.lKd, R.color.CAM_X0301, 1);
                    this.lKd.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.lKf.setVisibility(0);
                        this.lKg.startLoad(icon, 10, false);
                        this.lKh.setText(desc);
                    } else {
                        this.lKf.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.lKe.setButtonDrawable(ap.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                    this.lKe.setVisibility(0);
                    this.lKe.setText(this.lJV.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.lKe.setVisibility(8);
                }
            }
            if (z) {
                if (this.lKo) {
                    this.lKi.setText(R.string.buy_now);
                    return;
                } else {
                    this.lKi.setText(R.string.goto_exchange);
                    return;
                }
            }
            this.lKi.setText(R.string.get_tdou);
        }
    }

    public void hp(long j) {
        ap.setViewTextColor(this.lKd, R.color.CAM_X0105, 1);
        this.lKd.setText(hq(j));
        this.lKi.setText(R.string.goto_exchange);
    }

    private SpannableStringBuilder hq(long j) {
        String str = "" + j;
        String Pk = Pk(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Pk);
        int indexOf = Pk.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(getPageContext().getPageActivity(), ap.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, str.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private String Pk(String str) {
        return this.lKo ? this.lJV.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.lJV.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
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

    public ViewGroup dkS() {
        if (this.lKj == null) {
            this.lKj = (ViewGroup) LayoutInflater.from(this.lJV.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.r.a.a(this.lJV.getPageContext(), this.lKj);
            this.lKk = (EditText) this.lKj.findViewById(R.id.dialog_input);
            this.lKl = (ViewGroup) this.lKj.findViewById(R.id.password_tip_layout);
            this.lKm = (TextView) this.lKj.findViewById(R.id.password_input_tip);
            this.lKn = (TextView) this.lKj.findViewById(R.id.password_use_tip);
        }
        return this.lKj;
    }

    public void Fs(int i) {
        if (this.lKl != null) {
            if (i == 5) {
                this.lKl.setVisibility(0);
                this.lKm.setText("");
                this.lKn.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                this.lKl.setVisibility(0);
                this.lKm.setText(this.lJV.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.lKn.setText(R.string.payment_input_password_forget);
            } else {
                this.lKl.setVisibility(0);
                this.lKm.setText(this.lJV.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.lKn.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void bIY() {
        if (this.lKk != null) {
            this.lKk.setText("");
        }
    }

    public void dkT() {
        if (this.lKj != null && this.lKj.getParent() != null) {
            ((ViewGroup) this.lKj.getParent()).removeAllViews();
        }
    }

    public ViewGroup getContentView() {
        return this.mContentView;
    }

    public CheckBox dkU() {
        return this.lKe;
    }

    public TextView dkV() {
        return this.lKi;
    }

    public void uA(boolean z) {
        this.lKi.setEnabled(z);
    }

    public TextView dkW() {
        return this.lKn;
    }

    public String dkX() {
        return this.lKk != null ? this.lKk.getText().toString() : "";
    }

    public void uB(boolean z) {
        if (this.lKk != null) {
            this.lKk.setEnabled(z);
        }
    }

    public EditText dkY() {
        return this.lKk;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lJV.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lJV.getPageContext(), i);
    }
}
