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
    private View bmB;
    private com.baidu.tbadk.editortools.i bpW;
    private VoiceManager dBC;
    public au fHZ;
    private View fLZ = null;
    private TextView fMa = null;
    private TextView fMb = null;
    private EditorScrollView fMc;
    private PbFullScreenEditorInputView fMd;
    private WholeDisplayGridView fMe;
    private p fMf;
    private LinearLayout fMg;
    private PlayVoiceBntNew fMh;
    private LinearLayout fMi;
    private ImageView fMj;
    private LinearLayout fMk;
    private u fMl;
    private t fMm;
    private PbEditorData fMn;
    private PostWriteCallBackData fMo;
    private View fMp;
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
        this.dBC = new VoiceManager();
        this.dBC.onCreate(getPageContext());
        initView();
        initData();
        if (this.fMn != null && this.fMn.getEditorType() == 1 && this.fMd != null) {
            this.fMd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fHZ = new au();
        if (this.fMd != null) {
            this.fHZ.g(this.fMd);
        }
        if (this.fMo != null) {
            this.fHZ.e(this.fMo);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        avQ();
        this.bmB = findViewById(d.g.view_line);
        this.fMc = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fMc.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.bpW.IG();
                PbFullScreenEditorActivity.this.bpW.KG();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fMd);
            }
        });
        bbC();
        this.fMd = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bpW.IG();
                PbFullScreenEditorActivity.this.bpW.KG();
            }
        });
        this.fMd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bbF();
                if (PbFullScreenEditorActivity.this.fHZ != null && PbFullScreenEditorActivity.this.fHZ.bet() != null) {
                    if (!PbFullScreenEditorActivity.this.fHZ.bet().bER()) {
                        PbFullScreenEditorActivity.this.fHZ.kG(false);
                    }
                    PbFullScreenEditorActivity.this.fHZ.bet().nt(false);
                }
            }
        });
        this.fMg = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fMh = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fMi = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fMj = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fMi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bbE();
            }
        });
        this.fMe = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fMf = new p(this.mContext);
        this.fMf.a(this);
        this.fMe.setAdapter((ListAdapter) this.fMf);
    }

    private void bbC() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fMr = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fMe) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fMr);
                    int x = ((int) motionEvent.getX()) - this.fMr[0];
                    int y = ((int) motionEvent.getY()) - this.fMr[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.bpW.IG();
                        PbFullScreenEditorActivity.this.bpW.KG();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fMd);
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
        this.fMp = findViewById(d.g.scroll_view_child);
        this.fMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.bpW != null) {
                    PbFullScreenEditorActivity.this.bpW.IG();
                    PbFullScreenEditorActivity.this.bpW.KG();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fMd);
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

    private void avQ() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fLZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fMb = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.r(this.fMb, d.C0108d.cp_cont_b);
        this.fMa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fLZ != null && this.fMa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fLZ.getLayoutParams();
            layoutParams2.width = -2;
            this.fLZ.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fMa.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(getActivity(), d.e.ds14);
            this.fMa.setLayoutParams(layoutParams3);
            this.fMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jZ(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fMn = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fMn != null) {
                jY(this.fMn.getEditorType() == 1);
                final String disableVoiceMessage = this.fMn.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.bpW != null) {
                    com.baidu.tbadk.editortools.l hH = this.bpW.hH(6);
                    if (hH instanceof View) {
                        ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fMn.getThreadData();
                if (this.fMl != null) {
                    this.fMl.setThreadData(this.mThreadData);
                }
                if (this.fMm != null) {
                    this.fMm.setThreadData(this.mThreadData);
                }
                this.fMd.loadData(this.fMn.getContent());
                WriteImagesInfo writeImagesInfo = this.fMn.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fMf.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fMf.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fMn.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fMg.setVisibility(0);
                    this.fMh.setVoiceModel(voiceModel);
                    this.fMm.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r hJ = this.bpW.hJ(6);
                    if (hJ != null && hJ.bqj != null) {
                        hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.bpW.bh((View) this.bpW.hH(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fMo = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bbF();
    }

    private void jY(boolean z) {
        this.fMk = (LinearLayout) findViewById(d.g.editbar_container);
        this.fMl = new u();
        this.fMl.ka(z);
        this.fMm = (t) this.fMl.be(this.mContext);
        this.bpW = this.fMm.Kw();
        this.fMm.b(this);
        this.fMl.b(this);
        this.fMk.addView(this.bpW, new LinearLayout.LayoutParams(-1, -2));
        this.bpW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fMm.c(this);
        this.bpW.ti();
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
        jZ(false);
    }

    public void jZ(boolean z) {
        Intent intent = new Intent();
        if (this.fMn == null) {
            this.fMn = new PbEditorData();
        }
        this.fMn.setContent(this.fMd.getText().toString());
        this.fMn.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fMn.setVoiceModel(this.fMm.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fMn);
        if (z) {
            if (this.fHZ != null && this.fHZ.bet() != null && this.fHZ.bet().bEQ()) {
                showToast(this.fHZ.bet().bES());
                this.fHZ.kG(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sL(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fMf.notifyDataSetChanged();
            }
            bbF();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void sM(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fMm != null) {
            this.fMm.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bbD();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            U(intent);
                        } else {
                            W(intent);
                        }
                        this.fMf.r(this.mWriteImagesInfo.getChosedFiles());
                        this.fMf.notifyDataSetChanged();
                        bbF();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fMd.ak(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bbD();
                    V(intent);
                    this.fMf.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fMf.notifyDataSetChanged();
                    bbF();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fMd.gg(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bbD() {
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
            bbD();
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
            bbD();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBC;
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
                    com.baidu.tieba.face.b.b(this.fMd);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bbE();
                    return;
                case 14:
                    bbD();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.KR().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fMd.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fMm.setVoiceModel(voiceModel);
            this.fMg.setVisibility(0);
            this.fMh.setVoiceModel(voiceModel);
            bbF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbE() {
        if (this.fMm.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eN(this.fMm.getVoiceModel().voiceId));
        }
        this.fMm.setVoiceModel(null);
        this.fMg.setVisibility(8);
        this.fMh.setVoiceModel(null);
        com.baidu.tbadk.editortools.r hJ = this.bpW.hJ(6);
        if (hJ != null && hJ.bqj != null) {
            hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bbF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbF() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fMd.getText().toString());
        boolean z4 = (this.fMm == null || this.fMm.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fMa != null) {
            this.fMa.setEnabled(z);
        }
        if (z) {
            if (this.fMa != null) {
                com.baidu.tbadk.core.util.aj.r(this.fMa, d.C0108d.cp_link_tip_a);
            }
        } else if (this.fMa != null) {
            com.baidu.tbadk.core.util.aj.r(this.fMa, d.C0108d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.r(this.fMd, d.C0108d.cp_cont_b);
        this.fMd.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.fMj, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.t(this.bmB, d.C0108d.cp_bg_line_c);
        if (this.fHZ != null) {
            this.fHZ.onChangeSkinType();
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
        if (this.fHZ != null) {
            this.fHZ.onDestroy();
        }
    }
}
