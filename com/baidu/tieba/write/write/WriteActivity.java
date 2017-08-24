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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.b.a.a;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0023a, VoiceManager.c, r.a, d.a {
    private static int gIs = 0;
    private i aCk;
    private VoiceData.VoiceModel aDT;
    private String aDU;
    private LocationModel aDV;
    private NewWriteModel aDW;
    private String ajv;
    private VoiceManager cjK;
    private LinearLayout exc;
    private TextView fSQ;
    private com.baidu.tieba.write.d fSR;
    private ImageView fSS;
    private View fST;
    private int fSw;
    private LinearLayout gHB;
    private View gHE;
    private View gHF;
    private Toast gHL;
    private AdditionData gHM;
    private RelativeLayout gHN;
    private TextView gHO;
    private TextView gHP;
    private TextView gHQ;
    List<x> gHS;
    x gHT;
    private int gHU;
    private String gHV;
    private int gHW;
    private PostCategoryView gHX;
    private NewFrameMultiImgToolView gHY;
    private View gIA;
    private TextView gIB;
    private TextView gIC;
    private com.baidu.tieba.write.b.b gIH;
    private com.baidu.tieba.view.a gIN;
    private com.baidu.tieba.write.a gIw;
    private HotTopicBussinessData gIy;
    private View gIz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gHw = "";
    private boolean gHx = false;
    private WriteData mData = null;
    private boolean gHy = false;
    private boolean gHz = false;
    private boolean gHA = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fSN = null;
    private HeadImageView gFy = null;
    private View fSO = null;
    private LinearLayout bqX = null;
    private EditText bqW = null;
    private FeedBackModel gHC = null;
    private FeedBackTopListView gHD = null;
    private ArrayList<com.baidu.tieba.write.c> gGz = new ArrayList<>();
    private String eev = null;
    private final KeyEvent gHG = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View arn = null;
    private TextView gHH = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gHI = null;
    private final Handler mHandler = new Handler();
    private boolean gHJ = false;
    private String gHK = null;
    private RelativeLayout mParent = null;
    private String aEb = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEe = 0;
    private int gHR = 0;
    private WriteImagesInfo fuF = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gHZ = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gIa = null;
    private ScrollView gIb = null;
    private EditText gIc = null;
    private View gId = null;
    private View gIe = null;
    private View gIf = null;
    private EditText gIg = null;
    private TextView gIh = null;
    private TextView gIi = null;
    private TextWatcher gIj = null;
    private TextWatcher gIk = null;
    private boolean gIl = false;
    private boolean gIm = false;
    private com.baidu.tbadk.core.view.a aMm = null;
    private File gIn = null;
    private TbImageView gIo = null;
    private View gIp = null;
    private Dialog gIq = null;
    private LinearLayout gIr = null;
    private boolean gIt = false;
    private long gIu = -1000;
    private boolean gIv = false;
    private String gEb = "2";
    private boolean gIx = false;
    private String gID = "";
    private String gIE = "";
    private int gIF = 0;
    private SpannableStringBuilder gIG = new SpannableStringBuilder();
    private final HttpMessageListener gII = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eev)) {
                    WriteActivity.this.eev = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nk(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eev)) {
                    WriteActivity.this.eev = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eev);
                    WriteActivity.this.nk(true);
                }
            }
        }
    };
    private TbFaceManager.a gIJ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan go(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kW());
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
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.afE();
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
                        if (!u.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gID)) {
                            TiebaStatic.log(new aj("c11731").aa("obj_id", WriteActivity.this.gID));
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
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yx());
                        if (WriteActivity.this.gHA) {
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
    private final LocationModel.a aEl = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DR() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void ge(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.btB())) {
                WriteActivity.this.b(2, true, aVar.btB());
            } else {
                ge(null);
            }
        }
    };
    private final CustomMessageListener glR = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDV.mD(false);
                    WriteActivity.this.aDV.cm(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDV.mD(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private final View.OnClickListener gIK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bAo = WriteActivity.this.bAo();
            if (bAo >= 0 && bAo < WriteActivity.this.bqW.getText().length()) {
                WriteActivity.this.bqW.setSelection(bAo);
            }
        }
    };
    private boolean gIL = true;
    private final View.OnFocusChangeListener brd = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fSN || view == WriteActivity.this.arn || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gIL = true;
                    WriteActivity.this.bAp();
                    if (WriteActivity.this.aCk != null) {
                        WriteActivity.this.aCk.Bu();
                    }
                    k.c(WriteActivity.this.getActivity(), WriteActivity.this.fSN);
                } else if (view == WriteActivity.this.fSN) {
                    WriteActivity.this.fSQ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bqW && z) {
                WriteActivity.this.gIL = false;
                WriteActivity.this.bAp();
                WriteActivity.this.aCk.Bu();
                k.c(WriteActivity.this.getActivity(), WriteActivity.this.bqW);
            }
        }
    };
    private TextWatcher brf = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmC();
        }
    };
    private TextWatcher gIM = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmC();
        }
    };
    private final a.InterfaceC0119a eSl = new a.InterfaceC0119a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0119a
        public void li() {
            WriteActivity.this.eev = null;
            WriteActivity.this.nk(false);
            WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ajv)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DE();
        } else if (this.aDV.btJ()) {
            DC();
        } else {
            this.aDV.mD(false);
            b(1, true, null);
            this.aDV.btH();
        }
    }

    private void DE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aDV.TK();
                } else {
                    WriteActivity.this.aEl.DR();
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
        aVar.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bAo() {
        int selectionEnd = bAG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bAG().getText().getSpans(0, bAG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bAG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bAG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAp() {
        if (this.aCk != null) {
            this.aCk.setBarLauncherEnabled(!this.gIL);
            this.aCk.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gIl) {
            this.fSN.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gIf.setVisibility(8);
            } else {
                this.gIf.setVisibility(0);
            }
            b(this.gIi, this.gIc);
            b(this.gIh, this.gIg);
            bmC();
        }
        if (this.gHy) {
            this.fSN.requestFocus();
            ShowSoftKeyPadDelay(this.fSN);
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
        bAC();
        this.aDV = new LocationModel(this);
        this.aDV.a(this.aEl);
        registerListener(this.glR);
        initEditor();
        bAU();
        if (this.gIl) {
            this.gIa.setEditorTools(this.aCk);
        } else {
            this.bqW.requestFocus();
        }
        Bw();
        DN();
        this.gIw = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCk = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aCk.setBarMaxLauCount(6);
        } else {
            this.aCk.setBarMaxLauCount(5);
        }
        this.aCk.setMoreButtonAtEnd(true);
        this.aCk.setBarLauncherType(1);
        this.aCk.bE(true);
        this.aCk.setMoreLauncherIcon(d.g.write_more);
        this.aCk.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bAs();
                break;
            default:
                bAt();
                break;
        }
        this.aCk.Db();
        if (this.gHB != null) {
            this.gHB.addView(this.aCk);
        }
        bAu();
        this.aCk.lS();
        l eC = this.aCk.eC(6);
        if (eC != null && !TextUtils.isEmpty(this.aEb)) {
            ((View) eC).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aEb);
                }
            });
        }
        if (!this.gIl) {
            this.aCk.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCk.Bu();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCk.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.brc = this.mData.getForumName() + getResources().getString(d.l.bar);
        }
        this.aCk.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gHY != null) {
            this.gHY.setEditorTools(this.aCk);
            this.gHY.bzA();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bAq() {
        this.gId = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gIf = this.gId.findViewById(d.h.live_post_title_container);
        this.gIc = (EditText) this.gId.findViewById(d.h.live_post_content);
        this.gHZ = (GridView) this.gId.findViewById(d.h.photoLiveGridView);
        this.gIg = (EditText) this.gId.findViewById(d.h.live_post_title);
        this.gIh = (TextView) this.gId.findViewById(d.h.titleOverPlusNumber);
        this.gIi = (TextView) this.gId.findViewById(d.h.contentOverPlusNumber);
        this.gIe = this.gId.findViewById(d.h.live_interval_view);
        this.gIh.setText(String.valueOf(20));
        this.gIi.setText(String.valueOf(233));
        this.gId.setVisibility(0);
        this.gIh.setVisibility(0);
        this.gIi.setVisibility(0);
        this.gIg.setHint(d.l.tips_title_limit_new);
        this.gIg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gIm = true;
                    WriteActivity.this.gIL = true;
                    WriteActivity.this.bAp();
                    if (WriteActivity.this.aCk != null) {
                        WriteActivity.this.aCk.Bu();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gIc.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gIc.setHint(d.l.live_write_input_content_update);
        }
        this.gIc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gIm = false;
                    WriteActivity.this.gIL = false;
                    WriteActivity.this.bAp();
                    if (WriteActivity.this.aCk != null) {
                        WriteActivity.this.aCk.Bu();
                    }
                }
            }
        });
        this.gIc.requestFocus();
        this.gIc.addTextChangedListener(bbi());
        this.gIg.requestFocus();
        this.gIg.addTextChangedListener(bbi());
        this.gIg.setOnClickListener(this.gIK);
        this.gIc.setOnClickListener(this.gIK);
        this.gIa = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gHZ);
        this.gIa.ux(6);
        this.gHZ.setAdapter((ListAdapter) this.gIa);
        View findViewById = this.gId.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bzF() {
                WriteActivity.this.aGT();
            }
        });
        bAr();
    }

    private void bAr() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gIg.setText(this.mData.getTitle());
                this.gIg.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gIl) {
            new com.baidu.tbadk.editortools.a(14, -1, 1);
            bAQ();
        }
        if (this.aCk.Dd()) {
            this.aCk.Bu();
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

    private void bAs() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aCk.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aCk.eE(5);
        if (eE != null) {
            eE.aCR = 2;
            eE.aCP = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aCP = d.g.write_at;
        this.aCk.b(aVar);
        this.aCk.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bAt() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aCP = d.g.write_picture;
            this.aCk.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aCk.b(aVar);
        aVar.aCP = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCR = 6;
            rVar4.aCP = d.g.write_privilege;
            this.aCk.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aCP = d.g.write_at;
        this.aCk.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCT = true;
            rVar3.aCR = 9;
            rVar3.aCP = 0;
            this.aCk.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCT = true;
            rVar2.aCR = 10;
            rVar2.aCP = 0;
            this.aCk.b(rVar2);
        }
        Boolean bAL = bAL();
        if (!this.gHy && bAL != null && bAL.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bue() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCR = 2;
            rVar.aCP = d.g.write_recorder;
            this.aCk.b(rVar);
        }
        if (this.gHM == null) {
            if (this.gIH == null) {
                this.gIH = new com.baidu.tieba.write.b.b(getActivity(), this.gEb);
            }
            this.aCk.b(this.gIH);
        }
        this.aCk.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aCk.eE(5);
        if (eE != null) {
            eE.aCR = 1;
            eE.aCP = d.g.write_emotion;
        }
    }

    private void bAu() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bAF()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.d(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bAF()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bAI();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aDT = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bmC();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aDT = null;
                        WriteActivity.this.bmC();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bAS();
                        WriteActivity.this.bmC();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gHM == null) {
                            WriteActivity.this.DF();
                            return;
                        }
                        switch (WriteActivity.this.aEe) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (aa.aD(pageActivity)) {
                                    WriteActivity.this.DD();
                                    return;
                                } else {
                                    aa.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.DC();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eev = null;
                        } else {
                            WriteActivity.this.eev = (String) aVar.data;
                        }
                        WriteActivity.this.nk(false);
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
                            WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aCk.Dd()) {
                                        WriteActivity.this.aCk.Bu();
                                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bmC();
                        if (WriteActivity.this.bqW != null) {
                            WriteActivity.this.bqW.requestFocus();
                        }
                        WriteActivity.this.aCk.Bu();
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bqW);
                    } else if (aVar.code == 40) {
                        if (((aVar.data instanceof String) || aVar.data == null) && WriteActivity.this.mData != null) {
                            WriteActivity.this.mData.setGraffitiFileName((String) aVar.data);
                            WriteActivity.this.bmC();
                        }
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gHx = true;
                        WriteActivity.this.nl(true);
                        if (WriteActivity.this.bAH().isFocused()) {
                            WriteActivity.this.gHw = "from_title";
                        } else if (WriteActivity.this.bAG().isFocused()) {
                            WriteActivity.this.gHw = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.exc.setVisibility(0);
                        WriteActivity.this.exc.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gIw.cp(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAO());
                        TiebaStatic.log(new aj("c12258").aa("obj_locate", WriteActivity.this.gEb));
                    }
                }
            }
        };
        this.aCk.a(16, bVar);
        this.aCk.a(14, bVar);
        this.aCk.a(24, bVar);
        this.aCk.a(3, bVar);
        this.aCk.a(10, bVar);
        this.aCk.a(11, bVar);
        this.aCk.a(12, bVar);
        this.aCk.a(13, bVar);
        this.aCk.a(15, bVar);
        this.aCk.a(18, bVar);
        this.aCk.a(25, bVar);
        this.aCk.a(27, bVar);
        this.aCk.a(29, bVar);
        this.aCk.a(40, bVar);
        this.aCk.a(43, bVar);
        this.aCk.a(45, bVar);
        this.aCk.a(48, bVar);
        this.aCk.a(46, bVar);
        this.aCk.a(49, bVar);
        this.aCk.a(47, bVar);
        this.aCk.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF() {
        if (this.aDV.TG()) {
            if (this.aDV.btJ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.btF().getLocationData().btB());
                return;
            }
            b(1, true, null);
            this.aDV.btH();
            return;
        }
        b(0, true, null);
    }

    protected void bmu() {
        if (this.aDW != null) {
            this.aDW.cancelLoadData();
        }
        if (this.gHC != null) {
            this.gHC.cancelLoadData();
        }
        if (this.aDV != null) {
            this.aDV.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bmu();
        bAK();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gIw != null) {
            this.gIw.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzN() {
        if (this.mData != null && this.mData.getType() == 2 && this.gHJ) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bAH().getText().toString());
            this.mData.setContent(bAG().getText().toString());
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
            if (this.fSR != null && this.fSR.isShowing()) {
                g.a(this.fSR, getPageContext().getPageActivity());
                return true;
            } else if (this.aCk.Dd()) {
                this.aCk.Bu();
                return true;
            } else {
                bmu();
                bzN();
                return true;
            }
        }
        if (i == 67 && (text = bAG().getText()) != null) {
            int selectionStart = bAG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAG().onKeyDown(67, this.gHG);
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
        getLayoutMode().t(this.gIr);
        if (this.gIo != null && i == 1) {
            this.gIo.setBorderColor(ai.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.c(this.mPost, d.e.cp_link_tip_a, 1);
        bAp();
        ai.k(this.gId, d.e.cp_bg_line_d);
        ai.k(this.fSO, d.e.cp_bg_line_c);
        ai.k(this.gIe, d.e.cp_bg_line_c);
        ai.k(bAH(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.eev)) {
            ai.k(bAG(), d.e.cp_bg_line_d);
        }
        bmC();
        this.aCk.onChangeSkinType(i);
        if (this.gHX != null) {
            this.gHX.xd();
        }
        ai.i(this.mName, d.e.cp_cont_b);
        this.fSN.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.bqW.setHintTextColor(ai.getColor(d.e.cp_cont_e));
    }

    private void bAv() {
        this.gHY = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gHY.initView();
        this.gHY.setVisibility(0);
        this.gHY.setAsyncLocalImageLoader(bVar);
        if (this.gHY.getDragLayer() != null && this.gHY.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gHY.getDragLayer());
            bVar2.a((e) this.gHY.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gHY.getDragHorizonScrollView());
            this.gHY.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gHY.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gHY.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gHY.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gHY));
            }
            this.gHY.getDragHorizonScrollView().setOnSwapDataListener(this.gHY);
            this.gHY.getDragHorizonScrollView().setMaxItemNum(10);
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
        this.aMm = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gIl = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.arn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            layoutParams.leftMargin = k.g(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.arn != null && (this.arn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            layoutParams2.width = -2;
            this.arn.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ai.i(this.mName, d.e.cp_cont_b);
        this.gHH = (TextView) findViewById(d.h.btn_image_problem);
        bAw();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.brd);
        this.gIb = (ScrollView) findViewById(d.h.write_scrollview);
        this.gIb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bqW != null) {
                        k.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bqW);
                    }
                    if (WriteActivity.this.aCk != null) {
                        WriteActivity.this.aCk.Bu();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gHD = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gHE = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gHB = (LinearLayout) findViewById(d.h.tool_view);
        this.gHB.setContentDescription("..");
        this.exc = (LinearLayout) findViewById(d.h.title_view);
        this.fSO = findViewById(d.h.interval_view);
        this.gIz = findViewById(d.h.hot_topic_fourm_view);
        this.gIA = findViewById(d.h.hot_topic_divider);
        this.gIB = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gIC = (TextView) findViewById(d.h.change_one_tv);
        bmB();
        if (this.gIl) {
            this.gIb.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bAq();
        } else {
            bAv();
        }
        SD();
        if (this.gHy || this.gHz) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiW) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bqX = (LinearLayout) findViewById(d.h.post_content_container);
        this.bqX.setDrawingCacheEnabled(false);
        this.bqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bqW.requestFocus();
                WriteActivity.this.aCk.Bu();
            }
        });
        this.arn.setOnFocusChangeListener(this.brd);
        this.arn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bmu();
                WriteActivity.this.bzN();
            }
        });
        this.gHH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bAz();
        j(bAL());
        bAD();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gHy || this.gHz) {
                    if (this.gHA) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fSN.setVisibility(0);
                this.bqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.bqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fSN.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.bqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gIe.setVisibility(8);
                break;
            case 7:
                this.fSN.setVisibility(0);
                this.bqW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bAE();
        bAJ();
        bAp();
        bAB();
        bmA();
        bAM();
        if (this.mData.getType() == 4 && this.fST != null && this.gHF != null) {
            this.fST.setVisibility(8);
            this.gHF.setVisibility(8);
        }
        bmC();
        ShowSoftKeyPad(this.mInputManager, this.fSN);
        bAA();
    }

    private void bAw() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bAx() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gHy && !this.gHz && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = al.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bAH() != null) {
                bAH().setText(d);
                bAH().setSelection(d.length());
            }
        }
    }

    private void bAy() {
        this.gHS = null;
        this.gHU = -1;
        this.gHW = -1;
        z iL = y.agu().iL(1);
        if (iL != null) {
            this.gHS = iL.cmB;
            this.gHU = getIntent().getIntExtra("category_id", -1);
            if (this.gHS != null && !this.gHS.isEmpty() && this.gHU >= 0) {
                this.gHT = new x();
                this.gHT.cmx = 0;
                this.gHT.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gHW = this.gHT.cmx;
                this.gHV = this.gHT.name;
                for (x xVar : this.gHS) {
                    if (xVar.cmx == this.gHU) {
                        this.gHW = xVar.cmx;
                        this.gHV = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bAz() {
        if (this.gHS != null && !this.gHS.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gHX = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gHX.setText(this.gHV);
            this.gHX.b(this.gHS, this.gHT, this.gHW);
            this.gHX.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.gHX.setText(asVar.name);
                        WriteActivity.this.mData.setCategoryTo(asVar.cmx);
                        WriteActivity.this.gHW = asVar.cmx;
                        WriteActivity.this.gHX.bzH();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gHX.bzG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAG());
                }
            });
        }
    }

    private void bAA() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gIN = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gIN.setTitle(d.l.no_disturb_start_time);
        this.gIN.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gIN);
        this.gIN.setButton(-2, getPageContext().getString(d.l.alert_no_button), this.gIN);
        return this.gIN;
    }

    private void bAB() {
        this.gHN = (RelativeLayout) findViewById(d.h.addition_container);
        this.gHO = (TextView) findViewById(d.h.addition_create_time);
        this.gHP = (TextView) findViewById(d.h.addition_last_time);
        this.gHQ = (TextView) findViewById(d.h.addition_last_content);
        if (this.gHM != null) {
            this.gHN.setVisibility(0);
            this.gHO.setText(getPageContext().getString(d.l.write_addition_create) + al.r(this.gHM.getCreateTime() * 1000));
            if (this.gHM.getAlreadyCount() == 0) {
                this.gHP.setVisibility(8);
            } else {
                this.gHP.setText(getPageContext().getString(d.l.write_addition_last) + al.r(this.gHM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gHM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gHQ.setText(lastAdditionContent);
            } else {
                this.gHQ.setVisibility(8);
            }
            bAG().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gHM.getAlreadyCount()), Integer.valueOf(this.gHM.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gHN.setVisibility(8);
    }

    private void bmA() {
        this.fST = findViewById(d.h.post_prefix_layout);
        this.fSQ = (TextView) findViewById(d.h.post_prefix);
        this.gHF = findViewById(d.h.prefix_divider);
        this.fSS = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fST.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fSw = 1;
            this.fST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fSQ.setVisibility(0);
                    WriteActivity.this.fST.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fSR, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCk.Bu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fSN);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bqW);
                }
            });
            this.fSS = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fSS.setVisibility(0);
                this.fSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fSQ.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fSR, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aCk.Bu();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAH());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAG());
                    }
                });
            }
            this.fSR = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fSR.a(this);
            this.fSR.setMaxHeight(k.g(getActivity(), d.f.ds510));
            this.fSR.setOutsideTouchable(true);
            this.fSR.setFocusable(true);
            this.fSR.setOnDismissListener(this);
            this.fSR.setBackgroundDrawable(ai.getDrawable(d.e.cp_bg_line_d));
            int color = ai.getColor(d.e.cp_cont_b);
            int color2 = ai.getColor(d.e.cp_cont_c);
            ai.j(this.fSQ, d.e.cp_bg_line_d);
            ai.c(this.fSS, d.g.icon_frs_arrow_n);
            this.fSQ.setTextColor(color);
            this.gGz.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gGz.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fSR.addView(cVar);
            }
            this.fSR.setCurrentIndex(0);
            this.fSQ.setText(prefixs.get(1));
            uH(1);
            return;
        }
        this.fST.setVisibility(8);
    }

    private void bAC() {
        if (this.gHy && this.mData != null) {
            this.gHD.setVisibility(0);
            this.gHE.setVisibility(0);
            this.gHC = new FeedBackModel(this);
            this.gHC.to(this.mData.getForumName());
            this.gHC.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void g(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gHD.setVisibility(8);
                        WriteActivity.this.gHE.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gHD.setVisibility(8);
                        WriteActivity.this.gHE.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gHD.a(feedBackModel.bAh(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bAD() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAG());
                    WriteActivity.this.aCk.Bu();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gHy) {
                            WriteActivity.this.bzO();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            aj ajVar = new aj("c12102");
                            ajVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(ajVar);
                            if (WriteActivity.this.gIw.bxZ()) {
                                WriteActivity.this.bAP();
                            } else {
                                WriteActivity.this.gIx = true;
                                WriteActivity.this.gIw.cp(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAO());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bzO();
                    }
                    TiebaStatic.log(new aj("c12262").aa("obj_locate", WriteActivity.this.gEb));
                }
            }
        });
    }

    protected void bAE() {
        this.gHI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gHI.cW(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bAH().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bAG().getText().toString());
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
        this.gHI.b(getPageContext());
    }

    protected void bmB() {
        this.gFy = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gFy.setIsRound(true);
        this.gFy.setDrawBorder(false);
        this.gFy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dP = n.dP(currentPortrait);
            this.gFy.setUrl(dP);
            this.gFy.c(dP, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gFy.setVisibility(0);
        }
        this.fSN = (EditText) findViewById(d.h.post_title);
        this.fSN.setOnClickListener(this.gIK);
        this.fSN.setOnFocusChangeListener(this.brd);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fSN.setText(this.mData.getTitle());
                this.fSN.setSelection(this.mData.getTitle().length());
            } else if (this.gHA) {
                this.fSN.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fSN.addTextChangedListener(this.brf);
        if (!this.mData.getHaveDraft()) {
            bAx();
            this.gIv = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fSN.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fSN.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher bbi() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            private int bri;
            private EditText dAX = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bmC();
                if (WriteActivity.this.gIl) {
                    this.bri = this.dAX.getSelectionStart();
                    this.dAX.setSelection(this.bri);
                    WriteActivity.this.b(this.mTextView, this.dAX);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gIl || !WriteActivity.this.gIm) {
                    if (WriteActivity.this.gIl) {
                        if (this.dAX != WriteActivity.this.gIc || this.mTextView != WriteActivity.this.gIi) {
                            this.dAX = WriteActivity.this.gIc;
                            this.mTextView = WriteActivity.this.gIi;
                        }
                    }
                } else if (this.dAX != WriteActivity.this.gIg || this.mTextView != WriteActivity.this.gIh) {
                    this.dAX = WriteActivity.this.gIg;
                    this.mTextView = WriteActivity.this.gIh;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gIl && this.gIm) {
            if (this.gIj != null) {
                this.gIg.removeTextChangedListener(this.gIj);
            }
            this.gIj = textWatcher;
        } else if (this.gIl) {
            if (this.gIk != null) {
                this.gIc.removeTextChangedListener(this.gIk);
            }
            this.gIk = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gIc) {
            return 233L;
        }
        if (editText != this.gIg) {
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

    protected void SD() {
        this.bqW = (EditText) findViewById(d.h.post_content);
        this.bqW.setDrawingCacheEnabled(false);
        this.bqW.setOnClickListener(this.gIK);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Ew().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.bqW.setText(Y);
            this.bqW.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gHJ) {
                if (this.gHK != null && this.gHK.length() > 0) {
                    this.bqW.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gHK}));
                    this.bqW.setSelection(this.bqW.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bqW.setText(format);
                this.bqW.setSelection(format.length());
            }
        }
        this.bqW.setOnFocusChangeListener(this.brd);
        this.bqW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aCk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bqW.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bqW.addTextChangedListener(this.gIM);
        nk(true);
        if (this.mData.isUserFeedback()) {
            this.bqW.setHint(d.l.write_input_content);
        } else {
            this.bqW.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nk(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gIl) {
            bAG().setPadding(0, 0, 0, 0);
            bAG().setBackgroundDrawable(null);
            ai.k(bAG(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eev) && this.gHM == null) {
                com.baidu.adp.lib.f.c.fU().a(this.eev, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass27) aVar, str, i);
                        if (aVar != null && aVar.kW() != null && aVar.la() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kW(), aVar.kW().getNinePatchChunk(), aVar.la(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bAG().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bAG(), true, WriteActivity.this.eSl);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAF() {
        int i = 5000;
        if (this.gHM != null) {
            i = 1000;
        }
        return bAG().getText() != null && bAG().getText().length() >= i;
    }

    private void fU(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gHw)) {
                this.gHw = "";
                bAG().requestFocus();
                if (bAG().getText() != null && bAG().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAG().getSelectionStart();
                    editable = bAG().getText();
                }
            } else if ("from_title".equals(this.gHw)) {
                this.gHw = "";
                bAH().requestFocus();
                if (bAH().getText() != null && bAH().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAH().getSelectionStart();
                    editable = bAH().getText();
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
    public void nl(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bAG().getText().getSpans(0, bAG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gHL == null) {
                this.gHL = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gHL.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType yp = lVar.yp();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fU().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass29) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bAG().getSelectionStart(), aVar, yp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bAG() != null && bAG().getText() != null) {
            Bitmap kW = aVar.kW();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kW);
            int width = kW.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kW.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bAG().getSelectionStart() - 1;
                if (bAG().getText().length() > 1 && selectionStart >= 0 && bAG().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bAG().getText().insert(bAG().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bAG().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bAG().getText().insert(bAG().getSelectionStart(), spannableString2);
            }
            Editable text = bAG().getText();
            if (text != null) {
                this.gIG.clear();
                this.gIG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gIG);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bAG().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bAG().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bAG().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAG() {
        return this.gIl ? this.gIc : this.bqW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAH() {
        return this.gIl ? this.gIg : this.fSN;
    }

    protected void bAI() {
        Editable text;
        if (bAG() != null && (text = bAG().getText()) != null) {
            int selectionStart = bAG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAG().onKeyDown(67, this.gHG);
            }
            bAG().onKeyDown(67, this.gHG);
            int selectionStart2 = bAG().getSelectionStart();
            if (text != null) {
                this.gIG.clear();
                this.gIG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gIG);
                bAG().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gHy = true;
        }
    }

    private void bAJ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bAK() {
        try {
            if (this.gHI != null) {
                this.gHI.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aMm.c(null);
        this.aMm.dc(d.l.sending);
        this.aMm.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aMm.aH(false);
    }

    private Boolean bAL() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aEb = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmC() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bAH() != null) {
                str = bAH().getText().toString();
            }
            if (bAG() != null) {
                str2 = bAG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fSw == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dh(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dh(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dh(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gIl) {
                    dh(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dh(true);
                }
            }
            if (this.mData.getType() == 4) {
                dh(j(this.gIc) && i(this.gIg));
            } else if (this.mData.getType() == 5) {
                dh(j(this.gIc));
            } else if (!TextUtils.isEmpty(str2) || this.aDT != null) {
                dh(true);
            } else if (this.mData.getVideoInfo() != null) {
                dh(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                dh(true);
            } else {
                dh(false);
            }
        }
    }

    private void dh(boolean z) {
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
        this.aDW = new NewWriteModel(this);
        this.aDW.b(this.aEn);
        registerListener(this.gII);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bmu();
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
            this.gHy = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gHA = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gHJ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gHK = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aDU = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gHM = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gHM != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gHR = bundle.getInt("mem_type", 0);
            this.ajv = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gID = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gEb = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gHy = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gHA = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gHJ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gHK = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gHM = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gHM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gHR = intent.getIntExtra("mem_type", 0);
            this.ajv = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gID = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gEb = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gHy);
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
        this.eev = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gHz = true;
        }
        bAy();
        try {
            this.gIn = bAT();
        } catch (Throwable th) {
            this.gIn = null;
        }
    }

    private void bAM() {
        if (u.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gFy.setVisibility(8);
            this.gIz.setVisibility(0);
            this.gIA.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fSN.setText(com.baidu.tbadk.plugins.a.gG(tp(this.mList.get(0).mTopicName)));
                this.fSN.setMovementMethod(com.baidu.tieba.view.b.bxf());
            }
            this.gIB.setText(this.mList.get(0).mForumName);
            this.fSN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gIE.equals(charSequence.toString())) {
                        WriteActivity.this.gIF = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gG;
                    if (!WriteActivity.this.gIE.equals(editable.toString()) && (gG = com.baidu.tbadk.plugins.a.gG(editable.toString())) != null) {
                        WriteActivity.this.gIE = gG.toString();
                        WriteActivity.this.fSN.setText(gG);
                        if (WriteActivity.this.gIF <= WriteActivity.this.fSN.getText().length()) {
                            WriteActivity.this.fSN.setSelection(WriteActivity.this.gIF);
                        }
                    }
                }
            });
            this.gIC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
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
            SpannableString gG = com.baidu.tbadk.plugins.a.gG(tp(hotTopicBussinessData.mTopicName));
            if (gG != null) {
                this.fSN.setText(gG);
            }
            this.gIB.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tp(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String tp;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!j.isEmpty(writeData.getTitle())) {
                    this.exc.setVisibility(0);
                    this.exc.requestFocus();
                    this.aCk.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (j.isEmpty(bAH().getText().toString()) || this.gIv || ((this.gHy || this.gHz) && !j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!u.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) u.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            tp = this.mData.getTitle();
                        } else {
                            tp = tp(str);
                        }
                        SpannableString gG = com.baidu.tbadk.plugins.a.gG(tp);
                        if (gG != null) {
                            bAH().setText(gG);
                            bAH().setSelection(gG.length() > tp.length() ? tp.length() : gG.length());
                        }
                    } else {
                        SpannableString gG2 = com.baidu.tbadk.plugins.a.gG(this.mData.getTitle());
                        if (gG2 != null) {
                            bAH().setText(gG2);
                            bAH().setSelection(this.mData.getTitle().length() > gG2.length() ? gG2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bAx();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((j.isEmpty(bAG().getText().toString()) || this.gHy || this.gHz) && !j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ew().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gIJ);
                    bAG().setText(a2);
                    bAG().setSelection(a2.length());
                    if (this.gIl) {
                        b(this.gIi, this.gIc);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bAS();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DN();
                    }
                    nm(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bAN();
                }
                bmC();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gHS != null) {
                    this.gHW = this.gHT.cmx;
                    this.gHV = this.gHT.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gHS.size()) {
                            break;
                        }
                        x xVar = this.gHS.get(i);
                        if (categoryTo != xVar.cmx) {
                            i++;
                        } else {
                            this.gHW = categoryTo;
                            this.gHV = xVar.name;
                            this.mData.setCategoryTo(this.gHW);
                            break;
                        }
                    }
                    if (this.gHX != null) {
                        this.gHX.setText(this.gHV);
                        this.gHX.b(this.gHS, this.gHT, this.gHW);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aCk.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.aCk.Bu();
                return;
            }
            return;
        }
        bAN();
        bAx();
    }

    private void bAN() {
        if ((!this.gIl || this.gIa != null) && this.gHZ != null) {
            this.gIa.c(this.writeImagesInfo);
            aGT();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gHJ);
        if (this.gHy) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDU);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gHM);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gHR);
        bundle.putString("from", this.ajv);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gEb);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bAG().getEditableText().toString();
        if (obj != null) {
            bAG().setText(TbFaceManager.Ew().a(getPageContext().getPageActivity(), obj, this.gIJ));
            bAG().setSelection(bAG().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAO() {
        return (bAG() == null || bAG().getText() == null) ? "" : bAG().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bAH() == null || bAH().getText() == null) {
            return "";
        }
        String obj = bAH().getText().toString();
        if (this.mPrefixData != null && u.u(this.mPrefixData.getPrefixs()) > 0 && this.fSw != 0 && this.mData.getType() != 4 && this.fSQ != null && this.fSQ.getText() != null) {
            obj = this.fSQ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzO() {
        bmu();
        this.mData.setContent(bAO());
        this.mData.setTitle(getThreadTitle());
        if (this.gHy || this.gHz) {
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
                if (com.baidu.adp.lib.util.i.hr()) {
                    sb.append(com.baidu.adp.lib.util.i.hz());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gHU >= 0) {
            this.mData.setCategoryFrom(this.gHU);
        }
        if (this.gHW >= 0) {
            this.mData.setCategoryTo(this.gHW);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDV != null && this.aDV.TG());
        this.aDW.mF(this.writeImagesInfo.size() > 0);
        if (!u.v(this.mList) && this.gIy != null && this.gIy.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gIy.mForumId));
            this.mData.setForumName(this.gIy.mForumName);
        }
        this.aDW.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aDT != null) {
            if (this.aDT.getId() != null) {
                this.aDW.getWriteData().setVoice(this.aDT.getId());
                this.aDW.getWriteData().setVoiceDuringTime(this.aDT.duration);
            } else {
                this.aDW.getWriteData().setVoice(null);
                this.aDW.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDW.getWriteData().setVoice(null);
            this.aDW.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDW.buf()) {
            showToast(d.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hr()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aDW.startPostWrite();
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
            if (this.gHM != null) {
                i2 = this.gHM.getTotalCount();
                i = this.gHM.getAlreadyCount() + 1;
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
                if (this.aCk != null && !this.aCk.Dd()) {
                    bAG().requestFocus();
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
                            bAG().getText().insert(bAG().getSelectionStart(), sb.toString());
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
                                bcG();
                            } else {
                                ah(intent);
                            }
                        } else if (intExtra == 1) {
                            Z(intent);
                        } else {
                            ag(intent);
                            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gIl) {
                        B(intent);
                        bmC();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aCk.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aCk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aCk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bmC();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.b.P(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gHx) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gHx = false;
                            }
                            sb2.append(stringExtra);
                            fU(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !u.v(this.mList)) {
                    if (!u.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gIy = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gIy);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gIw.ae(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.brc = this.gIw.bxY();
                        this.aCk.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gIx) {
                        bAP();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aCk != null && !this.aCk.Dd()) {
                this.bqW.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DI();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bAR();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDU = String.valueOf(System.currentTimeMillis());
                    ah.b(getPageContext(), this.aDU);
                    return;
                case 12012:
                    bAR();
                    return;
                case 25004:
                    if ("from_title".equals(this.gHw)) {
                        bAH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gHw)) {
                        bAG().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gIw.bxX());
        this.mData.setCallFrom(this.gEb);
        this.mData.setRecommendExt(this.gIw.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bzO();
    }

    private void bAQ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bAR() {
        if (this.gIl) {
            this.gIa.c(this.writeImagesInfo);
            aGT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGT() {
        this.gIa.notifyDataSetChanged();
        this.gHZ.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gIa.notifyDataSetChanged();
                WriteActivity.this.gHZ.invalidateViews();
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
        bmC();
    }

    private void ag(Intent intent) {
        if (this.gIl) {
            aj(intent);
            bAR();
        } else {
            ak(intent);
        }
        bmC();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bAR();
            nm(true);
        }
    }

    private void ah(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bcG() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void Z(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fuF.parseJson(stringExtra);
            this.fuF.updateQuality();
            if (this.fuF.getChosedFiles() != null && this.fuF.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fuF.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fuF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bAH());
        HidenSoftKeyPad(this.mInputManager, bAG());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ak(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aDU = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDU;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(getPageContext().getPageActivity(), k.ag(getPageContext().getPageActivity())), k.dip2px(getPageContext().getPageActivity(), k.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDU, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bAS();
            DN();
        }
        nm(true);
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
                bAS();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DN();
                }
            }
            nm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAS() {
        if (this.aCk.eE(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DI() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDU));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nm(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cjK == null) {
            this.cjK = VoiceManager.instance();
        }
        return this.cjK;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afE() {
        this.cjK = getVoiceManager();
        this.cjK.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tx(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gHM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEe = i;
        if (this.aCk != null) {
            this.aCk.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aCk.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DN() {
        if (!this.gIl) {
            if (this.aCk != null) {
                this.aCk.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aCk.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gHY != null) {
                this.gHY.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gHY.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (this.aCk != null) {
            this.aCk.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uH(int i) {
        if (i < this.gGz.size()) {
            for (int i2 = 0; i2 < this.gGz.size(); i2++) {
                this.gGz.get(i2).nc(false);
            }
            this.gGz.get(i).nc(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sJ(int i) {
        this.fSw = i;
        this.fSR.setCurrentIndex(i);
        uH(i);
        this.fSQ.setText(this.mPrefixData.getPrefixs().get(i));
        bmC();
        g.a(this.fSR, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fST.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0023a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DD();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = aa.a(strArr, iArr);
            if (aa.aE(getApplicationContext())) {
                ah.b(getPageContext(), this.aDU);
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
        if (this.gIt && System.currentTimeMillis() - this.gIu < 800) {
            k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.gIt = false;
        }
        if (this.gIH != null && !z) {
            this.gIH.bza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(String str) {
        if (!j.isEmpty(str) && this.gIq != null) {
            tr(str);
            this.gIq.dismiss();
        }
    }

    private void bQ(Context context) {
        gIs = k.ah(context);
    }

    private void tr(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gIt = true;
        bAS();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DN();
        }
        nm(true);
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

    private File bAT() {
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

    private void bAU() {
        if (this.gIn != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            bQ(getActivity());
            this.gIp = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gIn != null) {
                        WriteActivity.this.tq(WriteActivity.this.gIn.getAbsolutePath());
                    }
                }
            });
            this.gIo = (TbImageView) this.gIp.findViewById(d.h.rec_img_view);
            this.gIr = (LinearLayout) this.gIp.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gIn.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gIn.getAbsolutePath());
                Bitmap c = c(this.gIn.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (c != null) {
                    this.gIo.setImageBitmap(c);
                    this.gIo.setDrawBorder(true);
                    this.gIo.setBorderWidth(2);
                    this.gIo.setBorderColor(ai.getColor(d.e.common_color_10264));
                    this.gIq = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gIq.setCanceledOnTouchOutside(true);
                    this.gIq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gIt) {
                                k.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gIu = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gIq.setContentView(this.gIp);
                    this.gIq.show();
                    Window window = this.gIq.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gIs / 18) + getResources().getDimensionPixelSize(d.f.ds12);
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
            this.gHx = false;
            this.gHw = "";
            if ("from_content".equals(str)) {
                this.gHw = "from_content";
            } else if ("from_title".equals(str)) {
                this.gHw = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nl(false);
            }
        }
    }

    public void Bw() {
        if (this.gHy || !u.v(this.mList)) {
            this.exc.setVisibility(0);
            this.exc.requestFocus();
            this.aCk.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.exc.setVisibility(8);
    }
}
