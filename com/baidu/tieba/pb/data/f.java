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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes21.dex */
public class f {
    private List<bx> lnC;
    private AlaLiveInfoCoreData lnD;
    private TwzhiboAnti lnG;
    private List<bt> lnH;
    private List<bt> lnI;
    private PostData lnK;
    private i lnL;
    private long lnM;
    private o lnN;
    private String lnO;
    private String lnP;
    private List<com.baidu.tbadk.core.data.o> lnS;
    private com.baidu.tieba.pb.videopb.c.a lnU;
    private PostData lnV;
    private PostData lnX;
    public boolean lnZ;
    public AppealInfo lnd;
    public String lne;
    public CardHListViewData lnf;
    public String lnh;
    public int lni;
    public int lnj;
    public List<PbSortType> lnk;
    public int lnl;
    public k lnm;
    public a lnq;
    private String lnv;
    private int lnw;
    private ac lod;
    public String loe;
    public String lof;
    public boolean lnn = false;
    public boolean lno = false;
    public boolean lnp = false;
    public boolean lnr = false;
    private boolean lnA = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> lnE = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n lnF = null;
    private int lnT = 0;
    public boolean lnW = true;
    public int lnY = 0;
    public int YM = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> loa = new ArrayList();
    private ForumData forum = new ForumData();
    private bt lns = new bt();
    private bx ghv = new bx();
    private ArrayList<PostData> lnt = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private aw page = new aw();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f lnu = new com.baidu.tbadk.data.f();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lnz = new ArrayList();
    private az lnx = new az();
    private ba lnB = new ba();
    private am lny = new am();
    private r lnJ = new r();
    private z lob = new z();
    private List<bn.a> lnQ = new ArrayList();
    private HashSet<String> lnR = new HashSet<>();

    public f() {
        this.lnw = 0;
        this.lnG = null;
        this.lnw = 0;
        this.lnG = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lnt != null && this.lnt.size() > 0;
    }

    public String[] fI(Context context) {
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
            int size = this.lnt.size() > 30 ? 30 : this.lnt.size();
            if (dhH() == null || dhH().blC() == null || au.isEmpty(dhH().blC().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dhH().blC().getUserId();
            PostData dhR = dhR();
            if (dhR == null || dhR.blC() == null || au.isEmpty(dhR.blC().getUserId())) {
                str2 = "";
            } else {
                if (!au.equals(userId, dhR.blC().getUserId())) {
                    str4 = null;
                } else {
                    str4 = dhR.dJX();
                }
                if (!au.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = dhR.dJV();
                }
            }
            if (au.isEmpty(str2) && au.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) y.getItem(this.lnt, i);
                    if (postData != null && postData.blC() != null && !au.isEmpty(postData.blC().getUserId()) && au.equals(userId, postData.blC().getUserId())) {
                        if (au.isEmpty(str5)) {
                            str5 = postData.dJX();
                        }
                        String dJV = au.isEmpty(str6) ? postData.dJV() : str6;
                        if (!au.isEmpty(str5) && !au.isEmpty(dJV)) {
                            str = dJV;
                            str3 = str5;
                            break;
                        }
                        str6 = dJV;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && au.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.ghv != null && this.ghv.bmE() != null && this.ghv.bmE().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.ghv == null || this.ghv.blU() == null || au.isEmpty(this.ghv.blU().thumbnail_url)) ? str3 : this.ghv.blU().thumbnail_url;
            if (this.ghv != null && !this.ghv.isShareThread && str5 == null && this.ghv.eEF != null && this.ghv.eEF.eAc != null) {
                ArrayList<MediaData> arrayList = this.ghv.eEF.eAc;
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

    public bt dhG() {
        return this.lns;
    }

    public void d(bt btVar) {
        this.lns = btVar;
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

    public bx dhH() {
        return this.ghv;
    }

    public void aH(bx bxVar) {
        this.ghv = bxVar;
    }

    public List<bx> dhI() {
        return this.lnC;
    }

    public String getThreadId() {
        if (this.ghv == null) {
            return "";
        }
        return this.ghv.getId();
    }

    public ArrayList<PostData> dhJ() {
        return this.lnt;
    }

    public aw getPage() {
        return this.page;
    }

    public am dhK() {
        return this.lny;
    }

    public ba dhL() {
        return this.lnB;
    }

    public z dhM() {
        if (this.lob == null || !this.lob.isValid()) {
            return null;
        }
        return this.lob;
    }

    public ac dhN() {
        if (this.lod == null || !this.lod.isValid()) {
            return null;
        }
        return this.lod;
    }

    public void a(aw awVar, int i) {
        this.page.nW(awVar.bkq());
        this.page.nU(awVar.bjr());
        this.page.nT(awVar.bkn());
        this.page.nX(awVar.bkr());
        this.page.nV(awVar.bkp());
        if (i == 0) {
            this.page = awVar;
        } else if (i == 1) {
            this.page.nY(awVar.bks());
        } else if (i == 2) {
            this.page.nZ(awVar.bkt());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bhP() {
        return this.ghv.blJ() != 0;
    }

    public void is(boolean z) {
        if (this.ghv != null) {
            if (z) {
                this.ghv.oj(1);
            } else {
                this.ghv.oj(0);
            }
        }
    }

    public String bhO() {
        if (this.ghv != null) {
            return this.ghv.blK();
        }
        return null;
    }

    public void ON(String str) {
        if (this.ghv != null) {
            this.ghv.Ay(str);
        }
    }

    public String dhO() {
        return this.lnP;
    }

    public boolean dhP() {
        return (this.ghv == null || this.ghv.blM() == null || this.ghv.blM().size() <= 0 || this.ghv.blM().get(0) == null || !this.ghv.blM().get(0).bjs()) ? false : true;
    }

    public PostData dhQ() {
        return this.lnV;
    }

    public void d(PostData postData) {
        this.lnV = postData;
        this.lnX = postData;
        this.lnW = false;
    }

    public PostData dhR() {
        return this.lnX;
    }

    public void e(PostData postData) {
        this.lnX = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dAG().Rb(dataRes.asp_shown_info);
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
                this.lns.parserProtobuf(dataRes.display_forum);
                this.ghv.setUserMap(this.userMap);
                this.ghv.a(dataRes.thread);
                this.lnx.a(dataRes.news_info);
                switch (this.lnx.eeS) {
                    case 1:
                        this.lny.lzM = this.lnx;
                        break;
                    case 2:
                        this.lny.lzN = this.lnx;
                        break;
                    case 3:
                        this.lny.lzO = this.lnx;
                        break;
                    default:
                        this.lny.lzN = this.lnx;
                        break;
                }
                this.lnB.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lnV = new PostData();
                this.lnV.Kf(1);
                this.lnV.setUserMap(this.userMap);
                this.lnV.xu(this.forum.isBrandForum);
                this.lnV.setTime(this.ghv.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lnV.a(dataRes.first_floor_post, context);
                }
                if (this.ghv != null && this.ghv.isShareThread) {
                    this.lnV.h(this.ghv.eEF);
                }
                if (this.lnX == null) {
                    this.lnX = this.lnV;
                    this.lnW = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lnu.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lnz.add(muteUser);
                        }
                    }
                }
                this.ghv.of(this.ghv.blt() > 0 ? this.ghv.blt() - 1 : 0);
                List<AppData> dzM = com.baidu.tieba.recapp.q.dzO().dzM();
                if (dzM != null) {
                    dzM.clear();
                }
                this.lnF = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dJE = nVar.dJE();
                        if (!this.lnE.contains(nVar) && dJE.goods != null && (!StringUtils.isNull(dJE.goods.user_name) || !StringUtils.isNull(dJE.goods.lego_card))) {
                            nVar.lCO = dih();
                            this.lnE.add(nVar);
                            if (dzM != null) {
                                dzM.add(nVar.dJE());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.q.dzO().dzN();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lnG.parserProtobuf(dataRes.twzhibo_anti);
                this.lnd = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lnL = new i();
                    this.lnL.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lnf = new CardHListViewData();
                    this.lnf.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lnH == null) {
                        this.lnH = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bt btVar = new bt();
                        btVar.parserProtobuf(simpleForum);
                        this.lnH.add(btVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lnI == null) {
                        this.lnI = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bt btVar2 = new bt();
                            btVar2.parserProtobuf(simpleForum2);
                            this.lnI.add(btVar2);
                        }
                    }
                }
                this.lnP = dataRes.multi_forum_text;
                if (this.lnM >= 0) {
                    this.lnM = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lnS == null) {
                    this.lnS = new ArrayList();
                }
                this.lnS.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            oVar.setFloorNum(i2);
                            oVar.a(threadInfo);
                            this.lnS.add(oVar);
                            i2++;
                        }
                    }
                }
                if (this.lnU != null && this.lnU.drC()) {
                    this.lnU = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lnU == null) {
                        this.lnU = new com.baidu.tieba.pb.videopb.c.a();
                        this.lnU.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lnU == null && dataRes.promotion != null) {
                    this.lnU = new com.baidu.tieba.pb.videopb.c.a();
                    this.lnU.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lnn = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lno = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lnp = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lnq == null) {
                            this.lnq = new a();
                        }
                        this.lnq.a(bVar);
                    }
                }
                this.lob.reset();
                this.lob.setUserMap(this.userMap);
                this.lob.a(dataRes.recom_ala_info);
                if (this.lob.lwB != null) {
                    this.lob.lwB.setTid(getThreadId());
                }
                this.lod = new ac();
                this.lod.setUserMap(this.userMap);
                this.lod.a(dataRes.recom_ala_info);
                if (this.lod.lwB != null) {
                    this.lod.lwB.setTid(getThreadId());
                }
                this.loe = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lof = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.lnR.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xu(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dhH().bln());
                    if (postData.bnv() != null && postData.bnv().baijiahaoData == null && dhH() != null && dhH().getBaijiahaoData() != null) {
                        postData.bnv().baijiahaoData = dhH().getBaijiahaoData();
                    }
                    this.lnR.add(postData.getId());
                    if (postData.dJQ() == 1 && this.ghv.bmq()) {
                        if (dhP()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ghv.bmp());
                        }
                    } else if (postData.dJQ() == 1 && this.ghv.bmM()) {
                        postData.setPostType(41);
                    } else if (postData.dJQ() == 1 && this.ghv != null && this.ghv.bki()) {
                        postData.setPostType(0);
                        postData.bFl();
                        if (this.ghv.blA() == null || this.ghv.blA().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ghv.blA(), true));
                        }
                        this.lnK = postData;
                    }
                    if (postData.dJQ() == 1 && this.ghv != null && this.ghv.isShareThread) {
                        postData.h(this.ghv.eEF);
                    }
                    if (postData.dJQ() == 1) {
                        this.lnX = postData;
                        this.lnW = false;
                    }
                    this.lnt.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lnN = new o(this.ghv, this.anti);
        this.lnh = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lnv = dataRes.follow_tip.tip_text;
        }
        this.lnD = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lnD.parserProtoBuf(dataRes.ala_info);
        }
        this.lnO = dataRes.fold_tip;
        this.lni = dataRes.exp_news_today.intValue();
        this.lnj = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bn.a aVar = new bn.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lnQ.add(aVar);
                i = i2 + 1;
            }
        }
        this.lnk = dataRes.pb_sort_info;
        this.lnl = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lnm = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lnC == null) {
                this.lnC = new ArrayList();
            }
            this.lnC.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bx bxVar = new bx();
                    bxVar.a(threadInfo);
                    this.lnC.add(bxVar);
                }
            }
            if (this.lnC != null && this.lnC.size() > 15) {
                this.lnC = y.subList(this.lnC, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> Ai;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.mXG = true;
        nVar.d(app);
        AppData dJE = nVar.dJE();
        if (dJE.goods != null) {
            if (y.isEmpty(dJE.goods.thread_pic_list) && (Ai = AdvertAppInfo.a.Ai(dJE.goods.lego_card)) != null && dJE.goods.thread_pic_list != null) {
                dJE.goods.thread_pic_list.addAll(Ai);
            }
            this.lnF = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.loa.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dJE = nVar.dJE();
                if (!this.loa.contains(nVar) && dJE.goods != null && (!StringUtils.isNull(dJE.goods.user_name) || !StringUtils.isNull(dJE.goods.lego_card))) {
                    nVar.lCO = dih();
                    this.loa.add(nVar);
                }
            }
        }
    }

    public String dhS() {
        return this.lnO;
    }

    public CardHListViewData dhT() {
        return this.lnf;
    }

    public PostData dhU() {
        return this.lnK;
    }

    public PostData f(PostData postData) {
        this.lnK = postData;
        return postData;
    }

    public r dhV() {
        return this.lnJ;
    }

    public int dhW() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lnw;
    }

    public void setIsNewUrl(int i) {
        this.lnw = i;
    }

    public List<MuteUser> dhX() {
        return this.lnz;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> dhY() {
        return this.lnE;
    }

    public com.baidu.tieba.tbadkCore.data.n dhZ() {
        return this.lnF;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.lnF = nVar;
    }

    public void dia() {
        if (this.lnF.dJE() != null) {
            this.lnF.dJE().legoCard = null;
        }
        this.lnF = null;
    }

    public void dib() {
        this.lob = null;
        this.lod = null;
    }

    public String dic() {
        return this.lne;
    }

    public void OO(String str) {
        this.lne = str;
    }

    public i did() {
        return this.lnL;
    }

    public List<bt> die() {
        return this.lnI;
    }

    public long dif() {
        return this.lnM;
    }

    public o dig() {
        return this.lnN;
    }

    public void a(o oVar) {
        this.lnN = oVar;
    }

    public boolean dih() {
        return (dhH() == null || !dhH().bki() || dhH().blU() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dii() {
        return this.lnD;
    }

    public List<com.baidu.tbadk.core.data.o> dij() {
        return this.lnS;
    }

    public boolean dik() {
        return dhH() != null && dhH().bkm();
    }

    public String dil() {
        if (this.lnk != null && this.lnk.size() > this.lnl) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lnk.size()) {
                    break;
                } else if (this.lnk.get(i2).sort_type.intValue() != this.lnl) {
                    i = i2 + 1;
                } else {
                    return this.lnk.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dim() {
        return this.lnU;
    }

    public int din() {
        return this.lnT;
    }

    public void Ga(int i) {
        this.lnT = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> dio() {
        return this.loa;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ghv == null || this.ghv.getBaijiahaoData() == null || this.ghv.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ghv.getBaijiahaoData().oriUgcNid);
    }
}
