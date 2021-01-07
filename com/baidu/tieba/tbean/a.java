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
/* loaded from: classes9.dex */
public class a {
    private int bNX;
    private ImageView eqT;
    private NoScrollGridView gZf;
    private RelativeLayout grc;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleView;
    private BuyTBeanActivity nwC;
    private RoundRelativeLayout nwI;
    private com.baidu.tieba.tbean.a.a nwJ;
    private TextView nwK;
    private TextView nwL;
    private EditText nwM;
    private TextView nwN;
    private com.baidu.tieba.tbean.b.c nwO;
    private TextView nwP;
    private LinearLayout nwQ;
    private TextView nwR;
    private boolean nwS;
    private TextView nwT;
    private TextView nwU;
    private TextView nwV;
    private TextView nwW;
    private SpannableString nwX;
    private TextView nwY;
    private BuyTBeanGiftBagView nwZ;
    private UserInfo nxa;
    private int nxb;
    private int nxc;
    private RelativeLayout nxd;
    private BubbleLayout nxe;
    private boolean nxg;
    private long nxf = 0;
    private View.OnClickListener nxh = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.nwM.requestFocus();
            l.showSoftKeyPad(a.this.nwC, a.this.nwM);
        }
    };
    private View.OnClickListener nxi = new View.OnClickListener() { // from class: com.baidu.tieba.tbean.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dRr();
        }
    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.tbean.a.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.tbean.b.b item = a.this.nwJ.getItem(i);
            if (item != null && item.nxo != null) {
                a.this.g(item.nxo.iconId, b.getYuanFromFen(item.nxo.dubi.intValue()) * 1, 1, b.a(a.this.nxa, item.nxo.non_member_t.intValue(), item.nxn) * 1);
                aq aqVar = new aq(TbeanStatisticKey.BUY_TBEAN_NORMAL_ITEM);
                aqVar.dX("obj_param1", item.nxo.iconId);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private BuyTBeanGiftBagView.a nxj = new BuyTBeanGiftBagView.a() { // from class: com.baidu.tieba.tbean.a.4
        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.a
        public void a(com.baidu.tieba.tbean.b.a aVar) {
            if (aVar != null && aVar.nxm != null) {
                a.this.g(aVar.nxm.icon_id, b.getYuanFromFen(aVar.nxm.dubi.intValue()) * 1, 1, aVar.nxm.non_member_t.intValue() * 1);
                TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
            }
        }
    };
    private Runnable nxk = new Runnable() { // from class: com.baidu.tieba.tbean.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.nxe != null) {
                a.this.nxe.setVisibility(8);
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
            String obj = a.this.nwM.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.nwS) {
                    a.this.nwP.setVisibility(8);
                    a.this.nwR.setText(String.format(a.this.nwC.getString(R.string.user_define_member_tbean_extra), a.this.nwO.nxn.vip_extra_percent));
                }
                a.this.nwT.setEnabled(false);
                a.this.nwM.setHint(a.this.nwX);
            } else if (obj.startsWith("0")) {
                if (a.this.nwS) {
                    a.this.nwP.setVisibility(8);
                    a.this.nwR.setText(String.format(a.this.nwC.getString(R.string.user_define_member_tbean_extra), a.this.nwO.nxn.vip_extra_percent));
                }
                a.this.nwM.setText("");
            } else {
                a.this.nwT.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.nwC.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.nwM.setText(substring);
                    a.this.nwM.setSelection(substring.length());
                    return;
                }
                long j = com.baidu.adp.lib.f.b.toLong(obj, 0L);
                if (j > 200000) {
                    a.this.nwC.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (j <= 0) {
                    a.this.nwN.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.nwM.setHint("");
                a.this.nwN.setText(at.formatTosepara(j * 1000));
                if (a.this.nwS && a.this.nwO != null && a.this.nwO.nxn != null) {
                    a.this.nwP.setVisibility(0);
                    a.this.nwP.setText(b.formatTBeanNum(((j * 1000) * a.this.nwO.nxn.vip_extra_percent.intValue()) / 100));
                }
            }
        }
    };

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.nwC = buyTBeanActivity;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nwC).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.mRootView.setFocusable(true);
        this.mRootView.setOnClickListener(this.nwC);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_panel_layout);
        this.nwI = (RoundRelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.nwI.setRadius(this.nwC.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nwI.setOnClickListener(this.nxh);
        this.grc = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_content_layout);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.buy_tbean_title);
        this.gZf = (NoScrollGridView) this.mRootView.findViewById(R.id.buy_tbean_gridview);
        this.nwJ = new com.baidu.tieba.tbean.a.a(this.nwC.getPageContext());
        this.gZf.setAdapter((ListAdapter) this.nwJ);
        this.gZf.setOnItemClickListener(this.mItemClickListener);
        this.nxd = (RelativeLayout) this.mRootView.findViewById(R.id.buy_tbean_balance_layout);
        this.nwL = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance_tip);
        this.nwK = (TextView) this.mRootView.findViewById(R.id.buy_tbean_balance);
        this.nwK.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.nwC.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.nwK.setCompoundDrawablePadding(this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.nwK.setCompoundDrawables(drawable, null, null, null);
        this.nwM = (EditText) this.mRootView.findViewById(R.id.buy_tbean_custom_price_edit);
        this.nwX = new SpannableString(this.nwC.getString(R.string.buy_tbean_user_define_hint));
        this.nwX.setSpan(new AbsoluteSizeSpan(this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds42), false), 0, this.nwX.length(), 33);
        this.nwM.setHint(this.nwX);
        this.nwM.addTextChangedListener(this.mTextWatcher);
        this.nwN = (TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.nwN.setCompoundDrawablePadding(this.nwC.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nwN.setCompoundDrawables(drawable, null, null, null);
        this.nwQ = (LinearLayout) this.mRootView.findViewById(R.id.buy_tbean_member_layout);
        this.nwP = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.nwC.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.nwC.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.nwP.setCompoundDrawablePadding(this.nwC.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.nwP.setCompoundDrawables(drawable2, null, null, null);
        this.nwR = (TextView) this.mRootView.findViewById(R.id.buy_tbean_member_prefix);
        this.nwT = (TextView) this.mRootView.findViewById(R.id.buy_tbean_recharge);
        this.nwT.setOnClickListener(this.nxi);
        this.nwU = (TextView) this.mRootView.findViewById(R.id.buy_tbean_use_rule);
        this.nwU.setOnClickListener(this.nwC);
        this.nwV = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value);
        this.nwV.setCompoundDrawablePadding(this.nwC.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.nwV.setCompoundDrawables(drawable, null, null, null);
        this.nwW = (TextView) this.mRootView.findViewById(R.id.buy_tbean_diff_value_tip);
        this.eqT = (ImageView) this.mRootView.findViewById(R.id.buy_tbean_close_image);
        this.eqT.setOnClickListener(this.nwC);
        this.nwY = (TextView) this.mRootView.findViewById(R.id.buy_tbean_yinji_time);
        this.nwZ = (BuyTBeanGiftBagView) this.mRootView.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.nwZ.setClickListener(this.nxj);
        this.nxe = (BubbleLayout) this.mRootView.findViewById(R.id.buy_tbean_pop_view);
        yq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRr() {
        int i = com.baidu.adp.lib.f.b.toInt(this.nwM.getText().toString(), 0);
        int i2 = i * 1;
        if (i2 > 200000) {
            this.nwC.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i2 > 0 && i2 > 0 && this.nwO != null && this.nwO.userInfo != null && this.nwO.nxm != null) {
            UserInfo userInfo = this.nwO.userInfo;
            g(this.nwO.nxm.icon_id, i2, i, b.a(userInfo, i2 * 1000, this.nwO.nxn) * 1);
            TiebaStatic.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i, int i2, int i3) {
        if (!StringUtils.isNull(str) && i >= 0 && i2 >= 0 && i3 >= 0) {
            if (!j.isNetWorkAvailable()) {
                this.nwC.showToast(this.nwC.getResources().getString(R.string.network_not_available));
                return;
            }
            c.Pu(TbeanStatisticKey.BUY_TBEAN_BUY);
            PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.nwC.dRj(), PageDialogHelper.PayForm.NOT_SET, this.nwC.getReferPage(), this.nwC.getClickZone());
            payConfig.setFromDecreaseGiftStepStrategy(this.nwC.isFromDecreaseGiftStepStrategy());
            com.baidu.tbadk.pay.c.bHw().a(payConfig, this.nwC);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.nxg = true;
            if (this.bNX <= 0) {
                this.bNX = (l.getEquipmentHeight(this.nwC) - this.mRootView.getHeight()) - l.getStatusBarHeight(this.nwC);
            }
            int height = ((this.bNX + this.nwI.getHeight()) + this.nxd.getHeight()) - this.nxb;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
                layoutParams.topMargin -= height;
                this.mPanelLayout.setLayoutParams(layoutParams);
                this.grc.scrollTo(0, this.bNX - height);
            } else {
                this.grc.scrollTo(0, this.bNX);
            }
            this.nwM.setSelection(this.nwM.getText().length());
            TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            return;
        }
        this.nxg = false;
        this.grc.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        layoutParams2.topMargin = this.nxc;
        this.mPanelLayout.setLayoutParams(layoutParams2);
        this.nwM.clearFocus();
    }

    public boolean dRs() {
        return this.nxg;
    }

    public void hideSoftKeyPad() {
        this.nwM.clearFocus();
        l.hideSoftKeyPad(this.nwC, this.nwM);
    }

    public void hC(long j) {
        if (j > 0) {
            this.nxf = j;
            this.nwM.setText((j / 1000) + "");
            this.nwM.setSelection(this.nwM.getText().length());
            this.nwV.setText(((j / 1000) * 1000) + "");
            this.nwV.setVisibility(0);
            this.nwW.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_tbean_buy_bubble_show", false)) {
                if (this.nxe != null) {
                    this.nxe.setVisibility(0);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_tbean_buy_bubble_show", true);
                }
                e.mB().removeCallbacks(this.nxk);
                e.mB().postDelayed(this.nxk, 4000L);
                return;
            }
            return;
        }
        this.nwM.setText("");
        this.nxe.setVisibility(8);
    }

    private void yq(boolean z) {
        if (z) {
            this.nwT.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.nwC.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.nwM.setLayoutParams(layoutParams);
            return;
        }
        this.nwT.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nwM.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.nwC.getResources().getDimensionPixelSize(R.dimen.ds42);
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

    public void cKk() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPanelLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.nwC.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.mPanelLayout.setLayoutParams(layoutParams);
        }
        this.nwC.setNetRefreshViewTopMargin(this.nwC.getResources().getDimensionPixelSize(R.dimen.ds50));
        this.nwC.showNetRefreshView(this.grc, this.nwC.getResources().getString(R.string.neterror));
    }

    public void cKl() {
        this.nwC.hideNetRefreshView(this.grc);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mPanelLayout, R.drawable.buy_tbean_circle_bg, i);
        ao.setViewTextColor(this.nwL, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nwK, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nwV, R.color.common_color_10191, 1, i);
        ao.setViewTextColor(this.nwW, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nwU, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        if (i == 1 || i == 4) {
            this.nwI.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nwI.setBgColorRes(R.color.CAM_X0201);
        }
        ao.setViewTextColor(this.nwN, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nwY, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nwR, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nwP, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nwM, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor((TextView) this.mRootView.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        if (this.nwJ != null) {
            this.nwJ.notifyDataSetChanged();
        }
    }

    public void a(List<com.baidu.tieba.tbean.b.b> list, com.baidu.tieba.tbean.b.c cVar, List<com.baidu.tieba.tbean.b.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.nxa = userInfo;
        }
        if (!x.isEmpty(list)) {
            int i = x.getCount(list) == 6 ? 3 : 2;
            this.gZf.setNumColumns(i);
            this.nwJ.Lk(i);
            this.nwJ.setDatas(list);
        }
        if (cVar != null) {
            this.nwO = cVar;
            if (this.nwO.nxn != null && this.nwO.nxn.vip_extra_switch.intValue() == 1 && this.nwO.nxn.vip_extra_percent.intValue() > 0) {
                this.nwS = true;
                this.nwQ.setVisibility(0);
                this.nwP.setVisibility(8);
                this.nwR.setText(String.format(this.nwC.getString(R.string.user_define_member_tbean_extra), this.nwO.nxn.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nwI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.nwI.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nwT.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.nwT.setLayoutParams(layoutParams2);
                }
            } else {
                this.nwQ.setVisibility(8);
                this.nwS = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nwI.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.nwI.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nwT.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.nwC.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.nwT.setLayoutParams(layoutParams4);
                }
            }
            if (this.nwO.nxm != null) {
                this.nwY.setText(this.nwC.getString(R.string.icon_name_valid_day, new Object[]{this.nwO.nxm.name, Integer.valueOf(this.nwO.nxm.duration == null ? 0 : this.nwO.nxm.duration.intValue())}));
            }
        }
        if (!x.isEmpty(list2)) {
            this.nwZ.fU(list2);
        }
        this.mPanelLayout.post(new Runnable() { // from class: com.baidu.tieba.tbean.a.7
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = a.this.mRootView.getMeasuredHeight();
                int measuredHeight2 = a.this.mPanelLayout.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) a.this.mPanelLayout.getLayoutParams();
                if (layoutParams5 != null) {
                    a.this.nxc = measuredHeight - measuredHeight2;
                    layoutParams5.topMargin = a.this.nxc;
                    a.this.mPanelLayout.setLayoutParams(layoutParams5);
                }
                a.this.nxb = a.this.grc.getHeight();
            }
        });
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nxk);
    }
}
