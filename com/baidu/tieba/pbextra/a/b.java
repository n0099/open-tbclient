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
    public TbRichTextView iGC;
    public TbImageView jdh;
    public View jdi;
    public PbGiftListView jdj;
    public FrsPraiseView jdk;
    public ImageView jdl;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jdh = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jdh.setSupportNoImage(true);
        this.jdh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdh.setOnClickListener(this);
        this.jdh.setInterceptOnClick(true);
        this.jdh.setDefaultResource(R.drawable.icon_click);
        this.iGC = (TbRichTextView) view.findViewById(R.id.richText);
        this.jdi = view.findViewById(R.id.pb_item_praise_topline);
        this.jdk = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jdl = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jdj = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iGC.getLayoutStrategy().setSupportNoImage();
        this.iGC.getLayoutStrategy().hl(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGC.getPaddingLeft()) - this.iGC.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iGC.getLayoutStrategy().ni(min);
        this.iGC.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGC.setTextSize(TbConfig.getContentSize());
        this.iGC.setDisplayImage(z2, false);
        this.iGC.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
