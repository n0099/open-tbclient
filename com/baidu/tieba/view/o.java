package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.af;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout a;
    private final int b;

    private o(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.a = frsCommonImageLayout;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(FrsCommonImageLayout frsCommonImageLayout, int i, o oVar) {
        this(frsCommonImageLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        MediaData[] mediaDataArr;
        MediaData[] mediaDataArr2;
        MediaData[] mediaDataArr3;
        Context context;
        String str;
        String str2;
        String str3;
        boolean z;
        Context context2;
        MediaData[] mediaDataArr4;
        Context context3;
        MediaData[] mediaDataArr5;
        p pVar2;
        pVar = this.a.a;
        if (pVar != null) {
            pVar2 = this.a.a;
            pVar2.a(this.b);
            return;
        }
        mediaDataArr = this.a.c;
        if (mediaDataArr[this.b].getType() != 5) {
            mediaDataArr2 = this.a.c;
            if (mediaDataArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                mediaDataArr3 = this.a.c;
                for (MediaData mediaData : mediaDataArr3) {
                    if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getSrc_pic());
                    }
                }
                if (arrayList.size() <= 0) {
                    mediaDataArr4 = this.a.c;
                    for (MediaData mediaData2 : mediaDataArr4) {
                        if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                            arrayList.add(mediaData2.getPicUrl());
                        }
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                context = this.a.d;
                af afVar = new af(context);
                int i = this.b;
                str = this.a.n;
                str2 = this.a.m;
                str3 = this.a.o;
                z = this.a.b;
                messageManager.sendMessage(new CustomMessage(2010000, afVar.a(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
                context2 = this.a.d;
                TiebaStatic.eventStat(context2, "pic_frs", "");
                return;
            }
            return;
        }
        context3 = this.a.d;
        mediaDataArr5 = this.a.c;
        com.baidu.tbadk.browser.a.a(context3, mediaDataArr5[this.b].getVideoUrl());
    }
}
