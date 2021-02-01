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
    private p gch;
    private com.baidu.adp.widget.ListView.a kkM;
    private com.baidu.adp.widget.ListView.a kkN;
    private List<Object> mOriginDatas;
    private com.baidu.tieba.InjectPlugin.a.c mRi;
    private com.baidu.adp.widget.ListView.a mRm;
    private com.baidu.adp.widget.ListView.a mRn;
    private com.baidu.adp.widget.ListView.a mRo;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mRi = cVar;
        if (this.mRi != null && (this.mRi.bJu() instanceof p)) {
            this.gch = (p) this.mRi.bJu();
            this.kkM = new com.baidu.tieba.recapp.adapter.c(this.gch, AdvertAppInfo.eLa);
            this.kkN = new com.baidu.tieba.recapp.adapter.d(this.gch, AdvertAppInfo.eLj);
            this.mRm = new com.baidu.tieba.recapp.adapter.d(this.gch, AdvertAppInfo.eLn);
            this.mRn = new com.baidu.tieba.recapp.adapter.d(this.gch, AdvertAppInfo.eLo);
            this.mRo = new com.baidu.tieba.recapp.adapter.d(this.gch, AdvertAppInfo.eLp);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bP(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bJt() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.eLj.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eLa.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eLn.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eLo.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eLp.getId()));
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
            int eL = com.baidu.tieba.lego.card.c.a.eL(list);
            int i3 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i3;
                if (!it2.hasNext()) {
                    break;
                }
                i3 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eL2 = com.baidu.tieba.lego.card.c.a.eL(arrayList);
            if (eL2 >= 1) {
                int i4 = eL - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < eL2; i5++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, i5);
                    advertAppInfo.page = "FRS";
                    int blD = advertAppInfo.blD();
                    if (blD != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, blD);
                        if (blD != 28 && blD != 31) {
                            advertAppInfo.eLD.eLR = -1001;
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
                        } else if (i6 >= eL && i4 > 3) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 2, i6, eL);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.aC(advertAppInfo);
                            cVar.sL(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.blE()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eLx) && com.baidu.tieba.a.bJg().bJi()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eLx) && !TextUtils.isEmpty(advertAppInfo.eLv)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i6);
                                    } else if (i6 == eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.blF()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < eL) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar, i6);
                                } else if (i6 == eL) {
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
            int eL = com.baidu.tieba.lego.card.c.a.eL(list);
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eL2 = com.baidu.tieba.lego.card.c.a.eL(arrayList);
            if (eL2 >= 1) {
                int i6 = (com.baidu.tieba.lego.card.c.a.eL(arrayList) <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, 0)).adPosition, 0) - 1;
                int i8 = eL - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < eL2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, i9);
                    advertAppInfo.page = "SMART_FRS";
                    int blD = advertAppInfo.blD();
                    if (blD != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, blD);
                        if (blD != 28 && blD != 31) {
                            advertAppInfo.eLD.eLR = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= eL) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!com.baidu.tieba.lego.card.c.a.isEmpty(list2)) {
                                        int eL3 = com.baidu.tieba.lego.card.c.a.eL(list2);
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        for (int i13 = 0; i13 < eL3 && i13 < i12; i13++) {
                                            if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.c.a.l(list2, i13)).bJq() instanceof AdvertAppInfo) {
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
                                    } else if (com.baidu.tieba.a.bJg().bJj()) {
                                        i3 = 36;
                                    } else {
                                        i3 = 0;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            } else {
                                i3 = 0;
                            }
                        } else if (i11 > eL) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 2, i11, eL);
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
                            cVar.sL(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.blE()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eLx) && com.baidu.tieba.a.bJg().bJi()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eLx) && !TextUtils.isEmpty(advertAppInfo.eLv)) {
                                    boolean CI = com.baidu.tbadk.download.b.bBa().CI(advertAppInfo.eLx);
                                    boolean CJ = com.baidu.tbadk.download.b.bBa().CJ(advertAppInfo.eLx);
                                    if (CI) {
                                        advertAppInfo.eLt = 1;
                                    } else if (CJ) {
                                        advertAppInfo.eLt = 2;
                                    } else {
                                        advertAppInfo.eLt = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i11);
                                    } else if (i11 == eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.blF()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < eL) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar, i11);
                                } else if (i11 == eL) {
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
            if (type == AdvertAppInfo.eLj) {
                aVar = this.kkN;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kkM;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRm;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRn;
            } else {
                aVar = type == AdvertAppInfo.eLp ? this.mRo : null;
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
            if (type == AdvertAppInfo.eLj) {
                aVar = this.kkN;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kkM;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRm;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRn;
            } else {
                aVar = type == AdvertAppInfo.eLp ? this.mRo : null;
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
            if (type == AdvertAppInfo.eLj) {
                aVar = this.kkN;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kkM;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRm;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRn;
            } else if (type != AdvertAppInfo.eLp) {
                aVar = null;
            } else {
                aVar = this.mRo;
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
            Set<com.baidu.adp.widget.ListView.n> RE = com.baidu.tieba.recapp.report.a.RE("FRS");
            HashSet hashSet = RE == null ? new HashSet() : RE;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bJq = cVar.bJq();
                    for (com.baidu.adp.widget.ListView.n nVar : hashSet) {
                        if (bJq != null && cVar.getThreadType() == 3 && (bJq instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && bJq.hashCode() == nVar.hashCode()) {
                            ((AdvertAppInfo) bJq).advertAppContext = ((AdvertAppInfo) nVar).advertAppContext;
                        }
                    }
                    if (bJq != null && cVar.getThreadType() == 3 && (bJq instanceof AdvertAppInfo) && ((AdvertAppInfo) bJq).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bJq;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.d();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.eKV = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.eKW = str2;
                        advertAppInfo.advertAppContext.eKX = str3;
                        advertAppInfo.advertAppContext.eKY = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.aas = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.c("FRS", hashSet);
        }
    }
}
