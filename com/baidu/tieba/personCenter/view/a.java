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
    private TextView cYo;
    private TextView eRr;
    private TextView eli;
    private TextView guZ;
    private TextView gva;
    private TextView gvb;
    private TextView gvc;
    private TextView gvd;
    private ImageView gve;
    private LinearLayout gvf;
    private LinearLayout gvg;
    private LinearLayout gvh;
    private LinearLayout gvi;
    private LinearLayout gvj;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.eli = (TextView) view.findViewById(e.g.fans_num);
        this.guZ = (TextView) view.findViewById(e.g.fans_title);
        this.gva = (TextView) view.findViewById(e.g.concer_num);
        this.gvb = (TextView) view.findViewById(e.g.concer_title);
        this.gvc = (TextView) view.findViewById(e.g.attention_bar_num);
        this.gvd = (TextView) view.findViewById(e.g.attention_bar_title);
        this.eRr = (TextView) view.findViewById(e.g.thread_num);
        this.cYo = (TextView) view.findViewById(e.g.thread_title);
        this.mTopLine = view.findViewById(e.g.top_divider_line);
        this.gvj = (LinearLayout) view.findViewById(e.g.attention_container);
        this.gvf = (LinearLayout) view.findViewById(e.g.fans_action);
        this.gvg = (LinearLayout) view.findViewById(e.g.concer_action);
        this.gvh = (LinearLayout) view.findViewById(e.g.attention_action);
        this.gvi = (LinearLayout) view.findViewById(e.g.thread_action);
        this.gve = (ImageView) view.findViewById(e.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eli, e.d.cp_cont_b);
            al.h(this.guZ, e.d.cp_cont_j);
            al.h(this.gva, e.d.cp_cont_b);
            al.h(this.gvb, e.d.cp_cont_j);
            al.h(this.gvc, e.d.cp_cont_b);
            al.h(this.gvd, e.d.cp_cont_j);
            al.h(this.eRr, e.d.cp_cont_b);
            al.h(this.cYo, e.d.cp_cont_j);
            al.j(this.mTopLine, e.d.cp_bg_line_e);
            this.gve.setImageDrawable(al.y(i, e.f.person_center_red_tip_shape));
            if (this.gvj != null) {
                for (int i2 = 0; i2 < this.gvj.getChildCount(); i2++) {
                    View childAt = this.gvj.getChildAt(i2);
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
        this.mUserData = cVar.fSM;
        this.eli.setText(Integer.toString(cVar.gus));
        this.gva.setText(Integer.toString(cVar.gut));
        this.gvc.setText(Integer.toString(cVar.guu));
        this.eRr.setText(ao.ab(cVar.threadNum));
        if (cVar.guv) {
            this.gve.setVisibility(0);
        } else {
            this.gve.setVisibility(8);
        }
        this.gvf.setOnClickListener(this);
        this.gvg.setOnClickListener(this);
        this.gvh.setOnClickListener(this);
        this.gvi.setOnClickListener(this);
        d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == e.g.fans_action) {
                if (this.mUserData != null) {
                    this.gve.setVisibility(8);
                    com.baidu.tieba.o.a.bww().c(2, false, true);
                    TiebaStatic.log(new am("c12523").x("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == e.g.concer_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.attention_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == e.g.thread_action) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
