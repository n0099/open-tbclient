package com.baidu.tieba.person.data;

import java.io.Serializable;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class PersonUserGodInfo implements Serializable {
    public static final int USER_GOD_TYPE_MULTI = 1;
    public static final int USER_GOD_TYPE_SINGLE = 2;
    private static final long serialVersionUID = -1538103146882985197L;
    private String address;
    private int age;
    private int curPage;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private List<ThreadInfo> godThreadList;
    private int godType;
    private int sex;
    private String totalThread;

    public int getGodType() {
        return this.godType;
    }

    public GodDetailInfo getgodDetailInfo() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public String getTotalThread() {
        return this.totalThread;
    }

    public void setTotalThread(String str) {
        this.totalThread = str;
    }

    public List<ThreadInfo> getGodThreadList() {
        return this.godThreadList;
    }

    public void setGodThreadList(List<ThreadInfo> list) {
        this.godThreadList = list;
    }

    public void parserProtobuf(UserGodInfo userGodInfo) {
        if (userGodInfo != null) {
            this.godType = userGodInfo.god_type.intValue();
            this.godDetailInfo = userGodInfo.god_info;
            this.forumGodList = userGodInfo.forum_god_list;
            this.sex = userGodInfo.sex.intValue();
            this.age = userGodInfo.age.intValue();
            this.address = userGodInfo.address;
            this.curPage = userGodInfo.cur_page.intValue();
            this.totalThread = userGodInfo.total_thread;
            this.godThreadList = userGodInfo.thread_list;
        }
    }
}
