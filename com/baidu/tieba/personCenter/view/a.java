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
    private TextView fXb;
    private TextView gGp;
    private TextView ilI;
    private TextView ilJ;
    private TextView ilK;
    private TextView ilL;
    private TextView ilM;
    private ImageView ilN;
    private LinearLayout ilO;
    private LinearLayout ilP;
    private LinearLayout ilQ;
    private LinearLayout ilR;
    private LinearLayout ilS;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fXb = (TextView) view.findViewById(R.id.fans_num);
        this.ilI = (TextView) view.findViewById(R.id.fans_title);
        this.ilJ = (TextView) view.findViewById(R.id.concer_num);
        this.ilK = (TextView) view.findViewById(R.id.concer_title);
        this.ilL = (TextView) view.findViewById(R.id.attention_bar_num);
        this.ilM = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gGp = (TextView) view.findViewById(R.id.thread_num);
        this.VY = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.ilS = (LinearLayout) view.findViewById(R.id.attention_container);
        this.ilO = (LinearLayout) view.findViewById(R.id.fans_action);
        this.ilP = (LinearLayout) view.findViewById(R.id.concer_action);
        this.ilQ = (LinearLayout) view.findViewById(R.id.attention_action);
        this.ilR = (LinearLayout) view.findViewById(R.id.thread_action);
        this.ilN = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.fXb, R.color.cp_cont_b);
            am.j(this.ilI, R.color.cp_cont_j);
            am.j(this.ilJ, R.color.cp_cont_b);
            am.j(this.ilK, R.color.cp_cont_j);
            am.j(this.ilL, R.color.cp_cont_b);
            am.j(this.ilM, R.color.cp_cont_j);
            am.j(this.gGp, R.color.cp_cont_b);
            am.j(this.VY, R.color.cp_cont_j);
            am.l(this.mTopLine, R.color.cp_bg_line_e);
            this.ilN.setImageDrawable(am.V(i, R.drawable.person_center_red_tip_shape));
            if (this.ilS != null) {
                for (int i2 = 0; i2 < this.ilS.getChildCount(); i2++) {
                    View childAt = this.ilS.getChildAt(i2);
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
        this.fXb.setText(Integer.toString(dVar.ikT));
        this.ilJ.setText(Integer.toString(dVar.ikU));
        this.ilL.setText(Integer.toString(dVar.ikV));
        this.gGp.setText(aq.aT(dVar.threadNum));
        if (dVar.ikW) {
            this.ilN.setVisibility(0);
        } else {
            this.ilN.setVisibility(8);
        }
        this.ilO.setOnClickListener(this);
        this.ilP.setOnClickListener(this);
        this.ilQ.setOnClickListener(this);
        this.ilR.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.ilN.setVisibility(8);
                    com.baidu.tieba.o.a.cjj().e(2, false, true);
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
