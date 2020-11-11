package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, r.a {
    private EditorScrollView fiv;
    private EditorTools fne;
    private VoiceManager iHo;
    public bb kzD;
    private View lvH = null;
    private TextView lvI = null;
    private TextView lvJ = null;
    private PbFullScreenEditorInputView lvK;
    private SpanGroupManager lvL;
    private WholeDisplayGridView lvM;
    private r lvN;
    private LinearLayout lvO;
    private PlayVoiceBntNew lvP;
    private LinearLayout lvQ;
    private ImageView lvR;
    private LinearLayout lvS;
    private x lvT;
    private w lvU;
    private PbEditorData lvV;
    private PostWriteCallBackData lvW;
    private View lvX;
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
        this.iHo = new VoiceManager();
        this.iHo.onCreate(getPageContext());
        initView();
        initData();
        if (this.lvV != null && this.lvV.getEditorType() == 1 && this.lvK != null) {
            this.lvK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kzD = new bb();
        if (this.lvK != null) {
            this.kzD.e(this.lvK);
        }
        if (this.lvW != null) {
            this.kzD.h(this.lvW);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bCV();
        this.mTopLine = findViewById(R.id.view_line);
        this.fiv = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fiv.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fne != null) {
                    PbFullScreenEditorActivity.this.fne.bxU();
                    PbFullScreenEditorActivity.this.fne.bzK();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lvK);
            }
        });
        dlk();
        this.lvK = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lvK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fne != null) {
                    PbFullScreenEditorActivity.this.fne.bxU();
                    PbFullScreenEditorActivity.this.fne.bzK();
                }
            }
        });
        this.lvK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dln();
                if (PbFullScreenEditorActivity.this.kzD != null && PbFullScreenEditorActivity.this.kzD.doC() != null) {
                    if (!PbFullScreenEditorActivity.this.kzD.doC().dSW()) {
                        PbFullScreenEditorActivity.this.kzD.uY(false);
                    }
                    PbFullScreenEditorActivity.this.kzD.doC().yq(false);
                }
            }
        });
        this.lvL = new SpanGroupManager(this.lvK, getUniqueId());
        this.lvO = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lvP = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lvQ = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lvR = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lvQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dlm();
            }
        });
        this.lvM = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lvN = new r(this.mContext);
        this.lvN.a(this);
        this.lvM.setAdapter((ListAdapter) this.lvN);
    }

    private void dlk() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lvZ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lvM) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lvZ);
                    int x = ((int) motionEvent.getX()) - this.lvZ[0];
                    int y = ((int) motionEvent.getY()) - this.lvZ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fne.bxU();
                        PbFullScreenEditorActivity.this.fne.bzK();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lvK);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.lvX = findViewById(R.id.scroll_view_child);
        this.lvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fne != null) {
                    PbFullScreenEditorActivity.this.fne.bxU();
                    PbFullScreenEditorActivity.this.fne.bzK();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lvK);
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

    private void bCV() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lvH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lvJ = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvJ, R.color.cp_cont_b);
        this.lvI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lvH != null && this.lvI != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvH.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lvH.getLayoutParams();
            layoutParams2.width = -2;
            this.lvH.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lvI.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lvI.setLayoutParams(layoutParams3);
            this.lvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.ur(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lvV = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lvV != null) {
                uq(this.lvV.getEditorType() == 1);
                final String disableVoiceMessage = this.lvV.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fne != null) {
                    com.baidu.tbadk.editortools.h rh = this.fne.rh(6);
                    if (rh instanceof View) {
                        ((View) rh).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lvV.getThreadData();
                if (this.lvT != null) {
                    this.lvT.setThreadData(this.mThreadData);
                }
                if (this.lvU != null) {
                    this.lvU.setThreadData(this.mThreadData);
                }
                String content = this.lvV.getContent();
                if (this.lvV.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lvV.getSubPbReplyPrefix();
                    this.lvK.fS(this.mSubPbReplyPrefix, content);
                } else {
                    this.lvK.hw(content);
                }
                WriteImagesInfo writeImagesInfo = this.lvV.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lvN.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lvN.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lvV.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lvO.setVisibility(0);
                    this.lvP.setVoiceModel(voiceModel);
                    this.lvU.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m rk = this.fne.rk(6);
                    if (rk != null && rk.fnp != null) {
                        rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fne.bA((View) this.fne.rh(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lvW = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dln();
    }

    private void uq(boolean z) {
        this.lvS = (LinearLayout) findViewById(R.id.editbar_container);
        this.lvT = new x();
        this.lvT.us(z);
        if (this.lvV != null && this.lvV.getThreadData() != null) {
            this.lvT.ut(this.lvV.getThreadData().isBJH);
        }
        this.lvU = (w) this.lvT.ei(this.mContext);
        this.fne = this.lvU.bzx();
        this.lvU.d(this);
        this.lvT.b(this);
        this.lvS.addView(this.fne, new LinearLayout.LayoutParams(-1, -2));
        this.fne.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lvU.e(this);
        this.fne.display();
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
        ur(false);
    }

    public void ur(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lvV == null) {
            this.lvV = new PbEditorData();
        }
        if (this.lvL != null) {
            pbFullScreenEditorInputView = this.lvL.btt();
        } else {
            pbFullScreenEditorInputView = this.lvK.toString();
        }
        this.lvV.setContent(pbFullScreenEditorInputView);
        this.lvV.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lvV.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lvV.setVoiceModel(this.lvU.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lvV);
        if (z) {
            if (this.kzD != null && this.kzD.doC() != null && this.kzD.doC().dSV()) {
                showToast(this.kzD.doC().dSX());
                this.kzD.uY(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void FM(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lvN.notifyDataSetChanged();
            }
            dln();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void FN(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lvU != null) {
            this.lvU.bAg();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lvU != null) {
            this.lvU.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        dll();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ad(intent);
                        } else {
                            af(intent);
                        }
                        this.lvN.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lvN.notifyDataSetChanged();
                        dln();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lvK.ba(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dll();
                    ae(intent);
                    this.lvN.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lvN.notifyDataSetChanged();
                    dln();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lvK.DJ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dll() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ad(Intent intent) {
        String stringExtra = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            dll();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ae(Intent intent) {
        a(intent, false);
    }

    private void af(Intent intent) {
        a(intent, true);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            dll();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    com.baidu.tieba.face.b.b(this.lvK);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dlm();
                    return;
                case 14:
                    dll();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bAa().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.buM() == EmotionGroupType.BIG_EMOTION || uVar.buM() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                            }
                            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                                if (this.mWriteImagesInfo.size() >= this.mWriteImagesInfo.getMaxImagesAllowed()) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(uVar.getName());
                                imageFileInfo.width = uVar.getWidth();
                                imageFileInfo.height = uVar.getHeight();
                                dll();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lvN.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lvN.notifyDataSetChanged();
                                dln();
                                return;
                            }
                            return;
                        }
                        this.lvK.b(uVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.lvU.setVoiceModel(voiceModel);
            this.lvO.setVisibility(0);
            this.lvP.setVoiceModel(voiceModel);
            dln();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (this.lvU.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CB(this.lvU.getVoiceModel().voiceId));
        }
        this.lvU.setVoiceModel(null);
        this.lvO.setVisibility(8);
        this.lvP.setVoiceModel(null);
        com.baidu.tbadk.editortools.m rk = this.fne.rk(6);
        if (rk != null && rk.fnp != null) {
            rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dln() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lvK.getText().toString());
        boolean z4 = (this.lvU == null || this.lvU.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lvI != null) {
            this.lvI.setEnabled(z);
        }
        if (z) {
            if (this.lvI != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvI, R.color.cp_link_tip_a);
            }
        } else if (this.lvI != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvI, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvK, R.color.cp_cont_b);
        this.lvK.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lvR, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvJ, R.color.cp_cont_b);
        dln();
        if (this.kzD != null) {
            this.kzD.onChangeSkinType();
        }
        if (this.fne != null) {
            this.fne.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kzD != null) {
            this.kzD.onDestroy();
        }
        if (this.iHo != null) {
            this.iHo.removeBlackScreen();
        }
    }
}
