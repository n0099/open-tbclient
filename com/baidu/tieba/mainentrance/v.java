package com.baidu.tieba.mainentrance;

import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends com.baidu.tieba.im.b<ArrayList<String>> {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ ArrayList<String> a() {
        return DatabaseService.n();
    }
}
