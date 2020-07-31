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
    public bb koj;
    private View kpV = null;
    private TextView kpW = null;
    private TextView kpX = null;
    private PbFullScreenEditorInputView kpY;
    private SpanGroupManager kpZ;
    private WholeDisplayGridView kqa;
    private r kqb;
    private LinearLayout kqc;
    private PlayVoiceBntNew kqd;
    private LinearLayout kqe;
    private ImageView kqf;
    private LinearLayout kqg;
    private x kqh;
    private w kqi;
    private PbEditorData kqj;
    private PostWriteCallBackData kqk;
    private View kql;
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
        if (this.kqj != null && this.kqj.getEditorType() == 1 && this.kpY != null) {
            this.kpY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.koj = new bb();
        if (this.kpY != null) {
            this.koj.e(this.kpY);
        }
        if (this.kqk != null) {
            this.koj.f(this.kqk);
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
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.kpY);
            }
        });
        cNz();
        this.kpY = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.kpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ezO != null) {
                    PbFullScreenEditorActivity.this.ezO.bhl();
                    PbFullScreenEditorActivity.this.ezO.biU();
                }
            }
        });
        this.kpY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cNC();
                if (PbFullScreenEditorActivity.this.koj != null && PbFullScreenEditorActivity.this.koj.cQO() != null) {
                    if (!PbFullScreenEditorActivity.this.koj.cQO().dub()) {
                        PbFullScreenEditorActivity.this.koj.sZ(false);
                    }
                    PbFullScreenEditorActivity.this.koj.cQO().wj(false);
                }
            }
        });
        this.kpZ = new SpanGroupManager(this.kpY, getUniqueId());
        this.kqc = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kqd = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kqe = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.kqf = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cNB();
            }
        });
        this.kqa = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.kqb = new r(this.mContext);
        this.kqb.a(this);
        this.kqa.setAdapter((ListAdapter) this.kqb);
    }

    private void cNz() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] kqn = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.kqa) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.kqn);
                    int x = ((int) motionEvent.getX()) - this.kqn[0];
                    int y = ((int) motionEvent.getY()) - this.kqn[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.ezO.bhl();
                        PbFullScreenEditorActivity.this.ezO.biU();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kpY);
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
        this.kql = findViewById(R.id.scroll_view_child);
        this.kql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ezO != null) {
                    PbFullScreenEditorActivity.this.ezO.bhl();
                    PbFullScreenEditorActivity.this.ezO.biU();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.kpY);
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
        this.kpV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kpX = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpX, R.color.cp_cont_b);
        this.kpW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.kpV != null && this.kpW != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kpV.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kpV.getLayoutParams();
            layoutParams2.width = -2;
            this.kpV.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.kpV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.kpW.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.kpW.setLayoutParams(layoutParams3);
            this.kpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.kqj = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.kqj != null) {
                ss(this.kqj.getEditorType() == 1);
                final String disableVoiceMessage = this.kqj.getDisableVoiceMessage();
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
                this.mThreadData = this.kqj.getThreadData();
                if (this.kqh != null) {
                    this.kqh.setThreadData(this.mThreadData);
                }
                if (this.kqi != null) {
                    this.kqi.setThreadData(this.mThreadData);
                }
                String content = this.kqj.getContent();
                if (this.kqj.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.kqj.getSubPbReplyPrefix();
                    this.kpY.fb(this.mSubPbReplyPrefix, content);
                } else {
                    this.kpY.GD(content);
                }
                WriteImagesInfo writeImagesInfo = this.kqj.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.kqb.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kqb.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.kqj.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.kqc.setVisibility(0);
                    this.kqd.setVoiceModel(voiceModel);
                    this.kqi.setVoiceModel(voiceModel);
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
            this.kqk = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cNC();
    }

    private void ss(boolean z) {
        this.kqg = (LinearLayout) findViewById(R.id.editbar_container);
        this.kqh = new x();
        this.kqh.su(z);
        if (this.kqj != null && this.kqj.getThreadData() != null) {
            this.kqh.sv(this.kqj.getThreadData().isBJH);
        }
        this.kqi = (w) this.kqh.dT(this.mContext);
        this.ezO = this.kqi.biJ();
        this.kqi.d(this);
        this.kqh.b(this);
        this.kqg.addView(this.ezO, new LinearLayout.LayoutParams(-1, -2));
        this.ezO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kqi.e(this);
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
        if (this.kqj == null) {
            this.kqj = new PbEditorData();
        }
        if (this.kpZ != null) {
            pbFullScreenEditorInputView = this.kpZ.bcX();
        } else {
            pbFullScreenEditorInputView = this.kpY.toString();
        }
        this.kqj.setContent(pbFullScreenEditorInputView);
        this.kqj.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.kqj.setWriteImagesInfo(this.mWriteImagesInfo);
        this.kqj.setVoiceModel(this.kqi.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.kqj);
        if (z) {
            if (this.koj != null && this.koj.cQO() != null && this.koj.cQO().dua()) {
                showToast(this.koj.cQO().duc());
                this.koj.sZ(true);
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
                this.kqb.notifyDataSetChanged();
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
        if (i == 0 && this.kqi != null) {
            this.kqi.bjn();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.kqi != null) {
            this.kqi.onActivityResult(i, i2, intent);
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
                        this.kqb.p(this.mWriteImagesInfo.getChosedFiles());
                        this.kqb.notifyDataSetChanged();
                        cNC();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.kpY.aP(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cNA();
                    af(intent);
                    this.kqb.p(this.mWriteImagesInfo.getChosedFiles());
                    this.kqb.notifyDataSetChanged();
                    cNC();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.kpY.zD(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
                    com.baidu.tieba.face.b.b(this.kpY);
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
                                this.kqb.p(this.mWriteImagesInfo.getChosedFiles());
                                this.kqb.notifyDataSetChanged();
                                cNC();
                                return;
                            }
                            return;
                        }
                        this.kpY.b(qVar);
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
            this.kqi.setVoiceModel(voiceModel);
            this.kqc.setVisibility(0);
            this.kqd.setVoiceModel(voiceModel);
            cNC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNB() {
        if (this.kqi.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.yw(this.kqi.getVoiceModel().voiceId));
        }
        this.kqi.setVoiceModel(null);
        this.kqc.setVisibility(8);
        this.kqd.setVoiceModel(null);
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
        boolean z3 = !TextUtils.isEmpty(this.kpY.getText().toString());
        boolean z4 = (this.kqi == null || this.kqi.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.kpW != null) {
            this.kpW.setEnabled(z);
        }
        if (z) {
            if (this.kpW != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpW, R.color.cp_link_tip_a);
            }
        } else if (this.kpW != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpW, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpY, R.color.cp_cont_b);
        this.kpY.setHintTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ao.setImageResource(this.kqf, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.kpX, R.color.cp_cont_b);
        cNC();
        if (this.koj != null) {
            this.koj.onChangeSkinType();
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
        if (this.koj != null) {
            this.koj.onDestroy();
        }
        if (this.hFy != null) {
            this.hFy.removeBlackScreen();
        }
    }
}
