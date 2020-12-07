package com.baidu.tieba.personPolymeric.mode;

import UserPost.DataRes;
import UserPost.UserPostResIdl;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.c.i;
import com.baidu.tieba.personPolymeric.c.j;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageRequestMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import tbclient.Abstract;
import tbclient.BaijiahaoInfo;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonPostModel extends BdBaseModel<BaseFragmentActivity> implements Serializable {
    public static final int PAGE_SIZE = 20;
    public int hide_post;
    public boolean isShowRecycleBinRedTip;
    private i mCardNullPolymericData;
    private int mFrom;
    private boolean mIsHost;
    private boolean mIsReset;
    private int mLastChooseStyle;
    private b mOnResult;
    private ResponsedMessage<?> mResponsedMessage;
    private HttpMessageListener pageHttpListener;
    private c pageSocketListener;
    public final ArrayList<q> postList;
    public final ArrayList<q> threadList;
    public int view_card_num;
    public static int FROM_PERSON_POLYMERIC = 1;
    public static int FROM_PERSON_POST = 2;
    private static int mThreadPn = 0;
    private static int mRecommentPn = 1;
    private static String mLastThreadUid = "";

    /* loaded from: classes24.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);
    }

    /* loaded from: classes24.dex */
    public interface b {
        void a(PersonPostModel personPostModel, boolean z);
    }

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, b bVar, boolean z, int i) {
        super(tbPageContext);
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new c(CmdConfigSocket.CMD_USER_POST_PAGE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPostModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
                    UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
                    if (userPostPageSocketResponsedMessage.getOrginalMessage() == null || userPostPageSocketResponsedMessage.hasError()) {
                        PersonPostModel.this.mOnResult.a(null, PersonPostModel.this.mIsReset);
                        return;
                    }
                    if (userPostPageSocketResponsedMessage.getPersonPostModel() != null) {
                        userPostPageSocketResponsedMessage.getPersonPostModel().setResponsedMessage(userPostPageSocketResponsedMessage);
                    }
                    UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                    a callback = userPostPageRequestMessage.getCallback();
                    if (callback != null) {
                        callback.b(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    }
                }
            }
        };
        this.pageHttpListener = new HttpMessageListener(1001503) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPostModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
                    UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
                    if (userPostPageHttpResponseMessage.getOrginalMessage() == null || userPostPageHttpResponseMessage.hasError()) {
                        PersonPostModel.this.mOnResult.a(null, PersonPostModel.this.mIsReset);
                        return;
                    }
                    if (userPostPageHttpResponseMessage.getPersonPostModel() != null) {
                        userPostPageHttpResponseMessage.getPersonPostModel().setResponsedMessage(userPostPageHttpResponseMessage);
                    }
                    UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                    a callback = userPostPageRequestMessage.getCallback();
                    if (callback != null) {
                        callback.b(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    }
                }
            }
        };
        this.mOnResult = bVar;
        setUniqueId(BdUniqueId.gen());
        this.mIsHost = z;
        this.mFrom = i;
    }

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, b bVar, boolean z, int i) {
        super(tbPageContext);
        this.mFrom = -1;
        this.threadList = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.hide_post = 0;
        this.mIsReset = false;
        this.mLastChooseStyle = -1;
        this.pageSocketListener = new c(CmdConfigSocket.CMD_USER_POST_PAGE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPostModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
                    UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
                    if (userPostPageSocketResponsedMessage.getOrginalMessage() == null || userPostPageSocketResponsedMessage.hasError()) {
                        PersonPostModel.this.mOnResult.a(null, PersonPostModel.this.mIsReset);
                        return;
                    }
                    if (userPostPageSocketResponsedMessage.getPersonPostModel() != null) {
                        userPostPageSocketResponsedMessage.getPersonPostModel().setResponsedMessage(userPostPageSocketResponsedMessage);
                    }
                    UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
                    a callback = userPostPageRequestMessage.getCallback();
                    if (callback != null) {
                        callback.b(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    }
                }
            }
        };
        this.pageHttpListener = new HttpMessageListener(1001503) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPostModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
                    UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
                    if (userPostPageHttpResponseMessage.getOrginalMessage() == null || userPostPageHttpResponseMessage.hasError()) {
                        PersonPostModel.this.mOnResult.a(null, PersonPostModel.this.mIsReset);
                        return;
                    }
                    if (userPostPageHttpResponseMessage.getPersonPostModel() != null) {
                        userPostPageHttpResponseMessage.getPersonPostModel().setResponsedMessage(userPostPageHttpResponseMessage);
                    }
                    UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
                    a callback = userPostPageRequestMessage.getCallback();
                    if (callback != null) {
                        callback.b(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
                    }
                }
            }
        };
        this.mOnResult = bVar;
        setUniqueId(bdUniqueId);
        this.mIsHost = z;
        this.mFrom = i;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        return this.mResponsedMessage;
    }

    public void setResponsedMessage(ResponsedMessage<?> responsedMessage) {
        this.mResponsedMessage = responsedMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, a aVar, boolean z, String str, boolean z2, boolean z3, boolean z4, User user) {
        fetchPost(tbPageContext, aVar, z, str, z2, 0, z3, z4, user);
    }

    public void resetThreadPn() {
        mRecommentPn = 1;
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, a aVar, boolean z, String str, boolean z2, int i, boolean z3, boolean z4, User user) {
        this.mIsReset = z;
        if (z3) {
            if (z || !str.equals(mLastThreadUid)) {
                mThreadPn = 1;
                mLastThreadUid = str;
            } else {
                mThreadPn++;
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
        userPostPageRequestMessage.set_sub_type(i);
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
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = 1;
        if (av.btX().btY()) {
            i2 = 2;
        }
        userPostPageRequestMessage.set_scr_w(equipmentWidth);
        userPostPageRequestMessage.set_scr_h(equipmentHeight);
        userPostPageRequestMessage.set_scr_dip(f);
        userPostPageRequestMessage.set_q_type(i2);
        userPostPageRequestMessage.setCallback(aVar);
        userPostPageRequestMessage.setThreadUser(user);
        if (z4) {
            userPostPageRequestMessage.set_is_view_card(1);
        } else {
            userPostPageRequestMessage.set_is_view_card(0);
        }
        sendMessage(userPostPageRequestMessage);
    }

    public void parseProtobuf(DataRes dataRes, int i, User user) {
        boolean z;
        if (dataRes != null) {
            this.hide_post = dataRes.hide_post.intValue();
            if (this.mIsHost && ((2 == dataRes.mask_type.intValue() || 3 == dataRes.mask_type.intValue() || 4 == dataRes.mask_type.intValue()) && i == 1)) {
                this.postList.add(new j());
                z = false;
            } else {
                z = true;
            }
            if (y.isEmpty(dataRes.post_list) && z) {
                this.mCardNullPolymericData = new i();
                this.postList.add(this.mCardNullPolymericData);
                return;
            }
            for (tbclient.PostInfoList postInfoList : dataRes.post_list) {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                PostInfoList postInfoList2 = new PostInfoList();
                int random = getRandom(3, this.mLastChooseStyle);
                this.mLastChooseStyle = random;
                cardPersonDynamicThreadData.a(user, postInfoList, random);
                cardPersonDynamicThreadData.isHost = this.mIsHost;
                postInfoList2.parseProtobuf(postInfoList, random);
                if (this.mFrom == FROM_PERSON_POLYMERIC) {
                    cardPersonDynamicThreadData.from = 3;
                } else if (this.mFrom == FROM_PERSON_POST) {
                    cardPersonDynamicThreadData.from = 1;
                }
                if (cardPersonDynamicThreadData.inM != 33) {
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
    }

    public static int getRandom(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    public UserPostResIdl parseProtobuf(byte[] bArr, int i, User user) {
        if (bArr == null) {
            return null;
        }
        try {
            UserPostResIdl userPostResIdl = (UserPostResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPostResIdl.class);
            parseProtobuf(userPostResIdl.data, i, user);
            return userPostResIdl;
        } catch (Throwable th) {
            BdLog.detailException(th);
            return null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        registerListener(this.pageSocketListener);
        registerListener(this.pageHttpListener);
        this.pageSocketListener.setSelfListener(true);
        this.pageHttpListener.setSelfListener(true);
    }

    public void setOnResult(b bVar) {
        this.mOnResult = bVar;
    }

    /* loaded from: classes24.dex */
    public static class PostInfoList extends OrmObject implements q, ah, Serializable {
        public static final BdUniqueId POST_INFO = BdUniqueId.gen();
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
        public VoiceData.VoiceModel[] voice_info = new VoiceData.VoiceModel[0];
        public ZhiBoInfoTW twzhibo_info = new ZhiBoInfoTW();

        public void parseProtobuf(tbclient.PostInfoList postInfoList, int i) {
            if (postInfoList != null) {
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
                    this.content = new PostInfoContent[postInfoList.content.size()];
                    for (int i3 = 0; i3 < this.content.length; i3++) {
                        PostInfoContent postInfoContent = new PostInfoContent();
                        postInfoContent.parseProtobuf(postInfoList.content.get(i3));
                        this.content[i3] = postInfoContent;
                    }
                }
                this.quote.parseProtobuf(postInfoList.quote);
                this.reply_num = postInfoList.reply_num.intValue();
                this.is_post_deleted = postInfoList.is_post_deleted.intValue();
                this.lbs_info.parseProtobuf(postInfoList.lbs_info);
                this.anchor_info.parseProtobuf(postInfoList.anchor_info);
                if (postInfoList.media != null) {
                    this.media = new Media[postInfoList.media.size()];
                    for (int i4 = 0; i4 < this.media.length; i4++) {
                        Media media = new Media();
                        media.parseProtobuf(postInfoList.media.get(i4));
                        this.media[i4] = media;
                    }
                }
                if (postInfoList.twzhibo_info != null) {
                    this.twzhibo_info.parseProtobuf(postInfoList.twzhibo_info, i);
                }
                this.isShareThread = postInfoList.is_share_thread.intValue() == 1;
                if (this.isShareThread) {
                    this.originalThreadInfo = new OriginalThreadInfo();
                    this.originalThreadInfo.a(postInfoList.origin_thread_info);
                }
                if (postInfoList.voice_info != null) {
                    this.voice_info = new VoiceData.VoiceModel[postInfoList.voice_info.size()];
                    for (int i5 = 0; i5 < this.voice_info.length; i5++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        voiceModel.parserProtobuf(postInfoList.voice_info.get(i5));
                        this.voice_info[i5] = voiceModel;
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ah
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

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return POST_INFO;
        }
    }

    /* loaded from: classes24.dex */
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

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i) {
            if (zhiBoInfoTW != null) {
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
                this.isHeadLive = zhiBoInfoTW.is_headline.intValue() == 1;
                this.userInfo.parseProtobuf(zhiBoInfoTW.user);
                if (zhiBoInfoTW.labelInfo != null) {
                    int size = zhiBoInfoTW.labelInfo.size();
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
    }

    public static void setShowExpressionViewIndexList(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        if (labelInfoArr != null) {
            int length = labelInfoArr.length;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            while (i < length && i < 3) {
                if (labelInfoArr[i] != null) {
                    int random = getRandom(3, -1);
                    if (random == i2 || random == i3) {
                        random = getNextShowViewIndex(length, i2, i3);
                    }
                    if (i == 0) {
                        i2 = random;
                    }
                    if (i == 1) {
                        i3 = random;
                    }
                    arrayList.add(Integer.valueOf(random));
                }
                i++;
                i2 = i2;
            }
        }
    }

    public static ArrayList<q> mergeDynamicThreadByTime(ArrayList<q> arrayList) {
        String str;
        String str2;
        String str3;
        String yearBytime = au.getYearBytime(System.currentTimeMillis());
        String str4 = "";
        String str5 = "";
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof CardPersonDynamicThreadData) {
                ((CardPersonDynamicThreadData) next).inZ = true;
                ((CardPersonDynamicThreadData) next).inY = true;
                long j = ((CardPersonDynamicThreadData) next).inK * 1000;
                String yearBytime2 = au.getYearBytime(j);
                String chineseMonthBytime = au.getChineseMonthBytime(j);
                String dateBytime = au.getDateBytime(j);
                if (au.equals(yearBytime2, yearBytime)) {
                    ((CardPersonDynamicThreadData) next).inZ = false;
                }
                if (au.equals(dateBytime, str5) && au.equals(chineseMonthBytime, str4) && au.equals(yearBytime2, yearBytime)) {
                    ((CardPersonDynamicThreadData) next).inY = false;
                    str = str5;
                    str2 = str4;
                    str3 = yearBytime;
                } else {
                    str = dateBytime;
                    str2 = chineseMonthBytime;
                    str3 = yearBytime2;
                }
            } else {
                str = str5;
                str2 = str4;
                str3 = yearBytime;
            }
            str4 = str2;
            yearBytime = str3;
            str5 = str;
        }
        return arrayList;
    }

    private static int getNextShowViewIndex(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    /* loaded from: classes24.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan != null) {
                this.num = zan.num.intValue();
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public String portrait = "";
        public String name_show = "";
        public long id = 0;

        public void parseProtobuf(User user) {
            if (user != null) {
                this.portrait = user.portrait;
                this.name_show = user.name_show;
                this.id = user.id.longValue();
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class LabelInfo extends OrmObject implements Serializable {
        public int labelHot = 0;
        public String labelName = "";
        public String LabelId = "";

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            if (labelInfo != null) {
                this.labelHot = labelInfo.labelHot.intValue();
                this.labelName = labelInfo.labelContent;
                this.LabelId = labelInfo.labelId;
            }
        }
    }

    /* loaded from: classes24.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
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

    /* loaded from: classes24.dex */
    public static class Abs extends OrmObject implements Serializable {
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

    /* loaded from: classes24.dex */
    public static class Quote extends OrmObject implements Serializable {
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

    /* loaded from: classes24.dex */
    public static class Media extends OrmObject implements Serializable {
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

    /* loaded from: classes24.dex */
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
            if (anchorInfo != null) {
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
    }

    /* loaded from: classes24.dex */
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
