package com.baidu.tieba.nearby;

import android.widget.ListView;
import com.baidu.tieba.util.NetWorkCore;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NearbyPbActivity nearbyPbActivity) {
        this.f1168a = nearbyPbActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0050 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ListView listView;
        ListView listView2;
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        int i;
        ae aeVar5;
        com.baidu.tieba.model.bg bgVar;
        ae aeVar6;
        ae aeVar7;
        try {
            listView = this.f1168a.b;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.f1168a.b;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.f1168a);
            aeVar = this.f1168a.l;
            aeVar.b().a();
            boolean z = c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG;
            aeVar2 = this.f1168a.l;
            aeVar2.b().a(z);
            int i2 = firstVisiblePosition;
            int i3 = 0;
            int i4 = 0;
            while (i2 < aeVar3.getCount()) {
                if (z || i2 <= lastVisiblePosition) {
                    aeVar4 = this.f1168a.l;
                    com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) aeVar4.getItem(i2);
                    if (anVar != null) {
                        ArrayList j = anVar.j();
                        int size = j.size();
                        aeVar5 = this.f1168a.l;
                        if (aeVar5.g() && i4 < 13) {
                            int i5 = 0;
                            int i6 = i4;
                            while (true) {
                                if (i5 >= size) {
                                    i4 = i6;
                                    break;
                                }
                                if (((com.baidu.tieba.data.i) j.get(i5)).a() == 3 || ((com.baidu.tieba.data.i) j.get(i5)).a() == 5) {
                                    if (i6 >= 13) {
                                        i4 = i6;
                                        break;
                                    }
                                    i6++;
                                    aeVar7 = this.f1168a.l;
                                    aeVar7.b().a(((com.baidu.tieba.data.i) j.get(i5)).f(), new l(this));
                                }
                                i5++;
                                i6 = i6;
                            }
                        }
                        String portrait = anVar.h().getPortrait();
                        bgVar = this.f1168a.n;
                        if (bgVar.b() && portrait != null && portrait.length() > 0 && i3 < 30) {
                            i3++;
                            aeVar6 = this.f1168a.l;
                            aeVar6.b().d(portrait, new m(this));
                        }
                        i = i3;
                        if (z && i4 >= 13 && i >= 30) {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyPbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
