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
    private View axd;
    private TextView bKl;
    private TextView cKD;
    private ImageView daV;
    private TextView dtq;
    private TextView faS;
    private TextView faT;
    private TextView faU;
    private TextView faV;
    private TextView faW;
    private LinearLayout faX;
    private LinearLayout faY;
    private LinearLayout faZ;
    private LinearLayout fba;
    private LinearLayout fbb;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.cKD = (TextView) view.findViewById(d.h.fans_num);
        this.faS = (TextView) view.findViewById(d.h.fans_title);
        this.faT = (TextView) view.findViewById(d.h.concer_num);
        this.faU = (TextView) view.findViewById(d.h.concer_title);
        this.faV = (TextView) view.findViewById(d.h.attention_bar_num);
        this.faW = (TextView) view.findViewById(d.h.attention_bar_title);
        this.dtq = (TextView) view.findViewById(d.h.thread_num);
        this.bKl = (TextView) view.findViewById(d.h.thread_title);
        this.axd = view.findViewById(d.h.top_divider_line);
        this.fbb = (LinearLayout) view.findViewById(d.h.attention_container);
        this.faX = (LinearLayout) view.findViewById(d.h.fans_action);
        this.faY = (LinearLayout) view.findViewById(d.h.concer_action);
        this.faZ = (LinearLayout) view.findViewById(d.h.attention_action);
        this.fba = (LinearLayout) view.findViewById(d.h.thread_action);
        this.daV = (ImageView) view.findViewById(d.h.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.cKD, d.e.cp_cont_b);
            aj.i(this.faS, d.e.cp_cont_j);
            aj.i(this.faT, d.e.cp_cont_b);
            aj.i(this.faU, d.e.cp_cont_j);
            aj.i(this.faV, d.e.cp_cont_b);
            aj.i(this.faW, d.e.cp_cont_j);
            aj.i(this.dtq, d.e.cp_cont_b);
            aj.i(this.bKl, d.e.cp_cont_j);
            aj.k(this.axd, d.e.cp_bg_line_e);
            this.daV.setImageDrawable(aj.u(i, d.g.person_center_red_tip_shape));
            if (this.fbb != null) {
                for (int i2 = 0; i2 < this.fbb.getChildCount(); i2++) {
                    View childAt = this.fbb.getChildAt(i2);
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
        this.mUserData = aVar.eyy;
        this.cKD.setText(Integer.toString(aVar.fan));
        this.faT.setText(Integer.toString(aVar.fao));
        this.faV.setText(Integer.toString(aVar.fap));
        this.dtq.setText(am.E(aVar.threadNum));
        if (aVar.faq) {
            this.daV.setVisibility(0);
        } else {
            this.daV.setVisibility(8);
        }
        this.faX.setOnClickListener(this);
        this.faY.setOnClickListener(this);
        this.faZ.setOnClickListener(this);
        this.fba.setOnClickListener(this);
        d(Xq(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.h.fans_action) {
                if (this.mUserData != null) {
                    this.daV.setVisibility(8);
                    com.baidu.tieba.j.a.bgP().b(2, false, true);
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

    public View aVt() {
        return this.faU;
    }
}
