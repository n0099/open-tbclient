package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes16.dex */
public class b extends ad.a implements View.OnClickListener {
    public TbImageView kKO;
    public View kKP;
    public PbGiftListView kKQ;
    public FrsPraiseView kKR;
    public ImageView kKS;
    public TbRichTextView kmZ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.kKO = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.kKO.setSupportNoImage(true);
        this.kKO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kKO.setOnClickListener(this);
        this.kKO.setInterceptOnClick(true);
        this.kKO.setDefaultResource(R.drawable.icon_click);
        this.kmZ = (TbRichTextView) view.findViewById(R.id.richText);
        this.kKP = view.findViewById(R.id.pb_item_praise_topline);
        this.kKR = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.kKS = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.kKQ = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.kmZ.getLayoutStrategy().setSupportNoImage();
        this.kmZ.getLayoutStrategy().jy(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kmZ.getPaddingLeft()) - this.kmZ.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.kmZ.getLayoutStrategy().oR(min);
        this.kmZ.getLayoutStrategy().oS((int) (min * 1.618f));
        this.kmZ.setTextSize(TbConfig.getContentSize());
        this.kmZ.setDisplayImage(z2, false);
        this.kmZ.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
