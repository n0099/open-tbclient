package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.av;
import com.baidu.live.data.cd;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a {
    private static a oDr;
    private int oDs = 0;

    public static a efK() {
        if (oDr == null) {
            synchronized (a.class) {
                if (oDr == null) {
                    oDr = new a();
                }
            }
        }
        return oDr;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        av Fk = Fk();
        if (!a(Fk) && a(Fk, true)) {
            b.efP().a(viewGroup, Fk.Fd(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        av efL = efL();
        if (!a(efL) && a(efL, true)) {
            b.efP().a(viewGroup, efL.Fd(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        av efM = efM();
        if (!a(efM) && a(efM, true)) {
            b.efP().a(viewGroup, efM.Fd(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        av efN = efN();
        if (!a(efN) && a(efN, true)) {
            b.efP().a(viewGroup, efN.Fd(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fl = Fl();
        if (!a(Fl) && a(Fl, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efP().a(viewGroup, Fl.Fd(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fm = Fm();
        if (!a(Fm) && a(Fm, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efP().b(viewGroup, Fm.Fd(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fn = Fn();
        if (!a(Fn) && a(Fn, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efP().c(viewGroup, Fn.Fd(), str, str2, cVar);
        }
    }

    public boolean a(av avVar, boolean z) {
        if (avVar == null) {
            return false;
        }
        boolean WG = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.WG(avVar.Fd());
        if (!WG && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(avVar.getDownloadUrl(), avVar.Fd(), null);
            return WG;
        }
        return WG;
    }

    private av Fk() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fk();
    }

    private av efL() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fo();
    }

    private av efM() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fp();
    }

    private av efN() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fq();
    }

    private av Fl() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fl();
    }

    private av Fm() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fm();
    }

    private av Fn() {
        cd efO = efO();
        if (efO == null) {
            return null;
        }
        return efO.Fn();
    }

    private static boolean a(av avVar) {
        return avVar == null || StringUtils.isNull(avVar.getDownloadUrl(), true) || StringUtils.isNull(avVar.Fd(), true);
    }

    private cd efO() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null) {
            return null;
        }
        return com.baidu.live.af.a.SE().bwi.aPq.aSS;
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

    public boolean WD(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String iw = com.baidu.live.ah.b.iw(str);
        return com.baidu.live.i.a.existFile(iw) && com.baidu.live.i.a.isDirectory(iw) && !com.baidu.live.i.b.b(iw, com.baidu.live.i.b.gt(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }
}
