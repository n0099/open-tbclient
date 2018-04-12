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
    private TextView cpw;
    private TextView dXn;
    private TextView duK;
    private LinearLayout fEA;
    private LinearLayout fEB;
    private LinearLayout fEC;
    private LinearLayout fED;
    private TextView fEt;
    private TextView fEu;
    private TextView fEv;
    private TextView fEw;
    private TextView fEx;
    private ImageView fEy;
    private LinearLayout fEz;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.duK = (TextView) view2.findViewById(d.g.fans_num);
        this.fEt = (TextView) view2.findViewById(d.g.fans_title);
        this.fEu = (TextView) view2.findViewById(d.g.concer_num);
        this.fEv = (TextView) view2.findViewById(d.g.concer_title);
        this.fEw = (TextView) view2.findViewById(d.g.attention_bar_num);
        this.fEx = (TextView) view2.findViewById(d.g.attention_bar_title);
        this.dXn = (TextView) view2.findViewById(d.g.thread_num);
        this.cpw = (TextView) view2.findViewById(d.g.thread_title);
        this.aze = view2.findViewById(d.g.top_divider_line);
        this.fED = (LinearLayout) view2.findViewById(d.g.attention_container);
        this.fEz = (LinearLayout) view2.findViewById(d.g.fans_action);
        this.fEA = (LinearLayout) view2.findViewById(d.g.concer_action);
        this.fEB = (LinearLayout) view2.findViewById(d.g.attention_action);
        this.fEC = (LinearLayout) view2.findViewById(d.g.thread_action);
        this.fEy = (ImageView) view2.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.duK, d.C0126d.cp_cont_b);
            ak.h(this.fEt, d.C0126d.cp_cont_j);
            ak.h(this.fEu, d.C0126d.cp_cont_b);
            ak.h(this.fEv, d.C0126d.cp_cont_j);
            ak.h(this.fEw, d.C0126d.cp_cont_b);
            ak.h(this.fEx, d.C0126d.cp_cont_j);
            ak.h(this.dXn, d.C0126d.cp_cont_b);
            ak.h(this.cpw, d.C0126d.cp_cont_j);
            ak.j(this.aze, d.C0126d.cp_bg_line_e);
            this.fEy.setImageDrawable(ak.u(i, d.f.person_center_red_tip_shape));
            if (this.fED != null) {
                for (int i2 = 0; i2 < this.fED.getChildCount(); i2++) {
                    View childAt = this.fED.getChildAt(i2);
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
        this.mUserData = bVar.fbV;
        this.duK.setText(Integer.toString(bVar.fDP));
        this.fEu.setText(Integer.toString(bVar.fDQ));
        this.fEw.setText(Integer.toString(bVar.fDR));
        this.dXn.setText(an.F(bVar.threadNum));
        if (bVar.fDS) {
            this.fEy.setVisibility(0);
        } else {
            this.fEy.setVisibility(8);
        }
        this.fEz.setOnClickListener(this);
        this.fEA.setOnClickListener(this);
        this.fEB.setOnClickListener(this);
        this.fEC.setOnClickListener(this);
        d(aeY(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fEy.setVisibility(8);
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
