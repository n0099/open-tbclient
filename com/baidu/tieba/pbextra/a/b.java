package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes9.dex */
public class b extends y.a implements View.OnClickListener {
    public TbImageView jOX;
    public View jOY;
    public PbGiftListView jOZ;
    public FrsPraiseView jPa;
    public ImageView jPb;
    public TbRichTextView jsw;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jOX = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jOX.setSupportNoImage(true);
        this.jOX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jOX.setOnClickListener(this);
        this.jOX.setInterceptOnClick(true);
        this.jOX.setDefaultResource(R.drawable.icon_click);
        this.jsw = (TbRichTextView) view.findViewById(R.id.richText);
        this.jOY = view.findViewById(R.id.pb_item_praise_topline);
        this.jPa = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jPb = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jOZ = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.jsw.getLayoutStrategy().setSupportNoImage();
        this.jsw.getLayoutStrategy().ik(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jsw.getPaddingLeft()) - this.jsw.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.jsw.getLayoutStrategy().nw(min);
        this.jsw.getLayoutStrategy().nx((int) (min * 1.618f));
        this.jsw.setTextSize(TbConfig.getContentSize());
        this.jsw.setDisplayImage(z2, false);
        this.jsw.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
