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
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorScrollView ckZ;
    private EditorTools cqs;
    private VoiceManager foP;
    public as hEu;
    private View hIH = null;
    private TextView hII = null;
    private TextView hIJ = null;
    private PbFullScreenEditorInputView hIK;
    private WholeDisplayGridView hIL;
    private n hIM;
    private LinearLayout hIN;
    private PlayVoiceBntNew hIO;
    private LinearLayout hIP;
    private ImageView hIQ;
    private LinearLayout hIR;
    private u hIS;
    private t hIT;
    private PbEditorData hIU;
    private PostWriteCallBackData hIV;
    private View hIW;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.foP = new VoiceManager();
        this.foP.onCreate(getPageContext());
        initView();
        initData();
        if (this.hIU != null && this.hIU.getEditorType() == 1 && this.hIK != null) {
            this.hIK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hEu = new as();
        if (this.hIK != null) {
            this.hEu.k(this.hIK);
        }
        if (this.hIV != null) {
            this.hEu.f(this.hIV);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aHR();
        this.mTopLine = findViewById(R.id.view_line);
        this.ckZ = (EditorScrollView) findViewById(R.id.scroll_view);
        this.ckZ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cqs != null) {
                    PbFullScreenEditorActivity.this.cqs.app();
                    PbFullScreenEditorActivity.this.cqs.ard();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hIK);
            }
        });
        bSB();
        this.hIK = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cqs != null) {
                    PbFullScreenEditorActivity.this.cqs.app();
                    PbFullScreenEditorActivity.this.cqs.ard();
                }
            }
        });
        this.hIK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bSE();
                if (PbFullScreenEditorActivity.this.hEu != null && PbFullScreenEditorActivity.this.hEu.bVt() != null) {
                    if (!PbFullScreenEditorActivity.this.hEu.bVt().cwg()) {
                        PbFullScreenEditorActivity.this.hEu.oP(false);
                    }
                    PbFullScreenEditorActivity.this.hEu.bVt().rL(false);
                }
            }
        });
        this.hIN = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hIO = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hIP = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hIQ = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hIP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bSD();
            }
        });
        this.hIL = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hIM = new n(this.mContext);
        this.hIM.a(this);
        this.hIL.setAdapter((ListAdapter) this.hIM);
    }

    private void bSB() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hIY = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hIL) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hIY);
                    int x = ((int) motionEvent.getX()) - this.hIY[0];
                    int y = ((int) motionEvent.getY()) - this.hIY[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cqs.app();
                        PbFullScreenEditorActivity.this.cqs.ard();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hIK);
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
        this.hIW = findViewById(R.id.scroll_view_child);
        this.hIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cqs != null) {
                    PbFullScreenEditorActivity.this.cqs.app();
                    PbFullScreenEditorActivity.this.cqs.ard();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hIK);
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

    private void aHR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hIH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hIJ = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hIJ, R.color.cp_cont_b);
        this.hII = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hIH != null && this.hII != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hIH.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hIH.getLayoutParams();
            layoutParams2.width = -2;
            this.hIH.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            this.hIH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hII.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds14);
            this.hII.setLayoutParams(layoutParams3);
            this.hII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.om(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hIU = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hIU != null) {
                ol(this.hIU.getEditorType() == 1);
                final String disableVoiceMessage = this.hIU.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cqs != null) {
                    com.baidu.tbadk.editortools.g kg = this.cqs.kg(6);
                    if (kg instanceof View) {
                        ((View) kg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hIU.getThreadData();
                if (this.hIS != null) {
                    this.hIS.setThreadData(this.mThreadData);
                }
                if (this.hIT != null) {
                    this.hIT.setThreadData(this.mThreadData);
                }
                String content = this.hIU.getContent();
                if (this.hIU.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hIU.getSubPbReplyPrefix();
                    this.hIK.dL(this.mSubPbReplyPrefix, content);
                } else {
                    this.hIK.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hIU.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hIM.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hIM.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hIU.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hIN.setVisibility(0);
                    this.hIO.setVoiceModel(voiceModel);
                    this.hIT.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k kj = this.cqs.kj(6);
                    if (kj != null && kj.cqF != null) {
                        kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cqs.bb((View) this.cqs.kg(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hIV = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bSE();
    }

    private void ol(boolean z) {
        this.hIR = (LinearLayout) findViewById(R.id.editbar_container);
        this.hIS = new u();
        this.hIS.on(z);
        this.hIT = (t) this.hIS.cJ(this.mContext);
        this.cqs = this.hIT.aqS();
        this.hIT.b(this);
        this.hIS.b(this);
        this.hIR.addView(this.cqs, new LinearLayout.LayoutParams(-1, -2));
        this.cqs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hIT.c(this);
        this.cqs.pO();
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
        om(false);
    }

    public void om(boolean z) {
        Intent intent = new Intent();
        if (this.hIU == null) {
            this.hIU = new PbEditorData();
        }
        this.hIU.setContent(this.hIK.getText().toString());
        this.hIU.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hIU.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hIU.setVoiceModel(this.hIT.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hIU);
        if (z) {
            if (this.hEu != null && this.hEu.bVt() != null && this.hEu.bVt().cwf()) {
                showToast(this.hEu.bVt().cwh());
                this.hEu.oP(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xm(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gt().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hIM.notifyDataSetChanged();
            }
            bSE();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xn(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.hIT != null) {
            this.hIT.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bSC();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            ap(intent);
                        } else {
                            ar(intent);
                        }
                        this.hIM.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hIM.notifyDataSetChanged();
                        bSE();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hIK.av(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bSC();
                    aq(intent);
                    this.hIM.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hIM.notifyDataSetChanged();
                    bSE();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hIK.pU(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bSC() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ap(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.af(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ah(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bSC();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void aq(Intent intent) {
        b(intent, false);
    }

    private void ar(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bSC();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foP;
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
                    com.baidu.tieba.face.b.f(this.hIK);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bSD();
                    return;
                case 14:
                    bSC();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.arp().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.alp() == EmotionGroupType.BIG_EMOTION || pVar.alp() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.aiM();
                            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.aa(this)) {
                                if (this.mWriteImagesInfo.size() >= 9) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                bSC();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hIM.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hIM.notifyDataSetChanged();
                                bSE();
                                return;
                            }
                            return;
                        }
                        this.hIK.b(pVar);
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
            this.hIT.setVoiceModel(voiceModel);
            this.hIN.setVisibility(0);
            this.hIO.setVoiceModel(voiceModel);
            bSE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSD() {
        if (this.hIT.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hIT.getVoiceModel().voiceId));
        }
        this.hIT.setVoiceModel(null);
        this.hIN.setVisibility(8);
        this.hIO.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kj = this.cqs.kj(6);
        if (kj != null && kj.cqF != null) {
            kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bSE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hIK.getText().toString());
        boolean z4 = (this.hIT == null || this.hIT.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hII != null) {
            this.hII.setEnabled(z);
        }
        if (z) {
            if (this.hII != null) {
                com.baidu.tbadk.core.util.al.j(this.hII, R.color.cp_link_tip_a);
            }
        } else if (this.hII != null) {
            com.baidu.tbadk.core.util.al.j(this.hII, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hIK, R.color.cp_cont_b);
        this.hIK.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hIQ, (int) R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, R.color.cp_bg_line_c);
        if (this.hEu != null) {
            this.hEu.onChangeSkinType();
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
        if (this.hEu != null) {
            this.hEu.onDestroy();
        }
        if (this.foP != null) {
            this.foP.removeBlackScreen();
        }
    }
}
