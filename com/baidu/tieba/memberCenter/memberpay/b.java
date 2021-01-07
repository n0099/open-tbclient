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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes9.dex */
public class b {
    private RelativeLayout ikd;
    private HListView llG;
    private ImageView llH;
    private TextView llI;
    private TextView llJ;
    private GridView llK;
    private LinearLayout llL;
    private TextView llM;
    private NoNetworkView llN;
    private TextView llO;
    private c llP;
    private e llQ;
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
    private int llu;
    private String mClickZone;
    private f mData;
    private String mReferPage;
    private TbPageContext mTbPageContext;
    private String mTitle;
    private View view;
    private static String lln = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String lkK = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String llo = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    AdapterView.c llZ = new AdapterView.c() { // from class: com.baidu.tieba.memberCenter.memberpay.b.1
        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.llP.getItem(i);
            if (item != null) {
                item.isChecked = true;
                b.this.llP.a(item);
                b.this.FN(item.isAutoPay);
                b.this.hf(item.lmA);
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 2;
            int i2 = 1;
            if (view == b.this.llM) {
                b.this.dht();
                if (b.this.llh != 1) {
                    i = b.this.llh == 2 ? 1 : 1;
                }
                f.d dhv = b.this.llP.dhv();
                if (dhv != null) {
                    if (dhv.isAutoPay == 1) {
                        i2 = 0;
                    } else if (dhv.lmC != 1) {
                        if (dhv.lmC == 3) {
                            i2 = 3;
                        } else if (dhv.lmC == 6) {
                            i2 = 6;
                        } else if (dhv.lmC == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new aq("c13200").an("obj_type", i).an("obj_locate", i2));
                }
                i2 = 0;
                TiebaStatic.log(new aq("c13200").an("obj_type", i).an("obj_locate", i2));
            } else if (view != b.this.llH) {
                if (view == b.this.llJ) {
                    be.bwv().b(b.this.mTbPageContext, new String[]{b.lkK});
                }
            } else {
                be.bwv().b(b.this.mTbPageContext, new String[]{b.llo});
            }
        }
    };

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.llh = 2;
        this.llk = false;
        this.view = view;
        this.mTbPageContext = tbPageContext;
        this.llh = i;
        this.llk = Boolean.valueOf(z);
        this.mReferPage = str;
        this.mClickZone = str2;
        this.llu = i2;
        initView();
    }

    private void initView() {
        this.ikd = (RelativeLayout) this.view.findViewById(R.id.root);
        this.llG = (HListView) this.view.findViewById(R.id.price_listview);
        this.llL = (LinearLayout) this.view.findViewById(R.id.renew_layout);
        this.llH = (ImageView) this.view.findViewById(R.id.renew_tip_img);
        this.llI = (TextView) this.view.findViewById(R.id.privilege_title);
        this.llJ = (TextView) this.view.findViewById(R.id.privilege_rule);
        this.llK = (GridView) this.view.findViewById(R.id.privilege_container);
        this.llN = (NoNetworkView) this.view.findViewById(R.id.view_no_network);
        this.llM = (TextView) this.view.findViewById(R.id.member_pay_button);
        this.llO = (TextView) this.view.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.llG.setBackgroundResource(R.drawable.transparent_bg);
        this.llG.setOnItemClickListener(this.llZ);
        this.llG.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.llK.setVerticalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.llK.setHorizontalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.llM.setOnClickListener(this.onClickListener);
        this.llH.setOnClickListener(this.onClickListener);
        this.llJ.setOnClickListener(this.onClickListener);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.ikd.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        refreshUI();
    }

    private void initData() {
        if (this.mData != null) {
            this.llS = this.mData.llS;
            this.llR = this.mData.llR;
            if (this.llS != null && this.llR != null && this.llR.lmJ != null) {
                this.llY = this.llR.lmJ.lmE;
                this.llU = this.llS.lmu;
                if (this.llU != null) {
                    this.llV = this.llU.mContent;
                }
                this.llT = this.llS.lmt;
                if (this.llT != null) {
                    this.llW = this.llT.mContent;
                }
            }
        }
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

    private void refreshUI() {
        if (this.mData == null) {
            this.ikd.setVisibility(8);
        } else if (this.llS == null || this.llR == null) {
            this.ikd.setVisibility(8);
        } else if (this.llR.lmJ == null) {
            this.ikd.setVisibility(8);
        } else if (this.llU == null && this.llT == null) {
            this.ikd.setVisibility(8);
        } else if (this.llh == 2 && (this.llU == null || x.isEmpty(this.llU.lmp))) {
            this.ikd.setVisibility(8);
        } else {
            this.ikd.setVisibility(0);
            dhp();
            dhq();
            dhr();
        }
    }

    private void dhp() {
        List<f.d> list;
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
            for (f.d dVar : list) {
                if (dVar.isChecked) {
                    FN(dVar.isAutoPay);
                    hf(dVar.lmA);
                }
            }
            if (this.llP == null) {
                this.llP = new c(this.mTbPageContext);
                this.llP.setData(list);
                this.llG.setAdapter((ListAdapter) this.llP);
            }
            this.llP.setData(list);
            this.llP.notifyDataSetChanged();
        }
    }

    private void dhq() {
        if (this.llQ == null) {
            ArrayList<d> dhs = dhs();
            this.llQ = new e(this.mTbPageContext.getPageActivity());
            this.llQ.setData(dhs);
            this.llK.setAdapter((ListAdapter) this.llQ);
        }
    }

    private void dhr() {
        String str = null;
        if (2 == this.llh) {
            if (this.llY == 2) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.llV});
            } else {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.llV});
            }
            this.llX = this.llV;
        } else if (1 == this.llh) {
            if (this.llY == 1) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.llW});
            } else if (this.llY == 0) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.llW});
            }
            this.llX = this.llW;
        } else {
            str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.llW});
            this.llX = this.llW;
        }
        this.mTitle = str;
    }

    private ArrayList<d> dhs() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.llh == 1) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (this.llh == 2) {
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
            dVar.lmj = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(int i) {
        if (i == 1) {
            this.llL.setVisibility(0);
        } else {
            this.llL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        this.llM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dht() {
        f.d dhv = this.llP.dhv();
        if (dhv == null) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (dhv.isAutoPay == 1 && dhv.lmD) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            b(dhv.lmz, dhv.lmA / 100, dhv.lmC, dhv.isAutoPay);
            if (this.llu == 26) {
                TiebaStatic.log(new aq("c13748").an("obj_source", 1));
            }
        }
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.llk.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setTitle(this.mTitle);
        payConfig.setOrderName(this.llX + this.mTbPageContext.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.llu == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        com.baidu.tbadk.pay.c.bHw().a(payConfig, this.mTbPageContext.getPageActivity());
    }

    public void onChangeSkinType(int i) {
        this.llN.onChangeSkinType(this.mTbPageContext, i);
        ao.setBackgroundColor(this.ikd, R.color.CAM_X0201);
        ao.setViewTextColor(this.llO, R.color.CAM_X0107);
        ao.setViewTextColor(this.llI, R.color.CAM_X0105);
        ao.setViewTextColor(this.llJ, R.color.CAM_X0107);
        this.llJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        ao.setViewTextColor(this.llM, R.color.CAM_X0101);
        ao.setBackgroundResource(this.llM, R.drawable.member_price_btn_bg);
        ao.setImageResource(this.llH, R.drawable.icon_tbvip_attention);
    }
}
