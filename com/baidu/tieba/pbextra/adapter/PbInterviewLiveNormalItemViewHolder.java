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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20170e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f20171f;

    /* renamed from: g  reason: collision with root package name */
    public View f20172g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f20173h;
    public FrsPraiseView i;
    public ImageView j;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f20170e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f20170e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20170e.setOnClickListener(this);
        this.f20170e.setInterceptOnClick(true);
        this.f20170e.setDefaultResource(R.drawable.icon_click);
        this.f20171f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f20172g = view.findViewById(R.id.pb_item_praise_topline);
        this.i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f20173h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f20171f.getLayoutStrategy().t();
        this.f20171f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f20171f.getPaddingLeft()) - this.f20171f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.f20171f.getLayoutStrategy().q(min);
        this.f20171f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f20171f.setTextSize(TbConfig.getContentSize());
        this.f20171f.setDisplayImage(z2, false);
        this.f20171f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
