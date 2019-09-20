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
    private static int gbj = 20;
    public TextView epQ;
    private com.baidu.tieba.pb.pb.main.b.a hNu;
    public TextView hQE;
    public ImageView hQF;
    public HeadPendantView hQG;
    public UserIconBox hQH;
    public UserIconBox hQI;
    public TextView hQs;
    public TextView hQt;
    public TextView hQw;
    public HeadImageView hQy;
    private com.baidu.tieba.pb.pb.a iaL;
    public View ihu;
    public View ihv;
    public PbFloorAgreeView ihw;
    public ImageView ihx;
    public PostPraiseView ihy;
    public PostDisPraiseView ihz;
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
        this.epQ = (TextView) findViewById(R.id.view_user_name);
        this.hQs = (TextView) findViewById(R.id.view_author_tip);
        this.hQt = (TextView) findViewById(R.id.view_post_time);
        this.hQF = (ImageView) findViewById(R.id.icon_forum_level);
        this.hQw = (TextView) findViewById(R.id.view_location);
        this.ihx = (ImageView) findViewById(R.id.image_more_tip);
        this.ihw = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.ihy = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.ihz = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hQy = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hQG = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hQG.setHasPendantStyle();
        if (this.hQG.getHeadView() != null) {
            this.hQG.getHeadView().setIsRound(true);
            this.hQG.getHeadView().setDrawBorder(false);
        }
        this.hQH = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hQI = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hQE = (TextView) findViewById(R.id.floor_num);
        this.ihu = findViewById(R.id.line_between_floor_and_time);
        this.ihv = findViewById(R.id.line_between_time_and_locate);
        this.hQy.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.iaL = aVar;
        if (this.iaL != null) {
            this.hNu = this.iaL.bUt();
        }
    }
}
