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
    private static int fTC = 20;
    public TextView ejr;
    private com.baidu.tieba.pb.pb.main.b.a hEm;
    public UserIconBox hHA;
    public TextView hHk;
    public TextView hHl;
    public TextView hHo;
    public HeadImageView hHq;
    public TextView hHw;
    public ImageView hHx;
    public HeadPendantView hHy;
    public UserIconBox hHz;
    private com.baidu.tieba.pb.pb.a hRB;
    public View hXZ;
    public View hYa;
    public PbFloorAgreeView hYb;
    public ImageView hYc;
    public PostPraiseView hYd;
    public PostDisPraiseView hYe;
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
        this.ejr = (TextView) findViewById(R.id.view_user_name);
        this.hHk = (TextView) findViewById(R.id.view_author_tip);
        this.hHl = (TextView) findViewById(R.id.view_post_time);
        this.hHx = (ImageView) findViewById(R.id.icon_forum_level);
        this.hHo = (TextView) findViewById(R.id.view_location);
        this.hYc = (ImageView) findViewById(R.id.image_more_tip);
        this.hYb = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.hYd = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.hYe = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hHq = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hHy = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hHy.setHasPendantStyle();
        if (this.hHy.getHeadView() != null) {
            this.hHy.getHeadView().setIsRound(true);
            this.hHy.getHeadView().setDrawBorder(false);
        }
        this.hHz = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hHA = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hHw = (TextView) findViewById(R.id.floor_num);
        this.hXZ = findViewById(R.id.line_between_floor_and_time);
        this.hYa = findViewById(R.id.line_between_time_and_locate);
        this.hHq.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hRB = aVar;
        if (this.hRB != null) {
            this.hEm = this.hRB.bQD();
        }
    }
}
