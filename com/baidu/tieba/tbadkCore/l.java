package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class l implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public ActivityConfig activityConfig;
    private AgreeBanner agreeBanner;
    private AntiData anti;
    public List<BottomMenu> bottomMenuList;
    public com.baidu.tieba.frs.b brandAdData;
    private h businessPromot;
    private bj cardVideoInfo;
    private com.baidu.tbadk.core.data.o carrierEnterData;
    private List<CategoryInfo> categoryInfos;
    private b chatGroup;
    public PopInfo enterFrsDialogInfo;
    protected boolean fortuneBag;
    protected String fortuneDesc;
    protected ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    private ForumHeadIcon forumHeadIcon;
    private String gameName;
    private List<FrsTabInfo> gameTabInfo;
    private String gameUrl;
    protected o gconAccount;
    private boolean hasGame;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    private List<FeedForumData> likeFeedForumDataList;
    private AlaLiveNotify liveNotify;
    private List<com.baidu.adp.widget.ListView.m> mCardShipinNew;
    private List<Integer> mCardShipinPos;
    private NavTabInfo mEntelechyTabInfo;
    private f mFrsInsertLiveData;
    private g mFrsStageLiveData;
    private n mFrsVideoActivityData;
    private com.baidu.tieba.h.b mGameRankListData;
    public FrsTabInfo mNewChapterInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected ap page;
    private int photoLivePos;
    private aw privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private com.baidu.tieba.tbadkCore.data.o redpacketRainData;
    private ba schoolRecommendInfo;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    private m star;
    public StarRank starRank;
    protected ArrayList<com.baidu.adp.widget.ListView.m> threadList;
    protected List<Long> threadListIds;
    private UserData userData;
    public List<User> userList;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tieba.frs.r userRecommend;
    private WorldcupSkin worldcupSkin;
    public int needLog = 0;
    private List<j> starEnter = new ArrayList();
    private int isNewUrl = 0;
    private ArrayList<com.baidu.tbadk.core.data.q> color_eggs = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r mActivityHeadData = null;
    private int frsDefaultTabId = 1;
    private boolean isShowRedTip = false;
    private String bawuCenterUrl = null;
    private z headSdkData = null;
    public aa recommendBookData = null;
    public RecomPostTopic postTopic = null;
    private com.baidu.tbadk.core.data.s bookInfoData = null;
    private Integer mangaReadRecordChapterId = -1;
    public com.baidu.tbadk.core.data.x presentInfoData = null;
    private com.baidu.tbadk.core.data.u headlineImgInfoData = null;
    private int schoolRecommendPos = -1;
    protected List<com.baidu.adp.widget.ListView.m> topThreadList = null;
    private int forumState = 0;
    private int accessFlag = 0;
    private int alaLiveCount = 0;
    private int gameDefaultTabId = 0;
    public int mErrorNo = 0;
    public int defaultShowTab = 1;

    public l() {
        initData();
    }

    private void initData() {
        this.forum = new ForumData();
        this.threadList = new ArrayList<>();
        this.topThreadList = new ArrayList();
        this.userMap = new HashMap<>();
        this.page = new ap();
        this.star = new m();
        this.userData = new UserData();
        this.gconAccount = new o();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new aw();
        this.mCardShipinNew = new ArrayList();
        this.mCardShipinPos = new ArrayList();
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                parserProtobuf(frsPageResIdl.data);
                return frsPageResIdl;
            }
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void parserProtobuf(DataRes dataRes) {
        MetaData metaData;
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.v.isEmpty(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.isEmpty(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                            if (qVar.a(colorEgg)) {
                                this.color_eggs.add(qVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hasGame = dataRes.forum.has_game.intValue() == 1;
                    this.gameUrl = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.r();
                    this.mActivityHeadData.a(dataRes.brand_forum_info.head_imgs);
                    this.brandAdData = new com.baidu.tieba.frs.b();
                    this.brandAdData.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                        this.oriForumInfoList = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.oriForumInfoList.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.isEmpty(dataRes.activityhead.head_imgs)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.r();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !aq.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.r();
                    this.mActivityHeadData.a(dataRes.private_forum_info.head_imgs);
                }
                this.bottomMenuList = dataRes.bottom_menu;
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData2 = new MetaData();
                        metaData2.parserProtobuf(list.get(i));
                        String userId = metaData2.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData2.getUserId(), metaData2);
                        }
                    }
                }
                this.userList = dataRes.user_list;
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.fortuneBag = dataRes.fortune_bag.intValue() == 1;
                this.fortuneDesc = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.starEnter.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        j jVar = new j();
                        jVar.a(list2.get(i2));
                        this.starEnter.add(jVar);
                    }
                }
                this.gconAccount.a(dataRes.gcon_account);
                this.forum.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.threadListIds = dataRes.thread_id_list;
                this.anti.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.d.e(dataRes.anti.block_pop_info);
                }
                this.chatGroup.a(dataRes.group);
                this.page.a(dataRes.page);
                this.star.a(dataRes.frs_star);
                this.userData.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.mEntelechyTabInfo = builder.build(true);
                } else {
                    this.mEntelechyTabInfo = dataRes.nav_tab_info;
                }
                if (this.mEntelechyTabInfo != null && com.baidu.tbadk.core.util.v.getItem(this.mEntelechyTabInfo.tab, 0) != null) {
                    this.defaultShowTab = ((FrsTabInfo) com.baidu.tbadk.core.util.v.getItem(this.mEntelechyTabInfo.tab, 0)).tab_id.intValue();
                }
                if (this.mEntelechyTabInfo != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mEntelechyTabInfo.head)) {
                    this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                handleDefaultTab(dataRes.frs_tab_default.intValue());
                this.photoLivePos = dataRes.twzhibo_pos.intValue();
                this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
                convertThreadInfoToThreadData(dataRes.thread_list, longValue);
                this.categoryInfos = dataRes.category_list;
                if (!aq.isEmpty(dataRes.bawu_enter_url)) {
                    this.bawuCenterUrl = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.headSdkData = new z();
                    this.headSdkData.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.recommendBookData = new aa();
                    this.recommendBookData.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.bookInfoData = new com.baidu.tbadk.core.data.s();
                    this.bookInfoData.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.presentInfoData = new com.baidu.tbadk.core.data.x();
                    this.presentInfoData.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.headlineImgInfoData = new com.baidu.tbadk.core.data.u();
                    this.headlineImgInfoData.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.business_promot != null) {
                    this.businessPromot = new h();
                    this.businessPromot.a(dataRes.business_promot);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.cardVideoInfo = new bj();
                    this.cardVideoInfo.ft(true);
                    this.cardVideoInfo.jy(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.aAT();
                    this.cardVideoInfo.cPY = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && longValue != 0) {
                        this.cardVideoInfo.setFid(longValue);
                    }
                    this.cardVideoInfo.w(this.color_eggs);
                    this.cardVideoInfo.fs(!this.cardVideoInfo.azB());
                    if (this.cardVideoInfo.azX() != null && this.cardVideoInfo.azX().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.azX().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                        mVar.bE(metaData.getPendantData().aLA());
                        mVar.sk(metaData.getPendantData().ayq());
                        this.cardVideoInfo.azX().setPendantData(mVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new f();
                    this.mFrsInsertLiveData.kdf = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bj bjVar = new bj();
                            bjVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bjVar.cPY = this.isBrandForum;
                            arrayList.add(bjVar);
                        }
                    }
                    this.mFrsInsertLiveData.kde = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new g();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bj bjVar2 = new bj();
                            bjVar2.a(dataRes.ala_stage_list.get(i4));
                            bjVar2.cPY = this.isBrandForum;
                            arrayList2.add(bjVar2);
                        }
                    }
                    this.mFrsStageLiveData.kdh = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new ba();
                    this.schoolRecommendInfo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.carrierEnterData = new com.baidu.tbadk.core.data.o();
                    this.carrierEnterData.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.needLog = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.cBK().HK(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bj bjVar3 = new bj();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            bjVar3.jy(this.mCardShipinPos.get(i5).intValue());
                        }
                        bjVar3.ft(true);
                        bjVar3.a(dataRes.card_shipin_new.get(i5));
                        bjVar3.cPY = this.isBrandForum;
                        this.mCardShipinNew.add(bjVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.h.b();
                    this.mGameRankListData.a(dataRes.esport);
                }
                this.agreeBanner = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.userRecommend = new com.baidu.tieba.frs.r();
                    this.userRecommend.a(dataRes.user_extend);
                }
                this.liveNotify = dataRes.live_frs_notify;
                this.gameTabInfo = dataRes.frs_game_tab_info;
                this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
                this.forumHeadIcon = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.mFrsVideoActivityData = new n();
                    this.mFrsVideoActivityData.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.forumArIno = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.starRank = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.postTopic = dataRes.recom_post_topic;
                }
                this.mWindowToast = dataRes.window_toast;
                this.activityConfig = dataRes.activity_config;
                this.worldcupSkin = dataRes.worldcup_skin;
                this.redpacketRainData = new com.baidu.tieba.tbadkCore.data.o();
                this.redpacketRainData.a(dataRes.redpacketrain);
                this.isFrsVideoAutoPlay = dataRes.video_auto_play.intValue() == 1;
                this.smartAppAvatar = dataRes.smart_app_avatar;
                this.smartApp = dataRes.smart_app;
                this.nebulaHotThreads = dataRes.nebula_hot_threads;
                if (dataRes.private_forum_info != null) {
                    this.privateForumTotalData.a(dataRes.private_forum_info);
                }
                this.forumActiveInfo = dataRes.private_forum_active_info;
                this.userList = dataRes.user_list;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner getAgreeBanner() {
        return this.agreeBanner;
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        this.agreeBanner = agreeBanner;
    }

    public ForumHeadIcon getForumHeadIcon() {
        return this.forumHeadIcon;
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        this.forumHeadIcon = forumHeadIcon;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    private void handleDefaultTab(int i) {
        this.frsDefaultTabId = 1;
        if (this.mEntelechyTabInfo != null && this.mEntelechyTabInfo.tab != null && this.mEntelechyTabInfo.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.frsDefaultTabId = i;
                    return;
                }
            }
        }
    }

    public void convertThreadInfoToThreadData(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.setUserMap(this.userMap);
                    bjVar.a(threadInfo);
                    bjVar.aAT();
                    if (bjVar.getFid() == 0 && j != 0) {
                        bjVar.setFid(j);
                    }
                    if (StringUtils.isNull(bjVar.aAc())) {
                        bjVar.sp(this.forum.getName());
                    }
                    bjVar.w(this.color_eggs);
                    bjVar.cPY = this.forum.isBrandForum;
                    bjVar.fy(true);
                    if (!TextUtils.isEmpty(bjVar.aBf())) {
                        ae aeVar = new ae();
                        aeVar.sg(bjVar.aBf());
                        this.threadList.add(aeVar);
                    } else {
                        this.threadList.add(bjVar);
                    }
                }
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo() {
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
        setThreadList(switchThreadDataToThreadCardInfo);
        return switchThreadDataToThreadCardInfo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if (next instanceof ae) {
                ((ae) next).position = i;
                arrayList2.add(next);
            } else if (next instanceof bj) {
                bj bjVar = (bj) next;
                int[] imageWidthAndHeight = imageWidthAndHeight(bjVar);
                if (bjVar.getType() == bj.cNf && !bjVar.isTop()) {
                    bi biVar = new bi();
                    biVar.cNb = bjVar;
                    biVar.position = i;
                    biVar.cMQ = true;
                    arrayList2.add(biVar);
                    bi biVar2 = new bi();
                    biVar2.cNb = bjVar;
                    biVar2.position = i;
                    if (bjVar.aBT()) {
                        biVar2.cMV = true;
                    } else if (bjVar.aBb() == 1) {
                        biVar2.cMT = true;
                        biVar2.cNc = imageWidthAndHeight[0];
                        biVar2.cNd = imageWidthAndHeight[1];
                    } else if (bjVar.aBb() >= 2) {
                        biVar2.cMU = true;
                    } else {
                        biVar2.cMR = true;
                    }
                    arrayList2.add(biVar2);
                    if (bjVar.aAJ() != null) {
                        bi biVar3 = new bi();
                        biVar3.cNa = true;
                        biVar3.cNb = bjVar;
                        biVar3.position = i;
                        arrayList2.add(biVar3);
                    }
                    if (bjVar.aBx() != null) {
                        bi biVar4 = new bi();
                        biVar4.cMX = true;
                        biVar4.cNb = bjVar;
                        biVar4.position = i;
                        arrayList2.add(biVar4);
                    }
                    bi biVar5 = new bi();
                    biVar5.cMW = true;
                    biVar5.cNb = bjVar;
                    biVar5.position = i;
                    arrayList2.add(biVar5);
                } else if (bjVar.getType() == bj.cNv && !bjVar.isTop()) {
                    bi biVar6 = new bi();
                    biVar6.cNb = bjVar;
                    biVar6.position = i;
                    biVar6.cMQ = true;
                    arrayList2.add(biVar6);
                    bi biVar7 = new bi();
                    biVar7.cNb = bjVar;
                    biVar7.position = i;
                    biVar7.cMY = true;
                    arrayList2.add(biVar7);
                    if (bjVar.aAJ() != null) {
                        bi biVar8 = new bi();
                        biVar8.cNa = true;
                        biVar8.cNb = bjVar;
                        biVar8.position = i;
                        arrayList2.add(biVar8);
                    }
                    if (bjVar.aBx() != null) {
                        bi biVar9 = new bi();
                        biVar9.cMX = true;
                        biVar9.cNb = bjVar;
                        biVar9.position = i;
                        arrayList2.add(biVar9);
                    }
                    bi biVar10 = new bi();
                    biVar10.cMW = true;
                    biVar10.cNb = bjVar;
                    biVar10.position = i;
                    arrayList2.add(biVar10);
                } else if (bjVar.aAo() != null && !bjVar.aBa() && bjVar.aAa()) {
                    bi biVar11 = new bi();
                    biVar11.cNb = bjVar;
                    biVar11.position = i;
                    biVar11.cMQ = true;
                    arrayList2.add(biVar11);
                    bi biVar12 = new bi();
                    biVar12.cNb = bjVar;
                    biVar12.position = i;
                    biVar12.cMZ = true;
                    arrayList2.add(biVar12);
                    if (bjVar.aAJ() != null) {
                        bi biVar13 = new bi();
                        biVar13.cNa = true;
                        biVar13.cNb = bjVar;
                        biVar13.position = i;
                        arrayList2.add(biVar13);
                    }
                    if (bjVar.aBx() != null) {
                        bi biVar14 = new bi();
                        biVar14.cMX = true;
                        biVar14.cNb = bjVar;
                        biVar14.position = i;
                        arrayList2.add(biVar14);
                    }
                    bi biVar15 = new bi();
                    biVar15.cMW = true;
                    biVar15.cNb = bjVar;
                    biVar15.position = i;
                    arrayList2.add(biVar15);
                } else if (bjVar.getType() == bj.cNs && bjVar.ayL()) {
                    bjVar.position = i;
                    arrayList2.add(bjVar);
                } else {
                    bi biVar16 = new bi();
                    biVar16.cNb = bjVar;
                    biVar16.position = i;
                    arrayList2.add(biVar16);
                }
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        return arrayList2;
    }

    public int[] imageWidthAndHeight(bj bjVar) {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (com.baidu.tbadk.core.i.axy().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aAh) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aAh.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, 0);
        if (mediaData2 != null && mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
            if (mediaData2.picWidth * 2 <= mediaData2.picHeight) {
                i = ((int) (i2 * 1.5f)) + dimensionPixelSize;
                i2 = (i2 * 2) + dimensionPixelSize;
            } else if (mediaData2.picHeight * 2 <= mediaData2.picWidth) {
                i = (i2 * 2) + dimensionPixelSize;
                i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
            } else if (mediaData2.picWidth < i2) {
                if (mediaData2.picHeight < i2) {
                    if (mediaData2.picWidth < mediaData2.picHeight) {
                        int i4 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                        i = i2;
                        i2 = i4;
                    } else {
                        i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                    }
                } else if (mediaData2.picHeight < i2 || mediaData2.picHeight >= i2 * 2) {
                    i2 = 0;
                    i = 0;
                } else {
                    int i5 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                    i = i2;
                    i2 = i5;
                }
            } else if (mediaData2.picWidth >= i2 && mediaData2.picWidth < i2 * 2) {
                if (mediaData2.picHeight < i2) {
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                    int i6 = mediaData2.picWidth;
                    i2 = mediaData2.picHeight;
                    i = i6;
                } else {
                    i2 = (i2 * 2) + dimensionPixelSize;
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                }
            } else if (mediaData2.picHeight < i2) {
                i2 = 0;
                i = 0;
            } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                int i7 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i7) / mediaData2.picWidth;
                i = i7;
            } else if (mediaData2.picWidth < mediaData2.picHeight) {
                i2 = (i2 * 2) + dimensionPixelSize;
                i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
            } else {
                int i8 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i8) / mediaData2.picWidth;
                i = i8;
            }
        } else {
            i2 = (i2 * 2) + dimensionPixelSize;
            i = i2;
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public int getAlaLiveCount() {
        return this.alaLiveCount;
    }

    public void setAlaLiveCount(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] toCacheByteArray() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean initByByteArray(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
    }

    public h getBusinessPromot() {
        return this.businessPromot;
    }

    public void setBusinessPromot(h hVar) {
        this.businessPromot = hVar;
    }

    public ForumData getForum() {
        return this.forum;
    }

    public int getForumState() {
        return this.forumState;
    }

    public void setForumState(int i) {
        this.forumState = i;
    }

    public int getAccessFlag() {
        return this.accessFlag;
    }

    public void setAccessFlag(int i) {
        this.accessFlag = i;
    }

    public void setForum(ForumData forumData) {
        this.forum = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getThreadList() {
        return this.threadList;
    }

    public void setThreadList(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public void setAnti(AntiData antiData) {
        this.anti = antiData;
    }

    public ap getPage() {
        return this.page;
    }

    public void setPage(ap apVar) {
        this.page = apVar;
    }

    public m getStar() {
        return this.star;
    }

    public void setStar(m mVar) {
        this.star = mVar;
    }

    public com.baidu.tbadk.core.data.r getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public void setActivityHeadData(com.baidu.tbadk.core.data.r rVar) {
        this.mActivityHeadData = rVar;
    }

    public boolean isFortuneBag() {
        return this.fortuneBag;
    }

    public void setFortuneBag(boolean z) {
        this.fortuneBag = z;
    }

    public String getFortuneDesc() {
        return this.fortuneDesc;
    }

    public void setFortuneDesc(String str) {
        this.fortuneDesc = str;
    }

    public o getGconAccount() {
        return this.gconAccount;
    }

    public void setGconAccount(o oVar) {
        this.gconAccount = oVar;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Long> getThreadListIds() {
        return this.threadListIds;
    }

    public void setThreadListIds(List<Long> list) {
        this.threadListIds = list;
    }

    public b getChatGroup() {
        return this.chatGroup;
    }

    public void setChatGroup(b bVar) {
        this.chatGroup = bVar;
    }

    public boolean isHasGame() {
        return this.hasGame;
    }

    public void setHasGame(boolean z) {
        this.hasGame = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<j> getStarEnter() {
        return this.starEnter;
    }

    public void setStarEnter(List<j> list) {
        this.starEnter = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int getIsNewUrl() {
        return this.isNewUrl;
    }

    public void setIsNewUrl(int i) {
        this.isNewUrl = i;
    }

    public String getGameUrl() {
        return this.gameUrl;
    }

    public void setGameUrl(String str) {
        this.gameUrl = str;
    }

    public int getPhotoLivePos() {
        return this.photoLivePos;
    }

    public void setPhotoLivePos(int i) {
        this.photoLivePos = i;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        return this.likeFeedForumDataList;
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        this.likeFeedForumDataList = list;
    }

    public void deleteLikeFeedForum(String str) {
        if (this.likeFeedForumDataList != null && str != null) {
            for (FeedForumData feedForumData : this.likeFeedForumDataList) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.likeFeedForumDataList.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        this.categoryInfos = list;
    }

    public void setBawuCenterUrl(String str) {
        this.bawuCenterUrl = str;
    }

    public String getBawuCenterUrl() {
        return this.bawuCenterUrl;
    }

    public bj getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(bj bjVar) {
        this.cardVideoInfo = bjVar;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public void setFrsDefaultTabId(int i) {
        this.frsDefaultTabId = i;
    }

    public z getHeadSdkData() {
        return this.headSdkData;
    }

    public void setHeadSdkData(z zVar) {
        this.headSdkData = zVar;
    }

    public com.baidu.tbadk.core.data.s getBookInfo() {
        return this.bookInfoData;
    }

    public void setBookInfo(com.baidu.tbadk.core.data.s sVar) {
        this.bookInfoData = sVar;
    }

    public com.baidu.tbadk.core.data.u getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public void setHeadlineImgInfoData(com.baidu.tbadk.core.data.u uVar) {
        this.headlineImgInfoData = uVar;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public void setSchoolRecommendPos(int i) {
        this.schoolRecommendPos = i;
    }

    public ba getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(ba baVar) {
        this.schoolRecommendInfo = baVar;
    }

    public NavTabInfo getEntelechyTabInfo() {
        return this.mEntelechyTabInfo;
    }

    public void setEntelechyTabInfo(NavTabInfo navTabInfo) {
        this.mEntelechyTabInfo = navTabInfo;
    }

    public boolean isShowRedTip() {
        return this.isShowRedTip;
    }

    public void setIsShowRedTip(boolean z) {
        this.isShowRedTip = z;
    }

    public com.baidu.tbadk.core.data.o getCarrierEnterData() {
        return this.carrierEnterData;
    }

    public void setCarrierEnterData(com.baidu.tbadk.core.data.o oVar) {
        this.carrierEnterData = oVar;
    }

    public int getSortType() {
        return this.mSortType;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public Integer getMangaReadRecordChapterId() {
        return this.mangaReadRecordChapterId;
    }

    public void setMangaReadRecordChapterId(Integer num) {
        this.mangaReadRecordChapterId = num;
    }

    public List<Integer> getCardShipinPos() {
        return this.mCardShipinPos;
    }

    public void setCardShipinPos(List<Integer> list) {
        this.mCardShipinPos = list;
    }

    public List<com.baidu.adp.widget.ListView.m> getCardShipinNew() {
        return this.mCardShipinNew;
    }

    public void setCardShipinNew(List<com.baidu.adp.widget.ListView.m> list) {
        this.mCardShipinNew = list;
    }

    public com.baidu.tieba.h.b getGameRankListData() {
        return this.mGameRankListData;
    }

    public void setGameRankListData(com.baidu.tieba.h.b bVar) {
        this.mGameRankListData = bVar;
    }

    public AlaLiveNotify getLiveNotify() {
        return this.liveNotify;
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        this.liveNotify = alaLiveNotify;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        return this.gameTabInfo;
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        this.gameTabInfo = list;
    }

    public void setGameDefaultTabId(int i) {
        this.gameDefaultTabId = i;
    }

    public int getGameDefaultTabId() {
        return this.gameDefaultTabId;
    }

    public void setUserRecommend(com.baidu.tieba.frs.r rVar) {
        this.userRecommend = rVar;
    }

    public com.baidu.tieba.frs.r getUserRecommend() {
        return this.userRecommend;
    }

    public n getFrsVideoActivityData() {
        return this.mFrsVideoActivityData;
    }

    public void setFrsVideoActivityData(n nVar) {
        this.mFrsVideoActivityData = nVar;
    }

    public f getFrsInsertLiveData() {
        return this.mFrsInsertLiveData;
    }

    public void setFrsInsertLiveData(f fVar) {
        this.mFrsInsertLiveData = fVar;
    }

    public g getFrsStageLiveData() {
        return this.mFrsStageLiveData;
    }

    public void setFrsStageLiveData(g gVar) {
        this.mFrsStageLiveData = gVar;
    }

    public WorldcupSkin getWorldCupSkin() {
        return this.worldcupSkin;
    }

    public com.baidu.tieba.tbadkCore.data.o getRedpacketRainData() {
        return this.redpacketRainData;
    }

    public void setRedpacketRainData(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.redpacketRainData = oVar;
    }

    public aw getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(aw awVar) {
        this.privateForumTotalData = awVar;
    }
}
