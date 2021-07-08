package com.baidu.tieba.personPolymeric.mode;

import UserPost.DataRes;
import UserPost.UserPostResIdl;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageRequestMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.p0.m2.e.i;
import d.a.p0.m2.e.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tbclient.Abstract;
import tbclient.BaijiahaoInfo;
import tbclient.User;
import tbclient.Voice;
/* loaded from: classes4.dex */
public class PersonPostModel extends BdBaseModel<BaseFragmentActivity> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static int FROM_PERSON_POLYMERIC = 1;
    public static int FROM_PERSON_POST = 2;
    public static final int PAGE_SIZE = 20;
    public static String mLastThreadUid = "";
    public static int mRecommentPn = 1;
    public static int mThreadPn;
    public transient /* synthetic */ FieldHolder $fh;
    public int hide_post;
    public boolean isShowRecycleBinRedTip;
    public i mCardNullPolymericData;
    public int mFrom;
    public boolean mIsHost;
    public boolean mIsReset;
    public int mLastChooseStyle;
    public d mOnResult;
    public ResponsedMessage<?> mResponsedMessage;
    public HttpMessageListener pageHttpListener;
    public d.a.c.c.g.c pageSocketListener;
    public final ArrayList<n> postList;
    public final ArrayList<n> threadList;
    public int view_card_num;

    /* loaded from: classes4.dex */
    public static class Abs extends OrmObject implements Serializable {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public void parseProtobuf(Abstract r5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || r5 == null) {
                return;
            }
            this.type = r5.type.intValue();
            this.text = r5.text;
            this.src = r5.src;
            this.un = r5.un;
            this.link = r5.link;
        }
    }

    /* loaded from: classes4.dex */
    public static class AnchorInfo extends OrmObject implements Serializable {
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
        public long publisherId;
        public String publisherName;
        public String publisherPortrait;
        public long start_time;
        public int status;

        public AnchorInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.publisherName = "";
            this.publisherId = 0L;
        }

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, anchorInfo) == null) || anchorInfo == null) {
                return;
            }
            this.portrait = anchorInfo.portrait;
            this.author_id = anchorInfo.author_id.longValue();
            this.author_name = anchorInfo.author_name;
            this.group_id = anchorInfo.group_id.longValue();
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

    /* loaded from: classes4.dex */
    public static class LabelInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String LabelId;
        public int labelHot;
        public String labelName;

        public LabelInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.labelHot = 0;
            this.labelName = "";
            this.LabelId = "";
        }

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, labelInfo) == null) || labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes4.dex */
    public static class LbsInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String lat;
        public String lon;
        public String town;

        public LbsInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lat = "";
            this.lon = "";
            this.town = "";
        }

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lbsInfo) == null) || lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes4.dex */
    public static class Media extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String big_pic;
        public String small_pic;
        public int type;
        public String water_pic;

        public Media() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = 0;
            this.small_pic = "";
            this.big_pic = "";
            this.water_pic = "";
        }

        public void parseProtobuf(tbclient.Media media) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, media) == null) || media == null) {
                return;
            }
            this.type = media.type.intValue();
            this.small_pic = media.small_pic;
            this.big_pic = media.big_pic;
            this.water_pic = media.water_pic;
        }
    }

    /* loaded from: classes4.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long create_time;
        public int is_author_view;
        public Abs[] post_content;
        public long post_id;
        public long post_type;

        public PostInfoContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_content = new Abs[0];
            this.create_time = 0L;
            this.post_type = 0L;
            this.post_id = 0L;
            this.is_author_view = 0;
        }

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, postInfoContent) == null) || postInfoContent == null) {
                return;
            }
            this.create_time = postInfoContent.create_time.longValue();
            this.post_id = postInfoContent.post_id.longValue();
            this.post_type = postInfoContent.post_type.longValue();
            this.is_author_view = postInfoContent.is_author_view.intValue();
            List<Abstract> list = postInfoContent.post_content;
            if (list != null) {
                this.post_content = new Abs[list.size()];
                for (int i2 = 0; i2 < this.post_content.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoContent.post_content.get(i2));
                    this.post_content[i2] = abs;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class PostInfoList extends OrmObject implements Serializable, PreLoadImageProvider, n {
        public static /* synthetic */ Interceptable $ic;
        public static final BdUniqueId POST_INFO;
        public transient /* synthetic */ FieldHolder $fh;
        public String abs;
        public Abs[] abs_thread;
        public AnchorInfo anchor_info;
        public PostInfoContent[] content;
        public String content_thread;
        public long create_time;
        public long forum_id;
        public String forum_name;
        public int isAuthorView;
        public boolean isDeal;
        public boolean isShareThread;
        public int is_post_deleted;
        public int is_thread;
        public LbsInfo lbs_info;
        public BaijiahaoInfo mBaijiahaoInfo;
        public Media[] media;
        public String name_show;
        public OriginalThreadInfo originalThreadInfo;
        public long post_id;
        public Quote quote;
        public int reply_num;
        public long thread_id;
        public long thread_type;
        public String title;
        public ZhiBoInfoTW twzhibo_info;
        public long user_id;
        public String user_name;
        public String user_portrait;
        public VoiceData$VoiceModel[] voice_info;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-166423971, "Lcom/baidu/tieba/personPolymeric/mode/PersonPostModel$PostInfoList;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-166423971, "Lcom/baidu/tieba/personPolymeric/mode/PersonPostModel$PostInfoList;");
                    return;
                }
            }
            POST_INFO = BdUniqueId.gen();
        }

        public PostInfoList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
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
            this.abs_thread = new Abs[0];
            this.content_thread = "";
            this.abs = "";
            this.content = new PostInfoContent[0];
            this.quote = new Quote();
            this.reply_num = 0;
            this.media = new Media[0];
            this.anchor_info = new AnchorInfo();
            this.lbs_info = new LbsInfo();
            this.is_post_deleted = 0;
            this.thread_type = 0L;
            this.voice_info = new VoiceData$VoiceModel[0];
            this.twzhibo_info = new ZhiBoInfoTW();
        }

        @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
        public ArrayList<PreLoadImageInfo> getImages() {
            InterceptResult invokeV;
            Media[] mediaArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
                for (Media media : this.media) {
                    if (media.big_pic != null) {
                        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                        preLoadImageInfo.imgUrl = media.big_pic;
                        preLoadImageInfo.procType = 10;
                        arrayList.add(preLoadImageInfo);
                    }
                }
                return arrayList;
            }
            return (ArrayList) invokeV.objValue;
        }

        @Override // d.a.c.k.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? POST_INFO : (BdUniqueId) invokeV.objValue;
        }

        public void parseProtobuf(tbclient.PostInfoList postInfoList, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, postInfoList, i2) == null) || postInfoList == null) {
                return;
            }
            this.forum_id = postInfoList.forum_id.longValue();
            this.thread_id = postInfoList.thread_id.longValue();
            this.post_id = postInfoList.post_id.longValue();
            this.is_thread = postInfoList.is_thread.intValue();
            this.create_time = postInfoList.create_time.intValue();
            this.forum_name = postInfoList.forum_name;
            this.title = postInfoList.title;
            this.user_name = postInfoList.user_name;
            this.name_show = postInfoList.name_show;
            this.user_id = postInfoList.user_id.longValue();
            this.user_portrait = postInfoList.user_portrait;
            this.thread_type = postInfoList.thread_type.longValue();
            if (postInfoList._abstract != null) {
                this.abs_thread = new Abs[postInfoList.abstract_thread.size()];
                for (int i3 = 0; i3 < this.abs_thread.length; i3++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoList.abstract_thread.get(i3));
                    this.abs_thread[i3] = abs;
                }
            }
            this.abs = postInfoList._abstract;
            this.mBaijiahaoInfo = postInfoList.baijiahao_info;
            this.content_thread = postInfoList.content_thread;
            List<tbclient.PostInfoContent> list = postInfoList.content;
            if (list != null) {
                this.content = new PostInfoContent[list.size()];
                for (int i4 = 0; i4 < this.content.length; i4++) {
                    PostInfoContent postInfoContent = new PostInfoContent();
                    postInfoContent.parseProtobuf(postInfoList.content.get(i4));
                    this.content[i4] = postInfoContent;
                }
            }
            this.quote.parseProtobuf(postInfoList.quote);
            this.reply_num = postInfoList.reply_num.intValue();
            this.is_post_deleted = postInfoList.is_post_deleted.intValue();
            this.lbs_info.parseProtobuf(postInfoList.lbs_info);
            this.anchor_info.parseProtobuf(postInfoList.anchor_info);
            List<tbclient.Media> list2 = postInfoList.media;
            if (list2 != null) {
                this.media = new Media[list2.size()];
                for (int i5 = 0; i5 < this.media.length; i5++) {
                    Media media = new Media();
                    media.parseProtobuf(postInfoList.media.get(i5));
                    this.media[i5] = media;
                }
            }
            tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
            if (zhiBoInfoTW != null) {
                this.twzhibo_info.parseProtobuf(zhiBoInfoTW, i2);
            }
            boolean z = postInfoList.is_share_thread.intValue() == 1;
            this.isShareThread = z;
            if (z) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.originalThreadInfo = originalThreadInfo;
                originalThreadInfo.j(postInfoList.origin_thread_info);
            }
            List<Voice> list3 = postInfoList.voice_info;
            if (list3 != null) {
                this.voice_info = new VoiceData$VoiceModel[list3.size()];
                for (int i6 = 0; i6 < this.voice_info.length; i6++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    voiceData$VoiceModel.parserProtobuf(postInfoList.voice_info.get(i6));
                    this.voice_info[i6] = voiceData$VoiceModel;
                }
            }
            this.isAuthorView = postInfoList.is_author_view.intValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class Quote extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String ip;
        public long post_id;
        public long user_id;
        public String user_name;

        public Quote() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_id = 0L;
            this.user_name = "";
            this.user_id = 0L;
            this.ip = null;
            this.content = "";
        }

        public void parseProtobuf(tbclient.Quote quote) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, quote) == null) || quote == null) {
                return;
            }
            this.post_id = quote.post_id.longValue();
            this.user_id = quote.user_id.longValue();
            this.user_name = quote.user_name;
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }

    /* loaded from: classes4.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long id;
        public String name_show;
        public String portrait;

        public UserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.portrait = "";
            this.name_show = "";
            this.id = 0L;
        }

        public void parseProtobuf(User user) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, user) == null) || user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class Zan extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int num;

        public Zan() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.num = 0;
        }

        public void parseProtobuf(tbclient.Zan zan) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zan) == null) || zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class ZhiBoInfoTW extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public long forum_id;
        public String forum_name;
        public boolean isHeadLive;
        public LabelInfo[] labelList;
        public long last_modified_time;
        public String livecover_src;
        public String livecover_src_bsize;
        public int post_num;
        public int reply_num;
        public ArrayList<Integer> showExpressionViewIndex;
        public int showStyle;
        public long thread_id;
        public String title;
        public UserInfo userInfo;
        public Zan zan;

        public ZhiBoInfoTW() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_num = 0;
            this.title = "";
            this.forum_id = 0L;
            this.livecover_src_bsize = "";
            this.last_modified_time = 0L;
            this.forum_name = "";
            this.thread_id = 0L;
            this.content = "";
            this.livecover_src = "";
            this.reply_num = 0;
            this.zan = new Zan();
            this.userInfo = new UserInfo();
            this.labelList = new LabelInfo[0];
            this.showStyle = -1;
            this.isHeadLive = false;
            this.showExpressionViewIndex = new ArrayList<>();
        }

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, zhiBoInfoTW, i2) == null) || zhiBoInfoTW == null) {
                return;
            }
            this.post_num = zhiBoInfoTW.post_num.intValue();
            this.title = zhiBoInfoTW.title;
            this.forum_id = zhiBoInfoTW.forum_id.longValue();
            this.livecover_src_bsize = zhiBoInfoTW.livecover_src_bsize;
            this.last_modified_time = zhiBoInfoTW.last_modified_time.longValue();
            this.forum_name = zhiBoInfoTW.forum_name;
            this.thread_id = zhiBoInfoTW.thread_id.longValue();
            this.content = zhiBoInfoTW.content;
            this.livecover_src = zhiBoInfoTW.livecover_src;
            this.reply_num = zhiBoInfoTW.reply_num.intValue();
            this.showStyle = i2;
            this.zan.parseProtobuf(zhiBoInfoTW.zan);
            this.isHeadLive = zhiBoInfoTW.is_headline.intValue() == 1;
            this.userInfo.parseProtobuf(zhiBoInfoTW.user);
            List<tbclient.LabelInfo> list = zhiBoInfoTW.labelInfo;
            if (list != null) {
                int size = list.size();
                this.labelList = new LabelInfo[size];
                for (int i3 = 0; i3 < size; i3++) {
                    if (zhiBoInfoTW.labelInfo.get(i3) != null) {
                        LabelInfo labelInfo = new LabelInfo();
                        labelInfo.labelHot = zhiBoInfoTW.labelInfo.get(i3).labelHot.intValue();
                        labelInfo.LabelId = zhiBoInfoTW.labelInfo.get(i3).labelId;
                        labelInfo.labelName = zhiBoInfoTW.labelInfo.get(i3).labelContent;
                        this.labelList[i3] = labelInfo;
                    }
                }
            }
            PersonPostModel.setShowExpressionViewIndexList(this.labelList, this.showExpressionViewIndex);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPostModel f20212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonPostModel personPostModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20212a = personPostModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage)) {
                UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
                if (userPostPageSocketResponsedMessage.getOrginalMessage() == null || userPostPageSocketResponsedMessage.hasError()) {
                    this.f20212a.mOnResult.S(null, this.f20212a.mIsReset);
                    return;
                }
                if (userPostPageSocketResponsedMessage.getPersonPostModel() != null) {
                    userPostPageSocketResponsedMessage.getPersonPostModel().setResponsedMessage(userPostPageSocketResponsedMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.L(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPostModel f20213a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonPostModel personPostModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20213a = personPostModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof UserPostPageHttpResponseMessage)) {
                UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
                if (userPostPageHttpResponseMessage.getOrginalMessage() == null || userPostPageHttpResponseMessage.hasError()) {
                    this.f20213a.mOnResult.S(null, this.f20213a.mIsReset);
                    return;
                }
                if (userPostPageHttpResponseMessage.getPersonPostModel() != null) {
                    userPostPageHttpResponseMessage.getPersonPostModel().setResponsedMessage(userPostPageHttpResponseMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.L(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void L(PersonPostModel personPostModel, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void S(PersonPostModel personPostModel, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-574236311, "Lcom/baidu/tieba/personPolymeric/mode/PersonPostModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-574236311, "Lcom/baidu/tieba/personPolymeric/mode/PersonPostModel;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, d dVar, boolean z, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new a(this, 303002);
        this.pageHttpListener = new b(this, CmdConfigHttp.USER_POST_HTTP_CMD);
        this.mOnResult = dVar;
        setUniqueId(BdUniqueId.gen());
        this.mIsHost = z;
        this.mFrom = i2;
    }

    public static int getNextShowViewIndex(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) {
            for (int i5 = 0; i5 < i2 && i5 < 3; i5++) {
                if (i5 != i3 && i5 != i4) {
                    return i5;
                }
            }
            return -1;
        }
        return invokeIII.intValue;
    }

    public static int getRandom(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) {
            int nextInt = new Random().nextInt(i2);
            return nextInt == i3 ? (nextInt + 1) % i2 : nextInt;
        }
        return invokeII.intValue;
    }

    public static ArrayList<n> mergeDynamicThreadByTime(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, arrayList)) == null) {
            String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
            Iterator<n> it = arrayList.iterator();
            String str = "";
            String str2 = "";
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof CardPersonDynamicThreadData) {
                    CardPersonDynamicThreadData cardPersonDynamicThreadData = (CardPersonDynamicThreadData) next;
                    cardPersonDynamicThreadData.F = true;
                    cardPersonDynamicThreadData.E = true;
                    long j = cardPersonDynamicThreadData.f14544i * 1000;
                    String yearBytime2 = StringHelper.getYearBytime(j);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(j);
                    String dateBytime = StringHelper.getDateBytime(j);
                    if (StringHelper.equals(yearBytime2, yearBytime)) {
                        cardPersonDynamicThreadData.F = false;
                    }
                    if (StringHelper.equals(dateBytime, str) && StringHelper.equals(chineseMonthBytime, str2) && StringHelper.equals(yearBytime2, yearBytime)) {
                        cardPersonDynamicThreadData.E = false;
                    } else {
                        str = dateBytime;
                        yearBytime = yearBytime2;
                        str2 = chineseMonthBytime;
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void setShowExpressionViewIndexList(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, labelInfoArr, arrayList) == null) || labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length && i4 < 3; i4++) {
            if (labelInfoArr[i4] != null) {
                int random = getRandom(3, -1);
                if (random == i2 || random == i3) {
                    random = getNextShowViewIndex(length, i2, i3);
                }
                if (i4 == 0) {
                    i2 = random;
                }
                if (i4 == 1) {
                    i3 = random;
                }
                arrayList.add(Integer.valueOf(random));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, boolean z3, boolean z4, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), user}) == null) {
            fetchPost(tbPageContext, cVar, z, str, z2, 0, z3, z4, user);
        }
    }

    public ResponsedMessage<?> getResponsedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mResponsedMessage : (ResponsedMessage) invokeV.objValue;
    }

    public void parseProtobuf(DataRes dataRes, int i2, User user) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, dataRes, i2, user) == null) || dataRes == null) {
            return;
        }
        this.hide_post = dataRes.hide_post.intValue();
        if (this.mIsHost && ((2 == dataRes.mask_type.intValue() || 3 == dataRes.mask_type.intValue() || 4 == dataRes.mask_type.intValue()) && i2 == 1)) {
            this.postList.add(new j());
            z = false;
        } else {
            z = true;
        }
        if (ListUtils.isEmpty(dataRes.post_list) && z) {
            i iVar = new i();
            this.mCardNullPolymericData = iVar;
            this.postList.add(iVar);
            return;
        }
        for (tbclient.PostInfoList postInfoList : dataRes.post_list) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            PostInfoList postInfoList2 = new PostInfoList();
            int random = getRandom(3, this.mLastChooseStyle);
            this.mLastChooseStyle = random;
            cardPersonDynamicThreadData.e(user, postInfoList, random);
            cardPersonDynamicThreadData.H = this.mIsHost;
            postInfoList2.parseProtobuf(postInfoList, random);
            int i3 = this.mFrom;
            if (i3 == FROM_PERSON_POLYMERIC) {
                cardPersonDynamicThreadData.s = 3;
            } else if (i3 == FROM_PERSON_POST) {
                cardPersonDynamicThreadData.s = 1;
            }
            if (cardPersonDynamicThreadData.m != 33) {
                this.threadList.add(cardPersonDynamicThreadData);
                this.postList.add(postInfoList2);
            }
        }
        this.view_card_num = dataRes.view_card_num.intValue();
        if (dataRes.reddot_deleted_thread.intValue() == 1) {
            this.isShowRecycleBinRedTip = true;
        } else {
            this.isShowRecycleBinRedTip = false;
        }
    }

    public void resetThreadPn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            mRecommentPn = 1;
        }
    }

    public void setOnResult(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.mOnResult = dVar;
        }
    }

    public void setResponsedMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, responsedMessage) == null) {
            this.mResponsedMessage = responsedMessage;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.unique_id = bdUniqueId;
            registerListener(this.pageSocketListener);
            registerListener(this.pageHttpListener);
            this.pageSocketListener.setSelfListener(true);
            this.pageHttpListener.setSelfListener(true);
        }
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, int i2, boolean z3, boolean z4, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3), Boolean.valueOf(z4), user}) == null) {
            this.mIsReset = z;
            if (z3) {
                if (!z && str.equals(mLastThreadUid)) {
                    mThreadPn++;
                } else {
                    mThreadPn = 1;
                    mLastThreadUid = str;
                }
            } else {
                if (z || !str.equals(mLastThreadUid)) {
                    if (this.mFrom == FROM_PERSON_POLYMERIC) {
                        mRecommentPn = 1;
                    } else {
                        mRecommentPn = 0;
                    }
                    mLastThreadUid = str;
                }
                mRecommentPn++;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
            userPostPageRequestMessage.set_sub_type(i2);
            userPostPageRequestMessage.setUid(mLastThreadUid);
            if (z3) {
                userPostPageRequestMessage.setPn(mThreadPn);
            } else {
                userPostPageRequestMessage.setPn(mRecommentPn);
            }
            userPostPageRequestMessage.setRn(20);
            userPostPageRequestMessage.setThread(!z3);
            userPostPageRequestMessage.setHost(this.mIsHost);
            userPostPageRequestMessage.setNeedContent(true);
            userPostPageRequestMessage.setReset(z);
            userPostPageRequestMessage.setFrom(this.mFrom);
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i3 = l.i(TbadkCoreApplication.getInst().getApp());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            userPostPageRequestMessage.set_scr_w(k);
            userPostPageRequestMessage.set_scr_h(i3);
            userPostPageRequestMessage.set_scr_dip(f2);
            userPostPageRequestMessage.set_q_type(i4);
            userPostPageRequestMessage.setCallback(cVar);
            userPostPageRequestMessage.setThreadUser(user);
            if (z4) {
                userPostPageRequestMessage.set_is_view_card(1);
            } else {
                userPostPageRequestMessage.set_is_view_card(0);
            }
            sendMessage(userPostPageRequestMessage);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, d dVar, boolean z, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, dVar, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new a(this, 303002);
        this.pageHttpListener = new b(this, CmdConfigHttp.USER_POST_HTTP_CMD);
        this.mOnResult = dVar;
        setUniqueId(bdUniqueId);
        this.mIsHost = z;
        this.mFrom = i2;
    }

    public UserPostResIdl parseProtobuf(byte[] bArr, int i2, User user) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, bArr, i2, user)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                UserPostResIdl userPostResIdl = (UserPostResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPostResIdl.class);
                parseProtobuf(userPostResIdl.data, i2, user);
                return userPostResIdl;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }
        return (UserPostResIdl) invokeLIL.objValue;
    }
}
