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
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private n dbz;
    private com.baidu.adp.widget.ListView.a gmb;
    private com.baidu.adp.widget.ListView.a gmc;
    private com.baidu.tieba.InjectPlugin.a.c iHI;
    private com.baidu.adp.widget.ListView.a iHM;
    private com.baidu.adp.widget.ListView.a iHN;
    private com.baidu.adp.widget.ListView.a iHO;
    private com.baidu.adp.widget.ListView.a iHP;
    private com.baidu.adp.widget.ListView.a iHQ;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iHI = cVar;
        if (this.iHI != null && (this.iHI.aBb() instanceof n)) {
            this.dbz = (n) this.iHI.aBb();
            this.gmb = new com.baidu.tieba.recapp.b.e(this.dbz, AdvertAppInfo.bWT);
            this.gmc = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXc);
            this.iHM = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXd);
            this.iHN = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXe);
            this.iHO = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXf);
            this.iHP = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXg);
            this.iHQ = new com.baidu.tieba.recapp.b.g(this.dbz, AdvertAppInfo.bXh);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void aM(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> aBa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXc.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bWT.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXd.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXe.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXf.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXg.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bXh.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void c(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int agR = advertAppInfo.agR();
                    if (agR != 0) {
                        a(advertAppInfo, i, agR);
                        if (agR != 28 && agR != 31) {
                            advertAppInfo.bXu.bXH = MessageConfig.ERROR_TASK_OUTTIME;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i6 = (com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(i6))) {
                            b(advertAppInfo, i, 29);
                        } else if (i6 < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (i6 >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.af(advertAppInfo);
                            cVar.ln(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.agS()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bXo)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bXo) && !TextUtils.isEmpty(advertAppInfo.bXl)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < size) {
                                        list.add(i6, cVar);
                                    } else if (i6 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.agT()) {
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
                int i6 = (arrayList.size() <= 1 || (i4 = (com.baidu.adp.lib.g.b.toInt(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : i4;
                int i7 = com.baidu.adp.lib.g.b.toInt(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i8 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i9 = 0; i9 < size2; i9++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i9);
                    advertAppInfo.page = "SMART_FRS";
                    int agR = advertAppInfo.agR();
                    if (agR != 0) {
                        a(advertAppInfo, i, agR);
                        if (agR != 28 && agR != 31) {
                            advertAppInfo.bXu.bXH = MessageConfig.ERROR_TASK_OUTTIME;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int i10 = com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, 0);
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
                                            } else if (list2.get(i14).aAX() instanceof AdvertAppInfo) {
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
                            cVar.af(advertAppInfo);
                            cVar.ln(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.agS()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bXo)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bXo) && !TextUtils.isEmpty(advertAppInfo.bXl)) {
                                    boolean pu = com.baidu.tbadk.download.b.atT().pu(advertAppInfo.bXo);
                                    boolean pw = com.baidu.tbadk.download.b.atT().pw(advertAppInfo.bXo);
                                    if (pu) {
                                        advertAppInfo.bXj = 1;
                                    } else if (pw) {
                                        advertAppInfo.bXj = 2;
                                    } else {
                                        advertAppInfo.bXj = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < size) {
                                        list.add(i11, cVar);
                                    } else if (i11 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.agT()) {
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
        com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.bXB != null) {
            advertAppInfo.bXB.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.bXu != null && advertAppInfo.bXu.bXH != 1001 && advertAppInfo.bXu.bXH != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.bXc) {
                aVar = this.gmc;
            } else if (type == AdvertAppInfo.bWT) {
                aVar = this.gmb;
            } else if (type == AdvertAppInfo.bXd) {
                aVar = this.iHM;
            } else if (type == AdvertAppInfo.bXe) {
                aVar = this.iHN;
            } else if (type == AdvertAppInfo.bXf) {
                aVar = this.iHO;
            } else if (type == AdvertAppInfo.bXg) {
                aVar = this.iHP;
            } else {
                aVar = type == AdvertAppInfo.bXh ? this.iHQ : null;
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
            if (type == AdvertAppInfo.bXc) {
                aVar = this.gmc;
            } else if (type == AdvertAppInfo.bWT) {
                aVar = this.gmb;
            } else if (type == AdvertAppInfo.bXd) {
                aVar = this.iHM;
            } else if (type == AdvertAppInfo.bXe) {
                aVar = this.iHN;
            } else if (type == AdvertAppInfo.bXf) {
                aVar = this.iHO;
            } else if (type == AdvertAppInfo.bXg) {
                aVar = this.iHP;
            } else {
                aVar = type == AdvertAppInfo.bXh ? this.iHQ : null;
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
            if (type == AdvertAppInfo.bXc) {
                aVar2 = this.gmc;
            } else if (type == AdvertAppInfo.bWT) {
                aVar2 = this.gmb;
            } else if (type == AdvertAppInfo.bXd) {
                aVar2 = this.iHM;
            } else if (type == AdvertAppInfo.bXe) {
                aVar2 = this.iHN;
            } else if (type == AdvertAppInfo.bXf) {
                aVar2 = this.iHO;
            } else if (type == AdvertAppInfo.bXg) {
                aVar2 = this.iHP;
            } else if (type != AdvertAppInfo.bXh) {
                aVar2 = null;
            } else {
                aVar2 = this.iHQ;
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
            Set<com.baidu.adp.widget.ListView.m> CO = com.baidu.tieba.recapp.report.a.CO("FRS");
            HashSet hashSet = CO == null ? new HashSet() : CO;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object aAX = cVar.aAX();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (aAX != null && cVar.getThreadType() == 3 && (aAX instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && aAX.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) aAX).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (aAX != null && cVar.getThreadType() == 3 && (aAX instanceof AdvertAppInfo) && ((AdvertAppInfo) aAX).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) aAX;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.bWO = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.bWP = str2;
                        advertAppInfo.advertAppContext.bWQ = str3;
                        advertAppInfo.advertAppContext.bWR = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.AJ = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("FRS", hashSet);
        }
    }
}
