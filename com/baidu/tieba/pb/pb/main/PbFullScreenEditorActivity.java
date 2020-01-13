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
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private EditorScrollView dnm;
    private EditorTools dsh;
    private VoiceManager gmi;
    public as iGb;
    private PbFullScreenEditorInputView iHO;
    private WholeDisplayGridView iHP;
    private p iHQ;
    private LinearLayout iHR;
    private PlayVoiceBntNew iHS;
    private LinearLayout iHT;
    private ImageView iHU;
    private LinearLayout iHV;
    private v iHW;
    private u iHX;
    private PbEditorData iHY;
    private PostWriteCallBackData iHZ;
    private View iIa;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;
    private View iHM = null;
    private TextView iHN = null;
    private TextView mTvName = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.gmi = new VoiceManager();
        this.gmi.onCreate(getPageContext());
        initView();
        initData();
        if (this.iHY != null && this.iHY.getEditorType() == 1 && this.iHO != null) {
            this.iHO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.iGb = new as();
        if (this.iHO != null) {
            this.iGb.e(this.iHO);
        }
        if (this.iHZ != null) {
            this.iGb.f(this.iHZ);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bas();
        this.mTopLine = findViewById(R.id.view_line);
        this.dnm = (EditorScrollView) findViewById(R.id.scroll_view);
        this.dnm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dsh != null) {
                    PbFullScreenEditorActivity.this.dsh.aKs();
                    PbFullScreenEditorActivity.this.dsh.aMf();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.iHO);
            }
        });
        clS();
        this.iHO = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.iHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dsh != null) {
                    PbFullScreenEditorActivity.this.dsh.aKs();
                    PbFullScreenEditorActivity.this.dsh.aMf();
                }
            }
        });
        this.iHO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.clV();
                if (PbFullScreenEditorActivity.this.iGb != null && PbFullScreenEditorActivity.this.iGb.cpd() != null) {
                    if (!PbFullScreenEditorActivity.this.iGb.cpd().cSN()) {
                        PbFullScreenEditorActivity.this.iGb.qt(false);
                    }
                    PbFullScreenEditorActivity.this.iGb.cpd().tD(false);
                }
            }
        });
        this.iHR = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iHS = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iHT = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.iHU = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iHT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.clU();
            }
        });
        this.iHP = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.iHQ = new p(this.mContext);
        this.iHQ.a(this);
        this.iHP.setAdapter((ListAdapter) this.iHQ);
    }

    private void clS() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] iIc = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.iHP) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.iIc);
                    int x = ((int) motionEvent.getX()) - this.iIc[0];
                    int y = ((int) motionEvent.getY()) - this.iIc[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dsh.aKs();
                        PbFullScreenEditorActivity.this.dsh.aMf();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iHO);
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
        this.iIa = findViewById(R.id.scroll_view_child);
        this.iIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dsh != null) {
                    PbFullScreenEditorActivity.this.dsh.aKs();
                    PbFullScreenEditorActivity.this.dsh.aMf();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iHO);
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

    private void bas() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iHM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTvName = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        this.iHN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.iHM != null && this.iHN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iHM.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iHM.getLayoutParams();
            layoutParams2.width = -2;
            this.iHM.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iHN.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.iHN.setLayoutParams(layoutParams3);
            this.iHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.pP(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.iHY = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.iHY != null) {
                pO(this.iHY.getEditorType() == 1);
                final String disableVoiceMessage = this.iHY.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dsh != null) {
                    com.baidu.tbadk.editortools.g lU = this.dsh.lU(6);
                    if (lU instanceof View) {
                        ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.iHY.getThreadData();
                if (this.iHW != null) {
                    this.iHW.setThreadData(this.mThreadData);
                }
                if (this.iHX != null) {
                    this.iHX.setThreadData(this.mThreadData);
                }
                String content = this.iHY.getContent();
                if (this.iHY.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.iHY.getSubPbReplyPrefix();
                    this.iHO.dV(this.mSubPbReplyPrefix, content);
                } else {
                    this.iHO.BG(content);
                }
                WriteImagesInfo writeImagesInfo = this.iHY.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.iHQ.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iHQ.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.iHY.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.iHR.setVisibility(0);
                    this.iHS.setVoiceModel(voiceModel);
                    this.iHX.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l lX = this.dsh.lX(6);
                    if (lX != null && lX.dss != null) {
                        lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dsh.be((View) this.dsh.lU(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.iHZ = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        clV();
    }

    private void pO(boolean z) {
        this.iHV = (LinearLayout) findViewById(R.id.editbar_container);
        this.iHW = new v();
        this.iHW.pQ(z);
        if (this.iHY != null && this.iHY.getThreadData() != null) {
            this.iHW.pR(this.iHY.getThreadData().isBJH);
        }
        this.iHX = (u) this.iHW.dR(this.mContext);
        this.dsh = this.iHX.aLV();
        this.iHX.b(this);
        this.iHW.b(this);
        this.iHV.addView(this.dsh, new LinearLayout.LayoutParams(-1, -2));
        this.dsh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iHX.c(this);
        this.dsh.display();
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
        pP(false);
    }

    public void pP(boolean z) {
        Intent intent = new Intent();
        if (this.iHY == null) {
            this.iHY = new PbEditorData();
        }
        this.iHY.setContent(this.iHO.getText().toString());
        this.iHY.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.iHY.setWriteImagesInfo(this.mWriteImagesInfo);
        this.iHY.setVoiceModel(this.iHX.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.iHY);
        if (z) {
            if (this.iGb != null && this.iGb.cpd() != null && this.iGb.cpd().cSM()) {
                showToast(this.iGb.cpd().cSO());
                this.iGb.qt(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void yC(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.iHQ.notifyDataSetChanged();
            }
            clV();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void yD(int i) {
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
        if (this.iHX != null) {
            this.iHX.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        clT();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            as(intent);
                        } else {
                            au(intent);
                        }
                        this.iHQ.p(this.mWriteImagesInfo.getChosedFiles());
                        this.iHQ.notifyDataSetChanged();
                        clV();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.iHO.aK(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    clT();
                    at(intent);
                    this.iHQ.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iHQ.notifyDataSetChanged();
                    clV();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.iHO.uQ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void clT() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void as(Intent intent) {
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
            clT();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void at(Intent intent) {
        b(intent, false);
    }

    private void au(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            clT();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gmi;
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
                    com.baidu.tieba.face.b.c(this.iHO);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    clU();
                    return;
                case 14:
                    clT();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aMr().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.aHc() == EmotionGroupType.BIG_EMOTION || pVar.aHc() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                                if (this.mWriteImagesInfo.size() >= this.mWriteImagesInfo.getMaxImagesAllowed()) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                clT();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.iHQ.p(this.mWriteImagesInfo.getChosedFiles());
                                this.iHQ.notifyDataSetChanged();
                                clV();
                                return;
                            }
                            return;
                        }
                        this.iHO.b(pVar);
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
            this.iHX.setVoiceModel(voiceModel);
            this.iHR.setVisibility(0);
            this.iHS.setVoiceModel(voiceModel);
            clV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clU() {
        if (this.iHX.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.iHX.getVoiceModel().voiceId));
        }
        this.iHX.setVoiceModel(null);
        this.iHR.setVisibility(8);
        this.iHS.setVoiceModel(null);
        com.baidu.tbadk.editortools.l lX = this.dsh.lX(6);
        if (lX != null && lX.dss != null) {
            lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        clV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clV() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.iHO.getText().toString());
        boolean z4 = (this.iHX == null || this.iHX.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.iHN != null) {
            this.iHN.setEnabled(z);
        }
        if (z) {
            if (this.iHN != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iHN, (int) R.color.cp_link_tip_a);
            }
        } else if (this.iHN != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHN, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iHO, (int) R.color.cp_cont_b);
        this.iHO.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.iHU, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        clV();
        if (this.iGb != null) {
            this.iGb.onChangeSkinType();
        }
        if (this.dsh != null) {
            this.dsh.onChangeSkinType(i);
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
        if (this.iGb != null) {
            this.iGb.onDestroy();
        }
        if (this.gmi != null) {
            this.gmi.removeBlackScreen();
        }
    }
}
