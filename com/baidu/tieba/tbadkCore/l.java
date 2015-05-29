package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ FrsCommonImageLayout coX;
    private final int mIndex;

    private l(FrsCommonImageLayout frsCommonImageLayout, int i) {
        this.coX = frsCommonImageLayout;
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
        boolean z2;
        MediaData[] mediaDataArr5;
        m mVar2;
        mVar = this.coX.coL;
        if (mVar != null) {
            mVar2 = this.coX.coL;
            mVar2.onChildClickCallback(this.mIndex);
            return;
        }
        mediaDataArr = this.coX.Yg;
        if (mediaDataArr[this.mIndex].getType() != 5) {
            mediaDataArr2 = this.coX.Yg;
            if (mediaDataArr2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                mediaDataArr3 = this.coX.Yg;
                for (MediaData mediaData : mediaDataArr3) {
                    if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getSrc_pic());
                        if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            z2 = this.coX.mIsFromCDN;
                            imageUrlData.urlType = z2 ? 13 : 14;
                            imageUrlData.imageUrl = mediaData.getPicUrl();
                            hashMap.put(mediaData.getSrc_pic(), imageUrlData);
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    mediaDataArr4 = this.coX.Yg;
                    for (MediaData mediaData2 : mediaDataArr4) {
                        if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                            arrayList.add(mediaData2.getPicUrl());
                        }
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                if (this.coX.coQ == null) {
                    pageActivity = this.coX.mContext;
                } else {
                    pageActivity = this.coX.coQ.getPageActivity();
                }
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(pageActivity);
                int i = this.mIndex;
                str = this.coX.mForumName;
                str2 = this.coX.mForumId;
                str3 = this.coX.mThreadId;
                z = this.coX.mIsFromCDN;
                messageManager.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i, str, str2, str3, z, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true, hashMap)));
                context = this.coX.mContext;
                TiebaStatic.eventStat(context, "pic_frs", "");
                return;
            }
            return;
        }
        Context pageActivity2 = this.coX.coQ == null ? this.coX.mContext : this.coX.coQ.getPageActivity();
        mediaDataArr5 = this.coX.Yg;
        com.baidu.tbadk.browser.f.x(pageActivity2, mediaDataArr5[this.mIndex].getVideoUrl());
    }
}
