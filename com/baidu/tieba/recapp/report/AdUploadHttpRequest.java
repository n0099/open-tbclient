package com.baidu.tieba.recapp.report;

import android.os.Build;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import d.b.b.e.p.j;
import d.b.i0.r2.b0.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class AdUploadHttpRequest extends HttpMessage {
    public static final String KEY_AD = "ad";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_NET_TYPE = "net_type";
    public static final String KEY_OS_TYPE = "_os_type";
    public static final String KEY_OS_VERSION = "_os_version";
    public static final String KEY_PRODUCT_ID = "productId";
    public ArrayList<c> dataArray;

    public AdUploadHttpRequest(ArrayList<c> arrayList) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        ArrayList<c> arrayList2 = new ArrayList<>();
        this.dataArray = arrayList2;
        arrayList2.addAll(arrayList);
        addParam("ad", toJSONString(this.dataArray));
        addParam("brand", Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
        addParam("productId", 2);
        addParam("net_type", j.I());
        addParam(KEY_OS_TYPE, 2);
    }

    private String toJSONString(ArrayList<c> arrayList) {
        if (ListUtils.getCount(arrayList) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                jSONArray.put(next.b());
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<c> getDataArray() {
        return this.dataArray;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpMessage, com.baidu.adp.framework.message.Message
    public synchronized List<Map.Entry<String, Object>> encodeInBackGround() {
        removeParam(HttpRequest.PHONE_IMEI);
        return super.encodeInBackGround();
    }

    public AdUploadHttpRequest(c cVar) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        ArrayList<c> arrayList = new ArrayList<>();
        this.dataArray = arrayList;
        arrayList.add(cVar);
        addParam("ad", toJSONString(this.dataArray));
        addParam("brand", Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
    }
}
