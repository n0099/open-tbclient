package com.baidu.tieba.myCollection.baseHistory;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.mvc.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements f {
    private String threadId = "";
    private String threadName = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String postID = "";
    private boolean isHostOnly = false;
    private boolean isSquence = false;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return (this.threadId == null || bVar.threadId == null || !this.threadId.equals(bVar.threadId)) ? false : true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        if (TextUtils.isEmpty(this.threadId)) {
            hashCode = 120;
        } else {
            hashCode = this.threadId.hashCode() + 119;
        }
        if (TextUtils.isEmpty(this.threadName)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.threadName.hashCode();
        }
        if (TextUtils.isEmpty(this.forumName)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.time);
        if (TextUtils.isEmpty(this.postID)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.postID.hashCode();
        }
        return (((this.isHostOnly ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.isSquence ? 1 : 0);
    }

    public boolean j(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.postID = jSONObject.optString("post_id");
            this.isHostOnly = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.isSquence = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            if (!TextUtils.isEmpty(string)) {
                this.forumName = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.threadId = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.threadName = string3;
            }
            if (j > 2000) {
                this.time = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject ZN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.threadName);
            jSONObject.put("post_id", this.postID);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.isHostOnly);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.isSquence);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String ZO() {
        return this.threadName;
    }

    public String getForumName() {
        return this.forumName;
    }

    public long getTime() {
        return this.time;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void id(String str) {
        this.threadName = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String ZP() {
        return this.postID;
    }

    public void ie(String str) {
        this.postID = str;
    }

    public boolean ZQ() {
        return this.isHostOnly;
    }

    public void dK(boolean z) {
        this.isHostOnly = z;
    }

    public boolean ZR() {
        return this.isSquence;
    }

    public void dL(boolean z) {
        this.isSquence = z;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String Bq() {
        return ZN().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean eS(String str) {
        if (str != null) {
            try {
                return j(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
