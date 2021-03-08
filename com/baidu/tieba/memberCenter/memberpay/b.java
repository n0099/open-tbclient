package com.baidu.tieba.memberCenter.memberpay;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private RelativeLayout imj;
    private int lqZ;
    private TextView lrA;
    private TextView lrB;
    private GridView lrC;
    private LinearLayout lrD;
    private TextView lrE;
    private NoNetworkView lrF;
    private TextView lrG;
    private c lrH;
    private e lrI;
    private f.g lrJ;
    private f.b lrK;
    private f.c lrL;
    private f.a lrM;
    private String lrN;
    private String lrO;
    private String lrP;
    private long lrQ;
    private Boolean lrc;
    private int lrm;
    private HListView lry;
    private ImageView lrz;
    private String mClickZone;
    private f mData;
    private String mReferPage;
    private TbPageContext mTbPageContext;
    private String mTitle;
    private View view;
    private static String lrf = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String lqC = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String lrg = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    AdapterView.c lrR = new AdapterView.c() { // from class: com.baidu.tieba.memberCenter.memberpay.b.1
        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.lrH.getItem(i);
            if (item != null) {
                item.isChecked = true;
                b.this.lrH.a(item);
                b.this.EC(item.isAutoPay);
                b.this.hk(item.lss);
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 2;
            int i2 = 1;
            if (view == b.this.lrE) {
                b.this.dfR();
                if (b.this.lqZ != 1) {
                    i = b.this.lqZ == 2 ? 1 : 1;
                }
                f.d dfT = b.this.lrH.dfT();
                if (dfT != null) {
                    if (dfT.isAutoPay == 1) {
                        i2 = 0;
                    } else if (dfT.lsu != 1) {
                        if (dfT.lsu == 3) {
                            i2 = 3;
                        } else if (dfT.lsu == 6) {
                            i2 = 6;
                        } else if (dfT.lsu == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new ar("c13200").aq("obj_type", i).aq("obj_locate", i2));
                }
                i2 = 0;
                TiebaStatic.log(new ar("c13200").aq("obj_type", i).aq("obj_locate", i2));
            } else if (view != b.this.lrz) {
                if (view == b.this.lrB) {
                    bf.bsY().b(b.this.mTbPageContext, new String[]{b.lqC});
                }
            } else {
                bf.bsY().b(b.this.mTbPageContext, new String[]{b.lrg});
            }
        }
    };

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.lqZ = 2;
        this.lrc = false;
        this.view = view;
        this.mTbPageContext = tbPageContext;
        this.lqZ = i;
        this.lrc = Boolean.valueOf(z);
        this.mReferPage = str;
        this.mClickZone = str2;
        this.lrm = i2;
        initView();
    }

    private void initView() {
        this.imj = (RelativeLayout) this.view.findViewById(R.id.root);
        this.lry = (HListView) this.view.findViewById(R.id.price_listview);
        this.lrD = (LinearLayout) this.view.findViewById(R.id.renew_layout);
        this.lrz = (ImageView) this.view.findViewById(R.id.renew_tip_img);
        this.lrA = (TextView) this.view.findViewById(R.id.privilege_title);
        this.lrB = (TextView) this.view.findViewById(R.id.privilege_rule);
        this.lrC = (GridView) this.view.findViewById(R.id.privilege_container);
        this.lrF = (NoNetworkView) this.view.findViewById(R.id.view_no_network);
        this.lrE = (TextView) this.view.findViewById(R.id.member_pay_button);
        this.lrG = (TextView) this.view.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.lry.setBackgroundResource(R.drawable.transparent_bg);
        this.lry.setOnItemClickListener(this.lrR);
        this.lry.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.lrC.setVerticalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.lrC.setHorizontalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.lrE.setOnClickListener(this.onClickListener);
        this.lrz.setOnClickListener(this.onClickListener);
        this.lrB.setOnClickListener(this.onClickListener);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.imj.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        refreshUI();
    }

    private void initData() {
        if (this.mData != null) {
            this.lrK = this.mData.lrK;
            this.lrJ = this.mData.lrJ;
            if (this.lrK != null && this.lrJ != null && this.lrJ.lsB != null) {
                this.lrQ = this.lrJ.lsB.lsw;
                this.lrM = this.lrK.lsm;
                if (this.lrM != null) {
                    this.lrN = this.lrM.mContent;
                }
                this.lrL = this.lrK.lsl;
                if (this.lrL != null) {
                    this.lrO = this.lrL.mContent;
                }
            }
        }
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

    private void refreshUI() {
        if (this.mData == null) {
            this.imj.setVisibility(8);
        } else if (this.lrK == null || this.lrJ == null) {
            this.imj.setVisibility(8);
        } else if (this.lrJ.lsB == null) {
            this.imj.setVisibility(8);
        } else if (this.lrM == null && this.lrL == null) {
            this.imj.setVisibility(8);
        } else if (this.lqZ == 2 && (this.lrM == null || y.isEmpty(this.lrM.lsh))) {
            this.imj.setVisibility(8);
        } else {
            this.imj.setVisibility(0);
            dfN();
            dfO();
            dfP();
        }
    }

    private void dfN() {
        List<f.d> list;
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
            for (f.d dVar : list) {
                if (dVar.isChecked) {
                    EC(dVar.isAutoPay);
                    hk(dVar.lss);
                }
            }
            if (this.lrH == null) {
                this.lrH = new c(this.mTbPageContext);
                this.lrH.setData(list);
                this.lry.setAdapter((ListAdapter) this.lrH);
            }
            this.lrH.setData(list);
            this.lrH.notifyDataSetChanged();
        }
    }

    private void dfO() {
        if (this.lrI == null) {
            ArrayList<d> dfQ = dfQ();
            this.lrI = new e(this.mTbPageContext.getPageActivity());
            this.lrI.setData(dfQ);
            this.lrC.setAdapter((ListAdapter) this.lrI);
        }
    }

    private void dfP() {
        String str = null;
        if (2 == this.lqZ) {
            if (this.lrQ == 2) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lrN});
            } else {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lrN});
            }
            this.lrP = this.lrN;
        } else if (1 == this.lqZ) {
            if (this.lrQ == 1) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lrO});
            } else if (this.lrQ == 0) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lrO});
            }
            this.lrP = this.lrO;
        } else {
            str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lrO});
            this.lrP = this.lrO;
        }
        this.mTitle = str;
    }

    private ArrayList<d> dfQ() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.lqZ == 1) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (this.lqZ == 2) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_forbid_adv), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_advertising24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_experience_acc), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_accelerate24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_one_key_sign), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_checkin24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_bg), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_bg24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_forbid_speak), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_notalk24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_more_link), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_morelink26_svg));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            d dVar = new d();
            dVar.name = (String) entry.getKey();
            dVar.lsb = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC(int i) {
        if (i == 1) {
            this.lrD.setVisibility(0);
        } else {
            this.lrD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(long j) {
        this.lrE.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfR() {
        f.d dfT = this.lrH.dfT();
        if (dfT == null) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (dfT.isAutoPay == 1 && dfT.lsv) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            b(dfT.lsr, dfT.lss / 100, dfT.lsu, dfT.isAutoPay);
            if (this.lrm == 26) {
                TiebaStatic.log(new ar("c13748").aq("obj_source", 1));
            }
        }
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lrc.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setTitle(this.mTitle);
        payConfig.setOrderName(this.lrP + this.mTbPageContext.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lrm == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        com.baidu.tbadk.pay.c.bDZ().a(payConfig, this.mTbPageContext.getPageActivity());
    }

    public void onChangeSkinType(int i) {
        this.lrF.onChangeSkinType(this.mTbPageContext, i);
        ap.setBackgroundColor(this.imj, R.color.CAM_X0201);
        ap.setViewTextColor(this.lrG, R.color.CAM_X0107);
        ap.setViewTextColor(this.lrA, R.color.CAM_X0105);
        ap.setViewTextColor(this.lrB, R.color.CAM_X0107);
        this.lrB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        ap.setViewTextColor(this.lrE, R.color.CAM_X0101);
        ap.setBackgroundResource(this.lrE, R.drawable.member_price_btn_bg);
        ap.setImageResource(this.lrz, R.drawable.icon_tbvip_attention);
    }
}
