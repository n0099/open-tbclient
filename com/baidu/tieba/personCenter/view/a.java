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
    private View bmB;
    private TextView cTz;
    private TextView dVJ;
    private ImageView egT;
    private TextView eyj;
    private TextView gii;
    private TextView gij;
    private TextView gik;
    private TextView gil;
    private TextView gim;
    private LinearLayout gin;
    private LinearLayout gio;
    private LinearLayout gip;
    private LinearLayout giq;
    private LinearLayout gir;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dVJ = (TextView) view.findViewById(d.g.fans_num);
        this.gii = (TextView) view.findViewById(d.g.fans_title);
        this.gij = (TextView) view.findViewById(d.g.concer_num);
        this.gik = (TextView) view.findViewById(d.g.concer_title);
        this.gil = (TextView) view.findViewById(d.g.attention_bar_num);
        this.gim = (TextView) view.findViewById(d.g.attention_bar_title);
        this.eyj = (TextView) view.findViewById(d.g.thread_num);
        this.cTz = (TextView) view.findViewById(d.g.thread_title);
        this.bmB = view.findViewById(d.g.top_divider_line);
        this.gir = (LinearLayout) view.findViewById(d.g.attention_container);
        this.gin = (LinearLayout) view.findViewById(d.g.fans_action);
        this.gio = (LinearLayout) view.findViewById(d.g.concer_action);
        this.gip = (LinearLayout) view.findViewById(d.g.attention_action);
        this.giq = (LinearLayout) view.findViewById(d.g.thread_action);
        this.egT = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dVJ, d.C0108d.cp_cont_b);
            aj.r(this.gii, d.C0108d.cp_cont_j);
            aj.r(this.gij, d.C0108d.cp_cont_b);
            aj.r(this.gik, d.C0108d.cp_cont_j);
            aj.r(this.gil, d.C0108d.cp_cont_b);
            aj.r(this.gim, d.C0108d.cp_cont_j);
            aj.r(this.eyj, d.C0108d.cp_cont_b);
            aj.r(this.cTz, d.C0108d.cp_cont_j);
            aj.t(this.bmB, d.C0108d.cp_bg_line_e);
            this.egT.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.gir != null) {
                for (int i2 = 0; i2 < this.gir.getChildCount(); i2++) {
                    View childAt = this.gir.getChildAt(i2);
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
        this.mUserData = bVar.fDO;
        this.dVJ.setText(Integer.toString(bVar.ghE));
        this.gij.setText(Integer.toString(bVar.ghF));
        this.gil.setText(Integer.toString(bVar.ghG));
        this.eyj.setText(am.N(bVar.threadNum));
        if (bVar.ghH) {
            this.egT.setVisibility(0);
        } else {
            this.egT.setVisibility(8);
        }
        this.gin.setOnClickListener(this);
        this.gio.setOnClickListener(this);
        this.gip.setOnClickListener(this);
        this.giq.setOnClickListener(this);
        d(akf(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.egT.setVisibility(8);
                    com.baidu.tieba.m.a.bnP().c(2, false, true);
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
