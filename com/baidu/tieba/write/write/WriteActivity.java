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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, VoiceManager.c, r.a, d.a {
    private static int gHR = 0;
    private i aBt;
    private VoiceData.VoiceModel aDh;
    private String aDi;
    private LocationModel aDj;
    private NewWriteModel aDk;
    private String aiO;
    private VoiceManager cpV;
    private int fRS;
    private TextView fSm;
    private com.baidu.tieba.write.d fSn;
    private ImageView fSo;
    private View fSp;
    private LinearLayout gGZ;
    private com.baidu.tieba.write.a gHV;
    private HotTopicBussinessData gHX;
    private View gHY;
    private View gHZ;
    private LinearLayout gHa;
    private View gHd;
    private View gHe;
    private Toast gHk;
    private AdditionData gHl;
    private RelativeLayout gHm;
    private TextView gHn;
    private TextView gHo;
    private TextView gHp;
    List<x> gHr;
    x gHs;
    private int gHt;
    private String gHu;
    private int gHv;
    private PostCategoryView gHw;
    private NewFrameMultiImgToolView gHx;
    private TextView gIa;
    private TextView gIb;
    private com.baidu.tieba.write.b.b gIg;
    private com.baidu.tieba.view.a gIm;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gGU = "";
    private boolean gGV = false;
    private WriteData mData = null;
    private boolean gGW = false;
    private boolean gGX = false;
    private boolean gGY = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fSj = null;
    private HeadImageView gEX = null;
    private View fSk = null;
    private LinearLayout brW = null;
    private EditText brV = null;
    private FeedBackModel gHb = null;
    private FeedBackTopListView gHc = null;
    private ArrayList<com.baidu.tieba.write.c> gFX = new ArrayList<>();
    private String elY = null;
    private final KeyEvent gHf = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqQ = null;
    private TextView gHg = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gHh = null;
    private final Handler mHandler = new Handler();
    private boolean gHi = false;
    private String gHj = null;
    private RelativeLayout mParent = null;
    private String aDp = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDs = 0;
    private int gHq = 0;
    private WriteImagesInfo ftS = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gHy = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gHz = null;
    private ScrollView gHA = null;
    private EditText gHB = null;
    private View gHC = null;
    private View gHD = null;
    private View gHE = null;
    private EditText gHF = null;
    private TextView gHG = null;
    private TextView gHH = null;
    private TextWatcher gHI = null;
    private TextWatcher gHJ = null;
    private boolean gHK = false;
    private boolean gHL = false;
    private com.baidu.tbadk.core.view.a aLP = null;
    private File gHM = null;
    private TbImageView gHN = null;
    private View gHO = null;
    private Dialog gHP = null;
    private LinearLayout gHQ = null;
    private boolean gHS = false;
    private long gHT = -1000;
    private boolean gHU = false;
    private String gDH = "2";
    private boolean gHW = false;
    private String gIc = "";
    private String gId = "";
    private int gIe = 0;
    private SpannableStringBuilder gIf = new SpannableStringBuilder();
    private final HttpMessageListener gIh = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.elY)) {
                    WriteActivity.this.elY = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nr(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.elY)) {
                    WriteActivity.this.elY = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.elY);
                    WriteActivity.this.nr(true);
                }
            }
        }
    };
    private TbFaceManager.a gIi = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gi(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kO());
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
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ahn();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                if (z) {
                    WriteActivity.this.bM(z);
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
                        if (!v.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gIc)) {
                            TiebaStatic.log(new ak("c11731").ad("obj_id", WriteActivity.this.gIc));
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
                    writeData.setVcodeExtra(qVar.yB());
                    if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yA());
                        if (WriteActivity.this.gGY) {
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
    private final LocationModel.a aDz = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DM() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fY(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.btb())) {
                WriteActivity.this.a(2, true, aVar.btb());
            } else {
                fY(null);
            }
        }
    };
    private final CustomMessageListener gln = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDj.mK(false);
                    WriteActivity.this.aDj.cl(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDj.mK(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private final View.OnClickListener gIj = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bzP = WriteActivity.this.bzP();
            if (bzP >= 0 && bzP < WriteActivity.this.brV.getText().length()) {
                WriteActivity.this.brV.setSelection(bzP);
            }
        }
    };
    private boolean gIk = true;
    private final View.OnFocusChangeListener bsc = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fSj || view == WriteActivity.this.aqQ || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gIk = true;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bp();
                    }
                    k.b(WriteActivity.this.getActivity(), WriteActivity.this.fSj);
                } else if (view == WriteActivity.this.fSj) {
                    WriteActivity.this.fSm.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.brV && z) {
                WriteActivity.this.gIk = false;
                WriteActivity.this.bzQ();
                WriteActivity.this.aBt.Bp();
                k.b(WriteActivity.this.getActivity(), WriteActivity.this.brV);
            }
        }
    };
    private TextWatcher bse = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmb();
        }
    };
    private TextWatcher gIl = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmb();
        }
    };
    private final a.InterfaceC0121a eRx = new a.InterfaceC0121a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0121a
        public void la() {
            WriteActivity.this.elY = null;
            WriteActivity.this.nr(false);
            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aiO)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dz();
        } else if (this.aDj.btj()) {
            Dx();
        } else {
            this.aDj.mK(false);
            a(1, true, (String) null);
            this.aDj.bth();
        }
    }

    private void Dz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hi()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aDj.UG();
                } else {
                    WriteActivity.this.aDz.DM();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzP() {
        int selectionEnd = bAh().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bAh().getText().getSpans(0, bAh().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bAh().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bAh().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzQ() {
        if (this.aBt != null) {
            this.aBt.setBarLauncherEnabled(!this.gIk);
            this.aBt.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gHK) {
            this.fSj.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gHE.setVisibility(8);
            } else {
                this.gHE.setVisibility(0);
            }
            b(this.gHH, this.gHB);
            b(this.gHG, this.gHF);
            bmb();
        }
        if (this.gGW) {
            this.fSj.requestFocus();
            ShowSoftKeyPadDelay(this.fSj);
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
        bAd();
        this.aDj = new LocationModel(this);
        this.aDj.a(this.aDz);
        registerListener(this.gln);
        initEditor();
        bAv();
        if (this.gHK) {
            this.gHz.setEditorTools(this.aBt);
        } else {
            this.brV.requestFocus();
        }
        Br();
        DI();
        this.gHV = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBt = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aBt.setBarMaxLauCount(6);
        } else {
            this.aBt.setBarMaxLauCount(5);
        }
        this.aBt.setMoreButtonAtEnd(true);
        this.aBt.setBarLauncherType(1);
        this.aBt.bD(true);
        this.aBt.setMoreLauncherIcon(d.g.write_more);
        this.aBt.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bzT();
                break;
            default:
                bzU();
                break;
        }
        this.aBt.CW();
        if (this.gGZ != null) {
            this.gGZ.addView(this.aBt);
        }
        bzV();
        this.aBt.lK();
        l eC = this.aBt.eC(6);
        if (eC != null && !TextUtils.isEmpty(this.aDp)) {
            ((View) eC).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDp);
                }
            });
        }
        if (!this.gHK) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBt.Bp();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.bsb = this.mData.getForumName() + getResources().getString(d.l.forum);
        }
        this.aBt.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gHx != null) {
            this.gHx.setEditorTools(this.aBt);
            this.gHx.bza();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bzR() {
        this.gHC = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gHE = this.gHC.findViewById(d.h.live_post_title_container);
        this.gHB = (EditText) this.gHC.findViewById(d.h.live_post_content);
        this.gHy = (GridView) this.gHC.findViewById(d.h.photoLiveGridView);
        this.gHF = (EditText) this.gHC.findViewById(d.h.live_post_title);
        this.gHG = (TextView) this.gHC.findViewById(d.h.titleOverPlusNumber);
        this.gHH = (TextView) this.gHC.findViewById(d.h.contentOverPlusNumber);
        this.gHD = this.gHC.findViewById(d.h.live_interval_view);
        this.gHG.setText(String.valueOf(20));
        this.gHH.setText(String.valueOf(233));
        this.gHC.setVisibility(0);
        this.gHG.setVisibility(0);
        this.gHH.setVisibility(0);
        this.gHF.setHint(d.l.tips_title_limit_new);
        this.gHF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gHL = true;
                    WriteActivity.this.gIk = true;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bp();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gHB.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gHB.setHint(d.l.live_write_input_content_update);
        }
        this.gHB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gHL = false;
                    WriteActivity.this.gIk = false;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bp();
                    }
                }
            }
        });
        this.gHB.requestFocus();
        this.gHB.addTextChangedListener(baE());
        this.gHF.requestFocus();
        this.gHF.addTextChangedListener(baE());
        this.gHF.setOnClickListener(this.gIj);
        this.gHB.setOnClickListener(this.gIj);
        this.gHz = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gHy);
        this.gHz.uB(6);
        this.gHy.setAdapter((ListAdapter) this.gHz);
        View findViewById = this.gHC.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bzf() {
                WriteActivity.this.aIR();
            }
        });
        bzS();
    }

    private void bzS() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gHF.setText(this.mData.getTitle());
                this.gHF.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gHK) {
            bAr();
        }
        if (this.aBt.CY()) {
            this.aBt.Bp();
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

    private void bzT() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBt.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aBt.eE(5);
        if (eE != null) {
            eE.aCb = 2;
            eE.aBZ = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBZ = d.g.write_at;
        this.aBt.b(aVar);
        this.aBt.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bzU() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBZ = d.g.write_picture;
            this.aBt.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aBt.b(aVar);
        aVar.aBZ = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCb = 6;
            rVar4.aBZ = d.g.write_privilege;
            this.aBt.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBZ = d.g.write_at;
        this.aBt.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCd = true;
            rVar3.aCb = 9;
            rVar3.aBZ = 0;
            this.aBt.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCd = true;
            rVar2.aCb = 10;
            rVar2.aBZ = 0;
            this.aBt.b(rVar2);
        }
        Boolean bAm = bAm();
        if (!this.gGW && bAm != null && bAm.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.btE() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCb = 2;
            rVar.aBZ = d.g.write_recorder;
            this.aBt.b(rVar);
        }
        if (this.gHl == null) {
            if (this.gIg == null) {
                this.gIg = new com.baidu.tieba.write.b.b(getActivity(), this.gDH);
            }
            this.aBt.b(this.gIg);
        }
        this.aBt.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aBt.eE(5);
        if (eE != null) {
            eE.aCb = 1;
            eE.aBZ = d.g.write_emotion;
        }
    }

    private void bzV() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bAg()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.d(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bAg()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bAj();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aDh = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bmb();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aDh = null;
                        WriteActivity.this.bmb();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bAt();
                        WriteActivity.this.bmb();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gHl == null) {
                            WriteActivity.this.DA();
                            return;
                        }
                        switch (WriteActivity.this.aDs) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aJ(pageActivity)) {
                                    WriteActivity.this.Dy();
                                    return;
                                } else {
                                    ab.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Dx();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.elY = null;
                        } else {
                            WriteActivity.this.elY = (String) aVar.data;
                        }
                        WriteActivity.this.nr(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ad("fid", str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBt.CY()) {
                                        WriteActivity.this.aBt.Bp();
                                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bmb();
                        if (WriteActivity.this.brV != null) {
                            WriteActivity.this.brV.requestFocus();
                        }
                        WriteActivity.this.aBt.Bp();
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.brV);
                    } else if (aVar.code == 40) {
                        if (((aVar.data instanceof String) || aVar.data == null) && WriteActivity.this.mData != null) {
                            WriteActivity.this.mData.setGraffitiFileName((String) aVar.data);
                            WriteActivity.this.bmb();
                        }
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gGV = true;
                        WriteActivity.this.ns(true);
                        if (WriteActivity.this.bAi().isFocused()) {
                            WriteActivity.this.gGU = "from_title";
                        } else if (WriteActivity.this.bAh().isFocused()) {
                            WriteActivity.this.gGU = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gHa.setVisibility(0);
                        WriteActivity.this.gHa.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gHV.co(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAp());
                        TiebaStatic.log(new ak("c12258").ad("obj_locate", WriteActivity.this.gDH));
                    }
                }
            }
        };
        this.aBt.a(16, bVar);
        this.aBt.a(14, bVar);
        this.aBt.a(24, bVar);
        this.aBt.a(3, bVar);
        this.aBt.a(10, bVar);
        this.aBt.a(11, bVar);
        this.aBt.a(12, bVar);
        this.aBt.a(13, bVar);
        this.aBt.a(15, bVar);
        this.aBt.a(18, bVar);
        this.aBt.a(25, bVar);
        this.aBt.a(27, bVar);
        this.aBt.a(29, bVar);
        this.aBt.a(40, bVar);
        this.aBt.a(43, bVar);
        this.aBt.a(45, bVar);
        this.aBt.a(48, bVar);
        this.aBt.a(46, bVar);
        this.aBt.a(49, bVar);
        this.aBt.a(47, bVar);
        this.aBt.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        if (this.aDj.UC()) {
            if (this.aDj.btj()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.btf().getLocationData().btb());
                return;
            }
            a(1, true, (String) null);
            this.aDj.bth();
            return;
        }
        a(0, true, (String) null);
    }

    protected void blT() {
        if (this.aDk != null) {
            this.aDk.cancelLoadData();
        }
        if (this.gHb != null) {
            this.gHb.cancelLoadData();
        }
        if (this.aDj != null) {
            this.aDj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        blT();
        bAl();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gHV != null) {
            this.gHV.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzo() {
        if (this.mData != null && this.mData.getType() == 2 && this.gHi) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bAi().getText().toString());
            this.mData.setContent(bAh().getText().toString());
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
            if (this.fSn != null && this.fSn.isShowing()) {
                g.a(this.fSn, getPageContext().getPageActivity());
                return true;
            } else if (this.aBt.CY()) {
                this.aBt.Bp();
                return true;
            } else {
                blT();
                bzo();
                return true;
            }
        }
        if (i == 67 && (text = bAh().getText()) != null) {
            int selectionStart = bAh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAh().onKeyDown(67, this.gHf);
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
        getLayoutMode().t(this.gHQ);
        if (this.gHN != null && i == 1) {
            this.gHN.setBorderColor(aj.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.e.cp_link_tip_a, 1);
        bzQ();
        aj.k(this.gHC, d.e.cp_bg_line_d);
        aj.k(this.fSk, d.e.cp_bg_line_c);
        aj.k(this.gHD, d.e.cp_bg_line_c);
        aj.k(bAi(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.elY)) {
            aj.k(bAh(), d.e.cp_bg_line_d);
        }
        bmb();
        this.aBt.onChangeSkinType(i);
        if (this.gHw != null) {
            this.gHw.xc();
        }
        aj.i(this.mName, d.e.cp_cont_b);
        this.fSj.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.brV.setHintTextColor(aj.getColor(d.e.cp_cont_e));
    }

    private void bzW() {
        this.gHx = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gHx.initView();
        this.gHx.setVisibility(0);
        this.gHx.setAsyncLocalImageLoader(bVar);
        if (this.gHx.getDragLayer() != null && this.gHx.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gHx.getDragLayer());
            bVar2.a((e) this.gHx.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gHx.getDragHorizonScrollView());
            this.gHx.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gHx.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gHx.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gHx.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gHx));
            }
            this.gHx.getDragHorizonScrollView().setOnSwapDataListener(this.gHx);
            this.gHx.getDragHorizonScrollView().setMaxItemNum(10);
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
        aj.c(imageView, d.g.new_frame_btn_add_photo_selector);
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
        this.aLP = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gHK = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aqQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqQ.getLayoutParams();
            layoutParams.leftMargin = k.f(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqQ != null && (this.aqQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqQ.getLayoutParams();
            layoutParams2.width = -2;
            this.aqQ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.e.cp_cont_b);
        this.gHg = (TextView) findViewById(d.h.btn_image_problem);
        bzX();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = k.f(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.bsc);
        this.gHA = (ScrollView) findViewById(d.h.write_scrollview);
        this.gHA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.brV != null) {
                        k.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.brV);
                    }
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bp();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gHc = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gHd = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gGZ = (LinearLayout) findViewById(d.h.tool_view);
        this.gGZ.setContentDescription("..");
        this.gHa = (LinearLayout) findViewById(d.h.title_view);
        this.fSk = findViewById(d.h.interval_view);
        this.gHY = findViewById(d.h.hot_topic_fourm_view);
        this.gHZ = findViewById(d.h.hot_topic_divider);
        this.gIa = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gIb = (TextView) findViewById(d.h.change_one_tv);
        bma();
        if (this.gHK) {
            this.gHA.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bzR();
        } else {
            bzW();
        }
        Tq();
        if (this.gGW || this.gGX) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aip) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.brW = (LinearLayout) findViewById(d.h.post_content_container);
        this.brW.setDrawingCacheEnabled(false);
        this.brW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.brV.requestFocus();
                WriteActivity.this.aBt.Bp();
            }
        });
        this.aqQ.setOnFocusChangeListener(this.bsc);
        this.aqQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.blT();
                WriteActivity.this.bzo();
            }
        });
        this.gHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bAa();
        i(bAm());
        bAe();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gGW || this.gGX) {
                    if (this.gGY) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fSj.setVisibility(0);
                this.brV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.brV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fSj.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.brV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gHD.setVisibility(8);
                break;
            case 7:
                this.fSj.setVisibility(0);
                this.brV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bAf();
        bAk();
        bzQ();
        bAc();
        blZ();
        bAn();
        if (this.mData.getType() == 4 && this.fSp != null && this.gHe != null) {
            this.fSp.setVisibility(8);
            this.gHe.setVisibility(8);
        }
        bmb();
        ShowSoftKeyPad(this.mInputManager, this.fSj);
        bAb();
    }

    private void bzX() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bzY() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gGW && !this.gGX && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bAi() != null) {
                bAi().setText(d);
                bAi().setSelection(d.length());
            }
        }
    }

    private void bzZ() {
        this.gHr = null;
        this.gHt = -1;
        this.gHv = -1;
        z iZ = y.aid().iZ(1);
        if (iZ != null) {
            this.gHr = iZ.csN;
            this.gHt = getIntent().getIntExtra("category_id", -1);
            if (this.gHr != null && !this.gHr.isEmpty() && this.gHt >= 0) {
                this.gHs = new x();
                this.gHs.csJ = 0;
                this.gHs.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gHv = this.gHs.csJ;
                this.gHu = this.gHs.name;
                for (x xVar : this.gHr) {
                    if (xVar.csJ == this.gHt) {
                        this.gHv = xVar.csJ;
                        this.gHu = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bAa() {
        if (this.gHr != null && !this.gHr.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gHw = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gHw.setText(this.gHu);
            this.gHw.b(this.gHr, this.gHs, this.gHv);
            this.gHw.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.gHw.setText(asVar.name);
                        WriteActivity.this.mData.setCategoryTo(asVar.csJ);
                        WriteActivity.this.gHv = asVar.csJ;
                        WriteActivity.this.gHw.bzh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gHw.bzg();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                }
            });
        }
    }

    private void bAb() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gIm = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gIm.setTitle(d.l.no_disturb_start_time);
        this.gIm.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gIm);
        this.gIm.setButton(-2, getPageContext().getString(d.l.cancel), this.gIm);
        return this.gIm;
    }

    private void bAc() {
        this.gHm = (RelativeLayout) findViewById(d.h.addition_container);
        this.gHn = (TextView) findViewById(d.h.addition_create_time);
        this.gHo = (TextView) findViewById(d.h.addition_last_time);
        this.gHp = (TextView) findViewById(d.h.addition_last_content);
        if (this.gHl != null) {
            this.gHm.setVisibility(0);
            this.gHn.setText(getPageContext().getString(d.l.write_addition_create) + am.r(this.gHl.getCreateTime() * 1000));
            if (this.gHl.getAlreadyCount() == 0) {
                this.gHo.setVisibility(8);
            } else {
                this.gHo.setText(getPageContext().getString(d.l.write_addition_last) + am.r(this.gHl.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gHl.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gHp.setText(lastAdditionContent);
            } else {
                this.gHp.setVisibility(8);
            }
            bAh().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gHl.getAlreadyCount()), Integer.valueOf(this.gHl.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gHm.setVisibility(8);
    }

    private void blZ() {
        this.fSp = findViewById(d.h.post_prefix_layout);
        this.fSm = (TextView) findViewById(d.h.post_prefix);
        this.gHe = findViewById(d.h.prefix_divider);
        this.fSo = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fSp.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fRS = 1;
            this.fSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fSm.setVisibility(0);
                    WriteActivity.this.fSp.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fSn, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBt.Bp();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fSj);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.brV);
                }
            });
            this.fSo = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fSo.setVisibility(0);
                this.fSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fSm.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fSn, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBt.Bp();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                    }
                });
            }
            this.fSn = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fSn.a(this);
            this.fSn.setMaxHeight(k.f(getActivity(), d.f.ds510));
            this.fSn.setOutsideTouchable(true);
            this.fSn.setFocusable(true);
            this.fSn.setOnDismissListener(this);
            this.fSn.setBackgroundDrawable(aj.getDrawable(d.e.cp_bg_line_d));
            int color = aj.getColor(d.e.cp_cont_b);
            int color2 = aj.getColor(d.e.cp_cont_c);
            aj.j(this.fSm, d.e.cp_bg_line_d);
            aj.c(this.fSo, d.g.icon_frs_arrow_n);
            this.fSm.setTextColor(color);
            this.gFX.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gFX.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fSn.addView(cVar);
            }
            this.fSn.setCurrentIndex(0);
            this.fSm.setText(prefixs.get(1));
            uL(1);
            return;
        }
        this.fSp.setVisibility(8);
    }

    private void bAd() {
        if (this.gGW && this.mData != null) {
            this.gHc.setVisibility(0);
            this.gHd.setVisibility(0);
            this.gHb = new FeedBackModel(this);
            this.gHb.tk(this.mData.getForumName());
            this.gHb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gHc.setVisibility(8);
                        WriteActivity.this.gHd.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gHc.setVisibility(8);
                        WriteActivity.this.gHd.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gHc.a(feedBackModel.bzI(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bAe() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                    WriteActivity.this.aBt.Bp();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gGW) {
                            WriteActivity.this.bzp();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ak akVar = new ak("c12102");
                            akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(akVar);
                            if (WriteActivity.this.gHV.bxA()) {
                                WriteActivity.this.bAq();
                            } else {
                                WriteActivity.this.gHW = true;
                                WriteActivity.this.gHV.co(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAp());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bzp();
                    }
                    TiebaStatic.log(new ak("c12262").ad("obj_locate", WriteActivity.this.gDH));
                }
            }
        });
    }

    protected void bAf() {
        this.gHh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gHh.cM(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bAi().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bAh().getText().toString());
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
        this.gHh.b(getPageContext());
    }

    protected void bma() {
        this.gEX = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gEX.setIsRound(true);
        this.gEX.setDrawBorder(false);
        this.gEX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dG = o.dG(currentPortrait);
            this.gEX.setUrl(dG);
            this.gEX.c(dG, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gEX.setVisibility(0);
        }
        this.fSj = (EditText) findViewById(d.h.post_title);
        this.fSj.setOnClickListener(this.gIj);
        this.fSj.setOnFocusChangeListener(this.bsc);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fSj.setText(this.mData.getTitle());
                this.fSj.setSelection(this.mData.getTitle().length());
            } else if (this.gGY) {
                this.fSj.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fSj.addTextChangedListener(this.bse);
        if (!this.mData.getHaveDraft()) {
            bzY();
            this.gHU = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fSj.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fSj.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher baE() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            private int bsh;
            private EditText dIv = null;
            private TextView abu = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bmb();
                if (WriteActivity.this.gHK) {
                    this.bsh = this.dIv.getSelectionStart();
                    this.dIv.setSelection(this.bsh);
                    WriteActivity.this.b(this.abu, this.dIv);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gHK || !WriteActivity.this.gHL) {
                    if (WriteActivity.this.gHK) {
                        if (this.dIv != WriteActivity.this.gHB || this.abu != WriteActivity.this.gHH) {
                            this.dIv = WriteActivity.this.gHB;
                            this.abu = WriteActivity.this.gHH;
                        }
                    }
                } else if (this.dIv != WriteActivity.this.gHF || this.abu != WriteActivity.this.gHG) {
                    this.dIv = WriteActivity.this.gHF;
                    this.abu = WriteActivity.this.gHG;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gHK && this.gHL) {
            if (this.gHI != null) {
                this.gHF.removeTextChangedListener(this.gHI);
            }
            this.gHI = textWatcher;
        } else if (this.gHK) {
            if (this.gHJ != null) {
                this.gHB.removeTextChangedListener(this.gHJ);
            }
            this.gHJ = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gHB) {
            return 233L;
        }
        if (editText != this.gHF) {
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
                    textView.setTextColor(aj.getColor(d.e.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.e.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void Tq() {
        this.brV = (EditText) findViewById(d.h.post_content);
        this.brV.setDrawingCacheEnabled(false);
        this.brV.setOnClickListener(this.gIj);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Eu().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.brV.setText(Y);
            this.brV.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gHi) {
                if (this.gHj != null && this.gHj.length() > 0) {
                    this.brV.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gHj}));
                    this.brV.setSelection(this.brV.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.brV.setText(format);
                this.brV.setSelection(format.length());
            }
        }
        this.brV.setOnFocusChangeListener(this.bsc);
        this.brV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.brV.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.brV.addTextChangedListener(this.gIl);
        nr(true);
        if (this.mData.isUserFeedback()) {
            this.brV.setHint(d.l.write_input_content);
        } else {
            this.brV.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nr(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gHK) {
            bAh().setPadding(0, 0, 0, 0);
            bAh().setBackgroundDrawable(null);
            aj.k(bAh(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.elY) && this.gHl == null) {
                com.baidu.adp.lib.f.c.fK().a(this.elY, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass27) aVar, str, i);
                        if (aVar != null && aVar.kO() != null && aVar.kS() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kO(), aVar.kO().getNinePatchChunk(), aVar.kS(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bAh().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bAh(), true, WriteActivity.this.eRx);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAg() {
        int i = 5000;
        if (this.gHl != null) {
            i = 1000;
        }
        return bAh().getText() != null && bAh().getText().length() >= i;
    }

    private void fO(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gGU)) {
                this.gGU = "";
                bAh().requestFocus();
                if (bAh().getText() != null && bAh().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAh().getSelectionStart();
                    editable = bAh().getText();
                }
            } else if ("from_title".equals(this.gGU)) {
                this.gGU = "";
                bAi().requestFocus();
                if (bAi().getText() != null && bAi().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAi().getSelectionStart();
                    editable = bAi().getText();
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
    public void ns(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bAh().getText().getSpans(0, bAh().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gHk == null) {
                this.gHk = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gHk.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType ys = lVar.ys();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fK().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass29) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bAh().getSelectionStart(), aVar, ys);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bAh() != null && bAh().getText() != null) {
            Bitmap kO = aVar.kO();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kO);
            int width = kO.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kO.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bAh().getSelectionStart() - 1;
                if (bAh().getText().length() > 1 && selectionStart >= 0 && bAh().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bAh().getText().insert(bAh().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bAh().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bAh().getText().insert(bAh().getSelectionStart(), spannableString2);
            }
            Editable text = bAh().getText();
            if (text != null) {
                this.gIf.clear();
                this.gIf.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gIf);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bAh().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bAh().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bAh().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAh() {
        return this.gHK ? this.gHB : this.brV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAi() {
        return this.gHK ? this.gHF : this.fSj;
    }

    protected void bAj() {
        Editable text;
        if (bAh() != null && (text = bAh().getText()) != null) {
            int selectionStart = bAh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAh().onKeyDown(67, this.gHf);
            }
            bAh().onKeyDown(67, this.gHf);
            int selectionStart2 = bAh().getSelectionStart();
            if (text != null) {
                this.gIf.clear();
                this.gIf.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gIf);
                bAh().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gGW = true;
        }
    }

    private void bAk() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bAl() {
        try {
            if (this.gHh != null) {
                this.gHh.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLP.c(null);
        this.aLP.dd(d.l.sending);
        this.aLP.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLP.aH(false);
    }

    private Boolean bAm() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDp = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmb() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bAi() != null) {
                str = bAi().getText().toString();
            }
            if (bAh() != null) {
                str2 = bAh().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fRS == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dl(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dl(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dl(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gHK) {
                    dl(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dl(true);
                }
            }
            if (this.mData.getType() == 4) {
                dl(j(this.gHB) && i(this.gHF));
            } else if (this.mData.getType() == 5) {
                dl(j(this.gHB));
            } else if (!TextUtils.isEmpty(str2) || this.aDh != null) {
                dl(true);
            } else if (this.mData.getVideoInfo() != null) {
                dl(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                dl(true);
            } else {
                dl(false);
            }
        }
    }

    private void dl(boolean z) {
        if (z) {
            aj.b(this.mPost, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.e.cp_cont_d, 1);
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
        this.aDk = new NewWriteModel(this);
        this.aDk.b(this.aDB);
        registerListener(this.gIh);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.blT();
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
            this.gGW = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gGY = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gHi = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gHj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aDi = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gHl = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gHl != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gHq = bundle.getInt("mem_type", 0);
            this.aiO = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gIc = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gDH = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gGW = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gGY = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gHi = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gHj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gHl = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gHl != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gHq = intent.getIntExtra("mem_type", 0);
            this.aiO = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gIc = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gDH = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gGW);
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
        this.elY = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gGX = true;
        }
        bzZ();
        try {
            this.gHM = bAu();
        } catch (Throwable th) {
            this.gHM = null;
        }
    }

    private void bAn() {
        if (v.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gEX.setVisibility(8);
            this.gHY.setVisibility(0);
            this.gHZ.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fSj.setText(com.baidu.tbadk.plugins.a.gC(tl(this.mList.get(0).mTopicName)));
                this.fSj.setMovementMethod(com.baidu.tieba.view.b.bwG());
            }
            this.gIa.setText(this.mList.get(0).mForumName);
            this.fSj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gId.equals(charSequence.toString())) {
                        WriteActivity.this.gIe = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gC;
                    if (!WriteActivity.this.gId.equals(editable.toString()) && (gC = com.baidu.tbadk.plugins.a.gC(editable.toString())) != null) {
                        WriteActivity.this.gId = gC.toString();
                        WriteActivity.this.fSj.setText(gC);
                        if (WriteActivity.this.gIe <= WriteActivity.this.fSj.getText().length()) {
                            WriteActivity.this.fSj.setSelection(WriteActivity.this.gIe);
                        }
                    }
                }
            });
            this.gIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
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
            SpannableString gC = com.baidu.tbadk.plugins.a.gC(tl(hotTopicBussinessData.mTopicName));
            if (gC != null) {
                this.fSj.setText(gC);
            }
            this.gIa.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tl(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String tl;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!j.isEmpty(writeData.getTitle())) {
                    this.gHa.setVisibility(0);
                    this.gHa.requestFocus();
                    this.aBt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (j.isEmpty(bAi().getText().toString()) || this.gHU || ((this.gGW || this.gGX) && !j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            tl = this.mData.getTitle();
                        } else {
                            tl = tl(str);
                        }
                        SpannableString gC = com.baidu.tbadk.plugins.a.gC(tl);
                        if (gC != null) {
                            bAi().setText(gC);
                            bAi().setSelection(gC.length() > tl.length() ? tl.length() : gC.length());
                        }
                    } else {
                        SpannableString gC2 = com.baidu.tbadk.plugins.a.gC(this.mData.getTitle());
                        if (gC2 != null) {
                            bAi().setText(gC2);
                            bAi().setSelection(this.mData.getTitle().length() > gC2.length() ? gC2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bzY();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((j.isEmpty(bAh().getText().toString()) || this.gGW || this.gGX) && !j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Eu().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gIi);
                    bAh().setText(a2);
                    bAh().setSelection(a2.length());
                    if (this.gHK) {
                        b(this.gHH, this.gHB);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bAt();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DI();
                    }
                    nt(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bAo();
                }
                bmb();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gHr != null) {
                    this.gHv = this.gHs.csJ;
                    this.gHu = this.gHs.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gHr.size()) {
                            break;
                        }
                        x xVar = this.gHr.get(i);
                        if (categoryTo != xVar.csJ) {
                            i++;
                        } else {
                            this.gHv = categoryTo;
                            this.gHu = xVar.name;
                            this.mData.setCategoryTo(this.gHv);
                            break;
                        }
                    }
                    if (this.gHw != null) {
                        this.gHw.setText(this.gHu);
                        this.gHw.b(this.gHr, this.gHs, this.gHv);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aBt.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.aBt.Bp();
                return;
            }
            return;
        }
        bAo();
        bzY();
    }

    private void bAo() {
        if ((!this.gHK || this.gHz != null) && this.gHy != null) {
            this.gHz.c(this.writeImagesInfo);
            aIR();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gHi);
        if (this.gGW) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDi);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gHl);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gHq);
        bundle.putString("from", this.aiO);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gDH);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bAh().getEditableText().toString();
        if (obj != null) {
            bAh().setText(TbFaceManager.Eu().a(getPageContext().getPageActivity(), obj, this.gIi));
            bAh().setSelection(bAh().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAp() {
        return (bAh() == null || bAh().getText() == null) ? "" : bAh().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bAi() == null || bAi().getText() == null) {
            return "";
        }
        String obj = bAi().getText().toString();
        if (this.mPrefixData != null && v.u(this.mPrefixData.getPrefixs()) > 0 && this.fRS != 0 && this.mData.getType() != 4 && this.fSm != null && this.fSm.getText() != null) {
            obj = this.fSm.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzp() {
        blT();
        this.mData.setContent(bAp());
        this.mData.setTitle(getThreadTitle());
        if (this.gGW || this.gGX) {
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
                if (com.baidu.adp.lib.util.i.hi()) {
                    sb.append(com.baidu.adp.lib.util.i.hq());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gHt >= 0) {
            this.mData.setCategoryFrom(this.gHt);
        }
        if (this.gHv >= 0) {
            this.mData.setCategoryTo(this.gHv);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDj != null && this.aDj.UC());
        this.aDk.mM(this.writeImagesInfo.size() > 0);
        if (!v.v(this.mList) && this.gHX != null && this.gHX.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gHX.mForumId));
            this.mData.setForumName(this.gHX.mForumName);
        }
        this.aDk.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aDh != null) {
            if (this.aDh.getId() != null) {
                this.aDk.getWriteData().setVoice(this.aDh.getId());
                this.aDk.getWriteData().setVoiceDuringTime(this.aDh.duration);
            } else {
                this.aDk.getWriteData().setVoice(null);
                this.aDk.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDk.getWriteData().setVoice(null);
            this.aDk.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDk.btF()) {
            showToast(d.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hi()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aDk.startPostWrite();
        }
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.gHl != null) {
                i2 = this.gHl.getTotalCount();
                i = this.gHl.getAlreadyCount() + 1;
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
                if (this.aBt != null && !this.aBt.CY()) {
                    bAh().requestFocus();
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
                            bAh().getText().insert(bAh().getSelectionStart(), sb.toString());
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
                                bcc();
                            } else {
                                ah(intent);
                            }
                        } else if (intExtra == 1) {
                            Y(intent);
                        } else {
                            ag(intent);
                            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gHK) {
                        A(intent);
                        bmb();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bmb();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.b.P(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gGV) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gGV = false;
                            }
                            sb2.append(stringExtra);
                            fO(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.v(this.mList)) {
                    if (!v.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gHX = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gHX);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gHV.ae(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.bsb = this.gHV.bxz();
                        this.aBt.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gHW) {
                        bAq();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aBt != null && !this.aBt.CY()) {
                this.brV.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DD();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bAs();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDi = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aDi);
                    return;
                case 12012:
                    bAs();
                    return;
                case 25004:
                    if ("from_title".equals(this.gGU)) {
                        bAi().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gGU)) {
                        bAh().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gHV.bxy());
        this.mData.setCallFrom(this.gDH);
        this.mData.setRecommendExt(this.gHV.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bzp();
    }

    private void bAr() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bAs() {
        if (this.gHK) {
            this.gHz.c(this.writeImagesInfo);
            aIR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIR() {
        this.gHz.notifyDataSetChanged();
        this.gHy.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gHz.notifyDataSetChanged();
                WriteActivity.this.gHy.invalidateViews();
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
        bmb();
    }

    private void ag(Intent intent) {
        if (this.gHK) {
            aj(intent);
            bAs();
        } else {
            ak(intent);
        }
        bmb();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bAs();
            nt(true);
        }
    }

    private void ah(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bcc() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void Y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.ftS.parseJson(stringExtra);
            this.ftS.updateQuality();
            if (this.ftS.getChosedFiles() != null && this.ftS.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ftS.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.ftS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bAi());
        HidenSoftKeyPad(this.mInputManager, bAh());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ak(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aDi = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(getPageContext().getPageActivity(), k.ae(getPageContext().getPageActivity())), k.dip2px(getPageContext().getPageActivity(), k.af(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDi, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bAt();
            DI();
        }
        nt(true);
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
                bAt();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DI();
                }
            }
            nt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAt() {
        if (this.aBt.eE(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.u(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDi));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nt(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cpV == null) {
            this.cpV = VoiceManager.instance();
        }
        return this.cpV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahn() {
        this.cpV = getVoiceManager();
        this.cpV.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gHl == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDs = i;
        if (this.aBt != null) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aBt.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DI() {
        if (!this.gHK) {
            if (this.aBt != null) {
                this.aBt.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBt.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gHx != null) {
                this.gHx.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gHx.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (this.aBt != null) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uL(int i) {
        if (i < this.gFX.size()) {
            for (int i2 = 0; i2 < this.gFX.size(); i2++) {
                this.gFX.get(i2).nj(false);
            }
            this.gFX.get(i).nj(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sN(int i) {
        this.fRS = i;
        this.fSn.setCurrentIndex(i);
        uL(i);
        this.fSm.setText(this.mPrefixData.getPrefixs().get(i));
        bmb();
        g.a(this.fSn, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fSp.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            k.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dy();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aK(getApplicationContext())) {
                ai.b(getPageContext(), this.aDi);
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
        if (this.gHS && System.currentTimeMillis() - this.gHT < 800) {
            k.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gHS = false;
        }
        if (this.gIg != null && !z) {
            this.gIg.aTp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm(String str) {
        if (!j.isEmpty(str) && this.gHP != null) {
            tn(str);
            this.gHP.dismiss();
        }
    }

    private void cc(Context context) {
        gHR = k.af(context);
    }

    private void tn(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gHS = true;
        bAt();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DI();
        }
        nt(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3946=4] */
    private static Bitmap b(String str, float f) {
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

    private File bAu() {
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

    private void bAv() {
        if (this.gHM != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cc(getActivity());
            this.gHO = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gHM != null) {
                        WriteActivity.this.tm(WriteActivity.this.gHM.getAbsolutePath());
                    }
                }
            });
            this.gHN = (TbImageView) this.gHO.findViewById(d.h.rec_img_view);
            this.gHQ = (LinearLayout) this.gHO.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gHM.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gHM.getAbsolutePath());
                Bitmap b = b(this.gHM.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (b != null) {
                    this.gHN.setImageBitmap(b);
                    this.gHN.setDrawBorder(true);
                    this.gHN.setBorderWidth(2);
                    this.gHN.setBorderColor(aj.getColor(d.e.common_color_10264));
                    this.gHP = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gHP.setCanceledOnTouchOutside(true);
                    this.gHP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gHS) {
                                k.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gHT = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gHP.setContentView(this.gHO);
                    this.gHP.show();
                    Window window = this.gHP.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gHR / 18) + getResources().getDimensionPixelSize(d.f.ds12);
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
            this.gGV = false;
            this.gGU = "";
            if ("from_content".equals(str)) {
                this.gGU = "from_content";
            } else if ("from_title".equals(str)) {
                this.gGU = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                ns(false);
            }
        }
    }

    public void Br() {
        if (this.gGW || !v.v(this.mList)) {
            this.gHa.setVisibility(0);
            this.gHa.requestFocus();
            this.aBt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gHa.setVisibility(8);
    }
}
