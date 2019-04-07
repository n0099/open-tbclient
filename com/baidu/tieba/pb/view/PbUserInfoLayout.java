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
    public TextView dYR;
    public View hFY;
    public View hFZ;
    public PbFloorAgreeView hGa;
    public ImageView hGb;
    public PostPraiseView hGc;
    public PostDisPraiseView hGd;
    private com.baidu.tieba.pb.pb.main.b.a hmK;
    public TextView hpH;
    public TextView hpI;
    public TextView hpL;
    public HeadImageView hpN;
    public TextView hpT;
    public ImageView hpU;
    public HeadPendantView hpV;
    public UserIconBox hpW;
    public UserIconBox hpX;
    private com.baidu.tieba.pb.pb.a hzQ;
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
        this.dYR = (TextView) findViewById(d.g.view_user_name);
        this.hpH = (TextView) findViewById(d.g.view_author_tip);
        this.hpI = (TextView) findViewById(d.g.view_post_time);
        this.hpU = (ImageView) findViewById(d.g.icon_forum_level);
        this.hpL = (TextView) findViewById(d.g.view_location);
        this.hGb = (ImageView) findViewById(d.g.image_more_tip);
        this.hGa = (PbFloorAgreeView) findViewById(d.g.view_floor_praise);
        this.hGc = (PostPraiseView) findViewById(d.g.view_floor_new_praise);
        this.hGd = (PostDisPraiseView) findViewById(d.g.view_floor_new_dispraise);
        this.hpN = (HeadImageView) findViewById(d.g.normal_user_photo);
        this.hpV = (HeadPendantView) findViewById(d.g.pendant_user_photo);
        this.hpV.setHasPendantStyle();
        if (this.hpV.getHeadView() != null) {
            this.hpV.getHeadView().setIsRound(true);
            this.hpV.getHeadView().setDrawBorder(false);
        }
        this.hpW = (UserIconBox) findViewById(d.g.show_icon_vip);
        this.hpX = (UserIconBox) findViewById(d.g.show_icon_yinji);
        this.hpT = (TextView) findViewById(d.g.floor_num);
        this.hFY = findViewById(d.g.line_between_floor_and_time);
        this.hFZ = findViewById(d.g.line_between_time_and_locate);
        this.hpN.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hzQ = aVar;
        if (this.hzQ != null) {
            this.hmK = this.hzQ.bIM();
        }
    }
}
