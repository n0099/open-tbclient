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
    private EditorScrollView fhB;
    private EditorTools fml;
    private VoiceManager iIc;
    public bb kzS;
    private View lvX = null;
    private TextView lvY = null;
    private TextView lvZ = null;
    private PbFullScreenEditorInputView lwa;
    private SpanGroupManager lwb;
    private WholeDisplayGridView lwc;
    private r lwd;
    private LinearLayout lwe;
    private PlayVoiceBntNew lwf;
    private LinearLayout lwg;
    private ImageView lwh;
    private LinearLayout lwi;
    private x lwj;
    private w lwk;
    private PbEditorData lwl;
    private PostWriteCallBackData lwm;
    private View lwn;
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
        this.iIc = new VoiceManager();
        this.iIc.onCreate(getPageContext());
        initView();
        initData();
        if (this.lwl != null && this.lwl.getEditorType() == 1 && this.lwa != null) {
            this.lwa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kzS = new bb();
        if (this.lwa != null) {
            this.kzS.e(this.lwa);
        }
        if (this.lwm != null) {
            this.kzS.h(this.lwm);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bCo();
        this.mTopLine = findViewById(R.id.view_line);
        this.fhB = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fhB.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fml != null) {
                    PbFullScreenEditorActivity.this.fml.bxk();
                    PbFullScreenEditorActivity.this.fml.bza();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lwa);
            }
        });
        dkH();
        this.lwa = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fml != null) {
                    PbFullScreenEditorActivity.this.fml.bxk();
                    PbFullScreenEditorActivity.this.fml.bza();
                }
            }
        });
        this.lwa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dkK();
                if (PbFullScreenEditorActivity.this.kzS != null && PbFullScreenEditorActivity.this.kzS.dob() != null) {
                    if (!PbFullScreenEditorActivity.this.kzS.dob().dSV()) {
                        PbFullScreenEditorActivity.this.kzS.vb(false);
                    }
                    PbFullScreenEditorActivity.this.kzS.dob().yx(false);
                }
            }
        });
        this.lwb = this.lwa.getSpanGroupManager();
        this.lwe = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lwf = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lwg = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lwh = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dkJ();
            }
        });
        this.lwc = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lwd = new r(this.mContext);
        this.lwd.a(this);
        this.lwc.setAdapter((ListAdapter) this.lwd);
    }

    private void dkH() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lwp = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lwc) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lwp);
                    int x = ((int) motionEvent.getX()) - this.lwp[0];
                    int y = ((int) motionEvent.getY()) - this.lwp[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fml.bxk();
                        PbFullScreenEditorActivity.this.fml.bza();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lwa);
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
        this.lwn = findViewById(R.id.scroll_view_child);
        this.lwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fml != null) {
                    PbFullScreenEditorActivity.this.fml.bxk();
                    PbFullScreenEditorActivity.this.fml.bza();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lwa);
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

    private void bCo() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lvX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lvZ = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvZ, R.color.CAM_X0105);
        this.lvY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lvX != null && this.lvY != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvX.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lvX.getLayoutParams();
            layoutParams2.width = -2;
            this.lvX.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lvY.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lvY.setLayoutParams(layoutParams3);
            this.lvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.uu(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lwl = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lwl != null) {
                ut(this.lwl.getEditorType() == 1);
                final String disableVoiceMessage = this.lwl.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fml != null) {
                    com.baidu.tbadk.editortools.h rF = this.fml.rF(6);
                    if (rF instanceof View) {
                        ((View) rF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lwl.getThreadData();
                if (this.lwj != null) {
                    this.lwj.setThreadData(this.mThreadData);
                }
                if (this.lwk != null) {
                    this.lwk.setThreadData(this.mThreadData);
                }
                String content = this.lwl.getContent();
                if (this.lwl.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lwl.getSubPbReplyPrefix();
                    this.lwa.fS(this.mSubPbReplyPrefix, content);
                } else {
                    this.lwa.hq(content);
                }
                WriteImagesInfo writeImagesInfo = this.lwl.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lwd.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lwd.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lwl.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lwe.setVisibility(0);
                    this.lwf.setVoiceModel(voiceModel);
                    this.lwk.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m rI = this.fml.rI(6);
                    if (rI != null && rI.fmx != null) {
                        rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fml.bD((View) this.fml.rF(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lwm = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dkK();
    }

    private void ut(boolean z) {
        this.lwi = (LinearLayout) findViewById(R.id.editbar_container);
        this.lwj = new x();
        this.lwj.uv(z);
        if (this.lwl != null && this.lwl.getThreadData() != null) {
            this.lwj.uw(this.lwl.getThreadData().isBJH);
        }
        this.lwk = (w) this.lwj.ei(this.mContext);
        this.fml = this.lwk.byN();
        this.lwk.d(this);
        this.lwj.b(this);
        this.lwi.addView(this.fml, new LinearLayout.LayoutParams(-1, -2));
        this.fml.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lwk.e(this);
        this.fml.display();
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
        uu(false);
    }

    public void uu(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lwl == null) {
            this.lwl = new PbEditorData();
        }
        if (this.lwb != null) {
            pbFullScreenEditorInputView = this.lwb.bsJ();
        } else {
            pbFullScreenEditorInputView = this.lwa.toString();
        }
        this.lwl.setContent(pbFullScreenEditorInputView);
        this.lwl.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lwl.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lwl.setVoiceModel(this.lwk.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lwl);
        if (z) {
            if (this.kzS != null && this.kzS.dob() != null && this.kzS.dob().dSU()) {
                showToast(this.kzS.dob().dSW());
                this.kzS.vb(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Gk(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lwd.notifyDataSetChanged();
            }
            dkK();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Gl(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lwk != null) {
            this.lwk.bzw();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lwk != null) {
            this.lwk.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        dkI();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ad(intent);
                        } else {
                            af(intent);
                        }
                        this.lwd.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lwd.notifyDataSetChanged();
                        dkK();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lwa.bb(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dkI();
                    ae(intent);
                    this.lwd.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lwd.notifyDataSetChanged();
                    dkK();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lwa.Di(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dkI() {
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
            dkI();
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
            dkI();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iIc;
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
                    com.baidu.tieba.face.b.b(this.lwa);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dkJ();
                    return;
                case 14:
                    dkI();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bzq().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.buc() == EmotionGroupType.BIG_EMOTION || uVar.buc() == EmotionGroupType.USER_COLLECT) {
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
                                dkI();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lwd.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lwd.notifyDataSetChanged();
                                dkK();
                                return;
                            }
                            return;
                        }
                        this.lwa.b(uVar);
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
            this.lwk.setVoiceModel(voiceModel);
            this.lwe.setVisibility(0);
            this.lwf.setVoiceModel(voiceModel);
            dkK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkJ() {
        if (this.lwk.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Ca(this.lwk.getVoiceModel().voiceId));
        }
        this.lwk.setVoiceModel(null);
        this.lwe.setVisibility(8);
        this.lwf.setVoiceModel(null);
        com.baidu.tbadk.editortools.m rI = this.fml.rI(6);
        if (rI != null && rI.fmx != null) {
            rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dkK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkK() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lwa.getText().toString());
        boolean z4 = (this.lwk == null || this.lwk.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lvY != null) {
            this.lvY.setEnabled(z);
        }
        if (z) {
            if (this.lvY != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvY, R.color.CAM_X0302);
            }
        } else if (this.lvY != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvY, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwa, R.color.CAM_X0105);
        this.lwa.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lwh, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lvZ, R.color.CAM_X0105);
        dkK();
        if (this.kzS != null) {
            this.kzS.onChangeSkinType();
        }
        if (this.fml != null) {
            this.fml.onChangeSkinType(i);
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
        if (this.kzS != null) {
            this.kzS.onDestroy();
        }
        if (this.iIc != null) {
            this.iIc.removeBlackScreen();
        }
    }
}
