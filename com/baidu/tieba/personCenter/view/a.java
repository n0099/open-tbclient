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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private TextView VY;
    private TextView fWl;
    private TextView gFx;
    private TextView ikF;
    private TextView ikG;
    private TextView ikH;
    private TextView ikI;
    private TextView ikJ;
    private ImageView ikK;
    private LinearLayout ikL;
    private LinearLayout ikM;
    private LinearLayout ikN;
    private LinearLayout ikO;
    private LinearLayout ikP;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fWl = (TextView) view.findViewById(R.id.fans_num);
        this.ikF = (TextView) view.findViewById(R.id.fans_title);
        this.ikG = (TextView) view.findViewById(R.id.concer_num);
        this.ikH = (TextView) view.findViewById(R.id.concer_title);
        this.ikI = (TextView) view.findViewById(R.id.attention_bar_num);
        this.ikJ = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gFx = (TextView) view.findViewById(R.id.thread_num);
        this.VY = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.ikP = (LinearLayout) view.findViewById(R.id.attention_container);
        this.ikL = (LinearLayout) view.findViewById(R.id.fans_action);
        this.ikM = (LinearLayout) view.findViewById(R.id.concer_action);
        this.ikN = (LinearLayout) view.findViewById(R.id.attention_action);
        this.ikO = (LinearLayout) view.findViewById(R.id.thread_action);
        this.ikK = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.fWl, R.color.cp_cont_b);
            am.j(this.ikF, R.color.cp_cont_j);
            am.j(this.ikG, R.color.cp_cont_b);
            am.j(this.ikH, R.color.cp_cont_j);
            am.j(this.ikI, R.color.cp_cont_b);
            am.j(this.ikJ, R.color.cp_cont_j);
            am.j(this.gFx, R.color.cp_cont_b);
            am.j(this.VY, R.color.cp_cont_j);
            am.l(this.mTopLine, R.color.cp_bg_line_e);
            this.ikK.setImageDrawable(am.V(i, R.drawable.person_center_red_tip_shape));
            if (this.ikP != null) {
                for (int i2 = 0; i2 < this.ikP.getChildCount(); i2++) {
                    View childAt = this.ikP.getChildAt(i2);
                    if (childAt != null) {
                        am.k(childAt, R.drawable.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.d dVar) {
        this.mUserData = dVar.userData;
        this.fWl.setText(Integer.toString(dVar.ijR));
        this.ikG.setText(Integer.toString(dVar.ijS));
        this.ikI.setText(Integer.toString(dVar.ijT));
        this.gFx.setText(aq.aT(dVar.threadNum));
        if (dVar.ijU) {
            this.ikK.setVisibility(0);
        } else {
            this.ikK.setVisibility(8);
        }
        this.ikL.setOnClickListener(this);
        this.ikM.setOnClickListener(this);
        this.ikN.setOnClickListener(this);
        this.ikO.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.ikK.setVisibility(8);
                    com.baidu.tieba.o.a.ciR().e(2, false, true);
                    TiebaStatic.log(new an("c12523").P("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == R.id.concer_action) {
                TiebaStatic.log(new an("c12523").P("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").P("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").P("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
