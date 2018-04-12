package com.baidu.tieba.setting.person;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Abstract;
import tbclient.PostInfoList;
/* loaded from: classes3.dex */
public class PersonPostListData extends OrmObject implements Serializable {
    public List<PostList> post_list = new ArrayList();
    public int hide_post = 0;

    /* loaded from: classes3.dex */
    public static class Content implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
    }

    public void parserData(ProfileSocketResponseMessage profileSocketResponseMessage) {
        List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
        ArrayList arrayList = new ArrayList();
        if (GetPostList != null && GetPostList.size() > 0) {
            for (PostInfoList postInfoList : GetPostList) {
                PostList postList = new PostList();
                postList.forum_id = postInfoList.forum_id.longValue();
                postList.thread_id = postInfoList.thread_id.longValue();
                postList.post_id = postInfoList.post_id.longValue();
                postList.is_thread = postInfoList.is_thread.intValue();
                postList.create_time = postInfoList.create_time.intValue();
                postList.forum_name = postInfoList.forum_name;
                postList.title = postInfoList.title;
                postList.user_name = postInfoList.user_name;
                postList.user_id = postInfoList.user_id.longValue();
                postList.user_portrait = postInfoList.user_portrait;
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (Abstract r1 : postInfoList.abstract_thread) {
                        Abs abs = new Abs();
                        abs.parserData(r1);
                        arrayList2.add(abs);
                    }
                    postList.Abstract = arrayList2;
                    postList.content = postInfoList.content_thread;
                    postList.quote.parserData(postInfoList.quote);
                    postList.reply_num = postInfoList.reply_num.intValue();
                    ArrayList arrayList3 = new ArrayList();
                    for (tbclient.Media media : postInfoList.media) {
                        Media media2 = new Media();
                        media2.parserData(media);
                        arrayList3.add(media2);
                    }
                    postList.media = arrayList3;
                    postList.anchor_info.parserData(postInfoList.anchor_info);
                    postList.lbs_info.parserData(postInfoList.lbs_info);
                    postList.is_post_deleted = postInfoList.is_post_deleted.intValue();
                    arrayList.add(postList);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            this.post_list = arrayList;
        }
    }

    public void parserData(ProfileHttpResponseMessage profileHttpResponseMessage) {
        List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
        ArrayList arrayList = new ArrayList();
        if (GetPostList != null && GetPostList.size() > 0) {
            for (PostInfoList postInfoList : GetPostList) {
                PostList postList = new PostList();
                postList.forum_id = postInfoList.forum_id.longValue();
                postList.thread_id = postInfoList.thread_id.longValue();
                postList.post_id = postInfoList.post_id.longValue();
                postList.is_thread = postInfoList.is_thread.intValue();
                postList.create_time = postInfoList.create_time.intValue();
                postList.forum_name = postInfoList.forum_name;
                postList.title = postInfoList.title;
                postList.user_name = postInfoList.user_name;
                postList.user_id = postInfoList.user_id.longValue();
                postList.user_portrait = postInfoList.user_portrait;
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (Abstract r1 : postInfoList.abstract_thread) {
                        Abs abs = new Abs();
                        abs.parserData(r1);
                        arrayList2.add(abs);
                    }
                    postList.Abstract = arrayList2;
                    postList.content = postInfoList.content_thread;
                    postList.quote.parserData(postInfoList.quote);
                    postList.reply_num = postInfoList.reply_num.intValue();
                    ArrayList arrayList3 = new ArrayList();
                    for (tbclient.Media media : postInfoList.media) {
                        Media media2 = new Media();
                        media2.parserData(media);
                        arrayList3.add(media2);
                    }
                    postList.media = arrayList3;
                    postList.anchor_info.parserData(postInfoList.anchor_info);
                    postList.lbs_info.parserData(postInfoList.lbs_info);
                    postList.is_post_deleted = postInfoList.is_post_deleted.intValue();
                    arrayList.add(postList);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            this.post_list = arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static class PostList extends AbstractImageProvider implements Serializable {
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
        public List<Abs> Abstract = new ArrayList();
        public String content = "";
        public Quote quote = new Quote();
        public int reply_num = 0;
        public List<Media> media = new ArrayList();
        public AnchorInfo anchor_info = new AnchorInfo();
        public LbsInfo lbs_info = new LbsInfo();
        public int is_post_deleted = 0;

        @Override // com.baidu.tbadk.core.util.AbstractImageProvider
        public ArrayList<String> getImageUrl() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = 0;
            for (Media media : this.media) {
                i++;
                if (i > 3) {
                    break;
                } else if (media.type == 3) {
                    arrayList.add(media.water_pic);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static class Abs implements Serializable {
        public int type = 0;
        public String text = "";
        public String src = "";
        public String un = "";
        public String link = "";

        public void parserData(Abstract r2) {
            this.type = r2.type.intValue();
            this.text = r2.text;
            this.src = r2.src;
            this.un = r2.un;
            this.link = r2.link;
        }
    }

    /* loaded from: classes3.dex */
    public static class Quote implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public long ip = 0;
        public String content = "";

        public void parserData(tbclient.Quote quote) {
            if (quote != null) {
                try {
                    this.post_id = quote.post_id.longValue();
                    this.user_id = quote.user_id.longValue();
                    this.user_name = quote.user_name;
                    if (quote.ip != null) {
                        this.ip = Long.parseLong(quote.ip);
                    }
                    this.content = quote.content;
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Media implements Serializable {
        public int type = 0;
        public String small_pic = "";
        public String big_pic = "";
        public String water_pic = "";
        public String vsrc = "";
        public String vpic = "";

        public void parserData(tbclient.Media media) {
            try {
                this.type = media.type.intValue();
                this.small_pic = media.small_pic;
                this.big_pic = media.big_pic;
                this.water_pic = media.water_pic;
                this.vsrc = media.vsrc;
                this.vpic = media.vpic;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class AnchorInfo implements Serializable {
        public String portrait = "";
        public String name = "";
        public long start_time = 0;
        public int status = 0;
        public long author_id = 0;
        public String author_name = "";
        public int listeners = 0;
        public int likers = 0;
        public long group_id = 0;
        public String intro = "";
        public String publisherPortrait = "";
        public String publisher_name = "";
        public long publisher_id = 0;

        public void parserData(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo != null) {
                try {
                    this.portrait = anchorInfo.portrait;
                    this.name = anchorInfo.name;
                    this.start_time = anchorInfo.start_time.intValue();
                    this.status = anchorInfo.status.intValue();
                    this.author_id = anchorInfo.author_id.longValue();
                    this.author_name = anchorInfo.author_name;
                    this.listeners = anchorInfo.listeners.intValue();
                    this.likers = anchorInfo.likers.intValue();
                    this.group_id = anchorInfo.group_id.longValue();
                    this.intro = anchorInfo.intro;
                    this.publisherPortrait = anchorInfo.publisherPortrait;
                    this.publisher_name = anchorInfo.publisherName;
                    this.publisher_id = anchorInfo.publisherId.longValue();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LbsInfo implements Serializable {
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parserData(tbclient.LbsInfo lbsInfo) {
            if (lbsInfo != null) {
                try {
                    this.lat = lbsInfo.lat;
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }
}
