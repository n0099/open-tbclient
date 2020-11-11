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
/* loaded from: classes22.dex */
public class b extends af.a implements View.OnClickListener {
    public TbImageView lRo;
    public View lRp;
    public PbGiftListView lRq;
    public FrsPraiseView lRr;
    public ImageView lRs;
    public TbRichTextView lsI;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.lRo = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.lRo.setSupportNoImage(true);
        this.lRo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lRo.setOnClickListener(this);
        this.lRo.setInterceptOnClick(true);
        this.lRo.setDefaultResource(R.drawable.icon_click);
        this.lsI = (TbRichTextView) view.findViewById(R.id.richText);
        this.lRp = view.findViewById(R.id.pb_item_praise_topline);
        this.lRr = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.lRs = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.lRq = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lsI.getLayoutStrategy().setSupportNoImage();
        this.lsI.getLayoutStrategy().kT(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lsI.getPaddingLeft()) - this.lsI.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lsI.getLayoutStrategy().sn(min);
        this.lsI.getLayoutStrategy().so((int) (min * 1.618f));
        this.lsI.setTextSize(TbConfig.getContentSize());
        this.lsI.setDisplayImage(z2, false);
        this.lsI.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
