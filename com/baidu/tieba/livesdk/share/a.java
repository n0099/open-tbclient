package com.baidu.tieba.livesdk.share;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.sdk.a.f;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes6.dex */
public class a implements IShareChannel, f {
    @Override // com.baidu.tieba.sdk.a.f
    public void e(ShareEntity shareEntity) {
        e f;
        if (shareEntity != null && (f = f(shareEntity)) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), f, 0, 1)));
        }
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannel
    public void shareToSinaWeibo(ShareEntity shareEntity, IShareCallback iShareCallback) {
        a(6, shareEntity, iShareCallback);
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannel
    public void shareToWeixin(ShareEntity shareEntity, IShareCallback iShareCallback) {
        a(3, shareEntity, iShareCallback);
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannel
    public void shareToWeixinCircle(ShareEntity shareEntity, IShareCallback iShareCallback) {
        a(2, shareEntity, iShareCallback);
    }

    @Override // com.baidu.live.tbadk.share.single.interfaces.IShareChannel
    public void shareToQQ(ShareEntity shareEntity, IShareCallback iShareCallback) {
        a(8, shareEntity, iShareCallback);
    }

    private void a(int i, ShareEntity shareEntity, IShareCallback iShareCallback) {
        if (shareEntity != null) {
            if (!vv(i)) {
                if (iShareCallback != null) {
                    iShareCallback.onShare(0, 0, "");
                    return;
                }
                return;
            }
            e f = f(shareEntity);
            if (f != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), f, i, 2)));
            }
        }
    }

    private boolean vv(int i) {
        boolean z = false;
        switch (i) {
            case 2:
            case 3:
                z = w.isInstalledPackage(TbadkCoreApplication.getInst(), "com.tencent.mm");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(b.a.share_weixin_not_installed_yet));
                    break;
                }
                break;
            case 6:
                z = w.isInstalledPackage(TbadkCoreApplication.getInst(), "com.sina.weibo");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(b.a.share_weibo_not_installed_yet));
                    break;
                }
                break;
            case 8:
                z = w.isInstalledPackage(TbadkCoreApplication.getInst(), "com.tencent.mobileqq");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(b.a.share_qq_not_installed_yet));
                    break;
                }
                break;
        }
        return z;
    }

    private e f(ShareEntity shareEntity) {
        if (shareEntity == null) {
            return null;
        }
        e eVar = new e();
        eVar.title = shareEntity.title;
        eVar.content = shareEntity.content;
        eVar.imageUrl = shareEntity.imageUrl;
        eVar.linkUrl = shareEntity.linkUrl;
        return eVar;
    }
}
