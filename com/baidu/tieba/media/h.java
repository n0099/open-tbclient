package com.baidu.tieba.media;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
import com.baidu.cyberplayer.sdk.BMediaController;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.slidingmenu.lib.R;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayerActivity f1936a;
    private RelativeLayout b = null;
    private LinearLayout c = null;
    private BVideoView d = null;
    private BMediaController e = null;
    private boolean f = false;
    private View.OnClickListener g = new i(this);
    private View.OnClickListener h = new j(this);

    public h(MediaPlayerActivity mediaPlayerActivity) {
        this.f1936a = null;
        if (mediaPlayerActivity == null) {
            throw new InvalidParameterException("MediaPlayerView context is null");
        }
        this.f1936a = mediaPlayerActivity;
    }

    public void a() {
        BCyberPlayerFactory.init(this.f1936a);
        BCyberPlayerFactory.createEngineManager().initCyberPlayerEngine("WNgtxLzDe7RmrFRmNnAwWIPz", "gXWM6eodGykwKabj");
        this.f1936a.setContentView(R.layout.media_player_activity);
        this.b = (RelativeLayout) this.f1936a.findViewById(R.id.view_holder);
        this.c = (LinearLayout) this.f1936a.findViewById(R.id.controller_holder);
        this.d = new BVideoView(this.f1936a);
        this.e = new BMediaController(this.f1936a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.b.addView(this.d, layoutParams);
        this.c.addView(this.e, layoutParams);
        this.d.setOnPreparedListener(this.f1936a);
        this.d.setOnCompletionListener(this.f1936a);
        this.d.setOnErrorListener(this.f1936a);
        this.d.setOnInfoListener(this.f1936a);
        this.d.setOnPlayingBufferCacheListener(this.f1936a);
        this.e.setPreNextListener(this.g, this.h);
        this.d.setMediaController(this.e);
        this.f = this.f1936a.getIntent().getBooleanExtra("isHW", false);
        if (this.f) {
            this.d.setDecodeMode(0);
        } else {
            this.d.setDecodeMode(1);
        }
    }

    public int b() {
        return this.d.getDuration();
    }

    public int c() {
        return this.d.getCurrentPosition();
    }

    public void d() {
        this.d.stopPlayback();
    }

    public void a(String str) {
        this.d.setVideoPath(str);
    }

    public void a(int i) {
        this.d.seekTo(i);
    }

    public void e() {
        this.d.start();
    }
}
