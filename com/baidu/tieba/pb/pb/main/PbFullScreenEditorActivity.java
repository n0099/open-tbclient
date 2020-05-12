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
    private EditorScrollView dRY;
    private EditorTools dWB;
    private VoiceManager gYv;
    public ap jtF;
    private PbEditorData jvA;
    private PostWriteCallBackData jvB;
    private View jvC;
    private View jvn = null;
    private TextView jvo = null;
    private TextView jvp = null;
    private PbFullScreenEditorInputView jvq;
    private WholeDisplayGridView jvr;
    private o jvs;
    private LinearLayout jvt;
    private PlayVoiceBntNew jvu;
    private LinearLayout jvv;
    private ImageView jvw;
    private LinearLayout jvx;
    private u jvy;
    private t jvz;
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
        this.gYv = new VoiceManager();
        this.gYv.onCreate(getPageContext());
        initView();
        initData();
        if (this.jvA != null && this.jvA.getEditorType() == 1 && this.jvq != null) {
            this.jvq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jtF = new ap();
        if (this.jvq != null) {
            this.jtF.d(this.jvq);
        }
        if (this.jvB != null) {
            this.jtF.f(this.jvB);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        blD();
        this.mTopLine = findViewById(R.id.view_line);
        this.dRY = (EditorScrollView) findViewById(R.id.scroll_view);
        this.dRY.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dWB != null) {
                    PbFullScreenEditorActivity.this.dWB.aVq();
                    PbFullScreenEditorActivity.this.dWB.aWX();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.jvq);
            }
        });
        cyo();
        this.jvq = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.jvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dWB != null) {
                    PbFullScreenEditorActivity.this.dWB.aVq();
                    PbFullScreenEditorActivity.this.dWB.aWX();
                }
            }
        });
        this.jvq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cyr();
                if (PbFullScreenEditorActivity.this.jtF != null && PbFullScreenEditorActivity.this.jtF.cBx() != null) {
                    if (!PbFullScreenEditorActivity.this.jtF.cBx().deT()) {
                        PbFullScreenEditorActivity.this.jtF.rG(false);
                    }
                    PbFullScreenEditorActivity.this.jtF.cBx().uO(false);
                }
            }
        });
        this.jvt = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jvu = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jvv = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.jvw = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cyq();
            }
        });
        this.jvr = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.jvs = new o(this.mContext);
        this.jvs.a(this);
        this.jvr.setAdapter((ListAdapter) this.jvs);
    }

    private void cyo() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] jvE = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.jvr) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.jvE);
                    int x = ((int) motionEvent.getX()) - this.jvE[0];
                    int y = ((int) motionEvent.getY()) - this.jvE[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dWB.aVq();
                        PbFullScreenEditorActivity.this.dWB.aWX();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jvq);
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
        this.jvC = findViewById(R.id.scroll_view_child);
        this.jvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dWB != null) {
                    PbFullScreenEditorActivity.this.dWB.aVq();
                    PbFullScreenEditorActivity.this.dWB.aWX();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jvq);
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

    private void blD() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jvn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jvp = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvp, (int) R.color.cp_cont_b);
        this.jvo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.jvn != null && this.jvo != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jvn.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jvn.getLayoutParams();
            layoutParams2.width = -2;
            this.jvn.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jvo.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.jvo.setLayoutParams(layoutParams3);
            this.jvo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.jvA = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.jvA != null) {
                rb(this.jvA.getEditorType() == 1);
                final String disableVoiceMessage = this.jvA.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dWB != null) {
                    com.baidu.tbadk.editortools.g mA = this.dWB.mA(6);
                    if (mA instanceof View) {
                        ((View) mA).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.jvA.getThreadData();
                if (this.jvy != null) {
                    this.jvy.setThreadData(this.mThreadData);
                }
                if (this.jvz != null) {
                    this.jvz.setThreadData(this.mThreadData);
                }
                String content = this.jvA.getContent();
                if (this.jvA.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.jvA.getSubPbReplyPrefix();
                    this.jvq.er(this.mSubPbReplyPrefix, content);
                } else {
                    this.jvq.DI(content);
                }
                WriteImagesInfo writeImagesInfo = this.jvA.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.jvs.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jvs.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.jvA.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.jvt.setVisibility(0);
                    this.jvu.setVoiceModel(voiceModel);
                    this.jvz.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l mD = this.dWB.mD(6);
                    if (mD != null && mD.dWM != null) {
                        mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dWB.bf((View) this.dWB.mA(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.jvB = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cyr();
    }

    private void rb(boolean z) {
        this.jvx = (LinearLayout) findViewById(R.id.editbar_container);
        this.jvy = new u();
        this.jvy.rd(z);
        if (this.jvA != null && this.jvA.getThreadData() != null) {
            this.jvy.re(this.jvA.getThreadData().isBJH);
        }
        this.jvz = (t) this.jvy.dw(this.mContext);
        this.dWB = this.jvz.aWN();
        this.jvz.b(this);
        this.jvy.b(this);
        this.jvx.addView(this.dWB, new LinearLayout.LayoutParams(-1, -2));
        this.dWB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jvz.c(this);
        this.dWB.display();
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
        if (this.jvA == null) {
            this.jvA = new PbEditorData();
        }
        this.jvA.setContent(this.jvq.getText().toString());
        this.jvA.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.jvA.setWriteImagesInfo(this.mWriteImagesInfo);
        this.jvA.setVoiceModel(this.jvz.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.jvA);
        if (z) {
            if (this.jtF != null && this.jtF.cBx() != null && this.jtF.cBx().deS()) {
                showToast(this.jtF.cBx().deU());
                this.jtF.rG(true);
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
                this.jvs.notifyDataSetChanged();
            }
            cyr();
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
        if (this.jvz != null) {
            this.jvz.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cyp();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ae(intent);
                        } else {
                            ag(intent);
                        }
                        this.jvs.p(this.mWriteImagesInfo.getChosedFiles());
                        this.jvs.notifyDataSetChanged();
                        cyr();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.jvq.aM(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cyp();
                    af(intent);
                    this.jvs.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jvs.notifyDataSetChanged();
                    cyr();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.jvq.wy(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cyp() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ae(Intent intent) {
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
            cyp();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void af(Intent intent) {
        b(intent, false);
    }

    private void ag(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            cyp();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYv;
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
                    com.baidu.tieba.face.b.b(this.jvq);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cyq();
                    return;
                case 14:
                    cyp();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aXj().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aRV() == EmotionGroupType.BIG_EMOTION || qVar.aRV() == EmotionGroupType.USER_COLLECT) {
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
                                cyp();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.jvs.p(this.mWriteImagesInfo.getChosedFiles());
                                this.jvs.notifyDataSetChanged();
                                cyr();
                                return;
                            }
                            return;
                        }
                        this.jvq.b(qVar);
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
            this.jvz.setVoiceModel(voiceModel);
            this.jvt.setVisibility(0);
            this.jvu.setVoiceModel(voiceModel);
            cyr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyq() {
        if (this.jvz.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.vs(this.jvz.getVoiceModel().voiceId));
        }
        this.jvz.setVoiceModel(null);
        this.jvt.setVisibility(8);
        this.jvu.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mD = this.dWB.mD(6);
        if (mD != null && mD.dWM != null) {
            mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cyr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyr() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.jvq.getText().toString());
        boolean z4 = (this.jvz == null || this.jvz.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.jvo != null) {
            this.jvo.setEnabled(z);
        }
        if (z) {
            if (this.jvo != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jvo, (int) R.color.cp_link_tip_a);
            }
        } else if (this.jvo != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jvo, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvq, (int) R.color.cp_cont_b);
        this.jvq.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.jvw, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jvp, (int) R.color.cp_cont_b);
        cyr();
        if (this.jtF != null) {
            this.jtF.onChangeSkinType();
        }
        if (this.dWB != null) {
            this.dWB.onChangeSkinType(i);
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
        if (this.jtF != null) {
            this.jtF.onDestroy();
        }
        if (this.gYv != null) {
            this.gYv.removeBlackScreen();
        }
    }
}
