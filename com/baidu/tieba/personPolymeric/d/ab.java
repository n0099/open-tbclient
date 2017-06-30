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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private ImageView clQ;
    private TbImageView eYk;
    private TextView eYl;
    private com.baidu.tieba.personPolymeric.c.l eYm;
    private View mRootView;

    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eYk = (TbImageView) this.mRootView.findViewById(w.h.polymeric_vedio_pic);
        this.eYl = (TextView) this.mRootView.findViewById(w.h.polymeric_vedio_des);
        this.clQ = (ImageView) this.mRootView.findViewById(w.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            as.k(this.mRootView, w.e.cp_bg_line_d);
            as.c(this.eYl, w.e.cp_cont_b, 1);
            as.c(this.clQ, w.g.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.eYm = lVar;
            this.eYk.c(lVar.Vm, 10, false);
            this.eYl.setText(lVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eYm.Wg, this.eYm.postId, "")));
        }
    }
}
