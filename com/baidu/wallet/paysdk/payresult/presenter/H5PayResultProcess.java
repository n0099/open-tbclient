package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class H5PayResultProcess {
    public Context mContext;
    public H5ResultParams mH5;
    public String mQueryResultString;

    public static String getProcessedParams(List<RestNameValuePair> list, String str) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String processedParams = new RestUrlConnectionRequest(null, null, null, list, null, str).getProcessedParams();
        if (processedParams != null) {
            try {
                return URLEncoder.encode(processedParams, str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return processedParams;
            }
        }
        return processedParams;
    }

    public abstract void afterShow();

    public abstract void beforeShow();

    public abstract void show();
}
