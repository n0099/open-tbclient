package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes16.dex */
public class b extends ad.a implements View.OnClickListener {
    public TbImageView kKQ;
    public View kKR;
    public PbGiftListView kKS;
    public FrsPraiseView kKT;
    public ImageView kKU;
    public TbRichTextView knb;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.kKQ = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.kKQ.setSupportNoImage(true);
        this.kKQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kKQ.setOnClickListener(this);
        this.kKQ.setInterceptOnClick(true);
        this.kKQ.setDefaultResource(R.drawable.icon_click);
        this.knb = (TbRichTextView) view.findViewById(R.id.richText);
        this.kKR = view.findViewById(R.id.pb_item_praise_topline);
        this.kKT = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.kKU = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.kKS = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.knb.getLayoutStrategy().setSupportNoImage();
        this.knb.getLayoutStrategy().jy(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.knb.getPaddingLeft()) - this.knb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.knb.getLayoutStrategy().oR(min);
        this.knb.getLayoutStrategy().oS((int) (min * 1.618f));
        this.knb.setTextSize(TbConfig.getContentSize());
        this.knb.setDisplayImage(z2, false);
        this.knb.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
