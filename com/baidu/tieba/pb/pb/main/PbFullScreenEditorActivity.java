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
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
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
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, o.a {
    private EditorTools fBd;
    private EditorScrollView fwr;
    private VoiceManager jgu;
    public ar kWC;
    private View lTH = null;
    private TextView lTI = null;
    private TextView lTJ = null;
    private PbFullScreenEditorInputView lTK;
    private SpanGroupManager lTL;
    private WholeDisplayGridView lTM;
    private o lTN;
    private LinearLayout lTO;
    private PlayVoiceBntNew lTP;
    private LinearLayout lTQ;
    private ImageView lTR;
    private LinearLayout lTS;
    private t lTT;
    private s lTU;
    private PbEditorData lTV;
    private PostWriteCallBackData lTW;
    private View lTX;
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
        this.jgu = new VoiceManager();
        this.jgu.onCreate(getPageContext());
        initView();
        initData();
        if (this.lTV != null && this.lTV.getEditorType() == 1 && this.lTK != null) {
            this.lTK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kWC = new ar();
        if (this.lTK != null) {
            this.kWC.f(this.lTK);
        }
        if (this.lTW != null) {
            this.kWC.h(this.lTW);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bEL();
        this.mTopLine = findViewById(R.id.view_line);
        this.fwr = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fwr.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lTK);
            }
        });
        don();
        this.lTK = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
            }
        });
        this.lTK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.doq();
                if (PbFullScreenEditorActivity.this.kWC != null && PbFullScreenEditorActivity.this.kWC.drM() != null) {
                    if (!PbFullScreenEditorActivity.this.kWC.drM().dWy()) {
                        PbFullScreenEditorActivity.this.kWC.vQ(false);
                    }
                    PbFullScreenEditorActivity.this.kWC.drM().zu(false);
                }
            }
        });
        this.lTL = this.lTK.getSpanGroupManager();
        this.lTO = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lTP = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lTQ = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lTR = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dop();
            }
        });
        this.lTM = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lTN = new o(this.mContext);
        this.lTN.a(this);
        this.lTM.setAdapter((ListAdapter) this.lTN);
    }

    private void don() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lTZ = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lTM) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lTZ);
                    int x = ((int) motionEvent.getX()) - this.lTZ[0];
                    int y = ((int) motionEvent.getY()) - this.lTZ[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fBd.bzD();
                        PbFullScreenEditorActivity.this.fBd.bBu();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lTK);
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
        this.lTX = findViewById(R.id.scroll_view_child);
        this.lTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fBd != null) {
                    PbFullScreenEditorActivity.this.fBd.bzD();
                    PbFullScreenEditorActivity.this.fBd.bBu();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lTK);
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

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lTH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lTJ = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTJ, R.color.CAM_X0105);
        this.lTI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lTH != null && this.lTI != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lTH.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lTH.getLayoutParams();
            layoutParams2.width = -2;
            this.lTH.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lTI.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lTI.setLayoutParams(layoutParams3);
            this.lTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.vi(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lTV = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lTV != null) {
                vh(this.lTV.getEditorType() == 1);
                final String disableVoiceMessage = this.lTV.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fBd != null) {
                    com.baidu.tbadk.editortools.h qR = this.fBd.qR(6);
                    if (qR instanceof View) {
                        ((View) qR).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lTV.getThreadData();
                if (this.lTT != null) {
                    this.lTT.setThreadData(this.mThreadData);
                }
                if (this.lTU != null) {
                    this.lTU.setThreadData(this.mThreadData);
                }
                String content = this.lTV.getContent();
                if (this.lTV.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lTV.getSubPbReplyPrefix();
                    this.lTK.fT(this.mSubPbReplyPrefix, content);
                } else {
                    this.lTK.gL(content);
                }
                WriteImagesInfo writeImagesInfo = this.lTV.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lTN.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lTN.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lTV.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lTO.setVisibility(0);
                    this.lTP.setVoiceModel(voiceModel);
                    this.lTU.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qU = this.fBd.qU(6);
                    if (qU != null && qU.fBo != null) {
                        qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fBd.bL((View) this.fBd.qR(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lTW = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        doq();
    }

    private void vh(boolean z) {
        this.lTS = (LinearLayout) findViewById(R.id.editbar_container);
        this.lTT = new t();
        this.lTT.vj(z);
        if (this.lTV != null && this.lTV.getThreadData() != null) {
            this.lTT.vk(this.lTV.getThreadData().isBJH);
        }
        this.lTU = (s) this.lTT.fg(this.mContext);
        this.fBd = this.lTU.bBh();
        this.lTU.d(this);
        this.lTT.b(this);
        this.lTS.addView(this.fBd, new LinearLayout.LayoutParams(-1, -2));
        this.fBd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lTU.e(this);
        this.fBd.display();
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
        vi(false);
    }

    public void vi(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lTV == null) {
            this.lTV = new PbEditorData();
        }
        if (this.lTL != null) {
            pbFullScreenEditorInputView = this.lTL.bvd();
        } else {
            pbFullScreenEditorInputView = this.lTK.toString();
        }
        this.lTV.setContent(pbFullScreenEditorInputView);
        this.lTV.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lTV.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lTV.setVoiceModel(this.lTU.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lTV);
        if (z) {
            if (this.kWC != null && this.kWC.drM() != null && this.kWC.drM().dWx()) {
                showToast(this.kWC.drM().dWz());
                this.kWC.vQ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FE(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lTN.notifyDataSetChanged();
            }
            doq();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FF(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lTU != null) {
            this.lTU.bBQ();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lTU != null) {
            this.lTU.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        doo();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lTN.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lTN.notifyDataSetChanged();
                        doq();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lTK.aX(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    doo();
                    ad(intent);
                    this.lTN.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lTN.notifyDataSetChanged();
                    doq();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lTK.CQ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void doo() {
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
                    com.baidu.tbadk.core.util.o.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            doo();
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
            doo();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    com.baidu.tieba.face.b.d(this.lTK);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dop();
                    return;
                case 14:
                    doo();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bBK().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bwv() == EmotionGroupType.BIG_EMOTION || uVar.bwv() == EmotionGroupType.USER_COLLECT) {
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
                                imageFileInfo.setFilePath(uVar.getName());
                                imageFileInfo.width = uVar.getWidth();
                                imageFileInfo.height = uVar.getHeight();
                                doo();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lTN.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lTN.notifyDataSetChanged();
                                doq();
                                return;
                            }
                            return;
                        }
                        this.lTK.b(uVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.lTU.setVoiceModel(voiceModel);
            this.lTO.setVisibility(0);
            this.lTP.setVoiceModel(voiceModel);
            doq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dop() {
        if (this.lTU.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BL(this.lTU.getVoiceModel().voiceId));
        }
        this.lTU.setVoiceModel(null);
        this.lTO.setVisibility(8);
        this.lTP.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qU = this.fBd.qU(6);
        if (qU != null && qU.fBo != null) {
            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        doq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doq() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lTK.getText().toString());
        boolean z4 = (this.lTU == null || this.lTU.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lTI != null) {
            this.lTI.setEnabled(z);
        }
        if (z) {
            if (this.lTI != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTI, R.color.CAM_X0302);
            }
        } else if (this.lTI != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTI, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTK, R.color.CAM_X0105);
        this.lTK.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lTR, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lTJ, R.color.CAM_X0105);
        doq();
        if (this.kWC != null) {
            this.kWC.onChangeSkinType();
        }
        if (this.fBd != null) {
            this.fBd.onChangeSkinType(i);
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
        if (this.kWC != null) {
            this.kWC.onDestroy();
        }
        if (this.jgu != null) {
            this.jgu.removeBlackScreen();
        }
    }
}
