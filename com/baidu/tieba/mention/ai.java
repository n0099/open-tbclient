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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, w> aDF;
    private String aJR;
    private com.baidu.tieba.tbadkCore.writeModel.a aJT;
    private final com.baidu.tieba.tbadkCore.writeModel.d aJW;
    private final AbsListView.OnScrollListener aJZ;
    private PbEditor aKO;
    private com.baidu.tbadk.core.dialog.e aNG;
    private com.baidu.tbadk.mvc.i.b.c bFW;
    private long bGA;
    private final ad bGB;
    private com.baidu.tbadk.editortool.z bGC;
    private boolean bGD;
    private final SingleMentionActivity bGo;
    private BdListView bGv;
    private ab bGw;
    private FeedData bGx;
    private FeedData bGy;
    private long bGz;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;
    private WriteImagesInfo mWriteImagesInfo;

    public ai(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bGv = null;
        this.mWriteImagesInfo = new WriteImagesInfo();
        this.bGw = null;
        this.aNG = null;
        this.aJW = new aj(this);
        this.bGB = new ak(this);
        this.bGC = null;
        this.bGD = true;
        this.aJZ = new al(this);
        this.bGo = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bGv;
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
            this.bGx = (FeedData) bundle.getSerializable("reply_thread");
            this.aJR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.mWriteImagesInfo.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oH() {
        super.oH();
        if (this.aDF != null) {
            this.aDF.oH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aDF != null) {
            this.aDF.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aDF.s(((q) aVar).Zo());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return com.baidu.tieba.r.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.bGw = new ab(this.bGo);
        this.bGw.a(this.bGB);
        this.aJT = new com.baidu.tieba.tbadkCore.writeModel.a(AK());
        this.aJT.a(this.aJW);
        this.bGv = (BdListView) getView().findViewById(com.baidu.tieba.q.replyme_lv);
        this.bGv.setOnScrollListener(this.aJZ);
        this.aDF = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), w.class, com.baidu.tieba.r.mention_replyme_item, AL());
        this.aDF.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.mention_replyme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.bGv.setAdapter((ListAdapter) this.aDF);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.q.view_no_network_reply);
        this.aKO = (PbEditor) getView().findViewById(com.baidu.tieba.q.quick_reply_editor);
        this.aKO.aX(true);
        this.aKO.a(getPageContext(), new am(this));
        super.oL();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aDF.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aKO.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean AX() {
        if (this.aKO == null || !this.aKO.isVisible()) {
            return false;
        }
        Kk();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Br() == 9486) {
            FeedData feedData = (FeedData) bVar.Bs();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bGv) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bGv && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bGv.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.Bw();
                this.bGy = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.c.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.c.c(feedData.getPost_id(), 0L);
                }
                this.bGw.a(c, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c CH() {
        if (this.bFW == null) {
            this.bFW = new com.baidu.tbadk.mvc.i.b.c();
            this.bFW.setTitle(getString(com.baidu.tieba.t.mention_replyme));
            this.bFW.eb(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hr().inflate(getActivity(), com.baidu.tieba.r.message_tip_item, null);
            this.bFW.a(cVar);
            this.bFW.eT("msg_tip_key");
        }
        return this.bFW;
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
                        this.aKO.u(U);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aJT != null) {
                        WriteData JS = this.aJT.JS();
                        if (JS != null) {
                            JS.deleteUploadedTempImages();
                        }
                        this.aJT.c((WriteData) null);
                        this.aJT.fj(false);
                        bT(true);
                        dF(true);
                        a(this.mWriteImagesInfo, true);
                        this.aDF.notifyDataSetChanged();
                        Kk();
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
                    JT();
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

    public void JT() {
        new an(this).execute(new Void[0]);
    }

    private void K(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.M(getActivity())), com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJR, h, 100);
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
            this.aKO.iN(23);
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
                this.aKO.iN(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.mWriteImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJR);
        bundle.putSerializable("reply_thread", this.bGx);
    }

    public void c(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        if (this.aNG == null) {
            String[] strArr = {getString(com.baidu.tieba.t.take_photo), getString(com.baidu.tieba.t.album)};
            this.aNG = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.aNG.co(getString(com.baidu.tieba.t.operation));
            this.aNG.a(strArr, new ao(this));
            this.aNG.d(this.bGo.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bGx.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bGx.getReplyer().getUserName());
            antiData.setUser_id(this.bGx.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zs() {
        if (this.aJT.JS() == null) {
            WriteData JS = JS();
            JS.setWriteImagesInfo(this.mWriteImagesInfo);
            this.aJT.fj(this.mWriteImagesInfo.size() > 0);
            this.aJT.c(JS);
        }
        if (this.aJT.JS() != null) {
            this.aJT.JS().setIsFrsReply(true);
            this.aJT.JS().setContent(this.aKO.getContent());
            VoiceData.VoiceModel audioData = this.aKO.getAudioData();
            this.aKO.Kr();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aJT.JS().setVoice(audioData.getId());
                    this.aJT.JS().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aJT.JS().setVoice(null);
                    this.aJT.JS().setVoiceDuringTime(-1);
                }
            } else {
                this.aJT.JS().setVoice(null);
                this.aJT.JS().setVoiceDuringTime(-1);
            }
            if (!this.aJT.apH()) {
            }
        }
    }

    private WriteData JS() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bGx.getFname());
        writeData.setThreadId(this.bGx.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bGx.getIsFloor()) {
            writeData.setFloor(this.bGz > 0 ? String.valueOf(this.bGz) : this.bGx.getQuote_pid());
        } else {
            writeData.setFloor(this.bGx.getPost_id());
        }
        if (this.bGA > 0) {
            writeData.setRepostId(String.valueOf(this.bGA));
        }
        writeData.setType(2);
        return writeData;
    }

    public void dF(boolean z) {
        if (this.bGx != null) {
            if (z) {
                if (this.bGx.getIsFloor() && this.bGx.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGx.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGx.getThread_id(), (WriteData) null);
                }
            } else if (this.aJT != null && this.aKO != null) {
                WriteData JS = this.aJT.JS();
                if (JS == null) {
                    JS = new WriteData(2);
                    JS.setThreadId(this.bGx.getThread_id());
                    JS.setWriteImagesInfo(this.mWriteImagesInfo);
                }
                JS.setContent(this.aKO.getContent());
                if (this.bGx.getIsFloor() && this.bGx.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGx.getReplyer().getUserId(), JS);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bGx.getThread_id(), JS);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (this.bGx != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bGx.getThread_id())) || bb.isEmpty(writeData.getContent()))) {
                if (Ba() && this.bGx.getIsFloor() && this.bGx.getReplyer() != null) {
                    this.aKO.setContent(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGx.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aKO.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (Ba() && this.bGx.getIsFloor() && this.bGx.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGx.getReplyer().getName_show() + ":")) {
                    this.aKO.setContent(content);
                } else {
                    this.aKO.setContent(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGx.getReplyer().getName_show() + ":");
                }
            } else if (Ba() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.t.mention_replyme)) + this.bGx.getReplyer().getName_show() + ":")) {
                this.aKO.setContent(content);
            } else {
                this.aKO.setContent(null);
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
            this.aKO.getEditText().setText("");
            this.aKO.anP();
            this.aKO.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aKO.cqO.a(writeImagesInfo, z);
    }

    public void Kk() {
        dF(false);
        this.aKO.aa(this.aKO.getEditText());
        this.aKO.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) getActivity(), getString(com.baidu.tieba.t.login_to_use), true, 0)));
            return;
        }
        if (feedData != null && this.aKO != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getThread_id(), this);
            }
            this.mWriteImagesInfo = new WriteImagesInfo();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            a(this.mWriteImagesInfo, true);
            this.aJT.c((WriteData) null);
            this.aJT.fj(false);
            this.aKO.Kq();
        }
        this.bGx = feedData;
        Zt();
    }

    private void Zt() {
        this.bGD = false;
        this.aKO.CQ();
        this.aKO.refresh();
        if (this.aKO.anw()) {
            this.aKO.adc();
        } else {
            this.aKO.getEditText().requestFocus();
            this.aKO.Z(this.aKO.getEditText());
        }
        L(this.mPosition, this.mBottom);
    }

    protected void L(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.n.dip2px(getActivity(), 40.0f);
        }
        this.bGC = new com.baidu.tbadk.editortool.z(getActivity(), i, i2, this.aKO, this.bGv, i3);
        this.mHandler.postDelayed(this.bGC, 300L);
    }
}
