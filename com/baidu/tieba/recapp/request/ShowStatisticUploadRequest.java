package com.baidu.tieba.recapp.request;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.a.h;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShowStatisticUploadRequest extends HttpMessage {
    private static final TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD, "https://als.baidu.com/flog/logFeed");

    public ShowStatisticUploadRequest(boolean z) {
        super(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD);
        addParam("productId", "2");
        addParam("da_type", z ? "2" : "3");
        addParam("_os_version", Build.VERSION.RELEASE);
        String netType = h.getNetType();
        if (netType != null) {
            addParam(ETAG.KEY_NET_TYPE, netType);
        }
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        task.setUrl((adAdSense == null || adAdSense.Gt()) ? "https://als.baidu.com/flog/logFeed" : "http://als.baidu.com/flog/logFeed");
    }

    ShowStatisticUploadRequest init(int i, String str, String str2, String str3) {
        addParam("da_page", i == 1 ? "FRS" : "PB");
        addParam("da_menu1", str);
        addParam("da_menu2", str2);
        addParam("ext_info", str3);
        return this;
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(1, str, str2, str4);
        init.addParam(ImageViewerConfig.FORUM_ID, str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (a.b bVar : list) {
                if (bVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", bVar.biz);
                        jSONObject.put("locate", bVar.daz);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
            }
            init.addParam("infos", jSONArray.toString());
        }
        MessageManager.getInstance().sendMessage(init, task);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(2, str, str2, str5);
        init.addParam(ImageViewerConfig.FORUM_ID, str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (a.b bVar : list) {
                if (bVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Info.kBaiduPIDKey, bVar.mPid);
                        jSONObject.put("tid", str4);
                        jSONObject.put("locate", bVar.daz);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
            }
            init.addParam("infos", jSONArray.toString());
        }
        MessageManager.getInstance().sendMessage(init, task);
    }

    static {
        task.setResponsedClass(ResponseMessage.class);
        task.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(true);
    }

    /* loaded from: classes3.dex */
    private static final class ResponseMessage extends HttpResponsedMessage {
        public ResponseMessage(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
