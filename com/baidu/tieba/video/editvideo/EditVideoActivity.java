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
    private com.baidu.tbadk.core.view.a hOE;
    private String hOj;
    private int lBf;
    private FrsTabInfoData lBg;
    private String lBh;
    private List<VideoTitleData> lBi;
    private com.baidu.tieba.video.editvideo.view.a lBj;
    private SelectCoverModel lBk;
    private SelectMusicModel lBl;
    private String lBm;
    private boolean lBn;
    private com.baidu.tieba.video.editvideo.b.a lBo;
    private HttpMessageListener lBp;
    private CustomMessageListener lBq;
    private h lmg;
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
            this.lmg = lVar.cyB();
        }
        this.lBp = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.lBi = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.lBq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.lBf = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.lBh = getIntent().getStringExtra("video_title");
        this.hOj = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aWu = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.lBg = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.lzG).mkdirs();
        this.lBk = new SelectCoverModel(getPageContext(), this, this.lmg);
        this.lBl = new SelectMusicModel(getPageContext(), this);
        this.lBo = new com.baidu.tieba.video.editvideo.b.a(this);
        this.lBo.a(this);
        this.lBj = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.lmg);
        this.lBj.setData(this.mVideoPath);
        this.lBj.ak(getIntent());
        this.lBj.a(this.lBo);
        this.lBj.setGenMaskCoverListener(this);
        this.lBk.diH();
        this.lBl.diI();
        this.hOE = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hOE.setTipString(R.string.mixing);
        registerListener(this.lBq);
        dig();
        registerListener(this.lBp);
        dif();
        TiebaStatic.log("c12303");
    }

    private void die() {
        this.KE = true;
        this.lBm = null;
        this.mCoverPath = null;
        caU();
    }

    public void dif() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.evm)) {
            httpMessage.addParam("forum_id", this.evm);
        }
        sendMessage(httpMessage);
    }

    private void dig() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lBj.getRootView());
        if (this.lBj != null) {
            this.lBj.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lBj != null) {
            this.lBj.onPause();
        }
        if (this.lBo.dip()) {
            this.lBo.diq();
        }
        this.lBn = false;
        this.KE = true;
        die();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lBj != null) {
            this.lBj.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.diC().diD();
        com.baidu.tieba.video.editvideo.model.b.diF().diG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lBj != null) {
            this.lBj.release();
        }
        if (this.lBk != null) {
            this.lBk.cancelLoadData();
        }
        if (this.lBl != null) {
            this.lBl.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lBj != null) {
            this.lBj.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        caU();
        this.lBn = false;
        if (this.lBj != null && this.lBj.diS() != null) {
            this.lBj.diS().pause();
            this.lBj.diS().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.lBj == null || this.lBk == null || this.lBl == null) {
            caU();
            this.lBn = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.lBn) {
            this.lBn = true;
            this.KE = false;
            this.lBm = null;
            this.mCoverPath = null;
            this.lBj.onPause();
            this.hOE.setDialogVisiable(true);
            dii();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caU() {
        if (this.hOE != null) {
            this.hOE.setDialogVisiable(false);
        }
    }

    private void dih() {
        if (this.KE) {
            this.KE = false;
        } else if (this.lBj.diZ()) {
            this.lBl.h(this.mVideoPath, this.lBj.diX(), c.lzF + "video_" + System.currentTimeMillis() + ".mp4", this.lBj.isMute() ? false : true);
        } else if (this.lBj.isMute()) {
            this.lBl.h(this.mVideoPath, null, c.lzF + "video_" + System.currentTimeMillis() + ".mp4", this.lBj.isMute() ? false : true);
        } else {
            t(this.mVideoPath, -4399, "");
        }
    }

    private void dii() {
        if (this.KE) {
            this.KE = false;
            return;
        }
        String text = this.lBj.getText();
        if (TextUtils.isEmpty(text)) {
            this.lBk.bH(this.mVideoPath, this.lBj.getCurrentPosition());
        } else {
            this.lBk.JX(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dij() {
        File file;
        this.KE = false;
        if (this.lBj.diZ() || this.lBj.isMute()) {
            this.lBn = false;
            this.hOE.setDialogVisiable(true);
            this.lBj.onPause();
            if (this.lBm != null) {
                t(this.lBm, -4399, "");
            } else {
                dih();
            }
        } else if (this.lBo.dio()) {
            this.lBn = false;
            this.lBj.onPause();
            this.hOE.setDialogVisiable(true);
            Nw(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.lzG + file.getName());
                Ny(c.lzG + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cMp() {
        if (this.lBj == null || this.lBk == null) {
            caU();
            this.lBn = false;
        } else if (this.KE) {
            this.KE = false;
        } else {
            this.lBk.bH(this.mVideoPath, this.lBj.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JV(String str) {
        if (this.KE) {
            this.KE = false;
        } else if (this.lBn) {
            showToast(str);
            caU();
            this.lBn = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void K(Bitmap bitmap) {
        this.lBj.diS().O(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Nu(String str) {
        if (this.KE) {
            this.KE = false;
            return;
        }
        this.mCoverPath = str;
        dih();
    }

    private void dik() {
        if (this.KE) {
            this.KE = false;
        } else if (TextUtils.isEmpty(this.mCoverPath) || TextUtils.isEmpty(this.lBm)) {
        } else {
            m.a(new String[]{this.mCoverPath, this.lBm}, new m.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
                @Override // com.baidu.tbadk.core.util.m.b
                public void E(HashMap<String, String> hashMap) {
                    EditVideoActivity.this.mVideoInfo.setVideoPath(EditVideoActivity.this.lBm);
                    EditVideoActivity.this.mVideoInfo.setThumbPath(EditVideoActivity.this.mCoverPath);
                    if (hashMap != null) {
                        EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(EditVideoActivity.this.mCoverPath));
                        EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(EditVideoActivity.this.lBm));
                    }
                    if (EditVideoActivity.this.lBj.diZ() && !TextUtils.isEmpty(EditVideoActivity.this.lBj.diY())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(EditVideoActivity.this.lBj.diY());
                        EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                    }
                    WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.hOj, EditVideoActivity.this.evm, EditVideoActivity.this.mForumName, EditVideoActivity.this.lBh, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.lBi);
                    if (!StringUtils.isNull(EditVideoActivity.this.aWu)) {
                        writeVideoActivityConfig.addFromType(EditVideoActivity.this.aWu);
                    }
                    writeVideoActivityConfig.setProZone(EditVideoActivity.this.lBf);
                    writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                    writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.lBg);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                    EditVideoActivity.this.caU();
                    EditVideoActivity.this.lBn = false;
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
        this.lBj.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.KE) {
            this.KE = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            caU();
            this.lBj.onResume();
            this.lBn = false;
            if (this.lmg != null) {
                this.lmg.bl(i, str2);
            }
        } else if (this.lBo.dio()) {
            Nw(str);
        } else {
            Nx(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dil() {
        this.lBm = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eL(List<PendantData> list) {
        this.lBj.eL(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String NB = com.baidu.tieba.video.editvideo.model.a.diC().NB(stringExtra);
                if (this.lBj != null && !TextUtils.isEmpty(NB)) {
                    this.lBj.fy(NB, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Nv(String str) {
        Nx(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bz(int i, String str) {
        if (this.lmg != null) {
            this.lmg.bl(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bA(int i, String str) {
        if (this.lmg != null) {
            this.lmg.bl(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void dim() {
        e.ld().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.caU();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        L(bitmap);
    }

    private void Nw(String str) {
        this.lBj.diV();
        this.lBj.diW();
        this.lBj.diS().releaseSource();
        this.lBo.NA(str);
    }

    private void Nx(String str) {
        File file;
        this.lBm = str;
        if (this.lBn) {
            dik();
            return;
        }
        String str2 = c.lzG + file.getName();
        m.copyFile(new File(this.lBm).getAbsolutePath(), str2);
        Ny(str2);
        caU();
        finishPage();
    }

    private void Ny(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aZ(this, str);
        } catch (Exception e) {
            caU();
            this.lBn = false;
        }
    }

    private void L(Bitmap bitmap) {
        if (this.lBj == null || this.lBk == null) {
            caU();
            this.lBn = false;
        } else if (this.KE) {
            this.KE = false;
        } else {
            if (!TextUtils.isEmpty(this.lBj.getText())) {
                bitmap = this.lBj.D(bitmap);
            }
            if (bitmap != null) {
                this.lBk.b(bitmap, c.lzE);
            }
        }
    }
}
