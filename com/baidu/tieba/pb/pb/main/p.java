package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
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
/* loaded from: classes2.dex */
public class p extends r.a {
    public TbImageView bea;
    public TextView bey;
    public OriginalThreadCardView cYC;
    public View egZ;
    public TextView fJH;
    public View fJc;
    public View fJd;
    public TbRichTextView fJm;
    public PbGiftListView fJp;
    public LinearLayout fNT;
    public TbImageView fON;
    public TbImageView fOO;
    public ThreadSkinView fOP;
    public LinearLayout fOQ;
    public TextView fOR;
    public TextView fOS;
    public TextView fOT;
    public TextView fOU;
    public View fOV;
    public View fOW;
    public View fOX;
    public BaseWebView fOY;
    public TextView fOZ;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.bey = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cYC = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fOQ = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fOR = (TextView) view.findViewById(d.g.tip_source);
        this.fOS = (TextView) view.findViewById(d.g.view_forum1);
        this.fOT = (TextView) view.findViewById(d.g.view_forum2);
        this.fOU = (TextView) view.findViewById(d.g.view_forum3);
        this.fOV = view.findViewById(d.g.line_divide1);
        this.fOW = view.findViewById(d.g.line_divide2);
        this.fJm = (TbRichTextView) view.findViewById(d.g.richText);
        this.fJp = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fJc = view;
        this.fJd = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fJm.setLayoutStrategy(new c(this.fJm.getLayoutStrategy()));
        this.fON = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fOO = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fJm.getPaddingLeft()) - this.fJm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fJm.getLayoutStrategy().iL(min);
        this.fJm.getLayoutStrategy().iM((int) (min * 1.618f));
        this.fJm.setTextSize(TbConfig.getContentSize());
        this.fJm.o(z, false);
        this.fJm.setVoiceViewRes(d.h.voice_play_btn_new);
        this.egZ = view.findViewById(d.g.divider_bottom_first_floor);
        this.bea = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fOP = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fNT = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fJH = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fOX = view.findViewById(d.g.link_thread_divider);
        this.fOY = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fOZ = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
