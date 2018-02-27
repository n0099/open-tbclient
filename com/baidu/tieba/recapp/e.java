package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n bNp;
    private com.baidu.adp.widget.ListView.a dRs;
    private com.baidu.adp.widget.ListView.a ekb;
    private com.baidu.adp.widget.ListView.a gBA;
    private com.baidu.adp.widget.ListView.a gBB;
    private com.baidu.tieba.InjectPlugin.a.c gBt;
    private com.baidu.adp.widget.ListView.a gBx;
    private com.baidu.adp.widget.ListView.a gBy;
    private com.baidu.adp.widget.ListView.a gBz;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void aL(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gBt = cVar;
        if (this.gBt != null && (this.gBt.Sq() instanceof n)) {
            this.bNp = (n) this.gBt.Sq();
            this.dRs = new com.baidu.tieba.recapp.b.e(this.bNp, AdvertAppInfo.aKd);
            this.ekb = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKm);
            this.gBx = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKn);
            this.gBy = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKo);
            this.gBz = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKp);
            this.gBA = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKq);
            this.gBB = new com.baidu.tieba.recapp.b.g(this.bNp, AdvertAppInfo.aKr);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void W(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> Sp() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKm.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKd.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKo.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKp.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKq.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.aKr.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void j(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    advertAppInfo.aJX = "FRS";
                    int xJ = advertAppInfo.xJ();
                    if (xJ != 0) {
                        a(advertAppInfo, i, xJ);
                        if (xJ != 28 && xJ != 31) {
                            advertAppInfo.aKG.aKS = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int h = (com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(h))) {
                            b(advertAppInfo, i, 29);
                        } else if (h < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (h >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aK(advertAppInfo);
                            cVar.jb(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.xK()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.aKz)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.aKz) && !TextUtils.isEmpty(advertAppInfo.aKv)) {
                                    hashSet.add(Integer.valueOf(h));
                                    if (h < size) {
                                        list.add(h, cVar);
                                    } else if (h == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.xL()) {
                                hashSet.add(Integer.valueOf(h));
                                if (h < size) {
                                    list.add(h, cVar);
                                } else if (h == size) {
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
        int h;
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
                int i5 = (arrayList.size() <= 1 || (h = (com.baidu.adp.lib.g.b.h(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.h(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : h;
                int h2 = com.baidu.adp.lib.g.b.h(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i6 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < size2; i7++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i7);
                    advertAppInfo.aJX = "SMART_FRS";
                    int xJ = advertAppInfo.xJ();
                    if (xJ != 0) {
                        a(advertAppInfo, i, xJ);
                        if (xJ != 28 && xJ != 31) {
                            advertAppInfo.aKG.aKS = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int h3 = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, 0);
                        int i8 = (h3 + i2) - 1;
                        if (i8 >= 0 && !hashSet.contains(Integer.valueOf(i8)) && i8 <= size) {
                            if (h3 > (i6 - i5) + h2) {
                                if (z) {
                                    if (!v.E(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - h3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).Sm() instanceof AdvertAppInfo) {
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
                            cVar.aK(advertAppInfo);
                            cVar.jb(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.xK()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.aKz)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.aKz) && !TextUtils.isEmpty(advertAppInfo.aKv)) {
                                    boolean gc = com.baidu.tbadk.download.b.KQ().gc(advertAppInfo.aKz);
                                    boolean ge = com.baidu.tbadk.download.b.KQ().ge(advertAppInfo.aKz);
                                    if (gc) {
                                        advertAppInfo.aKt = 1;
                                    } else if (ge) {
                                        advertAppInfo.aKt = 2;
                                    } else {
                                        advertAppInfo.aKt = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.xL()) {
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
        com.baidu.tieba.recapp.report.b.boW().a(com.baidu.tieba.recapp.report.e.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.aKM != null) {
            advertAppInfo.aKM.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.aKG != null && advertAppInfo.aKG.aKS != 1001 && advertAppInfo.aKG.aKS != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.aKm) {
                aVar = this.ekb;
            } else if (type == AdvertAppInfo.aKd) {
                aVar = this.dRs;
            } else if (type == AdvertAppInfo.aKn) {
                aVar = this.gBx;
            } else if (type == AdvertAppInfo.aKo) {
                aVar = this.gBy;
            } else if (type == AdvertAppInfo.aKp) {
                aVar = this.gBz;
            } else if (type == AdvertAppInfo.aKq) {
                aVar = this.gBA;
            } else {
                aVar = type == AdvertAppInfo.aKr ? this.gBB : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public r.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.aKm) {
                aVar = this.ekb;
            } else if (type == AdvertAppInfo.aKd) {
                aVar = this.dRs;
            } else if (type == AdvertAppInfo.aKn) {
                aVar = this.gBx;
            } else if (type == AdvertAppInfo.aKo) {
                aVar = this.gBy;
            } else if (type == AdvertAppInfo.aKp) {
                aVar = this.gBz;
            } else if (type == AdvertAppInfo.aKq) {
                aVar = this.gBA;
            } else {
                aVar = type == AdvertAppInfo.aKr ? this.gBB : null;
            }
            if (aVar != null) {
                return aVar.onCreateViewHolder(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void onFillViewHolder(int i, ViewGroup viewGroup, r.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.aKm) {
                aVar2 = this.ekb;
            } else if (type == AdvertAppInfo.aKd) {
                aVar2 = this.dRs;
            } else if (type == AdvertAppInfo.aKn) {
                aVar2 = this.gBx;
            } else if (type == AdvertAppInfo.aKo) {
                aVar2 = this.gBy;
            } else if (type == AdvertAppInfo.aKp) {
                aVar2 = this.gBz;
            } else if (type == AdvertAppInfo.aKq) {
                aVar2 = this.gBA;
            } else if (type != AdvertAppInfo.aKr) {
                aVar2 = null;
            } else {
                aVar2 = this.gBB;
            }
            if (aVar2 != null) {
                aVar2.onFillViewHolder(i, viewGroup, aVar, obj);
            }
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void changeSkinType(int i) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, String str, String str2, String str3, String str4, boolean z, int i) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null && cVar.getThreadType() == 3 && (cVar.Sm() instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar.Sm();
                    advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                    advertAppInfo.advertAppContext.aJX = "FRS";
                    advertAppInfo.advertAppContext.aJY = String.valueOf(z);
                    advertAppInfo.advertAppContext.pn = i;
                    advertAppInfo.advertAppContext.fid = str;
                    advertAppInfo.advertAppContext.aJZ = str2;
                    advertAppInfo.advertAppContext.aKa = str3;
                    advertAppInfo.advertAppContext.aKb = str4;
                    advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                    advertAppInfo.advertAppContext.aKc = false;
                }
            }
        }
    }
}
