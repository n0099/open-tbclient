package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
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
/* loaded from: classes.dex */
public abstract class a {
    protected boolean bvm;
    private ArrayList<com.baidu.adp.widget.ListView.f> fkc;
    private c fkd;
    private com.baidu.tieba.person.a.e fke;
    private m fkf;
    private AlaLiveInfoCoreData fkg;
    protected g fkh;
    protected j fki;
    protected List<com.baidu.adp.widget.ListView.f> fkj;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fkm;
    private com.baidu.tieba.person.data.b fkn;
    public com.baidu.tieba.personCenter.b.a fko;
    public com.baidu.tieba.personCenter.b.a fkp;
    public com.baidu.tieba.personCenter.b.a fkq;
    public com.baidu.tieba.personCenter.b.a fkr;
    public com.baidu.tieba.personCenter.b.a fks;
    public com.baidu.tieba.personCenter.b.a fkt;
    private UserVideoChannelInfoData fku;
    private PersonUserGodInfo fkv;
    public UserAgreeInfo fkw;
    public NicknameInfo fkx;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fjV = true;
    protected int sex = 1;
    private int fjW = 1;
    private int fjX = 1;
    private int fjY = 1;
    private int fjZ = 1;
    private int fka = -1;
    private int fkb = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fkk = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> fkl = new ArrayList<>();

    public abstract void Xc();

    public a(boolean z) {
        this.bvm = z;
    }

    public boolean aAL() {
        return this.fjV;
    }

    public void kw(boolean z) {
        this.fjV = z;
    }

    public boolean Pi() {
        return this.bvm;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.fjW = fVar.GetUser().priv_sets.like.intValue();
                    this.fjX = fVar.GetUser().priv_sets.post.intValue();
                    this.fjY = fVar.GetUser().priv_sets.group.intValue();
                    this.fjZ = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.fjV = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.fku == null) {
                this.fku = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.fku.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.fkn = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!v.v(fVar.getConcernedForumList()) && !this.bvm && !aYn()) {
                cJ(fVar.getConcernedForumList());
            }
            if (this.fki == null && aYo() && !this.bvm) {
                this.fki = new j();
                this.fki.sex = this.sex;
                this.fki.fkP = aYo();
            }
            if (this.fkh == null && !this.bvm) {
                a(fVar.GetUser());
            }
            Random random = new Random();
            if (this.bvm && !v.v(fVar.GetPostList())) {
                for (PostInfoList postInfoList : fVar.GetPostList()) {
                    if (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) {
                        a(postInfoList, random);
                    }
                }
            }
            if (!v.v(fVar.getDynamicInfoList())) {
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.fka != date.getDate();
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z);
                                break;
                            case 2:
                                a(dynamicInfo, z);
                                break;
                            case 3:
                                b(dynamicInfo, z);
                                break;
                        }
                        this.fka = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.v(this.fkj) && v.v(this.fkm)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.bvm = this.bvm;
                this.hasMore = false;
            }
            if (this.bvm) {
                aYu();
            }
            if (this.fkv == null) {
                this.fkv = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fkv.parserProtobuf(fVar.getUserGodInfo());
            }
            this.fkw = fVar.getUserAgreeInfo();
            this.fkg = fVar.getLiveInfo();
            this.fkx = fVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.v(user.gift_list) && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.fkh = new g();
            this.fkh.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aYo() || this.bvm) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fkj == null) {
                this.fkj = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fkb);
            this.fkb = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bNT = true;
            cardPersonDynamicThreadData.bvm = this.bvm;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bNS = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fkj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aYo() || this.bvm) {
            if (this.fkm == null) {
                this.fkm = new ArrayList<>();
            }
            this.fkb = UtilHelper.getRandom(random, 3, this.fkb);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bNT = true;
            cardPersonDynamicThreadData.bvm = this.bvm;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bNS = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fkb);
            this.fkm.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.v(list)) {
                if (this.fkj == null) {
                    this.fkj = new ArrayList();
                }
                d dVar = new d();
                dVar.bvm = this.bvm;
                dVar.bNS = z;
                dVar.sex = this.sex;
                dVar.bNL = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fkz = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fkz = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fkj.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aYn() || this.bvm) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fkj == null) {
                this.fkj = new ArrayList();
            }
            b bVar = new b();
            bVar.bvm = this.bvm;
            bVar.sex = this.sex;
            bVar.bNS = z;
            bVar.bNL = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fkz = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.ddR = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fkA = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fkj.add(bVar);
            this.fkj.add(bo(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYf() {
        if (this.fke == null) {
            return null;
        }
        return this.fke.getPhotoAlbum();
    }

    private void cJ(List<ForumDynamic> list) {
        this.fkd = new c();
        this.fkd.fkC = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fkG = forumDynamic.user_thread_count.intValue();
                this.fkd.fkC.add(fVar);
            }
        }
    }

    private boolean aYn() {
        if (this.bvm) {
            return false;
        }
        if (this.fjW == 3) {
            return true;
        }
        return this.fjW == 2 && !this.fjV;
    }

    public boolean aYo() {
        if (this.bvm) {
            return false;
        }
        if (this.fjX == 3) {
            return true;
        }
        return this.fjX == 2 && !this.fjV;
    }

    protected com.baidu.tieba.person.h bo(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.faQ = i;
        hVar.aHa = i2;
        return hVar;
    }

    public void aYp() {
        this.fjV = true;
        this.sex = 1;
        this.fjW = 1;
        this.fjX = 1;
        this.fjY = 1;
        this.fjZ = 1;
        this.fka = -1;
        this.fkb = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fkc != null) {
            this.fkc.clear();
        }
        this.fkc = null;
        this.fkd = null;
        this.fke = null;
        this.fkf = null;
        this.fkh = null;
        this.fki = null;
        this.mCardNullPolymericData = null;
        if (this.fkj != null) {
            this.fkj.clear();
        }
        if (this.fkm != null) {
            this.fkm.clear();
        }
        this.fkj = null;
        this.fkm = null;
        this.fkk.clear();
        this.fkw = null;
        this.fkx = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aYq() {
        return this.fkg;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> asx() {
        return this.fkk;
    }

    public c aYr() {
        return this.fkd;
    }

    public g aYs() {
        return this.fkh;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aYt() {
        return this.fkl;
    }

    private void aYu() {
        this.fkl.clear();
        this.fkq = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fkq.cec = new Bundle();
        this.fkq.cec.putBoolean("person_center_item_red_tip", true);
        this.fkq.ffc.cec = new Bundle();
        this.fkq.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(this.fkq);
        this.fkr = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fkr.cec = new Bundle();
        this.fkr.cec.putBoolean("person_center_item_red_tip", true);
        this.fkr.ffc.cec = new Bundle();
        this.fkr.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(this.fkr);
        this.fko = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fko.cec = new Bundle();
        this.fko.cec.putBoolean("person_center_item_red_tip", true);
        this.fko.ffc.cec = new Bundle();
        this.fko.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(this.fko);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.ffc.cec = new Bundle();
        N.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.ala_live, 29);
            N2.cec = new Bundle();
            N2.ffc.cec = new Bundle();
            N2.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fkl.add(N2);
        }
        if (this.fku != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fku.getManChannel() == 1) {
                this.fkp = N(d.g.icon_weibar_caise_heibai, d.l.frs_channel_tip, 30);
                this.fkp.cec = new Bundle();
                this.fkp.cec.putBoolean("person_center_item_red_tip", true);
                this.fkp.ffc.cec = new Bundle();
                this.fkp.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fkl.add(this.fkp);
            }
        }
        this.fks = N(d.g.icon_vip_heibai, d.l.member_center_item, 16);
        this.fks.cec = new Bundle();
        this.fks.cec.putBoolean("person_center_item_red_tip", true);
        this.fks.ffc.cec = new Bundle();
        this.fks.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(this.fks);
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N3.ffc.cec = new Bundle();
        N3.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fkn != null) {
            N3.ffc.cec.putString("book_jump_link", this.fkn.feD);
        }
        this.fkl.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N4.ffc.cec = new Bundle();
        N4.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N5.ffc.cec = new Bundle();
        N5.ffc.cec.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fkl.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_fuwu_caise_heibai, d.l.person_service_centre, 41);
        N6.ffc.cec = new Bundle();
        N6.ffc.cec.putString("key_service_centre", "");
        this.fkl.add(N6);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.ffc = new com.baidu.tieba.personCenter.c.a();
        aVar.ffc.ceb = i3;
        return aVar;
    }
}
