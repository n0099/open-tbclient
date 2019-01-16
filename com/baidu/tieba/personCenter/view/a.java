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
/* loaded from: classes5.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView cYZ;
    private TextView eSe;
    private TextView elO;
    private TextView gwd;
    private TextView gwe;
    private TextView gwf;
    private TextView gwg;
    private TextView gwh;
    private ImageView gwi;
    private LinearLayout gwj;
    private LinearLayout gwk;
    private LinearLayout gwl;
    private LinearLayout gwm;
    private LinearLayout gwn;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.elO = (TextView) view.findViewById(e.g.fans_num);
        this.gwd = (TextView) view.findViewById(e.g.fans_title);
        this.gwe = (TextView) view.findViewById(e.g.concer_num);
        this.gwf = (TextView) view.findViewById(e.g.concer_title);
        this.gwg = (TextView) view.findViewById(e.g.attention_bar_num);
        this.gwh = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eSe = (TextView) view.findViewById(e.g.thread_num);
        this.cYZ = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.gwn = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gwj = (LinearLayout) view.findViewById(e.g.fans_action);
        this.gwk = (LinearLayout) view.findViewById(e.g.concer_action);
        this.gwl = (LinearLayout) view.findViewById(e.g.attention_action);
        this.gwm = (LinearLayout) view.findViewById(e.g.thread_action);
        this.gwi = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.elO, e.d.cp_cont_b);
            al.h(this.gwd, e.d.cp_cont_j);
            al.h(this.gwe, e.d.cp_cont_b);
            al.h(this.gwf, e.d.cp_cont_j);
            al.h(this.gwg, e.d.cp_cont_b);
            al.h(this.gwh, e.d.cp_cont_j);
            al.h(this.eSe, e.d.cp_cont_b);
            al.h(this.cYZ, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.gwi.setImageDrawable(al.y(i, e.f.person_center_red_tip_shape));
            if (this.gwn != null) {
                for (int i2 = 0; i2 < this.gwn.getChildCount(); i2++) {
                    View childAt = this.gwn.getChildAt(i2);
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
        this.mUserData = cVar.fTJ;
        this.elO.setText(Integer.toString(cVar.gvw));
        this.gwe.setText(Integer.toString(cVar.gvx));
        this.gwg.setText(Integer.toString(cVar.gvy));
        this.eSe.setText(ao.ab(cVar.threadNum));
        if (cVar.gvz) {
            this.gwi.setVisibility(0);
        } else {
            this.gwi.setVisibility(8);
        }
        this.gwj.setOnClickListener(this);
        this.gwk.setOnClickListener(this);
        this.gwl.setOnClickListener(this);
        this.gwm.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.gwi.setVisibility(8);
                    com.baidu.tieba.o.a.bxf().c(2, false, true);
                    TiebaStatic.log(new am("c12523").y("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == e.g.concer_action) {
                TiebaStatic.log(new am("c12523").y("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.attention_action) {
                TiebaStatic.log(new am("c12523").y("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.thread_action) {
                TiebaStatic.log(new am("c12523").y("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
