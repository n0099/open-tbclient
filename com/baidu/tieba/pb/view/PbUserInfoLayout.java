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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
/* loaded from: classes4.dex */
public class PbUserInfoLayout extends FrameLayout {
    private static int fCF = 20;
    public TextView dYS;
    public View hFZ;
    public View hGa;
    public PbFloorAgreeView hGb;
    public ImageView hGc;
    public PostPraiseView hGd;
    public PostDisPraiseView hGe;
    private com.baidu.tieba.pb.pb.main.b.a hmL;
    public TextView hpI;
    public TextView hpJ;
    public TextView hpM;
    public HeadImageView hpO;
    public TextView hpU;
    public ImageView hpV;
    public HeadPendantView hpW;
    public UserIconBox hpX;
    public UserIconBox hpY;
    private com.baidu.tieba.pb.pb.a hzR;
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
        LayoutInflater.from(getContext()).inflate(d.h.pb_user_info_layout, (ViewGroup) this, true);
        this.dYS = (TextView) findViewById(d.g.view_user_name);
        this.hpI = (TextView) findViewById(d.g.view_author_tip);
        this.hpJ = (TextView) findViewById(d.g.view_post_time);
        this.hpV = (ImageView) findViewById(d.g.icon_forum_level);
        this.hpM = (TextView) findViewById(d.g.view_location);
        this.hGc = (ImageView) findViewById(d.g.image_more_tip);
        this.hGb = (PbFloorAgreeView) findViewById(d.g.view_floor_praise);
        this.hGd = (PostPraiseView) findViewById(d.g.view_floor_new_praise);
        this.hGe = (PostDisPraiseView) findViewById(d.g.view_floor_new_dispraise);
        this.hpO = (HeadImageView) findViewById(d.g.normal_user_photo);
        this.hpW = (HeadPendantView) findViewById(d.g.pendant_user_photo);
        this.hpW.setHasPendantStyle();
        if (this.hpW.getHeadView() != null) {
            this.hpW.getHeadView().setIsRound(true);
            this.hpW.getHeadView().setDrawBorder(false);
        }
        this.hpX = (UserIconBox) findViewById(d.g.show_icon_vip);
        this.hpY = (UserIconBox) findViewById(d.g.show_icon_yinji);
        this.hpU = (TextView) findViewById(d.g.floor_num);
        this.hFZ = findViewById(d.g.line_between_floor_and_time);
        this.hGa = findViewById(d.g.line_between_time_and_locate);
        this.hpO.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hzR = aVar;
        if (this.hzR != null) {
            this.hmL = this.hzR.bIM();
        }
    }
}
