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
    public TbRichTextView gay;
    public TbImageView gqD;
    public View gqE;
    public PbGiftListView gqF;
    public FrsPraiseView gqG;
    public ImageView gqH;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.gqD = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.gqD.setSupportNoImage(true);
        this.gqD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gqD.setOnClickListener(this);
        this.gqD.setInterceptOnClick(true);
        this.gqD.setDefaultResource(e.f.icon_click);
        this.gay = (TbRichTextView) view.findViewById(e.g.richText);
        this.gqE = view.findViewById(e.g.pb_item_praise_topline);
        this.gqG = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gqH = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gqF = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.gay.getLayoutStrategy().setSupportNoImage();
        this.gay.getLayoutStrategy().dd(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.gay.getPaddingLeft()) - this.gay.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.gay.getLayoutStrategy().gL(min);
        this.gay.getLayoutStrategy().gM((int) (min * 1.618f));
        this.gay.setTextSize(TbConfig.getContentSize());
        this.gay.setDisplayImage(z2, false);
        this.gay.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
