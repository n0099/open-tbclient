package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d {
    private a foA;
    private List<bd> foC;
    private int foD;
    private AlaLiveInfoCoreData foE;
    private TwzhiboAnti foG;
    public AppealInfo foH;
    private List<az> foI;
    private List<az> foJ;
    public String foL;
    private PostData foM;
    private f foN;
    public CardHListViewData foO;
    private long foP;
    private j foQ;
    public String foR;
    public int foS;
    public int foT;
    private String foU;
    private String foV;
    private PostData foX;
    private String fot;
    private int fou;
    private boolean foz = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> foF = new ArrayList<>();
    private ForumData fon = new ForumData();
    private az foo = new az();
    private bd brC = new bd();
    private ArrayList<PostData> fop = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am ezX = new am();
    private AntiData agD = new AntiData();
    private com.baidu.tbadk.data.f foq = new com.baidu.tbadk.data.f();

    /* renamed from: for  reason: not valid java name */
    private int f0for = 0;
    private final UserData fov = new UserData();
    private List<MuteUser> foy = new ArrayList();
    private ao fow = new ao();
    private ap foB = new ap();
    private ac fox = new ac();
    private l foK = new l();
    private List<av.a> foW = new ArrayList();

    public boolean bal() {
        return this.foz;
    }

    public void jv(boolean z) {
        this.foz = z;
    }

    public d() {
        this.fou = 0;
        this.foG = null;
        this.fou = 0;
        this.foG = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fop != null && this.fop.size() > 0;
    }

    public String[] bX(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fop.size() > 30 ? 30 : this.fop.size();
            if (bao() == null || bao().vm() == null || com.baidu.tbadk.core.util.ao.isEmpty(bao().vm().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bao().vm().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) w.c(this.fop, i);
                if (postData != null && postData.vm() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.vm().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.vm().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bxg();
                    }
                    String bxe = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bxe() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bxe)) {
                        str2 = bxe;
                        break;
                    }
                    str2 = bxe;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fop.get(0);
            if (this.brC != null && this.brC.vV() != null && this.brC.vV().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.k.photo_live_tips) + "] " + str2;
            }
            if (this.brC != null && this.brC.vX() && postData2 != null && postData2.Nq() != null) {
                str = postData2.Nq().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bam() {
        return this.fon;
    }

    public az ban() {
        return this.foo;
    }

    public String getForumId() {
        if (this.fon == null) {
            return "";
        }
        return this.fon.getId();
    }

    public bd bao() {
        return this.brC;
    }

    public List<bd> bap() {
        return this.foC;
    }

    public String getThreadId() {
        if (this.brC == null) {
            return "";
        }
        return this.brC.getId();
    }

    public ArrayList<PostData> baq() {
        return this.fop;
    }

    public am uB() {
        return this.ezX;
    }

    public ac bar() {
        return this.fox;
    }

    public ap bas() {
        return this.foB;
    }

    public void a(am amVar, int i) {
        this.ezX.bI(amVar.uv());
        this.ezX.bG(amVar.tL());
        this.ezX.bF(amVar.us());
        this.ezX.bJ(amVar.uw());
        this.ezX.bH(amVar.uu());
        if (i == 0) {
            this.ezX = amVar;
        } else if (i == 1) {
            this.ezX.bK(amVar.ux());
        } else if (i == 2) {
            this.ezX.bL(amVar.uy());
        }
    }

    public AntiData uo() {
        return this.agD;
    }

    public UserData getUserData() {
        return this.fov;
    }

    public boolean sc() {
        return this.brC.vu() != 0;
    }

    public void ah(boolean z) {
        if (this.brC != null) {
            if (z) {
                this.brC.bU(1);
            } else {
                this.brC.bU(0);
            }
        }
    }

    public String sb() {
        if (this.brC != null) {
            return this.brC.vv();
        }
        return null;
    }

    public void rg(String str) {
        if (this.brC != null) {
            this.brC.dp(str);
        }
    }

    public String bat() {
        return this.foV;
    }

    public boolean bau() {
        return (this.brC == null || this.brC.vx() == null || this.brC.vx().size() <= 0 || this.brC.vx().get(0) == null || !this.brC.vx().get(0).tM()) ? false : true;
    }

    public PostData bav() {
        return this.foX;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.boX().sX(dataRes.asp_shown_info);
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
                qf(dataRes.is_new_url.intValue());
                this.fon.parserProtobuf(dataRes.forum);
                this.foo.parserProtobuf(dataRes.display_forum);
                this.brC.setUserMap(this.userMap);
                this.brC.a(dataRes.thread);
                this.brC.bX(2);
                this.fow.a(dataRes.news_info);
                switch (this.fow.agU) {
                    case 1:
                        this.fox.fyH = this.fow;
                        break;
                    case 2:
                        this.fox.fyI = this.fow;
                        break;
                    case 3:
                        this.fox.fyJ = this.fow;
                        break;
                    default:
                        this.fox.fyI = this.fow;
                        break;
                }
                this.foB.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(bao().va());
                        if (postData.bwZ() == 1 && this.brC.vP()) {
                            if (bau()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.brC.vO());
                            }
                        } else if (postData.bwZ() == 1 && this.brC.wb()) {
                            postData.setPostType(41);
                        } else if (postData.bwZ() == 1 && this.brC != null && this.brC.vX()) {
                            postData.setPostType(0);
                            postData.Nq();
                            if (this.brC.vk() == null || this.brC.vk().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.brC.vk(), true));
                            }
                            this.foM = postData;
                        }
                        if (postData.bwZ() == 1 && this.brC != null && this.brC.isShareThread) {
                            postData.f(this.brC.ajP);
                        }
                        this.fop.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.foX = new PostData();
                    this.foX.setUserMap(this.userMap);
                    this.foX.a(dataRes.first_floor_post, context);
                    if (this.brC != null && this.brC.isShareThread) {
                        this.foX.f(this.brC.ajP);
                    }
                }
                this.ezX.a(dataRes.page);
                this.agD.parserProtobuf(dataRes.anti);
                this.foq.a(dataRes.location);
                if (dataRes.user != null) {
                    this.f0for = dataRes.user.is_manager.intValue();
                }
                this.fov.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.foy.add(muteUser);
                        }
                    }
                }
                this.brC.bQ(this.brC.ve() > 0 ? this.brC.ve() - 1 : 0);
                List<AppData> boh = r.boj().boh();
                if (boh != null) {
                    boh.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bwP = lVar.bwP();
                        if (!this.foF.contains(lVar) && bwP.goods != null && (!StringUtils.isNull(bwP.goods.user_name) || !StringUtils.isNull(bwP.goods.lego_card))) {
                            this.foF.add(lVar);
                            if (boh != null) {
                                boh.add(lVar.bwP());
                            }
                        }
                    }
                }
                r.boj().boi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fov.getIsSelectTail());
                }
                this.foG.parserProtobuf(dataRes.twzhibo_anti);
                this.foH = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.foA = new a();
                    this.foA.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.foN = new f();
                    this.foN.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.foO = new CardHListViewData();
                    this.foO.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.foC == null) {
                        this.foC = new ArrayList();
                    }
                    this.foC.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.foC.add(bdVar);
                        }
                    }
                    if (this.foC != null && this.foC.size() > 15) {
                        this.foC = w.a(this.foC, 0, 15);
                    }
                }
                this.foD = dataRes.is_follow_current_channel.intValue();
                if (w.y(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.foI == null) {
                        this.foI = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.foI.add(azVar);
                    }
                }
                if (w.y(dataRes.from_forum_list) > 0) {
                    if (this.foJ == null) {
                        this.foJ = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.foJ.add(azVar2);
                        }
                    }
                }
                this.foV = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.foK != null) {
                    this.foK.a(context, dataRes.top_agree_post_list);
                }
                if (this.foP >= 0) {
                    this.foP = dataRes.thread_freq_num.longValue();
                }
                this.foQ = new j();
                this.foQ.a(dataRes);
                this.foR = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fot = dataRes.follow_tip.tip_text;
                }
                this.foE = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.foE.parserProtoBuf(dataRes.ala_info);
                }
                this.foU = dataRes.fold_tip;
                this.foS = dataRes.exp_news_today.intValue();
                this.foT = dataRes.exp_guide_today.intValue();
                if (!w.z(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        av.a aVar = new av.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.foW.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String baw() {
        return this.foU;
    }

    public CardHListViewData bax() {
        return this.foO;
    }

    public PostData bay() {
        return this.foM;
    }

    public PostData c(PostData postData) {
        this.foM = postData;
        return postData;
    }

    public l baz() {
        return this.foK;
    }

    public int baA() {
        return this.f0for;
    }

    public int baB() {
        return this.fou;
    }

    public void qf(int i) {
        this.fou = i;
    }

    public List<MuteUser> baC() {
        return this.foy;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> baD() {
        return this.foF;
    }

    public a baE() {
        return this.foA;
    }

    public String baF() {
        return this.foL;
    }

    public void rh(String str) {
        this.foL = str;
    }

    public f baG() {
        return this.foN;
    }

    public int baH() {
        return this.foD;
    }

    public List<az> baI() {
        return this.foJ;
    }

    public long baJ() {
        return this.foP;
    }

    public j baK() {
        return this.foQ;
    }

    public void a(j jVar) {
        this.foQ = jVar;
    }

    public boolean baL() {
        return (bao() == null || !bao().vX() || bao().vD() == null) ? false : true;
    }

    public String baM() {
        return this.fot;
    }

    public AlaLiveInfoCoreData baN() {
        return this.foE;
    }

    public List<av.a> baO() {
        return this.foW;
    }
}
