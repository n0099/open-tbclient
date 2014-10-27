package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout bRp;
    private final int mIndex;

    private o(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.bRp = frsCommonImageLayout;
        this.mIndex = i;
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
        pVar = this.bRp.bRj;
        if (pVar != null) {
            pVar2 = this.bRp.bRj;
            pVar2.bO(this.mIndex);
            return;
        }
        mediaDataArr = this.bRp.bQL;
        if (mediaDataArr[this.mIndex].getType() != 5) {
            mediaDataArr2 = this.bRp.bQL;
            if (mediaDataArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                mediaDataArr3 = this.bRp.bQL;
                for (MediaData mediaData : mediaDataArr3) {
                    if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getSrc_pic());
                    }
                }
                if (arrayList.size() <= 0) {
                    mediaDataArr4 = this.bRp.bQL;
                    for (MediaData mediaData2 : mediaDataArr4) {
                        if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                            arrayList.add(mediaData2.getPicUrl());
                        }
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                context = this.bRp.mContext;
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(context);
                int i = this.mIndex;
                str = this.bRp.mForumName;
                str2 = this.bRp.mForumId;
                str3 = this.bRp.mThreadId;
                z = this.bRp.mIsFromCDN;
                messageManager.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
                context2 = this.bRp.mContext;
                TiebaStatic.eventStat(context2, "pic_frs", "");
                return;
            }
            return;
        }
        context3 = this.bRp.mContext;
        mediaDataArr5 = this.bRp.bQL;
        com.baidu.tbadk.browser.a.i(context3, mediaDataArr5[this.mIndex].getVideoUrl());
    }
}
