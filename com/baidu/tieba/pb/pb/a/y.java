package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class y extends y.a {
    public TextureVideoView aJJ;
    public ImageView aTm;
    public FrsPraiseView bBX;
    public TextView bNS;
    public TextView bOr;
    public TextView bOs;
    public ProgressBar bOv;
    public ForeDrawableImageView cBT;
    public ImageView cBX;
    public View dMS;
    public View dMT;
    public ImageView dMU;
    public View dMV;
    public ImageView dMW;
    public TextView dMX;
    public AudioAnimationView dMY;
    public TextView dMZ;
    public View dNa;
    public View mRootView;
    public int mSkinType;

    public y(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(u.g.pb_layout_video_view);
        this.cBT = (ForeDrawableImageView) view.findViewById(u.g.pb_list_video_item_thumbnail);
        this.bOr = (TextView) view.findViewById(u.g.pb_list_video_item_title);
        this.bOs = (TextView) view.findViewById(u.g.pb_list_video_item_play_count);
        this.dMS = view.findViewById(u.g.pb_video_black_mask);
        this.dMT = view.findViewById(u.g.pb_list_video_item_location_container);
        this.dMU = (ImageView) view.findViewById(u.g.pb_list_video_item_location_img);
        this.bNS = (TextView) view.findViewById(u.g.pb_list_video_item_location_address);
        this.aJJ = (TextureVideoView) view.findViewById(u.g.pb_videoview);
        this.aTm = (ImageView) view.findViewById(u.g.pb_loading_image);
        this.bOv = (ProgressBar) view.findViewById(u.g.pb_loading_progress);
        this.dMY = (AudioAnimationView) view.findViewById(u.g.pb_video_play_state);
        this.dMY.setCertainColumnCount(4);
        this.dMY.setColumnColor(u.d.cp_cont_i);
        this.cBX = (ImageView) view.findViewById(u.g.pb_img_pause_play);
        this.bBX = (FrsPraiseView) view.findViewById(u.g.pb_list_video_item_praise_view);
        this.dMV = view.findViewById(u.g.pb_list_video_item_like_layout);
        this.dMZ = (TextView) view.findViewById(u.g.pb_video_error_tips);
        this.dNa = view.findViewById(u.g.pb_video_error_background);
        this.dMW = (ImageView) view.findViewById(u.g.zan_icon);
        this.dMX = (TextView) view.findViewById(u.g.zan_text_desc);
    }
}
