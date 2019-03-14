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
    private VoiceManager eYR;
    public as hnb;
    private View hrA;
    private View hrl = null;
    private TextView hrm = null;
    private TextView hrn = null;
    private PbFullScreenEditorInputView hro;
    private WholeDisplayGridView hrp;
    private n hrq;
    private LinearLayout hrr;
    private PlayVoiceBntNew hrs;
    private LinearLayout hrt;
    private ImageView hru;
    private LinearLayout hrv;
    private u hrw;
    private t hrx;
    private PbEditorData hry;
    private PostWriteCallBackData hrz;
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
        this.eYR = new VoiceManager();
        this.eYR.onCreate(getPageContext());
        initView();
        initData();
        if (this.hry != null && this.hry.getEditorType() == 1 && this.hro != null) {
            this.hro.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hnb = new as();
        if (this.hro != null) {
            this.hnb.k(this.hro);
        }
        if (this.hrz != null) {
            this.hnb.f(this.hrz);
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
                    PbFullScreenEditorActivity.this.cih.akp();
                    PbFullScreenEditorActivity.this.cih.amd();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hro);
            }
        });
        bKJ();
        this.hro = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.hro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akp();
                    PbFullScreenEditorActivity.this.cih.amd();
                }
            }
        });
        this.hro.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bKM();
                if (PbFullScreenEditorActivity.this.hnb != null && PbFullScreenEditorActivity.this.hnb.bNz() != null) {
                    if (!PbFullScreenEditorActivity.this.hnb.bNz().cob()) {
                        PbFullScreenEditorActivity.this.hnb.nZ(false);
                    }
                    PbFullScreenEditorActivity.this.hnb.bNz().qV(false);
                }
            }
        });
        this.hrr = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrs = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrt = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.hru = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bKL();
            }
        });
        this.hrp = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.hrq = new n(this.mContext);
        this.hrq.a(this);
        this.hrp.setAdapter((ListAdapter) this.hrq);
    }

    private void bKJ() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hrC = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hrp) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hrC);
                    int x = ((int) motionEvent.getX()) - this.hrC[0];
                    int y = ((int) motionEvent.getY()) - this.hrC[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cih.akp();
                        PbFullScreenEditorActivity.this.cih.amd();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hro);
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
        this.hrA = findViewById(d.g.scroll_view_child);
        this.hrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cih != null) {
                    PbFullScreenEditorActivity.this.cih.akp();
                    PbFullScreenEditorActivity.this.cih.amd();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hro);
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
        this.hrl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hrn = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hrn, d.C0277d.cp_cont_b);
        this.hrm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hrl != null && this.hrm != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hrl.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hrl.getLayoutParams();
            layoutParams2.width = -2;
            this.hrl.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.hrl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hrm.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds14);
            this.hrm.setLayoutParams(layoutParams3);
            this.hrm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.hry = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hry != null) {
                nv(this.hry.getEditorType() == 1);
                final String disableVoiceMessage = this.hry.getDisableVoiceMessage();
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
                this.mThreadData = this.hry.getThreadData();
                if (this.hrw != null) {
                    this.hrw.setThreadData(this.mThreadData);
                }
                if (this.hrx != null) {
                    this.hrx.setThreadData(this.mThreadData);
                }
                String content = this.hry.getContent();
                if (this.hry.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hry.getSubPbReplyPrefix();
                    this.hro.dy(this.mSubPbReplyPrefix, content);
                } else {
                    this.hro.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hry.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hrq.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrq.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hry.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hrr.setVisibility(0);
                    this.hrs.setVoiceModel(voiceModel);
                    this.hrx.setVoiceModel(voiceModel);
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
            this.hrz = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bKM();
    }

    private void nv(boolean z) {
        this.hrv = (LinearLayout) findViewById(d.g.editbar_container);
        this.hrw = new u();
        this.hrw.nx(z);
        this.hrx = (t) this.hrw.dd(this.mContext);
        this.cih = this.hrx.alS();
        this.hrx.b(this);
        this.hrw.b(this);
        this.hrv.addView(this.cih, new LinearLayout.LayoutParams(-1, -2));
        this.cih.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hrx.c(this);
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
        if (this.hry == null) {
            this.hry = new PbEditorData();
        }
        this.hry.setContent(this.hro.getText().toString());
        this.hry.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hry.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hry.setVoiceModel(this.hrx.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hry);
        if (z) {
            if (this.hnb != null && this.hnb.bNz() != null && this.hnb.bNz().coa()) {
                showToast(this.hnb.bNz().coc());
                this.hnb.nZ(true);
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
                this.hrq.notifyDataSetChanged();
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
        if (this.hrx != null) {
            this.hrx.onActivityResult(i, i2, intent);
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
                        this.hrq.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hrq.notifyDataSetChanged();
                        bKM();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hro.ar(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKK();
                    an(intent);
                    this.hrq.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrq.notifyDataSetChanged();
                    bKM();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hro.oM(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
        return this.eYR;
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
                    com.baidu.tieba.face.b.f(this.hro);
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
                    if (com.baidu.tbadk.editortools.pb.a.amp().getStatus() == 1) {
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
                                this.hrq.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hrq.notifyDataSetChanged();
                                bKM();
                                return;
                            }
                            return;
                        }
                        this.hro.b(pVar);
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
            this.hrx.setVoiceModel(voiceModel);
            this.hrr.setVisibility(0);
            this.hrs.setVoiceModel(voiceModel);
            bKM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKL() {
        if (this.hrx.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hrx.getVoiceModel().voiceId));
        }
        this.hrx.setVoiceModel(null);
        this.hrr.setVisibility(8);
        this.hrs.setVoiceModel(null);
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
        boolean z3 = !TextUtils.isEmpty(this.hro.getText().toString());
        boolean z4 = (this.hrx == null || this.hrx.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hrm != null) {
            this.hrm.setEnabled(z);
        }
        if (z) {
            if (this.hrm != null) {
                com.baidu.tbadk.core.util.al.j(this.hrm, d.C0277d.cp_link_tip_a);
            }
        } else if (this.hrm != null) {
            com.baidu.tbadk.core.util.al.j(this.hrm, d.C0277d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hro, d.C0277d.cp_cont_b);
        this.hro.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hru, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, d.C0277d.cp_bg_line_c);
        if (this.hnb != null) {
            this.hnb.onChangeSkinType();
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
        if (this.hnb != null) {
            this.hnb.onDestroy();
        }
    }
}
