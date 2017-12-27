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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private View bmk;
    private com.baidu.tbadk.editortools.i bpE;
    private VoiceManager dwG;
    public au fGe;
    private View fKe = null;
    private TextView fKf = null;
    private TextView fKg = null;
    private EditorScrollView fKh;
    private PbFullScreenEditorInputView fKi;
    private WholeDisplayGridView fKj;
    private p fKk;
    private LinearLayout fKl;
    private PlayVoiceBntNew fKm;
    private LinearLayout fKn;
    private ImageView fKo;
    private LinearLayout fKp;
    private u fKq;
    private t fKr;
    private PbEditorData fKs;
    private PostWriteCallBackData fKt;
    private View fKu;
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
        setContentView(d.h.layout_pb_editor_activity);
        this.dwG = new VoiceManager();
        this.dwG.onCreate(getPageContext());
        initView();
        initData();
        if (this.fKs != null && this.fKs.getEditorType() == 1 && this.fKi != null) {
            this.fKi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fGe = new au();
        if (this.fKi != null) {
            this.fGe.g(this.fKi);
        }
        if (this.fKt != null) {
            this.fGe.e(this.fKt);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        auI();
        this.bmk = findViewById(d.g.view_line);
        this.fKh = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fKh.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.bpE.IP();
                PbFullScreenEditorActivity.this.bpE.KP();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fKi);
            }
        });
        bbt();
        this.fKi = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bpE.IP();
                PbFullScreenEditorActivity.this.bpE.KP();
            }
        });
        this.fKi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bbw();
                if (PbFullScreenEditorActivity.this.fGe != null && PbFullScreenEditorActivity.this.fGe.bek() != null) {
                    if (!PbFullScreenEditorActivity.this.fGe.bek().bLp()) {
                        PbFullScreenEditorActivity.this.fGe.kC(false);
                    }
                    PbFullScreenEditorActivity.this.fGe.bek().oo(false);
                }
            }
        });
        this.fKl = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fKm = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fKn = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fKo = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bbv();
            }
        });
        this.fKj = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fKk = new p(this.mContext);
        this.fKk.a(this);
        this.fKj.setAdapter((ListAdapter) this.fKk);
    }

    private void bbt() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fKw = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fKj) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fKw);
                    int x = ((int) motionEvent.getX()) - this.fKw[0];
                    int y = ((int) motionEvent.getY()) - this.fKw[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.bpE.IP();
                        PbFullScreenEditorActivity.this.bpE.KP();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fKi);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.a(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.fKu = findViewById(d.g.scroll_view_child);
        this.fKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.bpE != null) {
                    PbFullScreenEditorActivity.this.bpE.IP();
                    PbFullScreenEditorActivity.this.bpE.KP();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fKi);
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

    private void auI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fKe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fKg = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.r(this.fKg, d.C0108d.cp_cont_b);
        this.fKf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fKe != null && this.fKf != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKe.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKe.getLayoutParams();
            layoutParams2.width = -2;
            this.fKe.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fKf.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds14);
            this.fKf.setLayoutParams(layoutParams3);
            this.fKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jU(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fKs = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fKs != null) {
                jT(this.fKs.getEditorType() == 1);
                final String disableVoiceMessage = this.fKs.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.bpE != null) {
                    com.baidu.tbadk.editortools.l hL = this.bpE.hL(6);
                    if (hL instanceof View) {
                        ((View) hL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fKs.getThreadData();
                if (this.fKq != null) {
                    this.fKq.setThreadData(this.mThreadData);
                }
                if (this.fKr != null) {
                    this.fKr.setThreadData(this.mThreadData);
                }
                this.fKi.loadData(this.fKs.getContent());
                WriteImagesInfo writeImagesInfo = this.fKs.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fKk.q(this.mWriteImagesInfo.getChosedFiles());
                    this.fKk.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fKs.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fKl.setVisibility(0);
                    this.fKm.setVoiceModel(voiceModel);
                    this.fKr.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r hN = this.bpE.hN(6);
                    if (hN != null && hN.bpR != null) {
                        hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.bpE.bf((View) this.bpE.hL(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fKt = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bbw();
    }

    private void jT(boolean z) {
        this.fKp = (LinearLayout) findViewById(d.g.editbar_container);
        this.fKq = new u();
        this.fKq.jV(z);
        this.fKr = (t) this.fKq.bh(this.mContext);
        this.bpE = this.fKr.KF();
        this.fKr.d(this);
        this.fKq.b(this);
        this.fKp.addView(this.bpE, new LinearLayout.LayoutParams(-1, -2));
        this.bpE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fKr.e(this);
        this.bpE.th();
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
        jU(false);
    }

    public void jU(boolean z) {
        Intent intent = new Intent();
        if (this.fKs == null) {
            this.fKs = new PbEditorData();
        }
        this.fKs.setContent(this.fKi.getText().toString());
        this.fKs.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fKs.setVoiceModel(this.fKr.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fKs);
        if (z) {
            if (this.fGe != null && this.fGe.bek() != null && this.fGe.bek().bLo()) {
                showToast(this.fGe.bek().bLq());
                this.fGe.kC(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sS(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fKk.notifyDataSetChanged();
            }
            bbw();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sT(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fKr != null) {
            this.fKr.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bbu();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            U(intent);
                        } else {
                            W(intent);
                        }
                        this.fKk.q(this.mWriteImagesInfo.getChosedFiles());
                        this.fKk.notifyDataSetChanged();
                        bbw();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fKi.ak(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bbu();
                    V(intent);
                    this.fKk.q(this.mWriteImagesInfo.getChosedFiles());
                    this.fKk.notifyDataSetChanged();
                    bbw();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fKi.fY(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bbu() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void U(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ao(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aq(this.mContext)));
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
            bbu();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void V(Intent intent) {
        b(intent, false);
    }

    private void W(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bbu();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dwG;
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
                    com.baidu.tieba.face.b.b(this.fKi);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bbv();
                    return;
                case 14:
                    bbu();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.La().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fKi.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fKr.setVoiceModel(voiceModel);
            this.fKl.setVisibility(0);
            this.fKm.setVoiceModel(voiceModel);
            bbw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        if (this.fKr.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eG(this.fKr.getVoiceModel().voiceId));
        }
        this.fKr.setVoiceModel(null);
        this.fKl.setVisibility(8);
        this.fKm.setVoiceModel(null);
        com.baidu.tbadk.editortools.r hN = this.bpE.hN(6);
        if (hN != null && hN.bpR != null) {
            hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bbw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbw() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fKi.getText().toString());
        boolean z4 = (this.fKr == null || this.fKr.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fKf != null) {
            this.fKf.setEnabled(z);
        }
        if (z) {
            if (this.fKf != null) {
                com.baidu.tbadk.core.util.aj.r(this.fKf, d.C0108d.cp_link_tip_a);
            }
        } else if (this.fKf != null) {
            com.baidu.tbadk.core.util.aj.r(this.fKf, d.C0108d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.r(this.fKi, d.C0108d.cp_cont_b);
        this.fKi.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.fKo, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.t(this.bmk, d.C0108d.cp_bg_line_c);
        if (this.fGe != null) {
            this.fGe.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.a(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fGe != null) {
            this.fGe.onDestroy();
        }
    }
}
