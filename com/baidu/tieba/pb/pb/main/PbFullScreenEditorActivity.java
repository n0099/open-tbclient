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
    private EditorScrollView ckY;
    private EditorTools cqr;
    private VoiceManager foO;
    public as hEq;
    private View hID = null;
    private TextView hIE = null;
    private TextView hIF = null;
    private PbFullScreenEditorInputView hIG;
    private WholeDisplayGridView hIH;
    private n hII;
    private LinearLayout hIJ;
    private PlayVoiceBntNew hIK;
    private LinearLayout hIL;
    private ImageView hIM;
    private LinearLayout hIN;
    private u hIO;
    private t hIP;
    private PbEditorData hIQ;
    private PostWriteCallBackData hIR;
    private View hIS;
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
        this.foO = new VoiceManager();
        this.foO.onCreate(getPageContext());
        initView();
        initData();
        if (this.hIQ != null && this.hIQ.getEditorType() == 1 && this.hIG != null) {
            this.hIG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hEq = new as();
        if (this.hIG != null) {
            this.hEq.k(this.hIG);
        }
        if (this.hIR != null) {
            this.hEq.f(this.hIR);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aHO();
        this.mTopLine = findViewById(R.id.view_line);
        this.ckY = (EditorScrollView) findViewById(R.id.scroll_view);
        this.ckY.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cqr != null) {
                    PbFullScreenEditorActivity.this.cqr.app();
                    PbFullScreenEditorActivity.this.cqr.ard();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hIG);
            }
        });
        bSx();
        this.hIG = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cqr != null) {
                    PbFullScreenEditorActivity.this.cqr.app();
                    PbFullScreenEditorActivity.this.cqr.ard();
                }
            }
        });
        this.hIG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bSA();
                if (PbFullScreenEditorActivity.this.hEq != null && PbFullScreenEditorActivity.this.hEq.bVp() != null) {
                    if (!PbFullScreenEditorActivity.this.hEq.bVp().cwf()) {
                        PbFullScreenEditorActivity.this.hEq.oO(false);
                    }
                    PbFullScreenEditorActivity.this.hEq.bVp().rK(false);
                }
            }
        });
        this.hIJ = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hIK = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hIL = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hIM = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hIL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bSz();
            }
        });
        this.hIH = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hII = new n(this.mContext);
        this.hII.a(this);
        this.hIH.setAdapter((ListAdapter) this.hII);
    }

    private void bSx() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hIU = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hIH) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hIU);
                    int x = ((int) motionEvent.getX()) - this.hIU[0];
                    int y = ((int) motionEvent.getY()) - this.hIU[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cqr.app();
                        PbFullScreenEditorActivity.this.cqr.ard();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hIG);
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
        this.hIS = findViewById(R.id.scroll_view_child);
        this.hIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cqr != null) {
                    PbFullScreenEditorActivity.this.cqr.app();
                    PbFullScreenEditorActivity.this.cqr.ard();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hIG);
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

    private void aHO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hID = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hIF = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hIF, R.color.cp_cont_b);
        this.hIE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hID != null && this.hIE != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hID.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hID.getLayoutParams();
            layoutParams2.width = -2;
            this.hID.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            this.hID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hIE.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds14);
            this.hIE.setLayoutParams(layoutParams3);
            this.hIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.ol(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hIQ = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hIQ != null) {
                ok(this.hIQ.getEditorType() == 1);
                final String disableVoiceMessage = this.hIQ.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cqr != null) {
                    com.baidu.tbadk.editortools.g kg = this.cqr.kg(6);
                    if (kg instanceof View) {
                        ((View) kg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hIQ.getThreadData();
                if (this.hIO != null) {
                    this.hIO.setThreadData(this.mThreadData);
                }
                if (this.hIP != null) {
                    this.hIP.setThreadData(this.mThreadData);
                }
                String content = this.hIQ.getContent();
                if (this.hIQ.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hIQ.getSubPbReplyPrefix();
                    this.hIG.dL(this.mSubPbReplyPrefix, content);
                } else {
                    this.hIG.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hIQ.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hII.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hII.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hIQ.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hIJ.setVisibility(0);
                    this.hIK.setVoiceModel(voiceModel);
                    this.hIP.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k kj = this.cqr.kj(6);
                    if (kj != null && kj.cqE != null) {
                        kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cqr.bb((View) this.cqr.kg(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hIR = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bSA();
    }

    private void ok(boolean z) {
        this.hIN = (LinearLayout) findViewById(R.id.editbar_container);
        this.hIO = new u();
        this.hIO.om(z);
        this.hIP = (t) this.hIO.cJ(this.mContext);
        this.cqr = this.hIP.aqS();
        this.hIP.b(this);
        this.hIO.b(this);
        this.hIN.addView(this.cqr, new LinearLayout.LayoutParams(-1, -2));
        this.cqr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hIP.c(this);
        this.cqr.pO();
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
        ol(false);
    }

    public void ol(boolean z) {
        Intent intent = new Intent();
        if (this.hIQ == null) {
            this.hIQ = new PbEditorData();
        }
        this.hIQ.setContent(this.hIG.getText().toString());
        this.hIQ.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hIQ.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hIQ.setVoiceModel(this.hIP.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hIQ);
        if (z) {
            if (this.hEq != null && this.hEq.bVp() != null && this.hEq.bVp().cwe()) {
                showToast(this.hEq.bVp().cwg());
                this.hEq.oO(true);
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
                this.hII.notifyDataSetChanged();
            }
            bSA();
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
        if (this.hIP != null) {
            this.hIP.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bSy();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            ap(intent);
                        } else {
                            ar(intent);
                        }
                        this.hII.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hII.notifyDataSetChanged();
                        bSA();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hIG.av(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bSy();
                    aq(intent);
                    this.hII.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hII.notifyDataSetChanged();
                    bSA();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hIG.pV(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bSy() {
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
            bSy();
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
            bSy();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foO;
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
                    com.baidu.tieba.face.b.f(this.hIG);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bSz();
                    return;
                case 14:
                    bSy();
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
                                bSy();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hII.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hII.notifyDataSetChanged();
                                bSA();
                                return;
                            }
                            return;
                        }
                        this.hIG.b(pVar);
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
            this.hIP.setVoiceModel(voiceModel);
            this.hIJ.setVisibility(0);
            this.hIK.setVoiceModel(voiceModel);
            bSA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSz() {
        if (this.hIP.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hIP.getVoiceModel().voiceId));
        }
        this.hIP.setVoiceModel(null);
        this.hIJ.setVisibility(8);
        this.hIK.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kj = this.cqr.kj(6);
        if (kj != null && kj.cqE != null) {
            kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bSA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSA() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hIG.getText().toString());
        boolean z4 = (this.hIP == null || this.hIP.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hIE != null) {
            this.hIE.setEnabled(z);
        }
        if (z) {
            if (this.hIE != null) {
                com.baidu.tbadk.core.util.al.j(this.hIE, R.color.cp_link_tip_a);
            }
        } else if (this.hIE != null) {
            com.baidu.tbadk.core.util.al.j(this.hIE, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hIG, R.color.cp_cont_b);
        this.hIG.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hIM, (int) R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, R.color.cp_bg_line_c);
        if (this.hEq != null) {
            this.hEq.onChangeSkinType();
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
        if (this.hEq != null) {
            this.hEq.onDestroy();
        }
        if (this.foO != null) {
            this.foO.removeBlackScreen();
        }
    }
}
