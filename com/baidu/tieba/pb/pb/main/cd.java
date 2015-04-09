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
public class cd extends com.baidu.adp.widget.ListView.am {
    UserIconBox aIp;
    public UserIconBox aOz;
    public TextView azB;
    public RelativeLayout bKA;
    public LinearLayout bKB;
    public ImageView bKC;
    public SubPbLayout bKD;
    public BaobaoTailView bKE;
    public LinearLayout bKF;
    public TextView bKG;
    public LinearLayout bKH;
    public Button bKI;
    public LinearLayout bKJ;
    public TextView bKK;
    public View bKL;
    public View bKM;
    public LinearLayout bKN;
    public ImageView bKO;
    public TextView bKP;
    public LinearLayout bKQ;
    public ImageView bKR;
    public TextView bKS;
    public View bKi;
    public View bKj;
    public View bKk;
    public View bKl;
    public View bKm;
    public HeadImageView bKn;
    public ImageView bKo;
    public ImageView bKp;
    public TextView bKq;
    public TextView bKr;
    public ImageView bKs;
    public ImageView bKt;
    public TbRichTextView bKu;
    public TextView bKv;
    public TbRichTextView bKw;
    public View bKx;
    public FrsPraiseView bKy;
    public ImageView bKz;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=5] */
    public cd(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.bKm = view.findViewById(com.baidu.tieba.v.sub_pb_more);
        this.bKn = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.azB = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.bKo = (ImageView) view.findViewById(com.baidu.tieba.v.user_rank);
        this.bKp = (ImageView) view.findViewById(com.baidu.tieba.v.user_gender);
        this.bKt = (ImageView) view.findViewById(com.baidu.tieba.v.reply);
        this.bKu = (TbRichTextView) view.findViewById(com.baidu.tieba.v.richText);
        this.bKv = (TextView) view.findViewById(com.baidu.tieba.v.pb_act_btn);
        this.bKw = (TbRichTextView) view.findViewById(com.baidu.tieba.v.pb_act_img);
        this.bKx = view.findViewById(com.baidu.tieba.v.pb_item_praise_topline);
        this.bKy = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.pb_item_praise_view);
        this.bKz = (ImageView) view.findViewById(com.baidu.tieba.v.pb_item_praise_bottomline);
        this.bKN = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_item_location_container);
        this.bKP = (TextView) view.findViewById(com.baidu.tieba.v.pb_item_location_address);
        this.bKO = (ImageView) view.findViewById(com.baidu.tieba.v.pb_item_location_img);
        this.bKQ = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_reply_location_container);
        this.bKS = (TextView) view.findViewById(com.baidu.tieba.v.pb_reply_location_address);
        this.bKR = (ImageView) view.findViewById(com.baidu.tieba.v.pb_reply_location_img);
        this.bKs = (ImageView) view.findViewById(com.baidu.tieba.v.floor_owner);
        this.bKq = (TextView) view.findViewById(com.baidu.tieba.v.floor);
        this.bKr = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bKA = (RelativeLayout) view.findViewById(com.baidu.tieba.v.pb_post_header_layout);
        this.bKD = (SubPbLayout) view.findViewById(com.baidu.tieba.v.pb_post_footer_layout);
        this.bKB = (LinearLayout) view.findViewById(com.baidu.tieba.v.pb_subpb_layout_root);
        this.bKC = (ImageView) view.findViewById(com.baidu.tieba.v.pb_post_footer_layout_line_top);
        this.bKi = view;
        this.bKj = view.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top);
        this.bKk = view.findViewById(com.baidu.tieba.v.new_pb_list_item_line_top_full);
        this.bKl = view.findViewById(com.baidu.tieba.v.new_pb_list_item_blank_top);
        this.bKu.DS();
        this.bKu.setImageViewStretch(true);
        this.bKw.setMaxImageWidth(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - (((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds30)) * 2));
        this.bKw.setMaxImageHeight((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds484));
        int min = Math.min(((((com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.bKu.getPaddingLeft()) - this.bKu.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds60)), i);
        this.bKu.setMaxImageWidth(min);
        this.bKu.setMaxImageHeight((int) (min * 1.618f));
        this.bKu.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bKn.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds60);
            this.bKn.setLayoutParams(layoutParams);
            this.bKn.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.bKn.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(com.baidu.tieba.t.ds30);
            this.bKn.setLayoutParams(layoutParams2);
            this.bKn.setVisibility(4);
        }
        this.bKu.b(z2, false);
        this.bKu.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        this.aOz = (UserIconBox) view.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aIp = (UserIconBox) view.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.bKF = (LinearLayout) view.findViewById(com.baidu.tieba.v.add_post_footer_layout);
        if (z3) {
            this.bKA.setVisibility(8);
            this.bKt.setVisibility(8);
            this.bKu.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bKu.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.bKu.setLayoutParams(layoutParams3);
            view.findViewById(com.baidu.tieba.v.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.bKH = (LinearLayout) view.findViewById(com.baidu.tieba.v.add_time_container);
            this.bKG = (TextView) view.findViewById(com.baidu.tieba.v.add_time);
            this.bKI = (Button) view.findViewById(com.baidu.tieba.v.manage_btn);
            this.bKH.setVisibility(0);
        }
        this.bKJ = (LinearLayout) view.findViewById(com.baidu.tieba.v.addition_more_container);
        this.bKK = (TextView) this.bKJ.findViewById(com.baidu.tieba.v.addition_more);
        this.bKL = this.bKJ.findViewById(com.baidu.tieba.v.addition_divider1);
        this.bKM = this.bKJ.findViewById(com.baidu.tieba.v.addition_divider2);
        this.bKE = (BaobaoTailView) view.findViewById(com.baidu.tieba.v.baobao_tail);
    }
}
