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
    public TbRichTextView fJm;
    public FrsPraiseView fJn;
    public ImageView fJo;
    public PbGiftListView fJp;
    public TbImageView geE;
    public View geF;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.geE = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.geE.setSupportNoImage(true);
        this.geE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.geE.setOnClickListener(this);
        this.geE.setInterceptOnClick(true);
        this.geE.setDefaultResource(d.f.icon_click);
        this.fJm = (TbRichTextView) view.findViewById(d.g.richText);
        this.geF = view.findViewById(d.g.pb_item_praise_topline);
        this.fJn = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.fJo = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.fJp = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fJm.getLayoutStrategy().Rh();
        this.fJm.getLayoutStrategy().cM(true);
        int min = Math.min(((((l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fJm.getPaddingLeft()) - this.fJm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fJm.getLayoutStrategy().iL(min);
        this.fJm.getLayoutStrategy().iM((int) (min * 1.618f));
        this.fJm.setTextSize(TbConfig.getContentSize());
        this.fJm.o(z2, false);
        this.fJm.setVoiceViewRes(d.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
