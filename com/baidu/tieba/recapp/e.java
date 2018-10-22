package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
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
    private n brm;
    private com.baidu.adp.widget.ListView.a dQL;
    private com.baidu.adp.widget.ListView.a enY;
    private com.baidu.tieba.InjectPlugin.a.c gCQ;
    private com.baidu.adp.widget.ListView.a gCU;
    private com.baidu.adp.widget.ListView.a gCV;
    private com.baidu.adp.widget.ListView.a gCW;
    private com.baidu.adp.widget.ListView.a gCX;
    private com.baidu.adp.widget.ListView.a gCY;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void Q(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gCQ = cVar;
        if (this.gCQ != null && (this.gCQ.Sy() instanceof n)) {
            this.brm = (n) this.gCQ.Sy();
            this.dQL = new com.baidu.tieba.recapp.b.e(this.brm, AdvertAppInfo.akK);
            this.enY = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akT);
            this.gCU = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akU);
            this.gCV = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akV);
            this.gCW = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akW);
            this.gCX = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akX);
            this.gCY = new com.baidu.tieba.recapp.b.g(this.brm, AdvertAppInfo.akY);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void aa(List<Object> list) {
        this.mOriginDatas = list;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public List<Integer> Sx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.akT.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akK.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akU.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akV.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akW.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akX.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.akY.getId()));
        return arrayList;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void g(List<com.baidu.tieba.InjectPlugin.FrsFeedAd.c> list, int i) {
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
                    int wQ = advertAppInfo.wQ();
                    if (wQ != 0) {
                        a(advertAppInfo, i, wQ);
                        if (wQ != 28 && wQ != 31) {
                            advertAppInfo.aln.alA = -1001;
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
                            cVar.P(advertAppInfo);
                            cVar.gP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.wR()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.alg)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.alg) && !TextUtils.isEmpty(advertAppInfo.alc)) {
                                    hashSet.add(Integer.valueOf(l));
                                    if (l < size) {
                                        list.add(l, cVar);
                                    } else if (l == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.wS()) {
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
                    int wQ = advertAppInfo.wQ();
                    if (wQ != 0) {
                        a(advertAppInfo, i, wQ);
                        if (wQ != 28 && wQ != 31) {
                            advertAppInfo.aln.alA = -1001;
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
                                    if (!v.J(list2)) {
                                        int size3 = list2.size();
                                        int i9 = (i5 - ((i6 - l3) + 1)) - 1;
                                        int i10 = 0;
                                        while (true) {
                                            int i11 = i10;
                                            if (i11 >= size3 || i11 >= i9) {
                                                break;
                                            } else if (list2.get(i11).Su() instanceof AdvertAppInfo) {
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
                            cVar.P(advertAppInfo);
                            cVar.gP(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.wR()) {
                                if (s.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.alg)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.alg) && !TextUtils.isEmpty(advertAppInfo.alc)) {
                                    boolean he = com.baidu.tbadk.download.b.Kz().he(advertAppInfo.alg);
                                    boolean hg = com.baidu.tbadk.download.b.Kz().hg(advertAppInfo.alg);
                                    if (he) {
                                        advertAppInfo.ala = 1;
                                    } else if (hg) {
                                        advertAppInfo.ala = 2;
                                    } else {
                                        advertAppInfo.ala = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i8));
                                    if (i8 < size) {
                                        list.add(i8, cVar);
                                    } else if (i8 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.wS()) {
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
        com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.alu != null) {
            advertAppInfo.alu.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.alA != 1001 && advertAppInfo.aln.alA != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.akT) {
                aVar = this.enY;
            } else if (type == AdvertAppInfo.akK) {
                aVar = this.dQL;
            } else if (type == AdvertAppInfo.akU) {
                aVar = this.gCU;
            } else if (type == AdvertAppInfo.akV) {
                aVar = this.gCV;
            } else if (type == AdvertAppInfo.akW) {
                aVar = this.gCW;
            } else if (type == AdvertAppInfo.akX) {
                aVar = this.gCX;
            } else {
                aVar = type == AdvertAppInfo.akY ? this.gCY : null;
            }
            if (aVar != null) {
                return aVar.getView(i, view, viewGroup, advertAppInfo);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public q.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.akT) {
                aVar = this.enY;
            } else if (type == AdvertAppInfo.akK) {
                aVar = this.dQL;
            } else if (type == AdvertAppInfo.akU) {
                aVar = this.gCU;
            } else if (type == AdvertAppInfo.akV) {
                aVar = this.gCV;
            } else if (type == AdvertAppInfo.akW) {
                aVar = this.gCW;
            } else if (type == AdvertAppInfo.akX) {
                aVar = this.gCX;
            } else {
                aVar = type == AdvertAppInfo.akY ? this.gCY : null;
            }
            if (aVar != null) {
                return aVar.onCreateViewHolder(viewGroup, obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public void onFillViewHolder(int i, ViewGroup viewGroup, q.a aVar, Object obj) {
        com.baidu.adp.widget.ListView.a aVar2;
        if (obj instanceof AdvertAppInfo) {
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.akT) {
                aVar2 = this.enY;
            } else if (type == AdvertAppInfo.akK) {
                aVar2 = this.dQL;
            } else if (type == AdvertAppInfo.akU) {
                aVar2 = this.gCU;
            } else if (type == AdvertAppInfo.akV) {
                aVar2 = this.gCV;
            } else if (type == AdvertAppInfo.akW) {
                aVar2 = this.gCW;
            } else if (type == AdvertAppInfo.akX) {
                aVar2 = this.gCX;
            } else if (type != AdvertAppInfo.akY) {
                aVar2 = null;
            } else {
                aVar2 = this.gCY;
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
            Set<com.baidu.adp.widget.ListView.h> ug = com.baidu.tieba.recapp.report.a.ug("FRS");
            HashSet hashSet = ug == null ? new HashSet() : ug;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object Su = cVar.Su();
                    for (com.baidu.adp.widget.ListView.h hVar : hashSet) {
                        if (Su != null && cVar.getThreadType() == 3 && (Su instanceof AdvertAppInfo) && hVar != null && (hVar instanceof AdvertAppInfo) && Su.hashCode() == hVar.hashCode()) {
                            ((AdvertAppInfo) Su).advertAppContext = ((AdvertAppInfo) hVar).advertAppContext;
                        }
                    }
                    if (Su != null && cVar.getThreadType() == 3 && (Su instanceof AdvertAppInfo) && ((AdvertAppInfo) Su).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) Su;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.b();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.akG = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.akH = str2;
                        advertAppInfo.advertAppContext.akI = str3;
                        advertAppInfo.advertAppContext.akJ = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.RQ = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
