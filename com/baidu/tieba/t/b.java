package com.baidu.tieba.t;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<ar>> mVf;
    private String[] mVg = {"obj_floor", "obj_isad", "obj_id", "tid", "pid", "thread_type", "fid", "post_type", "obj_isofficial", "obj_adlocate", "recom_weight", IntentConfig.RECOM_SOURCE, "recom_ab_tag", "recom_extra", "recom_type", "ugc_vid", "ugc_nid", "ori_ugc_type"};

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.mVf == null) {
            this.mVf = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mVf.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mVf.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, ar arVar) {
        if (arVar != null && bdUniqueId != null) {
            ArrayList<ar> arrayList = this.mVf.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mVf.put(bdUniqueId, arrayList);
            }
            arrayList.add(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(BdUniqueId bdUniqueId) {
        return this.mVf.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dIN() {
        if (this.mVf.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<ar>> entry : this.mVf.entrySet()) {
                ArrayList<ar> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<ar> arrayList = this.mVf.get(bdUniqueId);
            if (y.getCount(arrayList) != 0) {
                bj(arrayList);
                arrayList.clear();
            }
        }
    }

    private void bj(ArrayList<ar> arrayList) {
        if (arrayList != null && y.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (y.getCount(arrayList) == 1) {
                TiebaStatic.log((ar) y.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    ar arVar = arrayList.get(i);
                    if (hashMap.containsKey(arVar.getKey())) {
                        ((List) hashMap.get(arVar.getKey())).add(arVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(arVar);
                        hashMap.put(arVar.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (y.getCount(list) != 0) {
                        ar arVar2 = (ar) list.get(0);
                        for (int i2 = 0; i2 < this.mVg.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(p(((ar) list.get(i3)).getParams(), this.mVg[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            arVar2.delete(this.mVg[i2]);
                            arVar2.dR(this.mVg[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(arVar2);
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

    private String p(List<Object> list, String str) {
        int indexOf;
        if (y.getCount(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
