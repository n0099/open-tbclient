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
    public TbImageView fPA;
    public View fPB;
    public PbGiftListView fPC;
    public FrsPraiseView fPD;
    public ImageView fPE;
    public TbRichTextView fza;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.fPA = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.fPA.setSupportNoImage(true);
        this.fPA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fPA.setOnClickListener(this);
        this.fPA.setInterceptOnClick(true);
        this.fPA.setDefaultResource(d.f.icon_click);
        this.fza = (TbRichTextView) view.findViewById(d.g.richText);
        this.fPB = view.findViewById(d.g.pb_item_praise_topline);
        this.fPD = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.fPE = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.fPC = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fza.getLayoutStrategy().setSupportNoImage();
        this.fza.getLayoutStrategy().cm(true);
        int min = Math.min(((((l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fza.getPaddingLeft()) - this.fza.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fza.getLayoutStrategy().fO(min);
        this.fza.getLayoutStrategy().fP((int) (min * 1.618f));
        this.fza.setTextSize(TbConfig.getContentSize());
        this.fza.setDisplayImage(z2, false);
        this.fza.setVoiceViewRes(d.i.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
