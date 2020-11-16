package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.as;
import com.baidu.live.data.ca;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a {
    private static a ohv;
    private int ohw = 0;

    public static a dZV() {
        if (ohv == null) {
            synchronized (a.class) {
                if (ohv == null) {
                    ohv = new a();
                }
            }
        }
        return ohv;
    }

    private a() {
    }

    public void cR(ViewGroup viewGroup) {
        a(viewGroup, (c) null);
    }

    public void a(ViewGroup viewGroup, c cVar) {
        as Ej = Ej();
        if (!a(Ej) && a(Ej, true)) {
            b.dZX().a(viewGroup, Ej.Ec(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        as Ek = Ek();
        if (!a(Ek) && a(Ek, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZX().a(viewGroup, Ek.Ec(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        as El = El();
        if (!a(El) && a(El, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZX().b(viewGroup, El.Ec(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        as Em = Em();
        if (!a(Em) && a(Em, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZX().c(viewGroup, Em.Ec(), str, str2, cVar);
        }
    }

    public boolean a(as asVar, boolean z) {
        if (asVar == null) {
            return false;
        }
        boolean VG = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.VG(asVar.Ec());
        if (!VG && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(asVar.getDownloadUrl(), asVar.Ec(), null);
            return VG;
        }
        return VG;
    }

    private as Ej() {
        ca dZW = dZW();
        if (dZW == null) {
            return null;
        }
        return dZW.Ej();
    }

    private as Ek() {
        ca dZW = dZW();
        if (dZW == null) {
            return null;
        }
        return dZW.Ek();
    }

    private as El() {
        ca dZW = dZW();
        if (dZW == null) {
            return null;
        }
        return dZW.El();
    }

    private as Em() {
        ca dZW = dZW();
        if (dZW == null) {
            return null;
        }
        return dZW.Em();
    }

    private static boolean a(as asVar) {
        return asVar == null || StringUtils.isNull(asVar.getDownloadUrl(), true) || StringUtils.isNull(asVar.Ec(), true);
    }

    private ca dZW() {
        if (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLN == null) {
            return null;
        }
        return com.baidu.live.aa.a.Ph().bms.aLN.aOV;
    }

    public void cS(ViewGroup viewGroup) {
        cU(viewGroup);
        cT(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cT(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_lottie_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_lottie_view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cU(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_video_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_video_view));
        }
    }
}
