package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cz;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends cz<u, v> {
    public View.OnClickListener aOB;

    public t(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public v onCreateViewHolder(ViewGroup viewGroup) {
        return new v(LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, u uVar, v vVar) {
        super.onFillViewHolder(i, view, viewGroup, uVar, vVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.eka.getLayoutMode().ah(this.mSkinType == 1);
        this.eka.getLayoutMode().t(view);
        if (this.aOB != null) {
            view.setOnClickListener(this.aOB);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOB = onClickListener;
    }
}
