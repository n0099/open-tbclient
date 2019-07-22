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
    private EditorScrollView cmm;
    private EditorTools crG;
    private VoiceManager ftO;
    public as hKH;
    private View hOU = null;
    private TextView hOV = null;
    private TextView hOW = null;
    private PbFullScreenEditorInputView hOX;
    private WholeDisplayGridView hOY;
    private n hOZ;
    private LinearLayout hPa;
    private PlayVoiceBntNew hPb;
    private LinearLayout hPc;
    private ImageView hPd;
    private LinearLayout hPe;
    private u hPf;
    private t hPg;
    private PbEditorData hPh;
    private PostWriteCallBackData hPi;
    private View hPj;
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
        this.ftO = new VoiceManager();
        this.ftO.onCreate(getPageContext());
        initView();
        initData();
        if (this.hPh != null && this.hPh.getEditorType() == 1 && this.hOX != null) {
            this.hOX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.hKH = new as();
        if (this.hOX != null) {
            this.hKH.k(this.hOX);
        }
        if (this.hPi != null) {
            this.hKH.f(this.hPi);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        aJr();
        this.mTopLine = findViewById(R.id.view_line);
        this.cmm = (EditorScrollView) findViewById(R.id.scroll_view);
        this.cmm.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.crG != null) {
                    PbFullScreenEditorActivity.this.crG.aqu();
                    PbFullScreenEditorActivity.this.crG.asj();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.hOX);
            }
        });
        bVn();
        this.hOX = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.hOX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.crG != null) {
                    PbFullScreenEditorActivity.this.crG.aqu();
                    PbFullScreenEditorActivity.this.crG.asj();
                }
            }
        });
        this.hOX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bVq();
                if (PbFullScreenEditorActivity.this.hKH != null && PbFullScreenEditorActivity.this.hKH.bYh() != null) {
                    if (!PbFullScreenEditorActivity.this.hKH.bYh().czh()) {
                        PbFullScreenEditorActivity.this.hKH.pd(false);
                    }
                    PbFullScreenEditorActivity.this.hKH.bYh().sa(false);
                }
            }
        });
        this.hPa = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPb = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPc = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.hPd = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bVp();
            }
        });
        this.hOY = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.hOZ = new n(this.mContext);
        this.hOZ.a(this);
        this.hOY.setAdapter((ListAdapter) this.hOZ);
    }

    private void bVn() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] hPl = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.hOY) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.hPl);
                    int x = ((int) motionEvent.getX()) - this.hPl[0];
                    int y = ((int) motionEvent.getY()) - this.hPl[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.crG.aqu();
                        PbFullScreenEditorActivity.this.crG.asj();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hOX);
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
        this.hPj = findViewById(R.id.scroll_view_child);
        this.hPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.crG != null) {
                    PbFullScreenEditorActivity.this.crG.aqu();
                    PbFullScreenEditorActivity.this.crG.asj();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.hOX);
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

    private void aJr() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hOU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOW = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.j(this.hOW, R.color.cp_cont_b);
        this.hOV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.hOU != null && this.hOV != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hOU.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hOU.getLayoutParams();
            layoutParams2.width = -2;
            this.hOU.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(R.drawable.write_close_selector, R.drawable.write_close_selector);
            this.hOU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.hOV.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds14);
            this.hOV.setLayoutParams(layoutParams3);
            this.hOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.oA(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.hPh = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.hPh != null) {
                oz(this.hPh.getEditorType() == 1);
                final String disableVoiceMessage = this.hPh.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.crG != null) {
                    com.baidu.tbadk.editortools.g km = this.crG.km(6);
                    if (km instanceof View) {
                        ((View) km).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.hPh.getThreadData();
                if (this.hPf != null) {
                    this.hPf.setThreadData(this.mThreadData);
                }
                if (this.hPg != null) {
                    this.hPg.setThreadData(this.mThreadData);
                }
                String content = this.hPh.getContent();
                if (this.hPh.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.hPh.getSubPbReplyPrefix();
                    this.hOX.dM(this.mSubPbReplyPrefix, content);
                } else {
                    this.hOX.loadData(content);
                }
                WriteImagesInfo writeImagesInfo = this.hPh.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.hOZ.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hOZ.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.hPh.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.hPa.setVisibility(0);
                    this.hPb.setVoiceModel(voiceModel);
                    this.hPg.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k kp = this.crG.kp(6);
                    if (kp != null && kp.crT != null) {
                        kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.crG.bd((View) this.crG.km(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.hPi = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bVq();
    }

    private void oz(boolean z) {
        this.hPe = (LinearLayout) findViewById(R.id.editbar_container);
        this.hPf = new u();
        this.hPf.oB(z);
        this.hPg = (t) this.hPf.cK(this.mContext);
        this.crG = this.hPg.arY();
        this.hPg.b(this);
        this.hPf.b(this);
        this.hPe.addView(this.crG, new LinearLayout.LayoutParams(-1, -2));
        this.crG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hPg.c(this);
        this.crG.qk();
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
        oA(false);
    }

    public void oA(boolean z) {
        Intent intent = new Intent();
        if (this.hPh == null) {
            this.hPh = new PbEditorData();
        }
        this.hPh.setContent(this.hOX.getText().toString());
        this.hPh.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.hPh.setWriteImagesInfo(this.mWriteImagesInfo);
        this.hPh.setVoiceModel(this.hPg.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.hPh);
        if (z) {
            if (this.hKH != null && this.hKH.bYh() != null && this.hKH.bYh().czg()) {
                showToast(this.hKH.bYh().czi());
                this.hKH.pd(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xQ(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.hOZ.notifyDataSetChanged();
            }
            bVq();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void xR(int i) {
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
        if (this.hPg != null) {
            this.hPg.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        bVo();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            ap(intent);
                        } else {
                            ar(intent);
                        }
                        this.hOZ.t(this.mWriteImagesInfo.getChosedFiles());
                        this.hOZ.notifyDataSetChanged();
                        bVq();
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.hOX.av(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12012:
                    bVo();
                    aq(intent);
                    this.hOZ.t(this.mWriteImagesInfo.getChosedFiles());
                    this.hOZ.notifyDataSetChanged();
                    bVq();
                    return;
                case 25004:
                    if (intent != null) {
                        this.hOX.ql(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bVo() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ap(Intent intent) {
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
            bVo();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void aq(Intent intent) {
        b(intent, false);
    }

    private void ar(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bVo();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ftO;
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
                    com.baidu.tieba.face.b.f(this.hOX);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bVp();
                    return;
                case 14:
                    bVo();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.asv().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                        com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                        if (pVar.amu() == EmotionGroupType.BIG_EMOTION || pVar.amu() == EmotionGroupType.USER_COLLECT) {
                            if (this.mCurrentPermissionJudgePolicy == null) {
                                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                            }
                            this.mCurrentPermissionJudgePolicy.ajQ();
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
                                bVo();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.hOZ.t(this.mWriteImagesInfo.getChosedFiles());
                                this.hOZ.notifyDataSetChanged();
                                bVq();
                                return;
                            }
                            return;
                        }
                        this.hOX.b(pVar);
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
            this.hPg.setVoiceModel(voiceModel);
            this.hPa.setVisibility(0);
            this.hPb.setVoiceModel(voiceModel);
            bVq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.hPg.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.hPg.getVoiceModel().voiceId));
        }
        this.hPg.setVoiceModel(null);
        this.hPa.setVisibility(8);
        this.hPb.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kp = this.crG.kp(6);
        if (kp != null && kp.crT != null) {
            kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bVq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVq() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.hOX.getText().toString());
        boolean z4 = (this.hPg == null || this.hPg.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.hOV != null) {
            this.hOV.setEnabled(z);
        }
        if (z) {
            if (this.hOV != null) {
                com.baidu.tbadk.core.util.am.j(this.hOV, R.color.cp_link_tip_a);
            }
        } else if (this.hOV != null) {
            com.baidu.tbadk.core.util.am.j(this.hOV, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.j(this.hOX, R.color.cp_cont_b);
        this.hOX.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.hPd, (int) R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.l(this.mTopLine, R.color.cp_bg_line_c);
        if (this.hKH != null) {
            this.hKH.onChangeSkinType();
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
        if (this.hKH != null) {
            this.hKH.onDestroy();
        }
        if (this.ftO != null) {
            this.ftO.removeBlackScreen();
        }
    }
}
