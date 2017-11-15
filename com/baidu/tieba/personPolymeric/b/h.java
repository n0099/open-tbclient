package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class h {
    public static String g(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return null;
        }
        if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
            return "http://himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    public static void a(l lVar, BdUniqueId bdUniqueId) {
        if (lVar != null && !StringUtils.isNull(lVar.Cw()) && v.v(MessageManager.getInstance().findMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT, bdUniqueId))) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", lVar.Cw());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(l lVar, List<com.baidu.adp.widget.ListView.f> list) {
        l lVar2;
        if (lVar != null && !v.v(list) && !StringUtils.isNull(lVar.Cw())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = list.get(i);
                if ((fVar instanceof l) && (lVar2 = (l) fVar) != lVar && !lVar2.Cx()) {
                    jSONArray.put(lVar2.Cw());
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            if (jSONArray.length() <= 0) {
                httpMessage.addParam("truncat", 1);
            } else {
                httpMessage.addParam("truncat", 0);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void p(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (!StringUtils.isNull(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = list.get(i);
                if (fVar instanceof l) {
                    l lVar = (l) fVar;
                    if (!lVar.Cx()) {
                        jSONArray.put(lVar.Cw());
                    }
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void x(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(tbPageContext.getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }
}
