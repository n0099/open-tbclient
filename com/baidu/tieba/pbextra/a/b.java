package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes4.dex */
public class b extends v.a implements View.OnClickListener {
    public TbImageView hGO;
    public View hGP;
    public PbGiftListView hGQ;
    public FrsPraiseView hGR;
    public ImageView hGS;
    public TbRichTextView hqP;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.hGO = (TbImageView) view.findViewById(d.g.interview_live_post_pic);
        this.hGO.setSupportNoImage(true);
        this.hGO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hGO.setOnClickListener(this);
        this.hGO.setInterceptOnClick(true);
        this.hGO.setDefaultResource(d.f.icon_click);
        this.hqP = (TbRichTextView) view.findViewById(d.g.richText);
        this.hGP = view.findViewById(d.g.pb_item_praise_topline);
        this.hGR = (FrsPraiseView) view.findViewById(d.g.pb_item_praise_view);
        this.hGS = (ImageView) view.findViewById(d.g.pb_item_praise_bottomline);
        this.hGQ = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.hqP.getLayoutStrategy().setSupportNoImage();
        this.hqP.getLayoutStrategy().ft(true);
        int min = Math.min(((((l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqP.getPaddingLeft()) - this.hqP.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqP.getLayoutStrategy().kz(min);
        this.hqP.getLayoutStrategy().kA((int) (min * 1.618f));
        this.hqP.setTextSize(TbConfig.getContentSize());
        this.hqP.setDisplayImage(z2, false);
        this.hqP.setVoiceViewRes(d.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
