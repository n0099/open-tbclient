package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.ForumRuleStatus;
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
import tbclient.SignActivityInfo;
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
    public AddBawuPopInfo bawuPopInfo;
    public WindowToast bazhuExam;
    public List<BottomMenu> bottomMenuList;
    public com.baidu.tieba.frs.d brandAdData;
    private i businessPromot;
    private cb cardVideoInfo;
    private com.baidu.tbadk.core.data.s carrierEnterData;
    private List<CategoryInfo> categoryInfos;
    private b chatGroup;
    public PopInfo enterFrsDialogInfo;
    protected boolean fortuneBag;
    protected String fortuneDesc;
    protected ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    private ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    private String gameName;
    private List<FrsTabInfo> gameTabInfo;
    private String gameUrl;
    protected r gconAccount;
    private boolean hasGame;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public ItemInfo itemInfo;
    private List<FeedForumData> likeFeedForumDataList;
    private AlaLiveNotify liveNotify;
    private List<com.baidu.adp.widget.ListView.n> mCardShipinNew;
    private List<Integer> mCardShipinPos;
    private NavTabInfo mEntelechyTabInfo;
    private g mFrsInsertLiveData;
    private h mFrsStageLiveData;
    private q mFrsVideoActivityData;
    private com.baidu.tieba.i.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    private HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public SignActivityInfo mSignActivityInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected az page;
    private int photoLivePos;
    private bh privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bq schoolRecommendInfo;
    public aa serviceAreaData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    private n star;
    public StarRank starRank;
    protected ArrayList<com.baidu.adp.widget.ListView.n> threadList;
    protected List<Long> threadListIds;
    public Integer toLoadHorseData;
    private UserData userData;
    public List<User> userList;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tieba.frs.w userRecommend;
    public int needLog = 0;
    private List<k> starEnter = new ArrayList();
    private int isNewUrl = 0;
    private ArrayList<com.baidu.tbadk.core.data.u> color_eggs = new ArrayList<>();
    protected com.baidu.tbadk.core.data.x mActivityHeadData = null;
    private int frsDefaultTabId = 1;
    private boolean isShowRedTip = false;
    private String bawuCenterUrl = null;
    private ag headSdkData = null;
    public ah recommendBookData = null;
    public RecomPostTopic postTopic = null;
    private com.baidu.tbadk.core.data.y bookInfoData = null;
    private Integer mangaReadRecordChapterId = -1;
    public com.baidu.tbadk.core.data.ae presentInfoData = null;
    private com.baidu.tbadk.core.data.ab headlineImgInfoData = null;
    private int schoolRecommendPos = -1;
    protected List<com.baidu.adp.widget.ListView.n> topThreadList = null;
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
        this.page = new az();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new r();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new bh();
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
        long j;
        int i;
        MetaData metaData;
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.y.isEmpty(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.u uVar = new com.baidu.tbadk.core.data.u();
                            if (uVar.a(colorEgg)) {
                                this.color_eggs.add(uVar);
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
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.x();
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
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.x();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !au.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.x();
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
                if (dataRes.forum != null) {
                    long longValue = dataRes.forum.id.longValue();
                    aq.b(Long.valueOf(longValue), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
                    j = longValue;
                } else {
                    j = 0;
                }
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
                if (com.baidu.tbadk.a.d.bjq() && !com.baidu.tbadk.a.b.a.eGs.equals(((FrsTabInfo) com.baidu.tbadk.core.util.y.getItem(this.mEntelechyTabInfo.tab, 0)).tab_name)) {
                    this.defaultShowTab = com.baidu.tbadk.a.b.a.bjG();
                }
                if (this.mEntelechyTabInfo != null && !com.baidu.tbadk.core.util.y.isEmpty(this.mEntelechyTabInfo.head)) {
                    this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                handleDefaultTab(dataRes.frs_tab_default.intValue());
                this.photoLivePos = dataRes.twzhibo_pos.intValue();
                this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
                convertThreadInfoToThreadData(dataRes.thread_list, j);
                this.categoryInfos = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.bawuCenterUrl = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.headSdkData = new ag();
                    this.headSdkData.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.recommendBookData = new ah();
                    this.recommendBookData.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.bookInfoData = new com.baidu.tbadk.core.data.y();
                    this.bookInfoData.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.presentInfoData = new com.baidu.tbadk.core.data.ae();
                    this.presentInfoData.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.headlineImgInfoData = new com.baidu.tbadk.core.data.ab();
                    this.headlineImgInfoData.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.business_promot != null) {
                    this.businessPromot = new i();
                    this.businessPromot.a(dataRes.business_promot);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.cardVideoInfo = new cb();
                    this.cardVideoInfo.jy(true);
                    this.cardVideoInfo.nq(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.boP();
                    this.cardVideoInfo.eTo = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && j != 0) {
                        this.cardVideoInfo.setFid(j);
                    }
                    this.cardVideoInfo.A(this.color_eggs);
                    this.cardVideoInfo.jx(!this.cardVideoInfo.bnv());
                    if (this.cardVideoInfo.bnQ() != null && this.cardVideoInfo.bnQ().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.bnQ().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.n nVar = new com.baidu.tbadk.data.n();
                        nVar.ek(metaData.getPendantData().bAG());
                        nVar.Ad(metaData.getPendantData().getImgUrl());
                        this.cardVideoInfo.bnQ().setPendantData(nVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.nuJ = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            cb cbVar = new cb();
                            cbVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            cbVar.eTo = this.isBrandForum;
                            arrayList.add(cbVar);
                        }
                    }
                    this.mFrsInsertLiveData.nuI = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            cb cbVar2 = new cb();
                            cbVar2.a(dataRes.ala_stage_list.get(i5));
                            cbVar2.eTo = this.isBrandForum;
                            arrayList2.add(cbVar2);
                        }
                    }
                    this.mFrsStageLiveData.nuL = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bq();
                    this.schoolRecommendInfo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.carrierEnterData = new com.baidu.tbadk.core.data.s();
                    this.carrierEnterData.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.needLog = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.dEm().RP(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        cb cbVar3 = new cb();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            cbVar3.nq(this.mCardShipinPos.get(i6).intValue());
                        }
                        cbVar3.jy(true);
                        cbVar3.a(dataRes.card_shipin_new.get(i6));
                        cbVar3.eTo = this.isBrandForum;
                        this.mCardShipinNew.add(cbVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.i.b();
                    this.mGameRankListData.a(dataRes.esport);
                }
                this.agreeBanner = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.userRecommend = new com.baidu.tieba.frs.w();
                    this.userRecommend.a(dataRes.user_extend);
                }
                this.liveNotify = dataRes.live_frs_notify;
                this.gameTabInfo = dataRes.frs_game_tab_info;
                this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
                this.forumHeadIcon = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.mFrsVideoActivityData = new q();
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
                if (dataRes.sign_activity_info != null) {
                    this.mSignActivityInfo = dataRes.sign_activity_info;
                }
                if (dataRes.add_bawu_pop != null) {
                    this.bawuPopInfo = dataRes.add_bawu_pop;
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.service_area)) {
                    this.serviceAreaData = new aa();
                    ArrayList arrayList3 = new ArrayList();
                    int i7 = 0;
                    for (ServiceArea serviceArea : dataRes.service_area) {
                        if (serviceArea != null) {
                            ab abVar = new ab();
                            abVar.imageUrl = serviceArea.picurl;
                            abVar.name = serviceArea.servicename;
                            abVar.category = serviceArea.service_type;
                            if (abVar.category != null && abVar.category.equals("原生小程序") && serviceArea.area_smart_app != null) {
                                abVar.imageUrl = serviceArea.area_smart_app.avatar;
                                abVar.name = serviceArea.area_smart_app.name;
                            }
                            abVar.link = serviceArea.serviceurl;
                            abVar.version = serviceArea.version;
                            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("frs_service_version_" + this.forum.getName() + abVar.name, "");
                            abVar.iJB = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                ac acVar = new ac();
                                acVar.c(serviceArea.area_smart_app);
                                abVar.nwa = acVar;
                            }
                            if (this.forum != null) {
                                abVar.forumName = this.forum.getName();
                                abVar.forumId = this.forum.getId();
                            }
                            abVar.index = i7;
                            i = i7 + 1;
                            arrayList3.add(abVar);
                        } else {
                            i = i7;
                        }
                        i7 = i;
                    }
                    this.serviceAreaData.nvZ = arrayList3.size();
                    this.serviceAreaData.dataList = arrayList3;
                }
                this.itemInfo = dataRes.item_info;
                this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
                this.forumRule = dataRes.forum_rule;
                this.showAdsense = dataRes.show_adsense;
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
                    cb cbVar = new cb();
                    aq.a(j, cbVar);
                    cbVar.setUserMap(this.userMap);
                    cbVar.jE(true);
                    cbVar.a(threadInfo);
                    cbVar.boP();
                    cbVar.bns();
                    if (cbVar.getFid() == 0 && j != 0) {
                        cbVar.setFid(j);
                    }
                    if (StringUtils.isNull(cbVar.bnU())) {
                        cbVar.Ai(this.forum.getName());
                    }
                    cbVar.A(this.color_eggs);
                    cbVar.eTo = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(cbVar.bpb())) {
                        an anVar = new an();
                        anVar.zV(cbVar.bpb());
                        this.threadList.add(anVar);
                    } else {
                        this.threadList.add(cbVar);
                        JSONObject a2 = com.baidu.tieba.recapp.report.b.a(threadInfo, cbVar.bnU());
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.dEt().q("FRS", arrayList);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo() {
        ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
        setThreadList(switchThreadDataToThreadCardInfo);
        return switchThreadDataToThreadCardInfo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int i;
        int i2;
        this.mHasThreadExceptTop = false;
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if (next instanceof am) {
                ((am) next).setPosition(i3 - i4);
                arrayList2.add(next);
                i = i3 + 1;
            } else if (next instanceof an) {
                ((an) next).position = i3;
                arrayList2.add(next);
                i = i3 + 1;
            } else if (next instanceof cb) {
                cb cbVar = (cb) next;
                if (cbVar.isTop()) {
                    i4++;
                }
                com.baidu.tbadk.a.a.a.a(cbVar);
                int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                if (cbVar.getType() == cb.eQm && !cbVar.isTop()) {
                    ca caVar = new ca();
                    caVar.eJQ = cbVar;
                    caVar.position = i3;
                    caVar.ePR = true;
                    caVar.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(caVar);
                    ca caVar2 = new ca();
                    caVar2.eJQ = cbVar;
                    caVar2.position = i3;
                    if (cbVar.bpN()) {
                        caVar2.ePW = true;
                    } else if (cbVar.boX() == 1) {
                        caVar2.ePU = true;
                        caVar2.eQj = imageWidthAndHeight[0];
                        caVar2.eQk = imageWidthAndHeight[1];
                    } else if (cbVar.boX() >= 2) {
                        caVar2.ePV = true;
                    } else {
                        caVar2.ePS = true;
                    }
                    caVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(caVar2);
                    if (cbVar.bpY() != null) {
                        ca caVar3 = new ca();
                        caVar3.eQf = true;
                        caVar3.eJQ = cbVar;
                        caVar3.position = i3;
                        caVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar3);
                    }
                    if (cbVar.boE() != null) {
                        ca caVar4 = new ca();
                        caVar4.eQc = true;
                        caVar4.eJQ = cbVar;
                        caVar4.position = i3;
                        caVar4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar4);
                    }
                    if (!com.baidu.tbadk.core.util.y.isEmpty(cbVar.bpZ()) || !com.baidu.tbadk.core.util.y.isEmpty(cbVar.bqa())) {
                        ca caVar5 = new ca();
                        if (com.baidu.tbadk.core.util.y.getCount(cbVar.bpZ()) + com.baidu.tbadk.core.util.y.getCount(cbVar.bqa()) == 1) {
                            caVar5.eQg = true;
                        } else if (com.baidu.tbadk.core.util.y.getCount(cbVar.bpZ()) + com.baidu.tbadk.core.util.y.getCount(cbVar.bqa()) > 1) {
                            caVar5.eQh = true;
                        }
                        caVar5.eJQ = cbVar;
                        caVar5.position = i3;
                        caVar5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar5);
                    }
                    if (cbVar.bpv() != null) {
                        ca caVar6 = new ca();
                        caVar6.ePY = true;
                        caVar6.eJQ = cbVar;
                        caVar6.position = i3;
                        caVar6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar6);
                    }
                    if (cbVar.bpW() != null && !cbVar.boS()) {
                        ca caVar7 = new ca();
                        caVar7.eQe = true;
                        caVar7.eJQ = cbVar;
                        caVar7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar7);
                    }
                    ca caVar8 = new ca();
                    caVar8.ePX = true;
                    caVar8.eJQ = cbVar;
                    caVar8.position = i3;
                    caVar8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(caVar8);
                    i2 = i3 + 1;
                } else if ((cbVar.getType() == cb.eQK || cbVar.getType() == cb.eRd) && !cbVar.isTop()) {
                    ca caVar9 = new ca();
                    caVar9.eJQ = cbVar;
                    caVar9.position = i3;
                    caVar9.ePR = true;
                    caVar9.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(caVar9);
                    ca caVar10 = new ca();
                    caVar10.eJQ = cbVar;
                    caVar10.position = i3;
                    if (cbVar instanceof aw) {
                        caVar10.eQa = true;
                    } else {
                        caVar10.ePZ = true;
                    }
                    caVar10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(caVar10);
                    if (cbVar.bpY() != null) {
                        ca caVar11 = new ca();
                        caVar11.eQf = true;
                        caVar11.eJQ = cbVar;
                        caVar11.position = i3;
                        caVar11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar11);
                    }
                    if (cbVar.boE() != null) {
                        ca caVar12 = new ca();
                        caVar12.eQc = true;
                        caVar12.eJQ = cbVar;
                        caVar12.position = i3;
                        caVar12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar12);
                    }
                    if (cbVar.bpv() != null) {
                        ca caVar13 = new ca();
                        caVar13.ePY = true;
                        caVar13.eJQ = cbVar;
                        caVar13.position = i3;
                        caVar13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar13);
                    }
                    if (cbVar.bpW() != null && !cbVar.boS()) {
                        ca caVar14 = new ca();
                        caVar14.eQe = true;
                        caVar14.eJQ = cbVar;
                        caVar14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar14);
                    }
                    ca caVar15 = new ca();
                    caVar15.ePX = true;
                    caVar15.eJQ = cbVar;
                    caVar15.position = i3;
                    caVar15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(caVar15);
                    i2 = i3 + 1;
                } else if (cbVar.boh() != null && !cbVar.boW() && cbVar.bnT()) {
                    ca caVar16 = new ca();
                    caVar16.eJQ = cbVar;
                    caVar16.position = i3;
                    caVar16.ePR = true;
                    caVar16.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(caVar16);
                    ca caVar17 = new ca();
                    caVar17.eJQ = cbVar;
                    caVar17.position = i3;
                    caVar17.eQb = true;
                    caVar17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(caVar17);
                    if (cbVar.bpY() != null) {
                        ca caVar18 = new ca();
                        caVar18.eQf = true;
                        caVar18.eJQ = cbVar;
                        caVar18.position = i3;
                        caVar18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar18);
                    }
                    if (cbVar.boE() != null) {
                        ca caVar19 = new ca();
                        caVar19.eQc = true;
                        caVar19.eJQ = cbVar;
                        caVar19.position = i3;
                        caVar19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar19);
                    }
                    if (cbVar.bpv() != null) {
                        ca caVar20 = new ca();
                        caVar20.ePY = true;
                        caVar20.eJQ = cbVar;
                        caVar20.position = i3;
                        caVar20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar20);
                    }
                    if (cbVar.bpW() != null && !cbVar.boS()) {
                        ca caVar21 = new ca();
                        caVar21.eQe = true;
                        caVar21.eJQ = cbVar;
                        caVar21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(caVar21);
                    }
                    ca caVar22 = new ca();
                    caVar22.ePX = true;
                    caVar22.eJQ = cbVar;
                    caVar22.position = i3;
                    caVar22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(caVar22);
                    i2 = i3 + 1;
                } else if (cbVar.getType() == cb.eQB && cbVar.bmx()) {
                    cbVar.position = i3;
                    arrayList2.add(cbVar);
                    i2 = i3 + 1;
                } else {
                    ca caVar23 = new ca();
                    caVar23.eJQ = cbVar;
                    caVar23.position = i3;
                    arrayList2.add(caVar23);
                    i2 = i3 + 1;
                }
                cbVar.setSupportType(BaseCardInfo.SupportType.TOP);
                i = i2;
            } else {
                arrayList2.add(next);
                i = i3 + 1;
            }
            if (next != null && next.getType() != cb.eQl) {
                this.mHasThreadExceptTop = true;
            }
            i3 = i;
        }
        com.baidu.tbadk.a.a.a.bj(arrayList2);
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

    public ArrayList<com.baidu.adp.widget.ListView.n> getThreadList() {
        return this.threadList;
    }

    public void setThreadList(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public void setAnti(AntiData antiData) {
        this.anti = antiData;
    }

    public az getPage() {
        return this.page;
    }

    public void setPage(az azVar) {
        this.page = azVar;
    }

    public n getStar() {
        return this.star;
    }

    public void setStar(n nVar) {
        this.star = nVar;
    }

    public com.baidu.tbadk.core.data.x getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public void setActivityHeadData(com.baidu.tbadk.core.data.x xVar) {
        this.mActivityHeadData = xVar;
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

    public r getGconAccount() {
        return this.gconAccount;
    }

    public void setGconAccount(r rVar) {
        this.gconAccount = rVar;
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

    public cb getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(cb cbVar) {
        this.cardVideoInfo = cbVar;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public void setFrsDefaultTabId(int i) {
        this.frsDefaultTabId = i;
    }

    public ag getHeadSdkData() {
        return this.headSdkData;
    }

    public void setHeadSdkData(ag agVar) {
        this.headSdkData = agVar;
    }

    public com.baidu.tbadk.core.data.y getBookInfo() {
        return this.bookInfoData;
    }

    public void setBookInfo(com.baidu.tbadk.core.data.y yVar) {
        this.bookInfoData = yVar;
    }

    public com.baidu.tbadk.core.data.ab getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public void setHeadlineImgInfoData(com.baidu.tbadk.core.data.ab abVar) {
        this.headlineImgInfoData = abVar;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public void setSchoolRecommendPos(int i) {
        this.schoolRecommendPos = i;
    }

    public bq getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bq bqVar) {
        this.schoolRecommendInfo = bqVar;
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

    public com.baidu.tbadk.core.data.s getCarrierEnterData() {
        return this.carrierEnterData;
    }

    public void setCarrierEnterData(com.baidu.tbadk.core.data.s sVar) {
        this.carrierEnterData = sVar;
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

    public List<com.baidu.adp.widget.ListView.n> getCardShipinNew() {
        return this.mCardShipinNew;
    }

    public void setCardShipinNew(List<com.baidu.adp.widget.ListView.n> list) {
        this.mCardShipinNew = list;
    }

    public com.baidu.tieba.i.b getGameRankListData() {
        return this.mGameRankListData;
    }

    public void setGameRankListData(com.baidu.tieba.i.b bVar) {
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

    public void setUserRecommend(com.baidu.tieba.frs.w wVar) {
        this.userRecommend = wVar;
    }

    public com.baidu.tieba.frs.w getUserRecommend() {
        return this.userRecommend;
    }

    public q getFrsVideoActivityData() {
        return this.mFrsVideoActivityData;
    }

    public void setFrsVideoActivityData(q qVar) {
        this.mFrsVideoActivityData = qVar;
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

    public bh getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(bh bhVar) {
        this.privateForumTotalData = bhVar;
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
