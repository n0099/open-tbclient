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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.d> {
    private TextView aht;
    private View eNL;
    private TextView jDG;
    private TextView ksA;
    private LinearLayout mContainer;
    private int mSkinType;
    private View mTopLine;
    private UserData mUserData;
    private TextView mkU;
    private TextView mkV;
    private TextView mkW;
    private TextView mkX;
    private TextView mkY;
    private LinearLayout mkZ;
    private LinearLayout mla;
    private LinearLayout mlb;
    private LinearLayout mlc;
    private int mld;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mld = 0;
        View view = getView();
        this.mContainer = (LinearLayout) view.findViewById(R.id.layout_container);
        this.mTopLine = view.findViewById(R.id.top_divider_line);
        this.eNL = view.findViewById(R.id.bottom_divider_line);
        this.jDG = (TextView) view.findViewById(R.id.fans_num);
        this.mkU = (TextView) view.findViewById(R.id.fans_title);
        this.mkV = (TextView) view.findViewById(R.id.concer_num);
        this.mkW = (TextView) view.findViewById(R.id.concer_title);
        this.mkX = (TextView) view.findViewById(R.id.attention_bar_num);
        this.mkY = (TextView) view.findViewById(R.id.attention_bar_title);
        this.ksA = (TextView) view.findViewById(R.id.thread_num);
        this.aht = (TextView) view.findViewById(R.id.thread_title);
        this.mkZ = (LinearLayout) view.findViewById(R.id.fans_action);
        this.mla = (LinearLayout) view.findViewById(R.id.concer_action);
        this.mlb = (LinearLayout) view.findViewById(R.id.attention_action);
        this.mlc = (LinearLayout) view.findViewById(R.id.thread_action);
        this.mTopLine.setVisibility(8);
        this.eNL.setVisibility(8);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.jDG, R.color.CAM_X0105);
            ap.setViewTextColor(this.mkU, R.color.CAM_X0109);
            ap.setViewTextColor(this.mkV, R.color.CAM_X0105);
            ap.setViewTextColor(this.mkW, R.color.CAM_X0109);
            ap.setViewTextColor(this.mkX, R.color.CAM_X0105);
            ap.setViewTextColor(this.mkY, R.color.CAM_X0109);
            ap.setViewTextColor(this.ksA, R.color.CAM_X0105);
            ap.setViewTextColor(this.aht, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
            int dimens = l.getDimens(getContext(), R.dimen.tbds16);
            com.baidu.tbadk.core.util.e.a.buy().qq(1).qr(4096).qx(R.color.CAM_X0205).qs(0).a(R.color.cp_shadow_a, 0.2f, 0, l.getDimens(getContext(), R.dimen.tbds5), dimens).bq(getView());
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
        this.mld = dVar.mjW;
        this.jDG.setText(au.numFormatOverWanNa(dVar.mjV));
        this.mkV.setText(Integer.toString(dVar.mjW));
        this.mkX.setText(Integer.toString(dVar.mjX));
        this.ksA.setText(au.longNumFormatOver9999wan(dVar.threadNum));
        this.mkZ.setOnClickListener(this);
        this.mla.setOnClickListener(this);
        this.mlb.setOnClickListener(this);
        this.mlc.setOnClickListener(this);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.fans_action) {
                if (this.mUserData != null) {
                    com.baidu.tieba.q.a.dGO().h(2, false, true);
                    TiebaStatic.log(new ar("c12523").al("obj_locate", 6));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser())));
                }
            } else if (view.getId() == R.id.concer_action) {
                if (this.mUserData != null) {
                    TiebaStatic.log(new ar("c12523").al("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mTbPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateBjhUser(this.mUserData.isBaijiahaoUser()).updateFollowNum(this.mld, this.mUserData.getPortrait())));
                }
            } else if (view.getId() == R.id.attention_action) {
                TiebaStatic.log(new ar("c12523").al("obj_locate", 7));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else if (view.getId() == R.id.thread_action) {
                TiebaStatic.log(new ar("c12523").al("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getSex(), this.mUserData.getPortrait())));
            }
        }
    }
}
