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
/* loaded from: classes21.dex */
public class b extends af.a implements View.OnClickListener {
    public TbImageView lRE;
    public View lRF;
    public PbGiftListView lRG;
    public FrsPraiseView lRH;
    public ImageView lRI;
    public TbRichTextView lsY;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.lRE = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.lRE.setSupportNoImage(true);
        this.lRE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lRE.setOnClickListener(this);
        this.lRE.setInterceptOnClick(true);
        this.lRE.setDefaultResource(R.drawable.icon_click);
        this.lsY = (TbRichTextView) view.findViewById(R.id.richText);
        this.lRF = view.findViewById(R.id.pb_item_praise_topline);
        this.lRH = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.lRI = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.lRG = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lsY.getLayoutStrategy().setSupportNoImage();
        this.lsY.getLayoutStrategy().kU(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lsY.getPaddingLeft()) - this.lsY.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lsY.getLayoutStrategy().sL(min);
        this.lsY.getLayoutStrategy().sM((int) (min * 1.618f));
        this.lsY.setTextSize(TbConfig.getContentSize());
        this.lsY.setDisplayImage(z2, false);
        this.lsY.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
