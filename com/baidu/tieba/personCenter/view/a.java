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
    private TextView hRs;
    private TextView izk;
    private TextView klU;
    private TextView klV;
    private TextView klW;
    private TextView klX;
    private TextView klY;
    private ImageView klZ;
    private LinearLayout kma;
    private LinearLayout kmb;
    private LinearLayout kmc;
    private LinearLayout kmd;
    private int kme;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kme = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.dIS = view.findViewById(R.id.bottom_divider_line);
        this.hRs = (TextView) view.findViewById(R.id.fans_num);
        this.klU = (TextView) view.findViewById(R.id.fans_title);
        this.klV = (TextView) view.findViewById(R.id.concer_num);
        this.klW = (TextView) view.findViewById(R.id.concer_title);
        this.klX = (TextView) view.findViewById(R.id.attention_bar_num);
        this.klY = (TextView) view.findViewById(R.id.attention_bar_title);
        this.izk = (TextView) view.findViewById(R.id.thread_num);
        this.adX = (TextView) view.findViewById(R.id.thread_title);
        this.kma = (LinearLayout) view.findViewById(R.id.fans_action);
        this.kmb = (LinearLayout) view.findViewById(R.id.concer_action);
        this.kmc = (LinearLayout) view.findViewById(R.id.attention_action);
        this.kmd = (LinearLayout) view.findViewById(R.id.thread_action);
        this.klZ = (ImageView) view.findViewById(R.id.person_center_fans_red_tip);
        this.mTopLine.setVisibility(8);
        this.dIS.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hRs, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.klU, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.klV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.klW, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.klX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.klY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.izk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.adX, (int) R.color.cp_cont_d);
            am.setImageResource(this.klZ, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.aVu().lw(1).lx(4096).lD(R.color.cp_bg_line_e).ly(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).aR(getView());
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
        this.kme = dVar.klb;
        this.hRs.setText(aq.numFormatOverWanNa(dVar.kla));
        this.klV.setText(Integer.toString(dVar.klb));
        this.klX.setText(Integer.toString(dVar.klc));
        this.izk.setText(aq.longNumFormatOver9999wan(dVar.threadNum));
        if (dVar.kld) {
            this.klZ.setVisibility(0);
        } else {
            this.klZ.setVisibility(8);
        }
        this.kma.setOnClickListener(this);
        this.kmb.setOnClickListener(this);
        this.kmc.setOnClickListener(this);
        this.kmd.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    this.klZ.setVisibility(8);
                    com.baidu.tieba.p.a.cVL().g(2, false, true);
                    TiebaStatic.log(new an("c12523").ag("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").ag("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.kme, this.mUserData.getPortrait())));
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
