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
    public OriginalThreadCardView crr;
    public View dCN;
    public View fiT;
    public LinearLayout fiU;
    public View fjQ;
    public TbRichTextView fjR;
    public PbGiftListView fjS;
    public TbImageView fjT;
    public TbImageView fjU;
    public TbImageView fjV;
    public ThreadSkinView fjW;
    public LinearLayout fjX;
    public TextView fjY;
    public TextView fjZ;
    public TextView fjl;
    public TextView fka;
    public TextView fkb;
    public View fkc;
    public View fkd;
    public View fke;
    public BaseWebView fkf;
    public TextView fkg;
    public PbTopicContainer fkh;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view2, boolean z, int i) {
        super(view2);
        this.mSkinType = 3;
        this.crr = (OriginalThreadCardView) view2.findViewById(d.g.view_original_thread_info);
        this.fjX = (LinearLayout) view2.findViewById(d.g.view_multi_from_list);
        this.fjY = (TextView) view2.findViewById(d.g.tip_source);
        this.fjZ = (TextView) view2.findViewById(d.g.view_forum1);
        this.fka = (TextView) view2.findViewById(d.g.view_forum2);
        this.fkb = (TextView) view2.findViewById(d.g.view_forum3);
        this.fkc = view2.findViewById(d.g.line_divide1);
        this.fkd = view2.findViewById(d.g.line_divide2);
        this.fjR = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fjS = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fiT = view2;
        this.fjQ = view2.findViewById(d.g.new_pb_list_item_blank_top);
        this.fjR.setLayoutStrategy(new c(this.fjR.getLayoutStrategy()));
        this.fjU = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        this.fjV = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fjR.getPaddingLeft()) - this.fjR.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fjR.getLayoutStrategy().fM(min);
        this.fjR.getLayoutStrategy().fN((int) (min * 1.618f));
        this.fjR.setTextSize(TbConfig.getContentSize());
        this.fjR.setDisplayImage(z, false);
        this.fjR.setVoiceViewRes(d.i.voice_play_btn_new);
        this.dCN = view2.findViewById(d.g.divider_bottom_first_floor);
        this.fjT = (TbImageView) view2.findViewById(d.g.user_head_mask);
        this.fjW = (ThreadSkinView) view2.findViewById(d.g.pb_item_thread_skin);
        this.fiU = (LinearLayout) view2.findViewById(d.g.pb_list_content);
        this.fjl = (TextView) view2.findViewById(d.g.pb_item_tail_content);
        this.fke = view2.findViewById(d.g.link_thread_divider);
        this.fkf = (BaseWebView) view2.findViewById(d.g.link_thread_webview);
        this.fkg = (TextView) view2.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        this.fkh = (PbTopicContainer) view2.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
