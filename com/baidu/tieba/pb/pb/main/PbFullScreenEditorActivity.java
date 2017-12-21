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
    private com.baidu.tbadk.editortools.i aBJ;
    private View ayf;
    private VoiceManager cHl;
    public at eTD;
    private ImageView eXA;
    private LinearLayout eXB;
    private u eXC;
    private t eXD;
    private PbEditorData eXE;
    private PostWriteCallBackData eXF;
    private View eXq = null;
    private TextView eXr = null;
    private TextView eXs = null;
    private EditorScrollView eXt;
    private PbFullScreenEditorInputView eXu;
    private WholeDisplayGridView eXv;
    private p eXw;
    private LinearLayout eXx;
    private PlayVoiceBntNew eXy;
    private LinearLayout eXz;
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
        this.cHl = new VoiceManager();
        this.cHl.onCreate(getPageContext());
        initView();
        initData();
        if (this.eXE != null && this.eXE.getEditorType() == 1 && this.eXu != null) {
            this.eXu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.eTD = new at();
        if (this.eXu != null) {
            this.eTD.g(this.eXu);
        }
        if (this.eXF != null) {
            this.eTD.e(this.eXF);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        anb();
        this.ayf = findViewById(d.g.view_line);
        this.eXt = (EditorScrollView) findViewById(d.g.scroll_view);
        this.eXt.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.aBJ.Bn();
                PbFullScreenEditorActivity.this.aBJ.Do();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.eXu);
            }
        });
        this.eXu = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.eXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aBJ.Bn();
                PbFullScreenEditorActivity.this.aBJ.Do();
            }
        });
        this.eXu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.aUi();
                if (PbFullScreenEditorActivity.this.eTD != null && PbFullScreenEditorActivity.this.eTD.aWW() != null) {
                    if (!PbFullScreenEditorActivity.this.eTD.aWW().bFH()) {
                        PbFullScreenEditorActivity.this.eTD.ka(false);
                    }
                    PbFullScreenEditorActivity.this.eTD.aWW().nU(false);
                }
            }
        });
        this.eXx = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.eXy = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.eXz = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.eXA = (ImageView) findViewById(d.g.iv_delete_voice);
        this.eXz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aUh();
            }
        });
        this.eXv = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.eXw = new p(this.mContext);
        this.eXw.a(this);
        this.eXv.setAdapter((ListAdapter) this.eXw);
    }

    private void anb() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.eXq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXs = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.i(this.eXs, d.C0095d.cp_cont_b);
        this.eXr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.eXq != null && this.eXr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXq.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXq.getLayoutParams();
            layoutParams2.width = -2;
            this.eXq.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.eXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eXr.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds14);
            this.eXr.setLayoutParams(layoutParams3);
            this.eXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.js(true);
                }
            });
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA) instanceof PbEditorData) {
            this.eXE = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.eXE != null) {
                jr(this.eXE.getEditorType() == 1);
                final String disableVoiceMessage = this.eXE.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aBJ != null) {
                    com.baidu.tbadk.editortools.l eN = this.aBJ.eN(6);
                    if (eN instanceof View) {
                        ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.eXE.getThreadData();
                if (this.eXC != null) {
                    this.eXC.setThreadData(this.mThreadData);
                }
                if (this.eXD != null) {
                    this.eXD.setThreadData(this.mThreadData);
                }
                this.eXu.loadData(this.eXE.getContent());
                WriteImagesInfo writeImagesInfo = this.eXE.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.eXw.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eXw.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.eXE.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.eXx.setVisibility(0);
                    this.eXy.setVoiceModel(voiceModel);
                    this.eXD.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r eP = this.aBJ.eP(6);
                    if (eP != null && eP.aBW != null) {
                        eP.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aBJ.M((View) this.aBJ.eN(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.eXF = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        aUi();
    }

    private void jr(boolean z) {
        this.eXB = (LinearLayout) findViewById(d.g.editbar_container);
        this.eXC = new u();
        this.eXC.jt(z);
        this.eXD = (t) this.eXC.aV(this.mContext);
        this.aBJ = this.eXD.De();
        this.eXD.d(this);
        this.eXC.b(this);
        this.eXB.addView(this.aBJ, new LinearLayout.LayoutParams(-1, -2));
        this.aBJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eXD.e(this);
        this.aBJ.lE();
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
        js(false);
    }

    public void js(boolean z) {
        Intent intent = new Intent();
        if (this.eXE == null) {
            this.eXE = new PbEditorData();
        }
        this.eXE.setContent(this.eXu.getText().toString());
        this.eXE.setWriteImagesInfo(this.mWriteImagesInfo);
        this.eXE.setVoiceModel(this.eXD.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.eXE);
        if (z) {
            if (this.eTD != null && this.eTD.aWW() != null && this.eTD.aWW().bFG()) {
                showToast(this.eTD.aWW().bFI());
                this.eTD.ka(true);
                return;
            }
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void pY(int i) {
        if (this.mWriteImagesInfo != null && this.mWriteImagesInfo.getChosedFiles() != null) {
            if (i >= 0 && i < this.mWriteImagesInfo.size()) {
                ImageFileInfo remove = this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                this.eXw.notifyDataSetChanged();
            }
            aUi();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.p.a
    public void pZ(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.mWriteImagesInfo, i)));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (this.eXD != null) {
            this.eXD.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        aUg();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        this.eXw.p(this.mWriteImagesInfo.getChosedFiles());
                        this.eXw.notifyDataSetChanged();
                        aUi();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.eXu.aj(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    aUg();
                    U(intent);
                    this.eXw.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eXw.notifyDataSetChanged();
                    aUi();
                    return;
                case 25004:
                    if (intent != null) {
                        this.eXu.fR(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aUg() {
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
            aUg();
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
            aUg();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHl;
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
                    com.baidu.tieba.face.b.b(this.eXu);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    aUh();
                    return;
                case 14:
                    aUg();
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.mWriteImagesInfo.toJsonString(), true, true);
                    albumActivityConfig.getIntent().putExtra("from", "pb");
                    if (this.mThreadData != null && !TextUtils.isEmpty(this.mThreadData.getForumId())) {
                        albumActivityConfig.getIntent().putExtra("forum_id", this.mThreadData.getForumId());
                    }
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    if (com.baidu.tbadk.editortools.pb.a.Dz().getStatus() == 1) {
                        albumActivityConfig.setRequestFrom(2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                    return;
                case 24:
                    if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.n) {
                        this.eXu.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.eXD.setVoiceModel(voiceModel);
            this.eXx.setVisibility(0);
            this.eXy.setVoiceModel(voiceModel);
            aUi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        if (this.eXD.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.eXD.getVoiceModel().voiceId));
        }
        this.eXD.setVoiceModel(null);
        this.eXx.setVisibility(8);
        this.eXy.setVoiceModel(null);
        com.baidu.tbadk.editortools.r eP = this.aBJ.eP(6);
        if (eP != null && eP.aBW != null) {
            eP.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        aUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUi() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.eXu.getText().toString());
        boolean z4 = (this.eXD == null || this.eXD.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.eXr != null) {
            this.eXr.setEnabled(z);
        }
        if (z) {
            if (this.eXr != null) {
                com.baidu.tbadk.core.util.aj.i(this.eXr, d.C0095d.cp_link_tip_a);
            }
        } else if (this.eXr != null) {
            com.baidu.tbadk.core.util.aj.i(this.eXr, d.C0095d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.i(this.eXu, d.C0095d.cp_cont_b);
        this.eXu.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.eXA, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.k(this.ayf, d.C0095d.cp_bg_line_c);
        if (this.eTD != null) {
            this.eTD.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTD != null) {
            this.eTD.onDestroy();
        }
    }
}
