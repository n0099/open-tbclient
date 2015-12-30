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
public class q extends c<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.h> {
    private List<MyGift> cQJ;
    private String cQK;
    private TextView cQL;
    private boolean isSelf;
    private BaseFragmentActivity mActivity;
    private View.OnClickListener mClickListener;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public com.baidu.tieba.person.b.h a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.h(LayoutInflater.from(this.mContext).inflate(n.h.person_info_gift_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.h hVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(hVar);
        if (iVar != null && this.aVr) {
            a(hVar, iVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.i iVar) {
        if (iVar != null && iVar.getUserData() != null && hVar != null) {
            this.mClickListener = new a(iVar.getUserId(), iVar.getUserData());
            this.isSelf = iVar.getIsSelf();
            this.cQL = hVar.cTA;
            if (this.isSelf) {
                hVar.cTA.setVisibility(8);
            } else {
                hVar.cTA.setVisibility(0);
            }
            b(hVar, iVar);
            hVar.cSU.setOnClickListener(this.mClickListener);
            hVar.cTc.setOnClickListener(this.mClickListener);
            hVar.cTf.setOnClickListener(this.mClickListener);
            hVar.cTA.setOnClickListener(this.mClickListener);
        }
    }

    private void b(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.i iVar) {
        if (iVar != null && hVar != null) {
            this.cQJ = iVar.apr();
            this.isSelf = iVar.getIsSelf();
            this.cQK = this.mContext.getResources().getString(n.j.gift_received_by_me);
            this.mContext.getResources().getString(n.j.gifts_got_in_total);
            if (!this.isSelf && iVar.getSex() == 2) {
                this.cQK = this.mContext.getResources().getString(n.j.gift_received_by_her);
            } else if (!this.isSelf && (iVar.getSex() == 1 || iVar.getSex() == 0)) {
                this.cQK = this.mContext.getResources().getString(n.j.gift_received_by_him);
            }
            if (com.baidu.tbadk.core.util.y.l(this.cQJ) == 0) {
                hVar.cTc.setVisibility(8);
                hVar.cSU.setVisibility(8);
                hVar.cTw.setVisibility(0);
                hVar.cTx.setText(this.cQK);
                hVar.cSU.setPadding(0, 0, 0, 0);
                hVar.cTw.setOnClickListener(this.mClickListener);
                return;
            }
            int giftNum = this.cQJ != null ? iVar.getGiftNum() : 0;
            hVar.cTd.setText(this.cQK);
            hVar.cTc.setVisibility(0);
            hVar.cTw.setVisibility(8);
            hVar.cSU.setVisibility(0);
            hVar.cSR.setVisibility(0);
            hVar.cTf.setText(ax.x(giftNum));
            for (int i = 0; i < com.baidu.tbadk.core.util.y.l(this.cQJ) && i < 4; i++) {
                if (i == 0) {
                    hVar.cTg.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cQJ, i) != null) {
                        hVar.cTk.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftName(), 5, "..."));
                        r(hVar.cTk, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftNum());
                        hVar.cTi.setBorderWidth(0);
                        hVar.cTi.setBorderColor(this.mActivity.getResources().getColor(n.d.transparent));
                        hVar.cTi.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftIcon(), 10, false);
                        hVar.cTm.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getSender(), 7, "..."));
                    }
                } else if (i == 1) {
                    hVar.cTh.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cQJ, i) != null) {
                        hVar.cTl.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftName(), 5, "..."));
                        r(hVar.cTl, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftNum());
                        hVar.cTj.setBorderWidth(0);
                        hVar.cTj.setBorderColor(this.mActivity.getResources().getColor(n.d.transparent));
                        hVar.cTj.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftIcon(), 10, false);
                        hVar.cTn.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getSender(), 7, "..."));
                    }
                } else if (i == 2) {
                    hVar.cTo.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cQJ, i) != null) {
                        hVar.cTs.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftName(), 5, "..."));
                        r(hVar.cTs, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftNum());
                        hVar.cTq.setBorderWidth(0);
                        hVar.cTq.setBorderColor(this.mActivity.getResources().getColor(n.d.transparent));
                        hVar.cTq.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftIcon(), 10, false);
                        hVar.cTu.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getSender(), 7, "..."));
                    }
                } else if (i == 3) {
                    hVar.cTp.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cQJ, i) != null) {
                        hVar.cTt.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftName(), 5, "..."));
                        r(hVar.cTt, ((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftNum());
                        hVar.cTr.setBorderWidth(0);
                        hVar.cTr.setBorderColor(this.mActivity.getResources().getColor(n.d.transparent));
                        hVar.cTr.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getGiftIcon(), 10, false);
                        hVar.cTv.setText(ax.d(((MyGift) com.baidu.tbadk.core.util.y.b(this.cQJ, i)).getSender(), 7, "..."));
                    }
                }
            }
        }
    }

    public void r(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(" X" + bm(i));
        spannableString.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(n.d.cp_link_tip_d)), 0, spannableString.length(), 33);
        textView.append(spannableString);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 long)] */
    public static String bm(long j) {
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
        private UserData VW;
        private String id;

        public a(String str, UserData userData) {
            this.id = str;
            this.VW = userData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.id == null) {
                return;
            }
            if (!q.this.apj()) {
                q.this.mActivity.showToast(n.j.gift_load_fail);
            } else if (bj.ah(q.this.mActivity.getActivity())) {
                if (view.getId() == q.this.cQL.getId()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(q.this.mActivity.getPageContext().getPageActivity(), this.VW.getUserIdLong(), this.VW.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (this.VW != null) {
                    if (q.this.isSelf) {
                        str = "iowner_gift";
                        if (view.getId() == n.g.group_none) {
                            TiebaStatic.log(new av("c10595").r("obj_type", 3));
                        } else {
                            TiebaStatic.log(new av("c10595").r("obj_type", 1));
                        }
                    } else {
                        str = "iguest_gift";
                        if (view.getId() == n.g.group_none) {
                            TiebaStatic.log(new av("c10612").r("obj_type", 3).aa("obj_id", this.id));
                        } else {
                            TiebaStatic.log(new av("c10612").r("obj_type", 1).aa("obj_id", this.id));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(q.this.mActivity.getPageContext().getPageActivity(), this.VW.getUserId(), this.VW.getUserName(), this.VW.getSex(), str)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apj() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private void a(com.baidu.tieba.person.b.h hVar) {
        if (hVar != null && hVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(hVar.cSU, n.f.addresslist_item_bg);
            as.i(hVar.cTw, n.f.addresslist_item_bg);
            as.j(hVar.getView(), n.d.cp_bg_line_d);
            as.j(hVar.cTb, n.d.cp_bg_line_c);
            as.j(hVar.cSR, n.d.cp_bg_line_b);
            as.j(hVar.cSS, n.d.cp_bg_line_b);
            as.b(hVar.cTd, n.d.cp_cont_f, 1);
            as.b(hVar.cTf, n.d.cp_cont_c, 1);
            as.b(hVar.cTk, n.d.cp_cont_f, 1);
            as.b(hVar.cTm, n.d.cp_cont_d, 1);
            as.b(hVar.cTl, n.d.cp_cont_f, 1);
            as.b(hVar.cTn, n.d.cp_cont_d, 1);
            as.b(hVar.cTs, n.d.cp_cont_f, 1);
            as.b(hVar.cTu, n.d.cp_cont_d, 1);
            as.b(hVar.cTt, n.d.cp_cont_f, 1);
            as.b(hVar.cTv, n.d.cp_cont_d, 1);
            as.b(hVar.cTx, n.d.cp_cont_f, 1);
            as.b(hVar.cTy, n.d.cp_cont_d, 1);
            as.c(hVar.cTe, n.f.icon_arrow_tab);
            as.c(hVar.cTz, n.f.icon_mycenter_lock);
            as.b(hVar.cTA, n.d.cp_cont_i, 1);
            as.c(hVar.cTA, n.f.btn_all_orange, 1);
        }
    }
}
