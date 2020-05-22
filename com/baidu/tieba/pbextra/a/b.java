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
    public TbRichTextView jJw;
    public TbImageView kgT;
    public View kgU;
    public PbGiftListView kgV;
    public FrsPraiseView kgW;
    public ImageView kgX;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.kgT = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.kgT.setSupportNoImage(true);
        this.kgT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kgT.setOnClickListener(this);
        this.kgT.setInterceptOnClick(true);
        this.kgT.setDefaultResource(R.drawable.icon_click);
        this.jJw = (TbRichTextView) view.findViewById(R.id.richText);
        this.kgU = view.findViewById(R.id.pb_item_praise_topline);
        this.kgW = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.kgX = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.kgV = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.jJw.getLayoutStrategy().setSupportNoImage();
        this.jJw.getLayoutStrategy().iH(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jJw.getPaddingLeft()) - this.jJw.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.jJw.getLayoutStrategy().nZ(min);
        this.jJw.getLayoutStrategy().oa((int) (min * 1.618f));
        this.jJw.setTextSize(TbConfig.getContentSize());
        this.jJw.setDisplayImage(z2, false);
        this.jJw.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
