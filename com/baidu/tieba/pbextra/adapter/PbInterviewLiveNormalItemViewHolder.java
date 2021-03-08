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
    public TbRichTextView lSH;
    public TbImageView mrL;
    public View mrM;
    public PbGiftListView mrN;
    public FrsPraiseView mrO;
    public ImageView mrP;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mrL = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mrL.setSupportNoImage(true);
        this.mrL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mrL.setOnClickListener(this);
        this.mrL.setInterceptOnClick(true);
        this.mrL.setDefaultResource(R.drawable.icon_click);
        this.lSH = (TbRichTextView) view.findViewById(R.id.richText);
        this.mrM = view.findViewById(R.id.pb_item_praise_topline);
        this.mrO = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mrP = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mrN = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lSH.getLayoutStrategy().setSupportNoImage();
        this.lSH.getLayoutStrategy().lK(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lSH.getPaddingLeft()) - this.lSH.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lSH.getLayoutStrategy().sa(min);
        this.lSH.getLayoutStrategy().sb((int) (min * 1.618f));
        this.lSH.setTextSize(TbConfig.getContentSize());
        this.lSH.setDisplayImage(z2, false);
        this.lSH.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
