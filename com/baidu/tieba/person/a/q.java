package com.baidu.tieba.person.a;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.t;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class q extends c<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.i> {
    private View.OnClickListener OZ;
    private List<MyGift> duR;
    private String duS;
    private TextView duT;
    private View duU;
    private BaseFragmentActivity duj;
    private boolean isSelf;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.duj = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.tieba.person.b.i b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(t.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.i iVar2) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(iVar2);
        if (iVar != null && this.bcn) {
            a(iVar2, iVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2) {
        if (iVar2 != null && iVar2.getUserData() != null && iVar != null) {
            this.OZ = new a(iVar2.getUserId(), iVar2.getUserData());
            this.isSelf = iVar2.getIsSelf();
            this.duT = iVar.dzn;
            this.duU = iVar.dzp;
            if (this.isSelf) {
                iVar.dzn.setVisibility(8);
            } else {
                iVar.dzn.setVisibility(0);
            }
            b(iVar, iVar2);
            iVar.dyH.setOnClickListener(this.OZ);
            iVar.dyO.setOnClickListener(this.OZ);
            iVar.dyR.setOnClickListener(this.OZ);
            iVar.dzn.setOnClickListener(this.OZ);
            iVar.dzp.setOnClickListener(this.OZ);
        }
    }

    private void b(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2) {
        if (iVar2 != null && iVar != null) {
            this.duR = iVar2.aBP();
            this.isSelf = iVar2.getIsSelf();
            this.duS = this.mContext.getResources().getString(t.j.gift_received_by_me);
            String string = this.mContext.getResources().getString(t.j.gifts_got_in_total);
            if (!this.isSelf && iVar2.getSex() == 2) {
                this.duS = this.mContext.getResources().getString(t.j.gift_received_by_her);
            } else if (!this.isSelf && (iVar2.getSex() == 1 || iVar2.getSex() == 0)) {
                this.duS = this.mContext.getResources().getString(t.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.p(this.duR) == 0) {
                iVar.dyO.setVisibility(8);
                iVar.dyH.setVisibility(8);
                iVar.dzj.setVisibility(0);
                iVar.dzk.setText(this.duS);
                iVar.dyH.setPadding(0, 0, 0, 0);
                iVar.dzj.setOnClickListener(this.OZ);
                a(iVar, iVar2, String.format(string, ay.z(0)));
                return;
            }
            int giftNum = this.duR != null ? iVar2.getGiftNum() : 0;
            iVar.dyP.setText(this.duS);
            iVar.dyO.setVisibility(0);
            iVar.dzj.setVisibility(8);
            iVar.dyH.setVisibility(0);
            iVar.dyS.setVisibility(0);
            iVar.dyR.setText(ay.z(giftNum));
            a(iVar, iVar2, String.format(string, ay.z(giftNum)));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.p(this.duR) && i < 4; i++) {
                if (i == 0) {
                    iVar.dyT.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.duR, i) != null) {
                        iVar.dyX.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftName(), 5, "..."));
                        u(iVar.dyX, ((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftNum());
                        iVar.dyV.setBorderWidth(0);
                        iVar.dyV.setBorderColor(this.duj.getResources().getColor(t.d.transparent));
                        iVar.dyV.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftIcon(), 10, false);
                        iVar.dyZ.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    iVar.dyU.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.duR, i) != null) {
                        iVar.dyY.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftName(), 5, "..."));
                        u(iVar.dyY, ((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftNum());
                        iVar.dyW.setBorderWidth(0);
                        iVar.dyW.setBorderColor(this.duj.getResources().getColor(t.d.transparent));
                        iVar.dyW.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftIcon(), 10, false);
                        iVar.dza.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    iVar.dzb.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.duR, i) != null) {
                        iVar.dzf.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftName(), 5, "..."));
                        u(iVar.dzf, ((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftNum());
                        iVar.dzd.setBorderWidth(0);
                        iVar.dzd.setBorderColor(this.duj.getResources().getColor(t.d.transparent));
                        iVar.dzd.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftIcon(), 10, false);
                        iVar.dzh.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    iVar.dzc.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.duR, i) != null) {
                        iVar.dzg.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftName(), 5, "..."));
                        u(iVar.dzg, ((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftNum());
                        iVar.dze.setBorderWidth(0);
                        iVar.dze.setBorderColor(this.duj.getResources().getColor(t.d.transparent));
                        iVar.dze.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getGiftIcon(), 10, false);
                        iVar.dzi.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.b(this.duR, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2, String str) {
        String string;
        if (iVar2.aBQ()) {
            this.duT.setVisibility(8);
            iVar.dzo.setVisibility(0);
            iVar.dzp.setVisibility(0);
            if (iVar2.getSex() == 2) {
                string = this.mContext.getResources().getString(t.j.give_gift_her);
            } else {
                string = this.mContext.getResources().getString(t.j.give_gift_him);
            }
            iVar.dzr.setText(string);
            iVar.dyR.setText(str);
            return;
        }
        iVar.dzo.setVisibility(8);
        iVar.dzp.setVisibility(8);
    }

    public void u(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + bF(i));
        spannableString.setSpan(new ForegroundColorSpan(this.duj.getResources().getColor(t.d.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String bF(long j) {
        if (j > 99999000) {
            return "9999.9+w";
        }
        if (j > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
        }
        if (j < 0) {
            return "0";
        }
        return new StringBuilder().append(j).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private UserData TP;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.TP = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!q.this.aBG()) {
                q.this.duj.showToast(t.j.gift_load_fail);
            } else if (bl.ad(q.this.duj.getActivity())) {
                if ((q.this.duT != null && view.getId() == q.this.duT.getId()) || (q.this.duU != null && view.getId() == q.this.duU.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(q.this.duj.getPageContext().getPageActivity(), this.TP.getUserIdLong(), this.TP.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.TP != null) {
                    if (q.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10595").r("obj_type", 3));
                        } else {
                            TiebaStatic.log(new aw("c10595").r("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10612").r("obj_type", 3).ac("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new aw("c10612").r("obj_type", 1).ac("obj_id", this.id));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(q.this.duj.getPageContext().getPageActivity(), this.TP.getUserId(), this.TP.getUserName(), this.TP.getSex(), str)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBG() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.i iVar) {
        if (iVar != null && iVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(iVar.dyH, t.f.addresslist_item_bg);
            at.k(iVar.dzj, t.f.addresslist_item_bg);
            at.l(iVar.getView(), t.d.cp_bg_line_d);
            at.l(iVar.dyN, t.d.cp_bg_line_c);
            at.l(iVar.dyS, t.d.cp_bg_line_b);
            at.l(iVar.dyF, t.d.cp_bg_line_b);
            at.b(iVar.dyP, t.d.cp_cont_f, 1);
            at.b(iVar.dyR, t.d.cp_cont_c, 1);
            at.b(iVar.dyX, t.d.cp_cont_f, 1);
            at.b(iVar.dyZ, t.d.cp_cont_d, 1);
            at.b(iVar.dyY, t.d.cp_cont_f, 1);
            at.b(iVar.dza, t.d.cp_cont_d, 1);
            at.b(iVar.dzf, t.d.cp_cont_f, 1);
            at.b(iVar.dzh, t.d.cp_cont_d, 1);
            at.b(iVar.dzg, t.d.cp_cont_f, 1);
            at.b(iVar.dzi, t.d.cp_cont_d, 1);
            at.b(iVar.dzk, t.d.cp_cont_f, 1);
            at.b(iVar.dzl, t.d.cp_cont_d, 1);
            at.c(iVar.dyQ, t.f.icon_arrow_tab);
            at.c(iVar.dzm, t.f.icon_mycenter_lock);
            at.b(iVar.dzn, t.d.cp_cont_i, 1);
            at.c(iVar.dzn, t.f.btn_all_orange, 1);
            at.l(iVar.dzo, t.d.cp_bg_line_b);
            at.k(iVar.dzp, t.f.addresslist_item_bg);
            at.b(iVar.dzr, t.d.cp_link_tip_a, 1);
            at.c(iVar.dzq, t.f.icon_mine_gift);
        }
    }
}
