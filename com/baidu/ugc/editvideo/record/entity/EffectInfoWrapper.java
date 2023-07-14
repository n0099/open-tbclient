package com.baidu.ugc.editvideo.record.entity;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes9.dex */
public class EffectInfoWrapper implements Serializable {
    public static final int TYPE_BLOCKBUSTER = 0;
    public static final int TYPE_KSONG_MUSIC = 2;
    public static final int TYPE_STICKING_POINT = 1;
    public List<EffectInfo> data;
    public String name;
    public int type;
}
