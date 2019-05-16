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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private TextView VE;
    private TextView fRl;
    private TextView gzk;
    private TextView iel;
    private TextView iem;
    private TextView ien;
    private TextView ieo;
    private TextView iep;
    private ImageView ieq;
    private LinearLayout ier;
    private LinearLayout ies;
    private LinearLayout iet;
    private LinearLayout ieu;
    private LinearLayout iev;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fRl = (TextView) view.findViewById(R.id.fans_num);
        this.iel = (TextView) view.findViewById(R.id.fans_title);
        this.iem = (TextView) view.findViewById(R.id.concer_num);
        this.ien = (TextView) view.findViewById(R.id.concer_title);
        this.ieo = (TextView) view.findViewById(R.id.attention_bar_num);
        this.iep = (TextView) view.findViewById(R.id.attention_bar_title);
        this.gzk = (TextView) view.findViewById(R.id.thread_num);
        this.VE = (TextView) view.findViewById(R.id.thread_title);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.iev = (LinearLayout) view.findViewById(R.id.attention_container);
        this.ier = (LinearLayout) view.findViewById(R.id.fans_action);
        this.ies = (LinearLayout) view.findViewById(R.id.concer_action);
        this.iet = (LinearLayout) view.findViewById(R.id.attention_action);
        this.ieu = (LinearLayout) view.findViewById(R.id.thread_action);
        this.ieq = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fRl, R.color.cp_cont_b);
            al.j(this.iel, R.color.cp_cont_j);
            al.j(this.iem, R.color.cp_cont_b);
            al.j(this.ien, R.color.cp_cont_j);
            al.j(this.ieo, R.color.cp_cont_b);
            al.j(this.iep, R.color.cp_cont_j);
            al.j(this.gzk, R.color.cp_cont_b);
            al.j(this.VE, R.color.cp_cont_j);
            al.l(this.mTopLine, R.color.cp_bg_line_e);
            this.ieq.setImageDrawable(al.S(i, R.drawable.person_center_red_tip_shape));
            if (this.iev != null) {
                for (int i2 = 0; i2 < this.iev.getChildCount(); i2++) {
                    View childAt = this.iev.getChildAt(i2);
                    if (childAt != null) {
                        al.k(childAt, R.drawable.person_center_action_item_selector);
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
        this.fRl.setText(Integer.toString(dVar.idy));
        this.iem.setText(Integer.toString(dVar.idz));
        this.ieo.setText(Integer.toString(dVar.idA));
        this.gzk.setText(ap.aS(dVar.threadNum));
        if (dVar.idB) {
            this.ieq.setVisibility(0);
        } else {
            this.ieq.setVisibility(8);
        }
        this.ier.setOnClickListener(this);
        this.ies.setOnClickListener(this);
        this.iet.setOnClickListener(this);
        this.ieu.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.ieq.setVisibility(8);
                    com.baidu.tieba.o.a.cfX().d(2, false, true);
                    TiebaStatic.log(new am("c12523").P("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
                }
            } else if (view.getId() == R.id.concer_action) {
                TiebaStatic.log(new am("c12523").P("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new am("c12523").P("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new am("c12523").P("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
