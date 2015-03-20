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
    private com.baidu.tbadk.mvc.j.d<FeedData, com.baidu.tbadk.mvc.e.c, w> aBB;
    private String aHA;
    private com.baidu.tieba.tbadkCore.writeModel.a aHC;
    private WriteImagesInfo aHD;
    private final com.baidu.tieba.tbadkCore.writeModel.d aHG;
    private final AbsListView.OnScrollListener aHJ;
    private PbEditor aIy;
    private com.baidu.tbadk.core.dialog.e aLn;
    private com.baidu.tbadk.mvc.i.b.c bCO;
    private final SingleMentionActivity bDg;
    private BdListView bDn;
    private ab bDo;
    private FeedData bDp;
    private FeedData bDq;
    private long bDr;
    private long bDs;
    private final ad bDt;
    private com.baidu.tbadk.editortool.z bDu;
    private boolean bDv;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;

    public ai(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bDn = null;
        this.aHD = new WriteImagesInfo();
        this.bDo = null;
        this.aLn = null;
        this.aHG = new aj(this);
        this.bDt = new ak(this);
        this.bDu = null;
        this.bDv = true;
        this.aHJ = new al(this);
        this.bDg = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.bDn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aHD = writeImagesInfo;
            }
            this.bDp = (FeedData) bundle.getSerializable("reply_thread");
            this.aHA = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aHD.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void or() {
        super.or();
        if (this.aBB != null) {
            this.aBB.or();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aBB != null) {
            this.aBB.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.aBB.r(((q) aVar).XD());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return com.baidu.tieba.w.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bDo = new ab(this.bDg);
        this.bDo.a(this.bDt);
        this.aHC = new com.baidu.tieba.tbadkCore.writeModel.a(zS());
        this.aHC.a(this.aHG);
        this.bDn = (BdListView) getView().findViewById(com.baidu.tieba.v.replyme_lv);
        this.bDn.setOnScrollListener(this.aHJ);
        this.aBB = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), w.class, com.baidu.tieba.w.mention_replyme_item, zT());
        this.aBB.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.mention_replyme_nodata), (com.baidu.tbadk.core.view.u) null, (FrameLayout.LayoutParams) null);
        this.bDn.setAdapter((ListAdapter) this.aBB);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network_reply);
        this.aIy = (PbEditor) getView().findViewById(com.baidu.tieba.v.quick_reply_editor);
        this.aIy.aQ(true);
        this.aIy.a(getPageContext(), new am(this));
        super.ov();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aBB.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aIy.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean Af() {
        if (this.aIy == null || !this.aIy.isVisible()) {
            return false;
        }
        Ja();
        return true;
    }

    public void c(com.baidu.tbadk.mvc.c.b bVar) {
        long a;
        if (bVar != null && bVar.Az() == 9486) {
            FeedData feedData = (FeedData) bVar.AA();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.bDn) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.bDn && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.bDn.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.AE();
                this.bDq = feedData;
                if (feedData.getIsFloor()) {
                    a = com.baidu.adp.lib.g.c.a(feedData.getQuote_pid(), 0L);
                } else {
                    a = com.baidu.adp.lib.g.c.a(feedData.getPost_id(), 0L);
                }
                this.bDo.a(a, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c BP() {
        if (this.bCO == null) {
            this.bCO = new com.baidu.tbadk.mvc.i.b.c();
            this.bCO.setTitle(getString(com.baidu.tieba.y.mention_replyme));
            this.bCO.dR(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.hH().inflate(getActivity(), com.baidu.tieba.w.message_tip_item, null);
            this.bCO.a(cVar);
            this.bCO.ez("msg_tip_key");
        }
        return this.bCO;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    L(intent);
                    int size2 = this.aHD.size() - 1;
                    if (size2 <= -1 || this.aHD == null || this.aHD.getChosedFiles() == null || (size = this.aHD.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.aHD, size2)));
                    return true;
                case 12002:
                    Q(intent);
                    return true;
                case 12004:
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V != null) {
                        this.aIy.v(V);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aHC != null) {
                        WriteData IM = this.aHC.IM();
                        if (IM != null) {
                            IM.deleteUploadedTempImages();
                        }
                        this.aHC.c((WriteData) null);
                        this.aHC.eS(false);
                        bK(true);
                        dw(true);
                        a(this.aHD, true);
                        this.aBB.notifyDataSetChanged();
                        Ja();
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
                    IN();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.aHD.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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

    public void IN() {
        new an(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.M(getActivity())), com.baidu.adp.lib.util.n.dip2px(getActivity(), com.baidu.adp.lib.util.n.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHA, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aHD.addChooseFile(imageFileInfo);
            this.aHD.updateQuality();
            a(this.aHD, true);
        }
        if (this.aHD.getChosedFiles() != null && this.aHD.getChosedFiles().size() > 0) {
            this.aIy.io(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aHD.parseJson(stringExtra);
                this.aHD.updateQuality();
                if (this.aHD.getChosedFiles() != null) {
                    a(this.aHD, z);
                }
            }
            if (this.aHD.getChosedFiles() != null && this.aHD.getChosedFiles().size() > 0) {
                this.aIy.io(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aHD);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHA);
        bundle.putSerializable("reply_thread", this.bDp);
    }

    public void c(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XG() {
        if (this.aLn == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            this.aLn = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.aLn.cb(getString(com.baidu.tieba.y.operation));
            this.aLn.a(strArr, new ao(this));
            this.aLn.d(this.bDg.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bDp.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bDp.getReplyer().getUserName());
            antiData.setUser_id(this.bDp.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XH() {
        if (this.aHC.IM() == null) {
            WriteData IM = IM();
            IM.setWriteImagesInfo(this.aHD);
            this.aHC.eS(this.aHD.size() > 0);
            this.aHC.c(IM);
        }
        if (this.aHC.IM() != null) {
            this.aHC.IM().setIsFrsReply(true);
            this.aHC.IM().setContent(this.aIy.getContent());
            VoiceData.VoiceModel audioData = this.aIy.getAudioData();
            this.aIy.Jh();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aHC.IM().setVoice(audioData.getId());
                    this.aHC.IM().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aHC.IM().setVoice(null);
                    this.aHC.IM().setVoiceDuringTime(-1);
                }
            } else {
                this.aHC.IM().setVoice(null);
                this.aHC.IM().setVoiceDuringTime(-1);
            }
            if (!this.aHC.anA()) {
            }
        }
    }

    private WriteData IM() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bDp.getFname());
        writeData.setThreadId(this.bDp.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bDp.getIsFloor()) {
            writeData.setFloor(this.bDr > 0 ? String.valueOf(this.bDr) : this.bDp.getQuote_pid());
        } else {
            writeData.setFloor(this.bDp.getPost_id());
        }
        if (this.bDs > 0) {
            writeData.setRepostId(String.valueOf(this.bDs));
        }
        writeData.setType(2);
        return writeData;
    }

    public void dw(boolean z) {
        if (this.bDp != null) {
            if (z) {
                if (this.bDp.getIsFloor() && this.bDp.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDp.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDp.getThread_id(), (WriteData) null);
                }
            } else if (this.aHC != null && this.aIy != null) {
                WriteData IM = this.aHC.IM();
                if (IM == null) {
                    IM = new WriteData(2);
                    IM.setThreadId(this.bDp.getThread_id());
                    IM.setWriteImagesInfo(this.aHD);
                }
                IM.setContent(this.aIy.getContent());
                if (this.bDp.getIsFloor() && this.bDp.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDp.getReplyer().getUserId(), IM);
                } else {
                    com.baidu.tieba.tbadkCore.ao.b(this.bDp.getThread_id(), IM);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (this.bDp != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bDp.getThread_id())) || bd.isEmpty(writeData.getContent()))) {
                if (Ai() && this.bDp.getIsFloor() && this.bDp.getReplyer() != null) {
                    this.aIy.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDp.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aIy.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (Ai() && this.bDp.getIsFloor() && this.bDp.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDp.getReplyer().getName_show() + ":")) {
                    this.aIy.setContent(content);
                } else {
                    this.aIy.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDp.getReplyer().getName_show() + ":");
                }
            } else if (Ai() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bDp.getReplyer().getName_show() + ":")) {
                this.aIy.setContent(content);
            } else {
                this.aIy.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.aHD.size() == 0) {
                this.aHD.copyFrom(writeData.getWriteImagesInfo());
                a(this.aHD, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.aIy.getEditText().setText("");
            this.aIy.alO();
            this.aIy.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aIy.cmz.a(writeImagesInfo, z);
    }

    public void Ja() {
        dw(false);
        this.aIy.Z(this.aIy.getEditText());
        this.aIy.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getActivity(), getString(com.baidu.tieba.y.login_to_use), true, 0)));
            return;
        }
        if (feedData != null && this.aIy != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(feedData.getThread_id(), this);
            }
            this.aHD = new WriteImagesInfo();
            this.aHD.setMaxImagesAllowed(10);
            a(this.aHD, true);
            this.aHC.c((WriteData) null);
            this.aHC.eS(false);
            this.aIy.Jg();
        }
        this.bDp = feedData;
        XI();
    }

    private void XI() {
        this.bDv = false;
        this.aIy.BZ();
        this.aIy.refresh();
        if (this.aIy.alv()) {
            this.aIy.acj();
        } else {
            this.aIy.getEditText().requestFocus();
            this.aIy.Y(this.aIy.getEditText());
        }
        K(this.mPosition, this.mBottom);
    }

    protected void K(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.n.dip2px(getActivity(), 40.0f);
        }
        this.bDu = new com.baidu.tbadk.editortool.z(getActivity(), i, i2, this.aIy, this.bDn, i3);
        this.mHandler.postDelayed(this.bDu, 300L);
    }
}
