package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cx;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends cx<u, v> {
    public View.OnClickListener aOT;

    public t(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public v onCreateViewHolder(ViewGroup viewGroup) {
        return new v(LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, u uVar, v vVar) {
        super.onFillViewHolder(i, view, viewGroup, uVar, vVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.ekw.getLayoutMode().aj(this.mSkinType == 1);
        this.ekw.getLayoutMode().t(view);
        if (this.aOT != null) {
            view.setOnClickListener(this.aOT);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOT = onClickListener;
    }
}
