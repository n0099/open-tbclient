package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class f implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private q gcm;
    private com.baidu.adp.widget.ListView.a kla;
    private com.baidu.adp.widget.ListView.a klb;
    private List<Object> mOriginDatas;
    private com.baidu.adp.widget.ListView.a mRC;
    private com.baidu.adp.widget.ListView.a mRD;
    private com.baidu.adp.widget.ListView.a mRE;
    private com.baidu.tieba.InjectPlugin.a.c mRy;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mRy = cVar;
        if (this.mRy != null && (this.mRy.bJz() instanceof q)) {
            this.gcm = (q) this.mRy.bJz();
            this.kla = new com.baidu.tieba.recapp.adapter.c(this.gcm, AdvertAppInfo.eLa);
            this.klb = new com.baidu.tieba.recapp.adapter.d(this.gcm, AdvertAppInfo.eLj);
            this.mRC = new com.baidu.tieba.recapp.adapter.d(this.gcm, AdvertAppInfo.eLn);
            this.mRD = new com.baidu.tieba.recapp.adapter.d(this.gcm, AdvertAppInfo.eLo);
            this.mRE = new com.baidu.tieba.recapp.adapter.d(this.gcm, AdvertAppInfo.eLp);
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
    public List<Integer> bJy() {
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
            int i2 = 0;
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                i2 = cVar.getThreadType() == 1 ? i2 + 1 : i2;
            }
            int eL2 = com.baidu.tieba.lego.card.c.a.eL(arrayList);
            if (eL2 >= 1) {
                int i3 = eL - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < eL2; i4++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) com.baidu.tieba.lego.card.c.a.l(arrayList, i4);
                    advertAppInfo.page = "FRS";
                    int blD = advertAppInfo.blD();
                    if (blD != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, blD);
                        if (blD != 28 && blD != 31) {
                            advertAppInfo.eLC.eLR = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 100);
                    } else {
                        int i5 = (com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(i5))) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 29);
                        } else if (i5 < 0) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 33);
                        } else if (i5 >= eL && i3 > 3) {
                            com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 2, i5, eL);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar2 = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar2.aC(advertAppInfo);
                            cVar2.sL(advertAppInfo.getType().getId());
                            cVar2.setThreadType(3);
                            if (advertAppInfo.blE()) {
                                if (t.Ru(advertAppInfo.eLw) && com.baidu.tieba.a.bJg().bJi()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eLw) && !TextUtils.isEmpty(advertAppInfo.eLu)) {
                                    hashSet.add(Integer.valueOf(i5));
                                    if (i5 < eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar2, i5);
                                    } else if (i5 == eL) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar2);
                                    }
                                }
                            } else if (advertAppInfo.blF()) {
                                hashSet.add(Integer.valueOf(i5));
                                if (i5 < eL) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar2, i5);
                                } else if (i5 == eL) {
                                    com.baidu.tieba.lego.card.c.a.a(list, cVar2);
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
                            advertAppInfo.eLC.eLR = -1001;
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
                                            if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.c.a.l(list2, i13)).bJv() instanceof AdvertAppInfo) {
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
                                if (t.Ru(advertAppInfo.eLw) && com.baidu.tieba.a.bJg().bJi()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eLw) && !TextUtils.isEmpty(advertAppInfo.eLu)) {
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
                aVar = this.klb;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kla;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRC;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRD;
            } else {
                aVar = type == AdvertAppInfo.eLp ? this.mRE : null;
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
                aVar = this.klb;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kla;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRC;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRD;
            } else {
                aVar = type == AdvertAppInfo.eLp ? this.mRE : null;
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
                aVar = this.klb;
            } else if (type == AdvertAppInfo.eLa) {
                aVar = this.kla;
            } else if (type == AdvertAppInfo.eLn) {
                aVar = this.mRC;
            } else if (type == AdvertAppInfo.eLo) {
                aVar = this.mRD;
            } else if (type != AdvertAppInfo.eLp) {
                aVar = null;
            } else {
                aVar = this.mRE;
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
            Set<com.baidu.adp.widget.ListView.n> RQ = com.baidu.tieba.recapp.report.a.RQ("FRS");
            HashSet hashSet = RQ == null ? new HashSet() : RQ;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bJv = cVar.bJv();
                    for (com.baidu.adp.widget.ListView.n nVar : hashSet) {
                        if (bJv != null && cVar.getThreadType() == 3 && (bJv instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && bJv.hashCode() == nVar.hashCode()) {
                            ((AdvertAppInfo) bJv).advertAppContext = ((AdvertAppInfo) nVar).advertAppContext;
                        }
                    }
                    if (bJv != null && cVar.getThreadType() == 3 && (bJv instanceof AdvertAppInfo) && ((AdvertAppInfo) bJv).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bJv;
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
