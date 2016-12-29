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
public class s extends y.a {
    public QuickVideoView aNV;
    public ah aNk;
    public TextView aOf;
    public ProgressBar bKw;
    public ImageView bcn;
    public ForeDrawableImageView cBJ;
    public ImageView cBN;
    public View dXA;
    public View dXy;
    public AudioAnimationView dXz;
    public View mRootView;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(r.g.pb_layout_video_view);
        this.cBJ = (ForeDrawableImageView) view.findViewById(r.g.pb_list_video_item_thumbnail);
        this.dXy = view.findViewById(r.g.pb_video_black_mask);
        this.aNV = (QuickVideoView) view.findViewById(r.g.pb_videoview);
        this.aNk = new ah(view.getContext());
        this.aNV.setBusiness(this.aNk);
        this.bcn = (ImageView) view.findViewById(r.g.pb_loading_image);
        this.bKw = (ProgressBar) view.findViewById(r.g.pb_loading_progress);
        this.dXz = (AudioAnimationView) view.findViewById(r.g.pb_video_play_state);
        this.dXz.setCertainColumnCount(4);
        this.dXz.setColumnColor(r.d.cp_cont_i);
        this.cBN = (ImageView) view.findViewById(r.g.pb_img_pause_play);
        this.aOf = (TextView) view.findViewById(r.g.pb_video_error_tips);
        this.dXA = view.findViewById(r.g.pb_video_error_background);
    }
}
