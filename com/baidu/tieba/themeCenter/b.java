package com.baidu.tieba.themeCenter;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.GetSkin.DataRes;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class b {
    private String activityUrl;
    private int bzj;
    private String description;
    private String dfT;
    private String dfU;
    private String dfV;
    private String dfW;
    private int dfX;
    private ArrayList<String> dfY;
    private String dga;
    private int id;
    private String picUrl;
    private String title;
    private int versionCode;
    private int newVersionCode = 0;
    private boolean dfZ = false;
    private int aao = 1;

    public void a(ThemeSkinPropMain themeSkinPropMain) {
        if (themeSkinPropMain != null) {
            this.id = themeSkinPropMain.props_id.intValue();
            this.title = themeSkinPropMain.title;
            this.picUrl = themeSkinPropMain.example_url;
            this.dfT = themeSkinPropMain.package_size;
            this.dfU = themeSkinPropMain.package_url;
            this.versionCode = themeSkinPropMain.props_version.intValue();
            this.dfV = themeSkinPropMain.permission;
            this.dfW = themeSkinPropMain.props_state_img;
            this.dfX = themeSkinPropMain.free_user_level.intValue();
            this.activityUrl = themeSkinPropMain.activity_url;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.dfT = dataRes.package_size;
            this.dfU = dataRes.package_url;
            this.description = dataRes.description;
            this.versionCode = dataRes.props_version.intValue();
            this.dfV = dataRes.permission;
            this.dga = dataRes.permission;
            this.dfW = dataRes.props_state_img;
            this.dfX = dataRes.free_user_level.intValue();
            this.activityUrl = dataRes.activity_url;
            this.dfY = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            if (dataRes.pic_url != null && dataRes.pic_url.size() > 0) {
                for (String str : dataRes.pic_url) {
                    if (!StringUtils.isNull(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 5) {
                    this.dfY.addAll(arrayList.subList(0, 5));
                } else {
                    this.dfY.addAll(arrayList);
                }
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void lW(String str) {
        this.picUrl = str;
    }

    public String getPackageSize() {
        return this.dfT;
    }

    public void setPackageSize(String str) {
        this.dfT = str;
    }

    public String azU() {
        return this.dfU;
    }

    public void lX(String str) {
        this.dfU = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String azV() {
        return this.dfV;
    }

    public void lY(String str) {
        this.dfV = str;
    }

    public String azW() {
        return this.dfW;
    }

    public void lZ(String str) {
        this.dfW = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int azX() {
        return this.dfX;
    }

    public void lE(int i) {
        this.dfX = i;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int azY() {
        return this.aao;
    }

    public void lF(int i) {
        this.aao = i;
    }

    public ArrayList<String> azZ() {
        return this.dfY;
    }

    public int UA() {
        return this.bzj;
    }

    public void hm(int i) {
        this.bzj = i;
    }

    public boolean aAa() {
        return this.dfZ;
    }

    public void gM(boolean z) {
        this.dfZ = z;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void lG(int i) {
        this.newVersionCode = i;
    }

    public String aAb() {
        return this.dga;
    }
}
