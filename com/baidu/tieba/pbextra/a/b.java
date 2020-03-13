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
/* loaded from: classes9.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView iGO;
    public TbImageView jdt;
    public View jdu;
    public PbGiftListView jdv;
    public FrsPraiseView jdw;
    public ImageView jdx;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jdt = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jdt.setSupportNoImage(true);
        this.jdt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdt.setOnClickListener(this);
        this.jdt.setInterceptOnClick(true);
        this.jdt.setDefaultResource(R.drawable.icon_click);
        this.iGO = (TbRichTextView) view.findViewById(R.id.richText);
        this.jdu = view.findViewById(R.id.pb_item_praise_topline);
        this.jdw = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jdx = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jdv = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iGO.getLayoutStrategy().setSupportNoImage();
        this.iGO.getLayoutStrategy().hl(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGO.getPaddingLeft()) - this.iGO.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iGO.getLayoutStrategy().ni(min);
        this.iGO.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGO.setTextSize(TbConfig.getContentSize());
        this.iGO.setDisplayImage(z2, false);
        this.iGO.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
