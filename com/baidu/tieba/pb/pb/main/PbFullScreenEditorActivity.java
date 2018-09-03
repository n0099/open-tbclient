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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, n.a {
    private EditorTools aLP;
    private VoiceManager dmn;
    private LinearLayout fAa;
    private ImageView fAb;
    private LinearLayout fAc;
    private u fAd;
    private t fAe;
    private PbEditorData fAf;
    private PostWriteCallBackData fAg;
    private View fAh;
    public av fvt;
    private View fzR = null;
    private TextView fzS = null;
    private TextView fzT = null;
    private EditorScrollView fzU;
    private PbFullScreenEditorInputView fzV;
    private WholeDisplayGridView fzW;
    private n fzX;
    private LinearLayout fzY;
    private PlayVoiceBntNew fzZ;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private View mTopLine;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(f.h.layout_pb_editor_activity);
        this.dmn = new VoiceManager();
        this.dmn.onCreate(getPageContext());
        initView();
        initData();
        if (this.fAf != null && this.fAf.getEditorType() == 1 && this.fzV != null) {
            this.fzV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.fvt = new av();
        if (this.fzV != null) {
            this.fvt.g(this.fzV);
        }
        if (this.fAg != null) {
            this.fvt.f(this.fAg);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        asl();
        this.mTopLine = findViewById(f.g.view_line);
        this.fzU = (EditorScrollView) findViewById(f.g.scroll_view);
        this.fzU.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (PbFullScreenEditorActivity.this.aLP != null) {
                    PbFullScreenEditorActivity.this.aLP.FP();
                    PbFullScreenEditorActivity.this.aLP.HD();
                }
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.fzV);
            }
        });
        bbV();
        this.fzV = (PbFullScreenEditorInputView) findViewById(f.g.edit_content);
        this.fzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLP != null) {
                    PbFullScreenEditorActivity.this.aLP.FP();
                    PbFullScreenEditorActivity.this.aLP.HD();
                }
            }
        });
        this.fzV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.bbY();
                if (PbFullScreenEditorActivity.this.fvt != null && PbFullScreenEditorActivity.this.fvt.beL() != null) {
                    if (!PbFullScreenEditorActivity.this.fvt.beL().bFq()) {
                        PbFullScreenEditorActivity.this.fvt.ku(false);
                    }
                    PbFullScreenEditorActivity.this.fvt.beL().no(false);
                }
            }
        });
        this.fzY = (LinearLayout) findViewById(f.g.layout_voice_play);
        this.fzZ = (PlayVoiceBntNew) findViewById(f.g.btn_play_voice);
        this.fAa = (LinearLayout) findViewById(f.g.layout_del_voice);
        this.fAb = (ImageView) findViewById(f.g.iv_delete_voice);
        this.fAa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.bbX();
            }
        });
        this.fzW = (WholeDisplayGridView) findViewById(f.g.gridview);
        this.fzX = new n(this.mContext);
        this.fzX.a(this);
        this.fzW.setAdapter((ListAdapter) this.fzX);
    }

    private void bbV() {
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
            private int[] fAj = new int[2];

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                WholeDisplayGridView wholeDisplayGridView;
                if (motionEvent != null && (wholeDisplayGridView = PbFullScreenEditorActivity.this.fzW) != null) {
                    wholeDisplayGridView.getLocationInWindow(this.fAj);
                    int x = ((int) motionEvent.getX()) - this.fAj[0];
                    int y = ((int) motionEvent.getY()) - this.fAj[1];
                    if (x >= 0 && x < wholeDisplayGridView.getWidth() && y >= 0 && y < wholeDisplayGridView.getHeight() && wholeDisplayGridView.pointToPosition(x, y) == -1) {
                        PbFullScreenEditorActivity.this.aLP.FP();
                        PbFullScreenEditorActivity.this.aLP.HD();
                        com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fzV);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                com.baidu.adp.lib.util.l.a(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        });
        this.fAh = findViewById(f.g.scroll_view_child);
        this.fAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PbFullScreenEditorActivity.this.aLP != null) {
                    PbFullScreenEditorActivity.this.aLP.FP();
                    PbFullScreenEditorActivity.this.aLP.HD();
                }
                com.baidu.adp.lib.util.l.b(TbadkCoreApplication.getInst(), PbFullScreenEditorActivity.this.fzV);
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

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fzR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fzT = this.mNavigationBar.setCenterTextTitle(getString(f.j.pb_reply_floor));
        com.baidu.tbadk.core.util.am.h(this.fzT, f.d.cp_cont_b);
        this.fzS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.fzR != null && this.fzS != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzR.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getActivity(), f.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fzR.getLayoutParams();
            layoutParams2.width = -2;
            this.fzR.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(f.C0146f.write_close_selector, f.C0146f.write_close_selector);
            this.fzR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fzS.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(getActivity(), f.e.ds14);
            this.fzS.setLayoutParams(layoutParams3);
            this.fzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jN(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.fAf = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.fAf != null) {
                jM(this.fAf.getEditorType() == 1);
                final String disableVoiceMessage = this.fAf.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aLP != null) {
                    com.baidu.tbadk.editortools.g eK = this.aLP.eK(6);
                    if (eK instanceof View) {
                        ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.fAf.getThreadData();
                if (this.fAd != null) {
                    this.fAd.setThreadData(this.mThreadData);
                }
                if (this.fAe != null) {
                    this.fAe.setThreadData(this.mThreadData);
                }
                this.fzV.loadData(this.fAf.getContent());
                WriteImagesInfo writeImagesInfo = this.fAf.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.fzX.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fzX.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.fAf.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.fzY.setVisibility(0);
                    this.fzZ.setVoiceModel(voiceModel);
                    this.fAe.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.k eN = this.aLP.eN(6);
                    if (eN != null && eN.aMc != null) {
                        eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aLP.N((View) this.aLP.eK(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.fAg = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        bbY();
    }

    private void jM(boolean z) {
        this.fAc = (LinearLayout) findViewById(f.g.editbar_container);
        this.fAd = new u();
        this.fAd.jO(z);
        this.fAe = (t) this.fAd.aY(this.mContext);
        this.aLP = this.fAe.Ht();
        this.fAe.b(this);
        this.fAd.b(this);
        this.fAc.addView(this.aLP, new LinearLayout.LayoutParams(-1, -2));
        this.aLP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fAe.c(this);
        this.aLP.oC();
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
        jN(false);
    }

    public void jN(boolean z) {
        Intent intent = new Intent();
        if (this.fAf == null) {
            this.fAf = new PbEditorData();
        }
        this.fAf.setContent(this.fzV.getText().toString());
        this.fAf.setWriteImagesInfo(this.mWriteImagesInfo);
        this.fAf.setVoiceModel(this.fAe.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.fAf);
        if (z) {
            if (this.fvt != null && this.fvt.beL() != null && this.fvt.beL().bFp()) {
                showToast(this.fvt.beL().bFr());
                this.fvt.ku(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qA(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.fzX.notifyDataSetChanged();
            }
            bbY();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.n.a
    public void qB(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.fAe != null) {
            this.fAe.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        bbW();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            R(intent);
                        } else {
                            T(intent);
                        }
                        this.fzX.s(this.mWriteImagesInfo.getChosedFiles());
                        this.fzX.notifyDataSetChanged();
                        bbY();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.fzV.ao(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bbW();
                    S(intent);
                    this.fzX.s(this.mWriteImagesInfo.getChosedFiles());
                    this.fzX.notifyDataSetChanged();
                    bbY();
                    return;
                case 25004:
                    if (intent != null) {
                        this.fzV.gG(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bbW() {
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
            bbW();
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
            bbW();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmn;
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
                    com.baidu.tieba.face.b.b(this.fzV);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    bbX();
                    return;
                case 14:
                    bbW();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.HP().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.fzV.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.fAe.setVoiceModel(voiceModel);
            this.fzY.setVisibility(0);
            this.fzZ.setVoiceModel(voiceModel);
            bbY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbX() {
        if (this.fAe.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.fAe.getVoiceModel().voiceId));
        }
        this.fAe.setVoiceModel(null);
        this.fzY.setVisibility(8);
        this.fzZ.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eN = this.aLP.eN(6);
        if (eN != null && eN.aMc != null) {
            eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bbY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbY() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.fzV.getText().toString());
        boolean z4 = (this.fAe == null || this.fAe.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.fzS != null) {
            this.fzS.setEnabled(z);
        }
        if (z) {
            if (this.fzS != null) {
                com.baidu.tbadk.core.util.am.h(this.fzS, f.d.cp_link_tip_a);
            }
        } else if (this.fzS != null) {
            com.baidu.tbadk.core.util.am.h(this.fzS, f.d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.h(this.fzV, f.d.cp_cont_b);
        this.fzV.setHintTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_e));
        com.baidu.tbadk.core.util.am.c(this.fAb, f.C0146f.icon_edit_close_n);
        com.baidu.tbadk.core.util.am.j(this.mTopLine, f.d.cp_bg_line_c);
        if (this.fvt != null) {
            this.fvt.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        com.baidu.adp.lib.util.l.a(this, getCurrentFocus());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fvt != null) {
            this.fvt.onDestroy();
        }
    }
}
