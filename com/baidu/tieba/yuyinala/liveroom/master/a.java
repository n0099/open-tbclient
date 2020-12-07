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
import com.baidu.live.data.aq;
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
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    public String huR;
    public boolean huS;
    public boolean huT;
    public String mForumId;
    public String mForumName;
    private d onR;
    private YuyinAlaCreateLiveRoomActivity onT;
    private b onU;
    private com.baidu.tieba.yuyinala.liveroom.data.d onV;
    private d.b onW = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cit() {
            a.this.cho();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ciu() {
            a.this.huS = a.this.onU.cex();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hqc = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.onU.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hqd = a.this.onU.cey();
            dVar.hqg = a.this.huS;
            dVar.hqf = a.this.onU.cev();
            dVar.hqe = a.this.onU.ceA();
            dVar.hqh = a.this.onU.cew();
            if (!dVar.hqh) {
                a.this.onT.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.onV = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.onV);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.edL();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cix() {
            BrowserHelper.startWebActivity(a.this.onT, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a onX = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0926a onY = new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0926a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                aq cjz = a.this.onR.cjz();
                if (!a.this.a(cjz)) {
                    if (cjz.aPf != 1) {
                        a.this.onT.showToast(cjz.aPg);
                    } else if (cjz.mErrorCode != 0) {
                        a.this.onT.showToast(str);
                        if (cjz.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.onT.getActivity());
                        }
                    } else {
                        a.this.d(cjz);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.onT.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hxE == 1 && alaGetVerifyStrategyResponseHttpMessage.hxG == 1 && alaGetVerifyStrategyResponseHttpMessage.hxJ == 1) {
                    a.this.ceD();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.onT = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.i.d dVar) {
        this.onR = dVar;
        if (this.onR == null) {
            this.onR = new com.baidu.tieba.yuyinala.liveroom.i.d(this.onT.getPageContext());
        }
        this.onR.a(this.onY);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.huR = str3;
        this.huT = false;
        if (this.onU == null) {
            this.onU = new b(this.onT.getPageContext());
            this.onT.setContentView(this.onU.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.onU.a(this.onW);
        this.onU.a(this.onX);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IA(O(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.onU != null) {
            this.onU.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edL() {
        this.onT.cgT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceD() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cip();
        } else if (this.onU != null) {
            this.onU.ceD();
        }
    }

    private void cip() {
        if (this.onV != null) {
            this.mForumName = this.onV.forumName;
            this.mForumId = this.onV.forumId;
            this.huS = this.onV.hqg;
            a(this.onV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aq aqVar) {
        if (aqVar == null) {
            return false;
        }
        this.onT.closeLoadingDialog();
        if (aqVar.mErrorCode == 6) {
            this.onT.showToast(aqVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hqc) {
            boolean z = dVar.hqd;
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
            this.onR.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hqe, "", "", dVar.hqf ? 1 : 0, 1, this.huS ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        if (this.onR != null) {
            this.onR.cjs();
        }
    }

    private void IA(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.onT.getActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.onU != null) {
            this.onU.In(fromJson.getSmallurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(aq aqVar) {
        if (this.onT != null && aqVar != null && aqVar.mLiveInfo != null && aqVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.onT.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(aqVar.mLiveInfo.live_id, String.valueOf(aqVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.onT.cgT();
            } catch (Throwable th) {
            }
        }
    }
}
