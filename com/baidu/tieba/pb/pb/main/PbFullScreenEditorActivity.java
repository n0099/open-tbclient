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
    private EditorScrollView cno;
    private EditorTools csI;
    private VoiceManager fwa;
    public as hNy;
    private View hRM = null;
    private TextView hRN = null;
    private TextView hRO = null;
    private PbFullScreenEditorInputView hRP;
    private WholeDisplayGridView hRQ;
    private n hRR;
    private LinearLayout hRS;
    private PlayVoiceBntNew hRT;
    private LinearLayout hRU;
    private ImageView hRV;
    private LinearLayout hRW;
    private u hRX;
    private t hRY;
    private PbEditorData hRZ;
    private PostWriteCallBackData hSa;
    private View hSb;
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
        this.fwa = new VoiceManager();
        this.fwa.onCreate(getPageContext());
        initView();
        initData();
        if (this.hRZ != null && this.hRZ.getEditorType() == 1 && this.hRP != null) {
            this.hRP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hNy = new as();
        if (this.hRP != null) {
            this.hNy.k(this.hRP);
        }
        if (this.hSa != null) {
            this.hNy.f(this.hSa);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aJX();
        this.mTopLine = findViewById(R.id.view_line);
        this.cno = (EditorScrollView) findViewById(R.id.scroll_view);
        this.cno.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.csI != null) {
                    PbFullScreenEditorActivity.this.csI.aqI();
                    PbFullScreenEditorActivity.this.csI.asx();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hRP);
            }
        });
        bWq();
        this.hRP = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.csI != null) {
                    PbFullScreenEditorActivity.this.csI.aqI();
                    PbFullScreenEditorActivity.this.csI.asx();
                }
            }
        });
        this.hRP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bWt();
                if (PbFullScreenEditorActivity.this.hNy != null && PbFullScreenEditorActivity.this.hNy.bZl() != null) {
                    if (!PbFullScreenEditorActivity.this.hNy.bZl().cAq()) {
                        PbFullScreenEditorActivity.this.hNy.ph(false);
                    }
                    PbFullScreenEditorActivity.this.hNy.bZl().se(false);
                }
            }
        });
        this.hRS = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hRT = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hRU = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hRV = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bWs();
            }
        });
        this.hRQ = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hRR = new n(this.mContext);
        this.hRR.a(this);
        this.hRQ.setAdapter((ListAdapter) this.hRR);
    }

    private void bWq() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hSd = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hRQ) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hSd);
                    int x = ((int) motionEvent.getX()) - this.hSd[0];
                    int y = ((int) motionEvent.getY()) - this.hSd[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.csI.aqI();
                        PbFullScreenEditorActivity.this.csI.asx();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hRP);
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
        this.hSb = findViewById(R.id.scroll_view_child);
        this.hSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.csI != null) {
                    PbFullScreenEditorActivity.this.csI.aqI();
                    PbFullScreenEditorActivity.this.csI.asx();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hRP);
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

    private void aJX() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hRM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hRO = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.j(this.hRO, R.color.cp_cont_b);
        this.hRN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hRM != null && this.hRN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hRM.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hRM.getLayoutParams();
            layoutParams2.width = -2;
            this.hRM.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.hRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hRN.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds14);
            this.hRN.setLayoutParams(layoutParams3);
            this.hRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.oE(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hRZ = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hRZ != null) {
                oD(this.hRZ.getEditorType() == 1);
                final String disableVoiceMessage = this.hRZ.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.csI != null) {
                    com.baidu.tbadk.editortools.g kq = this.csI.kq(6);
                    if (kq instanceof View) {
                        ((View) kq).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hRZ.getThreadData();
                if (this.hRX != null) {
                    this.hRX.setThreadData(this.mThreadData);
                }
                if (this.hRY != null) {
                    this.hRY.setThreadData(this.mThreadData);
                }
                String content = this.hRZ.getContent();
                if (this.hRZ.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hRZ.getSubPbReplyPrefix();
                    this.hRP.dO(this.mSubPbReplyPrefix, content);
                } else {
                    this.hRP.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hRZ.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hRR.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hRR.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hRZ.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hRS.setVisibility(0);
                    this.hRT.setVoiceModel(voiceModel);
                    this.hRY.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k kt = this.csI.kt(6);
                    if (kt != null && kt.csV != null) {
                        kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.csI.bd((View) this.csI.kq(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hSa = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bWt();
    }

    private void oD(boolean z) {
        this.hRW = (LinearLayout) findViewById(R.id.editbar_container);
        this.hRX = new u();
        this.hRX.oF(z);
        this.hRY = (t) this.hRX.cK(this.mContext);
        this.csI = this.hRY.asm();
        this.hRY.b(this);
        this.hRX.b(this);
        this.hRW.addView(this.csI, new LinearLayout.LayoutParams(-1, -2));
        this.csI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hRY.c(this);
        this.csI.ql();
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
        oE(false);
    }

    public void oE(boolean z) {
        Intent intent = new Intent();
        if (this.hRZ == null) {
            this.hRZ = new PbEditorData();
        }
        this.hRZ.setContent(this.hRP.getText().toString());
        this.hRZ.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hRZ.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hRZ.setVoiceModel(this.hRY.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hRZ);
        if (z) {
            if (this.hNy != null && this.hNy.bZl() != null && this.hNy.bZl().cAp()) {
                showToast(this.hNy.bZl().cAr());
                this.hNy.ph(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xV(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hRR.notifyDataSetChanged();
            }
            bWt();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xW(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.hRY != null) {
            this.hRY.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        bWr();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            ar(intent);
                        } else {
                            at(intent);
                        }
                        this.hRR.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hRR.notifyDataSetChanged();
                        bWt();
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hRP.av(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12012:
                    bWr();
                    as(intent);
                    this.hRR.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hRR.notifyDataSetChanged();
                    bWt();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hRP.qw(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bWr() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ar(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.af(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ah(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bWr();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void as(Intent intent) {
        b(intent, false);
    }

    private void at(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bWr();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fwa;
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
                    com.baidu.tieba.face.b.f(this.hRP);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bWs();
                    return;
                case 14:
                    bWr();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.asJ().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.amI() == EmotionGroupType.BIG_EMOTION || pVar.amI() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                            }
                            this.mCurrentPermissionJudgePolicy.ake();
                            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!this.mCurrentPermissionJudgePolicy.ad(this)) {
                                if (this.mWriteImagesInfo.size() >= 9) {
                                    showToast(String.format(getString(R.string.max_choose_image_count), Integer.valueOf(this.mWriteImagesInfo.getMaxImagesAllowed())));
                                    return;
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setImageType(1);
                                imageFileInfo.setFilePath(pVar.getName());
                                imageFileInfo.width = pVar.getWidth();
                                imageFileInfo.height = pVar.getHeight();
                                bWr();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hRR.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hRR.notifyDataSetChanged();
                                bWt();
                                return;
                            }
                            return;
                        }
                        this.hRP.b(pVar);
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
            this.hRY.setVoiceModel(voiceModel);
            this.hRS.setVisibility(0);
            this.hRT.setVoiceModel(voiceModel);
            bWt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWs() {
        if (this.hRY.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hRY.getVoiceModel().voiceId));
        }
        this.hRY.setVoiceModel(null);
        this.hRS.setVisibility(8);
        this.hRT.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kt = this.csI.kt(6);
        if (kt != null && kt.csV != null) {
            kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bWt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWt() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hRP.getText().toString());
        boolean z4 = (this.hRY == null || this.hRY.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hRN != null) {
            this.hRN.setEnabled(z);
        }
        if (z) {
            if (this.hRN != null) {
                com.baidu.tbadk.core.util.am.j(this.hRN, R.color.cp_link_tip_a);
            }
        } else if (this.hRN != null) {
            com.baidu.tbadk.core.util.am.j(this.hRN, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.j(this.hRP, R.color.cp_cont_b);
        this.hRP.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.hRV, (int) R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.l(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.j(this.hRO, R.color.cp_cont_b);
        bWt();
        if (this.hNy != null) {
            this.hNy.onChangeSkinType();
        }
        if (this.csI != null) {
            this.csI.onChangeSkinType(i);
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
        if (this.hNy != null) {
            this.hNy.onDestroy();
        }
        if (this.fwa != null) {
            this.fwa.removeBlackScreen();
        }
    }
}
