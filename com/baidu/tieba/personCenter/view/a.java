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
    private View azf;
    private TextView cqC;
    private TextView dYr;
    private TextView dvP;
    private TextView fFA;
    private ImageView fFB;
    private LinearLayout fFC;
    private LinearLayout fFD;
    private LinearLayout fFE;
    private LinearLayout fFF;
    private LinearLayout fFG;
    private TextView fFw;
    private TextView fFx;
    private TextView fFy;
    private TextView fFz;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.dvP = (TextView) view2.findViewById(d.g.fans_num);
        this.fFw = (TextView) view2.findViewById(d.g.fans_title);
        this.fFx = (TextView) view2.findViewById(d.g.concer_num);
        this.fFy = (TextView) view2.findViewById(d.g.concer_title);
        this.fFz = (TextView) view2.findViewById(d.g.attention_bar_num);
        this.fFA = (TextView) view2.findViewById(d.g.attention_bar_title);
        this.dYr = (TextView) view2.findViewById(d.g.thread_num);
        this.cqC = (TextView) view2.findViewById(d.g.thread_title);
        this.azf = view2.findViewById(d.g.top_divider_line);
        this.fFG = (LinearLayout) view2.findViewById(d.g.attention_container);
        this.fFC = (LinearLayout) view2.findViewById(d.g.fans_action);
        this.fFD = (LinearLayout) view2.findViewById(d.g.concer_action);
        this.fFE = (LinearLayout) view2.findViewById(d.g.attention_action);
        this.fFF = (LinearLayout) view2.findViewById(d.g.thread_action);
        this.fFB = (ImageView) view2.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.dvP, d.C0126d.cp_cont_b);
            ak.h(this.fFw, d.C0126d.cp_cont_j);
            ak.h(this.fFx, d.C0126d.cp_cont_b);
            ak.h(this.fFy, d.C0126d.cp_cont_j);
            ak.h(this.fFz, d.C0126d.cp_cont_b);
            ak.h(this.fFA, d.C0126d.cp_cont_j);
            ak.h(this.dYr, d.C0126d.cp_cont_b);
            ak.h(this.cqC, d.C0126d.cp_cont_j);
            ak.j(this.azf, d.C0126d.cp_bg_line_e);
            this.fFB.setImageDrawable(ak.u(i, d.f.person_center_red_tip_shape));
            if (this.fFG != null) {
                for (int i2 = 0; i2 < this.fFG.getChildCount(); i2++) {
                    View childAt = this.fFG.getChildAt(i2);
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
        this.mUserData = bVar.fcZ;
        this.dvP.setText(Integer.toString(bVar.fES));
        this.fFx.setText(Integer.toString(bVar.fET));
        this.fFz.setText(Integer.toString(bVar.fEU));
        this.dYr.setText(an.F(bVar.threadNum));
        if (bVar.fEV) {
            this.fFB.setVisibility(0);
        } else {
            this.fFB.setVisibility(8);
        }
        this.fFC.setOnClickListener(this);
        this.fFD.setOnClickListener(this);
        this.fFE.setOnClickListener(this);
        this.fFF.setOnClickListener(this);
        d(aeY(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fFB.setVisibility(8);
                    com.baidu.tieba.n.a.bks().b(2, false, true);
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
