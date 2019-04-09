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
    private EditorScrollView ccU;
    private EditorTools cik;
    private VoiceManager eYE;
    public as hmP;
    private View hqZ = null;
    private TextView hra = null;
    private TextView hrb = null;
    private PbFullScreenEditorInputView hrc;
    private WholeDisplayGridView hrd;
    private n hre;
    private LinearLayout hrf;
    private PlayVoiceBntNew hrg;
    private LinearLayout hrh;
    private ImageView hri;
    private LinearLayout hrj;
    private u hrk;
    private t hrl;
    private PbEditorData hrm;
    private PostWriteCallBackData hrn;
    private View hro;
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
        this.eYE = new VoiceManager();
        this.eYE.onCreate(getPageContext());
        initView();
        initData();
        if (this.hrm != null && this.hrm.getEditorType() == 1 && this.hrc != null) {
            this.hrc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hmP = new as();
        if (this.hrc != null) {
            this.hmP.k(this.hrc);
        }
        if (this.hrn != null) {
            this.hmP.f(this.hrn);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aBy();
        this.mTopLine = findViewById(d.g.view_line);
        this.ccU = (EditorScrollView) findViewById(d.g.scroll_view);
        this.ccU.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cik != null) {
                    PbFullScreenEditorActivity.this.cik.akm();
                    PbFullScreenEditorActivity.this.cik.ama();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hrc);
            }
        });
        bKG();
        this.hrc = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.hrc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cik != null) {
                    PbFullScreenEditorActivity.this.cik.akm();
                    PbFullScreenEditorActivity.this.cik.ama();
                }
            }
        });
        this.hrc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bKJ();
                if (PbFullScreenEditorActivity.this.hmP != null && PbFullScreenEditorActivity.this.hmP.bNw() != null) {
                    if (!PbFullScreenEditorActivity.this.hmP.bNw().cnZ()) {
                        PbFullScreenEditorActivity.this.hmP.nZ(false);
                    }
                    PbFullScreenEditorActivity.this.hmP.bNw().qV(false);
                }
            }
        });
        this.hrf = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrg = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrh = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.hri = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bKI();
            }
        });
        this.hrd = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.hre = new n(this.mContext);
        this.hre.a(this);
        this.hrd.setAdapter((ListAdapter) this.hre);
    }

    private void bKG() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hrq = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hrd) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hrq);
                    int x = ((int) motionEvent.getX()) - this.hrq[0];
                    int y = ((int) motionEvent.getY()) - this.hrq[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cik.akm();
                        PbFullScreenEditorActivity.this.cik.ama();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrc);
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
        this.hro = findViewById(d.g.scroll_view_child);
        this.hro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cik != null) {
                    PbFullScreenEditorActivity.this.cik.akm();
                    PbFullScreenEditorActivity.this.cik.ama();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrc);
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

    private void aBy() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hqZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hrb = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hrb, d.C0277d.cp_cont_b);
        this.hra = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hqZ != null && this.hra != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hqZ.getLayoutParams();
            layoutParams2.width = -2;
            this.hqZ.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.hqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hra.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds14);
            this.hra.setLayoutParams(layoutParams3);
            this.hra.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.hrm = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hrm != null) {
                nv(this.hrm.getEditorType() == 1);
                final String disableVoiceMessage = this.hrm.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cik != null) {
                    com.baidu.tbadk.editortools.g js = this.cik.js(6);
                    if (js instanceof View) {
                        ((View) js).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hrm.getThreadData();
                if (this.hrk != null) {
                    this.hrk.setThreadData(this.mThreadData);
                }
                if (this.hrl != null) {
                    this.hrl.setThreadData(this.mThreadData);
                }
                String content = this.hrm.getContent();
                if (this.hrm.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hrm.getSubPbReplyPrefix();
                    this.hrc.dz(this.mSubPbReplyPrefix, content);
                } else {
                    this.hrc.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hrm.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hre.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hre.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hrm.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hrf.setVisibility(0);
                    this.hrg.setVoiceModel(voiceModel);
                    this.hrl.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k jv = this.cik.jv(6);
                    if (jv != null && jv.cix != null) {
                        jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cik.aV((View) this.cik.js(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hrn = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bKJ();
    }

    private void nv(boolean z) {
        this.hrj = (LinearLayout) findViewById(d.g.editbar_container);
        this.hrk = new u();
        this.hrk.nx(z);
        this.hrl = (t) this.hrk.dd(this.mContext);
        this.cik = this.hrl.alP();
        this.hrl.b(this);
        this.hrk.b(this);
        this.hrj.addView(this.cik, new LinearLayout.LayoutParams(-1, -2));
        this.cik.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hrl.c(this);
        this.cik.qT();
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
        if (this.hrm == null) {
            this.hrm = new PbEditorData();
        }
        this.hrm.setContent(this.hrc.getText().toString());
        this.hrm.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hrm.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hrm.setVoiceModel(this.hrl.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hrm);
        if (z) {
            if (this.hmP != null && this.hmP.bNw() != null && this.hmP.bNw().cnY()) {
                showToast(this.hmP.bNw().coa());
                this.hmP.nZ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wg(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hre.notifyDataSetChanged();
            }
            bKJ();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wh(int i) {
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
        if (this.hrl != null) {
            this.hrl.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bKH();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            am(intent);
                        } else {
                            ao(intent);
                        }
                        this.hre.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hre.notifyDataSetChanged();
                        bKJ();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hrc.ar(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKH();
                    an(intent);
                    this.hre.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hre.notifyDataSetChanged();
                    bKJ();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hrc.oN(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bKH() {
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
            bKH();
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
            bKH();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYE;
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
                    com.baidu.tieba.face.b.f(this.hrc);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bKI();
                    return;
                case 14:
                    bKH();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.amm().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.agq() == EmotionGroupType.BIG_EMOTION || pVar.agq() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.adN();
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
                                bKH();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hre.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hre.notifyDataSetChanged();
                                bKJ();
                                return;
                            }
                            return;
                        }
                        this.hrc.b(pVar);
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
            this.hrl.setVoiceModel(voiceModel);
            this.hrf.setVisibility(0);
            this.hrg.setVoiceModel(voiceModel);
            bKJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        if (this.hrl.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hrl.getVoiceModel().voiceId));
        }
        this.hrl.setVoiceModel(null);
        this.hrf.setVisibility(8);
        this.hrg.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jv = this.cik.jv(6);
        if (jv != null && jv.cix != null) {
            jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKJ() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hrc.getText().toString());
        boolean z4 = (this.hrl == null || this.hrl.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hra != null) {
            this.hra.setEnabled(z);
        }
        if (z) {
            if (this.hra != null) {
                com.baidu.tbadk.core.util.al.j(this.hra, d.C0277d.cp_link_tip_a);
            }
        } else if (this.hra != null) {
            com.baidu.tbadk.core.util.al.j(this.hra, d.C0277d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hrc, d.C0277d.cp_cont_b);
        this.hrc.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hri, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, d.C0277d.cp_bg_line_c);
        if (this.hmP != null) {
            this.hmP.onChangeSkinType();
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
        if (this.hmP != null) {
            this.hmP.onDestroy();
        }
    }
}
