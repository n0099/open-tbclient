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
    public TbRichTextView hOw;
    public TbImageView ieV;
    public View ieW;
    public PbGiftListView ieX;
    public FrsPraiseView ieY;
    public ImageView ieZ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ieV = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.ieV.setSupportNoImage(true);
        this.ieV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ieV.setOnClickListener(this);
        this.ieV.setInterceptOnClick(true);
        this.ieV.setDefaultResource(R.drawable.icon_click);
        this.hOw = (TbRichTextView) view.findViewById(R.id.richText);
        this.ieW = view.findViewById(R.id.pb_item_praise_topline);
        this.ieY = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.ieZ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.ieX = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hOw.getLayoutStrategy().setSupportNoImage();
        this.hOw.getLayoutStrategy().fU(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hOw.getPaddingLeft()) - this.hOw.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hOw.getLayoutStrategy().lt(min);
        this.hOw.getLayoutStrategy().lu((int) (min * 1.618f));
        this.hOw.setTextSize(TbConfig.getContentSize());
        this.hOw.setDisplayImage(z2, false);
        this.hOw.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
