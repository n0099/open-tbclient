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
    public TbRichTextView gax;
    public TbImageView gqC;
    public View gqD;
    public PbGiftListView gqE;
    public FrsPraiseView gqF;
    public ImageView gqG;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.gqC = (TbImageView) view.findViewById(e.g.interview_live_post_pic);
        this.gqC.setSupportNoImage(true);
        this.gqC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gqC.setOnClickListener(this);
        this.gqC.setInterceptOnClick(true);
        this.gqC.setDefaultResource(e.f.icon_click);
        this.gax = (TbRichTextView) view.findViewById(e.g.richText);
        this.gqD = view.findViewById(e.g.pb_item_praise_topline);
        this.gqF = (FrsPraiseView) view.findViewById(e.g.pb_item_praise_view);
        this.gqG = (ImageView) view.findViewById(e.g.pb_item_praise_bottomline);
        this.gqE = (PbGiftListView) view.findViewById(e.g.gift_list_view);
        this.gax.getLayoutStrategy().setSupportNoImage();
        this.gax.getLayoutStrategy().dd(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.gax.getPaddingLeft()) - this.gax.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.gax.getLayoutStrategy().gL(min);
        this.gax.getLayoutStrategy().gM((int) (min * 1.618f));
        this.gax.setTextSize(TbConfig.getContentSize());
        this.gax.setDisplayImage(z2, false);
        this.gax.setVoiceViewRes(e.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
