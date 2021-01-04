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
    public TbRichTextView lMb;
    public TbImageView mkY;
    public View mkZ;
    public PbGiftListView mla;
    public FrsPraiseView mlb;
    public ImageView mlc;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mkY = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mkY.setSupportNoImage(true);
        this.mkY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mkY.setOnClickListener(this);
        this.mkY.setInterceptOnClick(true);
        this.mkY.setDefaultResource(R.drawable.icon_click);
        this.lMb = (TbRichTextView) view.findViewById(R.id.richText);
        this.mkZ = view.findViewById(R.id.pb_item_praise_topline);
        this.mlb = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mlc = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mla = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lMb.getLayoutStrategy().setSupportNoImage();
        this.lMb.getLayoutStrategy().lK(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lMb.getPaddingLeft()) - this.lMb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lMb.getLayoutStrategy().tz(min);
        this.lMb.getLayoutStrategy().tA((int) (min * 1.618f));
        this.lMb.setTextSize(TbConfig.getContentSize());
        this.lMb.setDisplayImage(z2, false);
        this.lMb.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
