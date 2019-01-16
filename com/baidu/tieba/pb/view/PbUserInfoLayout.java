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
    private static int eqr = 20;
    public TextView cLW;
    private com.baidu.tieba.pb.pb.main.b.a fWN;
    public TextView fZE;
    public TextView fZF;
    public View fZG;
    public View fZH;
    public TextView fZI;
    public ImageView fZJ;
    public PostPraiseView fZK;
    public PostDisPraiseView fZL;
    public HeadImageView fZM;
    public TextView fZQ;
    public ImageView fZR;
    public HeadPendantView fZS;
    public UserIconBox fZT;
    public UserIconBox fZU;
    private com.baidu.tieba.pb.pb.a gkh;
    public PbFloorAgreeView gqf;
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
        this.cLW = (TextView) findViewById(e.g.view_user_name);
        this.fZE = (TextView) findViewById(e.g.view_author_tip);
        this.fZF = (TextView) findViewById(e.g.view_post_time);
        this.fZR = (ImageView) findViewById(e.g.icon_forum_level);
        this.fZI = (TextView) findViewById(e.g.view_location);
        this.fZJ = (ImageView) findViewById(e.g.image_more_tip);
        this.gqf = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fZK = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fZL = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fZM = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fZS = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fZS.setHasPendantStyle();
        if (this.fZS.getHeadView() != null) {
            this.fZS.getHeadView().setIsRound(true);
            this.fZS.getHeadView().setDrawBorder(false);
        }
        this.fZT = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fZU = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fZQ = (TextView) findViewById(e.g.floor_num);
        this.fZG = findViewById(e.g.line_between_floor_and_time);
        this.fZH = findViewById(e.g.line_between_time_and_locate);
        this.fZM.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.gkh = aVar;
        if (this.gkh != null) {
            this.fWN = this.gkh.bis();
        }
    }
}
