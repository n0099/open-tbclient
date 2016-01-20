package com.baidu.tieba.themeCenter;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.GetSkin.DataRes;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class b {
    private String activityUrl;
    private int bRV;
    private String dLf;
    private String dLg;
    private String dLh;
    private String dLi;
    private int dLj;
    private ArrayList<String> dLk;
    private String dLm;
    private String dLn;
    private String description;
    private int id;
    private String picUrl;
    private String title;
    private int versionCode;
    private int newVersionCode = 0;
    private boolean dLl = false;
    private int activityFinish = 0;
    private int abE = 1;

    public void a(ThemeSkinPropMain themeSkinPropMain) {
        if (themeSkinPropMain != null) {
            this.id = themeSkinPropMain.props_id.intValue();
            this.title = themeSkinPropMain.title;
            this.picUrl = themeSkinPropMain.example_url;
            this.dLf = themeSkinPropMain.package_size;
            this.dLg = themeSkinPropMain.package_url;
            this.versionCode = themeSkinPropMain.props_version.intValue();
            this.dLh = themeSkinPropMain.permission;
            this.dLi = themeSkinPropMain.props_state_img;
            this.dLj = themeSkinPropMain.free_user_level.intValue();
            this.activityUrl = themeSkinPropMain.activity_url;
            this.activityFinish = themeSkinPropMain.is_finished.intValue();
            this.dLn = themeSkinPropMain.package_key;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.dLf = dataRes.package_size;
            this.dLg = dataRes.package_url;
            this.description = dataRes.description;
            this.versionCode = dataRes.props_version.intValue();
            this.dLh = dataRes.permission;
            this.dLm = dataRes.permission;
            this.dLi = dataRes.props_state_img;
            this.dLj = dataRes.free_user_level.intValue();
            this.activityUrl = dataRes.activity_url;
            this.dLk = new ArrayList<>();
            this.activityFinish = dataRes.is_finished.intValue();
            this.dLn = dataRes.package_key;
            ArrayList arrayList = new ArrayList();
            if (dataRes.pic_url != null && dataRes.pic_url.size() > 0) {
                for (String str : dataRes.pic_url) {
                    if (!StringUtils.isNull(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 5) {
                    this.dLk.addAll(arrayList.subList(0, 5));
                } else {
                    this.dLk.addAll(arrayList);
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

    public void mL(String str) {
        this.picUrl = str;
    }

    public String getPackageSize() {
        return this.dLf;
    }

    public void setPackageSize(String str) {
        this.dLf = str;
    }

    public String aHq() {
        return this.dLg;
    }

    public void mM(String str) {
        this.dLg = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String aHr() {
        return this.dLh;
    }

    public void mN(String str) {
        this.dLh = str;
    }

    public String aHs() {
        return this.dLi;
    }

    public void mO(String str) {
        this.dLi = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int aHt() {
        return this.dLj;
    }

    public void nq(int i) {
        this.dLj = i;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int aHu() {
        return this.abE;
    }

    public void nr(int i) {
        this.abE = i;
    }

    public ArrayList<String> aHv() {
        return this.dLk;
    }

    public int YL() {
        return this.bRV;
    }

    public void iz(int i) {
        this.bRV = i;
    }

    public boolean aHw() {
        return this.dLl;
    }

    public void hD(boolean z) {
        this.dLl = z;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void ns(int i) {
        this.newVersionCode = i;
    }

    public String aHx() {
        return this.dLm;
    }

    public int getActivityFinish() {
        return this.activityFinish;
    }
}
