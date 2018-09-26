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
    public TbRichTextView fGR;
    public TbImageView fWS;
    public View fWT;
    public PbGiftListView fWU;
    public FrsPraiseView fWV;
    public ImageView fWW;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.fWS = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.fWS.setSupportNoImage(true);
        this.fWS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fWS.setOnClickListener(this);
        this.fWS.setInterceptOnClick(true);
        this.fWS.setDefaultResource(e.f.icon_click);
        this.fGR = (TbRichTextView) view.findViewById(e.g.richText);
        this.fWT = view.findViewById(e.g.pb_item_praise_topline);
        this.fWV = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.fWW = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.fWU = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fGR.getLayoutStrategy().setSupportNoImage();
        this.fGR.getLayoutStrategy().cz(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fGR.getPaddingLeft()) - this.fGR.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0141e.ds60)), i);
        this.fGR.getLayoutStrategy().ga(min);
        this.fGR.getLayoutStrategy().gb((int) (min * 1.618f));
        this.fGR.setTextSize(TbConfig.getContentSize());
        this.fGR.setDisplayImage(z2, false);
        this.fGR.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
