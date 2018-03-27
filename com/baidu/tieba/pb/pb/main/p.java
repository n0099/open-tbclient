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
    public TbImageView bdR;
    public TextView beo;
    public OriginalThreadCardView cYt;
    public View ehd;
    public TextView fJM;
    public View fJh;
    public View fJi;
    public TbRichTextView fJr;
    public PbGiftListView fJu;
    public LinearLayout fNY;
    public TbImageView fOS;
    public TbImageView fOT;
    public ThreadSkinView fOU;
    public LinearLayout fOV;
    public TextView fOW;
    public TextView fOX;
    public TextView fOY;
    public TextView fOZ;
    public View fPa;
    public View fPb;
    public View fPc;
    public BaseWebView fPd;
    public TextView fPe;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.beo = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cYt = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fOV = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fOW = (TextView) view.findViewById(d.g.tip_source);
        this.fOX = (TextView) view.findViewById(d.g.view_forum1);
        this.fOY = (TextView) view.findViewById(d.g.view_forum2);
        this.fOZ = (TextView) view.findViewById(d.g.view_forum3);
        this.fPa = view.findViewById(d.g.line_divide1);
        this.fPb = view.findViewById(d.g.line_divide2);
        this.fJr = (TbRichTextView) view.findViewById(d.g.richText);
        this.fJu = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fJh = view;
        this.fJi = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fJr.setLayoutStrategy(new c(this.fJr.getLayoutStrategy()));
        this.fOS = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fOT = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fJr.getPaddingLeft()) - this.fJr.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fJr.getLayoutStrategy().iL(min);
        this.fJr.getLayoutStrategy().iM((int) (min * 1.618f));
        this.fJr.setTextSize(TbConfig.getContentSize());
        this.fJr.o(z, false);
        this.fJr.setVoiceViewRes(d.h.voice_play_btn_new);
        this.ehd = view.findViewById(d.g.divider_bottom_first_floor);
        this.bdR = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fOU = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fNY = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fJM = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fPc = view.findViewById(d.g.link_thread_divider);
        this.fPd = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fPe = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
