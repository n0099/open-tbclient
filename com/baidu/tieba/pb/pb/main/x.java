package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x {
    public int fJz;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void nI(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> fh = ay.fh(str);
        if (fh != null) {
            this.fJz = 5;
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c10320");
            amVar.al("obj_locate", fh.get("obj_locate"));
            amVar.w("obj_type", 1);
            amVar.al("tid", fh.get("tid"));
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fh.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            amVar.al("obj_param2", fh.get("obj_param2"));
            amVar.w("obj_to", 3);
            amVar.al(VideoPlayActivityConfig.OBJ_ID, fh.get("bdid"));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(fh.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(fh.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        amVar.al(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    public String U(Intent intent) {
        int length;
        String str = null;
        if (intent != null && intent.getData() != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Matcher matcher = Pattern.compile(".*fr=(.*)&tid=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        if ("mpush".equals(matcher.group(1))) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11895").al("tid", matcher.group(2)));
                        } else {
                            nI(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        nI(decode);
                        int indexOf = decode.indexOf("tid=");
                        if (indexOf >= 0 && (length = indexOf + "tid=".length()) <= decode.length()) {
                            str = decode.substring(length);
                        }
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                    httpMessage.addParam("call_url", dataString);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        }
        return str;
    }
}
