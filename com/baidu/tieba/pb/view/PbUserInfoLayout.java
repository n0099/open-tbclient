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
    private static int fYC = 20;
    public TextView enZ;
    private com.baidu.tieba.pb.pb.main.b.a hKD;
    public TextView hNB;
    public TextView hNC;
    public TextView hNF;
    public HeadImageView hNH;
    public TextView hNN;
    public ImageView hNO;
    public HeadPendantView hNP;
    public UserIconBox hNQ;
    public UserIconBox hNR;
    private com.baidu.tieba.pb.pb.a hXS;
    public View iet;
    public View ieu;
    public PbFloorAgreeView iev;
    public ImageView iew;
    public PostPraiseView iex;
    public PostDisPraiseView iey;
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
        this.enZ = (TextView) findViewById(R.id.view_user_name);
        this.hNB = (TextView) findViewById(R.id.view_author_tip);
        this.hNC = (TextView) findViewById(R.id.view_post_time);
        this.hNO = (ImageView) findViewById(R.id.icon_forum_level);
        this.hNF = (TextView) findViewById(R.id.view_location);
        this.iew = (ImageView) findViewById(R.id.image_more_tip);
        this.iev = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.iex = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.iey = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hNH = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hNP = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hNP.setHasPendantStyle();
        if (this.hNP.getHeadView() != null) {
            this.hNP.getHeadView().setIsRound(true);
            this.hNP.getHeadView().setDrawBorder(false);
        }
        this.hNQ = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hNR = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hNN = (TextView) findViewById(R.id.floor_num);
        this.iet = findViewById(R.id.line_between_floor_and_time);
        this.ieu = findViewById(R.id.line_between_time_and_locate);
        this.hNH.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hXS = aVar;
        if (this.hXS != null) {
            this.hKD = this.hXS.bTs();
        }
    }
}
