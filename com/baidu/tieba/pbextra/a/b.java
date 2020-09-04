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
/* loaded from: classes16.dex */
public class b extends af.a implements View.OnClickListener {
    public TbRichTextView kCz;
    public TbImageView laM;
    public View laN;
    public PbGiftListView laO;
    public FrsPraiseView laP;
    public ImageView laQ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.laM = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.laM.setSupportNoImage(true);
        this.laM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.laM.setOnClickListener(this);
        this.laM.setInterceptOnClick(true);
        this.laM.setDefaultResource(R.drawable.icon_click);
        this.kCz = (TbRichTextView) view.findViewById(R.id.richText);
        this.laN = view.findViewById(R.id.pb_item_praise_topline);
        this.laP = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.laQ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.laO = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.kCz.getLayoutStrategy().setSupportNoImage();
        this.kCz.getLayoutStrategy().jY(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kCz.getPaddingLeft()) - this.kCz.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.kCz.getLayoutStrategy().rd(min);
        this.kCz.getLayoutStrategy().re((int) (min * 1.618f));
        this.kCz.setTextSize(TbConfig.getContentSize());
        this.kCz.setDisplayImage(z2, false);
        this.kCz.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
