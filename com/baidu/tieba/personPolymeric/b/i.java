package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.m;
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

    public static void a(m mVar, BdUniqueId bdUniqueId) {
        if (mVar != null && !StringUtils.isNull(mVar.bcC()) && v.isEmpty(MessageManager.getInstance().findMessage(1003063, bdUniqueId))) {
            HttpMessage httpMessage = new HttpMessage(1003063);
            httpMessage.addParam("pic_url", mVar.bcC());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(m mVar, List<o> list) {
        m mVar2;
        if (mVar != null && !v.isEmpty(list) && !StringUtils.isNull(mVar.bcC())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                o oVar = list.get(i);
                if ((oVar instanceof m) && (mVar2 = (m) oVar) != mVar && !mVar2.bcD()) {
                    jSONArray.put(mVar2.bcC());
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

    public static void q(String str, List<o> list) {
        if (!StringUtils.isNull(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                o oVar = list.get(i);
                if (oVar instanceof m) {
                    m mVar = (m) oVar;
                    if (!mVar.bcD()) {
                        jSONArray.put(mVar.bcC());
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
