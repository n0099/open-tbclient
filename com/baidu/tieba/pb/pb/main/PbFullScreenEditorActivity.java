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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorScrollView cmt;
    private EditorTools crN;
    private VoiceManager fun;
    public as hLB;
    private View hPP = null;
    private TextView hPQ = null;
    private TextView hPR = null;
    private PbFullScreenEditorInputView hPS;
    private WholeDisplayGridView hPT;
    private n hPU;
    private LinearLayout hPV;
    private PlayVoiceBntNew hPW;
    private LinearLayout hPX;
    private ImageView hPY;
    private LinearLayout hPZ;
    private u hQa;
    private t hQb;
    private PbEditorData hQc;
    private PostWriteCallBackData hQd;
    private View hQe;
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
        this.fun = new VoiceManager();
        this.fun.onCreate(getPageContext());
        initView();
        initData();
        if (this.hQc != null && this.hQc.getEditorType() == 1 && this.hPS != null) {
            this.hPS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hLB = new as();
        if (this.hPS != null) {
            this.hLB.k(this.hPS);
        }
        if (this.hQd != null) {
            this.hLB.f(this.hQd);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aJt();
        this.mTopLine = findViewById(R.id.view_line);
        this.cmt = (EditorScrollView) findViewById(R.id.scroll_view);
        this.cmt.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.crN != null) {
                    PbFullScreenEditorActivity.this.crN.aqw();
                    PbFullScreenEditorActivity.this.crN.asl();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hPS);
            }
        });
        bVD();
        this.hPS = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.crN != null) {
                    PbFullScreenEditorActivity.this.crN.aqw();
                    PbFullScreenEditorActivity.this.crN.asl();
                }
            }
        });
        this.hPS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bVG();
                if (PbFullScreenEditorActivity.this.hLB != null && PbFullScreenEditorActivity.this.hLB.bYy() != null) {
                    if (!PbFullScreenEditorActivity.this.hLB.bYy().czC()) {
                        PbFullScreenEditorActivity.this.hLB.pd(false);
                    }
                    PbFullScreenEditorActivity.this.hLB.bYy().sb(false);
                }
            }
        });
        this.hPV = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPW = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPX = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hPY = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bVF();
            }
        });
        this.hPT = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hPU = new n(this.mContext);
        this.hPU.a(this);
        this.hPT.setAdapter((ListAdapter) this.hPU);
    }

    private void bVD() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hQg = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hPT) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hQg);
                    int x = ((int) motionEvent.getX()) - this.hQg[0];
                    int y = ((int) motionEvent.getY()) - this.hQg[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.crN.aqw();
                        PbFullScreenEditorActivity.this.crN.asl();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hPS);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.hQe = findViewById(R.id.scroll_view_child);
        this.hQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.crN != null) {
                    PbFullScreenEditorActivity.this.crN.aqw();
                    PbFullScreenEditorActivity.this.crN.asl();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hPS);
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

    private void aJt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hPP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hPR = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.j(this.hPR, R.color.cp_cont_b);
        this.hPQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hPP != null && this.hPQ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPP.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hPP.getLayoutParams();
            layoutParams2.width = -2;
            this.hPP.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            this.hPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hPQ.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds14);
            this.hPQ.setLayoutParams(layoutParams3);
            this.hPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.oA(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hQc = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hQc != null) {
                oz(this.hQc.getEditorType() == 1);
                final String disableVoiceMessage = this.hQc.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.crN != null) {
                    com.baidu.tbadk.editortools.g kn = this.crN.kn(6);
                    if (kn instanceof View) {
                        ((View) kn).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hQc.getThreadData();
                if (this.hQa != null) {
                    this.hQa.setThreadData(this.mThreadData);
                }
                if (this.hQb != null) {
                    this.hQb.setThreadData(this.mThreadData);
                }
                String content = this.hQc.getContent();
                if (this.hQc.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hQc.getSubPbReplyPrefix();
                    this.hPS.dM(this.mSubPbReplyPrefix, content);
                } else {
                    this.hPS.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hQc.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hPU.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hPU.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hQc.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hPV.setVisibility(0);
                    this.hPW.setVoiceModel(voiceModel);
                    this.hQb.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k kq = this.crN.kq(6);
                    if (kq != null && kq.csa != null) {
                        kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.crN.bd((View) this.crN.kn(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hQd = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bVG();
    }

    private void oz(boolean z) {
        this.hPZ = (LinearLayout) findViewById(R.id.editbar_container);
        this.hQa = new u();
        this.hQa.oB(z);
        this.hQb = (t) this.hQa.cK(this.mContext);
        this.crN = this.hQb.asa();
        this.hQb.b(this);
        this.hQa.b(this);
        this.hPZ.addView(this.crN, new LinearLayout.LayoutParams(-1, -2));
        this.crN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hQb.c(this);
        this.crN.qk();
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
        oA(false);
    }

    public void oA(boolean z) {
        Intent intent = new Intent();
        if (this.hQc == null) {
            this.hQc = new PbEditorData();
        }
        this.hQc.setContent(this.hPS.getText().toString());
        this.hQc.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hQc.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hQc.setVoiceModel(this.hQb.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hQc);
        if (z) {
            if (this.hLB != null && this.hLB.bYy() != null && this.hLB.bYy().czB()) {
                showToast(this.hLB.bYy().czD());
                this.hLB.pd(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xS(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hPU.notifyDataSetChanged();
            }
            bVG();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xT(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.hQb != null) {
            this.hQb.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        bVE();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            ar(intent);
                        } else {
                            at(intent);
                        }
                        this.hPU.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hPU.notifyDataSetChanged();
                        bVG();
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hPS.av(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12012:
                    bVE();
                    as(intent);
                    this.hPU.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hPU.notifyDataSetChanged();
                    bVG();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hPS.ql(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bVE() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ar(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.af(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ah(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bVE();
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
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bVE();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fun;
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
                    com.baidu.tieba.face.b.f(this.hPS);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bVF();
                    return;
                case 14:
                    bVE();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.asx().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.amw() == EmotionGroupType.BIG_EMOTION || pVar.amw() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.ajS();
                            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.ad(this)) {
                                if (this.mWriteImagesInfo.size() >= 9) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                bVE();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hPU.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hPU.notifyDataSetChanged();
                                bVG();
                                return;
                            }
                            return;
                        }
                        this.hPS.b(pVar);
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
            this.hQb.setVoiceModel(voiceModel);
            this.hPV.setVisibility(0);
            this.hPW.setVoiceModel(voiceModel);
            bVG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        if (this.hQb.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hQb.getVoiceModel().voiceId));
        }
        this.hQb.setVoiceModel(null);
        this.hPV.setVisibility(8);
        this.hPW.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kq = this.crN.kq(6);
        if (kq != null && kq.csa != null) {
            kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVG() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hPS.getText().toString());
        boolean z4 = (this.hQb == null || this.hQb.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hPQ != null) {
            this.hPQ.setEnabled(z);
        }
        if (z) {
            if (this.hPQ != null) {
                com.baidu.tbadk.core.util.am.j(this.hPQ, R.color.cp_link_tip_a);
            }
        } else if (this.hPQ != null) {
            com.baidu.tbadk.core.util.am.j(this.hPQ, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.j(this.hPS, R.color.cp_cont_b);
        this.hPS.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.hPY, (int) R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.l(this.mTopLine, R.color.cp_bg_line_c);
        if (this.hLB != null) {
            this.hLB.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.b(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hLB != null) {
            this.hLB.onDestroy();
        }
        if (this.fun != null) {
            this.fun.removeBlackScreen();
        }
    }
}
