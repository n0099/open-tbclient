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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.b> {
    private View aIx;
    private TextView cwZ;
    private TextView dIx;
    private TextView eny;
    private TextView fUR;
    private TextView fUS;
    private TextView fUT;
    private TextView fUU;
    private TextView fUV;
    private ImageView fUW;
    private LinearLayout fUX;
    private LinearLayout fUY;
    private LinearLayout fUZ;
    private LinearLayout fVa;
    private LinearLayout fVb;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dIx = (TextView) view.findViewById(d.g.fans_num);
        this.fUR = (TextView) view.findViewById(d.g.fans_title);
        this.fUS = (TextView) view.findViewById(d.g.concer_num);
        this.fUT = (TextView) view.findViewById(d.g.concer_title);
        this.fUU = (TextView) view.findViewById(d.g.attention_bar_num);
        this.fUV = (TextView) view.findViewById(d.g.attention_bar_title);
        this.eny = (TextView) view.findViewById(d.g.thread_num);
        this.cwZ = (TextView) view.findViewById(d.g.thread_title);
        this.aIx = view.findViewById(d.g.top_divider_line);
        this.fVb = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fUX = (LinearLayout) view.findViewById(d.g.fans_action);
        this.fUY = (LinearLayout) view.findViewById(d.g.concer_action);
        this.fUZ = (LinearLayout) view.findViewById(d.g.attention_action);
        this.fVa = (LinearLayout) view.findViewById(d.g.thread_action);
        this.fUW = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dIx, d.C0142d.cp_cont_b);
            am.h(this.fUR, d.C0142d.cp_cont_j);
            am.h(this.fUS, d.C0142d.cp_cont_b);
            am.h(this.fUT, d.C0142d.cp_cont_j);
            am.h(this.fUU, d.C0142d.cp_cont_b);
            am.h(this.fUV, d.C0142d.cp_cont_j);
            am.h(this.eny, d.C0142d.cp_cont_b);
            am.h(this.cwZ, d.C0142d.cp_cont_j);
            am.j(this.aIx, d.C0142d.cp_bg_line_e);
            this.fUW.setImageDrawable(am.v(i, d.f.person_center_red_tip_shape));
            if (this.fVb != null) {
                for (int i2 = 0; i2 < this.fVb.getChildCount(); i2++) {
                    View childAt = this.fVb.getChildAt(i2);
                    if (childAt != null) {
                        am.i(childAt, d.f.person_center_action_item_selector);
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
        this.mUserData = bVar.fso;
        this.dIx.setText(Integer.toString(bVar.fUn));
        this.fUS.setText(Integer.toString(bVar.fUo));
        this.fUU.setText(Integer.toString(bVar.fUp));
        this.eny.setText(ap.J(bVar.threadNum));
        if (bVar.fUq) {
            this.fUW.setVisibility(0);
        } else {
            this.fUW.setVisibility(8);
        }
        this.fUX.setOnClickListener(this);
        this.fUY.setOnClickListener(this);
        this.fUZ.setOnClickListener(this);
        this.fVa.setOnClickListener(this);
        d(ahZ(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.fUW.setVisibility(8);
                    com.baidu.tieba.o.a.bpR().b(2, false, true);
                    TiebaStatic.log(new an("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
