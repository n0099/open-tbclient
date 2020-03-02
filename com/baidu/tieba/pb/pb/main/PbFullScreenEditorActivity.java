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
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, o.a {
    private EditorScrollView drx;
    private EditorTools dwp;
    private VoiceManager gol;
    public ap iHH;
    private PbEditorData iJA;
    private PostWriteCallBackData iJB;
    private View iJC;
    private PbFullScreenEditorInputView iJq;
    private WholeDisplayGridView iJr;
    private o iJs;
    private LinearLayout iJt;
    private PlayVoiceBntNew iJu;
    private LinearLayout iJv;
    private ImageView iJw;
    private LinearLayout iJx;
    private u iJy;
    private t iJz;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private String mSubPbReplyPrefix;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;
    private View iJo = null;
    private TextView iJp = null;
    private TextView mTvName = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(R.layout.layout_pb_editor_activity);
        this.gol = new VoiceManager();
        this.gol.onCreate(getPageContext());
        initView();
        initData();
        if (this.iJA != null && this.iJA.getEditorType() == 1 && this.iJq != null) {
            this.iJq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.iHH = new ap();
        if (this.iJq != null) {
            this.iHH.e(this.iJq);
        }
        if (this.iJB != null) {
            this.iHH.f(this.iJB);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bcJ();
        this.mTopLine = findViewById(R.id.view_line);
        this.drx = (EditorScrollView) findViewById(R.id.scroll_view);
        this.drx.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.dwp != null) {
                    PbFullScreenEditorActivity.this.dwp.aMQ();
                    PbFullScreenEditorActivity.this.dwp.aOD();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.iJq);
            }
        });
        cno();
        this.iJq = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.iJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwp != null) {
                    PbFullScreenEditorActivity.this.dwp.aMQ();
                    PbFullScreenEditorActivity.this.dwp.aOD();
                }
            }
        });
        this.iJq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.cnr();
                if (PbFullScreenEditorActivity.this.iHH != null && PbFullScreenEditorActivity.this.iHH.cqx() != null) {
                    if (!PbFullScreenEditorActivity.this.iHH.cqx().cUf()) {
                        PbFullScreenEditorActivity.this.iHH.qw(false);
                    }
                    PbFullScreenEditorActivity.this.iHH.cqx().tH(false);
                }
            }
        });
        this.iJt = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iJu = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iJv = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.iJw = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.cnq();
            }
        });
        this.iJr = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.iJs = new o(this.mContext);
        this.iJs.a(this);
        this.iJr.setAdapter((ListAdapter) this.iJs);
    }

    private void cno() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] iJE = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.iJr) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.iJE);
                    int x = ((int) motionEvent.getX()) - this.iJE[0];
                    int y = ((int) motionEvent.getY()) - this.iJE[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.dwp.aMQ();
                        PbFullScreenEditorActivity.this.dwp.aOD();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iJq);
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
        this.iJC = findViewById(R.id.scroll_view_child);
        this.iJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.dwp != null) {
                    PbFullScreenEditorActivity.this.dwp.aMQ();
                    PbFullScreenEditorActivity.this.dwp.aOD();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.iJq);
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

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.iJo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTvName = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        this.iJp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.iJo != null && this.iJp != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iJo.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJo.getLayoutParams();
            layoutParams2.width = -2;
            this.iJo.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.iJp.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.iJp.setLayoutParams(layoutParams3);
            this.iJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.iJA = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.iJA != null) {
                pR(this.iJA.getEditorType() == 1);
                final String disableVoiceMessage = this.iJA.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.dwp != null) {
                    com.baidu.tbadk.editortools.g mm = this.dwp.mm(6);
                    if (mm instanceof View) {
                        ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.iJA.getThreadData();
                if (this.iJy != null) {
                    this.iJy.setThreadData(this.mThreadData);
                }
                if (this.iJz != null) {
                    this.iJz.setThreadData(this.mThreadData);
                }
                String content = this.iJA.getContent();
                if (this.iJA.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.iJA.getSubPbReplyPrefix();
                    this.iJq.ee(this.mSubPbReplyPrefix, content);
                } else {
                    this.iJq.BW(content);
                }
                WriteImagesInfo writeImagesInfo = this.iJA.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.iJs.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iJs.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.iJA.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.iJt.setVisibility(0);
                    this.iJu.setVoiceModel(voiceModel);
                    this.iJz.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.l mp = this.dwp.mp(6);
                    if (mp != null && mp.dwA != null) {
                        mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.dwp.be((View) this.dwp.mm(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.iJB = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        cnr();
    }

    private void pR(boolean z) {
        this.iJx = (LinearLayout) findViewById(R.id.editbar_container);
        this.iJy = new u();
        this.iJy.pT(z);
        if (this.iJA != null && this.iJA.getThreadData() != null) {
            this.iJy.pU(this.iJA.getThreadData().isBJH);
        }
        this.iJz = (t) this.iJy.dV(this.mContext);
        this.dwp = this.iJz.aOt();
        this.iJz.b(this);
        this.iJy.b(this);
        this.iJx.addView(this.dwp, new LinearLayout.LayoutParams(-1, -2));
        this.dwp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iJz.c(this);
        this.dwp.display();
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
        if (this.iJA == null) {
            this.iJA = new PbEditorData();
        }
        this.iJA.setContent(this.iJq.getText().toString());
        this.iJA.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.iJA.setWriteImagesInfo(this.mWriteImagesInfo);
        this.iJA.setVoiceModel(this.iJz.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.iJA);
        if (z) {
            if (this.iHH != null && this.iHH.cqx() != null && this.iHH.cqx().cUe()) {
                showToast(this.iHH.cqx().cUg());
                this.iHH.qw(true);
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
                this.iJs.notifyDataSetChanged();
            }
            cnr();
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
        if (this.iJz != null) {
            this.iJz.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        cnp();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            as(intent);
                        } else {
                            au(intent);
                        }
                        this.iJs.p(this.mWriteImagesInfo.getChosedFiles());
                        this.iJs.notifyDataSetChanged();
                        cnr();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.iJq.aK(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cnp();
                    at(intent);
                    this.iJs.p(this.mWriteImagesInfo.getChosedFiles());
                    this.iJs.notifyDataSetChanged();
                    cnr();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.iJq.vh(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void cnp() {
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
            cnp();
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
            cnp();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gol;
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
                    com.baidu.tieba.face.b.c(this.iJq);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    cnq();
                    return;
                case 14:
                    cnp();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.aOP().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                        com.baidu.tbadk.coreExtra.data.q qVar = (com.baidu.tbadk.coreExtra.data.q) aVar.data;
                        if (qVar.aJw() == EmotionGroupType.BIG_EMOTION || qVar.aJw() == EmotionGroupType.USER_COLLECT) {
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
                                imageFileInfo.setFilePath(qVar.getName());
                                imageFileInfo.width = qVar.getWidth();
                                imageFileInfo.height = qVar.getHeight();
                                cnp();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.iJs.p(this.mWriteImagesInfo.getChosedFiles());
                                this.iJs.notifyDataSetChanged();
                                cnr();
                                return;
                            }
                            return;
                        }
                        this.iJq.b(qVar);
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
            this.iJz.setVoiceModel(voiceModel);
            this.iJt.setVisibility(0);
            this.iJu.setVoiceModel(voiceModel);
            cnr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnq() {
        if (this.iJz.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.iJz.getVoiceModel().voiceId));
        }
        this.iJz.setVoiceModel(null);
        this.iJt.setVisibility(8);
        this.iJu.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mp = this.dwp.mp(6);
        if (mp != null && mp.dwA != null) {
            mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cnr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnr() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.iJq.getText().toString());
        boolean z4 = (this.iJz == null || this.iJz.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.iJp != null) {
            this.iJp.setEnabled(z);
        }
        if (z) {
            if (this.iJp != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iJp, (int) R.color.cp_link_tip_a);
            }
        } else if (this.iJp != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iJp, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iJq, (int) R.color.cp_cont_b);
        this.iJq.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.am.setImageResource(this.iJw, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(this.mTvName, (int) R.color.cp_cont_b);
        cnr();
        if (this.iHH != null) {
            this.iHH.onChangeSkinType();
        }
        if (this.dwp != null) {
            this.dwp.onChangeSkinType(i);
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
        if (this.iHH != null) {
            this.iHH.onDestroy();
        }
        if (this.gol != null) {
            this.gol.removeBlackScreen();
        }
    }
}
