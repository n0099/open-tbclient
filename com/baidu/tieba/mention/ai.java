package com.baidu.tieba.mention;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends l implements com.baidu.tieba.tbadkCore.ap {
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, w> aDG;
    private String aJS;
    private com.baidu.tieba.tbadkCore.writeModel.a aJU;
    private final com.baidu.tieba.tbadkCore.writeModel.d aJX;
    private PbEditor aKP;
    private final AbsListView.OnScrollListener aKa;
    private com.baidu.tbadk.core.dialog.e aNH;
    private com.baidu.tbadk.mvc.i.b.c bFX;
    private long bGA;
    private long bGB;
    private final ad bGC;
    private com.baidu.tbadk.editortool.z bGD;
    private boolean bGE;
    private final SingleMentionActivity bGp;
    private BdListView bGw;
    private ab bGx;
    private FeedData bGy;
    private FeedData bGz;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;
    private WriteImagesInfo mWriteImagesInfo;

    public ai(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bGw = null;
        this.mWriteImagesInfo = new WriteImagesInfo();
        this.bGx = null;
        this.aNH = null;
        this.aJX = new aj(this);
        this.bGC = new ak(this);
        this.bGD = null;
        this.bGE = true;
        this.aKa = new al(this);
        this.bGp = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bGw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.mWriteImagesInfo = writeImagesInfo;
            }
            this.bGy = (FeedData) bundle.getSerializable("reply_thread");
            this.aJS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.mWriteImagesInfo.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (this.aDG != null) {
            this.aDG.oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aDG != null) {
            this.aDG.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aDG.s(((q) aVar).Zp());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return com.baidu.tieba.r.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.bGx = new ab(this.bGp);
        this.bGx.a(this.bGC);
        this.aJU = new com.baidu.tieba.tbadkCore.writeModel.a(AL());
        this.aJU.a(this.aJX);
        this.bGw = (BdListView) getView().findViewById(com.baidu.tieba.q.replyme_lv);
        this.bGw.setOnScrollListener(this.aKa);
        this.aDG = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), w.class, com.baidu.tieba.r.mention_replyme_item, AM());
        this.aDG.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.mention_replyme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.bGw.setAdapter((ListAdapter) this.aDG);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.q.view_no_network_reply);
        this.aKP = (PbEditor) getView().findViewById(com.baidu.tieba.q.quick_reply_editor);
        this.aKP.aX(true);
        this.aKP.a(getPageContext(), new am(this));
        super.oL();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aDG.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aKP.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean AY() {
        if (this.aKP == null || !this.aKP.isVisible()) {
            return false;
        }
        Kl();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Bs() == 9486) {
            FeedData feedData = (FeedData) bVar.Bt();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bGw) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bGw && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bGw.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.Bx();
                this.bGz = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.c.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.c.c(feedData.getPost_id(), 0L);
                }
                this.bGx.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c CI() {
        if (this.bFX == null) {
            this.bFX = new com.baidu.tbadk.mvc.i.b.c();
            this.bFX.setTitle(getString(com.baidu.tieba.t.mention_replyme));
            this.bFX.eb(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hr().inflate(getActivity(), com.baidu.tieba.r.message_tip_item, null);
            this.bFX.a(cVar);
            this.bFX.eT("msg_tip_key");
        }
        return this.bFX;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    K(intent);
                    int size2 = this.mWriteImagesInfo.size() - 1;
                    if (size2 <= -1 || this.mWriteImagesInfo == null || this.mWriteImagesInfo.getChosedFiles() == null || (size = this.mWriteImagesInfo.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, size2)));
                    return true;
                case 12002:
                    P(intent);
                    return true;
                case 12004:
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                    if (U != null) {
                        this.aKP.u(U);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aJU != null) {
                        WriteData JT = this.aJU.JT();
                        if (JT != null) {
                            JT.deleteUploadedTempImages();
                        }
                        this.aJU.c((WriteData) null);
                        this.aJU.fj(false);
                        bT(true);
                        dF(true);
                        a(this.mWriteImagesInfo, true);
                        this.aDG.notifyDataSetChanged();
                        Kl();
                        return true;
                    }
                    return true;
                case 12012:
                    J(intent);
                    return true;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    JU();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.mWriteImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return true;
                case 12003:
                    return true;
            }
        }
        return false;
    }

    public void P(Intent intent) {
        a(intent, true);
    }

    public void J(Intent intent) {
        a(intent, false);
    }

    public void JU() {
        new an(this).execute(new Void[0]);
    }

    private void K(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.M(getActivity())), com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJS, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
            a(this.mWriteImagesInfo, true);
        }
        if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
            this.aKP.iN(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.mWriteImagesInfo.parseJson(stringExtra);
                this.mWriteImagesInfo.updateQuality();
                if (this.mWriteImagesInfo.getChosedFiles() != null) {
                    a(this.mWriteImagesInfo, z);
                }
            }
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                this.aKP.iN(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.mWriteImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJS);
        bundle.putSerializable("reply_thread", this.bGy);
    }

    public void c(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zs() {
        if (this.aNH == null) {
            String[] strArr = {getString(com.baidu.tieba.t.take_photo), getString(com.baidu.tieba.t.album)};
            this.aNH = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.aNH.co(getString(com.baidu.tieba.t.operation));
            this.aNH.a(strArr, new ao(this));
            this.aNH.d(this.bGp.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bGy.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bGy.getReplyer().getUserName());
            antiData.setUser_id(this.bGy.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zt() {
        if (this.aJU.JT() == null) {
            WriteData JT = JT();
            JT.setWriteImagesInfo(this.mWriteImagesInfo);
            this.aJU.fj(this.mWriteImagesInfo.size() > 0);
            this.aJU.c(JT);
        }
        if (this.aJU.JT() != null) {
            this.aJU.JT().setIsFrsReply(true);
            this.aJU.JT().setContent(this.aKP.getContent());
            VoiceData.VoiceModel audioData = this.aKP.getAudioData();
            this.aKP.Ks();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aJU.JT().setVoice(audioData.getId());
                    this.aJU.JT().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aJU.JT().setVoice(null);
                    this.aJU.JT().setVoiceDuringTime(-1);
                }
            } else {
                this.aJU.JT().setVoice(null);
                this.aJU.JT().setVoiceDuringTime(-1);
            }
            if (!this.aJU.apI()) {
            }
        }
    }

    private WriteData JT() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bGy.getFname());
        writeData.setThreadId(this.bGy.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bGy.getIsFloor()) {
            writeData.setFloor(this.bGA > 0 ? String.valueOf(this.bGA) : this.bGy.getQuote_pid());
        } else {
            writeData.setFloor(this.bGy.getPost_id());
        }
        if (this.bGB > 0) {
            writeData.setRepostId(String.valueOf(this.bGB));
        }
        writeData.setType(2);
        return writeData;
    }

    public void dF(boolean z) {
        if (this.bGy != null) {
            if (z) {
                if (this.bGy.getIsFloor() && this.bGy.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGy.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGy.getThread_id(), (WriteData) null);
                }
            } else if (this.aJU != null && this.aKP != null) {
                WriteData JT = this.aJU.JT();
                if (JT == null) {
                    JT = new WriteData(2);
                    JT.setThreadId(this.bGy.getThread_id());
                    JT.setWriteImagesInfo(this.mWriteImagesInfo);
                }
                JT.setContent(this.aKP.getContent());
                if (this.bGy.getIsFloor() && this.bGy.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGy.getReplyer().getUserId(), JT);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGy.getThread_id(), JT);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (this.bGy != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bGy.getThread_id())) || bb.isEmpty(writeData.getContent()))) {
                if (Bb() && this.bGy.getIsFloor() && this.bGy.getReplyer() != null) {
                    this.aKP.setContent(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGy.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aKP.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (Bb() && this.bGy.getIsFloor() && this.bGy.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGy.getReplyer().getName_show() + ":")) {
                    this.aKP.setContent(content);
                } else {
                    this.aKP.setContent(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGy.getReplyer().getName_show() + ":");
                }
            } else if (Bb() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGy.getReplyer().getName_show() + ":")) {
                this.aKP.setContent(content);
            } else {
                this.aKP.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.mWriteImagesInfo.size() == 0) {
                this.mWriteImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                a(this.mWriteImagesInfo, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z) {
            this.aKP.getEditText().setText("");
            this.aKP.anQ();
            this.aKP.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aKP.cqP.a(writeImagesInfo, z);
    }

    public void Kl() {
        dF(false);
        this.aKP.aa(this.aKP.getEditText());
        this.aKP.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) getActivity(), getString(com.baidu.tieba.t.login_to_use), true, 0)));
            return;
        }
        if (feedData != null && this.aKP != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getThread_id(), this);
            }
            this.mWriteImagesInfo = new WriteImagesInfo();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            a(this.mWriteImagesInfo, true);
            this.aJU.c((WriteData) null);
            this.aJU.fj(false);
            this.aKP.Kr();
        }
        this.bGy = feedData;
        Zu();
    }

    private void Zu() {
        this.bGE = false;
        this.aKP.CR();
        this.aKP.refresh();
        if (this.aKP.anx()) {
            this.aKP.add();
        } else {
            this.aKP.getEditText().requestFocus();
            this.aKP.Z(this.aKP.getEditText());
        }
        L(this.mPosition, this.mBottom);
    }

    protected void L(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.n.dip2px(getActivity(), 40.0f);
        }
        this.bGD = new com.baidu.tbadk.editortool.z(getActivity(), i, i2, this.aKP, this.bGw, i3);
        this.mHandler.postDelayed(this.bGD, 300L);
    }
}
