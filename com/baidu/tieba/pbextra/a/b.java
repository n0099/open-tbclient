package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes4.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView hIj;
    public TbImageView hYF;
    public View hYG;
    public PbGiftListView hYH;
    public FrsPraiseView hYI;
    public ImageView hYJ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.hYF = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.hYF.setSupportNoImage(true);
        this.hYF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hYF.setOnClickListener(this);
        this.hYF.setInterceptOnClick(true);
        this.hYF.setDefaultResource(R.drawable.icon_click);
        this.hIj = (TbRichTextView) view.findViewById(R.id.richText);
        this.hYG = view.findViewById(R.id.pb_item_praise_topline);
        this.hYI = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.hYJ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.hYH = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hIj.getLayoutStrategy().setSupportNoImage();
        this.hIj.getLayoutStrategy().fQ(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIj.getPaddingLeft()) - this.hIj.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIj.getLayoutStrategy().ln(min);
        this.hIj.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIj.setTextSize(TbConfig.getContentSize());
        this.hIj.setDisplayImage(z2, false);
        this.hIj.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
