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
    private static int gaH = 20;
    public TextView eAg;
    private com.baidu.tieba.pb.pb.main.b.a hLX;
    public TextView hOX;
    public TextView hOY;
    public TextView hPb;
    public HeadImageView hPd;
    public TextView hPj;
    public ImageView hPk;
    public HeadPendantView hPl;
    public UserIconBox hPm;
    public UserIconBox hPn;
    private com.baidu.tieba.pb.pb.a hZs;
    public View ige;
    public View igf;
    public PbFloorAgreeView igg;
    public ImageView igh;
    public PostPraiseView igi;
    public PostDisPraiseView igj;
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
        this.eAg = (TextView) findViewById(R.id.view_user_name);
        this.hOX = (TextView) findViewById(R.id.view_author_tip);
        this.hOY = (TextView) findViewById(R.id.view_post_time);
        this.hPk = (ImageView) findViewById(R.id.icon_forum_level);
        this.hPb = (TextView) findViewById(R.id.view_location);
        this.igh = (ImageView) findViewById(R.id.image_more_tip);
        this.igg = (PbFloorAgreeView) findViewById(R.id.view_floor_praise);
        this.igi = (PostPraiseView) findViewById(R.id.view_floor_new_praise);
        this.igj = (PostDisPraiseView) findViewById(R.id.view_floor_new_dispraise);
        this.hPd = (HeadImageView) findViewById(R.id.normal_user_photo);
        this.hPl = (HeadPendantView) findViewById(R.id.pendant_user_photo);
        this.hPl.setHasPendantStyle();
        if (this.hPl.getHeadView() != null) {
            this.hPl.getHeadView().setIsRound(true);
            this.hPl.getHeadView().setDrawBorder(false);
        }
        this.hPm = (UserIconBox) findViewById(R.id.show_icon_vip);
        this.hPn = (UserIconBox) findViewById(R.id.show_icon_yinji);
        this.hPj = (TextView) findViewById(R.id.floor_num);
        this.ige = findViewById(R.id.line_between_floor_and_time);
        this.igf = findViewById(R.id.line_between_time_and_locate);
        this.hPd.setIsRound(true);
    }

    public void setPbEventController(com.baidu.tieba.pb.pb.a aVar) {
        this.hZs = aVar;
        if (this.hZs != null) {
            this.hLX = this.hZs.bRu();
        }
    }
}
