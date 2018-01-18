package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private View bmt;
    private com.baidu.tbadk.editortools.i bpN;
    private VoiceManager dBh;
    public au fHE;
    private View fLE = null;
    private TextView fLF = null;
    private TextView fLG = null;
    private EditorScrollView fLH;
    private PbFullScreenEditorInputView fLI;
    private WholeDisplayGridView fLJ;
    private p fLK;
    private LinearLayout fLL;
    private PlayVoiceBntNew fLM;
    private LinearLayout fLN;
    private ImageView fLO;
    private LinearLayout fLP;
    private u fLQ;
    private t fLR;
    private PbEditorData fLS;
    private PostWriteCallBackData fLT;
    private View fLU;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_pb_editor_activity);
        this.dBh = new VoiceManager();
        this.dBh.onCreate(getPageContext());
        initView();
        initData();
        if (this.fLS != null && this.fLS.getEditorType() == 1 && this.fLI != null) {
            this.fLI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fHE = new au();
        if (this.fLI != null) {
            this.fHE.g(this.fLI);
        }
        if (this.fLT != null) {
            this.fHE.e(this.fLT);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        avL();
        this.bmt = findViewById(d.g.view_line);
        this.fLH = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fLH.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.bpN.IE();
                PbFullScreenEditorActivity.this.bpN.KE();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fLI);
            }
        });
        bbx();
        this.fLI = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bpN.IE();
                PbFullScreenEditorActivity.this.bpN.KE();
            }
        });
        this.fLI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bbA();
                if (PbFullScreenEditorActivity.this.fHE != null && PbFullScreenEditorActivity.this.fHE.beo() != null) {
                    if (!PbFullScreenEditorActivity.this.fHE.beo().bEP()) {
                        PbFullScreenEditorActivity.this.fHE.kE(false);
                    }
                    PbFullScreenEditorActivity.this.fHE.beo().nr(false);
                }
            }
        });
        this.fLL = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fLM = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fLN = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fLO = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bbz();
            }
        });
        this.fLJ = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fLK = new p(this.mContext);
        this.fLK.a(this);
        this.fLJ.setAdapter((ListAdapter) this.fLK);
    }

    private void bbx() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fLW = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fLJ) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fLW);
                    int x = ((int) motionEvent.getX()) - this.fLW[0];
                    int y = ((int) motionEvent.getY()) - this.fLW[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.bpN.IE();
                        PbFullScreenEditorActivity.this.bpN.KE();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fLI);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.a(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.fLU = findViewById(d.g.scroll_view_child);
        this.fLU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.bpN != null) {
                    PbFullScreenEditorActivity.this.bpN.IE();
                    PbFullScreenEditorActivity.this.bpN.KE();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fLI);
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void avL() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fLE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fLG = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.r(this.fLG, d.C0107d.cp_cont_b);
        this.fLF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fLE != null && this.fLF != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLE.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fLE.getLayoutParams();
            layoutParams2.width = -2;
            this.fLE.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fLF.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds14);
            this.fLF.setLayoutParams(layoutParams3);
            this.fLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jX(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fLS = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fLS != null) {
                jW(this.fLS.getEditorType() == 1);
                final String disableVoiceMessage = this.fLS.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.bpN != null) {
                    com.baidu.tbadk.editortools.l hH = this.bpN.hH(6);
                    if (hH instanceof View) {
                        ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fLS.getThreadData();
                if (this.fLQ != null) {
                    this.fLQ.setThreadData(this.mThreadData);
                }
                if (this.fLR != null) {
                    this.fLR.setThreadData(this.mThreadData);
                }
                this.fLI.loadData(this.fLS.getContent());
                WriteImagesInfo writeImagesInfo = this.fLS.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fLK.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fLK.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fLS.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fLL.setVisibility(0);
                    this.fLM.setVoiceModel(voiceModel);
                    this.fLR.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r hJ = this.bpN.hJ(6);
                    if (hJ != null && hJ.bqa != null) {
                        hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.bpN.bh((View) this.bpN.hH(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fLT = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bbA();
    }

    private void jW(boolean z) {
        this.fLP = (LinearLayout) findViewById(d.g.editbar_container);
        this.fLQ = new u();
        this.fLQ.jY(z);
        this.fLR = (t) this.fLQ.bh(this.mContext);
        this.bpN = this.fLR.Ku();
        this.fLR.b(this);
        this.fLQ.b(this);
        this.fLP.addView(this.bpN, new LinearLayout.LayoutParams(-1, -2));
        this.bpN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fLR.c(this);
        this.bpN.th();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        jX(false);
    }

    public void jX(boolean z) {
        Intent intent = new Intent();
        if (this.fLS == null) {
            this.fLS = new PbEditorData();
        }
        this.fLS.setContent(this.fLI.getText().toString());
        this.fLS.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fLS.setVoiceModel(this.fLR.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fLS);
        if (z) {
            if (this.fHE != null && this.fHE.beo() != null && this.fHE.beo().bEO()) {
                showToast(this.fHE.beo().bEQ());
                this.fHE.kE(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sL(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fLK.notifyDataSetChanged();
            }
            bbA();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sM(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fLR != null) {
            this.fLR.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bby();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            U(intent);
                        } else {
                            W(intent);
                        }
                        this.fLK.r(this.mWriteImagesInfo.getChosedFiles());
                        this.fLK.notifyDataSetChanged();
                        bbA();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fLI.ak(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bby();
                    V(intent);
                    this.fLK.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fLK.notifyDataSetChanged();
                    bbA();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fLI.fZ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bby() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void U(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ao(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aq(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bby();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void V(Intent intent) {
        b(intent, false);
    }

    private void W(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bby();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    com.baidu.tieba.face.b.b(this.fLI);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bbz();
                    return;
                case 14:
                    bby();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.KP().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fLI.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.fLR.setVoiceModel(voiceModel);
            this.fLL.setVisibility(0);
            this.fLM.setVoiceModel(voiceModel);
            bbA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbz() {
        if (this.fLR.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eG(this.fLR.getVoiceModel().voiceId));
        }
        this.fLR.setVoiceModel(null);
        this.fLL.setVisibility(8);
        this.fLM.setVoiceModel(null);
        com.baidu.tbadk.editortools.r hJ = this.bpN.hJ(6);
        if (hJ != null && hJ.bqa != null) {
            hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bbA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbA() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fLI.getText().toString());
        boolean z4 = (this.fLR == null || this.fLR.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fLF != null) {
            this.fLF.setEnabled(z);
        }
        if (z) {
            if (this.fLF != null) {
                com.baidu.tbadk.core.util.aj.r(this.fLF, d.C0107d.cp_link_tip_a);
            }
        } else if (this.fLF != null) {
            com.baidu.tbadk.core.util.aj.r(this.fLF, d.C0107d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.r(this.fLI, d.C0107d.cp_cont_b);
        this.fLI.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.fLO, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.t(this.bmt, d.C0107d.cp_bg_line_c);
        if (this.fHE != null) {
            this.fHE.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.a(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fHE != null) {
            this.fHE.onDestroy();
        }
    }
}
