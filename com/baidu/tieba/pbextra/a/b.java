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
/* loaded from: classes6.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView iBs;
    public TbImageView iXR;
    public View iXS;
    public PbGiftListView iXT;
    public FrsPraiseView iXU;
    public ImageView iXV;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.iXR = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.iXR.setSupportNoImage(true);
        this.iXR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iXR.setOnClickListener(this);
        this.iXR.setInterceptOnClick(true);
        this.iXR.setDefaultResource(R.drawable.icon_click);
        this.iBs = (TbRichTextView) view.findViewById(R.id.richText);
        this.iXS = view.findViewById(R.id.pb_item_praise_topline);
        this.iXU = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.iXV = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.iXT = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iBs.getLayoutStrategy().setSupportNoImage();
        this.iBs.getLayoutStrategy().gZ(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iBs.getPaddingLeft()) - this.iBs.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iBs.getLayoutStrategy().mR(min);
        this.iBs.getLayoutStrategy().mS((int) (min * 1.618f));
        this.iBs.setTextSize(TbConfig.getContentSize());
        this.iBs.setDisplayImage(z2, false);
        this.iBs.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
