package com.baidu.tieba.yuyinala.liveroom.wheat.lottie;

import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.av;
import com.baidu.live.data.cd;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a {
    private static a oyN;
    private int oyO = 0;

    public static a ebS() {
        if (oyN == null) {
            synchronized (a.class) {
                if (oyN == null) {
                    oyN = new a();
                }
            }
        }
        return oyN;
    }

    private a() {
    }

    public void a(ViewGroup viewGroup, c cVar) {
        av Bp = Bp();
        if (!a(Bp) && a(Bp, true)) {
            b.ebX().a(viewGroup, Bp.Bi(), cVar);
        }
    }

    public void b(ViewGroup viewGroup, c cVar) {
        av ebT = ebT();
        if (!a(ebT) && a(ebT, true)) {
            b.ebX().a(viewGroup, ebT.Bi(), cVar);
        }
    }

    public void c(ViewGroup viewGroup, c cVar) {
        av ebU = ebU();
        if (!a(ebU) && a(ebU, true)) {
            b.ebX().a(viewGroup, ebU.Bi(), cVar);
        }
    }

    public void d(ViewGroup viewGroup, c cVar) {
        av ebV = ebV();
        if (!a(ebV) && a(ebV, true)) {
            b.ebX().a(viewGroup, ebV.Bi(), cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Bq = Bq();
        if (!a(Bq) && a(Bq, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.ebX().a(viewGroup, Bq.Bi(), str, str2, cVar);
        }
    }

    public void a(ViewGroup viewGroup, String str, String str2) {
        b(viewGroup, str, str2, null);
    }

    public void b(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Br = Br();
        if (!a(Br) && a(Br, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.ebX().b(viewGroup, Br.Bi(), str, str2, cVar);
        }
    }

    public void b(ViewGroup viewGroup, String str, String str2) {
        c(viewGroup, str, str2, null);
    }

    public void c(ViewGroup viewGroup, String str, String str2, c cVar) {
        av Bs = Bs();
        if (!a(Bs) && a(Bs, true) && !StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            b.ebX().c(viewGroup, Bs.Bi(), str, str2, cVar);
        }
    }

    public boolean a(av avVar, boolean z) {
        if (avVar == null) {
            return false;
        }
        boolean Vz = com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.Vz(avVar.Bi());
        if (!Vz && z) {
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.b(avVar.getDownloadUrl(), avVar.Bi(), null);
            return Vz;
        }
        return Vz;
    }

    private av Bp() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bp();
    }

    private av ebT() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bt();
    }

    private av ebU() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bu();
    }

    private av ebV() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bv();
    }

    private av Bq() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bq();
    }

    private av Br() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Br();
    }

    private av Bs() {
        cd ebW = ebW();
        if (ebW == null) {
            return null;
        }
        return ebW.Bs();
    }

    private static boolean a(av avVar) {
        return avVar == null || StringUtils.isNull(avVar.getDownloadUrl(), true) || StringUtils.isNull(avVar.Bi(), true);
    }

    private cd ebW() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKD == null) {
            return null;
        }
        return com.baidu.live.af.a.OJ().bru.aKD.aOf;
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

    public boolean Vw(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String hl = com.baidu.live.ah.b.hl(str);
        return com.baidu.live.i.a.existFile(hl) && com.baidu.live.i.a.isDirectory(hl) && !com.baidu.live.i.b.b(hl, com.baidu.live.i.b.fh(new StringBuilder().append("video_bg_md5_").append(str).toString()));
    }
}
