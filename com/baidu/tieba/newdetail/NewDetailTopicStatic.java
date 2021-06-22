package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import d.a.c.e.m.b;
/* loaded from: classes5.dex */
public class NewDetailTopicStatic {

    /* loaded from: classes5.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null) {
                return 3;
            }
            String lowerCase = strArr[0].toLowerCase();
            if (!lowerCase.startsWith(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL) && !lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL)) {
                if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    try {
                        Intent parseUri = Intent.parseUri(lowerCase, 1);
                        parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        if (tbPageContext.getPageActivity() != null) {
                            tbPageContext.getPageActivity().startActivity(parseUri);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 1;
                } else if (lowerCase.contains("unidispatch/topicdetail")) {
                    TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(tbPageContext.getPageActivity());
                    topicDetailActivityConfig.setUri(Uri.parse(lowerCase));
                    tbPageContext.sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
                    return 0;
                } else {
                    return 3;
                }
            }
            Uri parse = Uri.parse(lowerCase);
            if (parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("topic_id");
                if (StringUtils.isNull(queryParameter)) {
                    return 3;
                }
                TopicDetailActivityConfig topicDetailActivityConfig2 = new TopicDetailActivityConfig(tbPageContext.getPageActivity(), b.f(queryParameter, 0L));
                topicDetailActivityConfig2.setIsFromYunPush(lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH));
                tbPageContext.sendMessage(new CustomMessage(2002001, topicDetailActivityConfig2));
                return 1;
            }
            return 3;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(TopicDetailActivityConfig.class, HotTopicDetailActivity.class);
        d();
        b();
        c();
        a();
    }

    public static void a() {
        d.a.o0.e3.d0.a.h(309085, BlessSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }

    public static void b() {
        d.a.o0.e3.d0.a.h(303050, ResponseSocketHotTopicMessage.class, false, false);
        d.a.o0.e3.d0.a.c(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
    }

    public static void c() {
        d.a.o0.e3.d0.a.h(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
    }

    public static void d() {
        UrlManager.getInstance().addListener(new a());
    }
}
