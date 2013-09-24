package com.baidu.tieba.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.voice.service.MediaService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.f2058a = rVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ai aiVar;
        ac k;
        ai aiVar2;
        ai aiVar3;
        String a2;
        ai aiVar4;
        ac k2;
        ai aiVar5;
        ai aiVar6;
        ai aiVar7;
        ac k3;
        ai aiVar8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        ai aiVar9;
        ac k4;
        ai aiVar10;
        ai aiVar11;
        ai aiVar12;
        ai aiVar13;
        ac k5;
        ai aiVar14;
        int i = 0;
        aiVar = this.f2058a.u;
        if (aiVar != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    aiVar12 = this.f2058a.u;
                    if (aiVar12 != null) {
                        try {
                            aiVar13 = this.f2058a.u;
                            aiVar13.h = 3;
                            k5 = this.f2058a.k();
                            if (k5 != null) {
                                aiVar14 = this.f2058a.u;
                                k5.a(aiVar14);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                k4 = this.f2058a.k();
                if (k4 != null) {
                    k4.c(intExtra);
                }
                aiVar10 = this.f2058a.u;
                if (aiVar10 != null) {
                    aiVar11 = this.f2058a.u;
                    aiVar11.f = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                k3 = this.f2058a.k();
                aiVar8 = this.f2058a.u;
                if (aiVar8 != null) {
                    z = this.f2058a.M;
                    if (!z) {
                        this.f2058a.o();
                        r rVar = this.f2058a;
                        aiVar9 = this.f2058a.u;
                        rVar.b(aiVar9);
                        this.f2058a.x = null;
                    }
                    this.f2058a.u = null;
                    z2 = this.f2058a.M;
                    if (z2 && k3 != null) {
                        ai voiceModel = k3.getVoiceModel();
                        if (voiceModel != null) {
                            voiceModel.g = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.f2058a.p;
                        if (handler != null) {
                            handler2 = this.f2058a.p;
                            handler2.removeCallbacks(this.f2058a.j);
                            handler3 = this.f2058a.p;
                            handler3.postDelayed(this.f2058a.j, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    aiVar4 = this.f2058a.u;
                    if (aiVar4 != null) {
                        aiVar7 = this.f2058a.u;
                        i = aiVar7.d * LocationClientOption.MIN_SCAN_SPAN;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", i);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        aiVar5 = this.f2058a.u;
                        if (aiVar5 != null) {
                            aiVar6 = this.f2058a.u;
                            aiVar6.e = (int) longExtra;
                        }
                    }
                    k2 = this.f2058a.k();
                    if (k2 != null) {
                        k2.c();
                    }
                    MediaService.startPlay(context);
                    return;
                }
                k = this.f2058a.k();
                if (k != null) {
                    if (intExtra2 == 2) {
                        a2 = ak.a(R.string.voice_err_no_file);
                    } else {
                        a2 = ak.a(R.string.voice_err_play);
                    }
                    k.a(5, a2);
                }
                aiVar2 = this.f2058a.u;
                if (aiVar2 != null) {
                    r rVar2 = this.f2058a;
                    aiVar3 = this.f2058a.u;
                    rVar2.b(aiVar3);
                    this.f2058a.u = null;
                }
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
