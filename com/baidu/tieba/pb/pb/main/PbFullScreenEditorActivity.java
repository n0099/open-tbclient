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
    private EditorTools fDw;
    private EditorScrollView fyJ;
    private VoiceManager jfh;
    public ar kSQ;
    private View lPa = null;
    private TextView lPb = null;
    private TextView lPc = null;
    private PbFullScreenEditorInputView lPd;
    private SpanGroupManager lPe;
    private WholeDisplayGridView lPf;
    private o lPg;
    private LinearLayout lPh;
    private PlayVoiceBntNew lPi;
    private LinearLayout lPj;
    private ImageView lPk;
    private LinearLayout lPl;
    private t lPm;
    private s lPn;
    private PbEditorData lPo;
    private PostWriteCallBackData lPp;
    private View lPq;
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
        this.jfh = new VoiceManager();
        this.jfh.onCreate(getPageContext());
        initView();
        initData();
        if (this.lPo != null && this.lPo.getEditorType() == 1 && this.lPd != null) {
            this.lPd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kSQ = new ar();
        if (this.lPd != null) {
            this.kSQ.f(this.lPd);
        }
        if (this.lPp != null) {
            this.kSQ.h(this.lPp);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bIl();
        this.mTopLine = findViewById(R.id.view_line);
        this.fyJ = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fyJ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDf();
                    PbFullScreenEditorActivity.this.fDw.bEW();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lPd);
            }
        });
        dpK();
        this.lPd = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDf();
                    PbFullScreenEditorActivity.this.fDw.bEW();
                }
            }
        });
        this.lPd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dpN();
                if (PbFullScreenEditorActivity.this.kSQ != null && PbFullScreenEditorActivity.this.kSQ.dtj() != null) {
                    if (!PbFullScreenEditorActivity.this.kSQ.dtj().dXU()) {
                        PbFullScreenEditorActivity.this.kSQ.vF(false);
                    }
                    PbFullScreenEditorActivity.this.kSQ.dtj().zc(false);
                }
            }
        });
        this.lPe = this.lPd.getSpanGroupManager();
        this.lPh = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lPi = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lPj = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lPk = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dpM();
            }
        });
        this.lPf = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lPg = new o(this.mContext);
        this.lPg.a(this);
        this.lPf.setAdapter((ListAdapter) this.lPg);
    }

    private void dpK() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lPs = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lPf) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lPs);
                    int x = ((int) motionEvent.getX()) - this.lPs[0];
                    int y = ((int) motionEvent.getY()) - this.lPs[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fDw.bDf();
                        PbFullScreenEditorActivity.this.fDw.bEW();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lPd);
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
        this.lPq = findViewById(R.id.scroll_view_child);
        this.lPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDf();
                    PbFullScreenEditorActivity.this.fDw.bEW();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lPd);
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

    private void bIl() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lPa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lPc = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPc, R.color.CAM_X0105);
        this.lPb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lPa != null && this.lPb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPa.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lPa.getLayoutParams();
            layoutParams2.width = -2;
            this.lPa.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lPa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lPb.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lPb.setLayoutParams(layoutParams3);
            this.lPb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.uX(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.lPo = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lPo != null) {
                uW(this.lPo.getEditorType() == 1);
                final String disableVoiceMessage = this.lPo.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.fDw != null) {
                    com.baidu.tbadk.editortools.h ss = this.fDw.ss(6);
                    if (ss instanceof View) {
                        ((View) ss).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.lPo.getThreadData();
                if (this.lPm != null) {
                    this.lPm.setThreadData(this.mThreadData);
                }
                if (this.lPn != null) {
                    this.lPn.setThreadData(this.mThreadData);
                }
                String content = this.lPo.getContent();
                if (this.lPo.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lPo.getSubPbReplyPrefix();
                    this.lPd.fU(this.mSubPbReplyPrefix, content);
                } else {
                    this.lPd.hz(content);
                }
                WriteImagesInfo writeImagesInfo = this.lPo.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lPg.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lPg.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lPo.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lPh.setVisibility(0);
                    this.lPi.setVoiceModel(voiceModel);
                    this.lPn.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m sv = this.fDw.sv(6);
                    if (sv != null && sv.fDH != null) {
                        sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.fDw.bP((View) this.fDw.ss(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.lPp = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dpN();
    }

    private void uW(boolean z) {
        this.lPl = (LinearLayout) findViewById(R.id.editbar_container);
        this.lPm = new t();
        this.lPm.uY(z);
        if (this.lPo != null && this.lPo.getThreadData() != null) {
            this.lPm.uZ(this.lPo.getThreadData().isBJH);
        }
        this.lPn = (s) this.lPm.fj(this.mContext);
        this.fDw = this.lPn.bEJ();
        this.lPn.d(this);
        this.lPm.b(this);
        this.lPl.addView(this.fDw, new LinearLayout.LayoutParams(-1, -2));
        this.fDw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lPn.e(this);
        this.fDw.rV();
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
        uX(false);
    }

    public void uX(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.lPo == null) {
            this.lPo = new PbEditorData();
        }
        if (this.lPe != null) {
            pbFullScreenEditorInputView = this.lPe.byD();
        } else {
            pbFullScreenEditorInputView = this.lPd.toString();
        }
        this.lPo.setContent(pbFullScreenEditorInputView);
        this.lPo.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lPo.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lPo.setVoiceModel(this.lPn.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lPo);
        if (z) {
            if (this.kSQ != null && this.kSQ.dtj() != null && this.kSQ.dtj().dXT()) {
                showToast(this.kSQ.dtj().dXV());
                this.kSQ.vF(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void GR(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.lPg.notifyDataSetChanged();
            }
            dpN();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.o.a
    public void GS(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.lPn != null) {
            this.lPn.bFs();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lPn != null) {
            this.lPn.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        dpL();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lPg.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lPg.notifyDataSetChanged();
                        dpN();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lPd.bd(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dpL();
                    ad(intent);
                    this.lPg.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lPg.notifyDataSetChanged();
                    dpN();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lPd.DM(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dpL() {
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
                    com.baidu.tbadk.core.util.n.a("cameras", stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            dpL();
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
            dpL();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jfh;
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
                    com.baidu.tieba.face.b.d(this.lPd);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dpM();
                    return;
                case 14:
                    dpL();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bFm().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bzX() == EmotionGroupType.BIG_EMOTION || uVar.bzX() == EmotionGroupType.USER_COLLECT) {
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
                                dpL();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lPg.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lPg.notifyDataSetChanged();
                                dpN();
                                return;
                            }
                            return;
                        }
                        this.lPd.b(uVar);
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
            this.lPn.setVoiceModel(voiceModel);
            this.lPh.setVisibility(0);
            this.lPi.setVoiceModel(voiceModel);
            dpN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpM() {
        if (this.lPn.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CF(this.lPn.getVoiceModel().voiceId));
        }
        this.lPn.setVoiceModel(null);
        this.lPh.setVisibility(8);
        this.lPi.setVoiceModel(null);
        com.baidu.tbadk.editortools.m sv = this.fDw.sv(6);
        if (sv != null && sv.fDH != null) {
            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dpN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpN() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lPd.getText().toString());
        boolean z4 = (this.lPn == null || this.lPn.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lPb != null) {
            this.lPb.setEnabled(z);
        }
        if (z) {
            if (this.lPb != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPb, R.color.CAM_X0302);
            }
        } else if (this.lPb != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPb, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPd, R.color.CAM_X0105);
        this.lPd.setHintTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ao.setImageResource(this.lPk, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPc, R.color.CAM_X0105);
        dpN();
        if (this.kSQ != null) {
            this.kSQ.onChangeSkinType();
        }
        if (this.fDw != null) {
            this.fDw.onChangeSkinType(i);
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
        if (this.kSQ != null) {
            this.kSQ.onDestroy();
        }
        if (this.jfh != null) {
            this.jfh.removeBlackScreen();
        }
    }
}
