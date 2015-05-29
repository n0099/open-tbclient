package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.game.GameInfoData;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AnchorInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.StarEnter;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.mvc.b.c {
    private AntiData Ql;
    protected com.baidu.tbadk.core.data.q bGk;
    protected ForumData bJD;
    private UserData bJJ;
    protected List<Long> cpg;
    private v cph;
    protected boolean cpi;
    protected String cpj;
    protected x cpk;
    private b cpl;
    private boolean cpm;
    private ArrayList<LiveCardData> cpp;
    private String cpq;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.ai> threadList;
    private HashMap<String, MetaData> userMap;
    private List<o> cpn = new ArrayList();
    private int cpo = 0;
    private ArrayList<com.baidu.tbadk.core.data.i> cpr = new ArrayList<>();

    public u() {
        initData();
    }

    private void initData() {
        this.bJD = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bGk = new com.baidu.tbadk.core.data.q();
        this.cph = new v();
        this.bJJ = new UserData();
        this.cpk = new x();
        b(new AntiData());
        a(new b());
    }

    public FrsPageResIdl D(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                a(frsPageResIdl.data);
                return frsPageResIdl;
            }
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                            if (iVar.a(colorEgg)) {
                                this.cpr.add(iVar);
                            }
                        }
                    }
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                gX(dataRes.is_new_url.intValue());
                this.cpi = dataRes.fortune_bag.intValue() == 1;
                this.cpj = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cpm = dataRes.forum.has_game.intValue() == 1;
                    this.cpq = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cpn.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        o oVar = new o();
                        oVar.a(list2.get(i2));
                        this.cpn.add(oVar);
                    }
                }
                this.cpk.a(dataRes.gcon_account);
                this.bJD.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i3));
                        wVar.parser_title();
                        wVar.l(this.cpr);
                        this.threadList.add(wVar);
                    }
                }
                this.cpg = dataRes.thread_id_list;
                this.Ql.parserProtobuf(dataRes.anti);
                this.cpl.a(dataRes.group);
                this.bGk.a(dataRes.page);
                this.cph.a(dataRes.frs_star);
                this.bJJ.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cpp = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.cpp.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Bo() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }

    public ForumData aar() {
        return this.bJD;
    }

    public void c(ForumData forumData) {
        this.bJD = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.ai> getThreadList() {
        return this.threadList;
    }

    public void R(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qK() {
        return this.Ql;
    }

    public void b(AntiData antiData) {
        this.Ql = antiData;
    }

    public com.baidu.tbadk.core.data.q Zp() {
        return this.bGk;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.bGk = qVar;
    }

    public v amp() {
        return this.cph;
    }

    public void a(v vVar) {
        this.cph = vVar;
    }

    public boolean amq() {
        return this.cpi;
    }

    public void fc(boolean z) {
        this.cpi = z;
    }

    public String amr() {
        return this.cpj;
    }

    public void jq(String str) {
        this.cpj = str;
    }

    public x ams() {
        return this.cpk;
    }

    public void a(x xVar) {
        this.cpk = xVar;
    }

    public UserData getUserData() {
        return this.bJJ;
    }

    public void k(UserData userData) {
        this.bJJ = userData;
    }

    public List<Long> amt() {
        return this.cpg;
    }

    public void aZ(List<Long> list) {
        this.cpg = list;
    }

    public b amu() {
        return this.cpl;
    }

    public void a(b bVar) {
        this.cpl = bVar;
    }

    public boolean amv() {
        return this.cpm;
    }

    public void fd(boolean z) {
        this.cpm = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<o> amw() {
        return this.cpn;
    }

    public void ba(List<o> list) {
        this.cpn = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aaw() {
        return this.cpo;
    }

    public void gX(int i) {
        this.cpo = i;
    }

    public ArrayList<LiveCardData> amx() {
        return this.cpp;
    }

    public void S(ArrayList<LiveCardData> arrayList) {
        this.cpp = arrayList;
    }

    public String amy() {
        return this.cpq;
    }

    public void jr(String str) {
        this.cpq = str;
    }
}
