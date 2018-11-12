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
    private TextView cOR;
    private TextView eHL;
    private TextView ebP;
    private LinearLayout glA;
    private LinearLayout glB;
    private LinearLayout glC;
    private TextView gls;
    private TextView glt;
    private TextView glu;
    private TextView glv;
    private TextView glw;
    private ImageView glx;
    private LinearLayout gly;
    private LinearLayout glz;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ebP = (TextView) view.findViewById(e.g.fans_num);
        this.gls = (TextView) view.findViewById(e.g.fans_title);
        this.glt = (TextView) view.findViewById(e.g.concer_num);
        this.glu = (TextView) view.findViewById(e.g.concer_title);
        this.glv = (TextView) view.findViewById(e.g.attention_bar_num);
        this.glw = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eHL = (TextView) view.findViewById(e.g.thread_num);
        this.cOR = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.glC = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gly = (LinearLayout) view.findViewById(e.g.fans_action);
        this.glz = (LinearLayout) view.findViewById(e.g.concer_action);
        this.glA = (LinearLayout) view.findViewById(e.g.attention_action);
        this.glB = (LinearLayout) view.findViewById(e.g.thread_action);
        this.glx = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.ebP, e.d.cp_cont_b);
            al.h(this.gls, e.d.cp_cont_j);
            al.h(this.glt, e.d.cp_cont_b);
            al.h(this.glu, e.d.cp_cont_j);
            al.h(this.glv, e.d.cp_cont_b);
            al.h(this.glw, e.d.cp_cont_j);
            al.h(this.eHL, e.d.cp_cont_b);
            al.h(this.cOR, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.glx.setImageDrawable(al.x(i, e.f.person_center_red_tip_shape));
            if (this.glC != null) {
                for (int i2 = 0; i2 < this.glC.getChildCount(); i2++) {
                    View childAt = this.glC.getChildAt(i2);
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
        this.mUserData = cVar.fJe;
        this.ebP.setText(Integer.toString(cVar.gkL));
        this.glt.setText(Integer.toString(cVar.gkM));
        this.glv.setText(Integer.toString(cVar.gkN));
        this.eHL.setText(ao.T(cVar.threadNum));
        if (cVar.gkO) {
            this.glx.setVisibility(0);
        } else {
            this.glx.setVisibility(8);
        }
        this.gly.setOnClickListener(this);
        this.glz.setOnClickListener(this);
        this.glA.setOnClickListener(this);
        this.glB.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.glx.setVisibility(8);
                    com.baidu.tieba.o.a.btQ().c(2, false, true);
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
