package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TbImageView gdB;
    private TextView gdC;
    private ImageView gdD;
    private com.baidu.tieba.personPolymeric.c.l gdE;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gdB = (TbImageView) this.mRootView.findViewById(d.g.polymeric_vedio_pic);
        this.gdC = (TextView) this.mRootView.findViewById(d.g.polymeric_vedio_des);
        this.gdD = (ImageView) this.mRootView.findViewById(d.g.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.mRootView, d.C0140d.cp_bg_line_d);
            am.c(this.gdC, d.C0140d.cp_cont_b, 1);
            am.b(this.gdD, d.f.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.gdE = lVar;
            this.gdB.startLoad(lVar.thumbnailUrl, 10, false);
            this.gdC.setText(lVar.title);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createNormalCfg(this.gdE.tid, this.gdE.postId, "person_page")));
        }
    }
}
