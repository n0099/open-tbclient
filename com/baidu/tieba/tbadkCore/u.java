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
    private AntiData PP;
    protected com.baidu.tbadk.core.data.q bDp;
    protected ForumData bHo;
    private UserData bHu;
    protected List<Long> clh;
    private v cli;
    protected boolean clj;
    protected String clk;
    protected x cll;
    private b clm;
    private boolean cln;
    private ArrayList<LiveCardData> clq;
    private String clr;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.ai> threadList;
    private HashMap<String, MetaData> userMap;
    private List<o> clo = new ArrayList();
    private int clp = 0;
    private ArrayList<com.baidu.tbadk.core.data.i> cls = new ArrayList<>();

    public u() {
        initData();
    }

    private void initData() {
        this.bHo = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bDp = new com.baidu.tbadk.core.data.q();
        this.cli = new v();
        this.bHu = new UserData();
        this.cll = new x();
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
                                this.cls.add(iVar);
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
                gG(dataRes.is_new_url.intValue());
                this.clj = dataRes.fortune_bag.intValue() == 1;
                this.clk = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cln = dataRes.forum.has_game.intValue() == 1;
                    this.clr = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.clo.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        o oVar = new o();
                        oVar.a(list2.get(i2));
                        this.clo.add(oVar);
                    }
                }
                this.cll.a(dataRes.gcon_account);
                this.bHo.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i3));
                        wVar.parser_title();
                        wVar.m(this.cls);
                        this.threadList.add(wVar);
                    }
                }
                this.clh = dataRes.thread_id_list;
                this.PP.parserProtobuf(dataRes.anti);
                this.clm.a(dataRes.group);
                this.bDp.a(dataRes.page);
                this.cli.a(dataRes.frs_star);
                this.bHu.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.clq = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.clq.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] AC() {
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

    public ForumData Za() {
        return this.bHo;
    }

    public void c(ForumData forumData) {
        this.bHo = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.ai> getThreadList() {
        return this.threadList;
    }

    public List<Long> akE() {
        return this.clh;
    }

    public void aY(List<Long> list) {
        this.clh = list;
    }

    public void V(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qe() {
        return this.PP;
    }

    public void b(AntiData antiData) {
        this.PP = antiData;
    }

    public com.baidu.tbadk.core.data.q XQ() {
        return this.bDp;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.bDp = qVar;
    }

    public v akF() {
        return this.cli;
    }

    public void a(v vVar) {
        this.cli = vVar;
    }

    public boolean akG() {
        return this.clj;
    }

    public void eI(boolean z) {
        this.clj = z;
    }

    public String akH() {
        return this.clk;
    }

    public void ix(String str) {
        this.clk = str;
    }

    public x akI() {
        return this.cll;
    }

    public void a(x xVar) {
        this.cll = xVar;
    }

    public UserData getUserData() {
        return this.bHu;
    }

    public void k(UserData userData) {
        this.bHu = userData;
    }

    public b akJ() {
        return this.clm;
    }

    public void a(b bVar) {
        this.clm = bVar;
    }

    public boolean akK() {
        return this.cln;
    }

    public void eJ(boolean z) {
        this.cln = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<o> akL() {
        return this.clo;
    }

    public void aZ(List<o> list) {
        this.clo = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int Zf() {
        return this.clp;
    }

    public void gG(int i) {
        this.clp = i;
    }

    public ArrayList<LiveCardData> akM() {
        return this.clq;
    }

    public void W(ArrayList<LiveCardData> arrayList) {
        this.clq = arrayList;
    }

    public String akN() {
        return this.clr;
    }

    public void iy(String str) {
        this.clr = str;
    }
}
