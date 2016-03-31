package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.pb.view.PbVideoControllerView;
import com.baidu.tieba.pb.view.PbVideoProgressView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class an extends x.a {
    public TextView bAt;
    public FrsPraiseView bjL;
    public TextView brk;
    public TextureVideoView deA;
    public PbVideoControllerView deB;
    public PbVideoProgressView deC;
    public View deD;
    public TextView deE;
    public ImageView deF;
    public ForeDrawableImageView deu;
    public TextView dev;
    public TextView dew;
    public View dex;
    public ImageView dey;
    public View dez;
    public View mLoadingLayout;
    public int mSkinType;

    public an(View view) {
        super(view);
        this.mSkinType = 3;
        this.deu = (ForeDrawableImageView) view.findViewById(t.g.pb_list_video_item_thumbnail);
        this.dev = (TextView) view.findViewById(t.g.pb_list_video_item_title);
        this.dew = (TextView) view.findViewById(t.g.pb_list_video_item_play_count);
        this.dex = view.findViewById(t.g.pb_list_video_item_location_container);
        this.dey = (ImageView) view.findViewById(t.g.pb_list_video_item_location_img);
        this.brk = (TextView) view.findViewById(t.g.pb_list_video_item_location_address);
        this.deA = (TextureVideoView) view.findViewById(t.g.pb_videoview);
        this.deB = (PbVideoControllerView) view.findViewById(t.g.pb_video_controller);
        this.deC = (PbVideoProgressView) view.findViewById(t.g.pb_video_progress_view);
        this.deD = view.findViewById(t.g.pb_replay_layout);
        this.bAt = (TextView) view.findViewById(t.g.textview_pb_replay);
        this.deF = (ImageView) view.findViewById(t.g.pb_img_pause_play);
        this.mLoadingLayout = view.findViewById(t.g.pb_layout_loading);
        this.deE = (TextView) view.findViewById(t.g.textview_pb_like_after_play);
        this.bjL = (FrsPraiseView) view.findViewById(t.g.pb_list_video_item_praise_view);
        this.dez = view.findViewById(t.g.pb_list_video_item_like_layout);
    }
}
