package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private bw cardVideoInfo;
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
    protected q gconAccount;
    private boolean hasGame;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public ItemInfo itemInfo;
    private List<FeedForumData> likeFeedForumDataList;
    private AlaLiveNotify liveNotify;
    private List<com.baidu.adp.widget.ListView.q> mCardShipinNew;
    private List<Integer> mCardShipinPos;
    private NavTabInfo mEntelechyTabInfo;
    private g mFrsInsertLiveData;
    private h mFrsStageLiveData;
    private p mFrsVideoActivityData;
    private com.baidu.tieba.h.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    private HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected av page;
    private int photoLivePos;
    private bd privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bl schoolRecommendInfo;
    public z serviceAreaData;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    private n star;
    public StarRank starRank;
    protected ArrayList<com.baidu.adp.widget.ListView.q> threadList;
    protected List<Long> threadListIds;
    public Integer toLoadHorseData;
    private UserData userData;
    public List<User> userList;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tieba.frs.y userRecommend;
    public int needLog = 0;
    private List<k> starEnter = new ArrayList();
    private int isNewUrl = 0;
    private ArrayList<com.baidu.tbadk.core.data.s> color_eggs = new ArrayList<>();
    protected com.baidu.tbadk.core.data.v mActivityHeadData = null;
    private int frsDefaultTabId = 1;
    private boolean isShowRedTip = false;
    private String bawuCenterUrl = null;
    private ae headSdkData = null;
    public af recommendBookData = null;
    public RecomPostTopic postTopic = null;
    private com.baidu.tbadk.core.data.w bookInfoData = null;
    private Integer mangaReadRecordChapterId = -1;
    public com.baidu.tbadk.core.data.ac presentInfoData = null;
    private com.baidu.tbadk.core.data.z headlineImgInfoData = null;
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
        this.page = new av();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new q();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new bd();
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
                if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.y.isEmpty(colorEgg.holiday_words)) {
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
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.v();
                    this.mActivityHeadData.a(dataRes.brand_forum_info.head_imgs);
                    this.brandAdData = new com.baidu.tieba.frs.d();
                    this.brandAdData.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                        this.oriForumInfoList = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.oriForumInfoList.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.y.isEmpty(dataRes.activityhead.head_imgs)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.v();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !at.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.v();
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
                if (this.mEntelechyTabInfo != null && com.baidu.tbadk.core.util.y.getItem(this.mEntelechyTabInfo.tab, 0) != null) {
                    this.defaultShowTab = ((FrsTabInfo) com.baidu.tbadk.core.util.y.getItem(this.mEntelechyTabInfo.tab, 0)).tab_id.intValue();
                }
                if (this.mEntelechyTabInfo != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mEntelechyTabInfo.head)) {
                    this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                handleDefaultTab(dataRes.frs_tab_default.intValue());
                this.photoLivePos = dataRes.twzhibo_pos.intValue();
                this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
                convertThreadInfoToThreadData(dataRes.thread_list, longValue);
                this.categoryInfos = dataRes.category_list;
                if (!at.isEmpty(dataRes.bawu_enter_url)) {
                    this.bawuCenterUrl = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.headSdkData = new ae();
                    this.headSdkData.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.recommendBookData = new af();
                    this.recommendBookData.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.bookInfoData = new com.baidu.tbadk.core.data.w();
                    this.bookInfoData.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.presentInfoData = new com.baidu.tbadk.core.data.ac();
                    this.presentInfoData.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.headlineImgInfoData = new com.baidu.tbadk.core.data.z();
                    this.headlineImgInfoData.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.business_promot != null) {
                    this.businessPromot = new i();
                    this.businessPromot.a(dataRes.business_promot);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.cardVideoInfo = new bw();
                    this.cardVideoInfo.iF(true);
                    this.cardVideoInfo.of(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.bkY();
                    this.cardVideoInfo.eAK = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && longValue != 0) {
                        this.cardVideoInfo.setFid(longValue);
                    }
                    this.cardVideoInfo.F(this.color_eggs);
                    this.cardVideoInfo.iE(!this.cardVideoInfo.bjF());
                    if (this.cardVideoInfo.bka() != null && this.cardVideoInfo.bka().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.bka().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                        mVar.dj(metaData.getPendantData().bwx());
                        mVar.AJ(metaData.getPendantData().bhW());
                        this.cardVideoInfo.bka().setPendantData(mVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.mOD = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            bw bwVar = new bw();
                            bwVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            bwVar.eAK = this.isBrandForum;
                            arrayList.add(bwVar);
                        }
                    }
                    this.mFrsInsertLiveData.mOC = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            bw bwVar2 = new bw();
                            bwVar2.a(dataRes.ala_stage_list.get(i5));
                            bwVar2.eAK = this.isBrandForum;
                            arrayList2.add(bwVar2);
                        }
                    }
                    this.mFrsStageLiveData.mOF = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bl();
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
                com.baidu.tieba.recapp.d.a.dyA().Rm(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bw bwVar3 = new bw();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            bwVar3.of(this.mCardShipinPos.get(i6).intValue());
                        }
                        bwVar3.iF(true);
                        bwVar3.a(dataRes.card_shipin_new.get(i6));
                        bwVar3.eAK = this.isBrandForum;
                        this.mCardShipinNew.add(bwVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.h.b();
                    this.mGameRankListData.a(dataRes.esport);
                }
                this.agreeBanner = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.userRecommend = new com.baidu.tieba.frs.y();
                    this.userRecommend.a(dataRes.user_extend);
                }
                this.liveNotify = dataRes.live_frs_notify;
                this.gameTabInfo = dataRes.frs_game_tab_info;
                this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
                this.forumHeadIcon = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.mFrsVideoActivityData = new p();
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
                if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.service_area)) {
                    this.serviceAreaData = new z();
                    ArrayList arrayList3 = new ArrayList();
                    int i7 = 0;
                    for (ServiceArea serviceArea : dataRes.service_area) {
                        if (serviceArea != null) {
                            aa aaVar = new aa();
                            aaVar.imageUrl = serviceArea.picurl;
                            aaVar.name = serviceArea.servicename;
                            aaVar.category = serviceArea.service_type;
                            if (aaVar.category != null && aaVar.category.equals("原生小程序") && serviceArea.area_smart_app != null) {
                                aaVar.imageUrl = serviceArea.area_smart_app.avatar;
                                aaVar.name = serviceArea.area_smart_app.name;
                            }
                            aaVar.link = serviceArea.serviceurl;
                            aaVar.version = serviceArea.version;
                            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("frs_service_version_" + this.forum.getName() + aaVar.name, "");
                            aaVar.beq = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                ab abVar = new ab();
                                abVar.c(serviceArea.area_smart_app);
                                aaVar.mPU = abVar;
                            }
                            if (this.forum != null) {
                                aaVar.forumName = this.forum.getName();
                                aaVar.forumId = this.forum.getId();
                            }
                            aaVar.index = i7;
                            i = i7 + 1;
                            arrayList3.add(aaVar);
                        } else {
                            i = i7;
                        }
                        i7 = i;
                    }
                    this.serviceAreaData.mPT = arrayList3.size();
                    this.serviceAreaData.dataList = arrayList3;
                }
                this.itemInfo = dataRes.item_info;
                this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.setUserMap(this.userMap);
                    bwVar.iL(true);
                    bwVar.a(threadInfo);
                    bwVar.bkY();
                    if (bwVar.getFid() == 0 && j != 0) {
                        bwVar.setFid(j);
                    }
                    if (StringUtils.isNull(bwVar.bke())) {
                        bwVar.AO(this.forum.getName());
                    }
                    bwVar.F(this.color_eggs);
                    bwVar.eAK = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(bwVar.blk())) {
                        ak akVar = new ak();
                        akVar.AC(bwVar.blk());
                        this.threadList.add(akVar);
                    } else {
                        this.threadList.add(bwVar);
                        JSONObject a2 = com.baidu.tieba.recapp.report.b.a(threadInfo, bwVar.bke());
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.dyH().fr(arrayList);
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
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if (next instanceof ak) {
                ((ak) next).position = i2;
                arrayList2.add(next);
                i = i2 + 1;
            } else if (next instanceof bw) {
                bw bwVar = (bw) next;
                com.baidu.tbadk.a.a.a.a(bwVar);
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                if (bwVar.getType() == bw.exJ && !bwVar.isTop()) {
                    bv bvVar = new bv();
                    bvVar.erH = bwVar;
                    bvVar.position = i2;
                    bvVar.exo = true;
                    bvVar.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.erH = bwVar;
                    bvVar2.position = i2;
                    if (bwVar.blV()) {
                        bvVar2.exu = true;
                    } else if (bwVar.blg() == 1) {
                        bvVar2.exr = true;
                        bvVar2.exG = imageWidthAndHeight[0];
                        bvVar2.exH = imageWidthAndHeight[1];
                    } else if (bwVar.blg() >= 2) {
                        bvVar2.exs = true;
                    } else {
                        bvVar2.exp = true;
                    }
                    bvVar2.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(bvVar2);
                    if (bwVar.bmf() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.exC = true;
                        bvVar3.erH = bwVar;
                        bvVar3.position = i2;
                        bvVar3.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar3);
                    }
                    if (bwVar.bkP() != null) {
                        bv bvVar4 = new bv();
                        bvVar4.exz = true;
                        bvVar4.erH = bwVar;
                        bvVar4.position = i2;
                        bvVar4.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar4);
                    }
                    if (!com.baidu.tbadk.core.util.y.isEmpty(bwVar.bmg()) || !com.baidu.tbadk.core.util.y.isEmpty(bwVar.bmh())) {
                        bv bvVar5 = new bv();
                        if (com.baidu.tbadk.core.util.y.getCount(bwVar.bmg()) + com.baidu.tbadk.core.util.y.getCount(bwVar.bmh()) == 1) {
                            bvVar5.exD = true;
                        } else if (com.baidu.tbadk.core.util.y.getCount(bwVar.bmg()) + com.baidu.tbadk.core.util.y.getCount(bwVar.bmh()) > 1) {
                            bvVar5.exE = true;
                        }
                        bvVar5.erH = bwVar;
                        bvVar5.position = i2;
                        bvVar5.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar5);
                    }
                    if (bwVar.blD() != null) {
                        bv bvVar6 = new bv();
                        bvVar6.exw = true;
                        bvVar6.erH = bwVar;
                        bvVar6.position = i2;
                        bvVar6.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar6);
                    }
                    bv bvVar7 = new bv();
                    bvVar7.exv = true;
                    bvVar7.erH = bwVar;
                    bvVar7.position = i2;
                    bvVar7.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(bvVar7);
                    i = i2 + 1;
                } else if (bwVar.getType() == bw.eyg && !bwVar.isTop()) {
                    bv bvVar8 = new bv();
                    bvVar8.erH = bwVar;
                    bvVar8.position = i2;
                    bvVar8.exo = true;
                    bvVar8.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(bvVar8);
                    bv bvVar9 = new bv();
                    bvVar9.erH = bwVar;
                    bvVar9.position = i2;
                    bvVar9.exx = true;
                    bvVar9.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(bvVar9);
                    if (bwVar.bmf() != null) {
                        bv bvVar10 = new bv();
                        bvVar10.exC = true;
                        bvVar10.erH = bwVar;
                        bvVar10.position = i2;
                        bvVar10.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar10);
                    }
                    if (bwVar.bkP() != null) {
                        bv bvVar11 = new bv();
                        bvVar11.exz = true;
                        bvVar11.erH = bwVar;
                        bvVar11.position = i2;
                        bvVar11.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar11);
                    }
                    if (bwVar.blD() != null) {
                        bv bvVar12 = new bv();
                        bvVar12.exw = true;
                        bvVar12.erH = bwVar;
                        bvVar12.position = i2;
                        bvVar12.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar12);
                    }
                    bv bvVar13 = new bv();
                    bvVar13.exv = true;
                    bvVar13.erH = bwVar;
                    bvVar13.position = i2;
                    bvVar13.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(bvVar13);
                    i = i2 + 1;
                } else if (bwVar.bks() != null && !bwVar.blf() && bwVar.bkd()) {
                    bv bvVar14 = new bv();
                    bvVar14.erH = bwVar;
                    bvVar14.position = i2;
                    bvVar14.exo = true;
                    bvVar14.a(AbsThreadDataSupport.SupportType.TOP);
                    arrayList2.add(bvVar14);
                    bv bvVar15 = new bv();
                    bvVar15.erH = bwVar;
                    bvVar15.position = i2;
                    bvVar15.exy = true;
                    bvVar15.a(AbsThreadDataSupport.SupportType.CONTENT);
                    arrayList2.add(bvVar15);
                    if (bwVar.bmf() != null) {
                        bv bvVar16 = new bv();
                        bvVar16.exC = true;
                        bvVar16.erH = bwVar;
                        bvVar16.position = i2;
                        bvVar16.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar16);
                    }
                    if (bwVar.bkP() != null) {
                        bv bvVar17 = new bv();
                        bvVar17.exz = true;
                        bvVar17.erH = bwVar;
                        bvVar17.position = i2;
                        bvVar17.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar17);
                    }
                    if (bwVar.blD() != null) {
                        bv bvVar18 = new bv();
                        bvVar18.exw = true;
                        bvVar18.erH = bwVar;
                        bvVar18.position = i2;
                        bvVar18.a(AbsThreadDataSupport.SupportType.EXTEND);
                        arrayList2.add(bvVar18);
                    }
                    bv bvVar19 = new bv();
                    bvVar19.exv = true;
                    bvVar19.erH = bwVar;
                    bvVar19.position = i2;
                    bvVar19.a(AbsThreadDataSupport.SupportType.BOTTOM);
                    arrayList2.add(bvVar19);
                    i = i2 + 1;
                } else if (bwVar.getType() == bw.exX && bwVar.biI()) {
                    bwVar.position = i2;
                    arrayList2.add(bwVar);
                    i = i2 + 1;
                } else {
                    bv bvVar20 = new bv();
                    bvVar20.erH = bwVar;
                    bvVar20.position = i2;
                    arrayList2.add(bvVar20);
                    i = i2 + 1;
                }
            } else {
                arrayList2.add(next);
                i = i2 + 1;
            }
            if (next != null && next.getType() != bw.exI) {
                this.mHasThreadExceptTop = true;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.aX(arrayList2);
        return arrayList2;
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

    public av getPage() {
        return this.page;
    }

    public void setPage(av avVar) {
        this.page = avVar;
    }

    public n getStar() {
        return this.star;
    }

    public void setStar(n nVar) {
        this.star = nVar;
    }

    public com.baidu.tbadk.core.data.v getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public void setActivityHeadData(com.baidu.tbadk.core.data.v vVar) {
        this.mActivityHeadData = vVar;
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

    public q getGconAccount() {
        return this.gconAccount;
    }

    public void setGconAccount(q qVar) {
        this.gconAccount = qVar;
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

    public bw getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(bw bwVar) {
        this.cardVideoInfo = bwVar;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public void setFrsDefaultTabId(int i) {
        this.frsDefaultTabId = i;
    }

    public ae getHeadSdkData() {
        return this.headSdkData;
    }

    public void setHeadSdkData(ae aeVar) {
        this.headSdkData = aeVar;
    }

    public com.baidu.tbadk.core.data.w getBookInfo() {
        return this.bookInfoData;
    }

    public void setBookInfo(com.baidu.tbadk.core.data.w wVar) {
        this.bookInfoData = wVar;
    }

    public com.baidu.tbadk.core.data.z getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public void setHeadlineImgInfoData(com.baidu.tbadk.core.data.z zVar) {
        this.headlineImgInfoData = zVar;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public void setSchoolRecommendPos(int i) {
        this.schoolRecommendPos = i;
    }

    public bl getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bl blVar) {
        this.schoolRecommendInfo = blVar;
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

    public void setUserRecommend(com.baidu.tieba.frs.y yVar) {
        this.userRecommend = yVar;
    }

    public com.baidu.tieba.frs.y getUserRecommend() {
        return this.userRecommend;
    }

    public p getFrsVideoActivityData() {
        return this.mFrsVideoActivityData;
    }

    public void setFrsVideoActivityData(p pVar) {
        this.mFrsVideoActivityData = pVar;
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

    public bd getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(bd bdVar) {
        this.privateForumTotalData = bdVar;
    }

    public HotUserRankEntry getHotUserRankData() {
        return this.mHotUserRankData;
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        this.mHotUserRankData = hotUserRankEntry;
    }

    public Integer getToLoadHorseData() {
        return this.toLoadHorseData;
    }
}
