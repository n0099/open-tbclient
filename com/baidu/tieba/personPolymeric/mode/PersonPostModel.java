package com.baidu.tieba.personPolymeric.mode;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.g9;
import com.baidu.tieba.hb;
import com.baidu.tieba.ma9;
import com.baidu.tieba.na9;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageRequestMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.ri;
import com.baidu.tieba.rn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import tbclient.Abstract;
import tbclient.BaijiahaoInfo;
import tbclient.User;
import tbclient.UserPost.DataRes;
import tbclient.UserPost.UserPostResIdl;
import tbclient.Voice;
/* loaded from: classes7.dex */
public class PersonPostModel extends BdBaseModel<BaseFragmentActivity> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_PERSON_POLYMERIC = 1;
    public static final int FROM_PERSON_POST = 2;
    public static final int PAGE_SIZE = 20;
    public static String mLastThreadUid = "";
    public static int mRecommentPn = 1;
    public static int mThreadPn;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Map<String, Object> dataResMap;
    public int hide_post;
    public boolean isShowRecycleBinRedTip;
    public ma9 mCardNullPolymericData;
    public int mFrom;
    public boolean mIsHost;
    public boolean mIsReset;
    public int mLastChooseStyle;
    public d mOnResult;
    public ResponsedMessage<?> mResponsedMessage;
    public HttpMessageListener pageHttpListener;
    public hb pageSocketListener;
    public final ArrayList<rn> postList;
    public final ArrayList<rn> threadList;
    public int view_card_num;

    /* loaded from: classes7.dex */
    public interface c {
        void r0(PersonPostModel personPostModel, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void z0(PersonPostModel personPostModel, boolean z);
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

    public static int getNextShowViewIndex(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65541, null, i, i2, i3)) == null) {
            for (int i4 = 0; i4 < i && i4 < 3; i4++) {
                if (i4 != i2 && i4 != i3) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeIII.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
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

        public void parseProtobuf(Abstract r5) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, r5) != null) || r5 == null) {
                return;
            }
            this.type = r5.type.intValue();
            this.text = r5.text;
            this.src = r5.src;
            this.un = r5.un;
            this.link = r5.link;
        }
    }

    /* loaded from: classes7.dex */
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
            this.publisherName = "";
            this.publisherId = 0L;
        }

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, anchorInfo) != null) || anchorInfo == null) {
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

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, labelInfo) != null) || labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, lbsInfo) != null) || lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes7.dex */
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
        }

        public void parseProtobuf(tbclient.Media media) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, media) != null) || media == null) {
                return;
            }
            this.type = media.type.intValue();
            this.small_pic = media.small_pic;
            this.big_pic = media.big_pic;
            this.water_pic = media.water_pic;
        }
    }

    /* loaded from: classes7.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String contentStr;
        public long create_time;
        public int is_author_view;
        public Abs[] post_content;
        public long post_id;
        public long post_type;
        public String targetScheme;
        public String threadId;
        public String threadType;
        public String timeStr;

        public PostInfoContent() {
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
            this.post_content = new Abs[0];
            this.create_time = 0L;
            this.post_type = 0L;
            this.post_id = 0L;
            this.is_author_view = 0;
            this.threadId = "0";
            this.threadType = "";
            this.contentStr = "";
            this.timeStr = "";
            this.targetScheme = "";
        }

        public String getPostId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.valueOf(this.post_id);
            }
            return (String) invokeV.objValue;
        }

        public void parseProtobuf(long j, long j2, tbclient.PostInfoContent postInfoContent) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), postInfoContent}) != null) || postInfoContent == null) {
                return;
            }
            this.threadId = String.valueOf(j);
            this.threadType = String.valueOf(j2);
            this.create_time = postInfoContent.create_time.longValue();
            this.post_id = postInfoContent.post_id.longValue();
            this.post_type = postInfoContent.post_type.longValue();
            this.is_author_view = postInfoContent.is_author_view.intValue();
            this.targetScheme = postInfoContent.target_scheme;
            List<Abstract> list = postInfoContent.post_content;
            if (list != null) {
                this.post_content = new Abs[list.size()];
                for (int i = 0; i < this.post_content.length; i++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoContent.post_content.get(i));
                    this.post_content[i] = abs;
                }
            }
            if (this.post_content.length > 0) {
                StringBuilder sb = new StringBuilder();
                if (!this.post_content[0].text.startsWith("回复 ")) {
                    sb.append("回复：");
                }
                for (Abs abs2 : this.post_content) {
                    sb.append(abs2.text);
                }
                this.contentStr = sb.toString();
            }
            if (this.is_author_view == 1) {
                str = " " + TbadkCoreApplication.getInst().getResources().getString(R.string.not_open_read);
            } else {
                str = "";
            }
            this.timeStr = StringHelper.getFormatTime(this.create_time * 1000) + str;
        }
    }

    /* loaded from: classes7.dex */
    public static class PostInfoList extends OrmObject implements Serializable, PreLoadImageProvider, rn {
        public static /* synthetic */ Interceptable $ic;
        public static final BdUniqueId POST_INFO;
        public transient /* synthetic */ FieldHolder $fh;
        public String abs;
        public Abs[] abs_thread;
        public AnchorInfo anchor_info;
        public List<PostInfoContent> content;
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
        public String targetScheme;
        public long thread_id;
        public long thread_type;
        public String title;
        public ZhiBoInfoTW twzhibo_info;
        public long user_id;
        public String user_name;
        public String user_portrait;
        public VoiceData.VoiceModel[] voice_info;

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

        @Override // com.baidu.tieba.rn
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return POST_INFO;
            }
            return (BdUniqueId) invokeV.objValue;
        }

        public PostInfoList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            this.content = new ArrayList();
            this.quote = new Quote();
            this.reply_num = 0;
            this.media = new Media[0];
            this.anchor_info = new AnchorInfo();
            this.lbs_info = new LbsInfo();
            this.is_post_deleted = 0;
            this.thread_type = 0L;
            this.voice_info = new VoiceData.VoiceModel[0];
            this.twzhibo_info = new ZhiBoInfoTW();
            this.targetScheme = "";
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

        public void parseProtobuf(tbclient.PostInfoList postInfoList, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, postInfoList, i) != null) || postInfoList == null) {
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
            this.targetScheme = postInfoList.target_scheme;
            if (postInfoList._abstract != null) {
                this.abs_thread = new Abs[postInfoList.abstract_thread.size()];
                for (int i2 = 0; i2 < this.abs_thread.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                    this.abs_thread[i2] = abs;
                }
            }
            this.abs = postInfoList._abstract;
            this.mBaijiahaoInfo = postInfoList.baijiahao_info;
            this.content_thread = postInfoList.content_thread;
            if (postInfoList.content != null) {
                this.content.clear();
                for (int i3 = 0; i3 < postInfoList.content.size(); i3++) {
                    PostInfoContent postInfoContent = new PostInfoContent();
                    postInfoContent.parseProtobuf(postInfoList.thread_id.longValue(), postInfoList.thread_type.longValue(), postInfoList.content.get(i3));
                    this.content.add(postInfoContent);
                }
            }
            this.quote.parseProtobuf(postInfoList.quote);
            this.reply_num = postInfoList.reply_num.intValue();
            this.is_post_deleted = postInfoList.is_post_deleted.intValue();
            this.lbs_info.parseProtobuf(postInfoList.lbs_info);
            this.anchor_info.parseProtobuf(postInfoList.anchor_info);
            List<tbclient.Media> list = postInfoList.media;
            if (list != null) {
                this.media = new Media[list.size()];
                for (int i4 = 0; i4 < this.media.length; i4++) {
                    Media media = new Media();
                    media.parseProtobuf(postInfoList.media.get(i4));
                    this.media[i4] = media;
                }
            }
            tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
            if (zhiBoInfoTW != null) {
                this.twzhibo_info.parseProtobuf(zhiBoInfoTW, i);
            }
            boolean z = true;
            if (postInfoList.is_share_thread.intValue() != 1) {
                z = false;
            }
            this.isShareThread = z;
            if (z) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.originalThreadInfo = originalThreadInfo;
                originalThreadInfo.o(postInfoList.origin_thread_info);
            }
            List<Voice> list2 = postInfoList.voice_info;
            if (list2 != null) {
                this.voice_info = new VoiceData.VoiceModel[list2.size()];
                for (int i5 = 0; i5 < this.voice_info.length; i5++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(postInfoList.voice_info.get(i5));
                    this.voice_info[i5] = voiceModel;
                }
            }
            this.isAuthorView = postInfoList.is_author_view.intValue();
        }
    }

    /* loaded from: classes7.dex */
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
            this.ip = null;
            this.content = "";
        }

        public void parseProtobuf(tbclient.Quote quote) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, quote) != null) || quote == null) {
                return;
            }
            this.post_id = quote.post_id.longValue();
            this.user_id = quote.user_id.longValue();
            this.user_name = quote.user_name;
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, user) != null) || user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes7.dex */
    public static class Zan extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int num;

        public Zan() {
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
            this.num = 0;
        }

        public void parseProtobuf(tbclient.Zan zan) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zan) != null) || zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, zhiBoInfoTW, i) != null) || zhiBoInfoTW == null) {
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
            this.showStyle = i;
            this.zan.parseProtobuf(zhiBoInfoTW.zan);
            boolean z = true;
            if (zhiBoInfoTW.is_headline.intValue() != 1) {
                z = false;
            }
            this.isHeadLive = z;
            this.userInfo.parseProtobuf(zhiBoInfoTW.user);
            List<tbclient.LabelInfo> list = zhiBoInfoTW.labelInfo;
            if (list != null) {
                int size = list.size();
                this.labelList = new LabelInfo[size];
                for (int i2 = 0; i2 < size; i2++) {
                    if (zhiBoInfoTW.labelInfo.get(i2) != null) {
                        LabelInfo labelInfo = new LabelInfo();
                        labelInfo.labelHot = zhiBoInfoTW.labelInfo.get(i2).labelHot.intValue();
                        labelInfo.LabelId = zhiBoInfoTW.labelInfo.get(i2).labelId;
                        labelInfo.labelName = zhiBoInfoTW.labelInfo.get(i2).labelContent;
                        this.labelList[i2] = labelInfo;
                    }
                }
            }
            PersonPostModel.setShowExpressionViewIndexList(this.labelList, this.showExpressionViewIndex);
        }
    }

    /* loaded from: classes7.dex */
    public class a extends hb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPostModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonPostModel personPostModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPostModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof UserPostPageSocketResponsedMessage)) {
                return;
            }
            UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
            if (userPostPageSocketResponsedMessage.getOrginalMessage() != null && !userPostPageSocketResponsedMessage.hasError()) {
                if (userPostPageSocketResponsedMessage.getPersonPostModel() != null) {
                    userPostPageSocketResponsedMessage.getPersonPostModel().setResponsedMessage(userPostPageSocketResponsedMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.r0(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    return;
                }
                return;
            }
            this.a.mOnResult.z0(null, this.a.mIsReset);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonPostModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonPostModel personPostModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPostModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personPostModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof UserPostPageHttpResponseMessage)) {
                return;
            }
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() != null && !userPostPageHttpResponseMessage.hasError()) {
                if (userPostPageHttpResponseMessage.getPersonPostModel() != null) {
                    userPostPageHttpResponseMessage.getPersonPostModel().setResponsedMessage(userPostPageHttpResponseMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.r0(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    return;
                }
                return;
            }
            this.a.mOnResult.z0(null, this.a.mIsReset);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, d dVar, boolean z, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, dVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((g9) newInitContext.callArgs[0]);
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
        this.mFrom = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, d dVar, boolean z, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((g9) newInitContext.callArgs[0]);
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
        this.mFrom = i;
    }

    public void setOnResult(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.mOnResult = dVar;
        }
    }

    public void setResponsedMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, responsedMessage) == null) {
            this.mResponsedMessage = responsedMessage;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            this.unique_id = bdUniqueId;
            registerListener(this.pageSocketListener);
            registerListener(this.pageHttpListener);
            this.pageSocketListener.setSelfListener(true);
            this.pageHttpListener.setSelfListener(true);
        }
    }

    public static int getRandom(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            int nextInt = new Random().nextInt(i);
            if (nextInt == i2) {
                return (nextInt + 1) % i;
            }
            return nextInt;
        }
        return invokeII.intValue;
    }

    public static ArrayList<rn> mergeDynamicThreadByTime(ArrayList<rn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, arrayList)) == null) {
            String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
            Iterator<rn> it = arrayList.iterator();
            String str = "";
            String str2 = "";
            while (it.hasNext()) {
                rn next = it.next();
                if (next instanceof CardPersonDynamicThreadData) {
                    CardPersonDynamicThreadData cardPersonDynamicThreadData = (CardPersonDynamicThreadData) next;
                    cardPersonDynamicThreadData.D = true;
                    cardPersonDynamicThreadData.C = true;
                    long j = cardPersonDynamicThreadData.g * 1000;
                    String yearBytime2 = StringHelper.getYearBytime(j);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(j);
                    String dateBytime = StringHelper.getDateBytime(j);
                    if (StringHelper.equals(yearBytime2, yearBytime)) {
                        cardPersonDynamicThreadData.D = false;
                    }
                    if (StringHelper.equals(dateBytime, str) && StringHelper.equals(chineseMonthBytime, str2) && StringHelper.equals(yearBytime2, yearBytime)) {
                        cardPersonDynamicThreadData.C = false;
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

    private void parseProtobufInternal(DataRes dataRes, int i, User user, @Nullable MetaData metaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65544, this, dataRes, i, user, metaData) != null) || dataRes == null) {
            return;
        }
        this.dataResMap = DataExt.toMap(dataRes);
        this.hide_post = dataRes.hide_post.intValue();
        if (this.mIsHost && ((2 == dataRes.mask_type.intValue() || 3 == dataRes.mask_type.intValue() || 4 == dataRes.mask_type.intValue()) && i == 1)) {
            this.postList.add(new na9());
            z = false;
        } else {
            z = true;
        }
        if (ListUtils.isEmpty(dataRes.post_list) && z) {
            ma9 ma9Var = new ma9();
            this.mCardNullPolymericData = ma9Var;
            this.postList.add(ma9Var);
            return;
        }
        for (tbclient.PostInfoList postInfoList : dataRes.post_list) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            PostInfoList postInfoList2 = new PostInfoList();
            int random = getRandom(3, this.mLastChooseStyle);
            this.mLastChooseStyle = random;
            cardPersonDynamicThreadData.e(user, metaData, postInfoList, random);
            cardPersonDynamicThreadData.F = this.mIsHost;
            postInfoList2.parseProtobuf(postInfoList, random);
            int i2 = this.mFrom;
            if (i2 == 1) {
                cardPersonDynamicThreadData.q = 3;
            } else if (i2 == 2) {
                cardPersonDynamicThreadData.q = 1;
            }
            if (cardPersonDynamicThreadData.k != 33) {
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

    public static void setShowExpressionViewIndexList(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, labelInfoArr, arrayList) != null) || labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < length && i3 < 3; i3++) {
            if (labelInfoArr[i3] != null) {
                int random = getRandom(3, -1);
                if (random == i || random == i2) {
                    random = getNextShowViewIndex(length, i, i2);
                }
                if (i3 == 0) {
                    i = random;
                }
                if (i3 == 1) {
                    i2 = random;
                }
                arrayList.add(Integer.valueOf(random));
            }
        }
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, int i, boolean z3, boolean z4, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4), user}) == null) {
            fetchPost(tbPageContext, cVar, z, str, z2, i, z3, z4, user, null, null, null, null, null, null);
        }
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, int i, boolean z3, boolean z4, @Nullable User user, @Nullable MetaData metaData, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Long l, @Nullable String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4), user, metaData, num, num2, num3, l, str2}) == null) {
            this.mIsReset = z;
            if (z3) {
                if (!z && str.equals(mLastThreadUid)) {
                    mThreadPn++;
                } else {
                    mThreadPn = 1;
                    mLastThreadUid = str;
                }
            } else {
                if (z || (!TextUtils.isEmpty(str) && !str.equals(mLastThreadUid))) {
                    if (this.mFrom == 1) {
                        mRecommentPn = 1;
                    } else {
                        mRecommentPn = 0;
                    }
                    mLastThreadUid = str;
                }
                mRecommentPn++;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
            userPostPageRequestMessage.set_sub_type(i);
            if (!TextUtils.isEmpty(str)) {
                userPostPageRequestMessage.setUid(mLastThreadUid);
            }
            if (z3) {
                userPostPageRequestMessage.setPn(mThreadPn);
            } else {
                userPostPageRequestMessage.setPn(mRecommentPn);
            }
            userPostPageRequestMessage.setPortrait(str2);
            userPostPageRequestMessage.setRn(20);
            userPostPageRequestMessage.setThread(!z3);
            userPostPageRequestMessage.setHost(this.mIsHost);
            userPostPageRequestMessage.setNeedContent(true);
            userPostPageRequestMessage.setReset(z);
            userPostPageRequestMessage.setFrom(this.mFrom);
            int l2 = ri.l(TbadkCoreApplication.getInst().getApp());
            int j = ri.j(TbadkCoreApplication.getInst().getApp());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            userPostPageRequestMessage.set_scr_w(l2);
            userPostPageRequestMessage.set_scr_h(j);
            userPostPageRequestMessage.set_scr_dip(f);
            userPostPageRequestMessage.set_q_type(i2);
            userPostPageRequestMessage.setCallback(cVar);
            userPostPageRequestMessage.setThreadUser(user);
            userPostPageRequestMessage.setThreadAuthor(metaData);
            if (z4) {
                userPostPageRequestMessage.set_is_view_card(1);
            } else {
                userPostPageRequestMessage.set_is_view_card(0);
            }
            userPostPageRequestMessage.setWorkTabId(num);
            userPostPageRequestMessage.setType(num2);
            userPostPageRequestMessage.setFromType(num3);
            userPostPageRequestMessage.setBeginThreadId(l);
            sendMessage(userPostPageRequestMessage);
        }
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, int i, boolean z3, boolean z4, User user, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4), user, str2}) == null) {
            fetchPost(tbPageContext, cVar, z, str, z2, i, z3, z4, user, null, null, null, null, null, str2);
        }
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, boolean z3, boolean z4, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbPageContext, cVar, Boolean.valueOf(z), str, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), user}) == null) {
            fetchPost(tbPageContext, cVar, z, str, z2, 0, z3, z4, user, null, null, null, null, null, null);
        }
    }

    public void fetchPostByBeginThreadId(@NonNull String str, @NonNull c cVar, @Nullable MetaData metaData, @NonNull Integer num, @NonNull Integer num2, @NonNull Integer num3, @NonNull Integer num4, @NonNull Long l, @NonNull Integer num5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, cVar, metaData, num, num2, num3, num4, l, num5}) == null) {
            UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
            userPostPageRequestMessage.set_sub_type(num2.intValue());
            userPostPageRequestMessage.setUid(str);
            userPostPageRequestMessage.setPn(num5.intValue());
            userPostPageRequestMessage.setRn(20);
            int i = 1;
            userPostPageRequestMessage.setThread(true);
            userPostPageRequestMessage.setHost(this.mIsHost);
            userPostPageRequestMessage.setNeedContent(true);
            userPostPageRequestMessage.setReset(false);
            userPostPageRequestMessage.setFrom(this.mFrom);
            int l2 = ri.l(TbadkCoreApplication.getInst().getApp());
            int j = ri.j(TbadkCoreApplication.getInst().getApp());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            }
            userPostPageRequestMessage.set_scr_w(l2);
            userPostPageRequestMessage.set_scr_h(j);
            userPostPageRequestMessage.set_scr_dip(f);
            userPostPageRequestMessage.set_q_type(i);
            userPostPageRequestMessage.setCallback(cVar);
            userPostPageRequestMessage.setThreadAuthor(metaData);
            userPostPageRequestMessage.set_is_view_card(0);
            userPostPageRequestMessage.setWorkTabId(num);
            userPostPageRequestMessage.setType(num3);
            userPostPageRequestMessage.setFromType(num4);
            userPostPageRequestMessage.setBeginThreadId(l);
            sendMessage(userPostPageRequestMessage);
        }
    }

    @Nullable
    public Map<String, Object> getDataResMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.dataResMap;
        }
        return (Map) invokeV.objValue;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mResponsedMessage;
        }
        return (ResponsedMessage) invokeV.objValue;
    }

    public void resetThreadPn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            mRecommentPn = 1;
        }
    }

    public UserPostResIdl parseProtobuf(byte[] bArr, int i, User user, @Nullable MetaData metaData) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048585, this, bArr, i, user, metaData)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                UserPostResIdl userPostResIdl = (UserPostResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPostResIdl.class);
                parseProtobufInternal(userPostResIdl.data, i, user, metaData);
                return userPostResIdl;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }
        return (UserPostResIdl) invokeLILL.objValue;
    }
}
