package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends BaseFragment implements com.baidu.adp.widget.ListView.f, o, com.baidu.tieba.util.m {
    private int UC;
    private com.baidu.tbadk.core.view.y Yg;
    private int aao;
    private com.baidu.tbadk.core.view.o ahX;
    private NoNetworkView aoS;
    private String ayG;
    private ar ayI;
    private com.baidu.tbadk.core.view.d ayo;
    private PbEditor azJ;
    private LinearLayout bnl;
    private FeedData boc;
    private FeedData bod;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private x bnZ = null;
    private BdListView boa = null;
    private Activity mActivity = null;
    private am bob = null;
    private View mRoot = null;
    private WriteImagesInfo aib = new WriteImagesInfo();
    private boolean bnm = false;
    private AlertDialog ayP = null;
    private final as ayL = new af(this);
    private ao boe = new ag(this);
    private ch azK = null;
    private boolean bof = true;
    private final AbsListView.OnScrollListener ayO = new ah(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.w.reply_me_activity, (ViewGroup) null);
        initUI();
        d(bundle);
        this.mHandler = new Handler();
        return this.mRoot;
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aib = writeImagesInfo;
            }
            this.boc = (FeedData) bundle.getSerializable("reply_thread");
            this.ayG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aib.setMaxImagesAllowed(10);
    }

    private void initUI() {
        this.Yg = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yg.a(this);
        this.azJ = (PbEditor) this.mRoot.findViewById(com.baidu.tieba.v.quick_reply_editor);
        this.azJ.au(true);
        this.azJ.setOnActionListener(new ai(this));
        this.bnl = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.bodyNotLogin);
        this.ahX = NoDataViewFactory.a(this.mActivity, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.mention_replyme_nodata), null, true);
        this.boa = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.replyme_lv);
        this.boa.setDividerHeight(0);
        this.boa.setPullRefresh(this.Yg);
        this.boa.setOnScrollListener(this.ayO);
        this.bnZ = new x(this, 1, new aj(this));
        this.bnZ.t(this.boa);
        this.bnZ.d((ViewGroup) this.mRoot.findViewById(com.baidu.tieba.v.mention_layout_replyme1));
        this.bnZ.a(this.ahX);
        this.bnZ.gO("c/u/feed/replyme");
        this.bnZ.init();
        this.aoS = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.v.view_no_network_reply);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    g(intent);
                    int size2 = this.aib.size() - 1;
                    if (size2 > -1 && this.aib != null && this.aib.getChosedFiles() != null && (size = this.aib.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.mActivity, 12012, this.aib, size2)));
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12004:
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.azJ.p(p);
                        return;
                    }
                    return;
                case 12006:
                    if (this.ayI != null) {
                        WriteData EE = this.ayI.EE();
                        if (EE != null) {
                            EE.deleteUploadedTempImages();
                        }
                        this.ayI.b((WriteData) null);
                        this.ayI.dI(false);
                        bQ(true);
                        dC(true);
                        a(this.aib, true);
                        this.bnZ.SQ();
                        ER();
                        return;
                    }
                    return;
                case 12012:
                    f(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EF();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aib.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    public void e(Intent intent) {
        a(intent, true);
    }

    public void f(Intent intent) {
        a(intent, false);
    }

    public void EF() {
        new ak(this).execute(new Void[0]);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this.mActivity, com.baidu.adp.lib.util.m.n(this.mActivity)), com.baidu.adp.lib.util.m.dip2px(this.mActivity, com.baidu.adp.lib.util.m.o(this.mActivity)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayG, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aib.addChooseFile(imageFileInfo);
            this.aib.updateQuality();
            a(this.aib, true);
        }
        if (this.aib.getChosedFiles() != null && this.aib.getChosedFiles().size() > 0) {
            this.azJ.er(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aib.parseJson(stringExtra);
                this.aib.updateQuality();
                if (this.aib.getChosedFiles() != null) {
                    a(this.aib, z);
                }
            }
            if (this.aib.getChosedFiles() != null && this.aib.getChosedFiles().size() > 0) {
                this.azJ.er(23);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ahX != null) {
                this.ahX.onChangeSkinType(i);
            }
            if (this.Yg != null) {
                this.Yg.bM(i);
            }
            if (this.ayo != null) {
                this.ayo.bG(i);
            }
            if (this.bnZ != null) {
                this.bnZ.SQ();
            }
            if (this.aoS != null) {
                this.aoS.onChangeSkinType(i);
            }
            if (this.azJ != null) {
                this.azJ.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.boa.setVisibility(0);
            this.bnl.setVisibility(8);
            if (this.bnm) {
                this.bnm = false;
                SK();
            }
            this.bnZ.SO();
        } else {
            this.ahX.setVisibility(8);
            SL();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void SK() {
        if (this.bnZ == null) {
            this.bnm = true;
            return;
        }
        this.bnm = false;
        if (TbadkApplication.isLogin()) {
            this.boa.setVisibility(0);
            this.bnl.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgReplyme() > 0) {
                this.bnZ.setUpdateType(2);
            } else {
                this.bnZ.setUpdateType(1);
            }
            this.bnZ.show();
            this.bnZ.SO();
            return;
        }
        SL();
    }

    private void SL() {
        if (this.ayo == null) {
            this.ayo = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.y.login_msg_tab), getString(com.baidu.tieba.y.login_msg_form), 3);
            this.bnl.addView(this.ayo.getView());
            this.ayo.bG(TbadkApplication.m251getInst().getSkinType());
        } else {
            ((ViewGroup) this.ayo.getView().getParent()).removeAllViews();
            this.bnl.addView(this.ayo.getView());
            this.ayo.bG(TbadkApplication.m251getInst().getSkinType());
        }
        this.boa.setVisibility(8);
        this.bnl.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.ahX.onActivityStop();
        if (this.ayo != null) {
            this.ayo.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ayI != null) {
            this.ayI.cancelLoadData();
        }
        if (this.bnZ != null) {
            this.bnZ.SV();
        }
    }

    public void refresh() {
        this.bnZ.refresh();
    }

    public void b(com.baidu.tieba.model.am amVar) {
        this.bnZ.b(amVar);
    }

    public int SX() {
        return this.bnZ.SX();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            refresh();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aib);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayG);
        bundle.putSerializable("reply_thread", this.boc);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ED() {
        if (this.ayP == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new al(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.boc.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.boc.getReplyer().getUserName());
            antiData.setUser_id(this.boc.getReplyer().getUserId());
            AntiHelper.a(this.mActivity, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this.mActivity, str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        this.bob = new am(activity, this);
        this.bob.a(this.boe);
        this.ayI = new ar(activity);
        this.ayI.a(this.ayL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SZ() {
        if (this.ayI.EE() == null) {
            WriteData EE = EE();
            EE.setWriteImagesInfo(this.aib);
            this.ayI.dI(this.aib.size() > 0);
            this.ayI.b(EE);
        }
        if (this.ayI.EE() != null) {
            this.ayI.EE().setIsFrsReply(true);
            this.ayI.EE().setContent(this.azJ.getContent());
            VoiceData.VoiceModel audioData = this.azJ.getAudioData();
            this.azJ.BS();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayI.EE().setVoice(audioData.getId());
                    this.ayI.EE().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayI.EE().setVoice(null);
                    this.ayI.EE().setVoiceDuringTime(-1);
                }
            } else {
                this.ayI.EE().setVoice(null);
                this.ayI.EE().setVoiceDuringTime(-1);
            }
            if (!this.ayI.TU()) {
            }
        }
    }

    private WriteData EE() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.boc.getFname());
        writeData.setThreadId(this.boc.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.boc.getIsFloor()) {
            writeData.setFloor(this.boc.getQuote_pid());
        } else {
            writeData.setFloor(this.boc.getPost_id());
        }
        writeData.setType(2);
        return writeData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
        r0 = new android.graphics.Rect();
        r7.getDrawingRect(r0);
        ((android.view.ViewGroup) r8).offsetDescendantRectToMyCoords(r7, r0);
        r5.aao = r0.bottom;
        r5.UC = r6;
        r5.bod = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r9.getIsFloor() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
        r0 = com.baidu.adp.lib.g.c.a(r9.getQuote_pid(), 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        r5.bob.a(r0, 2, r9.getFname());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
        r0 = com.baidu.adp.lib.g.c.a(r9.getPost_id(), 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    @Override // com.baidu.tieba.mention.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, View view, View view2, FeedData feedData) {
        if (view != null && this.bob != null && view2 != null && feedData != null && view.getId() == com.baidu.tieba.v.ll_quick_reply && (view2 instanceof ViewGroup) && (view instanceof ViewParent)) {
            ViewParent viewParent = (ViewParent) view;
            while (viewParent != null && (viewParent instanceof View) && viewParent != view2) {
                viewParent = viewParent.getParent();
            }
        }
    }

    public void dC(boolean z) {
        if (this.boc != null) {
            if (z) {
                if (this.boc.getIsFloor() && this.boc.getReplyer() != null) {
                    com.baidu.tieba.util.l.b(this.boc.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.util.l.b(this.boc.getThread_id(), (WriteData) null);
                }
            } else if (this.ayI != null && this.azJ != null) {
                WriteData EE = this.ayI.EE();
                if (EE == null) {
                    EE = new WriteData(2);
                    EE.setThreadId(this.boc.getThread_id());
                    EE.setWriteImagesInfo(this.aib);
                }
                EE.setContent(this.azJ.getContent());
                if (this.boc.getIsFloor() && this.boc.getReplyer() != null) {
                    com.baidu.tieba.util.l.b(this.boc.getReplyer().getUserId(), EE);
                } else {
                    com.baidu.tieba.util.l.b(this.boc.getThread_id(), EE);
                }
            }
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (this.boc != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.boc.getThread_id())) || az.aA(writeData.getContent()))) {
                if (isAdded() && this.boc.getIsFloor() && this.boc.getReplyer() != null) {
                    this.azJ.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.boc.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.azJ.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (isAdded() && this.boc.getIsFloor() && this.boc.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.boc.getReplyer().getName_show() + ":")) {
                    this.azJ.setContent(content);
                } else {
                    this.azJ.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.boc.getReplyer().getName_show() + ":");
                }
            } else if (isAdded() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.boc.getReplyer().getName_show() + ":")) {
                this.azJ.setContent(content);
            } else {
                this.azJ.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.aib.size() == 0) {
                this.aib.copyFrom(writeData.getWriteImagesInfo());
                a(this.aib, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        if (z) {
            this.azJ.getEditText().setText("");
            this.azJ.Ca();
            this.azJ.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azJ.arn.a(writeImagesInfo, z);
    }

    public void ER() {
        dC(false);
        this.azJ.w(this.azJ.getEditText());
        this.azJ.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(FeedData feedData) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(this.mActivity, this.mActivity.getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.azJ != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.util.l.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.util.l.a(feedData.getThread_id(), this);
            }
            this.aib = new WriteImagesInfo();
            this.aib.setMaxImagesAllowed(10);
            a(this.aib, true);
            this.ayI.b((WriteData) null);
            this.ayI.dI(false);
            this.azJ.BR();
        }
        this.boc = feedData;
        Ta();
    }

    private void Ta() {
        this.bof = false;
        this.azJ.Bc();
        this.azJ.refresh();
        if (this.azJ.BD()) {
            this.azJ.Ch();
        } else {
            this.azJ.getEditText().requestFocus();
            this.azJ.v(this.azJ.getEditText());
        }
        I(this.UC, this.aao);
    }

    protected void I(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.m.dip2px(this.mActivity, 40.0f);
        }
        this.azK = new ch(this.mActivity, i, i2, this.azJ, this.boa, i3);
        this.mHandler.postDelayed(this.azK, 300L);
    }

    public PbEditor EQ() {
        return this.azJ;
    }
}
