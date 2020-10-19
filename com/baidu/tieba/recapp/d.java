package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes26.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n fzt;
    private com.baidu.adp.widget.ListView.a jmW;
    private com.baidu.adp.widget.ListView.a jmX;
    private List<Object> mOriginDatas;
    private com.baidu.adp.widget.ListView.a maA;
    private com.baidu.tieba.InjectPlugin.a.c mat;
    private com.baidu.adp.widget.ListView.a may;
    private com.baidu.adp.widget.ListView.a maz;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mat = cVar;
        if (this.mat != null && (this.mat.bDo() instanceof n)) {
            this.fzt = (n) this.mat.bDo();
            this.jmW = new com.baidu.tieba.recapp.b.e(this.fzt, AdvertAppInfo.eke);
            this.jmX = new com.baidu.tieba.recapp.b.g(this.fzt, AdvertAppInfo.ekn);
            this.may = new com.baidu.tieba.recapp.b.g(this.fzt, AdvertAppInfo.eko);
            this.maz = new com.baidu.tieba.recapp.b.g(this.fzt, AdvertAppInfo.ekp);
            this.maA = new com.baidu.tieba.recapp.b.g(this.fzt, AdvertAppInfo.ekq);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bt(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bDn() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.ekn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eke.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eko.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ekp.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ekq.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void d(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
        int i2;
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(this.mOriginDatas)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    com.baidu.tieba.lego.card.d.a.a(arrayList, (AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int el = com.baidu.tieba.lego.card.d.a.el(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int el2 = com.baidu.tieba.lego.card.d.a.el(arrayList);
            if (el2 >= 1) {
                int i4 = el - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < el2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bfY = advertAppInfo.bfY();
                    if (bfY != 0) {
                        a(advertAppInfo, i, bfY);
                        if (bfY != 28 && bfY != 31) {
                            advertAppInfo.ekE.ekR = -1001;
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
                        } else if (i6 >= el && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aA(advertAppInfo);
                            cVar.sE(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bfZ()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eky)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eky) && !TextUtils.isEmpty(advertAppInfo.ekw)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < el) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                    } else if (i6 == el) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bga()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < el) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                } else if (i6 == el) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar);
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
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(this.mOriginDatas)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.mOriginDatas) {
                if (obj instanceof AdvertAppInfo) {
                    com.baidu.tieba.lego.card.d.a.a(arrayList, (AdvertAppInfo) obj);
                }
            }
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 3) {
                    it.remove();
                }
            }
            int el = com.baidu.tieba.lego.card.d.a.el(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int el2 = com.baidu.tieba.lego.card.d.a.el(arrayList);
            if (el2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.d.a.el(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = el - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < el2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bfY = advertAppInfo.bfY();
                    if (bfY != 0) {
                        a(advertAppInfo, i, bfY);
                        if (bfY != 28 && bfY != 31) {
                            advertAppInfo.ekE.ekR = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= el) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.d.a.isEmpty(list2)) {
                                        int el3 = com.baidu.tieba.lego.card.d.a.el(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= el3 || i14 >= i12) {
                                                break;
                                            } else if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.d.a.l(list2, i14)).bDk() instanceof AdvertAppInfo) {
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
                        } else if (i11 > el) {
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
                            cVar.aA(advertAppInfo);
                            cVar.sE(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bfZ()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eky)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eky) && !TextUtils.isEmpty(advertAppInfo.ekw)) {
                                    boolean CR = com.baidu.tbadk.download.b.buY().CR(advertAppInfo.eky);
                                    boolean CT = com.baidu.tbadk.download.b.buY().CT(advertAppInfo.eky);
                                    if (CR) {
                                        advertAppInfo.eku = 1;
                                    } else if (CT) {
                                        advertAppInfo.eku = 2;
                                    } else {
                                        advertAppInfo.eku = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < el) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                    } else if (i11 == el) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bga()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < el) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                } else if (i11 == el) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        com.baidu.tieba.recapp.report.d.dvG().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.ekL != null) {
            advertAppInfo.ekL.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.ekE != null && advertAppInfo.ekE.ekR != 1001 && advertAppInfo.ekE.ekR != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.ekn) {
                aVar = this.jmX;
            } else if (type == AdvertAppInfo.eke) {
                aVar = this.jmW;
            } else if (type == AdvertAppInfo.eko) {
                aVar = this.may;
            } else if (type == AdvertAppInfo.ekp) {
                aVar = this.maz;
            } else {
                aVar = type == AdvertAppInfo.ekq ? this.maA : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public af.a a(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.ekn) {
                aVar = this.jmX;
            } else if (type == AdvertAppInfo.eke) {
                aVar = this.jmW;
            } else if (type == AdvertAppInfo.eko) {
                aVar = this.may;
            } else if (type == AdvertAppInfo.ekp) {
                aVar = this.maz;
            } else {
                aVar = type == AdvertAppInfo.ekq ? this.maA : null;
            }
            if (aVar != null) {
                return aVar.a(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(int i, ViewGroup viewGroup, af.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.ekn) {
                aVar2 = this.jmX;
            } else if (type == AdvertAppInfo.eke) {
                aVar2 = this.jmW;
            } else if (type == AdvertAppInfo.eko) {
                aVar2 = this.may;
            } else if (type == AdvertAppInfo.ekp) {
                aVar2 = this.maz;
            } else if (type != AdvertAppInfo.ekq) {
                aVar2 = null;
            } else {
                aVar2 = this.maA;
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
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(list)) {
            Set<com.baidu.adp.widget.ListView.q> QP = com.baidu.tieba.recapp.report.a.QP("FRS");
            HashSet hashSet = QP == null ? new HashSet() : QP;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bDk = cVar.bDk();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bDk != null && cVar.getThreadType() == 3 && (bDk instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bDk.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bDk).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bDk != null && cVar.getThreadType() == 3 && (bDk instanceof AdvertAppInfo) && ((AdvertAppInfo) bDk).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bDk;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.ejZ = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.eka = str2;
                        advertAppInfo.advertAppContext.ekb = str3;
                        advertAppInfo.advertAppContext.ekc = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.YM = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
