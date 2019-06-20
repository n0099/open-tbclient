package com.baidu.tieba.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
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
    private Map<BdUniqueId, ArrayList<am>> iWe;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.iWe == null) {
            this.iWe = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iWe.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iWe.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, am amVar) {
        if (amVar != null && bdUniqueId != null) {
            ArrayList<am> arrayList = this.iWe.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.iWe.put(bdUniqueId, arrayList);
            }
            arrayList.add(amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(BdUniqueId bdUniqueId) {
        return this.iWe.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clv() {
        if (this.iWe.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<am>> entry : this.iWe.entrySet()) {
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
            ArrayList<am> arrayList = this.iWe.get(bdUniqueId);
            if (v.Z(arrayList) != 0) {
                aF(arrayList);
                arrayList.clear();
            }
        }
    }

    private void aF(ArrayList<am> arrayList) {
        if (arrayList != null && v.Z(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (v.Z(arrayList) == 1) {
                TiebaStatic.log((am) v.c(arrayList, 0));
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
                boolean z = false;
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (v.Z(list) != 0) {
                        am amVar2 = (am) list.get(0);
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        StringBuilder sb3 = new StringBuilder(100);
                        StringBuilder sb4 = new StringBuilder();
                        StringBuilder sb5 = new StringBuilder();
                        StringBuilder sb6 = new StringBuilder();
                        StringBuilder sb7 = new StringBuilder();
                        StringBuilder sb8 = new StringBuilder();
                        StringBuilder sb9 = new StringBuilder();
                        StringBuilder sb10 = new StringBuilder();
                        int i3 = 0;
                        while (i3 < list.size()) {
                            List<Object> params = ((am) list.get(i3)).getParams();
                            sb.append(m(params, "obj_floor"));
                            sb.append("|");
                            sb2.append(m(params, "obj_isad"));
                            sb2.append("|");
                            sb3.append(m(params, VideoPlayActivityConfig.OBJ_ID));
                            sb3.append("|");
                            sb4.append(m(params, "tid"));
                            sb4.append("|");
                            sb5.append(m(params, Info.kBaiduPIDKey));
                            sb5.append("|");
                            sb6.append(m(params, "thread_type"));
                            sb6.append("|");
                            sb7.append(m(params, "fid"));
                            sb7.append("|");
                            String m = m(params, "post_type");
                            boolean z2 = !StringUtils.isNull(m) ? true : z;
                            sb8.append(m);
                            sb8.append("|");
                            sb9.append(m(params, "obj_isofficial"));
                            sb9.append("|");
                            sb10.append(m(params, "obj_adlocate"));
                            sb10.append("|");
                            i3++;
                            z = z2;
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
                        if (sb8.length() > 0) {
                            sb8.deleteCharAt(sb8.length() - 1);
                        }
                        if (sb9.length() > 0) {
                            sb9.deleteCharAt(sb9.length() - 1);
                        }
                        if (sb10.length() > 0) {
                            sb10.deleteCharAt(sb10.length() - 1);
                        }
                        amVar2.delete("obj_floor");
                        amVar2.delete("obj_isad");
                        amVar2.delete(VideoPlayActivityConfig.OBJ_ID);
                        amVar2.delete("tid");
                        amVar2.delete(Info.kBaiduPIDKey);
                        amVar2.delete("thread_type");
                        amVar2.delete("fid");
                        amVar2.delete("post_type");
                        amVar2.delete("obj_isofficial");
                        amVar2.bT("obj_floors", sb.toString());
                        amVar2.bT("obj_isads", sb2.toString());
                        amVar2.bT("obj_ids", sb3.toString());
                        amVar2.bT("tids", sb4.toString());
                        amVar2.bT("pids", sb5.toString());
                        amVar2.bT("thread_types", sb6.toString());
                        amVar2.bT("fids", sb7.toString());
                        amVar2.bT("obj_isofficials", sb9.toString());
                        amVar2.bT("obj_adlocates", sb10.toString());
                        if (z) {
                            amVar2.bT("post_types", sb8.toString());
                        }
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

    private String m(List<Object> list, String str) {
        int indexOf;
        if (v.Z(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
