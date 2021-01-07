package com.baidu.tieba.memberCenter.memberpay;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes9.dex */
public class MemberPayView extends LinearLayout {
    private NoNetworkView gCe;
    private f.g llR;
    private f.b llS;
    private f.c llT;
    private f.a llU;
    private String llV;
    private String llW;
    private String llX;
    private long llY;
    private int llh;
    private Boolean llk;
    private MemberPayActivity lmT;
    private RadioGroup lmU;
    private RadioButton lmV;
    private RadioButton lmW;
    private LinearLayout lmX;
    private LinearLayout lmY;
    private TextView lmZ;
    private View lna;
    private TextView lnb;
    private View lnc;
    private TextView lnd;
    private TextView lne;
    private TbImageView lnf;
    private TbImageView lnh;
    private ImageView lni;
    private ImageView lnj;
    private String lnk;
    private String lnl;
    private String lnm;
    private String lnn;
    private int lno;
    private int lnp;
    private int lnq;
    private boolean lnr;
    private f mData;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private String mTitle;

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.lno = 35;
        this.lnp = 12;
        this.llh = 2;
        this.lnr = false;
        this.llk = false;
        this.lmT = memberPayActivity;
        this.lnq = i;
        this.llk = Boolean.valueOf(z);
        initView();
    }

    private void initView() {
        this.lmT.setContentView(R.layout.member_pay_activity);
        this.mRootView = this.lmT.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.lmT.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.lmT.findViewById(R.id.view_no_network);
        this.lmX = (LinearLayout) this.lmT.findViewById(R.id.container);
        this.lmU = (RadioGroup) this.lmT.findViewById(R.id.btns_mem_select);
        this.lmU.setOnCheckedChangeListener(this.lmT);
        this.lmV = (RadioButton) this.lmT.findViewById(R.id.btn_mem1);
        this.lmW = (RadioButton) this.lmT.findViewById(R.id.btn_mem2);
        this.lnc = this.lmT.findViewById(R.id.v_blank);
        this.lne = (TextView) this.lmT.findViewById(R.id.goods_des);
        this.lnf = (TbImageView) this.lmT.findViewById(R.id.bdimg_adv);
        this.lnh = (TbImageView) this.lmT.findViewById(R.id.bdimg_comm);
        this.lni = (ImageView) this.lmT.findViewById(R.id.crumb_adv);
        this.lnj = (ImageView) this.lmT.findViewById(R.id.crumb_comm);
        this.lnd = (TextView) this.lmT.findViewById(R.id.aotu_pay_law);
        this.lnd.setOnClickListener(this.lmT);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        FQ(this.llh);
    }

    public void tL(boolean z) {
        List<f.d> list;
        if (this.mData != null) {
            if (2 == this.llh) {
                if (this.llU != null && this.llU.lmp != null) {
                    list = this.llU.lmp;
                }
                list = null;
            } else {
                if (this.llT != null && this.llT.lmp != null) {
                    list = this.llT.lmp;
                }
                list = null;
            }
            if (!x.isEmpty(list)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        f.d dVar = list.get(i2);
                        if (dVar == null || dVar.lmA < 0 || dVar.isAutoPay != 1) {
                            i = i2 + 1;
                        } else {
                            dVar.lmD = z;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void FQ(int i) {
        if (i >= 0 && i <= 2) {
            this.llh = i;
            refreshUI();
        }
    }

    private void refreshUI() {
        if (this.mData == null) {
            this.mRootView.setVisibility(8);
        } else if (this.llS == null || this.llR == null) {
            this.mRootView.setVisibility(8);
        } else if (this.llR.lmJ == null) {
            this.mRootView.setVisibility(8);
        } else if (this.llU == null && this.llT == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lnr && x.isEmpty(this.llU.lmp)) {
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            dhp();
            dhw();
            dhr();
            dhx();
        }
    }

    private void initData() {
        if (this.mData != null) {
            this.llS = this.mData.llS;
            this.llR = this.mData.llR;
            if (this.llS != null && this.llR != null && this.llR.lmJ != null) {
                this.llY = this.llR.lmJ.lmE;
                this.lnr = this.llY == 2 || this.lnq == 2;
                this.llU = this.llS.lmu;
                if (this.llU != null) {
                    this.llV = this.llU.mContent;
                    this.lnk = this.llU.lmr;
                    this.lnl = this.llU.lms;
                    this.llT = this.llS.lmt;
                    if (this.llT != null) {
                        this.llW = this.llT.mContent;
                        this.lnm = this.llT.lmr;
                        this.lnn = this.llT.lms;
                    }
                }
            }
        }
    }

    private void dhw() {
        this.lmV.setText(bB(this.llV, this.lnp));
        if (2 == this.llh) {
            if (at.isEmpty(this.lnk)) {
                this.lne.setVisibility(8);
                this.lni.setVisibility(8);
            } else {
                this.lne.setVisibility(0);
                this.lni.setVisibility(0);
                this.lne.setText(this.lnk);
            }
        } else if (at.isEmpty(this.lnm)) {
            this.lne.setVisibility(8);
            this.lnj.setVisibility(8);
        } else {
            this.lne.setVisibility(0);
            this.lnj.setVisibility(0);
            this.lne.setText(this.lnm);
        }
        this.lnf.setDefaultBgResource(0);
        this.lnh.setDefaultBgResource(0);
        this.lnf.setAutoChangeStyle(false);
        this.lnh.setAutoChangeStyle(false);
        if (at.isEmpty(this.llU.lms)) {
            ao.setImageResource(this.lnf, R.drawable.icon_vip_advanced, 0);
        } else {
            this.lnf.startLoad(this.llU.lms, 10, false);
        }
        if (this.lnr || this.llT == null || x.isEmpty(this.llT.lmp)) {
            this.lmW.setVisibility(8);
            this.lnh.setVisibility(8);
            this.lnj.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
            this.lnj.setVisibility(8);
        } else {
            this.lmW.setVisibility(0);
            this.lmW.setText(bB(this.llW, this.lnp));
            this.lnh.setVisibility(0);
            if (at.isEmpty(this.llT.lms)) {
                ao.setImageResource(this.lnh, R.drawable.icon_vip_member, 0);
            } else {
                this.lnh.startLoad(this.llT.lms, 21, false);
            }
        }
        if (this.lnc != null) {
            this.lnc.setVisibility(8);
        }
    }

    private void dhp() {
        List<f.d> list;
        Boolean bool = false;
        if (2 == this.llh) {
            if (this.llU != null && this.llU.lmp != null) {
                list = this.llU.lmp;
            }
            list = null;
        } else {
            if (this.llT != null && this.llT.lmp != null) {
                list = this.llT.lmp;
            }
            list = null;
        }
        if (!x.isEmpty(list)) {
            this.lmX.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.lmA >= 0) {
                    Boolean bool2 = dVar.isAutoPay == 1 ? true : bool;
                    a aVar = new a();
                    View inflate = LayoutInflater.from(this.lmT.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    aVar.lns = (TextView) inflate.findViewById(R.id.cb);
                    aVar.lnt = (TextView) inflate.findViewById(R.id.tv_month);
                    aVar.lnu = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    aVar.lnv = (TextView) inflate.findViewById(R.id.tv_discount);
                    aVar.lnw = (TextView) inflate.findViewById(R.id.tv_money);
                    aVar.mRootView = (RelativeLayout) inflate.findViewById(R.id.root);
                    aVar.lnx = inflate.findViewById(R.id.v_line);
                    aVar.lnt.setText(bB(dVar.mTitle, 7));
                    if (!TextUtils.isEmpty(dVar.mIcon)) {
                        aVar.lnu.setVisibility(0);
                        aVar.lnu.startLoad(dVar.mIcon, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.mDiscount)) {
                        aVar.lnv.setVisibility(8);
                    } else {
                        aVar.lnv.setVisibility(0);
                        aVar.lnv.setText(bB(dVar.mDiscount, 10));
                    }
                    aVar.lnw.setText("¥" + (dVar.lmA / 100));
                    if (dVar.isChecked) {
                        ao.setBackgroundResource(aVar.lns, R.drawable.btn_non_orange_s);
                        ao.setViewTextColor(aVar.lns, R.color.CAM_X0101);
                    } else {
                        ao.setBackgroundResource(aVar.lns, R.drawable.btn_non_orange_n);
                        ao.setViewTextColor(aVar.lns, R.color.CAM_X0305);
                    }
                    aVar.lns.setTag(dVar);
                    aVar.lns.setText(R.string.click_open);
                    inflate.setContentDescription(bB(dVar.mTitle, 7));
                    inflate.setOnClickListener(new b(list));
                    inflate.setTag(aVar);
                    inflate.setLayoutParams(layoutParams);
                    com.baidu.tbadk.r.a.a(this.lmT.getPageContext(), inflate);
                    a(list, i2, aVar);
                    this.lmX.addView(inflate);
                    bool = bool2;
                }
                i = i2 + 1;
            }
            if (bool.booleanValue()) {
                this.lmY = (LinearLayout) LayoutInflater.from(this.lmT.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.lmZ = (TextView) this.lmY.findViewById(R.id.tv_member_agreement_auto_pay);
                this.lna = this.lmY.findViewById(R.id.view_agreement_divider_auto_pay);
                this.lnb = (TextView) this.lmY.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.lmZ.setOnClickListener(this.lmT);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ao.setBackgroundColor(this.lna, R.color.CAM_X0204_1);
                }
                this.lnb.setOnClickListener(this.lmT);
                this.lmX.addView(this.lmY);
                return;
            }
            this.lmY = (LinearLayout) LayoutInflater.from(this.lmT.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.lmZ = (TextView) this.lmY.findViewById(R.id.tv_member_agreement_normal);
            this.lmZ.setOnClickListener(this.lmT);
            this.lmX.addView(this.lmY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private List<f.d> ivn;

        public b(List<f.d> list) {
            this.ivn = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            f.d dVar;
            if (MemberPayView.this.lmX != null) {
                f.d dVar2 = null;
                for (int i = 0; i < MemberPayView.this.lmX.getChildCount(); i++) {
                    View childAt = MemberPayView.this.lmX.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                        if (textView.getTag() instanceof f.d) {
                            dVar = (f.d) textView.getTag();
                            if (view == childAt) {
                                dVar.isChecked = true;
                                ao.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                                ao.setViewTextColor(textView, R.color.CAM_X0101);
                                MemberPayView.this.a(this.ivn, i, (a) childAt.getTag());
                                dVar2 = dVar;
                            } else {
                                dVar.isChecked = false;
                                ao.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                                ao.setViewTextColor(textView, R.color.CAM_X0305);
                            }
                        }
                        dVar = dVar2;
                        MemberPayView.this.a(this.ivn, i, (a) childAt.getTag());
                        dVar2 = dVar;
                    }
                }
                if (dVar2 != null) {
                    if (dVar2.isAutoPay != 1 || !dVar2.lmD) {
                        MemberPayView.this.b(dVar2.lmz, dVar2.lmA / 100, dVar2.lmC, dVar2.isAutoPay);
                    } else {
                        l.showToast(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.llk.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.lmT.getReferPage(), this.lmT.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.lmT.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lmT.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.lmT.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        com.baidu.tbadk.pay.c.bHw().a(payConfig, this.lmT.getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<f.d> list, int i, a aVar) {
        f.d dVar;
        if (list != null && i < list.size() && aVar != null && (dVar = list.get(i)) != null) {
            if (i == 0) {
                if (dVar.isChecked) {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_up_s);
                } else {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_up_n);
                }
                aVar.lnx.setVisibility(0);
            } else if (i == list.size() - 1) {
                if (dVar.isChecked) {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_s);
                } else {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_n);
                }
                aVar.lnx.setVisibility(8);
            } else {
                if (dVar.isChecked) {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_s);
                } else {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_n);
                }
                aVar.lnx.setVisibility(0);
            }
        }
    }

    private void dhr() {
        String str = null;
        if (2 == this.llh) {
            if (this.llY == 2) {
                str = this.lmT.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.llV});
            } else {
                str = this.lmT.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.llV});
            }
            this.llX = this.llV;
        } else if (1 == this.llh) {
            if (this.llY == 1) {
                str = this.lmT.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.llW});
            } else if (this.llY == 0) {
                str = this.lmT.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.llW});
            }
            this.llX = this.llW;
        } else {
            str = this.lmT.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.llW});
            this.llX = this.llW;
        }
        this.mTitle = str;
        if (!StringUtils.isNULL(str)) {
            this.mNavigationBar.setTitleText(bB(str, 10));
        }
    }

    private void dhx() {
        if (2 == this.llh) {
            if (!at.isEmpty(this.lnk)) {
                this.lne.setText(this.lnk);
                this.lni.setVisibility(0);
                this.lnj.setVisibility(4);
                return;
            }
            this.lni.setVisibility(4);
            this.lnj.setVisibility(4);
        } else if (1 == this.llh) {
            if (!at.isEmpty(this.lnm)) {
                this.lne.setText(this.lnm);
                this.lni.setVisibility(4);
                this.lnj.setVisibility(0);
                return;
            }
            this.lni.setVisibility(4);
            this.lnj.setVisibility(4);
        }
    }

    public String bB(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getCurrentContent() {
        return this.llX;
    }

    public int getCurrentShowType() {
        return this.llh;
    }

    public NoNetworkView getNoNetworkView() {
        return this.gCe;
    }

    public void onChangeSkinType(int i) {
        this.lmT.getLayoutMode().setNightMode(i == 1);
        this.lmT.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lmT.getPageContext(), i);
        this.gCe.onChangeSkinType(this.lmT.getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public TextView lns;
        public TextView lnt;
        public TbImageView lnu;
        public TextView lnv;
        public TextView lnw;
        public View lnx;
        public RelativeLayout mRootView;

        private a() {
        }
    }
}
