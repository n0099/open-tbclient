package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f19655e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f19656f;

    /* renamed from: g  reason: collision with root package name */
    public View f19657g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f19658h;

    /* renamed from: i  reason: collision with root package name */
    public FrsPraiseView f19659i;
    public ImageView j;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i2, boolean z3) {
        super(view);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f19655e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f19655e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f19655e.setOnClickListener(this);
        this.f19655e.setInterceptOnClick(true);
        this.f19655e.setDefaultResource(R.drawable.icon_click);
        this.f19656f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f19657g = view.findViewById(R.id.pb_item_praise_topline);
        this.f19659i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f19658h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f19656f.getLayoutStrategy().t();
        this.f19656f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f19656f.getPaddingLeft()) - this.f19656f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.f19656f.getLayoutStrategy().q(min);
        this.f19656f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f19656f.setTextSize(TbConfig.getContentSize());
        this.f19656f.setDisplayImage(z2, false);
        this.f19656f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
