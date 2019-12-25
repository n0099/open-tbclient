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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private EditorScrollView dnb;
    private EditorTools drW;
    private VoiceManager giZ;
    public as iCx;
    private PbFullScreenEditorInputView iEk;
    private WholeDisplayGridView iEl;
    private p iEm;
    private LinearLayout iEn;
    private PlayVoiceBntNew iEo;
    private LinearLayout iEp;
    private ImageView iEq;
    private LinearLayout iEr;
    private v iEs;
    private u iEt;
    private PbEditorData iEu;
    private PostWriteCallBackData iEv;
    private View iEw;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;
    private View iEi = null;
    private TextView iEj = null;
    private TextView mTvName = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.giZ = new VoiceManager();
        this.giZ.onCreate(getPageContext());
        initView();
        initData();
        if (this.iEu != null && this.iEu.getEditorType() == 1 && this.iEk != null) {
            this.iEk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.iCx = new as();
        if (this.iEk != null) {
            this.iCx.e(this.iEk);
        }
        if (this.iEv != null) {
            this.iCx.f(this.iEv);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aZT();
        this.mTopLine = findViewById(R.id.view_line);
        this.dnb = (EditorScrollView) findViewById(R.id.scroll_view);
        this.dnb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.drW != null) {
                    PbFullScreenEditorActivity.this.drW.aJZ();
                    PbFullScreenEditorActivity.this.drW.aLM();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.iEk);
            }
        });
        ckK();
        this.iEk = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.iEk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.drW != null) {
                    PbFullScreenEditorActivity.this.drW.aJZ();
                    PbFullScreenEditorActivity.this.drW.aLM();
                }
            }
        });
        this.iEk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.ckN();
                if (PbFullScreenEditorActivity.this.iCx != null && PbFullScreenEditorActivity.this.iCx.cnW() != null) {
                    if (!PbFullScreenEditorActivity.this.iCx.cnW().cRK()) {
                        PbFullScreenEditorActivity.this.iCx.qh(false);
                    }
                    PbFullScreenEditorActivity.this.iCx.cnW().tr(false);
                }
            }
        });
        this.iEn = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iEo = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iEp = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.iEq = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.ckM();
            }
        });
        this.iEl = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.iEm = new p(this.mContext);
        this.iEm.a(this);
        this.iEl.setAdapter((ListAdapter) this.iEm);
    }

    private void ckK() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] iEy = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.iEl) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.iEy);
                    int x = ((int) motionEvent.getX()) - this.iEy[0];
                    int y = ((int) motionEvent.getY()) - this.iEy[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.drW.aJZ();
                        PbFullScreenEditorActivity.this.drW.aLM();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iEk);
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
        this.iEw = findViewById(R.id.scroll_view_child);
        this.iEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.drW != null) {
                    PbFullScreenEditorActivity.this.drW.aJZ();
                    PbFullScreenEditorActivity.this.drW.aLM();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iEk);
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

    private void aZT() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iEi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTvName = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        this.iEj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.iEi != null && this.iEj != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iEi.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iEi.getLayoutParams();
            layoutParams2.width = -2;
            this.iEi.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iEj.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.iEj.setLayoutParams(layoutParams3);
            this.iEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.pD(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.iEu = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.iEu != null) {
                pC(this.iEu.getEditorType() == 1);
                final String disableVoiceMessage = this.iEu.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.drW != null) {
                    com.baidu.tbadk.editortools.g lU = this.drW.lU(6);
                    if (lU instanceof View) {
                        ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.iEu.getThreadData();
                if (this.iEs != null) {
                    this.iEs.setThreadData(this.mThreadData);
                }
                if (this.iEt != null) {
                    this.iEt.setThreadData(this.mThreadData);
                }
                String content = this.iEu.getContent();
                if (this.iEu.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.iEu.getSubPbReplyPrefix();
                    this.iEk.dT(this.mSubPbReplyPrefix, content);
                } else {
                    this.iEk.Bw(content);
                }
                WriteImagesInfo writeImagesInfo = this.iEu.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.iEm.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iEm.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.iEu.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.iEn.setVisibility(0);
                    this.iEo.setVoiceModel(voiceModel);
                    this.iEt.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l lX = this.drW.lX(6);
                    if (lX != null && lX.dsh != null) {
                        lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.drW.ba((View) this.drW.lU(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.iEv = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        ckN();
    }

    private void pC(boolean z) {
        this.iEr = (LinearLayout) findViewById(R.id.editbar_container);
        this.iEs = new v();
        this.iEs.pE(z);
        if (this.iEu != null && this.iEu.getThreadData() != null) {
            this.iEs.pF(this.iEu.getThreadData().isBJH);
        }
        this.iEt = (u) this.iEs.dR(this.mContext);
        this.drW = this.iEt.aLC();
        this.iEt.b(this);
        this.iEs.b(this);
        this.iEr.addView(this.drW, new LinearLayout.LayoutParams(-1, -2));
        this.drW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iEt.c(this);
        this.drW.lw();
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
        pD(false);
    }

    public void pD(boolean z) {
        Intent intent = new Intent();
        if (this.iEu == null) {
            this.iEu = new PbEditorData();
        }
        this.iEu.setContent(this.iEk.getText().toString());
        this.iEu.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.iEu.setWriteImagesInfo(this.mWriteImagesInfo);
        this.iEu.setVoiceModel(this.iEt.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.iEu);
        if (z) {
            if (this.iCx != null && this.iCx.cnW() != null && this.iCx.cnW().cRJ()) {
                showToast(this.iCx.cnW().cRL());
                this.iCx.qh(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void yx(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.iEm.notifyDataSetChanged();
            }
            ckN();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void yy(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.iEt != null) {
            this.iEt.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        ckL();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            as(intent);
                        } else {
                            au(intent);
                        }
                        this.iEm.p(this.mWriteImagesInfo.getChosedFiles());
                        this.iEm.notifyDataSetChanged();
                        ckN();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.iEk.aK(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    ckL();
                    at(intent);
                    this.iEm.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iEm.notifyDataSetChanged();
                    ckN();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.iEk.uL(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void ckL() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void as(Intent intent) {
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
                    com.baidu.tbadk.core.util.m.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            ckL();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void at(Intent intent) {
        b(intent, false);
    }

    private void au(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            ckL();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.giZ;
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
                    com.baidu.tieba.face.b.c(this.iEk);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    ckM();
                    return;
                case 14:
                    ckL();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aLY().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.aGJ() == EmotionGroupType.BIG_EMOTION || pVar.aGJ() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
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
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                ckL();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.iEm.p(this.mWriteImagesInfo.getChosedFiles());
                                this.iEm.notifyDataSetChanged();
                                ckN();
                                return;
                            }
                            return;
                        }
                        this.iEk.b(pVar);
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
            this.iEt.setVoiceModel(voiceModel);
            this.iEn.setVisibility(0);
            this.iEo.setVoiceModel(voiceModel);
            ckN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckM() {
        if (this.iEt.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.iEt.getVoiceModel().voiceId));
        }
        this.iEt.setVoiceModel(null);
        this.iEn.setVisibility(8);
        this.iEo.setVoiceModel(null);
        com.baidu.tbadk.editortools.l lX = this.drW.lX(6);
        if (lX != null && lX.dsh != null) {
            lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        ckN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckN() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.iEk.getText().toString());
        boolean z4 = (this.iEt == null || this.iEt.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.iEj != null) {
            this.iEj.setEnabled(z);
        }
        if (z) {
            if (this.iEj != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEj, (int) R.color.cp_link_tip_a);
            }
        } else if (this.iEj != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iEj, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iEk, (int) R.color.cp_cont_b);
        this.iEk.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.iEq, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        ckN();
        if (this.iCx != null) {
            this.iCx.onChangeSkinType();
        }
        if (this.drW != null) {
            this.drW.onChangeSkinType(i);
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
        if (this.iCx != null) {
            this.iCx.onDestroy();
        }
        if (this.giZ != null) {
            this.giZ.removeBlackScreen();
        }
    }
}
