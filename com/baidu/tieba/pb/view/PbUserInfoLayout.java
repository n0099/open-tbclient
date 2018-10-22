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
    private static int eeH = 20;
    public TextView cGZ;
    private com.baidu.tieba.pb.pb.main.b.a fKJ;
    public TextView fNA;
    public TextView fNB;
    public View fNC;
    public View fND;
    public TextView fNE;
    public ImageView fNF;
    public PostPraiseView fNG;
    public PostDisPraiseView fNH;
    public HeadImageView fNI;
    public TextView fNM;
    public ImageView fNN;
    public HeadPendantView fNO;
    public UserIconBox fNP;
    public UserIconBox fNQ;
    private com.baidu.tieba.pb.pb.a fXV;
    public PbFloorAgreeView gdW;
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
        this.fNA = (TextView) findViewById(e.g.view_author_tip);
        this.fNB = (TextView) findViewById(e.g.view_post_time);
        this.fNN = (ImageView) findViewById(e.g.icon_forum_level);
        this.fNE = (TextView) findViewById(e.g.view_location);
        this.fNF = (ImageView) findViewById(e.g.image_more_tip);
        this.gdW = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fNG = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fNH = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fNI = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fNO = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fNO.setHasPendantStyle();
        if (this.fNO.getHeadView() != null) {
            this.fNO.getHeadView().setIsRound(true);
            this.fNO.getHeadView().setDrawBorder(false);
        }
        this.fNP = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fNQ = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fNM = (TextView) findViewById(e.g.floor_num);
        this.fNC = findViewById(e.g.line_between_floor_and_time);
        this.fND = findViewById(e.g.line_between_time_and_locate);
        this.fNI.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.fXV = aVar;
        if (this.fXV != null) {
            this.fKJ = this.fXV.bfP();
        }
    }
}
