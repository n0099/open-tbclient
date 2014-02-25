package com.baidu.tieba.mainentrance;

import android.content.Context;
import com.baidu.tieba.MainTabActivity;
/* loaded from: classes.dex */
public class g implements e {
    @Override // com.baidu.tieba.mainentrance.e
    public void a(Context context, int i) {
        MainTabActivity.a(context, i);
    }

    @Override // com.baidu.tieba.mainentrance.e
    public void a(Context context) {
        MainTabActivity.a(context);
    }

    @Override // com.baidu.tieba.mainentrance.e
    public void a(Context context, int i, boolean z) {
        MainTabActivity.b(context, i, z);
    }

    @Override // com.baidu.tieba.mainentrance.e
    public void b(Context context, int i) {
        MainTabActivity.b(context, i);
    }

    @Override // com.baidu.tieba.mainentrance.e
    public Class a() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tieba.mainentrance.e
    public String b() {
        return MainTabActivity.class.getName();
    }
}
