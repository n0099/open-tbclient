package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes22.dex */
public class f {
    public AppealInfo lgR;
    public String lgS;
    public CardHListViewData lgT;
    public String lgU;
    public int lgV;
    public int lgW;
    public List<PbSortType> lgX;
    public int lgY;
    public k lgZ;
    private o lhA;
    private String lhB;
    private String lhC;
    private List<com.baidu.tbadk.core.data.n> lhF;
    private com.baidu.tieba.pb.videopb.c.a lhH;
    private PostData lhI;
    private PostData lhK;
    public boolean lhM;
    private ac lhP;
    public String lhQ;
    public String lhR;
    public a lhd;
    private String lhi;
    private int lhj;
    private List<bw> lhp;
    private AlaLiveInfoCoreData lhq;
    private TwzhiboAnti lht;
    private List<bs> lhu;
    private List<bs> lhv;
    private PostData lhx;
    private i lhy;
    private long lhz;
    public boolean lha = false;
    public boolean lhb = false;
    public boolean lhc = false;
    public boolean lhe = false;
    private boolean lhn = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> lhr = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n lhs = null;
    private int lhG = 0;
    public boolean lhJ = true;
    public int lhL = 0;
    public int YH = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> lhN = new ArrayList();
    private ForumData forum = new ForumData();
    private bs lhf = new bs();
    private bw gbZ = new bw();
    private ArrayList<PostData> lhg = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f lhh = new com.baidu.tbadk.data.f();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lhm = new ArrayList();
    private ay lhk = new ay();
    private az lho = new az();
    private am lhl = new am();
    private r lhw = new r();
    private z lhO = new z();
    private List<bm.a> lhD = new ArrayList();
    private HashSet<String> lhE = new HashSet<>();

    public f() {
        this.lhj = 0;
        this.lht = null;
        this.lhj = 0;
        this.lht = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lhg != null && this.lhg.size() > 0;
    }

    public String[] fJ(Context context) {
        return r(context, true);
    }

    public String[] r(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.lhg.size() > 30 ? 30 : this.lhg.size();
            if (dfI() == null || dfI().bka() == null || at.isEmpty(dfI().bka().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dfI().bka().getUserId();
            PostData dfS = dfS();
            if (dfS == null || dfS.bka() == null || at.isEmpty(dfS.bka().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, dfS.bka().getUserId())) {
                    str4 = null;
                } else {
                    str4 = dfS.dHE();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = dfS.dHC();
                }
            }
            if (at.isEmpty(str2) && at.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) y.getItem(this.lhg, i);
                    if (postData != null && postData.bka() != null && !at.isEmpty(postData.bka().getUserId()) && at.equals(userId, postData.bka().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dHE();
                        }
                        String dHC = at.isEmpty(str6) ? postData.dHC() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dHC)) {
                            str = dHC;
                            str3 = str5;
                            break;
                        }
                        str6 = dHC;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && at.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.gbZ != null && this.gbZ.bla() != null && this.gbZ.bla().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.gbZ == null || this.gbZ.bks() == null || at.isEmpty(this.gbZ.bks().thumbnail_url)) ? str3 : this.gbZ.bks().thumbnail_url;
            if (this.gbZ != null && !this.gbZ.isShareThread && str5 == null && this.gbZ.eAy != null && this.gbZ.eAy.evS != null) {
                ArrayList<MediaData> arrayList = this.gbZ.eAy.evS;
                int size2 = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    MediaData mediaData = arrayList.get(i2);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str5 = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str5 = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i2++;
                }
            }
        }
        return new String[]{str5, str};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bs dfH() {
        return this.lhf;
    }

    public void d(bs bsVar) {
        this.lhf = bsVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public String getForumName() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getName();
    }

    public bw dfI() {
        return this.gbZ;
    }

    public void aF(bw bwVar) {
        this.gbZ = bwVar;
    }

    public List<bw> dfJ() {
        return this.lhp;
    }

    public String getThreadId() {
        if (this.gbZ == null) {
            return "";
        }
        return this.gbZ.getId();
    }

    public ArrayList<PostData> dfK() {
        return this.lhg;
    }

    public av getPage() {
        return this.page;
    }

    public am dfL() {
        return this.lhl;
    }

    public az dfM() {
        return this.lho;
    }

    public z dfN() {
        if (this.lhO == null || !this.lhO.isValid()) {
            return null;
        }
        return this.lhO;
    }

    public ac dfO() {
        if (this.lhP == null || !this.lhP.isValid()) {
            return null;
        }
        return this.lhP;
    }

    public void a(av avVar, int i) {
        this.page.nQ(avVar.biO());
        this.page.nO(avVar.bhP());
        this.page.nN(avVar.biL());
        this.page.nR(avVar.biP());
        this.page.nP(avVar.biN());
        if (i == 0) {
            this.page = avVar;
        } else if (i == 1) {
            this.page.nS(avVar.biQ());
        } else if (i == 2) {
            this.page.nT(avVar.biR());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bfV() {
        return this.gbZ.bkh() != 0;
    }

    public void ih(boolean z) {
        if (this.gbZ != null) {
            if (z) {
                this.gbZ.od(1);
            } else {
                this.gbZ.od(0);
            }
        }
    }

    public String bfU() {
        if (this.gbZ != null) {
            return this.gbZ.bki();
        }
        return null;
    }

    public void Pa(String str) {
        if (this.gbZ != null) {
            this.gbZ.AP(str);
        }
    }

    public String dfP() {
        return this.lhC;
    }

    public boolean dfQ() {
        return (this.gbZ == null || this.gbZ.bkk() == null || this.gbZ.bkk().size() <= 0 || this.gbZ.bkk().get(0) == null || !this.gbZ.bkk().get(0).bhQ()) ? false : true;
    }

    public PostData dfR() {
        return this.lhI;
    }

    public void d(PostData postData) {
        this.lhI = postData;
        this.lhK = postData;
        this.lhJ = false;
    }

    public PostData dfS() {
        return this.lhK;
    }

    public void e(PostData postData) {
        this.lhK = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dyA().Rm(dataRes.asp_shown_info);
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.lhf.parserProtobuf(dataRes.display_forum);
                this.gbZ.setUserMap(this.userMap);
                this.gbZ.a(dataRes.thread);
                this.lhk.a(dataRes.news_info);
                switch (this.lhk.eaI) {
                    case 1:
                        this.lhl.ltx = this.lhk;
                        break;
                    case 2:
                        this.lhl.lty = this.lhk;
                        break;
                    case 3:
                        this.lhl.ltz = this.lhk;
                        break;
                    default:
                        this.lhl.lty = this.lhk;
                        break;
                }
                this.lho.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lhI = new PostData();
                this.lhI.Jq(1);
                this.lhI.setUserMap(this.userMap);
                this.lhI.xh(this.forum.isBrandForum);
                this.lhI.setTime(this.gbZ.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lhI.a(dataRes.first_floor_post, context);
                }
                if (this.gbZ != null && this.gbZ.isShareThread) {
                    this.lhI.h(this.gbZ.eAy);
                }
                if (this.lhK == null) {
                    this.lhK = this.lhI;
                    this.lhJ = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lhh.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lhm.add(muteUser);
                        }
                    }
                }
                this.gbZ.nZ(this.gbZ.bjR() > 0 ? this.gbZ.bjR() - 1 : 0);
                List<AppData> dxK = com.baidu.tieba.recapp.r.dxM().dxK();
                if (dxK != null) {
                    dxK.clear();
                }
                this.lhs = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dHl = nVar.dHl();
                        if (!this.lhr.contains(nVar) && dHl.goods != null && (!StringUtils.isNull(dHl.goods.user_name) || !StringUtils.isNull(dHl.goods.lego_card))) {
                            nVar.lwz = dgi();
                            this.lhr.add(nVar);
                            if (dxK != null) {
                                dxK.add(nVar.dHl());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dxM().dxL();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lht.parserProtobuf(dataRes.twzhibo_anti);
                this.lgR = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lhy = new i();
                    this.lhy.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lgT = new CardHListViewData();
                    this.lgT.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lhu == null) {
                        this.lhu = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.lhu.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lhv == null) {
                        this.lhv = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.lhv.add(bsVar2);
                        }
                    }
                }
                this.lhC = dataRes.multi_forum_text;
                if (this.lhz >= 0) {
                    this.lhz = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lhF == null) {
                    this.lhF = new ArrayList();
                }
                this.lhF.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.lhF.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.lhH != null && this.lhH.dpA()) {
                    this.lhH = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lhH == null) {
                        this.lhH = new com.baidu.tieba.pb.videopb.c.a();
                        this.lhH.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lhH == null && dataRes.promotion != null) {
                    this.lhH = new com.baidu.tieba.pb.videopb.c.a();
                    this.lhH.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lha = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lhb = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lhc = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lhd == null) {
                            this.lhd = new a();
                        }
                        this.lhd.a(bVar);
                    }
                }
                this.lhO.reset();
                this.lhO.setUserMap(this.userMap);
                this.lhO.a(dataRes.recom_ala_info);
                if (this.lhO.lqo != null) {
                    this.lhO.lqo.setTid(getThreadId());
                }
                this.lhP = new ac();
                this.lhP.setUserMap(this.userMap);
                this.lhP.a(dataRes.recom_ala_info);
                if (this.lhP.lqo != null) {
                    this.lhP.lqo.setTid(getThreadId());
                }
                this.lhQ = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lhR = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.lhE.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xh(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dfI().bjL());
                    if (postData.blR() != null && postData.blR().baijiahaoData == null && dfI() != null && dfI().getBaijiahaoData() != null) {
                        postData.blR().baijiahaoData = dfI().getBaijiahaoData();
                    }
                    this.lhE.add(postData.getId());
                    if (postData.dHx() == 1 && this.gbZ.bkO()) {
                        if (dfQ()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gbZ.bkN());
                        }
                    } else if (postData.dHx() == 1 && this.gbZ.bli()) {
                        postData.setPostType(41);
                    } else if (postData.dHx() == 1 && this.gbZ != null && this.gbZ.biG()) {
                        postData.setPostType(0);
                        postData.bDt();
                        if (this.gbZ.bjY() == null || this.gbZ.bjY().size() == 0) {
                            JSONArray jSONArray = new JSONArray();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", 0);
                                jSONObject.put("text", "");
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            postData.c(TbRichTextView.a(context, jSONArray, false));
                        } else {
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gbZ.bjY(), true));
                        }
                        this.lhx = postData;
                    }
                    if (postData.dHx() == 1 && this.gbZ != null && this.gbZ.isShareThread) {
                        postData.h(this.gbZ.eAy);
                    }
                    if (postData.dHx() == 1) {
                        this.lhK = postData;
                        this.lhJ = false;
                    }
                    this.lhg.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lhA = new o(this.gbZ, this.anti);
        this.lgU = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lhi = dataRes.follow_tip.tip_text;
        }
        this.lhq = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lhq.parserProtoBuf(dataRes.ala_info);
        }
        this.lhB = dataRes.fold_tip;
        this.lgV = dataRes.exp_news_today.intValue();
        this.lgW = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lhD.add(aVar);
                i = i2 + 1;
            }
        }
        this.lgX = dataRes.pb_sort_info;
        this.lgY = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lgZ = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lhp == null) {
                this.lhp = new ArrayList();
            }
            this.lhp.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.lhp.add(bwVar);
                }
            }
            if (this.lhp != null && this.lhp.size() > 15) {
                this.lhp = y.subList(this.lhp, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> Az;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.mQK = true;
        nVar.d(app);
        AppData dHl = nVar.dHl();
        if (dHl.goods != null) {
            if (y.isEmpty(dHl.goods.thread_pic_list) && (Az = AdvertAppInfo.a.Az(dHl.goods.lego_card)) != null && dHl.goods.thread_pic_list != null) {
                dHl.goods.thread_pic_list.addAll(Az);
            }
            this.lhs = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lhN.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dHl = nVar.dHl();
                if (!this.lhN.contains(nVar) && dHl.goods != null && (!StringUtils.isNull(dHl.goods.user_name) || !StringUtils.isNull(dHl.goods.lego_card))) {
                    nVar.lwz = dgi();
                    this.lhN.add(nVar);
                }
            }
        }
    }

    public String dfT() {
        return this.lhB;
    }

    public CardHListViewData dfU() {
        return this.lgT;
    }

    public PostData dfV() {
        return this.lhx;
    }

    public PostData f(PostData postData) {
        this.lhx = postData;
        return postData;
    }

    public r dfW() {
        return this.lhw;
    }

    public int dfX() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lhj;
    }

    public void setIsNewUrl(int i) {
        this.lhj = i;
    }

    public List<MuteUser> dfY() {
        return this.lhm;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> dfZ() {
        return this.lhr;
    }

    public com.baidu.tieba.tbadkCore.data.n dga() {
        return this.lhs;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.lhs = nVar;
    }

    public void dgb() {
        if (this.lhs.dHl() != null) {
            this.lhs.dHl().legoCard = null;
        }
        this.lhs = null;
    }

    public void dgc() {
        this.lhO = null;
        this.lhP = null;
    }

    public String dgd() {
        return this.lgS;
    }

    public void Pb(String str) {
        this.lgS = str;
    }

    public i dge() {
        return this.lhy;
    }

    public List<bs> dgf() {
        return this.lhv;
    }

    public long dgg() {
        return this.lhz;
    }

    public o dgh() {
        return this.lhA;
    }

    public void a(o oVar) {
        this.lhA = oVar;
    }

    public boolean dgi() {
        return (dfI() == null || !dfI().biG() || dfI().bks() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dgj() {
        return this.lhq;
    }

    public List<com.baidu.tbadk.core.data.n> dgk() {
        return this.lhF;
    }

    public boolean dgl() {
        return dfI() != null && dfI().biK();
    }

    public String dgm() {
        if (this.lgX != null && this.lgX.size() > this.lgY) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lgX.size()) {
                    break;
                } else if (this.lgX.get(i2).sort_type.intValue() != this.lgY) {
                    i = i2 + 1;
                } else {
                    return this.lgX.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dgn() {
        return this.lhH;
    }

    public int dgo() {
        return this.lhG;
    }

    public void Fp(int i) {
        this.lhG = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> dgp() {
        return this.lhN;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gbZ == null || this.gbZ.getBaijiahaoData() == null || this.gbZ.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gbZ.getBaijiahaoData().oriUgcNid);
    }
}
