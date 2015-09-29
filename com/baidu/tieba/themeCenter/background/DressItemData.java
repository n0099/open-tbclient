package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import java.io.Serializable;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class DressItemData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private String activityUrl;
    private String description;
    private String exampleImgUrl;
    private int freeUserLevel;
    private int inUse;
    private String permissionImgUrl;
    private int propsId;
    private String propsStateImg;
    private String title;

    public DressItemData() {
    }

    public DressItemData(ThemeBgProp themeBgProp) {
        if (themeBgProp != null) {
            this.title = themeBgProp.title;
            this.description = themeBgProp.description;
            this.exampleImgUrl = themeBgProp.example_url;
            this.propsId = themeBgProp.props_id.intValue();
            this.inUse = themeBgProp.in_use.intValue();
            this.freeUserLevel = themeBgProp.free_user_level.intValue();
            this.permissionImgUrl = themeBgProp.permission;
            this.propsStateImg = themeBgProp.props_state_img;
            this.activityUrl = themeBgProp.activity_url;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getExampleImgUrl() {
        return this.exampleImgUrl;
    }

    public void setExampleImgUrl(String str) {
        this.exampleImgUrl = str;
    }

    public int getPropsId() {
        return this.propsId;
    }

    public void setPropsId(int i) {
        this.propsId = i;
    }

    public boolean getInUse() {
        return this.inUse == 1;
    }

    public void setInUse(boolean z) {
        this.inUse = z ? 1 : 0;
    }

    public int getFreeUserLevel() {
        return this.freeUserLevel;
    }

    public void setFreeUserLevel(int i) {
        this.freeUserLevel = i;
    }

    public String getPermissionImgUrl() {
        return this.permissionImgUrl;
    }

    public void setPermissionImgUrl(String str) {
        this.permissionImgUrl = str;
    }

    public String getPropsStateImg() {
        return this.propsStateImg;
    }

    public void setPropsStateImg(String str) {
        this.propsStateImg = str;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public boolean getIsActivity() {
        return !StringUtils.isNull(this.activityUrl);
    }
}
