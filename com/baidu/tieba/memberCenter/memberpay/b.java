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
    private RelativeLayout ikl;
    private int loJ;
    private Boolean loM;
    private int loW;
    private long lpA;
    private HListView lpi;
    private ImageView lpj;
    private TextView lpk;
    private TextView lpl;
    private GridView lpm;
    private LinearLayout lpn;
    private TextView lpo;
    private NoNetworkView lpp;
    private TextView lpq;
    private c lpr;
    private e lps;
    private f.g lpt;
    private f.b lpu;
    private f.c lpv;
    private f.a lpw;
    private String lpx;
    private String lpy;
    private String lpz;
    private String mClickZone;
    private f mData;
    private String mReferPage;
    private TbPageContext mTbPageContext;
    private String mTitle;
    private View view;
    private static String loP = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String lok = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String loQ = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    AdapterView.c lpB = new AdapterView.c() { // from class: com.baidu.tieba.memberCenter.memberpay.b.1
        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.lpr.getItem(i);
            if (item != null) {
                item.isChecked = true;
                b.this.lpr.a(item);
                b.this.Ez(item.isAutoPay);
                b.this.hk(item.lqc);
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 2;
            int i2 = 1;
            if (view == b.this.lpo) {
                b.this.dfB();
                if (b.this.loJ != 1) {
                    i = b.this.loJ == 2 ? 1 : 1;
                }
                f.d dfD = b.this.lpr.dfD();
                if (dfD != null) {
                    if (dfD.isAutoPay == 1) {
                        i2 = 0;
                    } else if (dfD.lqe != 1) {
                        if (dfD.lqe == 3) {
                            i2 = 3;
                        } else if (dfD.lqe == 6) {
                            i2 = 6;
                        } else if (dfD.lqe == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new ar("c13200").ap("obj_type", i).ap("obj_locate", i2));
                }
                i2 = 0;
                TiebaStatic.log(new ar("c13200").ap("obj_type", i).ap("obj_locate", i2));
            } else if (view != b.this.lpj) {
                if (view == b.this.lpl) {
                    bf.bsV().b(b.this.mTbPageContext, new String[]{b.lok});
                }
            } else {
                bf.bsV().b(b.this.mTbPageContext, new String[]{b.loQ});
            }
        }
    };

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.loJ = 2;
        this.loM = false;
        this.view = view;
        this.mTbPageContext = tbPageContext;
        this.loJ = i;
        this.loM = Boolean.valueOf(z);
        this.mReferPage = str;
        this.mClickZone = str2;
        this.loW = i2;
        initView();
    }

    private void initView() {
        this.ikl = (RelativeLayout) this.view.findViewById(R.id.root);
        this.lpi = (HListView) this.view.findViewById(R.id.price_listview);
        this.lpn = (LinearLayout) this.view.findViewById(R.id.renew_layout);
        this.lpj = (ImageView) this.view.findViewById(R.id.renew_tip_img);
        this.lpk = (TextView) this.view.findViewById(R.id.privilege_title);
        this.lpl = (TextView) this.view.findViewById(R.id.privilege_rule);
        this.lpm = (GridView) this.view.findViewById(R.id.privilege_container);
        this.lpp = (NoNetworkView) this.view.findViewById(R.id.view_no_network);
        this.lpo = (TextView) this.view.findViewById(R.id.member_pay_button);
        this.lpq = (TextView) this.view.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.lpi.setBackgroundResource(R.drawable.transparent_bg);
        this.lpi.setOnItemClickListener(this.lpB);
        this.lpi.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.lpm.setVerticalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.lpm.setHorizontalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.lpo.setOnClickListener(this.onClickListener);
        this.lpj.setOnClickListener(this.onClickListener);
        this.lpl.setOnClickListener(this.onClickListener);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.ikl.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        refreshUI();
    }

    private void initData() {
        if (this.mData != null) {
            this.lpu = this.mData.lpu;
            this.lpt = this.mData.lpt;
            if (this.lpu != null && this.lpt != null && this.lpt.lql != null) {
                this.lpA = this.lpt.lql.lqg;
                this.lpw = this.lpu.lpW;
                if (this.lpw != null) {
                    this.lpx = this.lpw.mContent;
                }
                this.lpv = this.lpu.lpV;
                if (this.lpv != null) {
                    this.lpy = this.lpv.mContent;
                }
            }
        }
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

    private void refreshUI() {
        if (this.mData == null) {
            this.ikl.setVisibility(8);
        } else if (this.lpu == null || this.lpt == null) {
            this.ikl.setVisibility(8);
        } else if (this.lpt.lql == null) {
            this.ikl.setVisibility(8);
        } else if (this.lpw == null && this.lpv == null) {
            this.ikl.setVisibility(8);
        } else if (this.loJ == 2 && (this.lpw == null || y.isEmpty(this.lpw.lpR))) {
            this.ikl.setVisibility(8);
        } else {
            this.ikl.setVisibility(0);
            dfx();
            dfy();
            dfz();
        }
    }

    private void dfx() {
        List<f.d> list;
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
            for (f.d dVar : list) {
                if (dVar.isChecked) {
                    Ez(dVar.isAutoPay);
                    hk(dVar.lqc);
                }
            }
            if (this.lpr == null) {
                this.lpr = new c(this.mTbPageContext);
                this.lpr.setData(list);
                this.lpi.setAdapter((ListAdapter) this.lpr);
            }
            this.lpr.setData(list);
            this.lpr.notifyDataSetChanged();
        }
    }

    private void dfy() {
        if (this.lps == null) {
            ArrayList<d> dfA = dfA();
            this.lps = new e(this.mTbPageContext.getPageActivity());
            this.lps.setData(dfA);
            this.lpm.setAdapter((ListAdapter) this.lps);
        }
    }

    private void dfz() {
        String str = null;
        if (2 == this.loJ) {
            if (this.lpA == 2) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpx});
            } else {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpx});
            }
            this.lpz = this.lpx;
        } else if (1 == this.loJ) {
            if (this.lpA == 1) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lpy});
            } else if (this.lpA == 0) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpy});
            }
            this.lpz = this.lpy;
        } else {
            str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lpy});
            this.lpz = this.lpy;
        }
        this.mTitle = str;
    }

    private ArrayList<d> dfA() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.loJ == 1) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (this.loJ == 2) {
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
            dVar.lpL = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez(int i) {
        if (i == 1) {
            this.lpn.setVisibility(0);
        } else {
            this.lpn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(long j) {
        this.lpo.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfB() {
        f.d dfD = this.lpr.dfD();
        if (dfD == null) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (dfD.isAutoPay == 1 && dfD.lqf) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            b(dfD.lqb, dfD.lqc / 100, dfD.lqe, dfD.isAutoPay);
            if (this.loW == 26) {
                TiebaStatic.log(new ar("c13748").ap("obj_source", 1));
            }
        }
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.loM.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setTitle(this.mTitle);
        payConfig.setOrderName(this.lpz + this.mTbPageContext.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.loW == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        com.baidu.tbadk.pay.c.bDV().a(payConfig, this.mTbPageContext.getPageActivity());
    }

    public void onChangeSkinType(int i) {
        this.lpp.onChangeSkinType(this.mTbPageContext, i);
        ap.setBackgroundColor(this.ikl, R.color.CAM_X0201);
        ap.setViewTextColor(this.lpq, R.color.CAM_X0107);
        ap.setViewTextColor(this.lpk, R.color.CAM_X0105);
        ap.setViewTextColor(this.lpl, R.color.CAM_X0107);
        this.lpl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        ap.setViewTextColor(this.lpo, R.color.CAM_X0101);
        ap.setBackgroundResource(this.lpo, R.drawable.member_price_btn_bg);
        ap.setImageResource(this.lpj, R.drawable.icon_tbvip_attention);
    }
}
