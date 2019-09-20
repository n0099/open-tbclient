package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
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
    private n cSf;
    private com.baidu.adp.widget.ListView.a gmD;
    private com.baidu.adp.widget.ListView.a gmE;
    private com.baidu.tieba.InjectPlugin.a.c iIS;
    private com.baidu.adp.widget.ListView.a iIW;
    private com.baidu.adp.widget.ListView.a iIX;
    private com.baidu.adp.widget.ListView.a iIY;
    private com.baidu.adp.widget.ListView.a iIZ;
    private com.baidu.adp.widget.ListView.a iJa;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iIS = cVar;
        if (this.iIS != null && (this.iIS.aAR() instanceof n)) {
            this.cSf = (n) this.iIS.aAR();
            this.gmD = new com.baidu.tieba.recapp.b.e(this.cSf, AdvertAppInfo.bFb);
            this.gmE = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFk);
            this.iIW = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFl);
            this.iIX = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFm);
            this.iIY = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFn);
            this.iIZ = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFo);
            this.iJa = new com.baidu.tieba.recapp.b.g(this.cSf, AdvertAppInfo.bFp);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void au(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> aAQ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFk.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFb.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFl.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFm.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFo.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bFp.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void f(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int acL = advertAppInfo.acL();
                    if (acL != 0) {
                        a(advertAppInfo, i, acL);
                        if (acL != 28 && acL != 31) {
                            advertAppInfo.bFC.bFP = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int f = (com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(f))) {
                            b(advertAppInfo, i, 29);
                        } else if (f < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (f >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aj(advertAppInfo);
                            cVar.mi(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.acM()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bFw)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bFw) && !TextUtils.isEmpty(advertAppInfo.bFt)) {
                                    hashSet.add(Integer.valueOf(f));
                                    if (f < size) {
                                        list.add(f, cVar);
                                    } else if (f == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.acN()) {
                                hashSet.add(Integer.valueOf(f));
                                if (f < size) {
                                    list.add(f, cVar);
                                } else if (f == size) {
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
        int f;
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
                int i5 = (arrayList.size() <= 1 || (f = (com.baidu.adp.lib.g.b.f(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.f(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : f;
                int f2 = com.baidu.adp.lib.g.b.f(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i6 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < size2; i7++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i7);
                    advertAppInfo.page = "SMART_FRS";
                    int acL = advertAppInfo.acL();
                    if (acL != 0) {
                        a(advertAppInfo, i, acL);
                        if (acL != 28 && acL != 31) {
                            advertAppInfo.bFC.bFP = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int f3 = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, 0);
                        int i8 = (f3 + i2) - 1;
                        if (i8 >= 0 && !hashSet.contains(Integer.valueOf(i8)) && i8 <= size) {
                            if (f3 > (i6 - i5) + f2) {
                                if (z) {
                                    if (!v.aa(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - f3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).aAN() instanceof AdvertAppInfo) {
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
                            cVar.aj(advertAppInfo);
                            cVar.mi(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.acM()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bFw)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bFw) && !TextUtils.isEmpty(advertAppInfo.bFt)) {
                                    boolean qk = com.baidu.tbadk.download.b.ase().qk(advertAppInfo.bFw);
                                    boolean qm = com.baidu.tbadk.download.b.ase().qm(advertAppInfo.bFw);
                                    if (qk) {
                                        advertAppInfo.bFr = 1;
                                    } else if (qm) {
                                        advertAppInfo.bFr = 2;
                                    } else {
                                        advertAppInfo.bFr = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.acN()) {
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
        com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.bFJ != null) {
            advertAppInfo.bFJ.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.bFC != null && advertAppInfo.bFC.bFP != 1001 && advertAppInfo.bFC.bFP != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.bFk) {
                aVar = this.gmE;
            } else if (type == AdvertAppInfo.bFb) {
                aVar = this.gmD;
            } else if (type == AdvertAppInfo.bFl) {
                aVar = this.iIW;
            } else if (type == AdvertAppInfo.bFm) {
                aVar = this.iIX;
            } else if (type == AdvertAppInfo.bFn) {
                aVar = this.iIY;
            } else if (type == AdvertAppInfo.bFo) {
                aVar = this.iIZ;
            } else {
                aVar = type == AdvertAppInfo.bFp ? this.iJa : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public v.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.bFk) {
                aVar = this.gmE;
            } else if (type == AdvertAppInfo.bFb) {
                aVar = this.gmD;
            } else if (type == AdvertAppInfo.bFl) {
                aVar = this.iIW;
            } else if (type == AdvertAppInfo.bFm) {
                aVar = this.iIX;
            } else if (type == AdvertAppInfo.bFn) {
                aVar = this.iIY;
            } else if (type == AdvertAppInfo.bFo) {
                aVar = this.iIZ;
            } else {
                aVar = type == AdvertAppInfo.bFp ? this.iJa : null;
            }
            if (aVar != null) {
                return aVar.onCreateViewHolder(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void onFillViewHolder(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.bFk) {
                aVar2 = this.gmE;
            } else if (type == AdvertAppInfo.bFb) {
                aVar2 = this.gmD;
            } else if (type == AdvertAppInfo.bFl) {
                aVar2 = this.iIW;
            } else if (type == AdvertAppInfo.bFm) {
                aVar2 = this.iIX;
            } else if (type == AdvertAppInfo.bFn) {
                aVar2 = this.iIY;
            } else if (type == AdvertAppInfo.bFo) {
                aVar2 = this.iIZ;
            } else if (type != AdvertAppInfo.bFp) {
                aVar2 = null;
            } else {
                aVar2 = this.iJa;
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
            Set<com.baidu.adp.widget.ListView.m> Et = com.baidu.tieba.recapp.report.a.Et("FRS");
            HashSet hashSet = Et == null ? new HashSet() : Et;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object aAN = cVar.aAN();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (aAN != null && cVar.getThreadType() == 3 && (aAN instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && aAN.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) aAN).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (aAN != null && cVar.getThreadType() == 3 && (aAN instanceof AdvertAppInfo) && ((AdvertAppInfo) aAN).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) aAN;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.bEW = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.bEX = str2;
                        advertAppInfo.advertAppContext.bEY = str3;
                        advertAppInfo.advertAppContext.bEZ = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Rm = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("FRS", hashSet);
        }
    }
}
