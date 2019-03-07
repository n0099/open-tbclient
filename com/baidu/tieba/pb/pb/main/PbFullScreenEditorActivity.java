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
    public as hnh;
    private ImageView hrA;
    private LinearLayout hrB;
    private u hrC;
    private t hrD;
    private PbEditorData hrE;
    private PostWriteCallBackData hrF;
    private View hrG;
    private View hrr = null;
    private TextView hrs = null;
    private TextView hrt = null;
    private PbFullScreenEditorInputView hru;
    private WholeDisplayGridView hrv;
    private n hrw;
    private LinearLayout hrx;
    private PlayVoiceBntNew hry;
    private LinearLayout hrz;
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
        if (this.hrE != null && this.hrE.getEditorType() == 1 && this.hru != null) {
            this.hru.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hnh = new as();
        if (this.hru != null) {
            this.hnh.k(this.hru);
        }
        if (this.hrF != null) {
            this.hnh.f(this.hrF);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aBB();
        this.mTopLine = findViewById(d.g.view_line);
        this.ccR = (EditorScrollView) findViewById(d.g.scroll_view);
        this.ccR.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hru);
            }
        });
        bKJ();
        this.hru = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.hru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
            }
        });
        this.hru.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bKM();
                if (PbFullScreenEditorActivity.this.hnh != null && PbFullScreenEditorActivity.this.hnh.bNy() != null) {
                    if (!PbFullScreenEditorActivity.this.hnh.bNy().cnO()) {
                        PbFullScreenEditorActivity.this.hnh.nZ(false);
                    }
                    PbFullScreenEditorActivity.this.hnh.bNy().qV(false);
                }
            }
        });
        this.hrx = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hry = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrz = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.hrA = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bKL();
            }
        });
        this.hrv = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.hrw = new n(this.mContext);
        this.hrw.a(this);
        this.hrv.setAdapter((ListAdapter) this.hrw);
    }

    private void bKJ() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hrI = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hrv) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hrI);
                    int x = ((int) motionEvent.getX()) - this.hrI[0];
                    int y = ((int) motionEvent.getY()) - this.hrI[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cih.akq();
                        PbFullScreenEditorActivity.this.cih.ame();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hru);
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
        this.hrG = findViewById(d.g.scroll_view_child);
        this.hrG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akq();
                    PbFullScreenEditorActivity.this.cih.ame();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hru);
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

    private void aBB() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hrr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hrt = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hrt, d.C0236d.cp_cont_b);
        this.hrs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hrr != null && this.hrs != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hrr.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hrr.getLayoutParams();
            layoutParams2.width = -2;
            this.hrr.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.hrr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hrs.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds14);
            this.hrs.setLayoutParams(layoutParams3);
            this.hrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.hrE = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hrE != null) {
                nv(this.hrE.getEditorType() == 1);
                final String disableVoiceMessage = this.hrE.getDisableVoiceMessage();
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
                this.mThreadData = this.hrE.getThreadData();
                if (this.hrC != null) {
                    this.hrC.setThreadData(this.mThreadData);
                }
                if (this.hrD != null) {
                    this.hrD.setThreadData(this.mThreadData);
                }
                String content = this.hrE.getContent();
                if (this.hrE.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hrE.getSubPbReplyPrefix();
                    this.hru.dy(this.mSubPbReplyPrefix, content);
                } else {
                    this.hru.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hrE.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hrw.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrw.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hrE.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hrx.setVisibility(0);
                    this.hry.setVoiceModel(voiceModel);
                    this.hrD.setVoiceModel(voiceModel);
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
            this.hrF = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bKM();
    }

    private void nv(boolean z) {
        this.hrB = (LinearLayout) findViewById(d.g.editbar_container);
        this.hrC = new u();
        this.hrC.nx(z);
        this.hrD = (t) this.hrC.dd(this.mContext);
        this.cih = this.hrD.alT();
        this.hrD.b(this);
        this.hrC.b(this);
        this.hrB.addView(this.cih, new LinearLayout.LayoutParams(-1, -2));
        this.cih.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hrD.c(this);
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
        if (this.hrE == null) {
            this.hrE = new PbEditorData();
        }
        this.hrE.setContent(this.hru.getText().toString());
        this.hrE.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hrE.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hrE.setVoiceModel(this.hrD.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hrE);
        if (z) {
            if (this.hnh != null && this.hnh.bNy() != null && this.hnh.bNy().cnN()) {
                showToast(this.hnh.bNy().cnP());
                this.hnh.nZ(true);
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
                this.hrw.notifyDataSetChanged();
            }
            bKM();
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
        if (this.hrD != null) {
            this.hrD.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bKK();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            am(intent);
                        } else {
                            ao(intent);
                        }
                        this.hrw.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hrw.notifyDataSetChanged();
                        bKM();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hru.ar(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKK();
                    an(intent);
                    this.hrw.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrw.notifyDataSetChanged();
                    bKM();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hru.oM(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bKK() {
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
            bKK();
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
            bKK();
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
                    com.baidu.tieba.face.b.f(this.hru);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bKL();
                    return;
                case 14:
                    bKK();
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
                                bKK();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hrw.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hrw.notifyDataSetChanged();
                                bKM();
                                return;
                            }
                            return;
                        }
                        this.hru.b(pVar);
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
            this.hrD.setVoiceModel(voiceModel);
            this.hrx.setVisibility(0);
            this.hry.setVoiceModel(voiceModel);
            bKM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKL() {
        if (this.hrD.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hrD.getVoiceModel().voiceId));
        }
        this.hrD.setVoiceModel(null);
        this.hrx.setVisibility(8);
        this.hry.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jw = this.cih.jw(6);
        if (jw != null && jw.ciu != null) {
            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bKM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKM() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hru.getText().toString());
        boolean z4 = (this.hrD == null || this.hrD.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hrs != null) {
            this.hrs.setEnabled(z);
        }
        if (z) {
            if (this.hrs != null) {
                com.baidu.tbadk.core.util.al.j(this.hrs, d.C0236d.cp_link_tip_a);
            }
        } else if (this.hrs != null) {
            com.baidu.tbadk.core.util.al.j(this.hrs, d.C0236d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hru, d.C0236d.cp_cont_b);
        this.hru.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hrA, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, d.C0236d.cp_bg_line_c);
        if (this.hnh != null) {
            this.hnh.onChangeSkinType();
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
        if (this.hnh != null) {
            this.hnh.onDestroy();
        }
    }
}
