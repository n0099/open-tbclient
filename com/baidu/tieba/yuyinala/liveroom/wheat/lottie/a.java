package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.at;
import com.baidu.live.data.cc;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a {
    private static a owx;
    private int owy = 0;

    public static a efB() {
        if (owx == null) {
            synchronized (a.class) {
                if (owx == null) {
                    owx = new a();
                }
            }
        }
        return owx;
    }

    private a() {
    }

    public void cU(ViewGroup viewGroup) {
        a(viewGroup, (c) null);
    }

    public void a(ViewGroup viewGroup, c cVar) {
        at FU = FU();
        if (!a(FU) && a(FU, true)) {
            b.efD().a(viewGroup, FU.FN(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        at FV = FV();
        if (!a(FV) && a(FV, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efD().a(viewGroup, FV.FN(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        at FW = FW();
        if (!a(FW) && a(FW, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efD().b(viewGroup, FW.FN(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        at FX = FX();
        if (!a(FX) && a(FX, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efD().c(viewGroup, FX.FN(), str, str2, cVar);
        }
    }

    public boolean a(at atVar, boolean z) {
        if (atVar == null) {
            return false;
        }
        boolean WV = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.WV(atVar.FN());
        if (!WV && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(atVar.getDownloadUrl(), atVar.FN(), null);
            return WV;
        }
        return WV;
    }

    private at FU() {
        cc efC = efC();
        if (efC == null) {
            return null;
        }
        return efC.FU();
    }

    private at FV() {
        cc efC = efC();
        if (efC == null) {
            return null;
        }
        return efC.FV();
    }

    private at FW() {
        cc efC = efC();
        if (efC == null) {
            return null;
        }
        return efC.FW();
    }

    private at FX() {
        cc efC = efC();
        if (efC == null) {
            return null;
        }
        return efC.FX();
    }

    private static boolean a(at atVar) {
        return atVar == null || StringUtils.isNull(atVar.getDownloadUrl(), true) || StringUtils.isNull(atVar.FN(), true);
    }

    private cc efC() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null) {
            return null;
        }
        return com.baidu.live.ae.a.RB().brA.aOJ.aRX;
    }

    public void cV(ViewGroup viewGroup) {
        cX(viewGroup);
        cW(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cW(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_lottie_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_lottie_view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cX(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_video_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_video_view));
        }
    }
}
