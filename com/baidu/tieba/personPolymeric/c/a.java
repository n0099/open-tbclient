package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes6.dex */
public abstract class a {
    private AntiData cua;
    private PersonUserGodInfo ikS;
    private com.baidu.tieba.person.data.d ikT;
    public NicknameInfo irA;
    private ArrayList<com.baidu.adp.widget.ListView.m> irh;
    private c iri;
    private com.baidu.tieba.person.a.f irj;
    private m irk;
    private AlaLiveInfoCoreData irl;
    private List<AlaLiveInfoCoreData> irm;
    protected g irn;
    protected List<com.baidu.adp.widget.ListView.m> iro;
    protected ArrayList<com.baidu.adp.widget.ListView.m> irr;
    public n irs;
    public n irt;
    public n iru;
    public n irv;
    public n irw;
    public n irx;
    private UserVideoChannelInfoData iry;
    public UserAgreeInfo irz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ird = true;
    protected int sex = 1;
    private int ire = 1;
    private int irf = 1;
    private int irg = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> irp = new ArrayList<>();
    private ArrayList<n> irq = new ArrayList<>();

    public abstract void cbf();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bEE() {
        return this.ird;
    }

    public void pC(boolean z) {
        this.ird = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.cua == null) {
                this.cua = new AntiData();
            }
            this.cua.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.ire = cVar.GetUser().priv_sets.like.intValue();
                    this.irf = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ird = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.iry == null) {
                this.iry = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.iry.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.ikT = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cbg()) {
                eg(cVar.getConcernedForumList());
            }
            if (this.irn == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String yearBytime = aq.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = aq.getYearBytime(longValue);
                        String chineseMonthBytime = aq.getChineseMonthBytime(longValue);
                        String dateBytime = aq.getDateBytime(longValue);
                        if (aq.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (aq.equals(dateBytime, str3) && aq.equals(chineseMonthBytime, str2) && aq.equals(yearBytime2, yearBytime)) {
                            z2 = false;
                            dateBytime = str3;
                            str = yearBytime;
                        } else {
                            z2 = true;
                            str2 = chineseMonthBytime;
                            str = yearBytime2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z, z2, z3);
                                break;
                            case 2:
                                a(dynamicInfo, z2);
                                break;
                            case 3:
                                b(dynamicInfo, z2);
                                break;
                        }
                        z3 = false;
                        str3 = dateBytime;
                        yearBytime = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.isEmpty(this.iro) && v.isEmpty(this.irr)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bZp();
                this.maskType = cVar.getMaskType();
            }
            if (this.ikS == null) {
                this.ikS = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.ikS.parserProtobuf(cVar.getUserGodInfo());
            }
            this.irz = cVar.getUserAgreeInfo();
            this.irl = cVar.getLiveInfo();
            this.irm = cVar.getLiveReplayInfo();
            this.irA = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.irn = new g();
            this.irn.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cbh() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.iro == null) {
                this.iro = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.irg);
            this.irg = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eQp = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eQn = z;
            cardPersonDynamicThreadData.eQm = z2;
            cardPersonDynamicThreadData.eQo = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.iro.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cbh() || this.isHost) {
            if (this.irr == null) {
                this.irr = new ArrayList<>();
            }
            this.irg = UtilHelper.getRandom(random, 3, this.irg);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eQp = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eQn = false;
            cardPersonDynamicThreadData.eQm = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.irg);
            this.irr.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.iro == null) {
                    this.iro = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eQm = z;
                dVar.sex = this.sex;
                dVar.eQf = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eQg = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eQg = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.iro.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cbg() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.iro == null) {
                this.iro = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eQm = z;
            bVar.eQf = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eQg = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.irC = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.irD = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.iro.add(bVar);
            this.iro.add(cc(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> caV() {
        if (this.irj == null) {
            return null;
        }
        return this.irj.getPhotoAlbum();
    }

    private void eg(List<ForumDynamic> list) {
        this.iri = new c();
        this.iri.irF = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.irJ = forumDynamic.user_thread_count.intValue();
                this.iri.irF.add(fVar);
            }
        }
    }

    private boolean cbg() {
        if (this.isHost) {
            return false;
        }
        if (this.ire == 3) {
            return true;
        }
        return this.ire == 2 && !this.ird;
    }

    public boolean cbh() {
        if (this.isHost) {
            return false;
        }
        if (this.irf == 3) {
            return true;
        }
        return this.irf == 2 && !this.ird;
    }

    protected com.baidu.tieba.person.d cc(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.ifx = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cbi() {
        this.ird = true;
        this.sex = 1;
        this.ire = 1;
        this.irf = 1;
        this.irg = -1;
        this.mUserData = null;
        if (this.irh != null) {
            this.irh.clear();
        }
        this.irh = null;
        this.iri = null;
        this.irj = null;
        this.irk = null;
        this.irn = null;
        this.mCardNullPolymericData = null;
        if (this.iro != null) {
            this.iro.clear();
        }
        if (this.irr != null) {
            this.irr.clear();
        }
        this.iro = null;
        this.irr = null;
        this.irp.clear();
        this.irz = null;
        this.irA = null;
        this.maskType = 0;
        this.irl = null;
        if (this.irm != null) {
            this.irm.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData biX() {
        return this.cua;
    }

    public AlaLiveInfoCoreData cbj() {
        return this.irl;
    }

    public List<AlaLiveInfoCoreData> cbk() {
        return this.irm;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bwu() {
        return this.irp;
    }

    public c cbl() {
        return this.iri;
    }

    public g cbm() {
        return this.irn;
    }

    public PersonUserGodInfo cbn() {
        return this.ikS;
    }

    private void bZp() {
        this.irq.clear();
        this.iru = U(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.iru.aSz = new Bundle();
        this.iru.aSz.putBoolean("person_center_item_red_tip", true);
        this.iru.irV.aSz = new Bundle();
        this.iru.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(this.iru);
        this.irv = U(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.irv.aSz = new Bundle();
        this.irv.aSz.putBoolean("person_center_item_red_tip", true);
        this.irv.irV.aSz = new Bundle();
        this.irv.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(this.irv);
        this.irs = U(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.irs.aSz = new Bundle();
        this.irs.aSz.putBoolean("person_center_item_red_tip", true);
        this.irs.irV.aSz = new Bundle();
        this.irs.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(this.irs);
        n U = U(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        U.irV.aSz = new Bundle();
        U.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(U);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n U2 = U(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            U2.aSz = new Bundle();
            U2.irV.aSz = new Bundle();
            U2.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.irq.add(U2);
        }
        if (this.iry != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.iry.getManChannel() == 1) {
                this.irt = U(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.irt.aSz = new Bundle();
                this.irt.aSz.putBoolean("person_center_item_red_tip", true);
                this.irt.irV.aSz = new Bundle();
                this.irt.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.irq.add(this.irt);
            }
        }
        this.irw = U(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.irw.aSz = new Bundle();
        this.irw.aSz.putBoolean("person_center_item_red_tip", true);
        this.irw.irV.aSz = new Bundle();
        this.irw.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(this.irw);
        n U3 = U(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        U3.irV.aSz = new Bundle();
        U3.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.ikT != null) {
            U3.irV.aSz.putString("book_jump_link", this.ikT.ijK);
        }
        this.irq.add(U3);
        n U4 = U(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        U4.irV.aSz = new Bundle();
        U4.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(U4);
        n U5 = U(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        U5.irV.aSz = new Bundle();
        U5.irV.aSz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irq.add(U5);
        n U6 = U(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        U6.irV.aSz = new Bundle();
        U6.irV.aSz.putString("key_service_centre", "");
        this.irq.add(U6);
    }

    private n U(int i, int i2, int i3) {
        n nVar = new n();
        nVar.ilc = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.irV = new com.baidu.tieba.personCenter.c.a();
        nVar.irV.fgD = i3;
        return nVar;
    }
}
