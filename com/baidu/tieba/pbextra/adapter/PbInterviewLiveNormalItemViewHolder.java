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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f19862e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f19863f;

    /* renamed from: g  reason: collision with root package name */
    public View f19864g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f19865h;
    public FrsPraiseView i;
    public ImageView j;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f19862e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f19862e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f19862e.setOnClickListener(this);
        this.f19862e.setInterceptOnClick(true);
        this.f19862e.setDefaultResource(R.drawable.icon_click);
        this.f19863f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f19864g = view.findViewById(R.id.pb_item_praise_topline);
        this.i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f19865h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f19863f.getLayoutStrategy().t();
        this.f19863f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f19863f.getPaddingLeft()) - this.f19863f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.f19863f.getLayoutStrategy().q(min);
        this.f19863f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f19863f.setTextSize(TbConfig.getContentSize());
        this.f19863f.setDisplayImage(z2, false);
        this.f19863f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
