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
    private AntiData cuS;
    private PersonUserGodInfo ilJ;
    private com.baidu.tieba.person.data.d ilK;
    private ArrayList<com.baidu.adp.widget.ListView.m> irY;
    private c irZ;
    protected boolean isHost;
    private com.baidu.tieba.person.a.f isa;
    private m isb;
    private AlaLiveInfoCoreData isc;
    private List<AlaLiveInfoCoreData> isd;
    protected g ise;
    protected List<com.baidu.adp.widget.ListView.m> isf;
    protected ArrayList<com.baidu.adp.widget.ListView.m> isi;
    public n isj;
    public n isk;
    public n isl;
    public n ism;
    public n isn;
    public n iso;
    private UserVideoChannelInfoData isp;
    public UserAgreeInfo isq;
    public NicknameInfo isr;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean irU = true;
    protected int sex = 1;
    private int irV = 1;
    private int irW = 1;
    private int irX = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> isg = new ArrayList<>();
    private ArrayList<n> ish = new ArrayList<>();

    public abstract void cbh();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bEG() {
        return this.irU;
    }

    public void pC(boolean z) {
        this.irU = z;
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
            if (this.cuS == null) {
                this.cuS = new AntiData();
            }
            this.cuS.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.irV = cVar.GetUser().priv_sets.like.intValue();
                    this.irW = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.irU = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.isp == null) {
                this.isp = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.isp.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.ilK = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cbi()) {
                eg(cVar.getConcernedForumList());
            }
            if (this.ise == null) {
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.isf) && v.isEmpty(this.isi)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bZr();
                this.maskType = cVar.getMaskType();
            }
            if (this.ilJ == null) {
                this.ilJ = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.ilJ.parserProtobuf(cVar.getUserGodInfo());
            }
            this.isq = cVar.getUserAgreeInfo();
            this.isc = cVar.getLiveInfo();
            this.isd = cVar.getLiveReplayInfo();
            this.isr = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.ise = new g();
            this.ise.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cbj() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.isf == null) {
                this.isf = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.irX);
            this.irX = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eRg = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eRe = z;
            cardPersonDynamicThreadData.eRd = z2;
            cardPersonDynamicThreadData.eRf = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.isf.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cbj() || this.isHost) {
            if (this.isi == null) {
                this.isi = new ArrayList<>();
            }
            this.irX = UtilHelper.getRandom(random, 3, this.irX);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eRg = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eRe = false;
            cardPersonDynamicThreadData.eRd = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.irX);
            this.isi.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.isf == null) {
                    this.isf = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eRd = z;
                dVar.sex = this.sex;
                dVar.eQW = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eQX = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eQX = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.isf.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cbi() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.isf == null) {
                this.isf = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eRd = z;
            bVar.eQW = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eQX = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.ist = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.isu = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.isf.add(bVar);
            this.isf.add(ce(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> caX() {
        if (this.isa == null) {
            return null;
        }
        return this.isa.getPhotoAlbum();
    }

    private void eg(List<ForumDynamic> list) {
        this.irZ = new c();
        this.irZ.isw = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.isA = forumDynamic.user_thread_count.intValue();
                this.irZ.isw.add(fVar);
            }
        }
    }

    private boolean cbi() {
        if (this.isHost) {
            return false;
        }
        if (this.irV == 3) {
            return true;
        }
        return this.irV == 2 && !this.irU;
    }

    public boolean cbj() {
        if (this.isHost) {
            return false;
        }
        if (this.irW == 3) {
            return true;
        }
        return this.irW == 2 && !this.irU;
    }

    protected com.baidu.tieba.person.d ce(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.igo = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cbk() {
        this.irU = true;
        this.sex = 1;
        this.irV = 1;
        this.irW = 1;
        this.irX = -1;
        this.mUserData = null;
        if (this.irY != null) {
            this.irY.clear();
        }
        this.irY = null;
        this.irZ = null;
        this.isa = null;
        this.isb = null;
        this.ise = null;
        this.mCardNullPolymericData = null;
        if (this.isf != null) {
            this.isf.clear();
        }
        if (this.isi != null) {
            this.isi.clear();
        }
        this.isf = null;
        this.isi = null;
        this.isg.clear();
        this.isq = null;
        this.isr = null;
        this.maskType = 0;
        this.isc = null;
        if (this.isd != null) {
            this.isd.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData biZ() {
        return this.cuS;
    }

    public AlaLiveInfoCoreData cbl() {
        return this.isc;
    }

    public List<AlaLiveInfoCoreData> cbm() {
        return this.isd;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bww() {
        return this.isg;
    }

    public c cbn() {
        return this.irZ;
    }

    public g cbo() {
        return this.ise;
    }

    public PersonUserGodInfo cbp() {
        return this.ilJ;
    }

    private void bZr() {
        this.ish.clear();
        this.isl = U(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.isl.aSR = new Bundle();
        this.isl.aSR.putBoolean("person_center_item_red_tip", true);
        this.isl.isM.aSR = new Bundle();
        this.isl.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(this.isl);
        this.ism = U(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ism.aSR = new Bundle();
        this.ism.aSR.putBoolean("person_center_item_red_tip", true);
        this.ism.isM.aSR = new Bundle();
        this.ism.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(this.ism);
        this.isj = U(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.isj.aSR = new Bundle();
        this.isj.aSR.putBoolean("person_center_item_red_tip", true);
        this.isj.isM.aSR = new Bundle();
        this.isj.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(this.isj);
        n U = U(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        U.isM.aSR = new Bundle();
        U.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(U);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n U2 = U(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            U2.aSR = new Bundle();
            U2.isM.aSR = new Bundle();
            U2.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ish.add(U2);
        }
        if (this.isp != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.isp.getManChannel() == 1) {
                this.isk = U(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.isk.aSR = new Bundle();
                this.isk.aSR.putBoolean("person_center_item_red_tip", true);
                this.isk.isM.aSR = new Bundle();
                this.isk.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ish.add(this.isk);
            }
        }
        this.isn = U(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.isn.aSR = new Bundle();
        this.isn.aSR.putBoolean("person_center_item_red_tip", true);
        this.isn.isM.aSR = new Bundle();
        this.isn.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(this.isn);
        n U3 = U(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        U3.isM.aSR = new Bundle();
        U3.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.ilK != null) {
            U3.isM.aSR.putString("book_jump_link", this.ilK.ikB);
        }
        this.ish.add(U3);
        n U4 = U(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        U4.isM.aSR = new Bundle();
        U4.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(U4);
        n U5 = U(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        U5.isM.aSR = new Bundle();
        U5.isM.aSR.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ish.add(U5);
        n U6 = U(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        U6.isM.aSR = new Bundle();
        U6.isM.aSR.putString("key_service_centre", "");
        this.ish.add(U6);
    }

    private n U(int i, int i2, int i3) {
        n nVar = new n();
        nVar.ilT = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.isM = new com.baidu.tieba.personCenter.c.a();
        nVar.isM.fhu = i3;
        return nVar;
    }
}
