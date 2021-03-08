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
    private EditorTools fCC;
    private EditorScrollView fxQ;
    private VoiceManager jie;
    public ar kYE;
    private View lVJ = null;
    private TextView lVK = null;
    private TextView lVL = null;
    private PbFullScreenEditorInputView lVM;
    private SpanGroupManager lVN;
    private WholeDisplayGridView lVO;
    private o lVP;
    private LinearLayout lVQ;
    private PlayVoiceBntNew lVR;
    private LinearLayout lVS;
    private ImageView lVT;
    private LinearLayout lVU;
    private t lVV;
    private s lVW;
    private PbEditorData lVX;
    private PostWriteCallBackData lVY;
    private View lVZ;
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
        this.jie = new VoiceManager();
        this.jie.onCreate(getPageContext());
        initView();
        initData();
        if (this.lVX != null && this.lVX.getEditorType() == 1 && this.lVM != null) {
            this.lVM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kYE = new ar();
        if (this.lVM != null) {
            this.kYE.f(this.lVM);
        }
        if (this.lVY != null) {
            this.kYE.h(this.lVY);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bEP();
        this.mTopLine = findViewById(R.id.view_line);
        this.fxQ = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fxQ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fCC != null) {
                    PbFullScreenEditorActivity.this.fCC.bzG();
                    PbFullScreenEditorActivity.this.fCC.bBx();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lVM);
            }
        });
        dow();
        this.lVM = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fCC != null) {
                    PbFullScreenEditorActivity.this.fCC.bzG();
                    PbFullScreenEditorActivity.this.fCC.bBx();
                }
            }
        });
        this.lVM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.doz();
                if (PbFullScreenEditorActivity.this.kYE != null && PbFullScreenEditorActivity.this.kYE.drV() != null) {
                    if (!PbFullScreenEditorActivity.this.kYE.drV().dWG()) {
                        PbFullScreenEditorActivity.this.kYE.vQ(false);
                    }
                    PbFullScreenEditorActivity.this.kYE.drV().zt(false);
                }
            }
        });
        this.lVN = this.lVM.getSpanGroupManager();
        this.lVQ = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lVR = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lVS = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lVT = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lVS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.doy();
            }
        });
        this.lVO = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lVP = new o(this.mContext);
        this.lVP.a(this);
        this.lVO.setAdapter((ListAdapter) this.lVP);
    }

    private void dow() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lWb = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lVO) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lWb);
                    int x = ((int) motionEvent.getX()) - this.lWb[0];
                    int y = ((int) motionEvent.getY()) - this.lWb[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fCC.bzG();
                        PbFullScreenEditorActivity.this.fCC.bBx();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lVM);
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
        this.lVZ = findViewById(R.id.scroll_view_child);
        this.lVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fCC != null) {
                    PbFullScreenEditorActivity.this.fCC.bzG();
                    PbFullScreenEditorActivity.this.fCC.bBx();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lVM);
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

    private void bEP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lVJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lVL = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lVL, R.color.CAM_X0105);
        this.lVK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lVJ != null && this.lVK != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lVJ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lVJ.getLayoutParams();
            layoutParams2.width = -2;
            this.lVJ.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lVK.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lVK.setLayoutParams(layoutParams3);
            this.lVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.lVX = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lVX != null) {
                vh(this.lVX.getEditorType() == 1);
                final String disableVoiceMessage = this.lVX.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fCC != null) {
                    com.baidu.tbadk.editortools.h qS = this.fCC.qS(6);
                    if (qS instanceof View) {
                        ((View) qS).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lVX.getThreadData();
                if (this.lVV != null) {
                    this.lVV.setThreadData(this.mThreadData);
                }
                if (this.lVW != null) {
                    this.lVW.setThreadData(this.mThreadData);
                }
                String content = this.lVX.getContent();
                if (this.lVX.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lVX.getSubPbReplyPrefix();
                    this.lVM.fT(this.mSubPbReplyPrefix, content);
                } else {
                    this.lVM.gR(content);
                }
                WriteImagesInfo writeImagesInfo = this.lVX.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lVP.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lVP.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lVX.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lVQ.setVisibility(0);
                    this.lVR.setVoiceModel(voiceModel);
                    this.lVW.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qV = this.fCC.qV(6);
                    if (qV != null && qV.fCN != null) {
                        qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fCC.bL((View) this.fCC.qS(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lVY = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        doz();
    }

    private void vh(boolean z) {
        this.lVU = (LinearLayout) findViewById(R.id.editbar_container);
        this.lVV = new t();
        this.lVV.vj(z);
        if (this.lVX != null && this.lVX.getThreadData() != null) {
            this.lVV.vk(this.lVX.getThreadData().isBJH);
        }
        this.lVW = (s) this.lVV.ff(this.mContext);
        this.fCC = this.lVW.bBk();
        this.lVW.d(this);
        this.lVV.b(this);
        this.lVU.addView(this.fCC, new LinearLayout.LayoutParams(-1, -2));
        this.fCC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lVW.e(this);
        this.fCC.display();
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
        if (this.lVX == null) {
            this.lVX = new PbEditorData();
        }
        if (this.lVN != null) {
            pbFullScreenEditorInputView = this.lVN.bvg();
        } else {
            pbFullScreenEditorInputView = this.lVM.toString();
        }
        this.lVX.setContent(pbFullScreenEditorInputView);
        this.lVX.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lVX.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lVX.setVoiceModel(this.lVW.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lVX);
        if (z) {
            if (this.kYE != null && this.kYE.drV() != null && this.kYE.drV().dWF()) {
                showToast(this.kYE.drV().dWH());
                this.kYE.vQ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FH(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lVP.notifyDataSetChanged();
            }
            doz();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void FI(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lVW != null) {
            this.lVW.bBT();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lVW != null) {
            this.lVW.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        dox();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lVP.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lVP.notifyDataSetChanged();
                        doz();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lVM.aX(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dox();
                    ad(intent);
                    this.lVP.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lVP.notifyDataSetChanged();
                    doz();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lVM.CX(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dox() {
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
            dox();
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
            dox();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jie;
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
                    com.baidu.tieba.face.b.d(this.lVM);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    doy();
                    return;
                case 14:
                    dox();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bBN().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bwy() == EmotionGroupType.BIG_EMOTION || uVar.bwy() == EmotionGroupType.USER_COLLECT) {
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
                                dox();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lVP.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lVP.notifyDataSetChanged();
                                doz();
                                return;
                            }
                            return;
                        }
                        this.lVM.b(uVar);
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
            this.lVW.setVoiceModel(voiceModel);
            this.lVQ.setVisibility(0);
            this.lVR.setVoiceModel(voiceModel);
            doz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        if (this.lVW.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BS(this.lVW.getVoiceModel().voiceId));
        }
        this.lVW.setVoiceModel(null);
        this.lVQ.setVisibility(8);
        this.lVR.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qV = this.fCC.qV(6);
        if (qV != null && qV.fCN != null) {
            qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        doz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doz() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lVM.getText().toString());
        boolean z4 = (this.lVW == null || this.lVW.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lVK != null) {
            this.lVK.setEnabled(z);
        }
        if (z) {
            if (this.lVK != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lVK, R.color.CAM_X0302);
            }
        } else if (this.lVK != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lVK, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lVM, R.color.CAM_X0105);
        this.lVM.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lVT, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lVL, R.color.CAM_X0105);
        doz();
        if (this.kYE != null) {
            this.kYE.onChangeSkinType();
        }
        if (this.fCC != null) {
            this.fCC.onChangeSkinType(i);
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
        if (this.kYE != null) {
            this.kYE.onDestroy();
        }
        if (this.jie != null) {
            this.jie.removeBlackScreen();
        }
    }
}
