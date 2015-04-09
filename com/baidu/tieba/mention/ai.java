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
import com.baidu.tbadk.core.util.bd;
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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, w> aBJ;
    private String aHI;
    private com.baidu.tieba.tbadkCore.writeModel.a aHK;
    private WriteImagesInfo aHL;
    private final com.baidu.tieba.tbadkCore.writeModel.d aHO;
    private final AbsListView.OnScrollListener aHR;
    private PbEditor aIG;
    private com.baidu.tbadk.core.dialog.e aLx;
    private BdListView bDA;
    private ab bDB;
    private FeedData bDC;
    private FeedData bDD;
    private long bDE;
    private long bDF;
    private final ad bDG;
    private com.baidu.tbadk.editortool.z bDH;
    private boolean bDI;
    private com.baidu.tbadk.mvc.i.b.c bDb;
    private final SingleMentionActivity bDt;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;

    public ai(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bDA = null;
        this.aHL = new WriteImagesInfo();
        this.bDB = null;
        this.aLx = null;
        this.aHO = new aj(this);
        this.bDG = new ak(this);
        this.bDH = null;
        this.bDI = true;
        this.aHR = new al(this);
        this.bDt = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bDA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aHL = writeImagesInfo;
            }
            this.bDC = (FeedData) bundle.getSerializable("reply_thread");
            this.aHI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aHL.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (this.aBJ != null) {
            this.aBJ.or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aBJ != null) {
            this.aBJ.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aBJ.r(((q) aVar).XP());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return com.baidu.tieba.w.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bDB = new ab(this.bDt);
        this.bDB.a(this.bDG);
        this.aHK = new com.baidu.tieba.tbadkCore.writeModel.a(zY());
        this.aHK.a(this.aHO);
        this.bDA = (BdListView) getView().findViewById(com.baidu.tieba.v.replyme_lv);
        this.bDA.setOnScrollListener(this.aHR);
        this.aBJ = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), w.class, com.baidu.tieba.w.mention_replyme_item, zZ());
        this.aBJ.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.mention_replyme_nodata), (com.baidu.tbadk.core.view.u) null, (FrameLayout.LayoutParams) null);
        this.bDA.setAdapter((ListAdapter) this.aBJ);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network_reply);
        this.aIG = (PbEditor) getView().findViewById(com.baidu.tieba.v.quick_reply_editor);
        this.aIG.aQ(true);
        this.aIG.a(getPageContext(), new am(this));
        super.ov();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aBJ.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aIG.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean Al() {
        if (this.aIG == null || !this.aIG.isVisible()) {
            return false;
        }
        Jg();
        return true;
    }

    public void c(com.baidu.tbadk.mvc.c.b bVar) {
        long a;
        if (bVar != null && bVar.AF() == 9486) {
            FeedData feedData = (FeedData) bVar.AG();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bDA) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bDA && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bDA.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.AK();
                this.bDD = feedData;
                if (feedData.getIsFloor()) {
                    a = com.baidu.adp.lib.g.c.a(feedData.getQuote_pid(), 0L);
                } else {
                    a = com.baidu.adp.lib.g.c.a(feedData.getPost_id(), 0L);
                }
                this.bDB.a(a, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c BV() {
        if (this.bDb == null) {
            this.bDb = new com.baidu.tbadk.mvc.i.b.c();
            this.bDb.setTitle(getString(com.baidu.tieba.y.mention_replyme));
            this.bDb.dR(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hH().inflate(getActivity(), com.baidu.tieba.w.message_tip_item, null);
            this.bDb.a(cVar);
            this.bDb.eC("msg_tip_key");
        }
        return this.bDb;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    L(intent);
                    int size2 = this.aHL.size() - 1;
                    if (size2 <= -1 || this.aHL == null || this.aHL.getChosedFiles() == null || (size = this.aHL.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.aHL, size2)));
                    return true;
                case 12002:
                    Q(intent);
                    return true;
                case 12004:
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V != null) {
                        this.aIG.v(V);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aHK != null) {
                        WriteData IS = this.aHK.IS();
                        if (IS != null) {
                            IS.deleteUploadedTempImages();
                        }
                        this.aHK.c((WriteData) null);
                        this.aHK.eQ(false);
                        bK(true);
                        du(true);
                        a(this.aHL, true);
                        this.aBJ.notifyDataSetChanged();
                        Jg();
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
                    IT();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.aHL.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return true;
                case 12003:
                    return true;
            }
        }
        return false;
    }

    public void Q(Intent intent) {
        a(intent, true);
    }

    public void K(Intent intent) {
        a(intent, false);
    }

    public void IT() {
        new an(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.M(getActivity())), com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aHL.addChooseFile(imageFileInfo);
            this.aHL.updateQuality();
            a(this.aHL, true);
        }
        if (this.aHL.getChosedFiles() != null && this.aHL.getChosedFiles().size() > 0) {
            this.aIG.ir(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aHL.parseJson(stringExtra);
                this.aHL.updateQuality();
                if (this.aHL.getChosedFiles() != null) {
                    a(this.aHL, z);
                }
            }
            if (this.aHL.getChosedFiles() != null && this.aHL.getChosedFiles().size() > 0) {
                this.aIG.ir(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aHL);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHI);
        bundle.putSerializable("reply_thread", this.bDC);
    }

    public void c(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XS() {
        if (this.aLx == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            this.aLx = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.aLx.cb(getString(com.baidu.tieba.y.operation));
            this.aLx.a(strArr, new ao(this));
            this.aLx.d(this.bDt.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bDC.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bDC.getReplyer().getUserName());
            antiData.setUser_id(this.bDC.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        if (this.aHK.IS() == null) {
            WriteData IS = IS();
            IS.setWriteImagesInfo(this.aHL);
            this.aHK.eQ(this.aHL.size() > 0);
            this.aHK.c(IS);
        }
        if (this.aHK.IS() != null) {
            this.aHK.IS().setIsFrsReply(true);
            this.aHK.IS().setContent(this.aIG.getContent());
            VoiceData.VoiceModel audioData = this.aIG.getAudioData();
            this.aIG.Jn();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aHK.IS().setVoice(audioData.getId());
                    this.aHK.IS().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aHK.IS().setVoice(null);
                    this.aHK.IS().setVoiceDuringTime(-1);
                }
            } else {
                this.aHK.IS().setVoice(null);
                this.aHK.IS().setVoiceDuringTime(-1);
            }
            if (!this.aHK.anP()) {
            }
        }
    }

    private WriteData IS() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bDC.getFname());
        writeData.setThreadId(this.bDC.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bDC.getIsFloor()) {
            writeData.setFloor(this.bDE > 0 ? String.valueOf(this.bDE) : this.bDC.getQuote_pid());
        } else {
            writeData.setFloor(this.bDC.getPost_id());
        }
        if (this.bDF > 0) {
            writeData.setRepostId(String.valueOf(this.bDF));
        }
        writeData.setType(2);
        return writeData;
    }

    public void du(boolean z) {
        if (this.bDC != null) {
            if (z) {
                if (this.bDC.getIsFloor() && this.bDC.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDC.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDC.getThread_id(), (WriteData) null);
                }
            } else if (this.aHK != null && this.aIG != null) {
                WriteData IS = this.aHK.IS();
                if (IS == null) {
                    IS = new WriteData(2);
                    IS.setThreadId(this.bDC.getThread_id());
                    IS.setWriteImagesInfo(this.aHL);
                }
                IS.setContent(this.aIG.getContent());
                if (this.bDC.getIsFloor() && this.bDC.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDC.getReplyer().getUserId(), IS);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDC.getThread_id(), IS);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (this.bDC != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bDC.getThread_id())) || bd.isEmpty(writeData.getContent()))) {
                if (Ao() && this.bDC.getIsFloor() && this.bDC.getReplyer() != null) {
                    this.aIG.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDC.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aIG.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (Ao() && this.bDC.getIsFloor() && this.bDC.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDC.getReplyer().getName_show() + ":")) {
                    this.aIG.setContent(content);
                } else {
                    this.aIG.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDC.getReplyer().getName_show() + ":");
                }
            } else if (Ao() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDC.getReplyer().getName_show() + ":")) {
                this.aIG.setContent(content);
            } else {
                this.aIG.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.aHL.size() == 0) {
                this.aHL.copyFrom(writeData.getWriteImagesInfo());
                a(this.aHL, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.aIG.getEditText().setText("");
            this.aIG.amd();
            this.aIG.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aIG.cmP.a(writeImagesInfo, z);
    }

    public void Jg() {
        du(false);
        this.aIG.Z(this.aIG.getEditText());
        this.aIG.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getActivity(), getString(com.baidu.tieba.y.login_to_use), true, 0)));
            return;
        }
        if (feedData != null && this.aIG != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getThread_id(), this);
            }
            this.aHL = new WriteImagesInfo();
            this.aHL.setMaxImagesAllowed(10);
            a(this.aHL, true);
            this.aHK.c((WriteData) null);
            this.aHK.eQ(false);
            this.aIG.Jm();
        }
        this.bDC = feedData;
        XU();
    }

    private void XU() {
        this.bDI = false;
        this.aIG.Cf();
        this.aIG.refresh();
        if (this.aIG.alK()) {
            this.aIG.acy();
        } else {
            this.aIG.getEditText().requestFocus();
            this.aIG.Y(this.aIG.getEditText());
        }
        K(this.mPosition, this.mBottom);
    }

    protected void K(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.n.dip2px(getActivity(), 40.0f);
        }
        this.bDH = new com.baidu.tbadk.editortool.z(getActivity(), i, i2, this.aIG, this.bDA, i3);
        this.mHandler.postDelayed(this.bDH, 300L);
    }
}
