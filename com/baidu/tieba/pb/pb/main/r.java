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
    public TbImageView bcc;
    public OriginalThreadCardView cQU;
    public TextView djB;
    public View ebi;
    public View fDK;
    public View fDL;
    public TbRichTextView fDU;
    public PbGiftListView fDX;
    public TextView fEp;
    public LinearLayout fIO;
    public TbImageView fJJ;
    public TbImageView fJK;
    public ThreadSkinView fJL;
    public LinearLayout fJM;
    public TextView fJN;
    public TextView fJO;
    public TextView fJP;
    public TextView fJQ;
    public View fJR;
    public View fJS;
    public View fJT;
    public BaseWebView fJU;
    public TextView fJV;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.djB = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cQU = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fJM = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fJN = (TextView) view.findViewById(d.g.tip_source);
        this.fJO = (TextView) view.findViewById(d.g.view_forum1);
        this.fJP = (TextView) view.findViewById(d.g.view_forum2);
        this.fJQ = (TextView) view.findViewById(d.g.view_forum3);
        this.fJR = view.findViewById(d.g.line_divide1);
        this.fJS = view.findViewById(d.g.line_divide2);
        this.fDU = (TbRichTextView) view.findViewById(d.g.richText);
        this.fDX = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fDK = view;
        this.fDL = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fDU.setLayoutStrategy(new c(this.fDU.getLayoutStrategy()));
        this.fJJ = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fJK = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fDU.getPaddingLeft()) - this.fDU.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fDU.getLayoutStrategy().iS(min);
        this.fDU.getLayoutStrategy().iT((int) (min * 1.618f));
        this.fDU.setTextSize(TbConfig.getContentSize());
        this.fDU.o(z, false);
        this.fDU.setVoiceViewRes(d.h.voice_play_btn_new);
        this.ebi = view.findViewById(d.g.divider_bottom_first_floor);
        this.bcc = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fJL = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fIO = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fEp = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fJT = view.findViewById(d.g.link_thread_divider);
        this.fJU = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fJV = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
