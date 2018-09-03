package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes3.dex */
public class b extends q.a implements View.OnClickListener {
    public TbImageView fPC;
    public View fPD;
    public PbGiftListView fPE;
    public FrsPraiseView fPF;
    public ImageView fPG;
    public TbRichTextView fzf;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.fPC = (TbImageView) view.findViewById(f.g.interview_live_post_pic);
        this.fPC.setSupportNoImage(true);
        this.fPC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fPC.setOnClickListener(this);
        this.fPC.setInterceptOnClick(true);
        this.fPC.setDefaultResource(f.C0146f.icon_click);
        this.fzf = (TbRichTextView) view.findViewById(f.g.richText);
        this.fPD = view.findViewById(f.g.pb_item_praise_topline);
        this.fPF = (FrsPraiseView) view.findViewById(f.g.pb_item_praise_view);
        this.fPG = (ImageView) view.findViewById(f.g.pb_item_praise_bottomline);
        this.fPE = (PbGiftListView) view.findViewById(f.g.gift_list_view);
        this.fzf.getLayoutStrategy().setSupportNoImage();
        this.fzf.getLayoutStrategy().cn(true);
        int min = Math.min(((((l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fzf.getPaddingLeft()) - this.fzf.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(f.e.ds60)), i);
        this.fzf.getLayoutStrategy().fO(min);
        this.fzf.getLayoutStrategy().fP((int) (min * 1.618f));
        this.fzf.setTextSize(TbConfig.getContentSize());
        this.fzf.setDisplayImage(z2, false);
        this.fzf.setVoiceViewRes(f.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
