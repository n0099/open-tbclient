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
    public TbRichTextView lGM;
    public TbImageView mfL;
    public View mfM;
    public PbGiftListView mfN;
    public FrsPraiseView mfO;
    public ImageView mfP;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mfL = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.mfL.setSupportNoImage(true);
        this.mfL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mfL.setOnClickListener(this);
        this.mfL.setInterceptOnClick(true);
        this.mfL.setDefaultResource(R.drawable.icon_click);
        this.lGM = (TbRichTextView) view.findViewById(R.id.richText);
        this.mfM = view.findViewById(R.id.pb_item_praise_topline);
        this.mfO = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.mfP = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mfN = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lGM.getLayoutStrategy().setSupportNoImage();
        this.lGM.getLayoutStrategy().lo(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lGM.getPaddingLeft()) - this.lGM.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lGM.getLayoutStrategy().to(min);
        this.lGM.getLayoutStrategy().tp((int) (min * 1.618f));
        this.lGM.setTextSize(TbConfig.getContentSize());
        this.lGM.setDisplayImage(z2, false);
        this.lGM.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
