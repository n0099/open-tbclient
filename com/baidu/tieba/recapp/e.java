package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes13.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n dSS;
    private com.baidu.adp.widget.ListView.a heo;
    private com.baidu.adp.widget.ListView.a hep;
    private com.baidu.tieba.InjectPlugin.a.c jFJ;
    private com.baidu.adp.widget.ListView.a jFN;
    private com.baidu.adp.widget.ListView.a jFO;
    private com.baidu.adp.widget.ListView.a jFP;
    private com.baidu.adp.widget.ListView.a jFQ;
    private com.baidu.adp.widget.ListView.a jFR;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jFJ = cVar;
        if (this.jFJ != null && (this.jFJ.aVA() instanceof n)) {
            this.dSS = (n) this.jFJ.aVA();
            this.heo = new com.baidu.tieba.recapp.b.e(this.dSS, AdvertAppInfo.cMF);
            this.hep = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMO);
            this.jFN = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMP);
            this.jFO = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMQ);
            this.jFP = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMR);
            this.jFQ = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMS);
            this.jFR = new com.baidu.tieba.recapp.b.g(this.dSS, AdvertAppInfo.cMT);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void aS(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> aVz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMO.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMF.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMP.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMQ.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMR.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMS.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.cMT.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void d(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    advertAppInfo.page = "FRS";
                    int aAp = advertAppInfo.aAp();
                    if (aAp != 0) {
                        a(advertAppInfo, i, aAp);
                        if (aAp != 28 && aAp != 31) {
                            advertAppInfo.cNf.cNs = MessageConfig.ERROR_TASK_OUTTIME;
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
                        } else if (i6 >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.an(advertAppInfo);
                            cVar.nR(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aAq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.cMZ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.cMZ) && !TextUtils.isEmpty(advertAppInfo.cMX)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < size) {
                                        list.add(i6, cVar);
                                    } else if (i6 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aAr()) {
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < size) {
                                    list.add(i6, cVar);
                                } else if (i6 == size) {
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
        int i4;
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
            int i5 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                i5 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int size2 = arrayList.size();
            if (size2 >= 1) {
                int i6 = (arrayList.size() <= 1 || (i4 = (com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.f.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i8 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < size2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i9);
                    advertAppInfo.page = "SMART_FRS";
                    int aAp = advertAppInfo.aAp();
                    if (aAp != 0) {
                        a(advertAppInfo, i, aAp);
                        if (aAp != 28 && aAp != 31) {
                            advertAppInfo.cNf.cNs = MessageConfig.ERROR_TASK_OUTTIME;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0);
                        int i11 = (i10 + i2) - 1;
                        if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= size) {
                            if (i10 > (i8 - i6) + i7) {
                                if (z) {
                                    if (!v.isEmpty(list2)) {
                                        int size3 = list2.size();
                                        int i12 = (i6 - ((i8 - i10) + 1)) - 1;
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13;
                                            if (i14 >= size3 || i14 >= i12) {
                                                break;
                                            } else if (list2.get(i14).aVw() instanceof AdvertAppInfo) {
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
                        } else if (i11 > size) {
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
                            cVar.an(advertAppInfo);
                            cVar.nR(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aAq()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.cMZ)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.cMZ) && !TextUtils.isEmpty(advertAppInfo.cMX)) {
                                    boolean uW = com.baidu.tbadk.download.b.aOn().uW(advertAppInfo.cMZ);
                                    boolean uY = com.baidu.tbadk.download.b.aOn().uY(advertAppInfo.cMZ);
                                    if (uW) {
                                        advertAppInfo.cMV = 1;
                                    } else if (uY) {
                                        advertAppInfo.cMV = 2;
                                    } else {
                                        advertAppInfo.cMV = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < size) {
                                        list.add(i11, cVar);
                                    } else if (i11 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aAr()) {
                                hashSet.add(Integer.valueOf(i11));
                                if (i11 < size) {
                                    list.add(i11, cVar);
                                } else if (i11 == size) {
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
        com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.cNm != null) {
            advertAppInfo.cNm.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.cNf != null && advertAppInfo.cNf.cNs != 1001 && advertAppInfo.cNf.cNs != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.cMO) {
                aVar = this.hep;
            } else if (type == AdvertAppInfo.cMF) {
                aVar = this.heo;
            } else if (type == AdvertAppInfo.cMP) {
                aVar = this.jFN;
            } else if (type == AdvertAppInfo.cMQ) {
                aVar = this.jFO;
            } else if (type == AdvertAppInfo.cMR) {
                aVar = this.jFP;
            } else if (type == AdvertAppInfo.cMS) {
                aVar = this.jFQ;
            } else {
                aVar = type == AdvertAppInfo.cMT ? this.jFR : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public v.a a(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.cMO) {
                aVar = this.hep;
            } else if (type == AdvertAppInfo.cMF) {
                aVar = this.heo;
            } else if (type == AdvertAppInfo.cMP) {
                aVar = this.jFN;
            } else if (type == AdvertAppInfo.cMQ) {
                aVar = this.jFO;
            } else if (type == AdvertAppInfo.cMR) {
                aVar = this.jFP;
            } else if (type == AdvertAppInfo.cMS) {
                aVar = this.jFQ;
            } else {
                aVar = type == AdvertAppInfo.cMT ? this.jFR : null;
            }
            if (aVar != null) {
                return aVar.a(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.cMO) {
                aVar2 = this.hep;
            } else if (type == AdvertAppInfo.cMF) {
                aVar2 = this.heo;
            } else if (type == AdvertAppInfo.cMP) {
                aVar2 = this.jFN;
            } else if (type == AdvertAppInfo.cMQ) {
                aVar2 = this.jFO;
            } else if (type == AdvertAppInfo.cMR) {
                aVar2 = this.jFP;
            } else if (type == AdvertAppInfo.cMS) {
                aVar2 = this.jFQ;
            } else if (type != AdvertAppInfo.cMT) {
                aVar2 = null;
            } else {
                aVar2 = this.jFR;
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
        if (list != null && !list.isEmpty()) {
            Set<com.baidu.adp.widget.ListView.m> HZ = com.baidu.tieba.recapp.report.a.HZ("FRS");
            HashSet hashSet = HZ == null ? new HashSet() : HZ;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object aVw = cVar.aVw();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (aVw != null && cVar.getThreadType() == 3 && (aVw instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && aVw.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) aVw).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (aVw != null && cVar.getThreadType() == 3 && (aVw instanceof AdvertAppInfo) && ((AdvertAppInfo) aVw).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) aVw;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.cMA = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.cMB = str2;
                        advertAppInfo.advertAppContext.cMC = str3;
                        advertAppInfo.advertAppContext.cMD = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Dn = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
