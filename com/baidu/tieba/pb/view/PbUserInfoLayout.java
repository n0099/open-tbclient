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
    private static int fCS = 20;
    public TextView dZy;
    private com.baidu.tieba.pb.pb.a hAk;
    public View hGs;
    public View hGt;
    public PbFloorAgreeView hGu;
    public ImageView hGv;
    public PostPraiseView hGw;
    public PostDisPraiseView hGx;
    private com.baidu.tieba.pb.pb.main.b.a hne;
    public TextView hqb;
    public TextView hqc;
    public TextView hqf;
    public HeadImageView hqh;
    public TextView hqn;
    public ImageView hqo;
    public HeadPendantView hqp;
    public UserIconBox hqq;
    public UserIconBox hqr;
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
        this.dZy = (TextView) findViewById(d.g.view_user_name);
        this.hqb = (TextView) findViewById(d.g.view_author_tip);
        this.hqc = (TextView) findViewById(d.g.view_post_time);
        this.hqo = (ImageView) findViewById(d.g.icon_forum_level);
        this.hqf = (TextView) findViewById(d.g.view_location);
        this.hGv = (ImageView) findViewById(d.g.image_more_tip);
        this.hGu = (PbFloorAgreeView) findViewById(d.g.view_floor_praise);
        this.hGw = (PostPraiseView) findViewById(d.g.view_floor_new_praise);
        this.hGx = (PostDisPraiseView) findViewById(d.g.view_floor_new_dispraise);
        this.hqh = (HeadImageView) findViewById(d.g.normal_user_photo);
        this.hqp = (HeadPendantView) findViewById(d.g.pendant_user_photo);
        this.hqp.setHasPendantStyle();
        if (this.hqp.getHeadView() != null) {
            this.hqp.getHeadView().setIsRound(true);
            this.hqp.getHeadView().setDrawBorder(false);
        }
        this.hqq = (UserIconBox) findViewById(d.g.show_icon_vip);
        this.hqr = (UserIconBox) findViewById(d.g.show_icon_yinji);
        this.hqn = (TextView) findViewById(d.g.floor_num);
        this.hGs = findViewById(d.g.line_between_floor_and_time);
        this.hGt = findViewById(d.g.line_between_time_and_locate);
        this.hqh.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hAk = aVar;
        if (this.hAk != null) {
            this.hne = this.hAk.bIQ();
        }
    }
}
