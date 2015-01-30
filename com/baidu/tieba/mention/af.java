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
import com.baidu.tbadk.core.util.bf;
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
    private String aBK;
    private com.baidu.tieba.tbadkCore.f.a aBM;
    private final com.baidu.tieba.tbadkCore.f.b aBP;
    private final AbsListView.OnScrollListener aBS;
    private PbEditor aCF;
    private AlertDialog aFr;
    private WriteImagesInfo aql;
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, t> atT;
    private SingleMentionActivity btL;
    private BdListView btS;
    private y btT;
    private FeedData btU;
    private FeedData btV;
    private long btW;
    private long btX;
    private aa btY;
    private com.baidu.tbadk.editortool.aa btZ;
    private com.baidu.tbadk.mvc.i.b.c btt;
    private boolean bua;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;

    public af(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btS = null;
        this.aql = new WriteImagesInfo();
        this.btT = null;
        this.aFr = null;
        this.aBP = new ag(this);
        this.btY = new ah(this);
        this.btZ = null;
        this.bua = true;
        this.aBS = new ai(this);
        this.btL = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.btS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aql = writeImagesInfo;
            }
            this.btU = (FeedData) bundle.getSerializable("reply_thread");
            this.aBK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aql.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kF() {
        super.kF();
        if (this.atT != null) {
            this.atT.kF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.atT != null) {
            this.atT.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.atT.w(((q) aVar).Uo());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return com.baidu.tieba.x.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.btT = new y(this.btL);
        this.btT.a(this.btY);
        this.aBM = new com.baidu.tieba.tbadkCore.f.a(wM());
        this.aBM.a(this.aBP);
        this.btS = (BdListView) getView().findViewById(com.baidu.tieba.w.replyme_lv);
        this.btS.setOnScrollListener(this.aBS);
        this.atT = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), t.class, com.baidu.tieba.x.mention_replyme_item, wN());
        this.atT.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.mention_replyme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.btS.setAdapter((ListAdapter) this.atT);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_reply);
        this.aCF = (PbEditor) getView().findViewById(com.baidu.tieba.w.quick_reply_editor);
        this.aCF.aK(true);
        this.aCF.a(getPageContext(), new aj(this));
        super.kJ();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.atT.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aCF.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean wZ() {
        if (this.aCF == null || !this.aCF.isVisible()) {
            return false;
        }
        FH();
        return true;
    }

    public void b(com.baidu.tbadk.mvc.c.b bVar) {
        long a;
        if (bVar != null && bVar.xs() == 9486) {
            FeedData feedData = (FeedData) bVar.xt();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.btS) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.btS && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.btS.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.xx();
                this.btV = feedData;
                if (feedData.getIsFloor()) {
                    a = com.baidu.adp.lib.g.c.a(feedData.getQuote_pid(), 0L);
                } else {
                    a = com.baidu.adp.lib.g.c.a(feedData.getPost_id(), 0L);
                }
                this.btT.a(a, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yH() {
        if (this.btt == null) {
            this.btt = new com.baidu.tbadk.mvc.i.b.c();
            this.btt.setTitle(getString(com.baidu.tieba.z.mention_replyme));
            this.btt.dO(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.btt.a(cVar);
            this.btt.ey("msg_tip_key");
        }
        return this.btt;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    M(intent);
                    int size2 = this.aql.size() - 1;
                    if (size2 <= -1 || this.aql == null || this.aql.getChosedFiles() == null || (size = this.aql.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.aql, size2)));
                    return true;
                case 12002:
                    S(intent);
                    return true;
                case 12004:
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.aCF.A(W);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aBM != null) {
                        WriteData Ft = this.aBM.Ft();
                        if (Ft != null) {
                            Ft.deleteUploadedTempImages();
                        }
                        this.aBM.c((WriteData) null);
                        this.aBM.eF(false);
                        bG(true);
                        ds(true);
                        a(this.aql, true);
                        this.atT.notifyDataSetChanged();
                        FH();
                        return true;
                    }
                    return true;
                case 12012:
                    L(intent);
                    return true;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fu();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.aql.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return true;
                case 12003:
                    return true;
            }
        }
        return false;
    }

    public void S(Intent intent) {
        a(intent, true);
    }

    public void L(Intent intent) {
        a(intent, false);
    }

    public void Fu() {
        new ak(this).execute(new Void[0]);
    }

    private void M(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cb = com.baidu.tbadk.core.util.d.cb(str);
                if (cb != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.M(getActivity())), com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cb);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBK, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aql.addChooseFile(imageFileInfo);
            this.aql.updateQuality();
            a(this.aql, true);
        }
        if (this.aql.getChosedFiles() != null && this.aql.getChosedFiles().size() > 0) {
            this.aCF.hQ(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aql.parseJson(stringExtra);
                this.aql.updateQuality();
                if (this.aql.getChosedFiles() != null) {
                    a(this.aql, z);
                }
            }
            if (this.aql.getChosedFiles() != null && this.aql.getChosedFiles().size() > 0) {
                this.aCF.hQ(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aql);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBK);
        bundle.putSerializable("reply_thread", this.btU);
    }

    public void b(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        if (this.aFr == null) {
            String[] strArr = {getString(com.baidu.tieba.z.take_photo), getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new al(this));
            this.aFr = builder.create();
            this.aFr.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.btU.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.btU.getReplyer().getUserName());
            antiData.setUser_id(this.btU.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        if (this.aBM.Ft() == null) {
            WriteData Ft = Ft();
            Ft.setWriteImagesInfo(this.aql);
            this.aBM.eF(this.aql.size() > 0);
            this.aBM.c(Ft);
        }
        if (this.aBM.Ft() != null) {
            this.aBM.Ft().setIsFrsReply(true);
            this.aBM.Ft().setContent(this.aCF.getContent());
            VoiceData.VoiceModel audioData = this.aCF.getAudioData();
            this.aCF.FO();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBM.Ft().setVoice(audioData.getId());
                    this.aBM.Ft().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBM.Ft().setVoice(null);
                    this.aBM.Ft().setVoiceDuringTime(-1);
                }
            } else {
                this.aBM.Ft().setVoice(null);
                this.aBM.Ft().setVoiceDuringTime(-1);
            }
            if (!this.aBM.aiF()) {
            }
        }
    }

    private WriteData Ft() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.btU.getFname());
        writeData.setThreadId(this.btU.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.btU.getIsFloor()) {
            writeData.setFloor(this.btW > 0 ? String.valueOf(this.btW) : this.btU.getQuote_pid());
        } else {
            writeData.setFloor(this.btU.getPost_id());
        }
        if (this.btX > 0) {
            writeData.setRepostId(String.valueOf(this.btX));
        }
        writeData.setType(2);
        return writeData;
    }

    public void ds(boolean z) {
        if (this.btU != null) {
            if (z) {
                if (this.btU.getIsFloor() && this.btU.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.btU.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.btU.getThread_id(), (WriteData) null);
                }
            } else if (this.aBM != null && this.aCF != null) {
                WriteData Ft = this.aBM.Ft();
                if (Ft == null) {
                    Ft = new WriteData(2);
                    Ft.setThreadId(this.btU.getThread_id());
                    Ft.setWriteImagesInfo(this.aql);
                }
                Ft.setContent(this.aCF.getContent());
                if (this.btU.getIsFloor() && this.btU.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.btU.getReplyer().getUserId(), Ft);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.btU.getThread_id(), Ft);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (this.btU != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.btU.getThread_id())) || bf.isEmpty(writeData.getContent()))) {
                if (xc() && this.btU.getIsFloor() && this.btU.getReplyer() != null) {
                    this.aCF.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btU.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aCF.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (xc() && this.btU.getIsFloor() && this.btU.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btU.getReplyer().getName_show() + ":")) {
                    this.aCF.setContent(content);
                } else {
                    this.aCF.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btU.getReplyer().getName_show() + ":");
                }
            } else if (xc() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btU.getReplyer().getName_show() + ":")) {
                this.aCF.setContent(content);
            } else {
                this.aCF.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.aql.size() == 0) {
                this.aql.copyFrom(writeData.getWriteImagesInfo());
                a(this.aql, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (z) {
            this.aCF.getEditText().setText("");
            this.aCF.agg();
            this.aCF.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCF.bWk.a(writeImagesInfo, z);
    }

    public void FH() {
        ds(false);
        this.aCF.W(this.aCF.getEditText());
        this.aCF.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(getActivity(), getString(com.baidu.tieba.z.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.aCF != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.al.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(feedData.getThread_id(), this);
            }
            this.aql = new WriteImagesInfo();
            this.aql.setMaxImagesAllowed(10);
            a(this.aql, true);
            this.aBM.c((WriteData) null);
            this.aBM.eF(false);
            this.aCF.FN();
        }
        this.btU = feedData;
        Us();
    }

    private void Us() {
        this.bua = false;
        this.aCF.yR();
        this.aCF.refresh();
        if (this.aCF.afN()) {
            this.aCF.aae();
        } else {
            this.aCF.getEditText().requestFocus();
            this.aCF.V(this.aCF.getEditText());
        }
        K(this.mPosition, this.mBottom);
    }

    protected void K(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.l.dip2px(getActivity(), 40.0f);
        }
        this.btZ = new com.baidu.tbadk.editortool.aa(getActivity(), i, i2, this.aCF, this.btS, i3);
        this.mHandler.postDelayed(this.btZ, 300L);
    }
}
