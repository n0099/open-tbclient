package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class c extends x.a implements View.OnClickListener {
    public TbRichTextView ddA;
    public View ddB;
    public PbGiftListView ddC;
    public FrsPraiseView ddD;
    public ImageView ddE;
    public TbImageView ddz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [45=5] */
    public c(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ddz = (TbImageView) view.findViewById(t.g.interview_live_post_pic);
        this.ddz.setSupportNoImage(true);
        this.ddz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddz.setOnClickListener(this);
        this.ddz.setInterceptOnClick(true);
        this.ddz.setDefaultResource(t.f.icon_click);
        this.ddA = (TbRichTextView) view.findViewById(t.g.richText);
        this.ddB = view.findViewById(t.g.pb_item_praise_topline);
        this.ddD = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.ddE = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.ddC = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.ddA.IY();
        this.ddA.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ddA.getPaddingLeft()) - this.ddA.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.ddA.setMaxImageWidth(min);
        this.ddA.setMaxImageHeight((int) (min * 1.618f));
        this.ddA.setTextSize(TbConfig.getContentSize());
        this.ddA.h(z2, false);
        this.ddA.setVoiceViewRes(t.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
