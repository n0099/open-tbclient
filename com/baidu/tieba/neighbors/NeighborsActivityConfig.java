package com.baidu.tieba.neighbors;

import android.content.Context;
/* loaded from: classes.dex */
public class NeighborsActivityConfig extends com.baidu.tbadk.core.frameworkData.a {
    public static final String LOCATING = "locating";

    public NeighborsActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(LOCATING, z);
    }
}
