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
    private EditorScrollView evq;
    private EditorTools ezO;
    private VoiceManager hFy;
    public bb kol;
    private View kpX = null;
    private TextView kpY = null;
    private TextView kpZ = null;
    private PbFullScreenEditorInputView kqa;
    private SpanGroupManager kqb;
    private WholeDisplayGridView kqc;
    private r kqd;
    private LinearLayout kqe;
    private PlayVoiceBntNew kqf;
    private LinearLayout kqg;
    private ImageView kqh;
    private LinearLayout kqi;
    private x kqj;
    private w kqk;
    private PbEditorData kql;
    private PostWriteCallBackData kqm;
    private View kqn;
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
        this.hFy = new VoiceManager();
        this.hFy.onCreate(getPageContext());
        initView();
        initData();
        if (this.kql != null && this.kql.getEditorType() == 1 && this.kqa != null) {
            this.kqa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kol = new bb();
        if (this.kqa != null) {
            this.kol.e(this.kqa);
        }
        if (this.kqm != null) {
            this.kol.f(this.kqm);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bmb();
        this.mTopLine = findViewById(R.id.view_line);
        this.evq = (EditorScrollView) findViewById(R.id.scroll_view);
        this.evq.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.ezO != null) {
                    PbFullScreenEditorActivity.this.ezO.bhl();
                    PbFullScreenEditorActivity.this.ezO.biU();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.kqa);
            }
        });
        cNz();
        this.kqa = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.kqa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ezO != null) {
                    PbFullScreenEditorActivity.this.ezO.bhl();
                    PbFullScreenEditorActivity.this.ezO.biU();
                }
            }
        });
        this.kqa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cNC();
                if (PbFullScreenEditorActivity.this.kol != null && PbFullScreenEditorActivity.this.kol.cQO() != null) {
                    if (!PbFullScreenEditorActivity.this.kol.cQO().duc()) {
                        PbFullScreenEditorActivity.this.kol.sZ(false);
                    }
                    PbFullScreenEditorActivity.this.kol.cQO().wj(false);
                }
            }
        });
        this.kqb = new SpanGroupManager(this.kqa, getUniqueId());
        this.kqe = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kqf = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kqg = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.kqh = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cNB();
            }
        });
        this.kqc = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.kqd = new r(this.mContext);
        this.kqd.a(this);
        this.kqc.setAdapter((ListAdapter) this.kqd);
    }

    private void cNz() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] kqp = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.kqc) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.kqp);
                    int x = ((int) motionEvent.getX()) - this.kqp[0];
                    int y = ((int) motionEvent.getY()) - this.kqp[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.ezO.bhl();
                        PbFullScreenEditorActivity.this.ezO.biU();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kqa);
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
        this.kqn = findViewById(R.id.scroll_view_child);
        this.kqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ezO != null) {
                    PbFullScreenEditorActivity.this.ezO.bhl();
                    PbFullScreenEditorActivity.this.ezO.biU();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kqa);
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

    private void bmb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.kpX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kpZ = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpZ, R.color.cp_cont_b);
        this.kpY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.kpX != null && this.kpY != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kpX.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kpX.getLayoutParams();
            layoutParams2.width = -2;
            this.kpX.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.kpX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kpY.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.kpY.setLayoutParams(layoutParams3);
            this.kpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.st(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.kql = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.kql != null) {
                ss(this.kql.getEditorType() == 1);
                final String disableVoiceMessage = this.kql.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.ezO != null) {
                    com.baidu.tbadk.editortools.g nQ = this.ezO.nQ(6);
                    if (nQ instanceof View) {
                        ((View) nQ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.kql.getThreadData();
                if (this.kqj != null) {
                    this.kqj.setThreadData(this.mThreadData);
                }
                if (this.kqk != null) {
                    this.kqk.setThreadData(this.mThreadData);
                }
                String content = this.kql.getContent();
                if (this.kql.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.kql.getSubPbReplyPrefix();
                    this.kqa.fb(this.mSubPbReplyPrefix, content);
                } else {
                    this.kqa.GD(content);
                }
                WriteImagesInfo writeImagesInfo = this.kql.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.kqd.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kqd.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.kql.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.kqe.setVisibility(0);
                    this.kqf.setVoiceModel(voiceModel);
                    this.kqk.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l nT = this.ezO.nT(6);
                    if (nT != null && nT.ezZ != null) {
                        nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.ezO.bn((View) this.ezO.nQ(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.kqm = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cNC();
    }

    private void ss(boolean z) {
        this.kqi = (LinearLayout) findViewById(R.id.editbar_container);
        this.kqj = new x();
        this.kqj.su(z);
        if (this.kql != null && this.kql.getThreadData() != null) {
            this.kqj.sv(this.kql.getThreadData().isBJH);
        }
        this.kqk = (w) this.kqj.dT(this.mContext);
        this.ezO = this.kqk.biJ();
        this.kqk.d(this);
        this.kqj.b(this);
        this.kqi.addView(this.ezO, new LinearLayout.LayoutParams(-1, -2));
        this.ezO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kqk.e(this);
        this.ezO.display();
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
        st(false);
    }

    public void st(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.kql == null) {
            this.kql = new PbEditorData();
        }
        if (this.kqb != null) {
            pbFullScreenEditorInputView = this.kqb.bcX();
        } else {
            pbFullScreenEditorInputView = this.kqa.toString();
        }
        this.kql.setContent(pbFullScreenEditorInputView);
        this.kql.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.kql.setWriteImagesInfo(this.mWriteImagesInfo);
        this.kql.setVoiceModel(this.kqk.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.kql);
        if (z) {
            if (this.kol != null && this.kol.cQO() != null && this.kol.cQO().dub()) {
                showToast(this.kol.cQO().dud());
                this.kol.sZ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void BF(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.kqd.notifyDataSetChanged();
            }
            cNC();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void BG(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.kqk != null) {
            this.kqk.bjn();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.kqk != null) {
            this.kqk.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cNA();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ae(intent);
                        } else {
                            ag(intent);
                        }
                        this.kqd.p(this.mWriteImagesInfo.getChosedFiles());
                        this.kqd.notifyDataSetChanged();
                        cNC();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.kqa.aP(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cNA();
                    af(intent);
                    this.kqd.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kqd.notifyDataSetChanged();
                    cNC();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.kqa.zD(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cNA() {
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
                    com.baidu.tbadk.core.util.n.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            cNA();
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
            cNA();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
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
                    com.baidu.tieba.face.b.b(this.kqa);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cNB();
                    return;
                case 14:
                    cNA();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bjh().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.bef() == EmotionGroupType.BIG_EMOTION || qVar.bef() == EmotionGroupType.USER_COLLECT) {
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
                                cNA();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.kqd.p(this.mWriteImagesInfo.getChosedFiles());
                                this.kqd.notifyDataSetChanged();
                                cNC();
                                return;
                            }
                            return;
                        }
                        this.kqa.b(qVar);
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
            this.kqk.setVoiceModel(voiceModel);
            this.kqe.setVisibility(0);
            this.kqf.setVoiceModel(voiceModel);
            cNC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNB() {
        if (this.kqk.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.yw(this.kqk.getVoiceModel().voiceId));
        }
        this.kqk.setVoiceModel(null);
        this.kqe.setVisibility(8);
        this.kqf.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nT = this.ezO.nT(6);
        if (nT != null && nT.ezZ != null) {
            nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cNC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNC() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.kqa.getText().toString());
        boolean z4 = (this.kqk == null || this.kqk.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.kpY != null) {
            this.kpY.setEnabled(z);
        }
        if (z) {
            if (this.kpY != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpY, R.color.cp_link_tip_a);
            }
        } else if (this.kpY != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpY, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqa, R.color.cp_cont_b);
        this.kqa.setHintTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ao.setImageResource(this.kqh, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpZ, R.color.cp_cont_b);
        cNC();
        if (this.kol != null) {
            this.kol.onChangeSkinType();
        }
        if (this.ezO != null) {
            this.ezO.onChangeSkinType(i);
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
        if (this.kol != null) {
            this.kol.onDestroy();
        }
        if (this.hFy != null) {
            this.hFy.removeBlackScreen();
        }
    }
}
