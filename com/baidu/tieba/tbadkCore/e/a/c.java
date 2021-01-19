package com.baidu.tieba.tbadkCore.e.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String mData;
    private String mMessage;
    private String mMethodName;
    private boolean npn;
    private boolean npo;
    private int mStatus = -1;
    private boolean npp = true;

    public String ctj() {
        return this.mMethodName;
    }

    public void Sk(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                Sm(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                Sm(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                Sm(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                Sm(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                Sm(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void Sl(String str) {
        Sm(str);
        Js(401);
    }

    public void dLQ() {
        Sm(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        Js(401);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void Js(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void Sm(String str) {
        if (at.isEmpty(this.mMessage)) {
            this.mMessage = str;
        }
    }

    public String getData() {
        return this.mData;
    }

    public void setData(String str) {
        this.mData = str;
    }

    public boolean dLR() {
        return this.npn;
    }

    public void yf(boolean z) {
        this.npn = z;
    }

    public boolean dLS() {
        return this.npo;
    }

    public void yg(boolean z) {
        this.npo = z;
    }

    public boolean dLT() {
        return this.npp;
    }

    public void yh(boolean z) {
        this.npp = z;
    }

    public boolean isError() {
        return this.mStatus > 0;
    }

    public boolean dLU() {
        return this.mStatus != -1;
    }

    public String dLV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (at.AR(this.mData)) {
                jSONObject.put("data", new JSONObject(this.mData));
            } else if (at.isJSONArray(this.mData)) {
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
