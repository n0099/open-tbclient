package com.baidu.tieba.newinterest.data;
/* loaded from: classes23.dex */
public class b {
    private int icon;
    private int id;
    private boolean selected;
    private String text;

    public b(int i, String str, int i2, boolean z) {
        this.id = i;
        this.text = str;
        this.icon = i2;
        this.selected = z;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public int getIcon() {
        return this.icon;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }
}
