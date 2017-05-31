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
public class ab extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private ImageView cdE;
    private TbImageView eNZ;
    private TextView eOa;
    private com.baidu.tieba.personPolymeric.c.l eOb;
    private View mRootView;

    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eNZ = (TbImageView) this.mRootView.findViewById(w.h.polymeric_vedio_pic);
        this.eOa = (TextView) this.mRootView.findViewById(w.h.polymeric_vedio_des);
        this.cdE = (ImageView) this.mRootView.findViewById(w.h.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.k(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eOa, w.e.cp_cont_b, 1);
            aq.c(this.cdE, w.g.icon_play_video, i);
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
            this.eOb = lVar;
            this.eNZ.c(lVar.Vm, 10, false);
            this.eOa.setText(lVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.eOb.Wg, this.eOb.postId, "")));
        }
    }
}
