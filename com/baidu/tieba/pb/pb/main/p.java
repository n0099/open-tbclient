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
    public OriginalThreadCardView cqh;
    public View dBG;
    public View fhK;
    public LinearLayout fhL;
    public View fiJ;
    public TbRichTextView fiK;
    public PbGiftListView fiL;
    public TbImageView fiM;
    public TbImageView fiN;
    public TbImageView fiO;
    public ThreadSkinView fiP;
    public LinearLayout fiQ;
    public TextView fiR;
    public TextView fiS;
    public TextView fiT;
    public TextView fiU;
    public View fiV;
    public View fiW;
    public View fiX;
    public BaseWebView fiY;
    public TextView fiZ;
    public TextView fic;
    public PbTopicContainer fja;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view2, boolean z, int i) {
        super(view2);
        this.mSkinType = 3;
        this.cqh = (OriginalThreadCardView) view2.findViewById(d.g.view_original_thread_info);
        this.fiQ = (LinearLayout) view2.findViewById(d.g.view_multi_from_list);
        this.fiR = (TextView) view2.findViewById(d.g.tip_source);
        this.fiS = (TextView) view2.findViewById(d.g.view_forum1);
        this.fiT = (TextView) view2.findViewById(d.g.view_forum2);
        this.fiU = (TextView) view2.findViewById(d.g.view_forum3);
        this.fiV = view2.findViewById(d.g.line_divide1);
        this.fiW = view2.findViewById(d.g.line_divide2);
        this.fiK = (TbRichTextView) view2.findViewById(d.g.richText);
        this.fiL = (PbGiftListView) view2.findViewById(d.g.gift_list_view);
        this.fhK = view2;
        this.fiJ = view2.findViewById(d.g.new_pb_list_item_blank_top);
        this.fiK.setLayoutStrategy(new c(this.fiK.getLayoutStrategy()));
        this.fiN = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        this.fiO = (TbImageView) view2.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - this.fiK.getPaddingLeft()) - this.fiK.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fiK.getLayoutStrategy().fL(min);
        this.fiK.getLayoutStrategy().fM((int) (min * 1.618f));
        this.fiK.setTextSize(TbConfig.getContentSize());
        this.fiK.setDisplayImage(z, false);
        this.fiK.setVoiceViewRes(d.i.voice_play_btn_new);
        this.dBG = view2.findViewById(d.g.divider_bottom_first_floor);
        this.fiM = (TbImageView) view2.findViewById(d.g.user_head_mask);
        this.fiP = (ThreadSkinView) view2.findViewById(d.g.pb_item_thread_skin);
        this.fhL = (LinearLayout) view2.findViewById(d.g.pb_list_content);
        this.fic = (TextView) view2.findViewById(d.g.pb_item_tail_content);
        this.fiX = view2.findViewById(d.g.link_thread_divider);
        this.fiY = (BaseWebView) view2.findViewById(d.g.link_thread_webview);
        this.fiZ = (TextView) view2.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
        this.fja = (PbTopicContainer) view2.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
