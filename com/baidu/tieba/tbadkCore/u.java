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
    private AntiData PN;
    protected com.baidu.tbadk.core.data.q bDc;
    protected ForumData bHb;
    private UserData bHh;
    protected ArrayList<com.baidu.adp.widget.ListView.ai> ckR;
    private v ckS;
    protected boolean ckT;
    protected String ckU;
    protected x ckV;
    private b ckW;
    private boolean ckX;
    private ArrayList<LiveCardData> cla;
    private String clb;
    private String gameName;
    private HashMap<String, MetaData> userMap;
    private List<o> ckY = new ArrayList();
    private int ckZ = 0;
    private ArrayList<com.baidu.tbadk.core.data.i> clc = new ArrayList<>();

    public u() {
        initData();
    }

    private void initData() {
        this.bHb = new ForumData();
        this.ckR = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bDc = new com.baidu.tbadk.core.data.q();
        this.ckS = new v();
        this.bHh = new UserData();
        this.ckV = new x();
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
                                this.clc.add(iVar);
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
                gE(dataRes.is_new_url.intValue());
                this.ckT = dataRes.fortune_bag.intValue() == 1;
                this.ckU = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ckX = dataRes.forum.has_game.intValue() == 1;
                    this.clb = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.ckY.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        o oVar = new o();
                        oVar.a(list2.get(i2));
                        this.ckY.add(oVar);
                    }
                }
                this.ckV.a(dataRes.gcon_account);
                this.bHb.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i3));
                        wVar.parser_title();
                        wVar.m(this.clc);
                        this.ckR.add(wVar);
                    }
                }
                this.PN.parserProtobuf(dataRes.anti);
                this.ckW.a(dataRes.group);
                this.bDc.a(dataRes.page);
                this.ckS.a(dataRes.frs_star);
                this.bHh.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cla = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.cla.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Aw() {
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

    public ForumData YO() {
        return this.bHb;
    }

    public void c(ForumData forumData) {
        this.bHb = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.ai> akp() {
        return this.ckR;
    }

    public void T(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        this.ckR = arrayList;
    }

    public AntiData qe() {
        return this.PN;
    }

    public void b(AntiData antiData) {
        this.PN = antiData;
    }

    public com.baidu.tbadk.core.data.q XE() {
        return this.bDc;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.bDc = qVar;
    }

    public v akq() {
        return this.ckS;
    }

    public void a(v vVar) {
        this.ckS = vVar;
    }

    public boolean akr() {
        return this.ckT;
    }

    public void eK(boolean z) {
        this.ckT = z;
    }

    public String aks() {
        return this.ckU;
    }

    public void iu(String str) {
        this.ckU = str;
    }

    public x akt() {
        return this.ckV;
    }

    public void a(x xVar) {
        this.ckV = xVar;
    }

    public UserData getUserData() {
        return this.bHh;
    }

    public void k(UserData userData) {
        this.bHh = userData;
    }

    public b aku() {
        return this.ckW;
    }

    public void a(b bVar) {
        this.ckW = bVar;
    }

    public boolean akv() {
        return this.ckX;
    }

    public void eL(boolean z) {
        this.ckX = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<o> akw() {
        return this.ckY;
    }

    public void aV(List<o> list) {
        this.ckY = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int YT() {
        return this.ckZ;
    }

    public void gE(int i) {
        this.ckZ = i;
    }

    public ArrayList<LiveCardData> akx() {
        return this.cla;
    }

    public void U(ArrayList<LiveCardData> arrayList) {
        this.cla = arrayList;
    }

    public String aky() {
        return this.clb;
    }

    public void iv(String str) {
        this.clb = str;
    }
}
