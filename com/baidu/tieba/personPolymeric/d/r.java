package com.baidu.tieba.personPolymeric.d;

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
public class r extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private ImageView cAm;
    private TbImageView fmw;
    private TextView fmx;
    private com.baidu.tieba.personPolymeric.c.l fmy;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fmw = (TbImageView) this.mRootView.findViewById(d.h.polymeric_vedio_pic);
        this.fmx = (TextView) this.mRootView.findViewById(d.h.polymeric_vedio_des);
        this.cAm = (ImageView) this.mRootView.findViewById(d.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.k(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fmx, d.e.cp_cont_b, 1);
            aj.b(this.cAm, d.g.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.fmy = lVar;
            this.fmw.c(lVar.Wk, 10, false);
            this.fmx.setText(lVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.fmy.Xe, this.fmy.postId, "person_page")));
        }
    }
}
