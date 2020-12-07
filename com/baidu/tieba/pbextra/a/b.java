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
    public TbRichTextView lGK;
    public TbImageView mfJ;
    public View mfK;
    public PbGiftListView mfL;
    public FrsPraiseView mfM;
    public ImageView mfN;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mfJ = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mfJ.setSupportNoImage(true);
        this.mfJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mfJ.setOnClickListener(this);
        this.mfJ.setInterceptOnClick(true);
        this.mfJ.setDefaultResource(R.drawable.icon_click);
        this.lGK = (TbRichTextView) view.findViewById(R.id.richText);
        this.mfK = view.findViewById(R.id.pb_item_praise_topline);
        this.mfM = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mfN = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mfL = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lGK.getLayoutStrategy().setSupportNoImage();
        this.lGK.getLayoutStrategy().lo(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lGK.getPaddingLeft()) - this.lGK.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lGK.getLayoutStrategy().to(min);
        this.lGK.getLayoutStrategy().tp((int) (min * 1.618f));
        this.lGK.setTextSize(TbConfig.getContentSize());
        this.lGK.setDisplayImage(z2, false);
        this.lGK.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
