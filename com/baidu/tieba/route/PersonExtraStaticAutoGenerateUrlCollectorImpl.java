package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class PersonExtraStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.personExtra.PersonExtraStatic");
        hashMap.put("2002003", "com.baidu.tieba.personExtra.PersonExtraStatic");
        hashMap.put("3001000", "com.baidu.tieba.personExtra.PersonExtraStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("EditHeadActivityConfig");
        arrayList.add("PersonMoreActivityConfig");
        arrayList.add("PersonFriendActivityConfig");
        arrayList.add("PersonBarActivityConfig");
        arrayList.add("PersonImageActivityConfig");
        arrayList.add("PersonChangeActivityConfig");
        arrayList.add("EditNickNameActivityConfig");
        arrayList.add("EditNickNameActivityConfig");
        arrayList.add("SmartAppBrowseHistoryActivityConfig");
        arrayList.add("PersonPolymericActivityConfig");
        arrayList.add("PersonPostActivityConfig");
        arrayList.add(UrlSchemaHelper.GOTO_PERSON_INFO);
        arrayList.add(UrlSchemaHelper.OPEN_PERSON_INFO);
        arrayList.add(UrlSchemaHelper.JUMP_TO_MODIFY_NICKNAME);
        arrayList.add(UrlSchemaHelper.JUMP_TO_POST_LIST);
        hashMap.put("com.baidu.tieba.personExtra.PersonExtraStatic", arrayList);
        return hashMap;
    }
}
