package com.baidu.tieba.myCollection.baseHistory;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.mvc.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements f {
    private long cartoonId;
    private int chapterId;
    private String threadId = "";
    private String threadName = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String postID = "";
    private boolean isHostOnly = false;
    private boolean isSquence = false;
    private int threadType = 0;
    private boolean isManga = false;
    private String liveId = "";
    private String userName = "";
    private String description = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.threadType == 49) {
            if (this.liveId != null && aVar.liveId != null && this.liveId.equals(aVar.liveId)) {
                return true;
            }
        } else if (this.threadId != null && aVar.threadId != null && this.threadId.equals(aVar.threadId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
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
        if (TextUtils.isEmpty(this.liveId)) {
            hashCode5 = (hashCode4 * 7) + 1;
        } else {
            hashCode5 = (hashCode4 * 7) + this.liveId.hashCode();
        }
        if (TextUtils.isEmpty(this.description)) {
            hashCode6 = (hashCode5 * 7) + 1;
        } else {
            hashCode6 = (hashCode5 * 7) + this.description.hashCode();
        }
        return (((this.isHostOnly ? 1 : 0) + (hashCode6 * 7)) * 7) + (this.isSquence ? 1 : 0);
    }

    public boolean H(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.postID = jSONObject.optString("post_id");
            this.isHostOnly = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.isSquence = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            this.isManga = jSONObject.optBoolean("is_manga");
            this.cartoonId = jSONObject.optLong("cartoon_id");
            this.chapterId = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
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
            this.threadType = jSONObject.optInt("thread_type");
            this.liveId = jSONObject.optString("live_id", "");
            this.userName = jSONObject.optString("user_name", "");
            this.description = jSONObject.optString("live_description", "");
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject Zq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.threadName);
            jSONObject.put("post_id", this.postID);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.isHostOnly);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.isSquence);
            jSONObject.put("thread_type", this.threadType);
            jSONObject.put("is_manga", this.isManga);
            jSONObject.put("cartoon_id", this.cartoonId);
            jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.chapterId);
            jSONObject.put("live_id", this.liveId);
            jSONObject.put("user_name", this.userName);
            jSONObject.put("live_description", this.description);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean isManga() {
        return this.isManga;
    }

    public void setManga(boolean z) {
        this.isManga = z;
    }

    public long getCartoonId() {
        return this.cartoonId;
    }

    public void setCartoonId(long j) {
        this.cartoonId = j;
    }

    public int getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(int i) {
        this.chapterId = i;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String aOa() {
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

    public void oT(String str) {
        this.threadName = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String Dc() {
        return this.postID;
    }

    public void oU(String str) {
        this.postID = str;
    }

    public boolean aOb() {
        return this.isHostOnly;
    }

    public void ih(boolean z) {
        this.isHostOnly = z;
    }

    public boolean aOc() {
        return this.isSquence;
    }

    public void ii(boolean z) {
        this.isSquence = z;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public void oV(String str) {
        this.liveId = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.threadType == 49 ? this.liveId + "_ala" : this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String EL() {
        return Zq().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean gA(String str) {
        if (str != null) {
            try {
                return H(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
