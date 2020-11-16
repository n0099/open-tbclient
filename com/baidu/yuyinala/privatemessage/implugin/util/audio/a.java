package com.baidu.yuyinala.privatemessage.implugin.util.audio;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class a implements AudioManager.OnAudioFocusChangeListener {
    private AudioManager mAudioManager;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public boolean requestFocus() {
        return 1 == this.mAudioManager.requestAudioFocus(this, 3, 2);
    }

    public boolean eie() {
        return 1 == this.mAudioManager.abandonAudioFocus(this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        c.i("AudioFocusHelper", "get the focus result is " + i);
    }
}
