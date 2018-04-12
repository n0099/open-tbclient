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
    private n aXq;
    private com.baidu.adp.widget.ListView.a dEW;
    private com.baidu.adp.widget.ListView.a dlI;
    private com.baidu.adp.widget.ListView.a fWA;
    private com.baidu.adp.widget.ListView.a fWB;
    private com.baidu.adp.widget.ListView.a fWC;
    private com.baidu.adp.widget.ListView.a fWD;
    private com.baidu.adp.widget.ListView.a fWE;
    private com.baidu.tieba.InjectPlugin.a.c fWw;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void G(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.fWw = cVar;
        if (this.fWw != null && (this.fWw.KP() instanceof n)) {
            this.aXq = (n) this.fWw.KP();
            this.dlI = new com.baidu.tieba.recapp.b.e(this.aXq, AdvertAppInfo.Vy);
            this.dEW = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VH);
            this.fWA = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VI);
            this.fWB = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VJ);
            this.fWC = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VK);
            this.fWD = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VL);
            this.fWE = new com.baidu.tieba.recapp.b.g(this.aXq, AdvertAppInfo.VM);
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
    public List<Integer> KO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.VH.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.Vy.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VI.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VJ.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VK.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VL.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.VM.getId()));
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
                    advertAppInfo.Vt = "FRS";
                    int qs = advertAppInfo.qs();
                    if (qs != 0) {
                        a(advertAppInfo, i, qs);
                        if (qs != 28 && qs != 31) {
                            advertAppInfo.Wb.Wn = -1001;
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
                            if (advertAppInfo.qt()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.VU)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.VU) && !TextUtils.isEmpty(advertAppInfo.VQ)) {
                                    hashSet.add(Integer.valueOf(g));
                                    if (g < size) {
                                        list.add(g, cVar);
                                    } else if (g == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.qu()) {
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
                    advertAppInfo.Vt = "SMART_FRS";
                    int qs = advertAppInfo.qs();
                    if (qs != 0) {
                        a(advertAppInfo, i, qs);
                        if (qs != 28 && qs != 31) {
                            advertAppInfo.Wb.Wn = -1001;
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
                                            } else if (list2.get(i11).KL() instanceof AdvertAppInfo) {
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
                            if (advertAppInfo.qt()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.VU)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.VU) && !TextUtils.isEmpty(advertAppInfo.VQ)) {
                                    boolean fT = com.baidu.tbadk.download.b.Dv().fT(advertAppInfo.VU);
                                    boolean fV = com.baidu.tbadk.download.b.Dv().fV(advertAppInfo.VU);
                                    if (fT) {
                                        advertAppInfo.VO = 1;
                                    } else if (fV) {
                                        advertAppInfo.VO = 2;
                                    } else {
                                        advertAppInfo.VO = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.qu()) {
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
        com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.Wh != null) {
            advertAppInfo.Wh.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Wn != 1001 && advertAppInfo.Wb.Wn != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.VH) {
                aVar = this.dEW;
            } else if (type == AdvertAppInfo.Vy) {
                aVar = this.dlI;
            } else if (type == AdvertAppInfo.VI) {
                aVar = this.fWA;
            } else if (type == AdvertAppInfo.VJ) {
                aVar = this.fWB;
            } else if (type == AdvertAppInfo.VK) {
                aVar = this.fWC;
            } else if (type == AdvertAppInfo.VL) {
                aVar = this.fWD;
            } else {
                aVar = type == AdvertAppInfo.VM ? this.fWE : null;
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
            if (type == AdvertAppInfo.VH) {
                aVar = this.dEW;
            } else if (type == AdvertAppInfo.Vy) {
                aVar = this.dlI;
            } else if (type == AdvertAppInfo.VI) {
                aVar = this.fWA;
            } else if (type == AdvertAppInfo.VJ) {
                aVar = this.fWB;
            } else if (type == AdvertAppInfo.VK) {
                aVar = this.fWC;
            } else if (type == AdvertAppInfo.VL) {
                aVar = this.fWD;
            } else {
                aVar = type == AdvertAppInfo.VM ? this.fWE : null;
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
            if (type == AdvertAppInfo.VH) {
                aVar2 = this.dEW;
            } else if (type == AdvertAppInfo.Vy) {
                aVar2 = this.dlI;
            } else if (type == AdvertAppInfo.VI) {
                aVar2 = this.fWA;
            } else if (type == AdvertAppInfo.VJ) {
                aVar2 = this.fWB;
            } else if (type == AdvertAppInfo.VK) {
                aVar2 = this.fWC;
            } else if (type == AdvertAppInfo.VL) {
                aVar2 = this.fWD;
            } else if (type != AdvertAppInfo.VM) {
                aVar2 = null;
            } else {
                aVar2 = this.fWE;
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
                if (cVar != null && cVar.getThreadType() == 3 && (cVar.KL() instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar.KL();
                    advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                    advertAppInfo.advertAppContext.Vt = "FRS";
                    advertAppInfo.advertAppContext.Vu = String.valueOf(z);
                    advertAppInfo.advertAppContext.pn = i;
                    advertAppInfo.advertAppContext.fid = str;
                    advertAppInfo.advertAppContext.Vv = str2;
                    advertAppInfo.advertAppContext.Vw = str3;
                    advertAppInfo.advertAppContext.Vx = str4;
                    advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                    advertAppInfo.advertAppContext.IR = false;
                }
            }
        }
    }
}
