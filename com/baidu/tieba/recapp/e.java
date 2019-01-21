package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n bwp;
    private com.baidu.adp.widget.ListView.a ebO;
    private com.baidu.adp.widget.ListView.a ezQ;
    private com.baidu.tieba.InjectPlugin.a.c gPd;
    private com.baidu.adp.widget.ListView.a gPh;
    private com.baidu.adp.widget.ListView.a gPi;
    private com.baidu.adp.widget.ListView.a gPj;
    private com.baidu.adp.widget.ListView.a gPk;
    private com.baidu.adp.widget.ListView.a gPl;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gPd = cVar;
        if (this.gPd != null && (this.gPd.Ul() instanceof n)) {
            this.bwp = (n) this.gPd.Ul();
            this.ebO = new com.baidu.tieba.recapp.b.e(this.bwp, AdvertAppInfo.apC);
            this.ezQ = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apL);
            this.gPh = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apM);
            this.gPi = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apN);
            this.gPj = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apO);
            this.gPk = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apP);
            this.gPl = new com.baidu.tieba.recapp.b.g(this.bwp, AdvertAppInfo.apQ);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void aa(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> Uk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.apL.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apC.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apM.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apN.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apP.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.apQ.getId()));
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
                    int yp = advertAppInfo.yp();
                    if (yp != 0) {
                        a(advertAppInfo, i, yp);
                        if (yp != 28 && yp != 31) {
                            advertAppInfo.aqe.aqr = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int l = (com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(l))) {
                            b(advertAppInfo, i, 29);
                        } else if (l < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (l >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.P(advertAppInfo);
                            cVar.hs(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.yq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.apY)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.apY) && !TextUtils.isEmpty(advertAppInfo.apU)) {
                                    hashSet.add(Integer.valueOf(l));
                                    if (l < size) {
                                        list.add(l, cVar);
                                    } else if (l == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.yr()) {
                                hashSet.add(Integer.valueOf(l));
                                if (l < size) {
                                    list.add(l, cVar);
                                } else if (l == size) {
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
        int l;
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
                int i5 = (arrayList.size() <= 1 || (l = (com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : l;
                int l2 = com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i6 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < size2; i7++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i7);
                    advertAppInfo.page = "SMART_FRS";
                    int yp = advertAppInfo.yp();
                    if (yp != 0) {
                        a(advertAppInfo, i, yp);
                        if (yp != 28 && yp != 31) {
                            advertAppInfo.aqe.aqr = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int l3 = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0);
                        int i8 = (l3 + i2) - 1;
                        if (i8 >= 0 && !hashSet.contains(Integer.valueOf(i8)) && i8 <= size) {
                            if (l3 > (i6 - i5) + l2) {
                                if (z) {
                                    if (!v.I(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - l3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).Uh() instanceof AdvertAppInfo) {
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
                            cVar.P(advertAppInfo);
                            cVar.hs(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.yq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.apY)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.apY) && !TextUtils.isEmpty(advertAppInfo.apU)) {
                                    boolean hM = com.baidu.tbadk.download.b.Mh().hM(advertAppInfo.apY);
                                    boolean hO = com.baidu.tbadk.download.b.Mh().hO(advertAppInfo.apY);
                                    if (hM) {
                                        advertAppInfo.apS = 1;
                                    } else if (hO) {
                                        advertAppInfo.apS = 2;
                                    } else {
                                        advertAppInfo.apS = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.yr()) {
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
        com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.aql != null) {
            advertAppInfo.aql.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.aqe != null && advertAppInfo.aqe.aqr != 1001 && advertAppInfo.aqe.aqr != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.apL) {
                aVar = this.ezQ;
            } else if (type == AdvertAppInfo.apC) {
                aVar = this.ebO;
            } else if (type == AdvertAppInfo.apM) {
                aVar = this.gPh;
            } else if (type == AdvertAppInfo.apN) {
                aVar = this.gPi;
            } else if (type == AdvertAppInfo.apO) {
                aVar = this.gPj;
            } else if (type == AdvertAppInfo.apP) {
                aVar = this.gPk;
            } else {
                aVar = type == AdvertAppInfo.apQ ? this.gPl : null;
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
            if (type == AdvertAppInfo.apL) {
                aVar = this.ezQ;
            } else if (type == AdvertAppInfo.apC) {
                aVar = this.ebO;
            } else if (type == AdvertAppInfo.apM) {
                aVar = this.gPh;
            } else if (type == AdvertAppInfo.apN) {
                aVar = this.gPi;
            } else if (type == AdvertAppInfo.apO) {
                aVar = this.gPj;
            } else if (type == AdvertAppInfo.apP) {
                aVar = this.gPk;
            } else {
                aVar = type == AdvertAppInfo.apQ ? this.gPl : null;
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
            if (type == AdvertAppInfo.apL) {
                aVar2 = this.ezQ;
            } else if (type == AdvertAppInfo.apC) {
                aVar2 = this.ebO;
            } else if (type == AdvertAppInfo.apM) {
                aVar2 = this.gPh;
            } else if (type == AdvertAppInfo.apN) {
                aVar2 = this.gPi;
            } else if (type == AdvertAppInfo.apO) {
                aVar2 = this.gPj;
            } else if (type == AdvertAppInfo.apP) {
                aVar2 = this.gPk;
            } else if (type != AdvertAppInfo.apQ) {
                aVar2 = null;
            } else {
                aVar2 = this.gPl;
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
            Set<com.baidu.adp.widget.ListView.h> ve = com.baidu.tieba.recapp.report.a.ve("FRS");
            HashSet hashSet = ve == null ? new HashSet() : ve;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object Uh = cVar.Uh();
                    for (com.baidu.adp.widget.ListView.h hVar : hashSet) {
                        if (Uh != null && cVar.getThreadType() == 3 && (Uh instanceof AdvertAppInfo) && hVar != null && (hVar instanceof AdvertAppInfo) && Uh.hashCode() == hVar.hashCode()) {
                            ((AdvertAppInfo) Uh).advertAppContext = ((AdvertAppInfo) hVar).advertAppContext;
                        }
                    }
                    if (Uh != null && cVar.getThreadType() == 3 && (Uh instanceof AdvertAppInfo) && ((AdvertAppInfo) Uh).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) Uh;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.apy = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.apz = str2;
                        advertAppInfo.advertAppContext.apA = str3;
                        advertAppInfo.advertAppContext.apB = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Sc = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
