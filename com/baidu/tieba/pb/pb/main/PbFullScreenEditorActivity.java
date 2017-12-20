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
    private com.baidu.tbadk.editortools.i aBG;
    private View ayc;
    private VoiceManager cHh;
    public at eTy;
    private PostWriteCallBackData eXA;
    private View eXl = null;
    private TextView eXm = null;
    private TextView eXn = null;
    private EditorScrollView eXo;
    private PbFullScreenEditorInputView eXp;
    private WholeDisplayGridView eXq;
    private p eXr;
    private LinearLayout eXs;
    private PlayVoiceBntNew eXt;
    private LinearLayout eXu;
    private ImageView eXv;
    private LinearLayout eXw;
    private u eXx;
    private t eXy;
    private PbEditorData eXz;
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
        this.cHh = new VoiceManager();
        this.cHh.onCreate(getPageContext());
        initView();
        initData();
        if (this.eXz != null && this.eXz.getEditorType() == 1 && this.eXp != null) {
            this.eXp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        this.eTy = new at();
        if (this.eXp != null) {
            this.eTy.g(this.eXp);
        }
        if (this.eXA != null) {
            this.eTy.e(this.eXA);
        }
        adjustResizeForSoftInput();
    }

    private void initView() {
        ana();
        this.ayc = findViewById(d.g.view_line);
        this.eXo = (EditorScrollView) findViewById(d.g.scroll_view);
        this.eXo.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                PbFullScreenEditorActivity.this.aBG.Bn();
                PbFullScreenEditorActivity.this.aBG.Do();
                com.baidu.adp.lib.util.l.a(PbFullScreenEditorActivity.this.mContext, PbFullScreenEditorActivity.this.eXp);
            }
        });
        this.eXp = (PbFullScreenEditorInputView) findViewById(d.g.edit_content);
        this.eXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aBG.Bn();
                PbFullScreenEditorActivity.this.aBG.Do();
            }
        });
        this.eXp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PbFullScreenEditorActivity.this.aUh();
                if (PbFullScreenEditorActivity.this.eTy != null && PbFullScreenEditorActivity.this.eTy.aWV() != null) {
                    if (!PbFullScreenEditorActivity.this.eTy.aWV().bFG()) {
                        PbFullScreenEditorActivity.this.eTy.ka(false);
                    }
                    PbFullScreenEditorActivity.this.eTy.aWV().nU(false);
                }
            }
        });
        this.eXs = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.eXt = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.eXu = (LinearLayout) findViewById(d.g.layout_del_voice);
        this.eXv = (ImageView) findViewById(d.g.iv_delete_voice);
        this.eXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbFullScreenEditorActivity.this.aUg();
            }
        });
        this.eXq = (WholeDisplayGridView) findViewById(d.g.gridview);
        this.eXr = new p(this.mContext);
        this.eXr.a(this);
        this.eXq.setAdapter((ListAdapter) this.eXr);
    }

    private void ana() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.eXl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXn = this.mNavigationBar.setCenterTextTitle(getString(d.j.pb_reply_floor));
        com.baidu.tbadk.core.util.aj.i(this.eXn, d.C0096d.cp_cont_b);
        this.eXm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) && this.eXl != null && this.eXm != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXl.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds17);
            backImageView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXl.getLayoutParams();
            layoutParams2.width = -2;
            this.eXl.setLayoutParams(layoutParams2);
            this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
            this.eXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbFullScreenEditorActivity.this.onBackPressed();
                }
            });
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eXm.getLayoutParams();
            layoutParams3.width = -2;
            layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds14);
            this.eXm.setLayoutParams(layoutParams3);
            this.eXm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.6
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
            this.eXz = (PbEditorData) intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (this.eXz != null) {
                jr(this.eXz.getEditorType() == 1);
                final String disableVoiceMessage = this.eXz.getDisableVoiceMessage();
                if (!TextUtils.isEmpty(disableVoiceMessage) && this.aBG != null) {
                    com.baidu.tbadk.editortools.l eN = this.aBG.eN(6);
                    if (eN instanceof View) {
                        ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbFullScreenEditorActivity.this.showToast(disableVoiceMessage);
                            }
                        });
                    }
                }
                this.mThreadData = this.eXz.getThreadData();
                if (this.eXx != null) {
                    this.eXx.setThreadData(this.mThreadData);
                }
                if (this.eXy != null) {
                    this.eXy.setThreadData(this.mThreadData);
                }
                this.eXp.loadData(this.eXz.getContent());
                WriteImagesInfo writeImagesInfo = this.eXz.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    this.mWriteImagesInfo = writeImagesInfo;
                    this.eXr.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eXr.notifyDataSetChanged();
                }
                VoiceData.VoiceModel voiceModel = this.eXz.getVoiceModel();
                if (voiceModel != null && voiceModel.duration > 0 && !TextUtils.isEmpty(voiceModel.voiceId)) {
                    this.eXs.setVisibility(0);
                    this.eXt.setVoiceModel(voiceModel);
                    this.eXy.setVoiceModel(voiceModel);
                    com.baidu.tbadk.editortools.r eP = this.aBG.eP(6);
                    if (eP != null && eP.aBT != null) {
                        eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, voiceModel));
                    }
                    this.aBG.M((View) this.aBG.eN(6));
                }
            } else {
                return;
            }
        }
        if (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData) {
            this.eXA = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        aUh();
    }

    private void jr(boolean z) {
        this.eXw = (LinearLayout) findViewById(d.g.editbar_container);
        this.eXx = new u();
        this.eXx.jt(z);
        this.eXy = (t) this.eXx.aV(this.mContext);
        this.aBG = this.eXy.De();
        this.eXy.d(this);
        this.eXx.b(this);
        this.eXw.addView(this.aBG, new LinearLayout.LayoutParams(-1, -2));
        this.aBG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eXy.e(this);
        this.aBG.lE();
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
        if (this.eXz == null) {
            this.eXz = new PbEditorData();
        }
        this.eXz.setContent(this.eXp.getText().toString());
        this.eXz.setWriteImagesInfo(this.mWriteImagesInfo);
        this.eXz.setVoiceModel(this.eXy.getVoiceModel());
        intent.putExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA, this.eXz);
        if (z) {
            if (this.eTy != null && this.eTy.aWV() != null && this.eTy.aWV().bFF()) {
                showToast(this.eTy.aWV().bFH());
                this.eTy.ka(true);
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
                this.eXr.notifyDataSetChanged();
            }
            aUh();
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
        if (this.eXy != null) {
            this.eXy.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        aUf();
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        this.eXr.p(this.mWriteImagesInfo.getChosedFiles());
                        this.eXr.notifyDataSetChanged();
                        aUh();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        this.eXp.aj(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    aUf();
                    U(intent);
                    this.eXr.p(this.mWriteImagesInfo.getChosedFiles());
                    this.eXr.notifyDataSetChanged();
                    aUh();
                    return;
                case 25004:
                    if (intent != null) {
                        this.eXp.fR(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aUf() {
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
            aUf();
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
            aUf();
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHh;
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
                    com.baidu.tieba.face.b.b(this.eXp);
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        e((VoiceData.VoiceModel) aVar.data);
                        return;
                    }
                    return;
                case 11:
                    aUg();
                    return;
                case 14:
                    aUf();
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
                        this.eXp.b((com.baidu.tbadk.coreExtra.data.n) aVar.data);
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
            this.eXy.setVoiceModel(voiceModel);
            this.eXs.setVisibility(0);
            this.eXt.setVoiceModel(voiceModel);
            aUh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUg() {
        if (this.eXy.getVoiceModel() != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.eXy.getVoiceModel().voiceId));
        }
        this.eXy.setVoiceModel(null);
        this.eXs.setVisibility(8);
        this.eXt.setVoiceModel(null);
        com.baidu.tbadk.editortools.r eP = this.aBG.eP(6);
        if (eP != null && eP.aBT != null) {
            eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        aUh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        boolean z = false;
        boolean z2 = this.mWriteImagesInfo != null && this.mWriteImagesInfo.size() > 0;
        boolean z3 = !TextUtils.isEmpty(this.eXp.getText().toString());
        boolean z4 = (this.eXy == null || this.eXy.getVoiceModel() == null) ? false : true;
        if (z2 || z3 || z4) {
            z = true;
        }
        if (this.eXm != null) {
            this.eXm.setEnabled(z);
        }
        if (z) {
            if (this.eXm != null) {
                com.baidu.tbadk.core.util.aj.i(this.eXm, d.C0096d.cp_link_tip_a);
            }
        } else if (this.eXm != null) {
            com.baidu.tbadk.core.util.aj.i(this.eXm, d.C0096d.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aj.i(this.eXp, d.C0096d.cp_cont_b);
        this.eXp.setHintTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_cont_e));
        com.baidu.tbadk.core.util.aj.c(this.eXv, d.f.icon_edit_close_n);
        com.baidu.tbadk.core.util.aj.k(this.ayc, d.C0096d.cp_bg_line_c);
        if (this.eTy != null) {
            this.eTy.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTy != null) {
            this.eTy.onDestroy();
        }
    }
}
