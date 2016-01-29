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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.t;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class q extends c<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.i> {
    private View.OnClickListener OS;
    private BaseFragmentActivity cZG;
    private List<MyGift> dan;
    private String dao;
    private TextView dap;
    private View daq;
    private boolean isSelf;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.cZG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.person.b.i b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(t.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.i iVar2) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(iVar2);
        if (iVar != null && this.aXE) {
            a(iVar2, iVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2) {
        if (iVar2 != null && iVar2.getUserData() != null && iVar != null) {
            this.OS = new a(iVar2.getUserId(), iVar2.getUserData());
            this.isSelf = iVar2.getIsSelf();
            this.dap = iVar.deO;
            this.daq = iVar.deQ;
            if (this.isSelf) {
                iVar.deO.setVisibility(8);
            } else {
                iVar.deO.setVisibility(0);
            }
            b(iVar, iVar2);
            iVar.deh.setOnClickListener(this.OS);
            iVar.dep.setOnClickListener(this.OS);
            iVar.des.setOnClickListener(this.OS);
            iVar.deO.setOnClickListener(this.OS);
            iVar.deQ.setOnClickListener(this.OS);
        }
    }

    private void b(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2) {
        if (iVar2 != null && iVar != null) {
            this.dan = iVar2.auj();
            this.isSelf = iVar2.getIsSelf();
            this.dao = this.mContext.getResources().getString(t.j.gift_received_by_me);
            String string = this.mContext.getResources().getString(t.j.gifts_got_in_total);
            if (!this.isSelf && iVar2.getSex() == 2) {
                this.dao = this.mContext.getResources().getString(t.j.gift_received_by_her);
            } else if (!this.isSelf && (iVar2.getSex() == 1 || iVar2.getSex() == 0)) {
                this.dao = this.mContext.getResources().getString(t.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.x.o(this.dan) == 0) {
                iVar.dep.setVisibility(8);
                iVar.deh.setVisibility(8);
                iVar.deK.setVisibility(0);
                iVar.deL.setText(this.dao);
                iVar.deh.setPadding(0, 0, 0, 0);
                iVar.deK.setOnClickListener(this.OS);
                a(iVar, iVar2, String.format(string, aw.x(0)));
                return;
            }
            int giftNum = this.dan != null ? iVar2.getGiftNum() : 0;
            iVar.deq.setText(this.dao);
            iVar.dep.setVisibility(0);
            iVar.deK.setVisibility(8);
            iVar.deh.setVisibility(0);
            iVar.det.setVisibility(0);
            iVar.des.setText(aw.x(giftNum));
            a(iVar, iVar2, String.format(string, aw.x(giftNum)));
            for (int i = 0; i < com.baidu.tbadk.core.util.x.o(this.dan) && i < 4; i++) {
                if (i == 0) {
                    iVar.deu.setVisibility(0);
                    if (com.baidu.tbadk.core.util.x.b(this.dan, i) != null) {
                        iVar.dey.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftName(), 5, "..."));
                        t(iVar.dey, ((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftNum());
                        iVar.dew.setBorderWidth(0);
                        iVar.dew.setBorderColor(this.cZG.getResources().getColor(t.d.transparent));
                        iVar.dew.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftIcon(), 10, false);
                        iVar.deA.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    iVar.dev.setVisibility(0);
                    if (com.baidu.tbadk.core.util.x.b(this.dan, i) != null) {
                        iVar.dez.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftName(), 5, "..."));
                        t(iVar.dez, ((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftNum());
                        iVar.dex.setBorderWidth(0);
                        iVar.dex.setBorderColor(this.cZG.getResources().getColor(t.d.transparent));
                        iVar.dex.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftIcon(), 10, false);
                        iVar.deB.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    iVar.deC.setVisibility(0);
                    if (com.baidu.tbadk.core.util.x.b(this.dan, i) != null) {
                        iVar.deG.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftName(), 5, "..."));
                        t(iVar.deG, ((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftNum());
                        iVar.deE.setBorderWidth(0);
                        iVar.deE.setBorderColor(this.cZG.getResources().getColor(t.d.transparent));
                        iVar.deE.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftIcon(), 10, false);
                        iVar.deI.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    iVar.deD.setVisibility(0);
                    if (com.baidu.tbadk.core.util.x.b(this.dan, i) != null) {
                        iVar.deH.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftName(), 5, "..."));
                        t(iVar.deH, ((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftNum());
                        iVar.deF.setBorderWidth(0);
                        iVar.deF.setBorderColor(this.cZG.getResources().getColor(t.d.transparent));
                        iVar.deF.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getGiftIcon(), 10, false);
                        iVar.deJ.setText(aw.d(((MyGift) com.baidu.tbadk.core.util.x.b(this.dan, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.i iVar2, String str) {
        String string;
        if (iVar2.auk()) {
            this.dap.setVisibility(8);
            iVar.deP.setVisibility(0);
            iVar.deQ.setVisibility(0);
            if (iVar2.getSex() == 2) {
                string = this.mContext.getResources().getString(t.j.give_gift_her);
            } else {
                string = this.mContext.getResources().getString(t.j.give_gift_him);
            }
            iVar.deS.setText(string);
            iVar.des.setText(str);
            return;
        }
        iVar.deP.setVisibility(8);
        iVar.deQ.setVisibility(8);
    }

    public void t(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + bo(i));
        spannableString.setSpan(new ForegroundColorSpan(this.cZG.getResources().getColor(t.d.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String bo(long j) {
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
        private UserData VL;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.VL = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!q.this.aub()) {
                q.this.cZG.showToast(t.j.gift_load_fail);
            } else if (bi.ah(q.this.cZG.getActivity())) {
                if ((q.this.dap != null && view.getId() == q.this.dap.getId()) || (q.this.daq != null && view.getId() == q.this.daq.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(q.this.cZG.getPageContext().getPageActivity(), this.VL.getUserIdLong(), this.VL.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.VL != null) {
                    if (q.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new au("c10595").r("obj_type", 3));
                        } else {
                            TiebaStatic.log(new au("c10595").r("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new au("c10612").r("obj_type", 3).aa("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new au("c10612").r("obj_type", 1).aa("obj_id", this.id));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(q.this.cZG.getPageContext().getPageActivity(), this.VL.getUserId(), this.VL.getUserName(), this.VL.getSex(), str)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aub() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.i iVar) {
        if (iVar != null && iVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(iVar.deh, t.f.addresslist_item_bg);
            ar.k(iVar.deK, t.f.addresslist_item_bg);
            ar.l(iVar.getView(), t.d.cp_bg_line_d);
            ar.l(iVar.deo, t.d.cp_bg_line_c);
            ar.l(iVar.det, t.d.cp_bg_line_b);
            ar.l(iVar.def, t.d.cp_bg_line_b);
            ar.b(iVar.deq, t.d.cp_cont_f, 1);
            ar.b(iVar.des, t.d.cp_cont_c, 1);
            ar.b(iVar.dey, t.d.cp_cont_f, 1);
            ar.b(iVar.deA, t.d.cp_cont_d, 1);
            ar.b(iVar.dez, t.d.cp_cont_f, 1);
            ar.b(iVar.deB, t.d.cp_cont_d, 1);
            ar.b(iVar.deG, t.d.cp_cont_f, 1);
            ar.b(iVar.deI, t.d.cp_cont_d, 1);
            ar.b(iVar.deH, t.d.cp_cont_f, 1);
            ar.b(iVar.deJ, t.d.cp_cont_d, 1);
            ar.b(iVar.deL, t.d.cp_cont_f, 1);
            ar.b(iVar.deM, t.d.cp_cont_d, 1);
            ar.c(iVar.der, t.f.icon_arrow_tab);
            ar.c(iVar.deN, t.f.icon_mycenter_lock);
            ar.b(iVar.deO, t.d.cp_cont_i, 1);
            ar.c(iVar.deO, t.f.btn_all_orange, 1);
            ar.l(iVar.deP, t.d.cp_bg_line_b);
            ar.k(iVar.deQ, t.f.addresslist_item_bg);
            ar.b(iVar.deS, t.d.cp_link_tip_a, 1);
            ar.c(iVar.deR, t.f.icon_mine_gift);
        }
    }
}
