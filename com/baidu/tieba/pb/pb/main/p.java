package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tieba.pb.view.PbTopicContainer;
/* loaded from: classes2.dex */
public class p extends q.a {
    public OriginalThreadCardView cqk;
    public View dBJ;
    public View fhN;
    public LinearLayout fhO;
    public View fiM;
    public TbRichTextView fiN;
    public PbGiftListView fiO;
    public TbImageView fiP;
    public TbImageView fiQ;
    public TbImageView fiR;
    public ThreadSkinView fiS;
    public LinearLayout fiT;
    public TextView fiU;
    public TextView fiV;
    public TextView fiW;
    public TextView fiX;
    public View fiY;
    public View fiZ;
    public TextView fig;
    public View fja;
    public BaseWebView fjb;
    public TextView fjc;
    public PbTopicContainer fjd;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view2, boolean z, int i) {
        super(view2);
        this.mSkinType = 3;
        this.cqk = (OriginalThreadCardView) view2.findViewById(d.g.view_original_thread_info);
        this.fiT = (LinearLayout) view2.findViewById(d.g.view_multi_from_list);
        this.fiU = (TextView) view2.findViewById(d.g.tip_source);
        this.fiV = (TextView) view2.findViewById(d.g.view_forum1);
        this.fiW = (TextView) view2.findViewById(d.g.view_forum2);
        this.fiX = (TextView) view2.findViewById(d.g.view_forum3);
        this.fiY = view2.findViewById(d.g.line_divide1);
        this.fiZ = view2.findViewById(d.g.line_divide2);
        this.fiN = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fiO = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fhN = view2;
        this.fiM = view2.findViewById(d.g.new_pb_list_item_blank_top);
        this.fiN.setLayoutStrategy(new c(this.fiN.getLayoutStrategy()));
        this.fiQ = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        this.fiR = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fiN.getPaddingLeft()) - this.fiN.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fiN.getLayoutStrategy().fM(min);
        this.fiN.getLayoutStrategy().fN((int) (min * 1.618f));
        this.fiN.setTextSize(TbConfig.getContentSize());
        this.fiN.setDisplayImage(z, false);
        this.fiN.setVoiceViewRes(d.i.voice_play_btn_new);
        this.dBJ = view2.findViewById(d.g.divider_bottom_first_floor);
        this.fiP = (TbImageView) view2.findViewById(d.g.user_head_mask);
        this.fiS = (ThreadSkinView) view2.findViewById(d.g.pb_item_thread_skin);
        this.fhO = (LinearLayout) view2.findViewById(d.g.pb_list_content);
        this.fig = (TextView) view2.findViewById(d.g.pb_item_tail_content);
        this.fja = view2.findViewById(d.g.link_thread_divider);
        this.fjb = (BaseWebView) view2.findViewById(d.g.link_thread_webview);
        this.fjc = (TextView) view2.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        this.fjd = (PbTopicContainer) view2.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
