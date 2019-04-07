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
    private EditorScrollView ccT;
    private EditorTools cij;
    private VoiceManager eYD;
    public as hmO;
    private View hqY = null;
    private TextView hqZ = null;
    private TextView hra = null;
    private PbFullScreenEditorInputView hrb;
    private WholeDisplayGridView hrc;
    private n hrd;
    private LinearLayout hre;
    private PlayVoiceBntNew hrf;
    private LinearLayout hrg;
    private ImageView hrh;
    private LinearLayout hri;
    private u hrj;
    private t hrk;
    private PbEditorData hrl;
    private PostWriteCallBackData hrm;
    private View hrn;
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
        this.eYD = new VoiceManager();
        this.eYD.onCreate(getPageContext());
        initView();
        initData();
        if (this.hrl != null && this.hrl.getEditorType() == 1 && this.hrb != null) {
            this.hrb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hmO = new as();
        if (this.hrb != null) {
            this.hmO.k(this.hrb);
        }
        if (this.hrm != null) {
            this.hmO.f(this.hrm);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aBy();
        this.mTopLine = findViewById(d.g.view_line);
        this.ccT = (EditorScrollView) findViewById(d.g.scroll_view);
        this.ccT.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cij != null) {
                    PbFullScreenEditorActivity.this.cij.akm();
                    PbFullScreenEditorActivity.this.cij.ama();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hrb);
            }
        });
        bKG();
        this.hrb = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.hrb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cij != null) {
                    PbFullScreenEditorActivity.this.cij.akm();
                    PbFullScreenEditorActivity.this.cij.ama();
                }
            }
        });
        this.hrb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bKJ();
                if (PbFullScreenEditorActivity.this.hmO != null && PbFullScreenEditorActivity.this.hmO.bNw() != null) {
                    if (!PbFullScreenEditorActivity.this.hmO.bNw().cnZ()) {
                        PbFullScreenEditorActivity.this.hmO.nZ(false);
                    }
                    PbFullScreenEditorActivity.this.hmO.bNw().qV(false);
                }
            }
        });
        this.hre = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrf = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrg = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.hrh = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bKI();
            }
        });
        this.hrc = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.hrd = new n(this.mContext);
        this.hrd.a(this);
        this.hrc.setAdapter((ListAdapter) this.hrd);
    }

    private void bKG() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hrp = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hrc) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hrp);
                    int x = ((int) motionEvent.getX()) - this.hrp[0];
                    int y = ((int) motionEvent.getY()) - this.hrp[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cij.akm();
                        PbFullScreenEditorActivity.this.cij.ama();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrb);
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
        this.hrn = findViewById(d.g.scroll_view_child);
        this.hrn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cij != null) {
                    PbFullScreenEditorActivity.this.cij.akm();
                    PbFullScreenEditorActivity.this.cij.ama();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hrb);
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
        this.hqY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hra = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.j(this.hra, d.C0277d.cp_cont_b);
        this.hqZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hqY != null && this.hqZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hqY.getLayoutParams();
            layoutParams2.width = -2;
            this.hqY.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.hqY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hqZ.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds14);
            this.hqZ.setLayoutParams(layoutParams3);
            this.hqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.hrl = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hrl != null) {
                nv(this.hrl.getEditorType() == 1);
                final String disableVoiceMessage = this.hrl.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cij != null) {
                    com.baidu.tbadk.editortools.g js = this.cij.js(6);
                    if (js instanceof View) {
                        ((View) js).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hrl.getThreadData();
                if (this.hrj != null) {
                    this.hrj.setThreadData(this.mThreadData);
                }
                if (this.hrk != null) {
                    this.hrk.setThreadData(this.mThreadData);
                }
                String content = this.hrl.getContent();
                if (this.hrl.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hrl.getSubPbReplyPrefix();
                    this.hrb.dz(this.mSubPbReplyPrefix, content);
                } else {
                    this.hrb.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hrl.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hrd.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrd.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hrl.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hre.setVisibility(0);
                    this.hrf.setVoiceModel(voiceModel);
                    this.hrk.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k jv = this.cij.jv(6);
                    if (jv != null && jv.ciw != null) {
                        jv.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cij.aV((View) this.cij.js(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hrm = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bKJ();
    }

    private void nv(boolean z) {
        this.hri = (LinearLayout) findViewById(d.g.editbar_container);
        this.hrj = new u();
        this.hrj.nx(z);
        this.hrk = (t) this.hrj.dd(this.mContext);
        this.cij = this.hrk.alP();
        this.hrk.b(this);
        this.hrj.b(this);
        this.hri.addView(this.cij, new LinearLayout.LayoutParams(-1, -2));
        this.cij.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hrk.c(this);
        this.cij.qT();
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
        if (this.hrl == null) {
            this.hrl = new PbEditorData();
        }
        this.hrl.setContent(this.hrb.getText().toString());
        this.hrl.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hrl.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hrl.setVoiceModel(this.hrk.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hrl);
        if (z) {
            if (this.hmO != null && this.hmO.bNw() != null && this.hmO.bNw().cnY()) {
                showToast(this.hmO.bNw().coa());
                this.hmO.nZ(true);
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
                this.hrd.notifyDataSetChanged();
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
        if (this.hrk != null) {
            this.hrk.onActivityResult(i, i2, intent);
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
                        this.hrd.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hrd.notifyDataSetChanged();
                        bKJ();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hrb.ar(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKH();
                    an(intent);
                    this.hrd.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hrd.notifyDataSetChanged();
                    bKJ();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hrb.oN(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
        return this.eYD;
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
                    com.baidu.tieba.face.b.f(this.hrb);
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
                                this.hrd.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hrd.notifyDataSetChanged();
                                bKJ();
                                return;
                            }
                            return;
                        }
                        this.hrb.b(pVar);
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
            this.hrk.setVoiceModel(voiceModel);
            this.hre.setVisibility(0);
            this.hrf.setVoiceModel(voiceModel);
            bKJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        if (this.hrk.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hrk.getVoiceModel().voiceId));
        }
        this.hrk.setVoiceModel(null);
        this.hre.setVisibility(8);
        this.hrf.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jv = this.cij.jv(6);
        if (jv != null && jv.ciw != null) {
            jv.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKJ() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hrb.getText().toString());
        boolean z4 = (this.hrk == null || this.hrk.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hqZ != null) {
            this.hqZ.setEnabled(z);
        }
        if (z) {
            if (this.hqZ != null) {
                com.baidu.tbadk.core.util.al.j(this.hqZ, d.C0277d.cp_link_tip_a);
            }
        } else if (this.hqZ != null) {
            com.baidu.tbadk.core.util.al.j(this.hqZ, d.C0277d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.hrb, d.C0277d.cp_cont_b);
        this.hrb.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.hrh, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.l(this.mTopLine, d.C0277d.cp_bg_line_c);
        if (this.hmO != null) {
            this.hmO.onChangeSkinType();
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
        if (this.hmO != null) {
            this.hmO.onDestroy();
        }
    }
}
