package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private String mData;
    private String mMessage;
    private String mMethodName;
    private boolean naf;
    private boolean nag;
    private int mStatus = -1;
    private boolean nah = true;

    public String getMethodName() {
        return this.mMethodName;
    }

    public void Su(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                Sv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                Sv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                Sv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                Sv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                Sv(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void Kn(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void Sv(String str) {
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

    public boolean dKt() {
        return this.naf;
    }

    public void xz(boolean z) {
        this.naf = z;
    }

    public boolean dKu() {
        return this.nag;
    }

    public void xA(boolean z) {
        this.nag = z;
    }

    public boolean dKv() {
        return this.nah;
    }

    public void xB(boolean z) {
        this.nah = z;
    }

    public boolean dKw() {
        return this.mStatus != -1;
    }

    public String dKx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (au.By(this.mData)) {
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
