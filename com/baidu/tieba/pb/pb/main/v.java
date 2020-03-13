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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class v {
    public int Yv;

    public v(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
    }

    private void BO(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            this.Yv = 5;
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c10320");
            anVar.cy("obj_locate", paramPair.get("obj_locate"));
            anVar.X("obj_type", 1);
            anVar.cy("tid", paramPair.get("tid"));
            anVar.cy("obj_source", paramPair.get("obj_source"));
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.X(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.cy("obj_id", paramPair.get("bdid"));
            if (!com.baidu.tbadk.core.util.aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.cy(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public void a(Intent intent, f.a aVar) {
        if (intent != null && intent.getParcelableExtra("key_uri") != null) {
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            String uri2 = uri.toString();
            if (!StringUtils.isNull(uri2) && uri2.startsWith("tbpb://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    BO(decode);
                    HashMap<String, Object> Ga = Ga(decode);
                    String str = (String) Ga.get("tid");
                    if ("mpush".equals((String) Ga.get("fr")) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11895").cy("tid", str));
                    }
                    HttpMessage httpMessage = new HttpMessage(1003393);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aVar.n(Ga);
                }
            }
        }
    }

    public HashMap<String, Object> Ga(String str) {
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
