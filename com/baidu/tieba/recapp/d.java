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
    private n fHO;
    private com.baidu.adp.widget.ListView.a jzw;
    private com.baidu.adp.widget.ListView.a jzx;
    private List<Object> mOriginDatas;
    private com.baidu.tieba.InjectPlugin.a.c mmS;
    private com.baidu.adp.widget.ListView.a mmW;
    private com.baidu.adp.widget.ListView.a mmX;
    private com.baidu.adp.widget.ListView.a mmY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mmS = cVar;
        if (this.mmS != null && (this.mmS.bFh() instanceof n)) {
            this.fHO = (n) this.mmS.bFh();
            this.jzw = new com.baidu.tieba.recapp.b.e(this.fHO, AdvertAppInfo.esD);
            this.jzx = new com.baidu.tieba.recapp.b.g(this.fHO, AdvertAppInfo.esM);
            this.mmW = new com.baidu.tieba.recapp.b.g(this.fHO, AdvertAppInfo.esN);
            this.mmX = new com.baidu.tieba.recapp.b.g(this.fHO, AdvertAppInfo.esO);
            this.mmY = new com.baidu.tieba.recapp.b.g(this.fHO, AdvertAppInfo.esP);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bC(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bFg() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.esM.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.esD.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.esN.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.esO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.esP.getId()));
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
            int eu = com.baidu.tieba.lego.card.d.a.eu(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eu2 = com.baidu.tieba.lego.card.d.a.eu(arrayList);
            if (eu2 >= 1) {
                int i4 = eu - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < eu2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bhR = advertAppInfo.bhR();
                    if (bhR != 0) {
                        a(advertAppInfo, i, bhR);
                        if (bhR != 28 && bhR != 31) {
                            advertAppInfo.ete.etr = -1001;
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
                        } else if (i6 >= eu && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aA(advertAppInfo);
                            cVar.sP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bhS()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.esX)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.esX) && !TextUtils.isEmpty(advertAppInfo.esV)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < eu) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                    } else if (i6 == eu) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bhT()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < eu) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                } else if (i6 == eu) {
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
            int eu = com.baidu.tieba.lego.card.d.a.eu(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eu2 = com.baidu.tieba.lego.card.d.a.eu(arrayList);
            if (eu2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.d.a.eu(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = eu - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < eu2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bhR = advertAppInfo.bhR();
                    if (bhR != 0) {
                        a(advertAppInfo, i, bhR);
                        if (bhR != 28 && bhR != 31) {
                            advertAppInfo.ete.etr = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= eu) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.d.a.isEmpty(list2)) {
                                        int eu3 = com.baidu.tieba.lego.card.d.a.eu(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= eu3 || i14 >= i12) {
                                                break;
                                            } else if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.d.a.l(list2, i14)).bFd() instanceof AdvertAppInfo) {
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
                        } else if (i11 > eu) {
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
                            cVar.sP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bhS()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.esX)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.esX) && !TextUtils.isEmpty(advertAppInfo.esV)) {
                                    boolean Dk = com.baidu.tbadk.download.b.bwR().Dk(advertAppInfo.esX);
                                    boolean Dm = com.baidu.tbadk.download.b.bwR().Dm(advertAppInfo.esX);
                                    if (Dk) {
                                        advertAppInfo.esT = 1;
                                    } else if (Dm) {
                                        advertAppInfo.esT = 2;
                                    } else {
                                        advertAppInfo.esT = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < eu) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                    } else if (i11 == eu) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bhT()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < eu) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                } else if (i11 == eu) {
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
        com.baidu.tieba.recapp.report.d.dyN().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.etl != null) {
            advertAppInfo.etl.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.ete != null && advertAppInfo.ete.etr != 1001 && advertAppInfo.ete.etr != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.esM) {
                aVar = this.jzx;
            } else if (type == AdvertAppInfo.esD) {
                aVar = this.jzw;
            } else if (type == AdvertAppInfo.esN) {
                aVar = this.mmW;
            } else if (type == AdvertAppInfo.esO) {
                aVar = this.mmX;
            } else {
                aVar = type == AdvertAppInfo.esP ? this.mmY : null;
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
            if (type == AdvertAppInfo.esM) {
                aVar = this.jzx;
            } else if (type == AdvertAppInfo.esD) {
                aVar = this.jzw;
            } else if (type == AdvertAppInfo.esN) {
                aVar = this.mmW;
            } else if (type == AdvertAppInfo.esO) {
                aVar = this.mmX;
            } else {
                aVar = type == AdvertAppInfo.esP ? this.mmY : null;
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
            if (type == AdvertAppInfo.esM) {
                aVar2 = this.jzx;
            } else if (type == AdvertAppInfo.esD) {
                aVar2 = this.jzw;
            } else if (type == AdvertAppInfo.esN) {
                aVar2 = this.mmW;
            } else if (type == AdvertAppInfo.esO) {
                aVar2 = this.mmX;
            } else if (type != AdvertAppInfo.esP) {
                aVar2 = null;
            } else {
                aVar2 = this.mmY;
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
            Set<com.baidu.adp.widget.ListView.q> Rn = com.baidu.tieba.recapp.report.a.Rn("FRS");
            HashSet hashSet = Rn == null ? new HashSet() : Rn;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bFd = cVar.bFd();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bFd != null && cVar.getThreadType() == 3 && (bFd instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bFd.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bFd).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bFd != null && cVar.getThreadType() == 3 && (bFd instanceof AdvertAppInfo) && ((AdvertAppInfo) bFd).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bFd;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.esy = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.esz = str2;
                        advertAppInfo.advertAppContext.esA = str3;
                        advertAppInfo.advertAppContext.esB = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.YN = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
