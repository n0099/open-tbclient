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
    private EditorTools aTJ;
    private VoiceManager dAm;
    public at fKM;
    private View fPb = null;
    private TextView fPc = null;
    private TextView fPd = null;
    private EditorScrollView fPe;
    private PbFullScreenEditorInputView fPf;
    private WholeDisplayGridView fPg;
    private n fPh;
    private LinearLayout fPi;
    private PlayVoiceBntNew fPj;
    private LinearLayout fPk;
    private ImageView fPl;
    private LinearLayout fPm;
    private u fPn;
    private t fPo;
    private PbEditorData fPp;
    private PostWriteCallBackData fPq;
    private View fPr;
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
        this.dAm = new VoiceManager();
        this.dAm.onCreate(getPageContext());
        initView();
        initData();
        if (this.fPp != null && this.fPp.getEditorType() == 1 && this.fPf != null) {
            this.fPf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fKM = new at();
        if (this.fPf != null) {
            this.fKM.g(this.fPf);
        }
        if (this.fPq != null) {
            this.fKM.f(this.fPq);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        axv();
        this.mTopLine = findViewById(e.g.view_line);
        this.fPe = (EditorScrollView) findViewById(e.g.scroll_view);
        this.fPe.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fPf);
            }
        });
        bhI();
        this.fPf = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.fPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
            }
        });
        this.fPf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bhL();
                if (PbFullScreenEditorActivity.this.fKM != null && PbFullScreenEditorActivity.this.fKM.bkx() != null) {
                    if (!PbFullScreenEditorActivity.this.fKM.bkx().bLt()) {
                        PbFullScreenEditorActivity.this.fKM.lj(false);
                    }
                    PbFullScreenEditorActivity.this.fKM.bkx().ob(false);
                }
            }
        });
        this.fPi = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fPj = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fPk = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.fPl = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bhK();
            }
        });
        this.fPg = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.fPh = new n(this.mContext);
        this.fPh.a(this);
        this.fPg.setAdapter((ListAdapter) this.fPh);
    }

    private void bhI() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fPt = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fPg) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fPt);
                    int x = ((int) motionEvent.getX()) - this.fPt[0];
                    int y = ((int) motionEvent.getY()) - this.fPt[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aTJ.Jg();
                        PbFullScreenEditorActivity.this.aTJ.KR();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPf);
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
        this.fPr = findViewById(e.g.scroll_view_child);
        this.fPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPf);
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

    private void axv() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fPb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPd = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.fPd, e.d.cp_cont_b);
        this.fPc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fPb != null && this.fPc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPb.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fPb.getLayoutParams();
            layoutParams2.width = -2;
            this.fPb.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.fPb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fPc.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds14);
            this.fPc.setLayoutParams(layoutParams3);
            this.fPc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kE(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fPp = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fPp != null) {
                kD(this.fPp.getEditorType() == 1);
                final String disableVoiceMessage = this.fPp.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aTJ != null) {
                    com.baidu.tbadk.editortools.g ff = this.aTJ.ff(6);
                    if (ff instanceof View) {
                        ((View) ff).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fPp.getThreadData();
                if (this.fPn != null) {
                    this.fPn.setThreadData(this.mThreadData);
                }
                if (this.fPo != null) {
                    this.fPo.setThreadData(this.mThreadData);
                }
                this.fPf.loadData(this.fPp.getContent());
                WriteImagesInfo writeImagesInfo = this.fPp.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fPh.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fPh.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fPp.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fPi.setVisibility(0);
                    this.fPj.setVoiceModel(voiceModel);
                    this.fPo.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k fi = this.aTJ.fi(6);
                    if (fi != null && fi.aTV != null) {
                        fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aTJ.aa((View) this.aTJ.ff(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fPq = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bhL();
    }

    private void kD(boolean z) {
        this.fPm = (LinearLayout) findViewById(e.g.editbar_container);
        this.fPn = new u();
        this.fPn.kF(z);
        this.fPo = (t) this.fPn.bM(this.mContext);
        this.aTJ = this.fPo.KH();
        this.fPo.b(this);
        this.fPn.b(this);
        this.fPm.addView(this.aTJ, new LinearLayout.LayoutParams(-1, -2));
        this.aTJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fPo.c(this);
        this.aTJ.pQ();
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
        kE(false);
    }

    public void kE(boolean z) {
        Intent intent = new Intent();
        if (this.fPp == null) {
            this.fPp = new PbEditorData();
        }
        this.fPp.setContent(this.fPf.getText().toString());
        this.fPp.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fPp.setVoiceModel(this.fPo.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fPp);
        if (z) {
            if (this.fKM != null && this.fKM.bkx() != null && this.fKM.bkx().bLs()) {
                showToast(this.fKM.bkx().bLu());
                this.fKM.lj(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void rx(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fPh.notifyDataSetChanged();
            }
            bhL();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void ry(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fPo != null) {
            this.fPo.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bhJ();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            V(intent);
                        } else {
                            X(intent);
                        }
                        this.fPh.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fPh.notifyDataSetChanged();
                        bhL();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fPf.ao(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bhJ();
                    W(intent);
                    this.fPh.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fPh.notifyDataSetChanged();
                    bhL();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fPf.hq(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bhJ() {
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
            bhJ();
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
            bhJ();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dAm;
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
                    com.baidu.tieba.face.b.b(this.fPf);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bhK();
                    return;
                case 14:
                    bhJ();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Ld().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.o) {
                        this.fPf.b((com.baidu.tbadk.coreExtra.data.o) aVar.data);
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
            this.fPo.setVoiceModel(voiceModel);
            this.fPi.setVisibility(0);
            this.fPj.setVoiceModel(voiceModel);
            bhL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhK() {
        if (this.fPo.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fPo.getVoiceModel().voiceId));
        }
        this.fPo.setVoiceModel(null);
        this.fPi.setVisibility(8);
        this.fPj.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fi = this.aTJ.fi(6);
        if (fi != null && fi.aTV != null) {
            fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bhL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhL() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fPf.getText().toString());
        boolean z4 = (this.fPo == null || this.fPo.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fPc != null) {
            this.fPc.setEnabled(z);
        }
        if (z) {
            if (this.fPc != null) {
                com.baidu.tbadk.core.util.al.h(this.fPc, e.d.cp_link_tip_a);
            }
        } else if (this.fPc != null) {
            com.baidu.tbadk.core.util.al.h(this.fPc, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.fPf, e.d.cp_cont_b);
        this.fPf.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.fPl, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fKM != null) {
            this.fKM.onChangeSkinType();
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
        if (this.fKM != null) {
            this.fKM.onDestroy();
        }
    }
}
