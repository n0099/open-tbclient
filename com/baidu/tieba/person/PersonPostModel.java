package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.Abstract;
import tbclient.User;
import tbclient.UserPost.DataRes;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class PersonPostModel extends com.baidu.adp.base.e<BaseFragmentActivity> implements Serializable {
    public static final int PAGE_SIZE = 20;
    private static int cZE = 0;
    private static String cZF = "";
    public int hide_post;
    private int mLastChooseStyle;
    public List<PostInfoList> post_list;

    /* loaded from: classes.dex */
    public interface a {
        void a(PersonPostModel personPostModel, boolean z);
    }

    public PersonPostModel() {
        this.post_list = new ArrayList();
        this.hide_post = 0;
        this.mLastChooseStyle = -1;
    }

    public PersonPostModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.post_list = new ArrayList();
        this.hide_post = 0;
        this.mLastChooseStyle = -1;
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
        fetchPost(tbPageContext, aVar, z, str, z2, 0);
    }

    public void fetchPost(TbPageContext<BaseFragmentActivity> tbPageContext, a aVar, boolean z, String str, boolean z2, int i) {
        if (z || !str.equals(cZF)) {
            cZE = 1;
            cZF = str;
        } else {
            cZE++;
        }
        if (tbPageContext != null) {
            this.unique_id = tbPageContext.getUniqueId();
        }
        UserPostPageRequestMessage userPostPageRequestMessage = new UserPostPageRequestMessage();
        userPostPageRequestMessage.set_sub_type(i);
        userPostPageRequestMessage.setUid(cZF);
        userPostPageRequestMessage.setPn(cZE);
        userPostPageRequestMessage.setRn(20);
        userPostPageRequestMessage.setThread(z2);
        userPostPageRequestMessage.setNeedContent(true);
        userPostPageRequestMessage.setReset(z);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ax.wg().wi() ? 2 : 1;
        userPostPageRequestMessage.set_scr_w(K);
        userPostPageRequestMessage.set_scr_h(L);
        userPostPageRequestMessage.set_scr_dip(f);
        userPostPageRequestMessage.set_q_type(i2);
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
                    int random = getRandom(3, this.mLastChooseStyle);
                    this.mLastChooseStyle = random;
                    postInfoList2.parseProtobuf(postInfoList, random);
                    if (postInfoList2.thread_type != 33) {
                        this.post_list.add(postInfoList2);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.post_list.add(postInfoList2);
                    }
                }
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
    public static class PostInfoList extends com.baidu.adp.lib.a.b.a.a.i implements com.baidu.tbadk.core.util.ai, Serializable {
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
            }
        }

        @Override // com.baidu.tbadk.core.util.ai
        public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
            Media[] mediaArr;
            ArrayList<com.baidu.tbadk.core.util.ah> arrayList = new ArrayList<>();
            for (Media media : this.media) {
                if (media.big_pic != null) {
                    com.baidu.tbadk.core.util.ah ahVar = new com.baidu.tbadk.core.util.ah();
                    ahVar.imgUrl = media.big_pic;
                    ahVar.acq = 10;
                    arrayList.add(ahVar);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class ZhiBoInfoTW extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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
                        random = l(length, i2, i3);
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

    private static int l(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    /* loaded from: classes.dex */
    public static class Zan extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan != null) {
                this.num = zan.num.intValue();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UserInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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

    /* loaded from: classes.dex */
    public static class LabelInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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
