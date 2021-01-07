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
    public TbRichTextView lMa;
    public TbImageView mkX;
    public View mkY;
    public PbGiftListView mkZ;
    public FrsPraiseView mla;
    public ImageView mlb;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mkX = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mkX.setSupportNoImage(true);
        this.mkX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mkX.setOnClickListener(this);
        this.mkX.setInterceptOnClick(true);
        this.mkX.setDefaultResource(R.drawable.icon_click);
        this.lMa = (TbRichTextView) view.findViewById(R.id.richText);
        this.mkY = view.findViewById(R.id.pb_item_praise_topline);
        this.mla = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mlb = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mkZ = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lMa.getLayoutStrategy().setSupportNoImage();
        this.lMa.getLayoutStrategy().lK(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lMa.getPaddingLeft()) - this.lMa.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lMa.getLayoutStrategy().tz(min);
        this.lMa.getLayoutStrategy().tA((int) (min * 1.618f));
        this.lMa.setTextSize(TbConfig.getContentSize());
        this.lMa.setDisplayImage(z2, false);
        this.lMa.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
