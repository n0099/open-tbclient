package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class c extends y.a implements View.OnClickListener {
    public TbImageView dfS;
    public TbRichTextView dfT;
    public View dfU;
    public PbGiftListView dfV;
    public FrsPraiseView dfW;
    public ImageView dfX;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [45=5] */
    public c(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.dfS = (TbImageView) view.findViewById(t.g.interview_live_post_pic);
        this.dfS.setSupportNoImage(true);
        this.dfS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dfS.setOnClickListener(this);
        this.dfS.setInterceptOnClick(true);
        this.dfS.setDefaultResource(t.f.icon_click);
        this.dfT = (TbRichTextView) view.findViewById(t.g.richText);
        this.dfU = view.findViewById(t.g.pb_item_praise_topline);
        this.dfW = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.dfX = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.dfV = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.dfT.Hq();
        this.dfT.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.dfT.getPaddingLeft()) - this.dfT.getPaddingRight()) - ((int) TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds60)), i);
        this.dfT.setMaxImageWidth(min);
        this.dfT.setMaxImageHeight((int) (min * 1.618f));
        this.dfT.setTextSize(TbConfig.getContentSize());
        this.dfT.h(z2, false);
        this.dfT.setVoiceViewRes(t.h.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
