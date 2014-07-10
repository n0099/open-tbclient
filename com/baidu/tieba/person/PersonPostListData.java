package com.baidu.tieba.person;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PersonPostListData implements Serializable {
    @SerializedName("post_list")
    public List<PostList> post_list = new ArrayList();
    @SerializedName("hide_post")
    public int hide_post = 0;

    /* loaded from: classes.dex */
    public class Abs implements Serializable {
        @SerializedName("type")
        public int type = 0;
        @SerializedName("text")
        public String text = "";
        @SerializedName("src")
        public String src = "";
        @SerializedName("un")
        public String un = "";
        @SerializedName("link")
        public String link = "";
    }

    /* loaded from: classes.dex */
    public class AnchorInfo implements Serializable {
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)
        public String portrait = "";
        @SerializedName("name")
        public String name = "";
        @SerializedName("start_time")
        public long start_time = 0;
        @SerializedName("status")
        public int status = 0;
        @SerializedName("author_id")
        public int author_id = 0;
        @SerializedName("author_name")
        public String author_name = "";
        @SerializedName("listeners")
        public int listeners = 0;
        @SerializedName("likers")
        public int likers = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.GROUP_ID)
        public int group_id = 0;
        @SerializedName("intro")
        public String intro = "";
        @SerializedName("publisherPortrait")
        public String publisherPortrait = "";
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME)
        public String publisher_name = "";
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID)
        public int publisher_id = 0;
    }

    /* loaded from: classes.dex */
    public class Content implements Serializable {
        @SerializedName("post_content")
        public Abs[] post_content = new Abs[0];
        @SerializedName("create_time")
        public long create_time = 0;
    }

    /* loaded from: classes.dex */
    public class LbsInfo implements Serializable {
        @SerializedName("lat")
        public String lat = "";
        @SerializedName("lon")
        public String lon = "";
        @SerializedName("town")
        public String town = "";
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
    }

    /* loaded from: classes.dex */
    public class Quote implements Serializable {
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.POST_ID)
        public long post_id = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.USER_NAME)
        public String user_name = "";
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.USER_ID)
        public long user_id = 0;
        @SerializedName("ip")
        public long ip = 0;
        @SerializedName("content")
        public String content = "";
    }

    /* loaded from: classes.dex */
    public class PostList extends com.baidu.tbadk.core.util.a implements Serializable {
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.FORUM_ID)
        public long forum_id = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.THREAD_ID)
        public long thread_id = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.POST_ID)
        public long post_id = 0;
        @SerializedName("is_thread")
        public int is_thread = 0;
        public long create_time = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME)
        public String forum_name = "";
        @SerializedName("title")
        public String title = "";
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.USER_NAME)
        public String user_name = "";
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.USER_ID)
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
        @SerializedName("anchor_info")
        public AnchorInfo anchor_info = new AnchorInfo();
        @SerializedName("lbs_info")
        public LbsInfo lbs_info = new LbsInfo();
        @SerializedName("is_post_deleted")
        public int is_post_deleted = 0;

        @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ai
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
}
