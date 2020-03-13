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
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, o.a {
    private EditorScrollView drK;
    private EditorTools dwC;
    private VoiceManager goy;
    public ap iHT;
    private PbFullScreenEditorInputView iJC;
    private WholeDisplayGridView iJD;
    private o iJE;
    private LinearLayout iJF;
    private PlayVoiceBntNew iJG;
    private LinearLayout iJH;
    private ImageView iJI;
    private LinearLayout iJJ;
    private u iJK;
    private t iJL;
    private PbEditorData iJM;
    private PostWriteCallBackData iJN;
    private View iJO;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;
    private View iJA = null;
    private TextView iJB = null;
    private TextView mTvName = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.goy = new VoiceManager();
        this.goy.onCreate(getPageContext());
        initView();
        initData();
        if (this.iJM != null && this.iJM.getEditorType() == 1 && this.iJC != null) {
            this.iJC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.iHT = new ap();
        if (this.iJC != null) {
            this.iHT.e(this.iJC);
        }
        if (this.iJN != null) {
            this.iHT.f(this.iJN);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bcK();
        this.mTopLine = findViewById(R.id.view_line);
        this.drK = (EditorScrollView) findViewById(R.id.scroll_view);
        this.drK.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dwC != null) {
                    PbFullScreenEditorActivity.this.dwC.aMR();
                    PbFullScreenEditorActivity.this.dwC.aOE();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.iJC);
            }
        });
        cnp();
        this.iJC = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.iJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwC != null) {
                    PbFullScreenEditorActivity.this.dwC.aMR();
                    PbFullScreenEditorActivity.this.dwC.aOE();
                }
            }
        });
        this.iJC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cns();
                if (PbFullScreenEditorActivity.this.iHT != null && PbFullScreenEditorActivity.this.iHT.cqy() != null) {
                    if (!PbFullScreenEditorActivity.this.iHT.cqy().cUg()) {
                        PbFullScreenEditorActivity.this.iHT.qw(false);
                    }
                    PbFullScreenEditorActivity.this.iHT.cqy().tH(false);
                }
            }
        });
        this.iJF = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iJG = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iJH = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.iJI = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cnr();
            }
        });
        this.iJD = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.iJE = new o(this.mContext);
        this.iJE.a(this);
        this.iJD.setAdapter((ListAdapter) this.iJE);
    }

    private void cnp() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] iJQ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.iJD) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.iJQ);
                    int x = ((int) motionEvent.getX()) - this.iJQ[0];
                    int y = ((int) motionEvent.getY()) - this.iJQ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dwC.aMR();
                        PbFullScreenEditorActivity.this.dwC.aOE();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iJC);
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
        this.iJO = findViewById(R.id.scroll_view_child);
        this.iJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwC != null) {
                    PbFullScreenEditorActivity.this.dwC.aMR();
                    PbFullScreenEditorActivity.this.dwC.aOE();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iJC);
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

    private void bcK() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iJA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTvName = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        this.iJB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.iJA != null && this.iJB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iJA.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJA.getLayoutParams();
            layoutParams2.width = -2;
            this.iJA.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iJA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iJB.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.iJB.setLayoutParams(layoutParams3);
            this.iJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.pS(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.iJM = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.iJM != null) {
                pR(this.iJM.getEditorType() == 1);
                final String disableVoiceMessage = this.iJM.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dwC != null) {
                    com.baidu.tbadk.editortools.g mm = this.dwC.mm(6);
                    if (mm instanceof View) {
                        ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.iJM.getThreadData();
                if (this.iJK != null) {
                    this.iJK.setThreadData(this.mThreadData);
                }
                if (this.iJL != null) {
                    this.iJL.setThreadData(this.mThreadData);
                }
                String content = this.iJM.getContent();
                if (this.iJM.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.iJM.getSubPbReplyPrefix();
                    this.iJC.ee(this.mSubPbReplyPrefix, content);
                } else {
                    this.iJC.BX(content);
                }
                WriteImagesInfo writeImagesInfo = this.iJM.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.iJE.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iJE.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.iJM.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.iJF.setVisibility(0);
                    this.iJG.setVoiceModel(voiceModel);
                    this.iJL.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l mp = this.dwC.mp(6);
                    if (mp != null && mp.dwN != null) {
                        mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dwC.be((View) this.dwC.mm(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.iJN = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cns();
    }

    private void pR(boolean z) {
        this.iJJ = (LinearLayout) findViewById(R.id.editbar_container);
        this.iJK = new u();
        this.iJK.pT(z);
        if (this.iJM != null && this.iJM.getThreadData() != null) {
            this.iJK.pU(this.iJM.getThreadData().isBJH);
        }
        this.iJL = (t) this.iJK.dV(this.mContext);
        this.dwC = this.iJL.aOu();
        this.iJL.b(this);
        this.iJK.b(this);
        this.iJJ.addView(this.dwC, new LinearLayout.LayoutParams(-1, -2));
        this.dwC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iJL.c(this);
        this.dwC.display();
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
        pS(false);
    }

    public void pS(boolean z) {
        Intent intent = new Intent();
        if (this.iJM == null) {
            this.iJM = new PbEditorData();
        }
        this.iJM.setContent(this.iJC.getText().toString());
        this.iJM.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.iJM.setWriteImagesInfo(this.mWriteImagesInfo);
        this.iJM.setVoiceModel(this.iJL.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.iJM);
        if (z) {
            if (this.iHT != null && this.iHT.cqy() != null && this.iHT.cqy().cUf()) {
                showToast(this.iHT.cqy().cUh());
                this.iHT.qw(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void yJ(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.iJE.notifyDataSetChanged();
            }
            cns();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void yK(int i) {
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
        if (this.iJL != null) {
            this.iJL.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cnq();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            as(intent);
                        } else {
                            au(intent);
                        }
                        this.iJE.p(this.mWriteImagesInfo.getChosedFiles());
                        this.iJE.notifyDataSetChanged();
                        cns();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.iJC.aK(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cnq();
                    at(intent);
                    this.iJE.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iJE.notifyDataSetChanged();
                    cns();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.iJC.vi(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cnq() {
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
            cnq();
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
            cnq();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goy;
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
                    com.baidu.tieba.face.b.c(this.iJC);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cnr();
                    return;
                case 14:
                    cnq();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aOQ().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aJx() == EmotionGroupType.BIG_EMOTION || qVar.aJx() == EmotionGroupType.USER_COLLECT) {
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
                                cnq();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.iJE.p(this.mWriteImagesInfo.getChosedFiles());
                                this.iJE.notifyDataSetChanged();
                                cns();
                                return;
                            }
                            return;
                        }
                        this.iJC.b(qVar);
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
            this.iJL.setVoiceModel(voiceModel);
            this.iJF.setVisibility(0);
            this.iJG.setVoiceModel(voiceModel);
            cns();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnr() {
        if (this.iJL.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.iJL.getVoiceModel().voiceId));
        }
        this.iJL.setVoiceModel(null);
        this.iJF.setVisibility(8);
        this.iJG.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mp = this.dwC.mp(6);
        if (mp != null && mp.dwN != null) {
            mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cns();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cns() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.iJC.getText().toString());
        boolean z4 = (this.iJL == null || this.iJL.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.iJB != null) {
            this.iJB.setEnabled(z);
        }
        if (z) {
            if (this.iJB != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iJB, (int) R.color.cp_link_tip_a);
            }
        } else if (this.iJB != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iJB, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iJC, (int) R.color.cp_cont_b);
        this.iJC.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.iJI, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        cns();
        if (this.iHT != null) {
            this.iHT.onChangeSkinType();
        }
        if (this.dwC != null) {
            this.dwC.onChangeSkinType(i);
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
        if (this.iHT != null) {
            this.iHT.onDestroy();
        }
        if (this.goy != null) {
            this.goy.removeBlackScreen();
        }
    }
}
