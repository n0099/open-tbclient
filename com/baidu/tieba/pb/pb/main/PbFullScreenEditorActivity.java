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
    private EditorScrollView eUg;
    private EditorTools eYO;
    private VoiceManager ioV;
    public bb khj;
    private View ldh = null;
    private TextView ldi = null;
    private TextView ldj = null;
    private PbFullScreenEditorInputView ldk;
    private SpanGroupManager ldl;
    private WholeDisplayGridView ldm;
    private r ldn;
    private LinearLayout ldo;
    private PlayVoiceBntNew ldp;
    private LinearLayout ldq;
    private ImageView ldr;
    private LinearLayout lds;
    private x ldt;
    private w ldu;
    private PbEditorData ldv;
    private PostWriteCallBackData ldw;
    private View ldx;
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
        this.ioV = new VoiceManager();
        this.ioV.onCreate(getPageContext());
        initView();
        initData();
        if (this.ldv != null && this.ldv.getEditorType() == 1 && this.ldk != null) {
            this.ldk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.khj = new bb();
        if (this.ldk != null) {
            this.khj.e(this.ldk);
        }
        if (this.ldw != null) {
            this.khj.h(this.ldw);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        byD();
        this.mTopLine = findViewById(R.id.view_line);
        this.eUg = (EditorScrollView) findViewById(R.id.scroll_view);
        this.eUg.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.eYO != null) {
                    PbFullScreenEditorActivity.this.eYO.btC();
                    PbFullScreenEditorActivity.this.eYO.bvs();
                }
                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.ldk);
            }
        });
        dfB();
        this.ldk = (PbFullScreenEditorInputView) findViewById(R.id.edit_content);
        this.ldk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eYO != null) {
                    PbFullScreenEditorActivity.this.eYO.btC();
                    PbFullScreenEditorActivity.this.eYO.bvs();
                }
            }
        });
        this.ldk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.dfE();
                if (PbFullScreenEditorActivity.this.khj != null && PbFullScreenEditorActivity.this.khj.diS() != null) {
                    if (!PbFullScreenEditorActivity.this.khj.diS().dNm()) {
                        PbFullScreenEditorActivity.this.khj.uy(false);
                    }
                    PbFullScreenEditorActivity.this.khj.diS().xQ(false);
                }
            }
        });
        this.ldl = new SpanGroupManager(this.ldk, getUniqueId());
        this.ldo = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.ldp = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.ldq = (LinearLayout) findViewById(R.id.layout_del_voice);
        this.ldr = (ImageView) findViewById(R.id.iv_delete_voice);
        this.ldq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.dfD();
            }
        });
        this.ldm = (WholeDisplayGridView) findViewById(R.id.gridview);
        this.ldn = new r(this.mContext);
        this.ldn.a(this);
        this.ldm.setAdapter((ListAdapter) this.ldn);
    }

    private void dfB() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] ldz = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.ldm) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.ldz);
                    int x = ((int) motionEvent.getX()) - this.ldz[0];
                    int y = ((int) motionEvent.getY()) - this.ldz[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.eYO.btC();
                        PbFullScreenEditorActivity.this.eYO.bvs();
                        com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.ldk);
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
        this.ldx = findViewById(R.id.scroll_view_child);
        this.ldx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.eYO != null) {
                    PbFullScreenEditorActivity.this.eYO.btC();
                    PbFullScreenEditorActivity.this.eYO.bvs();
                }
                com.baidu.adp.lib.util.l.showSoftKeyPad(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.ldk);
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

    private void byD() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.ldh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ldj = this.mNavigationBar.setCenterTextTitle(getString(R.string.pb_reply_floor));
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldj, R.color.cp_cont_b);
        this.ldi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.ldh != null && this.ldi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ldh.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ldh.getLayoutParams();
            layoutParams2.width = -2;
            this.ldh.setLayoutParams(layoutParams2);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.ldh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ldi.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds14);
            this.ldi.setLayoutParams(layoutParams3);
            this.ldi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.tR(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.ldv = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.ldv != null) {
                tQ(this.ldv.getEditorType() == 1);
                final String disableVoiceMessage = this.ldv.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.eYO != null) {
                    com.baidu.tbadk.editortools.h qM = this.eYO.qM(6);
                    if (qM instanceof View) {
                        ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.ldv.getThreadData();
                if (this.ldt != null) {
                    this.ldt.setThreadData(this.mThreadData);
                }
                if (this.ldu != null) {
                    this.ldu.setThreadData(this.mThreadData);
                }
                String content = this.ldv.getContent();
                if (this.ldv.getEditorType() == 1) {
                    this.mSubPbReplyPrefix = this.ldv.getSubPbReplyPrefix();
                    this.ldk.fN(this.mSubPbReplyPrefix, content);
                } else {
                    this.ldk.Kr(content);
                }
                WriteImagesInfo writeImagesInfo = this.ldv.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.ldn.p(this.mWriteImagesInfo.getChosedFiles());
                    this.ldn.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.ldv.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.ldo.setVisibility(0);
                    this.ldp.setVoiceModel(voiceModel);
                    this.ldu.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.m qP = this.eYO.qP(6);
                    if (qP != null && qP.eYZ != null) {
                        qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.eYO.bv((View) this.eYO.qM(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.ldw = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        dfE();
    }

    private void tQ(boolean z) {
        this.lds = (LinearLayout) findViewById(R.id.editbar_container);
        this.ldt = new x();
        this.ldt.tS(z);
        if (this.ldv != null && this.ldv.getThreadData() != null) {
            this.ldt.tT(this.ldv.getThreadData().isBJH);
        }
        this.ldu = (w) this.ldt.ei(this.mContext);
        this.eYO = this.ldu.bvf();
        this.ldu.d(this);
        this.ldt.b(this);
        this.lds.addView(this.eYO, new LinearLayout.LayoutParams(-1, -2));
        this.eYO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ldu.e(this);
        this.eYO.display();
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
        tR(false);
    }

    public void tR(boolean z) {
        String pbFullScreenEditorInputView;
        Intent intent = new Intent();
        if (this.ldv == null) {
            this.ldv = new PbEditorData();
        }
        if (this.ldl != null) {
            pbFullScreenEditorInputView = this.ldl.bpa();
        } else {
            pbFullScreenEditorInputView = this.ldk.toString();
        }
        this.ldv.setContent(pbFullScreenEditorInputView);
        this.ldv.setSubPbReplyPrefix(this.mSubPbReplyPrefix);
        this.ldv.setWriteImagesInfo(this.mWriteImagesInfo);
        this.ldv.setVoiceModel(this.ldu.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.ldv);
        if (z) {
            if (this.khj != null && this.khj.diS() != null && this.khj.diS().dNl()) {
                showToast(this.khj.diS().dNn());
                this.khj.uy(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Fg(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.ldn.notifyDataSetChanged();
            }
            dfE();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.r.a
    public void Fh(int i) {
        ImageFileInfo imageInfoAt = this.mWriteImagesInfo.getImageInfoAt(i);
        if (imageInfoAt != null && imageInfoAt.getImageType() != 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.mWriteImagesInfo, i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 0 && this.ldu != null) {
            this.ldu.bvO();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.ldu != null) {
            this.ldu.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        dfC();
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ad(intent);
                        } else {
                            af(intent);
                        }
                        this.ldn.p(this.mWriteImagesInfo.getChosedFiles());
                        this.ldn.notifyDataSetChanged();
                        dfE();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.ldk.aX(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dfC();
                    ae(intent);
                    this.ldn.p(this.mWriteImagesInfo.getChosedFiles());
                    this.ldn.notifyDataSetChanged();
                    dfE();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        this.ldk.Dc(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void dfC() {
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
            dfC();
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
            dfC();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ioV;
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
                    com.baidu.tieba.face.b.b(this.ldk);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        f((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    dfD();
                    return;
                case 14:
                    dfC();
                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumFloatActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    if (com.baidu.tbadk.editortools.pb.a.bvI().getStatus() == 1) {
                        albumFloatActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                        com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                        if (uVar.bqt() == EmotionGroupType.BIG_EMOTION || uVar.bqt() == EmotionGroupType.USER_COLLECT) {
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
                                dfC();
                                this.mWriteImagesInfo.addChooseFile(imageFileInfo);
                                this.mWriteImagesInfo.updateQuality();
                                this.ldn.p(this.mWriteImagesInfo.getChosedFiles());
                                this.ldn.notifyDataSetChanged();
                                dfE();
                                return;
                            }
                            return;
                        }
                        this.ldk.b(uVar);
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
            this.ldu.setVoiceModel(voiceModel);
            this.ldo.setVisibility(0);
            this.ldp.setVoiceModel(voiceModel);
            dfE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfD() {
        if (this.ldu.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BU(this.ldu.getVoiceModel().voiceId));
        }
        this.ldu.setVoiceModel(null);
        this.ldo.setVisibility(8);
        this.ldp.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qP = this.eYO.qP(6);
        if (qP != null && qP.eYZ != null) {
            qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dfE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfE() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.ldk.getText().toString());
        boolean z4 = (this.ldu == null || this.ldu.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.ldi != null) {
            this.ldi.setEnabled(z);
        }
        if (z) {
            if (this.ldi != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldi, R.color.cp_link_tip_a);
            }
        } else if (this.ldi != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldi, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldk, R.color.cp_cont_b);
        this.ldk.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_e));
        com.baidu.tbadk.core.util.ap.setImageResource(this.ldr, R.drawable.icon_edit_close_n);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldj, R.color.cp_cont_b);
        dfE();
        if (this.khj != null) {
            this.khj.onChangeSkinType();
        }
        if (this.eYO != null) {
            this.eYO.onChangeSkinType(i);
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
        if (this.khj != null) {
            this.khj.onDestroy();
        }
        if (this.ioV != null) {
            this.ioV.removeBlackScreen();
        }
    }
}
