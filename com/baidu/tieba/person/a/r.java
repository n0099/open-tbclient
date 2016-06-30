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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.u;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.j, com.baidu.tieba.person.b.j> {
    private View.OnClickListener aew;
    private BaseFragmentActivity bfw;
    private List<MyGift> egj;
    private String egk;
    private TextView egl;
    private View egm;
    private boolean isSelf;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public com.baidu.tieba.person.b.j a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(u.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.j jVar, com.baidu.tieba.person.b.j jVar2) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        a(jVar2);
        if (jVar != null && this.aMF) {
            a(jVar2, jVar);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2) {
        if (jVar2 != null && jVar2.getUserData() != null && jVar != null) {
            this.aew = new a(jVar2.getUserId(), jVar2.getUserData());
            this.isSelf = jVar2.getIsSelf();
            this.egl = jVar.ekY;
            this.egm = jVar.ela;
            if (this.isSelf) {
                jVar.ekY.setVisibility(8);
            } else {
                jVar.ekY.setVisibility(0);
            }
            b(jVar, jVar2);
            jVar.eks.setOnClickListener(this.aew);
            jVar.ekz.setOnClickListener(this.aew);
            jVar.ekC.setOnClickListener(this.aew);
            jVar.ekY.setOnClickListener(this.aew);
            jVar.ela.setOnClickListener(this.aew);
        }
    }

    private void b(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2) {
        if (jVar2 != null && jVar != null) {
            this.egj = jVar2.aLd();
            this.isSelf = jVar2.getIsSelf();
            this.egk = this.mContext.getResources().getString(u.j.gift_received_by_me);
            String string = this.mContext.getResources().getString(u.j.gifts_got_in_total);
            if (!this.isSelf && jVar2.getSex() == 2) {
                this.egk = this.mContext.getResources().getString(u.j.gift_received_by_her);
            } else if (!this.isSelf && (jVar2.getSex() == 1 || jVar2.getSex() == 0)) {
                this.egk = this.mContext.getResources().getString(u.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.s(this.egj) == 0) {
                jVar.ekz.setVisibility(8);
                jVar.eks.setVisibility(8);
                jVar.ekU.setVisibility(0);
                jVar.ekV.setText(this.egk);
                jVar.eks.setPadding(0, 0, 0, 0);
                jVar.ekU.setOnClickListener(this.aew);
                a(jVar, jVar2, String.format(string, ba.B(0)));
                return;
            }
            int giftNum = this.egj != null ? jVar2.getGiftNum() : 0;
            jVar.ekA.setText(this.egk);
            jVar.ekz.setVisibility(0);
            jVar.ekU.setVisibility(8);
            jVar.eks.setVisibility(0);
            jVar.ekD.setVisibility(0);
            jVar.ekC.setText(ba.B(giftNum));
            a(jVar, jVar2, String.format(string, ba.B(giftNum)));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.egj) && i < 4; i++) {
                if (i == 0) {
                    jVar.ekE.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.egj, i) != null) {
                        jVar.ekI.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftName(), 5, "..."));
                        t(jVar.ekI, ((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftNum());
                        jVar.ekG.setBorderWidth(0);
                        jVar.ekG.setBorderColor(this.bfw.getResources().getColor(u.d.common_color_10022));
                        jVar.ekG.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftIcon(), 10, false);
                        jVar.ekK.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    jVar.ekF.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.egj, i) != null) {
                        jVar.ekJ.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftName(), 5, "..."));
                        t(jVar.ekJ, ((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftNum());
                        jVar.ekH.setBorderWidth(0);
                        jVar.ekH.setBorderColor(this.bfw.getResources().getColor(u.d.common_color_10022));
                        jVar.ekH.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftIcon(), 10, false);
                        jVar.ekL.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    jVar.ekM.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.egj, i) != null) {
                        jVar.ekQ.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftName(), 5, "..."));
                        t(jVar.ekQ, ((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftNum());
                        jVar.ekO.setBorderWidth(0);
                        jVar.ekO.setBorderColor(this.bfw.getResources().getColor(u.d.common_color_10022));
                        jVar.ekO.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftIcon(), 10, false);
                        jVar.ekS.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    jVar.ekN.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.egj, i) != null) {
                        jVar.ekR.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftName(), 5, "..."));
                        t(jVar.ekR, ((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftNum());
                        jVar.ekP.setBorderWidth(0);
                        jVar.ekP.setBorderColor(this.bfw.getResources().getColor(u.d.common_color_10022));
                        jVar.ekP.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getGiftIcon(), 10, false);
                        jVar.ekT.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.egj, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.j jVar2, String str) {
        String string;
        if (jVar2.aLe()) {
            this.egl.setVisibility(8);
            jVar.ekZ.setVisibility(0);
            jVar.ela.setVisibility(0);
            if (jVar2.getSex() == 2) {
                string = this.mContext.getResources().getString(u.j.give_gift_her);
            } else {
                string = this.mContext.getResources().getString(u.j.give_gift_him);
            }
            jVar.elc.setText(string);
            jVar.ekC.setText(str);
            return;
        }
        jVar.ekZ.setVisibility(8);
        jVar.ela.setVisibility(8);
    }

    public void t(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + ci(i));
        spannableString.setSpan(new ForegroundColorSpan(this.bfw.getResources().getColor(u.d.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String ci(long j) {
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
            if (!r.this.aKR()) {
                r.this.bfw.showToast(u.j.gift_load_fail);
            } else if (bn.ab(r.this.bfw.getActivity())) {
                if ((r.this.egl != null && view.getId() == r.this.egl.getId()) || (r.this.egm != null && view.getId() == r.this.egm.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(r.this.bfw.getPageContext().getPageActivity(), this.OE.getUserIdLong(), this.OE.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.OE != null) {
                    if (r.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == u.g.group_none) {
                            TiebaStatic.log(new ay("c10595").s("obj_type", 3));
                        } else {
                            TiebaStatic.log(new ay("c10595").s("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == u.g.group_none) {
                            TiebaStatic.log(new ay("c10612").s("obj_type", 3).ab("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new ay("c10612").s("obj_type", 1).ab("obj_id", this.id));
                        }
                    }
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(r.this.bfw.getPageContext().getPageActivity(), this.OE.getUserId(), this.OE.getUserName(), this.OE.getSex(), str)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKR() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        if (jVar != null && jVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(jVar.eks, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(jVar.ekU, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(jVar.getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(jVar.eky, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(jVar.ekD, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.l(jVar.ekq, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(jVar.ekA, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekC, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekI, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekK, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekJ, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekL, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekQ, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekS, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekR, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekT, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekV, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekW, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(jVar.ekB, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.c(jVar.ekX, u.f.icon_mycenter_lock);
            com.baidu.tbadk.core.util.av.c(jVar.ekY, u.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.av.d(jVar.ekY, u.f.btn_all_orange, 1);
            com.baidu.tbadk.core.util.av.l(jVar.ekZ, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(jVar.ela, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(jVar.elc, u.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.c(jVar.elb, u.f.icon_mine_gift);
        }
    }
}
