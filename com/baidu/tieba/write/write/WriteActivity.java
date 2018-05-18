package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.d.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0045a, VoiceManager.c, t.a, d.a {
    private static int hiI = 0;
    private EditorTools aCT;
    private String aEv;
    private LocationModel aEw;
    private NewWriteModel aEx;
    private VoiceManager cYn;
    private ImageView fkA;
    private LinearLayout fkx;
    private PlayVoiceBntNew fky;
    private TextView gmW;
    private com.baidu.tieba.write.d gmX;
    private ImageView gmY;
    private View gmZ;
    private int gmz;
    private AdditionData hhA;
    private RelativeLayout hhB;
    private TextView hhC;
    private TextView hhD;
    private TextView hhE;
    List<v> hhF;
    v hhG;
    private int hhH;
    private String hhI;
    private int hhJ;
    private PostCategoryView hhK;
    private HotTopicBussinessData hhN;
    private TextView hhO;
    private com.baidu.tieba.write.editor.b hhQ;
    private e hhT;
    private LinearLayout hhu;
    private LinearLayout hhv;
    private View hhx;
    private Toast hhz;
    private View hiM;
    private View hiN;
    private TextView hiO;
    private com.baidu.tieba.d.c hiR;
    private com.baidu.tieba.view.b hia;
    private View hik;
    private g hir;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hhr = "";
    private boolean hhs = false;
    private WriteData mData = null;
    private boolean hig = false;
    private boolean hht = false;
    private boolean hih = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gmR = null;
    private HeadImageView hii = null;
    private View gmS = null;
    private LinearLayout gmU = null;
    private EditText gmV = null;
    private FeedBackModel hhw = null;
    private FeedBackTopListView hij = null;
    private ArrayList<WritePrefixItemLayout> hhy = new ArrayList<>();
    private String eJO = null;
    private final KeyEvent cLp = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private TextView hil = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a him = null;
    private final Handler mHandler = new Handler();
    private boolean hin = false;
    private String hio = null;
    private RelativeLayout mParent = null;
    private String aEB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEC = 0;
    private int hip = 0;
    private WriteImagesInfo hiq = new WriteImagesInfo();
    private View mRootView = null;
    private GridView his = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hit = null;
    private ScrollView hhL = null;
    private EditText hiu = null;
    private View hiv = null;
    private View hiw = null;
    private View hix = null;
    private EditText hiy = null;
    private TextView hiz = null;
    private TextView hiA = null;
    private TextWatcher hiB = null;
    private TextWatcher hiC = null;
    private boolean hhM = false;
    private boolean hiD = false;
    private com.baidu.tbadk.core.view.a aNd = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hiE = null;
    private TbImageView hiF = null;
    private View mBubbleView = null;
    private Dialog hiG = null;
    private LinearLayout hiH = null;
    private boolean hiJ = false;
    private long hiK = -1000;
    private boolean hiL = false;
    private String gMy = "2";
    private int hct = 0;
    private String hiP = "";
    private SpannableStringBuilder hhP = new SpannableStringBuilder();
    private boolean hiQ = false;
    private boolean hhR = false;
    private final b hhS = new b();
    private final HttpMessageListener hiS = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eJO)) {
                    WriteActivity.this.eJO = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.ny(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eJO)) {
                    WriteActivity.this.eJO = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eJO);
                    WriteActivity.this.ny(true);
                }
            }
        }
    };
    private TbFaceManager.a hhU = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gC(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kl());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.d(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cZl = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajb));
        }
    };
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.apB();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hhS.ax(null);
                if (z) {
                    WriteActivity.this.bF(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                t.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                t.c(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.b("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.w(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hiP)) {
                            TiebaStatic.log(new al("c11731").ac(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hiP));
                        }
                    }
                    WriteActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hhS.ax(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hhS.uE(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hhS.b(WriteActivity.this.gmR, WriteActivity.this.gmV);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yK());
                    if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yJ());
                        if (WriteActivity.this.hih) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aEJ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Es() {
            WriteActivity.this.showToast(d.k.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gq(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.k.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsy())) {
                WriteActivity.this.b(2, true, aVar.bsy());
            } else {
                gq(null);
            }
        }
    };
    private final CustomMessageListener gzI = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aEw.mu(false);
                    WriteActivity.this.aEw.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aEw.mu(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hhV = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hhW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bCW = WriteActivity.this.bCW();
            if (bCW >= 0 && bCW < WriteActivity.this.gmV.getText().length()) {
                WriteActivity.this.gmV.setSelection(bCW);
            }
        }
    };
    private boolean hhX = true;
    private final View.OnFocusChangeListener gmP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            if (view2 == WriteActivity.this.gmR || view2 == WriteActivity.this.asg || view2 == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hhX = true;
                    WriteActivity.this.bCX();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.gmR);
                    if (WriteActivity.this.aCT != null) {
                        WriteActivity.this.aCT.BY();
                    }
                } else if (view2 == WriteActivity.this.gmR) {
                    WriteActivity.this.gmW.setVisibility(0);
                }
            }
            if (view2 == WriteActivity.this.gmV && z) {
                WriteActivity.this.hhX = false;
                WriteActivity.this.bCX();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.gmV);
                if (WriteActivity.this.aCT != null) {
                    WriteActivity.this.aCT.BY();
                }
            }
            WriteActivity.this.bDd();
        }
    };
    private TextWatcher hhY = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hic = "";
        private String hie;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hie = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hie != null ? this.hie.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnQ();
            WriteActivity.this.bDe();
            EditText bDp = WriteActivity.this.bDp();
            if (editable != null && bDp != null && bDp.getText() != null) {
                if (this.hic == null || !this.hic.equals(editable.toString())) {
                    if (WriteActivity.this.hhS != null) {
                        this.hic = bDp.getText().toString();
                        WriteActivity.this.hhS.k(bDp);
                        return;
                    }
                    return;
                }
                bDp.setSelection(bDp.getSelectionEnd());
            }
        }
    };
    private TextWatcher hhZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hie;
        private String hif = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hie = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hie != null ? this.hie.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnQ();
            EditText bDo = WriteActivity.this.bDo();
            if (editable != null && bDo != null && bDo.getText() != null) {
                if (this.hif == null || !this.hif.equals(editable.toString())) {
                    if (WriteActivity.this.hhS != null) {
                        this.hif = bDo.getText().toString();
                        WriteActivity.this.hhS.k(bDo);
                        return;
                    }
                    return;
                }
                bDo.setSelection(bDo.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0215a frr = new a.InterfaceC0215a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0215a
        public void onRefresh() {
            WriteActivity.this.eJO = null;
            WriteActivity.this.ny(false);
            WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ee() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Ef() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Eg();
        } else if (this.aEw.bsG()) {
            Ee();
        } else {
            this.aEw.mu(false);
            b(1, true, null);
            this.aEw.bsE();
        }
    }

    private void Eg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aEw.abu();
                } else {
                    WriteActivity.this.aEJ.Es();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCW() {
        int selectionEnd = bDo().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bDo().getText().getSpans(0, bDo().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bDo().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bDo().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        if (this.aCT != null) {
            this.aCT.setBarLauncherEnabled(!this.hhX);
            this.aCT.setBarLauncherEnabled(true, 26);
            this.aCT.setBarLauncherEnabled(true, 2);
            K(9, this.hhX ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g eF;
        if (this.aCT != null && (eF = this.aCT.eF(i)) != null) {
            if (z) {
                eF.lM();
            } else {
                eF.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hhM) {
            this.gmR.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hix.setVisibility(8);
            } else {
                this.hix.setVisibility(0);
            }
            a(this.hiA, this.hiu);
            a(this.hiz, this.hiy);
            bnQ();
        }
        if (this.hig) {
            this.hhX = true;
            bCX();
            if (this.aCT != null) {
                this.aCT.BY();
            }
            this.gmR.requestFocus();
            ShowSoftKeyPadDelay(this.gmR);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (intent != null && (stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING")) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            bDM();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bDx();
            }
            nz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mData.getType() == 0) {
            vh(this.hct);
        }
        initUI();
        bDC();
        this.aEw = new LocationModel(this);
        this.aEw.a(this.aEJ);
        registerListener(this.gzI);
        registerListener(this.hhV);
        initEditor();
        bDO();
        if (this.hhM) {
            this.hit.setEditorTools(this.aCT);
        } else {
            this.gmV.requestFocus();
        }
        bjV();
        bDx();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCT = new EditorTools(getActivity());
        this.aCT.setBarMaxLauCount(5);
        this.aCT.setMoreButtonAtEnd(true);
        this.aCT.setBarLauncherType(1);
        this.aCT.bx(true);
        this.aCT.by(true);
        this.aCT.setMoreLauncherIcon(d.f.write_more);
        this.aCT.setBackgroundColorId(d.C0126d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bDA();
                break;
            default:
                bCY();
                break;
        }
        this.aCT.DE();
        if (this.hhu != null) {
            this.hhu.addView(this.aCT);
        }
        bCZ();
        this.aCT.lM();
        com.baidu.tbadk.editortools.g eF = this.aCT.eF(6);
        if (eF != null && !TextUtils.isEmpty(this.aEB)) {
            ((View) eF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    WriteActivity.this.showToast(WriteActivity.this.aEB);
                }
            });
        }
        if (!this.hhM) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCT.BY();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bDb();
    }

    private void bDy() {
        this.hiv = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hix = this.hiv.findViewById(d.g.live_post_title_container);
        this.hiu = (EditText) this.hiv.findViewById(d.g.live_post_content);
        this.his = (GridView) this.hiv.findViewById(d.g.photoLiveGridView);
        this.hiy = (EditText) this.hiv.findViewById(d.g.live_post_title);
        this.hiz = (TextView) this.hiv.findViewById(d.g.titleOverPlusNumber);
        this.hiA = (TextView) this.hiv.findViewById(d.g.contentOverPlusNumber);
        this.hiw = this.hiv.findViewById(d.g.live_interval_view);
        this.hiz.setText(String.valueOf(20));
        this.hiA.setText(String.valueOf(233));
        this.hiv.setVisibility(0);
        this.hiz.setVisibility(0);
        this.hiA.setVisibility(0);
        this.hiy.setHint(d.k.tips_title_limit_new);
        this.hiy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    WriteActivity.this.hiD = true;
                    WriteActivity.this.hhX = true;
                    WriteActivity.this.bCX();
                    if (WriteActivity.this.aCT != null) {
                        WriteActivity.this.aCT.BY();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hiu.setHint(d.k.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hiu.setHint(d.k.live_write_input_content_update);
        }
        this.hiu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    WriteActivity.this.hiD = false;
                    WriteActivity.this.hhX = false;
                    WriteActivity.this.bCX();
                    if (WriteActivity.this.aCT != null) {
                        WriteActivity.this.aCT.BY();
                    }
                }
            }
        });
        this.hiu.requestFocus();
        this.hiu.addTextChangedListener(bDE());
        this.hiy.requestFocus();
        this.hiy.addTextChangedListener(bDE());
        this.hiy.setOnClickListener(this.hhW);
        this.hiu.setOnClickListener(this.hhW);
        this.hit = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.his);
        this.hit.vb(6);
        this.his.setAdapter((ListAdapter) this.hit);
        View findViewById = this.hiv.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bCI() {
                WriteActivity.this.aOK();
            }
        });
        bDz();
    }

    private void bDz() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hiy.setText(this.mData.getTitle());
                this.hiy.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hhM) {
            bDJ();
        }
        if (this.aCT.DG()) {
            this.aCT.BY();
        }
        vh(0);
    }

    private void vh(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gMy);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bDA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aCT.C(arrayList);
        com.baidu.tbadk.editortools.k eI = this.aCT.eI(5);
        if (eI != null) {
            eI.aDC = 2;
            eI.aDA = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aDA = d.f.write_at;
        this.aCT.b(aVar);
        this.aCT.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bCY() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aDA = d.f.write_picture;
        this.aCT.b(dVar);
        Boolean bDH = bDH();
        if (!this.hig && bDH != null && bDH.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bte() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aDC = 3;
            kVar5.aDA = d.f.write_recorder;
            this.aCT.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aDA = d.f.icon_post_topic_selector;
        this.aCT.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aDC = 5;
            kVar4.aDA = d.f.write_privilege;
            this.aCT.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aDC = 6;
            kVar3.aDA = this.hig ? d.f.write_location : d.f.icon_post_more_location;
            this.aCT.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aDA = d.f.icon_post_more_at;
        this.aCT.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aDE = true;
            kVar2.aDC = 9;
            kVar2.aDA = 0;
            this.aCT.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aDE = true;
            kVar.aDC = 10;
            kVar.aDA = 0;
            this.aCT.b(kVar);
        }
        if (this.hhA == null) {
            if (this.hhQ == null) {
                this.hhQ = new com.baidu.tieba.write.editor.b(getActivity(), this.gMy);
                this.hhQ.aP(this.mData.getForumId(), this.privateThread);
            }
            this.aCT.b(this.hhQ);
        }
        this.aCT.C(arrayList);
        com.baidu.tbadk.editortools.k eI = this.aCT.eI(5);
        if (eI != null) {
            eI.aDC = 1;
            eI.aDA = d.f.write_emotion;
        }
    }

    private void bDa() {
        if (this.hhT != null) {
            this.hhT.hideTip();
        }
    }

    private void bDb() {
        if (this.hhT == null) {
            this.hhT = new e(getPageContext());
        }
        this.hhT.c(this.aCT);
    }

    private void bCZ() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bDn()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bDn()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bDq();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aYd();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bDM();
                        WriteActivity.this.bnQ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vi(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hhA == null) {
                            WriteActivity.this.Eh();
                            return;
                        }
                        switch (WriteActivity.this.aEC) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aC(pageActivity)) {
                                    WriteActivity.this.Ef();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Ee();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aEw != null) {
                            WriteActivity.this.aEw.mu(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eJO = null;
                        } else {
                            WriteActivity.this.eJO = (String) aVar.data;
                        }
                        WriteActivity.this.ny(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        al alVar = new al("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        alVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(alVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aCT.DG()) {
                                        WriteActivity.this.aCT.BY();
                                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.k.plugin_video_not_active), WriteActivity.this.getResources().getString(d.k.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.k.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.k.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bnQ();
                        if (WriteActivity.this.gmV != null) {
                            WriteActivity.this.gmV.requestFocus();
                        }
                        WriteActivity.this.aCT.BY();
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gmV);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hhs = true;
                        WriteActivity.this.nw(true);
                        if (WriteActivity.this.bDp().isFocused()) {
                            WriteActivity.this.hhr = "from_title";
                        } else if (WriteActivity.this.bDo().isFocused()) {
                            WriteActivity.this.hhr = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hhv.setVisibility(0);
                        WriteActivity.this.hhv.requestFocus();
                        WriteActivity.this.bnQ();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hhv.hasFocus()) {
                            WriteActivity.this.gmV.requestFocus();
                            WriteActivity.this.gmV.setSelection(WriteActivity.this.gmV.getText().toString().length());
                        }
                        WriteActivity.this.hhv.setVisibility(8);
                        WriteActivity.this.bnQ();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aCT.setActionListener(16, bVar);
        this.aCT.setActionListener(14, bVar);
        this.aCT.setActionListener(24, bVar);
        this.aCT.setActionListener(3, bVar);
        this.aCT.setActionListener(10, bVar);
        this.aCT.setActionListener(11, bVar);
        this.aCT.setActionListener(12, bVar);
        this.aCT.setActionListener(13, bVar);
        this.aCT.setActionListener(15, bVar);
        this.aCT.setActionListener(18, bVar);
        this.aCT.setActionListener(20, bVar);
        this.aCT.setActionListener(25, bVar);
        this.aCT.setActionListener(27, bVar);
        this.aCT.setActionListener(29, bVar);
        this.aCT.setActionListener(43, bVar);
        this.aCT.setActionListener(45, bVar);
        this.aCT.setActionListener(53, bVar);
        this.aCT.setActionListener(48, bVar);
        this.aCT.setActionListener(46, bVar);
        this.aCT.setActionListener(49, bVar);
        this.aCT.setActionListener(47, bVar);
        this.aCT.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        if (this.aEw.abq()) {
            if (this.aEw.bsG()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bsC().getLocationData().bsy());
                return;
            }
            b(1, true, null);
            this.aEw.bsE();
            return;
        }
        b(0, true, null);
    }

    protected void bnI() {
        if (this.aEx != null) {
            this.aEx.cancelLoadData();
        }
        if (this.hhw != null) {
            this.hhw.cancelLoadData();
        }
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bDa();
        TiebaPrepareImageService.StopService();
        bnI();
        bDG();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hir != null) {
            this.hir.destroy();
        }
        if (this.hiR != null) {
            this.hiR.ahf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDc() {
        if (this.mData != null && this.mData.getType() == 2 && this.hin) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bDp().getText().toString());
            this.mData.setContent(bDo().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.b("24591571", this.mData);
                }
            } else if (type == 1) {
                t.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                t.b(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                t.c(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gmX != null && this.gmX.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gmX, getPageContext().getPageActivity());
                return true;
            } else if (this.aCT.DG()) {
                this.aCT.BY();
                return true;
            } else {
                bnI();
                bDc();
                return true;
            }
        }
        if (i == 67 && (text = bDo().getText()) != null) {
            int selectionStart = bDo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDo().onKeyDown(67, this.cLp);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.mParent);
        getLayoutMode().u(this.hiH);
        if (this.hiF != null && i == 1) {
            this.hiF.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.c(this.mPost, d.C0126d.cp_link_tip_a, 1);
        bCX();
        ak.j(this.hiv, d.C0126d.cp_bg_line_d);
        ak.j(this.gmS, d.C0126d.cp_bg_line_c);
        ak.j(this.hiw, d.C0126d.cp_bg_line_c);
        ak.j(bDp(), d.C0126d.cp_bg_line_d);
        ak.c(this.fkA, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eJO)) {
            ak.j(bDo(), d.C0126d.cp_bg_line_d);
        }
        bnQ();
        this.aCT.onChangeSkinType(i);
        if (this.hhK != null) {
            this.hhK.wX();
        }
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDd();
        bDe();
        if (this.hhS != null) {
            this.hhS.c(bDp(), bDo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDd() {
        if (this.gmR.hasFocus()) {
            this.gmR.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.gmR.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
        if (this.gmV.hasFocus()) {
            this.gmV.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.gmV.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (this.gmR != null && this.gmR.getText() != null && this.gmR.getText().toString() != null && this.gmR.getPaint() != null) {
            if (this.gmR.getText().toString().length() == 0) {
                this.gmR.getPaint().setFakeBoldText(false);
            } else if (this.gmR.getText().toString().length() > 0) {
                this.gmR.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aNd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hhM = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ak.h(this.mName, d.C0126d.cp_cont_b);
        this.hil = (TextView) findViewById(d.g.btn_image_problem);
        bDg();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gmP);
        this.hhL = (ScrollView) findViewById(d.g.write_scrollview);
        this.hhL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gmV != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gmV);
                    }
                    if (WriteActivity.this.aCT != null) {
                        WriteActivity.this.aCT.BY();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hij = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hik = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hhu = (LinearLayout) findViewById(d.g.tool_view);
        this.hhu.setContentDescription("..");
        this.hhv = (LinearLayout) findViewById(d.g.title_view);
        this.gmS = findViewById(d.g.interval_view);
        this.hiM = findViewById(d.g.hot_topic_fourm_view);
        this.hiN = findViewById(d.g.hot_topic_divider);
        this.hhO = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hiO = (TextView) findViewById(d.g.change_one_tv);
        bnP();
        if (this.hhM) {
            this.hhL.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bDy();
        } else {
            this.hir = new g(getPageContext(), this.mRootView);
            g gVar = this.hir;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nr(z);
        }
        bnR();
        if (this.hig || this.hht) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ajJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gmU = (LinearLayout) findViewById(d.g.post_content_container);
        this.gmU.setDrawingCacheEnabled(false);
        this.gmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.requestFocus();
                WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gmV.requestFocus();
            }
        });
        this.fkx = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fky = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fkA = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.aYd();
            }
        });
        this.asg.setOnFocusChangeListener(this.gmP);
        this.asg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.bnI();
                WriteActivity.this.bDc();
            }
        });
        this.hil.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bDj();
        i(bDH());
        bDl();
        bDf();
        bDD();
        bDF();
        bCX();
        bDk();
        bnO();
        bDr();
        if (this.mData.getType() == 4 && this.gmZ != null && this.hhx != null) {
            this.gmZ.setVisibility(8);
            this.hhx.setVisibility(8);
        }
        bnQ();
        bDB();
    }

    private void bDf() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hig || this.hht) {
                        if (this.hih) {
                            this.mName.setText(d.k.feedback_vcode);
                        } else {
                            this.mName.setText(d.k.feedback);
                        }
                    } else if (this.gMy != null && this.gMy.equals("1")) {
                        this.mName.setText(d.k.post_to_home_page);
                    } else if (this.gMy != null && this.gMy.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.k.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.k.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.k.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gmR.setVisibility(0);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gmR.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.k.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hiw.setVisibility(8);
                    return;
                case 7:
                    this.gmR.setVisibility(0);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.k.post_drift_bottle);
                    return;
            }
        }
    }

    private void bDg() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
    }

    private void bDh() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hig && !this.hht && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = an.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bDp() != null) {
                bDp().setText(d);
                bDp().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fkx.setVisibility(0);
            this.fky.setVoiceModel(voiceModel);
            this.fky.btd();
            bnQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aJ(com.baidu.tbadk.core.voice.a.eR(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fkx.setVisibility(8);
        this.fky.ayY();
        this.fky.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eI = this.aCT.eI(6);
        if (eI != null && eI.aCN != null) {
            eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bnQ();
    }

    private void bDi() {
        this.hhF = null;
        this.hhH = -1;
        this.hhJ = -1;
        x kj = w.aqE().kj(1);
        if (kj != null) {
            this.hhF = kj.dbj;
            this.hhH = getIntent().getIntExtra("category_id", -1);
            if (this.hhF != null && !this.hhF.isEmpty() && this.hhH >= 0) {
                this.hhG = new v();
                this.hhG.dbf = 0;
                this.hhG.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hhJ = this.hhG.dbf;
                this.hhI = this.hhG.name;
                for (v vVar : this.hhF) {
                    if (vVar.dbf == this.hhH) {
                        this.hhJ = vVar.dbf;
                        this.hhI = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bDj() {
        if (this.hhF != null && !this.hhF.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hhK = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hhK.setText(this.hhI);
            this.hhK.setCategoryContainerData(this.hhF, this.hhG, this.hhJ);
            this.hhK.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view2, com.baidu.tieba.frs.ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.hhK.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.dbf);
                        WriteActivity.this.hhJ = arVar.dbf;
                        WriteActivity.this.hhK.bCL();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    WriteActivity.this.hhK.bCK();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDp());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDo());
                }
            });
        }
    }

    private void bDB() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hia = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hia.setTitle(d.k.no_disturb_start_time);
        this.hia.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hia);
        this.hia.setButton(-2, getPageContext().getString(d.k.cancel), this.hia);
        return this.hia;
    }

    private void bDk() {
        this.hhB = (RelativeLayout) findViewById(d.g.addition_container);
        this.hhC = (TextView) findViewById(d.g.addition_create_time);
        this.hhD = (TextView) findViewById(d.g.addition_last_time);
        this.hhE = (TextView) findViewById(d.g.addition_last_content);
        if (this.hhA != null) {
            this.hhB.setVisibility(0);
            this.hhC.setText(getPageContext().getString(d.k.write_addition_create) + an.s(this.hhA.getCreateTime() * 1000));
            if (this.hhA.getAlreadyCount() == 0) {
                this.hhD.setVisibility(8);
            } else {
                this.hhD.setText(getPageContext().getString(d.k.write_addition_last) + an.s(this.hhA.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hhA.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hhE.setText(lastAdditionContent);
            } else {
                this.hhE.setVisibility(8);
            }
            bDo().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hhA.getAlreadyCount()), Integer.valueOf(this.hhA.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hhB.setVisibility(8);
    }

    private void bnO() {
        this.gmZ = findViewById(d.g.post_prefix_layout);
        if (this.hiR == null) {
            this.hiR = new com.baidu.tieba.d.c(getPageContext(), this.gmZ);
            this.hiR.jc(d.f.bg_tip_blue_up_left);
            this.hiR.jb(16);
            this.hiR.eG(true);
            this.hiR.B(true);
            this.hiR.jf(l.e(getActivity(), d.e.ds32));
        }
        this.gmW = (TextView) findViewById(d.g.post_prefix);
        this.hhx = findViewById(d.g.prefix_divider);
        this.gmY = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gmZ.setVisibility(0);
            this.hiR.h(getString(d.k.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gmz = 0;
            this.gmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c13013").ac(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gmW.setVisibility(0);
                    WriteActivity.this.gmZ.setSelected(true);
                    ak.c(WriteActivity.this.gmY, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gmX, view2, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCT.BY();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gmR);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gmV);
                }
            });
            this.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c13013").ac(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gmW.setSelected(true);
                    ak.c(WriteActivity.this.gmY, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gmX, view2, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCT.BY();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDp());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDo());
                }
            });
            this.gmX = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gmX.a(this);
            this.gmX.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gmX.setOutsideTouchable(true);
            this.gmX.setFocusable(true);
            this.gmX.setOnDismissListener(this);
            this.gmX.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_d));
            int color = ak.getColor(d.C0126d.cp_cont_b);
            ak.getColor(d.C0126d.cp_cont_c);
            ak.i(this.gmW, d.C0126d.cp_bg_line_d);
            ak.c(this.gmY, d.f.icon_arrow_gray_down);
            this.gmW.setTextColor(color);
            this.hhy.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hhy.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nm(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nm(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gmX.addView(writePrefixItemLayout);
            }
            this.gmX.setCurrentIndex(0);
            this.gmW.setText(prefixs.get(0));
            vg(0);
            return;
        }
        this.gmZ.setVisibility(8);
    }

    private void bDC() {
        if (this.hig && this.mData != null) {
            this.hij.setVisibility(0);
            this.hik.setVisibility(0);
            this.hhw = new FeedBackModel(getPageContext());
            this.hhw.uX(this.mData.getForumName());
            this.hhw.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hij.setVisibility(8);
                        WriteActivity.this.hik.setVisibility(8);
                        WriteActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hij.setVisibility(8);
                        WriteActivity.this.hik.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hij.a(feedBackModel.bCN(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bDl() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    WriteActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hhS.a(WriteActivity.this.gmR, WriteActivity.this.gmV)) {
                        WriteActivity.this.showToast(WriteActivity.this.hhS.bAW());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDp());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDo());
                    WriteActivity.this.aCT.BY();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hig) {
                            WriteActivity.this.bDu();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            al alVar = new al("c12102");
                            alVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(alVar);
                            WriteActivity.this.bDv();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bDu();
                    }
                    TiebaStatic.log(new al("c12262").ac("obj_locate", WriteActivity.this.gMy));
                }
            }
        });
    }

    protected void bDD() {
        this.him = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.him.dc(getPageContext().getString(d.k.is_save_draft)).ar(false).a(getPageContext().getString(d.k.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bDp().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bDo().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.k.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.k.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.him.b(getPageContext());
    }

    protected void bnP() {
        this.hii = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hii.setIsRound(true);
        this.hii.setDrawBorder(false);
        this.hii.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dU = o.dU(currentPortrait);
            this.hii.setUrl(dU);
            this.hii.startLoad(dU, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hii.setVisibility(0);
        }
        this.gmR = (EditText) findViewById(d.g.post_title);
        this.gmR.setOnClickListener(this.hhW);
        this.gmR.setOnFocusChangeListener(this.gmP);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gmR.setText(this.mData.getTitle());
                this.gmR.setSelection(this.mData.getTitle().length());
            } else if (this.hih) {
                this.gmR.setText(getResources().getString(d.k.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gmR.addTextChangedListener(this.hhY);
        if (!this.mData.getHaveDraft()) {
            bDh();
            this.hiL = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gmR.setHint(getResources().getString(d.k.feedback_title_hint));
        } else {
            this.gmR.setHint(getResources().getString(d.k.post_title_hint));
        }
    }

    private TextWatcher bDE() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hiV;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bnQ();
                if (WriteActivity.this.hhM) {
                    this.hiV = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hiV);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hhM || !WriteActivity.this.hiD) {
                    if (WriteActivity.this.hhM) {
                        if (this.mEditText != WriteActivity.this.hiu || this.mTextView != WriteActivity.this.hiA) {
                            this.mEditText = WriteActivity.this.hiu;
                            this.mTextView = WriteActivity.this.hiA;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hiy || this.mTextView != WriteActivity.this.hiz) {
                    this.mEditText = WriteActivity.this.hiy;
                    this.mTextView = WriteActivity.this.hiz;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hhM && this.hiD) {
            if (this.hiB != null) {
                this.hiy.removeTextChangedListener(this.hiB);
            }
            this.hiB = textWatcher;
        } else if (this.hhM) {
            if (this.hiC != null) {
                this.hiu.removeTextChangedListener(this.hiC);
            }
            this.hiC = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hiu) {
            return 233L;
        }
        if (editText != this.hiy) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long l = l(editText);
            long m = l - m(editText);
            String valueOf = String.valueOf(m);
            if (l == 20) {
                if (m < 0) {
                    if (m < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ak.getColor(d.C0126d.common_color_10159));
                } else {
                    textView.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ak.getColor(d.C0126d.common_color_10159));
            } else {
                textView.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.l(editText.getText().toString().trim());
    }

    protected void bnR() {
        this.gmV = (EditText) findViewById(d.g.post_content);
        this.gmV.setDrawingCacheEnabled(false);
        this.gmV.setOnClickListener(this.hhW);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EX().R(getPageContext().getPageActivity(), this.mData.getContent());
            this.gmV.setText(R);
            this.gmV.setSelection(R.length());
        } else if (this.mData.getType() == 2) {
            if (this.hin) {
                if (this.hio != null && this.hio.length() > 0) {
                    this.gmV.setText(getPageContext().getPageActivity().getString(d.k.reply_sub_floor, new Object[]{this.hio}));
                    this.gmV.setSelection(this.gmV.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.k.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gmV.setText(format);
                this.gmV.setSelection(format.length());
            }
        }
        this.gmV.setOnFocusChangeListener(this.gmP);
        this.gmV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    WriteActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gmV.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gmV.addTextChangedListener(this.hhZ);
        if (this.mData.getType() == 0) {
            this.hiQ = true;
        } else {
            ny(true);
            this.hiQ = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gmV.setHint(d.k.write_input_content);
        } else {
            this.gmV.setHint(d.k.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void ny(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hhM) {
            bDo().setPadding(0, 0, 0, 0);
            bDo().setBackgroundDrawable(null);
            ak.j(bDo(), d.C0126d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eJO) && this.hhA == null) {
                com.baidu.adp.lib.f.c.fp().a(this.eJO, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.kl() != null && aVar.kp() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kl(), aVar.kl().getNinePatchChunk(), aVar.kp(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bDo().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bDo(), true, WriteActivity.this.frr);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDn() {
        int i = 5000;
        if (this.hhA != null) {
            i = 1000;
        }
        return bDo().getText() != null && bDo().getText().length() >= i;
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hhr)) {
                this.hhr = "";
                bDo().requestFocus();
                if (bDo().getText() != null && bDo().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDo().getSelectionStart();
                    editable = bDo().getText();
                }
            } else if ("from_title".equals(this.hhr)) {
                this.hhr = "";
                bDp().requestFocus();
                if (bDp().getText() != null && bDp().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDp().getSelectionStart();
                    editable = bDp().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bDo().getText().getSpans(0, bDo().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hhz == null) {
                this.hhz = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hhz.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType yB = nVar.yB();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fp().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bDo().getSelectionStart(), aVar, yB);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bDo() != null && bDo().getText() != null) {
            Bitmap kl = aVar.kl();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kl);
            int width = kl.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kl.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.d(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bDo().getSelectionStart() - 1;
                if (bDo().getText().length() > 1 && selectionStart >= 0 && bDo().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bDo().getText().insert(bDo().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bDo().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bDo().getText().insert(bDo().getSelectionStart(), spannableString2);
            }
            Editable text = bDo().getText();
            if (text != null) {
                this.hhP.clear();
                this.hhP.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hhP);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bDo().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bDo().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bDo().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDo() {
        return this.hhM ? this.hiu : this.gmV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDp() {
        return this.hhM ? this.hiy : this.gmR;
    }

    protected void bDq() {
        Editable text;
        if (bDo() != null && (text = bDo().getText()) != null) {
            int selectionStart = bDo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDo().onKeyDown(67, this.cLp);
            }
            bDo().onKeyDown(67, this.cLp);
            int selectionStart2 = bDo().getSelectionStart();
            if (text != null) {
                this.hhP.clear();
                this.hhP.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hhP);
                bDo().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.k.feedback_bar_name).equals(str)) {
            this.hig = true;
        }
    }

    private void bDF() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bDG() {
        try {
            if (this.him != null) {
                this.him.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aNd.d(null);
        this.aNd.da(d.k.sending);
        this.aNd.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aNd.aI(false);
    }

    private Boolean bDH() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aEB = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnQ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bDp() != null) {
                str = bDp().getText().toString();
            }
            if (bDo() != null) {
                str2 = bDo().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gmz == com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hhv.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nx(true);
                            return;
                        }
                    } else if (this.hhv.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nx(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hhv.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nx(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hhM) {
                    nx(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nx(true);
                }
            }
            if (this.mData.getType() == 4) {
                nx(o(this.hiu) && n(this.hiy));
            } else if (this.mData.getType() == 5) {
                nx(o(this.hiu));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nx(true);
            } else if (this.mData.getVideoInfo() != null) {
                nx(true);
            } else {
                nx(false);
            }
        }
    }

    public void nx(boolean z) {
        if (z) {
            ak.b(this.mPost, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        ak.c(this.mPost, d.C0126d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean n(EditText editText) {
        long m = m(editText);
        return m <= 20 && m > 0;
    }

    private boolean o(EditText editText) {
        long m = m(editText);
        if (m > 233) {
            return false;
        }
        return m > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aEx = new NewWriteModel(this);
        this.aEx.b(this.aEL);
        registerListener(this.hiS);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bnI();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.hig = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hih = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hin = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hio = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aEv = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hhA = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hhA != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hip = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hiP = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gMy = bundle.getString("KEY_CALL_FROM");
            this.hct = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hig = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hih = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hin = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hio = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hhA = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hhA != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hip = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hiP = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gMy = intent.getStringExtra("KEY_CALL_FROM");
            this.hct = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.mData.getType() == 9) {
            this.mData.setEntranceType(1);
        } else if (this.mData.getType() == 10) {
            this.mData.setEntranceType(2);
            this.mData.setType(9);
        } else if (this.mData.getType() == 0) {
            this.mData.setEntranceType(3);
        }
        this.mData.setIsUserFeedback(this.hig);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0 || this.mData.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            t.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            t.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            t.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(d.k.write_no_prefix));
        }
        this.eJO = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hht = true;
        }
        bDi();
        try {
            this.hiE = bDN();
        } catch (Throwable th) {
            this.hiE = null;
        }
    }

    private void bDr() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gmR.setText(com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName)));
            this.gmR.setMovementMethod(com.baidu.tieba.view.c.bAb());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString gT = com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.gmR.setText(gT);
            }
            this.hhO.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String gU;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bDp().getText().toString()) || this.hiL || ((this.hig || this.hht) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!com.baidu.tbadk.core.util.v.w(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            gU = this.mData.getTitle();
                        } else {
                            gU = com.baidu.tbadk.plugins.b.gU(str);
                        }
                        SpannableString gT = com.baidu.tbadk.plugins.b.gT(gU);
                        if (gT != null) {
                            bDp().setText(gT);
                            bDp().setSelection(gT.length() > gU.length() ? gU.length() : gT.length());
                        }
                    } else {
                        SpannableString gT2 = com.baidu.tbadk.plugins.b.gT(this.mData.getTitle());
                        if (gT2 != null) {
                            bDp().setText(gT2);
                            bDp().setSelection(this.mData.getTitle().length() > gT2.length() ? gT2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bDh();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bDo().getText().toString()) || this.hig || this.hht) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.EX().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hhU);
                    bDo().setText(a2);
                    bDo().setSelection(a2.length());
                    if (this.hhM) {
                        a(this.hiA, this.hiu);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bDM();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bDx();
                    }
                    nz(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bDI();
                }
                bnQ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hhF != null) {
                    this.hhJ = this.hhG.dbf;
                    this.hhI = this.hhG.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hhF.size()) {
                            break;
                        }
                        v vVar = this.hhF.get(i);
                        if (categoryTo != vVar.dbf) {
                            i++;
                        } else {
                            this.hhJ = categoryTo;
                            this.hhI = vVar.name;
                            this.mData.setCategoryTo(this.hhJ);
                            break;
                        }
                    }
                    if (this.hhK != null) {
                        this.hhK.setText(this.hhI);
                        this.hhK.setCategoryContainerData(this.hhF, this.hhG, this.hhJ);
                    }
                }
                this.aCT.BY();
                return;
            }
            return;
        }
        bDI();
        bDh();
    }

    private void bDI() {
        if ((!this.hhM || this.hit != null) && this.his != null) {
            this.hit.c(this.writeImagesInfo);
            aOK();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hin);
        if (this.hig) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aEv);
        if (this.hhA != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hhA));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hip);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gMy);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hct);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bDo().getEditableText().toString();
        if (obj != null) {
            bDo().setText(TbFaceManager.EX().a(getPageContext().getPageActivity(), obj, this.hhU));
            bDo().setSelection(bDo().getText().length());
        }
    }

    private String bDs() {
        return (bDo() == null || bDo().getText() == null) ? "" : bDo().getText().toString();
    }

    private String bDt() {
        if (this.mData == null || bDp() == null || bDp().getVisibility() != 0 || bDp().getText() == null) {
            return "";
        }
        String obj = bDp().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) > 0 && this.gmz != com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gmW != null && this.gmW.getText() != null) {
            this.mData.setPostPrefix(this.gmW.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uY(String str) {
        if (this.mData != null && this.hhv != null) {
            if (this.hhv.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mData.setIsNoTitle(true);
                    this.mData.setTitle("");
                    return;
                }
                this.mData.setIsNoTitle(false);
                this.mData.setTitle(str);
                return;
            }
            this.mData.setIsNoTitle(true);
            this.mData.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDu() {
        bnI();
        this.mData.setContent(bDs());
        uY(bDt());
        if (this.hig || this.hht) {
            String string = getResources().getString(d.k.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uY(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.k.app_name) + getResources().getString(d.k.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.gP()) {
                    sb.append(com.baidu.adp.lib.util.j.gX());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hhH >= 0) {
            this.mData.setCategoryFrom(this.hhH);
        }
        if (this.hhJ >= 0) {
            this.mData.setCategoryTo(this.hhJ);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i++;
                }
                i = i;
            }
            this.mData.setTakePhotoNum(i);
        }
        this.mData.setHasLocationData(this.aEw != null && this.aEw.abq());
        if (this.writeImagesInfo != null) {
            this.aEx.mw(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.w(this.mList) && this.hhN != null && this.hhN.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hhN.mForumId));
            this.mData.setForumName(this.hhN.mForumName);
        }
        this.aEx.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aEx.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aEx.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aEx.getWriteData().setVoice(null);
                this.aEx.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aEx.getWriteData().setVoice(null);
            this.aEx.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aEx.btf()) {
            showToast(d.k.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
            this.aEx.startPostWrite();
        }
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hhA != null) {
                i2 = this.hhA.getTotalCount();
                i = this.hhA.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.k.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.gmR == getCurrentFocus()) {
                    bDo().clearFocus();
                    this.gmR.requestFocus();
                    if (this.aCT != null) {
                        this.aCT.BY();
                    }
                    ShowSoftKeyPadDelay(this.gmR);
                } else {
                    bDo().requestFocus();
                    if (this.aCT != null) {
                        this.aCT.BY();
                    }
                    ShowSoftKeyPadDelay(this.gmV);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            bDo().getText().insert(bDo().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    t.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.mData.getType() == 1) {
                    t.c(this.mData.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bDL();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            ah(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hiQ) {
                            ny(true);
                            this.hiQ = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hhM) {
                        A(intent);
                        bnQ();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bnQ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hhs) {
                                sb2.append(com.baidu.tbadk.plugins.b.aMA);
                                this.hhs = false;
                            }
                            sb2.append(stringExtra);
                            gh(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.w(this.mList) && !com.baidu.tbadk.core.util.v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hhN = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hhN);
                }
            }
        } else if (i2 == 0) {
            if (this.aCT != null && !this.aCT.DG()) {
                this.gmV.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aCT.BY();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    Ek();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bDK();
                    if (this.hiQ) {
                        ny(true);
                        this.hiQ = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gmR == getCurrentFocus()) {
                        bDo().clearFocus();
                        this.gmR.requestFocus();
                        if (this.aCT != null) {
                            this.aCT.BY();
                        }
                        ShowSoftKeyPadDelay(this.gmR);
                        return;
                    }
                    bDo().requestFocus();
                    if (this.aCT != null) {
                        this.aCT.BY();
                    }
                    ShowSoftKeyPadDelay(this.gmV);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hhS.uE(postWriteCallBackData.getErrorString());
                        this.hhS.ax(postWriteCallBackData.getSensitiveWords());
                        this.hhS.b(this.gmR, this.gmV);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aEv = String.valueOf(System.currentTimeMillis());
                    aj.a(getPageContext(), this.aEv);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bDK();
                    return;
                case 25004:
                    if ("from_title".equals(this.hhr)) {
                        bDp().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hhr)) {
                        bDo().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDv() {
        if ("1".equals(this.gMy)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gMy)) {
            this.mData.setCanNoForum(false);
        }
        bDw();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.gMy);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bDu();
    }

    private void bDw() {
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bDJ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bDK() {
        if (this.hhM) {
            this.hit.c(this.writeImagesInfo);
            aOK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOK() {
        this.hit.notifyDataSetChanged();
        this.his.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hit.notifyDataSetChanged();
                WriteActivity.this.his.invalidateViews();
            }
        }, 550L);
    }

    public void v(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bnQ();
    }

    private void ae(Intent intent) {
        if (this.hhM) {
            af(intent);
            bDK();
        } else {
            ai(intent);
        }
        bnQ();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bDK();
            nz(true);
        }
    }

    private void ag(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bDL() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hiq.parseJson(stringExtra);
            this.hiq.updateQuality();
            if (this.hiq.getChosedFiles() != null && this.hiq.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hiq.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hiq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bDp());
        HidenSoftKeyPad(this.mInputManager, bDo());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aEv = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aEv;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aEv, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bDM();
            bDx();
        }
        nz(true);
    }

    private void A(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bDM();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bDx();
                }
            }
            nz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDM() {
        if (this.aCT.eI(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Ek() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aEv));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nz(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hir != null) {
            this.hir.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void apB() {
        this.cYn = getVoiceManager();
        this.cYn.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ts(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cZl) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hhA == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEC = i;
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bDx() {
        if (!this.hhM) {
            if (this.aCT != null) {
                this.aCT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aCT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hir != null) {
                this.hir.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vg(int i) {
        if (i < this.hhy.size()) {
            for (int i2 = 0; i2 < this.hhy.size(); i2++) {
                this.hhy.get(i2).nn(false);
            }
            this.hhy.get(i).nn(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sN(int i) {
        if (i == com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new al("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new al("c13014").r("obj_type", 2));
        }
        this.gmz = i;
        this.gmX.setCurrentIndex(i);
        vg(i);
        this.gmW.setText(this.mPrefixData.getPrefixs().get(i));
        bnQ();
        com.baidu.adp.lib.g.g.a(this.gmX, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gmZ.setSelected(false);
        ak.c(this.gmY, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gmV);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mData != null) {
            if (this.mData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0045a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Ef();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aD(getApplicationContext())) {
                aj.a(getPageContext(), this.aEv);
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hhR = z;
        if (this.hiJ && System.currentTimeMillis() - this.hiK < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.hiJ = false;
        }
        if (this.hhQ != null && !z) {
            this.hhQ.akW();
        }
        if (this.hhT != null && !z) {
            bDa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hiG != null) {
            va(str);
            this.hiG.dismiss();
        }
    }

    private void ci(Context context) {
        hiI = l.ah(context);
    }

    private void va(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hiJ = true;
        bDM();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bDx();
        }
        nz(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4240=4] */
    private static Bitmap e(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap = null;
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap2 = BitmapHelper.getResizedBitmap(bitmap, i);
                if (bitmap != null && bitmap != bitmap2 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return bitmap2;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap2;
    }

    private File bDN() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
        String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("_data"));
                File file = new File(string);
                if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                    break;
                }
                String upperCase = string.toUpperCase();
                if (upperCase.contains("DCIM/CAMERA") || upperCase.contains("DCIM/100ANDRO") || upperCase.contains("DCIM/100MEDIA") || upperCase.contains("SCREENSHOTS") || upperCase.contains(name.toUpperCase()) || upperCase.contains(name2.toUpperCase())) {
                    return file;
                }
                query.moveToNext();
            }
            return null;
        } finally {
            query.close();
        }
    }

    private void bDO() {
        if (this.hiE != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ci(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(d.i.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteActivity.this.hiE != null) {
                        WriteActivity.this.uZ(WriteActivity.this.hiE.getAbsolutePath());
                    }
                }
            });
            this.hiF = (TbImageView) this.mBubbleView.findViewById(d.g.rec_img_view);
            this.hiH = (LinearLayout) this.mBubbleView.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hiE.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hiE.getAbsolutePath());
                Bitmap e = e(this.hiE.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (e != null) {
                    this.hiF.setImageBitmap(e);
                    this.hiF.setDrawBorder(true);
                    this.hiF.setBorderWidth(2);
                    this.hiF.setBorderColor(ak.getColor(d.C0126d.common_color_10264));
                    this.hiG = new Dialog(getActivity(), d.l.bubble_dialog);
                    this.hiG.setCanceledOnTouchOutside(true);
                    this.hiG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hiJ) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hiK = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hiG.setContentView(this.mBubbleView);
                    this.hiG.show();
                    Window window = this.hiG.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hiI / 18) + getResources().getDimensionPixelSize(d.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(d.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(d.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hhR && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hhs = false;
            this.hhr = "";
            if ("from_content".equals(str)) {
                this.hhr = "from_content";
            } else if ("from_title".equals(str)) {
                this.hhr = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.gS(String.valueOf(charSequence.charAt(i)))) {
                nw(false);
            }
        }
    }

    public void bjV() {
        if (this.hig || !com.baidu.tbadk.core.util.v.w(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hhv.setVisibility(0);
            this.hhv.requestFocus();
            this.aCT.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hhv.setVisibility(8);
    }
}
