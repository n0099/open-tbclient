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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ej;
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
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    private int diL;
    private a edg;
    private List<bk> edi;
    private int edj;
    private int edk;
    private TwzhiboAnti edm;
    private VoteDataInfo edn;
    public AppealInfo edo;
    private List<bd> edp;
    private List<bd> edq;
    public String eds;
    private PostData edt;
    private h edv;
    public CardHListViewData edw;
    private long edx;
    private k edy;
    private PostData edz;
    private boolean edf = true;
    private ArrayList<o> edl = new ArrayList<>();
    private ForumData ecV = new ForumData();
    private bd ecW = new bd();
    private bk bcB = new bk();
    private ArrayList<PostData> ecX = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private aq dhn = new aq();
    private AntiData Wf = new AntiData();
    private com.baidu.tbadk.data.f ecY = new com.baidu.tbadk.data.f();
    private int eda = 0;
    private boolean ecZ = false;
    private final UserData edb = new UserData();
    private List<MuteUser> ede = new ArrayList();
    private as edc = new as();
    private at edh = new at();
    private ej edd = new ej();
    private af edu = new af();
    private m edr = new m();

    public boolean aHB() {
        return this.edf;
    }

    public void hJ(boolean z) {
        this.edf = z;
    }

    public af aHC() {
        return this.edu;
    }

    public VoteDataInfo aHD() {
        return this.edn;
    }

    public f() {
        this.diL = 0;
        this.edm = null;
        this.diL = 0;
        this.edm = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.ecX != null && this.ecX.size() > 0;
    }

    public p rX() {
        if (this.bcB == null) {
            return null;
        }
        return this.bcB.rX();
    }

    public String[] bJ(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.ecX.get(0);
            PreLoadImageInfo bgR = postData.bgR();
            str = bgR != null ? bgR.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bT(context);
            if (this.bcB != null && this.bcB.sj() != null && this.bcB.sj().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcB != null && this.bcB.sl() && postData != null && postData.HM() != null) {
                str = postData.HM().qc();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aHE() {
        return this.ecV;
    }

    public bd aHF() {
        return this.ecW;
    }

    public String getForumId() {
        if (this.ecV == null) {
            return "";
        }
        return this.ecV.getId();
    }

    public bk aHG() {
        return this.bcB;
    }

    public List<bk> aHH() {
        return this.edi;
    }

    public String getThreadId() {
        if (this.bcB == null) {
            return "";
        }
        return this.bcB.getId();
    }

    public ArrayList<PostData> aHI() {
        return this.ecX;
    }

    public aq qB() {
        return this.dhn;
    }

    public ej aHJ() {
        return this.edd;
    }

    public at aHK() {
        return this.edh;
    }

    public TwzhiboAnti aHL() {
        return this.edm;
    }

    public void a(aq aqVar, int i) {
        this.dhn.bH(aqVar.qv());
        this.dhn.bF(aqVar.pp());
        this.dhn.bE(aqVar.qs());
        this.dhn.bI(aqVar.qw());
        this.dhn.bG(aqVar.qu());
        if (i == 0) {
            this.dhn = aqVar;
        } else if (i == 1) {
            this.dhn.bJ(aqVar.qx());
        } else if (i == 2) {
            this.dhn.bK(aqVar.qy());
        }
    }

    public AntiData ql() {
        return this.Wf;
    }

    public UserData getUserData() {
        return this.edb;
    }

    public boolean nL() {
        return this.bcB.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.bcB != null) {
            if (z) {
                this.bcB.setIsMarked(1);
            } else {
                this.bcB.setIsMarked(0);
            }
        }
    }

    public String nK() {
        if (this.bcB != null) {
            return this.bcB.rH();
        }
        return null;
    }

    public void ny(String str) {
        if (this.bcB != null) {
            this.bcB.cw(str);
        }
    }

    public boolean aHM() {
        return (this.bcB == null || this.bcB.rJ() == null || this.bcB.rJ().size() <= 0 || this.bcB.rJ().get(0) == null || !this.bcB.rJ().get(0).getIsSenior()) ? false : true;
    }

    public PostData aHN() {
        return this.edz;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.aYU().pr(dataRes.asp_shown_info);
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
                mb(dataRes.is_new_url.intValue());
                this.ecV.parserProtobuf(dataRes.forum);
                this.ecW.parserProtobuf(dataRes.display_forum);
                this.bcB.setUserMap(this.userMap);
                this.bcB.a(dataRes.thread);
                this.bcB.bV(2);
                if (rX() != null) {
                    rX().setForumId(com.baidu.adp.lib.g.b.c(this.ecV.getId(), 0L));
                }
                this.edc.a(dataRes.news_info);
                switch (this.edc.Wx) {
                    case 1:
                        this.edd.elp = this.edc;
                        break;
                    case 2:
                        this.edd.elq = this.edc;
                        break;
                    case 3:
                        this.edd.elr = this.edc;
                        break;
                    default:
                        this.edd.elq = this.edc;
                        break;
                }
                this.edh.a(dataRes.recommend_book);
                if (this.bcB != null && this.bcB.rn() != null) {
                    this.edn = new VoteDataInfo();
                    this.edn.parserProtobuf(aHG().rn());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aHG().ro());
                        if (postData.bgM() == 1 && this.bcB.sd()) {
                            if (aHM()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcB.sc());
                            }
                        } else if (postData.bgM() == 1 && this.bcB != null && this.bcB.sk()) {
                            postData.setPostType(36);
                        } else if (postData.bgM() == 1 && this.bcB.sq()) {
                            postData.setPostType(41);
                        } else if (postData.bgM() == 1 && this.bcB != null && this.bcB.sl()) {
                            postData.setPostType(0);
                            postData.HM();
                            if (this.bcB.rx() == null || this.bcB.rx().size() == 0) {
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
                                postData.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.bcB.rx(), true));
                            }
                            this.edt = postData;
                        } else if (postData.bgM() == 1 && this.bcB.sr()) {
                            postData.setPostType(48);
                        }
                        this.ecX.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.edz = new PostData();
                    this.edz.setUserMap(this.userMap);
                    this.edz.a(dataRes.first_floor_post, context);
                }
                this.dhn.a(dataRes.page);
                this.Wf.parserProtobuf(dataRes.anti);
                this.ecY.a(dataRes.location);
                this.ecZ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eda = dataRes.user.is_manager.intValue();
                }
                this.edb.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ede.add(muteUser);
                        }
                    }
                }
                this.bcB.bP(this.bcB.rr() > 0 ? this.bcB.rr() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        o oVar = new o();
                        oVar.c(app);
                        AppData bgA = oVar.bgA();
                        if (!this.edl.contains(oVar) && bgA.goods != null && (!StringUtils.isNull(bgA.goods.user_name) || !StringUtils.isNull(bgA.goods.lego_card))) {
                            this.edl.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.edb.getIsSelectTail());
                }
                this.edm.parserProtobuf(dataRes.twzhibo_anti);
                this.edo = dataRes.appeal_info;
                if (this.edu != null) {
                    this.edu.setForumId(getForumId());
                    this.edu.setThreadId(getThreadId());
                    this.edu.bD(0);
                    if (this.eda > 0) {
                        this.edu.bD(2);
                    }
                    if (this.bcB != null && this.bcB.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcB.getAuthor().getUserId())) {
                            this.edu.bD(1);
                        }
                    }
                    this.edu.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.edg = new a();
                    this.edg.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.edv = new h();
                    this.edv.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.edw = new CardHListViewData();
                    this.edw.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.edi == null) {
                        this.edi = new ArrayList();
                    }
                    this.edi.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bk bkVar = new bk();
                            bkVar.a(threadInfo);
                            this.edi.add(bkVar);
                        }
                    }
                    if (this.edi != null && this.edi.size() > 15) {
                        this.edi = x.a(this.edi, 0, 15);
                    }
                }
                this.edj = dataRes.is_follow_current_channel.intValue();
                this.edk = dataRes.switch_read_open.intValue();
                if (x.q(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.edp == null) {
                        this.edp = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bd bdVar = new bd();
                        bdVar.parserProtobuf(simpleForum);
                        this.edp.add(bdVar);
                    }
                }
                if (x.q(dataRes.from_forum_list) > 0) {
                    if (this.edq == null) {
                        this.edq = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bd bdVar2 = new bd();
                        bdVar2.parserProtobuf(simpleForum2);
                        this.edq.add(bdVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.edr != null) {
                    this.edr.a(context, dataRes.top_agree_post_list);
                }
                if (this.edx >= 0) {
                    this.edx = dataRes.thread_freq_num.longValue();
                }
                this.edy = new k();
                this.edy.a(dataRes);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aHO() {
        return this.edw;
    }

    public PostData aHP() {
        return this.edt;
    }

    public PostData c(PostData postData) {
        this.edt = postData;
        return postData;
    }

    public m aHQ() {
        return this.edr;
    }

    public int aHR() {
        return this.eda;
    }

    public int aHS() {
        return this.diL;
    }

    public void mb(int i) {
        this.diL = i;
    }

    public List<MuteUser> aHT() {
        return this.ede;
    }

    public ArrayList<o> aHU() {
        return this.edl;
    }

    public a aHV() {
        return this.edg;
    }

    public ArrayList<v> aHW() {
        return new ArrayList<>(this.ecX);
    }

    public String aHX() {
        return this.eds;
    }

    public void nz(String str) {
        this.eds = str;
    }

    public h aHY() {
        return this.edv;
    }

    public int aHZ() {
        return this.edj;
    }

    public boolean aIa() {
        return this.edk == 1;
    }

    public List<bd> aIb() {
        return this.edq;
    }

    public long aIc() {
        return this.edx;
    }

    public k aId() {
        return this.edy;
    }

    public void a(k kVar) {
        this.edy = kVar;
    }
}
