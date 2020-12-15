package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
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
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, r.a {
    private EditorScrollView fpb;
    private EditorTools ftQ;
    private VoiceManager iSW;
    public bb kNm;
    private View lJM = null;
    private TextView lJN = null;
    private TextView lJO = null;
    private PbFullScreenEditorInputView lJP;
    private SpanGroupManager lJQ;
    private WholeDisplayGridView lJR;
    private r lJS;
    private LinearLayout lJT;
    private PlayVoiceBntNew lJU;
    private LinearLayout lJV;
    private ImageView lJW;
    private LinearLayout lJX;
    private x lJY;
    private w lJZ;
    private PbEditorData lKa;
    private PostWriteCallBackData lKb;
    private View lKc;
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
        this.iSW = new VoiceManager();
        this.iSW.onCreate(getPageContext());
        initView();
        initData();
        if (this.lKa != null && this.lKa.getEditorType() == 1 && this.lJP != null) {
            this.lJP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kNm = new bb();
        if (this.lJP != null) {
            this.kNm.e(this.lJP);
        }
        if (this.lKb != null) {
            this.kNm.h(this.lKb);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bFP();
        this.mTopLine = findViewById(R.id.view_line);
        this.fpb = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fpb.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.ftQ != null) {
                    PbFullScreenEditorActivity.this.ftQ.bAK();
                    PbFullScreenEditorActivity.this.ftQ.bCA();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lJP);
            }
        });
        dpX();
        this.lJP = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ftQ != null) {
                    PbFullScreenEditorActivity.this.ftQ.bAK();
                    PbFullScreenEditorActivity.this.ftQ.bCA();
                }
            }
        });
        this.lJP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dqa();
                if (PbFullScreenEditorActivity.this.kNm != null && PbFullScreenEditorActivity.this.kNm.dtt() != null) {
                    if (!PbFullScreenEditorActivity.this.kNm.dtt().dYq()) {
                        PbFullScreenEditorActivity.this.kNm.vE(false);
                    }
                    PbFullScreenEditorActivity.this.kNm.dtt().zc(false);
                }
            }
        });
        this.lJQ = this.lJP.getSpanGroupManager();
        this.lJT = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lJU = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lJV = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lJW = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dpZ();
            }
        });
        this.lJR = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lJS = new r(this.mContext);
        this.lJS.a(this);
        this.lJR.setAdapter((ListAdapter) this.lJS);
    }

    private void dpX() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lKe = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lJR) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lKe);
                    int x = ((int) motionEvent.getX()) - this.lKe[0];
                    int y = ((int) motionEvent.getY()) - this.lKe[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.ftQ.bAK();
                        PbFullScreenEditorActivity.this.ftQ.bCA();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lJP);
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
        this.lKc = findViewById(R.id.scroll_view_child);
        this.lKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.ftQ != null) {
                    PbFullScreenEditorActivity.this.ftQ.bAK();
                    PbFullScreenEditorActivity.this.ftQ.bCA();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lJP);
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

    private void bFP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lJM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lJO = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lJO, R.color.CAM_X0105);
        this.lJN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lJM != null && this.lJN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lJM.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lJM.getLayoutParams();
            layoutParams2.width = -2;
            this.lJM.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lJM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lJN.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lJN.setLayoutParams(layoutParams3);
            this.lJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.uW(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lKa = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lKa != null) {
                uV(this.lKa.getEditorType() == 1);
                final String disableVoiceMessage = this.lKa.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.ftQ != null) {
                    com.baidu.tbadk.editortools.h sg = this.ftQ.sg(6);
                    if (sg instanceof View) {
                        ((View) sg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lKa.getThreadData();
                if (this.lJY != null) {
                    this.lJY.setThreadData(this.mThreadData);
                }
                if (this.lJZ != null) {
                    this.lJZ.setThreadData(this.mThreadData);
                }
                String content = this.lKa.getContent();
                if (this.lKa.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lKa.getSubPbReplyPrefix();
                    this.lJP.fX(this.mSubPbReplyPrefix, content);
                } else {
                    this.lJP.hO(content);
                }
                WriteImagesInfo writeImagesInfo = this.lKa.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lJS.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lJS.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lKa.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lJT.setVisibility(0);
                    this.lJU.setVoiceModel(voiceModel);
                    this.lJZ.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m sj = this.ftQ.sj(6);
                    if (sj != null && sj.fub != null) {
                        sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.ftQ.bG((View) this.ftQ.sg(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lKb = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dqa();
    }

    private void uV(boolean z) {
        this.lJX = (LinearLayout) findViewById(R.id.editbar_container);
        this.lJY = new x();
        this.lJY.uX(z);
        if (this.lKa != null && this.lKa.getThreadData() != null) {
            this.lJY.uY(this.lKa.getThreadData().isBJH);
        }
        this.lJZ = (w) this.lJY.eN(this.mContext);
        this.ftQ = this.lJZ.bCn();
        this.lJZ.d(this);
        this.lJY.b(this);
        this.lJX.addView(this.ftQ, new LinearLayout.LayoutParams(-1, -2));
        this.ftQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lJZ.e(this);
        this.ftQ.su();
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
        uW(false);
    }

    public void uW(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lKa == null) {
            this.lKa = new PbEditorData();
        }
        if (this.lJQ != null) {
            pbFullScreenEditorInputView = this.lJQ.bwj();
        } else {
            pbFullScreenEditorInputView = this.lJP.toString();
        }
        this.lKa.setContent(pbFullScreenEditorInputView);
        this.lKa.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lKa.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lKa.setVoiceModel(this.lJZ.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lKa);
        if (z) {
            if (this.kNm != null && this.kNm.dtt() != null && this.kNm.dtt().dYp()) {
                showToast(this.kNm.dtt().dYr());
                this.kNm.vE(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void GZ(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lJS.notifyDataSetChanged();
            }
            dqa();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Ha(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lJZ != null) {
            this.lJZ.bCW();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lJZ != null) {
            this.lJZ.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        dpY();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ad(intent);
                        } else {
                            af(intent);
                        }
                        this.lJS.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lJS.notifyDataSetChanged();
                        dqa();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lJP.bd(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dpY();
                    ae(intent);
                    this.lJS.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lJS.notifyDataSetChanged();
                    dqa();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lJP.DQ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dpY() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void ad(Intent intent) {
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
                    com.baidu.tbadk.core.util.n.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            dpY();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void ae(Intent intent) {
        a(intent, false);
    }

    private void af(Intent intent) {
        a(intent, true);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            dpY();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSW;
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
                    com.baidu.tieba.face.b.b(this.lJP);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dpZ();
                    return;
                case 14:
                    dpY();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bCQ().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bxC() == EmotionGroupType.BIG_EMOTION || uVar.bxC() == EmotionGroupType.USER_COLLECT) {
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
                                dpY();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lJS.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lJS.notifyDataSetChanged();
                                dqa();
                                return;
                            }
                            return;
                        }
                        this.lJP.b(uVar);
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
            this.lJZ.setVoiceModel(voiceModel);
            this.lJT.setVisibility(0);
            this.lJU.setVoiceModel(voiceModel);
            dqa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpZ() {
        if (this.lJZ.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CI(this.lJZ.getVoiceModel().voiceId));
        }
        this.lJZ.setVoiceModel(null);
        this.lJT.setVisibility(8);
        this.lJU.setVoiceModel(null);
        com.baidu.tbadk.editortools.m sj = this.ftQ.sj(6);
        if (sj != null && sj.fub != null) {
            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dqa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqa() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lJP.getText().toString());
        boolean z4 = (this.lJZ == null || this.lJZ.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lJN != null) {
            this.lJN.setEnabled(z);
        }
        if (z) {
            if (this.lJN != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lJN, R.color.CAM_X0302);
            }
        } else if (this.lJN != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lJN, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lJP, R.color.CAM_X0105);
        this.lJP.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ap.setImageResource(this.lJW, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lJO, R.color.CAM_X0105);
        dqa();
        if (this.kNm != null) {
            this.kNm.onChangeSkinType();
        }
        if (this.ftQ != null) {
            this.ftQ.onChangeSkinType(i);
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
        if (this.kNm != null) {
            this.kNm.onDestroy();
        }
        if (this.iSW != null) {
            this.iSW.removeBlackScreen();
        }
    }
}
