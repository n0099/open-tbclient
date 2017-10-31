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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.a> {
    private View axo;
    private TextView bRF;
    private TextView cTC;
    private TextView dAR;
    private ImageView dix;
    private TextView fiU;
    private TextView fiV;
    private TextView fiW;
    private TextView fiX;
    private TextView fiY;
    private LinearLayout fiZ;
    private LinearLayout fja;
    private LinearLayout fjb;
    private LinearLayout fjc;
    private LinearLayout fjd;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.cTC = (TextView) view.findViewById(d.g.fans_num);
        this.fiU = (TextView) view.findViewById(d.g.fans_title);
        this.fiV = (TextView) view.findViewById(d.g.concer_num);
        this.fiW = (TextView) view.findViewById(d.g.concer_title);
        this.fiX = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fiY = (TextView) view.findViewById(d.g.attention_bar_title);
        this.dAR = (TextView) view.findViewById(d.g.thread_num);
        this.bRF = (TextView) view.findViewById(d.g.thread_title);
        this.axo = view.findViewById(d.g.top_divider_line);
        this.fjd = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fiZ = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fja = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fjb = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fjc = (LinearLayout) view.findViewById(d.g.thread_action);
        this.dix = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.cTC, d.C0080d.cp_cont_b);
            aj.i(this.fiU, d.C0080d.cp_cont_j);
            aj.i(this.fiV, d.C0080d.cp_cont_b);
            aj.i(this.fiW, d.C0080d.cp_cont_j);
            aj.i(this.fiX, d.C0080d.cp_cont_b);
            aj.i(this.fiY, d.C0080d.cp_cont_j);
            aj.i(this.dAR, d.C0080d.cp_cont_b);
            aj.i(this.bRF, d.C0080d.cp_cont_j);
            aj.k(this.axo, d.C0080d.cp_bg_line_e);
            this.dix.setImageDrawable(aj.u(i, d.f.person_center_red_tip_shape));
            if (this.fjd != null) {
                for (int i2 = 0; i2 < this.fjd.getChildCount(); i2++) {
                    View childAt = this.fjd.getChildAt(i2);
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
        this.mUserData = aVar.eGm;
        this.cTC.setText(Integer.toString(aVar.fio));
        this.fiV.setText(Integer.toString(aVar.fip));
        this.fiX.setText(Integer.toString(aVar.fiq));
        this.dAR.setText(am.F(aVar.threadNum));
        if (aVar.fir) {
            this.dix.setVisibility(0);
        } else {
            this.dix.setVisibility(8);
        }
        this.fiZ.setOnClickListener(this);
        this.fja.setOnClickListener(this);
        this.fjb.setOnClickListener(this);
        this.fjc.setOnClickListener(this);
        d(Zw(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.dix.setVisibility(8);
                    com.baidu.tieba.j.a.bjW().c(2, false, true);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false, true)));
            }
        }
    }
}
