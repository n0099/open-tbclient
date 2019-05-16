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
    public TbRichTextView hIf;
    public TbImageView hYB;
    public View hYC;
    public PbGiftListView hYD;
    public FrsPraiseView hYE;
    public ImageView hYF;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.hYB = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.hYB.setSupportNoImage(true);
        this.hYB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hYB.setOnClickListener(this);
        this.hYB.setInterceptOnClick(true);
        this.hYB.setDefaultResource(R.drawable.icon_click);
        this.hIf = (TbRichTextView) view.findViewById(R.id.richText);
        this.hYC = view.findViewById(R.id.pb_item_praise_topline);
        this.hYE = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.hYF = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.hYD = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hIf.getLayoutStrategy().setSupportNoImage();
        this.hIf.getLayoutStrategy().fQ(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIf.getPaddingLeft()) - this.hIf.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIf.getLayoutStrategy().ln(min);
        this.hIf.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIf.setTextSize(TbConfig.getContentSize());
        this.hIf.setDisplayImage(z2, false);
        this.hIf.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
