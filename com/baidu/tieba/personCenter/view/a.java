package com.baidu.tieba.personCenter.view;

import android.view.View;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView ahn;
    private View eSX;
    private TextView jLC;
    private TextView kyK;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;
    private TextView mlA;
    private TextView mlB;
    private LinearLayout mlC;
    private LinearLayout mlD;
    private LinearLayout mlE;
    private LinearLayout mlF;
    private int mlG;
    private TextView mlx;
    private TextView mly;
    private TextView mlz;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mlG = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eSX = view.findViewById(R.id.bottom_divider_line);
        this.jLC = (TextView) view.findViewById(R.id.fans_num);
        this.mlx = (TextView) view.findViewById(R.id.fans_title);
        this.mly = (TextView) view.findViewById(R.id.concer_num);
        this.mlz = (TextView) view.findViewById(R.id.concer_title);
        this.mlA = (TextView) view.findViewById(R.id.attention_bar_num);
        this.mlB = (TextView) view.findViewById(R.id.attention_bar_title);
        this.kyK = (TextView) view.findViewById(R.id.thread_num);
        this.ahn = (TextView) view.findViewById(R.id.thread_title);
        this.mlC = (LinearLayout) view.findViewById(R.id.fans_action);
        this.mlD = (LinearLayout) view.findViewById(R.id.concer_action);
        this.mlE = (LinearLayout) view.findViewById(R.id.attention_action);
        this.mlF = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eSX.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.jLC, R.color.CAM_X0105);
            ao.setViewTextColor(this.mlx, R.color.CAM_X0109);
            ao.setViewTextColor(this.mly, R.color.CAM_X0105);
            ao.setViewTextColor(this.mlz, R.color.CAM_X0109);
            ao.setViewTextColor(this.mlA, R.color.CAM_X0105);
            ao.setViewTextColor(this.mlB, R.color.CAM_X0109);
            ao.setViewTextColor(this.kyK, R.color.CAM_X0105);
            ao.setViewTextColor(this.ahn, R.color.CAM_X0109);
            ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.eSX, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.f.a.bta().oU(1).oV(4096).pb(R.color.CAM_X0205).oW(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bz(getView());
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
        this.mlG = dVar.mkz;
        this.jLC.setText(at.numFormatOverWanNa(dVar.mky));
        this.mly.setText(Integer.toString(dVar.mkz));
        this.mlA.setText(Integer.toString(dVar.mkA));
        this.kyK.setText(at.longNumFormatOver9999wan(dVar.threadNum));
        this.mlC.setOnClickListener(this);
        this.mlD.setOnClickListener(this);
        this.mlE.setOnClickListener(this);
        this.mlF.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.p.a.dCM().h(2, false, true);
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.mlG, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
