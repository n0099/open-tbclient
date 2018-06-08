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
    public FrsPraiseView fLA;
    public ImageView fLB;
    public TbImageView fLy;
    public View fLz;
    public TbRichTextView fvm;
    public PbGiftListView fvn;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.fLy = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.fLy.setSupportNoImage(true);
        this.fLy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fLy.setOnClickListener(this);
        this.fLy.setInterceptOnClick(true);
        this.fLy.setDefaultResource(d.f.icon_click);
        this.fvm = (TbRichTextView) view.findViewById(d.g.richText);
        this.fLz = view.findViewById(d.g.pb_item_praise_topline);
        this.fLA = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.fLB = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.fvn = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fvm.getLayoutStrategy().setSupportNoImage();
        this.fvm.getLayoutStrategy().cj(true);
        int min = Math.min(((((l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fvm.getPaddingLeft()) - this.fvm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fvm.getLayoutStrategy().fN(min);
        this.fvm.getLayoutStrategy().fO((int) (min * 1.618f));
        this.fvm.setTextSize(TbConfig.getContentSize());
        this.fvm.setDisplayImage(z2, false);
        this.fvm.setVoiceViewRes(d.i.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
