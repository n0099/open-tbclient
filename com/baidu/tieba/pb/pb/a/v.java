package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class v extends y.a {
    UserIconBox ahx;
    public UserIconBox bQG;
    public TextView bbH;
    public View dXQ;
    public View dXR;
    public View dXS;
    public HeadPendantView dXT;
    public HeadImageView dXU;
    public ImageView dXV;
    public ImageView dXW;
    public TextView dXX;
    public TextView dXY;
    public TextView dXZ;
    public TbRichTextView dYa;
    public FrsPraiseView dYb;
    public ImageView dYc;
    public PbGiftListView dYd;
    public RelativeLayout dYe;
    public SubPbLayout dYf;
    public RelativeLayout dYg;
    public RelativeLayout dYh;
    public View dYi;
    public LinearLayout dYj;
    public TextView dYk;
    public LinearLayout dYl;
    public Button dYm;
    public LinearLayout dYn;
    public TextView dYo;
    public View dYp;
    public View dYq;
    public RelativeLayout dYr;
    public TextView dYs;
    public TextView dYt;
    public TextView dYu;
    public TextView dYv;
    public TextView dYw;
    public TriangleShapeView dYx;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public v(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.dXS = view.findViewById(r.g.sub_pb_more);
        this.dYg = (RelativeLayout) view.findViewById(r.g.user_head_layout);
        this.dYh = (RelativeLayout) view.findViewById(r.g.pb_item_floor_layout);
        this.dXU = (HeadImageView) view.findViewById(r.g.photo);
        this.dXT = (HeadPendantView) view.findViewById(r.g.pendant_photo);
        this.dXT.vY();
        if (this.dXT.getHeadView() != null) {
            this.dXT.getHeadView().setIsRound(true);
            this.dXT.getHeadView().setDrawBorder(false);
        }
        if (this.dXT.getPendantView() != null) {
            this.dXT.getPendantView().setIsRound(true);
            this.dXT.getPendantView().setDrawBorder(false);
        }
        this.bbH = (TextView) view.findViewById(r.g.user_name);
        this.dXV = (ImageView) view.findViewById(r.g.user_rank);
        this.dXW = (ImageView) view.findViewById(r.g.user_bawu);
        this.dYa = (TbRichTextView) view.findViewById(r.g.richText);
        this.dYb = (FrsPraiseView) view.findViewById(r.g.pb_item_praise_view);
        this.dYc = (ImageView) view.findViewById(r.g.pb_item_praise_bottomline);
        this.dYd = (PbGiftListView) view.findViewById(r.g.gift_list_view);
        this.dYr = (RelativeLayout) view.findViewById(r.g.pb_first_floor_location_container);
        this.dYs = (TextView) view.findViewById(r.g.pb_item_first_floor_name);
        this.dYt = (TextView) view.findViewById(r.g.pb_item_first_floor_reply_time);
        this.dYu = (TextView) view.findViewById(r.g.pb_item_first_floor_location_address);
        this.dYv = (TextView) view.findViewById(r.g.pb_reply_location_address);
        this.dXZ = (TextView) view.findViewById(r.g.floor_owner);
        this.dXX = (TextView) view.findViewById(r.g.floor);
        this.dXY = (TextView) view.findViewById(r.g.time);
        this.dYe = (RelativeLayout) view.findViewById(r.g.pb_post_header_layout);
        this.dYf = (SubPbLayout) view.findViewById(r.g.pb_post_footer_layout);
        this.dXQ = view;
        this.dXR = view.findViewById(r.g.new_pb_list_item_blank_top);
        this.dYi = view.findViewById(r.g.new_pb_list_item_line_full);
        this.dYa.Im();
        this.dYa.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.dYa.getPaddingLeft()) - this.dYa.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60)), i);
        this.dYa.setMaxImageWidth(min);
        this.dYa.setMaxImageHeight((int) (min * 1.618f));
        this.dYa.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.dXU.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60);
        this.dXU.setLayoutParams(layoutParams);
        this.dXU.setVisibility(0);
        this.dYa.j(z, false);
        this.dYa.setVoiceViewRes(r.h.voice_play_btn);
        this.bQG = (UserIconBox) view.findViewById(r.g.user_icon_box);
        this.ahx = (UserIconBox) view.findViewById(r.g.user_tshow_icon_box);
        this.dYj = (LinearLayout) view.findViewById(r.g.add_post_footer_layout);
        if (z2) {
            this.dYe.setVisibility(8);
            this.dYa.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dYa.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.dYa.setLayoutParams(layoutParams2);
            view.findViewById(r.g.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.dYl = (LinearLayout) view.findViewById(r.g.add_time_container);
            this.dYk = (TextView) view.findViewById(r.g.add_time);
            this.dYm = (Button) view.findViewById(r.g.manage_btn);
            this.dYl.setVisibility(0);
        }
        this.dYn = (LinearLayout) view.findViewById(r.g.addition_more_container);
        this.dYo = (TextView) this.dYn.findViewById(r.g.addition_more);
        this.dYp = this.dYn.findViewById(r.g.addition_divider1);
        this.dYq = this.dYn.findViewById(r.g.addition_divider2);
        this.dYw = (TextView) view.findViewById(r.g.pb_item_tail_content);
        this.dYx = (TriangleShapeView) view.findViewById(r.g.triangle_view);
    }
}
