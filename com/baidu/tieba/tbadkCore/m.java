package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
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
import tbclient.FrsTabInfo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ServiceArea;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public ActivityConfig activityConfig;
    private AgreeBanner agreeBanner;
    private AntiData anti;
    public WindowToast bazhuExam;
    public List<BottomMenu> bottomMenuList;
    public com.baidu.tieba.frs.d brandAdData;
    private i businessPromot;
    private bu cardVideoInfo;
    private com.baidu.tbadk.core.data.q carrierEnterData;
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
    protected p gconAccount;
    private boolean hasGame;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public Integer is_get_horse_race_lamp;
    public ItemInfo itemInfo;
    private List<FeedForumData> likeFeedForumDataList;
    private AlaLiveNotify liveNotify;
    private List<com.baidu.adp.widget.ListView.q> mCardShipinNew;
    private List<Integer> mCardShipinPos;
    private NavTabInfo mEntelechyTabInfo;
    private g mFrsInsertLiveData;
    private h mFrsStageLiveData;
    private o mFrsVideoActivityData;
    private com.baidu.tieba.h.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    private HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected at page;
    private int photoLivePos;
    private bb privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bj schoolRecommendInfo;
    public y serviceAreaData;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    private n star;
    public StarRank starRank;
    protected ArrayList<com.baidu.adp.widget.ListView.q> threadList;
    protected List<Long> threadListIds;
    private UserData userData;
    public List<User> userList;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tieba.frs.x userRecommend;
    public int needLog = 0;
    private List<k> starEnter = new ArrayList();
    private int isNewUrl = 0;
    private ArrayList<com.baidu.tbadk.core.data.s> color_eggs = new ArrayList<>();
    protected com.baidu.tbadk.core.data.u mActivityHeadData = null;
    private int frsDefaultTabId = 1;
    private boolean isShowRedTip = false;
    private String bawuCenterUrl = null;
    private com.baidu.tbadk.core.data.ac headSdkData = null;
    public ad recommendBookData = null;
    public RecomPostTopic postTopic = null;
    private com.baidu.tbadk.core.data.v bookInfoData = null;
    private Integer mangaReadRecordChapterId = -1;
    public com.baidu.tbadk.core.data.aa presentInfoData = null;
    private com.baidu.tbadk.core.data.x headlineImgInfoData = null;
    private int schoolRecommendPos = -1;
    protected List<com.baidu.adp.widget.ListView.q> topThreadList = null;
    private int forumState = 0;
    private int accessFlag = 0;
    private int alaLiveCount = 0;
    private int gameDefaultTabId = 0;
    public int mErrorNo = 0;
    public int defaultShowTab = 1;
    private long mDataParseTime = 0;

    public m() {
        initData();
    }

    private void initData() {
        this.forum = new ForumData();
        this.threadList = new ArrayList<>();
        this.topThreadList = new ArrayList();
        this.userMap = new HashMap<>();
        this.page = new at();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new p();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new bb();
        this.mCardShipinNew = new ArrayList();
        this.mCardShipinPos = new ArrayList();
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                parserProtobuf(frsPageResIdl.data);
            }
            if (z) {
                if (this.mDataParseTime == 0) {
                    this.mDataParseTime = System.currentTimeMillis() - currentTimeMillis;
                    return frsPageResIdl;
                }
                return frsPageResIdl;
            }
            this.mDataParseTime = 0L;
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void parserProtobuf(DataRes dataRes) {
        int i;
        MetaData metaData;
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.w.isEmpty(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.w.isEmpty(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                            if (sVar.a(colorEgg)) {
                                this.color_eggs.add(sVar);
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
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.u();
                    this.mActivityHeadData.a(dataRes.brand_forum_info.head_imgs);
                    this.brandAdData = new com.baidu.tieba.frs.d();
                    this.brandAdData.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.w.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                        this.oriForumInfoList = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.oriForumInfoList.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.isEmpty(dataRes.activityhead.head_imgs)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.u();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !ar.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.u();
                    this.mActivityHeadData.a(dataRes.private_forum_info.head_imgs);
                }
                this.bottomMenuList = dataRes.bottom_menu;
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MetaData metaData2 = new MetaData();
                        metaData2.parserProtobuf(list.get(i2));
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
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        k kVar = new k();
                        kVar.a(list2.get(i3));
                        this.starEnter.add(kVar);
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
                if (this.mEntelechyTabInfo != null && com.baidu.tbadk.core.util.w.getItem(this.mEntelechyTabInfo.tab, 0) != null) {
                    this.defaultShowTab = ((FrsTabInfo) com.baidu.tbadk.core.util.w.getItem(this.mEntelechyTabInfo.tab, 0)).tab_id.intValue();
                }
                if (this.mEntelechyTabInfo != null && !com.baidu.tbadk.core.util.w.isEmpty(this.mEntelechyTabInfo.head)) {
                    this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                handleDefaultTab(dataRes.frs_tab_default.intValue());
                this.photoLivePos = dataRes.twzhibo_pos.intValue();
                this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
                convertThreadInfoToThreadData(dataRes.thread_list, longValue);
                this.categoryInfos = dataRes.category_list;
                if (!ar.isEmpty(dataRes.bawu_enter_url)) {
                    this.bawuCenterUrl = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.headSdkData = new com.baidu.tbadk.core.data.ac();
                    this.headSdkData.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.recommendBookData = new ad();
                    this.recommendBookData.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.bookInfoData = new com.baidu.tbadk.core.data.v();
                    this.bookInfoData.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.presentInfoData = new com.baidu.tbadk.core.data.aa();
                    this.presentInfoData.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.headlineImgInfoData = new com.baidu.tbadk.core.data.x();
                    this.headlineImgInfoData.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.business_promot != null) {
                    this.businessPromot = new i();
                    this.businessPromot.a(dataRes.business_promot);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.cardVideoInfo = new bu();
                    this.cardVideoInfo.gY(true);
                    this.cardVideoInfo.kM(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.aTn();
                    this.cardVideoInfo.dOj = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && longValue != 0) {
                        this.cardVideoInfo.setFid(longValue);
                    }
                    this.cardVideoInfo.y(this.color_eggs);
                    this.cardVideoInfo.gX(!this.cardVideoInfo.aRU());
                    if (this.cardVideoInfo.aSp() != null && this.cardVideoInfo.aSp().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.aSp().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                        lVar.ct(metaData.getPendantData().beE());
                        lVar.vN(metaData.getPendantData().aQl());
                        this.cardVideoInfo.aSp().setPendantData(lVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.lDD = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            bu buVar = new bu();
                            buVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            buVar.dOj = this.isBrandForum;
                            arrayList.add(buVar);
                        }
                    }
                    this.mFrsInsertLiveData.lDC = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            bu buVar2 = new bu();
                            buVar2.a(dataRes.ala_stage_list.get(i5));
                            buVar2.dOj = this.isBrandForum;
                            arrayList2.add(buVar2);
                        }
                    }
                    this.mFrsStageLiveData.lDF = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bj();
                    this.schoolRecommendInfo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.carrierEnterData = new com.baidu.tbadk.core.data.q();
                    this.carrierEnterData.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.needLog = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.cZG().LU(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bu buVar3 = new bu();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            buVar3.kM(this.mCardShipinPos.get(i6).intValue());
                        }
                        buVar3.gY(true);
                        buVar3.a(dataRes.card_shipin_new.get(i6));
                        buVar3.dOj = this.isBrandForum;
                        this.mCardShipinNew.add(buVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.h.b();
                    this.mGameRankListData.a(dataRes.esport);
                }
                this.agreeBanner = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.userRecommend = new com.baidu.tieba.frs.x();
                    this.userRecommend.a(dataRes.user_extend);
                }
                this.liveNotify = dataRes.live_frs_notify;
                this.gameTabInfo = dataRes.frs_game_tab_info;
                this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
                this.forumHeadIcon = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.mFrsVideoActivityData = new o();
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
                this.isFrsVideoAutoPlay = dataRes.video_auto_play.intValue() == 1;
                this.smartAppAvatar = dataRes.smart_app_avatar;
                this.smartApp = dataRes.smart_app;
                this.nebulaHotThreads = dataRes.nebula_hot_threads;
                if (dataRes.private_forum_info != null) {
                    this.privateForumTotalData.a(dataRes.private_forum_info);
                }
                this.forumActiveInfo = dataRes.private_forum_active_info;
                this.userList = dataRes.user_list;
                this.mHotUserRankData = dataRes.hot_user_entry;
                this.bazhuExam = dataRes.bazhu_exam_fail;
                if (!com.baidu.tbadk.core.util.w.isEmpty(dataRes.service_area)) {
                    this.serviceAreaData = new y();
                    ArrayList arrayList3 = new ArrayList();
                    int i7 = 0;
                    for (ServiceArea serviceArea : dataRes.service_area) {
                        if (serviceArea != null) {
                            z zVar = new z();
                            zVar.imageUrl = serviceArea.picurl;
                            zVar.name = serviceArea.servicename;
                            zVar.category = serviceArea.service_type;
                            if (zVar.category != null && zVar.category.equals("原生小程序") && serviceArea.area_smart_app != null) {
                                zVar.imageUrl = serviceArea.area_smart_app.avatar;
                                zVar.name = serviceArea.area_smart_app.name;
                            }
                            zVar.link = serviceArea.serviceurl;
                            zVar.version = serviceArea.version;
                            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("frs_service_version_" + this.forum.getName() + zVar.name, "");
                            zVar.hdb = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                aa aaVar = new aa();
                                aaVar.c(serviceArea.area_smart_app);
                                zVar.lES = aaVar;
                            }
                            if (this.forum != null) {
                                zVar.forumName = this.forum.getName();
                                zVar.forumId = this.forum.getId();
                            }
                            zVar.index = i7;
                            i = i7 + 1;
                            arrayList3.add(zVar);
                        } else {
                            i = i7;
                        }
                        i7 = i;
                    }
                    this.serviceAreaData.lER = arrayList3.size();
                    this.serviceAreaData.dataList = arrayList3;
                }
                this.itemInfo = dataRes.item_info;
                this.is_get_horse_race_lamp = dataRes.is_get_horse_race_lamp;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long getDataParseTime() {
        return this.mDataParseTime;
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
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bu buVar = new bu();
                    buVar.setUserMap(this.userMap);
                    buVar.he(true);
                    buVar.a(threadInfo);
                    buVar.aTn();
                    if (buVar.getFid() == 0 && j != 0) {
                        buVar.setFid(j);
                    }
                    if (StringUtils.isNull(buVar.aSt())) {
                        buVar.vS(this.forum.getName());
                    }
                    buVar.y(this.color_eggs);
                    buVar.dOj = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(buVar.aTz())) {
                        ai aiVar = new ai();
                        aiVar.vG(buVar.aTz());
                        this.threadList.add(aiVar);
                    } else {
                        this.threadList.add(buVar);
                        JSONObject a = com.baidu.tieba.recapp.report.b.a(threadInfo, buVar.aSt());
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.cZL().eJ(arrayList);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo() {
        ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
        setThreadList(switchThreadDataToThreadCardInfo);
        return switchThreadDataToThreadCardInfo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        this.mHasThreadExceptTop = false;
        com.baidu.tbadk.a.e aOa = com.baidu.tbadk.a.a.c.aOa();
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if (next instanceof ai) {
                ((ai) next).position = i2;
                arrayList2.add(next);
                i = i2 + 1;
            } else if (next instanceof bu) {
                bu buVar = (bu) next;
                com.baidu.tbadk.a.a.c.a(aOa, buVar);
                int[] imageWidthAndHeight = imageWidthAndHeight(buVar);
                if (buVar.getType() == bu.dLm && !buVar.isTop()) {
                    bt btVar = new bt();
                    btVar.dLi = buVar;
                    btVar.position = i2;
                    btVar.dKS = true;
                    btVar.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(btVar);
                    bt btVar2 = new bt();
                    btVar2.dLi = buVar;
                    btVar2.position = i2;
                    if (buVar.aUl()) {
                        btVar2.dKX = true;
                    } else if (buVar.aTv() == 1) {
                        btVar2.dKV = true;
                        btVar2.dLj = imageWidthAndHeight[0];
                        btVar2.dLk = imageWidthAndHeight[1];
                    } else if (buVar.aTv() >= 2) {
                        btVar2.dKW = true;
                    } else {
                        btVar2.dKT = true;
                    }
                    btVar2.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(btVar2);
                    if (buVar.aUw() != null) {
                        bt btVar3 = new bt();
                        btVar3.dLf = true;
                        btVar3.dLi = buVar;
                        btVar3.position = i2;
                        btVar3.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar3);
                    }
                    if (buVar.aTe() != null) {
                        bt btVar4 = new bt();
                        btVar4.dLc = true;
                        btVar4.dLi = buVar;
                        btVar4.position = i2;
                        btVar4.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar4);
                    }
                    if (!com.baidu.tbadk.core.util.w.isEmpty(buVar.aUx())) {
                        bt btVar5 = new bt();
                        if (com.baidu.tbadk.core.util.w.getCount(buVar.aUx()) == 1) {
                            btVar5.dLg = true;
                        } else {
                            btVar5.dLh = true;
                        }
                        btVar5.dLi = buVar;
                        btVar5.position = i2;
                        btVar5.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar5);
                    }
                    if (buVar.aTS() != null) {
                        bt btVar6 = new bt();
                        btVar6.dKZ = true;
                        btVar6.dLi = buVar;
                        btVar6.position = i2;
                        btVar6.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar6);
                    }
                    bt btVar7 = new bt();
                    btVar7.dKY = true;
                    btVar7.dLi = buVar;
                    btVar7.position = i2;
                    btVar7.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(btVar7);
                    i = i2 + 1;
                } else if (buVar.getType() == bu.dLH && !buVar.isTop()) {
                    bt btVar8 = new bt();
                    btVar8.dLi = buVar;
                    btVar8.position = i2;
                    btVar8.dKS = true;
                    btVar8.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(btVar8);
                    bt btVar9 = new bt();
                    btVar9.dLi = buVar;
                    btVar9.position = i2;
                    btVar9.dLa = true;
                    btVar9.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(btVar9);
                    if (buVar.aUw() != null) {
                        bt btVar10 = new bt();
                        btVar10.dLf = true;
                        btVar10.dLi = buVar;
                        btVar10.position = i2;
                        btVar10.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar10);
                    }
                    if (buVar.aTe() != null) {
                        bt btVar11 = new bt();
                        btVar11.dLc = true;
                        btVar11.dLi = buVar;
                        btVar11.position = i2;
                        btVar11.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar11);
                    }
                    if (buVar.aTS() != null) {
                        bt btVar12 = new bt();
                        btVar12.dKZ = true;
                        btVar12.dLi = buVar;
                        btVar12.position = i2;
                        btVar12.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar12);
                    }
                    bt btVar13 = new bt();
                    btVar13.dKY = true;
                    btVar13.dLi = buVar;
                    btVar13.position = i2;
                    btVar13.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(btVar13);
                    i = i2 + 1;
                } else if (buVar.aSH() != null && !buVar.aTu() && buVar.aSs()) {
                    bt btVar14 = new bt();
                    btVar14.dLi = buVar;
                    btVar14.position = i2;
                    btVar14.dKS = true;
                    btVar14.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(btVar14);
                    bt btVar15 = new bt();
                    btVar15.dLi = buVar;
                    btVar15.position = i2;
                    btVar15.dLb = true;
                    btVar15.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(btVar15);
                    if (buVar.aUw() != null) {
                        bt btVar16 = new bt();
                        btVar16.dLf = true;
                        btVar16.dLi = buVar;
                        btVar16.position = i2;
                        btVar16.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar16);
                    }
                    if (buVar.aTe() != null) {
                        bt btVar17 = new bt();
                        btVar17.dLc = true;
                        btVar17.dLi = buVar;
                        btVar17.position = i2;
                        btVar17.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar17);
                    }
                    if (buVar.aTS() != null) {
                        bt btVar18 = new bt();
                        btVar18.dKZ = true;
                        btVar18.dLi = buVar;
                        btVar18.position = i2;
                        btVar18.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(btVar18);
                    }
                    bt btVar19 = new bt();
                    btVar19.dKY = true;
                    btVar19.dLi = buVar;
                    btVar19.position = i2;
                    btVar19.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(btVar19);
                    i = i2 + 1;
                } else if (buVar.getType() == bu.dLz && buVar.aQX()) {
                    buVar.position = i2;
                    arrayList2.add(buVar);
                    i = i2 + 1;
                } else {
                    bt btVar20 = new bt();
                    btVar20.dLi = buVar;
                    btVar20.position = i2;
                    arrayList2.add(btVar20);
                    i = i2 + 1;
                }
            } else {
                arrayList2.add(next);
                i = i2 + 1;
            }
            if (next != null && next.getType() != bu.dLl) {
                this.mHasThreadExceptTop = true;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.c.a(aOa, arrayList2);
        return arrayList2;
    }

    public int[] imageWidthAndHeight(bu buVar) {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aSy = buVar.aSy();
        if (com.baidu.tbadk.core.k.aPA().isShowImages() && com.baidu.tbadk.core.util.w.getCount(aSy) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aSy.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, 0);
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

    public i getBusinessPromot() {
        return this.businessPromot;
    }

    public void setBusinessPromot(i iVar) {
        this.businessPromot = iVar;
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

    public ArrayList<com.baidu.adp.widget.ListView.q> getThreadList() {
        return this.threadList;
    }

    public void setThreadList(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public void setAnti(AntiData antiData) {
        this.anti = antiData;
    }

    public at getPage() {
        return this.page;
    }

    public void setPage(at atVar) {
        this.page = atVar;
    }

    public n getStar() {
        return this.star;
    }

    public void setStar(n nVar) {
        this.star = nVar;
    }

    public com.baidu.tbadk.core.data.u getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public void setActivityHeadData(com.baidu.tbadk.core.data.u uVar) {
        this.mActivityHeadData = uVar;
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

    public p getGconAccount() {
        return this.gconAccount;
    }

    public void setGconAccount(p pVar) {
        this.gconAccount = pVar;
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

    public List<k> getStarEnter() {
        return this.starEnter;
    }

    public void setStarEnter(List<k> list) {
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

    public bu getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(bu buVar) {
        this.cardVideoInfo = buVar;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public void setFrsDefaultTabId(int i) {
        this.frsDefaultTabId = i;
    }

    public com.baidu.tbadk.core.data.ac getHeadSdkData() {
        return this.headSdkData;
    }

    public void setHeadSdkData(com.baidu.tbadk.core.data.ac acVar) {
        this.headSdkData = acVar;
    }

    public com.baidu.tbadk.core.data.v getBookInfo() {
        return this.bookInfoData;
    }

    public void setBookInfo(com.baidu.tbadk.core.data.v vVar) {
        this.bookInfoData = vVar;
    }

    public com.baidu.tbadk.core.data.x getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public void setHeadlineImgInfoData(com.baidu.tbadk.core.data.x xVar) {
        this.headlineImgInfoData = xVar;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public void setSchoolRecommendPos(int i) {
        this.schoolRecommendPos = i;
    }

    public bj getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bj bjVar) {
        this.schoolRecommendInfo = bjVar;
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

    public com.baidu.tbadk.core.data.q getCarrierEnterData() {
        return this.carrierEnterData;
    }

    public void setCarrierEnterData(com.baidu.tbadk.core.data.q qVar) {
        this.carrierEnterData = qVar;
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

    public List<com.baidu.adp.widget.ListView.q> getCardShipinNew() {
        return this.mCardShipinNew;
    }

    public void setCardShipinNew(List<com.baidu.adp.widget.ListView.q> list) {
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

    public void setUserRecommend(com.baidu.tieba.frs.x xVar) {
        this.userRecommend = xVar;
    }

    public com.baidu.tieba.frs.x getUserRecommend() {
        return this.userRecommend;
    }

    public o getFrsVideoActivityData() {
        return this.mFrsVideoActivityData;
    }

    public void setFrsVideoActivityData(o oVar) {
        this.mFrsVideoActivityData = oVar;
    }

    public g getFrsInsertLiveData() {
        return this.mFrsInsertLiveData;
    }

    public void setFrsInsertLiveData(g gVar) {
        this.mFrsInsertLiveData = gVar;
    }

    public h getFrsStageLiveData() {
        return this.mFrsStageLiveData;
    }

    public void setFrsStageLiveData(h hVar) {
        this.mFrsStageLiveData = hVar;
    }

    public bb getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(bb bbVar) {
        this.privateForumTotalData = bbVar;
    }

    public HotUserRankEntry getHotUserRankData() {
        return this.mHotUserRankData;
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        this.mHotUserRankData = hotUserRankEntry;
    }

    public Integer getIs_get_horse_race_lamp() {
        return this.is_get_horse_race_lamp;
    }
}
