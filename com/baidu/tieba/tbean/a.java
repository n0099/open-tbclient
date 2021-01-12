package com.baidu.tieba.tbean;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.live.tbean.TbeanStatisticKey;
import com.baidu.tieba.tbean.view.BuyTBeanGiftBagView;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes8.dex */
public class a {
    private int bJl;
    private ImageView eme;
    private NoScrollGridView gUz;
    private RelativeLayout gmv;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleView;
    private BuyTBeanActivity nrW;
    private boolean nsA;
    private RoundRelativeLayout nsc;
    private com.baidu.tieba.tbean.a.a nsd;
    private TextView nse;
    private TextView nsf;
    private EditText nsg;
    private TextView nsh;
    private com.baidu.tieba.tbean.b.c nsi;
    private TextView nsj;
    private LinearLayout nsk;
    private TextView nsl;
    private boolean nsm;
    private TextView nsn;
    private TextView nso;
    private TextView nsp;
    private TextView nsq;
    private SpannableString nsr;
    private TextView nss;
    private BuyTBeanGiftBagView nst;
    private UserInfo nsu;
    private int nsv;
    private int nsw;
    private RelativeLayout nsx;
    private BubbleLayout nsy;
    private long nsz = 0;
    private View.OnClickListener nsB = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nsg.requestFocus();
            l.showSoftKeyPad(a.this.nrW, a.this.nsg);
        }
    };
    private View.OnClickListener nsC = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dNz();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nsd.getItem(i);
            if (item != null && item.nsI != null) {
                a.this.g(item.nsI.iconId, b.getYuanFromFen(item.nsI.dubi.intValue()) * 1, 1, b.a(a.this.nsu, item.nsI.non_member_t.intValue(), item.nsH) * 1);
                aq aqVar = new aq(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                aqVar.dW("obj_param1", item.nsI.iconId);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nsD = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nsG != null) {
                a.this.g(aVar.nsG.icon_id, b.getYuanFromFen(aVar.nsG.dubi.intValue()) * 1, 1, aVar.nsG.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nsE = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nsy != null) {
                a.this.nsy.setVisibility(8);
            }
        }
    };
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.tbean.a.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = a.this.nsg.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nsm) {
                    a.this.nsj.setVisibility(8);
                    a.this.nsl.setText(String.format(a.this.nrW.getString(R.string.user_define_member_tbean_extra), a.this.nsi.nsH.vip_extra_percent));
                }
                a.this.nsn.setEnabled(false);
                a.this.nsg.setHint(a.this.nsr);
            } else if (obj.startsWith("0")) {
                if (a.this.nsm) {
                    a.this.nsj.setVisibility(8);
                    a.this.nsl.setText(String.format(a.this.nrW.getString(R.string.user_define_member_tbean_extra), a.this.nsi.nsH.vip_extra_percent));
                }
                a.this.nsg.setText("");
            } else {
                a.this.nsn.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nrW.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nsg.setText(substring);
                    a.this.nsg.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nrW.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nsh.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nsg.setHint("");
                a.this.nsh.setText(at.formatTosepara(j * 1000));
                if (a.this.nsm && a.this.nsi != null && a.this.nsi.nsH != null) {
                    a.this.nsj.setVisibility(0);
                    a.this.nsj.setText(b.formatTBeanNum(((j * 1000) * a.this.nsi.nsH.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nrW = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nrW).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nrW);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nsc = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nsc.setRadius(this.nrW.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nsc.setOnClickListener(this.nsB);
        this.gmv = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gUz = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nsd = new com.baidu.tieba.tbean.a.a(this.nrW.getPageContext());
        this.gUz.setAdapter((ListAdapter) this.nsd);
        this.gUz.setOnItemClickListener(this.mItemClickListener);
        this.nsx = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nsf = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nse = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nse.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nrW.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nse.setCompoundDrawablePadding(this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nse.setCompoundDrawables(drawable, null, null, null);
        this.nsg = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nsr = new SpannableString(this.nrW.getString(R.string.buy_tbean_user_define_hint));
        this.nsr.setSpan(new AbsoluteSizeSpan(this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nsr.length(), 33);
        this.nsg.setHint(this.nsr);
        this.nsg.addTextChangedListener(this.mTextWatcher);
        this.nsh = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nsh.setCompoundDrawablePadding(this.nrW.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nsh.setCompoundDrawables(drawable, null, null, null);
        this.nsk = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nsj = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nrW.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nrW.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nsj.setCompoundDrawablePadding(this.nrW.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nsj.setCompoundDrawables(drawable2, null, null, null);
        this.nsl = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nsn = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nsn.setOnClickListener(this.nsC);
        this.nso = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nso.setOnClickListener(this.nrW);
        this.nsp = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nsp.setCompoundDrawablePadding(this.nrW.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nsp.setCompoundDrawables(drawable, null, null, null);
        this.nsq = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.eme = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.eme.setOnClickListener(this.nrW);
        this.nss = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nst = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nst.setClickListener(this.nsD);
        this.nsy = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        ym(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNz() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nsg.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nrW.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nsi != null && this.nsi.userInfo != null && this.nsi.nsG != null) {
            UserInfo userInfo = this.nsi.userInfo;
            g(this.nsi.nsG.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nsi.nsH) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nrW.showToast(this.nrW.getResources().getString(R.string.network_not_available));
                return;
            }
            c.Om(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nrW.dNr(), PageDialogHelper.PayForm.NOT_SET, this.nrW.getReferPage(), this.nrW.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nrW.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bDD().a(payConfig, this.nrW);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nsA = true;
            if (this.bJl <= 0) {
                this.bJl = (l.getEquipmentHeight(this.nrW) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nrW);
            }
            int height = ((this.bJl + this.nsc.getHeight()) + this.nsx.getHeight()) - this.nsv;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.gmv.scrollTo(0, this.bJl - height);
            } else {
                this.gmv.scrollTo(0, this.bJl);
            }
            this.nsg.setSelection(this.nsg.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nsA = false;
        this.gmv.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nsw;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nsg.clearFocus();
    }

    public boolean dNA() {
        return this.nsA;
    }

    public void hideSoftKeyPad() {
        this.nsg.clearFocus();
        l.hideSoftKeyPad(this.nrW, this.nsg);
    }

    public void hC(long j) {
        if (j > 0) {
            this.nsz = j;
            this.nsg.setText((j / 1000) + "");
            this.nsg.setSelection(this.nsg.getText().length());
            this.nsp.setText(((j / 1000) * 1000) + "");
            this.nsp.setVisibility(0);
            this.nsq.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nsy != null) {
                    this.nsy.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mB().removeCallbacks(this.nsE);
                e.mB().postDelayed(this.nsE, 4000L);
                return;
            }
            return;
        }
        this.nsg.setText("");
        this.nsy.setVisibility(8);
    }

    private void ym(boolean z) {
        if (z) {
            this.nsn.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nrW.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nsg.setLayoutParams(layoutParams);
            return;
        }
        this.nsn.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nsg.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nrW.getResources().getDimensionPixelSize(R.dimen.ds42);
        }
    }

    public void hideRootView() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(8);
        }
    }

    public void showRootView() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(0);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void cGs() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.nrW.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nrW.setNetRefreshViewTopMargin(this.nrW.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nrW.showNetRefreshView(this.gmv, this.nrW.getResources().getString(R.string.neterror));
    }

    public void cGt() {
        this.nrW.hideNetRefreshView(this.gmv);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ao.setViewTextColor(this.nsf, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nse, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsp, R.color.common_color_10191, 1, i);
        ao.setViewTextColor(this.nsq, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nso, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nsc.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nsc.setBgColorRes(R.color.CAM_X0201);
        }
        ao.setViewTextColor(this.nsh, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nss, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsl, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsj, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsg, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nsd != null) {
            this.nsd.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nsu = userInfo;
        }
        if (!x.isEmpty(list)) {
            int i = x.getCount(list) == 6 ? 3 : 2;
            this.gUz.setNumColumns(i);
            this.nsd.JD(i);
            this.nsd.setDatas(list);
        }
        if (cVar != null) {
            this.nsi = cVar;
            if (this.nsi.nsH != null && this.nsi.nsH.vip_extra_switch.intValue() == 1 && this.nsi.nsH.vip_extra_percent.intValue() > 0) {
                this.nsm = true;
                this.nsk.setVisibility(0);
                this.nsj.setVisibility(8);
                this.nsl.setText(String.format(this.nrW.getString(R.string.user_define_member_tbean_extra), this.nsi.nsH.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nsc.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nsn.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nsn.setLayoutParams(layoutParams2);
                }
            } else {
                this.nsk.setVisibility(8);
                this.nsm = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nsc.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nsc.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nsn.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nrW.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nsn.setLayoutParams(layoutParams4);
                }
            }
            if (this.nsi.nsG != null) {
                this.nss.setText(this.nrW.getString(R.string.icon_name_valid_day, new Object[]{this.nsi.nsG.name, Integer.valueOf(this.nsi.nsG.duration == null ? 0 : this.nsi.nsG.duration.intValue())}));
            }
        }
        if (!x.isEmpty(list2)) {
            this.nst.fU(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nsw = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nsw;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nsv = a.this.gmv.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nsE);
    }
}
