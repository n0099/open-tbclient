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
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, o.a {
    private EditorScrollView dRT;
    private EditorTools dWw;
    private VoiceManager gYp;
    public ap jtB;
    private View jvj = null;
    private TextView jvk = null;
    private TextView jvl = null;
    private PbFullScreenEditorInputView jvm;
    private WholeDisplayGridView jvn;
    private o jvo;
    private LinearLayout jvp;
    private PlayVoiceBntNew jvq;
    private LinearLayout jvr;
    private ImageView jvs;
    private LinearLayout jvt;
    private u jvu;
    private t jvv;
    private PbEditorData jvw;
    private PostWriteCallBackData jvx;
    private View jvy;
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
        this.gYp = new VoiceManager();
        this.gYp.onCreate(getPageContext());
        initView();
        initData();
        if (this.jvw != null && this.jvw.getEditorType() == 1 && this.jvm != null) {
            this.jvm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jtB = new ap();
        if (this.jvm != null) {
            this.jtB.d(this.jvm);
        }
        if (this.jvx != null) {
            this.jtB.f(this.jvx);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        blF();
        this.mTopLine = findViewById(R.id.view_line);
        this.dRT = (EditorScrollView) findViewById(R.id.scroll_view);
        this.dRT.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dWw != null) {
                    PbFullScreenEditorActivity.this.dWw.aVs();
                    PbFullScreenEditorActivity.this.dWw.aWZ();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.jvm);
            }
        });
        cyq();
        this.jvm = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.jvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dWw != null) {
                    PbFullScreenEditorActivity.this.dWw.aVs();
                    PbFullScreenEditorActivity.this.dWw.aWZ();
                }
            }
        });
        this.jvm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cyt();
                if (PbFullScreenEditorActivity.this.jtB != null && PbFullScreenEditorActivity.this.jtB.cBz() != null) {
                    if (!PbFullScreenEditorActivity.this.jtB.cBz().deV()) {
                        PbFullScreenEditorActivity.this.jtB.rG(false);
                    }
                    PbFullScreenEditorActivity.this.jtB.cBz().uO(false);
                }
            }
        });
        this.jvp = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jvq = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jvr = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.jvs = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jvr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cys();
            }
        });
        this.jvn = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.jvo = new o(this.mContext);
        this.jvo.a(this);
        this.jvn.setAdapter((ListAdapter) this.jvo);
    }

    private void cyq() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] jvA = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.jvn) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.jvA);
                    int x = ((int) motionEvent.getX()) - this.jvA[0];
                    int y = ((int) motionEvent.getY()) - this.jvA[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dWw.aVs();
                        PbFullScreenEditorActivity.this.dWw.aWZ();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jvm);
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
        this.jvy = findViewById(R.id.scroll_view_child);
        this.jvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dWw != null) {
                    PbFullScreenEditorActivity.this.dWw.aVs();
                    PbFullScreenEditorActivity.this.dWw.aWZ();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jvm);
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

    private void blF() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jvj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jvl = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvl, (int) R.color.cp_cont_b);
        this.jvk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.jvj != null && this.jvk != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jvj.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jvj.getLayoutParams();
            layoutParams2.width = -2;
            this.jvj.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jvk.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.jvk.setLayoutParams(layoutParams3);
            this.jvk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.rc(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.jvw = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.jvw != null) {
                rb(this.jvw.getEditorType() == 1);
                final String disableVoiceMessage = this.jvw.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dWw != null) {
                    com.baidu.tbadk.editortools.g mA = this.dWw.mA(6);
                    if (mA instanceof View) {
                        ((View) mA).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.jvw.getThreadData();
                if (this.jvu != null) {
                    this.jvu.setThreadData(this.mThreadData);
                }
                if (this.jvv != null) {
                    this.jvv.setThreadData(this.mThreadData);
                }
                String content = this.jvw.getContent();
                if (this.jvw.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.jvw.getSubPbReplyPrefix();
                    this.jvm.er(this.mSubPbReplyPrefix, content);
                } else {
                    this.jvm.DF(content);
                }
                WriteImagesInfo writeImagesInfo = this.jvw.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.jvo.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jvo.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.jvw.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.jvp.setVisibility(0);
                    this.jvq.setVoiceModel(voiceModel);
                    this.jvv.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l mD = this.dWw.mD(6);
                    if (mD != null && mD.dWH != null) {
                        mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dWw.bf((View) this.dWw.mA(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.jvx = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cyt();
    }

    private void rb(boolean z) {
        this.jvt = (LinearLayout) findViewById(R.id.editbar_container);
        this.jvu = new u();
        this.jvu.rd(z);
        if (this.jvw != null && this.jvw.getThreadData() != null) {
            this.jvu.re(this.jvw.getThreadData().isBJH);
        }
        this.jvv = (t) this.jvu.dI(this.mContext);
        this.dWw = this.jvv.aWP();
        this.jvv.b(this);
        this.jvu.b(this);
        this.jvt.addView(this.dWw, new LinearLayout.LayoutParams(-1, -2));
        this.dWw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jvv.c(this);
        this.dWw.display();
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
        rc(false);
    }

    public void rc(boolean z) {
        Intent intent = new Intent();
        if (this.jvw == null) {
            this.jvw = new PbEditorData();
        }
        this.jvw.setContent(this.jvm.getText().toString());
        this.jvw.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.jvw.setWriteImagesInfo(this.mWriteImagesInfo);
        this.jvw.setVoiceModel(this.jvv.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.jvw);
        if (z) {
            if (this.jtB != null && this.jtB.cBz() != null && this.jtB.cBz().deU()) {
                showToast(this.jtB.cBz().deW());
                this.jtB.rG(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void zs(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.jP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.jvo.notifyDataSetChanged();
            }
            cyt();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void zt(int i) {
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
        if (this.jvv != null) {
            this.jvv.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cyr();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ar(intent);
                        } else {
                            at(intent);
                        }
                        this.jvo.p(this.mWriteImagesInfo.getChosedFiles());
                        this.jvo.notifyDataSetChanged();
                        cyt();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.jvm.aM(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cyr();
                    as(intent);
                    this.jvo.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jvo.notifyDataSetChanged();
                    cyt();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.jvm.wv(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cyr() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ar(Intent intent) {
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
            cyr();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void as(Intent intent) {
        b(intent, false);
    }

    private void at(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            cyr();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYp;
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
                    com.baidu.tieba.face.b.b(this.jvm);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cys();
                    return;
                case 14:
                    cyr();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aXl().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aRY() == EmotionGroupType.BIG_EMOTION || qVar.aRY() == EmotionGroupType.USER_COLLECT) {
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
                                cyr();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.jvo.p(this.mWriteImagesInfo.getChosedFiles());
                                this.jvo.notifyDataSetChanged();
                                cyt();
                                return;
                            }
                            return;
                        }
                        this.jvm.b(qVar);
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
            this.jvv.setVoiceModel(voiceModel);
            this.jvp.setVisibility(0);
            this.jvq.setVoiceModel(voiceModel);
            cyt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cys() {
        if (this.jvv.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.vp(this.jvv.getVoiceModel().voiceId));
        }
        this.jvv.setVoiceModel(null);
        this.jvp.setVisibility(8);
        this.jvq.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mD = this.dWw.mD(6);
        if (mD != null && mD.dWH != null) {
            mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cyt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyt() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.jvm.getText().toString());
        boolean z4 = (this.jvv == null || this.jvv.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.jvk != null) {
            this.jvk.setEnabled(z);
        }
        if (z) {
            if (this.jvk != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jvk, (int) R.color.cp_link_tip_a);
            }
        } else if (this.jvk != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jvk, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvm, (int) R.color.cp_cont_b);
        this.jvm.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.jvs, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvl, (int) R.color.cp_cont_b);
        cyt();
        if (this.jtB != null) {
            this.jtB.onChangeSkinType();
        }
        if (this.dWw != null) {
            this.dWw.onChangeSkinType(i);
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
        if (this.jtB != null) {
            this.jtB.onDestroy();
        }
        if (this.gYp != null) {
            this.gYp.removeBlackScreen();
        }
    }
}
