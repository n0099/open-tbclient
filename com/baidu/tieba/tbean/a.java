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
    private BuyTBeanActivity nrX;
    private boolean nsB;
    private RoundRelativeLayout nsd;
    private com.baidu.tieba.tbean.a.a nse;
    private TextView nsf;
    private TextView nsg;
    private EditText nsh;
    private TextView nsi;
    private com.baidu.tieba.tbean.b.c nsj;
    private TextView nsk;
    private LinearLayout nsl;
    private TextView nsm;
    private boolean nsn;
    private TextView nso;
    private TextView nsp;
    private TextView nsq;
    private TextView nsr;
    private SpannableString nss;
    private TextView nst;
    private BuyTBeanGiftBagView nsu;
    private UserInfo nsv;
    private int nsw;
    private int nsx;
    private RelativeLayout nsy;
    private BubbleLayout nsz;
    private long nsA = 0;
    private View.OnClickListener nsC = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nsh.requestFocus();
            l.showSoftKeyPad(a.this.nrX, a.this.nsh);
        }
    };
    private View.OnClickListener nsD = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dNz();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nse.getItem(i);
            if (item != null && item.nsJ != null) {
                a.this.g(item.nsJ.iconId, b.getYuanFromFen(item.nsJ.dubi.intValue()) * 1, 1, b.a(a.this.nsv, item.nsJ.non_member_t.intValue(), item.nsI) * 1);
                aq aqVar = new aq(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                aqVar.dW("obj_param1", item.nsJ.iconId);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nsE = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nsH != null) {
                a.this.g(aVar.nsH.icon_id, b.getYuanFromFen(aVar.nsH.dubi.intValue()) * 1, 1, aVar.nsH.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nsF = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nsz != null) {
                a.this.nsz.setVisibility(8);
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
            String obj = a.this.nsh.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nsn) {
                    a.this.nsk.setVisibility(8);
                    a.this.nsm.setText(String.format(a.this.nrX.getString(R.string.user_define_member_tbean_extra), a.this.nsj.nsI.vip_extra_percent));
                }
                a.this.nso.setEnabled(false);
                a.this.nsh.setHint(a.this.nss);
            } else if (obj.startsWith("0")) {
                if (a.this.nsn) {
                    a.this.nsk.setVisibility(8);
                    a.this.nsm.setText(String.format(a.this.nrX.getString(R.string.user_define_member_tbean_extra), a.this.nsj.nsI.vip_extra_percent));
                }
                a.this.nsh.setText("");
            } else {
                a.this.nso.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nrX.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nsh.setText(substring);
                    a.this.nsh.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nrX.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nsi.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nsh.setHint("");
                a.this.nsi.setText(at.formatTosepara(j * 1000));
                if (a.this.nsn && a.this.nsj != null && a.this.nsj.nsI != null) {
                    a.this.nsk.setVisibility(0);
                    a.this.nsk.setText(b.formatTBeanNum(((j * 1000) * a.this.nsj.nsI.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nrX = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nrX).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nrX);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nsd = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nsd.setRadius(this.nrX.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nsd.setOnClickListener(this.nsC);
        this.gmv = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gUz = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nse = new com.baidu.tieba.tbean.a.a(this.nrX.getPageContext());
        this.gUz.setAdapter((ListAdapter) this.nse);
        this.gUz.setOnItemClickListener(this.mItemClickListener);
        this.nsy = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nsg = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nsf = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nsf.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nrX.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nsf.setCompoundDrawablePadding(this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nsf.setCompoundDrawables(drawable, null, null, null);
        this.nsh = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nss = new SpannableString(this.nrX.getString(R.string.buy_tbean_user_define_hint));
        this.nss.setSpan(new AbsoluteSizeSpan(this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nss.length(), 33);
        this.nsh.setHint(this.nss);
        this.nsh.addTextChangedListener(this.mTextWatcher);
        this.nsi = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nsi.setCompoundDrawablePadding(this.nrX.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nsi.setCompoundDrawables(drawable, null, null, null);
        this.nsl = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nsk = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nrX.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nrX.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nsk.setCompoundDrawablePadding(this.nrX.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nsk.setCompoundDrawables(drawable2, null, null, null);
        this.nsm = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nso = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nso.setOnClickListener(this.nsD);
        this.nsp = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nsp.setOnClickListener(this.nrX);
        this.nsq = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nsq.setCompoundDrawablePadding(this.nrX.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nsq.setCompoundDrawables(drawable, null, null, null);
        this.nsr = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.eme = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.eme.setOnClickListener(this.nrX);
        this.nst = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nsu = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nsu.setClickListener(this.nsE);
        this.nsz = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        ym(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNz() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nsh.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nrX.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nsj != null && this.nsj.userInfo != null && this.nsj.nsH != null) {
            UserInfo userInfo = this.nsj.userInfo;
            g(this.nsj.nsH.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nsj.nsI) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nrX.showToast(this.nrX.getResources().getString(R.string.network_not_available));
                return;
            }
            c.On(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nrX.dNr(), PageDialogHelper.PayForm.NOT_SET, this.nrX.getReferPage(), this.nrX.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nrX.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bDD().a(payConfig, this.nrX);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nsB = true;
            if (this.bJl <= 0) {
                this.bJl = (l.getEquipmentHeight(this.nrX) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nrX);
            }
            int height = ((this.bJl + this.nsd.getHeight()) + this.nsy.getHeight()) - this.nsw;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.gmv.scrollTo(0, this.bJl - height);
            } else {
                this.gmv.scrollTo(0, this.bJl);
            }
            this.nsh.setSelection(this.nsh.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nsB = false;
        this.gmv.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nsx;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nsh.clearFocus();
    }

    public boolean dNA() {
        return this.nsB;
    }

    public void hideSoftKeyPad() {
        this.nsh.clearFocus();
        l.hideSoftKeyPad(this.nrX, this.nsh);
    }

    public void hC(long j) {
        if (j > 0) {
            this.nsA = j;
            this.nsh.setText((j / 1000) + "");
            this.nsh.setSelection(this.nsh.getText().length());
            this.nsq.setText(((j / 1000) * 1000) + "");
            this.nsq.setVisibility(0);
            this.nsr.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nsz != null) {
                    this.nsz.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mB().removeCallbacks(this.nsF);
                e.mB().postDelayed(this.nsF, 4000L);
                return;
            }
            return;
        }
        this.nsh.setText("");
        this.nsz.setVisibility(8);
    }

    private void ym(boolean z) {
        if (z) {
            this.nso.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nrX.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nsh.setLayoutParams(layoutParams);
            return;
        }
        this.nso.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nsh.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nrX.getResources().getDimensionPixelSize(R.dimen.ds42);
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
            layoutParams.topMargin = this.nrX.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nrX.setNetRefreshViewTopMargin(this.nrX.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nrX.showNetRefreshView(this.gmv, this.nrX.getResources().getString(R.string.neterror));
    }

    public void cGt() {
        this.nrX.hideNetRefreshView(this.gmv);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ao.setViewTextColor(this.nsg, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsf, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsq, R.color.common_color_10191, 1, i);
        ao.setViewTextColor(this.nsr, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsp, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nsd.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nsd.setBgColorRes(R.color.CAM_X0201);
        }
        ao.setViewTextColor(this.nsi, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nst, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsm, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsk, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsh, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nse != null) {
            this.nse.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nsv = userInfo;
        }
        if (!x.isEmpty(list)) {
            int i = x.getCount(list) == 6 ? 3 : 2;
            this.gUz.setNumColumns(i);
            this.nse.JD(i);
            this.nse.setDatas(list);
        }
        if (cVar != null) {
            this.nsj = cVar;
            if (this.nsj.nsI != null && this.nsj.nsI.vip_extra_switch.intValue() == 1 && this.nsj.nsI.vip_extra_percent.intValue() > 0) {
                this.nsn = true;
                this.nsl.setVisibility(0);
                this.nsk.setVisibility(8);
                this.nsm.setText(String.format(this.nrX.getString(R.string.user_define_member_tbean_extra), this.nsj.nsI.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nsd.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nso.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nso.setLayoutParams(layoutParams2);
                }
            } else {
                this.nsl.setVisibility(8);
                this.nsn = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nsd.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nsd.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nso.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nrX.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nso.setLayoutParams(layoutParams4);
                }
            }
            if (this.nsj.nsH != null) {
                this.nst.setText(this.nrX.getString(R.string.icon_name_valid_day, new Object[]{this.nsj.nsH.name, Integer.valueOf(this.nsj.nsH.duration == null ? 0 : this.nsj.nsH.duration.intValue())}));
            }
        }
        if (!x.isEmpty(list2)) {
            this.nsu.fU(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nsx = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nsx;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nsw = a.this.gmv.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nsF);
    }
}
