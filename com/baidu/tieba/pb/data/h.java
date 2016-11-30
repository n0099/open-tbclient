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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.dv;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.tbadkCore.data.q;
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
import tbclient.SimpleUser;
import tbclient.User;
/* loaded from: classes.dex */
public class h {
    public String aSC;
    private int dBp;
    private q erV;
    private c esf;
    private TwzhiboAnti esi;
    private VoteDataInfo esj;
    public AppealInfo esk;
    private q esl;
    private l esn;
    private boolean ese = true;
    private ArrayList<p> esh = new ArrayList<>();
    private ForumData erU = new ForumData();
    private bk beS = new bk();
    private ArrayList<q> erW = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ao dzM = new ao();
    private AntiData Sh = new AntiData();
    private com.baidu.tbadk.data.g erX = new com.baidu.tbadk.data.g();
    private int erZ = 0;
    private boolean erY = false;
    private final UserData esa = new UserData();
    private List<MuteUser> esd = new ArrayList();
    private aq esb = new aq();
    private ar esg = new ar();
    private dv esc = new dv();
    private af esm = new af();

    public boolean aOh() {
        return this.ese;
    }

    public void ii(boolean z) {
        this.ese = z;
    }

    public af aOi() {
        return this.esm;
    }

    public VoteDataInfo aOj() {
        return this.esj;
    }

    public h() {
        this.dBp = 0;
        this.esi = null;
        this.dBp = 0;
        this.esi = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.erW != null && this.erW.size() > 0;
    }

    public String[] bi(Context context) {
        String str = "";
        if (isValid()) {
            q qVar = this.erW.get(0);
            ai bmq = qVar.bmq();
            r1 = bmq != null ? bmq.imgUrl : null;
            str = qVar.bu(context);
            if (this.beS != null && this.beS.sz() != null && this.beS.sz().getGroup_id() != 0) {
                str = "[" + context.getString(r.j.msglist_live) + "] " + str;
            }
            if (this.beS != null && this.beS.sB() && qVar != null && qVar.Il() != null) {
                r1 = qVar.Il().qg();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aOk() {
        return this.erU;
    }

    public String getForumId() {
        if (this.erU == null) {
            return "";
        }
        return this.erU.getId();
    }

    public bk aOl() {
        return this.beS;
    }

    public String getThreadId() {
        if (this.beS == null) {
            return "";
        }
        return this.beS.getId();
    }

    public ArrayList<q> aOm() {
        return this.erW;
    }

    public ao getPage() {
        return this.dzM;
    }

    public dv aOn() {
        return this.esc;
    }

    public ar aOo() {
        return this.esg;
    }

    public TwzhiboAnti aOp() {
        return this.esi;
    }

    public void a(ao aoVar, int i) {
        this.dzM.bN(aoVar.qB());
        this.dzM.bL(aoVar.pd());
        this.dzM.bK(aoVar.qy());
        this.dzM.bO(aoVar.qC());
        this.dzM.bM(aoVar.qA());
        if (i == 0) {
            this.dzM = aoVar;
        } else if (i == 1) {
            this.dzM.bP(aoVar.qD());
        } else if (i == 2) {
            this.dzM.bQ(aoVar.qE());
        }
    }

    public AntiData qs() {
        return this.Sh;
    }

    public UserData getUserData() {
        return this.esa;
    }

    public boolean nz() {
        return this.beS.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.beS != null) {
            if (z) {
                this.beS.setIsMarked(1);
            } else {
                this.beS.setIsMarked(0);
            }
        }
    }

    public String ny() {
        if (this.beS != null) {
            return this.beS.rX();
        }
        return null;
    }

    public void pl(String str) {
        if (this.beS != null) {
            this.beS.cz(str);
        }
    }

    public q aOq() {
        return this.erV;
    }

    public boolean aOr() {
        return (this.beS == null || this.beS.rZ() == null || this.beS.rZ().size() <= 0 || this.beS.rZ().get(0) == null || !this.beS.rZ().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.beA().qW(dataRes.asp_shown_info);
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
                mH(dataRes.is_new_url.intValue());
                this.erU.parserProtobuf(dataRes.forum);
                this.beS.setUserMap(this.userMap);
                this.beS.a(dataRes.thread);
                this.esb.a(dataRes.news_info);
                switch (this.esb.Sx) {
                    case 1:
                        this.esc.eyP = this.esb;
                        break;
                    case 2:
                        this.esc.eyQ = this.esb;
                        break;
                    case 3:
                        this.esc.eyR = this.esb;
                        break;
                    default:
                        this.esc.eyQ = this.esb;
                        break;
                }
                this.esg.a(dataRes.recommend_book);
                if (this.beS != null && this.beS.rG() != null) {
                    this.esj = new VoteDataInfo();
                    this.esj.parserProtobuf(aOl().rG());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        q qVar = new q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(post, context);
                        qVar.a(aOl().rH());
                        if (qVar.bml() == 1 && this.beS.st()) {
                            if (aOr()) {
                                qVar.setPostType(0);
                            } else {
                                qVar.setPostType(this.beS.ss());
                            }
                        } else if (qVar.bml() == 1 && this.beS != null && this.beS.sA()) {
                            qVar.setPostType(36);
                        } else if (qVar.bml() == 1 && this.beS.sG()) {
                            qVar.setPostType(41);
                        } else if (qVar.bml() == 1 && this.beS != null && this.beS.sB()) {
                            qVar.setPostType(0);
                            qVar.Il();
                            JSONArray jSONArray = new JSONArray();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", 0);
                                jSONObject.put("text", qVar.getTitle());
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            qVar.f(TbRichTextView.a(context, jSONArray, false));
                            this.esl = qVar;
                        } else if (qVar.bml() == 1 && this.beS.sH()) {
                            qVar.setPostType(48);
                        }
                        this.erW.add(qVar);
                    }
                }
                this.dzM.a(dataRes.page);
                this.Sh.parserProtobuf(dataRes.anti);
                this.erX.a(dataRes.location);
                this.erY = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.erZ = dataRes.user.is_manager.intValue();
                }
                this.esa.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.esd.add(muteUser);
                        }
                    }
                }
                this.beS.bU(this.beS.rJ() > 0 ? this.beS.rJ() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        p pVar = new p();
                        pVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e blZ = pVar.blZ();
                        if (!this.esh.contains(pVar) && blZ.fBN != null && (!StringUtils.isNull(blZ.fBN.user_name) || !StringUtils.isNull(blZ.fBN.lego_card))) {
                            this.esh.add(pVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.esa.getIsSelectTail());
                }
                this.esi.parserProtobuf(dataRes.twzhibo_anti);
                this.esk = dataRes.appeal_info;
                this.esm.setForumId(getForumId());
                this.esm.setThreadId(getThreadId());
                this.esm.bJ(0);
                if (this.erZ > 0) {
                    this.esm.bJ(2);
                }
                if (this.beS != null && this.beS.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.beS.getAuthor().getUserId())) {
                        this.esm.bJ(1);
                    }
                }
                this.esm.a(dataRes.graffiti_rank_list_info);
                if (dataRes.god_card != null) {
                    this.esf = new c();
                    this.esf.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.esn = new l();
                    this.esn.a(dataRes.forum_headline_img_info);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public q aOs() {
        return this.esl;
    }

    public q a(q qVar) {
        this.esl = qVar;
        return qVar;
    }

    public int aOt() {
        return this.erZ;
    }

    public int aOu() {
        return this.dBp;
    }

    public void mH(int i) {
        this.dBp = i;
    }

    public List<MuteUser> aOv() {
        return this.esd;
    }

    public ArrayList<p> aOw() {
        return this.esh;
    }

    public c aOx() {
        return this.esf;
    }

    public ArrayList<v> aOy() {
        return new ArrayList<>(this.erW);
    }

    public String LP() {
        return this.aSC;
    }

    public void hn(String str) {
        this.aSC = str;
    }

    public l aOz() {
        return this.esn;
    }
}
