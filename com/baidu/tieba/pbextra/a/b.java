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
/* loaded from: classes4.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView hPb;
    public TbImageView ifP;
    public View ifQ;
    public PbGiftListView ifR;
    public FrsPraiseView ifS;
    public ImageView ifT;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ifP = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.ifP.setSupportNoImage(true);
        this.ifP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ifP.setOnClickListener(this);
        this.ifP.setInterceptOnClick(true);
        this.ifP.setDefaultResource(R.drawable.icon_click);
        this.hPb = (TbRichTextView) view.findViewById(R.id.richText);
        this.ifQ = view.findViewById(R.id.pb_item_praise_topline);
        this.ifS = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.ifT = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.ifR = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hPb.getLayoutStrategy().setSupportNoImage();
        this.hPb.getLayoutStrategy().fM(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPb.getPaddingLeft()) - this.hPb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPb.getLayoutStrategy().kC(min);
        this.hPb.getLayoutStrategy().kD((int) (min * 1.618f));
        this.hPb.setTextSize(TbConfig.getContentSize());
        this.hPb.setDisplayImage(z2, false);
        this.hPb.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
