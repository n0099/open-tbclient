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
    private n cPJ;
    private com.baidu.adp.widget.ListView.a gdJ;
    private com.baidu.adp.widget.ListView.a gdK;
    private com.baidu.tieba.InjectPlugin.a.c izf;
    private com.baidu.adp.widget.ListView.a izj;
    private com.baidu.adp.widget.ListView.a izk;
    private com.baidu.adp.widget.ListView.a izl;
    private com.baidu.adp.widget.ListView.a izm;
    private com.baidu.adp.widget.ListView.a izn;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.izf = cVar;
        if (this.izf != null && (this.izf.azn() instanceof n)) {
            this.cPJ = (n) this.izf.azn();
            this.gdJ = new com.baidu.tieba.recapp.b.e(this.cPJ, AdvertAppInfo.bDC);
            this.gdK = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDL);
            this.izj = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDM);
            this.izk = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDN);
            this.izl = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDO);
            this.izm = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDP);
            this.izn = new com.baidu.tieba.recapp.b.g(this.cPJ, AdvertAppInfo.bDQ);
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
    public List<Integer> azm() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDL.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDC.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDM.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDN.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDP.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bDQ.getId()));
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
                    int abE = advertAppInfo.abE();
                    if (abE != 0) {
                        a(advertAppInfo, i, abE);
                        if (abE != 28 && abE != 31) {
                            advertAppInfo.bEd.bEq = -1001;
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
                            cVar.lW(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.abF()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bDX)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bDX) && !TextUtils.isEmpty(advertAppInfo.bDU)) {
                                    hashSet.add(Integer.valueOf(f));
                                    if (f < size) {
                                        list.add(f, cVar);
                                    } else if (f == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.abG()) {
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
                    int abE = advertAppInfo.abE();
                    if (abE != 0) {
                        a(advertAppInfo, i, abE);
                        if (abE != 28 && abE != 31) {
                            advertAppInfo.bEd.bEq = -1001;
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
                                            } else if (list2.get(i11).azj() instanceof AdvertAppInfo) {
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
                            cVar.lW(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.abF()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bDX)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bDX) && !TextUtils.isEmpty(advertAppInfo.bDU)) {
                                    boolean pI = com.baidu.tbadk.download.b.aqK().pI(advertAppInfo.bDX);
                                    boolean pK = com.baidu.tbadk.download.b.aqK().pK(advertAppInfo.bDX);
                                    if (pI) {
                                        advertAppInfo.bDS = 1;
                                    } else if (pK) {
                                        advertAppInfo.bDS = 2;
                                    } else {
                                        advertAppInfo.bDS = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.abG()) {
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
        com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.bEk != null) {
            advertAppInfo.bEk.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.bEd != null && advertAppInfo.bEd.bEq != 1001 && advertAppInfo.bEd.bEq != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.bDL) {
                aVar = this.gdK;
            } else if (type == AdvertAppInfo.bDC) {
                aVar = this.gdJ;
            } else if (type == AdvertAppInfo.bDM) {
                aVar = this.izj;
            } else if (type == AdvertAppInfo.bDN) {
                aVar = this.izk;
            } else if (type == AdvertAppInfo.bDO) {
                aVar = this.izl;
            } else if (type == AdvertAppInfo.bDP) {
                aVar = this.izm;
            } else {
                aVar = type == AdvertAppInfo.bDQ ? this.izn : null;
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
            if (type == AdvertAppInfo.bDL) {
                aVar = this.gdK;
            } else if (type == AdvertAppInfo.bDC) {
                aVar = this.gdJ;
            } else if (type == AdvertAppInfo.bDM) {
                aVar = this.izj;
            } else if (type == AdvertAppInfo.bDN) {
                aVar = this.izk;
            } else if (type == AdvertAppInfo.bDO) {
                aVar = this.izl;
            } else if (type == AdvertAppInfo.bDP) {
                aVar = this.izm;
            } else {
                aVar = type == AdvertAppInfo.bDQ ? this.izn : null;
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
            if (type == AdvertAppInfo.bDL) {
                aVar2 = this.gdK;
            } else if (type == AdvertAppInfo.bDC) {
                aVar2 = this.gdJ;
            } else if (type == AdvertAppInfo.bDM) {
                aVar2 = this.izj;
            } else if (type == AdvertAppInfo.bDN) {
                aVar2 = this.izk;
            } else if (type == AdvertAppInfo.bDO) {
                aVar2 = this.izl;
            } else if (type == AdvertAppInfo.bDP) {
                aVar2 = this.izm;
            } else if (type != AdvertAppInfo.bDQ) {
                aVar2 = null;
            } else {
                aVar2 = this.izn;
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
            Set<com.baidu.adp.widget.ListView.m> Df = com.baidu.tieba.recapp.report.a.Df("FRS");
            HashSet hashSet = Df == null ? new HashSet() : Df;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object azj = cVar.azj();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (azj != null && cVar.getThreadType() == 3 && (azj instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && azj.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) azj).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (azj != null && cVar.getThreadType() == 3 && (azj instanceof AdvertAppInfo) && ((AdvertAppInfo) azj).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) azj;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.bDy = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.bDz = str2;
                        advertAppInfo.advertAppContext.bDA = str3;
                        advertAppInfo.advertAppContext.bDB = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.QV = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("FRS", hashSet);
        }
    }
}
