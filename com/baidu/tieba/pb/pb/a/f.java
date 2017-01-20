package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
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
public class f extends y.a {
    UserIconBox agL;
    public UserIconBox bXk;
    public TextView blu;
    public HeadPendantView egA;
    public HeadImageView egB;
    public ImageView egC;
    public ImageView egD;
    public TextView egE;
    public TextView egF;
    public TextView egG;
    public TbRichTextView egH;
    public FrsPraiseView egI;
    public ImageView egJ;
    public PbGiftListView egK;
    public RelativeLayout egL;
    public SubPbLayout egM;
    public RelativeLayout egN;
    public RelativeLayout egO;
    public View egP;
    public LinearLayout egQ;
    public TextView egR;
    public LinearLayout egS;
    public Button egT;
    public LinearLayout egU;
    public TextView egV;
    public View egW;
    public View egX;
    public RelativeLayout egY;
    public TextView egZ;
    public View egx;
    public View egy;
    public View egz;
    public TextView eha;
    public TextView ehb;
    public TextView ehc;
    public TextView ehd;
    public TriangleShapeView ehe;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public f(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.egz = view.findViewById(r.h.sub_pb_more);
        this.egN = (RelativeLayout) view.findViewById(r.h.user_head_layout);
        this.egO = (RelativeLayout) view.findViewById(r.h.pb_item_floor_layout);
        this.egB = (HeadImageView) view.findViewById(r.h.photo);
        this.egA = (HeadPendantView) view.findViewById(r.h.pendant_photo);
        this.egA.vS();
        if (this.egA.getHeadView() != null) {
            this.egA.getHeadView().setIsRound(true);
            this.egA.getHeadView().setDrawBorder(false);
        }
        if (this.egA.getPendantView() != null) {
            this.egA.getPendantView().setIsRound(true);
            this.egA.getPendantView().setDrawBorder(false);
        }
        this.blu = (TextView) view.findViewById(r.h.user_name);
        this.egC = (ImageView) view.findViewById(r.h.user_rank);
        this.egD = (ImageView) view.findViewById(r.h.user_bawu);
        this.egH = (TbRichTextView) view.findViewById(r.h.richText);
        this.egI = (FrsPraiseView) view.findViewById(r.h.pb_item_praise_view);
        this.egJ = (ImageView) view.findViewById(r.h.pb_item_praise_bottomline);
        this.egK = (PbGiftListView) view.findViewById(r.h.gift_list_view);
        this.egY = (RelativeLayout) view.findViewById(r.h.pb_first_floor_location_container);
        this.egZ = (TextView) view.findViewById(r.h.pb_item_first_floor_name);
        this.eha = (TextView) view.findViewById(r.h.pb_item_first_floor_reply_time);
        this.ehb = (TextView) view.findViewById(r.h.pb_item_first_floor_location_address);
        this.ehc = (TextView) view.findViewById(r.h.pb_reply_location_address);
        this.egG = (TextView) view.findViewById(r.h.floor_owner);
        this.egE = (TextView) view.findViewById(r.h.floor);
        this.egF = (TextView) view.findViewById(r.h.time);
        this.egL = (RelativeLayout) view.findViewById(r.h.pb_post_header_layout);
        this.egM = (SubPbLayout) view.findViewById(r.h.pb_post_footer_layout);
        this.egx = view;
        this.egy = view.findViewById(r.h.new_pb_list_item_blank_top);
        this.egP = view.findViewById(r.h.new_pb_list_item_line_full);
        this.egH.Id();
        this.egH.setImageViewStretch(true);
        int min = Math.min(((((k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.egH.getPaddingLeft()) - this.egH.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds60)), i);
        this.egH.setMaxImageWidth(min);
        this.egH.setMaxImageHeight((int) (min * 1.618f));
        this.egH.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.egB.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds60);
        this.egB.setLayoutParams(layoutParams);
        this.egB.setVisibility(0);
        this.egH.j(z, false);
        this.egH.setVoiceViewRes(r.j.voice_play_btn);
        this.bXk = (UserIconBox) view.findViewById(r.h.user_icon_box);
        this.agL = (UserIconBox) view.findViewById(r.h.user_tshow_icon_box);
        this.egQ = (LinearLayout) view.findViewById(r.h.add_post_footer_layout);
        if (z2) {
            this.egL.setVisibility(8);
            this.egH.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.egH.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.egH.setLayoutParams(layoutParams2);
            view.findViewById(r.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.egS = (LinearLayout) view.findViewById(r.h.add_time_container);
            this.egR = (TextView) view.findViewById(r.h.add_time);
            this.egT = (Button) view.findViewById(r.h.manage_btn);
            this.egS.setVisibility(0);
        }
        this.egU = (LinearLayout) view.findViewById(r.h.addition_more_container);
        this.egV = (TextView) this.egU.findViewById(r.h.addition_more);
        this.egW = this.egU.findViewById(r.h.addition_divider1);
        this.egX = this.egU.findViewById(r.h.addition_divider2);
        this.ehd = (TextView) view.findViewById(r.h.pb_item_tail_content);
        this.ehe = (TriangleShapeView) view.findViewById(r.h.triangle_view);
    }
}
