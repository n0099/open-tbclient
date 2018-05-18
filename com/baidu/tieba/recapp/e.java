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
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n aXr;
    private com.baidu.adp.widget.ListView.a dFZ;
    private com.baidu.adp.widget.ListView.a dmM;
    private com.baidu.adp.widget.ListView.a fXD;
    private com.baidu.adp.widget.ListView.a fXE;
    private com.baidu.adp.widget.ListView.a fXF;
    private com.baidu.adp.widget.ListView.a fXG;
    private com.baidu.adp.widget.ListView.a fXH;
    private com.baidu.tieba.InjectPlugin.a.c fXz;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void G(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.fXz = cVar;
        if (this.fXz != null && (this.fXz.KN() instanceof n)) {
            this.aXr = (n) this.fXz.KN();
            this.dmM = new com.baidu.tieba.recapp.b.e(this.aXr, AdvertAppInfo.Vu);
            this.dFZ = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VD);
            this.fXD = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VE);
            this.fXE = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VF);
            this.fXF = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VG);
            this.fXG = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VH);
            this.fXH = new com.baidu.tieba.recapp.b.g(this.aXr, AdvertAppInfo.VI);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void N(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> KM() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.VD.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.Vu.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VE.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VF.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VG.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VH.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VI.getId()));
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
                    advertAppInfo.Vp = "FRS";
                    int qr = advertAppInfo.qr();
                    if (qr != 0) {
                        a(advertAppInfo, i, qr);
                        if (qr != 28 && qr != 31) {
                            advertAppInfo.VX.Wj = -1001;
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
                            cVar.F(advertAppInfo);
                            cVar.ga(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.qs()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.VQ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.VQ) && !TextUtils.isEmpty(advertAppInfo.VM)) {
                                    hashSet.add(Integer.valueOf(g));
                                    if (g < size) {
                                        list.add(g, cVar);
                                    } else if (g == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.qt()) {
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
                    advertAppInfo.Vp = "SMART_FRS";
                    int qr = advertAppInfo.qr();
                    if (qr != 0) {
                        a(advertAppInfo, i, qr);
                        if (qr != 28 && qr != 31) {
                            advertAppInfo.VX.Wj = -1001;
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
                                    if (!v.w(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - g3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).KJ() instanceof AdvertAppInfo) {
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
                            cVar.F(advertAppInfo);
                            cVar.ga(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.qs()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.VQ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.VQ) && !TextUtils.isEmpty(advertAppInfo.VM)) {
                                    boolean fT = com.baidu.tbadk.download.b.Dt().fT(advertAppInfo.VQ);
                                    boolean fV = com.baidu.tbadk.download.b.Dt().fV(advertAppInfo.VQ);
                                    if (fT) {
                                        advertAppInfo.VK = 1;
                                    } else if (fV) {
                                        advertAppInfo.VK = 2;
                                    } else {
                                        advertAppInfo.VK = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.qt()) {
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
        com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.Wd != null) {
            advertAppInfo.Wd.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.VX != null && advertAppInfo.VX.Wj != 1001 && advertAppInfo.VX.Wj != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.VD) {
                aVar = this.dFZ;
            } else if (type == AdvertAppInfo.Vu) {
                aVar = this.dmM;
            } else if (type == AdvertAppInfo.VE) {
                aVar = this.fXD;
            } else if (type == AdvertAppInfo.VF) {
                aVar = this.fXE;
            } else if (type == AdvertAppInfo.VG) {
                aVar = this.fXF;
            } else if (type == AdvertAppInfo.VH) {
                aVar = this.fXG;
            } else {
                aVar = type == AdvertAppInfo.VI ? this.fXH : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view2, viewGroup, advertAppInfo);
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
            if (type == AdvertAppInfo.VD) {
                aVar = this.dFZ;
            } else if (type == AdvertAppInfo.Vu) {
                aVar = this.dmM;
            } else if (type == AdvertAppInfo.VE) {
                aVar = this.fXD;
            } else if (type == AdvertAppInfo.VF) {
                aVar = this.fXE;
            } else if (type == AdvertAppInfo.VG) {
                aVar = this.fXF;
            } else if (type == AdvertAppInfo.VH) {
                aVar = this.fXG;
            } else {
                aVar = type == AdvertAppInfo.VI ? this.fXH : null;
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
            if (type == AdvertAppInfo.VD) {
                aVar2 = this.dFZ;
            } else if (type == AdvertAppInfo.Vu) {
                aVar2 = this.dmM;
            } else if (type == AdvertAppInfo.VE) {
                aVar2 = this.fXD;
            } else if (type == AdvertAppInfo.VF) {
                aVar2 = this.fXE;
            } else if (type == AdvertAppInfo.VG) {
                aVar2 = this.fXF;
            } else if (type == AdvertAppInfo.VH) {
                aVar2 = this.fXG;
            } else if (type != AdvertAppInfo.VI) {
                aVar2 = null;
            } else {
                aVar2 = this.fXH;
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
                if (cVar != null && cVar.getThreadType() == 3 && (cVar.KJ() instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar.KJ();
                    advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                    advertAppInfo.advertAppContext.Vp = "FRS";
                    advertAppInfo.advertAppContext.Vq = String.valueOf(z);
                    advertAppInfo.advertAppContext.pn = i;
                    advertAppInfo.advertAppContext.fid = str;
                    advertAppInfo.advertAppContext.Vr = str2;
                    advertAppInfo.advertAppContext.Vs = str3;
                    advertAppInfo.advertAppContext.Vt = str4;
                    advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                    advertAppInfo.advertAppContext.IM = false;
                }
            }
        }
    }
}
