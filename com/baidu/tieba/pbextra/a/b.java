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
    public TbRichTextView hRn;
    public TbImageView ihW;
    public View ihX;
    public PbGiftListView ihY;
    public FrsPraiseView ihZ;
    public ImageView iia;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ihW = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.ihW.setSupportNoImage(true);
        this.ihW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ihW.setOnClickListener(this);
        this.ihW.setInterceptOnClick(true);
        this.ihW.setDefaultResource(R.drawable.icon_click);
        this.hRn = (TbRichTextView) view.findViewById(R.id.richText);
        this.ihX = view.findViewById(R.id.pb_item_praise_topline);
        this.ihZ = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.iia = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.ihY = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hRn.getLayoutStrategy().setSupportNoImage();
        this.hRn.getLayoutStrategy().fX(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hRn.getPaddingLeft()) - this.hRn.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hRn.getLayoutStrategy().ly(min);
        this.hRn.getLayoutStrategy().lz((int) (min * 1.618f));
        this.hRn.setTextSize(TbConfig.getContentSize());
        this.hRn.setDisplayImage(z2, false);
        this.hRn.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
