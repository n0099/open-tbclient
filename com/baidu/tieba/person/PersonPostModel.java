package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.Abstract;
import tbclient.UserPost.DataRes;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class PersonPostModel extends com.baidu.adp.base.e<BaseFragmentActivity> implements Serializable {
    public static final int PAGE_SIZE = 20;
    private static int ckr = 0;
    private static String cks = "";
    public int hide_post;
    public List<PostInfoList> post_list;

    /* loaded from: classes.dex */
    public interface a {
        void a(PersonPostModel personPostModel, boolean z);
    }

    public PersonPostModel() {
        this.post_list = new ArrayList();
        this.hide_post = 0;
    }

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.post_list = new ArrayList();
        this.hide_post = 0;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, a aVar, boolean z, String str, boolean z2) {
        if (z || !str.equals(cks)) {
            ckr = 1;
            cks = str;
        } else {
            ckr++;
        }
        if (tbPageContext != null) {
            this.unique_id = tbPageContext.getUniqueId();
        }
        UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
        userPostPageRequestMessage.setUid(cks);
        userPostPageRequestMessage.setPn(ckr);
        userPostPageRequestMessage.setRn(20);
        userPostPageRequestMessage.setThread(z2);
        userPostPageRequestMessage.setNeedContent(true);
        userPostPageRequestMessage.setReset(z);
        userPostPageRequestMessage.setmCallbackWeakReference(new WeakReference<>(aVar));
        sendMessage(userPostPageRequestMessage);
    }

    public void parseProtobuf(DataRes dataRes) {
        if (dataRes != null) {
            this.hide_post = dataRes.hide_post.intValue();
            this.post_list.clear();
            if (dataRes.post_list != null) {
                for (tbclient.PostInfoList postInfoList : dataRes.post_list) {
                    PostInfoList postInfoList2 = new PostInfoList();
                    postInfoList2.parseProtobuf(postInfoList);
                    this.post_list.add(postInfoList2);
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
    public static class PostInfoList extends com.baidu.adp.lib.a.b.a.a.i implements com.baidu.tbadk.core.util.ad, Serializable {
        public long forum_id = 0;
        public long thread_id = 0;
        public long post_id = 0;
        public int is_thread = 0;
        public long create_time = 0;
        public String forum_name = "";
        public String title = "";
        public String user_name = "";
        public long user_id = 0;
        public String user_portrait = "";
        public Abs[] abs_thread = new Abs[0];
        public String content_thread = "";
        public String abs = "";
        public PostInfoContent[] content = new PostInfoContent[0];
        public Quote quote = new Quote();
        public int reply_num = 0;
        public Media[] media = new Media[0];
        public AnchorInfo anchor_info = new AnchorInfo();
        public LbsInfo lbs_info = new LbsInfo();
        public int is_post_deleted = 0;

        public void parseProtobuf(tbclient.PostInfoList postInfoList) {
            if (postInfoList != null) {
                this.forum_id = postInfoList.forum_id.longValue();
                this.thread_id = postInfoList.thread_id.longValue();
                this.post_id = postInfoList.post_id.longValue();
                this.is_thread = postInfoList.is_thread.intValue();
                this.create_time = postInfoList.create_time.intValue();
                this.forum_name = postInfoList.forum_name;
                this.title = postInfoList.title;
                this.user_name = postInfoList.user_name;
                this.user_id = postInfoList.user_id.longValue();
                this.user_portrait = postInfoList.user_portrait;
                if (postInfoList._abstract != null) {
                    this.abs_thread = new Abs[postInfoList.abstract_thread.size()];
                    for (int i = 0; i < this.abs_thread.length; i++) {
                        Abs abs = new Abs();
                        abs.parseProtobuf(postInfoList.abstract_thread.get(i));
                        this.abs_thread[i] = abs;
                    }
                }
                this.abs = postInfoList._abstract;
                this.content_thread = postInfoList.content_thread;
                if (postInfoList.content != null) {
                    this.content = new PostInfoContent[postInfoList.content.size()];
                    for (int i2 = 0; i2 < this.content.length; i2++) {
                        PostInfoContent postInfoContent = new PostInfoContent();
                        postInfoContent.parseProtobuf(postInfoList.content.get(i2));
                        this.content[i2] = postInfoContent;
                    }
                }
                this.quote.parseProtobuf(postInfoList.quote);
                this.reply_num = postInfoList.reply_num.intValue();
                this.is_post_deleted = postInfoList.is_post_deleted.intValue();
                this.lbs_info.parseProtobuf(postInfoList.lbs_info);
                this.anchor_info.parseProtobuf(postInfoList.anchor_info);
                if (postInfoList.media != null) {
                    this.media = new Media[postInfoList.media.size()];
                    for (int i3 = 0; i3 < this.media.length; i3++) {
                        Media media = new Media();
                        media.parseProtobuf(postInfoList.media.get(i3));
                        this.media[i3] = media;
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ad
        public ArrayList<com.baidu.tbadk.core.util.ac> getImages() {
            Media[] mediaArr;
            ArrayList<com.baidu.tbadk.core.util.ac> arrayList = new ArrayList<>();
            for (Media media : this.media) {
                if (media.big_pic != null) {
                    com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac();
                    acVar.VY = media.big_pic;
                    acVar.aau = 10;
                    arrayList.add(acVar);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class PostInfoContent extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
        public long post_type = 0;
        public long post_id = 0;

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            if (postInfoContent != null) {
                this.create_time = postInfoContent.create_time.longValue();
                this.post_id = postInfoContent.post_id.longValue();
                this.post_type = postInfoContent.post_type.longValue();
                if (postInfoContent.post_content != null) {
                    this.post_content = new Abs[postInfoContent.post_content.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.post_content.length) {
                            Abs abs = new Abs();
                            abs.parseProtobuf(postInfoContent.post_content.get(i2));
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
    public static class Abs extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public int type = 0;
        public String text = "";
        public String src = "";
        public String un = "";
        public String link = "";

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
    public static class Quote extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public String ip = null;
        public String content = "";

        public void parseProtobuf(tbclient.Quote quote) {
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
    public static class Media extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public int type = 0;
        public String small_pic = "";
        public String big_pic = "";
        public String water_pic = "";

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
    public static class AnchorInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public String portrait = "";
        public String name = "";
        public long start_time = 0;
        public int status = 0;
        public long author_id = 0;
        public String author_name = "";
        public int listeners = 0;
        public int likers = 0;
        public int group_id = 0;
        public String intro = "";
        public String publisherPortrait = "";
        public String publisherName = "";
        public long publisherId = 0;

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo != null) {
                this.portrait = anchorInfo.portrait;
                this.author_id = anchorInfo.author_id.longValue();
                this.author_name = anchorInfo.author_name;
                this.group_id = anchorInfo.group_id.intValue();
                this.intro = anchorInfo.intro;
                this.likers = anchorInfo.likers.intValue();
                this.listeners = anchorInfo.listeners.intValue();
                this.name = anchorInfo.name;
                this.publisherId = anchorInfo.publisherId.longValue();
                this.publisherName = anchorInfo.publisherName;
                this.publisherPortrait = anchorInfo.publisherPortrait;
                this.start_time = anchorInfo.start_time.intValue();
                this.status = anchorInfo.status.intValue();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LbsInfo implements Serializable {
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            if (lbsInfo != null) {
                this.lat = lbsInfo.lat;
                this.lon = lbsInfo.lon;
                this.town = lbsInfo.town;
            }
        }
    }
}
