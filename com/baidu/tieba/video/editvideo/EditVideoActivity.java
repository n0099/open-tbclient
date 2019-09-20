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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.c;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean AQ;
    private String amf;
    private String eHo;
    private String fVH;
    private com.baidu.tbadk.core.view.b foa;
    private h jjR;
    private int jyH;
    private String jyI;
    private List<VideoTitleData> jyJ;
    private com.baidu.tieba.video.editvideo.view.a jyK;
    private SelectCoverModel jyL;
    private SelectMusicModel jyM;
    private String jyN;
    private String jyO;
    private boolean jyP;
    private com.baidu.tieba.video.editvideo.b.a jyQ;
    private HttpMessageListener jyR;
    private CustomMessageListener jyS;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.jyR = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.jyJ = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jyS = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(R.layout.activity_edit_video);
        this.eHo = getIntent().getStringExtra("forum_id");
        this.jyH = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.jyI = getIntent().getStringExtra("video_title");
        this.fVH = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.amf = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.amf) && !new File(this.amf).exists()) {
            finishPage();
        }
        new File(c.jxd).mkdirs();
        this.jyL = new SelectCoverModel(getPageContext(), this, this.jjR);
        this.jyM = new SelectMusicModel(getPageContext(), this);
        this.jyQ = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jyQ.a(this);
        this.jyK = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.jjR);
        this.jyK.setData(this.amf);
        this.jyK.aA(getIntent());
        this.jyK.a(this.jyQ);
        this.jyK.setGenMaskCoverListener(this);
        this.jyL.cvO();
        this.jyM.cvP();
        this.foa = new com.baidu.tbadk.core.view.b(getPageContext());
        this.foa.iC(R.string.mixing);
        registerListener(this.jyS);
        cvk();
        registerListener(this.jyR);
        cvj();
        TiebaStatic.log("c12303");
    }

    private void cvi() {
        this.AQ = true;
        this.jyO = null;
        this.jyN = null;
        bsJ();
    }

    public void cvj() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eHo)) {
            httpMessage.addParam("forum_id", this.eHo);
        }
        sendMessage(httpMessage);
    }

    private void cvk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jyK.getRootView());
        if (this.jyK != null) {
            this.jyK.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jyK != null) {
            this.jyK.onPause();
        }
        if (this.jyQ.cvt()) {
            this.jyQ.cvu();
        }
        this.jyP = false;
        this.AQ = true;
        cvi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jyK != null) {
            this.jyK.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cvJ().cvK();
        com.baidu.tieba.video.editvideo.model.b.cvM().cvN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jyK != null) {
            this.jyK.release();
        }
        if (this.jyL != null) {
            this.jyL.cancelLoadData();
        }
        if (this.jyM != null) {
            this.jyM.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jyK != null) {
            this.jyK.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bsJ();
        this.jyP = false;
        if (this.jyK != null && this.jyK.cwb() != null) {
            this.jyK.cwb().pause();
            this.jyK.cwb().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cvl() {
        if (this.jyK == null || this.jyL == null || this.jyM == null) {
            bsJ();
            this.jyP = false;
        } else if (!j.kc()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jyP) {
            this.jyP = true;
            this.AQ = false;
            this.jyO = null;
            this.jyN = null;
            this.jyK.onPause();
            this.foa.em(true);
            cvn();
        }
    }

    private void bsJ() {
        if (this.foa != null) {
            this.foa.em(false);
        }
    }

    private void cvm() {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jyK.cwi()) {
            this.jyM.e(this.amf, this.jyK.cwg(), c.jxc + "video_" + System.currentTimeMillis() + ".mp4", this.jyK.isMute() ? false : true);
        } else if (this.jyK.isMute()) {
            this.jyM.e(this.amf, null, c.jxc + "video_" + System.currentTimeMillis() + ".mp4", this.jyK.isMute() ? false : true);
        } else {
            t(this.amf, -4399, "");
        }
    }

    private void cvn() {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        String text = this.jyK.getText();
        if (TextUtils.isEmpty(text)) {
            this.jyL.bs(this.amf, this.jyK.getCurrentPosition());
        } else {
            this.jyL.CY(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cvo() {
        File file;
        this.AQ = false;
        if (this.jyK.cwi() || this.jyK.isMute()) {
            this.jyP = false;
            this.foa.em(true);
            this.jyK.onPause();
            if (this.jyO != null) {
                t(this.jyO, -4399, "");
            } else {
                cvm();
            }
        } else if (this.jyQ.cvs()) {
            this.jyP = false;
            this.jyK.onPause();
            this.foa.em(true);
            Gi(this.amf);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.amf).getAbsolutePath(), c.jxd + file.getName());
                Gk(c.jxd + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cbv() {
        if (this.jyK == null || this.jyL == null) {
            bsJ();
            this.jyP = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            this.jyL.bs(this.amf, this.jyK.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void CV(String str) {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jyP) {
            showToast(str);
            bsJ();
            this.jyP = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.jyK.cwb().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gg(String str) {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        this.jyN = str;
        cvm();
    }

    private void cvp() {
        if (this.AQ) {
            this.AQ = false;
        } else if (!TextUtils.isEmpty(this.jyN) && !TextUtils.isEmpty(this.jyO)) {
            this.mVideoInfo.setVideoPath(this.jyO);
            this.mVideoInfo.setThumbPath(this.jyN);
            if (this.jyK.cwi() && !TextUtils.isEmpty(this.jyK.cwh())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jyK.cwh());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fVH, this.eHo, this.mForumName, this.jyI, 13003, this.mVideoInfo, this.mVideoTitleData, this.jyJ);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.jyH);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bsJ();
            this.jyP = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jyK.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AQ) {
            this.AQ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bsJ();
            this.jyK.onResume();
            this.jyP = false;
            if (this.jjR != null) {
                this.jjR.ax(i, str2);
            }
        } else if (this.jyQ.cvs()) {
            Gi(str);
        } else {
            Gj(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cvq() {
        this.jyO = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eo(List<PendantData> list) {
        this.jyK.eo(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Gn = com.baidu.tieba.video.editvideo.model.a.cvJ().Gn(stringExtra);
                if (this.jyK != null && !TextUtils.isEmpty(Gn)) {
                    this.jyK.eu(Gn, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Gh(String str) {
        Gj(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.jjR != null) {
            this.jjR.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.jjR != null) {
            this.jjR.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void Gi(String str) {
        this.jyK.cwe();
        this.jyK.cwf();
        this.jyK.cwb().releaseSource();
        this.jyQ.Gm(str);
    }

    private void Gj(String str) {
        File file;
        this.jyO = str;
        if (this.jyP) {
            cvp();
            return;
        }
        String str2 = c.jxd + file.getName();
        m.bQ(new File(this.jyO).getAbsolutePath(), str2);
        Gk(str2);
        bsJ();
        finishPage();
    }

    private void Gk(String str) {
        try {
            new w(this).nS(str);
            com.baidu.tieba.video.editvideo.b.c.aS(this, str);
        } catch (Exception e) {
            bsJ();
            this.jyP = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.jyK == null || this.jyL == null) {
            bsJ();
            this.jyP = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            if (!TextUtils.isEmpty(this.jyK.getText())) {
                bitmap = this.jyK.B(bitmap);
            }
            if (bitmap != null) {
                this.jyL.b(bitmap, c.jxb);
            }
        }
    }
}
