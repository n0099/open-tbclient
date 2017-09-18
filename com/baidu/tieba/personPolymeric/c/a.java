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
    protected boolean bwa;
    private ArrayList<com.baidu.adp.widget.ListView.f> fkV;
    private c fkW;
    private com.baidu.tieba.person.a.e fkX;
    private m fkY;
    private AlaLiveInfoCoreData fkZ;
    protected g fla;
    protected j flb;
    protected List<com.baidu.adp.widget.ListView.f> flc;
    protected ArrayList<com.baidu.adp.widget.ListView.f> flf;
    private com.baidu.tieba.person.data.b flg;
    public com.baidu.tieba.personCenter.b.a flh;
    public com.baidu.tieba.personCenter.b.a fli;
    public com.baidu.tieba.personCenter.b.a flj;
    public com.baidu.tieba.personCenter.b.a flk;
    public com.baidu.tieba.personCenter.b.a fll;
    public com.baidu.tieba.personCenter.b.a flm;
    private UserVideoChannelInfoData fln;
    private PersonUserGodInfo flo;
    public UserAgreeInfo flp;
    public NicknameInfo flq;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fkO = true;
    protected int sex = 1;
    private int fkP = 1;
    private int fkQ = 1;
    private int fkR = 1;
    private int fkS = 1;
    private int fkT = -1;
    private int fkU = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fld = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> fle = new ArrayList<>();

    public abstract void Xn();

    public a(boolean z) {
        this.bwa = z;
    }

    public boolean aAW() {
        return this.fkO;
    }

    public void kx(boolean z) {
        this.fkO = z;
    }

    public boolean Pk() {
        return this.bwa;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.fkP = fVar.GetUser().priv_sets.like.intValue();
                    this.fkQ = fVar.GetUser().priv_sets.post.intValue();
                    this.fkR = fVar.GetUser().priv_sets.group.intValue();
                    this.fkS = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.fkO = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.fln == null) {
                this.fln = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.fln.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.flg = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!v.v(fVar.getConcernedForumList()) && !this.bwa && !aYy()) {
                cK(fVar.getConcernedForumList());
            }
            if (this.flb == null && aYz() && !this.bwa) {
                this.flb = new j();
                this.flb.sex = this.sex;
                this.flb.flI = aYz();
            }
            if (this.fla == null && !this.bwa) {
                a(fVar.GetUser());
            }
            Random random = new Random();
            if (this.bwa && !v.v(fVar.GetPostList())) {
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
                        boolean z = this.fkT != date.getDate();
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
                        this.fkT = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.v(this.flc) && v.v(this.flf)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.bwa = this.bwa;
                this.hasMore = false;
            }
            if (this.bwa) {
                aYF();
            }
            if (this.flo == null) {
                this.flo = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.flo.parserProtobuf(fVar.getUserGodInfo());
            }
            this.flp = fVar.getUserAgreeInfo();
            this.fkZ = fVar.getLiveInfo();
            this.flq = fVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.v(user.gift_list) && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.fla = new g();
            this.fla.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aYz() || this.bwa) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.flc == null) {
                this.flc = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fkU);
            this.fkU = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOK = true;
            cardPersonDynamicThreadData.bwa = this.bwa;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOJ = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.flc.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aYz() || this.bwa) {
            if (this.flf == null) {
                this.flf = new ArrayList<>();
            }
            this.fkU = UtilHelper.getRandom(random, 3, this.fkU);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOK = true;
            cardPersonDynamicThreadData.bwa = this.bwa;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOJ = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fkU);
            this.flf.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.v(list)) {
                if (this.flc == null) {
                    this.flc = new ArrayList();
                }
                d dVar = new d();
                dVar.bwa = this.bwa;
                dVar.bOJ = z;
                dVar.sex = this.sex;
                dVar.bOC = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fls = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fls = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.flc.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aYy() || this.bwa) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.flc == null) {
                this.flc = new ArrayList();
            }
            b bVar = new b();
            bVar.bwa = this.bwa;
            bVar.sex = this.sex;
            bVar.bOJ = z;
            bVar.bOC = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fls = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.deN = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.flt = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.flc.add(bVar);
            this.flc.add(bs(com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYq() {
        if (this.fkX == null) {
            return null;
        }
        return this.fkX.getPhotoAlbum();
    }

    private void cK(List<ForumDynamic> list) {
        this.fkW = new c();
        this.fkW.flv = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.flz = forumDynamic.user_thread_count.intValue();
                this.fkW.flv.add(fVar);
            }
        }
    }

    private boolean aYy() {
        if (this.bwa) {
            return false;
        }
        if (this.fkP == 3) {
            return true;
        }
        return this.fkP == 2 && !this.fkO;
    }

    public boolean aYz() {
        if (this.bwa) {
            return false;
        }
        if (this.fkQ == 3) {
            return true;
        }
        return this.fkQ == 2 && !this.fkO;
    }

    protected com.baidu.tieba.person.h bs(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.fbK = i;
        hVar.aGX = i2;
        return hVar;
    }

    public void aYA() {
        this.fkO = true;
        this.sex = 1;
        this.fkP = 1;
        this.fkQ = 1;
        this.fkR = 1;
        this.fkS = 1;
        this.fkT = -1;
        this.fkU = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fkV != null) {
            this.fkV.clear();
        }
        this.fkV = null;
        this.fkW = null;
        this.fkX = null;
        this.fkY = null;
        this.fla = null;
        this.flb = null;
        this.mCardNullPolymericData = null;
        if (this.flc != null) {
            this.flc.clear();
        }
        if (this.flf != null) {
            this.flf.clear();
        }
        this.flc = null;
        this.flf = null;
        this.fld.clear();
        this.flp = null;
        this.flq = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aYB() {
        return this.fkZ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> asI() {
        return this.fld;
    }

    public c aYC() {
        return this.fkW;
    }

    public g aYD() {
        return this.fla;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aYE() {
        return this.fle;
    }

    private void aYF() {
        this.fle.clear();
        this.flj = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.flj.ceU = new Bundle();
        this.flj.ceU.putBoolean("person_center_item_red_tip", true);
        this.flj.ffV.ceU = new Bundle();
        this.flj.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(this.flj);
        this.flk = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.flk.ceU = new Bundle();
        this.flk.ceU.putBoolean("person_center_item_red_tip", true);
        this.flk.ffV.ceU = new Bundle();
        this.flk.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(this.flk);
        this.flh = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.flh.ceU = new Bundle();
        this.flh.ceU.putBoolean("person_center_item_red_tip", true);
        this.flh.ffV.ceU = new Bundle();
        this.flh.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(this.flh);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.ffV.ceU = new Bundle();
        N.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.ala_live, 29);
            N2.ceU = new Bundle();
            N2.ffV.ceU = new Bundle();
            N2.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fle.add(N2);
        }
        if (this.fln != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fln.getManChannel() == 1) {
                this.fli = N(d.g.icon_weibar_caise_heibai, d.l.frs_channel_tip, 30);
                this.fli.ceU = new Bundle();
                this.fli.ceU.putBoolean("person_center_item_red_tip", true);
                this.fli.ffV.ceU = new Bundle();
                this.fli.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fle.add(this.fli);
            }
        }
        this.fll = N(d.g.icon_vip_heibai, d.l.member_center_item, 16);
        this.fll.ceU = new Bundle();
        this.fll.ceU.putBoolean("person_center_item_red_tip", true);
        this.fll.ffV.ceU = new Bundle();
        this.fll.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(this.fll);
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N3.ffV.ceU = new Bundle();
        N3.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.flg != null) {
            N3.ffV.ceU.putString("book_jump_link", this.flg.ffw);
        }
        this.fle.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N4.ffV.ceU = new Bundle();
        N4.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N5.ffV.ceU = new Bundle();
        N5.ffV.ceU.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fle.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_fuwu_caise_heibai, d.l.person_service_centre, 41);
        N6.ffV.ceU = new Bundle();
        N6.ffV.ceU.putString("key_service_centre", "");
        this.fle.add(N6);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.ffV = new com.baidu.tieba.personCenter.c.a();
        aVar.ffV.ceT = i3;
        return aVar;
    }
}
