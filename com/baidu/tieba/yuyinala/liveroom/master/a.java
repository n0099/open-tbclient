package com.baidu.tieba.yuyinala.liveroom.master;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.data.aw;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.data.PhotoUrlData;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.live.tbadk.live.finish.FinishLiveManager;
import com.baidu.live.tbadk.location.LocationInfo;
import com.baidu.live.tbadk.location.LocationManager;
import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.tieba.yuyinala.liveroom.f.b;
import com.baidu.tieba.yuyinala.liveroom.k.a;
import com.baidu.tieba.yuyinala.liveroom.k.d;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.yuyinala.liveroom.views.d;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class a {
    public String hIp;
    public boolean hIq;
    public boolean hIr;
    public String mForumId;
    public String mForumName;
    private d oyY;
    private YuyinAlaCreateLiveRoomActivity oza;
    private b ozb;
    private com.baidu.tieba.yuyinala.liveroom.data.d ozc;
    private d.b ozd = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ciw() {
            a.this.chs();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cix() {
            a.this.hIq = a.this.ozb.ceF();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hDB = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.ozb.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hDC = a.this.ozb.ceG();
            dVar.hDF = a.this.hIq;
            dVar.hDE = a.this.ozb.ceD();
            dVar.hDD = a.this.ozb.ceI();
            dVar.hDG = a.this.ozb.ceE();
            if (!dVar.hDG) {
                a.this.oza.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.ozc = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.ozc);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.ebO();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ciA() {
            BrowserHelper.startWebActivity(a.this.oza, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a oze = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0934a ozf = new a.InterfaceC0934a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0934a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                aw cjB = a.this.oyY.cjB();
                if (!a.this.a(cjB)) {
                    if (cjB.aPD != 1) {
                        a.this.oza.showToast(cjB.aPE);
                    } else if (cjB.mErrorCode != 0) {
                        a.this.oza.showToast(str);
                        if (cjB.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.oza.getActivity());
                        }
                    } else {
                        a.this.d(cjB);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.oza.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hLh == 1 && alaGetVerifyStrategyResponseHttpMessage.hLj == 1 && alaGetVerifyStrategyResponseHttpMessage.hLm == 1) {
                    a.this.ceL();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.oza = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.oyY = dVar;
        if (this.oyY == null) {
            this.oyY = new com.baidu.tieba.yuyinala.liveroom.k.d(this.oza.getPageContext());
        }
        this.oyY.a(this.ozf);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hIp = str3;
        this.hIr = false;
        if (this.ozb == null) {
            this.ozb = new b(this.oza.getPageContext());
            this.oza.setContentView(this.ozb.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.ozb.a(this.ozd);
        this.ozb.a(this.oze);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Ie(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ozb != null) {
            this.ozb.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebO() {
        this.oza.cgX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceL() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cis();
        } else if (this.ozb != null) {
            this.ozb.ceL();
        }
    }

    private void cis() {
        if (this.ozc != null) {
            this.mForumName = this.ozc.forumName;
            this.mForumId = this.ozc.forumId;
            this.hIq = this.ozc.hDF;
            a(this.ozc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.oza.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.oza.showToast(awVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hDB) {
            boolean z = dVar.hDC;
            String str2 = null;
            String str3 = null;
            double d = 0.0d;
            double d2 = 0.0d;
            if (!z || (buildLocation = LocationManager.getInstance().buildLocation()) == null || buildLocation.getLocationInfo() == null) {
                str = null;
            } else {
                LocationInfo locationInfo = buildLocation.getLocationInfo();
                str2 = locationInfo.getCurCityName();
                if (!TextUtils.isEmpty(str2) && (md5 = Md5.toMd5("千@奇#百￥怪" + str2 + "哈哈·嘻嘻※嘿嘿")) != null) {
                    str3 = md5.toLowerCase();
                }
                d = locationInfo.latitude;
                d2 = locationInfo.longitude;
                str = str3;
            }
            this.oyY.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hDD, "", "", dVar.hDE ? 1 : 0, 1, this.hIq ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chs() {
        if (this.oyY != null) {
            this.oyY.cju();
        }
    }

    private void Ie(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.oza.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String P(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("album_result");
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (stringExtra != null) {
            writeImagesInfo.parseJson(stringExtra);
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (ListUtils.isEmpty(chosedFiles) || chosedFiles.get(0) == null) {
                return null;
            }
            return chosedFiles.get(0).getFilePath();
        }
        return null;
    }

    private void Q(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ozb != null) {
            this.ozb.HR(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(aw awVar) {
        if (this.oza != null && awVar != null && awVar.mLiveInfo != null && awVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oza.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(awVar.mLiveInfo.live_id, String.valueOf(awVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oza.cgX();
            } catch (Throwable th) {
            }
        }
    }
}
