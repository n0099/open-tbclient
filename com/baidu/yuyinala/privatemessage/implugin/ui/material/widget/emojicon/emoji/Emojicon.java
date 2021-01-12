package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class Emojicon implements Serializable {
    private static final long serialVersionUID = 1;
    private String emoji;
    private int icon;
    private char value;

    public Emojicon() {
    }

    public Emojicon(String str) {
        this.emoji = str;
    }

    public static Emojicon fromResource(int i, int i2) {
        Emojicon emojicon = new Emojicon();
        emojicon.icon = i;
        emojicon.value = (char) i2;
        return emojicon;
    }

    public static Emojicon fromCodePoint(int i) {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = newString(i);
        return emojicon;
    }

    public static Emojicon fromChar(char c) {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = Character.toString(c);
        return emojicon;
    }

    public static Emojicon fromChars(String str) {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = str;
        return emojicon;
    }

    public char getValue() {
        return this.value;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public static final String newString(int i) {
        return Character.charCount(i) == 1 ? String.valueOf(i) : new String(Character.toChars(i));
    }
}
