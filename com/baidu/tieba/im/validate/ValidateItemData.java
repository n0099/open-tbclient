package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.ae;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ValidateItemData implements ae, Serializable {
    private static final long serialVersionUID = 3854743775726463617L;
    private String UserId;
    private String applyReason;
    private long applyTime;
    private String groupId;
    private String groupName;
    private boolean isPass;
    private boolean isShown;
    private String notice_id;
    private String portrait;
    private String userName;

    public GroupNewsPojo toGroupNewsPojo() {
        return new GroupNewsPojo(this);
    }

    public String toJsonString() {
        return new Gson().toJson(this).toString();
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getApplyReason() {
        return this.applyReason;
    }

    public void setApplyReason(String str) {
        this.applyReason = str;
    }

    public long getApplyTime() {
        return this.applyTime;
    }

    public void setApplyTime(long j) {
        this.applyTime = j;
    }

    public boolean isPass() {
        return this.isPass;
    }

    public void setPass(boolean z) {
        this.isPass = z;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String str) {
        this.UserId = str;
    }

    @Override // com.baidu.tieba.util.ae
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }

    @Override // com.baidu.tieba.util.ae
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }
}
