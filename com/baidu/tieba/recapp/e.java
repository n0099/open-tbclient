package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
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
    private n cHz;
    private com.baidu.adp.widget.ListView.a fMy;
    private com.baidu.adp.widget.ListView.a fMz;
    private com.baidu.tieba.InjectPlugin.a.c igq;
    private com.baidu.adp.widget.ListView.a igu;
    private com.baidu.adp.widget.ListView.a igv;
    private com.baidu.adp.widget.ListView.a igw;
    private com.baidu.adp.widget.ListView.a igx;
    private com.baidu.adp.widget.ListView.a igy;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.igq = cVar;
        if (this.igq != null && (this.igq.auh() instanceof n)) {
            this.cHz = (n) this.igq.auh();
            this.fMy = new com.baidu.tieba.recapp.b.e(this.cHz, AdvertAppInfo.bwq);
            this.fMz = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwz);
            this.igu = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwA);
            this.igv = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwB);
            this.igw = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwC);
            this.igx = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwD);
            this.igy = new com.baidu.tieba.recapp.b.g(this.cHz, AdvertAppInfo.bwE);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void an(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> aug() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwz.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwq.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwA.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwB.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwC.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwD.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.bwE.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void f(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int WX = advertAppInfo.WX();
                    if (WX != 0) {
                        a(advertAppInfo, i, WX);
                        if (WX != 28 && WX != 31) {
                            advertAppInfo.bwR.bxe = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int l = (com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0) + i2) - 1;
                        if (hashSet.contains(Integer.valueOf(l))) {
                            b(advertAppInfo, i, 29);
                        } else if (l < 0) {
                            b(advertAppInfo, i, 33);
                        } else if (l >= size && i4 > 3) {
                            b(advertAppInfo, i, 2);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.ah(advertAppInfo);
                            cVar.lh(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.WY()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bwL)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bwL) && !TextUtils.isEmpty(advertAppInfo.bwI)) {
                                    hashSet.add(Integer.valueOf(l));
                                    if (l < size) {
                                        list.add(l, cVar);
                                    } else if (l == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.WZ()) {
                                hashSet.add(Integer.valueOf(l));
                                if (l < size) {
                                    list.add(l, cVar);
                                } else if (l == size) {
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
        int l;
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
            int i4 = 0;
            Iterator<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> it2 = list.iterator();
            while (true) {
                i2 = i4;
                if (!it2.hasNext()) {
                    break;
                }
                i4 = it2.next().getThreadType() == 1 ? i2 + 1 : i2;
            }
            int size2 = arrayList.size();
            if (size2 >= 1) {
                int i5 = (arrayList.size() <= 1 || (l = (com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(1)).adPosition, 0) - com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(0)).adPosition, 0)) + (-1)) <= 0) ? 9 : l;
                int l2 = com.baidu.adp.lib.g.b.l(((AdvertAppInfo) arrayList.get(0)).adPosition, 0) - 1;
                int i6 = size - i2;
                HashSet hashSet = new HashSet();
                for (int i7 = 0; i7 < size2; i7++) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) arrayList.get(i7);
                    advertAppInfo.page = "SMART_FRS";
                    int WX = advertAppInfo.WX();
                    if (WX != 0) {
                        a(advertAppInfo, i, WX);
                        if (WX != 28 && WX != 31) {
                            advertAppInfo.bwR.bxe = -1001;
                        }
                    }
                    if (advertAppInfo.getType() == null) {
                        b(advertAppInfo, i, 100);
                    } else {
                        int l3 = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0);
                        int i8 = (l3 + i2) - 1;
                        if (i8 >= 0 && !hashSet.contains(Integer.valueOf(i8)) && i8 <= size) {
                            if (l3 > (i6 - i5) + l2) {
                                if (z) {
                                    if (!v.T(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - l3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).aud() instanceof AdvertAppInfo) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i10 = i11 + 1;
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
                        } else if (i8 > size) {
                            i3 = 2;
                        } else if (i8 < 0) {
                            i3 = 33;
                        } else {
                            i3 = 29;
                        }
                        if (i3 != 0) {
                            b(advertAppInfo, i, i3);
                        } else {
                            com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar = new com.baidu.tieba.InjectPlugin.FrsFeedAd.c();
                            cVar.ah(advertAppInfo);
                            cVar.lh(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.WY()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.bwL)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.bwL) && !TextUtils.isEmpty(advertAppInfo.bwI)) {
                                    boolean oB = com.baidu.tbadk.download.b.alH().oB(advertAppInfo.bwL);
                                    boolean oD = com.baidu.tbadk.download.b.alH().oD(advertAppInfo.bwL);
                                    if (oB) {
                                        advertAppInfo.bwG = 1;
                                    } else if (oD) {
                                        advertAppInfo.bwG = 2;
                                    } else {
                                        advertAppInfo.bwG = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.WZ()) {
                                hashSet.add(Integer.valueOf(i8));
                                if (i8 < size) {
                                    list.add(i8, cVar);
                                } else if (i8 == size) {
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
        com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.bwY != null) {
            advertAppInfo.bwY.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.bwR != null && advertAppInfo.bwR.bxe != 1001 && advertAppInfo.bwR.bxe != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.bwz) {
                aVar = this.fMz;
            } else if (type == AdvertAppInfo.bwq) {
                aVar = this.fMy;
            } else if (type == AdvertAppInfo.bwA) {
                aVar = this.igu;
            } else if (type == AdvertAppInfo.bwB) {
                aVar = this.igv;
            } else if (type == AdvertAppInfo.bwC) {
                aVar = this.igw;
            } else if (type == AdvertAppInfo.bwD) {
                aVar = this.igx;
            } else {
                aVar = type == AdvertAppInfo.bwE ? this.igy : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public v.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.bwz) {
                aVar = this.fMz;
            } else if (type == AdvertAppInfo.bwq) {
                aVar = this.fMy;
            } else if (type == AdvertAppInfo.bwA) {
                aVar = this.igu;
            } else if (type == AdvertAppInfo.bwB) {
                aVar = this.igv;
            } else if (type == AdvertAppInfo.bwC) {
                aVar = this.igw;
            } else if (type == AdvertAppInfo.bwD) {
                aVar = this.igx;
            } else {
                aVar = type == AdvertAppInfo.bwE ? this.igy : null;
            }
            if (aVar != null) {
                return aVar.onCreateViewHolder(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void onFillViewHolder(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.bwz) {
                aVar2 = this.fMz;
            } else if (type == AdvertAppInfo.bwq) {
                aVar2 = this.fMy;
            } else if (type == AdvertAppInfo.bwA) {
                aVar2 = this.igu;
            } else if (type == AdvertAppInfo.bwB) {
                aVar2 = this.igv;
            } else if (type == AdvertAppInfo.bwC) {
                aVar2 = this.igw;
            } else if (type == AdvertAppInfo.bwD) {
                aVar2 = this.igx;
            } else if (type != AdvertAppInfo.bwE) {
                aVar2 = null;
            } else {
                aVar2 = this.igy;
            }
            if (aVar2 != null) {
                aVar2.onFillViewHolder(i, viewGroup, aVar, obj);
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
            Set<com.baidu.adp.widget.ListView.m> BH = com.baidu.tieba.recapp.report.a.BH("FRS");
            HashSet hashSet = BH == null ? new HashSet() : BH;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object aud = cVar.aud();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (aud != null && cVar.getThreadType() == 3 && (aud instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && aud.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) aud).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (aud != null && cVar.getThreadType() == 3 && (aud instanceof AdvertAppInfo) && ((AdvertAppInfo) aud).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) aud;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.bwm = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.bwn = str2;
                        advertAppInfo.advertAppContext.bwo = str3;
                        advertAppInfo.advertAppContext.bwp = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.Tl = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("FRS", hashSet);
        }
    }
}
