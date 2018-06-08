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
    public OriginalThreadCardView czT;
    public View dNV;
    public TextView fuG;
    public View fuo;
    public LinearLayout fup;
    public BaseWebView fvA;
    public TextView fvB;
    public PbTopicContainer fvC;
    public View fvl;
    public TbRichTextView fvm;
    public PbGiftListView fvn;
    public TbImageView fvo;
    public TbImageView fvp;
    public TbImageView fvq;
    public ThreadSkinView fvr;
    public LinearLayout fvs;
    public TextView fvt;
    public TextView fvu;
    public TextView fvv;
    public TextView fvw;
    public View fvx;
    public View fvy;
    public View fvz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.czT = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fvs = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fvt = (TextView) view.findViewById(d.g.tip_source);
        this.fvu = (TextView) view.findViewById(d.g.view_forum1);
        this.fvv = (TextView) view.findViewById(d.g.view_forum2);
        this.fvw = (TextView) view.findViewById(d.g.view_forum3);
        this.fvx = view.findViewById(d.g.line_divide1);
        this.fvy = view.findViewById(d.g.line_divide2);
        this.fvm = (TbRichTextView) view.findViewById(d.g.richText);
        this.fvn = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fuo = view;
        this.fvl = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fvm.setLayoutStrategy(new c(this.fvm.getLayoutStrategy()));
        this.fvp = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fvq = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fvm.getPaddingLeft()) - this.fvm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fvm.getLayoutStrategy().fN(min);
        this.fvm.getLayoutStrategy().fO((int) (min * 1.618f));
        this.fvm.setTextSize(TbConfig.getContentSize());
        this.fvm.setDisplayImage(z, false);
        this.fvm.setVoiceViewRes(d.i.voice_play_btn_new);
        this.dNV = view.findViewById(d.g.divider_bottom_first_floor);
        this.fvo = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fvr = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fup = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fuG = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fvz = view.findViewById(d.g.link_thread_divider);
        this.fvA = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fvB = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        this.fvC = (PbTopicContainer) view.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
