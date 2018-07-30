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
    public TbImageView fPK;
    public View fPL;
    public PbGiftListView fPM;
    public FrsPraiseView fPN;
    public ImageView fPO;
    public TbRichTextView fzm;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.fPK = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.fPK.setSupportNoImage(true);
        this.fPK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fPK.setOnClickListener(this);
        this.fPK.setInterceptOnClick(true);
        this.fPK.setDefaultResource(d.f.icon_click);
        this.fzm = (TbRichTextView) view.findViewById(d.g.richText);
        this.fPL = view.findViewById(d.g.pb_item_praise_topline);
        this.fPN = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.fPO = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.fPM = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fzm.getLayoutStrategy().setSupportNoImage();
        this.fzm.getLayoutStrategy().cm(true);
        int min = Math.min(((((l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fzm.getPaddingLeft()) - this.fzm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fzm.getLayoutStrategy().fP(min);
        this.fzm.getLayoutStrategy().fQ((int) (min * 1.618f));
        this.fzm.setTextSize(TbConfig.getContentSize());
        this.fzm.setDisplayImage(z2, false);
        this.fzm.setVoiceViewRes(d.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
