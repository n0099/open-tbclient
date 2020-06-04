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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean KE;
    private String aWu;
    private String evm;
    private String hOW;
    private com.baidu.tbadk.core.view.a hPr;
    private int lCo;
    private FrsTabInfoData lCp;
    private String lCq;
    private List<VideoTitleData> lCr;
    private com.baidu.tieba.video.editvideo.view.a lCs;
    private SelectCoverModel lCt;
    private SelectMusicModel lCu;
    private String lCv;
    private boolean lCw;
    private com.baidu.tieba.video.editvideo.b.a lCx;
    private HttpMessageListener lCy;
    private CustomMessageListener lCz;
    private h lnq;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lnq = lVar.cyS();
        }
        this.lCy = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.lCr = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.lCz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.evm = getIntent().getStringExtra("forum_id");
        this.lCo = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.lCq = getIntent().getStringExtra("video_title");
        this.hOW = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aWu = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.lCp = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.lAP).mkdirs();
        this.lCt = new SelectCoverModel(getPageContext(), this, this.lnq);
        this.lCu = new SelectMusicModel(getPageContext(), this);
        this.lCx = new com.baidu.tieba.video.editvideo.b.a(this);
        this.lCx.a(this);
        this.lCs = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.lnq);
        this.lCs.setData(this.mVideoPath);
        this.lCs.al(getIntent());
        this.lCs.a(this.lCx);
        this.lCs.setGenMaskCoverListener(this);
        this.lCt.diW();
        this.lCu.diX();
        this.hPr = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hPr.setTipString(R.string.mixing);
        registerListener(this.lCz);
        div();
        registerListener(this.lCy);
        diu();
        TiebaStatic.log("c12303");
    }

    private void dit() {
        this.KE = true;
        this.lCv = null;
        this.mCoverPath = null;
        cbc();
    }

    public void diu() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.evm)) {
            httpMessage.addParam("forum_id", this.evm);
        }
        sendMessage(httpMessage);
    }

    private void div() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lCs.getRootView());
        if (this.lCs != null) {
            this.lCs.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lCs != null) {
            this.lCs.onPause();
        }
        if (this.lCx.diE()) {
            this.lCx.diF();
        }
        this.lCw = false;
        this.KE = true;
        dit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lCs != null) {
            this.lCs.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.diR().diS();
        com.baidu.tieba.video.editvideo.model.b.diU().diV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lCs != null) {
            this.lCs.release();
        }
        if (this.lCt != null) {
            this.lCt.cancelLoadData();
        }
        if (this.lCu != null) {
            this.lCu.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lCs != null) {
            this.lCs.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cbc();
        this.lCw = false;
        if (this.lCs != null && this.lCs.djh() != null) {
            this.lCs.djh().pause();
            this.lCs.djh().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.lCs == null || this.lCt == null || this.lCu == null) {
            cbc();
            this.lCw = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.lCw) {
            this.lCw = true;
            this.KE = false;
            this.lCv = null;
            this.mCoverPath = null;
            this.lCs.onPause();
            this.hPr.setDialogVisiable(true);
            dix();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbc() {
        if (this.hPr != null) {
            this.hPr.setDialogVisiable(false);
        }
    }

    private void diw() {
        if (this.KE) {
            this.KE = false;
        } else if (this.lCs.djo()) {
            this.lCu.h(this.mVideoPath, this.lCs.djm(), c.lAO + "video_" + System.currentTimeMillis() + ".mp4", this.lCs.isMute() ? false : true);
        } else if (this.lCs.isMute()) {
            this.lCu.h(this.mVideoPath, null, c.lAO + "video_" + System.currentTimeMillis() + ".mp4", this.lCs.isMute() ? false : true);
        } else {
            t(this.mVideoPath, -4399, "");
        }
    }

    private void dix() {
        if (this.KE) {
            this.KE = false;
            return;
        }
        String text = this.lCs.getText();
        if (TextUtils.isEmpty(text)) {
            this.lCt.bH(this.mVideoPath, this.lCs.getCurrentPosition());
        } else {
            this.lCt.JY(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void diy() {
        File file;
        this.KE = false;
        if (this.lCs.djo() || this.lCs.isMute()) {
            this.lCw = false;
            this.hPr.setDialogVisiable(true);
            this.lCs.onPause();
            if (this.lCv != null) {
                t(this.lCv, -4399, "");
            } else {
                diw();
            }
        } else if (this.lCx.diD()) {
            this.lCw = false;
            this.lCs.onPause();
            this.hPr.setDialogVisiable(true);
            Nx(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.lAP + file.getName());
                Nz(c.lAP + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cMF() {
        if (this.lCs == null || this.lCt == null) {
            cbc();
            this.lCw = false;
        } else if (this.KE) {
            this.KE = false;
        } else {
            this.lCt.bH(this.mVideoPath, this.lCs.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JW(String str) {
        if (this.KE) {
            this.KE = false;
        } else if (this.lCw) {
            showToast(str);
            cbc();
            this.lCw = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void K(Bitmap bitmap) {
        this.lCs.djh().O(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Nv(String str) {
        if (this.KE) {
            this.KE = false;
            return;
        }
        this.mCoverPath = str;
        diw();
    }

    private void diz() {
        if (this.KE) {
            this.KE = false;
        } else if (TextUtils.isEmpty(this.mCoverPath) || TextUtils.isEmpty(this.lCv)) {
        } else {
            m.a(new String[]{this.mCoverPath, this.lCv}, new m.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
                @Override // com.baidu.tbadk.core.util.m.b
                public void E(HashMap<String, String> hashMap) {
                    EditVideoActivity.this.mVideoInfo.setVideoPath(EditVideoActivity.this.lCv);
                    EditVideoActivity.this.mVideoInfo.setThumbPath(EditVideoActivity.this.mCoverPath);
                    if (hashMap != null) {
                        EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(EditVideoActivity.this.mCoverPath));
                        EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(EditVideoActivity.this.lCv));
                    }
                    if (EditVideoActivity.this.lCs.djo() && !TextUtils.isEmpty(EditVideoActivity.this.lCs.djn())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(EditVideoActivity.this.lCs.djn());
                        EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                    }
                    WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.hOW, EditVideoActivity.this.evm, EditVideoActivity.this.mForumName, EditVideoActivity.this.lCq, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.lCr);
                    if (!StringUtils.isNull(EditVideoActivity.this.aWu)) {
                        writeVideoActivityConfig.addFromType(EditVideoActivity.this.aWu);
                    }
                    writeVideoActivityConfig.setProZone(EditVideoActivity.this.lCo);
                    writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                    writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.lCp);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                    EditVideoActivity.this.cbc();
                    EditVideoActivity.this.lCw = false;
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.lCs.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.KE) {
            this.KE = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            cbc();
            this.lCs.onResume();
            this.lCw = false;
            if (this.lnq != null) {
                this.lnq.bl(i, str2);
            }
        } else if (this.lCx.diD()) {
            Nx(str);
        } else {
            Ny(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void diA() {
        this.lCv = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eN(List<PendantData> list) {
        this.lCs.eN(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String NC = com.baidu.tieba.video.editvideo.model.a.diR().NC(stringExtra);
                if (this.lCs != null && !TextUtils.isEmpty(NC)) {
                    this.lCs.fy(NC, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Nw(String str) {
        Ny(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bz(int i, String str) {
        if (this.lnq != null) {
            this.lnq.bl(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bA(int i, String str) {
        if (this.lnq != null) {
            this.lnq.bl(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void diB() {
        e.ld().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.cbc();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        L(bitmap);
    }

    private void Nx(String str) {
        this.lCs.djk();
        this.lCs.djl();
        this.lCs.djh().releaseSource();
        this.lCx.NB(str);
    }

    private void Ny(String str) {
        File file;
        this.lCv = str;
        if (this.lCw) {
            diz();
            return;
        }
        String str2 = c.lAP + file.getName();
        m.copyFile(new File(this.lCv).getAbsolutePath(), str2);
        Nz(str2);
        cbc();
        finishPage();
    }

    private void Nz(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aZ(this, str);
        } catch (Exception e) {
            cbc();
            this.lCw = false;
        }
    }

    private void L(Bitmap bitmap) {
        if (this.lCs == null || this.lCt == null) {
            cbc();
            this.lCw = false;
        } else if (this.KE) {
            this.KE = false;
        } else {
            if (!TextUtils.isEmpty(this.lCs.getText())) {
                bitmap = this.lCs.D(bitmap);
            }
            if (bitmap != null) {
                this.lCt.b(bitmap, c.lAN);
            }
        }
    }
}
