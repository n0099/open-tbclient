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
/* loaded from: classes9.dex */
public class b {
    private RelativeLayout ikz;
    private int loX;
    private GridView lpA;
    private LinearLayout lpB;
    private TextView lpC;
    private NoNetworkView lpD;
    private TextView lpE;
    private c lpF;
    private e lpG;
    private f.g lpH;
    private f.b lpI;
    private f.c lpJ;
    private f.a lpK;
    private String lpL;
    private String lpM;
    private String lpN;
    private long lpO;
    private Boolean lpa;
    private int lpk;
    private HListView lpw;
    private ImageView lpx;
    private TextView lpy;
    private TextView lpz;
    private String mClickZone;
    private f mData;
    private String mReferPage;
    private TbPageContext mTbPageContext;
    private String mTitle;
    private View view;
    private static String lpd = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String loA = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String lpe = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    AdapterView.c lpP = new AdapterView.c() { // from class: com.baidu.tieba.memberCenter.memberpay.b.1
        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.lpF.getItem(i);
            if (item != null) {
                item.isChecked = true;
                b.this.lpF.a(item);
                b.this.Ez(item.isAutoPay);
                b.this.hk(item.lqq);
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 2;
            int i2 = 1;
            if (view == b.this.lpC) {
                b.this.dfI();
                if (b.this.loX != 1) {
                    i = b.this.loX == 2 ? 1 : 1;
                }
                f.d dfK = b.this.lpF.dfK();
                if (dfK != null) {
                    if (dfK.isAutoPay == 1) {
                        i2 = 0;
                    } else if (dfK.lqs != 1) {
                        if (dfK.lqs == 3) {
                            i2 = 3;
                        } else if (dfK.lqs == 6) {
                            i2 = 6;
                        } else if (dfK.lqs == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new ar("c13200").ap("obj_type", i).ap("obj_locate", i2));
                }
                i2 = 0;
                TiebaStatic.log(new ar("c13200").ap("obj_type", i).ap("obj_locate", i2));
            } else if (view != b.this.lpx) {
                if (view == b.this.lpz) {
                    bf.bsV().b(b.this.mTbPageContext, new String[]{b.loA});
                }
            } else {
                bf.bsV().b(b.this.mTbPageContext, new String[]{b.lpe});
            }
        }
    };

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.loX = 2;
        this.lpa = false;
        this.view = view;
        this.mTbPageContext = tbPageContext;
        this.loX = i;
        this.lpa = Boolean.valueOf(z);
        this.mReferPage = str;
        this.mClickZone = str2;
        this.lpk = i2;
        initView();
    }

    private void initView() {
        this.ikz = (RelativeLayout) this.view.findViewById(R.id.root);
        this.lpw = (HListView) this.view.findViewById(R.id.price_listview);
        this.lpB = (LinearLayout) this.view.findViewById(R.id.renew_layout);
        this.lpx = (ImageView) this.view.findViewById(R.id.renew_tip_img);
        this.lpy = (TextView) this.view.findViewById(R.id.privilege_title);
        this.lpz = (TextView) this.view.findViewById(R.id.privilege_rule);
        this.lpA = (GridView) this.view.findViewById(R.id.privilege_container);
        this.lpD = (NoNetworkView) this.view.findViewById(R.id.view_no_network);
        this.lpC = (TextView) this.view.findViewById(R.id.member_pay_button);
        this.lpE = (TextView) this.view.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.lpw.setBackgroundResource(R.drawable.transparent_bg);
        this.lpw.setOnItemClickListener(this.lpP);
        this.lpw.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.lpA.setVerticalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.lpA.setHorizontalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.lpC.setOnClickListener(this.onClickListener);
        this.lpx.setOnClickListener(this.onClickListener);
        this.lpz.setOnClickListener(this.onClickListener);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.ikz.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        refreshUI();
    }

    private void initData() {
        if (this.mData != null) {
            this.lpI = this.mData.lpI;
            this.lpH = this.mData.lpH;
            if (this.lpI != null && this.lpH != null && this.lpH.lqz != null) {
                this.lpO = this.lpH.lqz.lqu;
                this.lpK = this.lpI.lqk;
                if (this.lpK != null) {
                    this.lpL = this.lpK.mContent;
                }
                this.lpJ = this.lpI.lqj;
                if (this.lpJ != null) {
                    this.lpM = this.lpJ.mContent;
                }
            }
        }
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

    private void refreshUI() {
        if (this.mData == null) {
            this.ikz.setVisibility(8);
        } else if (this.lpI == null || this.lpH == null) {
            this.ikz.setVisibility(8);
        } else if (this.lpH.lqz == null) {
            this.ikz.setVisibility(8);
        } else if (this.lpK == null && this.lpJ == null) {
            this.ikz.setVisibility(8);
        } else if (this.loX == 2 && (this.lpK == null || y.isEmpty(this.lpK.lqf))) {
            this.ikz.setVisibility(8);
        } else {
            this.ikz.setVisibility(0);
            dfE();
            dfF();
            dfG();
        }
    }

    private void dfE() {
        List<f.d> list;
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
            for (f.d dVar : list) {
                if (dVar.isChecked) {
                    Ez(dVar.isAutoPay);
                    hk(dVar.lqq);
                }
            }
            if (this.lpF == null) {
                this.lpF = new c(this.mTbPageContext);
                this.lpF.setData(list);
                this.lpw.setAdapter((ListAdapter) this.lpF);
            }
            this.lpF.setData(list);
            this.lpF.notifyDataSetChanged();
        }
    }

    private void dfF() {
        if (this.lpG == null) {
            ArrayList<d> dfH = dfH();
            this.lpG = new e(this.mTbPageContext.getPageActivity());
            this.lpG.setData(dfH);
            this.lpA.setAdapter((ListAdapter) this.lpG);
        }
    }

    private void dfG() {
        String str = null;
        if (2 == this.loX) {
            if (this.lpO == 2) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpL});
            } else {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpL});
            }
            this.lpN = this.lpL;
        } else if (1 == this.loX) {
            if (this.lpO == 1) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpM});
            } else if (this.lpO == 0) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpM});
            }
            this.lpN = this.lpM;
        } else {
            str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpM});
            this.lpN = this.lpM;
        }
        this.mTitle = str;
    }

    private ArrayList<d> dfH() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.loX == 1) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (this.loX == 2) {
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
            dVar.lpZ = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez(int i) {
        if (i == 1) {
            this.lpB.setVisibility(0);
        } else {
            this.lpB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(long j) {
        this.lpC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfI() {
        f.d dfK = this.lpF.dfK();
        if (dfK == null) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (dfK.isAutoPay == 1 && dfK.lqt) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            b(dfK.lqp, dfK.lqq / 100, dfK.lqs, dfK.isAutoPay);
            if (this.lpk == 26) {
                TiebaStatic.log(new ar("c13748").ap("obj_source", 1));
            }
        }
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lpa.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setTitle(this.mTitle);
        payConfig.setOrderName(this.lpN + this.mTbPageContext.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lpk == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        com.baidu.tbadk.pay.c.bDV().a(payConfig, this.mTbPageContext.getPageActivity());
    }

    public void onChangeSkinType(int i) {
        this.lpD.onChangeSkinType(this.mTbPageContext, i);
        ap.setBackgroundColor(this.ikz, R.color.CAM_X0201);
        ap.setViewTextColor(this.lpE, R.color.CAM_X0107);
        ap.setViewTextColor(this.lpy, R.color.CAM_X0105);
        ap.setViewTextColor(this.lpz, R.color.CAM_X0107);
        this.lpz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        ap.setViewTextColor(this.lpC, R.color.CAM_X0101);
        ap.setBackgroundResource(this.lpC, R.drawable.member_price_btn_bg);
        ap.setImageResource(this.lpx, R.drawable.icon_tbvip_attention);
    }
}
