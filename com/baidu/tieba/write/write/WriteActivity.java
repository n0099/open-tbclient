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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0023a, VoiceManager.c, r.a, d.a {
    private static int gGY = 0;
    private i aBw;
    private VoiceData.VoiceModel aDk;
    private String aDl;
    private LocationModel aDm;
    private NewWriteModel aDn;
    private String aiP;
    private VoiceManager cpd;
    private int fQZ;
    private TextView fRt;
    private com.baidu.tieba.write.d fRu;
    private ImageView fRv;
    private View fRw;
    private int gGA;
    private String gGB;
    private int gGC;
    private PostCategoryView gGD;
    private NewFrameMultiImgToolView gGE;
    private LinearLayout gGg;
    private LinearLayout gGh;
    private View gGk;
    private View gGl;
    private Toast gGr;
    private AdditionData gGs;
    private RelativeLayout gGt;
    private TextView gGu;
    private TextView gGv;
    private TextView gGw;
    List<x> gGy;
    x gGz;
    private com.baidu.tieba.write.a gHc;
    private HotTopicBussinessData gHe;
    private View gHf;
    private View gHg;
    private TextView gHh;
    private TextView gHi;
    private com.baidu.tieba.write.b.b gHn;
    private com.baidu.tieba.view.a gHt;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gGb = "";
    private boolean gGc = false;
    private WriteData mData = null;
    private boolean gGd = false;
    private boolean gGe = false;
    private boolean gGf = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fRq = null;
    private HeadImageView gEe = null;
    private View fRr = null;
    private LinearLayout brC = null;
    private EditText brB = null;
    private FeedBackModel gGi = null;
    private FeedBackTopListView gGj = null;
    private ArrayList<com.baidu.tieba.write.c> gFe = new ArrayList<>();
    private String ele = null;
    private final KeyEvent gGm = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqT = null;
    private TextView gGn = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gGo = null;
    private final Handler mHandler = new Handler();
    private boolean gGp = false;
    private String gGq = null;
    private RelativeLayout mParent = null;
    private String aDs = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDv = 0;
    private int gGx = 0;
    private WriteImagesInfo fsZ = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gGF = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gGG = null;
    private ScrollView gGH = null;
    private EditText gGI = null;
    private View gGJ = null;
    private View gGK = null;
    private View gGL = null;
    private EditText gGM = null;
    private TextView gGN = null;
    private TextView gGO = null;
    private TextWatcher gGP = null;
    private TextWatcher gGQ = null;
    private boolean gGR = false;
    private boolean gGS = false;
    private com.baidu.tbadk.core.view.a aLS = null;
    private File gGT = null;
    private TbImageView gGU = null;
    private View gGV = null;
    private Dialog gGW = null;
    private LinearLayout gGX = null;
    private boolean gGZ = false;
    private long gHa = -1000;
    private boolean gHb = false;
    private String gCO = "2";
    private boolean gHd = false;
    private String gHj = "";
    private String gHk = "";
    private int gHl = 0;
    private SpannableStringBuilder gHm = new SpannableStringBuilder();
    private final HttpMessageListener gHo = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ele)) {
                    WriteActivity.this.ele = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nq(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ele)) {
                    WriteActivity.this.ele = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ele);
                    WriteActivity.this.nq(true);
                }
            }
        }
    };
    private TbFaceManager.a gHp = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final NewWriteModel.d aDE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ahc();
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
                        if (!v.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gHj)) {
                            TiebaStatic.log(new ak("c11731").ad("obj_id", WriteActivity.this.gHj));
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
                        if (WriteActivity.this.gGf) {
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
    private final LocationModel.a aDC = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
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
            if (aVar != null && !StringUtils.isNull(aVar.bsQ())) {
                WriteActivity.this.a(2, true, aVar.bsQ());
            } else {
                fY(null);
            }
        }
    };
    private final CustomMessageListener gkt = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDm.mJ(false);
                    WriteActivity.this.aDm.cl(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDm.mJ(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private final View.OnClickListener gHq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bzE = WriteActivity.this.bzE();
            if (bzE >= 0 && bzE < WriteActivity.this.brB.getText().length()) {
                WriteActivity.this.brB.setSelection(bzE);
            }
        }
    };
    private boolean gHr = true;
    private final View.OnFocusChangeListener brI = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fRq || view == WriteActivity.this.aqT || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gHr = true;
                    WriteActivity.this.bzF();
                    if (WriteActivity.this.aBw != null) {
                        WriteActivity.this.aBw.Bp();
                    }
                    k.b(WriteActivity.this.getActivity(), WriteActivity.this.fRq);
                } else if (view == WriteActivity.this.fRq) {
                    WriteActivity.this.fRt.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.brB && z) {
                WriteActivity.this.gHr = false;
                WriteActivity.this.bzF();
                WriteActivity.this.aBw.Bp();
                k.b(WriteActivity.this.getActivity(), WriteActivity.this.brB);
            }
        }
    };
    private TextWatcher brK = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.blQ();
        }
    };
    private TextWatcher gHs = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.blQ();
        }
    };
    private final a.InterfaceC0122a eQD = new a.InterfaceC0122a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0122a
        public void la() {
            WriteActivity.this.ele = null;
            WriteActivity.this.nq(false);
            WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aiP)) {
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
        } else if (this.aDm.bsY()) {
            Dx();
        } else {
            this.aDm.mJ(false);
            a(1, true, (String) null);
            this.aDm.bsW();
        }
    }

    private void Dz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hi()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aDm.Uw();
                } else {
                    WriteActivity.this.aDC.DM();
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
    public int bzE() {
        int selectionEnd = bzW().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bzW().getText().getSpans(0, bzW().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bzW().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bzW().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzF() {
        if (this.aBw != null) {
            this.aBw.setBarLauncherEnabled(!this.gHr);
            this.aBw.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gGR) {
            this.fRq.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gGL.setVisibility(8);
            } else {
                this.gGL.setVisibility(0);
            }
            b(this.gGO, this.gGI);
            b(this.gGN, this.gGM);
            blQ();
        }
        if (this.gGd) {
            this.fRq.requestFocus();
            ShowSoftKeyPadDelay(this.fRq);
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
        bzS();
        this.aDm = new LocationModel(this);
        this.aDm.a(this.aDC);
        registerListener(this.gkt);
        initEditor();
        bAk();
        if (this.gGR) {
            this.gGG.setEditorTools(this.aBw);
        } else {
            this.brB.requestFocus();
        }
        Br();
        DI();
        this.gHc = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBw = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aBw.setBarMaxLauCount(6);
        } else {
            this.aBw.setBarMaxLauCount(5);
        }
        this.aBw.setMoreButtonAtEnd(true);
        this.aBw.setBarLauncherType(1);
        this.aBw.bD(true);
        this.aBw.setMoreLauncherIcon(d.g.write_more);
        this.aBw.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bzI();
                break;
            default:
                bzJ();
                break;
        }
        this.aBw.CW();
        if (this.gGg != null) {
            this.gGg.addView(this.aBw);
        }
        bzK();
        this.aBw.lK();
        l eC = this.aBw.eC(6);
        if (eC != null && !TextUtils.isEmpty(this.aDs)) {
            ((View) eC).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDs);
                }
            });
        }
        if (!this.gGR) {
            this.aBw.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBw.Bp();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBw.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.brH = this.mData.getForumName() + getResources().getString(d.l.forum);
        }
        this.aBw.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gGE != null) {
            this.gGE.setEditorTools(this.aBw);
            this.gGE.byP();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bzG() {
        this.gGJ = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gGL = this.gGJ.findViewById(d.h.live_post_title_container);
        this.gGI = (EditText) this.gGJ.findViewById(d.h.live_post_content);
        this.gGF = (GridView) this.gGJ.findViewById(d.h.photoLiveGridView);
        this.gGM = (EditText) this.gGJ.findViewById(d.h.live_post_title);
        this.gGN = (TextView) this.gGJ.findViewById(d.h.titleOverPlusNumber);
        this.gGO = (TextView) this.gGJ.findViewById(d.h.contentOverPlusNumber);
        this.gGK = this.gGJ.findViewById(d.h.live_interval_view);
        this.gGN.setText(String.valueOf(20));
        this.gGO.setText(String.valueOf(233));
        this.gGJ.setVisibility(0);
        this.gGN.setVisibility(0);
        this.gGO.setVisibility(0);
        this.gGM.setHint(d.l.tips_title_limit_new);
        this.gGM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gGS = true;
                    WriteActivity.this.gHr = true;
                    WriteActivity.this.bzF();
                    if (WriteActivity.this.aBw != null) {
                        WriteActivity.this.aBw.Bp();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gGI.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gGI.setHint(d.l.live_write_input_content_update);
        }
        this.gGI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gGS = false;
                    WriteActivity.this.gHr = false;
                    WriteActivity.this.bzF();
                    if (WriteActivity.this.aBw != null) {
                        WriteActivity.this.aBw.Bp();
                    }
                }
            }
        });
        this.gGI.requestFocus();
        this.gGI.addTextChangedListener(bat());
        this.gGM.requestFocus();
        this.gGM.addTextChangedListener(bat());
        this.gGM.setOnClickListener(this.gHq);
        this.gGI.setOnClickListener(this.gHq);
        this.gGG = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gGF);
        this.gGG.uz(6);
        this.gGF.setAdapter((ListAdapter) this.gGG);
        View findViewById = this.gGJ.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void byU() {
                WriteActivity.this.aIG();
            }
        });
        bzH();
    }

    private void bzH() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gGM.setText(this.mData.getTitle());
                this.gGM.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gGR) {
            bAg();
        }
        if (this.aBw.CY()) {
            this.aBw.Bp();
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

    private void bzI() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBw.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aBw.eE(5);
        if (eE != null) {
            eE.aCe = 2;
            eE.aCc = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aCc = d.g.write_at;
        this.aBw.b(aVar);
        this.aBw.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bzJ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aCc = d.g.write_picture;
            this.aBw.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aBw.b(aVar);
        aVar.aCc = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCe = 6;
            rVar4.aCc = d.g.write_privilege;
            this.aBw.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aCc = d.g.write_at;
        this.aBw.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCg = true;
            rVar3.aCe = 9;
            rVar3.aCc = 0;
            this.aBw.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCg = true;
            rVar2.aCe = 10;
            rVar2.aCc = 0;
            this.aBw.b(rVar2);
        }
        Boolean bAb = bAb();
        if (!this.gGd && bAb != null && bAb.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.btt() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCe = 2;
            rVar.aCc = d.g.write_recorder;
            this.aBw.b(rVar);
        }
        if (this.gGs == null) {
            if (this.gHn == null) {
                this.gHn = new com.baidu.tieba.write.b.b(getActivity(), this.gCO);
            }
            this.aBw.b(this.gHn);
        }
        this.aBw.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aBw.eE(5);
        if (eE != null) {
            eE.aCe = 1;
            eE.aCc = d.g.write_emotion;
        }
    }

    private void bzK() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bzV()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.d(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bzV()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bzY();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aDk = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.blQ();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aDk = null;
                        WriteActivity.this.blQ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bAi();
                        WriteActivity.this.blQ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gGs == null) {
                            WriteActivity.this.DA();
                            return;
                        }
                        switch (WriteActivity.this.aDv) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aI(pageActivity)) {
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
                            WriteActivity.this.ele = null;
                        } else {
                            WriteActivity.this.ele = (String) aVar.data;
                        }
                        WriteActivity.this.nq(false);
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
                            WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBw.CY()) {
                                        WriteActivity.this.aBw.Bp();
                                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.blQ();
                        if (WriteActivity.this.brB != null) {
                            WriteActivity.this.brB.requestFocus();
                        }
                        WriteActivity.this.aBw.Bp();
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.brB);
                    } else if (aVar.code == 40) {
                        if (((aVar.data instanceof String) || aVar.data == null) && WriteActivity.this.mData != null) {
                            WriteActivity.this.mData.setGraffitiFileName((String) aVar.data);
                            WriteActivity.this.blQ();
                        }
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gGc = true;
                        WriteActivity.this.nr(true);
                        if (WriteActivity.this.bzX().isFocused()) {
                            WriteActivity.this.gGb = "from_title";
                        } else if (WriteActivity.this.bzW().isFocused()) {
                            WriteActivity.this.gGb = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gGh.setVisibility(0);
                        WriteActivity.this.gGh.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gHc.co(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAe());
                        TiebaStatic.log(new ak("c12258").ad("obj_locate", WriteActivity.this.gCO));
                    }
                }
            }
        };
        this.aBw.a(16, bVar);
        this.aBw.a(14, bVar);
        this.aBw.a(24, bVar);
        this.aBw.a(3, bVar);
        this.aBw.a(10, bVar);
        this.aBw.a(11, bVar);
        this.aBw.a(12, bVar);
        this.aBw.a(13, bVar);
        this.aBw.a(15, bVar);
        this.aBw.a(18, bVar);
        this.aBw.a(25, bVar);
        this.aBw.a(27, bVar);
        this.aBw.a(29, bVar);
        this.aBw.a(40, bVar);
        this.aBw.a(43, bVar);
        this.aBw.a(45, bVar);
        this.aBw.a(48, bVar);
        this.aBw.a(46, bVar);
        this.aBw.a(49, bVar);
        this.aBw.a(47, bVar);
        this.aBw.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        if (this.aDm.Us()) {
            if (this.aDm.bsY()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bsU().getLocationData().bsQ());
                return;
            }
            a(1, true, (String) null);
            this.aDm.bsW();
            return;
        }
        a(0, true, (String) null);
    }

    protected void blI() {
        if (this.aDn != null) {
            this.aDn.cancelLoadData();
        }
        if (this.gGi != null) {
            this.gGi.cancelLoadData();
        }
        if (this.aDm != null) {
            this.aDm.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        blI();
        bAa();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gHc != null) {
            this.gHc.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzd() {
        if (this.mData != null && this.mData.getType() == 2 && this.gGp) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bzX().getText().toString());
            this.mData.setContent(bzW().getText().toString());
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
            if (this.fRu != null && this.fRu.isShowing()) {
                g.a(this.fRu, getPageContext().getPageActivity());
                return true;
            } else if (this.aBw.CY()) {
                this.aBw.Bp();
                return true;
            } else {
                blI();
                bzd();
                return true;
            }
        }
        if (i == 67 && (text = bzW().getText()) != null) {
            int selectionStart = bzW().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bzW().onKeyDown(67, this.gGm);
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
        getLayoutMode().t(this.gGX);
        if (this.gGU != null && i == 1) {
            this.gGU.setBorderColor(aj.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.e.cp_link_tip_a, 1);
        bzF();
        aj.k(this.gGJ, d.e.cp_bg_line_d);
        aj.k(this.fRr, d.e.cp_bg_line_c);
        aj.k(this.gGK, d.e.cp_bg_line_c);
        aj.k(bzX(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.ele)) {
            aj.k(bzW(), d.e.cp_bg_line_d);
        }
        blQ();
        this.aBw.onChangeSkinType(i);
        if (this.gGD != null) {
            this.gGD.xc();
        }
        aj.i(this.mName, d.e.cp_cont_b);
        this.fRq.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.brB.setHintTextColor(aj.getColor(d.e.cp_cont_e));
    }

    private void bzL() {
        this.gGE = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gGE.initView();
        this.gGE.setVisibility(0);
        this.gGE.setAsyncLocalImageLoader(bVar);
        if (this.gGE.getDragLayer() != null && this.gGE.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gGE.getDragLayer());
            bVar2.a((e) this.gGE.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gGE.getDragHorizonScrollView());
            this.gGE.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gGE.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gGE.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gGE.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gGE));
            }
            this.gGE.getDragHorizonScrollView().setOnSwapDataListener(this.gGE);
            this.gGE.getDragHorizonScrollView().setMaxItemNum(10);
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
        this.aLS = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gGR = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aqT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqT.getLayoutParams();
            layoutParams.leftMargin = k.g(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqT != null && (this.aqT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqT.getLayoutParams();
            layoutParams2.width = -2;
            this.aqT.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.e.cp_cont_b);
        this.gGn = (TextView) findViewById(d.h.btn_image_problem);
        bzM();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.brI);
        this.gGH = (ScrollView) findViewById(d.h.write_scrollview);
        this.gGH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.brB != null) {
                        k.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.brB);
                    }
                    if (WriteActivity.this.aBw != null) {
                        WriteActivity.this.aBw.Bp();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gGj = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gGk = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gGg = (LinearLayout) findViewById(d.h.tool_view);
        this.gGg.setContentDescription("..");
        this.gGh = (LinearLayout) findViewById(d.h.title_view);
        this.fRr = findViewById(d.h.interval_view);
        this.gHf = findViewById(d.h.hot_topic_fourm_view);
        this.gHg = findViewById(d.h.hot_topic_divider);
        this.gHh = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gHi = (TextView) findViewById(d.h.change_one_tv);
        blP();
        if (this.gGR) {
            this.gGH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bzG();
        } else {
            bzL();
        }
        Tj();
        if (this.gGd || this.gGe) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiq) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.brC = (LinearLayout) findViewById(d.h.post_content_container);
        this.brC.setDrawingCacheEnabled(false);
        this.brC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.brB.requestFocus();
                WriteActivity.this.aBw.Bp();
            }
        });
        this.aqT.setOnFocusChangeListener(this.brI);
        this.aqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.blI();
                WriteActivity.this.bzd();
            }
        });
        this.gGn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bzP();
        i(bAb());
        bzT();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gGd || this.gGe) {
                    if (this.gGf) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fRq.setVisibility(0);
                this.brB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.brB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fRq.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.brB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gGK.setVisibility(8);
                break;
            case 7:
                this.fRq.setVisibility(0);
                this.brB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bzU();
        bzZ();
        bzF();
        bzR();
        blO();
        bAc();
        if (this.mData.getType() == 4 && this.fRw != null && this.gGl != null) {
            this.fRw.setVisibility(8);
            this.gGl.setVisibility(8);
        }
        blQ();
        ShowSoftKeyPad(this.mInputManager, this.fRq);
        bzQ();
    }

    private void bzM() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bzN() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gGd && !this.gGe && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bzX() != null) {
                bzX().setText(d);
                bzX().setSelection(d.length());
            }
        }
    }

    private void bzO() {
        this.gGy = null;
        this.gGA = -1;
        this.gGC = -1;
        z iX = y.ahS().iX(1);
        if (iX != null) {
            this.gGy = iX.crV;
            this.gGA = getIntent().getIntExtra("category_id", -1);
            if (this.gGy != null && !this.gGy.isEmpty() && this.gGA >= 0) {
                this.gGz = new x();
                this.gGz.crR = 0;
                this.gGz.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gGC = this.gGz.crR;
                this.gGB = this.gGz.name;
                for (x xVar : this.gGy) {
                    if (xVar.crR == this.gGA) {
                        this.gGC = xVar.crR;
                        this.gGB = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bzP() {
        if (this.gGy != null && !this.gGy.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gGD = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gGD.setText(this.gGB);
            this.gGD.b(this.gGy, this.gGz, this.gGC);
            this.gGD.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.gGD.setText(asVar.name);
                        WriteActivity.this.mData.setCategoryTo(asVar.crR);
                        WriteActivity.this.gGC = asVar.crR;
                        WriteActivity.this.gGD.byW();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gGD.byV();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzX());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzW());
                }
            });
        }
    }

    private void bzQ() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gHt = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gHt.setTitle(d.l.no_disturb_start_time);
        this.gHt.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gHt);
        this.gHt.setButton(-2, getPageContext().getString(d.l.cancel), this.gHt);
        return this.gHt;
    }

    private void bzR() {
        this.gGt = (RelativeLayout) findViewById(d.h.addition_container);
        this.gGu = (TextView) findViewById(d.h.addition_create_time);
        this.gGv = (TextView) findViewById(d.h.addition_last_time);
        this.gGw = (TextView) findViewById(d.h.addition_last_content);
        if (this.gGs != null) {
            this.gGt.setVisibility(0);
            this.gGu.setText(getPageContext().getString(d.l.write_addition_create) + am.r(this.gGs.getCreateTime() * 1000));
            if (this.gGs.getAlreadyCount() == 0) {
                this.gGv.setVisibility(8);
            } else {
                this.gGv.setText(getPageContext().getString(d.l.write_addition_last) + am.r(this.gGs.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gGs.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gGw.setText(lastAdditionContent);
            } else {
                this.gGw.setVisibility(8);
            }
            bzW().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gGs.getAlreadyCount()), Integer.valueOf(this.gGs.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gGt.setVisibility(8);
    }

    private void blO() {
        this.fRw = findViewById(d.h.post_prefix_layout);
        this.fRt = (TextView) findViewById(d.h.post_prefix);
        this.gGl = findViewById(d.h.prefix_divider);
        this.fRv = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fRw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fQZ = 1;
            this.fRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fRt.setVisibility(0);
                    WriteActivity.this.fRw.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fRu, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBw.Bp();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fRq);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.brB);
                }
            });
            this.fRv = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fRv.setVisibility(0);
                this.fRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fRt.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fRu, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBw.Bp();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzX());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzW());
                    }
                });
            }
            this.fRu = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fRu.a(this);
            this.fRu.setMaxHeight(k.g(getActivity(), d.f.ds510));
            this.fRu.setOutsideTouchable(true);
            this.fRu.setFocusable(true);
            this.fRu.setOnDismissListener(this);
            this.fRu.setBackgroundDrawable(aj.getDrawable(d.e.cp_bg_line_d));
            int color = aj.getColor(d.e.cp_cont_b);
            int color2 = aj.getColor(d.e.cp_cont_c);
            aj.j(this.fRt, d.e.cp_bg_line_d);
            aj.c(this.fRv, d.g.icon_frs_arrow_n);
            this.fRt.setTextColor(color);
            this.gFe.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gFe.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fRu.addView(cVar);
            }
            this.fRu.setCurrentIndex(0);
            this.fRt.setText(prefixs.get(1));
            uJ(1);
            return;
        }
        this.fRw.setVisibility(8);
    }

    private void bzS() {
        if (this.gGd && this.mData != null) {
            this.gGj.setVisibility(0);
            this.gGk.setVisibility(0);
            this.gGi = new FeedBackModel(this);
            this.gGi.ti(this.mData.getForumName());
            this.gGi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gGj.setVisibility(8);
                        WriteActivity.this.gGk.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gGj.setVisibility(8);
                        WriteActivity.this.gGk.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gGj.a(feedBackModel.bzx(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bzT() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzX());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzW());
                    WriteActivity.this.aBw.Bp();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gGd) {
                            WriteActivity.this.bze();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ak akVar = new ak("c12102");
                            akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(akVar);
                            if (WriteActivity.this.gHc.bxp()) {
                                WriteActivity.this.bAf();
                            } else {
                                WriteActivity.this.gHd = true;
                                WriteActivity.this.gHc.co(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAe());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bze();
                    }
                    TiebaStatic.log(new ak("c12262").ad("obj_locate", WriteActivity.this.gCO));
                }
            }
        });
    }

    protected void bzU() {
        this.gGo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gGo.cM(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bzX().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bzW().getText().toString());
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
        this.gGo.b(getPageContext());
    }

    protected void blP() {
        this.gEe = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gEe.setIsRound(true);
        this.gEe.setDrawBorder(false);
        this.gEe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dG = o.dG(currentPortrait);
            this.gEe.setUrl(dG);
            this.gEe.c(dG, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gEe.setVisibility(0);
        }
        this.fRq = (EditText) findViewById(d.h.post_title);
        this.fRq.setOnClickListener(this.gHq);
        this.fRq.setOnFocusChangeListener(this.brI);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fRq.setText(this.mData.getTitle());
                this.fRq.setSelection(this.mData.getTitle().length());
            } else if (this.gGf) {
                this.fRq.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fRq.addTextChangedListener(this.brK);
        if (!this.mData.getHaveDraft()) {
            bzN();
            this.gHb = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fRq.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fRq.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher bat() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            private int brN;
            private EditText dHA = null;
            private TextView abu = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.blQ();
                if (WriteActivity.this.gGR) {
                    this.brN = this.dHA.getSelectionStart();
                    this.dHA.setSelection(this.brN);
                    WriteActivity.this.b(this.abu, this.dHA);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gGR || !WriteActivity.this.gGS) {
                    if (WriteActivity.this.gGR) {
                        if (this.dHA != WriteActivity.this.gGI || this.abu != WriteActivity.this.gGO) {
                            this.dHA = WriteActivity.this.gGI;
                            this.abu = WriteActivity.this.gGO;
                        }
                    }
                } else if (this.dHA != WriteActivity.this.gGM || this.abu != WriteActivity.this.gGN) {
                    this.dHA = WriteActivity.this.gGM;
                    this.abu = WriteActivity.this.gGN;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gGR && this.gGS) {
            if (this.gGP != null) {
                this.gGM.removeTextChangedListener(this.gGP);
            }
            this.gGP = textWatcher;
        } else if (this.gGR) {
            if (this.gGQ != null) {
                this.gGI.removeTextChangedListener(this.gGQ);
            }
            this.gGQ = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gGI) {
            return 233L;
        }
        if (editText != this.gGM) {
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

    protected void Tj() {
        this.brB = (EditText) findViewById(d.h.post_content);
        this.brB.setDrawingCacheEnabled(false);
        this.brB.setOnClickListener(this.gHq);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Eu().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.brB.setText(Y);
            this.brB.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gGp) {
                if (this.gGq != null && this.gGq.length() > 0) {
                    this.brB.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gGq}));
                    this.brB.setSelection(this.brB.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.brB.setText(format);
                this.brB.setSelection(format.length());
            }
        }
        this.brB.setOnFocusChangeListener(this.brI);
        this.brB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.brB.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.brB.addTextChangedListener(this.gHs);
        nq(true);
        if (this.mData.isUserFeedback()) {
            this.brB.setHint(d.l.write_input_content);
        } else {
            this.brB.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nq(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gGR) {
            bzW().setPadding(0, 0, 0, 0);
            bzW().setBackgroundDrawable(null);
            aj.k(bzW(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ele) && this.gGs == null) {
                com.baidu.adp.lib.f.c.fK().a(this.ele, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.27
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
                            WriteActivity.this.bzW().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bzW(), true, WriteActivity.this.eQD);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzV() {
        int i = 5000;
        if (this.gGs != null) {
            i = 1000;
        }
        return bzW().getText() != null && bzW().getText().length() >= i;
    }

    private void fO(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gGb)) {
                this.gGb = "";
                bzW().requestFocus();
                if (bzW().getText() != null && bzW().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bzW().getSelectionStart();
                    editable = bzW().getText();
                }
            } else if ("from_title".equals(this.gGb)) {
                this.gGb = "";
                bzX().requestFocus();
                if (bzX().getText() != null && bzX().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bzX().getSelectionStart();
                    editable = bzX().getText();
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
    public void nr(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bzW().getText().getSpans(0, bzW().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gGr == null) {
                this.gGr = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gGr.show();
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
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bzW().getSelectionStart(), aVar, ys);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bzW() != null && bzW().getText() != null) {
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
                int selectionStart = bzW().getSelectionStart() - 1;
                if (bzW().getText().length() > 1 && selectionStart >= 0 && bzW().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bzW().getText().insert(bzW().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bzW().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bzW().getText().insert(bzW().getSelectionStart(), spannableString2);
            }
            Editable text = bzW().getText();
            if (text != null) {
                this.gHm.clear();
                this.gHm.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gHm);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bzW().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bzW().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bzW().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bzW() {
        return this.gGR ? this.gGI : this.brB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bzX() {
        return this.gGR ? this.gGM : this.fRq;
    }

    protected void bzY() {
        Editable text;
        if (bzW() != null && (text = bzW().getText()) != null) {
            int selectionStart = bzW().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bzW().onKeyDown(67, this.gGm);
            }
            bzW().onKeyDown(67, this.gGm);
            int selectionStart2 = bzW().getSelectionStart();
            if (text != null) {
                this.gHm.clear();
                this.gHm.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gHm);
                bzW().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gGd = true;
        }
    }

    private void bzZ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bAa() {
        try {
            if (this.gGo != null) {
                this.gGo.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLS.c(null);
        this.aLS.dd(d.l.sending);
        this.aLS.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLS.aH(false);
    }

    private Boolean bAb() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDs = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bzX() != null) {
                str = bzX().getText().toString();
            }
            if (bzW() != null) {
                str2 = bzW().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fQZ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dk(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dk(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dk(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gGR) {
                    dk(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dk(true);
                }
            }
            if (this.mData.getType() == 4) {
                dk(j(this.gGI) && i(this.gGM));
            } else if (this.mData.getType() == 5) {
                dk(j(this.gGI));
            } else if (!TextUtils.isEmpty(str2) || this.aDk != null) {
                dk(true);
            } else if (this.mData.getVideoInfo() != null) {
                dk(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                dk(true);
            } else {
                dk(false);
            }
        }
    }

    private void dk(boolean z) {
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
        this.aDn = new NewWriteModel(this);
        this.aDn.b(this.aDE);
        registerListener(this.gHo);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.blI();
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
            this.gGd = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gGf = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gGp = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gGq = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aDl = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gGs = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gGs != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gGx = bundle.getInt("mem_type", 0);
            this.aiP = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gHj = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gCO = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gGd = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gGf = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gGp = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gGq = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gGs = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gGs != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gGx = intent.getIntExtra("mem_type", 0);
            this.aiP = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gHj = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gCO = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gGd);
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
        this.ele = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gGe = true;
        }
        bzO();
        try {
            this.gGT = bAj();
        } catch (Throwable th) {
            this.gGT = null;
        }
    }

    private void bAc() {
        if (v.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gEe.setVisibility(8);
            this.gHf.setVisibility(0);
            this.gHg.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fRq.setText(com.baidu.tbadk.plugins.a.gC(tj(this.mList.get(0).mTopicName)));
                this.fRq.setMovementMethod(com.baidu.tieba.view.b.bwv());
            }
            this.gHh.setText(this.mList.get(0).mForumName);
            this.fRq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gHk.equals(charSequence.toString())) {
                        WriteActivity.this.gHl = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gC;
                    if (!WriteActivity.this.gHk.equals(editable.toString()) && (gC = com.baidu.tbadk.plugins.a.gC(editable.toString())) != null) {
                        WriteActivity.this.gHk = gC.toString();
                        WriteActivity.this.fRq.setText(gC);
                        if (WriteActivity.this.gHl <= WriteActivity.this.fRq.getText().length()) {
                            WriteActivity.this.fRq.setSelection(WriteActivity.this.gHl);
                        }
                    }
                }
            });
            this.gHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
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
            SpannableString gC = com.baidu.tbadk.plugins.a.gC(tj(hotTopicBussinessData.mTopicName));
            if (gC != null) {
                this.fRq.setText(gC);
            }
            this.gHh.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tj(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String tj;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!j.isEmpty(writeData.getTitle())) {
                    this.gGh.setVisibility(0);
                    this.gGh.requestFocus();
                    this.aBw.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (j.isEmpty(bzX().getText().toString()) || this.gHb || ((this.gGd || this.gGe) && !j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            tj = this.mData.getTitle();
                        } else {
                            tj = tj(str);
                        }
                        SpannableString gC = com.baidu.tbadk.plugins.a.gC(tj);
                        if (gC != null) {
                            bzX().setText(gC);
                            bzX().setSelection(gC.length() > tj.length() ? tj.length() : gC.length());
                        }
                    } else {
                        SpannableString gC2 = com.baidu.tbadk.plugins.a.gC(this.mData.getTitle());
                        if (gC2 != null) {
                            bzX().setText(gC2);
                            bzX().setSelection(this.mData.getTitle().length() > gC2.length() ? gC2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bzN();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((j.isEmpty(bzW().getText().toString()) || this.gGd || this.gGe) && !j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Eu().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gHp);
                    bzW().setText(a2);
                    bzW().setSelection(a2.length());
                    if (this.gGR) {
                        b(this.gGO, this.gGI);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bAi();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DI();
                    }
                    ns(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bAd();
                }
                blQ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gGy != null) {
                    this.gGC = this.gGz.crR;
                    this.gGB = this.gGz.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gGy.size()) {
                            break;
                        }
                        x xVar = this.gGy.get(i);
                        if (categoryTo != xVar.crR) {
                            i++;
                        } else {
                            this.gGC = categoryTo;
                            this.gGB = xVar.name;
                            this.mData.setCategoryTo(this.gGC);
                            break;
                        }
                    }
                    if (this.gGD != null) {
                        this.gGD.setText(this.gGB);
                        this.gGD.b(this.gGy, this.gGz, this.gGC);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aBw.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.aBw.Bp();
                return;
            }
            return;
        }
        bAd();
        bzN();
    }

    private void bAd() {
        if ((!this.gGR || this.gGG != null) && this.gGF != null) {
            this.gGG.c(this.writeImagesInfo);
            aIG();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gGp);
        if (this.gGd) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDl);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gGs);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gGx);
        bundle.putString("from", this.aiP);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gCO);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bzW().getEditableText().toString();
        if (obj != null) {
            bzW().setText(TbFaceManager.Eu().a(getPageContext().getPageActivity(), obj, this.gHp));
            bzW().setSelection(bzW().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAe() {
        return (bzW() == null || bzW().getText() == null) ? "" : bzW().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bzX() == null || bzX().getText() == null) {
            return "";
        }
        String obj = bzX().getText().toString();
        if (this.mPrefixData != null && v.u(this.mPrefixData.getPrefixs()) > 0 && this.fQZ != 0 && this.mData.getType() != 4 && this.fRt != null && this.fRt.getText() != null) {
            obj = this.fRt.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bze() {
        blI();
        this.mData.setContent(bAe());
        this.mData.setTitle(getThreadTitle());
        if (this.gGd || this.gGe) {
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
        if (this.gGA >= 0) {
            this.mData.setCategoryFrom(this.gGA);
        }
        if (this.gGC >= 0) {
            this.mData.setCategoryTo(this.gGC);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDm != null && this.aDm.Us());
        this.aDn.mL(this.writeImagesInfo.size() > 0);
        if (!v.v(this.mList) && this.gHe != null && this.gHe.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gHe.mForumId));
            this.mData.setForumName(this.gHe.mForumName);
        }
        this.aDn.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aDk != null) {
            if (this.aDk.getId() != null) {
                this.aDn.getWriteData().setVoice(this.aDk.getId());
                this.aDn.getWriteData().setVoiceDuringTime(this.aDk.duration);
            } else {
                this.aDn.getWriteData().setVoice(null);
                this.aDn.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDn.getWriteData().setVoice(null);
            this.aDn.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDn.btu()) {
            showToast(d.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hi()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aDn.startPostWrite();
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
            if (this.gGs != null) {
                i2 = this.gGs.getTotalCount();
                i = this.gGs.getAlreadyCount() + 1;
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
                if (this.aBw != null && !this.aBw.CY()) {
                    bzW().requestFocus();
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
                            bzW().getText().insert(bzW().getSelectionStart(), sb.toString());
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
                                bbR();
                            } else {
                                ai(intent);
                            }
                        } else if (intExtra == 1) {
                            Z(intent);
                        } else {
                            ah(intent);
                            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gGR) {
                        B(intent);
                        blQ();
                        return;
                    }
                    ak(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBw.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBw.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBw.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    blQ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.b.Q(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gGc) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gGc = false;
                            }
                            sb2.append(stringExtra);
                            fO(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.v(this.mList)) {
                    if (!v.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gHe = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gHe);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gHc.af(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.brH = this.gHc.bxo();
                        this.aBw.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gHd) {
                        bAf();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aBw != null && !this.aBw.CY()) {
                this.brB.requestFocus();
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
                    bAh();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDl = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aDl);
                    return;
                case 12012:
                    bAh();
                    return;
                case 25004:
                    if ("from_title".equals(this.gGb)) {
                        bzX().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gGb)) {
                        bzW().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAf() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gHc.bxn());
        this.mData.setCallFrom(this.gCO);
        this.mData.setRecommendExt(this.gHc.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bze();
    }

    private void bAg() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bAh() {
        if (this.gGR) {
            this.gGG.c(this.writeImagesInfo);
            aIG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIG() {
        this.gGG.notifyDataSetChanged();
        this.gGF.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gGG.notifyDataSetChanged();
                WriteActivity.this.gGF.invalidateViews();
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
        blQ();
    }

    private void ah(Intent intent) {
        if (this.gGR) {
            ak(intent);
            bAh();
        } else {
            al(intent);
        }
        blQ();
    }

    private void ak(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bAh();
            ns(true);
        }
    }

    private void ai(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bbR() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void Z(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fsZ.parseJson(stringExtra);
            this.fsZ.updateQuality();
            if (this.fsZ.getChosedFiles() != null && this.fsZ.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fsZ.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fsZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bzX());
        HidenSoftKeyPad(this.mInputManager, bzW());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void al(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aDl = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDl;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(getPageContext().getPageActivity(), k.ad(getPageContext().getPageActivity())), k.dip2px(getPageContext().getPageActivity(), k.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDl, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bAi();
            DI();
        }
        ns(true);
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
                bAi();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DI();
                }
            }
            ns(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        if (this.aBw.eE(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.u(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDl));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void ns(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cpd == null) {
            this.cpd = VoiceManager.instance();
        }
        return this.cpd;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahc() {
        this.cpd = getVoiceManager();
        this.cpd.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tz(postWriteCallBackData.getErrorCode())) {
                AntiHelper.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gGs == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDv = i;
        if (this.aBw != null) {
            this.aBw.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aBw.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DI() {
        if (!this.gGR) {
            if (this.aBw != null) {
                this.aBw.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBw.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gGE != null) {
                this.gGE.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gGE.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (this.aBw != null) {
            this.aBw.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uJ(int i) {
        if (i < this.gFe.size()) {
            for (int i2 = 0; i2 < this.gFe.size(); i2++) {
                this.gFe.get(i2).ni(false);
            }
            this.gFe.get(i).ni(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sL(int i) {
        this.fQZ = i;
        this.fRu.setCurrentIndex(i);
        uJ(i);
        this.fRt.setText(this.mPrefixData.getPrefixs().get(i));
        blQ();
        g.a(this.fRu, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fRw.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0023a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dy();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.aDl);
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
        if (this.gGZ && System.currentTimeMillis() - this.gHa < 800) {
            k.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gGZ = false;
        }
        if (this.gHn != null && !z) {
            this.gHn.aTe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(String str) {
        if (!j.isEmpty(str) && this.gGW != null) {
            tl(str);
            this.gGW.dismiss();
        }
    }

    private void cb(Context context) {
        gGY = k.ae(context);
    }

    private void tl(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gGZ = true;
        bAi();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DI();
        }
        ns(true);
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

    private File bAj() {
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

    private void bAk() {
        if (this.gGT != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cb(getActivity());
            this.gGV = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gGT != null) {
                        WriteActivity.this.tk(WriteActivity.this.gGT.getAbsolutePath());
                    }
                }
            });
            this.gGU = (TbImageView) this.gGV.findViewById(d.h.rec_img_view);
            this.gGX = (LinearLayout) this.gGV.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gGT.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gGT.getAbsolutePath());
                Bitmap b = b(this.gGT.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (b != null) {
                    this.gGU.setImageBitmap(b);
                    this.gGU.setDrawBorder(true);
                    this.gGU.setBorderWidth(2);
                    this.gGU.setBorderColor(aj.getColor(d.e.common_color_10264));
                    this.gGW = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gGW.setCanceledOnTouchOutside(true);
                    this.gGW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gGZ) {
                                k.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gHa = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gGW.setContentView(this.gGV);
                    this.gGW.show();
                    Window window = this.gGW.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gGY / 18) + getResources().getDimensionPixelSize(d.f.ds12);
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
            this.gGc = false;
            this.gGb = "";
            if ("from_content".equals(str)) {
                this.gGb = "from_content";
            } else if ("from_title".equals(str)) {
                this.gGb = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nr(false);
            }
        }
    }

    public void Br() {
        if (this.gGd || !v.v(this.mList)) {
            this.gGh.setVisibility(0);
            this.gGh.requestFocus();
            this.aBw.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gGh.setVisibility(8);
    }
}
