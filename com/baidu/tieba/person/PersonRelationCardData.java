package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.tieba.person.PersonPostListData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonRelationCardData extends PersonPostListData.PostList {
    private static final long serialVersionUID = 1;
    private String commonFriend;
    private String commonGroup;
    private String commonLike;
    private String distance;
    private Context mContext;
    private com.baidu.tieba.model.av mModel;
    private int sex;
    private String uId;

    public PersonRelationCardData(Context context, com.baidu.tieba.model.av avVar) {
        this.mContext = context;
        this.mModel = avVar;
        if (avVar.a().d() != null) {
            this.distance = avVar.a().d().a();
        }
        this.commonLike = listToString(avVar.a().a());
        this.commonFriend = listToString(avVar.a().c());
        this.commonGroup = listToString(avVar.a().b());
        if (!avVar.j()) {
            this.commonFriend = "";
        }
        this.uId = avVar.i();
        this.sex = avVar.k().getSex();
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getCommonLike() {
        return this.commonLike;
    }

    public void setCommonLike(String str) {
        this.commonLike = str;
    }

    public String getCommonFriend() {
        return this.commonFriend;
    }

    public void setCommonFriend(String str) {
        this.commonFriend = str;
        if (this.mModel != null && !this.mModel.j()) {
            this.commonFriend = "";
        }
    }

    public String getCommonGroup() {
        return this.commonGroup;
    }

    public void setCommonGroup(String str) {
        this.commonGroup = str;
    }

    public String getuId() {
        return this.uId;
    }

    public void setuId(String str) {
        this.uId = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public com.baidu.tieba.model.av getmModel() {
        return this.mModel;
    }

    public void setmModel(com.baidu.tieba.model.av avVar) {
        this.mModel = avVar;
    }

    public String listToString(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(arrayList.get(0)) + this.mContext.getString(com.baidu.tieba.x.comma) + arrayList.get(1) + this.mContext.getString(com.baidu.tieba.x.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(arrayList.get(0)) + this.mContext.getString(com.baidu.tieba.x.comma) + arrayList.get(1);
        }
        return arrayList.get(0);
    }
}
