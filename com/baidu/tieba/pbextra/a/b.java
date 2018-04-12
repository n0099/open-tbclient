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
    public TbRichTextView fiN;
    public PbGiftListView fiO;
    public TbImageView fza;
    public View fzb;
    public FrsPraiseView fzc;
    public ImageView fzd;

    public b(View view2, boolean z, boolean z2, int i, boolean z3) {
        super(view2);
        this.fza = (TbImageView) view2.findViewById(d.g.interview_live_post_pic);
        this.fza.setSupportNoImage(true);
        this.fza.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fza.setOnClickListener(this);
        this.fza.setInterceptOnClick(true);
        this.fza.setDefaultResource(d.f.icon_click);
        this.fiN = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fzb = view2.findViewById(d.g.pb_item_praise_topline);
        this.fzc = (FrsPraiseView) view2.findViewById(d.g.pb_item_praise_view);
        this.fzd = (ImageView) view2.findViewById(d.g.pb_item_praise_bottomline);
        this.fiO = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fiN.getLayoutStrategy().setSupportNoImage();
        this.fiN.getLayoutStrategy().ce(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fiN.getPaddingLeft()) - this.fiN.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fiN.getLayoutStrategy().fM(min);
        this.fiN.getLayoutStrategy().fN((int) (min * 1.618f));
        this.fiN.setTextSize(TbConfig.getContentSize());
        this.fiN.setDisplayImage(z2, false);
        this.fiN.setVoiceViewRes(d.i.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
