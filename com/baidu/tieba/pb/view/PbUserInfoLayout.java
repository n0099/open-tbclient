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
    private static int fCR = 20;
    public TextView dZu;
    private com.baidu.tieba.pb.pb.a hAe;
    public View hGm;
    public View hGn;
    public PbFloorAgreeView hGo;
    public ImageView hGp;
    public PostPraiseView hGq;
    public PostDisPraiseView hGr;
    private com.baidu.tieba.pb.pb.main.b.a hmX;
    public TextView hpU;
    public TextView hpV;
    public TextView hpY;
    public HeadImageView hqa;
    public TextView hqg;
    public ImageView hqh;
    public HeadPendantView hqi;
    public UserIconBox hqj;
    public UserIconBox hqk;
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
        this.dZu = (TextView) findViewById(d.g.view_user_name);
        this.hpU = (TextView) findViewById(d.g.view_author_tip);
        this.hpV = (TextView) findViewById(d.g.view_post_time);
        this.hqh = (ImageView) findViewById(d.g.icon_forum_level);
        this.hpY = (TextView) findViewById(d.g.view_location);
        this.hGp = (ImageView) findViewById(d.g.image_more_tip);
        this.hGo = (PbFloorAgreeView) findViewById(d.g.view_floor_praise);
        this.hGq = (PostPraiseView) findViewById(d.g.view_floor_new_praise);
        this.hGr = (PostDisPraiseView) findViewById(d.g.view_floor_new_dispraise);
        this.hqa = (HeadImageView) findViewById(d.g.normal_user_photo);
        this.hqi = (HeadPendantView) findViewById(d.g.pendant_user_photo);
        this.hqi.setHasPendantStyle();
        if (this.hqi.getHeadView() != null) {
            this.hqi.getHeadView().setIsRound(true);
            this.hqi.getHeadView().setDrawBorder(false);
        }
        this.hqj = (UserIconBox) findViewById(d.g.show_icon_vip);
        this.hqk = (UserIconBox) findViewById(d.g.show_icon_yinji);
        this.hqg = (TextView) findViewById(d.g.floor_num);
        this.hGm = findViewById(d.g.line_between_floor_and_time);
        this.hGn = findViewById(d.g.line_between_time_and_locate);
        this.hqa.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hAe = aVar;
        if (this.hAe != null) {
            this.hmX = this.hAe.bIP();
        }
    }
}
