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
    private static int fTD = 20;
    public TextView ejs;
    private com.baidu.tieba.pb.pb.main.b.a hEp;
    public ImageView hHA;
    public HeadPendantView hHB;
    public UserIconBox hHC;
    public UserIconBox hHD;
    public TextView hHn;
    public TextView hHo;
    public TextView hHr;
    public HeadImageView hHt;
    public TextView hHz;
    private com.baidu.tieba.pb.pb.a hRE;
    public View hYc;
    public View hYd;
    public PbFloorAgreeView hYe;
    public ImageView hYf;
    public PostPraiseView hYg;
    public PostDisPraiseView hYh;
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
        this.ejs = (TextView) findViewById(R.id.view_user_name);
        this.hHn = (TextView) findViewById(R.id.view_author_tip);
        this.hHo = (TextView) findViewById(R.id.view_post_time);
        this.hHA = (ImageView) findViewById(R.id.icon_forum_level);
        this.hHr = (TextView) findViewById(R.id.view_location);
        this.hYf = (ImageView) findViewById(R.id.image_more_tip);
        this.hYe = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.hYg = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.hYh = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hHt = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hHB = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hHB.setHasPendantStyle();
        if (this.hHB.getHeadView() != null) {
            this.hHB.getHeadView().setIsRound(true);
            this.hHB.getHeadView().setDrawBorder(false);
        }
        this.hHC = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hHD = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hHz = (TextView) findViewById(R.id.floor_num);
        this.hYc = findViewById(R.id.line_between_floor_and_time);
        this.hYd = findViewById(R.id.line_between_time_and_locate);
        this.hHt.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hRE = aVar;
        if (this.hRE != null) {
            this.hEp = this.hRE.bQG();
        }
    }
}
