package com.baidu.tieba.square;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends SingleRunnable<ArrayList<String>> {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public ArrayList<String> b() {
        return DatabaseService.o();
    }
}
