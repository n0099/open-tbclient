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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes8.dex */
public class MemberPayView extends LinearLayout {
    private NoNetworkView gCe;
    private int lqZ;
    private f.g lrJ;
    private f.b lrK;
    private f.c lrL;
    private f.a lrM;
    private String lrN;
    private String lrO;
    private String lrP;
    private long lrQ;
    private Boolean lrc;
    private MemberPayActivity lsL;
    private RadioGroup lsM;
    private RadioButton lsN;
    private RadioButton lsO;
    private LinearLayout lsP;
    private LinearLayout lsQ;
    private TextView lsR;
    private View lsS;
    private TextView lsT;
    private View lsU;
    private TextView lsV;
    private TextView lsW;
    private TbImageView lsX;
    private TbImageView lsY;
    private ImageView lsZ;
    private ImageView lta;
    private String ltb;
    private String ltc;
    private String ltd;
    private String lte;
    private int ltf;
    private int ltg;
    private int lth;
    private boolean lti;
    private f mData;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private String mTitle;

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.ltf = 35;
        this.ltg = 12;
        this.lqZ = 2;
        this.lti = false;
        this.lrc = false;
        this.lsL = memberPayActivity;
        this.lth = i;
        this.lrc = Boolean.valueOf(z);
        initView();
    }

    private void initView() {
        this.lsL.setContentView(R.layout.member_pay_activity);
        this.mRootView = this.lsL.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.lsL.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.lsL.findViewById(R.id.view_no_network);
        this.lsP = (LinearLayout) this.lsL.findViewById(R.id.container);
        this.lsM = (RadioGroup) this.lsL.findViewById(R.id.btns_mem_select);
        this.lsM.setOnCheckedChangeListener(this.lsL);
        this.lsN = (RadioButton) this.lsL.findViewById(R.id.btn_mem1);
        this.lsO = (RadioButton) this.lsL.findViewById(R.id.btn_mem2);
        this.lsU = this.lsL.findViewById(R.id.v_blank);
        this.lsW = (TextView) this.lsL.findViewById(R.id.goods_des);
        this.lsX = (TbImageView) this.lsL.findViewById(R.id.bdimg_adv);
        this.lsY = (TbImageView) this.lsL.findViewById(R.id.bdimg_comm);
        this.lsZ = (ImageView) this.lsL.findViewById(R.id.crumb_adv);
        this.lta = (ImageView) this.lsL.findViewById(R.id.crumb_comm);
        this.lsV = (TextView) this.lsL.findViewById(R.id.aotu_pay_law);
        this.lsV.setOnClickListener(this.lsL);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        EF(this.lqZ);
    }

    public void tU(boolean z) {
        List<f.d> list;
        if (this.mData != null) {
            if (2 == this.lqZ) {
                if (this.lrM != null && this.lrM.lsh != null) {
                    list = this.lrM.lsh;
                }
                list = null;
            } else {
                if (this.lrL != null && this.lrL.lsh != null) {
                    list = this.lrL.lsh;
                }
                list = null;
            }
            if (!y.isEmpty(list)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        f.d dVar = list.get(i2);
                        if (dVar == null || dVar.lss < 0 || dVar.isAutoPay != 1) {
                            i = i2 + 1;
                        } else {
                            dVar.lsv = z;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void EF(int i) {
        if (i >= 0 && i <= 2) {
            this.lqZ = i;
            refreshUI();
        }
    }

    private void refreshUI() {
        if (this.mData == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lrK == null || this.lrJ == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lrJ.lsB == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lrM == null && this.lrL == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lti && y.isEmpty(this.lrM.lsh)) {
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            dfN();
            dfU();
            dfP();
            dfV();
        }
    }

    private void initData() {
        if (this.mData != null) {
            this.lrK = this.mData.lrK;
            this.lrJ = this.mData.lrJ;
            if (this.lrK != null && this.lrJ != null && this.lrJ.lsB != null) {
                this.lrQ = this.lrJ.lsB.lsw;
                this.lti = this.lrQ == 2 || this.lth == 2;
                this.lrM = this.lrK.lsm;
                if (this.lrM != null) {
                    this.lrN = this.lrM.mContent;
                    this.ltb = this.lrM.lsj;
                    this.ltc = this.lrM.lsk;
                    this.lrL = this.lrK.lsl;
                    if (this.lrL != null) {
                        this.lrO = this.lrL.mContent;
                        this.ltd = this.lrL.lsj;
                        this.lte = this.lrL.lsk;
                    }
                }
            }
        }
    }

    private void dfU() {
        this.lsN.setText(bC(this.lrN, this.ltg));
        if (2 == this.lqZ) {
            if (au.isEmpty(this.ltb)) {
                this.lsW.setVisibility(8);
                this.lsZ.setVisibility(8);
            } else {
                this.lsW.setVisibility(0);
                this.lsZ.setVisibility(0);
                this.lsW.setText(this.ltb);
            }
        } else if (au.isEmpty(this.ltd)) {
            this.lsW.setVisibility(8);
            this.lta.setVisibility(8);
        } else {
            this.lsW.setVisibility(0);
            this.lta.setVisibility(0);
            this.lsW.setText(this.ltd);
        }
        this.lsX.setDefaultBgResource(0);
        this.lsY.setDefaultBgResource(0);
        this.lsX.setAutoChangeStyle(false);
        this.lsY.setAutoChangeStyle(false);
        if (au.isEmpty(this.lrM.lsk)) {
            ap.setImageResource(this.lsX, R.drawable.icon_vip_advanced, 0);
        } else {
            this.lsX.startLoad(this.lrM.lsk, 10, false);
        }
        if (this.lti || this.lrL == null || y.isEmpty(this.lrL.lsh)) {
            this.lsO.setVisibility(8);
            this.lsY.setVisibility(8);
            this.lta.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
            this.lta.setVisibility(8);
        } else {
            this.lsO.setVisibility(0);
            this.lsO.setText(bC(this.lrO, this.ltg));
            this.lsY.setVisibility(0);
            if (au.isEmpty(this.lrL.lsk)) {
                ap.setImageResource(this.lsY, R.drawable.icon_vip_member, 0);
            } else {
                this.lsY.startLoad(this.lrL.lsk, 21, false);
            }
        }
        if (this.lsU != null) {
            this.lsU.setVisibility(8);
        }
    }

    private void dfN() {
        List<f.d> list;
        Boolean bool = false;
        if (2 == this.lqZ) {
            if (this.lrM != null && this.lrM.lsh != null) {
                list = this.lrM.lsh;
            }
            list = null;
        } else {
            if (this.lrL != null && this.lrL.lsh != null) {
                list = this.lrL.lsh;
            }
            list = null;
        }
        if (!y.isEmpty(list)) {
            this.lsP.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.lss >= 0) {
                    Boolean bool2 = dVar.isAutoPay == 1 ? true : bool;
                    a aVar = new a();
                    View inflate = LayoutInflater.from(this.lsL.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    aVar.ltj = (TextView) inflate.findViewById(R.id.cb);
                    aVar.ltk = (TextView) inflate.findViewById(R.id.tv_month);
                    aVar.ltl = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    aVar.ltm = (TextView) inflate.findViewById(R.id.tv_discount);
                    aVar.ltn = (TextView) inflate.findViewById(R.id.tv_money);
                    aVar.mRootView = (RelativeLayout) inflate.findViewById(R.id.root);
                    aVar.lto = inflate.findViewById(R.id.v_line);
                    aVar.ltk.setText(bC(dVar.mTitle, 7));
                    if (!TextUtils.isEmpty(dVar.mIcon)) {
                        aVar.ltl.setVisibility(0);
                        aVar.ltl.startLoad(dVar.mIcon, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.mDiscount)) {
                        aVar.ltm.setVisibility(8);
                    } else {
                        aVar.ltm.setVisibility(0);
                        aVar.ltm.setText(bC(dVar.mDiscount, 10));
                    }
                    aVar.ltn.setText("¥" + (dVar.lss / 100));
                    if (dVar.isChecked) {
                        ap.setBackgroundResource(aVar.ltj, R.drawable.btn_non_orange_s);
                        ap.setViewTextColor(aVar.ltj, R.color.CAM_X0101);
                    } else {
                        ap.setBackgroundResource(aVar.ltj, R.drawable.btn_non_orange_n);
                        ap.setViewTextColor(aVar.ltj, R.color.CAM_X0305);
                    }
                    aVar.ltj.setTag(dVar);
                    aVar.ltj.setText(R.string.click_open);
                    inflate.setContentDescription(bC(dVar.mTitle, 7));
                    inflate.setOnClickListener(new b(list));
                    inflate.setTag(aVar);
                    inflate.setLayoutParams(layoutParams);
                    com.baidu.tbadk.r.a.a(this.lsL.getPageContext(), inflate);
                    a(list, i2, aVar);
                    this.lsP.addView(inflate);
                    bool = bool2;
                }
                i = i2 + 1;
            }
            if (bool.booleanValue()) {
                this.lsQ = (LinearLayout) LayoutInflater.from(this.lsL.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.lsR = (TextView) this.lsQ.findViewById(R.id.tv_member_agreement_auto_pay);
                this.lsS = this.lsQ.findViewById(R.id.view_agreement_divider_auto_pay);
                this.lsT = (TextView) this.lsQ.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.lsR.setOnClickListener(this.lsL);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ap.setBackgroundColor(this.lsS, R.color.CAM_X0204_1);
                }
                this.lsT.setOnClickListener(this.lsL);
                this.lsP.addView(this.lsQ);
                return;
            }
            this.lsQ = (LinearLayout) LayoutInflater.from(this.lsL.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.lsR = (TextView) this.lsQ.findViewById(R.id.tv_member_agreement_normal);
            this.lsR.setOnClickListener(this.lsL);
            this.lsP.addView(this.lsQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private List<f.d> iyh;

        public b(List<f.d> list) {
            this.iyh = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            f.d dVar;
            if (MemberPayView.this.lsP != null) {
                f.d dVar2 = null;
                for (int i = 0; i < MemberPayView.this.lsP.getChildCount(); i++) {
                    View childAt = MemberPayView.this.lsP.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                        if (textView.getTag() instanceof f.d) {
                            dVar = (f.d) textView.getTag();
                            if (view == childAt) {
                                dVar.isChecked = true;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                                ap.setViewTextColor(textView, R.color.CAM_X0101);
                                MemberPayView.this.a(this.iyh, i, (a) childAt.getTag());
                                dVar2 = dVar;
                            } else {
                                dVar.isChecked = false;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                                ap.setViewTextColor(textView, R.color.CAM_X0305);
                            }
                        }
                        dVar = dVar2;
                        MemberPayView.this.a(this.iyh, i, (a) childAt.getTag());
                        dVar2 = dVar;
                    }
                }
                if (dVar2 != null) {
                    if (dVar2.isAutoPay != 1 || !dVar2.lsv) {
                        MemberPayView.this.b(dVar2.lsr, dVar2.lss / 100, dVar2.lsu, dVar2.isAutoPay);
                    } else {
                        l.showToast(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lrc.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.lsL.getReferPage(), this.lsL.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.lsL.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lsL.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.lsL.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        com.baidu.tbadk.pay.c.bDZ().a(payConfig, this.lsL.getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<f.d> list, int i, a aVar) {
        f.d dVar;
        if (list != null && i < list.size() && aVar != null && (dVar = list.get(i)) != null) {
            if (i == 0) {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_up_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_up_n);
                }
                aVar.lto.setVisibility(0);
            } else if (i == list.size() - 1) {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_n);
                }
                aVar.lto.setVisibility(8);
            } else {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_n);
                }
                aVar.lto.setVisibility(0);
            }
        }
    }

    private void dfP() {
        String str = null;
        if (2 == this.lqZ) {
            if (this.lrQ == 2) {
                str = this.lsL.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lrN});
            } else {
                str = this.lsL.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lrN});
            }
            this.lrP = this.lrN;
        } else if (1 == this.lqZ) {
            if (this.lrQ == 1) {
                str = this.lsL.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lrO});
            } else if (this.lrQ == 0) {
                str = this.lsL.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lrO});
            }
            this.lrP = this.lrO;
        } else {
            str = this.lsL.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lrO});
            this.lrP = this.lrO;
        }
        this.mTitle = str;
        if (!StringUtils.isNULL(str)) {
            this.mNavigationBar.setTitleText(bC(str, 10));
        }
    }

    private void dfV() {
        if (2 == this.lqZ) {
            if (!au.isEmpty(this.ltb)) {
                this.lsW.setText(this.ltb);
                this.lsZ.setVisibility(0);
                this.lta.setVisibility(4);
                return;
            }
            this.lsZ.setVisibility(4);
            this.lta.setVisibility(4);
        } else if (1 == this.lqZ) {
            if (!au.isEmpty(this.ltd)) {
                this.lsW.setText(this.ltd);
                this.lsZ.setVisibility(4);
                this.lta.setVisibility(0);
                return;
            }
            this.lsZ.setVisibility(4);
            this.lta.setVisibility(4);
        }
    }

    public String bC(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getCurrentContent() {
        return this.lrP;
    }

    public int getCurrentShowType() {
        return this.lqZ;
    }

    public NoNetworkView getNoNetworkView() {
        return this.gCe;
    }

    public void onChangeSkinType(int i) {
        this.lsL.getLayoutMode().setNightMode(i == 1);
        this.lsL.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lsL.getPageContext(), i);
        this.gCe.onChangeSkinType(this.lsL.getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public TextView ltj;
        public TextView ltk;
        public TbImageView ltl;
        public TextView ltm;
        public TextView ltn;
        public View lto;
        public RelativeLayout mRootView;

        private a() {
        }
    }
}
