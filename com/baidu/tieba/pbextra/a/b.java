package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes9.dex */
public class b extends aa.a implements View.OnClickListener {
    public TbRichTextView jKC;
    public TbImageView khZ;
    public View kia;
    public PbGiftListView kib;
    public FrsPraiseView kic;
    public ImageView kie;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.khZ = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.khZ.setSupportNoImage(true);
        this.khZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.khZ.setOnClickListener(this);
        this.khZ.setInterceptOnClick(true);
        this.khZ.setDefaultResource(R.drawable.icon_click);
        this.jKC = (TbRichTextView) view.findViewById(R.id.richText);
        this.kia = view.findViewById(R.id.pb_item_praise_topline);
        this.kic = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.kie = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.kib = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.jKC.getLayoutStrategy().setSupportNoImage();
        this.jKC.getLayoutStrategy().iH(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jKC.getPaddingLeft()) - this.jKC.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.jKC.getLayoutStrategy().ob(min);
        this.jKC.getLayoutStrategy().oc((int) (min * 1.618f));
        this.jKC.setTextSize(TbConfig.getContentSize());
        this.jKC.setDisplayImage(z2, false);
        this.jKC.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
