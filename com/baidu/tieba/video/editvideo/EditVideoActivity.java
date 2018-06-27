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
    private String bmV;
    private String czo;
    private com.baidu.tbadk.core.view.a dbO;
    private h gOa;
    private String hbW;
    private List<VideoTitleData> hbX;
    private com.baidu.tieba.video.editvideo.view.a hbY;
    private SelectCoverModel hbZ;
    private SelectMusicModel hca;
    private String hcb;
    private String hcc;
    private boolean hcd;
    private com.baidu.tieba.video.editvideo.b.a hce;
    private String hcf;
    private HttpMessageListener hcg;
    private CustomMessageListener hch;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean zY;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.hcg = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hbX = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hch = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.czo = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hbW = getIntent().getStringExtra("video_title");
        this.hcf = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bmV = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bmV) && !new File(this.bmV).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.har).mkdirs();
        this.hbZ = new SelectCoverModel(getPageContext(), this, this.gOa);
        this.hca = new SelectMusicModel(getPageContext(), this);
        this.hce = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hce.a(this);
        this.hbY = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gOa);
        this.hbY.setData(this.bmV);
        this.hbY.aa(getIntent());
        this.hbY.a(this.hce);
        this.hbY.setGenMaskCoverListener(this);
        this.hbZ.bCx();
        this.hca.bCy();
        this.dbO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dbO.dd(d.k.mixing);
        registerListener(this.hch);
        bBT();
        registerListener(this.hcg);
        bBS();
        TiebaStatic.log("c12303");
    }

    private void bBR() {
        this.zY = true;
        this.hcc = null;
        this.hcb = null;
        azA();
    }

    public void bBS() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.czo)) {
            httpMessage.addParam("forum_id", this.czo);
        }
        sendMessage(httpMessage);
    }

    private void bBT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hbY.getRootView());
        if (this.hbY != null) {
            this.hbY.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hbY != null) {
            this.hbY.onPause();
        }
        if (this.hce.bCc()) {
            this.hce.bCd();
        }
        this.hcd = false;
        this.zY = true;
        bBR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hbY != null) {
            this.hbY.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bCs().bCt();
        com.baidu.tieba.video.editvideo.model.b.bCv().bCw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hbY != null) {
            this.hbY.release();
        }
        if (this.hbZ != null) {
            this.hbZ.cancelLoadData();
        }
        if (this.hca != null) {
            this.hca.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hbY != null) {
            this.hbY.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        azA();
        this.hcd = false;
        if (this.hbY != null && this.hbY.bCK() != null) {
            this.hbY.bCK().pause();
            this.hbY.bCK().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBU() {
        if (this.hbY != null && this.hbZ != null && this.hca != null) {
            if (!j.jD()) {
                getPageContext().showToast(d.k.no_network);
            } else if (!this.hcd) {
                this.hcd = true;
                this.zY = false;
                this.hcc = null;
                this.hcb = null;
                this.hbY.onPause();
                this.dbO.aO(true);
                bBW();
            }
        }
    }

    private void azA() {
        if (this.dbO != null) {
            this.dbO.aO(false);
        }
    }

    private void bBV() {
        if (this.zY) {
            this.zY = false;
        } else if (this.hbY.bCR()) {
            this.hca.c(this.bmV, this.hbY.bCP(), com.baidu.tieba.video.b.haq + "video_" + System.currentTimeMillis() + ".mp4", this.hbY.isMute() ? false : true);
        } else if (this.hbY.isMute()) {
            this.hca.c(this.bmV, null, com.baidu.tieba.video.b.haq + "video_" + System.currentTimeMillis() + ".mp4", this.hbY.isMute() ? false : true);
        } else {
            n(this.bmV, -4399, "");
        }
    }

    private void bBW() {
        if (this.zY) {
            this.zY = false;
            return;
        }
        String text = this.hbY.getText();
        if (TextUtils.isEmpty(text)) {
            this.hbZ.aQ(this.bmV, this.hbY.getCurrentPosition());
        } else {
            this.hbZ.rP(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBX() {
        File file;
        this.zY = false;
        if (this.hbY.bCR() || this.hbY.isMute()) {
            this.hcd = false;
            this.dbO.aO(true);
            this.hbY.onPause();
            if (this.hcc != null) {
                n(this.hcc, -4399, "");
            } else {
                bBV();
            }
        } else if (this.hce.bCb()) {
            this.hcd = false;
            this.hbY.onPause();
            this.dbO.aO(true);
            uH(this.bmV);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                l.ac(new File(this.bmV).getAbsolutePath(), com.baidu.tieba.video.b.har + file.getName());
                uJ(com.baidu.tieba.video.b.har + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void biy() {
        if (this.hbY == null || this.hbZ == null) {
            azA();
            this.hcd = false;
        } else if (this.zY) {
            this.zY = false;
        } else {
            this.hbZ.aQ(this.bmV, this.hbY.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void rN(String str) {
        if (this.zY) {
            this.zY = false;
        } else if (this.hcd) {
            showToast(str);
            azA();
            this.hcd = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hbY.bCK().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void uF(String str) {
        if (this.zY) {
            this.zY = false;
            return;
        }
        this.hcb = str;
        bBV();
    }

    private void bBY() {
        if (this.zY) {
            this.zY = false;
        } else if (!TextUtils.isEmpty(this.hcb) && !TextUtils.isEmpty(this.hcc)) {
            this.mVideoInfo.setVideoPath(this.hcc);
            this.mVideoInfo.setThumbPath(this.hcb);
            if (this.hbY.bCR() && !TextUtils.isEmpty(this.hbY.bCQ())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hbY.bCQ());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hcf, this.czo, this.mForumName, this.hbW, 13003, this.mVideoInfo, this.mVideoTitleData, this.hbX);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            azA();
            this.hcd = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.k.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.k.music_cloud)));
        this.hbY.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.zY) {
            this.zY = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.k.mixing_fail);
            azA();
            this.hbY.onResume();
            this.hcd = false;
            if (this.gOa != null) {
                this.gOa.ab(i, str2);
            }
        } else if (this.hce.bCb()) {
            uH(str);
        } else {
            uI(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBZ() {
        this.hcc = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dK(List<PendantData> list) {
        this.hbY.dK(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uN = com.baidu.tieba.video.editvideo.model.a.bCs().uN(stringExtra);
                if (this.hbY != null && !TextUtils.isEmpty(uN)) {
                    this.hbY.cv(uN, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void uG(String str) {
        uI(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void am(int i, String str) {
        if (this.gOa != null) {
            this.gOa.ab(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void an(int i, String str) {
        if (this.gOa != null) {
            this.gOa.ab(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void uH(String str) {
        this.hbY.bCN();
        this.hbY.bCO();
        this.hbY.bCK().releaseSource();
        this.hce.uL(str);
    }

    private void uI(String str) {
        File file;
        this.hcc = str;
        if (this.hcd) {
            bBY();
            return;
        }
        String str2 = com.baidu.tieba.video.b.har + file.getName();
        l.ac(new File(this.hcc).getAbsolutePath(), str2);
        uJ(str2);
        azA();
        finishPage();
    }

    private void uJ(String str) {
        try {
            new x(this).eB(str);
            c.aq(this, str);
        } catch (Exception e) {
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hbY == null || this.hbZ == null) {
            azA();
        } else if (this.zY) {
            this.zY = false;
        } else {
            if (!TextUtils.isEmpty(this.hbY.getText())) {
                bitmap = this.hbY.s(bitmap);
            }
            if (bitmap != null) {
                this.hbZ.b(bitmap, com.baidu.tieba.video.b.hap);
            }
        }
    }
}
