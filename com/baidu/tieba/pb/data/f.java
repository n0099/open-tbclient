package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
import com.baidu.tieba.w;
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
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    private int dmp;
    private PostData efS;
    private a egc;
    private List<bi> ege;
    private int egf;
    private int egg;
    private TwzhiboAnti egi;
    private VoteDataInfo egj;
    public AppealInfo egk;
    public String egl;
    private PostData egm;
    private h ego;
    public CardHListViewData egp;
    private boolean egb = true;
    private ArrayList<o> egh = new ArrayList<>();
    private ForumData efR = new ForumData();
    private bi bbo = new bi();
    private ArrayList<PostData> efT = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dkR = new ap();
    private AntiData WM = new AntiData();
    private com.baidu.tbadk.data.g efU = new com.baidu.tbadk.data.g();
    private int efW = 0;
    private boolean efV = false;
    private final UserData efX = new UserData();
    private List<MuteUser> ega = new ArrayList();
    private ar efY = new ar();
    private as egd = new as();
    private du efZ = new du();
    private af egn = new af();

    public boolean aJt() {
        return this.egb;
    }

    public void hZ(boolean z) {
        this.egb = z;
    }

    public af aJu() {
        return this.egn;
    }

    public VoteDataInfo aJv() {
        return this.egj;
    }

    public f() {
        this.dmp = 0;
        this.egi = null;
        this.dmp = 0;
        this.egi = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.efT != null && this.efT.size() > 0;
    }

    public p sN() {
        if (this.bbo == null) {
            return null;
        }
        return this.bbo.sN();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.efT.get(0);
            PreLoadImageInfo bit = postData.bit();
            str = bit != null ? bit.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bN(context);
            if (this.bbo != null && this.bbo.sZ() != null && this.bbo.sZ().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.photo_live_tips) + "] " + str2;
            }
            if (this.bbo != null && this.bbo.tb() && postData != null && postData.Iy() != null) {
                str = postData.Iy().qP();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aJw() {
        return this.efR;
    }

    public String getForumId() {
        if (this.efR == null) {
            return "";
        }
        return this.efR.getId();
    }

    public bi aJx() {
        return this.bbo;
    }

    public List<bi> aJy() {
        return this.ege;
    }

    public String getThreadId() {
        if (this.bbo == null) {
            return "";
        }
        return this.bbo.getId();
    }

    public ArrayList<PostData> aJz() {
        return this.efT;
    }

    public ap rr() {
        return this.dkR;
    }

    public du aJA() {
        return this.efZ;
    }

    public as aJB() {
        return this.egd;
    }

    public TwzhiboAnti aJC() {
        return this.egi;
    }

    public void a(ap apVar, int i) {
        this.dkR.bK(apVar.rl());
        this.dkR.bI(apVar.pI());
        this.dkR.bH(apVar.ri());
        this.dkR.bL(apVar.rm());
        this.dkR.bJ(apVar.rk());
        if (i == 0) {
            this.dkR = apVar;
        } else if (i == 1) {
            this.dkR.bM(apVar.rn());
        } else if (i == 2) {
            this.dkR.bN(apVar.ro());
        }
    }

    public AntiData rb() {
        return this.WM;
    }

    public UserData getUserData() {
        return this.efX;
    }

    public boolean oe() {
        return this.bbo.getIsMarked() != 0;
    }

    public void ae(boolean z) {
        if (this.bbo != null) {
            if (z) {
                this.bbo.setIsMarked(1);
            } else {
                this.bbo.setIsMarked(0);
            }
        }
    }

    public String od() {
        if (this.bbo != null) {
            return this.bbo.sx();
        }
        return null;
    }

    public void nr(String str) {
        if (this.bbo != null) {
            this.bbo.cy(str);
        }
    }

    public PostData aJD() {
        return this.efS;
    }

    public boolean aJE() {
        return (this.bbo == null || this.bbo.sz() == null || this.bbo.sz().size() <= 0 || this.bbo.sz().get(0) == null || !this.bbo.sz().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bau().ps(dataRes.asp_shown_info);
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
                mi(dataRes.is_new_url.intValue());
                this.efR.parserProtobuf(dataRes.forum);
                this.bbo.setUserMap(this.userMap);
                this.bbo.a(dataRes.thread);
                this.bbo.bX(2);
                if (sN() != null) {
                    sN().setForumId(com.baidu.adp.lib.g.b.c(this.efR.getId(), 0L));
                }
                this.efY.a(dataRes.news_info);
                switch (this.efY.Xe) {
                    case 1:
                        this.efZ.emY = this.efY;
                        break;
                    case 2:
                        this.efZ.emZ = this.efY;
                        break;
                    case 3:
                        this.efZ.ena = this.efY;
                        break;
                    default:
                        this.efZ.emZ = this.efY;
                        break;
                }
                this.egd.a(dataRes.recommend_book);
                if (this.bbo != null && this.bbo.sd() != null) {
                    this.egj = new VoteDataInfo();
                    this.egj.parserProtobuf(aJx().sd());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aJx().se());
                        if (postData.bio() == 1 && this.bbo.sT()) {
                            if (aJE()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bbo.sS());
                            }
                        } else if (postData.bio() == 1 && this.bbo != null && this.bbo.ta()) {
                            postData.setPostType(36);
                        } else if (postData.bio() == 1 && this.bbo.tg()) {
                            postData.setPostType(41);
                        } else if (postData.bio() == 1 && this.bbo != null && this.bbo.tb()) {
                            postData.setPostType(0);
                            postData.Iy();
                            if (this.bbo.sn() == null || this.bbo.sn().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", postData.getTitle());
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.bbo.sn(), true));
                            }
                            this.egm = postData;
                        } else if (postData.bio() == 1 && this.bbo.th()) {
                            postData.setPostType(48);
                        }
                        this.efT.add(postData);
                    }
                }
                this.dkR.a(dataRes.page);
                this.WM.parserProtobuf(dataRes.anti);
                this.efU.a(dataRes.location);
                this.efV = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.efW = dataRes.user.is_manager.intValue();
                }
                this.efX.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ega.add(muteUser);
                        }
                    }
                }
                this.bbo.bS(this.bbo.sh() > 0 ? this.bbo.sh() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        o oVar = new o();
                        oVar.c(app);
                        AppData bic = oVar.bic();
                        if (!this.egh.contains(oVar) && bic.goods != null && (!StringUtils.isNull(bic.goods.user_name) || !StringUtils.isNull(bic.goods.lego_card))) {
                            this.egh.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.efX.getIsSelectTail());
                }
                this.egi.parserProtobuf(dataRes.twzhibo_anti);
                this.egk = dataRes.appeal_info;
                if (this.egn != null) {
                    this.egn.setForumId(getForumId());
                    this.egn.setThreadId(getThreadId());
                    this.egn.bG(0);
                    if (this.efW > 0) {
                        this.egn.bG(2);
                    }
                    if (this.bbo != null && this.bbo.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bbo.getAuthor().getUserId())) {
                            this.egn.bG(1);
                        }
                    }
                    this.egn.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.egc = new a();
                    this.egc.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ego = new h();
                    this.ego.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.egp = new CardHListViewData();
                    this.egp.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.ege == null) {
                        this.ege = new ArrayList();
                    }
                    this.ege.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bi biVar = new bi();
                            biVar.a(threadInfo);
                            this.ege.add(biVar);
                        }
                    }
                    if (this.ege != null && this.ege.size() > 15) {
                        this.ege = x.a(this.ege, 0, 15);
                    }
                }
                this.egf = dataRes.is_follow_current_channel.intValue();
                this.egg = dataRes.switch_read_open.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aJF() {
        return this.egp;
    }

    public PostData aJG() {
        return this.egm;
    }

    public PostData a(PostData postData) {
        this.egm = postData;
        return postData;
    }

    public int aJH() {
        return this.efW;
    }

    public int aJI() {
        return this.dmp;
    }

    public void mi(int i) {
        this.dmp = i;
    }

    public List<MuteUser> aJJ() {
        return this.ega;
    }

    public ArrayList<o> aJK() {
        return this.egh;
    }

    public a aJL() {
        return this.egc;
    }

    public ArrayList<v> aJM() {
        return new ArrayList<>(this.efT);
    }

    public String aJN() {
        return this.egl;
    }

    public void ns(String str) {
        this.egl = str;
    }

    public h aJO() {
        return this.ego;
    }

    public int aJP() {
        return this.egf;
    }

    public boolean aJQ() {
        return this.egg == 1;
    }
}
