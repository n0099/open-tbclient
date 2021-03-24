package com.baidu.tieba.medialive.player;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbLiveVideoView extends BVideoView {
    public Uri G;
    public a H;

    /* loaded from: classes3.dex */
    public interface a {
        void onBufferingUpdate(int i);

        void onCompletion();

        void onError(int i, int i2);

        void onInfo(int i, int i2);

        void onPrepared();

        void onSeekComplete();

        void onVideoSizeChanged(int i, int i2);
    }

    public TbLiveVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public final void g() {
        setOption(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "true");
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "live");
        hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, "tieba");
        setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
    }

    public Uri getVideoURI() {
        return this.G;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        super.onBufferingUpdate(i);
        a aVar = this.H;
        if (aVar != null) {
            aVar.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        super.onCompletion();
        a aVar = this.H;
        if (aVar != null) {
            aVar.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        a aVar = this.H;
        if (aVar != null) {
            aVar.onError(i, i2);
        }
        return super.onError(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        a aVar = this.H;
        if (aVar != null) {
            aVar.onInfo(i, i2);
        }
        return super.onInfo(i, i2, obj);
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        a aVar = this.H;
        if (aVar != null) {
            aVar.onPrepared();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        super.onSeekComplete();
        a aVar = this.H;
        if (aVar != null) {
            aVar.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        super.onVideoSizeChanged(i, i2, i3, i4);
        a aVar = this.H;
        if (aVar != null) {
            aVar.onVideoSizeChanged(i, i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        super.pause();
    }

    public void setPlayerCallback(a aVar) {
        this.H = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        super.setVideoURI(uri);
        this.G = uri;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        super.start();
    }

    public TbLiveVideoView(Context context) {
        super(context);
        g();
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        super.setVideoURI(uri, map);
        this.G = uri;
    }
}
