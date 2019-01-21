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
    private static int eqs = 20;
    public TextView cLX;
    private com.baidu.tieba.pb.pb.main.b.a fWO;
    public TextView fZF;
    public TextView fZG;
    public View fZH;
    public View fZI;
    public TextView fZJ;
    public ImageView fZK;
    public PostPraiseView fZL;
    public PostDisPraiseView fZM;
    public HeadImageView fZN;
    public TextView fZR;
    public ImageView fZS;
    public HeadPendantView fZT;
    public UserIconBox fZU;
    public UserIconBox fZV;
    private com.baidu.tieba.pb.pb.a gki;
    public PbFloorAgreeView gqg;
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
        this.cLX = (TextView) findViewById(e.g.view_user_name);
        this.fZF = (TextView) findViewById(e.g.view_author_tip);
        this.fZG = (TextView) findViewById(e.g.view_post_time);
        this.fZS = (ImageView) findViewById(e.g.icon_forum_level);
        this.fZJ = (TextView) findViewById(e.g.view_location);
        this.fZK = (ImageView) findViewById(e.g.image_more_tip);
        this.gqg = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fZL = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fZM = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fZN = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fZT = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fZT.setHasPendantStyle();
        if (this.fZT.getHeadView() != null) {
            this.fZT.getHeadView().setIsRound(true);
            this.fZT.getHeadView().setDrawBorder(false);
        }
        this.fZU = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fZV = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fZR = (TextView) findViewById(e.g.floor_num);
        this.fZH = findViewById(e.g.line_between_floor_and_time);
        this.fZI = findViewById(e.g.line_between_time_and_locate);
        this.fZN.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.gki = aVar;
        if (this.gki != null) {
            this.fWO = this.gki.bis();
        }
    }
}
