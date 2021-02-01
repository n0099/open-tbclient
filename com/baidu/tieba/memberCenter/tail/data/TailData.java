package com.baidu.tieba.memberCenter.tail.data;

import java.io.Serializable;
/* loaded from: classes9.dex */
public class TailData implements Serializable {
    private static final long serialVersionUID = -4226675025601937685L;
    private String content;
    private String fontColor;
    private String fontType;
    private int id;
    private boolean isSelected;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public String getFontType() {
        return this.fontType;
    }

    public void setFontType(String str) {
        this.fontType = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
