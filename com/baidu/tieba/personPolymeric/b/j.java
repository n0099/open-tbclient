package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes24.dex */
public class j {
    public static String g(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return null;
        }
        if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
            return "http://tb.himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://tb.himg.baidu.com/sys/portraitl/item/" + str;
    }

    public static void a(o oVar, BdUniqueId bdUniqueId) {
        if (oVar != null && !StringUtils.isNull(oVar.bBN()) && y.isEmpty(MessageManager.getInstance().findMessage(1003063, bdUniqueId))) {
            HttpMessage httpMessage = new HttpMessage(1003063);
            httpMessage.addParam("pic_url", oVar.bBN());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(o oVar, List<q> list) {
        o oVar2;
        if (oVar != null && !y.isEmpty(list) && !StringUtils.isNull(oVar.bBN())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                q qVar = list.get(i);
                if ((qVar instanceof o) && (oVar2 = (o) qVar) != oVar && !oVar2.bBO()) {
                    jSONArray.put(oVar2.bBN());
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

    public static void p(String str, List<q> list) {
        if (!StringUtils.isNull(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                q qVar = list.get(i);
                if (qVar instanceof o) {
                    o oVar = (o) qVar;
                    if (!oVar.bBO()) {
                        jSONArray.put(oVar.bBN());
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
