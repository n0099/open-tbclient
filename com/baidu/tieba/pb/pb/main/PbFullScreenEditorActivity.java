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
    private EditorTools aXW;
    private VoiceManager dIc;
    public at fTc;
    private LinearLayout fXA;
    private ImageView fXB;
    private LinearLayout fXC;
    private u fXD;
    private t fXE;
    private PbEditorData fXF;
    private PostWriteCallBackData fXG;
    private View fXH;
    private View fXr = null;
    private TextView fXs = null;
    private TextView fXt = null;
    private EditorScrollView fXu;
    private PbFullScreenEditorInputView fXv;
    private WholeDisplayGridView fXw;
    private n fXx;
    private LinearLayout fXy;
    private PlayVoiceBntNew fXz;
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
        this.dIc = new VoiceManager();
        this.dIc.onCreate(getPageContext());
        initView();
        initData();
        if (this.fXF != null && this.fXF.getEditorType() == 1 && this.fXv != null) {
            this.fXv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fTc = new at();
        if (this.fXv != null) {
            this.fTc.g(this.fXv);
        }
        if (this.fXG != null) {
            this.fTc.f(this.fXG);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        ayF();
        this.mTopLine = findViewById(e.g.view_line);
        this.fXu = (EditorScrollView) findViewById(e.g.scroll_view);
        this.fXu.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aXW != null) {
                    PbFullScreenEditorActivity.this.aXW.Kw();
                    PbFullScreenEditorActivity.this.aXW.Mh();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fXv);
            }
        });
        biX();
        this.fXv = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.fXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aXW != null) {
                    PbFullScreenEditorActivity.this.aXW.Kw();
                    PbFullScreenEditorActivity.this.aXW.Mh();
                }
            }
        });
        this.fXv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bja();
                if (PbFullScreenEditorActivity.this.fTc != null && PbFullScreenEditorActivity.this.fTc.blN() != null) {
                    if (!PbFullScreenEditorActivity.this.fTc.blN().bMY()) {
                        PbFullScreenEditorActivity.this.fTc.lx(false);
                    }
                    PbFullScreenEditorActivity.this.fTc.blN().or(false);
                }
            }
        });
        this.fXy = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fXz = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fXA = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.fXB = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.biZ();
            }
        });
        this.fXw = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.fXx = new n(this.mContext);
        this.fXx.a(this);
        this.fXw.setAdapter((ListAdapter) this.fXx);
    }

    private void biX() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fXJ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fXw) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fXJ);
                    int x = ((int) motionEvent.getX()) - this.fXJ[0];
                    int y = ((int) motionEvent.getY()) - this.fXJ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aXW.Kw();
                        PbFullScreenEditorActivity.this.aXW.Mh();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fXv);
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
        this.fXH = findViewById(e.g.scroll_view_child);
        this.fXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aXW != null) {
                    PbFullScreenEditorActivity.this.aXW.Kw();
                    PbFullScreenEditorActivity.this.aXW.Mh();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fXv);
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

    private void ayF() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fXr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fXt = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.fXt, e.d.cp_cont_b);
        this.fXs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fXr != null && this.fXs != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXr.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fXr.getLayoutParams();
            layoutParams2.width = -2;
            this.fXr.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.fXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fXs.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds14);
            this.fXs.setLayoutParams(layoutParams3);
            this.fXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kS(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fXF = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fXF != null) {
                kR(this.fXF.getEditorType() == 1);
                final String disableVoiceMessage = this.fXF.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aXW != null) {
                    com.baidu.tbadk.editortools.g fH = this.aXW.fH(6);
                    if (fH instanceof View) {
                        ((View) fH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fXF.getThreadData();
                if (this.fXD != null) {
                    this.fXD.setThreadData(this.mThreadData);
                }
                if (this.fXE != null) {
                    this.fXE.setThreadData(this.mThreadData);
                }
                this.fXv.loadData(this.fXF.getContent());
                WriteImagesInfo writeImagesInfo = this.fXF.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fXx.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fXx.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fXF.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fXy.setVisibility(0);
                    this.fXz.setVoiceModel(voiceModel);
                    this.fXE.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k fK = this.aXW.fK(6);
                    if (fK != null && fK.aYi != null) {
                        fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aXW.aa((View) this.aXW.fH(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fXG = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bja();
    }

    private void kR(boolean z) {
        this.fXC = (LinearLayout) findViewById(e.g.editbar_container);
        this.fXD = new u();
        this.fXD.kT(z);
        this.fXE = (t) this.fXD.bM(this.mContext);
        this.aXW = this.fXE.LX();
        this.fXE.b(this);
        this.fXD.b(this);
        this.fXC.addView(this.aXW, new LinearLayout.LayoutParams(-1, -2));
        this.aXW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fXE.c(this);
        this.aXW.pN();
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
        kS(false);
    }

    public void kS(boolean z) {
        Intent intent = new Intent();
        if (this.fXF == null) {
            this.fXF = new PbEditorData();
        }
        this.fXF.setContent(this.fXv.getText().toString());
        this.fXF.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fXF.setVoiceModel(this.fXE.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fXF);
        if (z) {
            if (this.fTc != null && this.fTc.blN() != null && this.fTc.blN().bMX()) {
                showToast(this.fTc.blN().bMZ());
                this.fTc.lx(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sk(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fXx.notifyDataSetChanged();
            }
            bja();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sl(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fXE != null) {
            this.fXE.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        biY();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            V(intent);
                        } else {
                            X(intent);
                        }
                        this.fXx.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fXx.notifyDataSetChanged();
                        bja();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fXv.an(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    biY();
                    W(intent);
                    this.fXx.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fXx.notifyDataSetChanged();
                    bja();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fXv.hJ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void biY() {
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
            biY();
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
            biY();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dIc;
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
                    com.baidu.tieba.face.b.b(this.fXv);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    biZ();
                    return;
                case 14:
                    biY();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Mt().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        this.fXv.b((com.baidu.tbadk.coreExtra.data.p) aVar.data);
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
            this.fXE.setVoiceModel(voiceModel);
            this.fXy.setVisibility(0);
            this.fXz.setVoiceModel(voiceModel);
            bja();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biZ() {
        if (this.fXE.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fXE.getVoiceModel().voiceId));
        }
        this.fXE.setVoiceModel(null);
        this.fXy.setVisibility(8);
        this.fXz.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fK = this.aXW.fK(6);
        if (fK != null && fK.aYi != null) {
            fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bja() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fXv.getText().toString());
        boolean z4 = (this.fXE == null || this.fXE.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fXs != null) {
            this.fXs.setEnabled(z);
        }
        if (z) {
            if (this.fXs != null) {
                com.baidu.tbadk.core.util.al.h(this.fXs, e.d.cp_link_tip_a);
            }
        } else if (this.fXs != null) {
            com.baidu.tbadk.core.util.al.h(this.fXs, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.fXv, e.d.cp_cont_b);
        this.fXv.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.fXB, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fTc != null) {
            this.fTc.onChangeSkinType();
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
        if (this.fTc != null) {
            this.fTc.onDestroy();
        }
    }
}
