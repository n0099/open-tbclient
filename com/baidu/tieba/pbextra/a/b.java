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
/* loaded from: classes9.dex */
public class b extends ad.a implements View.OnClickListener {
    public TbImageView kBM;
    public View kBN;
    public PbGiftListView kBO;
    public FrsPraiseView kBP;
    public ImageView kBQ;
    public TbRichTextView kel;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.kBM = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.kBM.setSupportNoImage(true);
        this.kBM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kBM.setOnClickListener(this);
        this.kBM.setInterceptOnClick(true);
        this.kBM.setDefaultResource(R.drawable.icon_click);
        this.kel = (TbRichTextView) view.findViewById(R.id.richText);
        this.kBN = view.findViewById(R.id.pb_item_praise_topline);
        this.kBP = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.kBQ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.kBO = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.kel.getLayoutStrategy().setSupportNoImage();
        this.kel.getLayoutStrategy().iT(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kel.getPaddingLeft()) - this.kel.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.kel.getLayoutStrategy().oy(min);
        this.kel.getLayoutStrategy().oz((int) (min * 1.618f));
        this.kel.setTextSize(TbConfig.getContentSize());
        this.kel.setDisplayImage(z2, false);
        this.kel.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
