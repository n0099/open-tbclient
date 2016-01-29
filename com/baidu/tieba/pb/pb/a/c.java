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
    public TbImageView cKh;
    public TbRichTextView cKi;
    public View cKj;
    public PbGiftListView cKk;
    public FrsPraiseView cKl;
    public ImageView cKm;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [44=5] */
    public c(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.cKh = (TbImageView) view.findViewById(t.g.interview_live_post_pic);
        this.cKh.setSupportNoImage(true);
        this.cKh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cKh.setOnClickListener(this);
        this.cKh.setInterceptOnClick(true);
        this.cKh.setDefaultResource(t.f.icon_click);
        this.cKi = (TbRichTextView) view.findViewById(t.g.richText);
        this.cKj = view.findViewById(t.g.pb_item_praise_topline);
        this.cKl = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.cKm = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.cKk = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.cKi.HC();
        this.cKi.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.cKi.getPaddingLeft()) - this.cKi.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.cKi.setMaxImageWidth(min);
        this.cKi.setMaxImageHeight((int) (min * 1.618f));
        this.cKi.setTextSize(TbConfig.getContentSize());
        this.cKi.g(z2, false);
        this.cKi.setVoiceViewRes(t.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
