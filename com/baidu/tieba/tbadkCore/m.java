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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
    private by cardVideoInfo;
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
    private List<com.baidu.adp.widget.ListView.q> mCardShipinNew;
    private List<Integer> mCardShipinPos;
    private NavTabInfo mEntelechyTabInfo;
    private g mFrsInsertLiveData;
    private h mFrsStageLiveData;
    private q mFrsVideoActivityData;
    private com.baidu.tieba.i.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    private HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    private int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    protected ax page;
    private int photoLivePos;
    private bf privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    private bn schoolRecommendInfo;
    public aa serviceAreaData;
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
    private com.baidu.tieba.frs.x userRecommend;
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
                    this.cardVideoInfo = new by();
                    this.cardVideoInfo.je(true);
                    this.cardVideoInfo.oJ(this.photoLivePos);
                    this.cardVideoInfo.setUserMap(this.userMap);
                    this.cardVideoInfo.a(dataRes.card_shipin_info.get(0));
                    this.cardVideoInfo.bpP();
                    this.cardVideoInfo.eLT = this.isBrandForum;
                    if (this.cardVideoInfo.getFid() == 0 && j != 0) {
                        this.cardVideoInfo.setFid(j);
                    }
                    this.cardVideoInfo.F(this.color_eggs);
                    this.cardVideoInfo.jd(!this.cardVideoInfo.bou());
                    if (this.cardVideoInfo.boP() != null && this.cardVideoInfo.boP().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.boP().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.n nVar = new com.baidu.tbadk.data.n();
                        nVar.ee(metaData.getPendantData().bBM());
                        nVar.AZ(metaData.getPendantData().bmL());
                        this.cardVideoInfo.boP().setPendantData(nVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.mFrsInsertLiveData = new g();
                    this.mFrsInsertLiveData.njy = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                            by byVar = new by();
                            byVar.a(dataRes.ala_live_insert.ala_live_list.get(i4));
                            byVar.eLT = this.isBrandForum;
                            arrayList.add(byVar);
                        }
                    }
                    this.mFrsInsertLiveData.njx = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.mFrsStageLiveData = new h();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                        if (dataRes.ala_stage_list.get(i5) != null) {
                            by byVar2 = new by();
                            byVar2.a(dataRes.ala_stage_list.get(i5));
                            byVar2.eLT = this.isBrandForum;
                            arrayList2.add(byVar2);
                        }
                    }
                    this.mFrsStageLiveData.njA = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                    this.schoolRecommendInfo = new bn();
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
                com.baidu.tieba.recapp.d.a.dFX().Sk(dataRes.asp_shown_info);
                this.mCardShipinPos = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        by byVar3 = new by();
                        if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                            byVar3.oJ(this.mCardShipinPos.get(i6).intValue());
                        }
                        byVar3.je(true);
                        byVar3.a(dataRes.card_shipin_new.get(i6));
                        byVar3.eLT = this.isBrandForum;
                        this.mCardShipinNew.add(byVar3);
                    }
                }
                this.enterFrsDialogInfo = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.mGameRankListData = new com.baidu.tieba.i.b();
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
                            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("frs_service_version_" + this.forum.getName() + abVar.name, "");
                            abVar.ivV = TextUtils.isEmpty(string) || !string.equals(serviceArea.version);
                            if (serviceArea.area_smart_app != null) {
                                ac acVar = new ac();
                                acVar.c(serviceArea.area_smart_app);
                                abVar.nkO = acVar;
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
                    this.serviceAreaData.nkN = arrayList3.size();
                    this.serviceAreaData.dataList = arrayList3;
                }
                this.itemInfo = dataRes.item_info;
                this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
                this.forumRule = dataRes.forum_rule;
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
                    by byVar = new by();
                    aq.a(j, byVar);
                    byVar.setUserMap(this.userMap);
                    byVar.jk(true);
                    byVar.a(threadInfo);
                    byVar.bpP();
                    byVar.bor();
                    if (byVar.getFid() == 0 && j != 0) {
                        byVar.setFid(j);
                    }
                    if (StringUtils.isNull(byVar.boT())) {
                        byVar.Be(this.forum.getName());
                    }
                    byVar.F(this.color_eggs);
                    byVar.eLT = this.forum.isBrandForum;
                    if (!TextUtils.isEmpty(byVar.bqb())) {
                        am amVar = new am();
                        amVar.AS(byVar.bqb());
                        this.threadList.add(amVar);
                    } else {
                        this.threadList.add(byVar);
                        JSONObject a2 = com.baidu.tieba.recapp.report.b.a(threadInfo, byVar.boT());
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            com.baidu.tieba.recapp.report.b.dGe().q("tag_frs_tab", arrayList);
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
            if (next instanceof am) {
                ((am) next).position = i3;
                arrayList2.add(next);
                i = i3 + 1;
            } else if (next instanceof by) {
                by byVar = (by) next;
                com.baidu.tbadk.a.a.a.a(byVar);
                int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                if (byVar.getType() == by.eIS && !byVar.isTop()) {
                    bx bxVar = new bx();
                    bxVar.eCR = byVar;
                    bxVar.position = i3;
                    bxVar.eIy = true;
                    bxVar.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bxVar);
                    bx bxVar2 = new bx();
                    bxVar2.eCR = byVar;
                    bxVar2.position = i3;
                    if (byVar.bqM()) {
                        bxVar2.eID = true;
                    } else if (byVar.bpX() == 1) {
                        bxVar2.eIB = true;
                        bxVar2.eIP = imageWidthAndHeight[0];
                        bxVar2.eIQ = imageWidthAndHeight[1];
                    } else if (byVar.bpX() >= 2) {
                        bxVar2.eIC = true;
                    } else {
                        bxVar2.eIz = true;
                    }
                    bxVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bxVar2);
                    if (byVar.bqX() != null) {
                        bx bxVar3 = new bx();
                        bxVar3.eIL = true;
                        bxVar3.eCR = byVar;
                        bxVar3.position = i3;
                        bxVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar3);
                    }
                    if (byVar.bpE() != null) {
                        bx bxVar4 = new bx();
                        bxVar4.eII = true;
                        bxVar4.eCR = byVar;
                        bxVar4.position = i3;
                        bxVar4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar4);
                    }
                    if (!com.baidu.tbadk.core.util.y.isEmpty(byVar.bqY()) || !com.baidu.tbadk.core.util.y.isEmpty(byVar.bqZ())) {
                        bx bxVar5 = new bx();
                        if (com.baidu.tbadk.core.util.y.getCount(byVar.bqY()) + com.baidu.tbadk.core.util.y.getCount(byVar.bqZ()) == 1) {
                            bxVar5.eIM = true;
                        } else if (com.baidu.tbadk.core.util.y.getCount(byVar.bqY()) + com.baidu.tbadk.core.util.y.getCount(byVar.bqZ()) > 1) {
                            bxVar5.eIN = true;
                        }
                        bxVar5.eCR = byVar;
                        bxVar5.position = i3;
                        bxVar5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar5);
                    }
                    if (byVar.bqu() != null) {
                        bx bxVar6 = new bx();
                        bxVar6.eIF = true;
                        bxVar6.eCR = byVar;
                        bxVar6.position = i3;
                        bxVar6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar6);
                    }
                    if (byVar.bqV() != null && !byVar.bpS()) {
                        bx bxVar7 = new bx();
                        bxVar7.eIK = true;
                        bxVar7.eCR = byVar;
                        bxVar7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar7);
                    }
                    bx bxVar8 = new bx();
                    bxVar8.eIE = true;
                    bxVar8.eCR = byVar;
                    bxVar8.position = i3;
                    bxVar8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bxVar8);
                    i2 = i3 + 1;
                } else if (byVar.getType() == by.eJq && !byVar.isTop()) {
                    bx bxVar9 = new bx();
                    bxVar9.eCR = byVar;
                    bxVar9.position = i3;
                    bxVar9.eIy = true;
                    bxVar9.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bxVar9);
                    bx bxVar10 = new bx();
                    bxVar10.eCR = byVar;
                    bxVar10.position = i3;
                    bxVar10.eIG = true;
                    bxVar10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bxVar10);
                    if (byVar.bqX() != null) {
                        bx bxVar11 = new bx();
                        bxVar11.eIL = true;
                        bxVar11.eCR = byVar;
                        bxVar11.position = i3;
                        bxVar11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar11);
                    }
                    if (byVar.bpE() != null) {
                        bx bxVar12 = new bx();
                        bxVar12.eII = true;
                        bxVar12.eCR = byVar;
                        bxVar12.position = i3;
                        bxVar12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar12);
                    }
                    if (byVar.bqu() != null) {
                        bx bxVar13 = new bx();
                        bxVar13.eIF = true;
                        bxVar13.eCR = byVar;
                        bxVar13.position = i3;
                        bxVar13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar13);
                    }
                    if (byVar.bqV() != null && !byVar.bpS()) {
                        bx bxVar14 = new bx();
                        bxVar14.eIK = true;
                        bxVar14.eCR = byVar;
                        bxVar14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar14);
                    }
                    bx bxVar15 = new bx();
                    bxVar15.eIE = true;
                    bxVar15.eCR = byVar;
                    bxVar15.position = i3;
                    bxVar15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bxVar15);
                    i2 = i3 + 1;
                } else if (byVar.bph() != null && !byVar.bpW() && byVar.boS()) {
                    bx bxVar16 = new bx();
                    bxVar16.eCR = byVar;
                    bxVar16.position = i3;
                    bxVar16.eIy = true;
                    bxVar16.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(bxVar16);
                    bx bxVar17 = new bx();
                    bxVar17.eCR = byVar;
                    bxVar17.position = i3;
                    bxVar17.eIH = true;
                    bxVar17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(bxVar17);
                    if (byVar.bqX() != null) {
                        bx bxVar18 = new bx();
                        bxVar18.eIL = true;
                        bxVar18.eCR = byVar;
                        bxVar18.position = i3;
                        bxVar18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar18);
                    }
                    if (byVar.bpE() != null) {
                        bx bxVar19 = new bx();
                        bxVar19.eII = true;
                        bxVar19.eCR = byVar;
                        bxVar19.position = i3;
                        bxVar19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar19);
                    }
                    if (byVar.bqu() != null) {
                        bx bxVar20 = new bx();
                        bxVar20.eIF = true;
                        bxVar20.eCR = byVar;
                        bxVar20.position = i3;
                        bxVar20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar20);
                    }
                    if (byVar.bqV() != null && !byVar.bpS()) {
                        bx bxVar21 = new bx();
                        bxVar21.eIK = true;
                        bxVar21.eCR = byVar;
                        bxVar21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bxVar21);
                    }
                    bx bxVar22 = new bx();
                    bxVar22.eIE = true;
                    bxVar22.eCR = byVar;
                    bxVar22.position = i3;
                    bxVar22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(bxVar22);
                    i2 = i3 + 1;
                } else if (byVar.getType() == by.eJh && byVar.bnx()) {
                    byVar.position = i3;
                    arrayList2.add(byVar);
                    i2 = i3 + 1;
                } else {
                    bx bxVar23 = new bx();
                    bxVar23.eCR = byVar;
                    bxVar23.position = i3;
                    arrayList2.add(bxVar23);
                    i2 = i3 + 1;
                }
                byVar.setSupportType(BaseCardInfo.SupportType.TOP);
                i = i2;
            } else {
                arrayList2.add(next);
                i = i3 + 1;
            }
            if (next != null && next.getType() != by.eIR) {
                this.mHasThreadExceptTop = true;
            }
            i3 = i;
        }
        com.baidu.tbadk.a.a.a.bh(arrayList2);
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

    public by getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public void setCardVideoInfo(by byVar) {
        this.cardVideoInfo = byVar;
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

    public bn getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public void setSchoolRecommendInfo(bn bnVar) {
        this.schoolRecommendInfo = bnVar;
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

    public void setUserRecommend(com.baidu.tieba.frs.x xVar) {
        this.userRecommend = xVar;
    }

    public com.baidu.tieba.frs.x getUserRecommend() {
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
