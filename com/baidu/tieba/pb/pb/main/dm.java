package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dm extends z.a {
    public TextView aTT;
    public View avx;
    public View avy;
    public TextView bOa;
    public TextView ekV;
    public boolean eka;
    public View ekp;
    public ConstrainImageGroup eoA;
    public SubPbLayout eoB;
    public TextView eoC;
    public ImageView eoD;
    public HeadPendantView eoE;
    public UserIconBox eoF;
    public UserIconBox eoG;
    public LinearLayout eos;
    public TextView eot;
    public TextView eou;
    public TextView eov;
    public PbFloorAgreeView eow;
    public ImageView eox;
    public HeadImageView eoy;
    public TbRichTextView eoz;
    public int mSkinType;

    public dm(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eka = true;
        if (tbPageContext != null && view != null) {
            this.ekp = view;
            this.avx = view.findViewById(w.h.top_divider_line);
            this.aTT = (TextView) view.findViewById(w.h.view_user_name);
            this.eos = (LinearLayout) view.findViewById(w.h.content_user_and_praise);
            this.eot = (TextView) view.findViewById(w.h.view_author_tip);
            this.eou = (TextView) view.findViewById(w.h.view_post_time);
            this.bOa = (TextView) view.findViewById(w.h.view_forum_name);
            this.eoD = (ImageView) view.findViewById(w.h.icon_forum_level);
            this.eov = (TextView) view.findViewById(w.h.view_location);
            this.eox = (ImageView) view.findViewById(w.h.image_more_tip);
            this.eow = (PbFloorAgreeView) view.findViewById(w.h.view_floor_praise);
            this.eoy = (HeadImageView) view.findViewById(w.h.normal_user_photo);
            this.eoE = (HeadPendantView) view.findViewById(w.h.pendant_user_photo);
            this.eoE.vV();
            if (this.eoE.getHeadView() != null) {
                this.eoE.getHeadView().setIsRound(true);
                this.eoE.getHeadView().setDrawBorder(false);
            }
            if (this.eoE.getPendantView() != null) {
                this.eoE.getPendantView().setIsRound(true);
                this.eoE.getPendantView().setDrawBorder(false);
            }
            this.eoF = (UserIconBox) view.findViewById(w.h.show_icon_vip);
            this.eoG = (UserIconBox) view.findViewById(w.h.show_icon_yinji);
            this.eoz = (TbRichTextView) view.findViewById(w.h.richText);
            this.eoB = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
            this.eoA = (ConstrainImageGroup) view.findViewById(w.h.floor_images_content);
            this.avy = view.findViewById(w.h.pb_bottom_line);
            this.eoC = (TextView) view.findViewById(w.h.floor_num);
            this.eoA.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16));
            this.eoA.setSingleImageRatio(0.75d);
            this.eoA.setImageProcessor(new com.baidu.tbadk.widget.layout.i(3));
            this.eoz.Il();
            this.eoz.setImageViewStretch(true);
            this.eoz.setTextSize(TbConfig.getContentSize());
            this.eoy.setIsRound(true);
            this.eoz.j(this.eka, false);
            this.eoz.setVoiceViewRes(w.j.voice_play_btn_new);
            this.ekV = (TextView) view.findViewById(w.h.pb_item_tail_content);
        }
    }
}
