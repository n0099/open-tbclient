package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class DressItemData extends OrmObject implements Serializable {
    public int activityFinish;
    public String activityUrl;
    public int dailyPrevilegeStatus;
    public String description;
    public String exampleImgUrl;
    public int freeUserLevel;
    public int inUse;
    public String permissionImgUrl;
    public int propsId;
    public String propsStateImg;
    public String title;

    public DressItemData() {
        this.dailyPrevilegeStatus = 0;
        this.inUse = 0;
    }

    public int getActivityFinish() {
        return this.activityFinish;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExampleImgUrl() {
        return this.exampleImgUrl;
    }

    public int getFreeUserLevel() {
        return this.freeUserLevel;
    }

    public boolean getInUse() {
        return this.inUse == 1;
    }

    public boolean getIsActivity() {
        return !StringUtils.isNull(this.activityUrl);
    }

    public String getPermissionImgUrl() {
        return this.permissionImgUrl;
    }

    public int getPropsId() {
        return this.propsId;
    }

    public String getPropsStateImg() {
        return this.propsStateImg;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isDefault() {
        return this.propsId == 0;
    }

    public boolean isPropIdEven() {
        return this.propsId % 2 == 0;
    }

    public void setActivityFinish(int i) {
        this.activityFinish = i;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExampleImgUrl(String str) {
        this.exampleImgUrl = str;
    }

    public void setFreeUserLevel(int i) {
        this.freeUserLevel = i;
    }

    public void setInUse(boolean z) {
        this.inUse = z ? 1 : 0;
    }

    public void setPermissionImgUrl(String str) {
        this.permissionImgUrl = str;
    }

    public void setPropsId(int i) {
        this.propsId = i;
    }

    public void setPropsStateImg(String str) {
        this.propsStateImg = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public DressItemData(ThemeBgProp themeBgProp) {
        this.dailyPrevilegeStatus = 0;
        if (themeBgProp == null) {
            return;
        }
        this.title = themeBgProp.title;
        this.description = themeBgProp.description;
        this.exampleImgUrl = themeBgProp.example_url;
        this.propsId = themeBgProp.props_id.intValue();
        this.inUse = themeBgProp.in_use.intValue();
        this.freeUserLevel = themeBgProp.free_user_level.intValue();
        this.permissionImgUrl = themeBgProp.permission;
        this.propsStateImg = themeBgProp.props_state_img;
        this.activityUrl = themeBgProp.activity_url;
        this.activityFinish = themeBgProp.is_finished.intValue();
    }
}
