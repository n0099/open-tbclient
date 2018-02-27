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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View boC;
    private TextView cXg;
    private TextView dZK;
    private TextView eCt;
    private TextView gjG;
    private TextView gjH;
    private TextView gjI;
    private TextView gjJ;
    private TextView gjK;
    private ImageView gjL;
    private LinearLayout gjM;
    private LinearLayout gjN;
    private LinearLayout gjO;
    private LinearLayout gjP;
    private LinearLayout gjQ;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dZK = (TextView) view.findViewById(d.g.fans_num);
        this.gjG = (TextView) view.findViewById(d.g.fans_title);
        this.gjH = (TextView) view.findViewById(d.g.concer_num);
        this.gjI = (TextView) view.findViewById(d.g.concer_title);
        this.gjJ = (TextView) view.findViewById(d.g.attention_bar_num);
        this.gjK = (TextView) view.findViewById(d.g.attention_bar_title);
        this.eCt = (TextView) view.findViewById(d.g.thread_num);
        this.cXg = (TextView) view.findViewById(d.g.thread_title);
        this.boC = view.findViewById(d.g.top_divider_line);
        this.gjQ = (LinearLayout) view.findViewById(d.g.attention_container);
        this.gjM = (LinearLayout) view.findViewById(d.g.fans_action);
        this.gjN = (LinearLayout) view.findViewById(d.g.concer_action);
        this.gjO = (LinearLayout) view.findViewById(d.g.attention_action);
        this.gjP = (LinearLayout) view.findViewById(d.g.thread_action);
        this.gjL = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dZK, d.C0141d.cp_cont_b);
            aj.r(this.gjG, d.C0141d.cp_cont_j);
            aj.r(this.gjH, d.C0141d.cp_cont_b);
            aj.r(this.gjI, d.C0141d.cp_cont_j);
            aj.r(this.gjJ, d.C0141d.cp_cont_b);
            aj.r(this.gjK, d.C0141d.cp_cont_j);
            aj.r(this.eCt, d.C0141d.cp_cont_b);
            aj.r(this.cXg, d.C0141d.cp_cont_j);
            aj.t(this.boC, d.C0141d.cp_bg_line_e);
            this.gjL.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.gjQ != null) {
                for (int i2 = 0; i2 < this.gjQ.getChildCount(); i2++) {
                    View childAt = this.gjQ.getChildAt(i2);
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
        this.mUserData = bVar.fHa;
        this.dZK.setText(Integer.toString(bVar.gjd));
        this.gjH.setText(Integer.toString(bVar.gje));
        this.gjJ.setText(Integer.toString(bVar.gjf));
        this.eCt.setText(am.N(bVar.threadNum));
        if (bVar.gjg) {
            this.gjL.setVisibility(0);
        } else {
            this.gjL.setVisibility(8);
        }
        this.gjM.setOnClickListener(this);
        this.gjN.setOnClickListener(this);
        this.gjO.setOnClickListener(this);
        this.gjP.setOnClickListener(this);
        d(akN(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.gjL.setVisibility(8);
                    com.baidu.tieba.m.a.bpl().c(2, false, true);
                    TiebaStatic.log(new ak("c12523").s("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
