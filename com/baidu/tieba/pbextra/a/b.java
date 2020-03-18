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
    public TbRichTextView iIp;
    public TbImageView jeS;
    public View jeT;
    public PbGiftListView jeU;
    public FrsPraiseView jeV;
    public ImageView jeW;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.jeS = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.jeS.setSupportNoImage(true);
        this.jeS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jeS.setOnClickListener(this);
        this.jeS.setInterceptOnClick(true);
        this.jeS.setDefaultResource(R.drawable.icon_click);
        this.iIp = (TbRichTextView) view.findViewById(R.id.richText);
        this.jeT = view.findViewById(R.id.pb_item_praise_topline);
        this.jeV = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.jeW = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.jeU = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.iIp.getLayoutStrategy().setSupportNoImage();
        this.iIp.getLayoutStrategy().hm(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iIp.getPaddingLeft()) - this.iIp.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iIp.getLayoutStrategy().nk(min);
        this.iIp.getLayoutStrategy().nl((int) (min * 1.618f));
        this.iIp.setTextSize(TbConfig.getContentSize());
        this.iIp.setDisplayImage(z2, false);
        this.iIp.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
