package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class o extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.l> {
    private View mRootView;
    private TbImageView mvJ;
    private TextView mvK;
    private ImageView mvL;
    private com.baidu.tieba.personPolymeric.c.l mvM;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mvJ = (TbImageView) this.mRootView.findViewById(R.id.polymeric_vedio_pic);
        this.mvK = (TextView) this.mRootView.findViewById(R.id.polymeric_vedio_des);
        this.mvL = (ImageView) this.mRootView.findViewById(R.id.polymeric_vedio_play_icon);
        this.mRootView.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.mvK, R.color.CAM_X0105, 1);
            ap.setImageResource(this.mvL, R.drawable.icon_play_video, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_polymeric_vedio_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.mvM = lVar;
            this.mvJ.startLoad(lVar.thumbnailUrl, 10, false);
            this.mvK.setText(lVar.title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(this.mvM.tid, this.mvM.postId, "person_page")));
        }
    }
}
