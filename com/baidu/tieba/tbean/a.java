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
    private NoScrollGridView gXj;
    private RelativeLayout gpe;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleView;
    private BuyTBeanActivity nBG;
    private RoundRelativeLayout nBM;
    private com.baidu.tieba.tbean.a.a nBN;
    private TextView nBO;
    private TextView nBP;
    private EditText nBQ;
    private TextView nBR;
    private com.baidu.tieba.tbean.b.c nBS;
    private TextView nBT;
    private LinearLayout nBU;
    private TextView nBV;
    private boolean nBW;
    private TextView nBX;
    private TextView nBY;
    private TextView nBZ;
    private TextView nCa;
    private SpannableString nCb;
    private TextView nCc;
    private BuyTBeanGiftBagView nCd;
    private UserInfo nCe;
    private int nCf;
    private int nCg;
    private RelativeLayout nCh;
    private BubbleLayout nCi;
    private boolean nCk;
    private long nCj = 0;
    private View.OnClickListener nCl = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nBQ.requestFocus();
            l.showSoftKeyPad(a.this.nBG, a.this.nBQ);
        }
    };
    private View.OnClickListener nCm = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dPK();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nBN.getItem(i);
            if (item != null && item.nCs != null) {
                a.this.g(item.nCs.iconId, b.getYuanFromFen(item.nCs.dubi.intValue()) * 1, 1, b.a(a.this.nCe, item.nCs.non_member_t.intValue(), item.nCr) * 1);
                ar arVar = new ar(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                arVar.dR("obj_param1", item.nCs.iconId);
                TiebaStatic.log(arVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nCn = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nCq != null) {
                a.this.g(aVar.nCq.icon_id, b.getYuanFromFen(aVar.nCq.dubi.intValue()) * 1, 1, aVar.nCq.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nCo = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nCi != null) {
                a.this.nCi.setVisibility(8);
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
            String obj = a.this.nBQ.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nBW) {
                    a.this.nBT.setVisibility(8);
                    a.this.nBV.setText(String.format(a.this.nBG.getString(R.string.user_define_member_tbean_extra), a.this.nBS.nCr.vip_extra_percent));
                }
                a.this.nBX.setEnabled(false);
                a.this.nBQ.setHint(a.this.nCb);
            } else if (obj.startsWith("0")) {
                if (a.this.nBW) {
                    a.this.nBT.setVisibility(8);
                    a.this.nBV.setText(String.format(a.this.nBG.getString(R.string.user_define_member_tbean_extra), a.this.nBS.nCr.vip_extra_percent));
                }
                a.this.nBQ.setText("");
            } else {
                a.this.nBX.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nBG.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nBQ.setText(substring);
                    a.this.nBQ.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nBG.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nBR.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nBQ.setHint("");
                a.this.nBR.setText(au.formatTosepara(j * 1000));
                if (a.this.nBW && a.this.nBS != null && a.this.nBS.nCr != null) {
                    a.this.nBT.setVisibility(0);
                    a.this.nBT.setText(b.formatTBeanNum(((j * 1000) * a.this.nBS.nCr.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nBG = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nBG).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nBG);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nBM = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nBM.setRadius(this.nBG.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nBM.setOnClickListener(this.nCl);
        this.gpe = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gXj = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nBN = new com.baidu.tieba.tbean.a.a(this.nBG.getPageContext());
        this.gXj.setAdapter((ListAdapter) this.nBN);
        this.gXj.setOnItemClickListener(this.mItemClickListener);
        this.nCh = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nBP = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nBO = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nBO.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nBG.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nBO.setCompoundDrawablePadding(this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nBO.setCompoundDrawables(drawable, null, null, null);
        this.nBQ = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nCb = new SpannableString(this.nBG.getString(R.string.buy_tbean_user_define_hint));
        this.nCb.setSpan(new AbsoluteSizeSpan(this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nCb.length(), 33);
        this.nBQ.setHint(this.nCb);
        this.nBQ.addTextChangedListener(this.mTextWatcher);
        this.nBR = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nBR.setCompoundDrawablePadding(this.nBG.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nBR.setCompoundDrawables(drawable, null, null, null);
        this.nBU = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nBT = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nBG.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nBG.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nBT.setCompoundDrawablePadding(this.nBG.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nBT.setCompoundDrawables(drawable2, null, null, null);
        this.nBV = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nBX = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nBX.setOnClickListener(this.nCm);
        this.nBY = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nBY.setOnClickListener(this.nBG);
        this.nBZ = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nBZ.setCompoundDrawablePadding(this.nBG.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nBZ.setCompoundDrawables(drawable, null, null, null);
        this.nCa = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.eoo = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.eoo.setOnClickListener(this.nBG);
        this.nCc = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nCd = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nCd.setClickListener(this.nCn);
        this.nCi = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        yF(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPK() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nBQ.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nBG.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nBS != null && this.nBS.userInfo != null && this.nBS.nCq != null) {
            UserInfo userInfo = this.nBS.userInfo;
            g(this.nBS.nCq.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nBS.nCr) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nBG.showToast(this.nBG.getResources().getString(R.string.network_not_available));
                return;
            }
            c.Pe(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nBG.dPC(), PageDialogHelper.PayForm.NOT_SET, this.nBG.getReferPage(), this.nBG.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nBG.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bDV().a(payConfig, this.nBG);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nCk = true;
            if (this.bMV <= 0) {
                this.bMV = (l.getEquipmentHeight(this.nBG) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nBG);
            }
            int height = ((this.bMV + this.nBM.getHeight()) + this.nCh.getHeight()) - this.nCf;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.gpe.scrollTo(0, this.bMV - height);
            } else {
                this.gpe.scrollTo(0, this.bMV);
            }
            this.nBQ.setSelection(this.nBQ.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nCk = false;
        this.gpe.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nCg;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nBQ.clearFocus();
    }

    public boolean dPL() {
        return this.nCk;
    }

    public void hideSoftKeyPad() {
        this.nBQ.clearFocus();
        l.hideSoftKeyPad(this.nBG, this.nBQ);
    }

    public void hH(long j) {
        if (j > 0) {
            this.nCj = j;
            this.nBQ.setText((j / 1000) + "");
            this.nBQ.setSelection(this.nBQ.getText().length());
            this.nBZ.setText(((j / 1000) * 1000) + "");
            this.nBZ.setVisibility(0);
            this.nCa.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nCi != null) {
                    this.nCi.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mA().removeCallbacks(this.nCo);
                e.mA().postDelayed(this.nCo, 4000L);
                return;
            }
            return;
        }
        this.nBQ.setText("");
        this.nCi.setVisibility(8);
    }

    private void yF(boolean z) {
        if (z) {
            this.nBX.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nBG.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nBQ.setLayoutParams(layoutParams);
            return;
        }
        this.nBX.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nBQ.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nBG.getResources().getDimensionPixelSize(R.dimen.ds42);
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

    public void cHF() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.nBG.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nBG.setNetRefreshViewTopMargin(this.nBG.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nBG.showNetRefreshView(this.gpe, this.nBG.getResources().getString(R.string.neterror));
    }

    public void cHG() {
        this.nBG.hideNetRefreshView(this.gpe);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ap.setViewTextColor(this.nBP, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nBO, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nBZ, R.color.common_color_10191, 1, i);
        ap.setViewTextColor(this.nCa, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nBY, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nBM.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nBM.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nBR, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCc, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nBV, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nBT, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nBQ, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nBN != null) {
            this.nBN.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nCe = userInfo;
        }
        if (!y.isEmpty(list)) {
            int i = y.getCount(list) == 6 ? 3 : 2;
            this.gXj.setNumColumns(i);
            this.nBN.JX(i);
            this.nBN.setDatas(list);
        }
        if (cVar != null) {
            this.nBS = cVar;
            if (this.nBS.nCr != null && this.nBS.nCr.vip_extra_switch.intValue() == 1 && this.nBS.nCr.vip_extra_percent.intValue() > 0) {
                this.nBW = true;
                this.nBU.setVisibility(0);
                this.nBT.setVisibility(8);
                this.nBV.setText(String.format(this.nBG.getString(R.string.user_define_member_tbean_extra), this.nBS.nCr.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nBM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nBM.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nBX.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nBX.setLayoutParams(layoutParams2);
                }
            } else {
                this.nBU.setVisibility(8);
                this.nBW = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nBM.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nBM.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nBX.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nBG.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nBX.setLayoutParams(layoutParams4);
                }
            }
            if (this.nBS.nCq != null) {
                this.nCc.setText(this.nBG.getString(R.string.icon_name_valid_day, new Object[]{this.nBS.nCq.name, Integer.valueOf(this.nBS.nCq.duration == null ? 0 : this.nBS.nCq.duration.intValue())}));
            }
        }
        if (!y.isEmpty(list2)) {
            this.nCd.fS(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nCg = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nCg;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nCf = a.this.gpe.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nCo);
    }
}
