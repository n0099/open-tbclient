package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout a;
    private final int b;

    private q(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.a = frsCommonImageLayout;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(FrsCommonImageLayout frsCommonImageLayout, int i, q qVar) {
        this(frsCommonImageLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        MediaData[] mediaDataArr;
        MediaData[] mediaDataArr2;
        MediaData[] mediaDataArr3;
        Context context;
        String str;
        String str2;
        String str3;
        boolean z;
        Context context2;
        Context context3;
        MediaData[] mediaDataArr4;
        r rVar2;
        rVar = this.a.a;
        if (rVar != null) {
            rVar2 = this.a.a;
            rVar2.a(this.b);
            return;
        }
        mediaDataArr = this.a.c;
        if (mediaDataArr[this.b].getType() != 5) {
            mediaDataArr2 = this.a.c;
            if (mediaDataArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                mediaDataArr3 = this.a.c;
                for (MediaData mediaData : mediaDataArr3) {
                    if (TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getPicUrl());
                    } else {
                        arrayList.add(mediaData.getSrc_pic());
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                context = this.a.d;
                com.baidu.tbadk.core.atomData.ab abVar = new com.baidu.tbadk.core.atomData.ab(context);
                int i = this.b;
                str = this.a.n;
                str2 = this.a.m;
                str3 = this.a.o;
                z = this.a.b;
                messageManager.sendMessage(new CustomMessage(2010000, abVar.a(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
                context2 = this.a.d;
                TiebaStatic.eventStat(context2, "pic_frs", "");
                return;
            }
            return;
        }
        context3 = this.a.d;
        mediaDataArr4 = this.a.c;
        com.baidu.tbadk.browser.a.a(context3, mediaDataArr4[this.b].getVideoUrl());
    }
}
