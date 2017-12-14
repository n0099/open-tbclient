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
    public TbImageView aob;
    public TbImageView cJz;
    public OriginalThreadCardView ccm;
    public TextView cvb;
    public View doW;
    public TextView eRJ;
    public View eRe;
    public View eRf;
    public TbRichTextView eRo;
    public PbGiftListView eRr;
    public TbImageView eWS;
    public ThreadSkinView eWT;
    public LinearLayout eWU;
    public TextView eWV;
    public TextView eWW;
    public TextView eWX;
    public TextView eWY;
    public View eWZ;
    public LinearLayout eWe;
    public View eXa;
    public View eXb;
    public BaseWebView eXc;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.cvb = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.ccm = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.eWU = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.eWV = (TextView) view.findViewById(d.g.tip_source);
        this.eWW = (TextView) view.findViewById(d.g.view_forum1);
        this.eWX = (TextView) view.findViewById(d.g.view_forum2);
        this.eWY = (TextView) view.findViewById(d.g.view_forum3);
        this.eWZ = view.findViewById(d.g.line_divide1);
        this.eXa = view.findViewById(d.g.line_divide2);
        this.eRo = (TbRichTextView) view.findViewById(d.g.richText);
        this.eRr = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.eRe = view;
        this.eRf = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.eRo.setLayoutStrategy(new c(this.eRo.getLayoutStrategy()));
        this.cJz = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.eWS = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eRo.getPaddingLeft()) - this.eRo.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.eRo.getLayoutStrategy().fT(min);
        this.eRo.getLayoutStrategy().fU((int) (min * 1.618f));
        this.eRo.setTextSize(TbConfig.getContentSize());
        this.eRo.m(z, false);
        this.eRo.setVoiceViewRes(d.h.voice_play_btn_new);
        this.doW = view.findViewById(d.g.divider_bottom_first_floor);
        this.aob = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.eWT = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.eWe = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.eRJ = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.eXb = view.findViewById(d.g.link_thread_divider);
        this.eXc = (BaseWebView) view.findViewById(d.g.link_thread_webview);
    }
}
