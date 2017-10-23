package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.pb.pb.main.k<m, n> {
    public View.OnClickListener aTt;

    public l(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public n onCreateViewHolder(ViewGroup viewGroup) {
        return new n(LayoutInflater.from(this.mContext).inflate(d.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, n nVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, nVar);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.eDo.getLayoutMode().ah(this.mSkinType == 1);
        this.eDo.getLayoutMode().t(view);
        if (this.aTt != null) {
            view.setOnClickListener(this.aTt);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aTt = onClickListener;
    }
}
