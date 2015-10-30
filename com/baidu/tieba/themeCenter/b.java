package com.baidu.tieba.themeCenter;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.GetSkin.DataRes;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class b {
    private String activityUrl;
    private int byM;
    private String den;
    private String deo;
    private String dep;
    private String deq;
    private int der;
    private ArrayList<String> des;
    private String description;
    private String deu;
    private int id;
    private String picUrl;
    private String title;
    private int versionCode;
    private int newVersionCode = 0;
    private boolean det = false;
    private int aak = 1;

    public void a(ThemeSkinPropMain themeSkinPropMain) {
        if (themeSkinPropMain != null) {
            this.id = themeSkinPropMain.props_id.intValue();
            this.title = themeSkinPropMain.title;
            this.picUrl = themeSkinPropMain.example_url;
            this.den = themeSkinPropMain.package_size;
            this.deo = themeSkinPropMain.package_url;
            this.versionCode = themeSkinPropMain.props_version.intValue();
            this.dep = themeSkinPropMain.permission;
            this.deq = themeSkinPropMain.props_state_img;
            this.der = themeSkinPropMain.free_user_level.intValue();
            this.activityUrl = themeSkinPropMain.activity_url;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.den = dataRes.package_size;
            this.deo = dataRes.package_url;
            this.description = dataRes.description;
            this.versionCode = dataRes.props_version.intValue();
            this.dep = dataRes.permission;
            this.deu = dataRes.permission;
            this.deq = dataRes.props_state_img;
            this.der = dataRes.free_user_level.intValue();
            this.activityUrl = dataRes.activity_url;
            this.des = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            if (dataRes.pic_url != null && dataRes.pic_url.size() > 0) {
                for (String str : dataRes.pic_url) {
                    if (!StringUtils.isNull(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 5) {
                    this.des.addAll(arrayList.subList(0, 5));
                } else {
                    this.des.addAll(arrayList);
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

    public void lS(String str) {
        this.picUrl = str;
    }

    public String getPackageSize() {
        return this.den;
    }

    public void setPackageSize(String str) {
        this.den = str;
    }

    public String aze() {
        return this.deo;
    }

    public void lT(String str) {
        this.deo = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String azf() {
        return this.dep;
    }

    public void lU(String str) {
        this.dep = str;
    }

    public String azg() {
        return this.deq;
    }

    public void lV(String str) {
        this.deq = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int azh() {
        return this.der;
    }

    public void lq(int i) {
        this.der = i;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int azi() {
        return this.aak;
    }

    public void lr(int i) {
        this.aak = i;
    }

    public ArrayList<String> azj() {
        return this.des;
    }

    public int Uf() {
        return this.byM;
    }

    public void gZ(int i) {
        this.byM = i;
    }

    public boolean azk() {
        return this.det;
    }

    public void gJ(boolean z) {
        this.det = z;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void ls(int i) {
        this.newVersionCode = i;
    }

    public String azl() {
        return this.deu;
    }
}
