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
    public int azq;

    public ag(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
    }

    private void Gv(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = com.baidu.tbadk.core.util.bd.getParamPair(str);
        if (paramPair != null) {
            this.azq = 5;
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c10320");
            apVar.dn("obj_locate", paramPair.get("obj_locate"));
            apVar.ah("obj_type", 1);
            apVar.dn("tid", paramPair.get("tid"));
            apVar.dn("obj_source", paramPair.get("obj_source"));
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            apVar.ah(TiebaInitialize.Params.OBJ_TO, 3);
            apVar.dn("obj_id", paramPair.get("bdid"));
            if (!com.baidu.tbadk.core.util.as.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        apVar.dn(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(apVar);
        }
    }

    public void a(Intent intent, f.a aVar) {
        if (intent != null && intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (!StringUtils.isNull(uri2) && uri2.startsWith("tbpb://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Gv(decode);
                    HashMap<String, Object> KL = KL(decode);
                    String str = (String) KL.get("tid");
                    if ("mpush".equals((String) KL.get("fr")) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11895").dn("tid", str));
                    }
                    HttpMessage httpMessage = new HttpMessage(1003393);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aVar.B(KL);
                }
            }
        }
    }

    public HashMap<String, Object> KL(String str) {
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
