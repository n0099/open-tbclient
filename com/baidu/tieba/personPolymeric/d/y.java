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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private ImageView bZF;
    private TbImageView eJu;
    private TextView eJv;
    private com.baidu.tieba.personPolymeric.c.k eJw;
    private View mRootView;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eJu = (TbImageView) this.mRootView.findViewById(w.h.polymeric_vedio_pic);
        this.eJv = (TextView) this.mRootView.findViewById(w.h.polymeric_vedio_des);
        this.bZF = (ImageView) this.mRootView.findViewById(w.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.k(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eJv, w.e.cp_cont_b, 1);
            aq.c(this.bZF, w.g.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.eJw = kVar;
            this.eJu.c(kVar.Wg, 10, false);
            this.eJv.setText(kVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eJw.WT, this.eJw.postId, "")));
        }
    }
}
