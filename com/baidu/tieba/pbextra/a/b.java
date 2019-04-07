package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes4.dex */
public class b extends v.a implements View.OnClickListener {
    public TbImageView hGA;
    public View hGB;
    public PbGiftListView hGC;
    public FrsPraiseView hGD;
    public ImageView hGE;
    public TbRichTextView hqC;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.hGA = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.hGA.setSupportNoImage(true);
        this.hGA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hGA.setOnClickListener(this);
        this.hGA.setInterceptOnClick(true);
        this.hGA.setDefaultResource(d.f.icon_click);
        this.hqC = (TbRichTextView) view.findViewById(d.g.richText);
        this.hGB = view.findViewById(d.g.pb_item_praise_topline);
        this.hGD = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.hGE = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.hGC = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.hqC.getLayoutStrategy().setSupportNoImage();
        this.hqC.getLayoutStrategy().ft(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqC.getPaddingLeft()) - this.hqC.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqC.getLayoutStrategy().ky(min);
        this.hqC.getLayoutStrategy().kz((int) (min * 1.618f));
        this.hqC.setTextSize(TbConfig.getContentSize());
        this.hqC.setDisplayImage(z2, false);
        this.hqC.setVoiceViewRes(d.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
