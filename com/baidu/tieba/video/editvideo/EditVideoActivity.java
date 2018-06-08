package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.b.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean Aa;
    private String blw;
    private String cBu;
    private com.baidu.tbadk.core.view.a dCl;
    private h gJZ;
    private String gXR;
    private List<VideoTitleData> gXS;
    private com.baidu.tieba.video.editvideo.view.a gXT;
    private SelectCoverModel gXU;
    private SelectMusicModel gXV;
    private String gXW;
    private String gXX;
    private boolean gXY;
    private com.baidu.tieba.video.editvideo.b.a gXZ;
    private String gYa;
    private HttpMessageListener gYb;
    private CustomMessageListener gYc;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.gYb = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gXS = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gYc = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    EditVideoActivity.this.finishPage();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.activity_edit_video);
        this.cBu = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gXR = getIntent().getStringExtra("video_title");
        this.gYa = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.blw = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.blw) && !new File(this.blw).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gWm).mkdirs();
        this.gXU = new SelectCoverModel(getPageContext(), this, this.gJZ);
        this.gXV = new SelectMusicModel(getPageContext(), this);
        this.gXZ = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gXZ.a(this);
        this.gXT = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gJZ);
        this.gXT.setData(this.blw);
        this.gXT.aa(getIntent());
        this.gXT.a(this.gXZ);
        this.gXT.setGenMaskCoverListener(this);
        this.gXU.bBX();
        this.gXV.bBY();
        this.dCl = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dCl.dc(d.k.mixing);
        registerListener(this.gYc);
        bBt();
        registerListener(this.gYb);
        bBs();
        TiebaStatic.log("c12303");
    }

    private void bBr() {
        this.Aa = true;
        this.gXX = null;
        this.gXW = null;
        ayU();
    }

    public void bBs() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cBu)) {
            httpMessage.addParam("forum_id", this.cBu);
        }
        sendMessage(httpMessage);
    }

    private void bBt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gXT.getRootView());
        if (this.gXT != null) {
            this.gXT.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gXT != null) {
            this.gXT.onPause();
        }
        if (this.gXZ.bBC()) {
            this.gXZ.bBD();
        }
        this.gXY = false;
        this.Aa = true;
        bBr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gXT != null) {
            this.gXT.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
        com.baidu.tieba.video.editvideo.model.b.bBV().bBW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gXT != null) {
            this.gXT.release();
        }
        if (this.gXU != null) {
            this.gXU.cancelLoadData();
        }
        if (this.gXV != null) {
            this.gXV.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gXT != null) {
            this.gXT.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        ayU();
        this.gXY = false;
        if (this.gXT != null && this.gXT.bCk() != null) {
            this.gXT.bCk().pause();
            this.gXT.bCk().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBu() {
        if (this.gXT != null && this.gXU != null && this.gXV != null) {
            if (!j.jD()) {
                getPageContext().showToast(d.k.no_network);
            } else if (!this.gXY) {
                this.gXY = true;
                this.Aa = false;
                this.gXX = null;
                this.gXW = null;
                this.gXT.onPause();
                this.dCl.aM(true);
                bBw();
            }
        }
    }

    private void ayU() {
        if (this.dCl != null) {
            this.dCl.aM(false);
        }
    }

    private void bBv() {
        if (this.Aa) {
            this.Aa = false;
        } else if (this.gXT.bCr()) {
            this.gXV.c(this.blw, this.gXT.bCp(), com.baidu.tieba.video.b.gWl + "video_" + System.currentTimeMillis() + ".mp4", this.gXT.isMute() ? false : true);
        } else if (this.gXT.isMute()) {
            this.gXV.c(this.blw, null, com.baidu.tieba.video.b.gWl + "video_" + System.currentTimeMillis() + ".mp4", this.gXT.isMute() ? false : true);
        } else {
            n(this.blw, -4399, "");
        }
    }

    private void bBw() {
        if (this.Aa) {
            this.Aa = false;
            return;
        }
        String text = this.gXT.getText();
        if (TextUtils.isEmpty(text)) {
            this.gXU.aP(this.blw, this.gXT.getCurrentPosition());
        } else {
            this.gXU.rQ(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBx() {
        File file;
        this.Aa = false;
        if (this.gXT.bCr() || this.gXT.isMute()) {
            this.gXY = false;
            this.dCl.aM(true);
            this.gXT.onPause();
            if (this.gXX != null) {
                n(this.gXX, -4399, "");
            } else {
                bBv();
            }
        } else if (this.gXZ.bBB()) {
            this.gXY = false;
            this.gXT.onPause();
            this.dCl.aM(true);
            uL(this.blw);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                l.ac(new File(this.blw).getAbsolutePath(), com.baidu.tieba.video.b.gWm + file.getName());
                uN(com.baidu.tieba.video.b.gWm + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bhS() {
        if (this.gXT == null || this.gXU == null) {
            ayU();
            this.gXY = false;
        } else if (this.Aa) {
            this.Aa = false;
        } else {
            this.gXU.aP(this.blw, this.gXT.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void rO(String str) {
        if (this.Aa) {
            this.Aa = false;
        } else if (this.gXY) {
            showToast(str);
            ayU();
            this.gXY = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.gXT.bCk().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void uJ(String str) {
        if (this.Aa) {
            this.Aa = false;
            return;
        }
        this.gXW = str;
        bBv();
    }

    private void bBy() {
        if (this.Aa) {
            this.Aa = false;
        } else if (!TextUtils.isEmpty(this.gXW) && !TextUtils.isEmpty(this.gXX)) {
            this.mVideoInfo.setVideoPath(this.gXX);
            this.mVideoInfo.setThumbPath(this.gXW);
            if (this.gXT.bCr() && !TextUtils.isEmpty(this.gXT.bCq())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gXT.bCq());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gYa, this.cBu, this.mForumName, this.gXR, 13003, this.mVideoInfo, this.mVideoTitleData, this.gXS);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            ayU();
            this.gXY = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.k.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.k.music_cloud)));
        this.gXT.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.Aa) {
            this.Aa = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.k.mixing_fail);
            ayU();
            this.gXT.onResume();
            this.gXY = false;
            if (this.gJZ != null) {
                this.gJZ.ae(i, str2);
            }
        } else if (this.gXZ.bBB()) {
            uL(str);
        } else {
            uM(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBz() {
        this.gXX = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dH(List<PendantData> list) {
        this.gXT.dH(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uR = com.baidu.tieba.video.editvideo.model.a.bBS().uR(stringExtra);
                if (this.gXT != null && !TextUtils.isEmpty(uR)) {
                    this.gXT.cr(uR, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void uK(String str) {
        uM(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.gJZ != null) {
            this.gJZ.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gJZ != null) {
            this.gJZ.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void uL(String str) {
        this.gXT.bCn();
        this.gXT.bCo();
        this.gXT.bCk().releaseSource();
        this.gXZ.uP(str);
    }

    private void uM(String str) {
        File file;
        this.gXX = str;
        if (this.gXY) {
            bBy();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gWm + file.getName();
        l.ac(new File(this.gXX).getAbsolutePath(), str2);
        uN(str2);
        ayU();
        finishPage();
    }

    private void uN(String str) {
        try {
            new x(this).ey(str);
            c.aq(this, str);
        } catch (Exception e) {
        }
    }

    private void z(Bitmap bitmap) {
        if (this.gXT == null || this.gXU == null) {
            ayU();
        } else if (this.Aa) {
            this.Aa = false;
        } else {
            if (!TextUtils.isEmpty(this.gXT.getText())) {
                bitmap = this.gXT.s(bitmap);
            }
            if (bitmap != null) {
                this.gXU.b(bitmap, com.baidu.tieba.video.b.gWk);
            }
        }
    }
}
