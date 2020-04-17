package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
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
public class d implements com.baidu.tieba.InjectPlugin.FrsFeedAd.d {
    private m etu;
    private com.baidu.adp.widget.ListView.a hPE;
    private com.baidu.adp.widget.ListView.a hPF;
    private com.baidu.tieba.InjectPlugin.a.c krh;
    private com.baidu.adp.widget.ListView.a krl;
    private com.baidu.adp.widget.ListView.a krm;
    private com.baidu.adp.widget.ListView.a krn;
    private List<Object> mOriginDatas;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.krh = cVar;
        if (this.krh != null && (this.krh.bdP() instanceof m)) {
            this.etu = (m) this.krh.bdP();
            this.hPE = new com.baidu.tieba.recapp.b.e(this.etu, AdvertAppInfo.dlX);
            this.hPF = new com.baidu.tieba.recapp.b.g(this.etu, AdvertAppInfo.dmg);
            this.krl = new com.baidu.tieba.recapp.b.g(this.etu, AdvertAppInfo.dmh);
            this.krm = new com.baidu.tieba.recapp.b.g(this.etu, AdvertAppInfo.dmi);
            this.krn = new com.baidu.tieba.recapp.b.g(this.etu, AdvertAppInfo.dmj);
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
    public List<Integer> bdO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmg.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dlX.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmh.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmi.getId()));
        arrayList.add(Integer.valueOf(AdvertAppInfo.dmj.getId()));
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
                    int aIF = advertAppInfo.aIF();
                    if (aIF != 0) {
                        a(advertAppInfo, i, aIF);
                        if (aIF != 28 && aIF != 31) {
                            advertAppInfo.dmx.dmK = MessageConfig.ERROR_TASK_OUTTIME;
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
                            cVar.og(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aIG()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dmr)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dmr) && !TextUtils.isEmpty(advertAppInfo.dmp)) {
                                    hashSet.add(Integer.valueOf(i6));
                                    if (i6 < size) {
                                        list.add(i6, cVar);
                                    } else if (i6 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aIH()) {
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
                    int aIF = advertAppInfo.aIF();
                    if (aIF != 0) {
                        a(advertAppInfo, i, aIF);
                        if (aIF != 28 && aIF != 31) {
                            advertAppInfo.dmx.dmK = MessageConfig.ERROR_TASK_OUTTIME;
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
                                            } else if (list2.get(i14).bdL() instanceof AdvertAppInfo) {
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
                            cVar.og(advertAppInfo.getType().getId());
                            cVar.setThreadType(3);
                            if (advertAppInfo.aIG()) {
                                if (r.isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.dmr)) {
                                    b(advertAppInfo, i, 3);
                                } else if (!TextUtils.isEmpty(advertAppInfo.dmr) && !TextUtils.isEmpty(advertAppInfo.dmp)) {
                                    boolean wk = com.baidu.tbadk.download.b.aWJ().wk(advertAppInfo.dmr);
                                    boolean wm = com.baidu.tbadk.download.b.aWJ().wm(advertAppInfo.dmr);
                                    if (wk) {
                                        advertAppInfo.dmn = 1;
                                    } else if (wm) {
                                        advertAppInfo.dmn = 2;
                                    } else {
                                        advertAppInfo.dmn = 0;
                                    }
                                    hashSet.add(Integer.valueOf(i11));
                                    if (i11 < size) {
                                        list.add(i11, cVar);
                                    } else if (i11 == size) {
                                        list.add(cVar);
                                    }
                                }
                            } else if (advertAppInfo.aIH()) {
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
        com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(advertAppInfo, 5, i, i2));
        if (advertAppInfo != null && advertAppInfo.dmE != null) {
            advertAppInfo.dmE.mDiscardReason = i2;
        }
    }

    private void b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo != null && advertAppInfo.dmx != null && advertAppInfo.dmx.dmK != 1001 && advertAppInfo.dmx.dmK != -1001) {
            a(advertAppInfo, i, i2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsFeedAd.d
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        com.baidu.adp.widget.ListView.a aVar;
        if (obj instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.dmg) {
                aVar = this.hPF;
            } else if (type == AdvertAppInfo.dlX) {
                aVar = this.hPE;
            } else if (type == AdvertAppInfo.dmh) {
                aVar = this.krl;
            } else if (type == AdvertAppInfo.dmi) {
                aVar = this.krm;
            } else {
                aVar = type == AdvertAppInfo.dmj ? this.krn : null;
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
            if (type == AdvertAppInfo.dmg) {
                aVar = this.hPF;
            } else if (type == AdvertAppInfo.dlX) {
                aVar = this.hPE;
            } else if (type == AdvertAppInfo.dmh) {
                aVar = this.krl;
            } else if (type == AdvertAppInfo.dmi) {
                aVar = this.krm;
            } else {
                aVar = type == AdvertAppInfo.dmj ? this.krn : null;
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
            if (type == AdvertAppInfo.dmg) {
                aVar2 = this.hPF;
            } else if (type == AdvertAppInfo.dlX) {
                aVar2 = this.hPE;
            } else if (type == AdvertAppInfo.dmh) {
                aVar2 = this.krl;
            } else if (type == AdvertAppInfo.dmi) {
                aVar2 = this.krm;
            } else if (type != AdvertAppInfo.dmj) {
                aVar2 = null;
            } else {
                aVar2 = this.krn;
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
            Set<com.baidu.adp.widget.ListView.m> JE = com.baidu.tieba.recapp.report.a.JE("FRS");
            HashSet hashSet = JE == null ? new HashSet() : JE;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.tieba.InjectPlugin.FrsFeedAd.c cVar : list) {
                if (cVar != null) {
                    Object bdL = cVar.bdL();
                    for (com.baidu.adp.widget.ListView.m mVar : hashSet) {
                        if (bdL != null && cVar.getThreadType() == 3 && (bdL instanceof AdvertAppInfo) && mVar != null && (mVar instanceof AdvertAppInfo) && bdL.hashCode() == mVar.hashCode()) {
                            ((AdvertAppInfo) bdL).advertAppContext = ((AdvertAppInfo) mVar).advertAppContext;
                        }
                    }
                    if (bdL != null && cVar.getThreadType() == 3 && (bdL instanceof AdvertAppInfo) && ((AdvertAppInfo) bdL).advertAppContext == null) {
                        AdvertAppInfo advertAppInfo = (AdvertAppInfo) bdL;
                        advertAppInfo.advertAppContext = new com.baidu.tbadk.core.data.c();
                        advertAppInfo.advertAppContext.page = "FRS";
                        advertAppInfo.advertAppContext.dlS = String.valueOf(z);
                        advertAppInfo.advertAppContext.pn = i;
                        advertAppInfo.advertAppContext.fid = str;
                        advertAppInfo.advertAppContext.dlT = str2;
                        advertAppInfo.advertAppContext.dlU = str3;
                        advertAppInfo.advertAppContext.dlV = str4;
                        advertAppInfo.advertAppContext.extensionInfo = advertAppInfo.extensionInfo;
                        advertAppInfo.advertAppContext.WI = false;
                        hashSet2.add(advertAppInfo);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("FRS", hashSet);
        }
    }
}
