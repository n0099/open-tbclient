package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static void a(com.baidu.tieba.im.a<Boolean> aVar, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            com.baidu.tieba.im.e.a(new m(validateItemData), aVar);
        }
    }

    public static void ad(List<ValidateItemData> list) {
        if (list != null && !list.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ValidateItemData validateItemData = list.get(i);
                if (validateItemData != null && !validateItemData.isShown()) {
                    validateItemData.setShown(true);
                    linkedList.add(new GroupNewsPojo(validateItemData));
                }
            }
            new n(linkedList).execute(new Void[0]);
        }
    }

    public static void a(ValidateItemData validateItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (validateItemData != null) {
            com.baidu.tieba.im.e.a(new o(validateItemData), aVar);
        }
    }

    public static void a(int i, int i2, com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.e.a(new p(i, i2), aVar);
    }

    public static void d(com.baidu.tieba.im.a<Integer> aVar) {
        com.baidu.tieba.im.e.a(new q(), aVar);
    }

    public static List<ValidateItemData> o(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ValidateItemData g = g(it.next());
            if (g != null) {
                linkedList2.add(g);
            }
        }
        return linkedList2;
    }

    public static ValidateItemData g(GroupNewsPojo groupNewsPojo) {
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
                    validateItemData.setPortrait(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                    String optString = optJSONObject.optString("groupId");
                    validateItemData.setGroupId(optString);
                    a(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setInviterUserId(optJSONObject.optLong(ApplyJoinGroupActivityConfig.INVITE_USER_ID));
                    validateItemData.setJoinType(optJSONObject.optInt(ApplyJoinGroupActivityConfig.JOIN_TYPE));
                    validateItemData.setExt(groupNewsPojo.getExt());
                }
            } else {
                validateItemData = (ValidateItemData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(content, ValidateItemData.class);
                a(validateItemData, validateItemData.getGroupId());
            }
            return validateItemData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(ValidateItemData validateItemData, String str) {
        if (!BdBaseApplication.getInst().isDebugMode() || com.baidu.adp.lib.util.m.fu()) {
            String str2 = "";
            ImMessageCenterPojo B = com.baidu.tieba.im.memorycache.c.PK().B(str, 1);
            if (B != null) {
                str2 = B.getGroup_name();
            }
            validateItemData.setGroupName(str2);
        }
    }
}
