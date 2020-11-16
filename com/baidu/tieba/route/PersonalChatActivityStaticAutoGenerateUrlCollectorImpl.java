package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public final class PersonalChatActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PersonalMsgImageActivityConfig");
        arrayList.add("MessageCenterActivityConfig");
        arrayList.add("AtMessageActivityConfig");
        arrayList.add("AtMessageActivityConfig");
        arrayList.add("InviteFriendListActivityConfig");
        arrayList.add("PersonalTalkSettingActivityConfig");
        arrayList.add("SelectFriendActivityConfig");
        arrayList.add("StrangerListActivityConfig");
        arrayList.add("AddFriendActivityConfig");
        arrayList.add("ReplyMeActivityConfig");
        arrayList.add("OfficialNotificationActivityConfig");
        arrayList.add(UrlSchemaHelper.GOTO_PERSONAL_CHAT);
        arrayList.add(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT);
        hashMap.put("com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2002005", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2001011", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2001275", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2005016", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2008001", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2005016", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2001143", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2001146", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("2001149", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
        return hashMap;
    }
}
