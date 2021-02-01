package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.az;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a {
    private static a oIu;
    private int oIv = 0;

    public static a eeg() {
        if (oIu == null) {
            synchronized (a.class) {
                if (oIu == null) {
                    oIu = new a();
                }
            }
        }
        return oIu;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        az CC = CC();
        if (!a(CC) && a(CC, true)) {
            b.eel().a(viewGroup, CC.Cv(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        az eeh = eeh();
        if (!a(eeh) && a(eeh, true)) {
            b.eel().a(viewGroup, eeh.Cv(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        az eei = eei();
        if (!a(eei) && a(eei, true)) {
            b.eel().a(viewGroup, eei.Cv(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        az eej = eej();
        if (!a(eej) && a(eej, true)) {
            b.eel().a(viewGroup, eej.Cv(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CD = CD();
        if (!a(CD) && a(CD, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eel().a(viewGroup, CD.Cv(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CE = CE();
        if (!a(CE) && a(CE, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eel().b(viewGroup, CE.Cv(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CF = CF();
        if (!a(CF) && a(CF, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eel().c(viewGroup, CF.Cv(), str, str2, cVar);
        }
    }

    public boolean a(az azVar, boolean z) {
        if (azVar == null) {
            return false;
        }
        boolean Wy = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.Wy(azVar.Cv());
        if (!Wy && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(azVar.getDownloadUrl(), azVar.Cv(), null);
            return Wy;
        }
        return Wy;
    }

    private az CC() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CC();
    }

    private az eeh() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CG();
    }

    private az eei() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CH();
    }

    private az eej() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CI();
    }

    private az CD() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CD();
    }

    private az CE() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CE();
    }

    private az CF() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CF();
    }

    private az CK() {
        ck eek = eek();
        if (eek == null) {
            return null;
        }
        return eek.CK();
    }

    private static boolean a(az azVar) {
        return azVar == null || StringUtils.isNull(azVar.getDownloadUrl(), true) || StringUtils.isNull(azVar.Cv(), true);
    }

    private ck eek() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null) {
            return null;
        }
        return com.baidu.live.ae.a.Qj().buX.aNt.aRi;
    }

    public void dh(ViewGroup viewGroup) {
        dj(viewGroup);
        di(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void di(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_lottie_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_lottie_view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dj(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_video_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_video_view));
        }
    }

    public boolean Wv(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String hH = com.baidu.live.storage.b.hH(str);
        return com.baidu.live.h.a.existFile(hH) && com.baidu.live.h.a.isDirectory(hH) && !com.baidu.live.h.b.b(hH, com.baidu.live.h.b.fC(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }

    public void e(ViewGroup viewGroup, c cVar) {
        az CK = CK();
        if (!a(CK) && a(CK, true)) {
            b.eel().a(viewGroup, CK.Cv(), cVar);
        }
    }
}
