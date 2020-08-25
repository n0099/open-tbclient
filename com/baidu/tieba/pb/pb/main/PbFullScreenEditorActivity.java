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
/* loaded from: classes16.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, r.a {
    private EditorScrollView eFO;
    private EditorTools eKm;
    private VoiceManager hSO;
    public bb jJC;
    private LinearLayout kFA;
    private x kFB;
    private w kFC;
    private PbEditorData kFD;
    private PostWriteCallBackData kFE;
    private View kFF;
    private View kFp = null;
    private TextView kFq = null;
    private TextView kFr = null;
    private PbFullScreenEditorInputView kFs;
    private SpanGroupManager kFt;
    private WholeDisplayGridView kFu;
    private r kFv;
    private LinearLayout kFw;
    private PlayVoiceBntNew kFx;
    private LinearLayout kFy;
    private ImageView kFz;
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
        this.hSO = new VoiceManager();
        this.hSO.onCreate(getPageContext());
        initView();
        initData();
        if (this.kFD != null && this.kFD.getEditorType() == 1 && this.kFs != null) {
            this.kFs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jJC = new bb();
        if (this.kFs != null) {
            this.jJC.f(this.kFs);
        }
        if (this.kFE != null) {
            this.jJC.g(this.kFE);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        buO();
        this.mTopLine = findViewById(R.id.view_line);
        this.eFO = (EditorScrollView) findViewById(R.id.scroll_view);
        this.eFO.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.eKm != null) {
                    PbFullScreenEditorActivity.this.eKm.bpX();
                    PbFullScreenEditorActivity.this.eKm.brG();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.kFs);
            }
        });
        cYo();
        this.kFs = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.kFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eKm != null) {
                    PbFullScreenEditorActivity.this.eKm.bpX();
                    PbFullScreenEditorActivity.this.eKm.brG();
                }
            }
        });
        this.kFs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cYr();
                if (PbFullScreenEditorActivity.this.jJC != null && PbFullScreenEditorActivity.this.jJC.dbE() != null) {
                    if (!PbFullScreenEditorActivity.this.jJC.dbE().dFx()) {
                        PbFullScreenEditorActivity.this.jJC.tI(false);
                    }
                    PbFullScreenEditorActivity.this.jJC.dbE().wY(false);
                }
            }
        });
        this.kFt = new SpanGroupManager(this.kFs, getUniqueId());
        this.kFw = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kFx = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kFy = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.kFz = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cYq();
            }
        });
        this.kFu = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.kFv = new r(this.mContext);
        this.kFv.a(this);
        this.kFu.setAdapter((ListAdapter) this.kFv);
    }

    private void cYo() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] kFH = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.kFu) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.kFH);
                    int x = ((int) motionEvent.getX()) - this.kFH[0];
                    int y = ((int) motionEvent.getY()) - this.kFH[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.eKm.bpX();
                        PbFullScreenEditorActivity.this.eKm.brG();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kFs);
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
        this.kFF = findViewById(R.id.scroll_view_child);
        this.kFF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eKm != null) {
                    PbFullScreenEditorActivity.this.eKm.bpX();
                    PbFullScreenEditorActivity.this.eKm.brG();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kFs);
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

    private void buO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kFp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFr = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFr, R.color.cp_cont_b);
        this.kFq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.kFp != null && this.kFq != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kFp.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kFp.getLayoutParams();
            layoutParams2.width = -2;
            this.kFp.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.kFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kFq.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.kFq.setLayoutParams(layoutParams3);
            this.kFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.tb(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.kFD = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.kFD != null) {
                ta(this.kFD.getEditorType() == 1);
                final String disableVoiceMessage = this.kFD.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.eKm != null) {
                    com.baidu.tbadk.editortools.h qb = this.eKm.qb(6);
                    if (qb instanceof View) {
                        ((View) qb).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.kFD.getThreadData();
                if (this.kFB != null) {
                    this.kFB.setThreadData(this.mThreadData);
                }
                if (this.kFC != null) {
                    this.kFC.setThreadData(this.mThreadData);
                }
                String content = this.kFD.getContent();
                if (this.kFD.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.kFD.getSubPbReplyPrefix();
                    this.kFs.fs(this.mSubPbReplyPrefix, content);
                } else {
                    this.kFs.Jf(content);
                }
                WriteImagesInfo writeImagesInfo = this.kFD.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.kFv.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kFv.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.kFD.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.kFw.setVisibility(0);
                    this.kFx.setVoiceModel(voiceModel);
                    this.kFC.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qe = this.eKm.qe(6);
                    if (qe != null && qe.eKx != null) {
                        qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.eKm.bp((View) this.eKm.qb(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.kFE = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cYr();
    }

    private void ta(boolean z) {
        this.kFA = (LinearLayout) findViewById(R.id.editbar_container);
        this.kFB = new x();
        this.kFB.tc(z);
        if (this.kFD != null && this.kFD.getThreadData() != null) {
            this.kFB.td(this.kFD.getThreadData().isBJH);
        }
        this.kFC = (w) this.kFB.ec(this.mContext);
        this.eKm = this.kFC.brv();
        this.kFC.d(this);
        this.kFB.b(this);
        this.kFA.addView(this.eKm, new LinearLayout.LayoutParams(-1, -2));
        this.eKm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kFC.e(this);
        this.eKm.display();
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
        tb(false);
    }

    public void tb(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.kFD == null) {
            this.kFD = new PbEditorData();
        }
        if (this.kFt != null) {
            pbFullScreenEditorInputView = this.kFt.blw();
        } else {
            pbFullScreenEditorInputView = this.kFs.toString();
        }
        this.kFD.setContent(pbFullScreenEditorInputView);
        this.kFD.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.kFD.setWriteImagesInfo(this.mWriteImagesInfo);
        this.kFD.setVoiceModel(this.kFC.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.kFD);
        if (z) {
            if (this.jJC != null && this.jJC.dbE() != null && this.jJC.dbE().dFw()) {
                showToast(this.jJC.dbE().dFy());
                this.jJC.tI(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void DZ(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.kFv.notifyDataSetChanged();
            }
            cYr();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Ea(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.kFC != null) {
            this.kFC.brZ();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.kFC != null) {
            this.kFC.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cYp();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ag(intent);
                        } else {
                            ai(intent);
                        }
                        this.kFv.p(this.mWriteImagesInfo.getChosedFiles());
                        this.kFv.notifyDataSetChanged();
                        cYr();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.kFs.aV(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cYp();
                    ah(intent);
                    this.kFv.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kFv.notifyDataSetChanged();
                    cYr();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.kFs.BT(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cYp() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ag(Intent intent) {
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
            cYp();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ah(Intent intent) {
        a(intent, false);
    }

    private void ai(Intent intent) {
        a(intent, true);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            cYp();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSO;
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
                    com.baidu.tieba.face.b.c(this.kFs);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cYq();
                    return;
                case 14:
                    cYp();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.brT().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.t) {
                        com.baidu.tbadk.coreExtra.data.t tVar = (com.baidu.tbadk.coreExtra.data.t) aVar.data;
                        if (tVar.bmP() == EmotionGroupType.BIG_EMOTION || tVar.bmP() == EmotionGroupType.USER_COLLECT) {
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
                                imageFileInfo.setFilePath(tVar.getName());
                                imageFileInfo.width = tVar.getWidth();
                                imageFileInfo.height = tVar.getHeight();
                                cYp();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.kFv.p(this.mWriteImagesInfo.getChosedFiles());
                                this.kFv.notifyDataSetChanged();
                                cYr();
                                return;
                            }
                            return;
                        }
                        this.kFs.b(tVar);
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
            this.kFC.setVoiceModel(voiceModel);
            this.kFw.setVisibility(0);
            this.kFx.setVoiceModel(voiceModel);
            cYr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYq() {
        if (this.kFC.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.AL(this.kFC.getVoiceModel().voiceId));
        }
        this.kFC.setVoiceModel(null);
        this.kFw.setVisibility(8);
        this.kFx.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qe = this.eKm.qe(6);
        if (qe != null && qe.eKx != null) {
            qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cYr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYr() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.kFs.getText().toString());
        boolean z4 = (this.kFC == null || this.kFC.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.kFq != null) {
            this.kFq.setEnabled(z);
        }
        if (z) {
            if (this.kFq != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFq, R.color.cp_link_tip_a);
            }
        } else if (this.kFq != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFq, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFs, R.color.cp_cont_b);
        this.kFs.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ap.setImageResource(this.kFz, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFr, R.color.cp_cont_b);
        cYr();
        if (this.jJC != null) {
            this.jJC.onChangeSkinType();
        }
        if (this.eKm != null) {
            this.eKm.onChangeSkinType(i);
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
        if (this.jJC != null) {
            this.jJC.onDestroy();
        }
        if (this.hSO != null) {
            this.hSO.removeBlackScreen();
        }
    }
}
