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
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools aCA;
    private View aze;
    private VoiceManager cXg;
    public au feQ;
    private View fjj = null;
    private TextView fjk = null;
    private TextView fjl = null;
    private EditorScrollView fjm;
    private PbFullScreenEditorInputView fjn;
    private WholeDisplayGridView fjo;
    private n fjp;
    private LinearLayout fjq;
    private PlayVoiceBntNew fjr;
    private LinearLayout fjs;
    private ImageView fjt;
    private LinearLayout fju;
    private t fjv;
    private s fjw;
    private PbEditorData fjx;
    private PostWriteCallBackData fjy;
    private View fjz;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(d.i.layout_pb_editor_activity);
        this.cXg = new VoiceManager();
        this.cXg.onCreate(getPageContext());
        initView();
        initData();
        if (this.fjx != null && this.fjx.getEditorType() == 1 && this.fjn != null) {
            this.fjn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.feQ = new au();
        if (this.fjn != null) {
            this.feQ.g(this.fjn);
        }
        if (this.fjy != null) {
            this.feQ.f(this.fjy);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        are();
        this.aze = findViewById(d.g.view_line);
        this.fjm = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fjm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.aCA.Ca();
                PbFullScreenEditorActivity.this.aCA.DP();
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fjn);
            }
        });
        aYb();
        this.fjn = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbFullScreenEditorActivity.this.aCA.Ca();
                PbFullScreenEditorActivity.this.aCA.DP();
            }
        });
        this.fjn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.aYe();
                if (PbFullScreenEditorActivity.this.feQ != null && PbFullScreenEditorActivity.this.feQ.baQ() != null) {
                    if (!PbFullScreenEditorActivity.this.feQ.baQ().bAX()) {
                        PbFullScreenEditorActivity.this.feQ.kr(false);
                    }
                    PbFullScreenEditorActivity.this.feQ.baQ().nj(false);
                }
            }
        });
        this.fjq = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fjr = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fjs = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fjt = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbFullScreenEditorActivity.this.aYd();
            }
        });
        this.fjo = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fjp = new n(this.mContext);
        this.fjp.a(this);
        this.fjo.setAdapter((ListAdapter) this.fjp);
    }

    private void aYb() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fjB = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fjo) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fjB);
                    int x = ((int) motionEvent.getX()) - this.fjB[0];
                    int y = ((int) motionEvent.getY()) - this.fjB[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aCA.Ca();
                        PbFullScreenEditorActivity.this.aCA.DP();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fjn);
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
        this.fjz = findViewById(d.g.scroll_view_child);
        this.fjz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbFullScreenEditorActivity.this.aCA != null) {
                    PbFullScreenEditorActivity.this.aCA.Ca();
                    PbFullScreenEditorActivity.this.aCA.DP();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fjn);
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

    private void are() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fjj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fjl = this.mNavigationBar.setCenterTextTitle(getString(d.k.pb_reply_floor));
        com.baidu.tbadk.core.util.ak.h(this.fjl, d.C0126d.cp_cont_b);
        this.fjk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fjj != null && this.fjk != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjj.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fjj.getLayoutParams();
            layoutParams2.width = -2;
            this.fjj.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fjk.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds14);
            this.fjk.setLayoutParams(layoutParams3);
            this.fjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PbFullScreenEditorActivity.this.jK(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fjx = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fjx != null) {
                jJ(this.fjx.getEditorType() == 1);
                final String disableVoiceMessage = this.fjx.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aCA != null) {
                    com.baidu.tbadk.editortools.g eE = this.aCA.eE(6);
                    if (eE instanceof View) {
                        ((View) eE).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fjx.getThreadData();
                if (this.fjv != null) {
                    this.fjv.setThreadData(this.mThreadData);
                }
                if (this.fjw != null) {
                    this.fjw.setThreadData(this.mThreadData);
                }
                this.fjn.loadData(this.fjx.getContent());
                WriteImagesInfo writeImagesInfo = this.fjx.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fjp.u(this.mWriteImagesInfo.getChosedFiles());
                    this.fjp.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fjx.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fjq.setVisibility(0);
                    this.fjr.setVoiceModel(voiceModel);
                    this.fjw.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eH = this.aCA.eH(6);
                    if (eH != null && eH.aCM != null) {
                        eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aCA.M((View) this.aCA.eE(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fjy = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        aYe();
    }

    private void jJ(boolean z) {
        this.fju = (LinearLayout) findViewById(d.g.editbar_container);
        this.fjv = new t();
        this.fjv.jL(z);
        this.fjw = (s) this.fjv.aO(this.mContext);
        this.aCA = this.fjw.DF();
        this.fjw.b(this);
        this.fjv.b(this);
        this.fju.addView(this.aCA, new LinearLayout.LayoutParams(-1, -2));
        this.aCA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fjw.c(this);
        this.aCA.lN();
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
        jK(false);
    }

    public void jK(boolean z) {
        Intent intent = new Intent();
        if (this.fjx == null) {
            this.fjx = new PbEditorData();
        }
        this.fjx.setContent(this.fjn.getText().toString());
        this.fjx.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fjx.setVoiceModel(this.fjw.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fjx);
        if (z) {
            if (this.feQ != null && this.feQ.baQ() != null && this.feQ.baQ().bAW()) {
                showToast(this.feQ.baQ().bAY());
                this.feQ.kr(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void ql(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fjp.notifyDataSetChanged();
            }
            aYe();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qm(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fjw != null) {
            this.fjw.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        aYc();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            R(intent);
                        } else {
                            T(intent);
                        }
                        this.fjp.u(this.mWriteImagesInfo.getChosedFiles());
                        this.fjp.notifyDataSetChanged();
                        aYe();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fjn.am(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    aYc();
                    S(intent);
                    this.fjp.u(this.mWriteImagesInfo.getChosedFiles());
                    this.fjp.notifyDataSetChanged();
                    aYe();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fjn.gh(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aYc() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void R(Intent intent) {
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
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            aYc();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void S(Intent intent) {
        b(intent, false);
    }

    private void T(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            aYc();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cXg;
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
                    com.baidu.tieba.face.b.b(this.fjn);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    aYd();
                    return;
                case 14:
                    aYc();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Eb().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fjn.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fjw.setVoiceModel(voiceModel);
            this.fjq.setVisibility(0);
            this.fjr.setVoiceModel(voiceModel);
            aYe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        if (this.fjw.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aJ(com.baidu.tbadk.core.voice.a.eR(this.fjw.getVoiceModel().voiceId));
        }
        this.fjw.setVoiceModel(null);
        this.fjq.setVisibility(8);
        this.fjr.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eH = this.aCA.eH(6);
        if (eH != null && eH.aCM != null) {
            eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        aYe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYe() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fjn.getText().toString());
        boolean z4 = (this.fjw == null || this.fjw.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fjk != null) {
            this.fjk.setEnabled(z);
        }
        if (z) {
            if (this.fjk != null) {
                com.baidu.tbadk.core.util.ak.h(this.fjk, d.C0126d.cp_link_tip_a);
            }
        } else if (this.fjk != null) {
            com.baidu.tbadk.core.util.ak.h(this.fjk, d.C0126d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ak.h(this.fjn, d.C0126d.cp_cont_b);
        this.fjn.setHintTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_e));
        com.baidu.tbadk.core.util.ak.c(this.fjt, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.ak.j(this.aze, d.C0126d.cp_bg_line_c);
        if (this.feQ != null) {
            this.feQ.onChangeSkinType();
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
        if (this.feQ != null) {
            this.feQ.onDestroy();
        }
    }
}
