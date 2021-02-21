package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a {
    public static List<am> p(List<App> list, String str) {
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

    public static List<am> b(List<am> list, List<com.baidu.adp.widget.ListView.n> list2, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return arrayList;
        }
        fI(list);
        for (int i3 = 0; i3 < list.size(); i3++) {
            am amVar = (am) com.baidu.tieba.lego.card.c.a.l(list, i3);
            if (amVar != null && amVar.blH() != null) {
                int eL = com.baidu.tieba.lego.card.c.a.eL(list2);
                int e = e(amVar.blH()) - 1;
                if (e < 0) {
                    g(amVar.blH());
                } else {
                    int blI = amVar.blJ() ? amVar.blI() : e + i;
                    if (blI > eL) {
                        g(amVar.blH());
                    } else {
                        amVar.setPosition(blI);
                        com.baidu.tieba.lego.card.c.a.a(list2, amVar, blI);
                        arrayList.add(amVar);
                    }
                }
            }
        }
        while (i < com.baidu.tieba.lego.card.c.a.eL(list2)) {
            com.baidu.adp.widget.ListView.n nVar = list2.get(i);
            if (nVar instanceof am) {
                i2++;
            } else if (nVar instanceof BaseCardInfo) {
                ((BaseCardInfo) nVar).position += i2;
            }
            i++;
        }
        return arrayList;
    }

    public static void fI(List<am> list) {
        Collections.sort(list, new Comparator<am>() { // from class: com.baidu.tieba.recapp.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(am amVar, am amVar2) {
                if (amVar.blJ() && amVar2.blJ()) {
                    return amVar.blI() - amVar2.blI();
                }
                if (amVar.blJ() || amVar2.blJ()) {
                    return !amVar.blJ() ? 1 : -1;
                }
                return (amVar.blH() == null ? -1 : a.e(amVar.blH())) - (amVar2.blH() != null ? a.e(amVar2.blH()) : -1);
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
        int blD = advertAppInfo.blD();
        if (e(advertAppInfo) < 0) {
            return 23;
        }
        return blD;
    }

    private static void g(AdvertAppInfo advertAppInfo) {
        b(advertAppInfo, 23);
    }

    private static void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.e.dEu().a(com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 1, i));
        if (advertAppInfo != null && advertAppInfo.eLJ != null) {
            advertAppInfo.eLJ.mDiscardReason = i;
        }
    }

    public static int fJ(@NonNull List<com.baidu.adp.widget.ListView.n> list) {
        boolean z = false;
        int eL = com.baidu.tieba.lego.card.c.a.eL(list);
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            int eL2 = com.baidu.tieba.lego.card.c.a.eL(list) - 1;
            int i = 0;
            while (true) {
                if (eL2 < 0) {
                    break;
                } else if (com.baidu.tieba.lego.card.c.a.l(list, eL2) instanceof am) {
                    z = true;
                    break;
                } else {
                    i++;
                    eL2--;
                }
            }
            if (!z) {
                i = eL;
            }
            return i;
        }
        return eL;
    }

    public static Set<com.baidu.adp.widget.ListView.n> a(List<com.baidu.adp.widget.ListView.n> list, int i, String str) {
        AdvertAppInfo blH;
        AdvertAppInfo blH2;
        HashSet hashSet = new HashSet();
        if (com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return hashSet;
        }
        Set<com.baidu.adp.widget.ListView.n> RQ = com.baidu.tieba.recapp.report.a.RQ(str);
        HashSet hashSet2 = RQ == null ? new HashSet() : RQ;
        for (com.baidu.adp.widget.ListView.n nVar : list) {
            if (nVar != null) {
                for (com.baidu.adp.widget.ListView.n nVar2 : hashSet2) {
                    if ((nVar instanceof am) && (blH2 = ((am) nVar).blH()) != null && nVar2.hashCode() == blH2.hashCode()) {
                        blH2.advertAppContext = ((AdvertAppInfo) nVar2).advertAppContext;
                    }
                }
                if ((nVar instanceof am) && (blH = ((am) nVar).blH()) != null && blH.advertAppContext == null) {
                    blH.advertAppContext = new com.baidu.tbadk.core.data.d();
                    blH.advertAppContext.page = str;
                    blH.advertAppContext.pn = i;
                    blH.advertAppContext.extensionInfo = blH.extensionInfo;
                    blH.advertAppContext.aas = false;
                    hashSet.add(blH);
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
                if ((next instanceof am) || (next instanceof App)) {
                    if (next instanceof App) {
                        str2 = ((App) next).id;
                    } else {
                        if (next instanceof am) {
                            am amVar = (am) next;
                            if (amVar.blH() != null) {
                                str2 = amVar.blH().eLt;
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

    public static void fK(List<com.baidu.adp.widget.ListView.n> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < com.baidu.tieba.lego.card.c.a.eL(list)) {
                if (com.baidu.tieba.lego.card.c.a.l(list, i2) instanceof am) {
                    ((am) com.baidu.tieba.lego.card.c.a.l(list, i2)).setPosition(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static void fL(List<com.baidu.adp.widget.ListView.n> list) {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            Iterator<com.baidu.adp.widget.ListView.n> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof am) {
                    it.remove();
                }
            }
        }
    }

    public static String y(List<com.baidu.adp.widget.ListView.n> list, boolean z) {
        int i;
        StringBuilder sb = new StringBuilder("");
        if (z || com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            return sb.toString();
        }
        int i2 = 0;
        int eL = com.baidu.tieba.lego.card.c.a.eL(list) - 1;
        while (eL >= 0 && i2 < 6) {
            if (com.baidu.tieba.lego.card.c.a.l(list, eL) instanceof am) {
                am amVar = (am) com.baidu.tieba.lego.card.c.a.l(list, eL);
                if (amVar == null) {
                    i = i2;
                } else if (h(amVar.blH())) {
                    i = i2;
                } else {
                    sb.append(amVar.blI() + 1).append(",");
                    i = i2 + 1;
                }
            } else {
                i = i2;
            }
            eL--;
            i2 = i;
        }
        if (sb.length() <= 1) {
            return sb.toString();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean h(AdvertAppInfo advertAppInfo) {
        return advertAppInfo == null || advertAppInfo.getType() == AdvertAppInfo.eLa || advertAppInfo.getType() == AdvertAppInfo.eLf || advertAppInfo.getType() == AdvertAppInfo.eLg;
    }

    public static int e(@NonNull App app) {
        if (app.goods_info == null) {
            return -1001;
        }
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                return goodsInfo.goods_style.intValue();
            }
        }
        return -1001;
    }

    public static boolean f(@NonNull App app) {
        if (app.goods_info == null) {
            return false;
        }
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null && goodsInfo.goods_style.intValue() == 1001) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(App app, BannerList bannerList) {
        if (app == null || bannerList == null) {
            return false;
        }
        if (a(app, bannerList.pb_banner_ad)) {
            return true;
        }
        List<App> list = bannerList.video_recommend_ad;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            for (App app2 : list) {
                if (a(app, app2)) {
                    return true;
                }
            }
        }
        List<App> list2 = bannerList.app;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list2)) {
            for (App app3 : list2) {
                if (a(app, app3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(App app, App app2) {
        String str;
        String str2 = null;
        if (app == null || app2 == null) {
            return false;
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(app.goods_info) || com.baidu.tieba.lego.card.c.a.isEmpty(app2.goods_info)) {
            return false;
        }
        Iterator<GoodsInfo> it = app.goods_info.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            GoodsInfo next = it.next();
            if (next != null) {
                str = next.lego_card;
                break;
            }
        }
        Iterator<GoodsInfo> it2 = app2.goods_info.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            GoodsInfo next2 = it2.next();
            if (next2 != null) {
                str2 = next2.lego_card;
                break;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            if (TextUtils.equals(new JSONObject(str).optString("download_key"), new JSONObject(str2).optString("download_key"))) {
                return true;
            }
        } catch (JSONException e) {
        }
        return false;
    }
}
