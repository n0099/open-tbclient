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
/* loaded from: classes2.dex */
public class PbUserInfoLayout extends FrameLayout {
    private static int dWN = 20;
    public TextView cyw;
    private com.baidu.tieba.pb.pb.main.b.a fDh;
    public TextView fFY;
    public TextView fFZ;
    public View fGa;
    public View fGb;
    public TextView fGc;
    public ImageView fGd;
    public PostPraiseView fGe;
    public PostDisPraiseView fGf;
    public HeadImageView fGg;
    public TextView fGk;
    public ImageView fGl;
    public HeadPendantView fGm;
    public UserIconBox fGn;
    public UserIconBox fGo;
    private com.baidu.tieba.pb.pb.a fQu;
    public PbFloorAgreeView fWv;
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
        this.cyw = (TextView) findViewById(e.g.view_user_name);
        this.fFY = (TextView) findViewById(e.g.view_author_tip);
        this.fFZ = (TextView) findViewById(e.g.view_post_time);
        this.fGl = (ImageView) findViewById(e.g.icon_forum_level);
        this.fGc = (TextView) findViewById(e.g.view_location);
        this.fGd = (ImageView) findViewById(e.g.image_more_tip);
        this.fWv = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fGe = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fGf = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fGg = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fGm = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fGm.setHasPendantStyle();
        if (this.fGm.getHeadView() != null) {
            this.fGm.getHeadView().setIsRound(true);
            this.fGm.getHeadView().setDrawBorder(false);
        }
        this.fGn = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fGo = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fGk = (TextView) findViewById(e.g.floor_num);
        this.fGa = findViewById(e.g.line_between_floor_and_time);
        this.fGb = findViewById(e.g.line_between_time_and_locate);
        this.fGg.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.fQu = aVar;
        if (this.fQu != null) {
            this.fDh = this.fQu.bcD();
        }
    }
}
