package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String mData;
    private String mMessage;
    private String mMethodName;
    private boolean nBB;
    private boolean nBC;
    private int mStatus = -1;
    private boolean nBD = true;

    public String cuI() {
        return this.mMethodName;
    }

    public void TA(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                TC(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                TC(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                TC(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                TC(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                TC(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void TB(String str) {
        TC(str);
        JR(401);
    }

    public void dOs() {
        TC(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        JR(401);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void JR(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void TC(String str) {
        if (au.isEmpty(this.mMessage)) {
            this.mMessage = str;
        }
    }

    public String getData() {
        return this.mData;
    }

    public void setData(String str) {
        this.mData = str;
    }

    public boolean dOt() {
        return this.nBB;
    }

    public void yx(boolean z) {
        this.nBB = z;
    }

    public boolean dOu() {
        return this.nBC;
    }

    public void yy(boolean z) {
        this.nBC = z;
    }

    public boolean dOv() {
        return this.nBD;
    }

    public void yz(boolean z) {
        this.nBD = z;
    }

    public boolean isError() {
        return this.mStatus > 0;
    }

    public boolean dOw() {
        return this.mStatus != -1;
    }

    public String dOx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (au.Bp(this.mData)) {
                jSONObject.put("data", new JSONObject(this.mData));
            } else if (au.isJSONArray(this.mData)) {
                jSONObject.put("data", new JSONArray(this.mData));
            } else {
                jSONObject.put("data", this.mData);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return jSONObject.toString();
    }
}
