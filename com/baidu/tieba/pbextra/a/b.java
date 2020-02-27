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
    public TbRichTextView iGA;
    public TbImageView jdf;
    public View jdg;
    public PbGiftListView jdh;
    public FrsPraiseView jdi;
    public ImageView jdj;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jdf = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jdf.setSupportNoImage(true);
        this.jdf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdf.setOnClickListener(this);
        this.jdf.setInterceptOnClick(true);
        this.jdf.setDefaultResource(R.drawable.icon_click);
        this.iGA = (TbRichTextView) view.findViewById(R.id.richText);
        this.jdg = view.findViewById(R.id.pb_item_praise_topline);
        this.jdi = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jdj = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jdh = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iGA.getLayoutStrategy().setSupportNoImage();
        this.iGA.getLayoutStrategy().hl(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGA.getPaddingLeft()) - this.iGA.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iGA.getLayoutStrategy().ni(min);
        this.iGA.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGA.setTextSize(TbConfig.getContentSize());
        this.iGA.setDisplayImage(z2, false);
        this.iGA.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
