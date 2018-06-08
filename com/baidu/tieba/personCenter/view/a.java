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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View aHA;
    private TextView czf;
    private TextView dFc;
    private TextView ejE;
    private TextView fQP;
    private TextView fQQ;
    private TextView fQR;
    private TextView fQS;
    private TextView fQT;
    private ImageView fQU;
    private LinearLayout fQV;
    private LinearLayout fQW;
    private LinearLayout fQX;
    private LinearLayout fQY;
    private LinearLayout fQZ;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dFc = (TextView) view.findViewById(d.g.fans_num);
        this.fQP = (TextView) view.findViewById(d.g.fans_title);
        this.fQQ = (TextView) view.findViewById(d.g.concer_num);
        this.fQR = (TextView) view.findViewById(d.g.concer_title);
        this.fQS = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fQT = (TextView) view.findViewById(d.g.attention_bar_title);
        this.ejE = (TextView) view.findViewById(d.g.thread_num);
        this.czf = (TextView) view.findViewById(d.g.thread_title);
        this.aHA = view.findViewById(d.g.top_divider_line);
        this.fQZ = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fQV = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fQW = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fQX = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fQY = (LinearLayout) view.findViewById(d.g.thread_action);
        this.fQU = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.dFc, d.C0141d.cp_cont_b);
            al.h(this.fQP, d.C0141d.cp_cont_j);
            al.h(this.fQQ, d.C0141d.cp_cont_b);
            al.h(this.fQR, d.C0141d.cp_cont_j);
            al.h(this.fQS, d.C0141d.cp_cont_b);
            al.h(this.fQT, d.C0141d.cp_cont_j);
            al.h(this.ejE, d.C0141d.cp_cont_b);
            al.h(this.czf, d.C0141d.cp_cont_j);
            al.j(this.aHA, d.C0141d.cp_bg_line_e);
            this.fQU.setImageDrawable(al.v(i, d.f.person_center_red_tip_shape));
            if (this.fQZ != null) {
                for (int i2 = 0; i2 < this.fQZ.getChildCount(); i2++) {
                    View childAt = this.fQZ.getChildAt(i2);
                    if (childAt != null) {
                        al.i(childAt, d.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.b bVar) {
        this.mUserData = bVar.fov;
        this.dFc.setText(Integer.toString(bVar.fQl));
        this.fQQ.setText(Integer.toString(bVar.fQm));
        this.fQS.setText(Integer.toString(bVar.fQn));
        this.ejE.setText(ao.I(bVar.threadNum));
        if (bVar.fQo) {
            this.fQU.setVisibility(0);
        } else {
            this.fQU.setVisibility(8);
        }
        this.fQV.setOnClickListener(this);
        this.fQW.setOnClickListener(this);
        this.fQX.setOnClickListener(this);
        this.fQY.setOnClickListener(this);
        d(aiH(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fQU.setVisibility(8);
                    com.baidu.tieba.o.a.bpq().b(2, false, true);
                    TiebaStatic.log(new am("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new am("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new am("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new am("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
