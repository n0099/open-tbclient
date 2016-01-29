package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.pb.view.PbVideoControllerView;
import com.baidu.tieba.pb.view.PbVideoProgressView;
import com.baidu.tieba.pb.view.TextureVideoView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class am extends x.a {
    public FrsPraiseView beZ;
    public TextView blT;
    public TextView bvl;
    public ForeDrawableImageView cLd;
    public TextView cLe;
    public TextView cLf;
    public ImageView cLg;
    public View cLh;
    public ImageView cLi;
    public View cLj;
    public TextureVideoView cLk;
    public PbVideoControllerView cLl;
    public PbVideoProgressView cLm;
    public View cLn;
    public TextView cLo;
    public ImageView cLp;
    public View mLoadingLayout;
    public int mSkinType;

    public am(View view) {
        super(view);
        this.mSkinType = 3;
        this.cLd = (ForeDrawableImageView) view.findViewById(t.g.pb_list_video_item_thumbnail);
        this.cLe = (TextView) view.findViewById(t.g.pb_list_video_item_title);
        this.cLf = (TextView) view.findViewById(t.g.pb_list_video_item_play_count);
        this.cLg = (ImageView) view.findViewById(t.g.pb_list_video_item_like_btn);
        this.cLh = view.findViewById(t.g.pb_list_video_item_location_container);
        this.cLi = (ImageView) view.findViewById(t.g.pb_list_video_item_location_img);
        this.blT = (TextView) view.findViewById(t.g.pb_list_video_item_location_address);
        this.beZ = (FrsPraiseView) view.findViewById(t.g.pb_list_video_item_praise_view);
        this.cLj = view.findViewById(t.g.pb_list_video_item_like_layout);
        this.cLk = (TextureVideoView) view.findViewById(t.g.pb_videoview);
        this.cLl = (PbVideoControllerView) view.findViewById(t.g.pb_video_controller);
        this.cLm = (PbVideoProgressView) view.findViewById(t.g.pb_video_progress_view);
        this.cLn = view.findViewById(t.g.pb_replay_layout);
        this.cLo = (TextView) view.findViewById(t.g.textview_pb_like_after_play);
        this.bvl = (TextView) view.findViewById(t.g.textview_pb_replay);
        this.cLp = (ImageView) view.findViewById(t.g.pb_img_pause_play);
        this.mLoadingLayout = view.findViewById(t.g.pb_layout_loading);
    }
}
