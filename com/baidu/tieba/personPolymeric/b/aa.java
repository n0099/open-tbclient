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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aa {
    public static String g(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return null;
        }
        if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
            return "http://himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    public static void a(com.baidu.tbadk.data.j jVar, BdUniqueId bdUniqueId) {
        if (jVar != null && !StringUtils.isNull(jVar.BU()) && com.baidu.tbadk.core.util.x.r(MessageManager.getInstance().findMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT, bdUniqueId))) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", jVar.BU());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tbadk.data.j jVar2;
        if (jVar != null && !com.baidu.tbadk.core.util.x.r(list) && !StringUtils.isNull(jVar.BU())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = list.get(i);
                if ((vVar instanceof com.baidu.tbadk.data.j) && (jVar2 = (com.baidu.tbadk.data.j) vVar) != jVar && !jVar2.BV()) {
                    jSONArray.put(jVar2.BU());
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

    public static void j(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (!StringUtils.isNull(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = list.get(i);
                if (vVar instanceof com.baidu.tbadk.data.j) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) vVar;
                    if (!jVar.BV()) {
                        jSONArray.put(jVar.BU());
                    }
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void z(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(tbPageContext.getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }
}
