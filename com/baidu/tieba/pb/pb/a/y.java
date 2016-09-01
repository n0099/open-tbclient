package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class y extends y.a {
    public TextureVideoView aPh;
    public ImageView aZq;
    public ForeDrawableImageView cQp;
    public ImageView cQt;
    public TextView caL;
    public TextView cbl;
    public TextView cbm;
    public ProgressBar cbp;
    public View eli;
    public View elj;
    public ImageView elk;
    public FrsPraiseView ell;
    public View elm;
    public ImageView eln;
    public TextView elo;
    public AudioAnimationView elp;
    public TextView elq;
    public View elr;
    public View mRootView;
    public int mSkinType;

    public y(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(t.g.pb_layout_video_view);
        this.cQp = (ForeDrawableImageView) view.findViewById(t.g.pb_list_video_item_thumbnail);
        this.cbl = (TextView) view.findViewById(t.g.pb_list_video_item_title);
        this.cbm = (TextView) view.findViewById(t.g.pb_list_video_item_play_count);
        this.eli = view.findViewById(t.g.pb_video_black_mask);
        this.elj = view.findViewById(t.g.pb_list_video_item_location_container);
        this.elk = (ImageView) view.findViewById(t.g.pb_list_video_item_location_img);
        this.caL = (TextView) view.findViewById(t.g.pb_list_video_item_location_address);
        this.aPh = (TextureVideoView) view.findViewById(t.g.pb_videoview);
        this.aZq = (ImageView) view.findViewById(t.g.pb_loading_image);
        this.cbp = (ProgressBar) view.findViewById(t.g.pb_loading_progress);
        this.elp = (AudioAnimationView) view.findViewById(t.g.pb_video_play_state);
        this.elp.setCertainColumnCount(4);
        this.elp.setColumnColor(t.d.cp_cont_i);
        this.cQt = (ImageView) view.findViewById(t.g.pb_img_pause_play);
        this.ell = (FrsPraiseView) view.findViewById(t.g.pb_list_video_item_praise_view);
        this.elm = view.findViewById(t.g.pb_list_video_item_like_layout);
        this.elq = (TextView) view.findViewById(t.g.pb_video_error_tips);
        this.elr = view.findViewById(t.g.pb_video_error_background);
        this.eln = (ImageView) view.findViewById(t.g.zan_icon);
        this.elo = (TextView) view.findViewById(t.g.zan_text_desc);
    }
}
