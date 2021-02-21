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
    private boolean nzw;
    private boolean nzx;
    private int mStatus = -1;
    private boolean nzy = true;

    public String cuC() {
        return this.mMethodName;
    }

    public void Tt(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                Tv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                Tv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                Tv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                Tv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                Tv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void Tu(String str) {
        Tv(str);
        JM(401);
    }

    public void dOj() {
        Tv(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        JM(401);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void JM(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void Tv(String str) {
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

    public boolean dOk() {
        return this.nzw;
    }

    public void yy(boolean z) {
        this.nzw = z;
    }

    public boolean dOl() {
        return this.nzx;
    }

    public void yz(boolean z) {
        this.nzx = z;
    }

    public boolean dOm() {
        return this.nzy;
    }

    public void yA(boolean z) {
        this.nzy = z;
    }

    public boolean isError() {
        return this.mStatus > 0;
    }

    public boolean dOn() {
        return this.mStatus != -1;
    }

    public String dOo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (au.Bi(this.mData)) {
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
