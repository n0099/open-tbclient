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
    private View boF;
    private com.baidu.tbadk.editortools.i brZ;
    private VoiceManager dEn;
    public at fLo;
    private s fPA;
    private PbEditorData fPB;
    private PostWriteCallBackData fPC;
    private View fPD;
    private View fPn = null;
    private TextView fPo = null;
    private TextView fPp = null;
    private EditorScrollView fPq;
    private PbFullScreenEditorInputView fPr;
    private WholeDisplayGridView fPs;
    private n fPt;
    private LinearLayout fPu;
    private PlayVoiceBntNew fPv;
    private LinearLayout fPw;
    private ImageView fPx;
    private LinearLayout fPy;
    private t fPz;
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
        this.dEn = new VoiceManager();
        this.dEn.onCreate(getPageContext());
        initView();
        initData();
        if (this.fPB != null && this.fPB.getEditorType() == 1 && this.fPr != null) {
            this.fPr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fLo = new at();
        if (this.fPr != null) {
            this.fLo.g(this.fPr);
        }
        if (this.fPC != null) {
            this.fLo.e(this.fPC);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        awO();
        this.boF = findViewById(d.g.view_line);
        this.fPq = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fPq.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.brZ.Jm();
                PbFullScreenEditorActivity.this.brZ.Lm();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fPr);
            }
        });
        bde();
        this.fPr = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.brZ.Jm();
                PbFullScreenEditorActivity.this.brZ.Lm();
            }
        });
        this.fPr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bdh();
                if (PbFullScreenEditorActivity.this.fLo != null && PbFullScreenEditorActivity.this.fLo.bfT() != null) {
                    if (!PbFullScreenEditorActivity.this.fLo.bfT().bFJ()) {
                        PbFullScreenEditorActivity.this.fLo.kU(false);
                    }
                    PbFullScreenEditorActivity.this.fLo.bfT().nG(false);
                }
            }
        });
        this.fPu = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fPv = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fPw = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fPx = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fPw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bdg();
            }
        });
        this.fPs = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fPt = new n(this.mContext);
        this.fPt.a(this);
        this.fPs.setAdapter((ListAdapter) this.fPt);
    }

    private void bde() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fPF = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fPs) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fPF);
                    int x = ((int) motionEvent.getX()) - this.fPF[0];
                    int y = ((int) motionEvent.getY()) - this.fPF[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.brZ.Jm();
                        PbFullScreenEditorActivity.this.brZ.Lm();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPr);
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
        this.fPD = findViewById(d.g.scroll_view_child);
        this.fPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.brZ != null) {
                    PbFullScreenEditorActivity.this.brZ.Jm();
                    PbFullScreenEditorActivity.this.brZ.Lm();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPr);
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

    private void awO() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fPn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPp = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.r(this.fPp, d.C0141d.cp_cont_b);
        this.fPo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fPn != null && this.fPo != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPn.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fPn.getLayoutParams();
            layoutParams2.width = -2;
            this.fPn.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fPo.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds14);
            this.fPo.setLayoutParams(layoutParams3);
            this.fPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.ko(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fPB = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fPB != null) {
                kn(this.fPB.getEditorType() == 1);
                final String disableVoiceMessage = this.fPB.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.brZ != null) {
                    com.baidu.tbadk.editortools.l hG = this.brZ.hG(6);
                    if (hG instanceof View) {
                        ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fPB.getThreadData();
                if (this.fPz != null) {
                    this.fPz.setThreadData(this.mThreadData);
                }
                if (this.fPA != null) {
                    this.fPA.setThreadData(this.mThreadData);
                }
                this.fPr.loadData(this.fPB.getContent());
                WriteImagesInfo writeImagesInfo = this.fPB.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fPt.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fPt.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fPB.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fPu.setVisibility(0);
                    this.fPv.setVoiceModel(voiceModel);
                    this.fPA.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r hI = this.brZ.hI(6);
                    if (hI != null && hI.bsm != null) {
                        hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.brZ.bh((View) this.brZ.hG(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fPC = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bdh();
    }

    private void kn(boolean z) {
        this.fPy = (LinearLayout) findViewById(d.g.editbar_container);
        this.fPz = new t();
        this.fPz.kp(z);
        this.fPA = (s) this.fPz.bd(this.mContext);
        this.brZ = this.fPA.Lc();
        this.fPA.b(this);
        this.fPz.b(this);
        this.fPy.addView(this.brZ, new LinearLayout.LayoutParams(-1, -2));
        this.brZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fPA.c(this);
        this.brZ.th();
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
        ko(false);
    }

    public void ko(boolean z) {
        Intent intent = new Intent();
        if (this.fPB == null) {
            this.fPB = new PbEditorData();
        }
        this.fPB.setContent(this.fPr.getText().toString());
        this.fPB.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fPB.setVoiceModel(this.fPA.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fPB);
        if (z) {
            if (this.fLo != null && this.fLo.bfT() != null && this.fLo.bfT().bFI()) {
                showToast(this.fLo.bfT().bFK());
                this.fLo.kU(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sP(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fPt.notifyDataSetChanged();
            }
            bdh();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void sQ(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fPA != null) {
            this.fPA.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bdf();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            S(intent);
                        } else {
                            U(intent);
                        }
                        this.fPt.r(this.mWriteImagesInfo.getChosedFiles());
                        this.fPt.notifyDataSetChanged();
                        bdh();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fPr.al(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bdf();
                    T(intent);
                    this.fPt.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fPt.notifyDataSetChanged();
                    bdh();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fPr.gq(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bdf() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void S(Intent intent) {
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
            bdf();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void T(Intent intent) {
        b(intent, false);
    }

    private void U(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bdf();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEn;
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
                    com.baidu.tieba.face.b.b(this.fPr);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bdg();
                    return;
                case 14:
                    bdf();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Ly().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fPr.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fPA.setVoiceModel(voiceModel);
            this.fPu.setVisibility(0);
            this.fPv.setVoiceModel(voiceModel);
            bdh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdg() {
        if (this.fPA.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.fPA.getVoiceModel().voiceId));
        }
        this.fPA.setVoiceModel(null);
        this.fPu.setVisibility(8);
        this.fPv.setVoiceModel(null);
        com.baidu.tbadk.editortools.r hI = this.brZ.hI(6);
        if (hI != null && hI.bsm != null) {
            hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bdh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdh() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fPr.getText().toString());
        boolean z4 = (this.fPA == null || this.fPA.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fPo != null) {
            this.fPo.setEnabled(z);
        }
        if (z) {
            if (this.fPo != null) {
                com.baidu.tbadk.core.util.aj.r(this.fPo, d.C0141d.cp_link_tip_a);
            }
        } else if (this.fPo != null) {
            com.baidu.tbadk.core.util.aj.r(this.fPo, d.C0141d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.r(this.fPr, d.C0141d.cp_cont_b);
        this.fPr.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.fPx, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.t(this.boF, d.C0141d.cp_bg_line_c);
        if (this.fLo != null) {
            this.fLo.onChangeSkinType();
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
        if (this.fLo != null) {
            this.fLo.onDestroy();
        }
    }
}
