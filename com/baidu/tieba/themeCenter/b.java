package com.baidu.tieba.themeCenter;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.GetSkin.DataRes;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class b {
    private String activityUrl;
    private int byB;
    private String ddN;
    private String ddO;
    private String ddP;
    private String ddQ;
    private int ddR;
    private ArrayList<String> ddS;
    private String ddU;
    private String description;
    private int id;
    private String picUrl;
    private String title;
    private int versionCode;
    private int newVersionCode = 0;
    private boolean ddT = false;
    private int aai = 1;

    public void a(ThemeSkinPropMain themeSkinPropMain) {
        if (themeSkinPropMain != null) {
            this.id = themeSkinPropMain.props_id.intValue();
            this.title = themeSkinPropMain.title;
            this.picUrl = themeSkinPropMain.example_url;
            this.ddN = themeSkinPropMain.package_size;
            this.ddO = themeSkinPropMain.package_url;
            this.versionCode = themeSkinPropMain.props_version.intValue();
            this.ddP = themeSkinPropMain.permission;
            this.ddQ = themeSkinPropMain.props_state_img;
            this.ddR = themeSkinPropMain.free_user_level.intValue();
            this.activityUrl = themeSkinPropMain.activity_url;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.ddN = dataRes.package_size;
            this.ddO = dataRes.package_url;
            this.description = dataRes.description;
            this.versionCode = dataRes.props_version.intValue();
            this.ddP = dataRes.permission;
            this.ddU = dataRes.permission;
            this.ddQ = dataRes.props_state_img;
            this.ddR = dataRes.free_user_level.intValue();
            this.activityUrl = dataRes.activity_url;
            this.ddS = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            if (dataRes.pic_url != null && dataRes.pic_url.size() > 0) {
                for (String str : dataRes.pic_url) {
                    if (!StringUtils.isNull(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 5) {
                    this.ddS.addAll(arrayList.subList(0, 5));
                } else {
                    this.ddS.addAll(arrayList);
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

    public void lP(String str) {
        this.picUrl = str;
    }

    public String getPackageSize() {
        return this.ddN;
    }

    public void setPackageSize(String str) {
        this.ddN = str;
    }

    public String ayY() {
        return this.ddO;
    }

    public void lQ(String str) {
        this.ddO = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String ayZ() {
        return this.ddP;
    }

    public void lR(String str) {
        this.ddP = str;
    }

    public String aza() {
        return this.ddQ;
    }

    public void lS(String str) {
        this.ddQ = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int azb() {
        return this.ddR;
    }

    public void lo(int i) {
        this.ddR = i;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int azc() {
        return this.aai;
    }

    public void lp(int i) {
        this.aai = i;
    }

    public ArrayList<String> azd() {
        return this.ddS;
    }

    public int Uj() {
        return this.byB;
    }

    public void gZ(int i) {
        this.byB = i;
    }

    public boolean aze() {
        return this.ddT;
    }

    public void gJ(boolean z) {
        this.ddT = z;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public void lq(int i) {
        this.newVersionCode = i;
    }

    public String azf() {
        return this.ddU;
    }
}
