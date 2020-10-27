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
    public TbImageView lLs;
    public View lLt;
    public PbGiftListView lLu;
    public FrsPraiseView lLv;
    public ImageView lLw;
    public TbRichTextView lmH;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.lLs = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.lLs.setSupportNoImage(true);
        this.lLs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lLs.setOnClickListener(this);
        this.lLs.setInterceptOnClick(true);
        this.lLs.setDefaultResource(R.drawable.icon_click);
        this.lmH = (TbRichTextView) view.findViewById(R.id.richText);
        this.lLt = view.findViewById(R.id.pb_item_praise_topline);
        this.lLv = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.lLw = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.lLu = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lmH.getLayoutStrategy().setSupportNoImage();
        this.lmH.getLayoutStrategy().kK(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lmH.getPaddingLeft()) - this.lmH.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lmH.getLayoutStrategy().sd(min);
        this.lmH.getLayoutStrategy().se((int) (min * 1.618f));
        this.lmH.setTextSize(TbConfig.getContentSize());
        this.lmH.setDisplayImage(z2, false);
        this.lmH.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
