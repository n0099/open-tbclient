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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.c> {
    private TextView XM;
    private TextView fAo;
    private TextView ghX;
    private TextView hMa;
    private TextView hMb;
    private TextView hMc;
    private TextView hMd;
    private TextView hMe;
    private ImageView hMf;
    private LinearLayout hMg;
    private LinearLayout hMh;
    private LinearLayout hMi;
    private LinearLayout hMj;
    private LinearLayout hMk;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fAo = (TextView) view.findViewById(d.g.fans_num);
        this.hMa = (TextView) view.findViewById(d.g.fans_title);
        this.hMb = (TextView) view.findViewById(d.g.concer_num);
        this.hMc = (TextView) view.findViewById(d.g.concer_title);
        this.hMd = (TextView) view.findViewById(d.g.attention_bar_num);
        this.hMe = (TextView) view.findViewById(d.g.attention_bar_title);
        this.ghX = (TextView) view.findViewById(d.g.thread_num);
        this.XM = (TextView) view.findViewById(d.g.thread_title);
        this.mTopLine = view.findViewById(d.g.top_divider_line);
        this.hMk = (LinearLayout) view.findViewById(d.g.attention_container);
        this.hMg = (LinearLayout) view.findViewById(d.g.fans_action);
        this.hMh = (LinearLayout) view.findViewById(d.g.concer_action);
        this.hMi = (LinearLayout) view.findViewById(d.g.attention_action);
        this.hMj = (LinearLayout) view.findViewById(d.g.thread_action);
        this.hMf = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fAo, d.C0277d.cp_cont_b);
            al.j(this.hMa, d.C0277d.cp_cont_j);
            al.j(this.hMb, d.C0277d.cp_cont_b);
            al.j(this.hMc, d.C0277d.cp_cont_j);
            al.j(this.hMd, d.C0277d.cp_cont_b);
            al.j(this.hMe, d.C0277d.cp_cont_j);
            al.j(this.ghX, d.C0277d.cp_cont_b);
            al.j(this.XM, d.C0277d.cp_cont_j);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_e);
            this.hMf.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
            if (this.hMk != null) {
                for (int i2 = 0; i2 < this.hMk.getChildCount(); i2++) {
                    View childAt = this.hMk.getChildAt(i2);
                    if (childAt != null) {
                        al.k(childAt, d.f.person_center_action_item_selector);
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
    public void a(com.baidu.tieba.personCenter.data.c cVar) {
        this.mUserData = cVar.userData;
        this.fAo.setText(Integer.toString(cVar.hLu));
        this.hMb.setText(Integer.toString(cVar.hLv));
        this.hMd.setText(Integer.toString(cVar.hLw));
        this.ghX.setText(ap.aD(cVar.threadNum));
        if (cVar.hLx) {
            this.hMf.setVisibility(0);
        } else {
            this.hMf.setVisibility(8);
        }
        this.hMg.setOnClickListener(this);
        this.hMh.setOnClickListener(this);
        this.hMi.setOnClickListener(this);
        this.hMj.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.hMf.setVisibility(8);
                    com.baidu.tieba.o.a.bXS().d(2, false, true);
                    TiebaStatic.log(new am("c12523").T("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
