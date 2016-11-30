package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ah;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class t extends y.a {
    public ah aNT;
    public QuickVideoView aOE;
    public TextView aOO;
    public ImageView bcV;
    public ForeDrawableImageView cWB;
    public ImageView cWF;
    public ProgressBar ceN;
    public View etd;
    public AudioAnimationView ete;
    public View etf;
    public View mRootView;
    public int mSkinType;

    public t(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(r.g.pb_layout_video_view);
        this.cWB = (ForeDrawableImageView) view.findViewById(r.g.pb_list_video_item_thumbnail);
        this.etd = view.findViewById(r.g.pb_video_black_mask);
        this.aOE = (QuickVideoView) view.findViewById(r.g.pb_videoview);
        this.aNT = new ah(view.getContext());
        this.aOE.setBusiness(this.aNT);
        this.bcV = (ImageView) view.findViewById(r.g.pb_loading_image);
        this.ceN = (ProgressBar) view.findViewById(r.g.pb_loading_progress);
        this.ete = (AudioAnimationView) view.findViewById(r.g.pb_video_play_state);
        this.ete.setCertainColumnCount(4);
        this.ete.setColumnColor(r.d.cp_cont_i);
        this.cWF = (ImageView) view.findViewById(r.g.pb_img_pause_play);
        this.aOO = (TextView) view.findViewById(r.g.pb_video_error_tips);
        this.etf = view.findViewById(r.g.pb_video_error_background);
    }
}
