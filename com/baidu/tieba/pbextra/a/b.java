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
    public TbRichTextView fPS;
    public TbImageView gfQ;
    public View gfR;
    public PbGiftListView gfS;
    public FrsPraiseView gfT;
    public ImageView gfU;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.gfQ = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.gfQ.setSupportNoImage(true);
        this.gfQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfQ.setOnClickListener(this);
        this.gfQ.setInterceptOnClick(true);
        this.gfQ.setDefaultResource(e.f.icon_click);
        this.fPS = (TbRichTextView) view.findViewById(e.g.richText);
        this.gfR = view.findViewById(e.g.pb_item_praise_topline);
        this.gfT = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gfU = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gfS = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fPS.getLayoutStrategy().setSupportNoImage();
        this.fPS.getLayoutStrategy().cZ(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fPS.getPaddingLeft()) - this.fPS.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.ds60)), i);
        this.fPS.getLayoutStrategy().gw(min);
        this.fPS.getLayoutStrategy().gx((int) (min * 1.618f));
        this.fPS.setTextSize(TbConfig.getContentSize());
        this.fPS.setDisplayImage(z2, false);
        this.fPS.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
