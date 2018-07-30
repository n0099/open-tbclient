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
    private View aIx;
    private EditorTools aLS;
    private VoiceManager dmp;
    private EditorScrollView fAb;
    private PbFullScreenEditorInputView fAc;
    private WholeDisplayGridView fAd;
    private n fAe;
    private LinearLayout fAf;
    private PlayVoiceBntNew fAg;
    private LinearLayout fAh;
    private ImageView fAi;
    private LinearLayout fAj;
    private u fAk;
    private t fAl;
    private PbEditorData fAm;
    private PostWriteCallBackData fAn;
    private View fAo;
    public av fvA;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private WriteImagesInfo mWriteImagesInfo;
    private View fzY = null;
    private TextView fzZ = null;
    private TextView fAa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_pb_editor_activity);
        this.dmp = new VoiceManager();
        this.dmp.onCreate(getPageContext());
        initView();
        initData();
        if (this.fAm != null && this.fAm.getEditorType() == 1 && this.fAc != null) {
            this.fAc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fvA = new av();
        if (this.fAc != null) {
            this.fvA.g(this.fAc);
        }
        if (this.fAn != null) {
            this.fvA.f(this.fAn);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        asl();
        this.aIx = findViewById(d.g.view_line);
        this.fAb = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fAb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aLS != null) {
                    PbFullScreenEditorActivity.this.aLS.FP();
                    PbFullScreenEditorActivity.this.aLS.HD();
                }
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fAc);
            }
        });
        bca();
        this.fAc = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLS != null) {
                    PbFullScreenEditorActivity.this.aLS.FP();
                    PbFullScreenEditorActivity.this.aLS.HD();
                }
            }
        });
        this.fAc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bcd();
                if (PbFullScreenEditorActivity.this.fvA != null && PbFullScreenEditorActivity.this.fvA.beQ() != null) {
                    if (!PbFullScreenEditorActivity.this.fvA.beQ().bFm()) {
                        PbFullScreenEditorActivity.this.fvA.ku(false);
                    }
                    PbFullScreenEditorActivity.this.fvA.beQ().no(false);
                }
            }
        });
        this.fAf = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fAg = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fAh = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fAi = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bcc();
            }
        });
        this.fAd = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fAe = new n(this.mContext);
        this.fAe.a(this);
        this.fAd.setAdapter((ListAdapter) this.fAe);
    }

    private void bca() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fAq = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fAd) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fAq);
                    int x = ((int) motionEvent.getX()) - this.fAq[0];
                    int y = ((int) motionEvent.getY()) - this.fAq[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aLS.FP();
                        PbFullScreenEditorActivity.this.aLS.HD();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fAc);
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
        this.fAo = findViewById(d.g.scroll_view_child);
        this.fAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLS != null) {
                    PbFullScreenEditorActivity.this.aLS.FP();
                    PbFullScreenEditorActivity.this.aLS.HD();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fAc);
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

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fzY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fAa = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.am.h(this.fAa, d.C0140d.cp_cont_b);
        this.fzZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fzY != null && this.fzZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fzY.getLayoutParams();
            layoutParams2.width = -2;
            this.fzY.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fzY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fzZ.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds14);
            this.fzZ.setLayoutParams(layoutParams3);
            this.fzZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jN(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fAm = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fAm != null) {
                jM(this.fAm.getEditorType() == 1);
                final String disableVoiceMessage = this.fAm.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aLS != null) {
                    com.baidu.tbadk.editortools.g eL = this.aLS.eL(6);
                    if (eL instanceof View) {
                        ((View) eL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fAm.getThreadData();
                if (this.fAk != null) {
                    this.fAk.setThreadData(this.mThreadData);
                }
                if (this.fAl != null) {
                    this.fAl.setThreadData(this.mThreadData);
                }
                this.fAc.loadData(this.fAm.getContent());
                WriteImagesInfo writeImagesInfo = this.fAm.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fAe.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fAe.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fAm.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fAf.setVisibility(0);
                    this.fAg.setVoiceModel(voiceModel);
                    this.fAl.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eO = this.aLS.eO(6);
                    if (eO != null && eO.aMf != null) {
                        eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aLS.N((View) this.aLS.eL(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fAn = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bcd();
    }

    private void jM(boolean z) {
        this.fAj = (LinearLayout) findViewById(d.g.editbar_container);
        this.fAk = new u();
        this.fAk.jO(z);
        this.fAl = (t) this.fAk.aZ(this.mContext);
        this.aLS = this.fAl.Ht();
        this.fAl.b(this);
        this.fAk.b(this);
        this.fAj.addView(this.aLS, new LinearLayout.LayoutParams(-1, -2));
        this.aLS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fAl.c(this);
        this.aLS.oF();
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
        jN(false);
    }

    public void jN(boolean z) {
        Intent intent = new Intent();
        if (this.fAm == null) {
            this.fAm = new PbEditorData();
        }
        this.fAm.setContent(this.fAc.getText().toString());
        this.fAm.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fAm.setVoiceModel(this.fAl.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fAm);
        if (z) {
            if (this.fvA != null && this.fvA.beQ() != null && this.fvA.beQ().bFl()) {
                showToast(this.fvA.beQ().bFn());
                this.fvA.ku(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qA(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fAe.notifyDataSetChanged();
            }
            bcd();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qB(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fAl != null) {
            this.fAl.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bcb();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            R(intent);
                        } else {
                            T(intent);
                        }
                        this.fAe.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fAe.notifyDataSetChanged();
                        bcd();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fAc.ao(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bcb();
                    S(intent);
                    this.fAe.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fAe.notifyDataSetChanged();
                    bcd();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fAc.gG(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bcb() {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ah(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aj(this.mContext)));
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
            bcb();
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
            bcb();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmp;
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
                    com.baidu.tieba.face.b.b(this.fAc);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bcc();
                    return;
                case 14:
                    bcb();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.HP().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fAc.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fAl.setVoiceModel(voiceModel);
            this.fAf.setVisibility(0);
            this.fAg.setVoiceModel(voiceModel);
            bcd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcc() {
        if (this.fAl.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fAl.getVoiceModel().voiceId));
        }
        this.fAl.setVoiceModel(null);
        this.fAf.setVisibility(8);
        this.fAg.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eO = this.aLS.eO(6);
        if (eO != null && eO.aMf != null) {
            eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bcd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fAc.getText().toString());
        boolean z4 = (this.fAl == null || this.fAl.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fzZ != null) {
            this.fzZ.setEnabled(z);
        }
        if (z) {
            if (this.fzZ != null) {
                com.baidu.tbadk.core.util.am.h(this.fzZ, d.C0140d.cp_link_tip_a);
            }
        } else if (this.fzZ != null) {
            com.baidu.tbadk.core.util.am.h(this.fzZ, d.C0140d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.h(this.fAc, d.C0140d.cp_cont_b);
        this.fAc.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.fAi, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.j(this.aIx, d.C0140d.cp_bg_line_c);
        if (this.fvA != null) {
            this.fvA.onChangeSkinType();
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
        if (this.fvA != null) {
            this.fvA.onDestroy();
        }
    }
}
