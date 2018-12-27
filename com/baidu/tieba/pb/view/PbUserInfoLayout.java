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
    private static int epL = 20;
    public TextView cLl;
    private com.baidu.tieba.pb.pb.main.b.a fVQ;
    public TextView fYH;
    public TextView fYI;
    public View fYJ;
    public View fYK;
    public TextView fYL;
    public ImageView fYM;
    public PostPraiseView fYN;
    public PostDisPraiseView fYO;
    public HeadImageView fYP;
    public TextView fYT;
    public ImageView fYU;
    public HeadPendantView fYV;
    public UserIconBox fYW;
    public UserIconBox fYX;
    private com.baidu.tieba.pb.pb.a gje;
    public PbFloorAgreeView gpb;
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
        this.cLl = (TextView) findViewById(e.g.view_user_name);
        this.fYH = (TextView) findViewById(e.g.view_author_tip);
        this.fYI = (TextView) findViewById(e.g.view_post_time);
        this.fYU = (ImageView) findViewById(e.g.icon_forum_level);
        this.fYL = (TextView) findViewById(e.g.view_location);
        this.fYM = (ImageView) findViewById(e.g.image_more_tip);
        this.gpb = (PbFloorAgreeView) findViewById(e.g.view_floor_praise);
        this.fYN = (PostPraiseView) findViewById(e.g.view_floor_new_praise);
        this.fYO = (PostDisPraiseView) findViewById(e.g.view_floor_new_dispraise);
        this.fYP = (HeadImageView) findViewById(e.g.normal_user_photo);
        this.fYV = (HeadPendantView) findViewById(e.g.pendant_user_photo);
        this.fYV.setHasPendantStyle();
        if (this.fYV.getHeadView() != null) {
            this.fYV.getHeadView().setIsRound(true);
            this.fYV.getHeadView().setDrawBorder(false);
        }
        this.fYW = (UserIconBox) findViewById(e.g.show_icon_vip);
        this.fYX = (UserIconBox) findViewById(e.g.show_icon_yinji);
        this.fYT = (TextView) findViewById(e.g.floor_num);
        this.fYJ = findViewById(e.g.line_between_floor_and_time);
        this.fYK = findViewById(e.g.line_between_time_and_locate);
        this.fYP.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.gje = aVar;
        if (this.gje != null) {
            this.fVQ = this.gje.bhO();
        }
    }
}
