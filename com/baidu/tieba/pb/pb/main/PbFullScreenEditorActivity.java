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
    private View boC;
    private com.baidu.tbadk.editortools.i brW;
    private VoiceManager dEk;
    public at fKY;
    private View fOX = null;
    private TextView fOY = null;
    private TextView fOZ = null;
    private EditorScrollView fPa;
    private PbFullScreenEditorInputView fPb;
    private WholeDisplayGridView fPc;
    private n fPd;
    private LinearLayout fPe;
    private PlayVoiceBntNew fPf;
    private LinearLayout fPg;
    private ImageView fPh;
    private LinearLayout fPi;
    private t fPj;
    private s fPk;
    private PbEditorData fPl;
    private PostWriteCallBackData fPm;
    private View fPn;
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
        this.dEk = new VoiceManager();
        this.dEk.onCreate(getPageContext());
        initView();
        initData();
        if (this.fPl != null && this.fPl.getEditorType() == 1 && this.fPb != null) {
            this.fPb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fKY = new at();
        if (this.fPb != null) {
            this.fKY.g(this.fPb);
        }
        if (this.fPm != null) {
            this.fKY.e(this.fPm);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        awM();
        this.boC = findViewById(d.g.view_line);
        this.fPa = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fPa.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.brW.Jl();
                PbFullScreenEditorActivity.this.brW.Ll();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fPb);
            }
        });
        bdd();
        this.fPb = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fPb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.brW.Jl();
                PbFullScreenEditorActivity.this.brW.Ll();
            }
        });
        this.fPb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bdg();
                if (PbFullScreenEditorActivity.this.fKY != null && PbFullScreenEditorActivity.this.fKY.bfS() != null) {
                    if (!PbFullScreenEditorActivity.this.fKY.bfS().bFE()) {
                        PbFullScreenEditorActivity.this.fKY.kP(false);
                    }
                    PbFullScreenEditorActivity.this.fKY.bfS().nB(false);
                }
            }
        });
        this.fPe = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fPf = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fPg = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fPh = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bdf();
            }
        });
        this.fPc = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fPd = new n(this.mContext);
        this.fPd.a(this);
        this.fPc.setAdapter((ListAdapter) this.fPd);
    }

    private void bdd() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fPp = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fPc) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fPp);
                    int x = ((int) motionEvent.getX()) - this.fPp[0];
                    int y = ((int) motionEvent.getY()) - this.fPp[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.brW.Jl();
                        PbFullScreenEditorActivity.this.brW.Ll();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPb);
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
        this.fPn = findViewById(d.g.scroll_view_child);
        this.fPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.brW != null) {
                    PbFullScreenEditorActivity.this.brW.Jl();
                    PbFullScreenEditorActivity.this.brW.Ll();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPb);
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

    private void awM() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fOX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOZ = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.r(this.fOZ, d.C0141d.cp_cont_b);
        this.fOY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fOX != null && this.fOY != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fOX.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fOX.getLayoutParams();
            layoutParams2.width = -2;
            this.fOX.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fOX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fOY.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.t(getActivity(), d.e.ds14);
            this.fOY.setLayoutParams(layoutParams3);
            this.fOY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kj(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fPl = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fPl != null) {
                ki(this.fPl.getEditorType() == 1);
                final String disableVoiceMessage = this.fPl.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.brW != null) {
                    com.baidu.tbadk.editortools.l hG = this.brW.hG(6);
                    if (hG instanceof View) {
                        ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fPl.getThreadData();
                if (this.fPj != null) {
                    this.fPj.setThreadData(this.mThreadData);
                }
                if (this.fPk != null) {
                    this.fPk.setThreadData(this.mThreadData);
                }
                this.fPb.loadData(this.fPl.getContent());
                WriteImagesInfo writeImagesInfo = this.fPl.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fPd.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fPd.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fPl.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fPe.setVisibility(0);
                    this.fPf.setVoiceModel(voiceModel);
                    this.fPk.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r hI = this.brW.hI(6);
                    if (hI != null && hI.bsj != null) {
                        hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.brW.bh((View) this.brW.hG(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fPm = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bdg();
    }

    private void ki(boolean z) {
        this.fPi = (LinearLayout) findViewById(d.g.editbar_container);
        this.fPj = new t();
        this.fPj.kk(z);
        this.fPk = (s) this.fPj.bd(this.mContext);
        this.brW = this.fPk.Lb();
        this.fPk.b(this);
        this.fPj.b(this);
        this.fPi.addView(this.brW, new LinearLayout.LayoutParams(-1, -2));
        this.brW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fPk.c(this);
        this.brW.th();
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
        kj(false);
    }

    public void kj(boolean z) {
        Intent intent = new Intent();
        if (this.fPl == null) {
            this.fPl = new PbEditorData();
        }
        this.fPl.setContent(this.fPb.getText().toString());
        this.fPl.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fPl.setVoiceModel(this.fPk.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fPl);
        if (z) {
            if (this.fKY != null && this.fKY.bfS() != null && this.fKY.bfS().bFD()) {
                showToast(this.fKY.bfS().bFF());
                this.fKY.kP(true);
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
                this.fPd.notifyDataSetChanged();
            }
            bdg();
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
        if (this.fPk != null) {
            this.fPk.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bde();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            S(intent);
                        } else {
                            U(intent);
                        }
                        this.fPd.r(this.mWriteImagesInfo.getChosedFiles());
                        this.fPd.notifyDataSetChanged();
                        bdg();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fPb.al(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bde();
                    T(intent);
                    this.fPd.r(this.mWriteImagesInfo.getChosedFiles());
                    this.fPd.notifyDataSetChanged();
                    bdg();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fPb.gq(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bde() {
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
            bde();
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
            bde();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEk;
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
                    com.baidu.tieba.face.b.b(this.fPb);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bdf();
                    return;
                case 14:
                    bde();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Lx().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fPb.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fPk.setVoiceModel(voiceModel);
            this.fPe.setVisibility(0);
            this.fPf.setVoiceModel(voiceModel);
            bdg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdf() {
        if (this.fPk.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.fPk.getVoiceModel().voiceId));
        }
        this.fPk.setVoiceModel(null);
        this.fPe.setVisibility(8);
        this.fPf.setVoiceModel(null);
        com.baidu.tbadk.editortools.r hI = this.brW.hI(6);
        if (hI != null && hI.bsj != null) {
            hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bdg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdg() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fPb.getText().toString());
        boolean z4 = (this.fPk == null || this.fPk.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fOY != null) {
            this.fOY.setEnabled(z);
        }
        if (z) {
            if (this.fOY != null) {
                com.baidu.tbadk.core.util.aj.r(this.fOY, d.C0141d.cp_link_tip_a);
            }
        } else if (this.fOY != null) {
            com.baidu.tbadk.core.util.aj.r(this.fOY, d.C0141d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.r(this.fPb, d.C0141d.cp_cont_b);
        this.fPb.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.fPh, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.t(this.boC, d.C0141d.cp_bg_line_c);
        if (this.fKY != null) {
            this.fKY.onChangeSkinType();
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
        if (this.fKY != null) {
            this.fKY.onDestroy();
        }
    }
}
