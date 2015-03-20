package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.BaobaoTailView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.widget.ListView.am {
    UserIconBox aIh;
    public UserIconBox aOi;
    public TextView azt;
    public View bJT;
    public View bJU;
    public View bJV;
    public View bJW;
    public View bJX;
    public HeadImageView bJY;
    public ImageView bJZ;
    public TextView bKA;
    public LinearLayout bKB;
    public ImageView bKC;
    public TextView bKD;
    public ImageView bKa;
    public TextView bKb;
    public TextView bKc;
    public ImageView bKd;
    public ImageView bKe;
    public TbRichTextView bKf;
    public TextView bKg;
    public TbRichTextView bKh;
    public View bKi;
    public FrsPraiseView bKj;
    public ImageView bKk;
    public RelativeLayout bKl;
    public LinearLayout bKm;
    public ImageView bKn;
    public SubPbLayout bKo;
    public BaobaoTailView bKp;
    public LinearLayout bKq;
    public TextView bKr;
    public LinearLayout bKs;
    public Button bKt;
    public LinearLayout bKu;
    public TextView bKv;
    public View bKw;
    public View bKx;
    public LinearLayout bKy;
    public ImageView bKz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=5] */
    public cc(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.bJX = view.findViewById(com.baidu.tieba.v.sub_pb_more);
        this.bJY = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.azt = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.bJZ = (ImageView) view.findViewById(com.baidu.tieba.v.user_rank);
        this.bKa = (ImageView) view.findViewById(com.baidu.tieba.v.user_gender);
        this.bKe = (ImageView) view.findViewById(com.baidu.tieba.v.reply);
        this.bKf = (TbRichTextView) view.findViewById(com.baidu.tieba.v.richText);
        this.bKg = (TextView) view.findViewById(com.baidu.tieba.v.pb_act_btn);
        this.bKh = (TbRichTextView) view.findViewById(com.baidu.tieba.v.pb_act_img);
        this.bKi = view.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        this.bKj = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        this.bKk = (ImageView) view.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        this.bKy = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_item_location_container);
        this.bKA = (TextView) view.findViewById(com.baidu.tieba.v.pb_item_location_address);
        this.bKz = (ImageView) view.findViewById(com.baidu.tieba.v.pb_item_location_img);
        this.bKB = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_reply_location_container);
        this.bKD = (TextView) view.findViewById(com.baidu.tieba.v.pb_reply_location_address);
        this.bKC = (ImageView) view.findViewById(com.baidu.tieba.v.pb_reply_location_img);
        this.bKd = (ImageView) view.findViewById(com.baidu.tieba.v.floor_owner);
        this.bKb = (TextView) view.findViewById(com.baidu.tieba.v.floor);
        this.bKc = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bKl = (RelativeLayout) view.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        this.bKo = (SubPbLayout) view.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        this.bKm = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        this.bKn = (ImageView) view.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        this.bJT = view;
        this.bJU = view.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        this.bJV = view.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        this.bJW = view.findViewById(com.baidu.tieba.v.new_pb_list_item_blank_top);
        this.bKf.DM();
        this.bKf.setImageViewStretch(true);
        this.bKh.setMaxImageWidth(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - (((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds30)) * 2));
        this.bKh.setMaxImageHeight((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds484));
        int min = Math.min(((((com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.bKf.getPaddingLeft()) - this.bKf.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds60)), i);
        this.bKf.setMaxImageWidth(min);
        this.bKf.setMaxImageHeight((int) (min * 1.618f));
        this.bKf.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bJY.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds60);
            this.bJY.setLayoutParams(layoutParams);
            this.bJY.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.bJY.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds30);
            this.bJY.setLayoutParams(layoutParams2);
            this.bJY.setVisibility(4);
        }
        this.bKf.b(z2, false);
        this.bKf.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        this.aOi = (UserIconBox) view.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aIh = (UserIconBox) view.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.bKq = (LinearLayout) view.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        if (z3) {
            this.bKl.setVisibility(8);
            this.bKe.setVisibility(8);
            this.bKf.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bKf.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.bKf.setLayoutParams(layoutParams3);
            view.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.bKs = (LinearLayout) view.findViewById(com.baidu.tieba.v.add_time_container);
            this.bKr = (TextView) view.findViewById(com.baidu.tieba.v.add_time);
            this.bKt = (Button) view.findViewById(com.baidu.tieba.v.manage_btn);
            this.bKs.setVisibility(0);
        }
        this.bKu = (LinearLayout) view.findViewById(com.baidu.tieba.v.addition_more_container);
        this.bKv = (TextView) this.bKu.findViewById(com.baidu.tieba.v.addition_more);
        this.bKw = this.bKu.findViewById(com.baidu.tieba.v.addition_divider1);
        this.bKx = this.bKu.findViewById(com.baidu.tieba.v.addition_divider2);
        this.bKp = (BaobaoTailView) view.findViewById(com.baidu.tieba.v.baobao_tail);
    }
}
