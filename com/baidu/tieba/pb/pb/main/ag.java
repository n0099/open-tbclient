package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
/* loaded from: classes2.dex */
public class ag extends l<com.baidu.tieba.pb.data.l, PbNoDataItemViewHolder> {
    public ag(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public PbNoDataItemViewHolder e(ViewGroup viewGroup) {
        return new PbNoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tieba.pb.data.l) pbNoDataItemViewHolder);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        pbNoDataItemViewHolder.mTextView.setText(lVar.lHb);
        if (lVar.lHa != 0) {
            com.baidu.tbadk.core.util.ao.setImageResource(pbNoDataItemViewHolder.mImageView, lVar.lHa);
        } else {
            com.baidu.tbadk.core.util.ao.setImageResource(pbNoDataItemViewHolder.mImageView, R.drawable.new_pic_emotion_06);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(pbNoDataItemViewHolder.mTextView, R.color.CAM_X0109);
        if (lVar.gCu != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.gCu;
        }
        if (lVar.lHc != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mImageView.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.lHc, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.lHd != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mTextView.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.leftMargin, marginLayoutParams2.rightMargin, lVar.lHd);
        }
        pbNoDataItemViewHolder.mImageView.setVisibility(lVar.lHe);
        return view;
    }
}
