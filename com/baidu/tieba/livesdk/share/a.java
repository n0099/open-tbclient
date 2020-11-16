package com.baidu.tieba.livesdk.share;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.livesdk.c;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes4.dex */
public class a implements IShareChannel, e {
    @Override // com.baidu.tieba.sdk.b.e
    public boolean das() {
        return true;
    }

    @Override // com.baidu.tieba.sdk.b.e
    public void a(Activity activity, ShareEntity shareEntity) {
        if (shareEntity != null) {
            ShareItem e = e(shareEntity);
            Context context = activity;
            if (e != null) {
                if (activity == null) {
                    context = TbadkCoreApplication.getInst();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaSDKShareEmptyActivityConfig(context, e, 0, 1)));
            }
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
            if (!EO(i)) {
                if (iShareCallback != null) {
                    iShareCallback.onShare(0, 0, "");
                    return;
                }
                return;
            }
            ShareItem e = e(shareEntity);
            if (e != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), e, i, 2)));
            }
        }
    }

    private boolean EO(int i) {
        boolean z = false;
        switch (i) {
            case 2:
            case 3:
                z = y.isInstalledPackage(TbadkCoreApplication.getInst(), "com.tencent.mm");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(c.b.share_weixin_not_installed_yet));
                    break;
                }
                break;
            case 6:
                z = y.isInstalledPackage(TbadkCoreApplication.getInst(), "com.sina.weibo");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(c.b.share_weibo_not_installed_yet));
                    break;
                }
                break;
            case 8:
                z = y.isInstalledPackage(TbadkCoreApplication.getInst(), "com.tencent.mobileqq");
                if (!z) {
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(c.b.share_qq_not_installed_yet));
                    break;
                }
                break;
        }
        return z;
    }

    private ShareItem e(ShareEntity shareEntity) {
        if (shareEntity == null) {
            return null;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.title = shareEntity.title;
        shareItem.content = shareEntity.content;
        shareItem.imageUrl = shareEntity.imageUrl;
        shareItem.linkUrl = shareEntity.linkUrl;
        shareItem.extData = String.valueOf(shareEntity.liveId);
        shareItem.extLiveInfo = String.valueOf(shareEntity.userId);
        return shareItem;
    }
}
