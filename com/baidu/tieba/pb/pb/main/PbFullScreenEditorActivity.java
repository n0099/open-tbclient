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
import androidx.annotation.NonNull;
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
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, o.a {
    private EditorScrollView fub;
    private EditorTools fyO;
    private VoiceManager jaA;
    public ar kOl;
    private SpanGroupManager lKA;
    private WholeDisplayGridView lKB;
    private o lKC;
    private LinearLayout lKD;
    private PlayVoiceBntNew lKE;
    private LinearLayout lKF;
    private ImageView lKG;
    private LinearLayout lKH;
    private t lKI;
    private s lKJ;
    private PbEditorData lKK;
    private PostWriteCallBackData lKL;
    private View lKM;
    private View lKw = null;
    private TextView lKx = null;
    private TextView lKy = null;
    private PbFullScreenEditorInputView lKz;
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
        this.jaA = new VoiceManager();
        this.jaA.onCreate(getPageContext());
        initView();
        initData();
        if (this.lKK != null && this.lKK.getEditorType() == 1 && this.lKz != null) {
            this.lKz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kOl = new ar();
        if (this.lKz != null) {
            this.kOl.f(this.lKz);
        }
        if (this.lKL != null) {
            this.kOl.h(this.lKL);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bEt();
        this.mTopLine = findViewById(R.id.view_line);
        this.fub = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fub.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fyO != null) {
                    PbFullScreenEditorActivity.this.fyO.bzl();
                    PbFullScreenEditorActivity.this.fyO.bBc();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lKz);
            }
        });
        dlR();
        this.lKz = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fyO != null) {
                    PbFullScreenEditorActivity.this.fyO.bzl();
                    PbFullScreenEditorActivity.this.fyO.bBc();
                }
            }
        });
        this.lKz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dlU();
                if (PbFullScreenEditorActivity.this.kOl != null && PbFullScreenEditorActivity.this.kOl.dpr() != null) {
                    if (!PbFullScreenEditorActivity.this.kOl.dpr().dUc()) {
                        PbFullScreenEditorActivity.this.kOl.vB(false);
                    }
                    PbFullScreenEditorActivity.this.kOl.dpr().yY(false);
                }
            }
        });
        this.lKA = this.lKz.getSpanGroupManager();
        this.lKD = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lKE = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lKF = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lKG = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dlT();
            }
        });
        this.lKB = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lKC = new o(this.mContext);
        this.lKC.a(this);
        this.lKB.setAdapter((ListAdapter) this.lKC);
    }

    private void dlR() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lKO = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lKB) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lKO);
                    int x = ((int) motionEvent.getX()) - this.lKO[0];
                    int y = ((int) motionEvent.getY()) - this.lKO[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fyO.bzl();
                        PbFullScreenEditorActivity.this.fyO.bBc();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lKz);
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
        this.lKM = findViewById(R.id.scroll_view_child);
        this.lKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fyO != null) {
                    PbFullScreenEditorActivity.this.fyO.bzl();
                    PbFullScreenEditorActivity.this.fyO.bBc();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lKz);
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

    private void bEt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lKw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lKy = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lKy, R.color.CAM_X0105);
        this.lKx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lKw != null && this.lKx != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKw.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lKw.getLayoutParams();
            layoutParams2.width = -2;
            this.lKw.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lKw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lKx.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lKx.setLayoutParams(layoutParams3);
            this.lKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.uT(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lKK = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lKK != null) {
                uS(this.lKK.getEditorType() == 1);
                final String disableVoiceMessage = this.lKK.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fyO != null) {
                    com.baidu.tbadk.editortools.h qM = this.fyO.qM(6);
                    if (qM instanceof View) {
                        ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lKK.getThreadData();
                if (this.lKI != null) {
                    this.lKI.setThreadData(this.mThreadData);
                }
                if (this.lKJ != null) {
                    this.lKJ.setThreadData(this.mThreadData);
                }
                String content = this.lKK.getContent();
                if (this.lKK.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lKK.getSubPbReplyPrefix();
                    this.lKz.fT(this.mSubPbReplyPrefix, content);
                } else {
                    this.lKz.gn(content);
                }
                WriteImagesInfo writeImagesInfo = this.lKK.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lKC.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lKC.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lKK.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lKD.setVisibility(0);
                    this.lKE.setVoiceModel(voiceModel);
                    this.lKJ.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qP = this.fyO.qP(6);
                    if (qP != null && qP.fyZ != null) {
                        qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fyO.bP((View) this.fyO.qM(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lKL = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dlU();
    }

    private void uS(boolean z) {
        this.lKH = (LinearLayout) findViewById(R.id.editbar_container);
        this.lKI = new t();
        this.lKI.uU(z);
        if (this.lKK != null && this.lKK.getThreadData() != null) {
            this.lKI.uV(this.lKK.getThreadData().isBJH);
        }
        this.lKJ = (s) this.lKI.fh(this.mContext);
        this.fyO = this.lKJ.bAP();
        this.lKJ.d(this);
        this.lKI.b(this);
        this.lKH.addView(this.fyO, new LinearLayout.LayoutParams(-1, -2));
        this.fyO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lKJ.e(this);
        this.fyO.rV();
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
        uT(false);
    }

    public void uT(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lKK == null) {
            this.lKK = new PbEditorData();
        }
        if (this.lKA != null) {
            pbFullScreenEditorInputView = this.lKA.buJ();
        } else {
            pbFullScreenEditorInputView = this.lKz.toString();
        }
        this.lKK.setContent(pbFullScreenEditorInputView);
        this.lKK.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lKK.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lKK.setVoiceModel(this.lKJ.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lKK);
        if (z) {
            if (this.kOl != null && this.kOl.dpr() != null && this.kOl.dpr().dUb()) {
                showToast(this.kOl.dpr().dUd());
                this.kOl.vB(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void Fl(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lKC.notifyDataSetChanged();
            }
            dlU();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void Fm(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lKJ != null) {
            this.lKJ.bBy();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lKJ != null) {
            this.lKJ.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        dlS();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lKC.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lKC.notifyDataSetChanged();
                        dlU();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lKz.aY(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dlS();
                    ad(intent);
                    this.lKC.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lKC.notifyDataSetChanged();
                    dlU();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lKz.CB(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dlS() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ac(Intent intent) {
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
            dlS();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ad(Intent intent) {
        b(intent, false);
    }

    private void ae(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            dlS();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jaA;
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
                    com.baidu.tieba.face.b.d(this.lKz);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dlT();
                    return;
                case 14:
                    dlS();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bBs().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bwd() == EmotionGroupType.BIG_EMOTION || uVar.bwd() == EmotionGroupType.USER_COLLECT) {
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
                                dlS();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lKC.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lKC.notifyDataSetChanged();
                                dlU();
                                return;
                            }
                            return;
                        }
                        this.lKz.b(uVar);
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
            this.lKJ.setVoiceModel(voiceModel);
            this.lKD.setVisibility(0);
            this.lKE.setVoiceModel(voiceModel);
            dlU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlT() {
        if (this.lKJ.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Bu(this.lKJ.getVoiceModel().voiceId));
        }
        this.lKJ.setVoiceModel(null);
        this.lKD.setVisibility(8);
        this.lKE.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qP = this.fyO.qP(6);
        if (qP != null && qP.fyZ != null) {
            qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dlU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlU() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lKz.getText().toString());
        boolean z4 = (this.lKJ == null || this.lKJ.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lKx != null) {
            this.lKx.setEnabled(z);
        }
        if (z) {
            if (this.lKx != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lKx, R.color.CAM_X0302);
            }
        } else if (this.lKx != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lKx, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lKz, R.color.CAM_X0105);
        this.lKz.setHintTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ao.setImageResource(this.lKG, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lKy, R.color.CAM_X0105);
        dlU();
        if (this.kOl != null) {
            this.kOl.onChangeSkinType();
        }
        if (this.fyO != null) {
            this.fyO.onChangeSkinType(i);
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
        if (this.kOl != null) {
            this.kOl.onDestroy();
        }
        if (this.jaA != null) {
            this.jaA.removeBlackScreen();
        }
    }
}
