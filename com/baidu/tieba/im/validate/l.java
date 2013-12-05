package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static void a(com.baidu.tieba.im.a<Boolean> aVar, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            com.baidu.tieba.im.db.l.a().a(validateItemData, aVar);
        }
    }

    public static void a(List<ValidateItemData> list) {
        if (list != null && !list.isEmpty()) {
            RecentChatFriendData l = com.baidu.tieba.im.pushNotify.a.h().l();
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ValidateItemData validateItemData = list.get(i);
                if (validateItemData != null && !validateItemData.isShown()) {
                    validateItemData.setShown(true);
                    linkedList.add(new GroupNewsPojo(validateItemData));
                    l.setUnReadCount(l.getUnReadCount() - 1);
                    com.baidu.tieba.im.pushNotify.a.h().a(l.getUnReadCount());
                }
            }
            new m(linkedList).execute(new Void[0]);
        }
    }

    public static void a(ValidateItemData validateItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (validateItemData != null) {
            com.baidu.adp.lib.h.e.d("lastmid:" + validateItemData.getNotice_id());
            com.baidu.tieba.im.db.l.a().b(validateItemData.getNotice_id(), aVar);
        }
    }

    public static void a(int i, int i2, com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.db.l.a().a(0L, i, i2, "apply_join_group", aVar);
    }

    public static void a(com.baidu.tieba.im.a<Integer> aVar) {
        com.baidu.tieba.im.db.l.a().a("apply_join_group", aVar);
    }

    public static List<ValidateItemData> a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ValidateItemData a2 = a(it.next());
            if (a2 != null) {
                linkedList2.add(a2);
            }
        }
        return linkedList2;
    }

    public static ValidateItemData a(GroupNewsPojo groupNewsPojo) {
        ValidateItemData validateItemData;
        if (groupNewsPojo == null) {
            return null;
        }
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (true == jSONObject.isNull("notice_id")) {
                validateItemData = new ValidateItemData();
                validateItemData.setNotice_id(groupNewsPojo.getNotice_id());
                validateItemData.setApplyReason(jSONObject.optString("userMsg"));
                validateItemData.setApplyTime(groupNewsPojo.getTime());
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (optJSONObject == null) {
                    validateItemData = null;
                } else {
                    validateItemData.setUserName(optJSONObject.optString("userName"));
                    validateItemData.setPortrait(optJSONObject.optString("portrait"));
                    String optString = optJSONObject.optString("groupId");
                    validateItemData.setGroupId(optString);
                    com.baidu.adp.lib.h.e.d("getGroupInfo gid:" + optString);
                    a(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setExt(groupNewsPojo.getExt());
                }
            } else {
                validateItemData = (ValidateItemData) new GsonBuilder().create().fromJson(content, (Class<Object>) ValidateItemData.class);
                a(validateItemData, validateItemData.getGroupId());
            }
            return validateItemData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(ValidateItemData validateItemData, String str) {
        String str2 = "";
        List<GroupUpdateMessage> m = com.baidu.tieba.im.pushNotify.a.h().m();
        if (m != null && !TextUtils.isEmpty(str)) {
            for (GroupUpdateMessage groupUpdateMessage : m) {
                str2 = str.equals(String.valueOf(groupUpdateMessage.getGroupId())) ? groupUpdateMessage.getName() : str2;
            }
        }
        validateItemData.setGroupName(str2);
    }
}
