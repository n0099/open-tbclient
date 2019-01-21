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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools aYK;
    private VoiceManager dLA;
    public at fWS;
    private View gbh = null;
    private TextView gbi = null;
    private TextView gbj = null;
    private EditorScrollView gbk;
    private PbFullScreenEditorInputView gbl;
    private WholeDisplayGridView gbm;
    private n gbn;
    private LinearLayout gbo;
    private PlayVoiceBntNew gbp;
    private LinearLayout gbq;
    private ImageView gbr;
    private LinearLayout gbs;
    private u gbt;
    private t gbu;
    private PbEditorData gbv;
    private PostWriteCallBackData gbw;
    private View gbx;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(e.h.layout_pb_editor_activity);
        this.dLA = new VoiceManager();
        this.dLA.onCreate(getPageContext());
        initView();
        initData();
        if (this.gbv != null && this.gbv.getEditorType() == 1 && this.gbl != null) {
            this.gbl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fWS = new at();
        if (this.gbl != null) {
            this.fWS.g(this.gbl);
        }
        if (this.gbw != null) {
            this.fWS.f(this.gbw);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        azR();
        this.mTopLine = findViewById(e.g.view_line);
        this.gbk = (EditorScrollView) findViewById(e.g.scroll_view);
        this.gbk.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aYK != null) {
                    PbFullScreenEditorActivity.this.aYK.KM();
                    PbFullScreenEditorActivity.this.aYK.Mz();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.gbl);
            }
        });
        bkm();
        this.gbl = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.gbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aYK != null) {
                    PbFullScreenEditorActivity.this.aYK.KM();
                    PbFullScreenEditorActivity.this.aYK.Mz();
                }
            }
        });
        this.gbl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bkp();
                if (PbFullScreenEditorActivity.this.fWS != null && PbFullScreenEditorActivity.this.fWS.bng() != null) {
                    if (!PbFullScreenEditorActivity.this.fWS.bng().bOw()) {
                        PbFullScreenEditorActivity.this.fWS.lA(false);
                    }
                    PbFullScreenEditorActivity.this.fWS.bng().ov(false);
                }
            }
        });
        this.gbo = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.gbp = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.gbq = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.gbr = (ImageView) findViewById(e.g.iv_delete_voice);
        this.gbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bko();
            }
        });
        this.gbm = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.gbn = new n(this.mContext);
        this.gbn.a(this);
        this.gbm.setAdapter((ListAdapter) this.gbn);
    }

    private void bkm() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] gbz = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.gbm) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.gbz);
                    int x = ((int) motionEvent.getX()) - this.gbz[0];
                    int y = ((int) motionEvent.getY()) - this.gbz[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aYK.KM();
                        PbFullScreenEditorActivity.this.aYK.Mz();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.gbl);
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
        this.gbx = findViewById(e.g.scroll_view_child);
        this.gbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aYK != null) {
                    PbFullScreenEditorActivity.this.aYK.KM();
                    PbFullScreenEditorActivity.this.aYK.Mz();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.gbl);
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

    private void azR() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.gbh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gbj = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.gbj, e.d.cp_cont_b);
        this.gbi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.gbh != null && this.gbi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gbh.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gbh.getLayoutParams();
            layoutParams2.width = -2;
            this.gbh.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.gbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.gbi.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds14);
            this.gbi.setLayoutParams(layoutParams3);
            this.gbi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kV(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.gbv = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.gbv != null) {
                kU(this.gbv.getEditorType() == 1);
                final String disableVoiceMessage = this.gbv.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aYK != null) {
                    com.baidu.tbadk.editortools.g fI = this.aYK.fI(6);
                    if (fI instanceof View) {
                        ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.gbv.getThreadData();
                if (this.gbt != null) {
                    this.gbt.setThreadData(this.mThreadData);
                }
                if (this.gbu != null) {
                    this.gbu.setThreadData(this.mThreadData);
                }
                this.gbl.loadData(this.gbv.getContent());
                WriteImagesInfo writeImagesInfo = this.gbv.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.gbn.s(this.mWriteImagesInfo.getChosedFiles());
                    this.gbn.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.gbv.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.gbo.setVisibility(0);
                    this.gbp.setVoiceModel(voiceModel);
                    this.gbu.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k fL = this.aYK.fL(6);
                    if (fL != null && fL.aYW != null) {
                        fL.aYW.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aYK.aa((View) this.aYK.fI(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.gbw = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bkp();
    }

    private void kU(boolean z) {
        this.gbs = (LinearLayout) findViewById(e.g.editbar_container);
        this.gbt = new u();
        this.gbt.kW(z);
        this.gbu = (t) this.gbt.bM(this.mContext);
        this.aYK = this.gbu.Mp();
        this.gbu.b(this);
        this.gbt.b(this);
        this.gbs.addView(this.aYK, new LinearLayout.LayoutParams(-1, -2));
        this.aYK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gbu.c(this);
        this.aYK.pR();
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
        kV(false);
    }

    public void kV(boolean z) {
        Intent intent = new Intent();
        if (this.gbv == null) {
            this.gbv = new PbEditorData();
        }
        this.gbv.setContent(this.gbl.getText().toString());
        this.gbv.setWriteImagesInfo(this.mWriteImagesInfo);
        this.gbv.setVoiceModel(this.gbu.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.gbv);
        if (z) {
            if (this.fWS != null && this.fWS.bng() != null && this.fWS.bng().bOv()) {
                showToast(this.fWS.bng().bOx());
                this.fWS.lA(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sB(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.gbn.notifyDataSetChanged();
            }
            bkp();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sC(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.gbu != null) {
            this.gbu.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bkn();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            V(intent);
                        } else {
                            X(intent);
                        }
                        this.gbn.s(this.mWriteImagesInfo.getChosedFiles());
                        this.gbn.notifyDataSetChanged();
                        bkp();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.gbl.an(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bkn();
                    W(intent);
                    this.gbn.s(this.mWriteImagesInfo.getChosedFiles());
                    this.gbn.notifyDataSetChanged();
                    bkp();
                    return;
                case 25004:
                    if (intent != null) {
                        this.gbl.hY(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bkn() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void V(Intent intent) {
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
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bkn();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void W(Intent intent) {
        b(intent, false);
    }

    private void X(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bkn();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dLA;
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
                    com.baidu.tieba.face.b.b(this.gbl);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bko();
                    return;
                case 14:
                    bkn();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.ML().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        this.gbl.b((com.baidu.tbadk.coreExtra.data.p) aVar.data);
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
            this.gbu.setVoiceModel(voiceModel);
            this.gbo.setVisibility(0);
            this.gbp.setVoiceModel(voiceModel);
            bkp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        if (this.gbu.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.gbu.getVoiceModel().voiceId));
        }
        this.gbu.setVoiceModel(null);
        this.gbo.setVisibility(8);
        this.gbp.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fL = this.aYK.fL(6);
        if (fL != null && fL.aYW != null) {
            fL.aYW.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bkp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.gbl.getText().toString());
        boolean z4 = (this.gbu == null || this.gbu.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.gbi != null) {
            this.gbi.setEnabled(z);
        }
        if (z) {
            if (this.gbi != null) {
                com.baidu.tbadk.core.util.al.h(this.gbi, e.d.cp_link_tip_a);
            }
        } else if (this.gbi != null) {
            com.baidu.tbadk.core.util.al.h(this.gbi, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.gbl, e.d.cp_cont_b);
        this.gbl.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.gbr, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fWS != null) {
            this.fWS.onChangeSkinType();
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
        if (this.fWS != null) {
            this.fWS.onDestroy();
        }
    }
}
