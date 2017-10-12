package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private ImageView cBX;
    private TbImageView fjk;
    private TextView fjl;
    private com.baidu.tieba.personPolymeric.c.m fjm;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fjk = (TbImageView) this.mRootView.findViewById(d.h.polymeric_vedio_pic);
        this.fjl = (TextView) this.mRootView.findViewById(d.h.polymeric_vedio_des);
        this.cBX = (ImageView) this.mRootView.findViewById(d.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.k(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fjl, d.e.cp_cont_b, 1);
            aj.b(this.cBX, d.g.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar != null) {
            this.fjm = mVar;
            this.fjk.c(mVar.Wy, 10, false);
            this.fjl.setText(mVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.fjm.Xf, this.fjm.postId, "person_page")));
        }
    }
}
