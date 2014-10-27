package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
import tbclient.Anti;
import tbclient.PostInfoList;
import tbclient.Profile.TAInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ResponsePersonInfoMessage extends CustomResponsedMessage<Object> {
    private Anti anti_stat;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Anti getAnti_stat() {
        return this.anti_stat;
    }

    public void setAnti_stat(Anti anti) {
        this.anti_stat = anti;
    }

    public TAInfo getTainfo() {
        return this.tainfo;
    }

    public void setTainfo(TAInfo tAInfo) {
        this.tainfo = tAInfo;
    }

    public List<PostInfoList> getPost_list() {
        return this.post_list;
    }

    public void setPost_list(List<PostInfoList> list) {
        this.post_list = list;
    }

    public ResponsePersonInfoMessage() {
        super(2001235);
    }
}
