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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class ag {
    public int aEB;

    public ag(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
    }

    private void IX(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = com.baidu.tbadk.core.util.be.getParamPair(str);
        if (paramPair != null) {
            this.aEB = 5;
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10320");
            aqVar.dD("obj_locate", paramPair.get("obj_locate"));
            aqVar.ai("obj_type", 1);
            aqVar.dD("tid", paramPair.get("tid"));
            aqVar.dD("obj_source", paramPair.get("obj_source"));
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            aqVar.ai(TiebaInitialize.Params.OBJ_TO, 3);
            aqVar.dD("obj_id", paramPair.get("bdid"));
            if (!com.baidu.tbadk.core.util.at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        aqVar.dD(next, jSONObject.getString(next));
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
                    IX(decode);
                    HashMap<String, Object> NE = NE(decode);
                    String str = (String) NE.get("tid");
                    if ("mpush".equals((String) NE.get("fr")) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11895").dD("tid", str));
                    }
                    HttpMessage httpMessage = new HttpMessage(1003393);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aVar.z(NE);
                }
            }
        }
    }

    public HashMap<String, Object> NE(String str) {
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
