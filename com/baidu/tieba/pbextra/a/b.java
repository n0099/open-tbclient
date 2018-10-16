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
    public TbRichTextView fOs;
    public TbImageView get;
    public View geu;
    public PbGiftListView gev;
    public FrsPraiseView gew;
    public ImageView gex;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.get = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.get.setSupportNoImage(true);
        this.get.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.get.setOnClickListener(this);
        this.get.setInterceptOnClick(true);
        this.get.setDefaultResource(e.f.icon_click);
        this.fOs = (TbRichTextView) view.findViewById(e.g.richText);
        this.geu = view.findViewById(e.g.pb_item_praise_topline);
        this.gew = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gex = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gev = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fOs.getLayoutStrategy().setSupportNoImage();
        this.fOs.getLayoutStrategy().cI(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fOs.getPaddingLeft()) - this.fOs.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds60)), i);
        this.fOs.getLayoutStrategy().gi(min);
        this.fOs.getLayoutStrategy().gj((int) (min * 1.618f));
        this.fOs.setTextSize(TbConfig.getContentSize());
        this.fOs.setDisplayImage(z2, false);
        this.fOs.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
