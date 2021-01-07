package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static List<al> r(List<App> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return arrayList;
        }
        Log.e("frs", "src ad list size " + list.size());
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
        Log.e("frs", "src ad jiaoyan size " + arrayList.size());
        return arrayList;
    }

    public static List<al> b(List<al> list, List<com.baidu.adp.widget.ListView.n> list2, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return arrayList;
        }
        fK(list);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            al alVar = (al) com.baidu.tieba.lego.card.c.a.l(list, i4);
            if (alVar != null && alVar.bpj() != null) {
                int eN = com.baidu.tieba.lego.card.c.a.eN(list2);
                int e = e(alVar.bpj()) - 1;
                if (e < 0) {
                    i3++;
                    g(alVar.bpj());
                } else {
                    int bpk = alVar.bpl() ? alVar.bpk() : ((e + i) + i4) - i3;
                    if (bpk > eN) {
                        g(alVar.bpj());
                        i3++;
                    } else {
                        alVar.setPosition(bpk);
                        com.baidu.tieba.lego.card.c.a.a(list2, alVar, bpk);
                        arrayList.add(alVar);
                    }
                }
            }
        }
        while (i < com.baidu.tieba.lego.card.c.a.eN(list2)) {
            com.baidu.adp.widget.ListView.n nVar = list2.get(i);
            if (nVar instanceof al) {
                i2++;
            } else if (nVar instanceof BaseCardInfo) {
                ((BaseCardInfo) nVar).position += i2;
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
                if (alVar.bpl() && alVar2.bpl()) {
                    return alVar.bpk() - alVar2.bpk();
                }
                if (alVar.bpl() || alVar2.bpl()) {
                    return !alVar.bpl() ? 1 : -1;
                }
                return (alVar.bpj() == null ? -1 : a.e(alVar.bpj())) - (alVar2.bpj() != null ? a.e(alVar2.bpj()) : -1);
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

    public static int f(@Nullable AdvertAppInfo advertAppInfo) {
        int bpf = advertAppInfo.bpf();
        if (e(advertAppInfo) < 0) {
            return 23;
        }
        return bpf;
    }

    private static void g(AdvertAppInfo advertAppInfo) {
        b(advertAppInfo, 23);
    }

    private static void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.e.dFW().a(com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 1, i));
        if (advertAppInfo != null && advertAppInfo.eOj != null) {
            advertAppInfo.eOj.mDiscardReason = i;
        }
    }

    public static int fL(@NonNull List<com.baidu.adp.widget.ListView.n> list) {
        boolean z = false;
        int eN = com.baidu.tieba.lego.card.c.a.eN(list);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            int eN2 = com.baidu.tieba.lego.card.c.a.eN(list) - 1;
            int i = 0;
            while (true) {
                if (eN2 < 0) {
                    break;
                } else if (com.baidu.tieba.lego.card.c.a.l(list, eN2) instanceof al) {
                    z = true;
                    break;
                } else {
                    i++;
                    eN2--;
                }
            }
            if (!z) {
                i = eN;
            }
            return i;
        }
        return eN;
    }

    public static Set<com.baidu.adp.widget.ListView.n> a(List<com.baidu.adp.widget.ListView.n> list, int i, String str) {
        AdvertAppInfo bpj;
        AdvertAppInfo bpj2;
        HashSet hashSet = new HashSet();
        if (com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return hashSet;
        }
        Set<com.baidu.adp.widget.ListView.n> RS = com.baidu.tieba.recapp.report.a.RS(str);
        HashSet hashSet2 = RS == null ? new HashSet() : RS;
        for (com.baidu.adp.widget.ListView.n nVar : list) {
            if (nVar != null) {
                for (com.baidu.adp.widget.ListView.n nVar2 : hashSet2) {
                    if ((nVar instanceof al) && (bpj2 = ((al) nVar).bpj()) != null && nVar2.hashCode() == bpj2.hashCode()) {
                        bpj2.advertAppContext = ((AdvertAppInfo) nVar2).advertAppContext;
                    }
                }
                if ((nVar instanceof al) && (bpj = ((al) nVar).bpj()) != null && bpj.advertAppContext == null) {
                    bpj.advertAppContext = new com.baidu.tbadk.core.data.c();
                    bpj.advertAppContext.page = str;
                    bpj.advertAppContext.pn = i;
                    bpj.advertAppContext.extensionInfo = bpj.extensionInfo;
                    bpj.advertAppContext.aay = false;
                    hashSet.add(bpj);
                }
            }
        }
        hashSet2.addAll(hashSet);
        com.baidu.tieba.recapp.report.a.c(str, hashSet2);
        return hashSet;
    }

    public static void i(String str, List list) {
        String str2;
        if (!TextUtils.isEmpty(str) && !com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof al) || (next instanceof App)) {
                    if (next instanceof App) {
                        str2 = ((App) next).id;
                    } else {
                        if (next instanceof al) {
                            al alVar = (al) next;
                            if (alVar.bpj() != null) {
                                str2 = alVar.bpj().eNT;
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

    public static void fM(List<com.baidu.adp.widget.ListView.n> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < com.baidu.tieba.lego.card.c.a.eN(list)) {
                if (com.baidu.tieba.lego.card.c.a.l(list, i2) instanceof al) {
                    ((al) com.baidu.tieba.lego.card.c.a.l(list, i2)).setPosition(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static void fN(List<com.baidu.adp.widget.ListView.n> list) {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            Iterator<com.baidu.adp.widget.ListView.n> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof al) {
                    it.remove();
                }
            }
        }
    }
}
