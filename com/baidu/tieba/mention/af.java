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
    private String aBH;
    private com.baidu.tieba.tbadkCore.f.a aBJ;
    private final com.baidu.tieba.tbadkCore.f.b aBM;
    private final AbsListView.OnScrollListener aBP;
    private PbEditor aCC;
    private AlertDialog aFo;
    private WriteImagesInfo aqi;
    private com.baidu.tbadk.mvc.j.c<FeedData, com.baidu.tbadk.mvc.e.c, t> atQ;
    private SingleMentionActivity btK;
    private BdListView btR;
    private y btS;
    private FeedData btT;
    private FeedData btU;
    private long btV;
    private long btW;
    private aa btX;
    private com.baidu.tbadk.editortool.aa btY;
    private boolean btZ;
    private com.baidu.tbadk.mvc.i.b.c bts;
    private int mBottom;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNoNetworkView;
    private int mPosition;

    public af(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btR = null;
        this.aqi = new WriteImagesInfo();
        this.btS = null;
        this.aFo = null;
        this.aBM = new ag(this);
        this.btX = new ah(this);
        this.btY = null;
        this.btZ = true;
        this.aBP = new ai(this);
        this.btK = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.e
    public BdListView getListView() {
        return this.btR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aqi = writeImagesInfo;
            }
            this.btT = (FeedData) bundle.getSerializable("reply_thread");
            this.aBH = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aqi.setMaxImagesAllowed(10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ky() {
        super.ky();
        if (this.atQ != null) {
            this.atQ.ky();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.atQ != null) {
            this.atQ.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof q) {
            this.atQ.w(((q) aVar).Uj());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return com.baidu.tieba.x.reply_me_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.btS = new y(this.btK);
        this.btS.a(this.btX);
        this.aBJ = new com.baidu.tieba.tbadkCore.f.a(wG());
        this.aBJ.a(this.aBM);
        this.btR = (BdListView) getView().findViewById(com.baidu.tieba.w.replyme_lv);
        this.btR.setOnScrollListener(this.aBP);
        this.atQ = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), t.class, com.baidu.tieba.x.mention_replyme_item, wH());
        this.atQ.a(com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.mention_replyme_nodata), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.btR.setAdapter((ListAdapter) this.atQ);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(com.baidu.tieba.w.view_no_network_reply);
        this.aCC = (PbEditor) getView().findViewById(com.baidu.tieba.w.quick_reply_editor);
        this.aCC.aK(true);
        this.aCC.a(getPageContext(), new aj(this));
        super.kC();
    }

    @Override // com.baidu.tieba.mention.l, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.atQ.a(tbPageContext, i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aCC.b(tbPageContext, i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean wT() {
        if (this.aCC == null || !this.aCC.isVisible()) {
            return false;
        }
        FB();
        return true;
    }

    public void b(com.baidu.tbadk.mvc.c.b bVar) {
        long a;
        if (bVar != null && bVar.xm() == 9486) {
            FeedData feedData = (FeedData) bVar.xn();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.btR) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.btR && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.btR.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.mPosition = bVar.xr();
                this.btU = feedData;
                if (feedData.getIsFloor()) {
                    a = com.baidu.adp.lib.g.c.a(feedData.getQuote_pid(), 0L);
                } else {
                    a = com.baidu.adp.lib.g.c.a(feedData.getPost_id(), 0L);
                }
                this.btS.a(a, 2, feedData.getFname());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.i.b.b
    public com.baidu.tbadk.mvc.i.b.c yB() {
        if (this.bts == null) {
            this.bts = new com.baidu.tbadk.mvc.i.b.c();
            this.bts.setTitle(getString(com.baidu.tieba.z.mention_replyme));
            this.bts.dO(1);
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), com.baidu.tieba.x.message_tip_item, null);
            this.bts.a(cVar);
            this.bts.ev("msg_tip_key");
        }
        return this.bts;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public boolean onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    M(intent);
                    int size2 = this.aqi.size() - 1;
                    if (size2 <= -1 || this.aqi == null || this.aqi.getChosedFiles() == null || (size = this.aqi.getChosedFiles().size()) < 1 || size2 < 0 || size2 >= size) {
                        return true;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.aqi, size2)));
                    return true;
                case 12002:
                    S(intent);
                    return true;
                case 12004:
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.aCC.A(W);
                        return true;
                    }
                    return true;
                case 12006:
                    if (this.aBJ != null) {
                        WriteData Fn = this.aBJ.Fn();
                        if (Fn != null) {
                            Fn.deleteUploadedTempImages();
                        }
                        this.aBJ.c((WriteData) null);
                        this.aBJ.eF(false);
                        bG(true);
                        ds(true);
                        a(this.aqi, true);
                        this.atQ.notifyDataSetChanged();
                        FB();
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
                    Fo();
                    return true;
                case 12002:
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return true;
                    }
                    this.aqi.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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

    public void Fo() {
        new ak(this).execute(new Void[0]);
    }

    private void M(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bY = com.baidu.tbadk.core.util.d.bY(str);
                if (bY != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.M(getActivity())), com.baidu.adp.lib.util.l.dip2px(getActivity(), com.baidu.adp.lib.util.l.N(getActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, bY);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBH, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aqi.addChooseFile(imageFileInfo);
            this.aqi.updateQuality();
            a(this.aqi, true);
        }
        if (this.aqi.getChosedFiles() != null && this.aqi.getChosedFiles().size() > 0) {
            this.aCC.hQ(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aqi.parseJson(stringExtra);
                this.aqi.updateQuality();
                if (this.aqi.getChosedFiles() != null) {
                    a(this.aqi, z);
                }
            }
            if (this.aqi.getChosedFiles() != null && this.aqi.getChosedFiles().size() > 0) {
                this.aCC.hQ(23);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aqi);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBH);
        bundle.putSerializable("reply_thread", this.btT);
    }

    public void b(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        if (this.aFo == null) {
            String[] strArr = {getString(com.baidu.tieba.z.take_photo), getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new al(this));
            this.aFo = builder.create();
            this.aFo.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.btT.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.btT.getReplyer().getUserName());
            antiData.setUser_id(this.btT.getReplyer().getUserId());
            AntiHelper.a(getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Um() {
        if (this.aBJ.Fn() == null) {
            WriteData Fn = Fn();
            Fn.setWriteImagesInfo(this.aqi);
            this.aBJ.eF(this.aqi.size() > 0);
            this.aBJ.c(Fn);
        }
        if (this.aBJ.Fn() != null) {
            this.aBJ.Fn().setIsFrsReply(true);
            this.aBJ.Fn().setContent(this.aCC.getContent());
            VoiceData.VoiceModel audioData = this.aCC.getAudioData();
            this.aCC.FI();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBJ.Fn().setVoice(audioData.getId());
                    this.aBJ.Fn().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBJ.Fn().setVoice(null);
                    this.aBJ.Fn().setVoiceDuringTime(-1);
                }
            } else {
                this.aBJ.Fn().setVoice(null);
                this.aBJ.Fn().setVoiceDuringTime(-1);
            }
            if (!this.aBJ.aiA()) {
            }
        }
    }

    private WriteData Fn() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.btT.getFname());
        writeData.setThreadId(this.btT.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.btT.getIsFloor()) {
            writeData.setFloor(this.btV > 0 ? String.valueOf(this.btV) : this.btT.getQuote_pid());
        } else {
            writeData.setFloor(this.btT.getPost_id());
        }
        if (this.btW > 0) {
            writeData.setRepostId(String.valueOf(this.btW));
        }
        writeData.setType(2);
        return writeData;
    }

    public void ds(boolean z) {
        if (this.btT != null) {
            if (z) {
                if (this.btT.getIsFloor() && this.btT.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.btT.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.btT.getThread_id(), (WriteData) null);
                }
            } else if (this.aBJ != null && this.aCC != null) {
                WriteData Fn = this.aBJ.Fn();
                if (Fn == null) {
                    Fn = new WriteData(2);
                    Fn.setThreadId(this.btT.getThread_id());
                    Fn.setWriteImagesInfo(this.aqi);
                }
                Fn.setContent(this.aCC.getContent());
                if (this.btT.getIsFloor() && this.btT.getReplyer() != null) {
                    com.baidu.tieba.tbadkCore.al.b(this.btT.getReplyer().getUserId(), Fn);
                } else {
                    com.baidu.tieba.tbadkCore.al.b(this.btT.getThread_id(), Fn);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (this.btT != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.btT.getThread_id())) || bf.isEmpty(writeData.getContent()))) {
                if (wW() && this.btT.getIsFloor() && this.btT.getReplyer() != null) {
                    this.aCC.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btT.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.aCC.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (wW() && this.btT.getIsFloor() && this.btT.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btT.getReplyer().getName_show() + ":")) {
                    this.aCC.setContent(content);
                } else {
                    this.aCC.setContent(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btT.getReplyer().getName_show() + ":");
                }
            } else if (wW() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.z.mention_replyme)) + this.btT.getReplyer().getName_show() + ":")) {
                this.aCC.setContent(content);
            } else {
                this.aCC.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.aqi.size() == 0) {
                this.aqi.copyFrom(writeData.getWriteImagesInfo());
                a(this.aqi, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (z) {
            this.aCC.getEditText().setText("");
            this.aCC.agb();
            this.aCC.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCC.bWj.a(writeImagesInfo, z);
    }

    public void FB() {
        ds(false);
        this.aCC.W(this.aCC.getEditText());
        this.aCC.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedData feedData) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(getActivity(), getString(com.baidu.tieba.z.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.aCC != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.tbadkCore.al.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.tbadkCore.al.a(feedData.getThread_id(), this);
            }
            this.aqi = new WriteImagesInfo();
            this.aqi.setMaxImagesAllowed(10);
            a(this.aqi, true);
            this.aBJ.c((WriteData) null);
            this.aBJ.eF(false);
            this.aCC.FH();
        }
        this.btT = feedData;
        Un();
    }

    private void Un() {
        this.btZ = false;
        this.aCC.yL();
        this.aCC.refresh();
        if (this.aCC.afI()) {
            this.aCC.ZZ();
        } else {
            this.aCC.getEditText().requestFocus();
            this.aCC.V(this.aCC.getEditText());
        }
        L(this.mPosition, this.mBottom);
    }

    protected void L(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.l.dip2px(getActivity(), 40.0f);
        }
        this.btY = new com.baidu.tbadk.editortool.aa(getActivity(), i, i2, this.aCC, this.btR, i3);
        this.mHandler.postDelayed(this.btY, 300L);
    }
}
