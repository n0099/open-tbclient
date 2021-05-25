package com.baidu.tieba.recapp.request;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.a.m0.s.c.d;
import d.a.n0.e3.j0.a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ShowStatisticUploadRequest extends HttpMessage {
    public static final TbHttpMessageTask task;

    /* loaded from: classes5.dex */
    public static final class ResponseMessage extends HttpResponsedMessage {
        public ResponseMessage(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        }
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD, "https://als.baidu.com/flog/logFeed");
        task = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(ResponseMessage.class);
        task.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(true);
    }

    public ShowStatisticUploadRequest(boolean z) {
        super(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD);
        addParam("productId", "2");
        addParam("da_type", z ? "2" : "3");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        String netType = NetWorkUtil.getNetType();
        if (netType != null) {
            addParam("net_type", netType);
        }
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        task.setUrl((adAdSense == null || adAdSense.e()) ? "https://als.baidu.com/flog/logFeed" : "http://als.baidu.com/flog/logFeed");
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(1, str, str2, str4);
        init.addParam("fid", str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (a.c cVar : list) {
                if (cVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", cVar.f54074a);
                        jSONObject.put("locate", cVar.f54076c);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                }
            }
            init.addParam("infos", jSONArray.toString());
        }
        MessageManager.getInstance().sendMessage(init, task);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(2, str, str2, str5);
        init.addParam("fid", str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (a.c cVar : list) {
                if (cVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("pid", cVar.f54075b);
                        jSONObject.put("tid", str4);
                        jSONObject.put("locate", cVar.f54076c);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                }
            }
            init.addParam("infos", jSONArray.toString());
        }
        MessageManager.getInstance().sendMessage(init, task);
    }

    public ShowStatisticUploadRequest init(int i2, String str, String str2, String str3) {
        addParam("da_page", i2 == 1 ? "FRS" : "PB");
        addParam("da_menu1", str);
        addParam("da_menu2", str2);
        addParam("ext_info", str3);
        return this;
    }
}
