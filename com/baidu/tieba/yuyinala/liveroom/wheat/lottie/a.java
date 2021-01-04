package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.av;
import com.baidu.live.data.cd;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a {
    private static a oDs;
    private int oDt = 0;

    public static a efJ() {
        if (oDs == null) {
            synchronized (a.class) {
                if (oDs == null) {
                    oDs = new a();
                }
            }
        }
        return oDs;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        av Fk = Fk();
        if (!a(Fk) && a(Fk, true)) {
            b.efO().a(viewGroup, Fk.Fd(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        av efK = efK();
        if (!a(efK) && a(efK, true)) {
            b.efO().a(viewGroup, efK.Fd(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        av efL = efL();
        if (!a(efL) && a(efL, true)) {
            b.efO().a(viewGroup, efL.Fd(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        av efM = efM();
        if (!a(efM) && a(efM, true)) {
            b.efO().a(viewGroup, efM.Fd(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fl = Fl();
        if (!a(Fl) && a(Fl, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efO().a(viewGroup, Fl.Fd(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fm = Fm();
        if (!a(Fm) && a(Fm, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efO().b(viewGroup, Fm.Fd(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Fn = Fn();
        if (!a(Fn) && a(Fn, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.efO().c(viewGroup, Fn.Fd(), str, str2, cVar);
        }
    }

    public boolean a(av avVar, boolean z) {
        if (avVar == null) {
            return false;
        }
        boolean WH = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.WH(avVar.Fd());
        if (!WH && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(avVar.getDownloadUrl(), avVar.Fd(), null);
            return WH;
        }
        return WH;
    }

    private av Fk() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fk();
    }

    private av efK() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fo();
    }

    private av efL() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fp();
    }

    private av efM() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fq();
    }

    private av Fl() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fl();
    }

    private av Fm() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fm();
    }

    private av Fn() {
        cd efN = efN();
        if (efN == null) {
            return null;
        }
        return efN.Fn();
    }

    private static boolean a(av avVar) {
        return avVar == null || StringUtils.isNull(avVar.getDownloadUrl(), true) || StringUtils.isNull(avVar.Fd(), true);
    }

    private cd efN() {
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

    public boolean WE(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String iw = com.baidu.live.ah.b.iw(str);
        return com.baidu.live.i.a.existFile(iw) && com.baidu.live.i.a.isDirectory(iw) && !com.baidu.live.i.b.b(iw, com.baidu.live.i.b.gt(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }
}
