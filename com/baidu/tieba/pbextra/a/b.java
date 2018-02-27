package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes3.dex */
public class b extends r.a implements View.OnClickListener {
    public TbRichTextView fJb;
    public FrsPraiseView fJc;
    public ImageView fJd;
    public PbGiftListView fJe;
    public TbImageView get;
    public View geu;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.get = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.get.setSupportNoImage(true);
        this.get.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.get.setOnClickListener(this);
        this.get.setInterceptOnClick(true);
        this.get.setDefaultResource(d.f.icon_click);
        this.fJb = (TbRichTextView) view.findViewById(d.g.richText);
        this.geu = view.findViewById(d.g.pb_item_praise_topline);
        this.fJc = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.fJd = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.fJe = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fJb.getLayoutStrategy().Rg();
        this.fJb.getLayoutStrategy().cM(true);
        int min = Math.min(((((l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fJb.getPaddingLeft()) - this.fJb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fJb.getLayoutStrategy().iL(min);
        this.fJb.getLayoutStrategy().iM((int) (min * 1.618f));
        this.fJb.setTextSize(TbConfig.getContentSize());
        this.fJb.o(z2, false);
        this.fJb.setVoiceViewRes(d.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
