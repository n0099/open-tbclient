package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes.dex */
public class r extends j.a {
    public TbImageView anZ;
    public TbImageView cJp;
    public OriginalThreadCardView cci;
    public TextView cuS;
    public View dnQ;
    public TextView eQG;
    public View eQb;
    public View eQc;
    public TbRichTextView eQl;
    public PbGiftListView eQo;
    public TbImageView eVP;
    public ThreadSkinView eVQ;
    public LinearLayout eVR;
    public TextView eVS;
    public TextView eVT;
    public TextView eVU;
    public TextView eVV;
    public View eVW;
    public View eVX;
    public View eVY;
    public BaseWebView eVZ;
    public LinearLayout eVb;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.cuS = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cci = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.eVR = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.eVS = (TextView) view.findViewById(d.g.tip_source);
        this.eVT = (TextView) view.findViewById(d.g.view_forum1);
        this.eVU = (TextView) view.findViewById(d.g.view_forum2);
        this.eVV = (TextView) view.findViewById(d.g.view_forum3);
        this.eVW = view.findViewById(d.g.line_divide1);
        this.eVX = view.findViewById(d.g.line_divide2);
        this.eQl = (TbRichTextView) view.findViewById(d.g.richText);
        this.eQo = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.eQb = view;
        this.eQc = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.eQl.setLayoutStrategy(new c(this.eQl.getLayoutStrategy()));
        this.cJp = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.eVP = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eQl.getPaddingLeft()) - this.eQl.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.eQl.getLayoutStrategy().fT(min);
        this.eQl.getLayoutStrategy().fU((int) (min * 1.618f));
        this.eQl.setTextSize(TbConfig.getContentSize());
        this.eQl.m(z, false);
        this.eQl.setVoiceViewRes(d.h.voice_play_btn_new);
        this.dnQ = view.findViewById(d.g.divider_bottom_first_floor);
        this.anZ = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.eVQ = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.eVb = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.eQG = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.eVY = view.findViewById(d.g.link_thread_divider);
        this.eVZ = (BaseWebView) view.findViewById(d.g.link_thread_webview);
    }
}
