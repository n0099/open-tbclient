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
    private static int fTF = 20;
    public TextView ejs;
    private com.baidu.tieba.pb.pb.main.b.a hEq;
    public TextView hHA;
    public ImageView hHB;
    public HeadPendantView hHC;
    public UserIconBox hHD;
    public UserIconBox hHE;
    public TextView hHo;
    public TextView hHp;
    public TextView hHs;
    public HeadImageView hHu;
    private com.baidu.tieba.pb.pb.a hRF;
    public View hYd;
    public View hYe;
    public PbFloorAgreeView hYf;
    public ImageView hYg;
    public PostPraiseView hYh;
    public PostDisPraiseView hYi;
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
        this.hHo = (TextView) findViewById(R.id.view_author_tip);
        this.hHp = (TextView) findViewById(R.id.view_post_time);
        this.hHB = (ImageView) findViewById(R.id.icon_forum_level);
        this.hHs = (TextView) findViewById(R.id.view_location);
        this.hYg = (ImageView) findViewById(R.id.image_more_tip);
        this.hYf = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.hYh = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.hYi = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hHu = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hHC = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hHC.setHasPendantStyle();
        if (this.hHC.getHeadView() != null) {
            this.hHC.getHeadView().setIsRound(true);
            this.hHC.getHeadView().setDrawBorder(false);
        }
        this.hHD = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hHE = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hHA = (TextView) findViewById(R.id.floor_num);
        this.hYd = findViewById(R.id.line_between_floor_and_time);
        this.hYe = findViewById(R.id.line_between_time_and_locate);
        this.hHu.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hRF = aVar;
        if (this.hRF != null) {
            this.hEq = this.hRF.bQH();
        }
    }
}
