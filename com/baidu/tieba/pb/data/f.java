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
    public String eyB;
    private PostData eyC;
    private h eyD;
    public CardHListViewData eyE;
    private long eyF;
    private l eyG;
    public String eyH;
    private PostData eyI;
    private String eyh;
    private int eyi;
    private a eyp;
    private List<bh> eyr;
    private int eys;
    private int eyt;
    private TwzhiboAnti eyv;
    private VoteDataInfo eyw;
    public AppealInfo eyx;
    private List<bc> eyy;
    private List<bc> eyz;
    private boolean eyo = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eyu = new ArrayList<>();
    private ForumData eyb = new ForumData();
    private bc eyc = new bc();
    private bh bee = new bh();
    private ArrayList<PostData> eyd = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dJY = new ap();
    private AntiData WN = new AntiData();
    private com.baidu.tbadk.data.g eye = new com.baidu.tbadk.data.g();
    private int eyg = 0;
    private boolean eyf = false;
    private final UserData eyj = new UserData();
    private List<MuteUser> eyn = new ArrayList();
    private ar eyk = new ar();
    private as eyq = new as();
    private y eyl = new y();
    private n eyA = new n();

    public boolean aMS() {
        return this.eyo;
    }

    public void iB(boolean z) {
        this.eyo = z;
    }

    public VoteDataInfo aMT() {
        return this.eyw;
    }

    public f() {
        this.eyi = 0;
        this.eyv = null;
        this.eyi = 0;
        this.eyv = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eyd != null && this.eyd.size() > 0;
    }

    public p rN() {
        if (this.bee == null) {
            return null;
        }
        return this.bee.rN();
    }

    public String[] bK(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eyd.get(0);
            PreLoadImageInfo brv = postData.brv();
            str = brv != null ? brv.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bX(context);
            if (this.bee != null && this.bee.rZ() != null && this.bee.rZ().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bee != null && this.bee.sb() && postData != null && postData.IH() != null) {
                str = postData.IH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aMU() {
        return this.eyb;
    }

    public bc aMV() {
        return this.eyc;
    }

    public String getForumId() {
        if (this.eyb == null) {
            return "";
        }
        return this.eyb.getId();
    }

    public bh aMW() {
        return this.bee;
    }

    public List<bh> aMX() {
        return this.eyr;
    }

    public String getThreadId() {
        if (this.bee == null) {
            return "";
        }
        return this.bee.getId();
    }

    public ArrayList<PostData> aMY() {
        return this.eyd;
    }

    public ap qq() {
        return this.dJY;
    }

    public y aMZ() {
        return this.eyl;
    }

    public as aNa() {
        return this.eyq;
    }

    public TwzhiboAnti aNb() {
        return this.eyv;
    }

    public void a(ap apVar, int i) {
        this.dJY.bJ(apVar.qk());
        this.dJY.bH(apVar.pg());
        this.dJY.bG(apVar.qh());
        this.dJY.bK(apVar.ql());
        this.dJY.bI(apVar.qj());
        if (i == 0) {
            this.dJY = apVar;
        } else if (i == 1) {
            this.dJY.bL(apVar.qm());
        } else if (i == 2) {
            this.dJY.bM(apVar.qn());
        }
    }

    public AntiData qa() {
        return this.WN;
    }

    public UserData getUserData() {
        return this.eyj;
    }

    public boolean nz() {
        return this.bee.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bee != null) {
            if (z) {
                this.bee.setIsMarked(1);
            } else {
                this.bee.setIsMarked(0);
            }
        }
    }

    public String ny() {
        if (this.bee != null) {
            return this.bee.rx();
        }
        return null;
    }

    public void oG(String str) {
        if (this.bee != null) {
            this.bee.cE(str);
        }
    }

    public boolean aNc() {
        return (this.bee == null || this.bee.rz() == null || this.bee.rz().size() <= 0 || this.bee.rz().get(0) == null || !this.bee.rz().get(0).getIsSenior()) ? false : true;
    }

    public PostData aNd() {
        return this.eyI;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bgt().qN(dataRes.asp_shown_info);
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
                oV(dataRes.is_new_url.intValue());
                this.eyb.parserProtobuf(dataRes.forum);
                this.eyc.parserProtobuf(dataRes.display_forum);
                this.bee.setUserMap(this.userMap);
                this.bee.a(dataRes.thread);
                this.bee.bX(2);
                if (rN() != null) {
                    rN().setForumId(com.baidu.adp.lib.g.b.c(this.eyb.getId(), 0L));
                }
                this.eyk.a(dataRes.news_info);
                switch (this.eyk.Xe) {
                    case 1:
                        this.eyl.eHs = this.eyk;
                        break;
                    case 2:
                        this.eyl.eHt = this.eyk;
                        break;
                    case 3:
                        this.eyl.eHu = this.eyk;
                        break;
                    default:
                        this.eyl.eHt = this.eyk;
                        break;
                }
                this.eyq.a(dataRes.recommend_book);
                if (this.bee != null && this.bee.rc() != null) {
                    this.eyw = new VoteDataInfo();
                    this.eyw.parserProtobuf(aMW().rc());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aMW().re());
                        if (postData.brq() == 1 && this.bee.rT()) {
                            if (aNc()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bee.rS());
                            }
                        } else if (postData.brq() == 1 && this.bee != null && this.bee.sa()) {
                            postData.setPostType(36);
                        } else if (postData.brq() == 1 && this.bee.sg()) {
                            postData.setPostType(41);
                        } else if (postData.brq() == 1 && this.bee != null && this.bee.sb()) {
                            postData.setPostType(0);
                            postData.IH();
                            if (this.bee.rm() == null || this.bee.rm().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bee.rm(), true));
                            }
                            this.eyC = postData;
                        } else if (postData.brq() == 1 && this.bee.sh()) {
                            postData.setPostType(48);
                        }
                        this.eyd.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eyI = new PostData();
                    this.eyI.setUserMap(this.userMap);
                    this.eyI.a(dataRes.first_floor_post, context);
                }
                this.dJY.a(dataRes.page);
                this.WN.parserProtobuf(dataRes.anti);
                this.eye.a(dataRes.location);
                this.eyf = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eyg = dataRes.user.is_manager.intValue();
                }
                this.eyj.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eyn.add(muteUser);
                        }
                    }
                }
                this.bee.bR(this.bee.rg() > 0 ? this.bee.rg() - 1 : 0);
                List<AppData> bfM = r.bfO().bfM();
                if (bfM != null) {
                    bfM.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bre = lVar.bre();
                        if (!this.eyu.contains(lVar) && bre.goods != null && (!StringUtils.isNull(bre.goods.user_name) || !StringUtils.isNull(bre.goods.lego_card))) {
                            this.eyu.add(lVar);
                            if (bfM != null) {
                                bfM.add(lVar.bre());
                            }
                        }
                    }
                }
                r.bfO().bfN();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eyj.getIsSelectTail());
                }
                this.eyv.parserProtobuf(dataRes.twzhibo_anti);
                this.eyx = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.eyp = new a();
                    this.eyp.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eyD = new h();
                    this.eyD.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eyE = new CardHListViewData();
                    this.eyE.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eyr == null) {
                        this.eyr = new ArrayList();
                    }
                    this.eyr.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.eyr.add(bhVar);
                        }
                    }
                    if (this.eyr != null && this.eyr.size() > 15) {
                        this.eyr = v.a(this.eyr, 0, 15);
                    }
                }
                this.eys = dataRes.is_follow_current_channel.intValue();
                this.eyt = dataRes.switch_read_open.intValue();
                if (v.t(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eyy == null) {
                        this.eyy = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.eyy.add(bcVar);
                    }
                }
                if (v.t(dataRes.from_forum_list) > 0) {
                    if (this.eyz == null) {
                        this.eyz = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bc bcVar2 = new bc();
                        bcVar2.parserProtobuf(simpleForum2);
                        this.eyz.add(bcVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eyA != null) {
                    this.eyA.a(context, dataRes.top_agree_post_list);
                }
                if (this.eyF >= 0) {
                    this.eyF = dataRes.thread_freq_num.longValue();
                }
                this.eyG = new l();
                this.eyG.a(dataRes);
                this.eyH = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.eyh = dataRes.follow_tip.tip_text;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aNe() {
        return this.eyE;
    }

    public PostData aNf() {
        return this.eyC;
    }

    public PostData d(PostData postData) {
        this.eyC = postData;
        return postData;
    }

    public n aNg() {
        return this.eyA;
    }

    public int aNh() {
        return this.eyg;
    }

    public int aNi() {
        return this.eyi;
    }

    public void oV(int i) {
        this.eyi = i;
    }

    public List<MuteUser> aNj() {
        return this.eyn;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aNk() {
        return this.eyu;
    }

    public a aNl() {
        return this.eyp;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aNm() {
        return new ArrayList<>(this.eyd);
    }

    public String aNn() {
        return this.eyB;
    }

    public void oH(String str) {
        this.eyB = str;
    }

    public h aNo() {
        return this.eyD;
    }

    public int aNp() {
        return this.eys;
    }

    public List<bc> aNq() {
        return this.eyz;
    }

    public long aNr() {
        return this.eyF;
    }

    public l aNs() {
        return this.eyG;
    }

    public void a(l lVar) {
        this.eyG = lVar;
    }

    public boolean aNt() {
        return (aMW() == null || !aMW().sb() || aMW().rF() == null) ? false : true;
    }

    public String aNu() {
        return this.eyh;
    }
}
