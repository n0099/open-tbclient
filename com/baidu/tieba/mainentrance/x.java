package com.baidu.tieba.mainentrance;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.a<ArrayList<String>> {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ArrayList<String> arrayList) {
        this.a.a(true, arrayList);
    }
}
