package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {
    public int aHt;

    public z(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
    }

    private void Kw(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = be.getParamPair(str);
        if (paramPair != null) {
            this.aHt = 5;
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10320");
            aqVar.dW("obj_locate", paramPair.get("obj_locate"));
            aqVar.an("obj_type", 1);
            aqVar.dW("tid", paramPair.get("tid"));
            aqVar.dW("obj_source", paramPair.get("obj_source"));
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            aqVar.an(TiebaInitialize.Params.OBJ_TO, 3);
            aqVar.dW("obj_id", paramPair.get("bdid"));
            aqVar.an("obj_name", TbadkCoreApplication.getInst().getStartType());
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM3, 1);
            if (!com.baidu.tbadk.core.util.at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        aqVar.dW(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void a(Intent intent, f.a aVar) {
        if (intent != null && intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (!StringUtils.isNull(uri2) && uri2.startsWith("tbpb://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Kw(decode);
                    HashMap<String, Object> OL = OL(decode);
                    String str = (String) OL.get("tid");
                    if ("mpush".equals((String) OL.get("fr")) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11895").dW("tid", str));
                    }
                    HttpMessage httpMessage = new HttpMessage(1003393);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aVar.onCallBack(OL);
                }
            }
        }
    }

    public HashMap<String, Object> OL(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String[] split = str.split("[&]");
        if (split.length != 0) {
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return null;
    }
}
