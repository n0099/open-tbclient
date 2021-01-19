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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<PaymentConfirmActivity> {
    private PaymentConfirmActivity lyS;
    private ViewGroup lyT;
    private TbImageView lyU;
    private TextView lyV;
    private TextView lyW;
    private TextView lyX;
    private TextView lyY;
    private TextView lyZ;
    private TextView lza;
    private CheckBox lzb;
    private ViewGroup lzc;
    private TbImageView lzd;
    private TextView lze;
    private TextView lzf;
    private ViewGroup lzg;
    private EditText lzh;
    private ViewGroup lzi;
    private TextView lzj;
    private TextView lzk;
    private boolean lzl;
    private ViewGroup mContentView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.lzl = false;
        this.lyS = paymentConfirmActivity;
        this.lzl = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        o(paymentConfirmActivity);
        p(paymentConfirmActivity);
    }

    private void o(PaymentConfirmActivity paymentConfirmActivity) {
        this.mRootView = (ViewGroup) this.lyS.findViewById(R.id.payment_root);
        this.mNavigationBar = (NavigationBar) this.lyS.findViewById(R.id.payment_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.lzl) {
            this.mNavigationBar.setTitleText(this.lyS.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.mNavigationBar.setTitleText(this.lyS.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    private void p(PaymentConfirmActivity paymentConfirmActivity) {
        this.mContentView = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.lyT = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.lyU = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.lyV = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.lyW = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.lyX = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.lyY = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.lyZ = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.lza = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.lzb = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.lzc = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.lzd = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.lze = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.lzf = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public void b(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null) {
            this.lyT.setVisibility(0);
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (goods_info != null) {
                this.lyU.startLoad(goods_info.getGoods_pic(), 10, false);
                this.lyV.setText(goods_info.getGoods_name());
                String numFormatOver10000 = at.numFormatOver10000(goods_info.getGoods_num());
                this.lyW.setText(v(this.lyS.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, ao.getColor(R.color.CAM_X0305)));
                int goods_duration = goods_info.getGoods_duration();
                if (goods_duration > 0) {
                    String numFormatOver100002 = at.numFormatOver10000(goods_duration);
                    this.lyX.setText(v(this.lyS.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, ao.getColor(R.color.CAM_X0305)));
                } else {
                    this.lyX.setText(e(this.lyS.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, ao.getColor(R.color.CAM_X0305)));
                }
                this.lyY.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                this.lyY.setText(at.numFormatOver10000wan(goods_info.getTdou_num()));
                this.lyZ.setText(this.lyS.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
                if (z) {
                    ao.setViewTextColor(this.lza, R.color.CAM_X0105, 1);
                    this.lza.setText(hl(goods_info.getTdou_num()));
                } else {
                    ao.setViewTextColor(this.lza, R.color.CAM_X0301, 1);
                    this.lza.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
            PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
            if (order_info != null && (cpath = order_info.getCpath()) != null) {
                PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
                if (member != null) {
                    String icon = member.getIcon();
                    String desc = member.getDesc();
                    if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                        this.lzc.setVisibility(0);
                        this.lzd.startLoad(icon, 10, false);
                        this.lze.setText(desc);
                    } else {
                        this.lzc.setVisibility(8);
                    }
                }
                if (cpath.getTip_exist() == 1) {
                    this.lzb.setButtonDrawable(ao.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                    this.lzb.setVisibility(0);
                    this.lzb.setText(this.lyS.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
                } else {
                    this.lzb.setVisibility(8);
                }
            }
            if (z) {
                if (this.lzl) {
                    this.lzf.setText(R.string.buy_now);
                    return;
                } else {
                    this.lzf.setText(R.string.goto_exchange);
                    return;
                }
            }
            this.lzf.setText(R.string.get_tdou);
        }
    }

    public void hk(long j) {
        ao.setViewTextColor(this.lza, R.color.CAM_X0105, 1);
        this.lza.setText(hl(j));
        this.lzf.setText(R.string.goto_exchange);
    }

    private SpannableStringBuilder hl(long j) {
        String str = "" + j;
        String Om = Om(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Om);
        int indexOf = Om.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305));
            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(getPageContext().getPageActivity(), ao.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, indexOf + 1, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf + 1, str.length() + indexOf + 1, 33);
        }
        return spannableStringBuilder;
    }

    private String Om(String str) {
        return this.lzl ? this.lyS.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.lyS.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
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

    public ViewGroup diq() {
        if (this.lzg == null) {
            this.lzg = (ViewGroup) LayoutInflater.from(this.lyS.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            com.baidu.tbadk.r.a.a(this.lyS.getPageContext(), this.lzg);
            this.lzh = (EditText) this.lzg.findViewById(R.id.dialog_input);
            this.lzi = (ViewGroup) this.lzg.findViewById(R.id.password_tip_layout);
            this.lzj = (TextView) this.lzg.findViewById(R.id.password_input_tip);
            this.lzk = (TextView) this.lzg.findViewById(R.id.password_use_tip);
        }
        return this.lzg;
    }

    public void EW(int i) {
        if (this.lzi != null) {
            if (i == 5) {
                this.lzi.setVisibility(0);
                this.lzj.setText("");
                this.lzk.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                this.lzi.setVisibility(0);
                this.lzj.setText(this.lyS.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.lzk.setText(R.string.payment_input_password_forget);
            } else {
                this.lzi.setVisibility(0);
                this.lzj.setText(this.lyS.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.lzk.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void bIB() {
        if (this.lzh != null) {
            this.lzh.setText("");
        }
    }

    public void dir() {
        if (this.lzg != null && this.lzg.getParent() != null) {
            ((ViewGroup) this.lzg.getParent()).removeAllViews();
        }
    }

    public ViewGroup getContentView() {
        return this.mContentView;
    }

    public CheckBox dis() {
        return this.lzb;
    }

    public TextView dit() {
        return this.lzf;
    }

    public void un(boolean z) {
        this.lzf.setEnabled(z);
    }

    public TextView diu() {
        return this.lzk;
    }

    public String div() {
        return this.lzh != null ? this.lzh.getText().toString() : "";
    }

    public void uo(boolean z) {
        if (this.lzh != null) {
            this.lzh.setEnabled(z);
        }
    }

    public EditText diw() {
        return this.lzh;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lyS.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lyS.getPageContext(), i);
    }
}
