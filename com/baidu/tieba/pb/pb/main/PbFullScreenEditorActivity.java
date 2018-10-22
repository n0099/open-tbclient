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
    public at fKN;
    private View fPc = null;
    private TextView fPd = null;
    private TextView fPe = null;
    private EditorScrollView fPf;
    private PbFullScreenEditorInputView fPg;
    private WholeDisplayGridView fPh;
    private n fPi;
    private LinearLayout fPj;
    private PlayVoiceBntNew fPk;
    private LinearLayout fPl;
    private ImageView fPm;
    private LinearLayout fPn;
    private u fPo;
    private t fPp;
    private PbEditorData fPq;
    private PostWriteCallBackData fPr;
    private View fPs;
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
        if (this.fPq != null && this.fPq.getEditorType() == 1 && this.fPg != null) {
            this.fPg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fKN = new at();
        if (this.fPg != null) {
            this.fKN.g(this.fPg);
        }
        if (this.fPr != null) {
            this.fKN.f(this.fPr);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        axw();
        this.mTopLine = findViewById(e.g.view_line);
        this.fPf = (EditorScrollView) findViewById(e.g.scroll_view);
        this.fPf.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fPg);
            }
        });
        bhI();
        this.fPg = (PbFullScreenEditorInputView) findViewById(e.g.edit_content);
        this.fPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
            }
        });
        this.fPg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bhL();
                if (PbFullScreenEditorActivity.this.fKN != null && PbFullScreenEditorActivity.this.fKN.bkx() != null) {
                    if (!PbFullScreenEditorActivity.this.fKN.bkx().bLt()) {
                        PbFullScreenEditorActivity.this.fKN.lj(false);
                    }
                    PbFullScreenEditorActivity.this.fKN.bkx().ob(false);
                }
            }
        });
        this.fPj = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fPk = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fPl = (LinearLayout) findViewById(e.g.layout_del_voice);
        this.fPm = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bhK();
            }
        });
        this.fPh = (WholeDisplayGridView) findViewById(e.g.gridview);
        this.fPi = new n(this.mContext);
        this.fPi.a(this);
        this.fPh.setAdapter((ListAdapter) this.fPi);
    }

    private void bhI() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fPu = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fPh) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fPu);
                    int x = ((int) motionEvent.getX()) - this.fPu[0];
                    int y = ((int) motionEvent.getY()) - this.fPu[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aTJ.Jg();
                        PbFullScreenEditorActivity.this.aTJ.KR();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPg);
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
        this.fPs = findViewById(e.g.scroll_view_child);
        this.fPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aTJ != null) {
                    PbFullScreenEditorActivity.this.aTJ.Jg();
                    PbFullScreenEditorActivity.this.aTJ.KR();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fPg);
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

    private void axw() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fPc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPe = this.mNavigationBar.setCenterTextTitle(getString(e.j.pb_reply_floor));
        com.baidu.tbadk.core.util.al.h(this.fPe, e.d.cp_cont_b);
        this.fPd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fPc != null && this.fPd != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPc.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fPc.getLayoutParams();
            layoutParams2.width = -2;
            this.fPc.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(e.f.write_close_selector, e.f.write_close_selector);
            this.fPc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fPd.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.h(getActivity(), e.C0175e.ds14);
            this.fPd.setLayoutParams(layoutParams3);
            this.fPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.fPq = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fPq != null) {
                kD(this.fPq.getEditorType() == 1);
                final String disableVoiceMessage = this.fPq.getDisableVoiceMessage();
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
                this.mThreadData = this.fPq.getThreadData();
                if (this.fPo != null) {
                    this.fPo.setThreadData(this.mThreadData);
                }
                if (this.fPp != null) {
                    this.fPp.setThreadData(this.mThreadData);
                }
                this.fPg.loadData(this.fPq.getContent());
                WriteImagesInfo writeImagesInfo = this.fPq.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fPi.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fPi.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fPq.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fPj.setVisibility(0);
                    this.fPk.setVoiceModel(voiceModel);
                    this.fPp.setVoiceModel(voiceModel);
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
            this.fPr = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bhL();
    }

    private void kD(boolean z) {
        this.fPn = (LinearLayout) findViewById(e.g.editbar_container);
        this.fPo = new u();
        this.fPo.kF(z);
        this.fPp = (t) this.fPo.bM(this.mContext);
        this.aTJ = this.fPp.KH();
        this.fPp.b(this);
        this.fPo.b(this);
        this.fPn.addView(this.aTJ, new LinearLayout.LayoutParams(-1, -2));
        this.aTJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fPp.c(this);
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
        if (this.fPq == null) {
            this.fPq = new PbEditorData();
        }
        this.fPq.setContent(this.fPg.getText().toString());
        this.fPq.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fPq.setVoiceModel(this.fPp.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fPq);
        if (z) {
            if (this.fKN != null && this.fKN.bkx() != null && this.fKN.bkx().bLs()) {
                showToast(this.fKN.bkx().bLu());
                this.fKN.lj(true);
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
                this.fPi.notifyDataSetChanged();
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
        if (this.fPp != null) {
            this.fPp.onActivityResult(i, i2, intent);
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
                        this.fPi.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fPi.notifyDataSetChanged();
                        bhL();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fPg.ao(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bhJ();
                    W(intent);
                    this.fPi.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fPi.notifyDataSetChanged();
                    bhL();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fPg.hq(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
                    com.baidu.tieba.face.b.b(this.fPg);
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
                        this.fPg.b((com.baidu.tbadk.coreExtra.data.o) aVar.data);
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
            this.fPp.setVoiceModel(voiceModel);
            this.fPj.setVisibility(0);
            this.fPk.setVoiceModel(voiceModel);
            bhL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhK() {
        if (this.fPp.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fPp.getVoiceModel().voiceId));
        }
        this.fPp.setVoiceModel(null);
        this.fPj.setVisibility(8);
        this.fPk.setVoiceModel(null);
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
        boolean z3 = !TextUtils.isEmpty(this.fPg.getText().toString());
        boolean z4 = (this.fPp == null || this.fPp.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fPd != null) {
            this.fPd.setEnabled(z);
        }
        if (z) {
            if (this.fPd != null) {
                com.baidu.tbadk.core.util.al.h(this.fPd, e.d.cp_link_tip_a);
            }
        } else if (this.fPd != null) {
            com.baidu.tbadk.core.util.al.h(this.fPd, e.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.h(this.fPg, e.d.cp_cont_b);
        this.fPg.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_e));
        com.baidu.tbadk.core.util.al.c(this.fPm, e.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.al.j(this.mTopLine, e.d.cp_bg_line_c);
        if (this.fKN != null) {
            this.fKN.onChangeSkinType();
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
        if (this.fKN != null) {
            this.fKN.onDestroy();
        }
    }
}
