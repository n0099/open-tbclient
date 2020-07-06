package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes13.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private m eSv;
    private com.baidu.adp.widget.ListView.a iun;
    private com.baidu.adp.widget.ListView.a iuo;
    private com.baidu.tieba.InjectPlugin.a.c leh;
    private com.baidu.adp.widget.ListView.a lel;
    private com.baidu.adp.widget.ListView.a lem;
    private com.baidu.adp.widget.ListView.a leo;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.leh = cVar;
        if (this.leh != null && (this.leh.bmA() instanceof m)) {
            this.eSv = (m) this.leh.bmA();
            this.iun = new com.baidu.tieba.recapp.b.e(this.eSv, AdvertAppInfo.dGu);
            this.iuo = new com.baidu.tieba.recapp.b.g(this.eSv, AdvertAppInfo.dGD);
            this.lel = new com.baidu.tieba.recapp.b.g(this.eSv, AdvertAppInfo.dGE);
            this.lem = new com.baidu.tieba.recapp.b.g(this.eSv, AdvertAppInfo.dGF);
            this.leo = new com.baidu.tieba.recapp.b.g(this.eSv, AdvertAppInfo.dGG);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bh(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bmz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.dGD.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dGu.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dGE.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dGF.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dGG.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void d(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int aQi = advertAppInfo.aQi();
                    if (aQi != 0) {
                        a(advertAppInfo, i, aQi);
                        if (aQi != 28 && aQi != 31) {
                            advertAppInfo.dGU.dHh = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i6 = (com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(i6))) {
                            b(advertAppInfo, i, 29);
                        } else if (i6 < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (i6 >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.at(advertAppInfo);
                            cVar.pl(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aQj()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dGO)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dGO) && !TextUtils.isEmpty(advertAppInfo.dGM)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < size) {
                                        list.add(i6, cVar);
                                    } else if (i6 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aQk()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < size) {
                                    list.add(i6, cVar);
                                } else if (i6 == size) {
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
        int i4;
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
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int size2 = arrayList.size();
            if (size2 >= 1) {
                int i6 = (arrayList.size() <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i8 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < size2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i9);
                    advertAppInfo.page = "SMART_FRS";
                    int aQi = advertAppInfo.aQi();
                    if (aQi != 0) {
                        a(advertAppInfo, i, aQi);
                        if (aQi != 28 && aQi != 31) {
                            advertAppInfo.dGU.dHh = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= size) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!w.isEmpty(list2)) {
                                        int size3 = list2.size();
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= size3 || i14 >= i12) {
                                                break;
                                            } else if (list2.get(i14).bmw() instanceof AdvertAppInfo) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i13 = i14 + 1;
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
                        } else if (i11 > size) {
                            i3 = 2;
                        } else if (i11 < 0) {
                            i3 = 33;
                        } else {
                            i3 = 29;
                        }
                        if (i3 != 0) {
                            b(advertAppInfo, i, i3);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.at(advertAppInfo);
                            cVar.pl(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aQj()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dGO)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dGO) && !TextUtils.isEmpty(advertAppInfo.dGM)) {
                                    boolean ym = com.baidu.tbadk.download.b.beT().ym(advertAppInfo.dGO);
                                    boolean yo = com.baidu.tbadk.download.b.beT().yo(advertAppInfo.dGO);
                                    if (ym) {
                                        advertAppInfo.dGK = 1;
                                    } else if (yo) {
                                        advertAppInfo.dGK = 2;
                                    } else {
                                        advertAppInfo.dGK = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < size) {
                                        list.add(i11, cVar);
                                    } else if (i11 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aQk()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < size) {
                                    list.add(i11, cVar);
                                } else if (i11 == size) {
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
        com.baidu.tieba.recapp.report.d.cZR().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dHb != null) {
            advertAppInfo.dHb.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.dGU != null && advertAppInfo.dGU.dHh != 1001 && advertAppInfo.dGU.dHh != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.dGD) {
                aVar = this.iuo;
            } else if (type == AdvertAppInfo.dGu) {
                aVar = this.iun;
            } else if (type == AdvertAppInfo.dGE) {
                aVar = this.lel;
            } else if (type == AdvertAppInfo.dGF) {
                aVar = this.lem;
            } else {
                aVar = type == AdvertAppInfo.dGG ? this.leo : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public ad.a a(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.dGD) {
                aVar = this.iuo;
            } else if (type == AdvertAppInfo.dGu) {
                aVar = this.iun;
            } else if (type == AdvertAppInfo.dGE) {
                aVar = this.lel;
            } else if (type == AdvertAppInfo.dGF) {
                aVar = this.lem;
            } else {
                aVar = type == AdvertAppInfo.dGG ? this.leo : null;
            }
            if (aVar != null) {
                return aVar.a(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(int i, ViewGroup viewGroup, ad.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.dGD) {
                aVar2 = this.iuo;
            } else if (type == AdvertAppInfo.dGu) {
                aVar2 = this.iun;
            } else if (type == AdvertAppInfo.dGE) {
                aVar2 = this.lel;
            } else if (type == AdvertAppInfo.dGF) {
                aVar2 = this.lem;
            } else if (type != AdvertAppInfo.dGG) {
                aVar2 = null;
            } else {
                aVar2 = this.leo;
            }
            if (aVar2 != null) {
                aVar2.a(i, viewGroup, aVar, obj);
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
            Set<com.baidu.adp.widget.ListView.q> LV = com.baidu.tieba.recapp.report.a.LV("FRS");
            HashSet hashSet = LV == null ? new HashSet() : LV;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bmw = cVar.bmw();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bmw != null && cVar.getThreadType() == 3 && (bmw instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bmw.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bmw).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bmw != null && cVar.getThreadType() == 3 && (bmw instanceof AdvertAppInfo) && ((AdvertAppInfo) bmw).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bmw;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.dGp = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.dGq = str2;
                        advertAppInfo.advertAppContext.dGr = str3;
                        advertAppInfo.advertAppContext.dGs = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.XE = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
