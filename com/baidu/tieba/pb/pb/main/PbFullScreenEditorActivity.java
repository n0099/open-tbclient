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
    private EditorScrollView fcD;
    private EditorTools fhk;
    private VoiceManager iBr;
    public bb ktH;
    private View lpK = null;
    private TextView lpL = null;
    private TextView lpM = null;
    private PbFullScreenEditorInputView lpN;
    private SpanGroupManager lpO;
    private WholeDisplayGridView lpP;
    private r lpQ;
    private LinearLayout lpR;
    private PlayVoiceBntNew lpS;
    private LinearLayout lpT;
    private ImageView lpU;
    private LinearLayout lpV;
    private x lpW;
    private w lpX;
    private PbEditorData lpY;
    private PostWriteCallBackData lpZ;
    private View lqa;
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
        this.iBr = new VoiceManager();
        this.iBr.onCreate(getPageContext());
        initView();
        initData();
        if (this.lpY != null && this.lpY.getEditorType() == 1 && this.lpN != null) {
            this.lpN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.ktH = new bb();
        if (this.lpN != null) {
            this.ktH.e(this.lpN);
        }
        if (this.lpZ != null) {
            this.ktH.h(this.lpZ);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bAw();
        this.mTopLine = findViewById(R.id.view_line);
        this.fcD = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fcD.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fhk != null) {
                    PbFullScreenEditorActivity.this.fhk.bvv();
                    PbFullScreenEditorActivity.this.fhk.bxl();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lpN);
            }
        });
        diI();
        this.lpN = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lpN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fhk != null) {
                    PbFullScreenEditorActivity.this.fhk.bvv();
                    PbFullScreenEditorActivity.this.fhk.bxl();
                }
            }
        });
        this.lpN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.diL();
                if (PbFullScreenEditorActivity.this.ktH != null && PbFullScreenEditorActivity.this.ktH.dlZ() != null) {
                    if (!PbFullScreenEditorActivity.this.ktH.dlZ().dQu()) {
                        PbFullScreenEditorActivity.this.ktH.uP(false);
                    }
                    PbFullScreenEditorActivity.this.ktH.dlZ().yh(false);
                }
            }
        });
        this.lpO = new SpanGroupManager(this.lpN, getUniqueId());
        this.lpR = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lpS = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lpT = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lpU = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.diK();
            }
        });
        this.lpP = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lpQ = new r(this.mContext);
        this.lpQ.a(this);
        this.lpP.setAdapter((ListAdapter) this.lpQ);
    }

    private void diI() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lqc = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lpP) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lqc);
                    int x = ((int) motionEvent.getX()) - this.lqc[0];
                    int y = ((int) motionEvent.getY()) - this.lqc[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fhk.bvv();
                        PbFullScreenEditorActivity.this.fhk.bxl();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lpN);
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
        this.lqa = findViewById(R.id.scroll_view_child);
        this.lqa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fhk != null) {
                    PbFullScreenEditorActivity.this.fhk.bvv();
                    PbFullScreenEditorActivity.this.fhk.bxl();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lpN);
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

    private void bAw() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lpK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lpM = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpM, R.color.cp_cont_b);
        this.lpL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lpK != null && this.lpL != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lpK.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lpK.getLayoutParams();
            layoutParams2.width = -2;
            this.lpK.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lpK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lpL.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lpL.setLayoutParams(layoutParams3);
            this.lpL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.ui(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lpY = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lpY != null) {
                uh(this.lpY.getEditorType() == 1);
                final String disableVoiceMessage = this.lpY.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fhk != null) {
                    com.baidu.tbadk.editortools.h qX = this.fhk.qX(6);
                    if (qX instanceof View) {
                        ((View) qX).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lpY.getThreadData();
                if (this.lpW != null) {
                    this.lpW.setThreadData(this.mThreadData);
                }
                if (this.lpX != null) {
                    this.lpX.setThreadData(this.mThreadData);
                }
                String content = this.lpY.getContent();
                if (this.lpY.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lpY.getSubPbReplyPrefix();
                    this.lpN.fS(this.mSubPbReplyPrefix, content);
                } else {
                    this.lpN.hp(content);
                }
                WriteImagesInfo writeImagesInfo = this.lpY.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lpQ.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lpQ.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lpY.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lpR.setVisibility(0);
                    this.lpS.setVoiceModel(voiceModel);
                    this.lpX.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m ra = this.fhk.ra(6);
                    if (ra != null && ra.fhv != null) {
                        ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fhk.bw((View) this.fhk.qX(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lpZ = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        diL();
    }

    private void uh(boolean z) {
        this.lpV = (LinearLayout) findViewById(R.id.editbar_container);
        this.lpW = new x();
        this.lpW.uj(z);
        if (this.lpY != null && this.lpY.getThreadData() != null) {
            this.lpW.uk(this.lpY.getThreadData().isBJH);
        }
        this.lpX = (w) this.lpW.ei(this.mContext);
        this.fhk = this.lpX.bwY();
        this.lpX.d(this);
        this.lpW.b(this);
        this.lpV.addView(this.fhk, new LinearLayout.LayoutParams(-1, -2));
        this.fhk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lpX.e(this);
        this.fhk.display();
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
        ui(false);
    }

    public void ui(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lpY == null) {
            this.lpY = new PbEditorData();
        }
        if (this.lpO != null) {
            pbFullScreenEditorInputView = this.lpO.bqT();
        } else {
            pbFullScreenEditorInputView = this.lpN.toString();
        }
        this.lpY.setContent(pbFullScreenEditorInputView);
        this.lpY.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lpY.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lpY.setVoiceModel(this.lpX.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lpY);
        if (z) {
            if (this.ktH != null && this.ktH.dlZ() != null && this.ktH.dlZ().dQt()) {
                showToast(this.ktH.dlZ().dQv());
                this.ktH.uP(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Fz(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lpQ.notifyDataSetChanged();
            }
            diL();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void FA(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lpX != null) {
            this.lpX.bxH();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lpX != null) {
            this.lpX.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        diJ();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ad(intent);
                        } else {
                            af(intent);
                        }
                        this.lpQ.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lpQ.notifyDataSetChanged();
                        diL();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lpN.ba(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    diJ();
                    ae(intent);
                    this.lpQ.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lpQ.notifyDataSetChanged();
                    diL();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lpN.Dv(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void diJ() {
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
            diJ();
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
            diJ();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iBr;
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
                    com.baidu.tieba.face.b.b(this.lpN);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    diK();
                    return;
                case 14:
                    diJ();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bxB().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bsm() == EmotionGroupType.BIG_EMOTION || uVar.bsm() == EmotionGroupType.USER_COLLECT) {
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
                                diJ();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lpQ.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lpQ.notifyDataSetChanged();
                                diL();
                                return;
                            }
                            return;
                        }
                        this.lpN.b(uVar);
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
            this.lpX.setVoiceModel(voiceModel);
            this.lpR.setVisibility(0);
            this.lpS.setVoiceModel(voiceModel);
            diL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diK() {
        if (this.lpX.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Cn(this.lpX.getVoiceModel().voiceId));
        }
        this.lpX.setVoiceModel(null);
        this.lpR.setVisibility(8);
        this.lpS.setVoiceModel(null);
        com.baidu.tbadk.editortools.m ra = this.fhk.ra(6);
        if (ra != null && ra.fhv != null) {
            ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        diL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diL() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lpN.getText().toString());
        boolean z4 = (this.lpX == null || this.lpX.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lpL != null) {
            this.lpL.setEnabled(z);
        }
        if (z) {
            if (this.lpL != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpL, R.color.cp_link_tip_a);
            }
        } else if (this.lpL != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpL, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpN, R.color.cp_cont_b);
        this.lpN.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lpU, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpM, R.color.cp_cont_b);
        diL();
        if (this.ktH != null) {
            this.ktH.onChangeSkinType();
        }
        if (this.fhk != null) {
            this.fhk.onChangeSkinType(i);
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
        if (this.ktH != null) {
            this.ktH.onDestroy();
        }
        if (this.iBr != null) {
            this.iBr.removeBlackScreen();
        }
    }
}
