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
import com.baidu.live.data.ao;
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
    public String hfQ;
    public boolean hfR;
    public boolean hfS;
    public String mForumId;
    public String mForumName;
    private d nQf;
    private YuyinAlaCreateLiveRoomActivity nQh;
    private b nQi;
    private com.baidu.tieba.yuyinala.liveroom.data.d nQj;
    private d.b nQk = new d.b() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.1
        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ccE() {
            a.this.cbE();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ccF() {
            a.this.hfR = a.this.nQi.bYH();
            com.baidu.tieba.yuyinala.liveroom.data.d dVar = new com.baidu.tieba.yuyinala.liveroom.data.d();
            dVar.haU = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.title = a.this.nQi.getLiveTitle().trim();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.haV = a.this.nQi.bYI();
            dVar.haY = a.this.hfR;
            dVar.haX = a.this.nQi.bYF();
            dVar.haW = a.this.nQi.bYK();
            dVar.haZ = a.this.nQi.bYG();
            if (!dVar.haZ) {
                a.this.nQh.showToast(a.i.yuyin_ala_live_not_agree_licence_toast);
                return;
            }
            a.this.nQj = dVar;
            if (FinishLiveManager.getInstance().getFinishListener() != null) {
                FinishLiveManager.getInstance().getFinishListener().onStartLive();
            }
            a.this.a(a.this.nQj);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void onCloseClicked() {
            a.this.dVt();
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.views.d.b
        public void ccI() {
            BrowserHelper.startWebActivity(a.this.nQh, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }
    };
    private d.a nQl = new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.2
    };
    private a.InterfaceC0890a nQm = new a.InterfaceC0890a() { // from class: com.baidu.tieba.yuyinala.liveroom.master.a.3
        @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0890a
        public void a(int i, String str, int i2, Object obj) {
            if (i2 == 6) {
                ao cdL = a.this.nQf.cdL();
                if (!a.this.a(cdL)) {
                    if (cdL.aMR != 1) {
                        a.this.nQh.showToast(cdL.aMS);
                    } else if (cdL.mErrorCode != 0) {
                        a.this.nQh.showToast(str);
                        if (cdL.mErrorCode == 110000) {
                            ViewHelper.skipToLoginActivity(a.this.nQh.getActivity());
                        }
                    } else {
                        a.this.d(cdL);
                    }
                }
            } else if (i2 == 7 && (obj instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) obj;
                if (alaGetVerifyStrategyResponseHttpMessage.getError() != 0) {
                    BdUtilHelper.showToast(a.this.nQh.getActivity(), alaGetVerifyStrategyResponseHttpMessage.getErrorString());
                } else if (alaGetVerifyStrategyResponseHttpMessage.hiC == 1 && alaGetVerifyStrategyResponseHttpMessage.hiE == 1 && alaGetVerifyStrategyResponseHttpMessage.hiH == 1) {
                    a.this.bYN();
                }
            }
        }
    };

    public a(YuyinAlaCreateLiveRoomActivity yuyinAlaCreateLiveRoomActivity) {
        this.nQh = yuyinAlaCreateLiveRoomActivity;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.i.d dVar) {
        this.nQf = dVar;
        if (this.nQf == null) {
            this.nQf = new com.baidu.tieba.yuyinala.liveroom.i.d(this.nQh.getPageContext());
        }
        this.nQf.a(this.nQm);
    }

    public void a(String str, String str2, String str3, Bundle bundle) {
        this.mForumName = str;
        this.mForumId = str2;
        this.hfQ = str3;
        this.hfS = false;
        if (this.nQi == null) {
            this.nQi = new b(this.nQh.getPageContext());
            this.nQh.setContentView(this.nQi.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.nQi.a(this.nQk);
        this.nQi.a(this.nQl);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("CreateAudioRoom", "YuyinAlaCreateLiveRoomController:onActivityResult:" + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i);
        if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 12001 && i2 == -1) {
            HT(O(intent));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.nQi != null) {
            this.nQi.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVt() {
        this.nQh.cbh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYN() {
        if (TbadkCoreApplication.getInst().isOther()) {
            ccB();
        } else if (this.nQi != null) {
            this.nQi.bYN();
        }
    }

    private void ccB() {
        if (this.nQj != null) {
            this.mForumName = this.nQj.forumName;
            this.mForumId = this.nQj.forumId;
            this.hfR = this.nQj.haY;
            a(this.nQj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ao aoVar) {
        if (aoVar == null) {
            return false;
        }
        this.nQh.closeLoadingDialog();
        if (aoVar.mErrorCode == 6) {
            this.nQh.showToast(aoVar.mErrorMsg);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.liveroom.data.d dVar) {
        String str;
        ILocation buildLocation;
        String md5;
        if (dVar != null && !dVar.haU) {
            boolean z = dVar.haV;
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
            this.nQf.b(dVar.forumName, dVar.forumId, dVar.title, z ? 2 : 1, d, d2, str2, str, 1, dVar.haW, "", "", dVar.haX ? 1 : 0, 1, this.hfR ? 2 : 1, 1, dVar.gameId, dVar.gameName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        if (this.nQf != null) {
            this.nQf.cdE();
        }
    }

    private void HT(String str) {
        Log.i("CreateAudioRoom", "editLiveCoverFromCamera:" + str);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            Log.i("CreateAudioRoom", "editLiveCoverFromCamera1:" + str);
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this.nQh.getActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.nQi != null) {
            this.nQi.HF(fromJson.getSmallurl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ao aoVar) {
        if (this.nQh != null && aoVar != null && aoVar.mLiveInfo != null && aoVar.mLiveInfo.live_id != 0) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.nQh.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(aoVar.mLiveInfo.live_id, String.valueOf(aoVar.mLiveInfo.room_id), "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.nQh.cbh();
            } catch (Throwable th) {
            }
        }
    }
}
