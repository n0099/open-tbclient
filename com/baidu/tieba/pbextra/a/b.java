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
/* loaded from: classes22.dex */
public class b extends af.a implements View.OnClickListener {
    public TbRichTextView lai;
    public TbImageView lyV;
    public View lyW;
    public PbGiftListView lyX;
    public FrsPraiseView lyY;
    public ImageView lyZ;

    public b(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.lyV = (TbImageView) view.findViewById(R.id.interview_live_post_pic);
        this.lyV.setSupportNoImage(true);
        this.lyV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lyV.setOnClickListener(this);
        this.lyV.setInterceptOnClick(true);
        this.lyV.setDefaultResource(R.drawable.icon_click);
        this.lai = (TbRichTextView) view.findViewById(R.id.richText);
        this.lyW = view.findViewById(R.id.pb_item_praise_topline);
        this.lyY = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.lyZ = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.lyX = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.lai.getLayoutStrategy().setSupportNoImage();
        this.lai.getLayoutStrategy().kx(true);
        int min = Math.min(((((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lai.getPaddingLeft()) - this.lai.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.lai.getLayoutStrategy().rS(min);
        this.lai.getLayoutStrategy().rT((int) (min * 1.618f));
        this.lai.setTextSize(TbConfig.getContentSize());
        this.lai.setDisplayImage(z2, false);
        this.lai.setVoiceViewRes(R.layout.voice_play_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
