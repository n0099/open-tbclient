package com.baidu.yuyinala.more;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class AlaMoreFunctionDialogData implements IBaseDialogData {
    private String mCustomRoomId;
    private String mGroupId;
    private List<com.baidu.yuyinala.more.b.b> mGroupList;
    private String mLiveId;
    private String mRoomId;
    private boolean mShowFirstCharge = false;
    private boolean mShowSuperCharge = false;

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public void parseData(String str) {
        this.mGroupList = parseFunctionInfo(str);
        filterRechargeAndTransferFunction();
        sendRedNodeAndMoreShowMsg();
    }

    private void filterRechargeAndTransferFunction() {
        if (!ListUtils.isEmpty(this.mGroupList)) {
            if (this.mShowSuperCharge) {
                filterFunctionByAction("first_recharge");
                return;
            }
            filterFunctionByAction("super_recharge");
            if (!this.mShowFirstCharge) {
                filterFunctionByAction("first_recharge");
            }
        }
    }

    private void filterFunctionByAction(String str) {
        if (!ListUtils.isEmpty(this.mGroupList)) {
            Iterator<com.baidu.yuyinala.more.b.b> it = this.mGroupList.iterator();
            while (it.hasNext()) {
                com.baidu.yuyinala.more.b.b next = it.next();
                if (next == null || ListUtils.isEmpty(next.ekO())) {
                    it.remove();
                } else {
                    Iterator<com.baidu.yuyinala.more.b.a> it2 = next.ekO().iterator();
                    while (it2.hasNext()) {
                        com.baidu.yuyinala.more.b.a next2 = it2.next();
                        if (next2 == null) {
                            it2.remove();
                        } else if (TextUtils.equals(next2.getAction(), str)) {
                            it2.remove();
                            if (ListUtils.isEmpty(next.ekO())) {
                                it.remove();
                                return;
                            }
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }

    private void sendRedNodeAndMoreShowMsg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(mergeRedNodeFunctionId(this.mGroupList))));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501016, Boolean.valueOf(!ListUtils.isEmpty(this.mGroupList))));
    }

    public List<com.baidu.yuyinala.more.b.b> getGroupList() {
        return this.mGroupList;
    }

    public String getLiveId() {
        return this.mLiveId;
    }

    public void setLiveId(String str) {
        this.mLiveId = str;
    }

    public String getCustomRoomId() {
        return this.mCustomRoomId;
    }

    public void setCustomRoomId(String str) {
        this.mCustomRoomId = str;
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    public void setRoomId(String str) {
        this.mRoomId = str;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setShowFirstCharge(boolean z, boolean z2) {
        boolean z3 = false;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mShowFirstCharge = false;
            this.mShowSuperCharge = false;
            return;
        }
        if (z && com.baidu.live.ae.a.RB().RG()) {
            z3 = true;
        }
        this.mShowFirstCharge = z3;
        this.mShowSuperCharge = z2;
    }

    public static List<com.baidu.yuyinala.more.b.b> parseFunctionInfo(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                com.baidu.yuyinala.more.b.b bVar = new com.baidu.yuyinala.more.b.b();
                bVar.parse(jSONArray.optJSONObject(i));
                arrayList.add(bVar);
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveClickedId(com.baidu.yuyinala.more.b.a aVar) {
        if (aVar != null && aVar.ekM()) {
            Set<String> stringSet = d.BM().getStringSet("audio_more_red_node_clicked_function", new HashSet());
            if (stringSet.add(aVar.getId())) {
                d.BM().putStringSet("audio_more_red_node_clicked_function", stringSet);
            }
        }
    }

    public static boolean mergeRedNodeFunctionId(List<com.baidu.yuyinala.more.b.b> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        Set<String> stringSet = d.BM().getStringSet("audio_more_red_node_clicked_function", new HashSet());
        Set<String> redNodeFuncIdsFromData = getRedNodeFuncIdsFromData(list);
        initNeedShowRedNode(list, stringSet);
        HashSet hashSet = new HashSet();
        hashSet.clear();
        hashSet.addAll(stringSet);
        hashSet.removeAll(redNodeFuncIdsFromData);
        if (stringSet.removeAll(hashSet)) {
            d.BM().putStringSet("audio_more_red_node_clicked_function", stringSet);
        }
        return !stringSet.containsAll(redNodeFuncIdsFromData);
    }

    private static void initNeedShowRedNode(List<com.baidu.yuyinala.more.b.b> list, Set<String> set) {
        for (com.baidu.yuyinala.more.b.b bVar : list) {
            if (bVar != null && bVar.ekO() != null) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ekO()) {
                    if (aVar.ekM()) {
                        if (set.contains(aVar.getId())) {
                            aVar.At(false);
                        } else {
                            aVar.At(true);
                        }
                    }
                }
            }
        }
    }

    private static Set<String> getRedNodeFuncIdsFromData(List<com.baidu.yuyinala.more.b.b> list) {
        HashSet hashSet = new HashSet();
        for (com.baidu.yuyinala.more.b.b bVar : list) {
            if (bVar != null && bVar.ekO() != null) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ekO()) {
                    if (aVar.ekM()) {
                        hashSet.add(aVar.getId());
                    }
                }
            }
        }
        return hashSet;
    }
}
