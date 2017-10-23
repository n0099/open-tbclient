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
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.c.a> {
    private View awR;
    private TextView bJZ;
    private TextView cKr;
    private ImageView daI;
    private TextView dtc;
    private TextView faD;
    private TextView faE;
    private TextView faF;
    private TextView faG;
    private TextView faH;
    private LinearLayout faI;
    private LinearLayout faJ;
    private LinearLayout faK;
    private LinearLayout faL;
    private LinearLayout faM;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.cKr = (TextView) view.findViewById(d.h.fans_num);
        this.faD = (TextView) view.findViewById(d.h.fans_title);
        this.faE = (TextView) view.findViewById(d.h.concer_num);
        this.faF = (TextView) view.findViewById(d.h.concer_title);
        this.faG = (TextView) view.findViewById(d.h.attention_bar_num);
        this.faH = (TextView) view.findViewById(d.h.attention_bar_title);
        this.dtc = (TextView) view.findViewById(d.h.thread_num);
        this.bJZ = (TextView) view.findViewById(d.h.thread_title);
        this.awR = view.findViewById(d.h.top_divider_line);
        this.faM = (LinearLayout) view.findViewById(d.h.attention_container);
        this.faI = (LinearLayout) view.findViewById(d.h.fans_action);
        this.faJ = (LinearLayout) view.findViewById(d.h.concer_action);
        this.faK = (LinearLayout) view.findViewById(d.h.attention_action);
        this.faL = (LinearLayout) view.findViewById(d.h.thread_action);
        this.daI = (ImageView) view.findViewById(d.h.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.cKr, d.e.cp_cont_b);
            aj.i(this.faD, d.e.cp_cont_j);
            aj.i(this.faE, d.e.cp_cont_b);
            aj.i(this.faF, d.e.cp_cont_j);
            aj.i(this.faG, d.e.cp_cont_b);
            aj.i(this.faH, d.e.cp_cont_j);
            aj.i(this.dtc, d.e.cp_cont_b);
            aj.i(this.bJZ, d.e.cp_cont_j);
            aj.k(this.awR, d.e.cp_bg_line_e);
            this.daI.setImageDrawable(aj.u(i, d.g.person_center_red_tip_shape));
            if (this.faM != null) {
                for (int i2 = 0; i2 < this.faM.getChildCount(); i2++) {
                    View childAt = this.faM.getChildAt(i2);
                    if (childAt != null) {
                        aj.j(childAt, d.g.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.c.a aVar) {
        this.mUserData = aVar.eyj;
        this.cKr.setText(Integer.toString(aVar.eZY));
        this.faE.setText(Integer.toString(aVar.eZZ));
        this.faG.setText(Integer.toString(aVar.faa));
        this.dtc.setText(am.F(aVar.threadNum));
        if (aVar.fab) {
            this.daI.setVisibility(0);
        } else {
            this.daI.setVisibility(8);
        }
        this.faI.setOnClickListener(this);
        this.faJ.setOnClickListener(this);
        this.faK.setOnClickListener(this);
        this.faL.setOnClickListener(this);
        d(Xm(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.h.fans_action) {
                if (this.mUserData != null) {
                    this.daI.setVisibility(8);
                    com.baidu.tieba.j.a.bgJ().b(2, false, true);
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.h.concer_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.h.attention_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.h.thread_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false, true)));
            }
        }
    }
}
