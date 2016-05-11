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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.t;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class r extends c<com.baidu.tieba.person.data.j, com.baidu.tieba.person.b.j> {
    private View.OnClickListener Fn;
    private BaseFragmentActivity cSp;
    private List<MyGift> dxN;
    private String dxO;
    private TextView dxP;
    private View dxQ;
    private boolean isSelf;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public com.baidu.tieba.person.b.j b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(t.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.j jVar, com.baidu.tieba.person.b.j jVar2) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        a(jVar2);
        if (jVar != null && this.bUL) {
            a(jVar2, jVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2) {
        if (jVar2 != null && jVar2.getUserData() != null && jVar != null) {
            this.Fn = new a(jVar2.getUserId(), jVar2.getUserData());
            this.isSelf = jVar2.getIsSelf();
            this.dxP = jVar.dCv;
            this.dxQ = jVar.dCx;
            if (this.isSelf) {
                jVar.dCv.setVisibility(8);
            } else {
                jVar.dCv.setVisibility(0);
            }
            b(jVar, jVar2);
            jVar.dBP.setOnClickListener(this.Fn);
            jVar.dBW.setOnClickListener(this.Fn);
            jVar.dBZ.setOnClickListener(this.Fn);
            jVar.dCv.setOnClickListener(this.Fn);
            jVar.dCx.setOnClickListener(this.Fn);
        }
    }

    private void b(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2) {
        if (jVar2 != null && jVar != null) {
            this.dxN = jVar2.aCh();
            this.isSelf = jVar2.getIsSelf();
            this.dxO = this.mContext.getResources().getString(t.j.gift_received_by_me);
            String string = this.mContext.getResources().getString(t.j.gifts_got_in_total);
            if (!this.isSelf && jVar2.getSex() == 2) {
                this.dxO = this.mContext.getResources().getString(t.j.gift_received_by_her);
            } else if (!this.isSelf && (jVar2.getSex() == 1 || jVar2.getSex() == 0)) {
                this.dxO = this.mContext.getResources().getString(t.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.r(this.dxN) == 0) {
                jVar.dBW.setVisibility(8);
                jVar.dBP.setVisibility(8);
                jVar.dCr.setVisibility(0);
                jVar.dCs.setText(this.dxO);
                jVar.dBP.setPadding(0, 0, 0, 0);
                jVar.dCr.setOnClickListener(this.Fn);
                a(jVar, jVar2, String.format(string, ay.A(0)));
                return;
            }
            int giftNum = this.dxN != null ? jVar2.getGiftNum() : 0;
            jVar.dBX.setText(this.dxO);
            jVar.dBW.setVisibility(0);
            jVar.dCr.setVisibility(8);
            jVar.dBP.setVisibility(0);
            jVar.dCa.setVisibility(0);
            jVar.dBZ.setText(ay.A(giftNum));
            a(jVar, jVar2, String.format(string, ay.A(giftNum)));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.r(this.dxN) && i < 4; i++) {
                if (i == 0) {
                    jVar.dCb.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.dxN, i) != null) {
                        jVar.dCf.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftName(), 5, "..."));
                        u(jVar.dCf, ((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftNum());
                        jVar.dCd.setBorderWidth(0);
                        jVar.dCd.setBorderColor(this.cSp.getResources().getColor(t.d.transparent));
                        jVar.dCd.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftIcon(), 10, false);
                        jVar.dCh.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    jVar.dCc.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.dxN, i) != null) {
                        jVar.dCg.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftName(), 5, "..."));
                        u(jVar.dCg, ((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftNum());
                        jVar.dCe.setBorderWidth(0);
                        jVar.dCe.setBorderColor(this.cSp.getResources().getColor(t.d.transparent));
                        jVar.dCe.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftIcon(), 10, false);
                        jVar.dCi.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    jVar.dCj.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.dxN, i) != null) {
                        jVar.dCn.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftName(), 5, "..."));
                        u(jVar.dCn, ((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftNum());
                        jVar.dCl.setBorderWidth(0);
                        jVar.dCl.setBorderColor(this.cSp.getResources().getColor(t.d.transparent));
                        jVar.dCl.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftIcon(), 10, false);
                        jVar.dCp.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    jVar.dCk.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.dxN, i) != null) {
                        jVar.dCo.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftName(), 5, "..."));
                        u(jVar.dCo, ((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftNum());
                        jVar.dCm.setBorderWidth(0);
                        jVar.dCm.setBorderColor(this.cSp.getResources().getColor(t.d.transparent));
                        jVar.dCm.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getGiftIcon(), 10, false);
                        jVar.dCq.setText(ay.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.dxN, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2, String str) {
        String string;
        if (jVar2.aCi()) {
            this.dxP.setVisibility(8);
            jVar.dCw.setVisibility(0);
            jVar.dCx.setVisibility(0);
            if (jVar2.getSex() == 2) {
                string = this.mContext.getResources().getString(t.j.give_gift_her);
            } else {
                string = this.mContext.getResources().getString(t.j.give_gift_him);
            }
            jVar.dCz.setText(string);
            jVar.dBZ.setText(str);
            return;
        }
        jVar.dCw.setVisibility(8);
        jVar.dCx.setVisibility(8);
    }

    public void u(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + bF(i));
        spannableString.setSpan(new ForegroundColorSpan(this.cSp.getResources().getColor(t.d.cp_link_tip_d)), 0, spannableString.length(), 33);
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
        private UserData OE;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.OE = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!r.this.aBW()) {
                r.this.cSp.showToast(t.j.gift_load_fail);
            } else if (bl.ac(r.this.cSp.getActivity())) {
                if ((r.this.dxP != null && view.getId() == r.this.dxP.getId()) || (r.this.dxQ != null && view.getId() == r.this.dxQ.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(r.this.cSp.getPageContext().getPageActivity(), this.OE.getUserIdLong(), this.OE.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.OE != null) {
                    if (r.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10595").s("obj_type", 3));
                        } else {
                            TiebaStatic.log(new aw("c10595").s("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10612").s("obj_type", 3).ac("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new aw("c10612").s("obj_type", 1).ac("obj_id", this.id));
                        }
                    }
                    if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(r.this.cSp.getPageContext().getPageActivity(), this.OE.getUserId(), this.OE.getUserName(), this.OE.getSex(), str)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBW() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        if (jVar != null && jVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(jVar.dBP, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(jVar.dCr, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(jVar.getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(jVar.dBV, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(jVar.dCa, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.l(jVar.dBN, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.c(jVar.dBX, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dBZ, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCf, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCh, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCg, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCi, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCn, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCp, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCo, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCq, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCs, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCt, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dBY, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.c(jVar.dCu, t.f.icon_mycenter_lock);
            com.baidu.tbadk.core.util.at.c(jVar.dCv, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.at.d(jVar.dCv, t.f.btn_all_orange, 1);
            com.baidu.tbadk.core.util.at.l(jVar.dCw, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(jVar.dCx, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(jVar.dCz, t.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.at.c(jVar.dCy, t.f.icon_mine_gift);
        }
    }
}
