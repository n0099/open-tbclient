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
    public TbRichTextView lQq;
    public TbImageView mpu;
    public View mpv;
    public PbGiftListView mpw;
    public FrsPraiseView mpx;
    public ImageView mpy;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mpu = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mpu.setSupportNoImage(true);
        this.mpu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mpu.setOnClickListener(this);
        this.mpu.setInterceptOnClick(true);
        this.mpu.setDefaultResource(R.drawable.icon_click);
        this.lQq = (TbRichTextView) view.findViewById(R.id.richText);
        this.mpv = view.findViewById(R.id.pb_item_praise_topline);
        this.mpx = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mpy = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mpw = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lQq.getLayoutStrategy().setSupportNoImage();
        this.lQq.getLayoutStrategy().lK(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lQq.getPaddingLeft()) - this.lQq.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lQq.getLayoutStrategy().rY(min);
        this.lQq.getLayoutStrategy().rZ((int) (min * 1.618f));
        this.lQq.setTextSize(TbConfig.getContentSize());
        this.lQq.setDisplayImage(z2, false);
        this.lQq.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
