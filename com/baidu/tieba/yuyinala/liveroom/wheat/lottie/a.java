package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.as;
import com.baidu.live.data.ca;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a {
    private static a ofS;
    private int ofT = 0;

    public static a dZW() {
        if (ofS == null) {
            synchronized (a.class) {
                if (ofS == null) {
                    ofS = new a();
                }
            }
        }
        return ofS;
    }

    private a() {
    }

    public void cV(ViewGroup viewGroup) {
        a(viewGroup, (c) null);
    }

    public void a(ViewGroup viewGroup, c cVar) {
        as ES = ES();
        if (!a(ES) && a(ES, true)) {
            b.dZY().a(viewGroup, ES.EL(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        as ET = ET();
        if (!a(ET) && a(ET, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZY().a(viewGroup, ET.EL(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        as EU = EU();
        if (!a(EU) && a(EU, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZY().b(viewGroup, EU.EL(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        as EV = EV();
        if (!a(EV) && a(EV, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.dZY().c(viewGroup, EV.EL(), str, str2, cVar);
        }
    }

    public boolean a(as asVar, boolean z) {
        if (asVar == null) {
            return false;
        }
        boolean VV = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.VV(asVar.EL());
        if (!VV && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(asVar.getDownloadUrl(), asVar.EL(), null);
            return VV;
        }
        return VV;
    }

    private as ES() {
        ca dZX = dZX();
        if (dZX == null) {
            return null;
        }
        return dZX.ES();
    }

    private as ET() {
        ca dZX = dZX();
        if (dZX == null) {
            return null;
        }
        return dZX.ET();
    }

    private as EU() {
        ca dZX = dZX();
        if (dZX == null) {
            return null;
        }
        return dZX.EU();
    }

    private as EV() {
        ca dZX = dZX();
        if (dZX == null) {
            return null;
        }
        return dZX.EV();
    }

    private static boolean a(as asVar) {
        return asVar == null || StringUtils.isNull(asVar.getDownloadUrl(), true) || StringUtils.isNull(asVar.EL(), true);
    }

    private ca dZX() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNy == null) {
            return null;
        }
        return com.baidu.live.aa.a.PQ().bod.aNy.aQG;
    }

    public void cW(ViewGroup viewGroup) {
        cY(viewGroup);
        cX(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cX(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_lottie_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_lottie_view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cY(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.findViewById(a.f.ala_audio_dating_video_view) != null) {
            viewGroup.removeView(viewGroup.findViewById(a.f.ala_audio_dating_video_view));
        }
    }
}
