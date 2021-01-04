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
    private View lPb = null;
    private TextView lPc = null;
    private TextView lPd = null;
    private PbFullScreenEditorInputView lPe;
    private SpanGroupManager lPf;
    private WholeDisplayGridView lPg;
    private o lPh;
    private LinearLayout lPi;
    private PlayVoiceBntNew lPj;
    private LinearLayout lPk;
    private ImageView lPl;
    private LinearLayout lPm;
    private t lPn;
    private s lPo;
    private PbEditorData lPp;
    private PostWriteCallBackData lPq;
    private View lPr;
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
        if (this.lPp != null && this.lPp.getEditorType() == 1 && this.lPe != null) {
            this.lPe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.kSQ = new ar();
        if (this.lPe != null) {
            this.kSQ.f(this.lPe);
        }
        if (this.lPq != null) {
            this.kSQ.h(this.lPq);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        bIk();
        this.mTopLine = findViewById(R.id.view_line);
        this.fyJ = (EditorScrollView) findViewById(R.id.scroll_view);
        this.fyJ.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDe();
                    PbFullScreenEditorActivity.this.fDw.bEV();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.lPe);
            }
        });
        dpJ();
        this.lPe = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.lPe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDe();
                    PbFullScreenEditorActivity.this.fDw.bEV();
                }
            }
        });
        this.lPe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dpM();
                if (PbFullScreenEditorActivity.this.kSQ != null && PbFullScreenEditorActivity.this.kSQ.dti() != null) {
                    if (!PbFullScreenEditorActivity.this.kSQ.dti().dXT()) {
                        PbFullScreenEditorActivity.this.kSQ.vF(false);
                    }
                    PbFullScreenEditorActivity.this.kSQ.dti().zc(false);
                }
            }
        });
        this.lPf = this.lPe.getSpanGroupManager();
        this.lPi = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lPj = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lPk = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.lPl = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dpL();
            }
        });
        this.lPg = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.lPh = new o(this.mContext);
        this.lPh.a(this);
        this.lPg.setAdapter((ListAdapter) this.lPh);
    }

    private void dpJ() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] lPt = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.lPg) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.lPt);
                    int x = ((int) motionEvent.getX()) - this.lPt[0];
                    int y = ((int) motionEvent.getY()) - this.lPt[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.fDw.bDe();
                        PbFullScreenEditorActivity.this.fDw.bEV();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lPe);
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
        this.lPr = findViewById(R.id.scroll_view_child);
        this.lPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.fDw != null) {
                    PbFullScreenEditorActivity.this.fDw.bDe();
                    PbFullScreenEditorActivity.this.fDw.bEV();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.lPe);
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

    private void bIk() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.lPb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lPd = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPd, R.color.CAM_X0105);
        this.lPc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.lPb != null && this.lPc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPb.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lPb.getLayoutParams();
            layoutParams2.width = -2;
            this.lPb.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.lPb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lPc.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.lPc.setLayoutParams(layoutParams3);
            this.lPc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
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
            this.lPp = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.lPp != null) {
                uW(this.lPp.getEditorType() == 1);
                final String disableVoiceMessage = this.lPp.getDisableVoiceMessage();
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
                this.mThreadData = this.lPp.getThreadData();
                if (this.lPn != null) {
                    this.lPn.setThreadData(this.mThreadData);
                }
                if (this.lPo != null) {
                    this.lPo.setThreadData(this.mThreadData);
                }
                String content = this.lPp.getContent();
                if (this.lPp.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.lPp.getSubPbReplyPrefix();
                    this.lPe.fU(this.mSubPbReplyPrefix, content);
                } else {
                    this.lPe.hz(content);
                }
                WriteImagesInfo writeImagesInfo = this.lPp.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.lPh.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lPh.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.lPp.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.lPi.setVisibility(0);
                    this.lPj.setVoiceModel(voiceModel);
                    this.lPo.setVoiceModel(voiceModel);
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
            this.lPq = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dpM();
    }

    private void uW(boolean z) {
        this.lPm = (LinearLayout) findViewById(R.id.editbar_container);
        this.lPn = new t();
        this.lPn.uY(z);
        if (this.lPp != null && this.lPp.getThreadData() != null) {
            this.lPn.uZ(this.lPp.getThreadData().isBJH);
        }
        this.lPo = (s) this.lPn.fj(this.mContext);
        this.fDw = this.lPo.bEI();
        this.lPo.d(this);
        this.lPn.b(this);
        this.lPm.addView(this.fDw, new LinearLayout.LayoutParams(-1, -2));
        this.fDw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lPo.e(this);
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
        if (this.lPp == null) {
            this.lPp = new PbEditorData();
        }
        if (this.lPf != null) {
            pbFullScreenEditorInputView = this.lPf.byC();
        } else {
            pbFullScreenEditorInputView = this.lPe.toString();
        }
        this.lPp.setContent(pbFullScreenEditorInputView);
        this.lPp.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.lPp.setWriteImagesInfo(this.mWriteImagesInfo);
        this.lPp.setVoiceModel(this.lPo.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.lPp);
        if (z) {
            if (this.kSQ != null && this.kSQ.dti() != null && this.kSQ.dti().dXS()) {
                showToast(this.kSQ.dti().dXU());
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
                this.lPh.notifyDataSetChanged();
            }
            dpM();
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
        if (i == 0 && this.lPo != null) {
            this.lPo.bFr();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.lPo != null) {
            this.lPo.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        dpK();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ac(intent);
                        } else {
                            ae(intent);
                        }
                        this.lPh.p(this.mWriteImagesInfo.getChosedFiles());
                        this.lPh.notifyDataSetChanged();
                        dpM();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.lPe.bd(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dpK();
                    ad(intent);
                    this.lPh.p(this.mWriteImagesInfo.getChosedFiles());
                    this.lPh.notifyDataSetChanged();
                    dpM();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.lPe.DN(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dpK() {
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
            dpK();
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
            dpK();
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
                    com.baidu.tieba.face.b.d(this.lPe);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dpL();
                    return;
                case 14:
                    dpK();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.bFl().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bzW() == EmotionGroupType.BIG_EMOTION || uVar.bzW() == EmotionGroupType.USER_COLLECT) {
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
                                dpK();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.lPh.p(this.mWriteImagesInfo.getChosedFiles());
                                this.lPh.notifyDataSetChanged();
                                dpM();
                                return;
                            }
                            return;
                        }
                        this.lPe.b(uVar);
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
            this.lPo.setVoiceModel(voiceModel);
            this.lPi.setVisibility(0);
            this.lPj.setVoiceModel(voiceModel);
            dpM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpL() {
        if (this.lPo.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CG(this.lPo.getVoiceModel().voiceId));
        }
        this.lPo.setVoiceModel(null);
        this.lPi.setVisibility(8);
        this.lPj.setVoiceModel(null);
        com.baidu.tbadk.editortools.m sv = this.fDw.sv(6);
        if (sv != null && sv.fDH != null) {
            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dpM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpM() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.lPe.getText().toString());
        boolean z4 = (this.lPo == null || this.lPo.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.lPc != null) {
            this.lPc.setEnabled(z);
        }
        if (z) {
            if (this.lPc != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPc, R.color.CAM_X0302);
            }
        } else if (this.lPc != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPc, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPe, R.color.CAM_X0105);
        this.lPe.setHintTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0110));
        com.baidu.tbadk.core.util.ao.setImageResource(this.lPl, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPd, R.color.CAM_X0105);
        dpM();
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
