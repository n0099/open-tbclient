package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class PersonPostReplyModel extends com.baidu.adp.a.d implements Serializable {
    public static final int PAGE_SIZE = 20;
    public static g sFetchReplyAsyncTask;
    @SerializedName("post_list")
    public List<Post> post_list = new ArrayList();
    static int mReplyPn = 0;
    static String mLastReplyUid = "";

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (sFetchReplyAsyncTask != null) {
            sFetchReplyAsyncTask.cancel();
            return false;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class Post implements Serializable {
        @SerializedName("forum_id")
        public long forum_id = 0;
        @SerializedName("thread_id")
        public long thread_id = 0;
        @SerializedName("post_id")
        public long post_id = 0;
        @SerializedName("is_thread")
        public long is_thread = 0;
        @SerializedName("create_time")
        public long create_time = 0;
        @SerializedName("forum_name")
        public String forum_name = "";
        @SerializedName("title")
        public String title = "";
        @SerializedName("user_name")
        public String user_name = "";
        @SerializedName(PushConstants.EXTRA_USER_ID)
        public long user_id = 0;
        @SerializedName("user_portrait")
        public String user_portrait = "";
        @SerializedName("abstract")
        public String abs = "";
        @SerializedName(PushConstants.EXTRA_CONTENT)
        public Content[] content = new Content[0];
        @SerializedName("quote")
        public Quote quote = new Quote();
        @SerializedName("reply_num")
        public long reply_num = 0;
        @SerializedName("media")
        public Media[] media = new Media[0];
        @SerializedName("lbs_info")
        public LbsInfo lbs_info = new LbsInfo();
        @SerializedName("is_post_deleted")
        public long is_post_deleted = 0;

        public String toString() {
            return "PostList{forum_id=" + this.forum_id + ", thread_id=" + this.thread_id + ", post_id=" + this.post_id + ", is_thread=" + this.is_thread + ", create_time=" + this.create_time + ", forum_name='" + this.forum_name + "', title='" + this.title + "', user_name='" + this.user_name + "', user_id=" + this.user_id + ", user_portrait='" + this.user_portrait + "', abs='" + this.abs + "', content=" + this.content + ", quote=" + this.quote + ", reply_num=" + this.reply_num + ", media=" + Arrays.toString(this.media) + ", lbs_info=" + this.lbs_info + ", is_post_deleted=" + this.is_post_deleted + '}';
        }
    }

    /* loaded from: classes.dex */
    public class Content implements Serializable {
        @SerializedName("post_content")
        public Abs[] post_content = new Abs[0];
        @SerializedName("create_time")
        public long create_time = 0;
        @SerializedName("post_type")
        public long post_type = 0;
        @SerializedName("post_id")
        public long post_id = 0;

        public String toString() {
            return "Content{post_content=" + Arrays.toString(this.post_content) + ", create_time=" + this.create_time + '}';
        }
    }

    /* loaded from: classes.dex */
    public class Abs implements Serializable {
        @SerializedName("type")
        public long type = 0;
        @SerializedName("text")
        public String text = "";
        @SerializedName("src")
        public String src = "";
        @SerializedName("un")
        public String un = "";
        @SerializedName("link")
        public String link = "";

        public String toString() {
            return "PostContent{type=" + this.type + ", text='" + this.text + "', src='" + this.src + "', un='" + this.un + "', link='" + this.link + "'}";
        }
    }

    /* loaded from: classes.dex */
    public class Quote implements Serializable {
        @SerializedName("post_id")
        public long post_id = 0;
        @SerializedName("user_name")
        public String user_name = "";
        @SerializedName(PushConstants.EXTRA_USER_ID)
        public long user_id = 0;
        @SerializedName("ip")
        public long ip = 0;
        @SerializedName(PushConstants.EXTRA_CONTENT)
        public String content = "";

        public String toString() {
            return "Quote{post_id=" + this.post_id + ", user_name='" + this.user_name + "', user_id=" + this.user_id + ", ip=" + this.ip + ", content='" + this.content + "'}";
        }
    }

    /* loaded from: classes.dex */
    public class Media implements Serializable {
        @SerializedName("type")
        public long type = 0;
        @SerializedName("small_pic")
        public String small_pic = "";
        @SerializedName("big_pic")
        public String big_pic = "";
        @SerializedName("water_pic")
        public String water_pic = "";

        public String toString() {
            return "Media{type=" + this.type + ", small_pic='" + this.small_pic + "', big_pic='" + this.big_pic + "', water_pic='" + this.water_pic + "'}";
        }
    }

    /* loaded from: classes.dex */
    public class LbsInfo implements Serializable {
        @SerializedName("lat")
        public String lat = "";
        @SerializedName("lon")
        public String lon = "";
        @SerializedName("town")
        public String town = "";

        public String toString() {
            return "LbsInfo{lat='" + this.lat + "', lon='" + this.lon + "', town='" + this.town + "'}";
        }
    }

    public static int getRealPostCount(List<Post> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += list.get(i2).content.length;
        }
        return i;
    }

    public static void fetchReply(f fVar, boolean z, String str) {
        if (z || !str.equals(mLastReplyUid)) {
            mReplyPn = 1;
            mLastReplyUid = str;
        } else {
            mReplyPn++;
        }
        if (sFetchReplyAsyncTask != null && sFetchReplyAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            sFetchReplyAsyncTask.cancel();
        }
        sFetchReplyAsyncTask = new g(fVar, z);
        sFetchReplyAsyncTask.execute(new Void[0]);
    }
}
