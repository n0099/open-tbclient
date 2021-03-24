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
    public TbImageView f20169e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f20170f;

    /* renamed from: g  reason: collision with root package name */
    public View f20171g;

    /* renamed from: h  reason: collision with root package name */
    public PbGiftListView f20172h;
    public FrsPraiseView i;
    public ImageView j;

    public PbInterviewLiveNormalItemViewHolder(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.f20169e = tbImageView;
        tbImageView.setSupportNoImage(true);
        this.f20169e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20169e.setOnClickListener(this);
        this.f20169e.setInterceptOnClick(true);
        this.f20169e.setDefaultResource(R.drawable.icon_click);
        this.f20170f = (TbRichTextView) view.findViewById(R.id.richText);
        this.f20171g = view.findViewById(R.id.pb_item_praise_topline);
        this.i = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.j = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.f20172h = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.f20170f.getLayoutStrategy().t();
        this.f20170f.getLayoutStrategy().k(true);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f20170f.getPaddingLeft()) - this.f20170f.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.f20170f.getLayoutStrategy().q(min);
        this.f20170f.getLayoutStrategy().p((int) (min * 1.618f));
        this.f20170f.setTextSize(TbConfig.getContentSize());
        this.f20170f.setDisplayImage(z2, false);
        this.f20170f.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
