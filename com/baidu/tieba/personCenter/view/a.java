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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.a> {
    private View axX;
    private TextView bZQ;
    private TextView dJb;
    private TextView dde;
    private ImageView drS;
    private TextView fso;
    private TextView fsp;
    private TextView fsq;
    private TextView fsr;
    private TextView fss;
    private LinearLayout fst;
    private LinearLayout fsu;
    private LinearLayout fsv;
    private LinearLayout fsw;
    private LinearLayout fsx;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dde = (TextView) view.findViewById(d.g.fans_num);
        this.fso = (TextView) view.findViewById(d.g.fans_title);
        this.fsp = (TextView) view.findViewById(d.g.concer_num);
        this.fsq = (TextView) view.findViewById(d.g.concer_title);
        this.fsr = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fss = (TextView) view.findViewById(d.g.attention_bar_title);
        this.dJb = (TextView) view.findViewById(d.g.thread_num);
        this.bZQ = (TextView) view.findViewById(d.g.thread_title);
        this.axX = view.findViewById(d.g.top_divider_line);
        this.fsx = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fst = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fsu = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fsv = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fsw = (LinearLayout) view.findViewById(d.g.thread_action);
        this.drS = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dde, d.C0082d.cp_cont_b);
            aj.i(this.fso, d.C0082d.cp_cont_j);
            aj.i(this.fsp, d.C0082d.cp_cont_b);
            aj.i(this.fsq, d.C0082d.cp_cont_j);
            aj.i(this.fsr, d.C0082d.cp_cont_b);
            aj.i(this.fss, d.C0082d.cp_cont_j);
            aj.i(this.dJb, d.C0082d.cp_cont_b);
            aj.i(this.bZQ, d.C0082d.cp_cont_j);
            aj.k(this.axX, d.C0082d.cp_bg_line_e);
            this.drS.setImageDrawable(aj.u(i, d.f.person_center_red_tip_shape));
            if (this.fsx != null) {
                for (int i2 = 0; i2 < this.fsx.getChildCount(); i2++) {
                    View childAt = this.fsx.getChildAt(i2);
                    if (childAt != null) {
                        aj.j(childAt, d.f.person_center_action_item_selector);
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
    public void a(com.baidu.tieba.personCenter.data.a aVar) {
        this.mUserData = aVar.eOp;
        this.dde.setText(Integer.toString(aVar.frI));
        this.fsp.setText(Integer.toString(aVar.frJ));
        this.fsr.setText(Integer.toString(aVar.frK));
        this.dJb.setText(am.F(aVar.threadNum));
        if (aVar.frL) {
            this.drS.setVisibility(0);
        } else {
            this.drS.setVisibility(8);
        }
        this.fst.setOnClickListener(this);
        this.fsu.setOnClickListener(this);
        this.fsv.setOnClickListener(this);
        this.fsw.setOnClickListener(this);
        d(abr(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.drS.setVisibility(8);
                    com.baidu.tieba.m.a.bmh().c(2, false, true);
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
