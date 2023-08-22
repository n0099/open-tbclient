package com.baidu.tieba.setting.person;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Abstract;
import tbclient.PostInfoList;
/* loaded from: classes8.dex */
public class PersonPostListData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PostList> post_list;

    /* loaded from: classes8.dex */
    public static class Abs implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String link;
        public String src;
        public String text;
        public int type;
        public String un;

        public Abs() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = 0;
            this.text = "";
            this.src = "";
            this.un = "";
            this.link = "";
        }

        public void parserData(Abstract r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                this.type = r5.type.intValue();
                this.text = r5.text;
                this.src = r5.src;
                this.un = r5.un;
                this.link = r5.link;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class AnchorInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long author_id;
        public String author_name;
        public long group_id;
        public String intro;
        public int likers;
        public int listeners;
        public String name;
        public String portrait;
        public String publisherPortrait;
        public long publisher_id;
        public String publisher_name;
        public long start_time;
        public int status;

        public AnchorInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.portrait = "";
            this.name = "";
            this.start_time = 0L;
            this.status = 0;
            this.author_id = 0L;
            this.author_name = "";
            this.listeners = 0;
            this.likers = 0;
            this.group_id = 0L;
            this.intro = "";
            this.publisherPortrait = "";
            this.publisher_name = "";
            this.publisher_id = 0L;
        }

        public void parserData(tbclient.AnchorInfo anchorInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, anchorInfo) == null) && anchorInfo != null) {
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

    /* loaded from: classes8.dex */
    public static class LbsInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String lat;

        public LbsInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lat = "";
        }

        public void parserData(tbclient.LbsInfo lbsInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lbsInfo) == null) && lbsInfo != null) {
                try {
                    this.lat = lbsInfo.lat;
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Media implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String big_pic;
        public String small_pic;
        public int type;
        public String vpic;
        public String vsrc;
        public String water_pic;

        public Media() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = 0;
            this.small_pic = "";
            this.big_pic = "";
            this.water_pic = "";
            this.vsrc = "";
            this.vpic = "";
        }

        public void parserData(tbclient.Media media) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, media) == null) {
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
    }

    /* loaded from: classes8.dex */
    public static class PostList extends AbstractImageProvider implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Abs> Abstract;
        public AnchorInfo anchor_info;
        public String content;
        public long create_time;
        public long forum_id;
        public String forum_name;
        public int is_post_deleted;
        public int is_thread;
        public LbsInfo lbs_info;
        public List<Media> media;
        public long post_id;
        public Quote quote;
        public int reply_num;
        public long thread_id;
        public String title;
        public long user_id;
        public String user_name;
        public String user_portrait;

        public PostList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.forum_id = 0L;
            this.thread_id = 0L;
            this.post_id = 0L;
            this.is_thread = 0;
            this.create_time = 0L;
            this.forum_name = "";
            this.title = "";
            this.user_name = "";
            this.user_id = 0L;
            this.user_portrait = "";
            this.Abstract = new ArrayList();
            this.content = "";
            this.quote = new Quote();
            this.reply_num = 0;
            this.media = new ArrayList();
            this.anchor_info = new AnchorInfo();
            this.lbs_info = new LbsInfo();
            this.is_post_deleted = 0;
        }
    }

    /* loaded from: classes8.dex */
    public static class Quote implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public long ip;
        public long post_id;
        public long user_id;
        public String user_name;

        public Quote() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_id = 0L;
            this.user_name = "";
            this.user_id = 0L;
            this.ip = 0L;
            this.content = "";
        }

        public void parserData(tbclient.Quote quote) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, quote) != null) || quote == null) {
                return;
            }
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

    public PersonPostListData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.post_list = new ArrayList();
    }

    public void parserData(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, profileHttpResponseMessage) == null) {
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
                        for (Abstract r5 : postInfoList.abstract_thread) {
                            Abs abs = new Abs();
                            abs.parserData(r5);
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
    }

    public void parserData(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileSocketResponseMessage) == null) {
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
                        for (Abstract r5 : postInfoList.abstract_thread) {
                            Abs abs = new Abs();
                            abs.parserData(r5);
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
    }
}
