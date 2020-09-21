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
/* loaded from: classes25.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n fnf;
    private com.baidu.adp.widget.ListView.a iXX;
    private com.baidu.adp.widget.ListView.a iXY;
    private com.baidu.tieba.InjectPlugin.a.c lLd;
    private com.baidu.adp.widget.ListView.a lLh;
    private com.baidu.adp.widget.ListView.a lLi;
    private com.baidu.adp.widget.ListView.a lLj;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.lLd = cVar;
        if (this.lLd != null && (this.lLd.bAC() instanceof n)) {
            this.fnf = (n) this.lLd.bAC();
            this.iXX = new com.baidu.tieba.recapp.b.e(this.fnf, AdvertAppInfo.dYc);
            this.iXY = new com.baidu.tieba.recapp.b.g(this.fnf, AdvertAppInfo.dYl);
            this.lLh = new com.baidu.tieba.recapp.b.g(this.fnf, AdvertAppInfo.dYm);
            this.lLi = new com.baidu.tieba.recapp.b.g(this.fnf, AdvertAppInfo.dYn);
            this.lLj = new com.baidu.tieba.recapp.b.g(this.fnf, AdvertAppInfo.dYo);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bq(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bAB() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.dYl.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dYc.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dYm.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dYn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dYo.getId()));
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
            int ei = com.baidu.tieba.lego.card.d.a.ei(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int ei2 = com.baidu.tieba.lego.card.d.a.ei(arrayList);
            if (ei2 >= 1) {
                int i4 = ei - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < ei2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bdp = advertAppInfo.bdp();
                    if (bdp != 0) {
                        a(advertAppInfo, i, bdp);
                        if (bdp != 28 && bdp != 31) {
                            advertAppInfo.dYC.dYP = -1001;
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
                        } else if (i6 >= ei && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.ax(advertAppInfo);
                            cVar.sg(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bdq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dYw)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dYw) && !TextUtils.isEmpty(advertAppInfo.dYu)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < ei) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                    } else if (i6 == ei) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bdr()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < ei) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                } else if (i6 == ei) {
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
            int ei = com.baidu.tieba.lego.card.d.a.ei(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int ei2 = com.baidu.tieba.lego.card.d.a.ei(arrayList);
            if (ei2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.d.a.ei(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = ei - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < ei2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bdp = advertAppInfo.bdp();
                    if (bdp != 0) {
                        a(advertAppInfo, i, bdp);
                        if (bdp != 28 && bdp != 31) {
                            advertAppInfo.dYC.dYP = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= ei) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.d.a.isEmpty(list2)) {
                                        int ei3 = com.baidu.tieba.lego.card.d.a.ei(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= ei3 || i14 >= i12) {
                                                break;
                                            } else if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.d.a.l(list2, i14)).bAy() instanceof AdvertAppInfo) {
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
                        } else if (i11 > ei) {
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
                            cVar.ax(advertAppInfo);
                            cVar.sg(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bdq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dYw)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dYw) && !TextUtils.isEmpty(advertAppInfo.dYu)) {
                                    boolean Cf = com.baidu.tbadk.download.b.bso().Cf(advertAppInfo.dYw);
                                    boolean Ch = com.baidu.tbadk.download.b.bso().Ch(advertAppInfo.dYw);
                                    if (Cf) {
                                        advertAppInfo.dYs = 1;
                                    } else if (Ch) {
                                        advertAppInfo.dYs = 2;
                                    } else {
                                        advertAppInfo.dYs = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < ei) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                    } else if (i11 == ei) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bdr()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < ei) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                } else if (i11 == ei) {
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
        com.baidu.tieba.recapp.report.d.drV().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dYJ != null) {
            advertAppInfo.dYJ.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.dYC != null && advertAppInfo.dYC.dYP != 1001 && advertAppInfo.dYC.dYP != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.dYl) {
                aVar = this.iXY;
            } else if (type == AdvertAppInfo.dYc) {
                aVar = this.iXX;
            } else if (type == AdvertAppInfo.dYm) {
                aVar = this.lLh;
            } else if (type == AdvertAppInfo.dYn) {
                aVar = this.lLi;
            } else {
                aVar = type == AdvertAppInfo.dYo ? this.lLj : null;
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
            if (type == AdvertAppInfo.dYl) {
                aVar = this.iXY;
            } else if (type == AdvertAppInfo.dYc) {
                aVar = this.iXX;
            } else if (type == AdvertAppInfo.dYm) {
                aVar = this.lLh;
            } else if (type == AdvertAppInfo.dYn) {
                aVar = this.lLi;
            } else {
                aVar = type == AdvertAppInfo.dYo ? this.lLj : null;
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
            if (type == AdvertAppInfo.dYl) {
                aVar2 = this.iXY;
            } else if (type == AdvertAppInfo.dYc) {
                aVar2 = this.iXX;
            } else if (type == AdvertAppInfo.dYm) {
                aVar2 = this.lLh;
            } else if (type == AdvertAppInfo.dYn) {
                aVar2 = this.lLi;
            } else if (type != AdvertAppInfo.dYo) {
                aVar2 = null;
            } else {
                aVar2 = this.lLj;
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
            Set<com.baidu.adp.widget.ListView.q> Qb = com.baidu.tieba.recapp.report.a.Qb("FRS");
            HashSet hashSet = Qb == null ? new HashSet() : Qb;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bAy = cVar.bAy();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bAy != null && cVar.getThreadType() == 3 && (bAy instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bAy.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bAy).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bAy != null && cVar.getThreadType() == 3 && (bAy instanceof AdvertAppInfo) && ((AdvertAppInfo) bAy).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bAy;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.dXX = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.dXY = str2;
                        advertAppInfo.advertAppContext.dXZ = str3;
                        advertAppInfo.advertAppContext.dYa = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Yw = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
