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
    public String hlL;
    public boolean hlM;
    public boolean hlN;
    public String mForumId;
    public String mForumName;
    private d nXo;
    private YuyinAlaCreateLiveRoomActivity nXq;
    private b nXr;
    private com.baidu.tieba.yuyinala.liveroom.data.d nXs;
    private d.b nXt = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cff() {
            a.this.ced();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cfg() {
            a.this.hlM = a.this.nXr.cbj();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hgO = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.nXr.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hgP = a.this.nXr.cbk();
            dVar.hgS = a.this.hlM;
            dVar.hgR = a.this.nXr.cbh();
            dVar.hgQ = a.this.nXr.cbm();
            dVar.hgT = a.this.nXr.cbi();
            if (!dVar.hgT) {
                a.this.nXq.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.nXs = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.nXs);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.dYi();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cfj() {
            BrowserHelper.startWebActivity(a.this.nXq, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a nXu = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0906a nXv = new a.InterfaceC0906a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0906a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                ap cgm = a.this.nXo.cgm();
                if (!a.this.a(cgm)) {
                    if (cgm.aNT != 1) {
                        a.this.nXq.showToast(cgm.aNU);
                    } else if (cgm.mErrorCode != 0) {
                        a.this.nXq.showToast(str);
                        if (cgm.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.nXq.getActivity());
                        }
                    } else {
                        a.this.d(cgm);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.nXq.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hot == 1 && alaGetVerifyStrategyResponseHttpMessage.hov == 1 && alaGetVerifyStrategyResponseHttpMessage.hoy == 1) {
                    a.this.cbp();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.nXq = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.i.d dVar) {
        this.nXo = dVar;
        if (this.nXo == null) {
            this.nXo = new com.baidu.tieba.yuyinala.liveroom.i.d(this.nXq.getPageContext());
        }
        this.nXo.a(this.nXv);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hlL = str3;
        this.hlN = false;
        if (this.nXr == null) {
            this.nXr = new b(this.nXq.getPageContext());
            this.nXq.setContentView(this.nXr.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.nXr.a(this.nXt);
        this.nXr.a(this.nXu);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i);
        if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Ik(O(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nXr != null) {
            this.nXr.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYi() {
        this.nXq.cdI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cfc();
        } else if (this.nXr != null) {
            this.nXr.cbp();
        }
    }

    private void cfc() {
        if (this.nXs != null) {
            this.mForumName = this.nXs.forumName;
            this.mForumId = this.nXs.forumId;
            this.hlM = this.nXs.hgS;
            a(this.nXs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ap apVar) {
        if (apVar == null) {
            return false;
        }
        this.nXq.closeLoadingDialog();
        if (apVar.mErrorCode == 6) {
            this.nXq.showToast(apVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hgO) {
            boolean z = dVar.hgP;
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
            this.nXo.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hgQ, "", "", dVar.hgR ? 1 : 0, 1, this.hlM ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ced() {
        if (this.nXo != null) {
            this.nXo.cgf();
        }
    }

    private void Ik(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.nXq.getActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nXr != null) {
            this.nXr.HX(fromJson.getSmallurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ap apVar) {
        if (this.nXq != null && apVar != null && apVar.mLiveInfo != null && apVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.nXq.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(apVar.mLiveInfo.live_id, String.valueOf(apVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.nXq.cdI();
            } catch (Throwable th) {
            }
        }
    }
}
