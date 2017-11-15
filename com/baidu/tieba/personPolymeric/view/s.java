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
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private ImageView cJT;
    private TbImageView fsd;
    private TextView fse;
    private com.baidu.tieba.personPolymeric.c.m fsf;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fsd = (TbImageView) this.mRootView.findViewById(d.g.polymeric_vedio_pic);
        this.fse = (TextView) this.mRootView.findViewById(d.g.polymeric_vedio_des);
        this.cJT = (ImageView) this.mRootView.findViewById(d.g.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.fse, d.C0080d.cp_cont_b, 1);
            aj.b(this.cJT, d.f.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar != null) {
            this.fsf = mVar;
            this.fsd.startLoad(mVar.WE, 10, false);
            this.fse.setText(mVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.fsf.Xl, this.fsf.postId, "person_page")));
        }
    }
}
