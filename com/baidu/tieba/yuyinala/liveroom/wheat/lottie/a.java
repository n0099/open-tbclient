package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.az;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a {
    private static a oKZ;
    private int oLa = 0;

    public static a eew() {
        if (oKZ == null) {
            synchronized (a.class) {
                if (oKZ == null) {
                    oKZ = new a();
                }
            }
        }
        return oKZ;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        az CF = CF();
        if (!a(CF) && a(CF, true)) {
            b.eeB().a(viewGroup, CF.Cy(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        az eex = eex();
        if (!a(eex) && a(eex, true)) {
            b.eeB().a(viewGroup, eex.Cy(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        az eey = eey();
        if (!a(eey) && a(eey, true)) {
            b.eeB().a(viewGroup, eey.Cy(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        az eez = eez();
        if (!a(eez) && a(eez, true)) {
            b.eeB().a(viewGroup, eez.Cy(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CG = CG();
        if (!a(CG) && a(CG, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eeB().a(viewGroup, CG.Cy(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CH = CH();
        if (!a(CH) && a(CH, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eeB().b(viewGroup, CH.Cy(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        az CI = CI();
        if (!a(CI) && a(CI, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.eeB().c(viewGroup, CI.Cy(), str, str2, cVar);
        }
    }

    public boolean a(az azVar, boolean z) {
        if (azVar == null) {
            return false;
        }
        boolean WR = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.WR(azVar.Cy());
        if (!WR && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(azVar.getDownloadUrl(), azVar.Cy(), null);
            return WR;
        }
        return WR;
    }

    private az CF() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CF();
    }

    private az eex() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CJ();
    }

    private az eey() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CK();
    }

    private az eez() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CL();
    }

    private az CG() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CG();
    }

    private az CH() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CH();
    }

    private az CI() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CI();
    }

    private az CN() {
        ck eeA = eeA();
        if (eeA == null) {
            return null;
        }
        return eeA.CN();
    }

    private static boolean a(az azVar) {
        return azVar == null || StringUtils.isNull(azVar.getDownloadUrl(), true) || StringUtils.isNull(azVar.Cy(), true);
    }

    private ck eeA() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOT == null) {
            return null;
        }
        return com.baidu.live.ae.a.Qm().bwx.aOT.aSI;
    }

    public void dg(ViewGroup viewGroup) {
        di(viewGroup);
        dh(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dh(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_lottie_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_lottie_view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void di(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_video_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_video_view));
        }
    }

    public boolean WO(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String hN = com.baidu.live.storage.b.hN(str);
        return com.baidu.live.h.a.existFile(hN) && com.baidu.live.h.a.isDirectory(hN) && !com.baidu.live.h.b.b(hN, com.baidu.live.h.b.fI(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }

    public void e(ViewGroup viewGroup, c cVar) {
        az CN = CN();
        if (!a(CN) && a(CN, true)) {
            b.eeB().a(viewGroup, CN.Cy(), cVar);
        }
    }
}
