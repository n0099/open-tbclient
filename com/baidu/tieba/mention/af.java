package com.baidu.tieba.mention;

import android.app.AlertDialog;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.am;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends l implements am {
    private String aAI;
    private com.baidu.tieba.tbadkCore.f.a aAK;
    private final com.baidu.tieba.tbadkCore.f.b aAN;
    private final AbsListView.OnScrollListener aAQ;
    private AlertDialog aAR;
    private PbEditor aBE;
    private WriteImagesInfo apq;
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, t> asM;
    private com.baidu.tbadk.mvc.i.b.c brW;
    private long bsA;
    private aa bsB;
    private com.baidu.tbadk.editortool.aa bsC;
    private boolean bsD;
    private SingleMentionActivity bso;
    private BdListView bsv;
    private y bsw;
    private FeedData bsx;
    private FeedData bsy;
    private long bsz;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;

    public af(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bsv = null;
        this.apq = new WriteImagesInfo();
        this.bsw = null;
        this.aAR = null;
        this.aAN = new ag(this);
        this.bsB = new ah(this);
        this.bsC = null;
        this.bsD = true;
        this.aAQ = new ai(this);
        this.bso = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bsv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.apq = writeImagesInfo;
            }
            this.bsx = (FeedData) bundle.getSerializable("reply_thread");
            this.aAI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.apq.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (this.asM != null) {
            this.asM.kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.asM != null) {
            this.asM.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.asM.w(((q) aVar).TR());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return com.baidu.tieba.x.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.bsw = new y(this.bso);
        this.bsw.a(this.bsB);
        this.aAK = new com.baidu.tieba.tbadkCore.f.a(ww());
        this.aAK.a(this.aAN);
        this.bsv = (BdListView) getView().findViewById(com.baidu.tieba.w.replyme_lv);
        this.bsv.setOnScrollListener(this.aAQ);
        this.asM = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), t.class, com.baidu.tieba.x.mention_replyme_item, wx());
        this.asM.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.mention_replyme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.bsv.setAdapter((ListAdapter) this.asM);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_reply);
        this.aBE = (PbEditor) getView().findViewById(com.baidu.tieba.w.quick_reply_editor);
        this.aBE.aI(true);
        this.aBE.a(getPageContext(), new aj(this));
        super.kJ();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.asM.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aBE.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean wJ() {
        if (this.aBE == null || !this.aBE.isVisible()) {
            return false;
        }
        Fj();
        return true;
    }

    public void b(com.baidu.tbadk.mvc.c.b bVar) {
        long a;
        if (bVar != null && bVar.xc() == 9486) {
            FeedData feedData = (FeedData) bVar.xd();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bsv) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bsv && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bsv.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.xh();
                this.bsy = feedData;
                if (feedData.getIsFloor()) {
                    a = com.baidu.adp.lib.g.c.a(feedData.getQuote_pid(), 0L);
                } else {
                    a = com.baidu.adp.lib.g.c.a(feedData.getPost_id(), 0L);
                }
                this.bsw.a(a, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yr() {
        if (this.brW == null) {
            this.brW = new com.baidu.tbadk.mvc.i.b.c();
            this.brW.setTitle(getString(com.baidu.tieba.z.mention_replyme));
            this.brW.dI(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ek().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.brW.a(cVar);
            this.brW.ey("msg_tip_key");
        }
        return this.brW;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    L(intent);
                    int size2 = this.apq.size() - 1;
                    if (size2 <= -1 || this.apq == null || this.apq.getChosedFiles() == null || (size = this.apq.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.apq, size2)));
                    return true;
                case 12002:
                    J(intent);
                    return true;
                case 12004:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.i.T(intent);
                    if (T != null) {
                        this.aBE.z(T);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aAK != null) {
                        WriteData EV = this.aAK.EV();
                        if (EV != null) {
                            EV.deleteUploadedTempImages();
                        }
                        this.aAK.c((WriteData) null);
                        this.aAK.ey(false);
                        bD(true);
                        dm(true);
                        a(this.apq, true);
                        this.asM.notifyDataSetChanged();
                        Fj();
                        return true;
                    }
                    return true;
                case 12012:
                    K(intent);
                    return true;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EW();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.apq.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return true;
                case 12003:
                    return true;
            }
        }
        return false;
    }

    public void J(Intent intent) {
        a(intent, true);
    }

    public void K(Intent intent) {
        a(intent, false);
    }

    public void EW() {
        new ak(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cd = com.baidu.tbadk.core.util.d.cd(str);
                if (cd != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.M(getActivity())), com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cd);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aAI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.apq.addChooseFile(imageFileInfo);
            this.apq.updateQuality();
            a(this.apq, true);
        }
        if (this.apq.getChosedFiles() != null && this.apq.getChosedFiles().size() > 0) {
            this.aBE.hH(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.apq.parseJson(stringExtra);
                this.apq.updateQuality();
                if (this.apq.getChosedFiles() != null) {
                    a(this.apq, z);
                }
            }
            if (this.apq.getChosedFiles() != null && this.apq.getChosedFiles().size() > 0) {
                this.aBE.hH(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.apq);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAI);
        bundle.putSerializable("reply_thread", this.bsx);
    }

    public void b(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU() {
        if (this.aAR == null) {
            String[] strArr = {getString(com.baidu.tieba.z.take_photo), getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new al(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bsx.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bsx.getReplyer().getUserName());
            antiData.setUser_id(this.bsx.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TT() {
        if (this.aAK.EV() == null) {
            WriteData EV = EV();
            EV.setWriteImagesInfo(this.apq);
            this.aAK.ey(this.apq.size() > 0);
            this.aAK.c(EV);
        }
        if (this.aAK.EV() != null) {
            this.aAK.EV().setIsFrsReply(true);
            this.aAK.EV().setContent(this.aBE.getContent());
            VoiceData.VoiceModel audioData = this.aBE.getAudioData();
            this.aBE.Fq();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aAK.EV().setVoice(audioData.getId());
                    this.aAK.EV().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aAK.EV().setVoice(null);
                    this.aAK.EV().setVoiceDuringTime(-1);
                }
            } else {
                this.aAK.EV().setVoice(null);
                this.aAK.EV().setVoiceDuringTime(-1);
            }
            if (!this.aAK.aib()) {
            }
        }
    }

    private WriteData EV() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bsx.getFname());
        writeData.setThreadId(this.bsx.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bsx.getIsFloor()) {
            writeData.setFloor(this.bsz > 0 ? String.valueOf(this.bsz) : this.bsx.getQuote_pid());
        } else {
            writeData.setFloor(this.bsx.getPost_id());
        }
        if (this.bsA > 0) {
            writeData.setRepostId(String.valueOf(this.bsA));
        }
        writeData.setType(2);
        return writeData;
    }

    public void dm(boolean z) {
        if (this.bsx != null) {
            if (z) {
                if (this.bsx.getIsFloor() && this.bsx.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.bsx.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.bsx.getThread_id(), (WriteData) null);
                }
            } else if (this.aAK != null && this.aBE != null) {
                WriteData EV = this.aAK.EV();
                if (EV == null) {
                    EV = new WriteData(2);
                    EV.setThreadId(this.bsx.getThread_id());
                    EV.setWriteImagesInfo(this.apq);
                }
                EV.setContent(this.aBE.getContent());
                if (this.bsx.getIsFloor() && this.bsx.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.bsx.getReplyer().getUserId(), EV);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.bsx.getThread_id(), EV);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (this.bsx != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bsx.getThread_id())) || ba.isEmpty(writeData.getContent()))) {
                if (wM() && this.bsx.getIsFloor() && this.bsx.getReplyer() != null) {
                    this.aBE.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.bsx.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aBE.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (wM() && this.bsx.getIsFloor() && this.bsx.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.bsx.getReplyer().getName_show() + ":")) {
                    this.aBE.setContent(content);
                } else {
                    this.aBE.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.bsx.getReplyer().getName_show() + ":");
                }
            } else if (wM() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.bsx.getReplyer().getName_show() + ":")) {
                this.aBE.setContent(content);
            } else {
                this.aBE.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.apq.size() == 0) {
                this.apq.copyFrom(writeData.getWriteImagesInfo());
                a(this.apq, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(boolean z) {
        if (z) {
            this.aBE.getEditText().setText("");
            this.aBE.afC();
            this.aBE.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBE.bUs.a(writeImagesInfo, z);
    }

    public void Fj() {
        dm(false);
        this.aBE.U(this.aBE.getEditText());
        this.aBE.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(getActivity(), getString(com.baidu.tieba.z.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.aBE != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.al.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(feedData.getThread_id(), this);
            }
            this.apq = new WriteImagesInfo();
            this.apq.setMaxImagesAllowed(10);
            a(this.apq, true);
            this.aAK.c((WriteData) null);
            this.aAK.ey(false);
            this.aBE.Fp();
        }
        this.bsx = feedData;
        TU();
    }

    private void TU() {
        this.bsD = false;
        this.aBE.yB();
        this.aBE.refresh();
        if (this.aBE.afj()) {
            this.aBE.Zz();
        } else {
            this.aBE.getEditText().requestFocus();
            this.aBE.T(this.aBE.getEditText());
        }
        J(this.mPosition, this.mBottom);
    }

    protected void J(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.l.dip2px(getActivity(), 40.0f);
        }
        this.bsC = new com.baidu.tbadk.editortool.aa(getActivity(), i, i2, this.aBE, this.bsv, i3);
        this.mHandler.postDelayed(this.bsC, 300L);
    }
}
