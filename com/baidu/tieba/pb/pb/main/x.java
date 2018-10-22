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
/* loaded from: classes6.dex */
public class x {
    public int fRb;

    public x(PbModel pbModel, BaseActivity baseActivity) {
    }

    private void ol(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> fv = ay.fv(str);
        if (fv != null) {
            this.fRb = 5;
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c10320");
            amVar.ax("obj_locate", fv.get("obj_locate"));
            amVar.x("obj_type", 1);
            amVar.ax("tid", fv.get("tid"));
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fv.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
            amVar.ax("obj_param2", fv.get("obj_param2"));
            amVar.x("obj_to", 3);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, fv.get("bdid"));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(fv.get("ext_log"))) {
                try {
                    JSONObject jSONObject = new JSONObject(fv.get("ext_log"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        amVar.ax(next, jSONObject.getString(next));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    public String Y(Intent intent) {
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11895").ax("tid", matcher.group(2)));
                        } else {
                            ol(decode);
                        }
                        str = matcher.group(2);
                    } else {
                        ol(decode);
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
