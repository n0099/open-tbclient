package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class TiebaIMActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001275", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2002006", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001289", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001290", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001286", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001298", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2012110", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2003004", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001306", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("2001299", "com.baidu.tieba.im.TiebaIMActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.im.TiebaIMActivityStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("GroupChatActivityConfig");
        arrayList.add("OfficialMsgImageActivityConfig");
        arrayList.add("OfficialBarHistoryActivityConfig");
        arrayList.add("OfficialHistoryImageActivityConfig");
        arrayList.add("PersonGroupActivityConfig");
        arrayList.add("ForumDetailActivityConfig");
        arrayList.add("RecommendDetailActivityConfig");
        arrayList.add("OfficialBarFeedActivityConfig");
        arrayList.add(UrlSchemaHelper.GOTO_OFFICIAL_CHAT);
        arrayList.add("middlepage");
        hashMap.put("com.baidu.tieba.im.TiebaIMActivityStatic", arrayList);
        return hashMap;
    }
}
