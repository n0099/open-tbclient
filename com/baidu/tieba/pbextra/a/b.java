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
    public TbRichTextView fOt;
    public TbImageView geu;
    public View gev;
    public PbGiftListView gew;
    public FrsPraiseView gex;
    public ImageView gey;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.geu = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.geu.setSupportNoImage(true);
        this.geu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.geu.setOnClickListener(this);
        this.geu.setInterceptOnClick(true);
        this.geu.setDefaultResource(e.f.icon_click);
        this.fOt = (TbRichTextView) view.findViewById(e.g.richText);
        this.gev = view.findViewById(e.g.pb_item_praise_topline);
        this.gex = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gey = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gew = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fOt.getLayoutStrategy().setSupportNoImage();
        this.fOt.getLayoutStrategy().cI(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fOt.getPaddingLeft()) - this.fOt.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds60)), i);
        this.fOt.getLayoutStrategy().gi(min);
        this.fOt.getLayoutStrategy().gj((int) (min * 1.618f));
        this.fOt.setTextSize(TbConfig.getContentSize());
        this.fOt.setDisplayImage(z2, false);
        this.fOt.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
