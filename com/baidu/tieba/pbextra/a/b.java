package com.baidu.tieba.pbextra.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes3.dex */
public class b extends q.a implements View.OnClickListener {
    public TbRichTextView fiK;
    public PbGiftListView fiL;
    public TbImageView fyX;
    public View fyY;
    public FrsPraiseView fyZ;
    public ImageView fza;

    public b(View view2, boolean z, boolean z2, int i, boolean z3) {
        super(view2);
        this.fyX = (TbImageView) view2.findViewById(d.g.interview_live_post_pic);
        this.fyX.setSupportNoImage(true);
        this.fyX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fyX.setOnClickListener(this);
        this.fyX.setInterceptOnClick(true);
        this.fyX.setDefaultResource(d.f.icon_click);
        this.fiK = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fyY = view2.findViewById(d.g.pb_item_praise_topline);
        this.fyZ = (FrsPraiseView) view2.findViewById(d.g.pb_item_praise_view);
        this.fza = (ImageView) view2.findViewById(d.g.pb_item_praise_bottomline);
        this.fiL = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fiK.getLayoutStrategy().setSupportNoImage();
        this.fiK.getLayoutStrategy().ce(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fiK.getPaddingLeft()) - this.fiK.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fiK.getLayoutStrategy().fL(min);
        this.fiK.getLayoutStrategy().fM((int) (min * 1.618f));
        this.fiK.setTextSize(TbConfig.getContentSize());
        this.fiK.setDisplayImage(z2, false);
        this.fiK.setVoiceViewRes(d.i.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
