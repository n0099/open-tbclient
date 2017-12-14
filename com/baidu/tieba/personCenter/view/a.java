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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.a> {
    private View ayc;
    private TextView bZU;
    private TextView dKf;
    private TextView del;
    private ImageView dsX;
    private TextView ftj;
    private TextView ftk;
    private TextView ftl;
    private TextView ftm;
    private TextView ftn;
    private LinearLayout fto;
    private LinearLayout ftp;
    private LinearLayout ftq;
    private LinearLayout ftr;
    private LinearLayout fts;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.del = (TextView) view.findViewById(d.g.fans_num);
        this.ftj = (TextView) view.findViewById(d.g.fans_title);
        this.ftk = (TextView) view.findViewById(d.g.concer_num);
        this.ftl = (TextView) view.findViewById(d.g.concer_title);
        this.ftm = (TextView) view.findViewById(d.g.attention_bar_num);
        this.ftn = (TextView) view.findViewById(d.g.attention_bar_title);
        this.dKf = (TextView) view.findViewById(d.g.thread_num);
        this.bZU = (TextView) view.findViewById(d.g.thread_title);
        this.ayc = view.findViewById(d.g.top_divider_line);
        this.fts = (LinearLayout) view.findViewById(d.g.attention_container);
        this.fto = (LinearLayout) view.findViewById(d.g.fans_action);
        this.ftp = (LinearLayout) view.findViewById(d.g.concer_action);
        this.ftq = (LinearLayout) view.findViewById(d.g.attention_action);
        this.ftr = (LinearLayout) view.findViewById(d.g.thread_action);
        this.dsX = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.del, d.C0096d.cp_cont_b);
            aj.i(this.ftj, d.C0096d.cp_cont_j);
            aj.i(this.ftk, d.C0096d.cp_cont_b);
            aj.i(this.ftl, d.C0096d.cp_cont_j);
            aj.i(this.ftm, d.C0096d.cp_cont_b);
            aj.i(this.ftn, d.C0096d.cp_cont_j);
            aj.i(this.dKf, d.C0096d.cp_cont_b);
            aj.i(this.bZU, d.C0096d.cp_cont_j);
            aj.k(this.ayc, d.C0096d.cp_bg_line_e);
            this.dsX.setImageDrawable(aj.v(i, d.f.person_center_red_tip_shape));
            if (this.fts != null) {
                for (int i2 = 0; i2 < this.fts.getChildCount(); i2++) {
                    View childAt = this.fts.getChildAt(i2);
                    if (childAt != null) {
                        aj.j(childAt, d.f.person_center_action_item_selector);
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
    public void a(com.baidu.tieba.personCenter.data.a aVar) {
        this.mUserData = aVar.ePs;
        this.del.setText(Integer.toString(aVar.fsH));
        this.ftk.setText(Integer.toString(aVar.fsI));
        this.ftm.setText(Integer.toString(aVar.fsJ));
        this.dKf.setText(am.F(aVar.threadNum));
        if (aVar.fsK) {
            this.dsX.setVisibility(0);
        } else {
            this.dsX.setVisibility(8);
        }
        this.fto.setOnClickListener(this);
        this.ftp.setOnClickListener(this);
        this.ftq.setOnClickListener(this);
        this.ftr.setOnClickListener(this);
        d(abs(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.dsX.setVisibility(8);
                    com.baidu.tieba.m.a.bmN().c(2, false, true);
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == d.g.concer_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.attention_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == d.g.thread_action) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
