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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
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
    private bz cardVideoInfo;
    private com.baidu.tbadk.core.data.r carrierEnterData;
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
    protected ax page;
    private int photoLivePos;
    private bf privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bo schoolRecommendInfo;
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
    private ArrayList<com.baidu.tbadk.core.data.t> color_eggs = new ArrayList<>();
    protected com.baidu.tbadk.core.data.w mActivityHeadData = null;
    private int frsDefaultTabId = 1;
    private boolean isShowRedTip = false;
    private String bawuCenterUrl = null;
    private af headSdkData = null;
    public ag recommendBookData = null;
    public RecomPostTopic postTopic = null;
    private com.baidu.tbadk.core.data.x bookInfoData = null;
    private Integer mangaReadRecordChapterId = -1;
    public com.baidu.tbadk.core.data.ad presentInfoData = null;
    private com.baidu.tbadk.core.data.aa headlineImgInfoData = null;
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
        this.page = new ax();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new r();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new bf();
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
                if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.isEmpty(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                            if (tVar.a(colorEgg)) {
                                this.color_eggs.add(tVar);
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
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.w();
                    this.mActivityHeadData.a(dataRes.brand_forum_info.head_imgs);
                    this.brandAdData = new com.baidu.tieba.frs.d();
                    this.brandAdData.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                        this.oriForumInfoList = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.oriForumInfoList.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.isEmpty(dataRes.activityhead.head_imgs)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.w();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !at.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.w();
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
                    ap.b(Long.valueOf(longValue), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
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
                if (this.mEntelechyTabInfo != null && com.baidu.tbadk.core.util.x.getItem(this.mEntelechyTabInfo.tab, 0) != null) {
                    this.defaultShowTab = ((FrsTabInfo) com.baidu.tbadk.core.util.x.getItem(this.mEntelechyTabInfo.tab, 0)).tab_id.intValue();
                }
                if (com.baidu.tbadk.a.d.bje() && !com.baidu.tbadk.a.b.a.eEl.equals(((FrsTabInfo) com.baidu.tbadk.core.util.x.getItem(this.mEntelechyTabInfo.tab, 0)).tab_name)) {
                    this.defaultShowTab = com.baidu.tbadk.a.b.a.bjl();
                }
                if (this.mEntelechyTabInfo != null && !com.baidu.tbadk.core.util.x.isEmpty(this.mEntelechyTabInfo.head)) {
                    this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                handleDefaultTab(dataRes.frs_tab_default.intValue());
                this.photoLivePos = dataRes.twzhibo_pos.intValue();
                this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
                convertThreadInfoToThreadData(dataRes.thread_list, j);
                this.categoryInfos = dataRes.category_list;
                if (!at.isEmpty(dataRes.bawu_enter_url)) {
                    this.bawuCenterUrl = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.headSdkData = new af();
                    this.headSdkData.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.recommendBookData = new ag();
                    this.recommendBookData.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.bookInfoData = new com.baidu.tbadk.core.data.x();
                    this.bookInfoData.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.presentInfoData = new com.baidu.tbadk.core.data.ad();
                    this.presentInfoData.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.headlineImgInfoData = new com.baidu.tbadk.core.data.aa();
                    this.headlineImgInfoData.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.business_promot != null) {
                    this.businessPromot = new i();
                    this.businessPromot.a(dataRes.business_promot);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.cardVideoInfo = new bz();
                    this.cardVideoInfo.jw(true);
                    this.cardVideoInfo.nn(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.box();
                    this.cardVideoInfo.eRc = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && j != 0) {
                        this.cardVideoInfo.setFid(j);
                    }
                    this.cardVideoInfo.A(this.color_eggs);
                    this.cardVideoInfo.jv(!this.cardVideoInfo.bnc());
                    if (this.cardVideoInfo.bnx() != null && this.cardVideoInfo.bnx().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.bnx().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.n nVar = new com.baidu.tbadk.data.n();
                        nVar.ee(metaData.getPendantData().bAo());
                        nVar.zM(metaData.getPendantData().getImgUrl());
                        this.cardVideoInfo.bnx().setPendantData(nVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.nkA = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            bz bzVar = new bz();
                            bzVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            bzVar.eRc = this.isBrandForum;
                            arrayList.add(bzVar);
                        }
                    }
                    this.mFrsInsertLiveData.nkz = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            bz bzVar2 = new bz();
                            bzVar2.a(dataRes.ala_stage_list.get(i5));
                            bzVar2.eRc = this.isBrandForum;
                            arrayList2.add(bzVar2);
                        }
                    }
                    this.mFrsStageLiveData.nkC = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bo();
                    this.schoolRecommendInfo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.carrierEnterData = new com.baidu.tbadk.core.data.r();
                    this.carrierEnterData.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.needLog = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.dBW().QJ(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bz bzVar3 = new bz();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            bzVar3.nn(this.mCardShipinPos.get(i6).intValue());
                        }
                        bzVar3.jw(true);
                        bzVar3.a(dataRes.card_shipin_new.get(i6));
                        bzVar3.eRc = this.isBrandForum;
                        this.mCardShipinNew.add(bzVar3);
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
                if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.service_area)) {
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
                            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("frs_service_version_" + this.forum.getName() + abVar.name, "");
                            abVar.iDD = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                ac acVar = new ac();
                                acVar.c(serviceArea.area_smart_app);
                                abVar.nlQ = acVar;
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
                    this.serviceAreaData.nlP = arrayList3.size();
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bz bzVar = new bz();
                    ap.a(j, bzVar);
                    bzVar.setUserMap(this.userMap);
                    bzVar.jC(true);
                    bzVar.a(threadInfo);
                    bzVar.box();
                    bzVar.bmZ();
                    if (bzVar.getFid() == 0 && j != 0) {
                        bzVar.setFid(j);
                    }
                    if (StringUtils.isNull(bzVar.bnB())) {
                        bzVar.zR(this.forum.getName());
                    }
                    bzVar.A(this.color_eggs);
                    bzVar.eRc = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(bzVar.boJ())) {
                        am amVar = new am();
                        amVar.zE(bzVar.boJ());
                        this.threadList.add(amVar);
                    } else {
                        this.threadList.add(bzVar);
                        JSONObject a2 = com.baidu.tieba.recapp.report.b.a(threadInfo, bzVar.bnB());
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.dCd().q("FRS", arrayList);
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
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if (next instanceof am) {
                ((am) next).position = i3;
                arrayList2.add(next);
                i = i3 + 1;
            } else if (next instanceof bz) {
                bz bzVar = (bz) next;
                com.baidu.tbadk.a.a.a.a(bzVar);
                int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                if (bzVar.getType() == bz.eOa && !bzVar.boh()) {
                    by byVar = new by();
                    byVar.eHK = bzVar;
                    byVar.position = i3;
                    byVar.eNF = true;
                    byVar.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(byVar);
                    by byVar2 = new by();
                    byVar2.eHK = bzVar;
                    byVar2.position = i3;
                    if (bzVar.bpv()) {
                        byVar2.eNK = true;
                    } else if (bzVar.boF() == 1) {
                        byVar2.eNI = true;
                        byVar2.eNX = imageWidthAndHeight[0];
                        byVar2.eNY = imageWidthAndHeight[1];
                    } else if (bzVar.boF() >= 2) {
                        byVar2.eNJ = true;
                    } else {
                        byVar2.eNG = true;
                    }
                    byVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(byVar2);
                    if (bzVar.bpG() != null) {
                        by byVar3 = new by();
                        byVar3.eNT = true;
                        byVar3.eHK = bzVar;
                        byVar3.position = i3;
                        byVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar3);
                    }
                    if (bzVar.bom() != null) {
                        by byVar4 = new by();
                        byVar4.eNQ = true;
                        byVar4.eHK = bzVar;
                        byVar4.position = i3;
                        byVar4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar4);
                    }
                    if (!com.baidu.tbadk.core.util.x.isEmpty(bzVar.bpH()) || !com.baidu.tbadk.core.util.x.isEmpty(bzVar.bpI())) {
                        by byVar5 = new by();
                        if (com.baidu.tbadk.core.util.x.getCount(bzVar.bpH()) + com.baidu.tbadk.core.util.x.getCount(bzVar.bpI()) == 1) {
                            byVar5.eNU = true;
                        } else if (com.baidu.tbadk.core.util.x.getCount(bzVar.bpH()) + com.baidu.tbadk.core.util.x.getCount(bzVar.bpI()) > 1) {
                            byVar5.eNV = true;
                        }
                        byVar5.eHK = bzVar;
                        byVar5.position = i3;
                        byVar5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar5);
                    }
                    if (bzVar.bpd() != null) {
                        by byVar6 = new by();
                        byVar6.eNM = true;
                        byVar6.eHK = bzVar;
                        byVar6.position = i3;
                        byVar6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar6);
                    }
                    if (bzVar.bpE() != null && !bzVar.boA()) {
                        by byVar7 = new by();
                        byVar7.eNS = true;
                        byVar7.eHK = bzVar;
                        byVar7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar7);
                    }
                    by byVar8 = new by();
                    byVar8.eNL = true;
                    byVar8.eHK = bzVar;
                    byVar8.position = i3;
                    byVar8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(byVar8);
                    i2 = i3 + 1;
                } else if ((bzVar.getType() == bz.eOy || bzVar.getType() == bz.eOR) && !bzVar.boh()) {
                    by byVar9 = new by();
                    byVar9.eHK = bzVar;
                    byVar9.position = i3;
                    byVar9.eNF = true;
                    byVar9.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(byVar9);
                    by byVar10 = new by();
                    byVar10.eHK = bzVar;
                    byVar10.position = i3;
                    if (bzVar instanceof au) {
                        byVar10.eNO = true;
                    } else {
                        byVar10.eNN = true;
                    }
                    byVar10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(byVar10);
                    if (bzVar.bpG() != null) {
                        by byVar11 = new by();
                        byVar11.eNT = true;
                        byVar11.eHK = bzVar;
                        byVar11.position = i3;
                        byVar11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar11);
                    }
                    if (bzVar.bom() != null) {
                        by byVar12 = new by();
                        byVar12.eNQ = true;
                        byVar12.eHK = bzVar;
                        byVar12.position = i3;
                        byVar12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar12);
                    }
                    if (bzVar.bpd() != null) {
                        by byVar13 = new by();
                        byVar13.eNM = true;
                        byVar13.eHK = bzVar;
                        byVar13.position = i3;
                        byVar13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar13);
                    }
                    if (bzVar.bpE() != null && !bzVar.boA()) {
                        by byVar14 = new by();
                        byVar14.eNS = true;
                        byVar14.eHK = bzVar;
                        byVar14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar14);
                    }
                    by byVar15 = new by();
                    byVar15.eNL = true;
                    byVar15.eHK = bzVar;
                    byVar15.position = i3;
                    byVar15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(byVar15);
                    i2 = i3 + 1;
                } else if (bzVar.bnO() != null && !bzVar.boE() && bzVar.bnA()) {
                    by byVar16 = new by();
                    byVar16.eHK = bzVar;
                    byVar16.position = i3;
                    byVar16.eNF = true;
                    byVar16.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(byVar16);
                    by byVar17 = new by();
                    byVar17.eHK = bzVar;
                    byVar17.position = i3;
                    byVar17.eNP = true;
                    byVar17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(byVar17);
                    if (bzVar.bpG() != null) {
                        by byVar18 = new by();
                        byVar18.eNT = true;
                        byVar18.eHK = bzVar;
                        byVar18.position = i3;
                        byVar18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar18);
                    }
                    if (bzVar.bom() != null) {
                        by byVar19 = new by();
                        byVar19.eNQ = true;
                        byVar19.eHK = bzVar;
                        byVar19.position = i3;
                        byVar19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar19);
                    }
                    if (bzVar.bpd() != null) {
                        by byVar20 = new by();
                        byVar20.eNM = true;
                        byVar20.eHK = bzVar;
                        byVar20.position = i3;
                        byVar20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar20);
                    }
                    if (bzVar.bpE() != null && !bzVar.boA()) {
                        by byVar21 = new by();
                        byVar21.eNS = true;
                        byVar21.eHK = bzVar;
                        byVar21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(byVar21);
                    }
                    by byVar22 = new by();
                    byVar22.eNL = true;
                    byVar22.eHK = bzVar;
                    byVar22.position = i3;
                    byVar22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(byVar22);
                    i2 = i3 + 1;
                } else if (bzVar.getType() == bz.eOp && bzVar.bme()) {
                    bzVar.position = i3;
                    arrayList2.add(bzVar);
                    i2 = i3 + 1;
                } else {
                    by byVar23 = new by();
                    byVar23.eHK = bzVar;
                    byVar23.position = i3;
                    arrayList2.add(byVar23);
                    i2 = i3 + 1;
                }
                bzVar.setSupportType(BaseCardInfo.SupportType.TOP);
                i = i2;
            } else {
                arrayList2.add(next);
                i = i3 + 1;
            }
            if (next != null && next.getType() != bz.eNZ) {
                this.mHasThreadExceptTop = true;
            }
            i3 = i;
        }
        com.baidu.tbadk.a.a.a.bo(arrayList2);
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

    public ax getPage() {
        return this.page;
    }

    public void setPage(ax axVar) {
        this.page = axVar;
    }

    public n getStar() {
        return this.star;
    }

    public void setStar(n nVar) {
        this.star = nVar;
    }

    public com.baidu.tbadk.core.data.w getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public void setActivityHeadData(com.baidu.tbadk.core.data.w wVar) {
        this.mActivityHeadData = wVar;
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

    public bz getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(bz bzVar) {
        this.cardVideoInfo = bzVar;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public void setFrsDefaultTabId(int i) {
        this.frsDefaultTabId = i;
    }

    public af getHeadSdkData() {
        return this.headSdkData;
    }

    public void setHeadSdkData(af afVar) {
        this.headSdkData = afVar;
    }

    public com.baidu.tbadk.core.data.x getBookInfo() {
        return this.bookInfoData;
    }

    public void setBookInfo(com.baidu.tbadk.core.data.x xVar) {
        this.bookInfoData = xVar;
    }

    public com.baidu.tbadk.core.data.aa getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public void setHeadlineImgInfoData(com.baidu.tbadk.core.data.aa aaVar) {
        this.headlineImgInfoData = aaVar;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public void setSchoolRecommendPos(int i) {
        this.schoolRecommendPos = i;
    }

    public bo getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bo boVar) {
        this.schoolRecommendInfo = boVar;
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

    public com.baidu.tbadk.core.data.r getCarrierEnterData() {
        return this.carrierEnterData;
    }

    public void setCarrierEnterData(com.baidu.tbadk.core.data.r rVar) {
        this.carrierEnterData = rVar;
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

    public bf getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(bf bfVar) {
        this.privateForumTotalData = bfVar;
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
