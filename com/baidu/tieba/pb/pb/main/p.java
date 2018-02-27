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
    public TbImageView bdO;
    public TextView bel;
    public OriginalThreadCardView cYq;
    public View egN;
    public View fIR;
    public View fIS;
    public TbRichTextView fJb;
    public PbGiftListView fJe;
    public TextView fJw;
    public LinearLayout fNI;
    public TbImageView fOC;
    public TbImageView fOD;
    public ThreadSkinView fOE;
    public LinearLayout fOF;
    public TextView fOG;
    public TextView fOH;
    public TextView fOI;
    public TextView fOJ;
    public View fOK;
    public View fOL;
    public View fOM;
    public BaseWebView fON;
    public TextView fOO;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.bel = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cYq = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fOF = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fOG = (TextView) view.findViewById(d.g.tip_source);
        this.fOH = (TextView) view.findViewById(d.g.view_forum1);
        this.fOI = (TextView) view.findViewById(d.g.view_forum2);
        this.fOJ = (TextView) view.findViewById(d.g.view_forum3);
        this.fOK = view.findViewById(d.g.line_divide1);
        this.fOL = view.findViewById(d.g.line_divide2);
        this.fJb = (TbRichTextView) view.findViewById(d.g.richText);
        this.fJe = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fIR = view;
        this.fIS = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fJb.setLayoutStrategy(new c(this.fJb.getLayoutStrategy()));
        this.fOC = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fOD = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fJb.getPaddingLeft()) - this.fJb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fJb.getLayoutStrategy().iL(min);
        this.fJb.getLayoutStrategy().iM((int) (min * 1.618f));
        this.fJb.setTextSize(TbConfig.getContentSize());
        this.fJb.o(z, false);
        this.fJb.setVoiceViewRes(d.h.voice_play_btn_new);
        this.egN = view.findViewById(d.g.divider_bottom_first_floor);
        this.bdO = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fOE = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fNI = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fJw = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fOM = view.findViewById(d.g.link_thread_divider);
        this.fON = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fOO = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
