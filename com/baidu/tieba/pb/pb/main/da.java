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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class da extends x.a {
    public TextView aPp;
    UserIconBox ahN;
    public UserIconBox bvK;
    public TbRichTextView ddA;
    public View deO;
    public View deP;
    public View deQ;
    public View deR;
    public View deS;
    public HeadImageView deT;
    public ImageView deU;
    public ImageView deW;
    public TextView deX;
    public TextView deY;
    public ImageView deZ;
    public ImageView dfa;
    public RelativeLayout dfb;
    public LinearLayout dfc;
    public ImageView dfd;
    public SubPbLayout dfe;
    public TextView dfu;
    public ImageView diq;
    public RelativeLayout dir;
    public LinearLayout dis;
    public ImageView dit;
    public TextView diu;
    public ImageView div;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [99=5] */
    public da(View view, boolean z, boolean z2, int i) {
        super(view);
        this.deS = view.findViewById(t.g.sub_pb_more);
        this.deT = (HeadImageView) view.findViewById(t.g.photo);
        this.aPp = (TextView) view.findViewById(t.g.user_name);
        this.deU = (ImageView) view.findViewById(t.g.user_rank);
        this.deW = (ImageView) view.findViewById(t.g.user_gender);
        this.dfa = (ImageView) view.findViewById(t.g.reply);
        this.ddA = (TbRichTextView) view.findViewById(t.g.richText);
        this.deZ = (ImageView) view.findViewById(t.g.floor_owner);
        this.deX = (TextView) view.findViewById(t.g.floor);
        this.deY = (TextView) view.findViewById(t.g.time);
        this.dfb = (RelativeLayout) view.findViewById(t.g.pb_post_header_layout);
        this.dfe = (SubPbLayout) view.findViewById(t.g.pb_post_footer_layout);
        this.dfc = (LinearLayout) view.findViewById(t.g.pb_subpb_layout_root);
        this.dfd = (ImageView) view.findViewById(t.g.pb_post_footer_layout_line_top);
        this.deO = view;
        this.deP = view.findViewById(t.g.new_pb_list_item_line_top);
        this.deQ = view.findViewById(t.g.new_pb_list_item_line_top_full);
        this.deR = view.findViewById(t.g.new_pb_list_item_blank_top);
        this.dir = (RelativeLayout) view.findViewById(t.g.chudian_info_container);
        this.dis = (LinearLayout) view.findViewById(t.g.landmark_container);
        this.dit = (ImageView) view.findViewById(t.g.landmark_icon);
        this.diu = (TextView) view.findViewById(t.g.landmark_content);
        this.div = (ImageView) view.findViewById(t.g.ad_icon);
        this.ddA.IY();
        this.ddA.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ddA.getPaddingLeft()) - this.ddA.getPaddingRight()) - ((int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60)), i);
        this.ddA.setMaxImageWidth(min);
        this.ddA.setMaxImageHeight((int) (min * 1.618f));
        this.ddA.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.deT.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds60);
            this.deT.setLayoutParams(layoutParams);
            this.deT.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.deT.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds30);
            this.deT.setLayoutParams(layoutParams2);
            this.deT.setVisibility(4);
        }
        this.ddA.h(z2, false);
        this.ddA.setVoiceViewRes(t.h.voice_play_btn);
        this.bvK = (UserIconBox) view.findViewById(t.g.user_icon_box);
        this.ahN = (UserIconBox) view.findViewById(t.g.user_tshow_icon_box);
        this.dfu = (TextView) view.findViewById(t.g.pb_item_tail_content);
        this.diq = (ImageView) view.findViewById(t.g.replybtn);
    }
}
