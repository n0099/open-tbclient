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
    private View boP;
    private TextView cXs;
    private TextView dZW;
    private TextView eCF;
    private TextView gjR;
    private TextView gjS;
    private TextView gjT;
    private TextView gjU;
    private TextView gjV;
    private ImageView gjW;
    private LinearLayout gjX;
    private LinearLayout gjY;
    private LinearLayout gjZ;
    private LinearLayout gka;
    private LinearLayout gkb;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dZW = (TextView) view.findViewById(d.g.fans_num);
        this.gjR = (TextView) view.findViewById(d.g.fans_title);
        this.gjS = (TextView) view.findViewById(d.g.concer_num);
        this.gjT = (TextView) view.findViewById(d.g.concer_title);
        this.gjU = (TextView) view.findViewById(d.g.attention_bar_num);
        this.gjV = (TextView) view.findViewById(d.g.attention_bar_title);
        this.eCF = (TextView) view.findViewById(d.g.thread_num);
        this.cXs = (TextView) view.findViewById(d.g.thread_title);
        this.boP = view.findViewById(d.g.top_divider_line);
        this.gkb = (LinearLayout) view.findViewById(d.g.attention_container);
        this.gjX = (LinearLayout) view.findViewById(d.g.fans_action);
        this.gjY = (LinearLayout) view.findViewById(d.g.concer_action);
        this.gjZ = (LinearLayout) view.findViewById(d.g.attention_action);
        this.gka = (LinearLayout) view.findViewById(d.g.thread_action);
        this.gjW = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.dZW, d.C0140d.cp_cont_b);
            aj.r(this.gjR, d.C0140d.cp_cont_j);
            aj.r(this.gjS, d.C0140d.cp_cont_b);
            aj.r(this.gjT, d.C0140d.cp_cont_j);
            aj.r(this.gjU, d.C0140d.cp_cont_b);
            aj.r(this.gjV, d.C0140d.cp_cont_j);
            aj.r(this.eCF, d.C0140d.cp_cont_b);
            aj.r(this.cXs, d.C0140d.cp_cont_j);
            aj.t(this.boP, d.C0140d.cp_bg_line_e);
            this.gjW.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.gkb != null) {
                for (int i2 = 0; i2 < this.gkb.getChildCount(); i2++) {
                    View childAt = this.gkb.getChildAt(i2);
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
        this.mUserData = bVar.fHl;
        this.dZW.setText(Integer.toString(bVar.gjo));
        this.gjS.setText(Integer.toString(bVar.gjp));
        this.gjU.setText(Integer.toString(bVar.gjq));
        this.eCF.setText(am.N(bVar.threadNum));
        if (bVar.gjr) {
            this.gjW.setVisibility(0);
        } else {
            this.gjW.setVisibility(8);
        }
        this.gjX.setOnClickListener(this);
        this.gjY.setOnClickListener(this);
        this.gjZ.setOnClickListener(this);
        this.gka.setOnClickListener(this);
        d(akO(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.gjW.setVisibility(8);
                    com.baidu.tieba.m.a.bpm().c(2, false, true);
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
