package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes3.dex */
public class b extends q.a implements View.OnClickListener {
    public TbRichTextView fWI;
    public TbImageView gmH;
    public View gmI;
    public PbGiftListView gmJ;
    public FrsPraiseView gmK;
    public ImageView gmL;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.gmH = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.gmH.setSupportNoImage(true);
        this.gmH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gmH.setOnClickListener(this);
        this.gmH.setInterceptOnClick(true);
        this.gmH.setDefaultResource(e.f.icon_click);
        this.fWI = (TbRichTextView) view.findViewById(e.g.richText);
        this.gmI = view.findViewById(e.g.pb_item_praise_topline);
        this.gmK = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gmL = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gmJ = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fWI.getLayoutStrategy().setSupportNoImage();
        this.fWI.getLayoutStrategy().da(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fWI.getPaddingLeft()) - this.fWI.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.fWI.getLayoutStrategy().gK(min);
        this.fWI.getLayoutStrategy().gL((int) (min * 1.618f));
        this.fWI.setTextSize(TbConfig.getContentSize());
        this.fWI.setDisplayImage(z2, false);
        this.fWI.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
