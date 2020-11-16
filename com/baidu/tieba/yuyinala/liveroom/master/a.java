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
import com.baidu.live.data.ap;
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
import com.baidu.tieba.yuyinala.liveroom.i.a;
import com.baidu.tieba.yuyinala.liveroom.i.d;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.yuyinala.liveroom.views.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    public String hls;
    public boolean hlt;
    public boolean hlu;
    public String mForumId;
    public String mForumName;
    private d nYR;
    private YuyinAlaCreateLiveRoomActivity nYT;
    private b nYU;
    private com.baidu.tieba.yuyinala.liveroom.data.d nYV;
    private d.b nYW = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cey() {
            a.this.cdw();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cez() {
            a.this.hlt = a.this.nYU.caC();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hgv = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.nYU.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hgw = a.this.nYU.caD();
            dVar.hgz = a.this.hlt;
            dVar.hgy = a.this.nYU.caA();
            dVar.hgx = a.this.nYU.caF();
            dVar.hgA = a.this.nYU.caB();
            if (!dVar.hgA) {
                a.this.nYT.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.nYV = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.nYV);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.dYh();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ceC() {
            BrowserHelper.startWebActivity(a.this.nYT, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a nYX = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0909a nYY = new a.InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0909a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                ap cfF = a.this.nYR.cfF();
                if (!a.this.a(cfF)) {
                    if (cfF.aMi != 1) {
                        a.this.nYT.showToast(cfF.aMj);
                    } else if (cfF.mErrorCode != 0) {
                        a.this.nYT.showToast(str);
                        if (cfF.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.nYT.getActivity());
                        }
                    } else {
                        a.this.d(cfF);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.nYT.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hoa == 1 && alaGetVerifyStrategyResponseHttpMessage.hoc == 1 && alaGetVerifyStrategyResponseHttpMessage.hof == 1) {
                    a.this.caI();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.nYT = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.i.d dVar) {
        this.nYR = dVar;
        if (this.nYR == null) {
            this.nYR = new com.baidu.tieba.yuyinala.liveroom.i.d(this.nYT.getPageContext());
        }
        this.nYR.a(this.nYY);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hls = str3;
        this.hlu = false;
        if (this.nYU == null) {
            this.nYU = new b(this.nYT.getPageContext());
            this.nYT.setContentView(this.nYU.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.nYU.a(this.nYW);
        this.nYU.a(this.nYX);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i);
        if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HL(O(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nYU != null) {
            this.nYU.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYh() {
        this.nYT.cdb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cev();
        } else if (this.nYU != null) {
            this.nYU.caI();
        }
    }

    private void cev() {
        if (this.nYV != null) {
            this.mForumName = this.nYV.forumName;
            this.mForumId = this.nYV.forumId;
            this.hlt = this.nYV.hgz;
            a(this.nYV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ap apVar) {
        if (apVar == null) {
            return false;
        }
        this.nYT.closeLoadingDialog();
        if (apVar.mErrorCode == 6) {
            this.nYT.showToast(apVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hgv) {
            boolean z = dVar.hgw;
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
            this.nYR.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hgx, "", "", dVar.hgy ? 1 : 0, 1, this.hlt ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdw() {
        if (this.nYR != null) {
            this.nYR.cfy();
        }
    }

    private void HL(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.nYT.getActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String O(Intent intent) {
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

    private void P(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nYU != null) {
            this.nYU.Hy(fromJson.getSmallurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ap apVar) {
        if (this.nYT != null && apVar != null && apVar.mLiveInfo != null && apVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.nYT.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(apVar.mLiveInfo.live_id, String.valueOf(apVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.nYT.cdb();
            } catch (Throwable th) {
            }
        }
    }
}
