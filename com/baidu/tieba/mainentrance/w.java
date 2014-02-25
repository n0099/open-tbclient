package com.baidu.tieba.mainentrance;

import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.c<ArrayList<String>> {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public ArrayList<String> b() {
        return DatabaseService.m();
    }
}
