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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView cNL;
    private TextView eGr;
    private TextView eau;
    private TextView gjS;
    private TextView gjT;
    private TextView gjU;
    private TextView gjV;
    private TextView gjW;
    private ImageView gjX;
    private LinearLayout gjY;
    private LinearLayout gjZ;
    private LinearLayout gka;
    private LinearLayout gkb;
    private LinearLayout gkc;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.eau = (TextView) view.findViewById(e.g.fans_num);
        this.gjS = (TextView) view.findViewById(e.g.fans_title);
        this.gjT = (TextView) view.findViewById(e.g.concer_num);
        this.gjU = (TextView) view.findViewById(e.g.concer_title);
        this.gjV = (TextView) view.findViewById(e.g.attention_bar_num);
        this.gjW = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eGr = (TextView) view.findViewById(e.g.thread_num);
        this.cNL = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.gkc = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gjY = (LinearLayout) view.findViewById(e.g.fans_action);
        this.gjZ = (LinearLayout) view.findViewById(e.g.concer_action);
        this.gka = (LinearLayout) view.findViewById(e.g.attention_action);
        this.gkb = (LinearLayout) view.findViewById(e.g.thread_action);
        this.gjX = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eau, e.d.cp_cont_b);
            al.h(this.gjS, e.d.cp_cont_j);
            al.h(this.gjT, e.d.cp_cont_b);
            al.h(this.gjU, e.d.cp_cont_j);
            al.h(this.gjV, e.d.cp_cont_b);
            al.h(this.gjW, e.d.cp_cont_j);
            al.h(this.eGr, e.d.cp_cont_b);
            al.h(this.cNL, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.gjX.setImageDrawable(al.x(i, e.f.person_center_red_tip_shape));
            if (this.gkc != null) {
                for (int i2 = 0; i2 < this.gkc.getChildCount(); i2++) {
                    View childAt = this.gkc.getChildAt(i2);
                    if (childAt != null) {
                        al.i(childAt, e.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.c cVar) {
        this.mUserData = cVar.fHF;
        this.eau.setText(Integer.toString(cVar.gjl));
        this.gjT.setText(Integer.toString(cVar.gjm));
        this.gjV.setText(Integer.toString(cVar.gjn));
        this.eGr.setText(ao.R(cVar.threadNum));
        if (cVar.gjo) {
            this.gjX.setVisibility(0);
        } else {
            this.gjX.setVisibility(8);
        }
        this.gjY.setOnClickListener(this);
        this.gjZ.setOnClickListener(this);
        this.gka.setOnClickListener(this);
        this.gkb.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.gjX.setVisibility(8);
                    com.baidu.tieba.o.a.buu().c(2, false, true);
                    TiebaStatic.log(new am("c12523").x("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == e.g.concer_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.attention_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.thread_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
