package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes2.dex */
public class a extends l<b, GodReplyMoreViewHolder> {
    public View.OnClickListener gmj;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cH */
    public GodReplyMoreViewHolder e(ViewGroup viewGroup) {
        return new GodReplyMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) godReplyMoreViewHolder);
        if (godReplyMoreViewHolder != null && godReplyMoreViewHolder.iwi != null) {
            if (this.gmj != null) {
                godReplyMoreViewHolder.iwi.setOnClickListener(this.gmj);
            }
            if (godReplyMoreViewHolder.akW != TbadkCoreApplication.getInst().getSkinType()) {
                godReplyMoreViewHolder.akW = TbadkCoreApplication.getInst().getSkinType();
                ao.setViewTextColor(godReplyMoreViewHolder.iwi, R.color.CAM_X0106);
                ao.setBackgroundResource(godReplyMoreViewHolder.iwi, R.drawable.more_all);
                ao.setBackgroundResource(godReplyMoreViewHolder.dividerLine, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gmj = onClickListener;
    }
}
