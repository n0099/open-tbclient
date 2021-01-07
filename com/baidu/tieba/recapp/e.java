package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private p gey;
    private com.baidu.adp.widget.ListView.a khi;
    private com.baidu.adp.widget.ListView.a khj;
    private com.baidu.tieba.InjectPlugin.a.c mMG;
    private com.baidu.adp.widget.ListView.a mMK;
    private com.baidu.adp.widget.ListView.a mML;
    private com.baidu.adp.widget.ListView.a mMM;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mMG = cVar;
        if (this.mMG != null && (this.mMG.bMS() instanceof p)) {
            this.gey = (p) this.mMG.bMS();
            this.khi = new com.baidu.tieba.recapp.adapter.c(this.gey, AdvertAppInfo.eNz);
            this.khj = new com.baidu.tieba.recapp.adapter.d(this.gey, AdvertAppInfo.eNI);
            this.mMK = new com.baidu.tieba.recapp.adapter.d(this.gey, AdvertAppInfo.eNM);
            this.mML = new com.baidu.tieba.recapp.adapter.d(this.gey, AdvertAppInfo.eNN);
            this.mMM = new com.baidu.tieba.recapp.adapter.d(this.gey, AdvertAppInfo.eNO);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bU(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bMR() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.eNI.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eNz.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eNM.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eNN.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eNO.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void d(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
        int i2;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mOriginDatas)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    com.baidu.tieba.lego.card.c.a.a(arrayList, (AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int eN = com.baidu.tieba.lego.card.c.a.eN(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eN2 = com.baidu.tieba.lego.card.c.a.eN(arrayList);
            if (eN2 >= 1) {
                int i4 = eN - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < eN2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bpf = advertAppInfo.bpf();
                    if (bpf != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, bpf);
                        if (bpf != 28 && bpf != 31) {
                            advertAppInfo.eOc.eOq = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 100);
                    } else {
                        int i6 = (com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(i6))) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 29);
                        } else if (i6 < 0) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 33);
                        } else if (i6 >= eN && i4 > 3) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 2, i6, eN);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aC(advertAppInfo);
                            cVar.um(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bpg()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eNW) && com.baidu.tieba.a.bMF().bMH()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eNW) && !TextUtils.isEmpty(advertAppInfo.eNU)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i6);
                                    } else if (i6 == eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bph()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < eN) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar, i6);
                                } else if (i6 == eN) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                }
                            } else {
                                com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 21);
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
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mOriginDatas)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    com.baidu.tieba.lego.card.c.a.a(arrayList, (AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int eN = com.baidu.tieba.lego.card.c.a.eN(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eN2 = com.baidu.tieba.lego.card.c.a.eN(arrayList);
            if (eN2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.c.a.eN(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = eN - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < eN2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bpf = advertAppInfo.bpf();
                    if (bpf != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, bpf);
                        if (bpf != 28 && bpf != 31) {
                            advertAppInfo.eOc.eOq = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= eN) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.c.a.isEmpty(list2)) {
                                        int eN3 = com.baidu.tieba.lego.card.c.a.eN(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        for (int i13 = 0; i13 < eN3 && i13 < i12; i13++) {
                                            if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.c.a.l(list2, i13)).bMO() instanceof AdvertAppInfo) {
                                                z2 = false;
                                                break;
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
                        } else if (i11 > eN) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 2, i11, eN);
                        } else if (i11 < 0) {
                            i3 = 33;
                        } else {
                            i3 = 29;
                        }
                        if (i3 != 0) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, i3);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aC(advertAppInfo);
                            cVar.um(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bpg()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eNW) && com.baidu.tieba.a.bMF().bMH()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eNW) && !TextUtils.isEmpty(advertAppInfo.eNU)) {
                                    boolean DC = com.baidu.tbadk.download.b.bEC().DC(advertAppInfo.eNW);
                                    boolean DD = com.baidu.tbadk.download.b.bEC().DD(advertAppInfo.eNW);
                                    if (DC) {
                                        advertAppInfo.eNS = 1;
                                    } else if (DD) {
                                        advertAppInfo.eNS = 2;
                                    } else {
                                        advertAppInfo.eNS = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i11);
                                    } else if (i11 == eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bph()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < eN) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar, i11);
                                } else if (i11 == eN) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.eNI) {
                aVar = this.khj;
            } else if (type == AdvertAppInfo.eNz) {
                aVar = this.khi;
            } else if (type == AdvertAppInfo.eNM) {
                aVar = this.mMK;
            } else if (type == AdvertAppInfo.eNN) {
                aVar = this.mML;
            } else {
                aVar = type == AdvertAppInfo.eNO ? this.mMM : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public TypeAdapter.ViewHolder a(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.eNI) {
                aVar = this.khj;
            } else if (type == AdvertAppInfo.eNz) {
                aVar = this.khi;
            } else if (type == AdvertAppInfo.eNM) {
                aVar = this.mMK;
            } else if (type == AdvertAppInfo.eNN) {
                aVar = this.mML;
            } else {
                aVar = type == AdvertAppInfo.eNO ? this.mMM : null;
            }
            if (aVar != null) {
                return aVar.a(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.eNI) {
                aVar = this.khj;
            } else if (type == AdvertAppInfo.eNz) {
                aVar = this.khi;
            } else if (type == AdvertAppInfo.eNM) {
                aVar = this.mMK;
            } else if (type == AdvertAppInfo.eNN) {
                aVar = this.mML;
            } else if (type != AdvertAppInfo.eNO) {
                aVar = null;
            } else {
                aVar = this.mMM;
            }
            if (aVar != null) {
                aVar.a(i, viewGroup, viewHolder, obj);
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
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.n> RS = com.baidu.tieba.recapp.report.a.RS("FRS");
            HashSet hashSet = RS == null ? new HashSet() : RS;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bMO = cVar.bMO();
                    for (com.baidu.adp.widget.ListView.n nVar : hashSet) {
                        if (bMO != null && cVar.getThreadType() == 3 && (bMO instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && bMO.hashCode() == nVar.hashCode()) {
                            ((AdvertAppInfo) bMO).advertAppContext = ((AdvertAppInfo) nVar).advertAppContext;
                        }
                    }
                    if (bMO != null && cVar.getThreadType() == 3 && (bMO instanceof AdvertAppInfo) && ((AdvertAppInfo) bMO).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bMO;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.eNu = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.eNv = str2;
                        advertAppInfo.advertAppContext.eNw = str3;
                        advertAppInfo.advertAppContext.eNx = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.aay = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.c("FRS", hashSet);
        }
    }
}
