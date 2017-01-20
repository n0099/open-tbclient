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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private ImageView bQr;
    private TbImageView eFH;
    private TextView eFI;
    private com.baidu.tieba.personPolymeric.c.k eFJ;
    private View mRootView;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eFH = (TbImageView) this.mRootView.findViewById(r.h.polymeric_vedio_pic);
        this.eFI = (TextView) this.mRootView.findViewById(r.h.polymeric_vedio_des);
        this.bQr = (ImageView) this.mRootView.findViewById(r.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.k(this.mRootView, r.e.cp_bg_line_d);
            ap.c(this.eFI, r.e.cp_cont_b, 1);
            ap.c(this.bQr, r.g.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.eFJ = kVar;
            this.eFH.c(kVar.QC, 10, false);
            this.eFI.setText(kVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eFJ.SK, this.eFJ.postId, "")));
        }
    }
}
