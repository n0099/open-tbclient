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
    public String hGs;
    public boolean hGt;
    public boolean hGu;
    public String mForumId;
    public String mForumName;
    private d owt;
    private YuyinAlaCreateLiveRoomActivity owv;
    private b oww;
    private com.baidu.tieba.yuyinala.liveroom.data.d owx;
    private d.b owy = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cij() {
            a.this.chf();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cik() {
            a.this.hGt = a.this.oww.ces();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hBE = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.oww.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hBF = a.this.oww.cet();
            dVar.hBI = a.this.hGt;
            dVar.hBH = a.this.oww.ceq();
            dVar.hBG = a.this.oww.cev();
            dVar.hBJ = a.this.oww.cer();
            if (!dVar.hBJ) {
                a.this.owv.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.owx = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.owx);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.eby();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void cin() {
            BrowserHelper.startWebActivity(a.this.owv, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a owz = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0926a owA = new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0926a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                aw cjo = a.this.owt.cjo();
                if (!a.this.a(cjo)) {
                    if (cjo.aOd != 1) {
                        a.this.owv.showToast(cjo.aOe);
                    } else if (cjo.mErrorCode != 0) {
                        a.this.owv.showToast(str);
                        if (cjo.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.owv.getActivity());
                        }
                    } else {
                        a.this.d(cjo);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.owv.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hJk == 1 && alaGetVerifyStrategyResponseHttpMessage.hJm == 1 && alaGetVerifyStrategyResponseHttpMessage.hJp == 1) {
                    a.this.cey();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.owv = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.owt = dVar;
        if (this.owt == null) {
            this.owt = new com.baidu.tieba.yuyinala.liveroom.k.d(this.owv.getPageContext());
        }
        this.owt.a(this.owA);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hGs = str3;
        this.hGu = false;
        if (this.oww == null) {
            this.oww = new b(this.owv.getPageContext());
            this.owv.setContentView(this.oww.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.oww.a(this.owy);
        this.oww.a(this.owz);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HU(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.oww != null) {
            this.oww.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eby() {
        this.owv.cgK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cey() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cif();
        } else if (this.oww != null) {
            this.oww.cey();
        }
    }

    private void cif() {
        if (this.owx != null) {
            this.mForumName = this.owx.forumName;
            this.mForumId = this.owx.forumId;
            this.hGt = this.owx.hBI;
            a(this.owx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(aw awVar) {
        if (awVar == null) {
            return false;
        }
        this.owv.closeLoadingDialog();
        if (awVar.mErrorCode == 6) {
            this.owv.showToast(awVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hBE) {
            boolean z = dVar.hBF;
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
            this.owt.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hBG, "", "", dVar.hBH ? 1 : 0, 1, this.hGt ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        if (this.owt != null) {
            this.owt.cjh();
        }
    }

    private void HU(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.owv.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.oww != null) {
            this.oww.HH(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(aw awVar) {
        if (this.owv != null && awVar != null && awVar.mLiveInfo != null && awVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.owv.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(awVar.mLiveInfo.live_id, String.valueOf(awVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.owv.cgK();
            } catch (Throwable th) {
            }
        }
    }
}
