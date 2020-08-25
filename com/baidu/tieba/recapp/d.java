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
/* loaded from: classes20.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n fki;
    private com.baidu.adp.widget.ListView.a iPl;
    private com.baidu.adp.widget.ListView.a iPm;
    private com.baidu.tieba.InjectPlugin.a.c lBY;
    private com.baidu.adp.widget.ListView.a lCc;
    private com.baidu.adp.widget.ListView.a lCd;
    private com.baidu.adp.widget.ListView.a lCe;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.lBY = cVar;
        if (this.lBY != null && (this.lBY.bzs() instanceof n)) {
            this.fki = (n) this.lBY.bzs();
            this.iPl = new com.baidu.tieba.recapp.b.e(this.fki, AdvertAppInfo.dVO);
            this.iPm = new com.baidu.tieba.recapp.b.g(this.fki, AdvertAppInfo.dVX);
            this.lCc = new com.baidu.tieba.recapp.b.g(this.fki, AdvertAppInfo.dVY);
            this.lCd = new com.baidu.tieba.recapp.b.g(this.fki, AdvertAppInfo.dVZ);
            this.lCe = new com.baidu.tieba.recapp.b.g(this.fki, AdvertAppInfo.dWa);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bl(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bzr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.dVX.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dVO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dVY.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dVZ.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dWa.getId()));
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
            int ea = com.baidu.tieba.lego.card.d.a.ea(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int ea2 = com.baidu.tieba.lego.card.d.a.ea(arrayList);
            if (ea2 >= 1) {
                int i4 = ea - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < ea2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bcv = advertAppInfo.bcv();
                    if (bcv != 0) {
                        a(advertAppInfo, i, bcv);
                        if (bcv != 28 && bcv != 31) {
                            advertAppInfo.dWo.dWB = -1001;
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
                        } else if (i6 >= ea && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.av(advertAppInfo);
                            cVar.rP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bcw()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dWi)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dWi) && !TextUtils.isEmpty(advertAppInfo.dWg)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < ea) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                    } else if (i6 == ea) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bcx()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < ea) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                } else if (i6 == ea) {
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
            int ea = com.baidu.tieba.lego.card.d.a.ea(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int ea2 = com.baidu.tieba.lego.card.d.a.ea(arrayList);
            if (ea2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.d.a.ea(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = ea - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < ea2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bcv = advertAppInfo.bcv();
                    if (bcv != 0) {
                        a(advertAppInfo, i, bcv);
                        if (bcv != 28 && bcv != 31) {
                            advertAppInfo.dWo.dWB = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= ea) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.d.a.isEmpty(list2)) {
                                        int ea3 = com.baidu.tieba.lego.card.d.a.ea(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= ea3 || i14 >= i12) {
                                                break;
                                            } else if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.d.a.l(list2, i14)).bzo() instanceof AdvertAppInfo) {
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
                        } else if (i11 > ea) {
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
                            cVar.av(advertAppInfo);
                            cVar.rP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bcw()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dWi)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dWi) && !TextUtils.isEmpty(advertAppInfo.dWg)) {
                                    boolean BI = com.baidu.tbadk.download.b.bro().BI(advertAppInfo.dWi);
                                    boolean BK = com.baidu.tbadk.download.b.bro().BK(advertAppInfo.dWi);
                                    if (BI) {
                                        advertAppInfo.dWe = 1;
                                    } else if (BK) {
                                        advertAppInfo.dWe = 2;
                                    } else {
                                        advertAppInfo.dWe = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < ea) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                    } else if (i11 == ea) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bcx()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < ea) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                } else if (i11 == ea) {
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
        com.baidu.tieba.recapp.report.d.doi().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dWv != null) {
            advertAppInfo.dWv.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.dWo != null && advertAppInfo.dWo.dWB != 1001 && advertAppInfo.dWo.dWB != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.dVX) {
                aVar = this.iPm;
            } else if (type == AdvertAppInfo.dVO) {
                aVar = this.iPl;
            } else if (type == AdvertAppInfo.dVY) {
                aVar = this.lCc;
            } else if (type == AdvertAppInfo.dVZ) {
                aVar = this.lCd;
            } else {
                aVar = type == AdvertAppInfo.dWa ? this.lCe : null;
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
            if (type == AdvertAppInfo.dVX) {
                aVar = this.iPm;
            } else if (type == AdvertAppInfo.dVO) {
                aVar = this.iPl;
            } else if (type == AdvertAppInfo.dVY) {
                aVar = this.lCc;
            } else if (type == AdvertAppInfo.dVZ) {
                aVar = this.lCd;
            } else {
                aVar = type == AdvertAppInfo.dWa ? this.lCe : null;
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
            if (type == AdvertAppInfo.dVX) {
                aVar2 = this.iPm;
            } else if (type == AdvertAppInfo.dVO) {
                aVar2 = this.iPl;
            } else if (type == AdvertAppInfo.dVY) {
                aVar2 = this.lCc;
            } else if (type == AdvertAppInfo.dVZ) {
                aVar2 = this.lCd;
            } else if (type != AdvertAppInfo.dWa) {
                aVar2 = null;
            } else {
                aVar2 = this.lCe;
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
            Set<com.baidu.adp.widget.ListView.q> PA = com.baidu.tieba.recapp.report.a.PA("FRS");
            HashSet hashSet = PA == null ? new HashSet() : PA;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bzo = cVar.bzo();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bzo != null && cVar.getThreadType() == 3 && (bzo instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bzo.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bzo).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bzo != null && cVar.getThreadType() == 3 && (bzo instanceof AdvertAppInfo) && ((AdvertAppInfo) bzo).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bzo;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.dVJ = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.dVK = str2;
                        advertAppInfo.advertAppContext.dVL = str3;
                        advertAppInfo.advertAppContext.dVM = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Yb = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
