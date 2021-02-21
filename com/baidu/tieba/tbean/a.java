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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes9.dex */
public class a {
    private int bMV;
    private ImageView eoo;
    private NoScrollGridView gXx;
    private RelativeLayout gps;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleView;
    private TextView nCA;
    private SpannableString nCB;
    private TextView nCC;
    private BuyTBeanGiftBagView nCD;
    private UserInfo nCE;
    private int nCF;
    private int nCG;
    private RelativeLayout nCH;
    private BubbleLayout nCI;
    private boolean nCK;
    private BuyTBeanActivity nCg;
    private RoundRelativeLayout nCm;
    private com.baidu.tieba.tbean.a.a nCn;
    private TextView nCo;
    private TextView nCp;
    private EditText nCq;
    private TextView nCr;
    private com.baidu.tieba.tbean.b.c nCs;
    private TextView nCt;
    private LinearLayout nCu;
    private TextView nCv;
    private boolean nCw;
    private TextView nCx;
    private TextView nCy;
    private TextView nCz;
    private long nCJ = 0;
    private View.OnClickListener nCL = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nCq.requestFocus();
            l.showSoftKeyPad(a.this.nCg, a.this.nCq);
        }
    };
    private View.OnClickListener nCM = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dPS();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nCn.getItem(i);
            if (item != null && item.nCS != null) {
                a.this.g(item.nCS.iconId, b.getYuanFromFen(item.nCS.dubi.intValue()) * 1, 1, b.a(a.this.nCE, item.nCS.non_member_t.intValue(), item.nCR) * 1);
                ar arVar = new ar(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                arVar.dR("obj_param1", item.nCS.iconId);
                TiebaStatic.log(arVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nCN = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nCQ != null) {
                a.this.g(aVar.nCQ.icon_id, b.getYuanFromFen(aVar.nCQ.dubi.intValue()) * 1, 1, aVar.nCQ.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nCO = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nCI != null) {
                a.this.nCI.setVisibility(8);
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
            String obj = a.this.nCq.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nCw) {
                    a.this.nCt.setVisibility(8);
                    a.this.nCv.setText(String.format(a.this.nCg.getString(R.string.user_define_member_tbean_extra), a.this.nCs.nCR.vip_extra_percent));
                }
                a.this.nCx.setEnabled(false);
                a.this.nCq.setHint(a.this.nCB);
            } else if (obj.startsWith("0")) {
                if (a.this.nCw) {
                    a.this.nCt.setVisibility(8);
                    a.this.nCv.setText(String.format(a.this.nCg.getString(R.string.user_define_member_tbean_extra), a.this.nCs.nCR.vip_extra_percent));
                }
                a.this.nCq.setText("");
            } else {
                a.this.nCx.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nCg.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nCq.setText(substring);
                    a.this.nCq.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nCg.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nCr.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nCq.setHint("");
                a.this.nCr.setText(au.formatTosepara(j * 1000));
                if (a.this.nCw && a.this.nCs != null && a.this.nCs.nCR != null) {
                    a.this.nCt.setVisibility(0);
                    a.this.nCt.setText(b.formatTBeanNum(((j * 1000) * a.this.nCs.nCR.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nCg = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nCg).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nCg);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nCm = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nCm.setRadius(this.nCg.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nCm.setOnClickListener(this.nCL);
        this.gps = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gXx = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nCn = new com.baidu.tieba.tbean.a.a(this.nCg.getPageContext());
        this.gXx.setAdapter((ListAdapter) this.nCn);
        this.gXx.setOnItemClickListener(this.mItemClickListener);
        this.nCH = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nCp = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nCo = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nCo.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nCg.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nCo.setCompoundDrawablePadding(this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nCo.setCompoundDrawables(drawable, null, null, null);
        this.nCq = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nCB = new SpannableString(this.nCg.getString(R.string.buy_tbean_user_define_hint));
        this.nCB.setSpan(new AbsoluteSizeSpan(this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nCB.length(), 33);
        this.nCq.setHint(this.nCB);
        this.nCq.addTextChangedListener(this.mTextWatcher);
        this.nCr = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nCr.setCompoundDrawablePadding(this.nCg.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nCr.setCompoundDrawables(drawable, null, null, null);
        this.nCu = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nCt = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nCg.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nCg.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nCt.setCompoundDrawablePadding(this.nCg.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nCt.setCompoundDrawables(drawable2, null, null, null);
        this.nCv = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nCx = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nCx.setOnClickListener(this.nCM);
        this.nCy = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nCy.setOnClickListener(this.nCg);
        this.nCz = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nCz.setCompoundDrawablePadding(this.nCg.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nCz.setCompoundDrawables(drawable, null, null, null);
        this.nCA = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.eoo = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.eoo.setOnClickListener(this.nCg);
        this.nCC = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nCD = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nCD.setClickListener(this.nCN);
        this.nCI = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        yF(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPS() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nCq.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nCg.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nCs != null && this.nCs.userInfo != null && this.nCs.nCQ != null) {
            UserInfo userInfo = this.nCs.userInfo;
            g(this.nCs.nCQ.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nCs.nCR) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nCg.showToast(this.nCg.getResources().getString(R.string.network_not_available));
                return;
            }
            c.Pf(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nCg.dPK(), PageDialogHelper.PayForm.NOT_SET, this.nCg.getReferPage(), this.nCg.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nCg.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bDV().a(payConfig, this.nCg);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nCK = true;
            if (this.bMV <= 0) {
                this.bMV = (l.getEquipmentHeight(this.nCg) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nCg);
            }
            int height = ((this.bMV + this.nCm.getHeight()) + this.nCH.getHeight()) - this.nCF;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.gps.scrollTo(0, this.bMV - height);
            } else {
                this.gps.scrollTo(0, this.bMV);
            }
            this.nCq.setSelection(this.nCq.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nCK = false;
        this.gps.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nCG;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nCq.clearFocus();
    }

    public boolean dPT() {
        return this.nCK;
    }

    public void hideSoftKeyPad() {
        this.nCq.clearFocus();
        l.hideSoftKeyPad(this.nCg, this.nCq);
    }

    public void hH(long j) {
        if (j > 0) {
            this.nCJ = j;
            this.nCq.setText((j / 1000) + "");
            this.nCq.setSelection(this.nCq.getText().length());
            this.nCz.setText(((j / 1000) * 1000) + "");
            this.nCz.setVisibility(0);
            this.nCA.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nCI != null) {
                    this.nCI.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mA().removeCallbacks(this.nCO);
                e.mA().postDelayed(this.nCO, 4000L);
                return;
            }
            return;
        }
        this.nCq.setText("");
        this.nCI.setVisibility(8);
    }

    private void yF(boolean z) {
        if (z) {
            this.nCx.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nCg.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nCq.setLayoutParams(layoutParams);
            return;
        }
        this.nCx.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nCq.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nCg.getResources().getDimensionPixelSize(R.dimen.ds42);
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

    public void cHM() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.nCg.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nCg.setNetRefreshViewTopMargin(this.nCg.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nCg.showNetRefreshView(this.gps, this.nCg.getResources().getString(R.string.neterror));
    }

    public void cHN() {
        this.nCg.hideNetRefreshView(this.gps);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ap.setViewTextColor(this.nCp, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCo, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCz, R.color.common_color_10191, 1, i);
        ap.setViewTextColor(this.nCA, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCy, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nCm.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nCm.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nCr, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCC, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCv, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCt, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCq, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nCn != null) {
            this.nCn.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nCE = userInfo;
        }
        if (!y.isEmpty(list)) {
            int i = y.getCount(list) == 6 ? 3 : 2;
            this.gXx.setNumColumns(i);
            this.nCn.JX(i);
            this.nCn.setDatas(list);
        }
        if (cVar != null) {
            this.nCs = cVar;
            if (this.nCs.nCR != null && this.nCs.nCR.vip_extra_switch.intValue() == 1 && this.nCs.nCR.vip_extra_percent.intValue() > 0) {
                this.nCw = true;
                this.nCu.setVisibility(0);
                this.nCt.setVisibility(8);
                this.nCv.setText(String.format(this.nCg.getString(R.string.user_define_member_tbean_extra), this.nCs.nCR.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nCm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nCm.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nCx.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nCx.setLayoutParams(layoutParams2);
                }
            } else {
                this.nCu.setVisibility(8);
                this.nCw = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nCm.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nCm.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nCx.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nCg.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nCx.setLayoutParams(layoutParams4);
                }
            }
            if (this.nCs.nCQ != null) {
                this.nCC.setText(this.nCg.getString(R.string.icon_name_valid_day, new Object[]{this.nCs.nCQ.name, Integer.valueOf(this.nCs.nCQ.duration == null ? 0 : this.nCs.nCQ.duration.intValue())}));
            }
        }
        if (!y.isEmpty(list2)) {
            this.nCD.fS(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nCG = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nCG;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nCF = a.this.gps.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nCO);
    }
}
