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
    private TextView VX;
    private TextView fYS;
    private TextView gIh;
    private TextView inK;
    private TextView inL;
    private TextView inM;
    private TextView inN;
    private TextView inO;
    private ImageView inP;
    private LinearLayout inQ;
    private LinearLayout inR;
    private LinearLayout inS;
    private LinearLayout inT;
    private LinearLayout inU;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fYS = (TextView) view.findViewById(R.id.fans_num);
        this.inK = (TextView) view.findViewById(R.id.fans_title);
        this.inL = (TextView) view.findViewById(R.id.concer_num);
        this.inM = (TextView) view.findViewById(R.id.concer_title);
        this.inN = (TextView) view.findViewById(R.id.attention_bar_num);
        this.inO = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gIh = (TextView) view.findViewById(R.id.thread_num);
        this.VX = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.inU = (LinearLayout) view.findViewById(R.id.attention_container);
        this.inQ = (LinearLayout) view.findViewById(R.id.fans_action);
        this.inR = (LinearLayout) view.findViewById(R.id.concer_action);
        this.inS = (LinearLayout) view.findViewById(R.id.attention_action);
        this.inT = (LinearLayout) view.findViewById(R.id.thread_action);
        this.inP = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.fYS, R.color.cp_cont_b);
            am.j(this.inK, R.color.cp_cont_j);
            am.j(this.inL, R.color.cp_cont_b);
            am.j(this.inM, R.color.cp_cont_j);
            am.j(this.inN, R.color.cp_cont_b);
            am.j(this.inO, R.color.cp_cont_j);
            am.j(this.gIh, R.color.cp_cont_b);
            am.j(this.VX, R.color.cp_cont_j);
            am.l(this.mTopLine, R.color.cp_bg_line_c);
            this.inP.setImageDrawable(am.V(i, R.drawable.person_center_red_tip_shape));
            if (this.inU != null) {
                for (int i2 = 0; i2 < this.inU.getChildCount(); i2++) {
                    View childAt = this.inU.getChildAt(i2);
                    if (childAt != null) {
                        childAt.setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
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
        this.fYS.setText(Integer.toString(dVar.imT));
        this.inL.setText(Integer.toString(dVar.imU));
        this.inN.setText(Integer.toString(dVar.imV));
        this.gIh.setText(aq.aT(dVar.threadNum));
        if (dVar.imW) {
            this.inP.setVisibility(0);
        } else {
            this.inP.setVisibility(8);
        }
        this.inQ.setOnClickListener(this);
        this.inR.setOnClickListener(this);
        this.inS.setOnClickListener(this);
        this.inT.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.inP.setVisibility(8);
                    com.baidu.tieba.o.a.cjV().e(2, false, true);
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
