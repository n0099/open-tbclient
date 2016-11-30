package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private ImageView ceq;
    private TbImageView eSj;
    private TextView eSk;
    private com.baidu.tieba.personPolymeric.c.k eSl;
    private View mRootView;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eSj = (TbImageView) this.mRootView.findViewById(r.g.polymeric_vedio_pic);
        this.eSk = (TextView) this.mRootView.findViewById(r.g.polymeric_vedio_des);
        this.ceq = (ImageView) this.mRootView.findViewById(r.g.polymeric_vedio_play_icon);
        this.eSk.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            at.l(this.mRootView, r.d.cp_bg_line_d);
            at.c(this.eSk, r.d.cp_cont_b, 1);
            at.c(this.ceq, r.f.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.eSl = kVar;
            this.eSj.c(kVar.Rw, 10, false);
            this.eSk.setText(kVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eSk == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eSl.TY, this.eSl.postId, "")));
        } else if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.eSl.fid, this.eSl.TY, "")));
        }
    }
}
