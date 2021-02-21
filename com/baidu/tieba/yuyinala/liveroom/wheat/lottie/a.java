package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.az;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a {
    private static a oIU;
    private int oIV = 0;

    public static a eeo() {
        if (oIU == null) {
            synchronized (a.class) {
                if (oIU == null) {
                    oIU = new a();
                }
            }
        }
        return oIU;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        az CC = CC();
        if (!a(CC) && a(CC, true)) {
            b.eet().a(viewGroup, CC.Cv(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        az eep = eep();
        if (!a(eep) && a(eep, true)) {
            b.eet().a(viewGroup, eep.Cv(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        az eeq = eeq();
        if (!a(eeq) && a(eeq, true)) {
            b.eet().a(viewGroup, eeq.Cv(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        az eer = eer();
        if (!a(eer) && a(eer, true)) {
            b.eet().a(viewGroup, eer.Cv(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CD = CD();
        if (!a(CD) && a(CD, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eet().a(viewGroup, CD.Cv(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CE = CE();
        if (!a(CE) && a(CE, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eet().b(viewGroup, CE.Cv(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CF = CF();
        if (!a(CF) && a(CF, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eet().c(viewGroup, CF.Cv(), str, str2, cVar);
        }
    }

    public boolean a(az azVar, boolean z) {
        if (azVar == null) {
            return false;
        }
        boolean WK = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.WK(azVar.Cv());
        if (!WK && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(azVar.getDownloadUrl(), azVar.Cv(), null);
            return WK;
        }
        return WK;
    }

    private az CC() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CC();
    }

    private az eep() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CG();
    }

    private az eeq() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CH();
    }

    private az eer() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CI();
    }

    private az CD() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CD();
    }

    private az CE() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CE();
    }

    private az CF() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CF();
    }

    private az CK() {
        ck ees = ees();
        if (ees == null) {
            return null;
        }
        return ees.CK();
    }

    private static boolean a(az azVar) {
        return azVar == null || StringUtils.isNull(azVar.getDownloadUrl(), true) || StringUtils.isNull(azVar.Cv(), true);
    }

    private ck ees() {
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

    public boolean WH(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String hH = com.baidu.live.storage.b.hH(str);
        return com.baidu.live.h.a.existFile(hH) && com.baidu.live.h.a.isDirectory(hH) && !com.baidu.live.h.b.b(hH, com.baidu.live.h.b.fC(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }

    public void e(ViewGroup viewGroup, c cVar) {
        az CK = CK();
        if (!a(CK) && a(CK, true)) {
            b.eet().a(viewGroup, CK.Cv(), cVar);
        }
    }
}
