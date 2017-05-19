package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.w;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends y.a {
    public TbImageView ami;
    public TbImageView bQs;
    public View cpl;
    public View eeP;
    public View eeQ;
    public TbRichTextView eeZ;
    public TextView efA;
    public LinearLayout efB;
    public PbGiftListView efc;
    public TextView efv;
    public TextView efx;
    public TextView efy;
    public TextView efz;
    public LinearLayout eiJ;
    public TbImageView ejk;
    public ThreadSkinView ejl;
    public TextView ejm;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [67=5] */
    public Cdo(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.efB = (LinearLayout) view.findViewById(w.h.belong_ba);
        this.ejm = (TextView) view.findViewById(w.h.belong_bar_direction);
        this.efx = (TextView) view.findViewById(w.h.belong_ba_btn1);
        this.efy = (TextView) view.findViewById(w.h.belong_ba_btn2);
        this.efz = (TextView) view.findViewById(w.h.belong_ba_btn3);
        this.efA = (TextView) view.findViewById(w.h.belong_ba_btn4);
        this.eeZ = (TbRichTextView) view.findViewById(w.h.richText);
        this.efc = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.eeP = view;
        this.eeQ = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.eeZ.Iq();
        this.eeZ.setImageViewStretch(true);
        this.bQs = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.ejk = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eeZ.getPaddingLeft()) - this.eeZ.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.eeZ.setMaxImageWidth(min);
        this.eeZ.setMaxImageHeight((int) (min * 1.618f));
        this.eeZ.setTextSize(TbConfig.getContentSize());
        this.eeZ.j(z, false);
        this.eeZ.setVoiceViewRes(w.j.voice_play_btn_new);
        this.cpl = view.findViewById(w.h.divider_bottom_first_floor);
        this.ami = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.ejl = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.eiJ = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.efv = (TextView) view.findViewById(w.h.pb_item_tail_content);
    }
}
