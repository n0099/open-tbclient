package com.baidu.tieba.recapp.report;

import android.os.Build;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class AdUploadHttpRequest extends HttpMessage {
    private static final String KEY_AD = "ad";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_OS_VERSION = "_os_version";
    private ArrayList<a> dataArray;

    public AdUploadHttpRequest(ArrayList<a> arrayList) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        this.dataArray = new ArrayList<>();
        this.dataArray.addAll(arrayList);
        addParam(KEY_AD, toJSONString(this.dataArray));
        addParam(KEY_BRAND, Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
    }

    public AdUploadHttpRequest(a aVar) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        this.dataArray = new ArrayList<>();
        this.dataArray.add(aVar);
        addParam(KEY_AD, toJSONString(this.dataArray));
        addParam(KEY_BRAND, Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
    }

    public ArrayList<a> getDataArray() {
        return this.dataArray;
    }

    private String toJSONString(ArrayList<a> arrayList) {
        if (u.l(arrayList) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                jSONArray.put(next.apB());
            }
        }
        return jSONArray.toString();
    }
}
