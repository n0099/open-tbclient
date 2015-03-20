package com.baidu.tieba.pb.chosen.cache;

import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.pb.chosen.net.a {
    private User_Info bGf;
    private ForumInfo forumInfo;
    private long nextTid;
    private long preTid;

    public a(long j, long j2, User_Info user_Info, ForumInfo forumInfo) {
        this.preTid = j;
        this.nextTid = j2;
        this.bGf = user_Info;
        this.forumInfo = forumInfo;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public long getPreTid() {
        return this.preTid;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public long getNextTid() {
        return this.nextTid;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public User_Info getUserInfo() {
        return this.bGf;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public ForumInfo getForumInfo() {
        return this.forumInfo;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public int getErroCode() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public String getErrorText() {
        return null;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public boolean isEmpty() {
        return this.forumInfo == null || this.forumInfo.content == null || this.forumInfo.content.size() <= 0;
    }
}
