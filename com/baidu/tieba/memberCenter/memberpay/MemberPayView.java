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
/* loaded from: classes9.dex */
public class MemberPayView extends LinearLayout {
    private NoNetworkView gAv;
    private int loX;
    private f.g lpH;
    private f.b lpI;
    private f.c lpJ;
    private f.a lpK;
    private String lpL;
    private String lpM;
    private String lpN;
    private long lpO;
    private Boolean lpa;
    private MemberPayActivity lqJ;
    private RadioGroup lqK;
    private RadioButton lqL;
    private RadioButton lqM;
    private LinearLayout lqN;
    private LinearLayout lqO;
    private TextView lqP;
    private View lqQ;
    private TextView lqR;
    private View lqS;
    private TextView lqT;
    private TextView lqU;
    private TbImageView lqV;
    private TbImageView lqW;
    private ImageView lqX;
    private ImageView lqY;
    private String lqZ;
    private String lra;
    private String lrb;
    private String lrc;
    private int lrd;
    private int lre;
    private int lrf;
    private boolean lrg;
    private f mData;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private String mTitle;

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.lrd = 35;
        this.lre = 12;
        this.loX = 2;
        this.lrg = false;
        this.lpa = false;
        this.lqJ = memberPayActivity;
        this.lrf = i;
        this.lpa = Boolean.valueOf(z);
        initView();
    }

    private void initView() {
        this.lqJ.setContentView(R.layout.member_pay_activity);
        this.mRootView = this.lqJ.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.lqJ.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAv = (NoNetworkView) this.lqJ.findViewById(R.id.view_no_network);
        this.lqN = (LinearLayout) this.lqJ.findViewById(R.id.container);
        this.lqK = (RadioGroup) this.lqJ.findViewById(R.id.btns_mem_select);
        this.lqK.setOnCheckedChangeListener(this.lqJ);
        this.lqL = (RadioButton) this.lqJ.findViewById(R.id.btn_mem1);
        this.lqM = (RadioButton) this.lqJ.findViewById(R.id.btn_mem2);
        this.lqS = this.lqJ.findViewById(R.id.v_blank);
        this.lqU = (TextView) this.lqJ.findViewById(R.id.goods_des);
        this.lqV = (TbImageView) this.lqJ.findViewById(R.id.bdimg_adv);
        this.lqW = (TbImageView) this.lqJ.findViewById(R.id.bdimg_comm);
        this.lqX = (ImageView) this.lqJ.findViewById(R.id.crumb_adv);
        this.lqY = (ImageView) this.lqJ.findViewById(R.id.crumb_comm);
        this.lqT = (TextView) this.lqJ.findViewById(R.id.aotu_pay_law);
        this.lqT.setOnClickListener(this.lqJ);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        EC(this.loX);
    }

    public void tU(boolean z) {
        List<f.d> list;
        if (this.mData != null) {
            if (2 == this.loX) {
                if (this.lpK != null && this.lpK.lqf != null) {
                    list = this.lpK.lqf;
                }
                list = null;
            } else {
                if (this.lpJ != null && this.lpJ.lqf != null) {
                    list = this.lpJ.lqf;
                }
                list = null;
            }
            if (!y.isEmpty(list)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        f.d dVar = list.get(i2);
                        if (dVar == null || dVar.lqq < 0 || dVar.isAutoPay != 1) {
                            i = i2 + 1;
                        } else {
                            dVar.lqt = z;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void EC(int i) {
        if (i >= 0 && i <= 2) {
            this.loX = i;
            refreshUI();
        }
    }

    private void refreshUI() {
        if (this.mData == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpI == null || this.lpH == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpH.lqz == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpK == null && this.lpJ == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lrg && y.isEmpty(this.lpK.lqf)) {
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            dfE();
            dfL();
            dfG();
            dfM();
        }
    }

    private void initData() {
        if (this.mData != null) {
            this.lpI = this.mData.lpI;
            this.lpH = this.mData.lpH;
            if (this.lpI != null && this.lpH != null && this.lpH.lqz != null) {
                this.lpO = this.lpH.lqz.lqu;
                this.lrg = this.lpO == 2 || this.lrf == 2;
                this.lpK = this.lpI.lqk;
                if (this.lpK != null) {
                    this.lpL = this.lpK.mContent;
                    this.lqZ = this.lpK.lqh;
                    this.lra = this.lpK.lqi;
                    this.lpJ = this.lpI.lqj;
                    if (this.lpJ != null) {
                        this.lpM = this.lpJ.mContent;
                        this.lrb = this.lpJ.lqh;
                        this.lrc = this.lpJ.lqi;
                    }
                }
            }
        }
    }

    private void dfL() {
        this.lqL.setText(bC(this.lpL, this.lre));
        if (2 == this.loX) {
            if (au.isEmpty(this.lqZ)) {
                this.lqU.setVisibility(8);
                this.lqX.setVisibility(8);
            } else {
                this.lqU.setVisibility(0);
                this.lqX.setVisibility(0);
                this.lqU.setText(this.lqZ);
            }
        } else if (au.isEmpty(this.lrb)) {
            this.lqU.setVisibility(8);
            this.lqY.setVisibility(8);
        } else {
            this.lqU.setVisibility(0);
            this.lqY.setVisibility(0);
            this.lqU.setText(this.lrb);
        }
        this.lqV.setDefaultBgResource(0);
        this.lqW.setDefaultBgResource(0);
        this.lqV.setAutoChangeStyle(false);
        this.lqW.setAutoChangeStyle(false);
        if (au.isEmpty(this.lpK.lqi)) {
            ap.setImageResource(this.lqV, R.drawable.icon_vip_advanced, 0);
        } else {
            this.lqV.startLoad(this.lpK.lqi, 10, false);
        }
        if (this.lrg || this.lpJ == null || y.isEmpty(this.lpJ.lqf)) {
            this.lqM.setVisibility(8);
            this.lqW.setVisibility(8);
            this.lqY.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
            this.lqY.setVisibility(8);
        } else {
            this.lqM.setVisibility(0);
            this.lqM.setText(bC(this.lpM, this.lre));
            this.lqW.setVisibility(0);
            if (au.isEmpty(this.lpJ.lqi)) {
                ap.setImageResource(this.lqW, R.drawable.icon_vip_member, 0);
            } else {
                this.lqW.startLoad(this.lpJ.lqi, 21, false);
            }
        }
        if (this.lqS != null) {
            this.lqS.setVisibility(8);
        }
    }

    private void dfE() {
        List<f.d> list;
        Boolean bool = false;
        if (2 == this.loX) {
            if (this.lpK != null && this.lpK.lqf != null) {
                list = this.lpK.lqf;
            }
            list = null;
        } else {
            if (this.lpJ != null && this.lpJ.lqf != null) {
                list = this.lpJ.lqf;
            }
            list = null;
        }
        if (!y.isEmpty(list)) {
            this.lqN.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.lqq >= 0) {
                    Boolean bool2 = dVar.isAutoPay == 1 ? true : bool;
                    a aVar = new a();
                    View inflate = LayoutInflater.from(this.lqJ.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    aVar.lrh = (TextView) inflate.findViewById(R.id.cb);
                    aVar.lri = (TextView) inflate.findViewById(R.id.tv_month);
                    aVar.lrj = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    aVar.lrk = (TextView) inflate.findViewById(R.id.tv_discount);
                    aVar.lrl = (TextView) inflate.findViewById(R.id.tv_money);
                    aVar.mRootView = (RelativeLayout) inflate.findViewById(R.id.root);
                    aVar.lrm = inflate.findViewById(R.id.v_line);
                    aVar.lri.setText(bC(dVar.mTitle, 7));
                    if (!TextUtils.isEmpty(dVar.mIcon)) {
                        aVar.lrj.setVisibility(0);
                        aVar.lrj.startLoad(dVar.mIcon, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.mDiscount)) {
                        aVar.lrk.setVisibility(8);
                    } else {
                        aVar.lrk.setVisibility(0);
                        aVar.lrk.setText(bC(dVar.mDiscount, 10));
                    }
                    aVar.lrl.setText("¥" + (dVar.lqq / 100));
                    if (dVar.isChecked) {
                        ap.setBackgroundResource(aVar.lrh, R.drawable.btn_non_orange_s);
                        ap.setViewTextColor(aVar.lrh, R.color.CAM_X0101);
                    } else {
                        ap.setBackgroundResource(aVar.lrh, R.drawable.btn_non_orange_n);
                        ap.setViewTextColor(aVar.lrh, R.color.CAM_X0305);
                    }
                    aVar.lrh.setTag(dVar);
                    aVar.lrh.setText(R.string.click_open);
                    inflate.setContentDescription(bC(dVar.mTitle, 7));
                    inflate.setOnClickListener(new b(list));
                    inflate.setTag(aVar);
                    inflate.setLayoutParams(layoutParams);
                    com.baidu.tbadk.r.a.a(this.lqJ.getPageContext(), inflate);
                    a(list, i2, aVar);
                    this.lqN.addView(inflate);
                    bool = bool2;
                }
                i = i2 + 1;
            }
            if (bool.booleanValue()) {
                this.lqO = (LinearLayout) LayoutInflater.from(this.lqJ.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.lqP = (TextView) this.lqO.findViewById(R.id.tv_member_agreement_auto_pay);
                this.lqQ = this.lqO.findViewById(R.id.view_agreement_divider_auto_pay);
                this.lqR = (TextView) this.lqO.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.lqP.setOnClickListener(this.lqJ);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ap.setBackgroundColor(this.lqQ, R.color.CAM_X0204_1);
                }
                this.lqR.setOnClickListener(this.lqJ);
                this.lqN.addView(this.lqO);
                return;
            }
            this.lqO = (LinearLayout) LayoutInflater.from(this.lqJ.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.lqP = (TextView) this.lqO.findViewById(R.id.tv_member_agreement_normal);
            this.lqP.setOnClickListener(this.lqJ);
            this.lqN.addView(this.lqO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private List<f.d> iwy;

        public b(List<f.d> list) {
            this.iwy = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            f.d dVar;
            if (MemberPayView.this.lqN != null) {
                f.d dVar2 = null;
                for (int i = 0; i < MemberPayView.this.lqN.getChildCount(); i++) {
                    View childAt = MemberPayView.this.lqN.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                        if (textView.getTag() instanceof f.d) {
                            dVar = (f.d) textView.getTag();
                            if (view == childAt) {
                                dVar.isChecked = true;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                                ap.setViewTextColor(textView, R.color.CAM_X0101);
                                MemberPayView.this.a(this.iwy, i, (a) childAt.getTag());
                                dVar2 = dVar;
                            } else {
                                dVar.isChecked = false;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                                ap.setViewTextColor(textView, R.color.CAM_X0305);
                            }
                        }
                        dVar = dVar2;
                        MemberPayView.this.a(this.iwy, i, (a) childAt.getTag());
                        dVar2 = dVar;
                    }
                }
                if (dVar2 != null) {
                    if (dVar2.isAutoPay != 1 || !dVar2.lqt) {
                        MemberPayView.this.b(dVar2.lqp, dVar2.lqq / 100, dVar2.lqs, dVar2.isAutoPay);
                    } else {
                        l.showToast(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lpa.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.lqJ.getReferPage(), this.lqJ.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.lqJ.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lqJ.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.lqJ.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        com.baidu.tbadk.pay.c.bDV().a(payConfig, this.lqJ.getPageContext().getPageActivity());
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
                aVar.lrm.setVisibility(0);
            } else if (i == list.size() - 1) {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_n);
                }
                aVar.lrm.setVisibility(8);
            } else {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_n);
                }
                aVar.lrm.setVisibility(0);
            }
        }
    }

    private void dfG() {
        String str = null;
        if (2 == this.loX) {
            if (this.lpO == 2) {
                str = this.lqJ.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpL});
            } else {
                str = this.lqJ.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpL});
            }
            this.lpN = this.lpL;
        } else if (1 == this.loX) {
            if (this.lpO == 1) {
                str = this.lqJ.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpM});
            } else if (this.lpO == 0) {
                str = this.lqJ.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpM});
            }
            this.lpN = this.lpM;
        } else {
            str = this.lqJ.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpM});
            this.lpN = this.lpM;
        }
        this.mTitle = str;
        if (!StringUtils.isNULL(str)) {
            this.mNavigationBar.setTitleText(bC(str, 10));
        }
    }

    private void dfM() {
        if (2 == this.loX) {
            if (!au.isEmpty(this.lqZ)) {
                this.lqU.setText(this.lqZ);
                this.lqX.setVisibility(0);
                this.lqY.setVisibility(4);
                return;
            }
            this.lqX.setVisibility(4);
            this.lqY.setVisibility(4);
        } else if (1 == this.loX) {
            if (!au.isEmpty(this.lrb)) {
                this.lqU.setText(this.lrb);
                this.lqX.setVisibility(4);
                this.lqY.setVisibility(0);
                return;
            }
            this.lqX.setVisibility(4);
            this.lqY.setVisibility(4);
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
        return this.lpN;
    }

    public int getCurrentShowType() {
        return this.loX;
    }

    public NoNetworkView getNoNetworkView() {
        return this.gAv;
    }

    public void onChangeSkinType(int i) {
        this.lqJ.getLayoutMode().setNightMode(i == 1);
        this.lqJ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lqJ.getPageContext(), i);
        this.gAv.onChangeSkinType(this.lqJ.getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public TextView lrh;
        public TextView lri;
        public TbImageView lrj;
        public TextView lrk;
        public TextView lrl;
        public View lrm;
        public RelativeLayout mRootView;

        private a() {
        }
    }
}
