package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class w extends dh<x, y> {
    public View.OnClickListener aPm;

    public w(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public y onCreateViewHolder(ViewGroup viewGroup) {
        return new y(LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        super.onFillViewHolder(i, view, viewGroup, xVar, yVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.efF.getLayoutMode().ai(this.mSkinType == 1);
        this.efF.getLayoutMode().t(view);
        if (this.aPm != null) {
            view.setOnClickListener(this.aPm);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPm = onClickListener;
    }
}
