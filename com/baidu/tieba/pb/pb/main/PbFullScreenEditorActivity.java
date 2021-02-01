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
    private EditorTools fBd;
    private EditorScrollView fwr;
    private VoiceManager jgg;
    public ar kWo;
    private PlayVoiceBntNew lTA;
    private LinearLayout lTB;
    private ImageView lTC;
    private LinearLayout lTD;
    private t lTE;
    private s lTF;
    private PbEditorData lTG;
    private PostWriteCallBackData lTH;
    private View lTI;
    private View lTs = null;
    private TextView lTt = null;
    private TextView lTu = null;
    private PbFullScreenEditorInputView lTv;
    private SpanGroupManager lTw;
    private WholeDisplayGridView lTx;
    private o lTy;
    private LinearLayout lTz;
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
        this.jgg = new VoiceManager();
        this.jgg.onCreate(getPageContext());
        initView();
        initData();
        if (this.lTG != null && this.lTG.getEditorType() == 1 && this.lTv != null) {
            this.lTv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kWo = new ar();
        if (this.lTv != null) {
            this.kWo.f(this.lTv);
        }
        if (this.lTH != null) {
            this.kWo.h(this.lTH);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bEL();
        this.mTopLine = findViewById(R.id.view_line);
        this.fwr = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fwr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lTv);
            }
        });
        dog();
        this.lTv = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
            }
        });
        this.lTv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.doj();
                if (PbFullScreenEditorActivity.this.kWo != null && PbFullScreenEditorActivity.this.kWo.drF() != null) {
                    if (!PbFullScreenEditorActivity.this.kWo.drF().dWq()) {
                        PbFullScreenEditorActivity.this.kWo.vQ(false);
                    }
                    PbFullScreenEditorActivity.this.kWo.drF().zu(false);
                }
            }
        });
        this.lTw = this.lTv.getSpanGroupManager();
        this.lTz = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lTA = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lTB = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lTC = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.doi();
            }
        });
        this.lTx = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lTy = new o(this.mContext);
        this.lTy.a(this);
        this.lTx.setAdapter((ListAdapter) this.lTy);
    }

    private void dog() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lTK = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lTx) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lTK);
                    int x = ((int) motionEvent.getX()) - this.lTK[0];
                    int y = ((int) motionEvent.getY()) - this.lTK[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fBd.bzD();
                        PbFullScreenEditorActivity.this.fBd.bBu();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lTv);
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
        this.lTI = findViewById(R.id.scroll_view_child);
        this.lTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lTv);
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

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lTs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lTu = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTu, R.color.CAM_X0105);
        this.lTt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lTs != null && this.lTt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lTs.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lTs.getLayoutParams();
            layoutParams2.width = -2;
            this.lTs.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lTs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lTt.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lTt.setLayoutParams(layoutParams3);
            this.lTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.vi(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lTG = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lTG != null) {
                vh(this.lTG.getEditorType() == 1);
                final String disableVoiceMessage = this.lTG.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fBd != null) {
                    com.baidu.tbadk.editortools.h qR = this.fBd.qR(6);
                    if (qR instanceof View) {
                        ((View) qR).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lTG.getThreadData();
                if (this.lTE != null) {
                    this.lTE.setThreadData(this.mThreadData);
                }
                if (this.lTF != null) {
                    this.lTF.setThreadData(this.mThreadData);
                }
                String content = this.lTG.getContent();
                if (this.lTG.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lTG.getSubPbReplyPrefix();
                    this.lTv.fT(this.mSubPbReplyPrefix, content);
                } else {
                    this.lTv.gL(content);
                }
                WriteImagesInfo writeImagesInfo = this.lTG.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lTy.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lTy.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lTG.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lTz.setVisibility(0);
                    this.lTA.setVoiceModel(voiceModel);
                    this.lTF.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qU = this.fBd.qU(6);
                    if (qU != null && qU.fBo != null) {
                        qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fBd.bL((View) this.fBd.qR(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lTH = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        doj();
    }

    private void vh(boolean z) {
        this.lTD = (LinearLayout) findViewById(R.id.editbar_container);
        this.lTE = new t();
        this.lTE.vj(z);
        if (this.lTG != null && this.lTG.getThreadData() != null) {
            this.lTE.vk(this.lTG.getThreadData().isBJH);
        }
        this.lTF = (s) this.lTE.fg(this.mContext);
        this.fBd = this.lTF.bBh();
        this.lTF.d(this);
        this.lTE.b(this);
        this.lTD.addView(this.fBd, new LinearLayout.LayoutParams(-1, -2));
        this.fBd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lTF.e(this);
        this.fBd.display();
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
        vi(false);
    }

    public void vi(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lTG == null) {
            this.lTG = new PbEditorData();
        }
        if (this.lTw != null) {
            pbFullScreenEditorInputView = this.lTw.bvd();
        } else {
            pbFullScreenEditorInputView = this.lTv.toString();
        }
        this.lTG.setContent(pbFullScreenEditorInputView);
        this.lTG.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lTG.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lTG.setVoiceModel(this.lTF.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lTG);
        if (z) {
            if (this.kWo != null && this.kWo.drF() != null && this.kWo.drF().dWp()) {
                showToast(this.kWo.drF().dWr());
                this.kWo.vQ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FE(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lTy.notifyDataSetChanged();
            }
            doj();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FF(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lTF != null) {
            this.lTF.bBQ();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lTF != null) {
            this.lTF.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        doh();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lTy.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lTy.notifyDataSetChanged();
                        doj();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lTv.aX(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    doh();
                    ad(intent);
                    this.lTy.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lTy.notifyDataSetChanged();
                    doj();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lTv.CS(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void doh() {
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
                    com.baidu.tbadk.core.util.o.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            doh();
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
            doh();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgg;
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
                    com.baidu.tieba.face.b.d(this.lTv);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    doi();
                    return;
                case 14:
                    doh();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bBK().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bwv() == EmotionGroupType.BIG_EMOTION || uVar.bwv() == EmotionGroupType.USER_COLLECT) {
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
                                doh();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lTy.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lTy.notifyDataSetChanged();
                                doj();
                                return;
                            }
                            return;
                        }
                        this.lTv.b(uVar);
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
            this.lTF.setVoiceModel(voiceModel);
            this.lTz.setVisibility(0);
            this.lTA.setVoiceModel(voiceModel);
            doj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        if (this.lTF.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BL(this.lTF.getVoiceModel().voiceId));
        }
        this.lTF.setVoiceModel(null);
        this.lTz.setVisibility(8);
        this.lTA.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qU = this.fBd.qU(6);
        if (qU != null && qU.fBo != null) {
            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        doj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doj() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lTv.getText().toString());
        boolean z4 = (this.lTF == null || this.lTF.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lTt != null) {
            this.lTt.setEnabled(z);
        }
        if (z) {
            if (this.lTt != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTt, R.color.CAM_X0302);
            }
        } else if (this.lTt != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTt, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTv, R.color.CAM_X0105);
        this.lTv.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lTC, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTu, R.color.CAM_X0105);
        doj();
        if (this.kWo != null) {
            this.kWo.onChangeSkinType();
        }
        if (this.fBd != null) {
            this.fBd.onChangeSkinType(i);
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
        if (this.kWo != null) {
            this.kWo.onDestroy();
        }
        if (this.jgg != null) {
            this.jgg.removeBlackScreen();
        }
    }
}
