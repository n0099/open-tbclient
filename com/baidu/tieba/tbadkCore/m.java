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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
    private bx cardVideoInfo;
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
    private com.baidu.tieba.i.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    private HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected aw page;
    private int photoLivePos;
    private be privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bm schoolRecommendInfo;
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
        this.page = new aw();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new q();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new be();
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
                    if (!com.baidu.tbadk.core.util.y.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                        this.oriForumInfoList = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.oriForumInfoList.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.y.isEmpty(dataRes.activityhead.head_imgs)) {
                    this.mActivityHeadData = new com.baidu.tbadk.core.data.w();
                    this.mActivityHeadData.a(dataRes.activityhead);
                } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !au.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
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
                    this.cardVideoInfo = new bx();
                    this.cardVideoInfo.iP(true);
                    this.cardVideoInfo.ol(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.bmC();
                    this.cardVideoInfo.eER = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && j != 0) {
                        this.cardVideoInfo.setFid(j);
                    }
                    this.cardVideoInfo.F(this.color_eggs);
                    this.cardVideoInfo.iO(!this.cardVideoInfo.blh());
                    if (this.cardVideoInfo.blC() != null && this.cardVideoInfo.blC().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.blC().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                        mVar.dF(metaData.getPendantData().bym());
                        mVar.As(metaData.getPendantData().bjy());
                        this.cardVideoInfo.blC().setPendantData(mVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.mVA = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            bx bxVar = new bx();
                            bxVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            bxVar.eER = this.isBrandForum;
                            arrayList.add(bxVar);
                        }
                    }
                    this.mFrsInsertLiveData.mVz = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            bx bxVar2 = new bx();
                            bxVar2.a(dataRes.ala_stage_list.get(i5));
                            bxVar2.eER = this.isBrandForum;
                            arrayList2.add(bxVar2);
                        }
                    }
                    this.mFrsStageLiveData.mVC = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bm();
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
                com.baidu.tieba.recapp.d.a.dAG().Rb(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bx bxVar3 = new bx();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            bxVar3.ol(this.mCardShipinPos.get(i6).intValue());
                        }
                        bxVar3.iP(true);
                        bxVar3.a(dataRes.card_shipin_new.get(i6));
                        bxVar3.eER = this.isBrandForum;
                        this.mCardShipinNew.add(bxVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.i.b();
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
                            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("frs_service_version_" + this.forum.getName() + aaVar.name, "");
                            aaVar.bdX = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                ab abVar = new ab();
                                abVar.c(serviceArea.area_smart_app);
                                aaVar.mWQ = abVar;
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
                    this.serviceAreaData.mWP = arrayList3.size();
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
                    bx bxVar = new bx();
                    aq.a(j, bxVar);
                    bxVar.setUserMap(this.userMap);
                    bxVar.iV(true);
                    bxVar.a(threadInfo);
                    bxVar.bmC();
                    if (bxVar.getFid() == 0 && j != 0) {
                        bxVar.setFid(j);
                    }
                    if (StringUtils.isNull(bxVar.blG())) {
                        bxVar.Ax(this.forum.getName());
                    }
                    bxVar.F(this.color_eggs);
                    bxVar.eER = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(bxVar.bmO())) {
                        al alVar = new al();
                        alVar.Al(bxVar.bmO());
                        this.threadList.add(alVar);
                    } else {
                        this.threadList.add(bxVar);
                        JSONObject a2 = com.baidu.tieba.recapp.report.b.a(threadInfo, bxVar.blG());
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.dAN().fz(arrayList);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo() {
        ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
        setThreadList(switchThreadDataToThreadCardInfo);
        return switchThreadDataToThreadCardInfo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        int i2;
        this.mHasThreadExceptTop = false;
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if (next instanceof al) {
                ((al) next).position = i3;
                arrayList2.add(next);
                i = i3 + 1;
            } else if (next instanceof bx) {
                bx bxVar = (bx) next;
                com.baidu.tbadk.a.a.a.a(bxVar);
                int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
                if (bxVar.getType() == bx.eBR && !bxVar.isTop()) {
                    bw bwVar = new bw();
                    bwVar.evQ = bxVar;
                    bwVar.position = i3;
                    bwVar.eBx = true;
                    bwVar.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bwVar);
                    bw bwVar2 = new bw();
                    bwVar2.evQ = bxVar;
                    bwVar2.position = i3;
                    if (bxVar.bnz()) {
                        bwVar2.eBC = true;
                    } else if (bxVar.bmK() == 1) {
                        bwVar2.eBA = true;
                        bwVar2.eBO = imageWidthAndHeight[0];
                        bwVar2.eBP = imageWidthAndHeight[1];
                    } else if (bxVar.bmK() >= 2) {
                        bwVar2.eBB = true;
                    } else {
                        bwVar2.eBy = true;
                    }
                    bwVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bwVar2);
                    if (bxVar.bnJ() != null) {
                        bw bwVar3 = new bw();
                        bwVar3.eBK = true;
                        bwVar3.evQ = bxVar;
                        bwVar3.position = i3;
                        bwVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar3);
                    }
                    if (bxVar.bmr() != null) {
                        bw bwVar4 = new bw();
                        bwVar4.eBH = true;
                        bwVar4.evQ = bxVar;
                        bwVar4.position = i3;
                        bwVar4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar4);
                    }
                    if (!com.baidu.tbadk.core.util.y.isEmpty(bxVar.bnK()) || !com.baidu.tbadk.core.util.y.isEmpty(bxVar.bnL())) {
                        bw bwVar5 = new bw();
                        if (com.baidu.tbadk.core.util.y.getCount(bxVar.bnK()) + com.baidu.tbadk.core.util.y.getCount(bxVar.bnL()) == 1) {
                            bwVar5.eBL = true;
                        } else if (com.baidu.tbadk.core.util.y.getCount(bxVar.bnK()) + com.baidu.tbadk.core.util.y.getCount(bxVar.bnL()) > 1) {
                            bwVar5.eBM = true;
                        }
                        bwVar5.evQ = bxVar;
                        bwVar5.position = i3;
                        bwVar5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar5);
                    }
                    if (bxVar.bnh() != null) {
                        bw bwVar6 = new bw();
                        bwVar6.eBE = true;
                        bwVar6.evQ = bxVar;
                        bwVar6.position = i3;
                        bwVar6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar6);
                    }
                    bw bwVar7 = new bw();
                    bwVar7.eBD = true;
                    bwVar7.evQ = bxVar;
                    bwVar7.position = i3;
                    bwVar7.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bwVar7);
                    i2 = i3 + 1;
                } else if (bxVar.getType() == bx.eCo && !bxVar.isTop()) {
                    bw bwVar8 = new bw();
                    bwVar8.evQ = bxVar;
                    bwVar8.position = i3;
                    bwVar8.eBx = true;
                    bwVar8.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bwVar8);
                    bw bwVar9 = new bw();
                    bwVar9.evQ = bxVar;
                    bwVar9.position = i3;
                    bwVar9.eBF = true;
                    bwVar9.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bwVar9);
                    if (bxVar.bnJ() != null) {
                        bw bwVar10 = new bw();
                        bwVar10.eBK = true;
                        bwVar10.evQ = bxVar;
                        bwVar10.position = i3;
                        bwVar10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar10);
                    }
                    if (bxVar.bmr() != null) {
                        bw bwVar11 = new bw();
                        bwVar11.eBH = true;
                        bwVar11.evQ = bxVar;
                        bwVar11.position = i3;
                        bwVar11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar11);
                    }
                    if (bxVar.bnh() != null) {
                        bw bwVar12 = new bw();
                        bwVar12.eBE = true;
                        bwVar12.evQ = bxVar;
                        bwVar12.position = i3;
                        bwVar12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar12);
                    }
                    bw bwVar13 = new bw();
                    bwVar13.eBD = true;
                    bwVar13.evQ = bxVar;
                    bwVar13.position = i3;
                    bwVar13.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bwVar13);
                    i2 = i3 + 1;
                } else if (bxVar.blU() != null && !bxVar.bmJ() && bxVar.blF()) {
                    bw bwVar14 = new bw();
                    bwVar14.evQ = bxVar;
                    bwVar14.position = i3;
                    bwVar14.eBx = true;
                    bwVar14.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bwVar14);
                    bw bwVar15 = new bw();
                    bwVar15.evQ = bxVar;
                    bwVar15.position = i3;
                    bwVar15.eBG = true;
                    bwVar15.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bwVar15);
                    if (bxVar.bnJ() != null) {
                        bw bwVar16 = new bw();
                        bwVar16.eBK = true;
                        bwVar16.evQ = bxVar;
                        bwVar16.position = i3;
                        bwVar16.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar16);
                    }
                    if (bxVar.bmr() != null) {
                        bw bwVar17 = new bw();
                        bwVar17.eBH = true;
                        bwVar17.evQ = bxVar;
                        bwVar17.position = i3;
                        bwVar17.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar17);
                    }
                    if (bxVar.bnh() != null) {
                        bw bwVar18 = new bw();
                        bwVar18.eBE = true;
                        bwVar18.evQ = bxVar;
                        bwVar18.position = i3;
                        bwVar18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bwVar18);
                    }
                    bw bwVar19 = new bw();
                    bwVar19.eBD = true;
                    bwVar19.evQ = bxVar;
                    bwVar19.position = i3;
                    bwVar19.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bwVar19);
                    i2 = i3 + 1;
                } else if (bxVar.getType() == bx.eCg && bxVar.bkk()) {
                    bxVar.position = i3;
                    arrayList2.add(bxVar);
                    i2 = i3 + 1;
                } else {
                    bw bwVar20 = new bw();
                    bwVar20.evQ = bxVar;
                    bwVar20.position = i3;
                    arrayList2.add(bwVar20);
                    i2 = i3 + 1;
                }
                bxVar.setSupportType(BaseCardInfo.SupportType.TOP);
                i = i2;
            } else {
                arrayList2.add(next);
                i = i3 + 1;
            }
            if (next != null && next.getType() != bx.eBQ) {
                this.mHasThreadExceptTop = true;
            }
            i3 = i;
        }
        com.baidu.tbadk.a.a.a.be(arrayList2);
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

    public aw getPage() {
        return this.page;
    }

    public void setPage(aw awVar) {
        this.page = awVar;
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

    public bx getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(bx bxVar) {
        this.cardVideoInfo = bxVar;
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

    public bm getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bm bmVar) {
        this.schoolRecommendInfo = bmVar;
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

    public List<com.baidu.adp.widget.ListView.q> getCardShipinNew() {
        return this.mCardShipinNew;
    }

    public void setCardShipinNew(List<com.baidu.adp.widget.ListView.q> list) {
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

    public be getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public void setPrivateForumTotalInfo(be beVar) {
        this.privateForumTotalData = beVar;
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
