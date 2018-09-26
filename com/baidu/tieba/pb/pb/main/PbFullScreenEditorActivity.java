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
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools aPh;
    private VoiceManager dsk;
    public at fDl;
    private View fHA = null;
    private TextView fHB = null;
    private TextView fHC = null;
    private EditorScrollView fHD;
    private PbFullScreenEditorInputView fHE;
    private WholeDisplayGridView fHF;
    private n fHG;
    private LinearLayout fHH;
    private PlayVoiceBntNew fHI;
    private LinearLayout fHJ;
    private ImageView fHK;
    private LinearLayout fHL;
    private u fHM;
    private t fHN;
    private PbEditorData fHO;
    private PostWriteCallBackData fHP;
    private View fHQ;
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
        this.dsk = new VoiceManager();
        this.dsk.onCreate(getPageContext());
        initView();
        initData();
        if (this.fHO != null && this.fHO.getEditorType() == 1 && this.fHE != null) {
            this.fHE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fDl = new at();
        if (this.fHE != null) {
            this.fDl.g(this.fHE);
        }
        if (this.fHP != null) {
            this.fDl.f(this.fHP);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        atZ();
        this.mTopLine = findViewById(e.g.view_line);
        this.fHD = (EditorScrollView) findViewById(e.g.scroll_view);
        this.fHD.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aPh != null) {
                    PbFullScreenEditorActivity.this.aPh.Hf();
                    PbFullScreenEditorActivity.this.aPh.IT();
                }
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fHE);
            }
        });
        bew();
        this.fHE = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.fHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aPh != null) {
                    PbFullScreenEditorActivity.this.aPh.Hf();
                    PbFullScreenEditorActivity.this.aPh.IT();
                }
            }
        });
        this.fHE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bez();
                if (PbFullScreenEditorActivity.this.fDl != null && PbFullScreenEditorActivity.this.fDl.bhl() != null) {
                    if (!PbFullScreenEditorActivity.this.fDl.bhl().bIh()) {
                        PbFullScreenEditorActivity.this.fDl.kS(false);
                    }
                    PbFullScreenEditorActivity.this.fDl.bhl().nL(false);
                }
            }
        });
        this.fHH = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fHI = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fHJ = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.fHK = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bey();
            }
        });
        this.fHF = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.fHG = new n(this.mContext);
        this.fHG.a(this);
        this.fHF.setAdapter((ListAdapter) this.fHG);
    }

    private void bew() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fHS = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fHF) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fHS);
                    int x = ((int) motionEvent.getX()) - this.fHS[0];
                    int y = ((int) motionEvent.getY()) - this.fHS[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aPh.Hf();
                        PbFullScreenEditorActivity.this.aPh.IT();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fHE);
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
        this.fHQ = findViewById(e.g.scroll_view_child);
        this.fHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aPh != null) {
                    PbFullScreenEditorActivity.this.aPh.Hf();
                    PbFullScreenEditorActivity.this.aPh.IT();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fHE);
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

    private void atZ() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fHA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fHC = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.fHC, e.d.cp_cont_b);
        this.fHB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fHA != null && this.fHB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHA.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0141e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHA.getLayoutParams();
            layoutParams2.width = -2;
            this.fHA.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.fHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fHB.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0141e.ds14);
            this.fHB.setLayoutParams(layoutParams3);
            this.fHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kn(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fHO = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fHO != null) {
                km(this.fHO.getEditorType() == 1);
                final String disableVoiceMessage = this.fHO.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aPh != null) {
                    com.baidu.tbadk.editortools.g eW = this.aPh.eW(6);
                    if (eW instanceof View) {
                        ((View) eW).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fHO.getThreadData();
                if (this.fHM != null) {
                    this.fHM.setThreadData(this.mThreadData);
                }
                if (this.fHN != null) {
                    this.fHN.setThreadData(this.mThreadData);
                }
                this.fHE.loadData(this.fHO.getContent());
                WriteImagesInfo writeImagesInfo = this.fHO.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fHG.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fHG.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fHO.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fHH.setVisibility(0);
                    this.fHI.setVoiceModel(voiceModel);
                    this.fHN.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eZ = this.aPh.eZ(6);
                    if (eZ != null && eZ.aPu != null) {
                        eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aPh.aa((View) this.aPh.eW(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fHP = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bez();
    }

    private void km(boolean z) {
        this.fHL = (LinearLayout) findViewById(e.g.editbar_container);
        this.fHM = new u();
        this.fHM.ko(z);
        this.fHN = (t) this.fHM.bE(this.mContext);
        this.aPh = this.fHN.IJ();
        this.fHN.b(this);
        this.fHM.b(this);
        this.fHL.addView(this.aPh, new LinearLayout.LayoutParams(-1, -2));
        this.aPh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fHN.c(this);
        this.aPh.pI();
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
        kn(false);
    }

    public void kn(boolean z) {
        Intent intent = new Intent();
        if (this.fHO == null) {
            this.fHO = new PbEditorData();
        }
        this.fHO.setContent(this.fHE.getText().toString());
        this.fHO.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fHO.setVoiceModel(this.fHN.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fHO);
        if (z) {
            if (this.fDl != null && this.fDl.bhl() != null && this.fDl.bhl().bIg()) {
                showToast(this.fDl.bhl().bIi());
                this.fDl.kS(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void ra(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hl().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fHG.notifyDataSetChanged();
            }
            bez();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void rb(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fHN != null) {
            this.fHN.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bex();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            R(intent);
                        } else {
                            T(intent);
                        }
                        this.fHG.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fHG.notifyDataSetChanged();
                        bez();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fHE.ao(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bex();
                    S(intent);
                    this.fHG.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fHG.notifyDataSetChanged();
                    bez();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fHE.hc(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bex() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void R(Intent intent) {
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
            bex();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void S(Intent intent) {
        b(intent, false);
    }

    private void T(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bex();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dsk;
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
                    com.baidu.tieba.face.b.b(this.fHE);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bey();
                    return;
                case 14:
                    bex();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Jf().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.o) {
                        this.fHE.b((com.baidu.tbadk.coreExtra.data.o) aVar.data);
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
            this.fHN.setVoiceModel(voiceModel);
            this.fHH.setVisibility(0);
            this.fHI.setVoiceModel(voiceModel);
            bez();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bey() {
        if (this.fHN.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bp(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fHN.getVoiceModel().voiceId));
        }
        this.fHN.setVoiceModel(null);
        this.fHH.setVisibility(8);
        this.fHI.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eZ = this.aPh.eZ(6);
        if (eZ != null && eZ.aPu != null) {
            eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bez();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bez() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fHE.getText().toString());
        boolean z4 = (this.fHN == null || this.fHN.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fHB != null) {
            this.fHB.setEnabled(z);
        }
        if (z) {
            if (this.fHB != null) {
                com.baidu.tbadk.core.util.al.h(this.fHB, e.d.cp_link_tip_a);
            }
        } else if (this.fHB != null) {
            com.baidu.tbadk.core.util.al.h(this.fHB, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.fHE, e.d.cp_cont_b);
        this.fHE.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.fHK, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fDl != null) {
            this.fDl.onChangeSkinType();
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
        if (this.fDl != null) {
            this.fDl.onDestroy();
        }
    }
}
