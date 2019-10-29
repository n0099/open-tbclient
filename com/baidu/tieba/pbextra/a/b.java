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
    public TbRichTextView hPS;
    public TbImageView igG;
    public View igH;
    public PbGiftListView igI;
    public FrsPraiseView igJ;
    public ImageView igK;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.igG = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.igG.setSupportNoImage(true);
        this.igG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.igG.setOnClickListener(this);
        this.igG.setInterceptOnClick(true);
        this.igG.setDefaultResource(R.drawable.icon_click);
        this.hPS = (TbRichTextView) view.findViewById(R.id.richText);
        this.igH = view.findViewById(R.id.pb_item_praise_topline);
        this.igJ = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.igK = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.igI = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hPS.getLayoutStrategy().setSupportNoImage();
        this.hPS.getLayoutStrategy().fM(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPS.getPaddingLeft()) - this.hPS.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPS.getLayoutStrategy().kD(min);
        this.hPS.getLayoutStrategy().kE((int) (min * 1.618f));
        this.hPS.setTextSize(TbConfig.getContentSize());
        this.hPS.setDisplayImage(z2, false);
        this.hPS.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
