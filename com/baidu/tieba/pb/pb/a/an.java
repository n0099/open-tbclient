package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.pb.view.PbVideoControllerView;
import com.baidu.tieba.pb.view.PbVideoProgressView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class an extends y.a {
    public TextView bAx;
    public FrsPraiseView bfL;
    public TextView bmy;
    public ForeDrawableImageView dgN;
    public TextView dgO;
    public TextView dgP;
    public View dgQ;
    public ImageView dgR;
    public View dgS;
    public TextureVideoView dgT;
    public PbVideoControllerView dgU;
    public PbVideoProgressView dgV;
    public View dgW;
    public TextView dgX;
    public ImageView dgY;
    public View mLoadingLayout;
    public int mSkinType;

    public an(View view) {
        super(view);
        this.mSkinType = 3;
        this.dgN = (ForeDrawableImageView) view.findViewById(t.g.pb_list_video_item_thumbnail);
        this.dgO = (TextView) view.findViewById(t.g.pb_list_video_item_title);
        this.dgP = (TextView) view.findViewById(t.g.pb_list_video_item_play_count);
        this.dgQ = view.findViewById(t.g.pb_list_video_item_location_container);
        this.dgR = (ImageView) view.findViewById(t.g.pb_list_video_item_location_img);
        this.bmy = (TextView) view.findViewById(t.g.pb_list_video_item_location_address);
        this.dgT = (TextureVideoView) view.findViewById(t.g.pb_videoview);
        this.dgU = (PbVideoControllerView) view.findViewById(t.g.pb_video_controller);
        this.dgV = (PbVideoProgressView) view.findViewById(t.g.pb_video_progress_view);
        this.dgW = view.findViewById(t.g.pb_replay_layout);
        this.bAx = (TextView) view.findViewById(t.g.textview_pb_replay);
        this.dgY = (ImageView) view.findViewById(t.g.pb_img_pause_play);
        this.mLoadingLayout = view.findViewById(t.g.pb_layout_loading);
        this.dgX = (TextView) view.findViewById(t.g.textview_pb_like_after_play);
        this.bfL = (FrsPraiseView) view.findViewById(t.g.pb_list_video_item_praise_view);
        this.dgS = view.findViewById(t.g.pb_list_video_item_like_layout);
    }
}
