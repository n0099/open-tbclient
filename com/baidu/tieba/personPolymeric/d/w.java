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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private ImageView caR;
    private TbImageView eJI;
    private TextView eJJ;
    private com.baidu.tieba.personPolymeric.c.k eJK;
    private View mRootView;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eJI = (TbImageView) this.mRootView.findViewById(t.g.polymeric_vedio_pic);
        this.eJJ = (TextView) this.mRootView.findViewById(t.g.polymeric_vedio_des);
        this.caR = (ImageView) this.mRootView.findViewById(t.g.polymeric_vedio_play_icon);
        this.eJJ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            av.l(this.mRootView, t.d.cp_bg_line_d);
            av.c(this.eJJ, t.d.cp_cont_b, 1);
            av.c(this.caR, t.f.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.eJK = kVar;
            this.eJI.c(kVar.QV, 10, false);
            this.eJJ.setText(kVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eJJ == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eJK.Tt, this.eJK.postId, "")));
        } else if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.eJK.aRv, this.eJK.Tt, "")));
        }
    }
}
