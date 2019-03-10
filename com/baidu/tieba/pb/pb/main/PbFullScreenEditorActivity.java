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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorScrollView ccR;
    private EditorTools cih;
    private VoiceManager eYS;
    public as hni;
    private LinearLayout hrA;
    private ImageView hrB;
    private LinearLayout hrC;
    private u hrD;
    private t hrE;
    private PbEditorData hrF;
    private PostWriteCallBackData hrG;
    private View hrH;
    private View hrs = null;
    private TextView hrt = null;
    private TextView hru = null;
    private PbFullScreenEditorInputView hrv;
    private WholeDisplayGridView hrw;
    private n hrx;
    private LinearLayout hry;
    private PlayVoiceBntNew hrz;
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
        setContentView(d.h.layout_pb_editor_activity);
        this.eYS = new VoiceManager();
        this.eYS.onCreate(getPageContext());
        initView();
        initData();
        if (this.hrF != null && this.hrF.getEditorType() == 1 && this.hrv != null) {
            this.hrv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hni = new as();
        if (this.hrv != null) {
            this.hni.k(this.hrv);
        }
        if (this.hrG != null) {
            this.hni.f(this.hrG);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aBC();
        this.mTopLine = findViewById(d.g.view_line);
        this.ccR = (EditorScrollView) findViewById(d.g.scroll_view);
        this.ccR.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hrv);
            }
        });
        bKK();
        this.hrv = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.hrv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
            }
        });
        this.hrv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bKN();
                if (PbFullScreenEditorActivity.this.hni != null && PbFullScreenEditorActivity.this.hni.bNz() != null) {
                    if (!PbFullScreenEditorActivity.this.hni.bNz().cnY()) {
                        PbFullScreenEditorActivity.this.hni.nZ(false);
                    }
                    PbFullScreenEditorActivity.this.hni.bNz().qV(false);
                }
            }
        });
        this.hry = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrz = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrA = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.hrB = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bKM();
            }
        });
        this.hrw = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.hrx = new n(this.mContext);
        this.hrx.a(this);
        this.hrw.setAdapter((ListAdapter) this.hrx);
    }

    private void bKK() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hrJ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hrw) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hrJ);
                    int x = ((int) motionEvent.getX()) - this.hrJ[0];
                    int y = ((int) motionEvent.getY()) - this.hrJ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cih.akq();
                        PbFullScreenEditorActivity.this.cih.ame();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrv);
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
        this.hrH = findViewById(d.g.scroll_view_child);
        this.hrH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrv);
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

    private void aBC() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hrs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hru = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hru, d.C0236d.cp_cont_b);
        this.hrt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hrs != null && this.hrt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hrs.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hrs.getLayoutParams();
            layoutParams2.width = -2;
            this.hrs.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.hrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hrt.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds14);
            this.hrt.setLayoutParams(layoutParams3);
            this.hrt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.nw(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hrF = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hrF != null) {
                nv(this.hrF.getEditorType() == 1);
                final String disableVoiceMessage = this.hrF.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cih != null) {
                    com.baidu.tbadk.editortools.g jt = this.cih.jt(6);
                    if (jt instanceof View) {
                        ((View) jt).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hrF.getThreadData();
                if (this.hrD != null) {
                    this.hrD.setThreadData(this.mThreadData);
                }
                if (this.hrE != null) {
                    this.hrE.setThreadData(this.mThreadData);
                }
                String content = this.hrF.getContent();
                if (this.hrF.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hrF.getSubPbReplyPrefix();
                    this.hrv.dy(this.mSubPbReplyPrefix, content);
                } else {
                    this.hrv.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hrF.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hrx.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrx.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hrF.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hry.setVisibility(0);
                    this.hrz.setVoiceModel(voiceModel);
                    this.hrE.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k jw = this.cih.jw(6);
                    if (jw != null && jw.ciu != null) {
                        jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cih.aV((View) this.cih.jt(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hrG = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bKN();
    }

    private void nv(boolean z) {
        this.hrC = (LinearLayout) findViewById(d.g.editbar_container);
        this.hrD = new u();
        this.hrD.nx(z);
        this.hrE = (t) this.hrD.dd(this.mContext);
        this.cih = this.hrE.alT();
        this.hrE.b(this);
        this.hrD.b(this);
        this.hrC.addView(this.cih, new LinearLayout.LayoutParams(-1, -2));
        this.cih.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hrE.c(this);
        this.cih.qT();
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
        nw(false);
    }

    public void nw(boolean z) {
        Intent intent = new Intent();
        if (this.hrF == null) {
            this.hrF = new PbEditorData();
        }
        this.hrF.setContent(this.hrv.getText().toString());
        this.hrF.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hrF.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hrF.setVoiceModel(this.hrE.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hrF);
        if (z) {
            if (this.hni != null && this.hni.bNz() != null && this.hni.bNz().cnX()) {
                showToast(this.hni.bNz().cnZ());
                this.hni.nZ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wk(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hrx.notifyDataSetChanged();
            }
            bKN();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wl(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.hrE != null) {
            this.hrE.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bKL();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            am(intent);
                        } else {
                            ao(intent);
                        }
                        this.hrx.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hrx.notifyDataSetChanged();
                        bKN();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hrv.ar(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKL();
                    an(intent);
                    this.hrx.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrx.notifyDataSetChanged();
                    bKN();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hrv.oM(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bKL() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void am(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aO(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aQ(this.mContext)));
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
            bKL();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void an(Intent intent) {
        b(intent, false);
    }

    private void ao(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bKL();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
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
                    com.baidu.tieba.face.b.f(this.hrv);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bKM();
                    return;
                case 14:
                    bKL();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.amq().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.agt() == EmotionGroupType.BIG_EMOTION || pVar.agt() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.adQ();
                            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.Y(this)) {
                                if (this.mWriteImagesInfo.size() >= 9) {
                                    showToast(String.format(getString(d.j.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                bKL();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hrx.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hrx.notifyDataSetChanged();
                                bKN();
                                return;
                            }
                            return;
                        }
                        this.hrv.b(pVar);
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
            this.hrE.setVoiceModel(voiceModel);
            this.hry.setVisibility(0);
            this.hrz.setVoiceModel(voiceModel);
            bKN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKM() {
        if (this.hrE.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hrE.getVoiceModel().voiceId));
        }
        this.hrE.setVoiceModel(null);
        this.hry.setVisibility(8);
        this.hrz.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jw = this.cih.jw(6);
        if (jw != null && jw.ciu != null) {
            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bKN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKN() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hrv.getText().toString());
        boolean z4 = (this.hrE == null || this.hrE.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hrt != null) {
            this.hrt.setEnabled(z);
        }
        if (z) {
            if (this.hrt != null) {
                com.baidu.tbadk.core.util.al.j(this.hrt, d.C0236d.cp_link_tip_a);
            }
        } else if (this.hrt != null) {
            com.baidu.tbadk.core.util.al.j(this.hrt, d.C0236d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hrv, d.C0236d.cp_cont_b);
        this.hrv.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hrB, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, d.C0236d.cp_bg_line_c);
        if (this.hni != null) {
            this.hni.onChangeSkinType();
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
        if (this.hni != null) {
            this.hni.onDestroy();
        }
    }
}
