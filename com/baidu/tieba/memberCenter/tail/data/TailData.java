package com.baidu.tieba.memberCenter.tail.data;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class TailData implements Serializable {
    public static final long serialVersionUID = -4226675025601937685L;
    public String content;
    public String fontColor;
    public String fontType;
    public int id;
    public boolean isSelected;

    public String getContent() {
        return this.content;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public String getFontType() {
        return this.fontType;
    }

    public int getId() {
        return this.id;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public void setFontType(String str) {
        this.fontType = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
