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
import com.baidu.a.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.imgView.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, r.a, d.a {
    private static int gFp = 0;
    private i aAR;
    private VoiceData.VoiceModel aCB;
    private String aCC;
    private LocationModel aCD;
    private NewWriteModel aCE;
    private String aia;
    private VoiceManager chP;
    private LinearLayout etP;
    private TextView fPK;
    private com.baidu.tieba.write.d fPL;
    private ImageView fPM;
    private View fPN;
    private int fPq;
    private View gEB;
    private View gEC;
    private Toast gEI;
    private AdditionData gEJ;
    private RelativeLayout gEK;
    private TextView gEL;
    private TextView gEM;
    private TextView gEN;
    List<x> gEP;
    x gEQ;
    private int gER;
    private String gES;
    private int gET;
    private PostCategoryView gEU;
    private NewFrameMultiImgToolView gEV;
    private LinearLayout gEy;
    private com.baidu.tieba.write.b.b gFE;
    private com.baidu.tieba.view.a gFK;
    private com.baidu.tieba.write.a gFt;
    private HotTopicBussinessData gFv;
    private View gFw;
    private View gFx;
    private TextView gFy;
    private TextView gFz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gEt = "";
    private boolean gEu = false;
    private WriteData mData = null;
    private boolean gEv = false;
    private boolean gEw = false;
    private boolean gEx = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fPH = null;
    private HeadImageView gCv = null;
    private View fPI = null;
    private LinearLayout bpe = null;
    private EditText bpd = null;
    private FeedBackModel gEz = null;
    private FeedBackTopListView gEA = null;
    private ArrayList<com.baidu.tieba.write.c> gDw = new ArrayList<>();
    private String ebi = null;
    private final KeyEvent gED = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View apT = null;
    private TextView gEE = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gEF = null;
    private final Handler mHandler = new Handler();
    private boolean gEG = false;
    private String gEH = null;
    private RelativeLayout mParent = null;
    private String aCJ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aCM = 0;
    private int gEO = 0;
    private WriteImagesInfo fry = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gEW = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gEX = null;
    private ScrollView gEY = null;
    private EditText gEZ = null;
    private View gFa = null;
    private View gFb = null;
    private View gFc = null;
    private EditText gFd = null;
    private TextView gFe = null;
    private TextView gFf = null;
    private TextWatcher gFg = null;
    private TextWatcher gFh = null;
    private boolean gFi = false;
    private boolean gFj = false;
    private com.baidu.tbadk.core.view.a aKV = null;
    private File gFk = null;
    private TbImageView gFl = null;
    private View gFm = null;
    private Dialog gFn = null;
    private LinearLayout gFo = null;
    private boolean gFq = false;
    private long gFr = -1000;
    private boolean gFs = false;
    private String gAY = "2";
    private boolean gFu = false;
    private String gFA = "";
    private String gFB = "";
    private int gFC = 0;
    private SpannableStringBuilder gFD = new SpannableStringBuilder();
    private final HttpMessageListener gFF = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ebi)) {
                    WriteActivity.this.ebi = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nh(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ebi)) {
                    WriteActivity.this.ebi = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ebi);
                    WriteActivity.this.nh(true);
                }
            }
        }
    };
    private TbFaceManager.a gFG = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ge(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kN());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new ImageSpan(bitmapDrawable, 0);
        }
    };
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.afj();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                if (z) {
                    WriteActivity.this.bN(z);
                    WriteActivity.this.a(true, postWriteCallBackData);
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                r.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                r.c(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                r.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            r.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            r.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!u.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gFA)) {
                            TiebaStatic.log(new aj("c11731").aa("obj_id", WriteActivity.this.gFA));
                        }
                    }
                    WriteActivity.this.c(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yq());
                    if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yp());
                        if (WriteActivity.this.gEx) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aCT = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DJ() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fU(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsT())) {
                WriteActivity.this.b(2, true, aVar.bsT());
            } else {
                fU(null);
            }
        }
    };
    private final CustomMessageListener giO = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aCD.mA(false);
                    WriteActivity.this.aCD.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aCD.mA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private final View.OnClickListener gFH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bzI = WriteActivity.this.bzI();
            if (bzI >= 0 && bzI < WriteActivity.this.bpd.getText().length()) {
                WriteActivity.this.bpd.setSelection(bzI);
            }
        }
    };
    private boolean gFI = true;
    private final View.OnFocusChangeListener bpk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fPH || view == WriteActivity.this.apT || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gFI = true;
                    WriteActivity.this.bzJ();
                    if (WriteActivity.this.aAR != null) {
                        WriteActivity.this.aAR.Bm();
                    }
                    k.c(WriteActivity.this.getActivity(), WriteActivity.this.fPH);
                } else if (view == WriteActivity.this.fPH) {
                    WriteActivity.this.fPK.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bpd && z) {
                WriteActivity.this.gFI = false;
                WriteActivity.this.bzJ();
                WriteActivity.this.aAR.Bm();
                k.c(WriteActivity.this.getActivity(), WriteActivity.this.bpd);
            }
        }
    };
    private TextWatcher bpm = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.blT();
        }
    };
    private TextWatcher gFJ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.blT();
        }
    };
    private final a.InterfaceC0119a ePd = new a.InterfaceC0119a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0119a
        public void kZ() {
            WriteActivity.this.ebi = null;
            WriteActivity.this.nh(false);
            WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aia)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dw();
        } else if (this.aCD.btb()) {
            Du();
        } else {
            this.aCD.mA(false);
            b(1, true, null);
            this.aCD.bsZ();
        }
    }

    private void Dw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hh()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aCD.Tl();
                } else {
                    WriteActivity.this.aCT.DJ();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzI() {
        int selectionEnd = bAa().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bAa().getText().getSpans(0, bAa().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bAa().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bAa().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzJ() {
        if (this.aAR != null) {
            this.aAR.setBarLauncherEnabled(!this.gFI);
            this.aAR.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gFi) {
            this.fPH.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gFc.setVisibility(8);
            } else {
                this.gFc.setVisibility(0);
            }
            b(this.gFf, this.gEZ);
            b(this.gFe, this.gFd);
            blT();
        }
        if (this.gEv) {
            this.fPH.requestFocus();
            ShowSoftKeyPadDelay(this.fPH);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        bzW();
        this.aCD = new LocationModel(this);
        this.aCD.a(this.aCT);
        registerListener(this.giO);
        initEditor();
        bAo();
        if (this.gFi) {
            this.gEX.setEditorTools(this.aAR);
        } else {
            this.bpd.requestFocus();
        }
        Bo();
        DF();
        this.gFt = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aAR = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aAR.setBarMaxLauCount(6);
        } else {
            this.aAR.setBarMaxLauCount(5);
        }
        this.aAR.setMoreButtonAtEnd(true);
        this.aAR.setBarLauncherType(1);
        this.aAR.bE(true);
        this.aAR.setMoreLauncherIcon(d.g.write_more);
        this.aAR.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bzM();
                break;
            default:
                bzN();
                break;
        }
        this.aAR.CT();
        if (this.gEy != null) {
            this.gEy.addView(this.aAR);
        }
        bzO();
        this.aAR.lJ();
        l eA = this.aAR.eA(6);
        if (eA != null && !TextUtils.isEmpty(this.aCJ)) {
            ((View) eA).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aCJ);
                }
            });
        }
        if (!this.gFi) {
            this.aAR.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aAR.Bm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aAR.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.bpj = this.mData.getForumName() + getResources().getString(d.l.bar);
        }
        this.aAR.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gEV != null) {
            this.gEV.setEditorTools(this.aAR);
            this.gEV.byU();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bzK() {
        this.gFa = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gFc = this.gFa.findViewById(d.h.live_post_title_container);
        this.gEZ = (EditText) this.gFa.findViewById(d.h.live_post_content);
        this.gEW = (GridView) this.gFa.findViewById(d.h.photoLiveGridView);
        this.gFd = (EditText) this.gFa.findViewById(d.h.live_post_title);
        this.gFe = (TextView) this.gFa.findViewById(d.h.titleOverPlusNumber);
        this.gFf = (TextView) this.gFa.findViewById(d.h.contentOverPlusNumber);
        this.gFb = this.gFa.findViewById(d.h.live_interval_view);
        this.gFe.setText(String.valueOf(20));
        this.gFf.setText(String.valueOf(233));
        this.gFa.setVisibility(0);
        this.gFe.setVisibility(0);
        this.gFf.setVisibility(0);
        this.gFd.setHint(d.l.tips_title_limit_new);
        this.gFd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gFj = true;
                    WriteActivity.this.gFI = true;
                    WriteActivity.this.bzJ();
                    if (WriteActivity.this.aAR != null) {
                        WriteActivity.this.aAR.Bm();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gEZ.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gEZ.setHint(d.l.live_write_input_content_update);
        }
        this.gEZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gFj = false;
                    WriteActivity.this.gFI = false;
                    WriteActivity.this.bzJ();
                    if (WriteActivity.this.aAR != null) {
                        WriteActivity.this.aAR.Bm();
                    }
                }
            }
        });
        this.gEZ.requestFocus();
        this.gEZ.addTextChangedListener(baw());
        this.gFd.requestFocus();
        this.gFd.addTextChangedListener(baw());
        this.gFd.setOnClickListener(this.gFH);
        this.gEZ.setOnClickListener(this.gFH);
        this.gEX = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gEW);
        this.gEX.up(6);
        this.gEW.setAdapter((ListAdapter) this.gEX);
        View findViewById = this.gFa.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void byZ() {
                WriteActivity.this.aGg();
            }
        });
        bzL();
    }

    private void bzL() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gFd.setText(this.mData.getTitle());
                this.gFd.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gFi) {
            new com.baidu.tbadk.editortools.a(14, -1, 1);
            bAk();
        }
        if (this.aAR.CV()) {
            this.aAR.Bm();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bzM() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aAR.A(arrayList);
        com.baidu.tbadk.editortools.r eC = this.aAR.eC(5);
        if (eC != null) {
            eC.aBy = 2;
            eC.aBw = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBw = d.g.write_at;
        this.aAR.b(aVar);
        this.aAR.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bzN() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBw = d.g.write_picture;
            this.aAR.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aAR.b(aVar);
        aVar.aBw = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aBy = 6;
            rVar4.aBw = d.g.write_privilege;
            this.aAR.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBw = d.g.write_at;
        this.aAR.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aBA = true;
            rVar3.aBy = 9;
            rVar3.aBw = 0;
            this.aAR.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aBA = true;
            rVar2.aBy = 10;
            rVar2.aBw = 0;
            this.aAR.b(rVar2);
        }
        Boolean bAf = bAf();
        if (!this.gEv && bAf != null && bAf.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.btw() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aBy = 2;
            rVar.aBw = d.g.write_recorder;
            this.aAR.b(rVar);
        }
        if (this.gEJ == null) {
            if (this.gFE == null) {
                this.gFE = new com.baidu.tieba.write.b.b(getActivity(), this.gAY);
            }
            this.aAR.b(this.gFE);
        }
        this.aAR.A(arrayList);
        com.baidu.tbadk.editortools.r eC = this.aAR.eC(5);
        if (eC != null) {
            eC.aBy = 1;
            eC.aBw = d.g.write_emotion;
        }
    }

    private void bzO() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bzZ()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.d(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bzZ()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bAc();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aCB = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.blT();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aCB = null;
                        WriteActivity.this.blT();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bAm();
                        WriteActivity.this.blT();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gEJ == null) {
                            WriteActivity.this.Dx();
                            return;
                        }
                        switch (WriteActivity.this.aCM) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (aa.aC(pageActivity)) {
                                    WriteActivity.this.Dv();
                                    return;
                                } else {
                                    aa.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Du();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ebi = null;
                        } else {
                            WriteActivity.this.ebi = (String) aVar.data;
                        }
                        WriteActivity.this.nh(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        aj ajVar = new aj("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        ajVar.aa("fid", str);
                        TiebaStatic.log(ajVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aAR.CV()) {
                                        WriteActivity.this.aAR.Bm();
                                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.l.plugin_video_not_active), WriteActivity.this.getResources().getString(d.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.l.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.l.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.blT();
                        if (WriteActivity.this.bpd != null) {
                            WriteActivity.this.bpd.requestFocus();
                        }
                        WriteActivity.this.aAR.Bm();
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bpd);
                    } else if (aVar.code == 40) {
                        if (((aVar.data instanceof String) || aVar.data == null) && WriteActivity.this.mData != null) {
                            WriteActivity.this.mData.setGraffitiFileName((String) aVar.data);
                            WriteActivity.this.blT();
                        }
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gEu = true;
                        WriteActivity.this.ni(true);
                        if (WriteActivity.this.bAb().isFocused()) {
                            WriteActivity.this.gEt = "from_title";
                        } else if (WriteActivity.this.bAa().isFocused()) {
                            WriteActivity.this.gEt = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.etP.setVisibility(0);
                        WriteActivity.this.etP.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gFt.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAi());
                        TiebaStatic.log(new aj("c12258").aa("obj_locate", WriteActivity.this.gAY));
                    }
                }
            }
        };
        this.aAR.a(16, bVar);
        this.aAR.a(14, bVar);
        this.aAR.a(24, bVar);
        this.aAR.a(3, bVar);
        this.aAR.a(10, bVar);
        this.aAR.a(11, bVar);
        this.aAR.a(12, bVar);
        this.aAR.a(13, bVar);
        this.aAR.a(15, bVar);
        this.aAR.a(18, bVar);
        this.aAR.a(25, bVar);
        this.aAR.a(27, bVar);
        this.aAR.a(29, bVar);
        this.aAR.a(40, bVar);
        this.aAR.a(43, bVar);
        this.aAR.a(45, bVar);
        this.aAR.a(48, bVar);
        this.aAR.a(46, bVar);
        this.aAR.a(49, bVar);
        this.aAR.a(47, bVar);
        this.aAR.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dx() {
        if (this.aCD.Th()) {
            if (this.aCD.btb()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bsX().getLocationData().bsT());
                return;
            }
            b(1, true, null);
            this.aCD.bsZ();
            return;
        }
        b(0, true, null);
    }

    protected void blL() {
        if (this.aCE != null) {
            this.aCE.cancelLoadData();
        }
        if (this.gEz != null) {
            this.gEz.cancelLoadData();
        }
        if (this.aCD != null) {
            this.aCD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        blL();
        bAe();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gFt != null) {
            this.gFt.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzh() {
        if (this.mData != null && this.mData.getType() == 2 && this.gEG) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bAb().getText().toString());
            this.mData.setContent(bAa().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    r.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    r.c("24591571", this.mData);
                }
            } else if (type == 1) {
                r.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                r.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                r.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fPL != null && this.fPL.isShowing()) {
                g.a(this.fPL, getPageContext().getPageActivity());
                return true;
            } else if (this.aAR.CV()) {
                this.aAR.Bm();
                return true;
            } else {
                blL();
                bzh();
                return true;
            }
        }
        if (i == 67 && (text = bAa().getText()) != null) {
            int selectionStart = bAa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAa().onKeyDown(67, this.gED);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gFo);
        if (this.gFl != null && i == 1) {
            this.gFl.setBorderColor(ai.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.c(this.mPost, d.e.cp_link_tip_a, 1);
        bzJ();
        ai.k(this.gFa, d.e.cp_bg_line_d);
        ai.k(this.fPI, d.e.cp_bg_line_c);
        ai.k(this.gFb, d.e.cp_bg_line_c);
        ai.k(bAb(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.ebi)) {
            ai.k(bAa(), d.e.cp_bg_line_d);
        }
        blT();
        this.aAR.onChangeSkinType(i);
        if (this.gEU != null) {
            this.gEU.wV();
        }
        ai.i(this.mName, d.e.cp_cont_b);
        this.fPH.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.bpd.setHintTextColor(ai.getColor(d.e.cp_cont_e));
    }

    private void bzP() {
        this.gEV = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gEV.initView();
        this.gEV.setVisibility(0);
        this.gEV.setAsyncLocalImageLoader(bVar);
        if (this.gEV.getDragLayer() != null && this.gEV.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gEV.getDragLayer());
            bVar2.a((e) this.gEV.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gEV.getDragHorizonScrollView());
            this.gEV.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gEV.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gEV.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gEV.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gEV));
            }
            this.gEV.getDragHorizonScrollView().setOnSwapDataListener(this.gEV);
            this.gEV.getDragHorizonScrollView().setMaxItemNum(10);
        }
    }

    private View a(Context context, final s sVar) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dimension = (int) getResources().getDimension(d.f.ds194);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(dimension, dimension);
        }
        imageView.setLayoutParams(layoutParams);
        ai.c(imageView, d.g.new_frame_btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(d.l.add));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sVar != null) {
                    sVar.b(new com.baidu.tbadk.editortools.a(48, -1, true));
                }
            }
        });
        return imageView;
    }

    private void initUI() {
        this.aKV = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gFi = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.apT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
            layoutParams.leftMargin = k.g(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apT != null && (this.apT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
            layoutParams2.width = -2;
            this.apT.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ai.i(this.mName, d.e.cp_cont_b);
        this.gEE = (TextView) findViewById(d.h.btn_image_problem);
        bzQ();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.bpk);
        this.gEY = (ScrollView) findViewById(d.h.write_scrollview);
        this.gEY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bpd != null) {
                        k.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bpd);
                    }
                    if (WriteActivity.this.aAR != null) {
                        WriteActivity.this.aAR.Bm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gEA = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gEB = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gEy = (LinearLayout) findViewById(d.h.tool_view);
        this.gEy.setContentDescription("..");
        this.etP = (LinearLayout) findViewById(d.h.title_view);
        this.fPI = findViewById(d.h.interval_view);
        this.gFw = findViewById(d.h.hot_topic_fourm_view);
        this.gFx = findViewById(d.h.hot_topic_divider);
        this.gFy = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gFz = (TextView) findViewById(d.h.change_one_tv);
        blS();
        if (this.gFi) {
            this.gEY.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bzK();
        } else {
            bzP();
        }
        Sf();
        if (this.gEv || this.gEw) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahB) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bpe = (LinearLayout) findViewById(d.h.post_content_container);
        this.bpe.setDrawingCacheEnabled(false);
        this.bpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bpd.requestFocus();
                WriteActivity.this.aAR.Bm();
            }
        });
        this.apT.setOnFocusChangeListener(this.bpk);
        this.apT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.blL();
                WriteActivity.this.bzh();
            }
        });
        this.gEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bzT();
        j(bAf());
        bzX();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gEv || this.gEw) {
                    if (this.gEx) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fPH.setVisibility(0);
                this.bpd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.bpd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fPH.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.bpd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gFb.setVisibility(8);
                break;
            case 7:
                this.fPH.setVisibility(0);
                this.bpd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bzY();
        bAd();
        bzJ();
        bzV();
        blR();
        bAg();
        if (this.mData.getType() == 4 && this.fPN != null && this.gEC != null) {
            this.fPN.setVisibility(8);
            this.gEC.setVisibility(8);
        }
        blT();
        ShowSoftKeyPad(this.mInputManager, this.fPH);
        bzU();
    }

    private void bzQ() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bzR() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gEv && !this.gEw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = al.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bAb() != null) {
                bAb().setText(c);
                bAb().setSelection(c.length());
            }
        }
    }

    private void bzS() {
        this.gEP = null;
        this.gER = -1;
        this.gET = -1;
        z iJ = y.afY().iJ(1);
        if (iJ != null) {
            this.gEP = iJ.ckG;
            this.gER = getIntent().getIntExtra("category_id", -1);
            if (this.gEP != null && !this.gEP.isEmpty() && this.gER >= 0) {
                this.gEQ = new x();
                this.gEQ.ckC = 0;
                this.gEQ.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gET = this.gEQ.ckC;
                this.gES = this.gEQ.name;
                for (x xVar : this.gEP) {
                    if (xVar.ckC == this.gER) {
                        this.gET = xVar.ckC;
                        this.gES = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bzT() {
        if (this.gEP != null && !this.gEP.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gEU = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gEU.setText(this.gES);
            this.gEU.b(this.gEP, this.gEQ, this.gET);
            this.gEU.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.gEU.setText(asVar.name);
                        WriteActivity.this.mData.setCategoryTo(asVar.ckC);
                        WriteActivity.this.gET = asVar.ckC;
                        WriteActivity.this.gEU.bzb();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gEU.bza();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAb());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAa());
                }
            });
        }
    }

    private void bzU() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gFK = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gFK.setTitle(d.l.no_disturb_start_time);
        this.gFK.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gFK);
        this.gFK.setButton(-2, getPageContext().getString(d.l.alert_no_button), this.gFK);
        return this.gFK;
    }

    private void bzV() {
        this.gEK = (RelativeLayout) findViewById(d.h.addition_container);
        this.gEL = (TextView) findViewById(d.h.addition_create_time);
        this.gEM = (TextView) findViewById(d.h.addition_last_time);
        this.gEN = (TextView) findViewById(d.h.addition_last_content);
        if (this.gEJ != null) {
            this.gEK.setVisibility(0);
            this.gEL.setText(getPageContext().getString(d.l.write_addition_create) + al.r(this.gEJ.getCreateTime() * 1000));
            if (this.gEJ.getAlreadyCount() == 0) {
                this.gEM.setVisibility(8);
            } else {
                this.gEM.setText(getPageContext().getString(d.l.write_addition_last) + al.r(this.gEJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gEJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gEN.setText(lastAdditionContent);
            } else {
                this.gEN.setVisibility(8);
            }
            bAa().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gEJ.getAlreadyCount()), Integer.valueOf(this.gEJ.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gEK.setVisibility(8);
    }

    private void blR() {
        this.fPN = findViewById(d.h.post_prefix_layout);
        this.fPK = (TextView) findViewById(d.h.post_prefix);
        this.gEC = findViewById(d.h.prefix_divider);
        this.fPM = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fPN.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fPq = 1;
            this.fPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fPK.setVisibility(0);
                    WriteActivity.this.fPN.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fPL, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aAR.Bm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fPH);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bpd);
                }
            });
            this.fPM = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fPM.setVisibility(0);
                this.fPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fPK.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fPL, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aAR.Bm();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAb());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAa());
                    }
                });
            }
            this.fPL = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fPL.a(this);
            this.fPL.setMaxHeight(k.g(getActivity(), d.f.ds510));
            this.fPL.setOutsideTouchable(true);
            this.fPL.setFocusable(true);
            this.fPL.setOnDismissListener(this);
            this.fPL.setBackgroundDrawable(ai.getDrawable(d.e.cp_bg_line_d));
            int color = ai.getColor(d.e.cp_cont_b);
            int color2 = ai.getColor(d.e.cp_cont_c);
            ai.j(this.fPK, d.e.cp_bg_line_d);
            ai.c(this.fPM, d.g.icon_frs_arrow_n);
            this.fPK.setTextColor(color);
            this.gDw.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gDw.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fPL.addView(cVar);
            }
            this.fPL.uc(0);
            this.fPK.setText(prefixs.get(1));
            uz(1);
            return;
        }
        this.fPN.setVisibility(8);
    }

    private void bzW() {
        if (this.gEv && this.mData != null) {
            this.gEA.setVisibility(0);
            this.gEB.setVisibility(0);
            this.gEz = new FeedBackModel(this);
            this.gEz.tc(this.mData.getForumName());
            this.gEz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void g(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gEA.setVisibility(8);
                        WriteActivity.this.gEB.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gEA.setVisibility(8);
                        WriteActivity.this.gEB.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gEA.a(feedBackModel.bzB(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bzX() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.i.hh()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAb());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAa());
                    WriteActivity.this.aAR.Bm();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gEv) {
                            WriteActivity.this.bzi();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            aj ajVar = new aj("c12102");
                            ajVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(ajVar);
                            if (WriteActivity.this.gFt.bxs()) {
                                WriteActivity.this.bAj();
                            } else {
                                WriteActivity.this.gFu = true;
                                WriteActivity.this.gFt.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAi());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bzi();
                    }
                    TiebaStatic.log(new aj("c12262").aa("obj_locate", WriteActivity.this.gAY));
                }
            }
        });
    }

    protected void bzY() {
        this.gEF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gEF.cN(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bAb().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bAa().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    r.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    r.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.l.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.l.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    r.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    r.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.gEF.b(getPageContext());
    }

    protected void blS() {
        this.gCv = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gCv.setIsRound(true);
        this.gCv.setDrawBorder(false);
        this.gCv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dF = n.dF(currentPortrait);
            this.gCv.setUrl(dF);
            this.gCv.c(dF, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gCv.setVisibility(0);
        }
        this.fPH = (EditText) findViewById(d.h.post_title);
        this.fPH.setOnClickListener(this.gFH);
        this.fPH.setOnFocusChangeListener(this.bpk);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fPH.setText(this.mData.getTitle());
                this.fPH.setSelection(this.mData.getTitle().length());
            } else if (this.gEx) {
                this.fPH.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fPH.addTextChangedListener(this.bpm);
        if (!this.mData.getHaveDraft()) {
            bzR();
            this.gFs = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fPH.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fPH.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher baw() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            private int bpp;
            private EditText dxI = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.blT();
                if (WriteActivity.this.gFi) {
                    this.bpp = this.dxI.getSelectionStart();
                    this.dxI.setSelection(this.bpp);
                    WriteActivity.this.b(this.mTextView, this.dxI);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gFi || !WriteActivity.this.gFj) {
                    if (WriteActivity.this.gFi) {
                        if (this.dxI != WriteActivity.this.gEZ || this.mTextView != WriteActivity.this.gFf) {
                            this.dxI = WriteActivity.this.gEZ;
                            this.mTextView = WriteActivity.this.gFf;
                        }
                    }
                } else if (this.dxI != WriteActivity.this.gFd || this.mTextView != WriteActivity.this.gFe) {
                    this.dxI = WriteActivity.this.gFd;
                    this.mTextView = WriteActivity.this.gFe;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gFi && this.gFj) {
            if (this.gFg != null) {
                this.gFd.removeTextChangedListener(this.gFg);
            }
            this.gFg = textWatcher;
        } else if (this.gFi) {
            if (this.gFh != null) {
                this.gEZ.removeTextChangedListener(this.gFh);
            }
            this.gFh = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gEZ) {
            return 233L;
        }
        if (editText != this.gFd) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long h = h(editText);
            long f = h - f(editText);
            String valueOf = String.valueOf(f);
            if (h == 20) {
                if (f < 0) {
                    if (f < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ai.getColor(d.e.common_color_10159));
                } else {
                    textView.setTextColor(ai.getColor(d.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ai.getColor(d.e.common_color_10159));
            } else {
                textView.setTextColor(ai.getColor(d.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void Sf() {
        this.bpd = (EditText) findViewById(d.h.post_content);
        this.bpd.setDrawingCacheEnabled(false);
        this.bpd.setOnClickListener(this.gFH);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Eo().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.bpd.setText(Y);
            this.bpd.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gEG) {
                if (this.gEH != null && this.gEH.length() > 0) {
                    this.bpd.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gEH}));
                    this.bpd.setSelection(this.bpd.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bpd.setText(format);
                this.bpd.setSelection(format.length());
            }
        }
        this.bpd.setOnFocusChangeListener(this.bpk);
        this.bpd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aAR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bpd.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bpd.addTextChangedListener(this.gFJ);
        nh(true);
        if (this.mData.isUserFeedback()) {
            this.bpd.setHint(d.l.write_input_content);
        } else {
            this.bpd.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nh(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gFi) {
            bAa().setPadding(0, 0, 0, 0);
            bAa().setBackgroundDrawable(null);
            ai.k(bAa(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ebi) && this.gEJ == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.ebi, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass27) aVar, str, i);
                        if (aVar != null && aVar.kN() != null && aVar.kR() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kN(), aVar.kN().getNinePatchChunk(), aVar.kR(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bAa().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bAa(), true, WriteActivity.this.ePd);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzZ() {
        int i = 5000;
        if (this.gEJ != null) {
            i = 1000;
        }
        return bAa().getText() != null && bAa().getText().length() >= i;
    }

    private void fK(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gEt)) {
                this.gEt = "";
                bAa().requestFocus();
                if (bAa().getText() != null && bAa().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAa().getSelectionStart();
                    editable = bAa().getText();
                }
            } else if ("from_title".equals(this.gEt)) {
                this.gEt = "";
                bAb().requestFocus();
                if (bAb().getText() != null && bAb().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAb().getSelectionStart();
                    editable = bAb().getText();
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
    public void ni(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bAa().getText().getSpans(0, bAa().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gEI == null) {
                this.gEI = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gEI.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType yh = lVar.yh();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass29) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bAa().getSelectionStart(), aVar, yh);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bAa() != null && bAa().getText() != null) {
            Bitmap kN = aVar.kN();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
            int width = kN.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kN.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bAa().getSelectionStart() - 1;
                if (bAa().getText().length() > 1 && selectionStart >= 0 && bAa().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bAa().getText().insert(bAa().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bAa().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bAa().getText().insert(bAa().getSelectionStart(), spannableString2);
            }
            Editable text = bAa().getText();
            if (text != null) {
                this.gFD.clear();
                this.gFD.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gFD);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bAa().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bAa().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bAa().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAa() {
        return this.gFi ? this.gEZ : this.bpd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAb() {
        return this.gFi ? this.gFd : this.fPH;
    }

    protected void bAc() {
        Editable text;
        if (bAa() != null && (text = bAa().getText()) != null) {
            int selectionStart = bAa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAa().onKeyDown(67, this.gED);
            }
            bAa().onKeyDown(67, this.gED);
            int selectionStart2 = bAa().getSelectionStart();
            if (text != null) {
                this.gFD.clear();
                this.gFD.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gFD);
                bAa().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gEv = true;
        }
    }

    private void bAd() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bAe() {
        try {
            if (this.gEF != null) {
                this.gEF.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aKV.c(null);
        this.aKV.da(d.l.sending);
        this.aKV.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aKV.aH(false);
    }

    private Boolean bAf() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aCJ = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bAb() != null) {
                str = bAb().getText().toString();
            }
            if (bAa() != null) {
                str2 = bAa().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fPq == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dg(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dg(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dg(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gFi) {
                    dg(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dg(true);
                }
            }
            if (this.mData.getType() == 4) {
                dg(j(this.gEZ) && i(this.gFd));
            } else if (this.mData.getType() == 5) {
                dg(j(this.gEZ));
            } else if (!TextUtils.isEmpty(str2) || this.aCB != null) {
                dg(true);
            } else if (this.mData.getVideoInfo() != null) {
                dg(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                dg(true);
            } else {
                dg(false);
            }
        }
    }

    private void dg(boolean z) {
        if (z) {
            ai.b(this.mPost, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        ai.c(this.mPost, d.e.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean i(EditText editText) {
        long f = f(editText);
        return f <= 20 && f > 0;
    }

    private boolean j(EditText editText) {
        long f = f(editText);
        if (f > 233) {
            return false;
        }
        return f > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aCE = new NewWriteModel(this);
        this.aCE.b(this.aCV);
        registerListener(this.gFF);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.blL();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.gEv = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gEx = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gEG = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gEH = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aCC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gEJ = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gEJ != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gEO = bundle.getInt("mem_type", 0);
            this.aia = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gFA = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gAY = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gEv = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gEx = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gEG = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gEH = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gEJ = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gEJ != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gEO = intent.getIntExtra("mem_type", 0);
            this.aia = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gFA = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gAY = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gEv);
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
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                r.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                r.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            r.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            r.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            r.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.l.write_no_prefix));
        }
        this.ebi = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gEw = true;
        }
        bzS();
        try {
            this.gFk = bAn();
        } catch (Throwable th) {
            this.gFk = null;
        }
    }

    private void bAg() {
        if (u.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gCv.setVisibility(8);
            this.gFw.setVisibility(0);
            this.gFx.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fPH.setText(com.baidu.tbadk.plugins.a.gy(td(this.mList.get(0).mTopicName)));
                this.fPH.setMovementMethod(com.baidu.tieba.view.b.bwx());
            }
            this.gFy.setText(this.mList.get(0).mForumName);
            this.fPH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gFB.equals(charSequence.toString())) {
                        WriteActivity.this.gFC = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gy;
                    if (!WriteActivity.this.gFB.equals(editable.toString()) && (gy = com.baidu.tbadk.plugins.a.gy(editable.toString())) != null) {
                        WriteActivity.this.gFB = gy.toString();
                        WriteActivity.this.fPH.setText(gy);
                        if (WriteActivity.this.gFC <= WriteActivity.this.fPH.getText().length()) {
                            WriteActivity.this.fPH.setSelection(WriteActivity.this.gFC);
                        }
                    }
                }
            });
            this.gFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mData.getType() == 7) {
                        TiebaStatic.log("c12016");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 25005, WriteActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gy = com.baidu.tbadk.plugins.a.gy(td(hotTopicBussinessData.mTopicName));
            if (gy != null) {
                this.fPH.setText(gy);
            }
            this.gFy.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String td(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String td;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!j.isEmpty(writeData.getTitle())) {
                    this.etP.setVisibility(0);
                    this.etP.requestFocus();
                    this.aAR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (j.isEmpty(bAb().getText().toString()) || this.gFs || ((this.gEv || this.gEw) && !j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!u.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) u.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            td = this.mData.getTitle();
                        } else {
                            td = td(str);
                        }
                        SpannableString gy = com.baidu.tbadk.plugins.a.gy(td);
                        if (gy != null) {
                            bAb().setText(gy);
                            bAb().setSelection(gy.length() > td.length() ? td.length() : gy.length());
                        }
                    } else {
                        SpannableString gy2 = com.baidu.tbadk.plugins.a.gy(this.mData.getTitle());
                        if (gy2 != null) {
                            bAb().setText(gy2);
                            bAb().setSelection(this.mData.getTitle().length() > gy2.length() ? gy2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bzR();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((j.isEmpty(bAa().getText().toString()) || this.gEv || this.gEw) && !j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Eo().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gFG);
                    bAa().setText(a2);
                    bAa().setSelection(a2.length());
                    if (this.gFi) {
                        b(this.gFf, this.gEZ);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bAm();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DF();
                    }
                    nj(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bAh();
                }
                blT();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gEP != null) {
                    this.gET = this.gEQ.ckC;
                    this.gES = this.gEQ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gEP.size()) {
                            break;
                        }
                        x xVar = this.gEP.get(i);
                        if (categoryTo != xVar.ckC) {
                            i++;
                        } else {
                            this.gET = categoryTo;
                            this.gES = xVar.name;
                            this.mData.setCategoryTo(this.gET);
                            break;
                        }
                    }
                    if (this.gEU != null) {
                        this.gEU.setText(this.gES);
                        this.gEU.b(this.gEP, this.gEQ, this.gET);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aAR.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.aAR.Bm();
                return;
            }
            return;
        }
        bAh();
        bzR();
    }

    private void bAh() {
        if ((!this.gFi || this.gEX != null) && this.gEW != null) {
            this.gEX.c(this.writeImagesInfo);
            aGg();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gEG);
        if (this.gEv) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCC);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gEJ);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gEO);
        bundle.putString("from", this.aia);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gAY);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bAa().getEditableText().toString();
        if (obj != null) {
            bAa().setText(TbFaceManager.Eo().a(getPageContext().getPageActivity(), obj, this.gFG));
            bAa().setSelection(bAa().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAi() {
        return (bAa() == null || bAa().getText() == null) ? "" : bAa().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bAb() == null || bAb().getText() == null) {
            return "";
        }
        String obj = bAb().getText().toString();
        if (this.mPrefixData != null && u.u(this.mPrefixData.getPrefixs()) > 0 && this.fPq != 0 && this.mData.getType() != 4 && this.fPK != null && this.fPK.getText() != null) {
            obj = this.fPK.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzi() {
        blL();
        this.mData.setContent(bAi());
        this.mData.setTitle(getThreadTitle());
        if (this.gEv || this.gEw) {
            String string = getResources().getString(d.l.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.l.app_name) + getResources().getString(d.l.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.i.hh()) {
                    sb.append(com.baidu.adp.lib.util.i.hp());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gER >= 0) {
            this.mData.setCategoryFrom(this.gER);
        }
        if (this.gET >= 0) {
            this.mData.setCategoryTo(this.gET);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aCD != null && this.aCD.Th());
        this.aCE.mC(this.writeImagesInfo.size() > 0);
        if (!u.v(this.mList) && this.gFv != null && this.gFv.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gFv.mForumId));
            this.mData.setForumName(this.gFv.mForumName);
        }
        this.aCE.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aCB != null) {
            if (this.aCB.getId() != null) {
                this.aCE.getWriteData().setVoice(this.aCB.getId());
                this.aCE.getWriteData().setVoiceDuringTime(this.aCB.duration);
            } else {
                this.aCE.getWriteData().setVoice(null);
                this.aCE.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aCE.getWriteData().setVoice(null);
            this.aCE.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aCE.btx()) {
            showToast(d.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hh()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aCE.startPostWrite();
        }
    }

    private void p(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.gEJ != null) {
                i2 = this.gEJ.getTotalCount();
                i = this.gEJ.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.l.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        k.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    private void a(PostWriteCallBackData postWriteCallBackData, String str) {
        if (postWriteCallBackData != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aAR != null && !this.aAR.CV()) {
                    bAa().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
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
                            bAa().getText().insert(bAa().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    r.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    r.d(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    r.c(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                c(postWriteCallBackData);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bbU();
                            } else {
                                af(intent);
                            }
                        } else if (intExtra == 1) {
                            X(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gFi) {
                        B(intent);
                        blT();
                        return;
                    }
                    ah(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aAR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aAR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aAR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    blT();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.b.N(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gEu) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gEu = false;
                            }
                            sb2.append(stringExtra);
                            fK(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !u.v(this.mList)) {
                    if (!u.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gFv = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gFv);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gFt.ac(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.bpj = this.gFt.bxr();
                        this.aAR.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gFu) {
                        bAj();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aAR != null && !this.aAR.CV()) {
                this.bpd.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DA();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bAl();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aCC = String.valueOf(System.currentTimeMillis());
                    ah.b(getPageContext(), this.aCC);
                    return;
                case 12012:
                    bAl();
                    return;
                case 25004:
                    if ("from_title".equals(this.gEt)) {
                        bAb().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gEt)) {
                        bAa().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAj() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gFt.bxq());
        this.mData.setCallFrom(this.gAY);
        this.mData.setRecommendExt(this.gFt.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bzi();
    }

    private void bAk() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bAl() {
        if (this.gFi) {
            this.gEX.c(this.writeImagesInfo);
            aGg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGg() {
        this.gEX.notifyDataSetChanged();
        this.gEW.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gEX.notifyDataSetChanged();
                WriteActivity.this.gEW.invalidateViews();
            }
        }, 550L);
    }

    public void u(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        blT();
    }

    private void ae(Intent intent) {
        if (this.gFi) {
            ah(intent);
            bAl();
        } else {
            ai(intent);
        }
        blT();
    }

    private void ah(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bAl();
            nj(true);
        }
    }

    private void af(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bbU() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void X(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fry.parseJson(stringExtra);
            this.fry.updateQuality();
            if (this.fry.getChosedFiles() != null && this.fry.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fry.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fry.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bAb());
        HidenSoftKeyPad(this.mInputManager, bAa());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aCC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(getPageContext().getPageActivity(), k.af(getPageContext().getPageActivity())), k.dip2px(getPageContext().getPageActivity(), k.ag(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCC, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bAm();
            DF();
        }
        nj(true);
    }

    private void B(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bAm();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DF();
                }
            }
            nj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAm() {
        if (this.aAR.eC(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DA() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aCC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nj(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.chP == null) {
            this.chP = VoiceManager.instance();
        }
        return this.chP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afj() {
        this.chP = getVoiceManager();
        this.chP.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.to(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gEJ == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aCM = i;
        if (this.aAR != null) {
            this.aAR.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aAR.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DF() {
        if (!this.gFi) {
            if (this.aAR != null) {
                this.aAR.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aAR.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gEV != null) {
                this.gEV.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gEV.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (this.aAR != null) {
            this.aAR.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uz(int i) {
        if (i < this.gDw.size()) {
            for (int i2 = 0; i2 < this.gDw.size(); i2++) {
                this.gDw.get(i2).mZ(false);
            }
            this.gDw.get(i).mZ(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sA(int i) {
        this.fPq = i;
        this.fPL.uc(i);
        uz(i);
        this.fPK.setText(this.mPrefixData.getPrefixs().get(i));
        blT();
        g.a(this.fPL, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fPN.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dv();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = aa.a(strArr, iArr);
            if (aa.aD(getApplicationContext())) {
                ah.b(getPageContext(), this.aCC);
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gFq && System.currentTimeMillis() - this.gFr < 800) {
            k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.gFq = false;
        }
        if (this.gFE != null && !z) {
            this.gFE.byu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te(String str) {
        if (!j.isEmpty(str) && this.gFn != null) {
            tf(str);
            this.gFn.dismiss();
        }
    }

    private void bR(Context context) {
        gFp = k.ag(context);
    }

    private void tf(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gFq = true;
        bAm();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DF();
        }
        nj(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3941=4] */
    private static Bitmap c(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!j.isEmpty(str) && i > 0) {
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

    private File bAn() {
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
                if ((currentTimeMillis - file.lastModified()) / TbConfig.USE_TIME_INTERVAL > 1) {
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

    private void bAo() {
        if (this.gFk != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            bR(getActivity());
            this.gFm = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gFk != null) {
                        WriteActivity.this.te(WriteActivity.this.gFk.getAbsolutePath());
                    }
                }
            });
            this.gFl = (TbImageView) this.gFm.findViewById(d.h.rec_img_view);
            this.gFo = (LinearLayout) this.gFm.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gFk.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gFk.getAbsolutePath());
                Bitmap c = c(this.gFk.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (c != null) {
                    this.gFl.setImageBitmap(c);
                    this.gFl.setDrawBorder(true);
                    this.gFl.setBorderWidth(2);
                    this.gFl.setBorderColor(ai.getColor(d.e.common_color_10264));
                    this.gFn = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gFn.setCanceledOnTouchOutside(true);
                    this.gFn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gFq) {
                                k.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gFr = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gFn.setContentView(this.gFm);
                    this.gFn.show();
                    Window window = this.gFn.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gFp / 18) + getResources().getDimensionPixelSize(d.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(d.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(d.f.ds278);
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
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.gEu = false;
            this.gEt = "";
            if ("from_content".equals(str)) {
                this.gEt = "from_content";
            } else if ("from_title".equals(str)) {
                this.gEt = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                ni(false);
            }
        }
    }

    public void Bo() {
        if (this.gEv || !u.v(this.mList)) {
            this.etP.setVisibility(0);
            this.etP.requestFocus();
            this.aAR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.etP.setVisibility(8);
    }
}
