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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.u;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.i, com.baidu.tieba.person.holder.j> {
    private View.OnClickListener afk;
    private BaseFragmentActivity bgI;
    private List<MyGift> eqi;
    private String eqj;
    private TextView eqk;
    private View eql;
    private boolean isSelf;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public com.baidu.tieba.person.holder.j a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.j(LayoutInflater.from(this.mContext).inflate(u.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.holder.j jVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        a(jVar);
        if (iVar != null && this.aNz) {
            a(jVar, iVar);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.j jVar, com.baidu.tieba.person.data.i iVar) {
        if (iVar != null && iVar.getUserData() != null && jVar != null) {
            this.afk = new a(iVar.getUserId(), iVar.getUserData());
            this.isSelf = iVar.getIsSelf();
            this.eqk = jVar.evv;
            this.eql = jVar.evx;
            if (this.isSelf) {
                jVar.evv.setVisibility(8);
            } else {
                jVar.evv.setVisibility(0);
            }
            b(jVar, iVar);
            jVar.euP.setOnClickListener(this.afk);
            jVar.euW.setOnClickListener(this.afk);
            jVar.euZ.setOnClickListener(this.afk);
            jVar.evv.setOnClickListener(this.afk);
            jVar.evx.setOnClickListener(this.afk);
        }
    }

    private void b(com.baidu.tieba.person.holder.j jVar, com.baidu.tieba.person.data.i iVar) {
        if (iVar != null && jVar != null) {
            this.eqi = iVar.aNG();
            this.isSelf = iVar.getIsSelf();
            this.eqj = this.mContext.getResources().getString(u.j.gift_received_by_me);
            String string = this.mContext.getResources().getString(u.j.gifts_got_in_total);
            if (!this.isSelf && iVar.getSex() == 2) {
                this.eqj = this.mContext.getResources().getString(u.j.gift_received_by_her);
            } else if (!this.isSelf && (iVar.getSex() == 1 || iVar.getSex() == 0)) {
                this.eqj = this.mContext.getResources().getString(u.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.s(this.eqi) == 0) {
                jVar.euW.setVisibility(8);
                jVar.euP.setVisibility(8);
                jVar.evr.setVisibility(0);
                jVar.evs.setText(this.eqj);
                jVar.euP.setPadding(0, 0, 0, 0);
                jVar.evr.setOnClickListener(this.afk);
                a(jVar, iVar, String.format(string, ba.w(0)));
                return;
            }
            int giftNum = this.eqi != null ? iVar.getGiftNum() : 0;
            jVar.euX.setText(this.eqj);
            jVar.euW.setVisibility(0);
            jVar.evr.setVisibility(8);
            jVar.euP.setVisibility(0);
            jVar.eva.setVisibility(0);
            jVar.euZ.setText(ba.w(giftNum));
            a(jVar, iVar, String.format(string, ba.w(giftNum)));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.eqi) && i < 4; i++) {
                if (i == 0) {
                    jVar.evb.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.eqi, i) != null) {
                        jVar.evf.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftName(), 5, "..."));
                        t(jVar.evf, ((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftNum());
                        jVar.evd.setBorderWidth(0);
                        jVar.evd.setBorderColor(this.bgI.getResources().getColor(u.d.common_color_10022));
                        jVar.evd.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftIcon(), 10, false);
                        jVar.evh.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    jVar.evc.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.eqi, i) != null) {
                        jVar.evg.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftName(), 5, "..."));
                        t(jVar.evg, ((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftNum());
                        jVar.eve.setBorderWidth(0);
                        jVar.eve.setBorderColor(this.bgI.getResources().getColor(u.d.common_color_10022));
                        jVar.eve.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftIcon(), 10, false);
                        jVar.evi.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    jVar.evj.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.eqi, i) != null) {
                        jVar.evn.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftName(), 5, "..."));
                        t(jVar.evn, ((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftNum());
                        jVar.evl.setBorderWidth(0);
                        jVar.evl.setBorderColor(this.bgI.getResources().getColor(u.d.common_color_10022));
                        jVar.evl.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftIcon(), 10, false);
                        jVar.evp.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    jVar.evk.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.eqi, i) != null) {
                        jVar.evo.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftName(), 5, "..."));
                        t(jVar.evo, ((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftNum());
                        jVar.evm.setBorderWidth(0);
                        jVar.evm.setBorderColor(this.bgI.getResources().getColor(u.d.common_color_10022));
                        jVar.evm.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getGiftIcon(), 10, false);
                        jVar.evq.setText(ba.c(((MyGift) com.baidu.tbadk.core.util.y.c(this.eqi, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.person.holder.j jVar, com.baidu.tieba.person.data.i iVar, String str) {
        String string;
        if (iVar.aNH()) {
            this.eqk.setVisibility(8);
            jVar.evw.setVisibility(0);
            jVar.evx.setVisibility(0);
            if (iVar.getSex() == 2) {
                string = this.mContext.getResources().getString(u.j.give_gift_her);
            } else {
                string = this.mContext.getResources().getString(u.j.give_gift_him);
            }
            jVar.evz.setText(string);
            jVar.euZ.setText(str);
            return;
        }
        jVar.evw.setVisibility(8);
        jVar.evx.setVisibility(8);
    }

    public void t(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + ch(i));
        spannableString.setSpan(new ForegroundColorSpan(this.bgI.getResources().getColor(u.d.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String ch(long j) {
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
        private UserData OS;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.OS = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!p.this.aNu()) {
                p.this.bgI.showToast(u.j.gift_load_fail);
            } else if (bn.ab(p.this.bgI.getActivity())) {
                if ((p.this.eqk != null && view.getId() == p.this.eqk.getId()) || (p.this.eql != null && view.getId() == p.this.eql.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(p.this.bgI.getPageContext().getPageActivity(), this.OS.getUserIdLong(), this.OS.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.OS != null) {
                    if (p.this.isSelf) {
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
                    if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(p.this.bgI.getPageContext().getPageActivity(), this.OS.getUserId(), this.OS.getUserName(), this.OS.getSex(), str)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNu() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.holder.j jVar) {
        if (jVar != null && jVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(jVar.euP, u.f.addresslist_item_bg);
            av.k(jVar.evr, u.f.addresslist_item_bg);
            av.l(jVar.getView(), u.d.cp_bg_line_d);
            av.l(jVar.euV, u.d.cp_bg_line_c);
            av.l(jVar.eva, u.d.cp_bg_line_b);
            av.l(jVar.euN, u.d.cp_bg_line_b);
            av.c(jVar.euX, u.d.cp_cont_f, 1);
            av.c(jVar.euZ, u.d.cp_cont_c, 1);
            av.c(jVar.evf, u.d.cp_cont_f, 1);
            av.c(jVar.evh, u.d.cp_cont_d, 1);
            av.c(jVar.evg, u.d.cp_cont_f, 1);
            av.c(jVar.evi, u.d.cp_cont_d, 1);
            av.c(jVar.evn, u.d.cp_cont_f, 1);
            av.c(jVar.evp, u.d.cp_cont_d, 1);
            av.c(jVar.evo, u.d.cp_cont_f, 1);
            av.c(jVar.evq, u.d.cp_cont_d, 1);
            av.c(jVar.evs, u.d.cp_cont_f, 1);
            av.c(jVar.evt, u.d.cp_cont_d, 1);
            av.c(jVar.euY, u.f.icon_arrow_tab);
            av.c(jVar.evu, u.f.icon_mycenter_lock);
            av.c(jVar.evv, u.d.cp_cont_i, 1);
            av.d(jVar.evv, u.f.btn_all_orange, 1);
            av.l(jVar.evw, u.d.cp_bg_line_b);
            av.k(jVar.evx, u.f.addresslist_item_bg);
            av.c(jVar.evz, u.d.cp_link_tip_a, 1);
            av.c(jVar.evy, u.f.icon_mine_gift);
        }
    }
}
