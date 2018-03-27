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
    private View boF;
    private TextView cXj;
    private TextView eCJ;
    private TextView eaa;
    private TextView gjW;
    private TextView gjX;
    private TextView gjY;
    private TextView gjZ;
    private TextView gka;
    private ImageView gkb;
    private LinearLayout gkc;
    private LinearLayout gkd;
    private LinearLayout gke;
    private LinearLayout gkf;
    private LinearLayout gkg;
    private int mSkinType;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.eaa = (TextView) view.findViewById(d.g.fans_num);
        this.gjW = (TextView) view.findViewById(d.g.fans_title);
        this.gjX = (TextView) view.findViewById(d.g.concer_num);
        this.gjY = (TextView) view.findViewById(d.g.concer_title);
        this.gjZ = (TextView) view.findViewById(d.g.attention_bar_num);
        this.gka = (TextView) view.findViewById(d.g.attention_bar_title);
        this.eCJ = (TextView) view.findViewById(d.g.thread_num);
        this.cXj = (TextView) view.findViewById(d.g.thread_title);
        this.boF = view.findViewById(d.g.top_divider_line);
        this.gkg = (LinearLayout) view.findViewById(d.g.attention_container);
        this.gkc = (LinearLayout) view.findViewById(d.g.fans_action);
        this.gkd = (LinearLayout) view.findViewById(d.g.concer_action);
        this.gke = (LinearLayout) view.findViewById(d.g.attention_action);
        this.gkf = (LinearLayout) view.findViewById(d.g.thread_action);
        this.gkb = (ImageView) view.findViewById(d.g.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.eaa, d.C0141d.cp_cont_b);
            aj.r(this.gjW, d.C0141d.cp_cont_j);
            aj.r(this.gjX, d.C0141d.cp_cont_b);
            aj.r(this.gjY, d.C0141d.cp_cont_j);
            aj.r(this.gjZ, d.C0141d.cp_cont_b);
            aj.r(this.gka, d.C0141d.cp_cont_j);
            aj.r(this.eCJ, d.C0141d.cp_cont_b);
            aj.r(this.cXj, d.C0141d.cp_cont_j);
            aj.t(this.boF, d.C0141d.cp_bg_line_e);
            this.gkb.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            if (this.gkg != null) {
                for (int i2 = 0; i2 < this.gkg.getChildCount(); i2++) {
                    View childAt = this.gkg.getChildAt(i2);
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
        this.mUserData = bVar.fHq;
        this.eaa.setText(Integer.toString(bVar.gjt));
        this.gjX.setText(Integer.toString(bVar.gju));
        this.gjZ.setText(Integer.toString(bVar.gjv));
        this.eCJ.setText(am.N(bVar.threadNum));
        if (bVar.gjw) {
            this.gkb.setVisibility(0);
        } else {
            this.gkb.setVisibility(8);
        }
        this.gkc.setOnClickListener(this);
        this.gkd.setOnClickListener(this);
        this.gke.setOnClickListener(this);
        this.gkf.setOnClickListener(this);
        d(akO(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.fans_action) {
                if (this.mUserData != null) {
                    this.gkb.setVisibility(8);
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
