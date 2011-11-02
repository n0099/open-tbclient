package com.baidu.tieba.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PersonChangeModel implements Serializable {
    private static final long serialVersionUID = 4345761658406426272L;
    private String mIntro = null;
    private int mSex = 1;
    private String mName = null;
    private String mPortrait = null;
    private boolean mPhotoChanged = false;

    public String getIntro() {
        return this.mIntro;
    }

    public void setIntro(String intro) {
        this.mIntro = intro;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setSex(int sex) {
        this.mSex = sex;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return this.mName;
    }

    public void setPhotoChanged(boolean photoChanged) {
        this.mPhotoChanged = photoChanged;
    }

    public boolean getPhotoChanged() {
        return this.mPhotoChanged;
    }

    public void setPortrait(String portrait) {
        this.mPortrait = portrait;
    }

    public String getPortrait() {
        return this.mPortrait;
    }
}
