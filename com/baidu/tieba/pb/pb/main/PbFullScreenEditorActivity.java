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
/* loaded from: classes21.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, r.a {
    private EditorScrollView eHZ;
    private EditorTools eMH;
    private VoiceManager hZU;
    public bb jSk;
    private View kNV = null;
    private TextView kNW = null;
    private TextView kNX = null;
    private PbFullScreenEditorInputView kNY;
    private SpanGroupManager kNZ;
    private WholeDisplayGridView kOa;
    private r kOb;
    private LinearLayout kOc;
    private PlayVoiceBntNew kOd;
    private LinearLayout kOe;
    private ImageView kOf;
    private LinearLayout kOg;
    private x kOh;
    private w kOi;
    private PbEditorData kOj;
    private PostWriteCallBackData kOk;
    private View kOl;
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
        this.hZU = new VoiceManager();
        this.hZU.onCreate(getPageContext());
        initView();
        initData();
        if (this.kOj != null && this.kOj.getEditorType() == 1 && this.kNY != null) {
            this.kNY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jSk = new bb();
        if (this.kNY != null) {
            this.jSk.e(this.kNY);
        }
        if (this.kOk != null) {
            this.jSk.h(this.kOk);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bvT();
        this.mTopLine = findViewById(R.id.view_line);
        this.eHZ = (EditorScrollView) findViewById(R.id.scroll_view);
        this.eHZ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.eMH != null) {
                    PbFullScreenEditorActivity.this.eMH.bqS();
                    PbFullScreenEditorActivity.this.eMH.bsI();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.kNY);
            }
        });
        dbS();
        this.kNY = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.kNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eMH != null) {
                    PbFullScreenEditorActivity.this.eMH.bqS();
                    PbFullScreenEditorActivity.this.eMH.bsI();
                }
            }
        });
        this.kNY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dbV();
                if (PbFullScreenEditorActivity.this.jSk != null && PbFullScreenEditorActivity.this.jSk.dfj() != null) {
                    if (!PbFullScreenEditorActivity.this.jSk.dfj().dJA()) {
                        PbFullScreenEditorActivity.this.jSk.tR(false);
                    }
                    PbFullScreenEditorActivity.this.jSk.dfj().xj(false);
                }
            }
        });
        this.kNZ = new SpanGroupManager(this.kNY, getUniqueId());
        this.kOc = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kOd = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kOe = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.kOf = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dbU();
            }
        });
        this.kOa = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.kOb = new r(this.mContext);
        this.kOb.a(this);
        this.kOa.setAdapter((ListAdapter) this.kOb);
    }

    private void dbS() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] kOn = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.kOa) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.kOn);
                    int x = ((int) motionEvent.getX()) - this.kOn[0];
                    int y = ((int) motionEvent.getY()) - this.kOn[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.eMH.bqS();
                        PbFullScreenEditorActivity.this.eMH.bsI();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kNY);
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
        this.kOl = findViewById(R.id.scroll_view_child);
        this.kOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eMH != null) {
                    PbFullScreenEditorActivity.this.eMH.bqS();
                    PbFullScreenEditorActivity.this.eMH.bsI();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kNY);
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

    private void bvT() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kNV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNX = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kNX, R.color.cp_cont_b);
        this.kNW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.kNV != null && this.kNW != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kNV.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kNV.getLayoutParams();
            layoutParams2.width = -2;
            this.kNV.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.kNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kNW.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.kNW.setLayoutParams(layoutParams3);
            this.kNW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.tk(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.kOj = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.kOj != null) {
                tj(this.kOj.getEditorType() == 1);
                final String disableVoiceMessage = this.kOj.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.eMH != null) {
                    com.baidu.tbadk.editortools.h qo = this.eMH.qo(6);
                    if (qo instanceof View) {
                        ((View) qo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.kOj.getThreadData();
                if (this.kOh != null) {
                    this.kOh.setThreadData(this.mThreadData);
                }
                if (this.kOi != null) {
                    this.kOi.setThreadData(this.mThreadData);
                }
                String content = this.kOj.getContent();
                if (this.kOj.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.kOj.getSubPbReplyPrefix();
                    this.kNY.fG(this.mSubPbReplyPrefix, content);
                } else {
                    this.kNY.JE(content);
                }
                WriteImagesInfo writeImagesInfo = this.kOj.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.kOb.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kOb.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.kOj.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.kOc.setVisibility(0);
                    this.kOd.setVoiceModel(voiceModel);
                    this.kOi.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qr = this.eMH.qr(6);
                    if (qr != null && qr.eMS != null) {
                        qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.eMH.br((View) this.eMH.qo(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.kOk = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dbV();
    }

    private void tj(boolean z) {
        this.kOg = (LinearLayout) findViewById(R.id.editbar_container);
        this.kOh = new x();
        this.kOh.tl(z);
        if (this.kOj != null && this.kOj.getThreadData() != null) {
            this.kOh.tm(this.kOj.getThreadData().isBJH);
        }
        this.kOi = (w) this.kOh.eb(this.mContext);
        this.eMH = this.kOi.bsv();
        this.kOi.d(this);
        this.kOh.b(this);
        this.kOg.addView(this.eMH, new LinearLayout.LayoutParams(-1, -2));
        this.eMH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kOi.e(this);
        this.eMH.display();
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
        tk(false);
    }

    public void tk(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.kOj == null) {
            this.kOj = new PbEditorData();
        }
        if (this.kNZ != null) {
            pbFullScreenEditorInputView = this.kNZ.bmq();
        } else {
            pbFullScreenEditorInputView = this.kNY.toString();
        }
        this.kOj.setContent(pbFullScreenEditorInputView);
        this.kOj.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.kOj.setWriteImagesInfo(this.mWriteImagesInfo);
        this.kOj.setVoiceModel(this.kOi.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.kOj);
        if (z) {
            if (this.jSk != null && this.jSk.dfj() != null && this.jSk.dfj().dJz()) {
                showToast(this.jSk.dfj().dJB());
                this.jSk.tR(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void EA(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lK().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.kOb.notifyDataSetChanged();
            }
            dbV();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void EB(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.kOi != null) {
            this.kOi.bte();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.kOi != null) {
            this.kOi.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        dbT();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            af(intent);
                        } else {
                            ah(intent);
                        }
                        this.kOb.p(this.mWriteImagesInfo.getChosedFiles());
                        this.kOb.notifyDataSetChanged();
                        dbV();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.kNY.aX(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dbT();
                    ag(intent);
                    this.kOb.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kOb.notifyDataSetChanged();
                    dbV();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.kNY.Cq(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dbT() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void af(Intent intent) {
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
            dbT();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ag(Intent intent) {
        a(intent, false);
    }

    private void ah(Intent intent) {
        a(intent, true);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            dbT();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hZU;
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
                    com.baidu.tieba.face.b.b(this.kNY);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dbU();
                    return;
                case 14:
                    dbT();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bsY().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bnJ() == EmotionGroupType.BIG_EMOTION || uVar.bnJ() == EmotionGroupType.USER_COLLECT) {
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
                                dbT();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.kOb.p(this.mWriteImagesInfo.getChosedFiles());
                                this.kOb.notifyDataSetChanged();
                                dbV();
                                return;
                            }
                            return;
                        }
                        this.kNY.b(uVar);
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
            this.kOi.setVoiceModel(voiceModel);
            this.kOc.setVisibility(0);
            this.kOd.setVoiceModel(voiceModel);
            dbV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbU() {
        if (this.kOi.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Bi(this.kOi.getVoiceModel().voiceId));
        }
        this.kOi.setVoiceModel(null);
        this.kOc.setVisibility(8);
        this.kOd.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qr = this.eMH.qr(6);
        if (qr != null && qr.eMS != null) {
            qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dbV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbV() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.kNY.getText().toString());
        boolean z4 = (this.kOi == null || this.kOi.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.kNW != null) {
            this.kNW.setEnabled(z);
        }
        if (z) {
            if (this.kNW != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kNW, R.color.cp_link_tip_a);
            }
        } else if (this.kNW != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kNW, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kNY, R.color.cp_cont_b);
        this.kNY.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ap.setImageResource(this.kOf, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kNX, R.color.cp_cont_b);
        dbV();
        if (this.jSk != null) {
            this.jSk.onChangeSkinType();
        }
        if (this.eMH != null) {
            this.eMH.onChangeSkinType(i);
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
        if (this.jSk != null) {
            this.jSk.onDestroy();
        }
        if (this.hZU != null) {
            this.hZU.removeBlackScreen();
        }
    }
}
