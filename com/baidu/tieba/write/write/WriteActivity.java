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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.a;
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
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0036a, VoiceManager.c, u.a, e.a {
    private static int hUi = 0;
    private com.baidu.tbadk.editortools.i bpX;
    private LocationModel brA;
    private NewWriteModel brB;
    private String brz;
    private VoiceManager dwG;
    private LinearLayout fKl;
    private PlayVoiceBntNew fKm;
    private ImageView fKo;
    private TextView gYQ;
    private com.baidu.tieba.write.e gYR;
    private ImageView gYS;
    private View gYT;
    private int gYw;
    private com.baidu.tieba.write.b hQF;
    private LinearLayout hSX;
    private LinearLayout hSY;
    private com.baidu.tieba.view.d hTE;
    private View hTK;
    private f hTQ;
    private View hTa;
    private Toast hTb;
    private AdditionData hTc;
    private RelativeLayout hTd;
    private TextView hTe;
    private TextView hTf;
    private TextView hTg;
    List<z> hTh;
    z hTi;
    private int hTj;
    private String hTk;
    private int hTl;
    private PostCategoryView hTm;
    private HotTopicBussinessData hTp;
    private View hTq;
    private View hTr;
    private TextView hTs;
    private TextView hTt;
    private com.baidu.tieba.write.editor.d hTx;
    private com.baidu.tieba.write.b hTy;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hSU = "";
    private boolean hSV = false;
    private WriteData mData = null;
    private boolean hTG = false;
    private boolean hSW = false;
    private boolean hTH = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gYN = null;
    private HeadImageView hTI = null;
    private View gYO = null;
    private LinearLayout cwe = null;
    private EditText cwd = null;
    private FeedBackModel hSZ = null;
    private FeedBackTopListView hTJ = null;
    private ArrayList<com.baidu.tieba.write.d> hRQ = new ArrayList<>();
    private String fiI = null;
    private final KeyEvent djM = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View beD = null;
    private TextView hTL = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hTM = null;
    private final Handler mHandler = new Handler();
    private boolean hTN = false;
    private String hTO = null;
    private RelativeLayout mParent = null;
    private String brF = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brG = 0;
    private int hTP = 0;
    private WriteImagesInfo gvy = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hTR = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hTS = null;
    private ScrollView hTn = null;
    private EditText hTT = null;
    private View hTU = null;
    private View hTV = null;
    private View hTW = null;
    private EditText hTX = null;
    private TextView hTY = null;
    private TextView hTZ = null;
    private TextWatcher hUa = null;
    private TextWatcher hUb = null;
    private boolean hTo = false;
    private boolean hUc = false;
    private com.baidu.tbadk.core.view.b bAr = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hUd = null;
    private TbImageView hUe = null;
    private View hUf = null;
    private Dialog hUg = null;
    private LinearLayout hUh = null;
    private boolean hUj = false;
    private long hUk = -1000;
    private boolean hUl = false;
    private String hyr = "2";
    private int hNe = 0;
    private String hUm = "";
    private String hTu = "";
    private int hTv = 0;
    private SpannableStringBuilder hTw = new SpannableStringBuilder();
    private boolean hUn = false;
    private final HttpMessageListener hUo = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fiI)) {
                    WriteActivity.this.fiI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oE(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fiI)) {
                    WriteActivity.this.fiI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fiI);
                    WriteActivity.this.oE(true);
                }
            }
        }
    };
    private TbFaceManager.a hTz = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gt(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.si());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.h(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dxB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVW));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVW));
        }
    };
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.atk();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hQF.aB(null);
                WriteActivity.this.hQF.on(false);
                WriteActivity.this.hTy.aB(null);
                WriteActivity.this.hTy.on(false);
                if (z) {
                    WriteActivity.this.ck(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                u.b(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                u.c(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.G(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hUm)) {
                            TiebaStatic.log(new ak("c11731").ab("obj_id", WriteActivity.this.hUm));
                        }
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hQF.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hTy.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hQF.uE(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hTy.uE(postWriteCallBackData.getErrorString());
                    if (!v.G(WriteActivity.this.hQF.bLm())) {
                        WriteActivity.this.ow(true);
                        WriteActivity.this.oC(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.FJ());
                    if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.FI());
                        if (WriteActivity.this.hTH) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a brN = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Lu() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gh(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bCP())) {
                WriteActivity.this.b(2, true, aVar.bCP());
            } else {
                gh(null);
            }
        }
    };
    private final CustomMessageListener hkU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.brA.nA(false);
                    WriteActivity.this.brA.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.brA.nA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hTA = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hTB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bNU = WriteActivity.this.bNU();
            if (bNU >= 0 && bNU < WriteActivity.this.cwd.getText().length()) {
                WriteActivity.this.cwd.setSelection(bNU);
            }
        }
    };
    private boolean hTC = true;
    private final View.OnFocusChangeListener cwk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gYN || view == WriteActivity.this.beD || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hTC = true;
                    WriteActivity.this.bNV();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gYN);
                    if (WriteActivity.this.bpX != null) {
                        WriteActivity.this.bpX.IP();
                    }
                } else if (view == WriteActivity.this.gYN) {
                    WriteActivity.this.gYQ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.cwd && z) {
                WriteActivity.this.hTC = false;
                WriteActivity.this.bNV();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.cwd);
                if (WriteActivity.this.bpX != null) {
                    WriteActivity.this.bpX.IP();
                }
            }
            WriteActivity.this.bNY();
        }
    };
    private TextWatcher cwm = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bya();
            if (WriteActivity.this.hTy != null) {
                if (!WriteActivity.this.hTy.bLp()) {
                    WriteActivity.this.oC(false);
                }
                WriteActivity.this.hTy.oo(false);
                WriteActivity.this.bNZ();
            }
        }
    };
    private TextWatcher hTD = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bya();
            if (WriteActivity.this.hQF != null) {
                if (!WriteActivity.this.hQF.bLp()) {
                    WriteActivity.this.ow(false);
                }
                WriteActivity.this.hQF.oo(false);
            }
        }
    };
    private final a.InterfaceC0153a fQU = new a.InterfaceC0153a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0153a
        public void onRefresh() {
            WriteActivity.this.fiI = null;
            WriteActivity.this.oE(false);
            WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(boolean z) {
        if (bOk() != null && bOk().getVisibility() == 0 && bOk().getText() != null) {
            int selectionEnd = bOk().getSelectionEnd();
            SpannableStringBuilder b = this.hTy.b(bOk().getText());
            if (b != null) {
                this.hTy.oo(true);
                bOk().setText(b);
                if (z && this.hTy.bLn() >= 0) {
                    bOk().requestFocus();
                    bOk().setSelection(this.hTy.bLn());
                } else {
                    bOk().setSelection(selectionEnd);
                }
                this.hTy.on(this.hTy.bLn() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(boolean z) {
        if (bOj() != null && bOj().getText() != null) {
            int selectionEnd = bOj().getSelectionEnd();
            SpannableStringBuilder b = this.hQF.b(bOj().getText());
            if (b != null) {
                this.hQF.oo(true);
                bOj().setText(b);
                if (z && this.hQF.bLn() >= 0) {
                    bOj().requestFocus();
                    bOj().setSelection(this.hQF.bLn());
                } else {
                    bOj().setSelection(selectionEnd);
                }
                this.hQF.on(this.hQF.bLn() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Lg() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lh();
        } else if (this.brA.bCX()) {
            Lf();
        } else {
            this.brA.nA(false);
            b(1, true, null);
            this.brA.bCV();
        }
    }

    private void Lh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oI()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.brA.agv();
                } else {
                    WriteActivity.this.brN.Lu();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bNU() {
        int selectionEnd = bOj().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bOj().getText().getSpans(0, bOj().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bOj().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bOj().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNV() {
        if (this.bpX != null) {
            this.bpX.setBarLauncherEnabled(!this.hTC);
            this.bpX.g(true, 26);
            this.bpX.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hTo) {
            this.gYN.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hTW.setVisibility(8);
            } else {
                this.hTW.setVisibility(0);
            }
            b(this.hTZ, this.hTT);
            b(this.hTY, this.hTX);
            bya();
        }
        if (this.hTG) {
            this.hTC = true;
            bNV();
            if (this.bpX != null) {
                this.bpX.IP();
            }
            this.gYN.requestFocus();
            ShowSoftKeyPadDelay(this.gYN);
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
            bOD();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bOq();
            }
            oF(true);
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
        this.hTy = new com.baidu.tieba.write.b();
        this.hTy.yD(d.C0108d.cp_cont_i);
        this.hTy.yE(d.C0108d.cp_cont_h_alpha85);
        this.hQF = new com.baidu.tieba.write.b();
        this.hQF.yD(d.C0108d.cp_cont_i);
        this.hQF.yE(d.C0108d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            zj(this.hNe);
        }
        initUI();
        bOv();
        this.brA = new LocationModel(this);
        this.brA.a(this.brN);
        registerListener(this.hkU);
        registerListener(this.hTA);
        initEditor();
        bOF();
        if (this.hTo) {
            this.hTS.setEditorTools(this.bpX);
        } else {
            this.cwd.requestFocus();
        }
        IR();
        bOq();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bpX = new com.baidu.tbadk.editortools.i(getActivity());
        this.bpX.setBarMaxLauCount(5);
        this.bpX.setMoreButtonAtEnd(true);
        this.bpX.setBarLauncherType(1);
        this.bpX.cc(true);
        this.bpX.cd(true);
        this.bpX.setMoreLauncherIcon(d.f.write_more);
        this.bpX.setBackgroundColorId(d.C0108d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bOt();
                break;
            default:
                bNW();
                break;
        }
        this.bpX.KG();
        if (this.hSX != null) {
            this.hSX.addView(this.bpX);
        }
        bNX();
        this.bpX.th();
        com.baidu.tbadk.editortools.l hL = this.bpX.hL(6);
        if (hL != null && !TextUtils.isEmpty(this.brF)) {
            ((View) hL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.brF);
                }
            });
        }
        if (!this.hTo) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bpX.IP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bOr() {
        this.hTU = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hTW = this.hTU.findViewById(d.g.live_post_title_container);
        this.hTT = (EditText) this.hTU.findViewById(d.g.live_post_content);
        this.hTR = (GridView) this.hTU.findViewById(d.g.photoLiveGridView);
        this.hTX = (EditText) this.hTU.findViewById(d.g.live_post_title);
        this.hTY = (TextView) this.hTU.findViewById(d.g.titleOverPlusNumber);
        this.hTZ = (TextView) this.hTU.findViewById(d.g.contentOverPlusNumber);
        this.hTV = this.hTU.findViewById(d.g.live_interval_view);
        this.hTY.setText(String.valueOf(20));
        this.hTZ.setText(String.valueOf(233));
        this.hTU.setVisibility(0);
        this.hTY.setVisibility(0);
        this.hTZ.setVisibility(0);
        this.hTX.setHint(d.j.tips_title_limit_new);
        this.hTX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hUc = true;
                    WriteActivity.this.hTC = true;
                    WriteActivity.this.bNV();
                    if (WriteActivity.this.bpX != null) {
                        WriteActivity.this.bpX.IP();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hTT.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hTT.setHint(d.j.live_write_input_content_update);
        }
        this.hTT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hUc = false;
                    WriteActivity.this.hTC = false;
                    WriteActivity.this.bNV();
                    if (WriteActivity.this.bpX != null) {
                        WriteActivity.this.bpX.IP();
                    }
                }
            }
        });
        this.hTT.requestFocus();
        this.hTT.addTextChangedListener(blq());
        this.hTX.requestFocus();
        this.hTX.addTextChangedListener(blq());
        this.hTX.setOnClickListener(this.hTB);
        this.hTT.setOnClickListener(this.hTB);
        this.hTS = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hTR);
        this.hTS.yV(6);
        this.hTR.setAdapter((ListAdapter) this.hTS);
        View findViewById = this.hTU.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bNe() {
                WriteActivity.this.aRV();
            }
        });
        bOs();
    }

    private void bOs() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hTX.setText(this.mData.getTitle());
                this.hTX.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hTo) {
            bOB();
        }
        if (this.bpX.KI()) {
            this.bpX.IP();
        }
        zj(0);
    }

    private void zj(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hyr);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bOt() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bpX.K(arrayList);
        r hN = this.bpX.hN(5);
        if (hN != null) {
            hN.bqG = 2;
            hN.bqE = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.bqE = d.f.write_at;
        this.bpX.b(aVar);
        this.bpX.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bNW() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.bqE = d.f.write_picture;
        this.bpX.b(dVar);
        Boolean bOz = bOz();
        if (!this.hTG && bOz != null && bOz.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bDt() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.bqG = 3;
            rVar5.bqE = d.f.write_recorder;
            this.bpX.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.bqE = d.f.write_at;
        this.bpX.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.bqG = 5;
            rVar4.bqE = d.f.write_privilege;
            this.bpX.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.bqG = 6;
            rVar3.bqE = this.hTG ? d.f.write_location : d.f.icon_post_more_location;
            this.bpX.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bpX.b(aVar2);
        aVar2.bqE = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.bqI = true;
            rVar2.bqG = 9;
            rVar2.bqE = 0;
            this.bpX.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.bqI = true;
            rVar.bqG = 10;
            rVar.bqE = 0;
            this.bpX.b(rVar);
        }
        if (this.hTc == null) {
            if (this.hTx == null) {
                this.hTx = new com.baidu.tieba.write.editor.d(getActivity(), this.hyr);
                this.hTx.aL(this.mData.getForumId(), this.privateThread);
            }
            this.bpX.b(this.hTx);
        }
        this.bpX.K(arrayList);
        r hN = this.bpX.hN(5);
        if (hN != null) {
            hN.bqG = 1;
            hN.bqE = d.f.write_emotion;
        }
    }

    private void bNX() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bOi()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bOi()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bOl();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bbv();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bOD();
                        WriteActivity.this.bya();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.zk(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hTc == null) {
                            WriteActivity.this.Li();
                            return;
                        }
                        switch (WriteActivity.this.brG) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    WriteActivity.this.Lg();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Lf();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.brA != null) {
                            WriteActivity.this.brA.nA(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fiI = null;
                        } else {
                            WriteActivity.this.fiI = (String) aVar.data;
                        }
                        WriteActivity.this.oE(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ab(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bpX.KI()) {
                                        WriteActivity.this.bpX.IP();
                                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_not_active), WriteActivity.this.getResources().getString(d.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.j.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bya();
                        if (WriteActivity.this.cwd != null) {
                            WriteActivity.this.cwd.requestFocus();
                        }
                        WriteActivity.this.bpX.IP();
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwd);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hSV = true;
                        WriteActivity.this.oD(true);
                        if (WriteActivity.this.bOk().isFocused()) {
                            WriteActivity.this.hSU = "from_title";
                        } else if (WriteActivity.this.bOj().isFocused()) {
                            WriteActivity.this.hSU = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hSY.setVisibility(0);
                        WriteActivity.this.hSY.requestFocus();
                        WriteActivity.this.bya();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hSY.hasFocus()) {
                            WriteActivity.this.cwd.requestFocus();
                            WriteActivity.this.cwd.setSelection(WriteActivity.this.cwd.getText().toString().length());
                        }
                        WriteActivity.this.hSY.setVisibility(8);
                        WriteActivity.this.bya();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bpX.a(16, bVar);
        this.bpX.a(14, bVar);
        this.bpX.a(24, bVar);
        this.bpX.a(3, bVar);
        this.bpX.a(10, bVar);
        this.bpX.a(11, bVar);
        this.bpX.a(12, bVar);
        this.bpX.a(13, bVar);
        this.bpX.a(15, bVar);
        this.bpX.a(18, bVar);
        this.bpX.a(20, bVar);
        this.bpX.a(25, bVar);
        this.bpX.a(27, bVar);
        this.bpX.a(29, bVar);
        this.bpX.a(43, bVar);
        this.bpX.a(45, bVar);
        this.bpX.a(53, bVar);
        this.bpX.a(48, bVar);
        this.bpX.a(46, bVar);
        this.bpX.a(49, bVar);
        this.bpX.a(47, bVar);
        this.bpX.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        if (this.brA.agr()) {
            if (this.brA.bCX()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bCT().getLocationData().bCP());
                return;
            }
            b(1, true, null);
            this.brA.bCV();
            return;
        }
        b(0, true, null);
    }

    protected void bxS() {
        if (this.brB != null) {
            this.brB.cancelLoadData();
        }
        if (this.hSZ != null) {
            this.hSZ.cancelLoadData();
        }
        if (this.brA != null) {
            this.brA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bxS();
        bOy();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hTQ != null) {
            this.hTQ.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        if (this.mData != null && this.mData.getType() == 2 && this.hTN) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bOk().getText().toString());
            this.mData.setContent(bOj().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b("24591571", this.mData);
                }
            } else if (type == 1) {
                u.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                u.b(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                u.c(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gYR != null && this.gYR.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gYR, getPageContext().getPageActivity());
                return true;
            } else if (this.bpX.KI()) {
                this.bpX.IP();
                return true;
            } else {
                bxS();
                bNp();
                return true;
            }
        }
        if (i == 67 && (text = bOj().getText()) != null) {
            int selectionStart = bOj().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bOj().onKeyDown(67, this.djM);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.mParent);
        getLayoutMode().aM(this.hUh);
        if (this.hUe != null && i == 1) {
            this.hUe.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0108d.cp_link_tip_a, 1);
        bNV();
        aj.t(this.hTU, d.C0108d.cp_bg_line_d);
        aj.t(this.gYO, d.C0108d.cp_bg_line_c);
        aj.t(this.hTV, d.C0108d.cp_bg_line_c);
        aj.t(bOk(), d.C0108d.cp_bg_line_d);
        aj.c(this.fKo, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fiI)) {
            aj.t(bOj(), d.C0108d.cp_bg_line_d);
        }
        bya();
        this.bpX.onChangeSkinType(i);
        if (this.hTm != null) {
            this.hTm.Ea();
        }
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bNY();
        bNZ();
        if (this.hQF != null) {
            this.hQF.onChangeSkinType();
        }
        if (this.hTy != null) {
            this.hTy.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNY() {
        if (this.gYN.hasFocus()) {
            this.gYN.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.gYN.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
        if (this.cwd.hasFocus()) {
            this.cwd.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.cwd.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNZ() {
        if (this.gYN != null && this.gYN.getText() != null && this.gYN.getText().toString() != null && this.gYN.getPaint() != null) {
            if (this.gYN.getText().toString().length() == 0) {
                this.gYN.getPaint().setFakeBoldText(false);
            } else if (this.gYN.getText().toString().length() > 0) {
                this.gYN.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bAr = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hTo = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0108d.cp_cont_b);
        this.hTL = (TextView) findViewById(d.g.btn_image_problem);
        bOb();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwk);
        this.hTn = (ScrollView) findViewById(d.g.write_scrollview);
        this.hTn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.cwd != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.cwd);
                    }
                    if (WriteActivity.this.bpX != null) {
                        WriteActivity.this.bpX.IP();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hTJ = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hTK = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hSX = (LinearLayout) findViewById(d.g.tool_view);
        this.hSX.setContentDescription("..");
        this.hSY = (LinearLayout) findViewById(d.g.title_view);
        this.gYO = findViewById(d.g.interval_view);
        this.hTq = findViewById(d.g.hot_topic_fourm_view);
        this.hTr = findViewById(d.g.hot_topic_divider);
        this.hTs = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hTt = (TextView) findViewById(d.g.change_one_tv);
        bxZ();
        if (this.hTo) {
            this.hTn.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bOr();
        } else {
            this.hTQ = new f(getPageContext(), this.mRootView);
            f fVar = this.hTQ;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.ou(z);
        }
        afp();
        if (this.hTG || this.hSW) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWF) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.cwe = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwe.setDrawingCacheEnabled(false);
        this.cwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cwd.requestFocus();
                WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fKl = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fKm = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fKo = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bbv();
            }
        });
        this.beD.setOnFocusChangeListener(this.cwk);
        this.beD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bxS();
                WriteActivity.this.bNp();
            }
        });
        this.hTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bOe();
        i(bOz());
        bOg();
        bOa();
        bOw();
        bOx();
        bNV();
        bOf();
        bxY();
        bOm();
        if (this.mData.getType() == 4 && this.gYT != null && this.hTa != null) {
            this.gYT.setVisibility(8);
            this.hTa.setVisibility(8);
        }
        bya();
        bOu();
    }

    private void bOa() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hTG || this.hSW) {
                        if (this.hTH) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hyr != null && this.hyr.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hyr != null && this.hyr.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.j.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gYN.setVisibility(0);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gYN.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hTV.setVisibility(8);
                    return;
                case 7:
                    this.gYN.setVisibility(0);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bOb() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bOc() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hTG && !this.hSW && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bOk() != null) {
                bOk().setText(d);
                bOk().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fKl.setVisibility(0);
            this.fKm.setVoiceModel(voiceModel);
            this.fKm.bDs();
            bya();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eG(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fKl.setVisibility(8);
        this.fKm.aCw();
        this.fKm.setVoiceModel(null);
        r hN = this.bpX.hN(6);
        if (hN != null && hN.bpR != null) {
            hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bya();
    }

    private void bOd() {
        this.hTh = null;
        this.hTj = -1;
        this.hTl = -1;
        com.baidu.tieba.frs.ab mW = aa.auf().mW(1);
        if (mW != null) {
            this.hTh = mW.dzs;
            this.hTj = getIntent().getIntExtra("category_id", -1);
            if (this.hTh != null && !this.hTh.isEmpty() && this.hTj >= 0) {
                this.hTi = new z();
                this.hTi.dzo = 0;
                this.hTi.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hTl = this.hTi.dzo;
                this.hTk = this.hTi.name;
                for (z zVar : this.hTh) {
                    if (zVar.dzo == this.hTj) {
                        this.hTl = zVar.dzo;
                        this.hTk = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bOe() {
        if (this.hTh != null && !this.hTh.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hTm = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hTm.setText(this.hTk);
            this.hTm.b(this.hTh, this.hTi, this.hTl);
            this.hTm.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hTm.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dzo);
                        WriteActivity.this.hTl = avVar.dzo;
                        WriteActivity.this.hTm.bNh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hTm.bNg();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOk());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOj());
                }
            });
        }
    }

    private void bOu() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hTE = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hTE.setTitle(d.j.no_disturb_start_time);
        this.hTE.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hTE);
        this.hTE.setButton(-2, getPageContext().getString(d.j.cancel), this.hTE);
        return this.hTE;
    }

    private void bOf() {
        this.hTd = (RelativeLayout) findViewById(d.g.addition_container);
        this.hTe = (TextView) findViewById(d.g.addition_create_time);
        this.hTf = (TextView) findViewById(d.g.addition_last_time);
        this.hTg = (TextView) findViewById(d.g.addition_last_content);
        if (this.hTc != null) {
            this.hTd.setVisibility(0);
            this.hTe.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hTc.getCreateTime() * 1000));
            if (this.hTc.getAlreadyCount() == 0) {
                this.hTf.setVisibility(8);
            } else {
                this.hTf.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hTc.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hTc.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hTg.setText(lastAdditionContent);
            } else {
                this.hTg.setVisibility(8);
            }
            bOj().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hTc.getAlreadyCount()), Integer.valueOf(this.hTc.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hTd.setVisibility(8);
    }

    private void bxY() {
        this.gYT = findViewById(d.g.post_prefix_layout);
        this.gYQ = (TextView) findViewById(d.g.post_prefix);
        this.hTa = findViewById(d.g.prefix_divider);
        this.gYS = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gYT.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gYw = 1;
            this.gYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gYQ.setVisibility(0);
                    WriteActivity.this.gYT.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gYR, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bpX.IP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gYN);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwd);
                }
            });
            this.gYS = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gYS.setVisibility(0);
                this.gYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gYQ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gYR, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bpX.IP();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOk());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOj());
                    }
                });
            }
            this.gYR = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gYR.a(this);
            this.gYR.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gYR.setOutsideTouchable(true);
            this.gYR.setFocusable(true);
            this.gYR.setOnDismissListener(this);
            this.gYR.setBackgroundDrawable(aj.getDrawable(d.C0108d.cp_bg_line_d));
            int color = aj.getColor(d.C0108d.cp_cont_b);
            int color2 = aj.getColor(d.C0108d.cp_cont_c);
            aj.s(this.gYQ, d.C0108d.cp_bg_line_d);
            aj.c(this.gYS, d.f.icon_frs_arrow_n);
            this.gYQ.setTextColor(color);
            this.hRQ.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hRQ.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gYR.addView(dVar);
            }
            this.gYR.setCurrentIndex(0);
            this.gYQ.setText(prefixs.get(1));
            zf(1);
            return;
        }
        this.gYT.setVisibility(8);
    }

    private void bOv() {
        if (this.hTG && this.mData != null) {
            this.hTJ.setVisibility(0);
            this.hTK.setVisibility(0);
            this.hSZ = new FeedBackModel(getPageContext());
            this.hSZ.vb(this.mData.getForumName());
            this.hSZ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hTJ.setVisibility(8);
                        WriteActivity.this.hTK.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hTJ.setVisibility(8);
                        WriteActivity.this.hTK.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hTJ.a(feedBackModel.bNJ(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bOg() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hTy.bLo()) {
                        WriteActivity.this.showToast(WriteActivity.this.hTy.bLq());
                        WriteActivity.this.oC(true);
                    } else if (WriteActivity.this.hQF.bLo()) {
                        WriteActivity.this.showToast(WriteActivity.this.hQF.bLq());
                        WriteActivity.this.ow(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOk());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bOj());
                        WriteActivity.this.bpX.IP();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hTG) {
                                WriteActivity.this.bNq();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bOo();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bNq();
                        }
                        TiebaStatic.log(new ak("c12262").ab("obj_locate", WriteActivity.this.hyr));
                    }
                }
            }
        });
    }

    protected void bOw() {
        this.hTM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hTM.cZ(getPageContext().getString(d.j.is_save_draft)).aV(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bOk().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bOj().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    u.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hTM.b(getPageContext());
    }

    protected void bxZ() {
        this.hTI = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hTI.setIsRound(true);
        this.hTI.setDrawBorder(false);
        this.hTI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dL = o.dL(currentPortrait);
            this.hTI.setUrl(dL);
            this.hTI.startLoad(dL, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hTI.setVisibility(0);
        }
        this.gYN = (EditText) findViewById(d.g.post_title);
        this.gYN.setOnClickListener(this.hTB);
        this.gYN.setOnFocusChangeListener(this.cwk);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gYN.setText(this.mData.getTitle());
                this.gYN.setSelection(this.mData.getTitle().length());
            } else if (this.hTH) {
                this.gYN.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gYN.addTextChangedListener(this.cwm);
        if (!this.mData.getHaveDraft()) {
            bOc();
            this.hUl = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gYN.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gYN.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher blq() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int cwp;
            private EditText rE = null;
            private TextView rz = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bya();
                if (WriteActivity.this.hTo) {
                    this.cwp = this.rE.getSelectionStart();
                    this.rE.setSelection(this.cwp);
                    WriteActivity.this.b(this.rz, this.rE);
                }
                if (this.rE != WriteActivity.this.hTX || WriteActivity.this.hTy == null || WriteActivity.this.hTy.bLp()) {
                    if (this.rE == WriteActivity.this.hTT && WriteActivity.this.hQF != null && !WriteActivity.this.hQF.bLp()) {
                        WriteActivity.this.ow(false);
                    }
                } else {
                    WriteActivity.this.oC(false);
                }
                if (WriteActivity.this.hTy != null) {
                    WriteActivity.this.hTy.oo(false);
                }
                if (WriteActivity.this.hQF != null) {
                    WriteActivity.this.hQF.oo(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hTo || !WriteActivity.this.hUc) {
                    if (WriteActivity.this.hTo) {
                        if (this.rE != WriteActivity.this.hTT || this.rz != WriteActivity.this.hTZ) {
                            this.rE = WriteActivity.this.hTT;
                            this.rz = WriteActivity.this.hTZ;
                        }
                    }
                } else if (this.rE != WriteActivity.this.hTX || this.rz != WriteActivity.this.hTY) {
                    this.rE = WriteActivity.this.hTX;
                    this.rz = WriteActivity.this.hTY;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hTo && this.hUc) {
            if (this.hUa != null) {
                this.hTX.removeTextChangedListener(this.hUa);
            }
            this.hUa = textWatcher;
        } else if (this.hTo) {
            if (this.hUb != null) {
                this.hTT.removeTextChangedListener(this.hUb);
            }
            this.hUb = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.hTT) {
            return 233L;
        }
        if (editText != this.hTX) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long k = k(editText);
            long i = k - i(editText);
            String valueOf = String.valueOf(i);
            if (k == 20) {
                if (i < 0) {
                    if (i < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0108d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                }
            } else if (i < 0) {
                if (i < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0108d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long i(EditText editText) {
        return com.baidu.tieba.write.b.a.u(editText.getText().toString().trim());
    }

    protected void afp() {
        this.cwd = (EditText) findViewById(d.g.post_content);
        this.cwd.setDrawingCacheEnabled(false);
        this.cwd.setOnClickListener(this.hTB);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Ma().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwd.setText(W);
            this.cwd.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hTN) {
                if (this.hTO != null && this.hTO.length() > 0) {
                    this.cwd.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hTO}));
                    this.cwd.setSelection(this.cwd.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.cwd.setText(format);
                this.cwd.setSelection(format.length());
            }
        }
        this.cwd.setOnFocusChangeListener(this.cwk);
        this.cwd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.cwd.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwd.addTextChangedListener(this.hTD);
        if (this.mData.getType() == 0) {
            this.hUn = true;
        } else {
            oE(true);
            this.hUn = false;
        }
        if (this.mData.isUserFeedback()) {
            this.cwd.setHint(d.j.write_input_content);
        } else {
            this.cwd.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oE(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hTo) {
            bOj().setPadding(0, 0, 0, 0);
            bOj().setBackgroundDrawable(null);
            aj.t(bOj(), d.C0108d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fiI) && this.hTc == null) {
                com.baidu.adp.lib.f.c.nl().a(this.fiI, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.si() != null && aVar.sm() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.si(), aVar.si().getNinePatchChunk(), aVar.sm(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bOj().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bOj(), true, WriteActivity.this.fQU);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOi() {
        int i = 5000;
        if (this.hTc != null) {
            i = 1000;
        }
        return bOj().getText() != null && bOj().getText().length() >= i;
    }

    private void fY(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hSU)) {
                this.hSU = "";
                bOj().requestFocus();
                if (bOj().getText() != null && bOj().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bOj().getSelectionStart();
                    editable = bOj().getText();
                }
            } else if ("from_title".equals(this.hSU)) {
                this.hSU = "";
                bOk().requestFocus();
                if (bOk().getText() != null && bOk().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bOk().getSelectionStart();
                    editable = bOk().getText();
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
    public void oD(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bOj().getText().getSpans(0, bOj().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hTb == null) {
                this.hTb = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hTb.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FA = nVar.FA();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nl().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bOj().getSelectionStart(), aVar, FA);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bOj() != null && bOj().getText() != null) {
            Bitmap si = aVar.si();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(si);
            int width = si.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, si.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.h(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bOj().getSelectionStart() - 1;
                if (bOj().getText().length() > 1 && selectionStart >= 0 && bOj().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bOj().getText().insert(bOj().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bOj().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bOj().getText().insert(bOj().getSelectionStart(), spannableString2);
            }
            Editable text = bOj().getText();
            if (text != null) {
                this.hTw.clear();
                this.hTw.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hTw);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bOj().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bOj().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bOj().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bOj() {
        return this.hTo ? this.hTT : this.cwd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bOk() {
        return this.hTo ? this.hTX : this.gYN;
    }

    protected void bOl() {
        Editable text;
        if (bOj() != null && (text = bOj().getText()) != null) {
            int selectionStart = bOj().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bOj().onKeyDown(67, this.djM);
            }
            bOj().onKeyDown(67, this.djM);
            int selectionStart2 = bOj().getSelectionStart();
            if (text != null) {
                this.hTw.clear();
                this.hTw.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hTw);
                bOj().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hTG = true;
        }
    }

    private void bOx() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bOy() {
        try {
            if (this.hTM != null) {
                this.hTM.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAr.c(null);
        this.bAr.ga(d.j.sending);
        this.bAr.bm(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAr.bm(false);
    }

    private Boolean bOz() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.brF = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bya() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bOk() != null) {
                str = bOk().getText().toString();
            }
            if (bOj() != null) {
                str2 = bOj().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gYw == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hSY.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ef(true);
                            return;
                        }
                    } else if (this.hSY.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ef(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hSY.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ef(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hTo) {
                    ef(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ef(true);
                }
            }
            if (this.mData.getType() == 4) {
                ef(m(this.hTT) && l(this.hTX));
            } else if (this.mData.getType() == 5) {
                ef(m(this.hTT));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                ef(true);
            } else if (this.mData.getVideoInfo() != null) {
                ef(true);
            } else {
                ef(false);
            }
        }
    }

    public void ef(boolean z) {
        if (z) {
            aj.d(this.mPost, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.e(this.mPost, d.C0108d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean l(EditText editText) {
        long i = i(editText);
        return i <= 20 && i > 0;
    }

    private boolean m(EditText editText) {
        long i = i(editText);
        if (i > 233) {
            return false;
        }
        return i > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.brB = new NewWriteModel(this);
        this.brB.b(this.brP);
        registerListener(this.hUo);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bxS();
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
            this.hTG = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hTH = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hTN = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hTO = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.brz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hTc = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hTc != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hTP = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hUm = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hyr = bundle.getString("KEY_CALL_FROM");
            this.hNe = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hTG = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hTH = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hTN = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hTO = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hTc = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hTc != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hTP = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hUm = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hyr = intent.getStringExtra("KEY_CALL_FROM");
            this.hNe = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hTG);
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
                u.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                u.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            u.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            u.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            u.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.fiI = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hSW = true;
        }
        bOd();
        try {
            this.hUd = bOE();
        } catch (Throwable th) {
            this.hUd = null;
        }
    }

    private void bOm() {
        if (v.F(this.mList) > 0 && this.mList.get(0) != null) {
            this.hTI.setVisibility(8);
            this.hTq.setVisibility(0);
            this.hTr.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gYN.setText(com.baidu.tbadk.plugins.a.gL(vc(this.mList.get(0).mTopicName)));
                this.gYN.setMovementMethod(com.baidu.tieba.view.e.bKu());
            }
            this.hTs.setText(this.mList.get(0).mForumName);
            this.gYN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hTu.equals(charSequence.toString())) {
                        WriteActivity.this.hTv = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gL;
                    if (!WriteActivity.this.hTu.equals(editable.toString()) && (gL = com.baidu.tbadk.plugins.a.gL(editable.toString())) != null) {
                        WriteActivity.this.hTu = gL.toString();
                        WriteActivity.this.gYN.setText(gL);
                        if (WriteActivity.this.hTv <= WriteActivity.this.gYN.getText().length()) {
                            WriteActivity.this.gYN.setSelection(WriteActivity.this.hTv);
                        }
                    }
                }
            });
            this.hTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
            SpannableString gL = com.baidu.tbadk.plugins.a.gL(vc(hotTopicBussinessData.mTopicName));
            if (gL != null) {
                this.gYN.setText(gL);
            }
            this.hTs.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String vc(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.u.a
    public void a(WriteData writeData) {
        String str;
        String vc;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bOk().getText().toString()) || this.hUl || ((this.hTG || this.hSW) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.G(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.f(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            vc = this.mData.getTitle();
                        } else {
                            vc = vc(str);
                        }
                        SpannableString gL = com.baidu.tbadk.plugins.a.gL(vc);
                        if (gL != null) {
                            bOk().setText(gL);
                            bOk().setSelection(gL.length() > vc.length() ? vc.length() : gL.length());
                        }
                    } else {
                        SpannableString gL2 = com.baidu.tbadk.plugins.a.gL(this.mData.getTitle());
                        if (gL2 != null) {
                            bOk().setText(gL2);
                            bOk().setSelection(this.mData.getTitle().length() > gL2.length() ? gL2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bOc();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bOj().getText().toString()) || this.hTG || this.hSW) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ma().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hTz);
                    bOj().setText(a2);
                    bOj().setSelection(a2.length());
                    if (this.hTo) {
                        b(this.hTZ, this.hTT);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bOD();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bOq();
                    }
                    oF(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bOA();
                }
                bya();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hTh != null) {
                    this.hTl = this.hTi.dzo;
                    this.hTk = this.hTi.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hTh.size()) {
                            break;
                        }
                        z zVar = this.hTh.get(i);
                        if (categoryTo != zVar.dzo) {
                            i++;
                        } else {
                            this.hTl = categoryTo;
                            this.hTk = zVar.name;
                            this.mData.setCategoryTo(this.hTl);
                            break;
                        }
                    }
                    if (this.hTm != null) {
                        this.hTm.setText(this.hTk);
                        this.hTm.b(this.hTh, this.hTi, this.hTl);
                    }
                }
                this.bpX.IP();
                return;
            }
            return;
        }
        bOA();
        bOc();
    }

    private void bOA() {
        if ((!this.hTo || this.hTS != null) && this.hTR != null) {
            this.hTS.c(this.writeImagesInfo);
            aRV();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hTN);
        if (this.hTG) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.brz);
        if (this.hTc != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hTc));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hTP);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hyr);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hNe);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bOj().getEditableText().toString();
        if (obj != null) {
            bOj().setText(TbFaceManager.Ma().a(getPageContext().getPageActivity(), obj, this.hTz));
            bOj().setSelection(bOj().getText().length());
        }
    }

    private String bOn() {
        return (bOj() == null || bOj().getText() == null) ? "" : bOj().getText().toString();
    }

    private String blT() {
        if (this.mData == null || bOk() == null || bOk().getVisibility() != 0 || bOk().getText() == null) {
            return "";
        }
        String obj = bOk().getText().toString();
        if (this.mPrefixData != null && v.F(this.mPrefixData.getPrefixs()) > 0 && this.gYw != 0 && this.mData.getType() != 4 && this.gYQ != null && this.gYQ.getText() != null) {
            obj = this.gYQ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void vd(String str) {
        if (this.mData != null && this.hSY != null) {
            if (this.hSY.getVisibility() == 0) {
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
    public void bNq() {
        bxS();
        this.mData.setContent(bOn());
        vd(blT());
        if (this.hTG || this.hSW) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                vd(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.j.app_name) + getResources().getString(d.j.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.oI()) {
                    sb.append(com.baidu.adp.lib.util.j.oQ());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hTj >= 0) {
            this.mData.setCategoryFrom(this.hTj);
        }
        if (this.hTl >= 0) {
            this.mData.setCategoryTo(this.hTl);
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
        this.mData.setHasLocationData(this.brA != null && this.brA.agr());
        if (this.writeImagesInfo != null) {
            this.brB.nC(this.writeImagesInfo.size() > 0);
        }
        if (!v.G(this.mList) && this.hTp != null && this.hTp.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hTp.mForumId));
            this.mData.setForumName(this.hTp.mForumName);
        }
        this.brB.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.brB.getWriteData().setVoice(this.mVoiceModel.getId());
                this.brB.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.brB.getWriteData().setVoice(null);
                this.brB.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.brB.getWriteData().setVoice(null);
            this.brB.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.brB.bDu()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oI()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.brB.startPostWrite();
        }
    }

    private void s(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hTc != null) {
                i2 = this.hTc.getTotalCount();
                i = this.hTc.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.j.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    private void a(PostWriteCallBackData postWriteCallBackData, String str) {
        if (postWriteCallBackData != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
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
                if (this.gYN == getCurrentFocus()) {
                    bOj().clearFocus();
                    this.gYN.requestFocus();
                    if (this.bpX != null) {
                        this.bpX.IP();
                    }
                    ShowSoftKeyPadDelay(this.gYN);
                } else {
                    bOj().requestFocus();
                    if (this.bpX != null) {
                        this.bpX.IP();
                    }
                    ShowSoftKeyPadDelay(this.cwd);
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
                            bOj().getText().insert(bOj().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    u.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    u.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    u.b(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData2, "from_write");
                }
                j(postWriteCallBackData2);
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
                                bmO();
                            } else {
                                aj(intent);
                            }
                        } else if (intExtra == 1) {
                            aa(intent);
                        } else {
                            ai(intent);
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hUn) {
                            oE(true);
                            this.hUn = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hTo) {
                        C(intent);
                        bya();
                        return;
                    }
                    al(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bpX.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bya();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hSV) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hSV = false;
                            }
                            sb2.append(stringExtra);
                            fY(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.G(this.mList) && !v.G(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hTp = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hTp);
                }
            }
        } else if (i2 == 0) {
            if (this.bpX != null && !this.bpX.KI()) {
                this.cwd.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bpX.IP();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    Ll();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bOC();
                    if (this.hUn) {
                        oE(true);
                        this.hUn = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gYN == getCurrentFocus()) {
                        bOj().clearFocus();
                        this.gYN.requestFocus();
                        if (this.bpX != null) {
                            this.bpX.IP();
                        }
                        ShowSoftKeyPadDelay(this.gYN);
                        return;
                    }
                    bOj().requestFocus();
                    if (this.bpX != null) {
                        this.bpX.IP();
                    }
                    ShowSoftKeyPadDelay(this.cwd);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hQF.aB(postWriteCallBackData.getSensitiveWords());
                        this.hTy.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.G(this.hQF.bLm())) {
                            ow(true);
                            oC(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.brz = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.brz);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bOC();
                    return;
                case 25004:
                    if ("from_title".equals(this.hSU)) {
                        bOk().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hSU)) {
                        bOj().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOo() {
        if ("1".equals(this.hyr)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hyr)) {
            this.mData.setCanNoForum(false);
        }
        bOp();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hyr);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bNq();
    }

    private void bOp() {
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bOB() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bOC() {
        if (this.hTo) {
            this.hTS.c(this.writeImagesInfo);
            aRV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRV() {
        this.hTS.notifyDataSetChanged();
        this.hTR.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hTS.notifyDataSetChanged();
                WriteActivity.this.hTR.invalidateViews();
            }
        }, 550L);
    }

    public void r(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bya();
    }

    private void ai(Intent intent) {
        if (this.hTo) {
            al(intent);
            bOC();
        } else {
            am(intent);
        }
        bya();
    }

    private void al(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bOC();
            oF(true);
        }
    }

    private void aj(Intent intent) {
        if (this.writeImagesInfo != null) {
            B(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bmO() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aa(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.gvy.parseJson(stringExtra);
            this.gvy.updateQuality();
            if (this.gvy.getChosedFiles() != null && this.gvy.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.gvy.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.gvy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bOk());
        HidenSoftKeyPad(this.mInputManager, bOj());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.brz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.brz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.brz, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bOD();
            bOq();
        }
        oF(true);
    }

    private void C(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bOD();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bOq();
                }
            }
            oF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOD() {
        if (this.bpX.hN(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Ll() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.brz));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oF(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hTQ != null) {
            this.hTQ.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dwG == null) {
            this.dwG = VoiceManager.instance();
        }
        return this.dwG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atk() {
        this.dwG = getVoiceManager();
        this.dwG.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.xo(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dxB) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVW));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hTc == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                s(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brG = i;
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bOq() {
        if (!this.hTo) {
            if (this.bpX != null) {
                this.bpX.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bpX.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hTQ != null) {
                this.hTQ.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void zf(int i) {
        if (i < this.hRQ.size()) {
            for (int i2 = 0; i2 < this.hRQ.size(); i2++) {
                this.hRQ.get(i2).oq(false);
            }
            this.hRQ.get(i).oq(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void wL(int i) {
        this.gYw = i;
        this.gYR.setCurrentIndex(i);
        zf(i);
        this.gYQ.setText(this.mPrefixData.getPrefixs().get(i));
        bya();
        com.baidu.adp.lib.g.g.a(this.gYR, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gYT.setSelected(false);
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
            l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0036a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Lg();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aU(getApplicationContext())) {
                ai.b(getPageContext(), this.brz);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hUj && System.currentTimeMillis() - this.hUk < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hUj = false;
        }
        if (this.hTx != null && !z) {
            this.hTx.bdC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(String str) {
        if (!k.isEmpty(str) && this.hUg != null) {
            vf(str);
            this.hUg.dismiss();
        }
    }

    private void cw(Context context) {
        hUi = l.aq(context);
    }

    private void vf(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hUj = true;
        bOD();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bOq();
        }
        oF(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4300=4] */
    private static Bitmap d(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!k.isEmpty(str) && i > 0) {
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

    private File bOE() {
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

    private void bOF() {
        if (this.hUd != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cw(getActivity());
            this.hUf = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hUd != null) {
                        WriteActivity.this.ve(WriteActivity.this.hUd.getAbsolutePath());
                    }
                }
            });
            this.hUe = (TbImageView) this.hUf.findViewById(d.g.rec_img_view);
            this.hUh = (LinearLayout) this.hUf.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hUd.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hUd.getAbsolutePath());
                Bitmap d = d(this.hUd.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.hUe.setImageBitmap(d);
                    this.hUe.setDrawBorder(true);
                    this.hUe.setBorderWidth(2);
                    this.hUe.setBorderColor(aj.getColor(d.C0108d.common_color_10264));
                    this.hUg = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hUg.setCanceledOnTouchOutside(true);
                    this.hUg.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hUj) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hUk = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hUg.setContentView(this.hUf);
                    this.hUg.show();
                    Window window = this.hUg.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hUi / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hSV = false;
            this.hSU = "";
            if ("from_content".equals(str)) {
                this.hSU = "from_content";
            } else if ("from_title".equals(str)) {
                this.hSU = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                oD(false);
            }
        }
    }

    public void IR() {
        if (this.hTG || !v.G(this.mList)) {
            this.hSY.setVisibility(0);
            this.hSY.requestFocus();
            this.bpX.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hSY.setVisibility(8);
    }
}
