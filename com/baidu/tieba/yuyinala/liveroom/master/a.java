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
/* loaded from: classes10.dex */
public class a {
    public String hCj;
    public boolean hCk;
    public boolean hCl;
    public String mForumId;
    public String mForumName;
    private d omB;
    private YuyinAlaCreateLiveRoomActivity omD;
    private b omE;
    private com.baidu.tieba.yuyinala.liveroom.data.d omF;
    private d.b omG = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void chq() {
            a.this.cgm();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void chr() {
            a.this.hCk = a.this.omE.cdx();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.hxu = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.omE.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hxv = a.this.omE.cdy();
            dVar.hxy = a.this.hCk;
            dVar.hxx = a.this.omE.cdv();
            dVar.hxw = a.this.omE.cdA();
            dVar.hxz = a.this.omE.cdw();
            if (!dVar.hxz) {
                a.this.omD.showToast(a.h.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.omF = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.omF);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.dZm();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void chu() {
            BrowserHelper.startWebActivity(a.this.omD, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a omH = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0922a omI = new a.InterfaceC0922a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0922a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                as civ = a.this.omB.civ();
                if (!a.this.a(civ)) {
                    if (civ.aLh != 1) {
                        a.this.omD.showToast(civ.aLi);
                    } else if (civ.mErrorCode != 0) {
                        a.this.omD.showToast(str);
                        if (civ.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.omD.getActivity());
                        }
                    } else {
                        a.this.d(civ);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.omD.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hEY == 1 && alaGetVerifyStrategyResponseHttpMessage.hFa == 1 && alaGetVerifyStrategyResponseHttpMessage.hFd == 1) {
                    a.this.cdD();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.omD = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.k.d dVar) {
        this.omB = dVar;
        if (this.omB == null) {
            this.omB = new com.baidu.tieba.yuyinala.liveroom.k.d(this.omD.getPageContext());
        }
        this.omB.a(this.omI);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hCj = str3;
        this.hCl = false;
        if (this.omE == null) {
            this.omE = new b(this.omD.getPageContext());
            this.omD.setContentView(this.omE.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.omE.a(this.omG);
        this.omE.a(this.omH);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + "," + i);
        if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            Hq(P(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.omE != null) {
            this.omE.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZm() {
        this.omD.cfR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdD() {
        if (TbadkCoreApplication.getInst().isOther()) {
            chm();
        } else if (this.omE != null) {
            this.omE.cdD();
        }
    }

    private void chm() {
        if (this.omF != null) {
            this.mForumName = this.omF.forumName;
            this.mForumId = this.omF.forumId;
            this.hCk = this.omF.hxy;
            a(this.omF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        this.omD.closeLoadingDialog();
        if (asVar.mErrorCode == 6) {
            this.omD.showToast(asVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.hxu) {
            boolean z = dVar.hxv;
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
            this.omB.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.hxw, "", "", dVar.hxx ? 1 : 0, 1, this.hCk ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (this.omB != null) {
            this.omB.cio();
        }
    }

    private void Hq(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.omD.getActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.omE != null) {
            this.omE.Hd(fromJson.getBigurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(as asVar) {
        if (this.omD != null && asVar != null && asVar.mLiveInfo != null && asVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.omD.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(asVar.mLiveInfo.live_id, String.valueOf(asVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.omD.cfR();
            } catch (Throwable th) {
            }
        }
    }
}
