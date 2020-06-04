package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView adX;
    private View dIS;
    private TextView hSf;
    private TextView izX;
    private TextView kna;
    private TextView knb;
    private TextView knc;
    private TextView knd;
    private TextView kne;
    private ImageView knf;
    private LinearLayout kng;
    private LinearLayout knh;
    private LinearLayout kni;
    private LinearLayout knj;
    private int knk;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.knk = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.dIS = view.findViewById(R.id.bottom_divider_line);
        this.hSf = (TextView) view.findViewById(R.id.fans_num);
        this.kna = (TextView) view.findViewById(R.id.fans_title);
        this.knb = (TextView) view.findViewById(R.id.concer_num);
        this.knc = (TextView) view.findViewById(R.id.concer_title);
        this.knd = (TextView) view.findViewById(R.id.attention_bar_num);
        this.kne = (TextView) view.findViewById(R.id.attention_bar_title);
        this.izX = (TextView) view.findViewById(R.id.thread_num);
        this.adX = (TextView) view.findViewById(R.id.thread_title);
        this.kng = (LinearLayout) view.findViewById(R.id.fans_action);
        this.knh = (LinearLayout) view.findViewById(R.id.concer_action);
        this.kni = (LinearLayout) view.findViewById(R.id.attention_action);
        this.knj = (LinearLayout) view.findViewById(R.id.thread_action);
        this.knf = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.dIS.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hSf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kna, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.knb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.knc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.knd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kne, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.izX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adX, (int) R.color.cp_cont_d);
            am.setImageResource(this.knf, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aVv().ly(1).lz(4096).lF(R.color.cp_bg_line_e).lA(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aR(getView());
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_actions_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.d dVar) {
        this.mUserData = dVar.userData;
        this.knk = dVar.kmh;
        this.hSf.setText(aq.numFormatOverWanNa(dVar.kmg));
        this.knb.setText(Integer.toString(dVar.kmh));
        this.knd.setText(Integer.toString(dVar.kmi));
        this.izX.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.kmj) {
            this.knf.setVisibility(0);
        } else {
            this.knf.setVisibility(8);
        }
        this.kng.setOnClickListener(this);
        this.knh.setOnClickListener(this);
        this.kni.setOnClickListener(this);
        this.knj.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.knf.setVisibility(8);
                    com.baidu.tieba.p.a.cWb().g(2, false, true);
                    TiebaStatic.log(new an("c12523").ag("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").ag("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.knk, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new an("c12523").ag("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new an("c12523").ag("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
