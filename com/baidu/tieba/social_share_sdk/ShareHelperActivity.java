package com.baidu.tieba.social_share_sdk;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.tbadk.core.log.b;
import com.baidu.tieba.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareHelperActivity extends Activity {
    private int stateChangeCount = 0;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.share_helper_activity_layout);
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.social_share_sdk.ShareHelperActivity.1
            @Override // java.lang.Runnable
            public void run() {
                ShareHelperActivity.this.doShare();
            }
        }, 100L);
    }

    public void doShare() {
        try {
            ShareInfoData shareInfoData = (ShareInfoData) getIntent().getParcelableExtra("shareInfo");
            if (shareInfoData == null) {
                finish();
                return;
            }
            ShareContent shareContent = new ShareContent();
            shareContent.setTitle(shareInfoData.getTitle());
            shareContent.setContent(shareInfoData.getContent());
            shareContent.setLinkUrl(shareInfoData.getLinkUrl());
            shareContent.setImageUri(shareInfoData.getImageUri());
            shareContent.setLocation(shareInfoData.getLocation());
            String shareTo = shareInfoData.getShareTo();
            SocialShare.getInstance(this).setParentView(getWindow().getDecorView());
            SocialShare.getInstance(this).share(shareContent, shareTo, new IBaiduListener() { // from class: com.baidu.tieba.social_share_sdk.ShareHelperActivity.2
                @Override // com.baidu.cloudsdk.IBaiduListener
                public void onCancel() {
                    ShareHelperActivity.this.finish();
                }

                @Override // com.baidu.cloudsdk.IBaiduListener
                public void onComplete() {
                    k.showToast(ShareHelperActivity.this, i.h.share_alert_success);
                    ShareHelperActivity.this.finish();
                }

                @Override // com.baidu.cloudsdk.IBaiduListener
                public void onComplete(JSONObject jSONObject) {
                    k.showToast(ShareHelperActivity.this, i.h.share_alert_success);
                    ShareHelperActivity.this.finish();
                }

                @Override // com.baidu.cloudsdk.IBaiduListener
                public void onComplete(JSONArray jSONArray) {
                    k.showToast(ShareHelperActivity.this, i.h.share_alert_success);
                    ShareHelperActivity.this.finish();
                }

                @Override // com.baidu.cloudsdk.IBaiduListener
                public void onError(BaiduException baiduException) {
                    if (baiduException != null) {
                        b.a("socail_share", -1L, 0, "socail_share_fail", 123456, "", "share_fail_exception", baiduException.toString());
                    }
                    k.showToast(ShareHelperActivity.this, i.h.share_alert_fail);
                    ShareHelperActivity.this.finish();
                }
            }, true);
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.stateChangeCount++;
        }
        if (this.stateChangeCount == 2) {
            finish();
        }
    }
}
