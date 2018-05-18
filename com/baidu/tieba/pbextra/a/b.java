package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes3.dex */
public class b extends q.a implements View.OnClickListener {
    public TbImageView fAd;
    public View fAe;
    public FrsPraiseView fAf;
    public ImageView fAg;
    public TbRichTextView fjR;
    public PbGiftListView fjS;

    public b(View view2, boolean z, boolean z2, int i, boolean z3) {
        super(view2);
        this.fAd = (TbImageView) view2.findViewById(d.g.interview_live_post_pic);
        this.fAd.setSupportNoImage(true);
        this.fAd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAd.setOnClickListener(this);
        this.fAd.setInterceptOnClick(true);
        this.fAd.setDefaultResource(d.f.icon_click);
        this.fjR = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fAe = view2.findViewById(d.g.pb_item_praise_topline);
        this.fAf = (FrsPraiseView) view2.findViewById(d.g.pb_item_praise_view);
        this.fAg = (ImageView) view2.findViewById(d.g.pb_item_praise_bottomline);
        this.fjS = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fjR.getLayoutStrategy().setSupportNoImage();
        this.fjR.getLayoutStrategy().ce(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fjR.getPaddingLeft()) - this.fjR.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fjR.getLayoutStrategy().fM(min);
        this.fjR.getLayoutStrategy().fN((int) (min * 1.618f));
        this.fjR.setTextSize(TbConfig.getContentSize());
        this.fjR.setDisplayImage(z2, false);
        this.fjR.setVoiceViewRes(d.i.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
