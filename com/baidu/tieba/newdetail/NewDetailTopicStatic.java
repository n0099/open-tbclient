package com.baidu.tieba.newdetail;

import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
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
import com.baidu.tieba.rx9;
import com.baidu.tieba.tg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NewDetailTopicStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null && tbPageContext != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    if (lowerCase.contains(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL)) {
                        Uri parse = Uri.parse(lowerCase);
                        if (!parse.isHierarchical()) {
                            return 3;
                        }
                        String queryParameter = parse.getQueryParameter("topic_id");
                        if (StringUtils.isNull(queryParameter)) {
                            return 3;
                        }
                        TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(tbPageContext.getPageActivity(), tg.g(queryParameter, 0L));
                        topicDetailActivityConfig.setIsFromYunPush(lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH));
                        tbPageContext.sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
                        return 1;
                    } else if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        try {
                            Intent parseUri = Intent.parseUri(lowerCase, 1);
                            parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                            if (tbPageContext.getPageActivity() != null) {
                                tbPageContext.getPageActivity().startActivity(parseUri);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return 1;
                    } else if (lowerCase.contains("unidispatch/topicdetail")) {
                        TopicDetailActivityConfig topicDetailActivityConfig2 = new TopicDetailActivityConfig(tbPageContext.getPageActivity());
                        topicDetailActivityConfig2.setUri(Uri.parse(lowerCase));
                        tbPageContext.sendMessage(new CustomMessage(2002001, topicDetailActivityConfig2));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1806608701, "Lcom/baidu/tieba/newdetail/NewDetailTopicStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1806608701, "Lcom/baidu/tieba/newdetail/NewDetailTopicStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(TopicDetailActivityConfig.class, HotTopicDetailActivity.class);
        d();
        b();
        c();
        a();
    }

    public NewDetailTopicStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            rx9.h(309085, BlessSocketResponseMessage.class, false, false);
            rx9.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            rx9.h(303050, ResponseSocketHotTopicMessage.class, false, false);
            rx9.c(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            rx9.h(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
            rx9.c(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            UrlManager.getInstance().addListener(new a());
        }
    }
}
