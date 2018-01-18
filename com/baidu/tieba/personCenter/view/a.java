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
    private View bmt;
    private TextView cTe;
    private TextView dVo;
    private ImageView egy;
    private TextView exO;
    private TextView ghM;
    private TextView ghN;
    private TextView ghO;
    private TextView ghP;
    private TextView ghQ;
    private LinearLayout ghR;
    private LinearLayout ghS;
    private LinearLayout ghT;
    private LinearLayout ghU;
    private LinearLayout ghV;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dVo = (TextView) view.findViewById(d.g.fans_num);
        this.ghM = (TextView) view.findViewById(d.g.fans_title);
        this.ghN = (TextView) view.findViewById(d.g.concer_num);
        this.ghO = (TextView) view.findViewById(d.g.concer_title);
        this.ghP = (TextView) view.findViewById(d.g.attention_bar_num);
        this.ghQ = (TextView) view.findViewById(d.g.attention_bar_title);
        this.exO = (TextView) view.findViewById(d.g.thread_num);
        this.cTe = (TextView) view.findViewById(d.g.thread_title);
        this.bmt = view.findViewById(d.g.top_divider_line);
        this.ghV = (LinearLayout) view.findViewById(d.g.attention_container);
        this.ghR = (LinearLayout) view.findViewById(d.g.fans_action);
        this.ghS = (LinearLayout) view.findViewById(d.g.concer_action);
        this.ghT = (LinearLayout) view.findViewById(d.g.attention_action);
        this.ghU = (LinearLayout) view.findViewById(d.g.thread_action);
        this.egy = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dVo, d.C0107d.cp_cont_b);
            aj.r(this.ghM, d.C0107d.cp_cont_j);
            aj.r(this.ghN, d.C0107d.cp_cont_b);
            aj.r(this.ghO, d.C0107d.cp_cont_j);
            aj.r(this.ghP, d.C0107d.cp_cont_b);
            aj.r(this.ghQ, d.C0107d.cp_cont_j);
            aj.r(this.exO, d.C0107d.cp_cont_b);
            aj.r(this.cTe, d.C0107d.cp_cont_j);
            aj.t(this.bmt, d.C0107d.cp_bg_line_e);
            this.egy.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.ghV != null) {
                for (int i2 = 0; i2 < this.ghV.getChildCount(); i2++) {
                    View childAt = this.ghV.getChildAt(i2);
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
        this.mUserData = bVar.fDt;
        this.dVo.setText(Integer.toString(bVar.ghj));
        this.ghN.setText(Integer.toString(bVar.ghk));
        this.ghP.setText(Integer.toString(bVar.ghl));
        this.exO.setText(am.N(bVar.threadNum));
        if (bVar.ghm) {
            this.egy.setVisibility(0);
        } else {
            this.egy.setVisibility(8);
        }
        this.ghR.setOnClickListener(this);
        this.ghS.setOnClickListener(this);
        this.ghT.setOnClickListener(this);
        this.ghU.setOnClickListener(this);
        d(aka(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.egy.setVisibility(8);
                    com.baidu.tieba.m.a.bnO().c(2, false, true);
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
