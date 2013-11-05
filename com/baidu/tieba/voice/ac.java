package com.baidu.tieba.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.service.MediaService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(VoiceManager voiceManager) {
        this.f2563a = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VoiceManager.VoiceModel voiceModel;
        ae m;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager.VoiceModel voiceModel3;
        String a2;
        VoiceManager.VoiceModel voiceModel4;
        long j;
        ae m2;
        VoiceManager.VoiceModel voiceModel5;
        VoiceManager.VoiceModel voiceModel6;
        VoiceManager.VoiceModel voiceModel7;
        ae m3;
        VoiceManager.VoiceModel voiceModel8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceManager.VoiceModel voiceModel9;
        ae m4;
        VoiceManager.VoiceModel voiceModel10;
        VoiceManager.VoiceModel voiceModel11;
        VoiceManager.VoiceModel voiceModel12;
        Handler handler4;
        VoiceManager.VoiceModel voiceModel13;
        ae m5;
        VoiceManager.VoiceModel voiceModel14;
        Handler handler5;
        Runnable runnable;
        voiceModel = this.f2563a.v;
        if (voiceModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.f2563a.t();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    voiceModel12 = this.f2563a.v;
                    if (voiceModel12 != null) {
                        handler4 = this.f2563a.p;
                        if (handler4 != null) {
                            handler5 = this.f2563a.p;
                            runnable = this.f2563a.O;
                            handler5.removeCallbacks(runnable);
                        }
                        try {
                            voiceModel13 = this.f2563a.v;
                            voiceModel13.voice_status = 3;
                            m5 = this.f2563a.m();
                            if (m5 != null) {
                                voiceModel14 = this.f2563a.v;
                                m5.a(voiceModel14);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                m4 = this.f2563a.m();
                if (m4 != null) {
                    m4.c(intExtra);
                }
                voiceModel10 = this.f2563a.v;
                if (voiceModel10 != null) {
                    voiceModel11 = this.f2563a.v;
                    voiceModel11.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                m3 = this.f2563a.m();
                voiceModel8 = this.f2563a.v;
                if (voiceModel8 != null) {
                    z = this.f2563a.M;
                    if (!z) {
                        this.f2563a.q();
                        VoiceManager voiceManager = this.f2563a;
                        voiceModel9 = this.f2563a.v;
                        voiceManager.b(voiceModel9);
                        this.f2563a.y = null;
                    }
                    this.f2563a.v = null;
                    z2 = this.f2563a.M;
                    if (z2 && m3 != null) {
                        VoiceManager.VoiceModel voiceModel15 = m3.getVoiceModel();
                        if (voiceModel15 != null) {
                            voiceModel15.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.f2563a.p;
                        if (handler != null) {
                            handler2 = this.f2563a.p;
                            handler2.removeCallbacks(this.f2563a.j);
                            handler3 = this.f2563a.p;
                            handler3.postDelayed(this.f2563a.j, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    voiceModel4 = this.f2563a.v;
                    if (voiceModel4 != null) {
                        voiceModel7 = this.f2563a.v;
                        j = voiceModel7.duration * LocationClientOption.MIN_SCAN_SPAN;
                    } else {
                        j = 0;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", j);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        voiceModel5 = this.f2563a.v;
                        if (voiceModel5 != null) {
                            voiceModel6 = this.f2563a.v;
                            voiceModel6.duration2 = (int) longExtra;
                        }
                    }
                    m2 = this.f2563a.m();
                    if (m2 != null) {
                        m2.b();
                    }
                    MediaService.startPlay(context);
                    return;
                }
                m = this.f2563a.m();
                if (m != null) {
                    if (intExtra2 == 2) {
                        a2 = al.a(R.string.voice_err_no_file);
                    } else {
                        a2 = al.a(R.string.voice_err_play);
                    }
                    m.b(5, a2);
                }
                voiceModel2 = this.f2563a.v;
                if (voiceModel2 != null) {
                    VoiceManager voiceManager2 = this.f2563a;
                    voiceModel3 = this.f2563a.v;
                    voiceManager2.b(voiceModel3);
                    this.f2563a.v = null;
                }
            } else {
                if (action.equalsIgnoreCase("com.baidu.recognize")) {
                }
            }
        }
    }
}
