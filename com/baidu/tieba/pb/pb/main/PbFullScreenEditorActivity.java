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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools cEb;
    private EditorScrollView czv;
    private VoiceManager fuw;
    public as hLk;
    private View hPA = null;
    private TextView hPB = null;
    private TextView hPC = null;
    private PbFullScreenEditorInputView hPD;
    private WholeDisplayGridView hPE;
    private n hPF;
    private LinearLayout hPG;
    private PlayVoiceBntNew hPH;
    private LinearLayout hPI;
    private ImageView hPJ;
    private LinearLayout hPK;
    private u hPL;
    private t hPM;
    private PbEditorData hPN;
    private PostWriteCallBackData hPO;
    private View hPP;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.fuw = new VoiceManager();
        this.fuw.onCreate(getPageContext());
        initView();
        initData();
        if (this.hPN != null && this.hPN.getEditorType() == 1 && this.hPD != null) {
            this.hPD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hLk = new as();
        if (this.hPD != null) {
            this.hLk.g(this.hPD);
        }
        if (this.hPO != null) {
            this.hLk.f(this.hPO);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aJv();
        this.mTopLine = findViewById(R.id.view_line);
        this.czv = (EditorScrollView) findViewById(R.id.scroll_view);
        this.czv.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.cEb != null) {
                    PbFullScreenEditorActivity.this.cEb.asA();
                    PbFullScreenEditorActivity.this.cEb.auh();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hPD);
            }
        });
        bTq();
        this.hPD = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cEb != null) {
                    PbFullScreenEditorActivity.this.cEb.asA();
                    PbFullScreenEditorActivity.this.cEb.auh();
                }
            }
        });
        this.hPD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bTt();
                if (PbFullScreenEditorActivity.this.hLk != null && PbFullScreenEditorActivity.this.hLk.bWl() != null) {
                    if (!PbFullScreenEditorActivity.this.hLk.bWl().cxz()) {
                        PbFullScreenEditorActivity.this.hLk.oQ(false);
                    }
                    PbFullScreenEditorActivity.this.hLk.bWl().rL(false);
                }
            }
        });
        this.hPG = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPH = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPI = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hPJ = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bTs();
            }
        });
        this.hPE = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hPF = new n(this.mContext);
        this.hPF.a(this);
        this.hPE.setAdapter((ListAdapter) this.hPF);
    }

    private void bTq() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hPR = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hPE) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hPR);
                    int x = ((int) motionEvent.getX()) - this.hPR[0];
                    int y = ((int) motionEvent.getY()) - this.hPR[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.cEb.asA();
                        PbFullScreenEditorActivity.this.cEb.auh();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hPD);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.hPP = findViewById(R.id.scroll_view_child);
        this.hPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.cEb != null) {
                    PbFullScreenEditorActivity.this.cEb.asA();
                    PbFullScreenEditorActivity.this.cEb.auh();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hPD);
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

    private void aJv() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hPA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hPC = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hPC, (int) R.color.cp_cont_b);
        this.hPB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hPA != null && this.hPB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPA.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hPA.getLayoutParams();
            layoutParams2.width = -2;
            this.hPA.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.hPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hPB.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.hPB.setLayoutParams(layoutParams3);
            this.hPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.on(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hPN = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hPN != null) {
                om(this.hPN.getEditorType() == 1);
                final String disableVoiceMessage = this.hPN.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.cEb != null) {
                    com.baidu.tbadk.editortools.g jH = this.cEb.jH(6);
                    if (jH instanceof View) {
                        ((View) jH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hPN.getThreadData();
                if (this.hPL != null) {
                    this.hPL.setThreadData(this.mThreadData);
                }
                if (this.hPM != null) {
                    this.hPM.setThreadData(this.mThreadData);
                }
                String content = this.hPN.getContent();
                if (this.hPN.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hPN.getSubPbReplyPrefix();
                    this.hPD.dA(this.mSubPbReplyPrefix, content);
                } else {
                    this.hPD.wH(content);
                }
                WriteImagesInfo writeImagesInfo = this.hPN.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hPF.p(this.mWriteImagesInfo.getChosedFiles());
                    this.hPF.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hPN.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hPG.setVisibility(0);
                    this.hPH.setVoiceModel(voiceModel);
                    this.hPM.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k jK = this.cEb.jK(6);
                    if (jK != null && jK.cEn != null) {
                        jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.cEb.bd((View) this.cEb.jH(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hPO = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bTt();
    }

    private void om(boolean z) {
        this.hPK = (LinearLayout) findViewById(R.id.editbar_container);
        this.hPL = new u();
        this.hPL.oo(z);
        this.hPM = (t) this.hPL.cw(this.mContext);
        this.cEb = this.hPM.atX();
        this.hPM.b(this);
        this.hPL.b(this);
        this.hPK.addView(this.cEb, new LinearLayout.LayoutParams(-1, -2));
        this.cEb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hPM.c(this);
        this.cEb.le();
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
        on(false);
    }

    public void on(boolean z) {
        Intent intent = new Intent();
        if (this.hPN == null) {
            this.hPN = new PbEditorData();
        }
        this.hPN.setContent(this.hPD.getText().toString());
        this.hPN.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hPN.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hPN.setVoiceModel(this.hPM.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hPN);
        if (z) {
            if (this.hLk != null && this.hLk.bWl() != null && this.hLk.bWl().cxy()) {
                showToast(this.hLk.bWl().cxA());
                this.hLk.oQ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wz(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.eP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hPF.notifyDataSetChanged();
            }
            bTt();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void wA(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.hPM != null) {
            this.hPM.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        bTr();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            az(intent);
                        } else {
                            aB(intent);
                        }
                        this.hPF.p(this.mWriteImagesInfo.getChosedFiles());
                        this.hPF.notifyDataSetChanged();
                        bTt();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hPD.az(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    bTr();
                    aA(intent);
                    this.hPF.p(this.mWriteImagesInfo.getChosedFiles());
                    this.hPF.notifyDataSetChanged();
                    bTt();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.hPD.pF(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bTr() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void az(Intent intent) {
        String stringExtra = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bTr();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void aA(Intent intent) {
        b(intent, false);
    }

    private void aB(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            bTr();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fuw;
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
                    com.baidu.tieba.face.b.e(this.hPD);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bTs();
                    return;
                case 14:
                    bTr();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aut().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.apk() == EmotionGroupType.BIG_EMOTION || pVar.apk() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                            }
                            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                                if (this.mWriteImagesInfo.size() >= 9) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                bTr();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hPF.p(this.mWriteImagesInfo.getChosedFiles());
                                this.hPF.notifyDataSetChanged();
                                bTt();
                                return;
                            }
                            return;
                        }
                        this.hPD.b(pVar);
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
            this.hPM.setVoiceModel(voiceModel);
            this.hPG.setVisibility(0);
            this.hPH.setVoiceModel(voiceModel);
            bTt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTs() {
        if (this.hPM.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hPM.getVoiceModel().voiceId));
        }
        this.hPM.setVoiceModel(null);
        this.hPG.setVisibility(8);
        this.hPH.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jK = this.cEb.jK(6);
        if (jK != null && jK.cEn != null) {
            jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bTt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTt() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hPD.getText().toString());
        boolean z4 = (this.hPM == null || this.hPM.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hPB != null) {
            this.hPB.setEnabled(z);
        }
        if (z) {
            if (this.hPB != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hPB, (int) R.color.cp_link_tip_a);
            }
        } else if (this.hPB != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hPB, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hPD, (int) R.color.cp_cont_b);
        this.hPD.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.hPJ, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hPC, (int) R.color.cp_cont_b);
        bTt();
        if (this.hLk != null) {
            this.hLk.onChangeSkinType();
        }
        if (this.cEb != null) {
            this.cEb.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hLk != null) {
            this.hLk.onDestroy();
        }
        if (this.fuw != null) {
            this.fuw.removeBlackScreen();
        }
    }
}
