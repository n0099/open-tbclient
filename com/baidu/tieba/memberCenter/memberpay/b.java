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
/* loaded from: classes8.dex */
public class b {
    private RelativeLayout ifw;
    private int lgC;
    private Boolean lgF;
    private int lgP;
    private HListView lhb;
    private ImageView lhc;
    private TextView lhd;
    private TextView lhe;
    private GridView lhf;
    private LinearLayout lhg;
    private TextView lhh;
    private NoNetworkView lhi;
    private TextView lhj;
    private c lhk;
    private e lhl;
    private f.g lhm;
    private f.b lhn;
    private f.c lho;
    private f.a lhp;
    private String lhq;
    private String lhr;
    private String lhs;
    private long lht;
    private String mClickZone;
    private f mData;
    private String mReferPage;
    private TbPageContext mTbPageContext;
    private String mTitle;
    private View view;
    private static String lgI = "https://tieba.baidu.com/tb/eula_mobile.html?";
    private static String lgf = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private static String lgJ = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    AdapterView.c lhu = new AdapterView.c() { // from class: com.baidu.tieba.memberCenter.memberpay.b.1
        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item = b.this.lhk.getItem(i);
            if (item != null) {
                item.isChecked = true;
                b.this.lhk.a(item);
                b.this.Eh(item.isAutoPay);
                b.this.hf(item.lhV);
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberpay.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 2;
            int i2 = 1;
            if (view == b.this.lhh) {
                b.this.ddB();
                if (b.this.lgC != 1) {
                    i = b.this.lgC == 2 ? 1 : 1;
                }
                f.d ddD = b.this.lhk.ddD();
                if (ddD != null) {
                    if (ddD.isAutoPay == 1) {
                        i2 = 0;
                    } else if (ddD.lhX != 1) {
                        if (ddD.lhX == 3) {
                            i2 = 3;
                        } else if (ddD.lhX == 6) {
                            i2 = 6;
                        } else if (ddD.lhX == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new aq("c13200").an("obj_type", i).an("obj_locate", i2));
                }
                i2 = 0;
                TiebaStatic.log(new aq("c13200").an("obj_type", i).an("obj_locate", i2));
            } else if (view != b.this.lhc) {
                if (view == b.this.lhe) {
                    be.bsB().b(b.this.mTbPageContext, new String[]{b.lgf});
                }
            } else {
                be.bsB().b(b.this.mTbPageContext, new String[]{b.lgJ});
            }
        }
    };

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        this.lgC = 2;
        this.lgF = false;
        this.view = view;
        this.mTbPageContext = tbPageContext;
        this.lgC = i;
        this.lgF = Boolean.valueOf(z);
        this.mReferPage = str;
        this.mClickZone = str2;
        this.lgP = i2;
        initView();
    }

    private void initView() {
        this.ifw = (RelativeLayout) this.view.findViewById(R.id.root);
        this.lhb = (HListView) this.view.findViewById(R.id.price_listview);
        this.lhg = (LinearLayout) this.view.findViewById(R.id.renew_layout);
        this.lhc = (ImageView) this.view.findViewById(R.id.renew_tip_img);
        this.lhd = (TextView) this.view.findViewById(R.id.privilege_title);
        this.lhe = (TextView) this.view.findViewById(R.id.privilege_rule);
        this.lhf = (GridView) this.view.findViewById(R.id.privilege_container);
        this.lhi = (NoNetworkView) this.view.findViewById(R.id.view_no_network);
        this.lhh = (TextView) this.view.findViewById(R.id.member_pay_button);
        this.lhj = (TextView) this.view.findViewById(R.id.tv_member_auto_pay_cancel_tip);
        this.lhb.setBackgroundResource(R.drawable.transparent_bg);
        this.lhb.setOnItemClickListener(this.lhu);
        this.lhb.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        this.lhf.setVerticalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
        this.lhf.setHorizontalSpacing(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
        this.lhh.setOnClickListener(this.onClickListener);
        this.lhc.setOnClickListener(this.onClickListener);
        this.lhe.setOnClickListener(this.onClickListener);
    }

    public void setDataAndRefreshUI(f fVar) {
        if (fVar == null) {
            this.ifw.setVisibility(8);
            return;
        }
        this.mData = fVar;
        initData();
        refreshUI();
    }

    private void initData() {
        if (this.mData != null) {
            this.lhn = this.mData.lhn;
            this.lhm = this.mData.lhm;
            if (this.lhn != null && this.lhm != null && this.lhm.lie != null) {
                this.lht = this.lhm.lie.lhZ;
                this.lhp = this.lhn.lhP;
                if (this.lhp != null) {
                    this.lhq = this.lhp.mContent;
                }
                this.lho = this.lhn.lhO;
                if (this.lho != null) {
                    this.lhr = this.lho.mContent;
                }
            }
        }
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

    private void refreshUI() {
        if (this.mData == null) {
            this.ifw.setVisibility(8);
        } else if (this.lhn == null || this.lhm == null) {
            this.ifw.setVisibility(8);
        } else if (this.lhm.lie == null) {
            this.ifw.setVisibility(8);
        } else if (this.lhp == null && this.lho == null) {
            this.ifw.setVisibility(8);
        } else if (this.lgC == 2 && (this.lhp == null || x.isEmpty(this.lhp.lhK))) {
            this.ifw.setVisibility(8);
        } else {
            this.ifw.setVisibility(0);
            ddx();
            ddy();
            ddz();
        }
    }

    private void ddx() {
        List<f.d> list;
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
            for (f.d dVar : list) {
                if (dVar.isChecked) {
                    Eh(dVar.isAutoPay);
                    hf(dVar.lhV);
                }
            }
            if (this.lhk == null) {
                this.lhk = new c(this.mTbPageContext);
                this.lhk.setData(list);
                this.lhb.setAdapter((ListAdapter) this.lhk);
            }
            this.lhk.setData(list);
            this.lhk.notifyDataSetChanged();
        }
    }

    private void ddy() {
        if (this.lhl == null) {
            ArrayList<d> ddA = ddA();
            this.lhl = new e(this.mTbPageContext.getPageActivity());
            this.lhl.setData(ddA);
            this.lhf.setAdapter((ListAdapter) this.lhl);
        }
    }

    private void ddz() {
        String str = null;
        if (2 == this.lgC) {
            if (this.lht == 2) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lhq});
            } else {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lhq});
            }
            this.lhs = this.lhq;
        } else if (1 == this.lgC) {
            if (this.lht == 1) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.lhr});
            } else if (this.lht == 0) {
                str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lhr});
            }
            this.lhs = this.lhr;
        } else {
            str = this.mTbPageContext.getPageActivity().getString(R.string.dredge, new Object[]{this.lhr});
            this.lhs = this.lhr;
        }
        this.mTitle = str;
    }

    private ArrayList<d> ddA() {
        ArrayList<d> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.lgC == 1) {
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
            linkedHashMap.put(this.mTbPageContext.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
        } else if (this.lgC == 2) {
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
            dVar.lhE = ((Integer) entry.getValue()).intValue();
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(int i) {
        if (i == 1) {
            this.lhg.setVisibility(0);
        } else {
            this.lhg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        this.lhh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j / 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddB() {
        f.d ddD = this.lhk.ddD();
        if (ddD == null) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tb_member_select_money_tip);
        } else if (ddD.isAutoPay == 1 && ddD.lhY) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.tips_auto_pay_succ);
        } else {
            b(ddD.lhU, ddD.lhV / 100, ddD.lhX, ddD.isAutoPay);
            if (this.lgP == 26) {
                TiebaStatic.log(new aq("c13748").an("obj_source", 1));
            }
        }
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.lgF.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setTitle(this.mTitle);
        payConfig.setOrderName(this.lhs + this.mTbPageContext.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        if (this.lgP == 23) {
            payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
        }
        com.baidu.tbadk.pay.c.bDD().a(payConfig, this.mTbPageContext.getPageActivity());
    }

    public void onChangeSkinType(int i) {
        this.lhi.onChangeSkinType(this.mTbPageContext, i);
        ao.setBackgroundColor(this.ifw, R.color.CAM_X0201);
        ao.setViewTextColor(this.lhj, R.color.CAM_X0107);
        ao.setViewTextColor(this.lhd, R.color.CAM_X0105);
        ao.setViewTextColor(this.lhe, R.color.CAM_X0107);
        this.lhe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
        ao.setViewTextColor(this.lhh, R.color.CAM_X0101);
        ao.setBackgroundResource(this.lhh, R.drawable.member_price_btn_bg);
        ao.setImageResource(this.lhc, R.drawable.icon_tbvip_attention);
    }
}
