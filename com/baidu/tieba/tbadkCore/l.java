package com.baidu.tieba.tbadkCore;

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
public class l implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout bUo;
    private final int mIndex;

    private l(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.bUo = frsCommonImageLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(FrsCommonImageLayout frsCommonImageLayout, int i, l lVar) {
        this(frsCommonImageLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        MediaData[] mediaDataArr;
        MediaData[] mediaDataArr2;
        MediaData[] mediaDataArr3;
        Context pageActivity;
        String str;
        String str2;
        String str3;
        boolean z;
        Context context;
        MediaData[] mediaDataArr4;
        MediaData[] mediaDataArr5;
        m mVar2;
        mVar = this.bUo.bUc;
        if (mVar != null) {
            mVar2 = this.bUo.bUc;
            mVar2.onChildClickCallback(this.mIndex);
            return;
        }
        mediaDataArr = this.bUo.Mn;
        if (mediaDataArr[this.mIndex].getType() != 5) {
            mediaDataArr2 = this.bUo.Mn;
            if (mediaDataArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                mediaDataArr3 = this.bUo.Mn;
                for (MediaData mediaData : mediaDataArr3) {
                    if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getSrc_pic());
                    }
                }
                if (arrayList.size() <= 0) {
                    mediaDataArr4 = this.bUo.Mn;
                    for (MediaData mediaData2 : mediaDataArr4) {
                        if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                            arrayList.add(mediaData2.getPicUrl());
                        }
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                if (this.bUo.bUh == null) {
                    pageActivity = this.bUo.mContext;
                } else {
                    pageActivity = this.bUo.bUh.getPageActivity();
                }
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(pageActivity);
                int i = this.mIndex;
                str = this.bUo.mForumName;
                str2 = this.bUo.mForumId;
                str3 = this.bUo.mThreadId;
                z = this.bUo.mIsFromCDN;
                messageManager.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true)));
                context = this.bUo.mContext;
                TiebaStatic.eventStat(context, "pic_frs", "");
                return;
            }
            return;
        }
        Context pageActivity2 = this.bUo.bUh == null ? this.bUo.mContext : this.bUo.bUh.getPageActivity();
        mediaDataArr5 = this.bUo.Mn;
        com.baidu.tbadk.browser.a.x(pageActivity2, mediaDataArr5[this.mIndex].getVideoUrl());
    }
}
