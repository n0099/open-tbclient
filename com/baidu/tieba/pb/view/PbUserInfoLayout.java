package com.baidu.tieba.pb.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
/* loaded from: classes6.dex */
public class PbUserInfoLayout extends FrameLayout {
    private static int eeG = 20;
    public TextView cGZ;
    private com.baidu.tieba.pb.pb.main.b.a fKI;
    public TextView fNA;
    public View fNB;
    public View fNC;
    public TextView fND;
    public ImageView fNE;
    public PostPraiseView fNF;
    public PostDisPraiseView fNG;
    public HeadImageView fNH;
    public TextView fNL;
    public ImageView fNM;
    public HeadPendantView fNN;
    public UserIconBox fNO;
    public UserIconBox fNP;
    public TextView fNz;
    private com.baidu.tieba.pb.pb.a fXU;
    public PbFloorAgreeView gdV;
    private int mSkinType;

    public PbUserInfoLayout(@NonNull Context context) {
        this(context, null);
    }

    public PbUserInfoLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.pb_user_info_layout, (ViewGroup) this, true);
        this.cGZ = (TextView) findViewById(e.g.view_user_name);
        this.fNz = (TextView) findViewById(e.g.view_author_tip);
        this.fNA = (TextView) findViewById(e.g.view_post_time);
        this.fNM = (ImageView) findViewById(e.g.icon_forum_level);
        this.fND = (TextView) findViewById(e.g.view_location);
        this.fNE = (ImageView) findViewById(e.g.image_more_tip);
        this.gdV = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fNF = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fNG = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fNH = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fNN = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fNN.setHasPendantStyle();
        if (this.fNN.getHeadView() != null) {
            this.fNN.getHeadView().setIsRound(true);
            this.fNN.getHeadView().setDrawBorder(false);
        }
        this.fNO = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fNP = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fNL = (TextView) findViewById(e.g.floor_num);
        this.fNB = findViewById(e.g.line_between_floor_and_time);
        this.fNC = findViewById(e.g.line_between_time_and_locate);
        this.fNH.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.fXU = aVar;
        if (this.fXU != null) {
            this.fKI = this.fXU.bfP();
        }
    }
}
