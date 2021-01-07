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
    private boolean ntR;
    private boolean ntS;
    private int mStatus = -1;
    private boolean ntT = true;

    public String cxb() {
        return this.mMethodName;
    }

    public void Tr(String str) {
        this.mMethodName = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                Tt(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                return;
            case 101:
                Tt(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
                return;
            case 201:
                Tt(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
                return;
            case 202:
                Tt(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
                return;
            case 301:
                Tt(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
                return;
            default:
                return;
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void Ts(String str) {
        Tt(str);
        KZ(401);
    }

    public void dPI() {
        Tt(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        KZ(401);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void KZ(int i) {
        if (this.mStatus == -1) {
            setStatus(i);
        }
    }

    public void Tt(String str) {
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

    public boolean dPJ() {
        return this.ntR;
    }

    public void yj(boolean z) {
        this.ntR = z;
    }

    public boolean dPK() {
        return this.ntS;
    }

    public void yk(boolean z) {
        this.ntS = z;
    }

    public boolean dPL() {
        return this.ntT;
    }

    public void yl(boolean z) {
        this.ntT = z;
    }

    public boolean isError() {
        return this.mStatus > 0;
    }

    public boolean dPM() {
        return this.mStatus != -1;
    }

    public String dPN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.mStatus);
            jSONObject.put("message", this.mMessage);
            if (at.Cc(this.mData)) {
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
