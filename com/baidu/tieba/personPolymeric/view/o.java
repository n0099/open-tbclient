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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TbImageView hUp;
    private TextView hUq;
    private ImageView hUr;
    private com.baidu.tieba.personPolymeric.c.l hUs;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.hUp = (TbImageView) this.mRootView.findViewById(d.g.polymeric_vedio_pic);
        this.hUq = (TextView) this.mRootView.findViewById(d.g.polymeric_vedio_des);
        this.hUr = (ImageView) this.mRootView.findViewById(d.g.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.l(this.mRootView, d.C0277d.cp_bg_line_d);
            al.d(this.hUq, d.C0277d.cp_cont_b, 1);
            al.b(this.hUr, d.f.icon_play_video, i);
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
            this.hUs = lVar;
            this.hUp.startLoad(lVar.thumbnailUrl, 10, false);
            this.hUq.setText(lVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createNormalCfg(this.hUs.tid, this.hUs.postId, "person_page")));
        }
    }
}
