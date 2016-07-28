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
    public TextureVideoView aKC;
    public ImageView aUi;
    public TextView bPD;
    public TextView bQd;
    public TextView bQe;
    public ProgressBar bQh;
    public ForeDrawableImageView cEI;
    public ImageView cEM;
    public View dZe;
    public View dZf;
    public ImageView dZg;
    public FrsPraiseView dZh;
    public View dZi;
    public ImageView dZj;
    public TextView dZk;
    public AudioAnimationView dZl;
    public TextView dZm;
    public View dZn;
    public View mRootView;
    public int mSkinType;

    public y(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(u.g.pb_layout_video_view);
        this.cEI = (ForeDrawableImageView) view.findViewById(u.g.pb_list_video_item_thumbnail);
        this.bQd = (TextView) view.findViewById(u.g.pb_list_video_item_title);
        this.bQe = (TextView) view.findViewById(u.g.pb_list_video_item_play_count);
        this.dZe = view.findViewById(u.g.pb_video_black_mask);
        this.dZf = view.findViewById(u.g.pb_list_video_item_location_container);
        this.dZg = (ImageView) view.findViewById(u.g.pb_list_video_item_location_img);
        this.bPD = (TextView) view.findViewById(u.g.pb_list_video_item_location_address);
        this.aKC = (TextureVideoView) view.findViewById(u.g.pb_videoview);
        this.aUi = (ImageView) view.findViewById(u.g.pb_loading_image);
        this.bQh = (ProgressBar) view.findViewById(u.g.pb_loading_progress);
        this.dZl = (AudioAnimationView) view.findViewById(u.g.pb_video_play_state);
        this.dZl.setCertainColumnCount(4);
        this.dZl.setColumnColor(u.d.cp_cont_i);
        this.cEM = (ImageView) view.findViewById(u.g.pb_img_pause_play);
        this.dZh = (FrsPraiseView) view.findViewById(u.g.pb_list_video_item_praise_view);
        this.dZi = view.findViewById(u.g.pb_list_video_item_like_layout);
        this.dZm = (TextView) view.findViewById(u.g.pb_video_error_tips);
        this.dZn = view.findViewById(u.g.pb_video_error_background);
        this.dZj = (ImageView) view.findViewById(u.g.zan_icon);
        this.dZk = (TextView) view.findViewById(u.g.zan_text_desc);
    }
}
