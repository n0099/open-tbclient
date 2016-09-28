package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class v extends y.a {
    public com.baidu.tieba.play.s aLZ;
    public QuickVideoView aMF;
    public TextView aMP;
    public ImageView aZL;
    public ForeDrawableImageView cRg;
    public ImageView cRk;
    public TextView caN;
    public TextView cbn;
    public TextView cbo;
    public ProgressBar cbr;
    public View eng;
    public View enh;
    public ImageView eni;
    public FrsPraiseView enj;
    public View enk;
    public ImageView enl;
    public TextView enm;
    public AudioAnimationView enn;
    public View eno;
    public View mRootView;
    public int mSkinType;

    public v(View view) {
        super(view);
        this.mSkinType = 3;
        this.mRootView = view.findViewById(r.g.pb_layout_video_view);
        this.cRg = (ForeDrawableImageView) view.findViewById(r.g.pb_list_video_item_thumbnail);
        this.cbn = (TextView) view.findViewById(r.g.pb_list_video_item_title);
        this.cbo = (TextView) view.findViewById(r.g.pb_list_video_item_play_count);
        this.eng = view.findViewById(r.g.pb_video_black_mask);
        this.enh = view.findViewById(r.g.pb_list_video_item_location_container);
        this.eni = (ImageView) view.findViewById(r.g.pb_list_video_item_location_img);
        this.caN = (TextView) view.findViewById(r.g.pb_list_video_item_location_address);
        this.aMF = (QuickVideoView) view.findViewById(r.g.pb_videoview);
        this.aLZ = new com.baidu.tieba.play.s(view.getContext());
        this.aMF.setBusiness(this.aLZ);
        this.aZL = (ImageView) view.findViewById(r.g.pb_loading_image);
        this.cbr = (ProgressBar) view.findViewById(r.g.pb_loading_progress);
        this.enn = (AudioAnimationView) view.findViewById(r.g.pb_video_play_state);
        this.enn.setCertainColumnCount(4);
        this.enn.setColumnColor(r.d.cp_cont_i);
        this.cRk = (ImageView) view.findViewById(r.g.pb_img_pause_play);
        this.enj = (FrsPraiseView) view.findViewById(r.g.pb_list_video_item_praise_view);
        this.enk = view.findViewById(r.g.pb_list_video_item_like_layout);
        this.aMP = (TextView) view.findViewById(r.g.pb_video_error_tips);
        this.eno = view.findViewById(r.g.pb_video_error_background);
        this.enl = (ImageView) view.findViewById(r.g.zan_icon);
        this.enm = (TextView) view.findViewById(r.g.zan_text_desc);
    }
}
