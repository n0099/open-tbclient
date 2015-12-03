package com.baidu.tieba.themeCenter;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.GetSkin.DataRes;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class b {
    private String activityUrl;
    private int bOp;
    private String dDB;
    private String dDC;
    private String dDD;
    private String dDE;
    private int dDF;
    private ArrayList<String> dDG;
    private String dDI;
    private String dDJ;
    private String description;
    private int id;
    private String picUrl;
    private String title;
    private int versionCode;
    private int newVersionCode = 0;
    private boolean dDH = false;
    private int activityFinish = 0;
    private int aba = 1;

    public void a(ThemeSkinPropMain themeSkinPropMain) {
        if (themeSkinPropMain != null) {
            this.id = themeSkinPropMain.props_id.intValue();
            this.title = themeSkinPropMain.title;
            this.picUrl = themeSkinPropMain.example_url;
            this.dDB = themeSkinPropMain.package_size;
            this.dDC = themeSkinPropMain.package_url;
            this.versionCode = themeSkinPropMain.props_version.intValue();
            this.dDD = themeSkinPropMain.permission;
            this.dDE = themeSkinPropMain.props_state_img;
            this.dDF = themeSkinPropMain.free_user_level.intValue();
            this.activityUrl = themeSkinPropMain.activity_url;
            this.activityFinish = themeSkinPropMain.is_finished.intValue();
            this.dDJ = themeSkinPropMain.package_key;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.dDB = dataRes.package_size;
            this.dDC = dataRes.package_url;
            this.description = dataRes.description;
            this.versionCode = dataRes.props_version.intValue();
            this.dDD = dataRes.permission;
            this.dDI = dataRes.permission;
            this.dDE = dataRes.props_state_img;
            this.dDF = dataRes.free_user_level.intValue();
            this.activityUrl = dataRes.activity_url;
            this.dDG = new ArrayList<>();
            this.activityFinish = dataRes.is_finished.intValue();
            this.dDJ = dataRes.package_key;
            ArrayList arrayList = new ArrayList();
            if (dataRes.pic_url != null && dataRes.pic_url.size() > 0) {
                for (String str : dataRes.pic_url) {
                    if (!StringUtils.isNull(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 5) {
                    this.dDG.addAll(arrayList.subList(0, 5));
                } else {
                    this.dDG.addAll(arrayList);
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

    public void mN(String str) {
        this.picUrl = str;
    }

    public String getPackageSize() {
        return this.dDB;
    }

    public void setPackageSize(String str) {
        this.dDB = str;
    }

    public String aFb() {
        return this.dDC;
    }

    public void mO(String str) {
        this.dDC = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String aFc() {
        return this.dDD;
    }

    public void mP(String str) {
        this.dDD = str;
    }

    public String aFd() {
        return this.dDE;
    }

    public void mQ(String str) {
        this.dDE = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int aFe() {
        return this.dDF;
    }

    public void mO(int i) {
        this.dDF = i;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int aFf() {
        return this.aba;
    }

    public void mP(int i) {
        this.aba = i;
    }

    public ArrayList<String> aFg() {
        return this.dDG;
    }

    public int XG() {
        return this.bOp;
    }

    public void hZ(int i) {
        this.bOp = i;
    }

    public boolean aFh() {
        return this.dDH;
    }

    public void hu(boolean z) {
        this.dDH = z;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void mQ(int i) {
        this.newVersionCode = i;
    }

    public String aFi() {
        return this.dDI;
    }

    public int getActivityFinish() {
        return this.activityFinish;
    }
}
