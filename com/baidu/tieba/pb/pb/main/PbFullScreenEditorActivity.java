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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
/* loaded from: classes9.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private EditorScrollView egr;
    private EditorTools ekK;
    private VoiceManager hnh;
    public ax jKD;
    private PostWriteCallBackData jMA;
    private View jMB;
    private View jMm = null;
    private TextView jMn = null;
    private TextView jMo = null;
    private PbFullScreenEditorInputView jMp;
    private WholeDisplayGridView jMq;
    private p jMr;
    private LinearLayout jMs;
    private PlayVoiceBntNew jMt;
    private LinearLayout jMu;
    private ImageView jMv;
    private LinearLayout jMw;
    private v jMx;
    private u jMy;
    private PbEditorData jMz;
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
        this.hnh = new VoiceManager();
        this.hnh.onCreate(getPageContext());
        initView();
        initData();
        if (this.jMz != null && this.jMz.getEditorType() == 1 && this.jMp != null) {
            this.jMp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jKD = new ax();
        if (this.jMp != null) {
            this.jKD.d(this.jMp);
        }
        if (this.jMA != null) {
            this.jKD.f(this.jMA);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        brb();
        this.mTopLine = findViewById(R.id.view_line);
        this.egr = (EditorScrollView) findViewById(R.id.scroll_view);
        this.egr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbz();
                    PbFullScreenEditorActivity.this.ekK.bdg();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.jMp);
            }
        });
        cFi();
        this.jMp = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.jMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbz();
                    PbFullScreenEditorActivity.this.ekK.bdg();
                }
            }
        });
        this.jMp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cFl();
                if (PbFullScreenEditorActivity.this.jKD != null && PbFullScreenEditorActivity.this.jKD.cIt() != null) {
                    if (!PbFullScreenEditorActivity.this.jKD.cIt().dmj()) {
                        PbFullScreenEditorActivity.this.jKD.sf(false);
                    }
                    PbFullScreenEditorActivity.this.jKD.cIt().vm(false);
                }
            }
        });
        this.jMs = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jMt = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jMu = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.jMv = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cFk();
            }
        });
        this.jMq = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.jMr = new p(this.mContext);
        this.jMr.a(this);
        this.jMq.setAdapter((ListAdapter) this.jMr);
    }

    private void cFi() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] jMD = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.jMq) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.jMD);
                    int x = ((int) motionEvent.getX()) - this.jMD[0];
                    int y = ((int) motionEvent.getY()) - this.jMD[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.ekK.bbz();
                        PbFullScreenEditorActivity.this.ekK.bdg();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jMp);
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
        this.jMB = findViewById(R.id.scroll_view_child);
        this.jMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbz();
                    PbFullScreenEditorActivity.this.ekK.bdg();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jMp);
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

    private void brb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jMm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jMo = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jMo, (int) R.color.cp_cont_b);
        this.jMn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.jMm != null && this.jMn != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jMm.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jMm.getLayoutParams();
            layoutParams2.width = -2;
            this.jMm.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jMn.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.jMn.setLayoutParams(layoutParams3);
            this.jMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.rB(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.jMz = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.jMz != null) {
                rA(this.jMz.getEditorType() == 1);
                final String disableVoiceMessage = this.jMz.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.ekK != null) {
                    com.baidu.tbadk.editortools.g nc = this.ekK.nc(6);
                    if (nc instanceof View) {
                        ((View) nc).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.jMz.getThreadData();
                if (this.jMx != null) {
                    this.jMx.setThreadData(this.mThreadData);
                }
                if (this.jMy != null) {
                    this.jMy.setThreadData(this.mThreadData);
                }
                String content = this.jMz.getContent();
                if (this.jMz.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.jMz.getSubPbReplyPrefix();
                    this.jMp.eS(this.mSubPbReplyPrefix, content);
                } else {
                    this.jMp.Fr(content);
                }
                WriteImagesInfo writeImagesInfo = this.jMz.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.jMr.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jMr.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.jMz.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.jMs.setVisibility(0);
                    this.jMt.setVoiceModel(voiceModel);
                    this.jMy.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l nf = this.ekK.nf(6);
                    if (nf != null && nf.ekV != null) {
                        nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.ekK.bg((View) this.ekK.nc(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.jMA = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cFl();
    }

    private void rA(boolean z) {
        this.jMw = (LinearLayout) findViewById(R.id.editbar_container);
        this.jMx = new v();
        this.jMx.rC(z);
        if (this.jMz != null && this.jMz.getThreadData() != null) {
            this.jMx.rD(this.jMz.getThreadData().isBJH);
        }
        this.jMy = (u) this.jMx.dN(this.mContext);
        this.ekK = this.jMy.bcW();
        this.jMy.b(this);
        this.jMx.b(this);
        this.jMw.addView(this.ekK, new LinearLayout.LayoutParams(-1, -2));
        this.ekK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jMy.c(this);
        this.ekK.display();
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
        rB(false);
    }

    public void rB(boolean z) {
        Intent intent = new Intent();
        if (this.jMz == null) {
            this.jMz = new PbEditorData();
        }
        this.jMz.setContent(this.jMp.getText().toString());
        this.jMz.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.jMz.setWriteImagesInfo(this.mWriteImagesInfo);
        this.jMz.setVoiceModel(this.jMy.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.jMz);
        if (z) {
            if (this.jKD != null && this.jKD.cIt() != null && this.jKD.cIt().dmi()) {
                showToast(this.jKD.cIt().dmk());
                this.jKD.sf(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void Ac(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.jR().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.jMr.notifyDataSetChanged();
            }
            cFl();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void Ad(int i) {
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
        if (this.jMy != null) {
            this.jMy.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cFj();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ab(intent);
                        } else {
                            ad(intent);
                        }
                        this.jMr.p(this.mWriteImagesInfo.getChosedFiles());
                        this.jMr.notifyDataSetChanged();
                        cFl();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.jMp.aN(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cFj();
                    ac(intent);
                    this.jMr.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jMr.notifyDataSetChanged();
                    cFl();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.jMp.ye(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cFj() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ab(Intent intent) {
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
            cFj();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ac(Intent intent) {
        b(intent, false);
    }

    private void ad(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            cFj();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hnh;
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
                    com.baidu.tieba.face.b.b(this.jMp);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cFk();
                    return;
                case 14:
                    cFj();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bds().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aYc() == EmotionGroupType.BIG_EMOTION || qVar.aYc() == EmotionGroupType.USER_COLLECT) {
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
                                imageFileInfo.setFilePath(qVar.getName());
                                imageFileInfo.width = qVar.getWidth();
                                imageFileInfo.height = qVar.getHeight();
                                cFj();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.jMr.p(this.mWriteImagesInfo.getChosedFiles());
                                this.jMr.notifyDataSetChanged();
                                cFl();
                                return;
                            }
                            return;
                        }
                        this.jMp.b(qVar);
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
            this.jMy.setVoiceModel(voiceModel);
            this.jMs.setVisibility(0);
            this.jMt.setVoiceModel(voiceModel);
            cFl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFk() {
        if (this.jMy.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.wY(this.jMy.getVoiceModel().voiceId));
        }
        this.jMy.setVoiceModel(null);
        this.jMs.setVisibility(8);
        this.jMt.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nf = this.ekK.nf(6);
        if (nf != null && nf.ekV != null) {
            nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cFl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.jMp.getText().toString());
        boolean z4 = (this.jMy == null || this.jMy.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.jMn != null) {
            this.jMn.setEnabled(z);
        }
        if (z) {
            if (this.jMn != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jMn, (int) R.color.cp_link_tip_a);
            }
        } else if (this.jMn != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jMn, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jMp, (int) R.color.cp_cont_b);
        this.jMp.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.jMv, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jMo, (int) R.color.cp_cont_b);
        cFl();
        if (this.jKD != null) {
            this.jKD.onChangeSkinType();
        }
        if (this.ekK != null) {
            this.ekK.onChangeSkinType(i);
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
        if (this.jKD != null) {
            this.jKD.onDestroy();
        }
        if (this.hnh != null) {
            this.hnh.removeBlackScreen();
        }
    }
}
