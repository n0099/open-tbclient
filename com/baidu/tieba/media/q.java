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
public class q {

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayerActivity f1315a;
    private RelativeLayout b = null;
    private LinearLayout c = null;
    private BVideoView d = null;
    private BMediaController e = null;
    private boolean f = false;
    private View.OnClickListener g = new r(this);
    private View.OnClickListener h = new s(this);

    public q(MediaPlayerActivity mediaPlayerActivity) {
        this.f1315a = null;
        if (mediaPlayerActivity == null) {
            throw new InvalidParameterException("MediaPlayerView context is null");
        }
        this.f1315a = mediaPlayerActivity;
    }

    public void a() {
        BCyberPlayerFactory.init(this.f1315a);
        BCyberPlayerFactory.createEngineManager().initCyberPlayerEngine("WNgtxLzDe7RmrFRmNnAwWIPz", "gXWM6eodGykwKabj");
        this.f1315a.setContentView(R.layout.media_player_activity);
        this.b = (RelativeLayout) this.f1315a.findViewById(R.id.view_holder);
        this.c = (LinearLayout) this.f1315a.findViewById(R.id.controller_holder);
        this.d = new BVideoView(this.f1315a);
        this.e = new BMediaController(this.f1315a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.b.addView(this.d, layoutParams);
        this.c.addView(this.e, layoutParams);
        this.d.setOnPreparedListener(this.f1315a);
        this.d.setOnCompletionListener(this.f1315a);
        this.d.setOnErrorListener(this.f1315a);
        this.d.setOnInfoListener(this.f1315a);
        this.d.setOnPlayingBufferCacheListener(this.f1315a);
        this.e.setPreNextListener(this.g, this.h);
        this.d.setMediaController(this.e);
        this.f = this.f1315a.getIntent().getBooleanExtra("isHW", false);
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
