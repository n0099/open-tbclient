package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
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
/* loaded from: classes.dex */
public class f {
    private a eyD;
    private List<bh> eyF;
    private int eyG;
    private int eyH;
    private TwzhiboAnti eyJ;
    private VoteDataInfo eyK;
    public AppealInfo eyL;
    private List<bc> eyM;
    private List<bc> eyN;
    public String eyP;
    private PostData eyQ;
    private h eyR;
    public CardHListViewData eyS;
    private long eyT;
    private l eyU;
    public String eyV;
    private PostData eyW;
    private String eyw;
    private int eyx;
    private boolean eyC = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eyI = new ArrayList<>();
    private ForumData eyq = new ForumData();
    private bc eyr = new bc();
    private bh bes = new bh();
    private ArrayList<PostData> eys = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dKm = new ap();
    private AntiData WZ = new AntiData();
    private com.baidu.tbadk.data.g eyt = new com.baidu.tbadk.data.g();
    private int eyv = 0;
    private boolean eyu = false;
    private final UserData eyy = new UserData();
    private List<MuteUser> eyB = new ArrayList();
    private ar eyz = new ar();
    private as eyE = new as();
    private y eyA = new y();
    private n eyO = new n();

    public boolean aMX() {
        return this.eyC;
    }

    public void iC(boolean z) {
        this.eyC = z;
    }

    public VoteDataInfo aMY() {
        return this.eyK;
    }

    public f() {
        this.eyx = 0;
        this.eyJ = null;
        this.eyx = 0;
        this.eyJ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eys != null && this.eys.size() > 0;
    }

    public p rU() {
        if (this.bes == null) {
            return null;
        }
        return this.bes.rU();
    }

    public String[] bL(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eys.get(0);
            PreLoadImageInfo brC = postData.brC();
            str = brC != null ? brC.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bY(context);
            if (this.bes != null && this.bes.sg() != null && this.bes.sg().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bes != null && this.bes.si() && postData != null && postData.IN() != null) {
                str = postData.IN().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aMZ() {
        return this.eyq;
    }

    public bc aNa() {
        return this.eyr;
    }

    public String getForumId() {
        if (this.eyq == null) {
            return "";
        }
        return this.eyq.getId();
    }

    public bh aNb() {
        return this.bes;
    }

    public List<bh> aNc() {
        return this.eyF;
    }

    public String getThreadId() {
        if (this.bes == null) {
            return "";
        }
        return this.bes.getId();
    }

    public ArrayList<PostData> aNd() {
        return this.eys;
    }

    public ap qx() {
        return this.dKm;
    }

    public y aNe() {
        return this.eyA;
    }

    public as aNf() {
        return this.eyE;
    }

    public TwzhiboAnti aNg() {
        return this.eyJ;
    }

    public void a(ap apVar, int i) {
        this.dKm.bK(apVar.qr());
        this.dKm.bI(apVar.pn());
        this.dKm.bH(apVar.qo());
        this.dKm.bL(apVar.qs());
        this.dKm.bJ(apVar.qq());
        if (i == 0) {
            this.dKm = apVar;
        } else if (i == 1) {
            this.dKm.bM(apVar.qt());
        } else if (i == 2) {
            this.dKm.bN(apVar.qu());
        }
    }

    public AntiData qh() {
        return this.WZ;
    }

    public UserData getUserData() {
        return this.eyy;
    }

    public boolean nG() {
        return this.bes.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.bes != null) {
            if (z) {
                this.bes.setIsMarked(1);
            } else {
                this.bes.setIsMarked(0);
            }
        }
    }

    public String nF() {
        if (this.bes != null) {
            return this.bes.rE();
        }
        return null;
    }

    public void oH(String str) {
        if (this.bes != null) {
            this.bes.cF(str);
        }
    }

    public boolean aNh() {
        return (this.bes == null || this.bes.rG() == null || this.bes.rG().size() <= 0 || this.bes.rG().get(0) == null || !this.bes.rG().get(0).getIsSenior()) ? false : true;
    }

    public PostData aNi() {
        return this.eyW;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bgy().qO(dataRes.asp_shown_info);
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
                oW(dataRes.is_new_url.intValue());
                this.eyq.parserProtobuf(dataRes.forum);
                this.eyr.parserProtobuf(dataRes.display_forum);
                this.bes.setUserMap(this.userMap);
                this.bes.a(dataRes.thread);
                this.bes.bY(2);
                if (rU() != null) {
                    rU().setForumId(com.baidu.adp.lib.g.b.c(this.eyq.getId(), 0L));
                }
                this.eyz.a(dataRes.news_info);
                switch (this.eyz.Xq) {
                    case 1:
                        this.eyA.eHG = this.eyz;
                        break;
                    case 2:
                        this.eyA.eHH = this.eyz;
                        break;
                    case 3:
                        this.eyA.eHI = this.eyz;
                        break;
                    default:
                        this.eyA.eHH = this.eyz;
                        break;
                }
                this.eyE.a(dataRes.recommend_book);
                if (this.bes != null && this.bes.rj() != null) {
                    this.eyK = new VoteDataInfo();
                    this.eyK.parserProtobuf(aNb().rj());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aNb().rl());
                        if (postData.brx() == 1 && this.bes.sa()) {
                            if (aNh()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bes.rZ());
                            }
                        } else if (postData.brx() == 1 && this.bes != null && this.bes.sh()) {
                            postData.setPostType(36);
                        } else if (postData.brx() == 1 && this.bes.sn()) {
                            postData.setPostType(41);
                        } else if (postData.brx() == 1 && this.bes != null && this.bes.si()) {
                            postData.setPostType(0);
                            postData.IN();
                            if (this.bes.rt() == null || this.bes.rt().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.g(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bes.rt(), true));
                            }
                            this.eyQ = postData;
                        } else if (postData.brx() == 1 && this.bes.so()) {
                            postData.setPostType(48);
                        }
                        this.eys.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eyW = new PostData();
                    this.eyW.setUserMap(this.userMap);
                    this.eyW.a(dataRes.first_floor_post, context);
                }
                this.dKm.a(dataRes.page);
                this.WZ.parserProtobuf(dataRes.anti);
                this.eyt.a(dataRes.location);
                this.eyu = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eyv = dataRes.user.is_manager.intValue();
                }
                this.eyy.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eyB.add(muteUser);
                        }
                    }
                }
                this.bes.bS(this.bes.rn() > 0 ? this.bes.rn() - 1 : 0);
                List<AppData> bfR = r.bfT().bfR();
                if (bfR != null) {
                    bfR.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData brl = lVar.brl();
                        if (!this.eyI.contains(lVar) && brl.goods != null && (!StringUtils.isNull(brl.goods.user_name) || !StringUtils.isNull(brl.goods.lego_card))) {
                            this.eyI.add(lVar);
                            if (bfR != null) {
                                bfR.add(lVar.brl());
                            }
                        }
                    }
                }
                r.bfT().bfS();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eyy.getIsSelectTail());
                }
                this.eyJ.parserProtobuf(dataRes.twzhibo_anti);
                this.eyL = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.eyD = new a();
                    this.eyD.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eyR = new h();
                    this.eyR.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eyS = new CardHListViewData();
                    this.eyS.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eyF == null) {
                        this.eyF = new ArrayList();
                    }
                    this.eyF.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.eyF.add(bhVar);
                        }
                    }
                    if (this.eyF != null && this.eyF.size() > 15) {
                        this.eyF = v.a(this.eyF, 0, 15);
                    }
                }
                this.eyG = dataRes.is_follow_current_channel.intValue();
                this.eyH = dataRes.switch_read_open.intValue();
                if (v.t(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eyM == null) {
                        this.eyM = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.eyM.add(bcVar);
                    }
                }
                if (v.t(dataRes.from_forum_list) > 0) {
                    if (this.eyN == null) {
                        this.eyN = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bc bcVar2 = new bc();
                        bcVar2.parserProtobuf(simpleForum2);
                        this.eyN.add(bcVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eyO != null) {
                    this.eyO.a(context, dataRes.top_agree_post_list);
                }
                if (this.eyT >= 0) {
                    this.eyT = dataRes.thread_freq_num.longValue();
                }
                this.eyU = new l();
                this.eyU.a(dataRes);
                this.eyV = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.eyw = dataRes.follow_tip.tip_text;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aNj() {
        return this.eyS;
    }

    public PostData aNk() {
        return this.eyQ;
    }

    public PostData d(PostData postData) {
        this.eyQ = postData;
        return postData;
    }

    public n aNl() {
        return this.eyO;
    }

    public int aNm() {
        return this.eyv;
    }

    public int aNn() {
        return this.eyx;
    }

    public void oW(int i) {
        this.eyx = i;
    }

    public List<MuteUser> aNo() {
        return this.eyB;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aNp() {
        return this.eyI;
    }

    public a aNq() {
        return this.eyD;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aNr() {
        return new ArrayList<>(this.eys);
    }

    public String aNs() {
        return this.eyP;
    }

    public void oI(String str) {
        this.eyP = str;
    }

    public h aNt() {
        return this.eyR;
    }

    public int aNu() {
        return this.eyG;
    }

    public List<bc> aNv() {
        return this.eyN;
    }

    public long aNw() {
        return this.eyT;
    }

    public l aNx() {
        return this.eyU;
    }

    public void a(l lVar) {
        this.eyU = lVar;
    }

    public boolean aNy() {
        return (aNb() == null || !aNb().si() || aNb().rM() == null) ? false : true;
    }

    public String aNz() {
        return this.eyw;
    }
}
