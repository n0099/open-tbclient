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
/* loaded from: classes8.dex */
public class MemberPayView extends LinearLayout {
    private NoNetworkView gxx;
    private int lgC;
    private Boolean lgF;
    private f.g lhm;
    private f.b lhn;
    private f.c lho;
    private f.a lhp;
    private String lhq;
    private String lhr;
    private String lhs;
    private long lht;
    private TbImageView liA;
    private TbImageView liB;
    private ImageView liC;
    private ImageView liD;
    private String liE;
    private String liF;
    private String liG;
    private String liH;
    private int liI;
    private int liJ;
    private int liK;
    private boolean liL;
    private MemberPayActivity lio;
    private RadioGroup lip;
    private RadioButton liq;
    private RadioButton lir;
    private LinearLayout lis;
    private LinearLayout lit;
    private TextView liu;
    private View liv;
    private TextView liw;
    private View lix;
    private TextView liy;
    private TextView liz;
    private f mData;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private String mTitle;

    public MemberPayView(MemberPayActivity memberPayActivity, int i, boolean z) {
        super(memberPayActivity.getPageContext().getPageActivity());
        this.liI = 35;
        this.liJ = 12;
        this.lgC = 2;
        this.liL = false;
        this.lgF = false;
        this.lio = memberPayActivity;
        this.liK = i;
        this.lgF = Boolean.valueOf(z);
        initView();
    }

    private void initView() {
        this.lio.setContentView(R.layout.member_pay_activity);
        this.mRootView = this.lio.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.lio.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxx = (NoNetworkView) this.lio.findViewById(R.id.view_no_network);
        this.lis = (LinearLayout) this.lio.findViewById(R.id.container);
        this.lip = (RadioGroup) this.lio.findViewById(R.id.btns_mem_select);
        this.lip.setOnCheckedChangeListener(this.lio);
        this.liq = (RadioButton) this.lio.findViewById(R.id.btn_mem1);
        this.lir = (RadioButton) this.lio.findViewById(R.id.btn_mem2);
        this.lix = this.lio.findViewById(R.id.v_blank);
        this.liz = (TextView) this.lio.findViewById(R.id.goods_des);
        this.liA = (TbImageView) this.lio.findViewById(R.id.bdimg_adv);
        this.liB = (TbImageView) this.lio.findViewById(R.id.bdimg_comm);
        this.liC = (ImageView) this.lio.findViewById(R.id.crumb_adv);
        this.liD = (ImageView) this.lio.findViewById(R.id.crumb_comm);
        this.liy = (TextView) this.lio.findViewById(R.id.aotu_pay_law);
        this.liy.setOnClickListener(this.lio);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        Ek(this.lgC);
    }

    public void tH(boolean z) {
        List<f.d> list;
        if (this.mData != null) {
            if (2 == this.lgC) {
                if (this.lhp != null && this.lhp.lhK != null) {
                    list = this.lhp.lhK;
                }
                list = null;
            } else {
                if (this.lho != null && this.lho.lhK != null) {
                    list = this.lho.lhK;
                }
                list = null;
            }
            if (!x.isEmpty(list)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        f.d dVar = list.get(i2);
                        if (dVar == null || dVar.lhV < 0 || dVar.isAutoPay != 1) {
                            i = i2 + 1;
                        } else {
                            dVar.lhY = z;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void Ek(int i) {
        if (i >= 0 && i <= 2) {
            this.lgC = i;
            refreshUI();
        }
    }

    private void refreshUI() {
        if (this.mData == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lhn == null || this.lhm == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lhm.lie == null) {
            this.mRootView.setVisibility(8);
        } else if (this.lhp == null && this.lho == null) {
            this.mRootView.setVisibility(8);
        } else if (this.liL && x.isEmpty(this.lhp.lhK)) {
            this.mRootView.setVisibility(8);
        } else {
            this.mRootView.setVisibility(0);
            ddx();
            ddE();
            ddz();
            ddF();
        }
    }

    private void initData() {
        if (this.mData != null) {
            this.lhn = this.mData.lhn;
            this.lhm = this.mData.lhm;
            if (this.lhn != null && this.lhm != null && this.lhm.lie != null) {
                this.lht = this.lhm.lie.lhZ;
                this.liL = this.lht == 2 || this.liK == 2;
                this.lhp = this.lhn.lhP;
                if (this.lhp != null) {
                    this.lhq = this.lhp.mContent;
                    this.liE = this.lhp.lhM;
                    this.liF = this.lhp.lhN;
                    this.lho = this.lhn.lhO;
                    if (this.lho != null) {
                        this.lhr = this.lho.mContent;
                        this.liG = this.lho.lhM;
                        this.liH = this.lho.lhN;
                    }
                }
            }
        }
    }

    private void ddE() {
        this.liq.setText(bC(this.lhq, this.liJ));
        if (2 == this.lgC) {
            if (at.isEmpty(this.liE)) {
                this.liz.setVisibility(8);
                this.liC.setVisibility(8);
            } else {
                this.liz.setVisibility(0);
                this.liC.setVisibility(0);
                this.liz.setText(this.liE);
            }
        } else if (at.isEmpty(this.liG)) {
            this.liz.setVisibility(8);
            this.liD.setVisibility(8);
        } else {
            this.liz.setVisibility(0);
            this.liD.setVisibility(0);
            this.liz.setText(this.liG);
        }
        this.liA.setDefaultBgResource(0);
        this.liB.setDefaultBgResource(0);
        this.liA.setAutoChangeStyle(false);
        this.liB.setAutoChangeStyle(false);
        if (at.isEmpty(this.lhp.lhN)) {
            ao.setImageResource(this.liA, R.drawable.icon_vip_advanced, 0);
        } else {
            this.liA.startLoad(this.lhp.lhN, 10, false);
        }
        if (this.liL || this.lho == null || x.isEmpty(this.lho.lhK)) {
            this.lir.setVisibility(8);
            this.liB.setVisibility(8);
            this.liD.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.0f));
            this.liD.setVisibility(8);
        } else {
            this.lir.setVisibility(0);
            this.lir.setText(bC(this.lhr, this.liJ));
            this.liB.setVisibility(0);
            if (at.isEmpty(this.lho.lhN)) {
                ao.setImageResource(this.liB, R.drawable.icon_vip_member, 0);
            } else {
                this.liB.startLoad(this.lho.lhN, 21, false);
            }
        }
        if (this.lix != null) {
            this.lix.setVisibility(8);
        }
    }

    private void ddx() {
        List<f.d> list;
        Boolean bool = false;
        if (2 == this.lgC) {
            if (this.lhp != null && this.lhp.lhK != null) {
                list = this.lhp.lhK;
            }
            list = null;
        } else {
            if (this.lho != null && this.lho.lhK != null) {
                list = this.lho.lhK;
            }
            list = null;
        }
        if (!x.isEmpty(list)) {
            this.lis.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                f.d dVar = list.get(i2);
                if (dVar != null && dVar.lhV >= 0) {
                    Boolean bool2 = dVar.isAutoPay == 1 ? true : bool;
                    a aVar = new a();
                    View inflate = LayoutInflater.from(this.lio.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_item, (ViewGroup) null);
                    aVar.liM = (TextView) inflate.findViewById(R.id.cb);
                    aVar.liN = (TextView) inflate.findViewById(R.id.tv_month);
                    aVar.liO = (TbImageView) inflate.findViewById(R.id.member_price_item_sicon);
                    aVar.liP = (TextView) inflate.findViewById(R.id.tv_discount);
                    aVar.liQ = (TextView) inflate.findViewById(R.id.tv_money);
                    aVar.mRootView = (RelativeLayout) inflate.findViewById(R.id.root);
                    aVar.liR = inflate.findViewById(R.id.v_line);
                    aVar.liN.setText(bC(dVar.mTitle, 7));
                    if (!TextUtils.isEmpty(dVar.mIcon)) {
                        aVar.liO.setVisibility(0);
                        aVar.liO.startLoad(dVar.mIcon, 10, false);
                    }
                    if (TextUtils.isEmpty(dVar.mDiscount)) {
                        aVar.liP.setVisibility(8);
                    } else {
                        aVar.liP.setVisibility(0);
                        aVar.liP.setText(bC(dVar.mDiscount, 10));
                    }
                    aVar.liQ.setText("¥" + (dVar.lhV / 100));
                    if (dVar.isChecked) {
                        ao.setBackgroundResource(aVar.liM, R.drawable.btn_non_orange_s);
                        ao.setViewTextColor(aVar.liM, R.color.CAM_X0101);
                    } else {
                        ao.setBackgroundResource(aVar.liM, R.drawable.btn_non_orange_n);
                        ao.setViewTextColor(aVar.liM, R.color.CAM_X0305);
                    }
                    aVar.liM.setTag(dVar);
                    aVar.liM.setText(R.string.click_open);
                    inflate.setContentDescription(bC(dVar.mTitle, 7));
                    inflate.setOnClickListener(new b(list));
                    inflate.setTag(aVar);
                    inflate.setLayoutParams(layoutParams);
                    com.baidu.tbadk.r.a.a(this.lio.getPageContext(), inflate);
                    a(list, i2, aVar);
                    this.lis.addView(inflate);
                    bool = bool2;
                }
                i = i2 + 1;
            }
            if (bool.booleanValue()) {
                this.lit = (LinearLayout) LayoutInflater.from(this.lio.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_auto_pay_agreement_item, (ViewGroup) null);
                this.liu = (TextView) this.lit.findViewById(R.id.tv_member_agreement_auto_pay);
                this.liv = this.lit.findViewById(R.id.view_agreement_divider_auto_pay);
                this.liw = (TextView) this.lit.findViewById(R.id.tv_auto_pay_agreement_auto_pay);
                this.liu.setOnClickListener(this.lio);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ao.setBackgroundColor(this.liv, R.color.CAM_X0204_1);
                }
                this.liw.setOnClickListener(this.lio);
                this.lis.addView(this.lit);
                return;
            }
            this.lit = (LinearLayout) LayoutInflater.from(this.lio.getPageContext().getPageActivity()).inflate(R.layout.memberpaylist_normal_agreement_item, (ViewGroup) null);
            this.liu = (TextView) this.lit.findViewById(R.id.tv_member_agreement_normal);
            this.liu.setOnClickListener(this.lio);
            this.lis.addView(this.lit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private List<f.d> iqG;

        public b(List<f.d> list) {
            this.iqG = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            f.d dVar;
            if (MemberPayView.this.lis != null) {
                f.d dVar2 = null;
                for (int i = 0; i < MemberPayView.this.lis.getChildCount(); i++) {
                    View childAt = MemberPayView.this.lis.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof a) && (textView = (TextView) childAt.findViewById(R.id.cb)) != null && textView.getTag() != null) {
                        if (textView.getTag() instanceof f.d) {
                            dVar = (f.d) textView.getTag();
                            if (view == childAt) {
                                dVar.isChecked = true;
                                ao.setBackgroundResource(textView, R.drawable.btn_non_orange_s);
                                ao.setViewTextColor(textView, R.color.CAM_X0101);
                                MemberPayView.this.a(this.iqG, i, (a) childAt.getTag());
                                dVar2 = dVar;
                            } else {
                                dVar.isChecked = false;
                                ao.setBackgroundResource(textView, R.drawable.btn_non_orange_n);
                                ao.setViewTextColor(textView, R.color.CAM_X0305);
                            }
                        }
                        dVar = dVar2;
                        MemberPayView.this.a(this.iqG, i, (a) childAt.getTag());
                        dVar2 = dVar;
                    }
                }
                if (dVar2 != null) {
                    if (dVar2.isAutoPay != 1 || !dVar2.lhY) {
                        MemberPayView.this.b(dVar2.lhU, dVar2.lhV / 100, dVar2.lhX, dVar2.isAutoPay);
                    } else {
                        l.showToast(MemberPayView.this.getContext(), R.string.tips_auto_pay_succ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lgF.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.lio.getReferPage(), this.lio.getClickZone());
        payConfig.setTitle(getTitle());
        payConfig.setOrderName(getCurrentContent() + this.lio.getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lio.getFrom() == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        } else if (this.lio.getFrom() == 25) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_DUIBA;
        }
        com.baidu.tbadk.pay.c.bDD().a(payConfig, this.lio.getPageContext().getPageActivity());
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
                aVar.liR.setVisibility(0);
            } else if (i == list.size() - 1) {
                if (dVar.isChecked) {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_s);
                } else {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_down_n);
                }
                aVar.liR.setVisibility(8);
            } else {
                if (dVar.isChecked) {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_s);
                } else {
                    ao.setBackgroundResource(aVar.mRootView, R.drawable.bg_pay_list_center_n);
                }
                aVar.liR.setVisibility(0);
            }
        }
    }

    private void ddz() {
        String str = null;
        if (2 == this.lgC) {
            if (this.lht == 2) {
                str = this.lio.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lhq});
            } else {
                str = this.lio.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lhq});
            }
            this.lhs = this.lhq;
        } else if (1 == this.lgC) {
            if (this.lht == 1) {
                str = this.lio.getPageContext().getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lhr});
            } else if (this.lht == 0) {
                str = this.lio.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lhr});
            }
            this.lhs = this.lhr;
        } else {
            str = this.lio.getPageContext().getPageActivity().getString(R.string.dredge, new Object[]{this.lhr});
            this.lhs = this.lhr;
        }
        this.mTitle = str;
        if (!StringUtils.isNULL(str)) {
            this.mNavigationBar.setTitleText(bC(str, 10));
        }
    }

    private void ddF() {
        if (2 == this.lgC) {
            if (!at.isEmpty(this.liE)) {
                this.liz.setText(this.liE);
                this.liC.setVisibility(0);
                this.liD.setVisibility(4);
                return;
            }
            this.liC.setVisibility(4);
            this.liD.setVisibility(4);
        } else if (1 == this.lgC) {
            if (!at.isEmpty(this.liG)) {
                this.liz.setText(this.liG);
                this.liC.setVisibility(4);
                this.liD.setVisibility(0);
                return;
            }
            this.liC.setVisibility(4);
            this.liD.setVisibility(4);
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
        return this.lhs;
    }

    public int getCurrentShowType() {
        return this.lgC;
    }

    public NoNetworkView getNoNetworkView() {
        return this.gxx;
    }

    public void onChangeSkinType(int i) {
        this.lio.getLayoutMode().setNightMode(i == 1);
        this.lio.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lio.getPageContext(), i);
        this.gxx.onChangeSkinType(this.lio.getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public TextView liM;
        public TextView liN;
        public TbImageView liO;
        public TextView liP;
        public TextView liQ;
        public View liR;
        public RelativeLayout mRootView;

        private a() {
        }
    }
}
