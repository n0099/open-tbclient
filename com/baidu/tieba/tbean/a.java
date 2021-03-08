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
/* loaded from: classes8.dex */
public class a {
    private int bOv;
    private ImageView epP;
    private NoScrollGridView gZg;
    private RelativeLayout grb;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleView;
    private TextView nEA;
    private boolean nEB;
    private TextView nEC;
    private TextView nED;
    private TextView nEE;
    private TextView nEF;
    private SpannableString nEG;
    private TextView nEH;
    private BuyTBeanGiftBagView nEI;
    private UserInfo nEJ;
    private int nEK;
    private int nEL;
    private RelativeLayout nEM;
    private BubbleLayout nEN;
    private boolean nEP;
    private BuyTBeanActivity nEl;
    private RoundRelativeLayout nEr;
    private com.baidu.tieba.tbean.a.a nEs;
    private TextView nEt;
    private TextView nEu;
    private EditText nEv;
    private TextView nEw;
    private com.baidu.tieba.tbean.b.c nEx;
    private TextView nEy;
    private LinearLayout nEz;
    private long nEO = 0;
    private View.OnClickListener nEQ = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nEv.requestFocus();
            l.showSoftKeyPad(a.this.nEl, a.this.nEv);
        }
    };
    private View.OnClickListener nER = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dQb();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nEs.getItem(i);
            if (item != null && item.nEX != null) {
                a.this.g(item.nEX.iconId, b.getYuanFromFen(item.nEX.dubi.intValue()) * 1, 1, b.a(a.this.nEJ, item.nEX.non_member_t.intValue(), item.nEW) * 1);
                ar arVar = new ar(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                arVar.dR("obj_param1", item.nEX.iconId);
                TiebaStatic.log(arVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nES = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nEV != null) {
                a.this.g(aVar.nEV.icon_id, b.getYuanFromFen(aVar.nEV.dubi.intValue()) * 1, 1, aVar.nEV.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nET = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nEN != null) {
                a.this.nEN.setVisibility(8);
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
            String obj = a.this.nEv.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nEB) {
                    a.this.nEy.setVisibility(8);
                    a.this.nEA.setText(String.format(a.this.nEl.getString(R.string.user_define_member_tbean_extra), a.this.nEx.nEW.vip_extra_percent));
                }
                a.this.nEC.setEnabled(false);
                a.this.nEv.setHint(a.this.nEG);
            } else if (obj.startsWith("0")) {
                if (a.this.nEB) {
                    a.this.nEy.setVisibility(8);
                    a.this.nEA.setText(String.format(a.this.nEl.getString(R.string.user_define_member_tbean_extra), a.this.nEx.nEW.vip_extra_percent));
                }
                a.this.nEv.setText("");
            } else {
                a.this.nEC.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nEl.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nEv.setText(substring);
                    a.this.nEv.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nEl.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nEw.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nEv.setHint("");
                a.this.nEw.setText(au.formatTosepara(j * 1000));
                if (a.this.nEB && a.this.nEx != null && a.this.nEx.nEW != null) {
                    a.this.nEy.setVisibility(0);
                    a.this.nEy.setText(b.formatTBeanNum(((j * 1000) * a.this.nEx.nEW.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nEl = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nEl).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nEl);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nEr = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nEr.setRadius(this.nEl.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nEr.setOnClickListener(this.nEQ);
        this.grb = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gZg = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nEs = new com.baidu.tieba.tbean.a.a(this.nEl.getPageContext());
        this.gZg.setAdapter((ListAdapter) this.nEs);
        this.gZg.setOnItemClickListener(this.mItemClickListener);
        this.nEM = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nEu = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nEt = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nEt.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nEl.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nEt.setCompoundDrawablePadding(this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nEt.setCompoundDrawables(drawable, null, null, null);
        this.nEv = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nEG = new SpannableString(this.nEl.getString(R.string.buy_tbean_user_define_hint));
        this.nEG.setSpan(new AbsoluteSizeSpan(this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nEG.length(), 33);
        this.nEv.setHint(this.nEG);
        this.nEv.addTextChangedListener(this.mTextWatcher);
        this.nEw = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nEw.setCompoundDrawablePadding(this.nEl.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nEw.setCompoundDrawables(drawable, null, null, null);
        this.nEz = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nEy = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nEl.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nEl.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nEy.setCompoundDrawablePadding(this.nEl.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nEy.setCompoundDrawables(drawable2, null, null, null);
        this.nEA = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nEC = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nEC.setOnClickListener(this.nER);
        this.nED = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nED.setOnClickListener(this.nEl);
        this.nEE = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nEE.setCompoundDrawablePadding(this.nEl.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nEE.setCompoundDrawables(drawable, null, null, null);
        this.nEF = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.epP = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.epP.setOnClickListener(this.nEl);
        this.nEH = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nEI = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nEI.setClickListener(this.nES);
        this.nEN = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        yE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQb() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nEv.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nEl.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nEx != null && this.nEx.userInfo != null && this.nEx.nEV != null) {
            UserInfo userInfo = this.nEx.userInfo;
            g(this.nEx.nEV.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nEx.nEW) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nEl.showToast(this.nEl.getResources().getString(R.string.network_not_available));
                return;
            }
            c.Pl(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nEl.dPT(), PageDialogHelper.PayForm.NOT_SET, this.nEl.getReferPage(), this.nEl.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nEl.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bDZ().a(payConfig, this.nEl);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nEP = true;
            if (this.bOv <= 0) {
                this.bOv = (l.getEquipmentHeight(this.nEl) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nEl);
            }
            int height = ((this.bOv + this.nEr.getHeight()) + this.nEM.getHeight()) - this.nEK;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.grb.scrollTo(0, this.bOv - height);
            } else {
                this.grb.scrollTo(0, this.bOv);
            }
            this.nEv.setSelection(this.nEv.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nEP = false;
        this.grb.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nEL;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nEv.clearFocus();
    }

    public boolean dQc() {
        return this.nEP;
    }

    public void hideSoftKeyPad() {
        this.nEv.clearFocus();
        l.hideSoftKeyPad(this.nEl, this.nEv);
    }

    public void hH(long j) {
        if (j > 0) {
            this.nEO = j;
            this.nEv.setText((j / 1000) + "");
            this.nEv.setSelection(this.nEv.getText().length());
            this.nEE.setText(((j / 1000) * 1000) + "");
            this.nEE.setVisibility(0);
            this.nEF.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nEN != null) {
                    this.nEN.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mA().removeCallbacks(this.nET);
                e.mA().postDelayed(this.nET, 4000L);
                return;
            }
            return;
        }
        this.nEv.setText("");
        this.nEN.setVisibility(8);
    }

    private void yE(boolean z) {
        if (z) {
            this.nEC.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nEl.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nEv.setLayoutParams(layoutParams);
            return;
        }
        this.nEC.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nEv.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nEl.getResources().getDimensionPixelSize(R.dimen.ds42);
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

    public void cHS() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.nEl.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nEl.setNetRefreshViewTopMargin(this.nEl.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nEl.showNetRefreshView(this.grb, this.nEl.getResources().getString(R.string.neterror));
    }

    public void cHT() {
        this.nEl.hideNetRefreshView(this.grb);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ap.setViewTextColor(this.nEu, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nEt, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nEE, R.color.common_color_10191, 1, i);
        ap.setViewTextColor(this.nEF, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nED, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nEr.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nEr.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nEw, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nEH, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nEA, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nEy, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nEv, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nEs != null) {
            this.nEs.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nEJ = userInfo;
        }
        if (!y.isEmpty(list)) {
            int i = y.getCount(list) == 6 ? 3 : 2;
            this.gZg.setNumColumns(i);
            this.nEs.Kc(i);
            this.nEs.setDatas(list);
        }
        if (cVar != null) {
            this.nEx = cVar;
            if (this.nEx.nEW != null && this.nEx.nEW.vip_extra_switch.intValue() == 1 && this.nEx.nEW.vip_extra_percent.intValue() > 0) {
                this.nEB = true;
                this.nEz.setVisibility(0);
                this.nEy.setVisibility(8);
                this.nEA.setText(String.format(this.nEl.getString(R.string.user_define_member_tbean_extra), this.nEx.nEW.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nEr.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nEr.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nEC.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nEC.setLayoutParams(layoutParams2);
                }
            } else {
                this.nEz.setVisibility(8);
                this.nEB = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nEr.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nEr.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nEC.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nEl.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nEC.setLayoutParams(layoutParams4);
                }
            }
            if (this.nEx.nEV != null) {
                this.nEH.setText(this.nEl.getString(R.string.icon_name_valid_day, new Object[]{this.nEx.nEV.name, Integer.valueOf(this.nEx.nEV.duration == null ? 0 : this.nEx.nEV.duration.intValue())}));
            }
        }
        if (!y.isEmpty(list2)) {
            this.nEI.fS(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nEL = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nEL;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nEK = a.this.grb.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nET);
    }
}
