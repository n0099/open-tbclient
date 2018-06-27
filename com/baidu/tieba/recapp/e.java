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
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n bgM;
    private com.baidu.adp.widget.ListView.a dUT;
    private com.baidu.adp.widget.ListView.a dzo;
    private com.baidu.tieba.InjectPlugin.a.c gmJ;
    private com.baidu.adp.widget.ListView.a gmN;
    private com.baidu.adp.widget.ListView.a gmO;
    private com.baidu.adp.widget.ListView.a gmP;
    private com.baidu.adp.widget.ListView.a gmQ;
    private com.baidu.adp.widget.ListView.a gmR;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gmJ = cVar;
        if (this.gmJ != null && (this.gmJ.OF() instanceof n)) {
            this.bgM = (n) this.gmJ.OF();
            this.dzo = new com.baidu.tieba.recapp.b.e(this.bgM, AdvertAppInfo.adJ);
            this.dUT = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adS);
            this.gmN = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adT);
            this.gmO = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adU);
            this.gmP = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adV);
            this.gmQ = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adW);
            this.gmR = new com.baidu.tieba.recapp.b.g(this.bgM, AdvertAppInfo.adX);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void R(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> OE() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.adS.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adJ.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adT.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adU.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adV.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adW.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.adX.getId()));
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
                    advertAppInfo.adE = "FRS";
                    int tT = advertAppInfo.tT();
                    if (tT != 0) {
                        a(advertAppInfo, i, tT);
                        if (tT != 28 && tT != 31) {
                            advertAppInfo.aem.aez = -1001;
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
                            cVar.gc(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.tU()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.aef)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.aef) && !TextUtils.isEmpty(advertAppInfo.aeb)) {
                                    hashSet.add(Integer.valueOf(g));
                                    if (g < size) {
                                        list.add(g, cVar);
                                    } else if (g == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.tV()) {
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
                    advertAppInfo.adE = "SMART_FRS";
                    int tT = advertAppInfo.tT();
                    if (tT != 0) {
                        a(advertAppInfo, i, tT);
                        if (tT != 28 && tT != 31) {
                            advertAppInfo.aem.aez = -1001;
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
                                    if (!w.A(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - g3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).OB() instanceof AdvertAppInfo) {
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
                            cVar.gc(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.tU()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.aef)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.aef) && !TextUtils.isEmpty(advertAppInfo.aeb)) {
                                    boolean gw = com.baidu.tbadk.download.b.Ho().gw(advertAppInfo.aef);
                                    boolean gy = com.baidu.tbadk.download.b.Ho().gy(advertAppInfo.aef);
                                    if (gw) {
                                        advertAppInfo.adZ = 1;
                                    } else if (gy) {
                                        advertAppInfo.adZ = 2;
                                    } else {
                                        advertAppInfo.adZ = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.tV()) {
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
        com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.aet != null) {
            advertAppInfo.aet.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.aem != null && advertAppInfo.aem.aez != 1001 && advertAppInfo.aem.aez != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.adS) {
                aVar = this.dUT;
            } else if (type == AdvertAppInfo.adJ) {
                aVar = this.dzo;
            } else if (type == AdvertAppInfo.adT) {
                aVar = this.gmN;
            } else if (type == AdvertAppInfo.adU) {
                aVar = this.gmO;
            } else if (type == AdvertAppInfo.adV) {
                aVar = this.gmP;
            } else if (type == AdvertAppInfo.adW) {
                aVar = this.gmQ;
            } else {
                aVar = type == AdvertAppInfo.adX ? this.gmR : null;
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
            if (type == AdvertAppInfo.adS) {
                aVar = this.dUT;
            } else if (type == AdvertAppInfo.adJ) {
                aVar = this.dzo;
            } else if (type == AdvertAppInfo.adT) {
                aVar = this.gmN;
            } else if (type == AdvertAppInfo.adU) {
                aVar = this.gmO;
            } else if (type == AdvertAppInfo.adV) {
                aVar = this.gmP;
            } else if (type == AdvertAppInfo.adW) {
                aVar = this.gmQ;
            } else {
                aVar = type == AdvertAppInfo.adX ? this.gmR : null;
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
            if (type == AdvertAppInfo.adS) {
                aVar2 = this.dUT;
            } else if (type == AdvertAppInfo.adJ) {
                aVar2 = this.dzo;
            } else if (type == AdvertAppInfo.adT) {
                aVar2 = this.gmN;
            } else if (type == AdvertAppInfo.adU) {
                aVar2 = this.gmO;
            } else if (type == AdvertAppInfo.adV) {
                aVar2 = this.gmP;
            } else if (type == AdvertAppInfo.adW) {
                aVar2 = this.gmQ;
            } else if (type != AdvertAppInfo.adX) {
                aVar2 = null;
            } else {
                aVar2 = this.gmR;
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
                if (cVar != null && cVar.getThreadType() == 3 && (cVar.OB() instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar.OB();
                    advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                    advertAppInfo.advertAppContext.adE = "FRS";
                    advertAppInfo.advertAppContext.adF = String.valueOf(z);
                    advertAppInfo.advertAppContext.pn = i;
                    advertAppInfo.advertAppContext.fid = str;
                    advertAppInfo.advertAppContext.adG = str2;
                    advertAppInfo.advertAppContext.adH = str3;
                    advertAppInfo.advertAppContext.adI = str4;
                    advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                    advertAppInfo.advertAppContext.Pb = false;
                }
            }
        }
    }
}
