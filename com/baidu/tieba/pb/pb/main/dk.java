package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dk extends y.a {
    public TextView aLz;
    UserIconBox adH;
    public UserIconBox bvy;
    public TbRichTextView dfT;
    public TextView dhP;
    public View dhh;
    public View dhi;
    public View dhj;
    public View dhk;
    public View dhl;
    public HeadImageView dhm;
    public ImageView dhp;
    public TextView dhq;
    public TextView dhr;
    public ImageView dht;
    public RelativeLayout dhu;
    public LinearLayout dhv;
    public ImageView dhw;
    public SubPbLayout dhx;
    public ImageView dkC;
    public ImageView dmn;
    public PbNewChudianCommonView dmo;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=5] */
    public dk(View view, boolean z, boolean z2, int i) {
        super(view);
        this.dhl = view.findViewById(t.g.sub_pb_more);
        this.dhm = (HeadImageView) view.findViewById(t.g.photo);
        this.dhm.setIsRound(true);
        this.aLz = (TextView) view.findViewById(t.g.user_name);
        this.dmn = (ImageView) view.findViewById(t.g.advertise);
        this.dhp = (ImageView) view.findViewById(t.g.user_gender);
        this.dht = (ImageView) view.findViewById(t.g.reply);
        this.dfT = (TbRichTextView) view.findViewById(t.g.richText);
        this.dhq = (TextView) view.findViewById(t.g.floor);
        this.dhr = (TextView) view.findViewById(t.g.time);
        this.dhu = (RelativeLayout) view.findViewById(t.g.pb_post_header_layout);
        this.dhx = (SubPbLayout) view.findViewById(t.g.pb_post_footer_layout);
        this.dhv = (LinearLayout) view.findViewById(t.g.pb_subpb_layout_root);
        this.dhw = (ImageView) view.findViewById(t.g.pb_post_footer_layout_line_top);
        this.dhh = view;
        this.dhi = view.findViewById(t.g.new_pb_list_item_line_top);
        this.dhj = view.findViewById(t.g.new_pb_list_item_line_top_full);
        this.dhk = view.findViewById(t.g.new_pb_list_item_blank_top);
        this.dfT.Ho();
        this.dfT.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.dfT.getPaddingLeft()) - this.dfT.getPaddingRight()) - ((int) TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds60)), i);
        this.dfT.setMaxImageWidth(min);
        this.dfT.setMaxImageHeight((int) (min * 1.618f));
        this.dfT.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.dhm.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds60);
            this.dhm.setLayoutParams(layoutParams);
            this.dhm.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.dhm.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds30);
            this.dhm.setLayoutParams(layoutParams2);
            this.dhm.setVisibility(4);
        }
        this.dfT.h(z2, false);
        this.dfT.setVoiceViewRes(t.h.voice_play_btn);
        this.bvy = (UserIconBox) view.findViewById(t.g.user_icon_box);
        this.adH = (UserIconBox) view.findViewById(t.g.user_tshow_icon_box);
        this.dhP = (TextView) view.findViewById(t.g.pb_item_tail_content);
        this.dkC = (ImageView) view.findViewById(t.g.replybtn);
        this.dmo = (PbNewChudianCommonView) view.findViewById(t.g.newchudian_common);
    }
}
