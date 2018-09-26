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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView cFr;
    private TextView dSA;
    private TextView eyH;
    private LinearLayout gcA;
    private TextView gcq;
    private TextView gcr;
    private TextView gcs;
    private TextView gct;
    private TextView gcu;
    private ImageView gcv;
    private LinearLayout gcw;
    private LinearLayout gcx;
    private LinearLayout gcy;
    private LinearLayout gcz;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dSA = (TextView) view.findViewById(e.g.fans_num);
        this.gcq = (TextView) view.findViewById(e.g.fans_title);
        this.gcr = (TextView) view.findViewById(e.g.concer_num);
        this.gcs = (TextView) view.findViewById(e.g.concer_title);
        this.gct = (TextView) view.findViewById(e.g.attention_bar_num);
        this.gcu = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eyH = (TextView) view.findViewById(e.g.thread_num);
        this.cFr = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.gcA = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gcw = (LinearLayout) view.findViewById(e.g.fans_action);
        this.gcx = (LinearLayout) view.findViewById(e.g.concer_action);
        this.gcy = (LinearLayout) view.findViewById(e.g.attention_action);
        this.gcz = (LinearLayout) view.findViewById(e.g.thread_action);
        this.gcv = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.dSA, e.d.cp_cont_b);
            al.h(this.gcq, e.d.cp_cont_j);
            al.h(this.gcr, e.d.cp_cont_b);
            al.h(this.gcs, e.d.cp_cont_j);
            al.h(this.gct, e.d.cp_cont_b);
            al.h(this.gcu, e.d.cp_cont_j);
            al.h(this.eyH, e.d.cp_cont_b);
            al.h(this.cFr, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.gcv.setImageDrawable(al.x(i, e.f.person_center_red_tip_shape));
            if (this.gcA != null) {
                for (int i2 = 0; i2 < this.gcA.getChildCount(); i2++) {
                    View childAt = this.gcA.getChildAt(i2);
                    if (childAt != null) {
                        al.i(childAt, e.f.person_center_action_item_selector);
                    }
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.c cVar) {
        this.mUserData = cVar.fAd;
        this.dSA.setText(Integer.toString(cVar.gbJ));
        this.gcr.setText(Integer.toString(cVar.gbK));
        this.gct.setText(Integer.toString(cVar.gbL));
        this.eyH.setText(ao.P(cVar.threadNum));
        if (cVar.gbM) {
            this.gcv.setVisibility(0);
        } else {
            this.gcv.setVisibility(8);
        }
        this.gcw.setOnClickListener(this);
        this.gcx.setOnClickListener(this);
        this.gcy.setOnClickListener(this);
        this.gcz.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.gcv.setVisibility(8);
                    com.baidu.tieba.o.a.brf().c(2, false, true);
                    TiebaStatic.log(new am("c12523").w("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == e.g.concer_action) {
                TiebaStatic.log(new am("c12523").w("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.attention_action) {
                TiebaStatic.log(new am("c12523").w("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.thread_action) {
                TiebaStatic.log(new am("c12523").w("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
