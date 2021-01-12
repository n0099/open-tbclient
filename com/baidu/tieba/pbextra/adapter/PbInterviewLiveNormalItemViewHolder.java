package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes2.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public TbRichTextView lHw;
    public TbImageView mgr;
    public View mgs;
    public PbGiftListView mgt;
    public FrsPraiseView mgu;
    public ImageView mgv;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mgr = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mgr.setSupportNoImage(true);
        this.mgr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mgr.setOnClickListener(this);
        this.mgr.setInterceptOnClick(true);
        this.mgr.setDefaultResource(R.drawable.icon_click);
        this.lHw = (TbRichTextView) view.findViewById(R.id.richText);
        this.mgs = view.findViewById(R.id.pb_item_praise_topline);
        this.mgu = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mgv = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mgt = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lHw.getLayoutStrategy().setSupportNoImage();
        this.lHw.getLayoutStrategy().lG(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lHw.getPaddingLeft()) - this.lHw.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lHw.getLayoutStrategy().rT(min);
        this.lHw.getLayoutStrategy().rU((int) (min * 1.618f));
        this.lHw.setTextSize(TbConfig.getContentSize());
        this.lHw.setDisplayImage(z2, false);
        this.lHw.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
