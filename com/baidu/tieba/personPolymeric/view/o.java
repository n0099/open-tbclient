package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TbImageView gEC;
    private TextView gED;
    private ImageView gEE;
    private com.baidu.tieba.personPolymeric.c.l gEF;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gEC = (TbImageView) this.mRootView.findViewById(e.g.polymeric_vedio_pic);
        this.gED = (TextView) this.mRootView.findViewById(e.g.polymeric_vedio_des);
        this.gEE = (ImageView) this.mRootView.findViewById(e.g.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.gED, e.d.cp_cont_b, 1);
            al.b(this.gEE, e.f.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.gEF = lVar;
            this.gEC.startLoad(lVar.thumbnailUrl, 10, false);
            this.gED.setText(lVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createNormalCfg(this.gEF.tid, this.gEF.postId, "person_page")));
        }
    }
}
