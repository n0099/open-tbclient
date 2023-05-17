package com.baidu.ugc.bean;

import java.io.Serializable;
/* loaded from: classes8.dex */
public abstract class MusicBaseBean implements Serializable {
    public static final int MUSIC_MENU_COLUMNS = 5;
    public int type = -1;

    public abstract int getSpanSize();

    public int getType() {
        return this.type;
    }
}
