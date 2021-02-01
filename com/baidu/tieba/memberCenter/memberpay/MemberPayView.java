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
    private NoNetworkView gAh;
    private int loJ;
    private Boolean loM;
    private long lpA;
    private f.g lpt;
    private f.b lpu;
    private f.c lpv;
    private f.a lpw;
    private String lpx;
    private String lpy;
    private String lpz;
    private LinearLayout lqA;
    private TextView lqB;
    private View lqC;
    private TextView lqD;
    private View lqE;
    private TextView lqF;
    private TextView lqG;
    private TbImageView lqH;
    private TbImageView lqI;
    private ImageView lqJ;
    private ImageView lqK;
    private String lqL;
    private String lqM;
    private String lqN;
    private String lqO;
    private int lqP;
    private int lqQ;
    private int lqR;
    private boolean lqS;
    private MemberPayActivity lqv;
    private RadioGroup lqw;
    private RadioButton lqx;
    private RadioButton lqy;
    private LinearLayout lqz;
    private f mData;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private String mTitle;

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.lqP = 35;
        this.lqQ = 12;
        this.loJ = 2;
        this.lqS = false;
        this.loM = false;
        this.lqv = memberPayActivity;
        this.lqR = i;
        this.loM = Boolean.valueOf(z);
        initView();
    }

    private void initView() {
        this.lqv.setContentView(R.layout.member_pay_activity);
        this.mRootView = this.lqv.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.lqv.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAh = (NoNetworkView) this.lqv.findViewById(R.id.view_no_network);
        this.lqz = (LinearLayout) this.lqv.findViewById(R.id.container);
        this.lqw = (RadioGroup) this.lqv.findViewById(R.id.btns_mem_select);
        this.lqw.setOnCheckedChangeListener(this.lqv);
        this.lqx = (RadioButton) this.lqv.findViewById(R.id.btn_mem1);
        this.lqy = (RadioButton) this.lqv.findViewById(R.id.btn_mem2);
        this.lqE = this.lqv.findViewById(R.id.v_blank);
        this.lqG = (TextView) this.lqv.findViewById(R.id.goods_des);
        this.lqH = (TbImageView) this.lqv.findViewById(R.id.bdimg_adv);
        this.lqI = (TbImageView) this.lqv.findViewById(R.id.bdimg_comm);
        this.lqJ = (ImageView) this.lqv.findViewById(R.id.crumb_adv);
        this.lqK = (ImageView) this.lqv.findViewById(R.id.crumb_comm);
        this.lqF = (TextView) this.lqv.findViewById(R.id.aotu_pay_law);
        this.lqF.setOnClickListener(this.lqv);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        EC(this.loJ);
    }

    public void tU(boolean z) {
        List<f.d> list;
        if (this.mData != null) {
            if (2 == this.loJ) {
                if (this.lpw != null && this.lpw.lpR != null) {
                    list = this.lpw.lpR;
                }
                list = null;
            } else {
                if (this.lpv != null && this.lpv.lpR != null) {
                    list = this.lpv.lpR;
                }
                list = null;
            }
            if (!y.isEmpty(list)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        f.d dVar = list.get(i2);
                        if (dVar == null || dVar.lqc < 0 || dVar.isAutoPay != 1) {
                            i = i2 + 1;
                        } else {
                            dVar.lqf = z;
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
            this.loJ = i;
            refreshUI();
        }
    }

    private void refreshUI() {
        if (this.mData == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpu == null || this.lpt == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpt.lql == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lpw == null && this.lpv == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lqS && y.isEmpty(this.lpw.lpR)) {
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            dfx();
            dfE();
            dfz();
            dfF();
        }
    }

    private void initData() {
        if (this.mData != null) {
            this.lpu = this.mData.lpu;
            this.lpt = this.mData.lpt;
            if (this.lpu != null && this.lpt != null && this.lpt.lql != null) {
                this.lpA = this.lpt.lql.lqg;
                this.lqS = this.lpA == 2 || this.lqR == 2;
                this.lpw = this.lpu.lpW;
                if (this.lpw != null) {
                    this.lpx = this.lpw.mContent;
                    this.lqL = this.lpw.lpT;
                    this.lqM = this.lpw.lpU;
                    this.lpv = this.lpu.lpV;
                    if (this.lpv != null) {
                        this.lpy = this.lpv.mContent;
                        this.lqN = this.lpv.lpT;
                        this.lqO = this.lpv.lpU;
                    }
                }
            }
        }
    }

    private void dfE() {
        this.lqx.setText(bC(this.lpx, this.lqQ));
        if (2 == this.loJ) {
            if (au.isEmpty(this.lqL)) {
                this.lqG.setVisibility(8);
                this.lqJ.setVisibility(8);
            } else {
                this.lqG.setVisibility(0);
                this.lqJ.setVisibility(0);
                this.lqG.setText(this.lqL);
            }
        } else if (au.isEmpty(this.lqN)) {
            this.lqG.setVisibility(8);
            this.lqK.setVisibility(8);
        } else {
            this.lqG.setVisibility(0);
            this.lqK.setVisibility(0);
            this.lqG.setText(this.lqN);
        }
        this.lqH.setDefaultBgResource(0);
        this.lqI.setDefaultBgResource(0);
        this.lqH.setAutoChangeStyle(false);
        this.lqI.setAutoChangeStyle(false);
        if (au.isEmpty(this.lpw.lpU)) {
            ap.setImageResource(this.lqH, R.drawable.icon_vip_advanced, 0);
        } else {
            this.lqH.startLoad(this.lpw.lpU, 10, false);
        }
        if (this.lqS || this.lpv == null || y.isEmpty(this.lpv.lpR)) {
            this.lqy.setVisibility(8);
            this.lqI.setVisibility(8);
            this.lqK.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
            this.lqK.setVisibility(8);
        } else {
            this.lqy.setVisibility(0);
            this.lqy.setText(bC(this.lpy, this.lqQ));
            this.lqI.setVisibility(0);
            if (au.isEmpty(this.lpv.lpU)) {
                ap.setImageResource(this.lqI, R.drawable.icon_vip_member, 0);
            } else {
                this.lqI.startLoad(this.lpv.lpU, 21, false);
            }
        }
        if (this.lqE != null) {
            this.lqE.setVisibility(8);
        }
    }

    private void dfx() {
        List<f.d> list;
        Boolean bool = false;
        if (2 == this.loJ) {
            if (this.lpw != null && this.lpw.lpR != null) {
                list = this.lpw.lpR;
            }
            list = null;
        } else {
            if (this.lpv != null && this.lpv.lpR != null) {
                list = this.lpv.lpR;
            }
            list = null;
        }
        if (!y.isEmpty(list)) {
            this.lqz.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.lqc >= 0) {
                    Boolean bool2 = dVar.isAutoPay == 1 ? true : bool;
                    a aVar = new a();
                    View inflate = LayoutInflater.from(this.lqv.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    aVar.lqT = (TextView) inflate.findViewById(R.id.cb);
                    aVar.lqU = (TextView) inflate.findViewById(R.id.tv_month);
                    aVar.lqV = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    aVar.lqW = (TextView) inflate.findViewById(R.id.tv_discount);
                    aVar.lqX = (TextView) inflate.findViewById(R.id.tv_money);
                    aVar.mRootView = (RelativeLayout) inflate.findViewById(R.id.root);
                    aVar.lqY = inflate.findViewById(R.id.v_line);
                    aVar.lqU.setText(bC(dVar.mTitle, 7));
                    if (!TextUtils.isEmpty(dVar.mIcon)) {
                        aVar.lqV.setVisibility(0);
                        aVar.lqV.startLoad(dVar.mIcon, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.mDiscount)) {
                        aVar.lqW.setVisibility(8);
                    } else {
                        aVar.lqW.setVisibility(0);
                        aVar.lqW.setText(bC(dVar.mDiscount, 10));
                    }
                    aVar.lqX.setText("¥" + (dVar.lqc / 100));
                    if (dVar.isChecked) {
                        ap.setBackgroundResource(aVar.lqT, R.drawable.btn_non_orange_s);
                        ap.setViewTextColor(aVar.lqT, R.color.CAM_X0101);
                    } else {
                        ap.setBackgroundResource(aVar.lqT, R.drawable.btn_non_orange_n);
                        ap.setViewTextColor(aVar.lqT, R.color.CAM_X0305);
                    }
                    aVar.lqT.setTag(dVar);
                    aVar.lqT.setText(R.string.click_open);
                    inflate.setContentDescription(bC(dVar.mTitle, 7));
                    inflate.setOnClickListener(new b(list));
                    inflate.setTag(aVar);
                    inflate.setLayoutParams(layoutParams);
                    com.baidu.tbadk.r.a.a(this.lqv.getPageContext(), inflate);
                    a(list, i2, aVar);
                    this.lqz.addView(inflate);
                    bool = bool2;
                }
                i = i2 + 1;
            }
            if (bool.booleanValue()) {
                this.lqA = (LinearLayout) LayoutInflater.from(this.lqv.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.lqB = (TextView) this.lqA.findViewById(R.id.tv_member_agreement_auto_pay);
                this.lqC = this.lqA.findViewById(R.id.view_agreement_divider_auto_pay);
                this.lqD = (TextView) this.lqA.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.lqB.setOnClickListener(this.lqv);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ap.setBackgroundColor(this.lqC, R.color.CAM_X0204_1);
                }
                this.lqD.setOnClickListener(this.lqv);
                this.lqz.addView(this.lqA);
                return;
            }
            this.lqA = (LinearLayout) LayoutInflater.from(this.lqv.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.lqB = (TextView) this.lqA.findViewById(R.id.tv_member_agreement_normal);
            this.lqB.setOnClickListener(this.lqv);
            this.lqz.addView(this.lqA);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private List<f.d> iwk;

        public b(List<f.d> list) {
            this.iwk = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            f.d dVar;
            if (MemberPayView.this.lqz != null) {
                f.d dVar2 = null;
                for (int i = 0; i < MemberPayView.this.lqz.getChildCount(); i++) {
                    View childAt = MemberPayView.this.lqz.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                        if (textView.getTag() instanceof f.d) {
                            dVar = (f.d) textView.getTag();
                            if (view == childAt) {
                                dVar.isChecked = true;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                                ap.setViewTextColor(textView, R.color.CAM_X0101);
                                MemberPayView.this.a(this.iwk, i, (a) childAt.getTag());
                                dVar2 = dVar;
                            } else {
                                dVar.isChecked = false;
                                ap.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                                ap.setViewTextColor(textView, R.color.CAM_X0305);
                            }
                        }
                        dVar = dVar2;
                        MemberPayView.this.a(this.iwk, i, (a) childAt.getTag());
                        dVar2 = dVar;
                    }
                }
                if (dVar2 != null) {
                    if (dVar2.isAutoPay != 1 || !dVar2.lqf) {
                        MemberPayView.this.b(dVar2.lqb, dVar2.lqc / 100, dVar2.lqe, dVar2.isAutoPay);
                    } else {
                        l.showToast(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.loM.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.lqv.getReferPage(), this.lqv.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.lqv.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lqv.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.lqv.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        com.baidu.tbadk.pay.c.bDV().a(payConfig, this.lqv.getPageContext().getPageActivity());
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
                aVar.lqY.setVisibility(0);
            } else if (i == list.size() - 1) {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_n);
                }
                aVar.lqY.setVisibility(8);
            } else {
                if (dVar.isChecked) {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_s);
                } else {
                    ap.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_n);
                }
                aVar.lqY.setVisibility(0);
            }
        }
    }

    private void dfz() {
        String str = null;
        if (2 == this.loJ) {
            if (this.lpA == 2) {
                str = this.lqv.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpx});
            } else {
                str = this.lqv.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpx});
            }
            this.lpz = this.lpx;
        } else if (1 == this.loJ) {
            if (this.lpA == 1) {
                str = this.lqv.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpy});
            } else if (this.lpA == 0) {
                str = this.lqv.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpy});
            }
            this.lpz = this.lpy;
        } else {
            str = this.lqv.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lpy});
            this.lpz = this.lpy;
        }
        this.mTitle = str;
        if (!StringUtils.isNULL(str)) {
            this.mNavigationBar.setTitleText(bC(str, 10));
        }
    }

    private void dfF() {
        if (2 == this.loJ) {
            if (!au.isEmpty(this.lqL)) {
                this.lqG.setText(this.lqL);
                this.lqJ.setVisibility(0);
                this.lqK.setVisibility(4);
                return;
            }
            this.lqJ.setVisibility(4);
            this.lqK.setVisibility(4);
        } else if (1 == this.loJ) {
            if (!au.isEmpty(this.lqN)) {
                this.lqG.setText(this.lqN);
                this.lqJ.setVisibility(4);
                this.lqK.setVisibility(0);
                return;
            }
            this.lqJ.setVisibility(4);
            this.lqK.setVisibility(4);
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
        return this.lpz;
    }

    public int getCurrentShowType() {
        return this.loJ;
    }

    public NoNetworkView getNoNetworkView() {
        return this.gAh;
    }

    public void onChangeSkinType(int i) {
        this.lqv.getLayoutMode().setNightMode(i == 1);
        this.lqv.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lqv.getPageContext(), i);
        this.gAh.onChangeSkinType(this.lqv.getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public TextView lqT;
        public TextView lqU;
        public TbImageView lqV;
        public TextView lqW;
        public TextView lqX;
        public View lqY;
        public RelativeLayout mRootView;

        private a() {
        }
    }
}
