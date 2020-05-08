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
    public TbImageView jPb;
    public View jPc;
    public PbGiftListView jPd;
    public FrsPraiseView jPe;
    public ImageView jPf;
    public TbRichTextView jsA;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jPb = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jPb.setSupportNoImage(true);
        this.jPb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jPb.setOnClickListener(this);
        this.jPb.setInterceptOnClick(true);
        this.jPb.setDefaultResource(R.drawable.icon_click);
        this.jsA = (TbRichTextView) view.findViewById(R.id.richText);
        this.jPc = view.findViewById(R.id.pb_item_praise_topline);
        this.jPe = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jPf = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jPd = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.jsA.getLayoutStrategy().setSupportNoImage();
        this.jsA.getLayoutStrategy().ik(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jsA.getPaddingLeft()) - this.jsA.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.jsA.getLayoutStrategy().nw(min);
        this.jsA.getLayoutStrategy().nx((int) (min * 1.618f));
        this.jsA.setTextSize(TbConfig.getContentSize());
        this.jsA.setDisplayImage(z2, false);
        this.jsA.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
