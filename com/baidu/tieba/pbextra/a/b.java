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
    public TbRichTextView hIi;
    public TbImageView hYE;
    public View hYF;
    public PbGiftListView hYG;
    public FrsPraiseView hYH;
    public ImageView hYI;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.hYE = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.hYE.setSupportNoImage(true);
        this.hYE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hYE.setOnClickListener(this);
        this.hYE.setInterceptOnClick(true);
        this.hYE.setDefaultResource(R.drawable.icon_click);
        this.hIi = (TbRichTextView) view.findViewById(R.id.richText);
        this.hYF = view.findViewById(R.id.pb_item_praise_topline);
        this.hYH = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.hYI = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.hYG = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hIi.getLayoutStrategy().setSupportNoImage();
        this.hIi.getLayoutStrategy().fQ(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIi.getPaddingLeft()) - this.hIi.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIi.getLayoutStrategy().ln(min);
        this.hIi.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIi.setTextSize(TbConfig.getContentSize());
        this.hIi.setDisplayImage(z2, false);
        this.hIi.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
