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
/* loaded from: classes7.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private p fZO;
    private com.baidu.adp.widget.ListView.a kcC;
    private com.baidu.adp.widget.ListView.a kcD;
    private com.baidu.tieba.InjectPlugin.a.c mHX;
    private com.baidu.adp.widget.ListView.a mIb;
    private com.baidu.adp.widget.ListView.a mIc;
    private com.baidu.adp.widget.ListView.a mIe;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mHX = cVar;
        if (this.mHX != null && (this.mHX.bJa() instanceof p)) {
            this.fZO = (p) this.mHX.bJa();
            this.kcC = new com.baidu.tieba.recapp.adapter.c(this.fZO, AdvertAppInfo.eIO);
            this.kcD = new com.baidu.tieba.recapp.adapter.d(this.fZO, AdvertAppInfo.eIX);
            this.mIb = new com.baidu.tieba.recapp.adapter.d(this.fZO, AdvertAppInfo.eJb);
            this.mIc = new com.baidu.tieba.recapp.adapter.d(this.fZO, AdvertAppInfo.eJc);
            this.mIe = new com.baidu.tieba.recapp.adapter.d(this.fZO, AdvertAppInfo.eJd);
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
    public List<Integer> bIZ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.eIX.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eIO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eJb.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eJc.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.eJd.getId()));
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
                    int bll = advertAppInfo.bll();
                    if (bll != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, bll);
                        if (bll != 28 && bll != 31) {
                            advertAppInfo.eJr.eJF = -1001;
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
                            cVar.sG(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.blm()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eJl) && com.baidu.tieba.a.bIN().bIP()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eJl) && !TextUtils.isEmpty(advertAppInfo.eJj)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i6);
                                    } else if (i6 == eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bln()) {
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
                    int bll = advertAppInfo.bll();
                    if (bll != 0) {
                        com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, bll);
                        if (bll != 28 && bll != 31) {
                            advertAppInfo.eJr.eJF = -1001;
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
                                            if (((com.baidu.tieba.InjectPlugin.FrsFeedAd.c) com.baidu.tieba.lego.card.c.a.l(list2, i13)).bIW() instanceof AdvertAppInfo) {
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
                            cVar.sG(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.blm()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eJl) && com.baidu.tieba.a.bIN().bIP()) {
                                    com.baidu.tieba.recapp.report.d.a(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.eJl) && !TextUtils.isEmpty(advertAppInfo.eJj)) {
                                    boolean Cr = com.baidu.tbadk.download.b.bAI().Cr(advertAppInfo.eJl);
                                    boolean Cs = com.baidu.tbadk.download.b.bAI().Cs(advertAppInfo.eJl);
                                    if (Cr) {
                                        advertAppInfo.eJh = 1;
                                    } else if (Cs) {
                                        advertAppInfo.eJh = 2;
                                    } else {
                                        advertAppInfo.eJh = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar, i11);
                                    } else if (i11 == eN) {
                                        com.baidu.tieba.lego.card.c.a.a(list, cVar);
                                    }
                                }
                            } else if (advertAppInfo.bln()) {
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
            if (type == AdvertAppInfo.eIX) {
                aVar = this.kcD;
            } else if (type == AdvertAppInfo.eIO) {
                aVar = this.kcC;
            } else if (type == AdvertAppInfo.eJb) {
                aVar = this.mIb;
            } else if (type == AdvertAppInfo.eJc) {
                aVar = this.mIc;
            } else {
                aVar = type == AdvertAppInfo.eJd ? this.mIe : null;
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
            if (type == AdvertAppInfo.eIX) {
                aVar = this.kcD;
            } else if (type == AdvertAppInfo.eIO) {
                aVar = this.kcC;
            } else if (type == AdvertAppInfo.eJb) {
                aVar = this.mIb;
            } else if (type == AdvertAppInfo.eJc) {
                aVar = this.mIc;
            } else {
                aVar = type == AdvertAppInfo.eJd ? this.mIe : null;
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
            if (type == AdvertAppInfo.eIX) {
                aVar = this.kcD;
            } else if (type == AdvertAppInfo.eIO) {
                aVar = this.kcC;
            } else if (type == AdvertAppInfo.eJb) {
                aVar = this.mIb;
            } else if (type == AdvertAppInfo.eJc) {
                aVar = this.mIc;
            } else if (type != AdvertAppInfo.eJd) {
                aVar = null;
            } else {
                aVar = this.mIe;
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
            Set<com.baidu.adp.widget.ListView.n> QK = com.baidu.tieba.recapp.report.a.QK("FRS");
            HashSet hashSet = QK == null ? new HashSet() : QK;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bIW = cVar.bIW();
                    for (com.baidu.adp.widget.ListView.n nVar : hashSet) {
                        if (bIW != null && cVar.getThreadType() == 3 && (bIW instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && bIW.hashCode() == nVar.hashCode()) {
                            ((AdvertAppInfo) bIW).advertAppContext = ((AdvertAppInfo) nVar).advertAppContext;
                        }
                    }
                    if (bIW != null && cVar.getThreadType() == 3 && (bIW instanceof AdvertAppInfo) && ((AdvertAppInfo) bIW).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bIW;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.eIJ = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.eIK = str2;
                        advertAppInfo.advertAppContext.eIL = str3;
                        advertAppInfo.advertAppContext.eIM = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.aaw = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.c("FRS", hashSet);
        }
    }
}
