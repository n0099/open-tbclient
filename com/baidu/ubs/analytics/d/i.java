package com.baidu.ubs.analytics.d;

import com.baidu.android.common.util.DeviceId;
import com.baidu.ubs.analytics.SampleResult;
/* loaded from: classes3.dex */
public final class i {
    public static SampleResult Ht(String str) {
        if (str == null || str.equals("")) {
            return SampleResult.OTHERE;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 79:
                if (str.equals(DeviceId.CUIDInfo.I_FIXED)) {
                    c = '\b';
                    break;
                }
                break;
            case 2126:
                if (str.equals("C1")) {
                    c = 5;
                    break;
                }
                break;
            case 2127:
                if (str.equals("C2")) {
                    c = 6;
                    break;
                }
                break;
            case 2128:
                if (str.equals("C3")) {
                    c = 7;
                    break;
                }
                break;
            case 2653:
                if (str.equals("T1")) {
                    c = 0;
                    break;
                }
                break;
            case 2654:
                if (str.equals("T2")) {
                    c = 1;
                    break;
                }
                break;
            case 2655:
                if (str.equals("T3")) {
                    c = 2;
                    break;
                }
                break;
            case 2656:
                if (str.equals("T4")) {
                    c = 3;
                    break;
                }
                break;
            case 2657:
                if (str.equals("T5")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SampleResult.T1;
            case 1:
                return SampleResult.T2;
            case 2:
                return SampleResult.T3;
            case 3:
                return SampleResult.T4;
            case 4:
                return SampleResult.T5;
            case 5:
                return SampleResult.C1;
            case 6:
                return SampleResult.C2;
            case 7:
                return SampleResult.C3;
            case '\b':
                return SampleResult.OTHERE;
            default:
                return SampleResult.OTHERE;
        }
    }
}
