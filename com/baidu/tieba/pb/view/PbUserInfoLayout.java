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
    private static int fZQ = 20;
    public TextView ezp;
    private com.baidu.tieba.pb.pb.main.b.a hLg;
    public TextView hOg;
    public TextView hOh;
    public TextView hOk;
    public HeadImageView hOm;
    public TextView hOs;
    public ImageView hOt;
    public HeadPendantView hOu;
    public UserIconBox hOv;
    public UserIconBox hOw;
    private com.baidu.tieba.pb.pb.a hYB;
    public View ifn;
    public View ifo;
    public PbFloorAgreeView ifp;
    public ImageView ifq;
    public PostPraiseView ifr;
    public PostDisPraiseView ifs;
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
        this.ezp = (TextView) findViewById(R.id.view_user_name);
        this.hOg = (TextView) findViewById(R.id.view_author_tip);
        this.hOh = (TextView) findViewById(R.id.view_post_time);
        this.hOt = (ImageView) findViewById(R.id.icon_forum_level);
        this.hOk = (TextView) findViewById(R.id.view_location);
        this.ifq = (ImageView) findViewById(R.id.image_more_tip);
        this.ifp = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.ifr = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.ifs = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hOm = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hOu = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hOu.setHasPendantStyle();
        if (this.hOu.getHeadView() != null) {
            this.hOu.getHeadView().setIsRound(true);
            this.hOu.getHeadView().setDrawBorder(false);
        }
        this.hOv = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hOw = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hOs = (TextView) findViewById(R.id.floor_num);
        this.ifn = findViewById(R.id.line_between_floor_and_time);
        this.ifo = findViewById(R.id.line_between_time_and_locate);
        this.hOm.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hYB = aVar;
        if (this.hYB != null) {
            this.hLg = this.hYB.bRs();
        }
    }
}
