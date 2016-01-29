package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cz extends x.a {
    public TextView aMu;
    UserIconBox ahI;
    public UserIconBox bqH;
    public TbRichTextView cKi;
    public View cLA;
    public View cLB;
    public View cLC;
    public HeadImageView cLD;
    public ImageView cLG;
    public TextView cLH;
    public TextView cLI;
    public ImageView cLK;
    public RelativeLayout cLL;
    public LinearLayout cLM;
    public ImageView cLN;
    public SubPbLayout cLO;
    public View cLy;
    public View cLz;
    public TextView cMe;
    public ImageView cOj;
    public ImageView cPB;
    public PbNewChudianCommonView cPC;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [85=5] */
    public cz(View view, boolean z, boolean z2, int i) {
        super(view);
        this.cLC = view.findViewById(t.g.sub_pb_more);
        this.cLD = (HeadImageView) view.findViewById(t.g.photo);
        this.aMu = (TextView) view.findViewById(t.g.user_name);
        this.cPB = (ImageView) view.findViewById(t.g.advertise);
        this.cLG = (ImageView) view.findViewById(t.g.user_gender);
        this.cLK = (ImageView) view.findViewById(t.g.reply);
        this.cKi = (TbRichTextView) view.findViewById(t.g.richText);
        this.cLH = (TextView) view.findViewById(t.g.floor);
        this.cLI = (TextView) view.findViewById(t.g.time);
        this.cLL = (RelativeLayout) view.findViewById(t.g.pb_post_header_layout);
        this.cLO = (SubPbLayout) view.findViewById(t.g.pb_post_footer_layout);
        this.cLM = (LinearLayout) view.findViewById(t.g.pb_subpb_layout_root);
        this.cLN = (ImageView) view.findViewById(t.g.pb_post_footer_layout_line_top);
        this.cLy = view;
        this.cLz = view.findViewById(t.g.new_pb_list_item_line_top);
        this.cLA = view.findViewById(t.g.new_pb_list_item_line_top_full);
        this.cLB = view.findViewById(t.g.new_pb_list_item_blank_top);
        this.cKi.HC();
        this.cKi.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.cKi.getPaddingLeft()) - this.cKi.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.cKi.setMaxImageWidth(min);
        this.cKi.setMaxImageHeight((int) (min * 1.618f));
        this.cKi.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.cLD.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60);
            this.cLD.setLayoutParams(layoutParams);
            this.cLD.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.cLD.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds30);
            this.cLD.setLayoutParams(layoutParams2);
            this.cLD.setVisibility(4);
        }
        this.cKi.g(z2, false);
        this.cKi.setVoiceViewRes(t.h.voice_play_btn);
        this.bqH = (UserIconBox) view.findViewById(t.g.user_icon_box);
        this.ahI = (UserIconBox) view.findViewById(t.g.user_tshow_icon_box);
        this.cMe = (TextView) view.findViewById(t.g.pb_item_tail_content);
        this.cOj = (ImageView) view.findViewById(t.g.replybtn);
        this.cPC = (PbNewChudianCommonView) view.findViewById(t.g.newchudian_common);
    }
}
