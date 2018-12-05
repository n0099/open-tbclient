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
    private TextView cVy;
    private TextView eOA;
    private TextView eis;
    private TextView gsi;
    private TextView gsj;
    private TextView gsk;
    private TextView gsl;
    private TextView gsm;
    private ImageView gsn;
    private LinearLayout gso;
    private LinearLayout gsp;
    private LinearLayout gsq;
    private LinearLayout gsr;
    private LinearLayout gss;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.eis = (TextView) view.findViewById(e.g.fans_num);
        this.gsi = (TextView) view.findViewById(e.g.fans_title);
        this.gsj = (TextView) view.findViewById(e.g.concer_num);
        this.gsk = (TextView) view.findViewById(e.g.concer_title);
        this.gsl = (TextView) view.findViewById(e.g.attention_bar_num);
        this.gsm = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eOA = (TextView) view.findViewById(e.g.thread_num);
        this.cVy = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.gss = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gso = (LinearLayout) view.findViewById(e.g.fans_action);
        this.gsp = (LinearLayout) view.findViewById(e.g.concer_action);
        this.gsq = (LinearLayout) view.findViewById(e.g.attention_action);
        this.gsr = (LinearLayout) view.findViewById(e.g.thread_action);
        this.gsn = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eis, e.d.cp_cont_b);
            al.h(this.gsi, e.d.cp_cont_j);
            al.h(this.gsj, e.d.cp_cont_b);
            al.h(this.gsk, e.d.cp_cont_j);
            al.h(this.gsl, e.d.cp_cont_b);
            al.h(this.gsm, e.d.cp_cont_j);
            al.h(this.eOA, e.d.cp_cont_b);
            al.h(this.cVy, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.gsn.setImageDrawable(al.y(i, e.f.person_center_red_tip_shape));
            if (this.gss != null) {
                for (int i2 = 0; i2 < this.gss.getChildCount(); i2++) {
                    View childAt = this.gss.getChildAt(i2);
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
        this.mUserData = cVar.fPU;
        this.eis.setText(Integer.toString(cVar.grB));
        this.gsj.setText(Integer.toString(cVar.grC));
        this.gsl.setText(Integer.toString(cVar.grD));
        this.eOA.setText(ao.aa(cVar.threadNum));
        if (cVar.grE) {
            this.gsn.setVisibility(0);
        } else {
            this.gsn.setVisibility(8);
        }
        this.gso.setOnClickListener(this);
        this.gsp.setOnClickListener(this);
        this.gsq.setOnClickListener(this);
        this.gsr.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.gsn.setVisibility(8);
                    com.baidu.tieba.o.a.bvJ().c(2, false, true);
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
