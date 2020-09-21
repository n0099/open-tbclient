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
    public TbRichTextView kKX;
    public TbImageView ljD;
    public View ljE;
    public PbGiftListView ljF;
    public FrsPraiseView ljG;
    public ImageView ljH;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ljD = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.ljD.setSupportNoImage(true);
        this.ljD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ljD.setOnClickListener(this);
        this.ljD.setInterceptOnClick(true);
        this.ljD.setDefaultResource(R.drawable.icon_click);
        this.kKX = (TbRichTextView) view.findViewById(R.id.richText);
        this.ljE = view.findViewById(R.id.pb_item_praise_topline);
        this.ljG = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.ljH = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.ljF = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.kKX.getLayoutStrategy().setSupportNoImage();
        this.kKX.getLayoutStrategy().jZ(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kKX.getPaddingLeft()) - this.kKX.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.kKX.getLayoutStrategy().ru(min);
        this.kKX.getLayoutStrategy().rv((int) (min * 1.618f));
        this.kKX.setTextSize(TbConfig.getContentSize());
        this.kKX.setDisplayImage(z2, false);
        this.kKX.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
