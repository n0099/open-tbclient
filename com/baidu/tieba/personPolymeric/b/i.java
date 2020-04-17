package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class i {
    public static String e(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return null;
        }
        if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
            return "http://tb.himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://tb.himg.baidu.com/sys/portraitl/item/" + str;
    }

    public static void a(l lVar, BdUniqueId bdUniqueId) {
        if (lVar != null && !StringUtils.isNull(lVar.aWv()) && v.isEmpty(MessageManager.getInstance().findMessage(1003063, bdUniqueId))) {
            HttpMessage httpMessage = new HttpMessage(1003063);
            httpMessage.addParam("pic_url", lVar.aWv());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(l lVar, List<m> list) {
        l lVar2;
        if (lVar != null && !v.isEmpty(list) && !StringUtils.isNull(lVar.aWv())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m mVar = list.get(i);
                if ((mVar instanceof l) && (lVar2 = (l) mVar) != lVar && !lVar2.aWw()) {
                    jSONArray.put(lVar2.aWv());
                }
            }
            HttpMessage httpMessage = new HttpMessage(1003064);
            httpMessage.addParam("pic_list", jSONArray.toString());
            if (jSONArray.length() <= 0) {
                httpMessage.addParam("truncat", 1);
            } else {
                httpMessage.addParam("truncat", 0);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void q(String str, List<m> list) {
        if (!StringUtils.isNull(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m mVar = list.get(i);
                if (mVar instanceof l) {
                    l lVar = (l) mVar;
                    if (!lVar.aWw()) {
                        jSONArray.put(lVar.aWv());
                    }
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(1003064);
            httpMessage.addParam("pic_list", jSONArray.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
