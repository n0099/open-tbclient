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
    private EditorScrollView drX;
    private EditorTools dwP;
    private VoiceManager gpi;
    public ap iJu;
    private PbFullScreenEditorInputView iLd;
    private WholeDisplayGridView iLe;
    private o iLf;
    private LinearLayout iLg;
    private PlayVoiceBntNew iLh;
    private LinearLayout iLi;
    private ImageView iLj;
    private LinearLayout iLk;
    private u iLl;
    private t iLm;
    private PbEditorData iLn;
    private PostWriteCallBackData iLo;
    private View iLp;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;
    private View iLb = null;
    private TextView iLc = null;
    private TextView mTvName = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.gpi = new VoiceManager();
        this.gpi.onCreate(getPageContext());
        initView();
        initData();
        if (this.iLn != null && this.iLn.getEditorType() == 1 && this.iLd != null) {
            this.iLd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.iJu = new ap();
        if (this.iLd != null) {
            this.iJu.e(this.iLd);
        }
        if (this.iLo != null) {
            this.iJu.f(this.iLo);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bcO();
        this.mTopLine = findViewById(R.id.view_line);
        this.drX = (EditorScrollView) findViewById(R.id.scroll_view);
        this.drX.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dwP != null) {
                    PbFullScreenEditorActivity.this.dwP.aMV();
                    PbFullScreenEditorActivity.this.dwP.aOI();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.iLd);
            }
        });
        cnK();
        this.iLd = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.iLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwP != null) {
                    PbFullScreenEditorActivity.this.dwP.aMV();
                    PbFullScreenEditorActivity.this.dwP.aOI();
                }
            }
        });
        this.iLd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cnN();
                if (PbFullScreenEditorActivity.this.iJu != null && PbFullScreenEditorActivity.this.iJu.cqT() != null) {
                    if (!PbFullScreenEditorActivity.this.iJu.cqT().cUA()) {
                        PbFullScreenEditorActivity.this.iJu.qC(false);
                    }
                    PbFullScreenEditorActivity.this.iJu.cqT().tO(false);
                }
            }
        });
        this.iLg = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iLh = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iLi = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.iLj = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cnM();
            }
        });
        this.iLe = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.iLf = new o(this.mContext);
        this.iLf.a(this);
        this.iLe.setAdapter((ListAdapter) this.iLf);
    }

    private void cnK() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] iLr = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.iLe) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.iLr);
                    int x = ((int) motionEvent.getX()) - this.iLr[0];
                    int y = ((int) motionEvent.getY()) - this.iLr[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dwP.aMV();
                        PbFullScreenEditorActivity.this.dwP.aOI();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iLd);
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
        this.iLp = findViewById(R.id.scroll_view_child);
        this.iLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwP != null) {
                    PbFullScreenEditorActivity.this.dwP.aMV();
                    PbFullScreenEditorActivity.this.dwP.aOI();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iLd);
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

    private void bcO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iLb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTvName = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        this.iLc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.iLb != null && this.iLc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iLb.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iLb.getLayoutParams();
            layoutParams2.width = -2;
            this.iLb.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iLc.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.iLc.setLayoutParams(layoutParams3);
            this.iLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.pY(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.iLn = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.iLn != null) {
                pX(this.iLn.getEditorType() == 1);
                final String disableVoiceMessage = this.iLn.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dwP != null) {
                    com.baidu.tbadk.editortools.g mo = this.dwP.mo(6);
                    if (mo instanceof View) {
                        ((View) mo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.iLn.getThreadData();
                if (this.iLl != null) {
                    this.iLl.setThreadData(this.mThreadData);
                }
                if (this.iLm != null) {
                    this.iLm.setThreadData(this.mThreadData);
                }
                String content = this.iLn.getContent();
                if (this.iLn.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.iLn.getSubPbReplyPrefix();
                    this.iLd.ec(this.mSubPbReplyPrefix, content);
                } else {
                    this.iLd.BX(content);
                }
                WriteImagesInfo writeImagesInfo = this.iLn.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.iLf.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iLf.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.iLn.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.iLg.setVisibility(0);
                    this.iLh.setVoiceModel(voiceModel);
                    this.iLm.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l mr = this.dwP.mr(6);
                    if (mr != null && mr.dxa != null) {
                        mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dwP.be((View) this.dwP.mo(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.iLo = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cnN();
    }

    private void pX(boolean z) {
        this.iLk = (LinearLayout) findViewById(R.id.editbar_container);
        this.iLl = new u();
        this.iLl.pZ(z);
        if (this.iLn != null && this.iLn.getThreadData() != null) {
            this.iLl.qa(this.iLn.getThreadData().isBJH);
        }
        this.iLm = (t) this.iLl.dU(this.mContext);
        this.dwP = this.iLm.aOy();
        this.iLm.b(this);
        this.iLl.b(this);
        this.iLk.addView(this.dwP, new LinearLayout.LayoutParams(-1, -2));
        this.dwP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iLm.c(this);
        this.dwP.display();
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
        pY(false);
    }

    public void pY(boolean z) {
        Intent intent = new Intent();
        if (this.iLn == null) {
            this.iLn = new PbEditorData();
        }
        this.iLn.setContent(this.iLd.getText().toString());
        this.iLn.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.iLn.setWriteImagesInfo(this.mWriteImagesInfo);
        this.iLn.setVoiceModel(this.iLm.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.iLn);
        if (z) {
            if (this.iJu != null && this.iJu.cqT() != null && this.iJu.cqT().cUz()) {
                showToast(this.iJu.cqT().cUB());
                this.iJu.qC(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void yR(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.iLf.notifyDataSetChanged();
            }
            cnN();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void yS(int i) {
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
        if (this.iLm != null) {
            this.iLm.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cnL();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            as(intent);
                        } else {
                            au(intent);
                        }
                        this.iLf.p(this.mWriteImagesInfo.getChosedFiles());
                        this.iLf.notifyDataSetChanged();
                        cnN();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.iLd.aK(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cnL();
                    at(intent);
                    this.iLf.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iLf.notifyDataSetChanged();
                    cnN();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.iLd.vi(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cnL() {
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
            cnL();
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
            cnL();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gpi;
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
                    com.baidu.tieba.face.b.c(this.iLd);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cnM();
                    return;
                case 14:
                    cnL();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aOU().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aJB() == EmotionGroupType.BIG_EMOTION || qVar.aJB() == EmotionGroupType.USER_COLLECT) {
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
                                cnL();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.iLf.p(this.mWriteImagesInfo.getChosedFiles());
                                this.iLf.notifyDataSetChanged();
                                cnN();
                                return;
                            }
                            return;
                        }
                        this.iLd.b(qVar);
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
            this.iLm.setVoiceModel(voiceModel);
            this.iLg.setVisibility(0);
            this.iLh.setVoiceModel(voiceModel);
            cnN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        if (this.iLm.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.iLm.getVoiceModel().voiceId));
        }
        this.iLm.setVoiceModel(null);
        this.iLg.setVisibility(8);
        this.iLh.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mr = this.dwP.mr(6);
        if (mr != null && mr.dxa != null) {
            mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cnN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnN() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.iLd.getText().toString());
        boolean z4 = (this.iLm == null || this.iLm.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.iLc != null) {
            this.iLc.setEnabled(z);
        }
        if (z) {
            if (this.iLc != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iLc, (int) R.color.cp_link_tip_a);
            }
        } else if (this.iLc != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLc, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iLd, (int) R.color.cp_cont_b);
        this.iLd.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.iLj, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        cnN();
        if (this.iJu != null) {
            this.iJu.onChangeSkinType();
        }
        if (this.dwP != null) {
            this.dwP.onChangeSkinType(i);
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
        if (this.iJu != null) {
            this.iJu.onDestroy();
        }
        if (this.gpi != null) {
            this.gpi.removeBlackScreen();
        }
    }
}
