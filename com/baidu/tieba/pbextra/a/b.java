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
    public TbRichTextView fZA;
    public PbGiftListView gpA;
    public FrsPraiseView gpB;
    public ImageView gpC;
    public TbImageView gpy;
    public View gpz;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.gpy = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.gpy.setSupportNoImage(true);
        this.gpy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gpy.setOnClickListener(this);
        this.gpy.setInterceptOnClick(true);
        this.gpy.setDefaultResource(e.f.icon_click);
        this.fZA = (TbRichTextView) view.findViewById(e.g.richText);
        this.gpz = view.findViewById(e.g.pb_item_praise_topline);
        this.gpB = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gpC = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gpA = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.fZA.getLayoutStrategy().setSupportNoImage();
        this.fZA.getLayoutStrategy().da(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fZA.getPaddingLeft()) - this.fZA.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.fZA.getLayoutStrategy().gL(min);
        this.fZA.getLayoutStrategy().gM((int) (min * 1.618f));
        this.fZA.setTextSize(TbConfig.getContentSize());
        this.fZA.setDisplayImage(z2, false);
        this.fZA.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
