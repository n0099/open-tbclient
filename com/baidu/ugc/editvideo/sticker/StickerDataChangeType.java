package com.baidu.ugc.editvideo.sticker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface StickerDataChangeType {
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String INIT = "init";
    public static final String REPLACE = "replace";
    public static final String SWAP = "swap";
    public static final String UPDATE = "update";
}
