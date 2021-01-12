package com.baidu.yuyinala.privatemessage.implugin.util.audio;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
/* loaded from: classes10.dex */
public class a implements AudioManager.OnAudioFocusChangeListener {
    private AudioManager mAudioManager;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
    }

    public boolean requestFocus() {
        return 1 == this.mAudioManager.requestAudioFocus(this, 3, 2);
    }

    public boolean ekc() {
        return 1 == this.mAudioManager.abandonAudioFocus(this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        c.i("AudioFocusHelper", "get the focus result is " + i);
    }
}
