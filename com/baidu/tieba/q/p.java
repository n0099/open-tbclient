package com.baidu.tieba.q;

import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.ab;
/* loaded from: classes.dex */
public class p implements PerfSampleManager.IPerfSampleCallback {
    private static String UBC_BLOCK_ID = "2301";
    private static String ACTIVE_UPLOAD_TYPE = "1";
    private static String PASSIVE_UPLOAD_TYPE = "0";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        ab abVar = (ab) com.baidu.pyramid.runtime.service.c.a(ab.SERVICE_REFERENCE);
        if (abVar != null) {
            if (ACTIVE_UPLOAD_TYPE.equals(abVar.getUploadType(UBC_BLOCK_ID))) {
                return UBC_BLOCK_ID;
            }
        }
        return "";
    }
}
