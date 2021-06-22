package com.baidu.tieba.personPolymeric.mode;

import UserPost.DataRes;
import UserPost.UserPostResIdl;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
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
import com.squareup.wire.Wire;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.j2.e.i;
import d.a.o0.j2.e.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tbclient.Abstract;
import tbclient.BaijiahaoInfo;
import tbclient.User;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class PersonPostModel extends BdBaseModel<BaseFragmentActivity> implements Serializable {
    public static int FROM_PERSON_POLYMERIC = 1;
    public static int FROM_PERSON_POST = 2;
    public static final int PAGE_SIZE = 20;
    public static String mLastThreadUid = "";
    public static int mRecommentPn = 1;
    public static int mThreadPn;
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

    /* loaded from: classes5.dex */
    public static class Abs extends OrmObject implements Serializable {
        public int type = 0;
        public String text = "";
        public String src = "";
        public String un = "";
        public String link = "";

        public void parseProtobuf(Abstract r2) {
            if (r2 == null) {
                return;
            }
            this.type = r2.type.intValue();
            this.text = r2.text;
            this.src = r2.src;
            this.un = r2.un;
            this.link = r2.link;
        }
    }

    /* loaded from: classes5.dex */
    public static class AnchorInfo extends OrmObject implements Serializable {
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
        public String publisherName = "";
        public long publisherId = 0;

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo == null) {
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

    /* loaded from: classes5.dex */
    public static class LabelInfo extends OrmObject implements Serializable {
        public int labelHot = 0;
        public String labelName = "";
        public String LabelId = "";

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            if (labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes5.dex */
    public static class LbsInfo implements Serializable {
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            if (lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes5.dex */
    public static class Media extends OrmObject implements Serializable {
        public int type = 0;
        public String small_pic = "";
        public String big_pic = "";
        public String water_pic = "";

        public void parseProtobuf(tbclient.Media media) {
            if (media == null) {
                return;
            }
            this.type = media.type.intValue();
            this.small_pic = media.small_pic;
            this.big_pic = media.big_pic;
            this.water_pic = media.water_pic;
        }
    }

    /* loaded from: classes5.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
        public long post_type = 0;
        public long post_id = 0;
        public int is_author_view = 0;

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            if (postInfoContent == null) {
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

    /* loaded from: classes5.dex */
    public static class PostInfoList extends OrmObject implements Serializable, PreLoadImageProvider, n {
        public static final BdUniqueId POST_INFO = BdUniqueId.gen();
        public int isAuthorView;
        public boolean isDeal;
        public boolean isShareThread;
        public BaijiahaoInfo mBaijiahaoInfo;
        public String name_show;
        public OriginalThreadInfo originalThreadInfo;
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
        public long thread_type = 0;
        public VoiceData$VoiceModel[] voice_info = new VoiceData$VoiceModel[0];
        public ZhiBoInfoTW twzhibo_info = new ZhiBoInfoTW();

        @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
        public ArrayList<PreLoadImageInfo> getImages() {
            Media[] mediaArr;
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

        @Override // d.a.c.k.e.n
        public BdUniqueId getType() {
            return POST_INFO;
        }

        public void parseProtobuf(tbclient.PostInfoList postInfoList, int i2) {
            if (postInfoList == null) {
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

    /* loaded from: classes5.dex */
    public static class Quote extends OrmObject implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public String ip = null;
        public String content = "";

        public void parseProtobuf(tbclient.Quote quote) {
            if (quote == null) {
                return;
            }
            this.post_id = quote.post_id.longValue();
            this.user_id = quote.user_id.longValue();
            this.user_name = quote.user_name;
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }

    /* loaded from: classes5.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public String portrait = "";
        public String name_show = "";
        public long id = 0;

        public void parseProtobuf(User user) {
            if (user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes5.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes5.dex */
    public static class ZhiBoInfoTW extends OrmObject implements Serializable {
        public int post_num = 0;
        public String title = "";
        public long forum_id = 0;
        public String livecover_src_bsize = "";
        public long last_modified_time = 0;
        public String forum_name = "";
        public long thread_id = 0;
        public String content = "";
        public String livecover_src = "";
        public int reply_num = 0;
        public Zan zan = new Zan();
        public UserInfo userInfo = new UserInfo();
        public LabelInfo[] labelList = new LabelInfo[0];
        public int showStyle = -1;
        public boolean isHeadLive = false;
        public ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i2) {
            if (zhiBoInfoTW == null) {
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

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
                UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
                if (userPostPageSocketResponsedMessage.getOrginalMessage() == null || userPostPageSocketResponsedMessage.hasError()) {
                    PersonPostModel.this.mOnResult.T(null, PersonPostModel.this.mIsReset);
                    return;
                }
                if (userPostPageSocketResponsedMessage.getPersonPostModel() != null) {
                    userPostPageSocketResponsedMessage.getPersonPostModel().setResponsedMessage(userPostPageSocketResponsedMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.M(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
                UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
                if (userPostPageHttpResponseMessage.getOrginalMessage() == null || userPostPageHttpResponseMessage.hasError()) {
                    PersonPostModel.this.mOnResult.T(null, PersonPostModel.this.mIsReset);
                    return;
                }
                if (userPostPageHttpResponseMessage.getPersonPostModel() != null) {
                    userPostPageHttpResponseMessage.getPersonPostModel().setResponsedMessage(userPostPageHttpResponseMessage);
                }
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                c callback = userPostPageRequestMessage.getCallback();
                if (callback != null) {
                    callback.M(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void M(PersonPostModel personPostModel, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void T(PersonPostModel personPostModel, boolean z);
    }

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, d dVar, boolean z, int i2) {
        super(tbPageContext);
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new a(303002);
        this.pageHttpListener = new b(CmdConfigHttp.USER_POST_HTTP_CMD);
        this.mOnResult = dVar;
        setUniqueId(BdUniqueId.gen());
        this.mIsHost = z;
        this.mFrom = i2;
    }

    public static int getNextShowViewIndex(int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i2 && i5 < 3; i5++) {
            if (i5 != i3 && i5 != i4) {
                return i5;
            }
        }
        return -1;
    }

    public static int getRandom(int i2, int i3) {
        int nextInt = new Random().nextInt(i2);
        return nextInt == i3 ? (nextInt + 1) % i2 : nextInt;
    }

    public static ArrayList<n> mergeDynamicThreadByTime(ArrayList<n> arrayList) {
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
                long j = cardPersonDynamicThreadData.f14418i * 1000;
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

    public static void setShowExpressionViewIndexList(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        if (labelInfoArr == null) {
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
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, boolean z3, boolean z4, User user) {
        fetchPost(tbPageContext, cVar, z, str, z2, 0, z3, z4, user);
    }

    public ResponsedMessage<?> getResponsedMessage() {
        return this.mResponsedMessage;
    }

    public void parseProtobuf(DataRes dataRes, int i2, User user) {
        boolean z;
        if (dataRes == null) {
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
            cardPersonDynamicThreadData.B(user, postInfoList, random);
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
        mRecommentPn = 1;
    }

    public void setOnResult(d dVar) {
        this.mOnResult = dVar;
    }

    public void setResponsedMessage(ResponsedMessage<?> responsedMessage) {
        this.mResponsedMessage = responsedMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        registerListener(this.pageSocketListener);
        registerListener(this.pageHttpListener);
        this.pageSocketListener.setSelfListener(true);
        this.pageHttpListener.setSelfListener(true);
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar, boolean z, String str, boolean z2, int i2, boolean z3, boolean z4, User user) {
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

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, d dVar, boolean z, int i2) {
        super(tbPageContext);
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new a(303002);
        this.pageHttpListener = new b(CmdConfigHttp.USER_POST_HTTP_CMD);
        this.mOnResult = dVar;
        setUniqueId(bdUniqueId);
        this.mIsHost = z;
        this.mFrom = i2;
    }

    public UserPostResIdl parseProtobuf(byte[] bArr, int i2, User user) {
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
}
