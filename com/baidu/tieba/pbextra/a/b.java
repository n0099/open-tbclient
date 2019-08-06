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
/* loaded from: classes4.dex */
public class b extends v.a implements View.OnClickListener {
    public TbRichTextView hPq;
    public TbImageView ifX;
    public View ifY;
    public PbGiftListView ifZ;
    public FrsPraiseView iga;
    public ImageView igb;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.ifX = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.ifX.setSupportNoImage(true);
        this.ifX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ifX.setOnClickListener(this);
        this.ifX.setInterceptOnClick(true);
        this.ifX.setDefaultResource(R.drawable.icon_click);
        this.hPq = (TbRichTextView) view.findViewById(R.id.richText);
        this.ifY = view.findViewById(R.id.pb_item_praise_topline);
        this.iga = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.igb = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.ifZ = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.hPq.getLayoutStrategy().setSupportNoImage();
        this.hPq.getLayoutStrategy().fU(true);
        int min = Math.min(((((l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPq.getPaddingLeft()) - this.hPq.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPq.getLayoutStrategy().lu(min);
        this.hPq.getLayoutStrategy().lv((int) (min * 1.618f));
        this.hPq.setTextSize(TbConfig.getContentSize());
        this.hPq.setDisplayImage(z2, false);
        this.hPq.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
