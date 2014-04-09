package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class n {
    public static void a(com.baidu.tieba.im.a<Boolean> aVar, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            com.baidu.tieba.im.r.a(new o(validateItemData), aVar);
        }
    }

    public static void a(int i, int i2, com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.r.a(new r(i, i2), aVar);
    }

    public static List<ValidateItemData> a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ValidateItemData a = a(it.next());
            if (a != null) {
                linkedList2.add(a);
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
            if (jSONObject.isNull("notice_id")) {
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
                    com.baidu.adp.lib.util.f.e("getGroupInfo gid:" + optString);
                    a(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setInviterUserId(optJSONObject.optLong("inviteUserId"));
                    validateItemData.setJoinType(optJSONObject.optInt("joinType"));
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
        List<GroupUpdateMessage> g = com.baidu.tieba.im.pushNotify.a.d().g();
        if (g != null && !TextUtils.isEmpty(str)) {
            String str3 = "";
            for (GroupUpdateMessage groupUpdateMessage : g) {
                if (str.equals(String.valueOf(groupUpdateMessage.getGroupId()))) {
                    str3 = groupUpdateMessage.getName();
                }
            }
            str2 = str3;
        }
        validateItemData.setGroupName(str2);
    }
}
