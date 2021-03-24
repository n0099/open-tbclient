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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.b.e.p.l;
import d.b.h0.w.m;
import d.b.h0.w.n;
import d.b.i0.c2.k.e.p;
import d.b.i0.c2.k.e.s0;
import d.b.i0.c2.k.e.t;
import d.b.i0.c2.k.e.u;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements p.c, VoiceManager.j, d.b.h0.w.b {
    public static final int REPLY_MAX_SIZE = 140;
    public s0 mContentProcessController;
    public Context mContext;
    public PbFullScreenEditorInputView mEditContent;
    public SpanGroupManager mEditContentSpanGroupManager;
    public u mEditorBuilder;
    public LinearLayout mEditorContainer;
    public EditorTools mEditorTools;
    public t mFullScreenEditor;
    public GestureDetector mGestureDetector;
    public p mImgsAdapter;
    public WholeDisplayGridView mImgsGridView;
    public ImageView mIvDeleteVoice;
    public LinearLayout mLayoutDelVoice;
    public LinearLayout mLayoutVoicePlay;
    public NavigationBar mNavigationBar;
    public PbEditorData mPbEditorData;
    public PostWriteCallBackData mPostWriteCallBackData;
    public EditorScrollView mScrollView;
    public View mScrollViewChild;
    public String mSubPbReplyPrefix;
    public PbEditorData.ThreadData mThreadData;
    public View mTopLine;
    public VoiceManager mVoiceManager;
    public PlayVoiceBntNew mVoicePlayButton;
    public WriteImagesInfo mWriteImagesInfo;
    public View mBackBtn = null;
    public TextView mPostBtn = null;
    public TextView mTvName = null;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (PbFullScreenEditorActivity.this.mEditorTools != null) {
                PbFullScreenEditorActivity.this.mEditorTools.q();
                PbFullScreenEditorActivity.this.mEditorTools.y();
            }
            l.w(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.mEditContent);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbFullScreenEditorActivity.this.mEditorTools != null) {
                PbFullScreenEditorActivity.this.mEditorTools.q();
                PbFullScreenEditorActivity.this.mEditorTools.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PbFullScreenEditorActivity.this.checkPostBtnEnabled();
            s0 s0Var = PbFullScreenEditorActivity.this.mContentProcessController;
            if (s0Var == null || s0Var.e() == null) {
                return;
            }
            if (!PbFullScreenEditorActivity.this.mContentProcessController.e().e()) {
                PbFullScreenEditorActivity.this.mContentProcessController.a(false);
            }
            PbFullScreenEditorActivity.this.mContentProcessController.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFullScreenEditorActivity.this.deleteVoice();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public int[] f19682e = new int[2];

        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            l.w(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            WholeDisplayGridView wholeDisplayGridView;
            if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.mImgsGridView) != null) {
                wholeDisplayGridView.getLocationInWindow(this.f19682e);
                int x = ((int) motionEvent.getX()) - this.f19682e[0];
                int y = ((int) motionEvent.getY()) - this.f19682e[1];
                if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                    PbFullScreenEditorActivity.this.mEditorTools.q();
                    PbFullScreenEditorActivity.this.mEditorTools.y();
                    l.J(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.mEditContent);
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbFullScreenEditorActivity.this.mEditorTools != null) {
                PbFullScreenEditorActivity.this.mEditorTools.q();
                PbFullScreenEditorActivity.this.mEditorTools.y();
            }
            l.J(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.mEditContent);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFullScreenEditorActivity.this.onBackPressed();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFullScreenEditorActivity.this.onBack(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19687e;

        public i(String str) {
            this.f19687e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFullScreenEditorActivity.this.showToast(this.f19687e);
        }
    }

    private void addVoice(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || voiceData$VoiceModel.duration <= 0) {
            return;
        }
        this.mFullScreenEditor.r(voiceData$VoiceModel);
        this.mLayoutVoicePlay.setVisibility(0);
        this.mVoicePlayButton.setVoiceModel(voiceData$VoiceModel);
        checkPostBtnEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPostBtnEnabled() {
        WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
        boolean z = false;
        boolean z2 = writeImagesInfo != null && writeImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.mEditContent.getText().toString());
        t tVar = this.mFullScreenEditor;
        z = (z2 || z3 || (tVar != null && tVar.h() != null)) ? true : true;
        TextView textView = this.mPostBtn;
        if (textView != null) {
            textView.setEnabled(z);
        }
        if (z) {
            TextView textView2 = this.mPostBtn;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302);
                return;
            }
            return;
        }
        TextView textView3 = this.mPostBtn;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVoice() {
        n nVar;
        if (this.mFullScreenEditor.h() != null) {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(this.mFullScreenEditor.h().voiceId));
        }
        this.mFullScreenEditor.r(null);
        this.mLayoutVoicePlay.setVisibility(8);
        this.mVoicePlayButton.setVoiceModel(null);
        m n = this.mEditorTools.n(6);
        if (n != null && (nVar = n.k) != null) {
            nVar.onAction(new d.b.h0.w.a(52, 0, null));
        }
        checkPostBtnEnabled();
    }

    private void ensureWriteImagesInfo() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void getResData(Intent intent, boolean z) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        ensureWriteImagesInfo();
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
    }

    private void handleAlbumResultData(Intent intent) {
        getResData(intent, true);
    }

    private void handleCameraResultData(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.mContext, l.k(this.mContext)), l.e(this.mContext, l.i(this.mContext)));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception unused) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        ensureWriteImagesInfo();
        this.mWriteImagesInfo.addChooseFile(imageFileInfo);
        this.mWriteImagesInfo.updateQuality();
    }

    private void handleMotuResultData(Intent intent) {
        getResData(intent, false);
    }

    private void initData() {
        n nVar;
        EditorTools editorTools;
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            this.mPbEditorData = pbEditorData;
            if (pbEditorData == null) {
                return;
            }
            initEditTools(pbEditorData.getEditorType() == 1);
            String disableVoiceMessage = this.mPbEditorData.getDisableVoiceMessage();
            if (!TextUtils.isEmpty(disableVoiceMessage) && (editorTools = this.mEditorTools) != null) {
                d.b.h0.w.h m = editorTools.m(6);
                if (m instanceof View) {
                    ((View) m).setOnClickListener(new i(disableVoiceMessage));
                }
            }
            PbEditorData.ThreadData threadData = this.mPbEditorData.getThreadData();
            this.mThreadData = threadData;
            u uVar = this.mEditorBuilder;
            if (uVar != null) {
                uVar.l(threadData);
            }
            t tVar = this.mFullScreenEditor;
            if (tVar != null) {
                tVar.q(this.mThreadData);
            }
            String content = this.mPbEditorData.getContent();
            if (this.mPbEditorData.getEditorType() == 1) {
                String subPbReplyPrefix = this.mPbEditorData.getSubPbReplyPrefix();
                this.mSubPbReplyPrefix = subPbReplyPrefix;
                this.mEditContent.k(subPbReplyPrefix, content);
            } else {
                this.mEditContent.j(content);
            }
            WriteImagesInfo writeImagesInfo = this.mPbEditorData.getWriteImagesInfo();
            if (writeImagesInfo != null) {
                this.mWriteImagesInfo = writeImagesInfo;
                this.mImgsAdapter.c(writeImagesInfo.getChosedFiles());
                this.mImgsAdapter.notifyDataSetChanged();
            }
            VoiceData$VoiceModel voiceModel = this.mPbEditorData.getVoiceModel();
            if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                this.mLayoutVoicePlay.setVisibility(0);
                this.mVoicePlayButton.setVoiceModel(voiceModel);
                this.mFullScreenEditor.r(voiceModel);
                m n = this.mEditorTools.n(6);
                if (n != null && (nVar = n.k) != null) {
                    nVar.onAction(new d.b.h0.w.a(52, 0, voiceModel));
                }
                EditorTools editorTools2 = this.mEditorTools;
                editorTools2.x((View) editorTools2.m(6));
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.mPostWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        checkPostBtnEnabled();
    }

    private void initEditTools(boolean z) {
        this.mEditorContainer = (LinearLayout) findViewById(R.id.editbar_container);
        u uVar = new u();
        this.mEditorBuilder = uVar;
        uVar.j(z);
        PbEditorData pbEditorData = this.mPbEditorData;
        if (pbEditorData != null && pbEditorData.getThreadData() != null) {
            this.mEditorBuilder.i(this.mPbEditorData.getThreadData().isBJH);
        }
        t tVar = (t) this.mEditorBuilder.a(this.mContext);
        this.mFullScreenEditor = tVar;
        this.mEditorTools = tVar.a();
        this.mFullScreenEditor.p(this);
        this.mEditorBuilder.k(this);
        this.mEditorContainer.addView(this.mEditorTools, new LinearLayout.LayoutParams(-1, -2));
        this.mEditorTools.w(TbadkCoreApplication.getInst().getSkinType());
        this.mFullScreenEditor.j(this);
        this.mEditorTools.j();
    }

    private void initGestureControl() {
        this.mGestureDetector = new GestureDetector(new e());
        View findViewById = findViewById(R.id.scroll_view_child);
        this.mScrollViewChild = findViewById;
        findViewById.setOnClickListener(new f());
    }

    private void initNavigationBar() {
        View view;
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.showBottomLine();
        this.mBackBtn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        this.mTvName = centerTextTitle;
        SkinManager.setViewTextColor(centerTextTitle, R.color.CAM_X0105);
        this.mPostBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView == null || !(backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) || (view = this.mBackBtn) == null || this.mPostBtn == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = l.g(getActivity(), R.dimen.ds17);
        backImageView.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBackBtn.getLayoutParams();
        layoutParams2.width = -2;
        this.mBackBtn.setLayoutParams(layoutParams2);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mBackBtn.setOnClickListener(new g());
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPostBtn.getLayoutParams();
        layoutParams3.width = -2;
        layoutParams3.rightMargin = l.g(getActivity(), R.dimen.ds14);
        this.mPostBtn.setLayoutParams(layoutParams3);
        this.mPostBtn.setOnClickListener(new h());
    }

    private void initView() {
        initNavigationBar();
        this.mTopLine = findViewById(R.id.view_line);
        EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.scroll_view);
        this.mScrollView = editorScrollView;
        editorScrollView.setListener(new a());
        initGestureControl();
        PbFullScreenEditorInputView pbFullScreenEditorInputView = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.mEditContent = pbFullScreenEditorInputView;
        pbFullScreenEditorInputView.setOnClickListener(new b());
        this.mEditContent.addTextChangedListener(new c());
        this.mEditContentSpanGroupManager = this.mEditContent.getSpanGroupManager();
        this.mLayoutVoicePlay = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.mVoicePlayButton = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.mLayoutDelVoice = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.mIvDeleteVoice = (ImageView) findViewById(R.id.iv_delete_voice);
        this.mLayoutDelVoice.setOnClickListener(new d());
        this.mImgsGridView = (WholeDisplayGridView) findViewById(R.id.gridview);
        p pVar = new p(this.mContext);
        this.mImgsAdapter = pVar;
        pVar.b(this);
        this.mImgsGridView.setAdapter((ListAdapter) this.mImgsAdapter);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f51523a;
        if (i2 == 3) {
            d.b.i0.k0.b.a(this.mEditContent);
        } else if (i2 == 14) {
            ensureWriteImagesInfo();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "pb");
            PbEditorData.ThreadData threadData = this.mThreadData;
            if (threadData != null && !TextUtils.isEmpty(threadData.getForumId())) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
            }
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (d.b.h0.w.w.a.a().b() == 1) {
                albumFloatActivityConfig.setRequestFrom(2);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        } else if (i2 != 24) {
            if (i2 != 10) {
                if (i2 != 11) {
                    return;
                }
                deleteVoice();
                return;
            }
            Object obj = aVar.f51525c;
            if (obj instanceof VoiceData$VoiceModel) {
                addVoice((VoiceData$VoiceModel) obj);
            }
        } else {
            Object obj2 = aVar.f51525c;
            if (obj2 instanceof d.b.h0.s.c.t) {
                d.b.h0.s.c.t tVar = (d.b.h0.s.c.t) obj2;
                if (tVar.e() != EmotionGroupType.BIG_EMOTION && tVar.e() != EmotionGroupType.USER_COLLECT) {
                    this.mEditContent.l(tVar);
                    return;
                }
                if (this.mCurrentPermissionJudgePolicy == null) {
                    this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                }
                this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                    return;
                }
                if (this.mWriteImagesInfo.size() >= this.mWriteImagesInfo.getMaxImagesAllowed()) {
                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                    return;
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(tVar.b());
                imageFileInfo.width = tVar.g();
                imageFileInfo.height = tVar.a();
                ensureWriteImagesInfo();
                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                this.mWriteImagesInfo.updateQuality();
                this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                this.mImgsAdapter.notifyDataSetChanged();
                checkPostBtnEnabled();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        t tVar = this.mFullScreenEditor;
        if (tVar != null) {
            tVar.k(i2, i3, intent);
        }
        if (i3 == -1) {
            if (i2 == 12002) {
                if (intent == null) {
                    return;
                }
                ensureWriteImagesInfo();
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    handleCameraResultData(intent);
                } else {
                    handleAlbumResultData(intent);
                }
                this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                this.mImgsAdapter.notifyDataSetChanged();
                checkPostBtnEnabled();
            } else if (i2 == 12004) {
                if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                    return;
                }
                this.mEditContent.g(stringArrayListExtra);
            } else if (i2 != 12012) {
                if (i2 == 25004 && intent != null) {
                    this.mEditContent.h(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else {
                ensureWriteImagesInfo();
                handleMotuResultData(intent);
                this.mImgsAdapter.c(this.mWriteImagesInfo.getChosedFiles());
                this.mImgsAdapter.notifyDataSetChanged();
                checkPostBtnEnabled();
            }
        }
    }

    public void onBack(boolean z) {
        String editText;
        Intent intent = new Intent();
        if (this.mPbEditorData == null) {
            this.mPbEditorData = new PbEditorData();
        }
        SpanGroupManager spanGroupManager = this.mEditContentSpanGroupManager;
        if (spanGroupManager != null) {
            editText = spanGroupManager.p();
        } else {
            editText = this.mEditContent.toString();
        }
        this.mPbEditorData.setContent(editText);
        this.mPbEditorData.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.mPbEditorData.setWriteImagesInfo(this.mWriteImagesInfo);
        this.mPbEditorData.setVoiceModel(this.mFullScreenEditor.h());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.mPbEditorData);
        if (z) {
            s0 s0Var = this.mContentProcessController;
            if (s0Var != null && s0Var.e() != null && this.mContentProcessController.e().d()) {
                showToast(this.mContentProcessController.e().c());
                this.mContentProcessController.a(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onBack(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setViewTextColor(this.mEditContent, R.color.CAM_X0105);
        this.mEditContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.mIvDeleteVoice, R.drawable.icon_edit_close_n);
        SkinManager.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        SkinManager.setViewTextColor(this.mTvName, R.color.CAM_X0105);
        checkPostBtnEnabled();
        s0 s0Var = this.mContentProcessController;
        if (s0Var != null) {
            s0Var.i();
        }
        EditorTools editorTools = this.mEditorTools;
        if (editorTools != null) {
            editorTools.w(i2);
        }
    }

    @Override // d.b.i0.c2.k.e.p.c
    public void onClickImage(int i2) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i2);
        if (imageInfoAt == null || imageInfoAt.getImageType() == 1) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, i2)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PbFullScreenEditorInputView pbFullScreenEditorInputView;
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        VoiceManager voiceManager = new VoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        initView();
        initData();
        PbEditorData pbEditorData = this.mPbEditorData;
        if (pbEditorData != null && pbEditorData.getEditorType() == 1 && (pbFullScreenEditorInputView = this.mEditContent) != null) {
            pbFullScreenEditorInputView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(REPLY_MAX_SIZE)});
        }
        s0 s0Var = new s0();
        this.mContentProcessController = s0Var;
        PbFullScreenEditorInputView pbFullScreenEditorInputView2 = this.mEditContent;
        if (pbFullScreenEditorInputView2 != null) {
            s0Var.m(pbFullScreenEditorInputView2);
        }
        PostWriteCallBackData postWriteCallBackData = this.mPostWriteCallBackData;
        if (postWriteCallBackData != null) {
            this.mContentProcessController.k(postWriteCallBackData);
        }
        adjustResizeForSoftInput();
    }

    @Override // d.b.i0.c2.k.e.p.c
    public void onDeleteImage(int i2) {
        WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
        if (writeImagesInfo == null || writeImagesInfo.getChosedFiles() == null) {
            return;
        }
        if (i2 >= 0 && i2 < this.mWriteImagesInfo.size()) {
            ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.b.b.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            this.mImgsAdapter.notifyDataSetChanged();
        }
        checkPostBtnEnabled();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s0 s0Var = this.mContentProcessController;
        if (s0Var != null) {
            s0Var.j();
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.removeBlackScreen();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        l.w(this, getCurrentFocus());
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        t tVar;
        if (i2 == 0 && (tVar = this.mFullScreenEditor) != null) {
            tVar.t();
        } else {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
