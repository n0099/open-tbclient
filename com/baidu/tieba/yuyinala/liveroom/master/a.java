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
    private d orj;
    private YuyinAlaCreateLiveRoomActivity orl;
    private b orm;
    private com.baidu.tieba.yuyinala.liveroom.data.d orn;
    private d.b oro = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void clh() {
            a.this.ckd();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cli() {
            a.this.hGQ = a.this.orm.cho();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hCa = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.orm.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hCb = a.this.orm.chp();
            dVar.hCe = a.this.hGQ;
            dVar.hCd = a.this.orm.chm();
            dVar.hCc = a.this.orm.chr();
            dVar.hCf = a.this.orm.chn();
            if (!dVar.hCf) {
                a.this.orl.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.orn = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.orn);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.edd();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cll() {
            BrowserHelper.startWebActivity(a.this.orl, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a orp = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0901a orq = new a.InterfaceC0901a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0901a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                as cmm = a.this.orj.cmm();
                if (!a.this.a(cmm)) {
                    if (cmm.aPU != 1) {
                        a.this.orl.showToast(cmm.aPV);
                    } else if (cmm.mErrorCode != 0) {
                        a.this.orl.showToast(str);
                        if (cmm.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.orl.getActivity());
                        }
                    } else {
                        a.this.d(cmm);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.orl.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hJE == 1 && alaGetVerifyStrategyResponseHttpMessage.hJG == 1 && alaGetVerifyStrategyResponseHttpMessage.hJJ == 1) {
                    a.this.chu();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.orl = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.orj = dVar;
        if (this.orj == null) {
            this.orj = new com.baidu.tieba.yuyinala.liveroom.k.d(this.orl.getPageContext());
        }
        this.orj.a(this.orq);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGP = str3;
        this.hGR = false;
        if (this.orm == null) {
            this.orm = new b(this.orl.getPageContext());
            this.orl.setContentView(this.orm.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.orm.a(this.oro);
        this.orm.a(this.orp);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            IC(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.orm != null) {
            this.orm.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edd() {
        this.orl.cjI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chu() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cld();
        } else if (this.orm != null) {
            this.orm.chu();
        }
    }

    private void cld() {
        if (this.orn != null) {
            this.mForumName = this.orn.forumName;
            this.mForumId = this.orn.forumId;
            this.hGQ = this.orn.hCe;
            a(this.orn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        this.orl.closeLoadingDialog();
        if (asVar.mErrorCode == 6) {
            this.orl.showToast(asVar.mErrorMsg);
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
            this.orj.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hCc, "", "", dVar.hCd ? 1 : 0, 1, this.hGQ ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckd() {
        if (this.orj != null) {
            this.orj.cmf();
        }
    }

    private void IC(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.orl.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.orm != null) {
            this.orm.Ip(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(as asVar) {
        if (this.orl != null && asVar != null && asVar.mLiveInfo != null && asVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.orl.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(asVar.mLiveInfo.live_id, String.valueOf(asVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.orl.cjI();
            } catch (Throwable th) {
            }
        }
    }
}
