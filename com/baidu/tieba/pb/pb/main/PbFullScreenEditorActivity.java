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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private View aIx;
    private EditorTools aLT;
    private VoiceManager djz;
    private PbEditorData fAa;
    private PostWriteCallBackData fAb;
    private View fAc;
    public av fvo;
    private View fzM = null;
    private TextView fzN = null;
    private TextView fzO = null;
    private EditorScrollView fzP;
    private PbFullScreenEditorInputView fzQ;
    private WholeDisplayGridView fzR;
    private n fzS;
    private LinearLayout fzT;
    private PlayVoiceBntNew fzU;
    private LinearLayout fzV;
    private ImageView fzW;
    private LinearLayout fzX;
    private u fzY;
    private t fzZ;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(d.i.layout_pb_editor_activity);
        this.djz = new VoiceManager();
        this.djz.onCreate(getPageContext());
        initView();
        initData();
        if (this.fAa != null && this.fAa.getEditorType() == 1 && this.fzQ != null) {
            this.fzQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fvo = new av();
        if (this.fzQ != null) {
            this.fvo.g(this.fzQ);
        }
        if (this.fAb != null) {
            this.fvo.f(this.fAb);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        arI();
        this.aIx = findViewById(d.g.view_line);
        this.fzP = (EditorScrollView) findViewById(d.g.scroll_view);
        this.fzP.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aLT != null) {
                    PbFullScreenEditorActivity.this.aLT.FT();
                    PbFullScreenEditorActivity.this.aLT.HI();
                }
                com.baidu.adp.lib.util.l.b(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fzQ);
            }
        });
        bdH();
        this.fzQ = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.fzQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLT != null) {
                    PbFullScreenEditorActivity.this.aLT.FT();
                    PbFullScreenEditorActivity.this.aLT.HI();
                }
            }
        });
        this.fzQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bdK();
                if (PbFullScreenEditorActivity.this.fvo != null && PbFullScreenEditorActivity.this.fvo.bgx() != null) {
                    if (!PbFullScreenEditorActivity.this.fvo.bgx().bGB()) {
                        PbFullScreenEditorActivity.this.fvo.kI(false);
                    }
                    PbFullScreenEditorActivity.this.fvo.bgx().nA(false);
                }
            }
        });
        this.fzT = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fzU = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fzV = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.fzW = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bdJ();
            }
        });
        this.fzR = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.fzS = new n(this.mContext);
        this.fzS.a(this);
        this.fzR.setAdapter((ListAdapter) this.fzS);
    }

    private void bdH() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fAe = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fzR) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fAe);
                    int x = ((int) motionEvent.getX()) - this.fAe[0];
                    int y = ((int) motionEvent.getY()) - this.fAe[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aLT.FT();
                        PbFullScreenEditorActivity.this.aLT.HI();
                        com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fzQ);
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
        this.fAc = findViewById(d.g.scroll_view_child);
        this.fAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLT != null) {
                    PbFullScreenEditorActivity.this.aLT.FT();
                    PbFullScreenEditorActivity.this.aLT.HI();
                }
                com.baidu.adp.lib.util.l.c(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fzQ);
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

    private void arI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fzM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fzO = this.mNavigationBar.setCenterTextTitle(getString(d.k.pb_reply_floor));
        com.baidu.tbadk.core.util.am.h(this.fzO, d.C0142d.cp_cont_b);
        this.fzN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fzM != null && this.fzN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzM.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fzM.getLayoutParams();
            layoutParams2.width = -2;
            this.fzM.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.fzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fzN.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds14);
            this.fzN.setLayoutParams(layoutParams3);
            this.fzN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.kb(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fAa = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fAa != null) {
                ka(this.fAa.getEditorType() == 1);
                final String disableVoiceMessage = this.fAa.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aLT != null) {
                    com.baidu.tbadk.editortools.g eK = this.aLT.eK(6);
                    if (eK instanceof View) {
                        ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fAa.getThreadData();
                if (this.fzY != null) {
                    this.fzY.setThreadData(this.mThreadData);
                }
                if (this.fzZ != null) {
                    this.fzZ.setThreadData(this.mThreadData);
                }
                this.fzQ.loadData(this.fAa.getContent());
                WriteImagesInfo writeImagesInfo = this.fAa.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fzS.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fzS.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fAa.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fzT.setVisibility(0);
                    this.fzU.setVoiceModel(voiceModel);
                    this.fzZ.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eN = this.aLT.eN(6);
                    if (eN != null && eN.aMf != null) {
                        eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aLT.N((View) this.aLT.eK(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fAb = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bdK();
    }

    private void ka(boolean z) {
        this.fzX = (LinearLayout) findViewById(d.g.editbar_container);
        this.fzY = new u();
        this.fzY.kc(z);
        this.fzZ = (t) this.fzY.aY(this.mContext);
        this.aLT = this.fzZ.Hy();
        this.fzZ.b(this);
        this.fzY.b(this);
        this.fzX.addView(this.aLT, new LinearLayout.LayoutParams(-1, -2));
        this.aLT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fzZ.c(this);
        this.aLT.oD();
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
        kb(false);
    }

    public void kb(boolean z) {
        Intent intent = new Intent();
        if (this.fAa == null) {
            this.fAa = new PbEditorData();
        }
        this.fAa.setContent(this.fzQ.getText().toString());
        this.fAa.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fAa.setVoiceModel(this.fzZ.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fAa);
        if (z) {
            if (this.fvo != null && this.fvo.bgx() != null && this.fvo.bgx().bGA()) {
                showToast(this.fvo.bgx().bGC());
                this.fvo.kI(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qD(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gf().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fzS.notifyDataSetChanged();
            }
            bdK();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qE(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fzZ != null) {
            this.fzZ.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bdI();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            R(intent);
                        } else {
                            T(intent);
                        }
                        this.fzS.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fzS.notifyDataSetChanged();
                        bdK();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fzQ.aq(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bdI();
                    S(intent);
                    this.fzS.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fzS.notifyDataSetChanged();
                    bdK();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fzQ.gK(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bdI() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void R(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ah(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.aj(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            bdI();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void S(Intent intent) {
        b(intent, false);
    }

    private void T(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            bdI();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.djz;
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
                    com.baidu.tieba.face.b.b(this.fzQ);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bdJ();
                    return;
                case 14:
                    bdI();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.HU().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fzQ.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fzZ.setVoiceModel(voiceModel);
            this.fzT.setVisibility(0);
            this.fzU.setVoiceModel(voiceModel);
            bdK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdJ() {
        if (this.fzZ.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aX(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fzZ.getVoiceModel().voiceId));
        }
        this.fzZ.setVoiceModel(null);
        this.fzT.setVisibility(8);
        this.fzU.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eN = this.aLT.eN(6);
        if (eN != null && eN.aMf != null) {
            eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bdK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdK() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fzQ.getText().toString());
        boolean z4 = (this.fzZ == null || this.fzZ.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fzN != null) {
            this.fzN.setEnabled(z);
        }
        if (z) {
            if (this.fzN != null) {
                com.baidu.tbadk.core.util.am.h(this.fzN, d.C0142d.cp_link_tip_a);
            }
        } else if (this.fzN != null) {
            com.baidu.tbadk.core.util.am.h(this.fzN, d.C0142d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.h(this.fzQ, d.C0142d.cp_cont_b);
        this.fzQ.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.fzW, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.j(this.aIx, d.C0142d.cp_bg_line_c);
        if (this.fvo != null) {
            this.fvo.onChangeSkinType();
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
        if (this.fvo != null) {
            this.fvo.onDestroy();
        }
    }
}
