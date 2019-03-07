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
    private com.baidu.tieba.pb.pb.a hAj;
    public View hGr;
    public View hGs;
    public PbFloorAgreeView hGt;
    public ImageView hGu;
    public PostPraiseView hGv;
    public PostDisPraiseView hGw;
    private com.baidu.tieba.pb.pb.main.b.a hnd;
    public TextView hqa;
    public TextView hqb;
    public TextView hqe;
    public HeadImageView hqg;
    public TextView hqm;
    public ImageView hqn;
    public HeadPendantView hqo;
    public UserIconBox hqp;
    public UserIconBox hqq;
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
        this.hqa = (TextView) findViewById(d.g.view_author_tip);
        this.hqb = (TextView) findViewById(d.g.view_post_time);
        this.hqn = (ImageView) findViewById(d.g.icon_forum_level);
        this.hqe = (TextView) findViewById(d.g.view_location);
        this.hGu = (ImageView) findViewById(d.g.image_more_tip);
        this.hGt = (PbFloorAgreeView) findViewById(d.g.view_floor_praise);
        this.hGv = (PostPraiseView) findViewById(d.g.view_floor_new_praise);
        this.hGw = (PostDisPraiseView) findViewById(d.g.view_floor_new_dispraise);
        this.hqg = (HeadImageView) findViewById(d.g.normal_user_photo);
        this.hqo = (HeadPendantView) findViewById(d.g.pendant_user_photo);
        this.hqo.setHasPendantStyle();
        if (this.hqo.getHeadView() != null) {
            this.hqo.getHeadView().setIsRound(true);
            this.hqo.getHeadView().setDrawBorder(false);
        }
        this.hqp = (UserIconBox) findViewById(d.g.show_icon_vip);
        this.hqq = (UserIconBox) findViewById(d.g.show_icon_yinji);
        this.hqm = (TextView) findViewById(d.g.floor_num);
        this.hGr = findViewById(d.g.line_between_floor_and_time);
        this.hGs = findViewById(d.g.line_between_time_and_locate);
        this.hqg.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hAj = aVar;
        if (this.hAj != null) {
            this.hnd = this.hAj.bIP();
        }
    }
}
