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
import com.baidu.live.data.as;
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
    public String hGP;
    public boolean hGQ;
    public boolean hGR;
    public String mForumId;
    public String mForumName;
    private d ori;
    private YuyinAlaCreateLiveRoomActivity ork;
    private b orl;
    private com.baidu.tieba.yuyinala.liveroom.data.d orm;
    private d.b orn = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cli() {
            a.this.cke();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void clj() {
            a.this.hGQ = a.this.orl.chp();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hCa = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.orl.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hCb = a.this.orl.chq();
            dVar.hCe = a.this.hGQ;
            dVar.hCd = a.this.orl.chn();
            dVar.hCc = a.this.orl.chs();
            dVar.hCf = a.this.orl.cho();
            if (!dVar.hCf) {
                a.this.ork.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.orm = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.orm);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.ede();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void clm() {
            BrowserHelper.startWebActivity(a.this.ork, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a oro = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0939a orp = new a.InterfaceC0939a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0939a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                as cmn = a.this.ori.cmn();
                if (!a.this.a(cmn)) {
                    if (cmn.aPU != 1) {
                        a.this.ork.showToast(cmn.aPV);
                    } else if (cmn.mErrorCode != 0) {
                        a.this.ork.showToast(str);
                        if (cmn.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.ork.getActivity());
                        }
                    } else {
                        a.this.d(cmn);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.ork.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hJE == 1 && alaGetVerifyStrategyResponseHttpMessage.hJG == 1 && alaGetVerifyStrategyResponseHttpMessage.hJJ == 1) {
                    a.this.chv();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.ork = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.ori = dVar;
        if (this.ori == null) {
            this.ori = new com.baidu.tieba.yuyinala.liveroom.k.d(this.ork.getPageContext());
        }
        this.ori.a(this.orp);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGP = str3;
        this.hGR = false;
        if (this.orl == null) {
            this.orl = new b(this.ork.getPageContext());
            this.ork.setContentView(this.orl.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.orl.a(this.orn);
        this.orl.a(this.oro);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IB(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.orl != null) {
            this.orl.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ede() {
        this.ork.cjJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chv() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cle();
        } else if (this.orl != null) {
            this.orl.chv();
        }
    }

    private void cle() {
        if (this.orm != null) {
            this.mForumName = this.orm.forumName;
            this.mForumId = this.orm.forumId;
            this.hGQ = this.orm.hCe;
            a(this.orm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        this.ork.closeLoadingDialog();
        if (asVar.mErrorCode == 6) {
            this.ork.showToast(asVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hCa) {
            boolean z = dVar.hCb;
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
            this.ori.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hCc, "", "", dVar.hCd ? 1 : 0, 1, this.hGQ ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cke() {
        if (this.ori != null) {
            this.ori.cmg();
        }
    }

    private void IB(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.ork.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.orl != null) {
            this.orl.Io(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(as asVar) {
        if (this.ork != null && asVar != null && asVar.mLiveInfo != null && asVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.ork.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(asVar.mLiveInfo.live_id, String.valueOf(asVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.ork.cjJ();
            } catch (Throwable th) {
            }
        }
    }
}
