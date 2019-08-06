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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
/* loaded from: classes4.dex */
public class PbUserInfoLayout extends FrameLayout {
    private static int fZs = 20;
    public TextView eog;
    private com.baidu.tieba.pb.pb.main.b.a hLx;
    public HeadImageView hOB;
    public TextView hOH;
    public ImageView hOI;
    public HeadPendantView hOJ;
    public UserIconBox hOK;
    public UserIconBox hOL;
    public TextView hOv;
    public TextView hOw;
    public TextView hOz;
    private com.baidu.tieba.pb.pb.a hYO;
    public PostDisPraiseView ifA;
    public View ifv;
    public View ifw;
    public PbFloorAgreeView ifx;
    public ImageView ify;
    public PostPraiseView ifz;
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
        LayoutInflater.from(getContext()).inflate(R.layout.pb_user_info_layout, (ViewGroup) this, true);
        this.eog = (TextView) findViewById(R.id.view_user_name);
        this.hOv = (TextView) findViewById(R.id.view_author_tip);
        this.hOw = (TextView) findViewById(R.id.view_post_time);
        this.hOI = (ImageView) findViewById(R.id.icon_forum_level);
        this.hOz = (TextView) findViewById(R.id.view_location);
        this.ify = (ImageView) findViewById(R.id.image_more_tip);
        this.ifx = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.ifz = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.ifA = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hOB = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hOJ = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hOJ.setHasPendantStyle();
        if (this.hOJ.getHeadView() != null) {
            this.hOJ.getHeadView().setIsRound(true);
            this.hOJ.getHeadView().setDrawBorder(false);
        }
        this.hOK = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hOL = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hOH = (TextView) findViewById(R.id.floor_num);
        this.ifv = findViewById(R.id.line_between_floor_and_time);
        this.ifw = findViewById(R.id.line_between_time_and_locate);
        this.hOB.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hYO = aVar;
        if (this.hYO != null) {
            this.hLx = this.hYO.bTG();
        }
    }
}
