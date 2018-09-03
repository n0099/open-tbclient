package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n bhs;
    private com.baidu.adp.widget.ListView.a dBX;
    private com.baidu.adp.widget.ListView.a dYI;
    private com.baidu.tieba.InjectPlugin.a.c gnW;
    private com.baidu.adp.widget.ListView.a goa;
    private com.baidu.adp.widget.ListView.a gob;
    private com.baidu.adp.widget.ListView.a goc;
    private com.baidu.adp.widget.ListView.a god;
    private com.baidu.adp.widget.ListView.a goe;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gnW = cVar;
        if (this.gnW != null && (this.gnW.OK() instanceof n)) {
            this.bhs = (n) this.gnW.OK();
            this.dBX = new com.baidu.tieba.recapp.b.e(this.bhs, AdvertAppInfo.adn);
            this.dYI = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.adw);
            this.goa = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.adx);
            this.gob = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.ady);
            this.goc = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.adz);
            this.god = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.adA);
            this.goe = new com.baidu.tieba.recapp.b.g(this.bhs, AdvertAppInfo.adB);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void Q(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> OJ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.adw.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adx.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ady.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adz.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adA.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adB.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void g(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
        int i2;
        if (this.mOriginDatas != null && !this.mOriginDatas.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    arrayList.add((AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int size = list.size();
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int size2 = arrayList.size();
            if (size2 >= 1) {
                int i4 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < size2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i5);
                    advertAppInfo.page = "FRS";
                    int tE = advertAppInfo.tE();
                    if (tE != 0) {
                        a(advertAppInfo, i, tE);
                        if (tE != 28 && tE != 31) {
                            advertAppInfo.adQ.aed = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int g = (com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(g))) {
                            b(advertAppInfo, i, 29);
                        } else if (g < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (g >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.I(advertAppInfo);
                            cVar.gg(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.tF()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.adJ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.adJ) && !TextUtils.isEmpty(advertAppInfo.adF)) {
                                    hashSet.add(Integer.valueOf(g));
                                    if (g < size) {
                                        list.add(g, cVar);
                                    } else if (g == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.tG()) {
                                hashSet.add(Integer.valueOf(g));
                                if (g < size) {
                                    list.add(g, cVar);
                                } else if (g == size) {
                                    list.add(cVar);
                                }
                            } else {
                                b(advertAppInfo, i, 21);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list2, boolean z, int i) {
        int i2;
        int i3;
        boolean z2;
        int g;
        if (this.mOriginDatas != null && !this.mOriginDatas.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    arrayList.add((AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int size = list.size();
            int i4 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i4;
                if (!it2.hasNext()) {
                    break;
                }
                i4 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int size2 = arrayList.size();
            if (size2 >= 1) {
                int i5 = (arrayList.size() <= 1 || (g = (com.baidu.adp.lib.g.b.g(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.g(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : g;
                int g2 = com.baidu.adp.lib.g.b.g(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i6 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < size2; i7++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i7);
                    advertAppInfo.page = "SMART_FRS";
                    int tE = advertAppInfo.tE();
                    if (tE != 0) {
                        a(advertAppInfo, i, tE);
                        if (tE != 28 && tE != 31) {
                            advertAppInfo.adQ.aed = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int g3 = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0);
                        int i8 = (g3 + i2) - 1;
                        if (i8 >= 0 && !hashSet.contains(Integer.valueOf(i8)) && i8 <= size) {
                            if (g3 > (i6 - i5) + g2) {
                                if (z) {
                                    if (!w.z(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - g3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).OG() instanceof AdvertAppInfo) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i10 = i11 + 1;
                                            }
                                        }
                                        z2 = true;
                                        if (!z2) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                    } else {
                                        i3 = 36;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            } else {
                                i3 = 0;
                            }
                        } else if (i8 > size) {
                            i3 = 2;
                        } else if (i8 < 0) {
                            i3 = 33;
                        } else {
                            i3 = 29;
                        }
                        if (i3 != 0) {
                            b(advertAppInfo, i, i3);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.I(advertAppInfo);
                            cVar.gg(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.tF()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.adJ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.adJ) && !TextUtils.isEmpty(advertAppInfo.adF)) {
                                    boolean gu = com.baidu.tbadk.download.b.Hk().gu(advertAppInfo.adJ);
                                    boolean gw = com.baidu.tbadk.download.b.Hk().gw(advertAppInfo.adJ);
                                    if (gu) {
                                        advertAppInfo.adD = 1;
                                    } else if (gw) {
                                        advertAppInfo.adD = 2;
                                    } else {
                                        advertAppInfo.adD = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.tG()) {
                                hashSet.add(Integer.valueOf(i8));
                                if (i8 < size) {
                                    list.add(i8, cVar);
                                } else if (i8 == size) {
                                    list.add(cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.adX != null) {
            advertAppInfo.adX.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.aed != 1001 && advertAppInfo.adQ.aed != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.adw) {
                aVar = this.dYI;
            } else if (type == AdvertAppInfo.adn) {
                aVar = this.dBX;
            } else if (type == AdvertAppInfo.adx) {
                aVar = this.goa;
            } else if (type == AdvertAppInfo.ady) {
                aVar = this.gob;
            } else if (type == AdvertAppInfo.adz) {
                aVar = this.goc;
            } else if (type == AdvertAppInfo.adA) {
                aVar = this.god;
            } else {
                aVar = type == AdvertAppInfo.adB ? this.goe : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public q.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.adw) {
                aVar = this.dYI;
            } else if (type == AdvertAppInfo.adn) {
                aVar = this.dBX;
            } else if (type == AdvertAppInfo.adx) {
                aVar = this.goa;
            } else if (type == AdvertAppInfo.ady) {
                aVar = this.gob;
            } else if (type == AdvertAppInfo.adz) {
                aVar = this.goc;
            } else if (type == AdvertAppInfo.adA) {
                aVar = this.god;
            } else {
                aVar = type == AdvertAppInfo.adB ? this.goe : null;
            }
            if (aVar != null) {
                return aVar.onCreateViewHolder(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void onFillViewHolder(int i, ViewGroup viewGroup, q.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.adw) {
                aVar2 = this.dYI;
            } else if (type == AdvertAppInfo.adn) {
                aVar2 = this.dBX;
            } else if (type == AdvertAppInfo.adx) {
                aVar2 = this.goa;
            } else if (type == AdvertAppInfo.ady) {
                aVar2 = this.gob;
            } else if (type == AdvertAppInfo.adz) {
                aVar2 = this.goc;
            } else if (type == AdvertAppInfo.adA) {
                aVar2 = this.god;
            } else if (type != AdvertAppInfo.adB) {
                aVar2 = null;
            } else {
                aVar2 = this.goe;
            }
            if (aVar2 != null) {
                aVar2.onFillViewHolder(i, viewGroup, aVar, obj);
            }
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void changeSkinType(int i) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Set] */
    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, String str, String str2, String str3, String str4, boolean z, int i) {
        if (list != null && !list.isEmpty()) {
            Set<com.baidu.adp.widget.ListView.h> sX = com.baidu.tieba.recapp.report.a.sX("FRS");
            HashSet hashSet = sX == null ? new HashSet() : sX;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object OG = cVar.OG();
                    for (com.baidu.adp.widget.ListView.h hVar : hashSet) {
                        if (OG != null && cVar.getThreadType() == 3 && (OG instanceof AdvertAppInfo) && hVar != null && (hVar instanceof AdvertAppInfo) && OG.hashCode() == hVar.hashCode()) {
                            ((AdvertAppInfo) OG).advertAppContext = ((AdvertAppInfo) hVar).advertAppContext;
                        }
                    }
                    if (OG != null && cVar.getThreadType() == 3 && (OG instanceof AdvertAppInfo) && ((AdvertAppInfo) OG).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) OG;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.adj = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.adk = str2;
                        advertAppInfo.advertAppContext.adl = str3;
                        advertAppInfo.advertAppContext.adm = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.OY = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
