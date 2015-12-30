package com.baidu.tieba.themeCenter;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ SkinProgressView dLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SkinProgressView skinProgressView, int i) {
        super(i);
        this.dLG = skinProgressView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        b bVar;
        DownloadData downloadData;
        b bVar2;
        b bVar3;
        Context context;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        if (customResponsedMessage instanceof DownloadMessage) {
            bVar = this.dLG.mSkinData;
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
                    bVar7 = this.dLG.mSkinData;
                    if (bVar7.getId() > 0) {
                        bVar8 = this.dLG.mSkinData;
                        if (String.valueOf(bVar8.getId()).equals(downloadData.getId())) {
                            break;
                        }
                    }
                    i = i2 + 1;
                }
                if (downloadData != null) {
                    switch (downloadData.getStatus()) {
                        case 0:
                            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                            bVar6 = this.dLG.mSkinData;
                            m411getInst.deleteThemeFromWaitDownloadQuene(bVar6.getId());
                            this.dLG.aHz();
                            return;
                        case 1:
                            this.dLG.e(2, ((float) downloadData.getLength()) / ((float) downloadData.getSize()));
                            bVar5 = this.dLG.mSkinData;
                            bVar5.nr(2);
                            return;
                        case 2:
                            TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                            bVar2 = this.dLG.mSkinData;
                            m411getInst2.deleteThemeFromWaitDownloadQuene(bVar2.getId());
                            this.dLG.e(1, 0.0f);
                            bVar3 = this.dLG.mSkinData;
                            bVar3.nr(1);
                            context = this.dLG.mContext;
                            com.baidu.adp.lib.util.k.showToast(context, n.j.tip_download_error);
                            return;
                        case 3:
                            this.dLG.aHz();
                            return;
                        case 4:
                            this.dLG.e(3, 0.0f);
                            bVar4 = this.dLG.mSkinData;
                            bVar4.nr(3);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
