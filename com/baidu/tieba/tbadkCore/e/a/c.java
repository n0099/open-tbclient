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
    private boolean noh;
    private boolean noi;
    private int mStatus = -1;
    private boolean noj = true;

    public String getMethodName() {
        return this.mMethodName;
    }

    public void TI(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                TK(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                TK(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                TK(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                TK(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                TK(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void TJ(String str) {
        TK(str);
        Ld(401);
    }

    public void dPL() {
        TK(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        Ld(401);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void Ld(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void TK(String str) {
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

    public boolean dPM() {
        return this.noh;
    }

    public void ye(boolean z) {
        this.noh = z;
    }

    public boolean dPN() {
        return this.noi;
    }

    public void yf(boolean z) {
        this.noi = z;
    }

    public boolean dPO() {
        return this.noj;
    }

    public void yg(boolean z) {
        this.noj = z;
    }

    public boolean isError() {
        return this.mStatus > 0;
    }

    public boolean dPP() {
        return this.mStatus != -1;
    }

    public String dPQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (au.Cf(this.mData)) {
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
