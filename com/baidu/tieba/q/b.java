package com.baidu.tieba.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<am>> hkM;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.hkM == null) {
            this.hkM = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hkM.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hkM.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, am amVar) {
        if (amVar != null && bdUniqueId != null) {
            ArrayList<am> arrayList = this.hkM.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.hkM.put(bdUniqueId, arrayList);
            }
            arrayList.add(amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(BdUniqueId bdUniqueId) {
        return this.hkM.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBS() {
        if (this.hkM.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<am>> entry : this.hkM.entrySet()) {
                ArrayList<am> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<am> arrayList = this.hkM.get(bdUniqueId);
            if (v.H(arrayList) != 0) {
                ax(arrayList);
                arrayList.clear();
            }
        }
    }

    private void ax(ArrayList<am> arrayList) {
        if (arrayList != null && v.H(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (v.H(arrayList) == 1) {
                TiebaStatic.log((am) v.d(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    am amVar = arrayList.get(i2);
                    if (hashMap.containsKey(amVar.getKey())) {
                        ((List) hashMap.get(amVar.getKey())).add(amVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(amVar);
                        hashMap.put(amVar.getKey(), arrayList2);
                    }
                    i = i2 + 1;
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (v.H(list) != 0) {
                        am amVar2 = (am) list.get(0);
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        StringBuilder sb3 = new StringBuilder(100);
                        StringBuilder sb4 = new StringBuilder();
                        StringBuilder sb5 = new StringBuilder();
                        StringBuilder sb6 = new StringBuilder();
                        StringBuilder sb7 = new StringBuilder();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            List<Object> params = ((am) list.get(i4)).getParams();
                            sb.append(k(params, "obj_floor"));
                            sb.append("|");
                            sb2.append(k(params, "obj_isad"));
                            sb2.append("|");
                            sb3.append(k(params, VideoPlayActivityConfig.OBJ_ID));
                            sb3.append("|");
                            sb4.append(k(params, "tid"));
                            sb4.append("|");
                            sb5.append(k(params, Info.kBaiduPIDKey));
                            sb5.append("|");
                            sb6.append(k(params, "thread_type"));
                            sb6.append("|");
                            sb7.append(k(params, ImageViewerConfig.FORUM_ID));
                            sb7.append("|");
                            i3 = i4 + 1;
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (sb2.length() > 0) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        if (sb3.length() > 0) {
                            sb3.deleteCharAt(sb3.length() - 1);
                        }
                        if (sb4.length() > 0) {
                            sb4.deleteCharAt(sb4.length() - 1);
                        }
                        if (sb5.length() > 0) {
                            sb5.deleteCharAt(sb5.length() - 1);
                        }
                        if (sb6.length() > 0) {
                            sb6.deleteCharAt(sb6.length() - 1);
                        }
                        if (sb7.length() > 0) {
                            sb7.deleteCharAt(sb7.length() - 1);
                        }
                        amVar2.delete("obj_floor");
                        amVar2.delete("obj_isad");
                        amVar2.delete(VideoPlayActivityConfig.OBJ_ID);
                        amVar2.delete("tid");
                        amVar2.delete(Info.kBaiduPIDKey);
                        amVar2.delete("thread_type");
                        amVar2.delete(ImageViewerConfig.FORUM_ID);
                        amVar2.aA("obj_floors", sb.toString());
                        amVar2.aA("obj_isads", sb2.toString());
                        amVar2.aA("obj_ids", sb3.toString());
                        amVar2.aA("tids", sb4.toString());
                        amVar2.aA("pids", sb5.toString());
                        amVar2.aA("thread_types", sb6.toString());
                        amVar2.aA("fids", sb7.toString());
                        TiebaStatic.log(amVar2);
                    }
                }
                if (hashMap != null && !hashMap.isEmpty()) {
                    hashMap.clear();
                }
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("logStatisticByKey->" + (System.currentTimeMillis() - currentTimeMillis) + "|size=" + arrayList.size());
            }
        }
    }

    private String k(List<Object> list, String str) {
        int indexOf;
        if (v.H(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
