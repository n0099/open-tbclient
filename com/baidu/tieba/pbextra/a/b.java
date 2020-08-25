package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes16.dex */
public class b extends af.a implements View.OnClickListener {
    public TbRichTextView kCs;
    public TbImageView laF;
    public View laG;
    public PbGiftListView laH;
    public FrsPraiseView laI;
    public ImageView laJ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.laF = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.laF.setSupportNoImage(true);
        this.laF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.laF.setOnClickListener(this);
        this.laF.setInterceptOnClick(true);
        this.laF.setDefaultResource(R.drawable.icon_click);
        this.kCs = (TbRichTextView) view.findViewById(R.id.richText);
        this.laG = view.findViewById(R.id.pb_item_praise_topline);
        this.laI = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.laJ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.laH = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.kCs.getLayoutStrategy().setSupportNoImage();
        this.kCs.getLayoutStrategy().jW(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kCs.getPaddingLeft()) - this.kCs.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.kCs.getLayoutStrategy().rd(min);
        this.kCs.getLayoutStrategy().re((int) (min * 1.618f));
        this.kCs.setTextSize(TbConfig.getContentSize());
        this.kCs.setDisplayImage(z2, false);
        this.kCs.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
