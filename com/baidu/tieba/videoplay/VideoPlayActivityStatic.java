package com.baidu.tieba.videoplay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mainTab.videoRedIcon.VideoRedIconHttpResponse;
import com.baidu.tbadk.mainTab.videoRedIcon.VideoRedIconSocketResponse;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.il9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes6.dex */
public class VideoPlayActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2002654589, "Lcom/baidu/tieba/videoplay/VideoPlayActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2002654589, "Lcom/baidu/tieba/videoplay/VideoPlayActivityStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(VideoPlayActivityConfig.class, VideoPlayActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoRecommentPlayActivityConfig.class, VideoRecommentPlayActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsVideoTabPlayActivityConfig.class, FrsVideoTabPlayActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_NANI_VIDEO, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask.setResponsedClass(ResponseGetNaniVideoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        b();
    }

    public VideoPlayActivityStatic() {
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

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            il9.d(CmdConfigHttp.CMD_VIDEO_TAB_RED_ICON, 309708, "c/f/video/redIcon", VideoRedIconHttpResponse.class, VideoRedIconSocketResponse.class);
            il9.e(CmdConfigHttp.CMD_POST_VIDEO_MARK_RED_ICON, "c/c/video/markRedIcon", TbHttpResponsedMessage.class, true, false, true, true);
        }
    }

    public static void a(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, redIcon) != null) || redIcon == null) {
            return;
        }
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_VIDEO_MARK_RED_ICON);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 2);
            JSONArray jSONArray = new JSONArray();
            for (ThreadInfo threadInfo : redIcon.thread_list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tid", threadInfo.tid);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("thread_list", jSONArray);
            httpMessage.addParam("source_red_icon", jSONObject.toString());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
