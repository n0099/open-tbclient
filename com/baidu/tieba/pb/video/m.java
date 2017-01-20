package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends da<n, o> {
    public View.OnClickListener aJe;

    public m(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(r.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, nVar, oVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.ehi.getLayoutMode().ai(this.mSkinType == 1);
        this.ehi.getLayoutMode().v(view);
        if (this.aJe != null) {
            view.setOnClickListener(this.aJe);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aJe = onClickListener;
    }
}
