package com.baidu.tieba.person.post;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.annotations.SerializedName;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tbclient.Abstract;
import tbclient.UserPost.DataRes;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class PersonPostModel extends com.baidu.adp.base.d implements Serializable {
    public static final int PAGE_SIZE = 20;
    private static int a = 0;
    private static String b = "";
    public List<PostList> post_list = new ArrayList();
    public int hide_post = 0;

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public void fetchPost(Activity activity, f fVar, boolean z, String str, boolean z2) {
        if (z || !str.equals(b)) {
            a = 1;
            b = str;
        } else {
            a++;
        }
        UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
        userPostPageRequestMessage.setUid(b);
        userPostPageRequestMessage.setPn(a);
        userPostPageRequestMessage.setRn(20);
        userPostPageRequestMessage.setThread(z2);
        userPostPageRequestMessage.setNeedContent(true);
        userPostPageRequestMessage.setReset(z);
        userPostPageRequestMessage.setmCallbackWeakReference(new WeakReference<>(fVar));
        if (activity instanceof com.baidu.adp.base.b) {
            ((com.baidu.adp.base.b) activity).a(userPostPageRequestMessage);
        } else {
            MessageManager.getInstance().sendMessage(userPostPageRequestMessage);
        }
    }

    public void parseProtobuf(DataRes dataRes) {
        if (dataRes != null) {
            this.hide_post = dataRes.hide_post.intValue();
            this.post_list.clear();
            if (dataRes.post_list != null) {
                for (tbclient.UserPost.PostList postList : dataRes.post_list) {
                    PostList postList2 = new PostList();
                    postList2.parseProtobuf(postList);
                    this.post_list.add(postList2);
                }
            }
        }
    }

    public UserPostResIdl parseProtobuf(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            UserPostResIdl userPostResIdl = (UserPostResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPostResIdl.class);
            parseProtobuf(userPostResIdl.data);
            return userPostResIdl;
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class PostList implements Serializable {
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.FORUM_ID)
        public long forum_id = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.THREAD_ID)
        public long thread_id = 0;
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.POST_ID)
        public long post_id = 0;
        @SerializedName("is_thread")
        public int is_thread = 0;
        @SerializedName("create_time")
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
        @SerializedName("abstract_thread")
        public Abs[] abs_thread = new Abs[0];
        @SerializedName("content_thread")
        public String content_thread = "";
        @SerializedName("abstract")
        public String abs = "";
        @SerializedName("content")
        public Content[] content = new Content[0];
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

        public String toString() {
            return "PostList{forum_id=" + this.forum_id + ", thread_id=" + this.thread_id + ", post_id=" + this.post_id + ", is_thread=" + this.is_thread + ", create_time=" + this.create_time + ", forum_name='" + this.forum_name + "', title='" + this.title + "', user_name='" + this.user_name + "', user_id=" + this.user_id + ", user_portrait='" + this.user_portrait + "', abs=" + Arrays.toString(this.abs_thread) + ", content='" + this.content_thread + "', quote=" + this.quote + ", reply_num=" + this.reply_num + ", media=" + Arrays.toString(this.media) + ", anchor_info=" + this.anchor_info.toString() + ", lbs_info=" + this.lbs_info + ", is_post_deleted=" + this.is_post_deleted + '}';
        }

        public void parseProtobuf(tbclient.UserPost.PostList postList) {
            if (postList != null) {
                this.forum_id = postList.forum_id.longValue();
                this.thread_id = postList.thread_id.longValue();
                this.post_id = postList.post_id.longValue();
                this.is_thread = postList.is_thread.intValue();
                this.create_time = postList.create_time.intValue();
                this.forum_name = postList.forum_name;
                this.title = postList.title;
                this.user_name = postList.user_name;
                this.user_id = postList.user_id.longValue();
                this.user_portrait = postList.user_portrait;
                if (postList._abstract != null) {
                    this.abs_thread = new Abs[postList.abstract_thread.size()];
                    for (int i = 0; i < this.abs_thread.length; i++) {
                        Abs abs = new Abs();
                        abs.parseProtobuf(postList.abstract_thread.get(i));
                        this.abs_thread[i] = abs;
                    }
                }
                this.abs = postList._abstract;
                this.content_thread = postList.content_thread;
                if (postList.content != null) {
                    this.content = new Content[postList.content.size()];
                    for (int i2 = 0; i2 < this.content.length; i2++) {
                        Content content = new Content();
                        content.parseProtobuf(postList.content.get(i2));
                        this.content[i2] = content;
                    }
                }
                this.quote.parseProtobuf(postList.quote);
                this.reply_num = postList.reply_num.intValue();
                this.is_post_deleted = postList.is_post_deleted.intValue();
                this.lbs_info.parseProtobuf(postList.lbs_info);
                this.anchor_info.parseProtobuf(postList.anchor_info);
                if (postList.media != null) {
                    this.media = new Media[postList.media.size()];
                    for (int i3 = 0; i3 < this.media.length; i3++) {
                        Media media = new Media();
                        media.parseProtobuf(postList.media.get(i3));
                        this.media[i3] = media;
                    }
                }
            }
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
        @SerializedName(com.baidu.tbadk.core.frameworkData.a.POST_ID)
        public long post_id = 0;

        public String toString() {
            return "Content{post_content=" + Arrays.toString(this.post_content) + ", create_time=" + this.create_time + '}';
        }

        public void parseProtobuf(tbclient.UserPost.Content content) {
            if (content != null) {
                this.create_time = content.create_time.longValue();
                this.post_id = content.post_id.longValue();
                this.post_type = content.post_type.longValue();
                if (content.post_content != null) {
                    this.post_content = new Abs[content.post_content.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.post_content.length) {
                            Abs abs = new Abs();
                            abs.parseProtobuf(content.post_content.get(i2));
                            this.post_content[i2] = abs;
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
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
        @SerializedName("un")
        public String un = "";
        @SerializedName("link")
        public String link = "";

        public String toString() {
            return "PostContent{type=" + this.type + ", text='" + this.text + "', src='" + this.src + "', un='" + this.un + "', link='" + this.link + "'}";
        }

        public void parseProtobuf(Abstract r2) {
            if (r2 != null) {
                this.type = r2.type.intValue();
                this.text = r2.text;
                this.src = r2.src;
                this.un = r2.un;
                this.link = r2.link;
            }
        }
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
        public String ip = null;
        @SerializedName("content")
        public String content = "";

        public String toString() {
            return "Quote{post_id=" + this.post_id + ", user_name='" + this.user_name + "', user_id=" + this.user_id + ", ip=" + this.ip + ", content='" + this.content + "'}";
        }

        public void parseProtobuf(tbclient.UserPost.Quote quote) {
            if (quote != null) {
                this.post_id = quote.post_id.longValue();
                this.user_id = quote.user_id.longValue();
                this.user_name = quote.user_name;
                this.ip = quote.ip;
                this.content = quote.content;
            }
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

        public String toString() {
            return "Media{type=" + this.type + ", small_pic='" + this.small_pic + "', big_pic='" + this.big_pic + "', water_pic='" + this.water_pic + "'}";
        }

        public void parseProtobuf(tbclient.Media media) {
            if (media != null) {
                this.type = media.type.intValue();
                this.small_pic = media.small_pic;
                this.big_pic = media.big_pic;
                this.water_pic = media.water_pic;
            }
        }
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
        @SerializedName("publisherName")
        public String publisherName = "";
        @SerializedName("publisherId")
        public int publisherId = 0;

        public String toString() {
            return "anchor_info{portrait=" + this.portrait + ", name='" + this.name + "', start_time='" + this.start_time + "', status='" + this.status + "', author_id='" + this.author_id + "', author_name='" + this.author_name + "', listeners='" + this.listeners + "', likers='" + this.likers + "', group_id='" + this.group_id + "', intro='" + this.intro + "', publisherPortrait='" + this.publisherPortrait + "', publisherName='" + this.publisherName + "', publisherId='" + this.publisherId + "'}";
        }

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo != null) {
                this.portrait = anchorInfo.portrait;
                this.author_id = anchorInfo.author_id.intValue();
                this.author_name = anchorInfo.author_name;
                this.group_id = anchorInfo.group_id.intValue();
                this.intro = anchorInfo.intro;
                this.likers = anchorInfo.likers.intValue();
                this.name = anchorInfo.name;
                this.publisherId = anchorInfo.publisherId.intValue();
                this.publisherName = anchorInfo.publisherName;
                this.publisherPortrait = anchorInfo.publisherPortrait;
                this.start_time = anchorInfo.start_time.intValue();
                this.status = anchorInfo.status.intValue();
            }
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

        public void parseProtobuf(tbclient.UserPost.LbsInfo lbsInfo) {
            if (lbsInfo != null) {
                this.lat = lbsInfo.lat;
                this.lon = lbsInfo.lon;
                this.town = lbsInfo.town;
            }
        }
    }

    public String toString() {
        return "PersonPostThreadModel{post_list=" + this.post_list + ", hide_post=" + this.hide_post + '}';
    }
}
