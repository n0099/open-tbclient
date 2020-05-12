package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
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
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private m etz;
    private com.baidu.adp.widget.ListView.a hPK;
    private com.baidu.adp.widget.ListView.a hPL;
    private com.baidu.tieba.InjectPlugin.a.c krl;
    private com.baidu.adp.widget.ListView.a krp;
    private com.baidu.adp.widget.ListView.a krq;
    private com.baidu.adp.widget.ListView.a krr;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.krl = cVar;
        if (this.krl != null && (this.krl.bdN() instanceof m)) {
            this.etz = (m) this.krl.bdN();
            this.hPK = new com.baidu.tieba.recapp.b.e(this.etz, AdvertAppInfo.dmb);
            this.hPL = new com.baidu.tieba.recapp.b.g(this.etz, AdvertAppInfo.dmk);
            this.krp = new com.baidu.tieba.recapp.b.g(this.etz, AdvertAppInfo.dml);
            this.krq = new com.baidu.tieba.recapp.b.g(this.etz, AdvertAppInfo.dmm);
            this.krr = new com.baidu.tieba.recapp.b.g(this.etz, AdvertAppInfo.dmn);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void bc(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> bdM() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmk.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmb.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dml.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmm.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmn.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void e(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int aID = advertAppInfo.aID();
                    if (aID != 0) {
                        a(advertAppInfo, i, aID);
                        if (aID != 28 && aID != 31) {
                            advertAppInfo.dmB.dmO = -1001;
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
                            cVar.ao(advertAppInfo);
                            cVar.og(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aIE()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dmv)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dmv) && !TextUtils.isEmpty(advertAppInfo.dmt)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < size) {
                                        list.add(i6, cVar);
                                    } else if (i6 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aIF()) {
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
                    int aID = advertAppInfo.aID();
                    if (aID != 0) {
                        a(advertAppInfo, i, aID);
                        if (aID != 28 && aID != 31) {
                            advertAppInfo.dmB.dmO = -1001;
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
                                            } else if (list2.get(i14).bdJ() instanceof AdvertAppInfo) {
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
                            cVar.ao(advertAppInfo);
                            cVar.og(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aIE()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dmv)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dmv) && !TextUtils.isEmpty(advertAppInfo.dmt)) {
                                    boolean wn = com.baidu.tbadk.download.b.aWH().wn(advertAppInfo.dmv);
                                    boolean wp = com.baidu.tbadk.download.b.aWH().wp(advertAppInfo.dmv);
                                    if (wn) {
                                        advertAppInfo.dmr = 1;
                                    } else if (wp) {
                                        advertAppInfo.dmr = 2;
                                    } else {
                                        advertAppInfo.dmr = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < size) {
                                        list.add(i11, cVar);
                                    } else if (i11 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aIF()) {
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
        com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dmI != null) {
            advertAppInfo.dmI.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.dmB != null && advertAppInfo.dmB.dmO != 1001 && advertAppInfo.dmB.dmO != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.dmk) {
                aVar = this.hPL;
            } else if (type == AdvertAppInfo.dmb) {
                aVar = this.hPK;
            } else if (type == AdvertAppInfo.dml) {
                aVar = this.krp;
            } else if (type == AdvertAppInfo.dmm) {
                aVar = this.krq;
            } else {
                aVar = type == AdvertAppInfo.dmn ? this.krr : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public y.a a(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.dmk) {
                aVar = this.hPL;
            } else if (type == AdvertAppInfo.dmb) {
                aVar = this.hPK;
            } else if (type == AdvertAppInfo.dml) {
                aVar = this.krp;
            } else if (type == AdvertAppInfo.dmm) {
                aVar = this.krq;
            } else {
                aVar = type == AdvertAppInfo.dmn ? this.krr : null;
            }
            if (aVar != null) {
                return aVar.a(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void a(int i, ViewGroup viewGroup, y.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.dmk) {
                aVar2 = this.hPL;
            } else if (type == AdvertAppInfo.dmb) {
                aVar2 = this.hPK;
            } else if (type == AdvertAppInfo.dml) {
                aVar2 = this.krp;
            } else if (type == AdvertAppInfo.dmm) {
                aVar2 = this.krq;
            } else if (type != AdvertAppInfo.dmn) {
                aVar2 = null;
            } else {
                aVar2 = this.krr;
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
            Set<com.baidu.adp.widget.ListView.m> JH = com.baidu.tieba.recapp.report.a.JH("FRS");
            HashSet hashSet = JH == null ? new HashSet() : JH;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bdJ = cVar.bdJ();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (bdJ != null && cVar.getThreadType() == 3 && (bdJ instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && bdJ.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) bdJ).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (bdJ != null && cVar.getThreadType() == 3 && (bdJ instanceof AdvertAppInfo) && ((AdvertAppInfo) bdJ).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bdJ;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.dlW = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.dlX = str2;
                        advertAppInfo.advertAppContext.dlY = str3;
                        advertAppInfo.advertAppContext.dlZ = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.WL = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
