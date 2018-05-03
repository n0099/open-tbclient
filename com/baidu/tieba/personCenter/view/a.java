package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View aze;
    private TextView cps;
    private TextView dXk;
    private TextView duH;
    private LinearLayout fEA;
    private TextView fEq;
    private TextView fEr;
    private TextView fEs;
    private TextView fEt;
    private TextView fEu;
    private ImageView fEv;
    private LinearLayout fEw;
    private LinearLayout fEx;
    private LinearLayout fEy;
    private LinearLayout fEz;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.duH = (TextView) view2.findViewById(d.g.fans_num);
        this.fEq = (TextView) view2.findViewById(d.g.fans_title);
        this.fEr = (TextView) view2.findViewById(d.g.concer_num);
        this.fEs = (TextView) view2.findViewById(d.g.concer_title);
        this.fEt = (TextView) view2.findViewById(d.g.attention_bar_num);
        this.fEu = (TextView) view2.findViewById(d.g.attention_bar_title);
        this.dXk = (TextView) view2.findViewById(d.g.thread_num);
        this.cps = (TextView) view2.findViewById(d.g.thread_title);
        this.aze = view2.findViewById(d.g.top_divider_line);
        this.fEA = (LinearLayout) view2.findViewById(d.g.attention_container);
        this.fEw = (LinearLayout) view2.findViewById(d.g.fans_action);
        this.fEx = (LinearLayout) view2.findViewById(d.g.concer_action);
        this.fEy = (LinearLayout) view2.findViewById(d.g.attention_action);
        this.fEz = (LinearLayout) view2.findViewById(d.g.thread_action);
        this.fEv = (ImageView) view2.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.duH, d.C0126d.cp_cont_b);
            ak.h(this.fEq, d.C0126d.cp_cont_j);
            ak.h(this.fEr, d.C0126d.cp_cont_b);
            ak.h(this.fEs, d.C0126d.cp_cont_j);
            ak.h(this.fEt, d.C0126d.cp_cont_b);
            ak.h(this.fEu, d.C0126d.cp_cont_j);
            ak.h(this.dXk, d.C0126d.cp_cont_b);
            ak.h(this.cps, d.C0126d.cp_cont_j);
            ak.j(this.aze, d.C0126d.cp_bg_line_e);
            this.fEv.setImageDrawable(ak.u(i, d.f.person_center_red_tip_shape));
            if (this.fEA != null) {
                for (int i2 = 0; i2 < this.fEA.getChildCount(); i2++) {
                    View childAt = this.fEA.getChildAt(i2);
                    if (childAt != null) {
                        ak.i(childAt, d.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.b bVar) {
        this.mUserData = bVar.fbS;
        this.duH.setText(Integer.toString(bVar.fDM));
        this.fEr.setText(Integer.toString(bVar.fDN));
        this.fEt.setText(Integer.toString(bVar.fDO));
        this.dXk.setText(an.F(bVar.threadNum));
        if (bVar.fDP) {
            this.fEv.setVisibility(0);
        } else {
            this.fEv.setVisibility(8);
        }
        this.fEw.setOnClickListener(this);
        this.fEx.setOnClickListener(this);
        this.fEy.setOnClickListener(this);
        this.fEz.setOnClickListener(this);
        d(aeY(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fEv.setVisibility(8);
                    com.baidu.tieba.n.a.bkt().b(2, false, true);
                    TiebaStatic.log(new al("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view2.getId() == d.g.concer_action) {
                TiebaStatic.log(new al("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view2.getId() == d.g.attention_action) {
                TiebaStatic.log(new al("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view2.getId() == d.g.thread_action) {
                TiebaStatic.log(new al("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
