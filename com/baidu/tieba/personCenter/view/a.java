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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View bmk;
    private TextView cOD;
    private TextView dQA;
    private ImageView efh;
    private TextView ewp;
    private TextView ggk;
    private TextView ggl;
    private TextView ggm;
    private TextView ggn;
    private TextView ggo;
    private LinearLayout ggp;
    private LinearLayout ggq;
    private LinearLayout ggr;
    private LinearLayout ggs;
    private LinearLayout ggt;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dQA = (TextView) view.findViewById(d.g.fans_num);
        this.ggk = (TextView) view.findViewById(d.g.fans_title);
        this.ggl = (TextView) view.findViewById(d.g.concer_num);
        this.ggm = (TextView) view.findViewById(d.g.concer_title);
        this.ggn = (TextView) view.findViewById(d.g.attention_bar_num);
        this.ggo = (TextView) view.findViewById(d.g.attention_bar_title);
        this.ewp = (TextView) view.findViewById(d.g.thread_num);
        this.cOD = (TextView) view.findViewById(d.g.thread_title);
        this.bmk = view.findViewById(d.g.top_divider_line);
        this.ggt = (LinearLayout) view.findViewById(d.g.attention_container);
        this.ggp = (LinearLayout) view.findViewById(d.g.fans_action);
        this.ggq = (LinearLayout) view.findViewById(d.g.concer_action);
        this.ggr = (LinearLayout) view.findViewById(d.g.attention_action);
        this.ggs = (LinearLayout) view.findViewById(d.g.thread_action);
        this.efh = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dQA, d.C0108d.cp_cont_b);
            aj.r(this.ggk, d.C0108d.cp_cont_j);
            aj.r(this.ggl, d.C0108d.cp_cont_b);
            aj.r(this.ggm, d.C0108d.cp_cont_j);
            aj.r(this.ggn, d.C0108d.cp_cont_b);
            aj.r(this.ggo, d.C0108d.cp_cont_j);
            aj.r(this.ewp, d.C0108d.cp_cont_b);
            aj.r(this.cOD, d.C0108d.cp_cont_j);
            aj.t(this.bmk, d.C0108d.cp_bg_line_e);
            this.efh.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.ggt != null) {
                for (int i2 = 0; i2 < this.ggt.getChildCount(); i2++) {
                    View childAt = this.ggt.getChildAt(i2);
                    if (childAt != null) {
                        aj.s(childAt, d.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.b bVar) {
        this.mUserData = bVar.fBT;
        this.dQA.setText(Integer.toString(bVar.gfH));
        this.ggl.setText(Integer.toString(bVar.gfI));
        this.ggn.setText(Integer.toString(bVar.gfJ));
        this.ewp.setText(am.N(bVar.threadNum));
        if (bVar.gfK) {
            this.efh.setVisibility(0);
        } else {
            this.efh.setVisibility(8);
        }
        this.ggp.setOnClickListener(this);
        this.ggq.setOnClickListener(this);
        this.ggr.setOnClickListener(this);
        this.ggs.setOnClickListener(this);
        d(aiX(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.efh.setVisibility(8);
                    com.baidu.tieba.m.a.buv().c(2, false, true);
                    TiebaStatic.log(new ak("c12523").s("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
