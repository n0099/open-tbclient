package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes15.dex */
public class NewDetailTopicStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(TopicDetailActivityConfig.class, HotTopicDetailActivity.class);
        cSy();
        czK();
        czL();
        czM();
    }

    private static void czK() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC, ResponseSocketHotTopicMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC, 1003041, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
    }

    private static void czL() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_RELATE_THREAD, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_RELATE_THREAD, 1003042, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
    }

    private static void czM() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, BlessSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, 1003065, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }

    private static void cSy() {
        be.bju().a(new be.a() { // from class: com.baidu.tieba.newdetail.NewDetailTopicStatic.1
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.startsWith("http://tieba.baidu.com/mo/q/newtopic/detail") || lowerCase.startsWith("https://tieba.baidu.com/mo/q/newtopic/detail")) {
                    Uri parse = Uri.parse(lowerCase);
                    if (parse.isHierarchical()) {
                        String queryParameter = parse.getQueryParameter("topic_id");
                        if (StringUtils.isNull(queryParameter)) {
                            return 3;
                        }
                        TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(queryParameter, 0L));
                        topicDetailActivityConfig.setIsFromYunPush(lowerCase.contains("&from_yunpush=1"));
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, topicDetailActivityConfig));
                        return 1;
                    }
                    return 3;
                } else if (lowerCase.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        Intent parseUri = Intent.parseUri(lowerCase, 1);
                        parseUri.setFlags(268435456);
                        if (tbPageContext.getPageActivity() != null) {
                            tbPageContext.getPageActivity().startActivity(parseUri);
                            return 1;
                        }
                        return 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 1;
                    }
                } else if (lowerCase.contains("unidispatch/topicdetail")) {
                    TopicDetailActivityConfig topicDetailActivityConfig2 = new TopicDetailActivityConfig(tbPageContext.getPageActivity());
                    topicDetailActivityConfig2.setUri(Uri.parse(lowerCase));
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, topicDetailActivityConfig2));
                    return 0;
                } else {
                    return 3;
                }
            }
        });
    }
}
