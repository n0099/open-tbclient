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
    protected com.baidu.tbadk.core.data.q bGl;
    protected ForumData bJE;
    private UserData bJK;
    protected List<Long> cph;
    private v cpi;
    protected boolean cpj;
    protected String cpk;
    protected x cpl;
    private b cpm;
    private boolean cpn;
    private ArrayList<LiveCardData> cpq;
    private String cpr;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.ai> threadList;
    private HashMap<String, MetaData> userMap;
    private List<o> cpo = new ArrayList();
    private int cpp = 0;
    private ArrayList<com.baidu.tbadk.core.data.i> cps = new ArrayList<>();

    public u() {
        initData();
    }

    private void initData() {
        this.bJE = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bGl = new com.baidu.tbadk.core.data.q();
        this.cpi = new v();
        this.bJK = new UserData();
        this.cpl = new x();
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
                                this.cps.add(iVar);
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
                this.cpj = dataRes.fortune_bag.intValue() == 1;
                this.cpk = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cpn = dataRes.forum.has_game.intValue() == 1;
                    this.cpr = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cpo.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        o oVar = new o();
                        oVar.a(list2.get(i2));
                        this.cpo.add(oVar);
                    }
                }
                this.cpl.a(dataRes.gcon_account);
                this.bJE.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i3));
                        wVar.parser_title();
                        wVar.l(this.cps);
                        this.threadList.add(wVar);
                    }
                }
                this.cph = dataRes.thread_id_list;
                this.Ql.parserProtobuf(dataRes.anti);
                this.cpm.a(dataRes.group);
                this.bGl.a(dataRes.page);
                this.cpi.a(dataRes.frs_star);
                this.bJK.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cpq = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.cpq.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Bp() {
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

    public ForumData aas() {
        return this.bJE;
    }

    public void c(ForumData forumData) {
        this.bJE = forumData;
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

    public com.baidu.tbadk.core.data.q Zq() {
        return this.bGl;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.bGl = qVar;
    }

    public v amq() {
        return this.cpi;
    }

    public void a(v vVar) {
        this.cpi = vVar;
    }

    public boolean amr() {
        return this.cpj;
    }

    public void fc(boolean z) {
        this.cpj = z;
    }

    public String ams() {
        return this.cpk;
    }

    public void jq(String str) {
        this.cpk = str;
    }

    public x amt() {
        return this.cpl;
    }

    public void a(x xVar) {
        this.cpl = xVar;
    }

    public UserData getUserData() {
        return this.bJK;
    }

    public void k(UserData userData) {
        this.bJK = userData;
    }

    public List<Long> amu() {
        return this.cph;
    }

    public void aZ(List<Long> list) {
        this.cph = list;
    }

    public b amv() {
        return this.cpm;
    }

    public void a(b bVar) {
        this.cpm = bVar;
    }

    public boolean amw() {
        return this.cpn;
    }

    public void fd(boolean z) {
        this.cpn = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<o> amx() {
        return this.cpo;
    }

    public void ba(List<o> list) {
        this.cpo = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aax() {
        return this.cpp;
    }

    public void gX(int i) {
        this.cpp = i;
    }

    public ArrayList<LiveCardData> amy() {
        return this.cpq;
    }

    public void S(ArrayList<LiveCardData> arrayList) {
        this.cpq = arrayList;
    }

    public String amz() {
        return this.cpr;
    }

    public void jr(String str) {
        this.cpr = str;
    }
}
