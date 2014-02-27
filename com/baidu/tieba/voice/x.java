package com.baidu.tieba.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.service.MediaService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends BroadcastReceiver {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VoiceManager.VoiceModel voiceModel;
        ad o;
        VoiceManager.VoiceModel voiceModel2;
        VoiceManager.VoiceModel voiceModel3;
        String a;
        VoiceManager.VoiceModel voiceModel4;
        VoiceManager.VoiceModel voiceModel5;
        VoiceManager.VoiceModel voiceModel6;
        VoiceManager.VoiceModel voiceModel7;
        ad o2;
        VoiceManager.VoiceModel voiceModel8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceManager.VoiceModel voiceModel9;
        ad o3;
        VoiceManager.VoiceModel voiceModel10;
        VoiceManager.VoiceModel voiceModel11;
        VoiceManager.VoiceModel voiceModel12;
        Handler handler4;
        VoiceManager.VoiceModel voiceModel13;
        VoiceManager.VoiceModel voiceModel14;
        VoiceManager.VoiceModel voiceModel15;
        VoiceManager.VoiceModel voiceModel16;
        ad o4;
        VoiceManager.VoiceModel voiceModel17;
        Handler handler5;
        Runnable runnable;
        int i = 0;
        voiceModel = this.a.v;
        if (voiceModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.a.t();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    voiceModel12 = this.a.v;
                    if (voiceModel12 != null) {
                        handler4 = this.a.p;
                        if (handler4 != null) {
                            handler5 = this.a.p;
                            runnable = this.a.O;
                            handler5.removeCallbacks(runnable);
                        }
                        try {
                            voiceModel16 = this.a.v;
                            voiceModel16.voice_status = 3;
                            o4 = this.a.o();
                            if (o4 != null) {
                                voiceModel17 = this.a.v;
                                o4.a(voiceModel17);
                            }
                        } catch (Exception e) {
                            com.baidu.tieba.util.ae aeVar = new com.baidu.tieba.util.ae();
                            voiceModel13 = this.a.v;
                            if (voiceModel13 != null) {
                                voiceModel14 = this.a.v;
                                aeVar.a("id", voiceModel14.getId());
                                voiceModel15 = this.a.v;
                                aeVar.a("from", voiceModel15.from);
                            }
                            cb.b("", -1112, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), aeVar.toString());
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                o3 = this.a.o();
                if (o3 != null) {
                    o3.a(intExtra);
                }
                voiceModel10 = this.a.v;
                if (voiceModel10 != null) {
                    voiceModel11 = this.a.v;
                    voiceModel11.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                o2 = this.a.o();
                voiceModel8 = this.a.v;
                if (voiceModel8 != null) {
                    z = this.a.M;
                    if (!z) {
                        this.a.q();
                        VoiceManager voiceManager = this.a;
                        voiceModel9 = this.a.v;
                        voiceManager.b(voiceModel9);
                        this.a.y = null;
                    }
                    this.a.v = null;
                    z2 = this.a.M;
                    if (z2 && o2 != null) {
                        VoiceManager.VoiceModel voiceModel18 = o2.getVoiceModel();
                        if (voiceModel18 != null) {
                            voiceModel18.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.a.p;
                        if (handler != null) {
                            handler2 = this.a.p;
                            handler2.removeCallbacks(this.a.j);
                            handler3 = this.a.p;
                            handler3.postDelayed(this.a.j, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    voiceModel4 = this.a.v;
                    if (voiceModel4 != null) {
                        voiceModel7 = this.a.v;
                        i = voiceModel7.duration * LocationClientOption.MIN_SCAN_SPAN;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", i);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        voiceModel5 = this.a.v;
                        if (voiceModel5 != null) {
                            voiceModel6 = this.a.v;
                            voiceModel6.duration2 = (int) longExtra;
                        }
                    }
                    this.a.o();
                    MediaService.startPlay(context);
                    return;
                }
                o = this.a.o();
                if (o != null) {
                    if (intExtra2 == 2) {
                        a = ak.a(R.string.voice_err_io);
                    } else {
                        a = ak.a(R.string.voice_err_play);
                    }
                    o.a(5, a);
                }
                voiceModel2 = this.a.v;
                if (voiceModel2 != null) {
                    VoiceManager voiceManager2 = this.a;
                    voiceModel3 = this.a.v;
                    voiceManager2.b(voiceModel3);
                    this.a.v = null;
                }
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
