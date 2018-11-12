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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools aUz;
    private VoiceManager dBD;
    public at fMm;
    private View fQB = null;
    private TextView fQC = null;
    private TextView fQD = null;
    private EditorScrollView fQE;
    private PbFullScreenEditorInputView fQF;
    private WholeDisplayGridView fQG;
    private n fQH;
    private LinearLayout fQI;
    private PlayVoiceBntNew fQJ;
    private LinearLayout fQK;
    private ImageView fQL;
    private LinearLayout fQM;
    private u fQN;
    private t fQO;
    private PbEditorData fQP;
    private PostWriteCallBackData fQQ;
    private View fQR;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(e.h.layout_pb_editor_activity);
        this.dBD = new VoiceManager();
        this.dBD.onCreate(getPageContext());
        initView();
        initData();
        if (this.fQP != null && this.fQP.getEditorType() == 1 && this.fQF != null) {
            this.fQF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fMm = new at();
        if (this.fQF != null) {
            this.fMm.g(this.fQF);
        }
        if (this.fQQ != null) {
            this.fMm.f(this.fQQ);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        awU();
        this.mTopLine = findViewById(e.g.view_line);
        this.fQE = (EditorScrollView) findViewById(e.g.scroll_view);
        this.fQE.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aUz != null) {
                    PbFullScreenEditorActivity.this.aUz.Js();
                    PbFullScreenEditorActivity.this.aUz.Ld();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fQF);
            }
        });
        bhf();
        this.fQF = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.fQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aUz != null) {
                    PbFullScreenEditorActivity.this.aUz.Js();
                    PbFullScreenEditorActivity.this.aUz.Ld();
                }
            }
        });
        this.fQF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bhi();
                if (PbFullScreenEditorActivity.this.fMm != null && PbFullScreenEditorActivity.this.fMm.bjU() != null) {
                    if (!PbFullScreenEditorActivity.this.fMm.bjU().bKS()) {
                        PbFullScreenEditorActivity.this.fMm.lu(false);
                    }
                    PbFullScreenEditorActivity.this.fMm.bjU().op(false);
                }
            }
        });
        this.fQI = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fQJ = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fQK = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.fQL = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bhh();
            }
        });
        this.fQG = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.fQH = new n(this.mContext);
        this.fQH.a(this);
        this.fQG.setAdapter((ListAdapter) this.fQH);
    }

    private void bhf() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fQT = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fQG) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fQT);
                    int x = ((int) motionEvent.getX()) - this.fQT[0];
                    int y = ((int) motionEvent.getY()) - this.fQT[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aUz.Js();
                        PbFullScreenEditorActivity.this.aUz.Ld();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fQF);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.fQR = findViewById(e.g.scroll_view_child);
        this.fQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aUz != null) {
                    PbFullScreenEditorActivity.this.aUz.Js();
                    PbFullScreenEditorActivity.this.aUz.Ld();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fQF);
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

    private void awU() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fQB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fQD = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.fQD, e.d.cp_cont_b);
        this.fQC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fQB != null && this.fQC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQB.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0200e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fQB.getLayoutParams();
            layoutParams2.width = -2;
            this.fQB.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.fQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fQC.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0200e.ds14);
            this.fQC.setLayoutParams(layoutParams3);
            this.fQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kP(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fQP = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fQP != null) {
                kO(this.fQP.getEditorType() == 1);
                final String disableVoiceMessage = this.fQP.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aUz != null) {
                    com.baidu.tbadk.editortools.g ft = this.aUz.ft(6);
                    if (ft instanceof View) {
                        ((View) ft).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fQP.getThreadData();
                if (this.fQN != null) {
                    this.fQN.setThreadData(this.mThreadData);
                }
                if (this.fQO != null) {
                    this.fQO.setThreadData(this.mThreadData);
                }
                this.fQF.loadData(this.fQP.getContent());
                WriteImagesInfo writeImagesInfo = this.fQP.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fQH.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fQH.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fQP.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fQI.setVisibility(0);
                    this.fQJ.setVoiceModel(voiceModel);
                    this.fQO.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k fw = this.aUz.fw(6);
                    if (fw != null && fw.aUL != null) {
                        fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aUz.aa((View) this.aUz.ft(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fQQ = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bhi();
    }

    private void kO(boolean z) {
        this.fQM = (LinearLayout) findViewById(e.g.editbar_container);
        this.fQN = new u();
        this.fQN.kQ(z);
        this.fQO = (t) this.fQN.bJ(this.mContext);
        this.aUz = this.fQO.KT();
        this.fQO.b(this);
        this.fQN.b(this);
        this.fQM.addView(this.aUz, new LinearLayout.LayoutParams(-1, -2));
        this.aUz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fQO.c(this);
        this.aUz.pO();
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
        kP(false);
    }

    public void kP(boolean z) {
        Intent intent = new Intent();
        if (this.fQP == null) {
            this.fQP = new PbEditorData();
        }
        this.fQP.setContent(this.fQF.getText().toString());
        this.fQP.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fQP.setVoiceModel(this.fQO.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fQP);
        if (z) {
            if (this.fMm != null && this.fMm.bjU() != null && this.fMm.bjU().bKR()) {
                showToast(this.fMm.bjU().bKT());
                this.fMm.lu(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void rQ(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fQH.notifyDataSetChanged();
            }
            bhi();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void rR(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fQO != null) {
            this.fQO.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bhg();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            V(intent);
                        } else {
                            X(intent);
                        }
                        this.fQH.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fQH.notifyDataSetChanged();
                        bhi();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fQF.an(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bhg();
                    W(intent);
                    this.fQH.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fQH.notifyDataSetChanged();
                    bhi();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fQF.hr(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bhg() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void V(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aO(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aQ(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bhg();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void W(Intent intent) {
        b(intent, false);
    }

    private void X(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bhg();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBD;
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
                    com.baidu.tieba.face.b.b(this.fQF);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bhh();
                    return;
                case 14:
                    bhg();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Lp().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        this.fQF.b((com.baidu.tbadk.coreExtra.data.p) aVar.data);
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
            this.fQO.setVoiceModel(voiceModel);
            this.fQI.setVisibility(0);
            this.fQJ.setVoiceModel(voiceModel);
            bhi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhh() {
        if (this.fQO.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fQO.getVoiceModel().voiceId));
        }
        this.fQO.setVoiceModel(null);
        this.fQI.setVisibility(8);
        this.fQJ.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fw = this.aUz.fw(6);
        if (fw != null && fw.aUL != null) {
            fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bhi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhi() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fQF.getText().toString());
        boolean z4 = (this.fQO == null || this.fQO.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fQC != null) {
            this.fQC.setEnabled(z);
        }
        if (z) {
            if (this.fQC != null) {
                com.baidu.tbadk.core.util.al.h(this.fQC, e.d.cp_link_tip_a);
            }
        } else if (this.fQC != null) {
            com.baidu.tbadk.core.util.al.h(this.fQC, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.fQF, e.d.cp_cont_b);
        this.fQF.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.fQL, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fMm != null) {
            this.fMm.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.b(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fMm != null) {
            this.fMm.onDestroy();
        }
    }
}
