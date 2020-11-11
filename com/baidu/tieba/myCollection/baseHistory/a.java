package com.baidu.tieba.myCollection.baseHistory;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.mvc.b.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements f {
    private long cartoonId;
    private int chapterId;
    private boolean isShareThread;
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
    private boolean laS = true;

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

    public boolean eu(JSONObject jSONObject) {
        String optString = jSONObject.optString("forum_name");
        String optString2 = jSONObject.optString("thread_id");
        String optString3 = jSONObject.optString("thread_name");
        long optLong = jSONObject.optLong("thread_time");
        this.postID = jSONObject.optString("post_id");
        this.isHostOnly = jSONObject.optBoolean("host_only");
        this.isSquence = jSONObject.optBoolean("squence");
        this.isManga = jSONObject.optBoolean("is_manga");
        this.cartoonId = jSONObject.optLong("cartoon_id");
        this.chapterId = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
        this.isShareThread = jSONObject.optBoolean("is_share_thread", false);
        if (!TextUtils.isEmpty(optString)) {
            this.forumName = optString;
        }
        if (!TextUtils.isEmpty(optString2)) {
            this.threadId = optString2;
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.threadName = optString3;
        }
        if (optLong > 2000) {
            this.time = optLong;
        }
        this.threadType = jSONObject.optInt("thread_type");
        this.liveId = jSONObject.optString("live_id", "");
        this.userName = jSONObject.optString("user_name", "");
        this.description = jSONObject.optString("live_description", "");
        return true;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put("thread_time", this.time);
            jSONObject.put("thread_name", this.threadName);
            jSONObject.put("post_id", this.postID);
            jSONObject.put("host_only", this.isHostOnly);
            jSONObject.put("squence", this.isSquence);
            jSONObject.put("thread_type", this.threadType);
            jSONObject.put("is_manga", this.isManga);
            jSONObject.put("cartoon_id", this.cartoonId);
            jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.chapterId);
            jSONObject.put("is_share_thread", this.isShareThread);
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

    public void setIsShareThread(boolean z) {
        this.isShareThread = z;
    }

    public boolean isShareThread() {
        return this.isShareThread;
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

    public String dfe() {
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

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String bzZ() {
        return this.postID;
    }

    public void OW(String str) {
        this.postID = str;
    }

    public boolean dff() {
        return this.isHostOnly;
    }

    public void tw(boolean z) {
        this.isHostOnly = z;
    }

    public boolean dfg() {
        return this.isSquence;
    }

    public void tx(boolean z) {
        this.isSquence = z;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public void setLiveId(String str) {
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

    public boolean dfh() {
        return this.laS;
    }

    public void ty(boolean z) {
        this.laS = z;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.threadType == 49 ? this.liveId + "_ala" : this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String bBx() {
        return toJsonObject().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean Ef(String str) {
        if (str != null) {
            try {
                return eu(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
