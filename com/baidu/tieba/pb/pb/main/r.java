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
public class r extends r.a {
    public TextView bcH;
    public TbImageView bck;
    public OriginalThreadCardView cVR;
    public View ecN;
    public View fFF;
    public View fFG;
    public TbRichTextView fFP;
    public PbGiftListView fFS;
    public TextView fGk;
    public LinearLayout fKJ;
    public TbImageView fLE;
    public TbImageView fLF;
    public ThreadSkinView fLG;
    public LinearLayout fLH;
    public TextView fLI;
    public TextView fLJ;
    public TextView fLK;
    public TextView fLL;
    public View fLM;
    public View fLN;
    public View fLO;
    public BaseWebView fLP;
    public TextView fLQ;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.bcH = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cVR = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fLH = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fLI = (TextView) view.findViewById(d.g.tip_source);
        this.fLJ = (TextView) view.findViewById(d.g.view_forum1);
        this.fLK = (TextView) view.findViewById(d.g.view_forum2);
        this.fLL = (TextView) view.findViewById(d.g.view_forum3);
        this.fLM = view.findViewById(d.g.line_divide1);
        this.fLN = view.findViewById(d.g.line_divide2);
        this.fFP = (TbRichTextView) view.findViewById(d.g.richText);
        this.fFS = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fFF = view;
        this.fFG = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fFP.setLayoutStrategy(new c(this.fFP.getLayoutStrategy()));
        this.fLE = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fLF = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fFP.getPaddingLeft()) - this.fFP.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fFP.getLayoutStrategy().iO(min);
        this.fFP.getLayoutStrategy().iP((int) (min * 1.618f));
        this.fFP.setTextSize(TbConfig.getContentSize());
        this.fFP.o(z, false);
        this.fFP.setVoiceViewRes(d.h.voice_play_btn_new);
        this.ecN = view.findViewById(d.g.divider_bottom_first_floor);
        this.bck = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fLG = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fKJ = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fGk = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fLO = view.findViewById(d.g.link_thread_divider);
        this.fLP = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fLQ = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
