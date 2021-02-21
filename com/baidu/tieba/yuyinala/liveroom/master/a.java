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
/* loaded from: classes11.dex */
public class a {
    public String hGG;
    public boolean hGH;
    public boolean hGI;
    public String mForumId;
    public String mForumName;
    private d owT;
    private YuyinAlaCreateLiveRoomActivity owV;
    private b owW;
    private com.baidu.tieba.yuyinala.liveroom.data.d owX;
    private d.b owY = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ciq() {
            a.this.chm();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cir() {
            a.this.hGH = a.this.owW.cez();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hBS = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.owW.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hBT = a.this.owW.ceA();
            dVar.hBW = a.this.hGH;
            dVar.hBV = a.this.owW.cex();
            dVar.hBU = a.this.owW.ceC();
            dVar.hBX = a.this.owW.cey();
            if (!dVar.hBX) {
                a.this.owV.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.owX = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.owX);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.ebG();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ciu() {
            BrowserHelper.startWebActivity(a.this.owV, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a owZ = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0928a oxa = new a.InterfaceC0928a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0928a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                aw cjv = a.this.owT.cjv();
                if (!a.this.a(cjv)) {
                    if (cjv.aOd != 1) {
                        a.this.owV.showToast(cjv.aOe);
                    } else if (cjv.mErrorCode != 0) {
                        a.this.owV.showToast(str);
                        if (cjv.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.owV.getActivity());
                        }
                    } else {
                        a.this.d(cjv);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.owV.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hJy == 1 && alaGetVerifyStrategyResponseHttpMessage.hJA == 1 && alaGetVerifyStrategyResponseHttpMessage.hJD == 1) {
                    a.this.ceF();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.owV = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.owT = dVar;
        if (this.owT == null) {
            this.owT = new com.baidu.tieba.yuyinala.liveroom.k.d(this.owV.getPageContext());
        }
        this.owT.a(this.oxa);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGG = str3;
        this.hGI = false;
        if (this.owW == null) {
            this.owW = new b(this.owV.getPageContext());
            this.owV.setContentView(this.owW.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.owW.a(this.owY);
        this.owW.a(this.owZ);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HV(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.owW != null) {
            this.owW.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebG() {
        this.owV.cgR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceF() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cim();
        } else if (this.owW != null) {
            this.owW.ceF();
        }
    }

    private void cim() {
        if (this.owX != null) {
            this.mForumName = this.owX.forumName;
            this.mForumId = this.owX.forumId;
            this.hGH = this.owX.hBW;
            a(this.owX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.owV.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.owV.showToast(awVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hBS) {
            boolean z = dVar.hBT;
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
            this.owT.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hBU, "", "", dVar.hBV ? 1 : 0, 1, this.hGH ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chm() {
        if (this.owT != null) {
            this.owT.cjo();
        }
    }

    private void HV(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.owV.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.owW != null) {
            this.owW.HI(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(aw awVar) {
        if (this.owV != null && awVar != null && awVar.mLiveInfo != null && awVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.owV.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(awVar.mLiveInfo.live_id, String.valueOf(awVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.owV.cgR();
            } catch (Throwable th) {
            }
        }
    }
}
