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
/* loaded from: classes7.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView iEW;
    public View jbA;
    public PbGiftListView jbB;
    public FrsPraiseView jbC;
    public ImageView jbD;
    public TbImageView jbz;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jbz = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jbz.setSupportNoImage(true);
        this.jbz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jbz.setOnClickListener(this);
        this.jbz.setInterceptOnClick(true);
        this.jbz.setDefaultResource(R.drawable.icon_click);
        this.iEW = (TbRichTextView) view.findViewById(R.id.richText);
        this.jbA = view.findViewById(R.id.pb_item_praise_topline);
        this.jbC = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jbD = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jbB = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iEW.getLayoutStrategy().setSupportNoImage();
        this.iEW.getLayoutStrategy().he(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iEW.getPaddingLeft()) - this.iEW.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iEW.getLayoutStrategy().mR(min);
        this.iEW.getLayoutStrategy().mS((int) (min * 1.618f));
        this.iEW.setTextSize(TbConfig.getContentSize());
        this.iEW.setDisplayImage(z2, false);
        this.iEW.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
