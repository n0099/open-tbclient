package com.baidu.tieba.person;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PersonPostListData implements Serializable {
    @SerializedName("post_list")
    public List<PostList> post_list = new ArrayList();
    @SerializedName("hide_post")
    public int hide_post = 0;

    /* loaded from: classes.dex */
    public class PostList extends com.baidu.tbadk.core.util.a implements Serializable {
        @SerializedName("forum_id")
        public long forum_id = 0;
        @SerializedName("thread_id")
        public long thread_id = 0;
        @SerializedName("post_id")
        public long post_id = 0;
        @SerializedName("is_thread")
        public int is_thread = 0;
        @SerializedName("create_time")
        public long create_time = 0;
        @SerializedName("forum_name")
        public String forum_name = "";
        @SerializedName("title")
        public String title = "";
        @SerializedName("user_name")
        public String user_name = "";
        @SerializedName("user_id")
        public long user_id = 0;
        @SerializedName("user_portrait")
        public String user_portrait = "";
        @SerializedName("abstract")
        public Abs[] abs = new Abs[0];
        @SerializedName("content")
        public String content = "";
        @SerializedName("quote")
        public Quote quote = new Quote();
        @SerializedName("reply_num")
        public int reply_num = 0;
        @SerializedName("media")
        public Media[] media = new Media[0];
        @SerializedName("lbs_info")
        public LbsInfo lbs_info = new LbsInfo();
        @SerializedName("is_post_deleted")
        public int is_post_deleted = 0;

        public String toString() {
            return "PostList{forum_id=" + this.forum_id + ", thread_id=" + this.thread_id + ", post_id=" + this.post_id + ", is_thread=" + this.is_thread + ", create_time=" + this.create_time + ", forum_name='" + this.forum_name + "', title='" + this.title + "', user_name='" + this.user_name + "', user_id=" + this.user_id + ", user_portrait='" + this.user_portrait + "', abs=" + Arrays.toString(this.abs) + ", content='" + this.content + "', quote=" + this.quote + ", reply_num=" + this.reply_num + ", media=" + Arrays.toString(this.media) + ", lbs_info=" + this.lbs_info + ", is_post_deleted=" + this.is_post_deleted + '}';
        }

        @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
        public LinkedList<String> getImageUrl() {
            Media[] mediaArr;
            LinkedList<String> linkedList = new LinkedList<>();
            int i = 0;
            for (Media media : this.media) {
                i++;
                if (i > 3) {
                    break;
                }
                if (media.type == 3) {
                    linkedList.add(media.water_pic);
                }
            }
            return linkedList;
        }
    }

    /* loaded from: classes.dex */
    public class Content implements Serializable {
        @SerializedName("post_content")
        public Abs[] post_content = new Abs[0];
        @SerializedName("create_time")
        public long create_time = 0;

        public String toString() {
            return "Content{post_content=" + Arrays.toString(this.post_content) + ", create_time=" + this.create_time + '}';
        }
    }

    /* loaded from: classes.dex */
    public class Abs implements Serializable {
        @SerializedName("type")
        public int type = 0;
        @SerializedName("text")
        public String text = "";
        @SerializedName("src")
        public String src = "";
        @SerializedName(PersonInfoActivity.TAG_ID)
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
        @SerializedName("user_id")
        public long user_id = 0;
        @SerializedName("ip")
        public long ip = 0;
        @SerializedName("content")
        public String content = "";

        public String toString() {
            return "Quote{post_id=" + this.post_id + ", user_name='" + this.user_name + "', user_id=" + this.user_id + ", ip=" + this.ip + ", content='" + this.content + "'}";
        }
    }

    /* loaded from: classes.dex */
    public class Media implements Serializable {
        @SerializedName("type")
        public int type = 0;
        @SerializedName("small_pic")
        public String small_pic = "";
        @SerializedName("big_pic")
        public String big_pic = "";
        @SerializedName("water_pic")
        public String water_pic = "";
        @SerializedName("vsrc")
        public String video_url = "";
        @SerializedName("vpic")
        public String pic_url = "";

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

    public String toString() {
        return "PersonPostThreadModel{post_list=" + this.post_list + ", hide_post=" + this.hide_post + '}';
    }
}
