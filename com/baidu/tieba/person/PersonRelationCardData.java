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
    private com.baidu.tieba.model.au mModel;
    private int sex;
    private String uId;

    public PersonRelationCardData(Context context, com.baidu.tieba.model.au auVar) {
        this.mContext = context;
        this.mModel = auVar;
        if (auVar.a().d() != null) {
            this.distance = auVar.a().d().a();
        }
        this.commonLike = listToString(auVar.a().a());
        this.commonFriend = listToString(auVar.a().c());
        this.commonGroup = listToString(auVar.a().b());
        this.uId = auVar.h();
        this.sex = auVar.j().getSex();
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

    public com.baidu.tieba.model.au getmModel() {
        return this.mModel;
    }

    public void setmModel(com.baidu.tieba.model.au auVar) {
        this.mModel = auVar;
    }

    public String listToString(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() > 2) {
            return String.valueOf(arrayList.get(0)) + this.mContext.getString(com.baidu.tieba.y.comma) + arrayList.get(1) + this.mContext.getString(com.baidu.tieba.y.etc);
        }
        if (arrayList.size() == 2) {
            return String.valueOf(arrayList.get(0)) + this.mContext.getString(com.baidu.tieba.y.comma) + arrayList.get(1);
        }
        return arrayList.get(0);
    }
}
