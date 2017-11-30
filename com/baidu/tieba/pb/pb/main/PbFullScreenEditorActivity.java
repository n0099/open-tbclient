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
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbFullScreenEditorActivity extends BaseActivity implements VoiceManager.c, com.baidu.tbadk.editortools.b, p.a {
    private com.baidu.tbadk.editortools.i aBB;
    private View axX;
    private VoiceManager cGZ;
    public at eSv;
    private View eWi = null;
    private TextView eWj = null;
    private TextView eWk = null;
    private EditorScrollView eWl;
    private PbFullScreenEditorInputView eWm;
    private WholeDisplayGridView eWn;
    private p eWo;
    private LinearLayout eWp;
    private PlayVoiceBntNew eWq;
    private LinearLayout eWr;
    private ImageView eWs;
    private LinearLayout eWt;
    private u eWu;
    private t eWv;
    private PbEditorData eWw;
    private PostWriteCallBackData eWx;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private PbEditorData.ThreadData mThreadData;
    private WriteImagesInfo mWriteImagesInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_pb_editor_activity);
        this.cGZ = new VoiceManager();
        this.cGZ.onCreate(getPageContext());
        initView();
        initData();
        if (this.eWw != null && this.eWw.getEditorType() == 1 && this.eWm != null) {
            this.eWm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.eSv = new at();
        if (this.eWm != null) {
            this.eSv.g(this.eWm);
        }
        if (this.eWx != null) {
            this.eSv.e(this.eWx);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        amS();
        this.axX = findViewById(d.g.view_line);
        this.eWl = (EditorScrollView) findViewById(d.g.scroll_view);
        this.eWl.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.aBB.Bm();
                PbFullScreenEditorActivity.this.aBB.Dn();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.eWm);
            }
        });
        this.eWm = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.eWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aBB.Bm();
                PbFullScreenEditorActivity.this.aBB.Dn();
            }
        });
        this.eWm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.aTZ();
                if (PbFullScreenEditorActivity.this.eSv != null && PbFullScreenEditorActivity.this.eSv.aWN() != null) {
                    if (!PbFullScreenEditorActivity.this.eSv.aWN().bEV()) {
                        PbFullScreenEditorActivity.this.eSv.jZ(false);
                    }
                    PbFullScreenEditorActivity.this.eSv.aWN().nT(false);
                }
            }
        });
        this.eWp = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.eWq = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.eWr = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.eWs = (ImageView) findViewById(d.g.iv_delete_voice);
        this.eWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aTY();
            }
        });
        this.eWn = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.eWo = new p(this.mContext);
        this.eWo.a(this);
        this.eWn.setAdapter((ListAdapter) this.eWo);
    }

    private void amS() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.eWi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWk = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.i(this.eWk, d.C0082d.cp_cont_b);
        this.eWj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.eWi != null && this.eWj != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWi.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWi.getLayoutParams();
            layoutParams2.width = -2;
            this.eWi.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.eWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eWj.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds14);
            this.eWj.setLayoutParams(layoutParams3);
            this.eWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.jr(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.eWw = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.eWw != null) {
                jq(this.eWw.getEditorType() == 1);
                final String disableVoiceMessage = this.eWw.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aBB != null) {
                    com.baidu.tbadk.editortools.l eN = this.aBB.eN(6);
                    if (eN instanceof View) {
                        ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.eWw.getThreadData();
                if (this.eWu != null) {
                    this.eWu.setThreadData(this.mThreadData);
                }
                if (this.eWv != null) {
                    this.eWv.setThreadData(this.mThreadData);
                }
                this.eWm.loadData(this.eWw.getContent());
                WriteImagesInfo writeImagesInfo = this.eWw.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.eWo.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eWo.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.eWw.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.eWp.setVisibility(0);
                    this.eWq.setVoiceModel(voiceModel);
                    this.eWv.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r eP = this.aBB.eP(6);
                    if (eP != null && eP.aBO != null) {
                        eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aBB.L((View) this.aBB.eN(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.eWx = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        aTZ();
    }

    private void jq(boolean z) {
        this.eWt = (LinearLayout) findViewById(d.g.editbar_container);
        this.eWu = new u();
        this.eWu.js(z);
        this.eWv = (t) this.eWu.aY(this.mContext);
        this.aBB = this.eWv.Dd();
        this.eWv.d(this);
        this.eWu.b(this);
        this.eWt.addView(this.aBB, new LinearLayout.LayoutParams(-1, -2));
        this.aBB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eWv.e(this);
        this.aBB.lE();
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
        jr(false);
    }

    public void jr(boolean z) {
        Intent intent = new Intent();
        if (this.eWw == null) {
            this.eWw = new PbEditorData();
        }
        this.eWw.setContent(this.eWm.getText().toString());
        this.eWw.setWriteImagesInfo(this.mWriteImagesInfo);
        this.eWw.setVoiceModel(this.eWv.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.eWw);
        if (z) {
            if (this.eSv != null && this.eSv.aWN() != null && this.eSv.aWN().bEU()) {
                showToast(this.eSv.aWN().bEW());
                this.eSv.jZ(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void pR(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.eWo.notifyDataSetChanged();
            }
            aTZ();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void pS(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), 12012, this.mWriteImagesInfo, i)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.eWv != null) {
            this.eWv.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        aTX();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        this.eWo.p(this.mWriteImagesInfo.getChosedFiles());
                        this.eWo.notifyDataSetChanged();
                        aTZ();
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.eWm.ai(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12012:
                    aTX();
                    U(intent);
                    this.eWo.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eWo.notifyDataSetChanged();
                    aTZ();
                    return;
                case 25004:
                    if (intent != null) {
                        this.eWm.fS(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aTX() {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
    }

    private void T(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + stringExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ac(this.mContext)), com.baidu.adp.lib.util.l.dip2px(this.mContext, com.baidu.adp.lib.util.l.ae(this.mContext)));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, stringExtra, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            aTX();
            this.mWriteImagesInfo.addChooseFile(imageFileInfo);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    private void U(Intent intent) {
        b(intent, false);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            aTX();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cGZ;
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
                    com.baidu.tieba.face.b.b(this.eWm);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    aTY();
                    return;
                case 14:
                    aTX();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(12002);
                    if (com.baidu.tbadk.editortools.pb.a.Dy().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.m) {
                        this.eWm.b((com.baidu.tbadk.coreExtra.data.m) aVar.data);
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
            this.eWv.setVoiceModel(voiceModel);
            this.eWp.setVisibility(0);
            this.eWq.setVoiceModel(voiceModel);
            aTZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTY() {
        if (this.eWv.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.eWv.getVoiceModel().voiceId));
        }
        this.eWv.setVoiceModel(null);
        this.eWp.setVisibility(8);
        this.eWq.setVoiceModel(null);
        com.baidu.tbadk.editortools.r eP = this.aBB.eP(6);
        if (eP != null && eP.aBO != null) {
            eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        aTZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTZ() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.eWm.getText().toString());
        boolean z4 = (this.eWv == null || this.eWv.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.eWj != null) {
            this.eWj.setEnabled(z);
        }
        if (z) {
            if (this.eWj != null) {
                com.baidu.tbadk.core.util.aj.i(this.eWj, d.C0082d.cp_link_tip_a);
            }
        } else if (this.eWj != null) {
            com.baidu.tbadk.core.util.aj.i(this.eWj, d.C0082d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.i(this.eWm, d.C0082d.cp_cont_b);
        this.eWm.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.eWs, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.k(this.axX, d.C0082d.cp_bg_line_c);
        if (this.eSv != null) {
            this.eSv.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eSv != null) {
            this.eSv.onDestroy();
        }
    }
}
