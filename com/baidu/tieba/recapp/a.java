package com.baidu.tieba.recapp;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.al;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tbclient.App;
/* loaded from: classes.dex */
public class a {
    public static List<com.baidu.adp.widget.ListView.q> r(List<App> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            return arrayList;
        }
        for (App app : list) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            advertAppInfo.a(app);
            advertAppInfo.page = str;
            int f = f(advertAppInfo);
            if (f != 0) {
                b(advertAppInfo, f);
            } else {
                arrayList.add(advertAppInfo);
            }
        }
        return arrayList;
    }

    public static List<al> b(List<al> list, List<com.baidu.adp.widget.ListView.q> list2, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            return arrayList;
        }
        fK(list);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            al alVar = (al) com.baidu.tieba.lego.card.d.a.l(list, i4);
            if (alVar != null && alVar.bmI() != null) {
                int eN = com.baidu.tieba.lego.card.d.a.eN(list2);
                int e = e(alVar.bmI()) - 1;
                if (e < 0) {
                    i3++;
                    g(alVar.bmI());
                } else {
                    int bmJ = alVar.bmK() ? alVar.bmJ() : ((e + i) + i4) - i3;
                    if (bmJ > eN) {
                        g(alVar.bmI());
                        i3++;
                    } else {
                        alVar.setPosition(bmJ);
                        com.baidu.tieba.lego.card.d.a.a(list2, alVar, bmJ);
                        arrayList.add(alVar);
                    }
                }
            }
        }
        while (i < com.baidu.tieba.lego.card.d.a.eN(list2)) {
            com.baidu.adp.widget.ListView.q qVar = list2.get(i);
            if (qVar instanceof al) {
                i2++;
            } else if (qVar instanceof BaseCardInfo) {
                ((BaseCardInfo) qVar).position += i2;
            }
            i++;
        }
        return arrayList;
    }

    public static void fK(List<al> list) {
        Collections.sort(list, new Comparator<al>() { // from class: com.baidu.tieba.recapp.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(al alVar, al alVar2) {
                if (alVar.bmK() && alVar2.bmK()) {
                    return alVar.bmJ() - alVar2.bmJ();
                }
                if (alVar.bmK() || alVar2.bmK()) {
                    return !alVar.bmK() ? 1 : -1;
                }
                return (alVar.bmI() == null ? -1 : a.e(alVar.bmI())) - (alVar2.bmI() != null ? a.e(alVar2.bmI()) : -1);
            }
        });
    }

    public static int e(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            return 0;
        }
        if (TextUtils.isEmpty(advertAppInfo.adPosition)) {
            return -1;
        }
        return com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
    }

    public static int f(AdvertAppInfo advertAppInfo) {
        int bmD = advertAppInfo.bmD();
        if (e(advertAppInfo) < 0) {
            return 23;
        }
        return bmD;
    }

    private static void g(AdvertAppInfo advertAppInfo) {
        b(advertAppInfo, 23);
    }

    private static void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.d.dGf().a(com.baidu.tieba.recapp.report.g.b(advertAppInfo, 5, 1, i));
        if (advertAppInfo != null && advertAppInfo.eEt != null) {
            advertAppInfo.eEt.mDiscardReason = i;
        }
    }

    public static int fL(List<com.baidu.adp.widget.ListView.q> list) {
        boolean z = false;
        int size = list.size();
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            int eN = com.baidu.tieba.lego.card.d.a.eN(list) - 1;
            int i = 0;
            while (true) {
                if (eN < 0) {
                    break;
                } else if (list.get(eN) instanceof com.baidu.tieba.card.data.d) {
                    z = true;
                    break;
                } else {
                    eN--;
                    i++;
                }
            }
            if (!z) {
                i = size;
            }
            return i;
        }
        return size;
    }

    public static Set<com.baidu.adp.widget.ListView.q> a(List<com.baidu.adp.widget.ListView.q> list, int i, String str) {
        AdvertAppInfo bmI;
        AdvertAppInfo bmI2;
        HashSet hashSet = new HashSet();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            return hashSet;
        }
        Set<com.baidu.adp.widget.ListView.q> Sl = com.baidu.tieba.recapp.report.a.Sl(str);
        HashSet hashSet2 = Sl == null ? new HashSet() : Sl;
        for (com.baidu.adp.widget.ListView.q qVar : list) {
            if (qVar != null) {
                for (com.baidu.adp.widget.ListView.q qVar2 : hashSet2) {
                    if ((qVar instanceof al) && (bmI2 = ((al) qVar).bmI()) != null && qVar2.hashCode() == bmI2.hashCode()) {
                        bmI2.advertAppContext = ((AdvertAppInfo) qVar2).advertAppContext;
                    }
                }
                if ((qVar instanceof al) && (bmI = ((al) qVar).bmI()) != null && bmI.advertAppContext == null) {
                    bmI.advertAppContext = new com.baidu.tbadk.core.data.c();
                    bmI.advertAppContext.page = str;
                    bmI.advertAppContext.pn = i;
                    bmI.advertAppContext.extensionInfo = bmI.extensionInfo;
                    bmI.advertAppContext.ZP = false;
                    hashSet.add(bmI);
                }
            }
        }
        hashSet2.addAll(hashSet);
        com.baidu.tieba.recapp.report.a.b(str, hashSet2);
        return hashSet;
    }

    public static void i(String str, List list) {
        String str2;
        if (!TextUtils.isEmpty(str) && !com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof al) || (next instanceof App)) {
                    if (next instanceof App) {
                        str2 = ((App) next).id;
                    } else {
                        if (next instanceof al) {
                            al alVar = (al) next;
                            if (alVar.bmI() != null) {
                                str2 = alVar.bmI().eEd;
                            }
                        }
                        str2 = "";
                    }
                    if (TextUtils.equals(str, str2)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public static void fM(List<com.baidu.adp.widget.ListView.q> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < com.baidu.tieba.lego.card.d.a.eN(list)) {
                if (com.baidu.tieba.lego.card.d.a.l(list, i2) instanceof al) {
                    ((al) com.baidu.tieba.lego.card.d.a.l(list, i2)).setPosition(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static void fN(List<com.baidu.adp.widget.ListView.q> list) {
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            Iterator<com.baidu.adp.widget.ListView.q> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof al) {
                    it.remove();
                }
            }
        }
    }
}
