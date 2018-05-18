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
    private EditorTools aCB;
    private View azf;
    private VoiceManager cYn;
    public au ffX;
    private ImageView fkA;
    private LinearLayout fkB;
    private t fkC;
    private s fkD;
    private PbEditorData fkE;
    private PostWriteCallBackData fkF;
    private View fkG;
    private View fkq = null;
    private TextView fkr = null;
    private TextView fks = null;
    private EditorScrollView fkt;
    private PbFullScreenEditorInputView fku;
    private WholeDisplayGridView fkv;
    private n fkw;
    private LinearLayout fkx;
    private PlayVoiceBntNew fky;
    private LinearLayout fkz;
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
        this.cYn = new VoiceManager();
        this.cYn.onCreate(getPageContext());
        initView();
        initData();
        if (this.fkE != null && this.fkE.getEditorType() == 1 && this.fku != null) {
            this.fku.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.ffX = new au();
        if (this.fku != null) {
            this.ffX.g(this.fku);
        }
        if (this.fkF != null) {
            this.ffX.f(this.fkF);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        ard();
        this.azf = findViewById(d.g.view_line);
        this.fkt = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fkt.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.aCB.BY();
                PbFullScreenEditorActivity.this.aCB.DN();
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fku);
            }
        });
        aYb();
        this.fku = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbFullScreenEditorActivity.this.aCB.BY();
                PbFullScreenEditorActivity.this.aCB.DN();
            }
        });
        this.fku.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.aYe();
                if (PbFullScreenEditorActivity.this.ffX != null && PbFullScreenEditorActivity.this.ffX.baQ() != null) {
                    if (!PbFullScreenEditorActivity.this.ffX.baQ().bAV()) {
                        PbFullScreenEditorActivity.this.ffX.ks(false);
                    }
                    PbFullScreenEditorActivity.this.ffX.baQ().nk(false);
                }
            }
        });
        this.fkx = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fky = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fkz = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fkA = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbFullScreenEditorActivity.this.aYd();
            }
        });
        this.fkv = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fkw = new n(this.mContext);
        this.fkw.a(this);
        this.fkv.setAdapter((ListAdapter) this.fkw);
    }

    private void aYb() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fkI = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fkv) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fkI);
                    int x = ((int) motionEvent.getX()) - this.fkI[0];
                    int y = ((int) motionEvent.getY()) - this.fkI[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aCB.BY();
                        PbFullScreenEditorActivity.this.aCB.DN();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fku);
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
        this.fkG = findViewById(d.g.scroll_view_child);
        this.fkG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbFullScreenEditorActivity.this.aCB != null) {
                    PbFullScreenEditorActivity.this.aCB.BY();
                    PbFullScreenEditorActivity.this.aCB.DN();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fku);
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

    private void ard() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fkq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fks = this.mNavigationBar.setCenterTextTitle(getString(d.k.pb_reply_floor));
        com.baidu.tbadk.core.util.ak.h(this.fks, d.C0126d.cp_cont_b);
        this.fkr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fkq != null && this.fkr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fkq.getLayoutParams();
            layoutParams2.width = -2;
            this.fkq.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fkq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fkr.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds14);
            this.fkr.setLayoutParams(layoutParams3);
            this.fkr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PbFullScreenEditorActivity.this.jL(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fkE = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fkE != null) {
                jK(this.fkE.getEditorType() == 1);
                final String disableVoiceMessage = this.fkE.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aCB != null) {
                    com.baidu.tbadk.editortools.g eF = this.aCB.eF(6);
                    if (eF instanceof View) {
                        ((View) eF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fkE.getThreadData();
                if (this.fkC != null) {
                    this.fkC.setThreadData(this.mThreadData);
                }
                if (this.fkD != null) {
                    this.fkD.setThreadData(this.mThreadData);
                }
                this.fku.loadData(this.fkE.getContent());
                WriteImagesInfo writeImagesInfo = this.fkE.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fkw.u(this.mWriteImagesInfo.getChosedFiles());
                    this.fkw.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fkE.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fkx.setVisibility(0);
                    this.fky.setVoiceModel(voiceModel);
                    this.fkD.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eI = this.aCB.eI(6);
                    if (eI != null && eI.aCN != null) {
                        eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aCB.M((View) this.aCB.eF(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fkF = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        aYe();
    }

    private void jK(boolean z) {
        this.fkB = (LinearLayout) findViewById(d.g.editbar_container);
        this.fkC = new t();
        this.fkC.jM(z);
        this.fkD = (s) this.fkC.aO(this.mContext);
        this.aCB = this.fkD.DD();
        this.fkD.b(this);
        this.fkC.b(this);
        this.fkB.addView(this.aCB, new LinearLayout.LayoutParams(-1, -2));
        this.aCB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fkD.c(this);
        this.aCB.lM();
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
        jL(false);
    }

    public void jL(boolean z) {
        Intent intent = new Intent();
        if (this.fkE == null) {
            this.fkE = new PbEditorData();
        }
        this.fkE.setContent(this.fku.getText().toString());
        this.fkE.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fkE.setVoiceModel(this.fkD.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fkE);
        if (z) {
            if (this.ffX != null && this.ffX.baQ() != null && this.ffX.baQ().bAU()) {
                showToast(this.ffX.baQ().bAW());
                this.ffX.ks(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qk(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fkw.notifyDataSetChanged();
            }
            aYe();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void ql(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fkD != null) {
            this.fkD.onActivityResult(i, i2, intent);
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
                        this.fkw.u(this.mWriteImagesInfo.getChosedFiles());
                        this.fkw.notifyDataSetChanged();
                        aYe();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fku.am(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    aYc();
                    S(intent);
                    this.fkw.u(this.mWriteImagesInfo.getChosedFiles());
                    this.fkw.notifyDataSetChanged();
                    aYe();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fku.gh(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
        return this.cYn;
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
                    com.baidu.tieba.face.b.b(this.fku);
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
                    if (com.baidu.tbadk.editortools.pb.a.DZ().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fku.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fkD.setVoiceModel(voiceModel);
            this.fkx.setVisibility(0);
            this.fky.setVoiceModel(voiceModel);
            aYe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        if (this.fkD.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aJ(com.baidu.tbadk.core.voice.a.eR(this.fkD.getVoiceModel().voiceId));
        }
        this.fkD.setVoiceModel(null);
        this.fkx.setVisibility(8);
        this.fky.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eI = this.aCB.eI(6);
        if (eI != null && eI.aCN != null) {
            eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        aYe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYe() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fku.getText().toString());
        boolean z4 = (this.fkD == null || this.fkD.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fkr != null) {
            this.fkr.setEnabled(z);
        }
        if (z) {
            if (this.fkr != null) {
                com.baidu.tbadk.core.util.ak.h(this.fkr, d.C0126d.cp_link_tip_a);
            }
        } else if (this.fkr != null) {
            com.baidu.tbadk.core.util.ak.h(this.fkr, d.C0126d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ak.h(this.fku, d.C0126d.cp_cont_b);
        this.fku.setHintTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_e));
        com.baidu.tbadk.core.util.ak.c(this.fkA, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.ak.j(this.azf, d.C0126d.cp_bg_line_c);
        if (this.ffX != null) {
            this.ffX.onChangeSkinType();
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
        if (this.ffX != null) {
            this.ffX.onDestroy();
        }
    }
}
