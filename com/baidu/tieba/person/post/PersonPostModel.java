package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.Abstract;
import tbclient.UserPost.DataRes;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class PersonPostModel extends com.baidu.adp.base.e implements Serializable {
    public static final int PAGE_SIZE = 20;
    private static int bDy = 0;
    private static String bDz = "";
    public int hide_post;
    public List<PostList> post_list;

    public PersonPostModel() {
        this.post_list = new ArrayList();
        this.hide_post = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PersonPostModel(Context context) {
        super(context);
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

    public void fetchPost(Activity activity, g gVar, boolean z, String str, boolean z2) {
        if (z || !str.equals(bDz)) {
            bDy = 1;
            bDz = str;
        } else {
            bDy++;
        }
        if (activity instanceof BdBaseActivity) {
            this.unique_id = ((BdBaseActivity) activity).getUniqueId();
        } else if (activity instanceof BdBaseFragmentActivity) {
            this.unique_id = ((BdBaseFragmentActivity) activity).getUniqueId();
        }
        UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
        userPostPageRequestMessage.setUid(bDz);
        userPostPageRequestMessage.setPn(bDy);
        userPostPageRequestMessage.setRn(20);
        userPostPageRequestMessage.setThread(z2);
        userPostPageRequestMessage.setNeedContent(true);
        userPostPageRequestMessage.setReset(z);
        userPostPageRequestMessage.setmCallbackWeakReference(new WeakReference<>(gVar));
        sendMessage(userPostPageRequestMessage);
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
    public class PostList extends com.baidu.adp.lib.a.b.a.a.i implements at, Serializable {
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
        public Content[] content = new Content[0];
        public Quote quote = new Quote();
        public int reply_num = 0;
        public Media[] media = new Media[0];
        public AnchorInfo anchor_info = new AnchorInfo();
        public LbsInfo lbs_info = new LbsInfo();
        public int is_post_deleted = 0;

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

        @Override // com.baidu.tbadk.core.util.at
        public ArrayList<as> getImages() {
            Media[] mediaArr;
            ArrayList<as> arrayList = new ArrayList<>();
            for (Media media : this.media) {
                if (media.big_pic != null) {
                    as asVar = new as();
                    asVar.AI = media.big_pic;
                    asVar.ER = 10;
                    arrayList.add(asVar);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public class Content extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
        public long post_type = 0;
        public long post_id = 0;

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
    public class Abs extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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
    public class Quote extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public String ip = null;
        public String content = "";

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
    public class Media extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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
    public class AnchorInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public String portrait = "";
        public String name = "";
        public long start_time = 0;
        public int status = 0;
        public int author_id = 0;
        public String author_name = "";
        public int listeners = 0;
        public int likers = 0;
        public int group_id = 0;
        public String intro = "";
        public String publisherPortrait = "";
        public String publisherName = "";
        public int publisherId = 0;

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo != null) {
                this.portrait = anchorInfo.portrait;
                this.author_id = anchorInfo.author_id.intValue();
                this.author_name = anchorInfo.author_name;
                this.group_id = anchorInfo.group_id.intValue();
                this.intro = anchorInfo.intro;
                this.likers = anchorInfo.likers.intValue();
                this.listeners = anchorInfo.listeners.intValue();
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
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parseProtobuf(tbclient.UserPost.LbsInfo lbsInfo) {
            if (lbsInfo != null) {
                this.lat = lbsInfo.lat;
                this.lon = lbsInfo.lon;
                this.town = lbsInfo.town;
            }
        }
    }
}
