package com.baidu.tieba.s;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<ap>> lKy;
    private String[] lKz = {"obj_floor", "obj_isad", "obj_id", "tid", "pid", "thread_type", "fid", "post_type", "obj_isofficial", "obj_adlocate", "recom_weight", IntentConfig.RECOM_SOURCE, "recom_ab_tag", "recom_extra", "recom_type", "ugc_vid", "ugc_nid", "ori_ugc_type"};

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.lKy == null) {
            this.lKy = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lKy.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lKy.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, ap apVar) {
        if (apVar != null && bdUniqueId != null) {
            ArrayList<ap> arrayList = this.lKy.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.lKy.put(bdUniqueId, arrayList);
            }
            arrayList.add(apVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(BdUniqueId bdUniqueId) {
        return this.lKy.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dkg() {
        if (this.lKy.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<ap>> entry : this.lKy.entrySet()) {
                ArrayList<ap> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<ap> arrayList = this.lKy.get(bdUniqueId);
            if (x.getCount(arrayList) != 0) {
                aX(arrayList);
                arrayList.clear();
            }
        }
    }

    private void aX(ArrayList<ap> arrayList) {
        if (arrayList != null && x.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (x.getCount(arrayList) == 1) {
                TiebaStatic.log((ap) x.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    ap apVar = arrayList.get(i);
                    if (hashMap.containsKey(apVar.getKey())) {
                        ((List) hashMap.get(apVar.getKey())).add(apVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(apVar);
                        hashMap.put(apVar.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (x.getCount(list) != 0) {
                        ap apVar2 = (ap) list.get(0);
                        for (int i2 = 0; i2 < this.lKz.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(m(((ap) list.get(i3)).getParams(), this.lKz[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            apVar2.delete(this.lKz[i2]);
                            apVar2.dn(this.lKz[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(apVar2);
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
        if (x.getCount(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
