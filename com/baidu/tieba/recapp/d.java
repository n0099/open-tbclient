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
    private o fNh;
    private com.baidu.adp.widget.ListView.a jGs;
    private com.baidu.adp.widget.ListView.a jGt;
    private List<Object> mOriginDatas;
    private com.baidu.tieba.InjectPlugin.a.c mti;
    private com.baidu.adp.widget.ListView.a mtm;
    private com.baidu.adp.widget.ListView.a mtn;
    private com.baidu.adp.widget.ListView.a mto;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mti = cVar;
        if (this.mti != null && (this.mti.bGZ() instanceof o)) {
            this.fNh = (o) this.mti.bGZ();
            this.jGs = new com.baidu.tieba.recapp.b.e(this.fNh, AdvertAppInfo.ewL);
            this.jGt = new com.baidu.tieba.recapp.b.g(this.fNh, AdvertAppInfo.ewU);
            this.mtm = new com.baidu.tieba.recapp.b.g(this.fNh, AdvertAppInfo.ewV);
            this.mtn = new com.baidu.tieba.recapp.b.g(this.fNh, AdvertAppInfo.ewW);
            this.mto = new com.baidu.tieba.recapp.b.g(this.fNh, AdvertAppInfo.ewX);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bJ(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bGY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.ewU.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ewL.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ewV.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ewW.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.ewX.getId()));
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
            int eC = com.baidu.tieba.lego.card.d.a.eC(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eC2 = com.baidu.tieba.lego.card.d.a.eC(arrayList);
            if (eC2 >= 1) {
                int i4 = eC - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < eC2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int bjt = advertAppInfo.bjt();
                    if (bjt != 0) {
                        a(advertAppInfo, i, bjt);
                        if (bjt != 28 && bjt != 31) {
                            advertAppInfo.exl.exz = -1001;
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
                        } else if (i6 >= eC && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aA(advertAppInfo);
                            cVar.tx(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bju()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.exf)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.exf) && !TextUtils.isEmpty(advertAppInfo.exd)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < eC) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                    } else if (i6 == eC) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bjv()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < eC) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i6);
                                } else if (i6 == eC) {
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
            int eC = com.baidu.tieba.lego.card.d.a.eC(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eC2 = com.baidu.tieba.lego.card.d.a.eC(arrayList);
            if (eC2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.d.a.eC(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = eC - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < eC2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.d.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int bjt = advertAppInfo.bjt();
                    if (bjt != 0) {
                        a(advertAppInfo, i, bjt);
                        if (bjt != 28 && bjt != 31) {
                            advertAppInfo.exl.exz = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= eC) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.d.a.isEmpty(list2)) {
                                        int eC3 = com.baidu.tieba.lego.card.d.a.eC(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= eC3 || i14 >= i12) {
                                                break;
                                            } else if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.d.a.l(list2, i14)).bGV() instanceof AdvertAppInfo) {
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
                        } else if (i11 > eC) {
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
                            cVar.tx(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.bju()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.exf)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.exf) && !TextUtils.isEmpty(advertAppInfo.exd)) {
                                    boolean CX = com.baidu.tbadk.download.b.byG().CX(advertAppInfo.exf);
                                    boolean CZ = com.baidu.tbadk.download.b.byG().CZ(advertAppInfo.exf);
                                    if (CX) {
                                        advertAppInfo.exb = 1;
                                    } else if (CZ) {
                                        advertAppInfo.exb = 2;
                                    } else {
                                        advertAppInfo.exb = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < eC) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                    } else if (i11 == eC) {
                                        com.baidu.tieba.lego.card.d.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bjv()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < eC) {
                                    com.baidu.tieba.lego.card.d.a.a(list, cVar, i11);
                                } else if (i11 == eC) {
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
        com.baidu.tieba.recapp.report.d.dAT().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.exs != null) {
            advertAppInfo.exs.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.exl != null && advertAppInfo.exl.exz != 1001 && advertAppInfo.exl.exz != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.ewU) {
                aVar = this.jGt;
            } else if (type == AdvertAppInfo.ewL) {
                aVar = this.jGs;
            } else if (type == AdvertAppInfo.ewV) {
                aVar = this.mtm;
            } else if (type == AdvertAppInfo.ewW) {
                aVar = this.mtn;
            } else {
                aVar = type == AdvertAppInfo.ewX ? this.mto : null;
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
            if (type == AdvertAppInfo.ewU) {
                aVar = this.jGt;
            } else if (type == AdvertAppInfo.ewL) {
                aVar = this.jGs;
            } else if (type == AdvertAppInfo.ewV) {
                aVar = this.mtm;
            } else if (type == AdvertAppInfo.ewW) {
                aVar = this.mtn;
            } else {
                aVar = type == AdvertAppInfo.ewX ? this.mto : null;
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
            if (type == AdvertAppInfo.ewU) {
                aVar2 = this.jGt;
            } else if (type == AdvertAppInfo.ewL) {
                aVar2 = this.jGs;
            } else if (type == AdvertAppInfo.ewV) {
                aVar2 = this.mtm;
            } else if (type == AdvertAppInfo.ewW) {
                aVar2 = this.mtn;
            } else if (type != AdvertAppInfo.ewX) {
                aVar2 = null;
            } else {
                aVar2 = this.mto;
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
            Set<com.baidu.adp.widget.ListView.q> Rc = com.baidu.tieba.recapp.report.a.Rc("FRS");
            HashSet hashSet = Rc == null ? new HashSet() : Rc;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bGV = cVar.bGV();
                    for (com.baidu.adp.widget.ListView.q qVar : hashSet) {
                        if (bGV != null && cVar.getThreadType() == 3 && (bGV instanceof AdvertAppInfo) && qVar != null && (qVar instanceof AdvertAppInfo) && bGV.hashCode() == qVar.hashCode()) {
                            ((AdvertAppInfo) bGV).advertAppContext = ((AdvertAppInfo) qVar).advertAppContext;
                        }
                    }
                    if (bGV != null && cVar.getThreadType() == 3 && (bGV instanceof AdvertAppInfo) && ((AdvertAppInfo) bGV).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bGV;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.ewG = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.ewH = str2;
                        advertAppInfo.advertAppContext.ewI = str3;
                        advertAppInfo.advertAppContext.ewJ = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.YS = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
