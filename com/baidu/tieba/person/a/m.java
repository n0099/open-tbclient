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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tieba.n;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class m extends c<com.baidu.tieba.person.data.g, com.baidu.tieba.person.b.f> {
    private List<MyGift> cMp;
    private String cMq;
    private TextView cMr;
    private boolean isSelf;
    private BaseFragmentActivity mActivity;
    private View.OnClickListener mClickListener;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public com.baidu.tieba.person.b.f a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.f(LayoutInflater.from(this.mContext).inflate(n.g.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, com.baidu.tieba.person.b.f fVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(fVar);
        if (gVar != null && this.aRB) {
            a(fVar, gVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null && gVar.getUserData() != null && fVar != null) {
            this.mClickListener = new a(gVar.getUserId(), gVar.getUserData());
            this.isSelf = gVar.getIsSelf();
            this.cMr = fVar.cOQ;
            if (this.isSelf) {
                fVar.cOQ.setVisibility(8);
            } else {
                fVar.cOQ.setVisibility(0);
            }
            b(fVar, gVar);
            fVar.cOl.setOnClickListener(this.mClickListener);
            fVar.cOs.setOnClickListener(this.mClickListener);
            fVar.cOv.setOnClickListener(this.mClickListener);
            fVar.cOQ.setOnClickListener(this.mClickListener);
        }
    }

    private void b(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null && fVar != null) {
            this.cMp = gVar.aoh();
            this.isSelf = gVar.getIsSelf();
            this.cMq = this.mContext.getResources().getString(n.i.gift_received_by_me);
            this.mContext.getResources().getString(n.i.gifts_got_in_total);
            if (!this.isSelf && gVar.getSex() == 2) {
                this.cMq = this.mContext.getResources().getString(n.i.gift_received_by_her);
            } else if (!this.isSelf && (gVar.getSex() == 1 || gVar.getSex() == 0)) {
                this.cMq = this.mContext.getResources().getString(n.i.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.k(this.cMp) == 0) {
                fVar.cOs.setVisibility(8);
                fVar.cOl.setVisibility(8);
                fVar.cOM.setVisibility(0);
                fVar.cON.setText(this.cMq);
                fVar.cOl.setPadding(0, 0, 0, 0);
                fVar.cOM.setOnClickListener(this.mClickListener);
                return;
            }
            int giftNum = this.cMp != null ? gVar.getGiftNum() : 0;
            fVar.cOt.setText(this.cMq);
            fVar.cOs.setVisibility(0);
            fVar.cOM.setVisibility(8);
            fVar.cOl.setVisibility(0);
            fVar.cOi.setVisibility(0);
            fVar.cOv.setText(ax.w(giftNum));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.k(this.cMp) && i < 4; i++) {
                if (i == 0) {
                    fVar.cOw.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cMp, i) != null) {
                        fVar.cOA.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftName(), 5, "..."));
                        q(fVar.cOA, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftNum());
                        fVar.cOy.setBorderWidth(0);
                        fVar.cOy.setBorderColor(this.mActivity.getResources().getColor(n.c.transparent));
                        fVar.cOy.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftIcon(), 10, false);
                        fVar.cOC.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    fVar.cOx.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cMp, i) != null) {
                        fVar.cOB.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftName(), 5, "..."));
                        q(fVar.cOB, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftNum());
                        fVar.cOz.setBorderWidth(0);
                        fVar.cOz.setBorderColor(this.mActivity.getResources().getColor(n.c.transparent));
                        fVar.cOz.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftIcon(), 10, false);
                        fVar.cOD.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    fVar.cOE.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cMp, i) != null) {
                        fVar.cOI.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftName(), 5, "..."));
                        q(fVar.cOI, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftNum());
                        fVar.cOG.setBorderWidth(0);
                        fVar.cOG.setBorderColor(this.mActivity.getResources().getColor(n.c.transparent));
                        fVar.cOG.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftIcon(), 10, false);
                        fVar.cOK.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    fVar.cOF.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cMp, i) != null) {
                        fVar.cOJ.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftName(), 5, "..."));
                        q(fVar.cOJ, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftNum());
                        fVar.cOH.setBorderWidth(0);
                        fVar.cOH.setBorderColor(this.mActivity.getResources().getColor(n.c.transparent));
                        fVar.cOH.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getGiftIcon(), 10, false);
                        fVar.cOL.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cMp, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    public void q(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + bg(i));
        spannableString.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(n.c.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String bg(long j) {
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
        private UserData Vw;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.Vw = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!m.this.anY()) {
                m.this.mActivity.showToast(n.i.gift_load_fail);
            } else if (bj.ah(m.this.mActivity.getActivity())) {
                if (view.getId() == m.this.cMr.getId()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(m.this.mActivity.getPageContext().getPageActivity(), this.Vw.getUserIdLong(), this.Vw.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.Vw != null) {
                    if (m.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == n.f.group_none) {
                            TiebaStatic.log(new av("c10595").r("obj_type", 3));
                        } else {
                            TiebaStatic.log(new av("c10595").r("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == n.f.group_none) {
                            TiebaStatic.log(new av("c10612").r("obj_type", 3).ab("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new av("c10612").r("obj_type", 1).ab("obj_id", this.id));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(m.this.mActivity.getPageContext().getPageActivity(), this.Vw.getUserId(), this.Vw.getUserName(), this.Vw.getSex(), str)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anY() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.f fVar) {
        if (fVar != null && fVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(fVar.cOl, n.e.addresslist_item_bg);
            as.i(fVar.cOM, n.e.addresslist_item_bg);
            as.j(fVar.getView(), n.c.cp_bg_line_d);
            as.j(fVar.cOr, n.c.cp_bg_line_c);
            as.j(fVar.cOi, n.c.cp_bg_line_b);
            as.j(fVar.cOj, n.c.cp_bg_line_b);
            as.b(fVar.cOt, n.c.cp_cont_f, 1);
            as.b(fVar.cOv, n.c.cp_cont_c, 1);
            as.b(fVar.cOA, n.c.cp_cont_f, 1);
            as.b(fVar.cOC, n.c.cp_cont_d, 1);
            as.b(fVar.cOB, n.c.cp_cont_f, 1);
            as.b(fVar.cOD, n.c.cp_cont_d, 1);
            as.b(fVar.cOI, n.c.cp_cont_f, 1);
            as.b(fVar.cOK, n.c.cp_cont_d, 1);
            as.b(fVar.cOJ, n.c.cp_cont_f, 1);
            as.b(fVar.cOL, n.c.cp_cont_d, 1);
            as.b(fVar.cON, n.c.cp_cont_f, 1);
            as.b(fVar.cOO, n.c.cp_cont_d, 1);
            as.c(fVar.cOu, n.e.icon_arrow_tab);
            as.c(fVar.cOP, n.e.icon_mycenter_lock);
            as.b(fVar.cOQ, n.c.cp_cont_i, 1);
            as.c(fVar.cOQ, n.e.btn_all_orange, 1);
        }
    }
}
