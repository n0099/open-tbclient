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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
/* loaded from: classes9.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private EditorScrollView egr;
    private EditorTools ekK;
    private VoiceManager hns;
    public ax jLJ;
    private LinearLayout jNA;
    private ImageView jNB;
    private LinearLayout jNC;
    private v jND;
    private u jNE;
    private PbEditorData jNF;
    private PostWriteCallBackData jNG;
    private View jNH;
    private View jNs = null;
    private TextView jNt = null;
    private TextView jNu = null;
    private PbFullScreenEditorInputView jNv;
    private WholeDisplayGridView jNw;
    private p jNx;
    private LinearLayout jNy;
    private PlayVoiceBntNew jNz;
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
        this.hns = new VoiceManager();
        this.hns.onCreate(getPageContext());
        initView();
        initData();
        if (this.jNF != null && this.jNF.getEditorType() == 1 && this.jNv != null) {
            this.jNv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.jLJ = new ax();
        if (this.jNv != null) {
            this.jLJ.e(this.jNv);
        }
        if (this.jNG != null) {
            this.jLJ.f(this.jNG);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        brd();
        this.mTopLine = findViewById(R.id.view_line);
        this.egr = (EditorScrollView) findViewById(R.id.scroll_view);
        this.egr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbA();
                    PbFullScreenEditorActivity.this.ekK.bdh();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.jNv);
            }
        });
        cFy();
        this.jNv = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.jNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbA();
                    PbFullScreenEditorActivity.this.ekK.bdh();
                }
            }
        });
        this.jNv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cFB();
                if (PbFullScreenEditorActivity.this.jLJ != null && PbFullScreenEditorActivity.this.jLJ.cIJ() != null) {
                    if (!PbFullScreenEditorActivity.this.jLJ.cIJ().dmy()) {
                        PbFullScreenEditorActivity.this.jLJ.sf(false);
                    }
                    PbFullScreenEditorActivity.this.jLJ.cIJ().vn(false);
                }
            }
        });
        this.jNy = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jNz = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jNA = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.jNB = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cFA();
            }
        });
        this.jNw = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.jNx = new p(this.mContext);
        this.jNx.a(this);
        this.jNw.setAdapter((ListAdapter) this.jNx);
    }

    private void cFy() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] jNJ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.jNw) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.jNJ);
                    int x = ((int) motionEvent.getX()) - this.jNJ[0];
                    int y = ((int) motionEvent.getY()) - this.jNJ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.ekK.bbA();
                        PbFullScreenEditorActivity.this.ekK.bdh();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jNv);
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
        this.jNH = findViewById(R.id.scroll_view_child);
        this.jNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ekK != null) {
                    PbFullScreenEditorActivity.this.ekK.bbA();
                    PbFullScreenEditorActivity.this.ekK.bdh();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.jNv);
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

    private void brd() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.jNs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jNu = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jNu, (int) R.color.cp_cont_b);
        this.jNt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.jNs != null && this.jNt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jNs.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jNs.getLayoutParams();
            layoutParams2.width = -2;
            this.jNs.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.jNt.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.jNt.setLayoutParams(layoutParams3);
            this.jNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.rB(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.jNF = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.jNF != null) {
                rA(this.jNF.getEditorType() == 1);
                final String disableVoiceMessage = this.jNF.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.ekK != null) {
                    com.baidu.tbadk.editortools.g ne = this.ekK.ne(6);
                    if (ne instanceof View) {
                        ((View) ne).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.jNF.getThreadData();
                if (this.jND != null) {
                    this.jND.setThreadData(this.mThreadData);
                }
                if (this.jNE != null) {
                    this.jNE.setThreadData(this.mThreadData);
                }
                String content = this.jNF.getContent();
                if (this.jNF.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.jNF.getSubPbReplyPrefix();
                    this.jNv.eS(this.mSubPbReplyPrefix, content);
                } else {
                    this.jNv.Fr(content);
                }
                WriteImagesInfo writeImagesInfo = this.jNF.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.jNx.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jNx.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.jNF.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.jNy.setVisibility(0);
                    this.jNz.setVoiceModel(voiceModel);
                    this.jNE.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l nh = this.ekK.nh(6);
                    if (nh != null && nh.ekV != null) {
                        nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.ekK.bg((View) this.ekK.ne(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.jNG = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cFB();
    }

    private void rA(boolean z) {
        this.jNC = (LinearLayout) findViewById(R.id.editbar_container);
        this.jND = new v();
        this.jND.rC(z);
        if (this.jNF != null && this.jNF.getThreadData() != null) {
            this.jND.rD(this.jNF.getThreadData().isBJH);
        }
        this.jNE = (u) this.jND.dN(this.mContext);
        this.ekK = this.jNE.bcX();
        this.jNE.b(this);
        this.jND.b(this);
        this.jNC.addView(this.ekK, new LinearLayout.LayoutParams(-1, -2));
        this.ekK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jNE.c(this);
        this.ekK.display();
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
        rB(false);
    }

    public void rB(boolean z) {
        Intent intent = new Intent();
        if (this.jNF == null) {
            this.jNF = new PbEditorData();
        }
        this.jNF.setContent(this.jNv.getText().toString());
        this.jNF.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.jNF.setWriteImagesInfo(this.mWriteImagesInfo);
        this.jNF.setVoiceModel(this.jNE.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.jNF);
        if (z) {
            if (this.jLJ != null && this.jLJ.cIJ() != null && this.jLJ.cIJ().dmx()) {
                showToast(this.jLJ.cIJ().dmz());
                this.jLJ.sf(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void Ae(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.jR().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.jNx.notifyDataSetChanged();
            }
            cFB();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void Af(int i) {
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
        if (this.jNE != null) {
            this.jNE.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cFz();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.jNx.p(this.mWriteImagesInfo.getChosedFiles());
                        this.jNx.notifyDataSetChanged();
                        cFB();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.jNv.aN(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cFz();
                    ad(intent);
                    this.jNx.p(this.mWriteImagesInfo.getChosedFiles());
                    this.jNx.notifyDataSetChanged();
                    cFB();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.jNv.ye(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cFz() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ac(Intent intent) {
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
            cFz();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ad(Intent intent) {
        b(intent, false);
    }

    private void ae(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            cFz();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hns;
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
                    com.baidu.tieba.face.b.b(this.jNv);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cFA();
                    return;
                case 14:
                    cFz();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bdt().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aYd() == EmotionGroupType.BIG_EMOTION || qVar.aYd() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
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
                                imageFileInfo.setFilePath(qVar.getName());
                                imageFileInfo.width = qVar.getWidth();
                                imageFileInfo.height = qVar.getHeight();
                                cFz();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.jNx.p(this.mWriteImagesInfo.getChosedFiles());
                                this.jNx.notifyDataSetChanged();
                                cFB();
                                return;
                            }
                            return;
                        }
                        this.jNv.b(qVar);
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
            this.jNE.setVoiceModel(voiceModel);
            this.jNy.setVisibility(0);
            this.jNz.setVoiceModel(voiceModel);
            cFB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFA() {
        if (this.jNE.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.wY(this.jNE.getVoiceModel().voiceId));
        }
        this.jNE.setVoiceModel(null);
        this.jNy.setVisibility(8);
        this.jNz.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nh = this.ekK.nh(6);
        if (nh != null && nh.ekV != null) {
            nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cFB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFB() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.jNv.getText().toString());
        boolean z4 = (this.jNE == null || this.jNE.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.jNt != null) {
            this.jNt.setEnabled(z);
        }
        if (z) {
            if (this.jNt != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jNt, (int) R.color.cp_link_tip_a);
            }
        } else if (this.jNt != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNt, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jNv, (int) R.color.cp_cont_b);
        this.jNv.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.jNB, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.jNu, (int) R.color.cp_cont_b);
        cFB();
        if (this.jLJ != null) {
            this.jLJ.onChangeSkinType();
        }
        if (this.ekK != null) {
            this.ekK.onChangeSkinType(i);
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
        if (this.jLJ != null) {
            this.jLJ.onDestroy();
        }
        if (this.hns != null) {
            this.hns.removeBlackScreen();
        }
    }
}
