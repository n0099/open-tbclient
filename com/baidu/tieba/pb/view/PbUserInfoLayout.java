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
    private static int emT = 20;
    public TextView cKl;
    private com.baidu.tieba.pb.pb.main.b.a fSY;
    public TextView fVP;
    public TextView fVQ;
    public View fVR;
    public View fVS;
    public TextView fVT;
    public ImageView fVU;
    public PostPraiseView fVV;
    public PostDisPraiseView fVW;
    public HeadImageView fVX;
    public TextView fWb;
    public ImageView fWc;
    public HeadPendantView fWd;
    public UserIconBox fWe;
    public UserIconBox fWf;
    private com.baidu.tieba.pb.pb.a ggl;
    public PbFloorAgreeView gmk;
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
        this.cKl = (TextView) findViewById(e.g.view_user_name);
        this.fVP = (TextView) findViewById(e.g.view_author_tip);
        this.fVQ = (TextView) findViewById(e.g.view_post_time);
        this.fWc = (ImageView) findViewById(e.g.icon_forum_level);
        this.fVT = (TextView) findViewById(e.g.view_location);
        this.fVU = (ImageView) findViewById(e.g.image_more_tip);
        this.gmk = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fVV = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fVW = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fVX = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fWd = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fWd.setHasPendantStyle();
        if (this.fWd.getHeadView() != null) {
            this.fWd.getHeadView().setIsRound(true);
            this.fWd.getHeadView().setDrawBorder(false);
        }
        this.fWe = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fWf = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fWb = (TextView) findViewById(e.g.floor_num);
        this.fVR = findViewById(e.g.line_between_floor_and_time);
        this.fVS = findViewById(e.g.line_between_time_and_locate);
        this.fVX.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.ggl = aVar;
        if (this.ggl != null) {
            this.fSY = this.ggl.bhd();
        }
    }
}
