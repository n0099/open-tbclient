package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ad extends dn<ae, af> {
    public View.OnClickListener aPl;

    public ad(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public af onCreateViewHolder(ViewGroup viewGroup) {
        return new af(LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ae aeVar, af afVar) {
        super.onFillViewHolder(i, view, viewGroup, aeVar, afVar);
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.elf.getLayoutMode().ah(this.mSkinType == 1);
        this.elf.getLayoutMode().t(view);
        if (this.aPl != null) {
            view.setOnClickListener(this.aPl);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPl = onClickListener;
    }
}
