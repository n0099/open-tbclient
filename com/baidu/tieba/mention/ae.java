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
import com.baidu.tbadk.core.util.ay;
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
    private int Uy;
    private com.baidu.tbadk.core.view.y Yc;
    private int aak;
    private com.baidu.tbadk.core.view.o ahO;
    private NoNetworkView aoJ;
    private com.baidu.tbadk.core.view.d ayf;
    private String ayx;
    private ar ayz;
    private PbEditor azA;
    private LinearLayout bmX;
    private FeedData bnO;
    private FeedData bnP;
    private String mForumId;
    private Handler mHandler;
    private NavigationBar mNavigationBar;
    private x bnL = null;
    private BdListView bnM = null;
    private Activity mActivity = null;
    private am bnN = null;
    private View mRoot = null;
    private WriteImagesInfo ahS = new WriteImagesInfo();
    private boolean bmY = false;
    private AlertDialog ayG = null;
    private final as ayC = new af(this);
    private ao bnQ = new ag(this);
    private ch azB = null;
    private boolean bnR = true;
    private final AbsListView.OnScrollListener ayF = new ah(this);

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
                this.ahS = writeImagesInfo;
            }
            this.bnO = (FeedData) bundle.getSerializable("reply_thread");
            this.ayx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.ahS.setMaxImagesAllowed(10);
    }

    private void initUI() {
        this.Yc = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yc.a(this);
        this.azA = (PbEditor) this.mRoot.findViewById(com.baidu.tieba.v.quick_reply_editor);
        this.azA.au(true);
        this.azA.setOnActionListener(new ai(this));
        this.bmX = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.bodyNotLogin);
        this.ahO = NoDataViewFactory.a(this.mActivity, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.mention_replyme_nodata), null, true);
        this.bnM = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.replyme_lv);
        this.bnM.setDividerHeight(0);
        this.bnM.setPullRefresh(this.Yc);
        this.bnM.setOnScrollListener(this.ayF);
        this.bnL = new x(this, 1, new aj(this));
        this.bnL.t(this.bnM);
        this.bnL.d((ViewGroup) this.mRoot.findViewById(com.baidu.tieba.v.mention_layout_replyme1));
        this.bnL.a(this.ahO);
        this.bnL.gO("c/u/feed/replyme");
        this.bnL.init();
        this.aoJ = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.v.view_no_network_reply);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    g(intent);
                    int size2 = this.ahS.size() - 1;
                    if (size2 > -1 && this.ahS != null && this.ahS.getChosedFiles() != null && (size = this.ahS.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.mActivity, 12012, this.ahS, size2)));
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12004:
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.azA.o(p);
                        return;
                    }
                    return;
                case 12006:
                    if (this.ayz != null) {
                        WriteData EC = this.ayz.EC();
                        if (EC != null) {
                            EC.deleteUploadedTempImages();
                        }
                        this.ayz.b((WriteData) null);
                        this.ayz.dI(false);
                        bQ(true);
                        dC(true);
                        a(this.ahS, true);
                        this.bnL.SN();
                        EP();
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
                    ED();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.ahS.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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

    public void ED() {
        new ak(this).execute(new Void[0]);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this.mActivity, com.baidu.adp.lib.util.m.n(this.mActivity)), com.baidu.adp.lib.util.m.dip2px(this.mActivity, com.baidu.adp.lib.util.m.o(this.mActivity)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayx, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.ahS.addChooseFile(imageFileInfo);
            this.ahS.updateQuality();
            a(this.ahS, true);
        }
        if (this.ahS.getChosedFiles() != null && this.ahS.getChosedFiles().size() > 0) {
            this.azA.er(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.ahS.parseJson(stringExtra);
                this.ahS.updateQuality();
                if (this.ahS.getChosedFiles() != null) {
                    a(this.ahS, z);
                }
            }
            if (this.ahS.getChosedFiles() != null && this.ahS.getChosedFiles().size() > 0) {
                this.azA.er(23);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ahO != null) {
                this.ahO.onChangeSkinType(i);
            }
            if (this.Yc != null) {
                this.Yc.bM(i);
            }
            if (this.ayf != null) {
                this.ayf.bG(i);
            }
            if (this.bnL != null) {
                this.bnL.SN();
            }
            if (this.aoJ != null) {
                this.aoJ.onChangeSkinType(i);
            }
            if (this.azA != null) {
                this.azA.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.bnM.setVisibility(0);
            this.bmX.setVisibility(8);
            if (this.bmY) {
                this.bmY = false;
                SH();
            }
            this.bnL.SL();
        } else {
            this.ahO.setVisibility(8);
            SI();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void SH() {
        if (this.bnL == null) {
            this.bmY = true;
            return;
        }
        this.bmY = false;
        if (TbadkApplication.isLogin()) {
            this.bnM.setVisibility(0);
            this.bmX.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgReplyme() > 0) {
                this.bnL.setUpdateType(2);
            } else {
                this.bnL.setUpdateType(1);
            }
            this.bnL.show();
            this.bnL.SL();
            return;
        }
        SI();
    }

    private void SI() {
        if (this.ayf == null) {
            this.ayf = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.y.login_msg_tab), getString(com.baidu.tieba.y.login_msg_form), 3);
            this.bmX.addView(this.ayf.getView());
            this.ayf.bG(TbadkApplication.m251getInst().getSkinType());
        } else {
            ((ViewGroup) this.ayf.getView().getParent()).removeAllViews();
            this.bmX.addView(this.ayf.getView());
            this.ayf.bG(TbadkApplication.m251getInst().getSkinType());
        }
        this.bnM.setVisibility(8);
        this.bmX.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.ahO.onActivityStop();
        if (this.ayf != null) {
            this.ayf.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahO.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ayz != null) {
            this.ayz.cancelLoadData();
        }
        if (this.bnL != null) {
            this.bnL.SS();
        }
    }

    public void refresh() {
        this.bnL.refresh();
    }

    public void b(com.baidu.tieba.model.am amVar) {
        this.bnL.b(amVar);
    }

    public int SU() {
        return this.bnL.SU();
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
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.ahS);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayx);
        bundle.putSerializable("reply_thread", this.bnO);
    }

    public void a(NavigationBar navigationBar) {
        this.mNavigationBar = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB() {
        if (this.ayG == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new al(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.bnO.getFname());
            antiData.setBlock_forum_id(this.mForumId);
            antiData.setUser_name(this.bnO.getReplyer().getUserName());
            antiData.setUser_id(this.bnO.getReplyer().getUserId());
            AntiHelper.a(this.mActivity, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this.mActivity, str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        this.bnN = new am(activity, this);
        this.bnN.a(this.bnQ);
        this.ayz = new ar(activity);
        this.ayz.a(this.ayC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SW() {
        if (this.ayz.EC() == null) {
            WriteData EC = EC();
            EC.setWriteImagesInfo(this.ahS);
            this.ayz.dI(this.ahS.size() > 0);
            this.ayz.b(EC);
        }
        if (this.ayz.EC() != null) {
            this.ayz.EC().setIsFrsReply(true);
            this.ayz.EC().setContent(this.azA.getContent());
            VoiceData.VoiceModel audioData = this.azA.getAudioData();
            this.azA.BQ();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayz.EC().setVoice(audioData.getId());
                    this.ayz.EC().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayz.EC().setVoice(null);
                    this.ayz.EC().setVoiceDuringTime(-1);
                }
            } else {
                this.ayz.EC().setVoice(null);
                this.ayz.EC().setVoiceDuringTime(-1);
            }
            if (!this.ayz.TR()) {
            }
        }
    }

    private WriteData EC() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.bnO.getFname());
        writeData.setThreadId(this.bnO.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.bnO.getIsFloor()) {
            writeData.setFloor(this.bnO.getQuote_pid());
        } else {
            writeData.setFloor(this.bnO.getPost_id());
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
        r5.aak = r0.bottom;
        r5.Uy = r6;
        r5.bnP = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r9.getIsFloor() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
        r0 = com.baidu.adp.lib.g.c.a(r9.getQuote_pid(), 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        r5.bnN.a(r0, 2, r9.getFname());
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
        if (view != null && this.bnN != null && view2 != null && feedData != null && view.getId() == com.baidu.tieba.v.ll_quick_reply && (view2 instanceof ViewGroup) && (view instanceof ViewParent)) {
            ViewParent viewParent = (ViewParent) view;
            while (viewParent != null && (viewParent instanceof View) && viewParent != view2) {
                viewParent = viewParent.getParent();
            }
        }
    }

    public void dC(boolean z) {
        if (this.bnO != null) {
            if (z) {
                if (this.bnO.getIsFloor() && this.bnO.getReplyer() != null) {
                    com.baidu.tieba.util.l.b(this.bnO.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.util.l.b(this.bnO.getThread_id(), (WriteData) null);
                }
            } else if (this.ayz != null && this.azA != null) {
                WriteData EC = this.ayz.EC();
                if (EC == null) {
                    EC = new WriteData(2);
                    EC.setThreadId(this.bnO.getThread_id());
                    EC.setWriteImagesInfo(this.ahS);
                }
                EC.setContent(this.azA.getContent());
                if (this.bnO.getIsFloor() && this.bnO.getReplyer() != null) {
                    com.baidu.tieba.util.l.b(this.bnO.getReplyer().getUserId(), EC);
                } else {
                    com.baidu.tieba.util.l.b(this.bnO.getThread_id(), EC);
                }
            }
        }
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (this.bnO != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.bnO.getThread_id())) || ay.aA(writeData.getContent()))) {
                if (isAdded() && this.bnO.getIsFloor() && this.bnO.getReplyer() != null) {
                    this.azA.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bnO.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.azA.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (isAdded() && this.bnO.getIsFloor() && this.bnO.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bnO.getReplyer().getName_show() + ":")) {
                    this.azA.setContent(content);
                } else {
                    this.azA.setContent(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bnO.getReplyer().getName_show() + ":");
                }
            } else if (isAdded() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.y.mention_replyme)) + this.bnO.getReplyer().getName_show() + ":")) {
                this.azA.setContent(content);
            } else {
                this.azA.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.ahS.size() == 0) {
                this.ahS.copyFrom(writeData.getWriteImagesInfo());
                a(this.ahS, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        if (z) {
            this.azA.getEditText().setText("");
            this.azA.BY();
            this.azA.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azA.are.a(writeImagesInfo, z);
    }

    public void EP() {
        dC(false);
        this.azA.w(this.azA.getEditText());
        this.azA.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(FeedData feedData) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(this.mActivity, this.mActivity.getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.azA != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.util.l.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.util.l.a(feedData.getThread_id(), this);
            }
            this.ahS = new WriteImagesInfo();
            this.ahS.setMaxImagesAllowed(10);
            a(this.ahS, true);
            this.ayz.b((WriteData) null);
            this.ayz.dI(false);
            this.azA.BP();
        }
        this.bnO = feedData;
        SX();
    }

    private void SX() {
        this.bnR = false;
        this.azA.Ba();
        this.azA.refresh();
        if (this.azA.BB()) {
            this.azA.Cf();
        } else {
            this.azA.getEditText().requestFocus();
            this.azA.v(this.azA.getEditText());
        }
        I(this.Uy, this.aak);
    }

    protected void I(int i, int i2) {
        int i3 = 0;
        if (this.mNavigationBar != null) {
            i3 = this.mNavigationBar.getHeight() + 0 + com.baidu.adp.lib.util.m.dip2px(this.mActivity, 40.0f);
        }
        this.azB = new ch(this.mActivity, i, i2, this.azA, this.bnM, i3);
        this.mHandler.postDelayed(this.azB, 300L);
    }

    public PbEditor EO() {
        return this.azA;
    }
}
