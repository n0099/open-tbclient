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
/* loaded from: classes3.dex */
public class PbInterviewLiveNormalItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20368e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f20369f;

    /* renamed from: g  reason: collision with root package name */
    public View f20370g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f20371h;

    /* renamed from: i  reason: collision with root package name */
    public FrsPraiseView f20372i;
    public ImageView j;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i2, boolean z3) {
        super(view);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f20368e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f20368e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20368e.setOnClickListener(this);
        this.f20368e.setInterceptOnClick(true);
        this.f20368e.setDefaultResource(R.drawable.icon_click);
        this.f20369f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f20370g = view.findViewById(R.id.pb_item_praise_topline);
        this.f20372i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f20371h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f20369f.getLayoutStrategy().t();
        this.f20369f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f20369f.getPaddingLeft()) - this.f20369f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.f20369f.getLayoutStrategy().q(min);
        this.f20369f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f20369f.setTextSize(TbConfig.getContentSize());
        this.f20369f.setDisplayImage(z2, false);
        this.f20369f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
