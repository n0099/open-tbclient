package com.baidu.tieba.themeCenter;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ SkinProgressView dep;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SkinProgressView skinProgressView, int i) {
        super(i);
        this.dep = skinProgressView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        b bVar;
        DownloadData downloadData;
        b bVar2;
        Context context;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        if (customResponsedMessage instanceof DownloadMessage) {
            bVar = this.dep.mSkinData;
            if (bVar != null) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= data.size()) {
                        downloadData = null;
                        break;
                    }
                    downloadData = data.get(i2);
                    bVar5 = this.dep.mSkinData;
                    if (bVar5.getId() > 0) {
                        bVar6 = this.dep.mSkinData;
                        if (String.valueOf(bVar6.getId()).equals(downloadData.getId())) {
                            break;
                        }
                    }
                    i = i2 + 1;
                }
                if (downloadData == null) {
                    return;
                }
                switch (downloadData.getStatus()) {
                    case 0:
                        this.dep.azh();
                        return;
                    case 1:
                        this.dep.e(2, ((float) downloadData.getLength()) / ((float) downloadData.getSize()));
                        bVar4 = this.dep.mSkinData;
                        bVar4.lp(2);
                        return;
                    case 2:
                        this.dep.e(1, 0.0f);
                        bVar2 = this.dep.mSkinData;
                        bVar2.lp(1);
                        context = this.dep.mContext;
                        com.baidu.adp.lib.util.k.showToast(context, i.h.tip_download_error);
                        return;
                    case 3:
                        this.dep.azh();
                        return;
                    case 4:
                        this.dep.e(3, 0.0f);
                        bVar3 = this.dep.mSkinData;
                        bVar3.lp(3);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
