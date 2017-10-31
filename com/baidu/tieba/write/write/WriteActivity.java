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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, VoiceManager.c, s.a, e.a {
    private static int gWy = 0;
    private i aBl;
    private VoiceData.VoiceModel aCU;
    private String aCV;
    private LocationModel aCW;
    private NewWriteModel aCX;
    private VoiceManager cxA;
    private int fXU;
    private TextView fYo;
    private com.baidu.tieba.write.e fYp;
    private ImageView fYq;
    private View fYr;
    private com.baidu.tieba.write.b gTB;
    private com.baidu.tieba.write.a gTo;
    private LinearLayout gVG;
    private LinearLayout gVH;
    private View gVK;
    private View gVL;
    private Toast gVR;
    private AdditionData gVS;
    private RelativeLayout gVT;
    private TextView gVU;
    private TextView gVV;
    private TextView gVW;
    List<y> gVY;
    y gVZ;
    private HotTopicBussinessData gWD;
    private View gWE;
    private View gWF;
    private TextView gWG;
    private TextView gWH;
    private com.baidu.tieba.write.b.b gWM;
    private com.baidu.tieba.write.b gWO;
    private com.baidu.tieba.view.b gWV;
    private int gWa;
    private String gWb;
    private int gWc;
    private PostCategoryView gWd;
    private d gWe;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gVA = "";
    private boolean gVB = false;
    private WriteData mData = null;
    private boolean gVC = false;
    private boolean gVD = false;
    private boolean gVE = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fYl = null;
    private HeadImageView gVF = null;
    private View fYm = null;
    private LinearLayout bzg = null;
    private EditText bzf = null;
    private FeedBackModel gVI = null;
    private FeedBackTopListView gVJ = null;
    private ArrayList<com.baidu.tieba.write.d> gUD = new ArrayList<>();
    private String epE = null;
    private final KeyEvent gVM = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqh = null;
    private TextView gVN = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gVO = null;
    private final Handler mHandler = new Handler();
    private boolean gVP = false;
    private String gVQ = null;
    private RelativeLayout mParent = null;
    private String aDb = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDd = 0;
    private int gVX = 0;
    private WriteImagesInfo fyx = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gWf = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gWg = null;
    private ScrollView gWh = null;
    private EditText gWi = null;
    private View gWj = null;
    private View gWk = null;
    private View gWl = null;
    private EditText gWm = null;
    private TextView gWn = null;
    private TextView gWo = null;
    private TextWatcher gWp = null;
    private TextWatcher gWq = null;
    private boolean gWr = false;
    private boolean gWs = false;
    private com.baidu.tbadk.core.view.a aLO = null;
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private File gWt = null;
    private TbImageView gWu = null;
    private View gWv = null;
    private Dialog gWw = null;
    private LinearLayout gWx = null;
    private boolean gWz = false;
    private long gWA = -1000;
    private boolean gWB = false;
    private String gSl = "2";
    private boolean gWC = false;
    private String gWI = "";
    private String gWJ = "";
    private int gWK = 0;
    private SpannableStringBuilder gWL = new SpannableStringBuilder();
    private boolean gWN = false;
    private final HttpMessageListener gWP = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.epE)) {
                    WriteActivity.this.epE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nx(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.epE)) {
                    WriteActivity.this.epE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.epE);
                    WriteActivity.this.nx(true);
                }
            }
        }
    };
    private TbFaceManager.a gWQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gi(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kK());
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
    private final AntiHelper.a cys = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahs));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahs));
        }
    };
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ajk();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.gTB.aB(null);
                WriteActivity.this.gTB.ni(false);
                WriteActivity.this.gWO.aB(null);
                WriteActivity.this.gWO.ni(false);
                if (z) {
                    WriteActivity.this.bF(z);
                    if (WriteActivity.this.c(writeData)) {
                        WriteActivity.this.b(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                s.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                s.c(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                s.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            s.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            s.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gWI)) {
                            TiebaStatic.log(new ak("c11731").ac("obj_id", WriteActivity.this.gWI));
                        }
                    }
                    WriteActivity.this.i(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.gTB.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.gWO.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.gTB.tI(postWriteCallBackData.getErrorString());
                    WriteActivity.this.gWO.tI(postWriteCallBackData.getErrorString());
                    if (!v.v(WriteActivity.this.gTB.bCd())) {
                        WriteActivity.this.nr(true);
                        WriteActivity.this.nw(true);
                    }
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.b(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xZ());
                        if (WriteActivity.this.gVE) {
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
    private final LocationModel.a aDm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Dz() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fX(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.buW())) {
                WriteActivity.this.a(2, true, aVar.buW());
            } else {
                fX(null);
            }
        }
    };
    private final CustomMessageListener grt = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aCW.mz(false);
                    WriteActivity.this.aCW.cc(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aCW.mz(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener gWR = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener gWS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bEt = WriteActivity.this.bEt();
            if (bEt >= 0 && bEt < WriteActivity.this.bzf.getText().length()) {
                WriteActivity.this.bzf.setSelection(bEt);
            }
        }
    };
    private boolean gWT = true;
    private final View.OnFocusChangeListener bzm = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fYl || view == WriteActivity.this.aqh || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gWT = true;
                    WriteActivity.this.bEu();
                    if (WriteActivity.this.aBl != null) {
                        WriteActivity.this.aBl.AQ();
                    }
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.fYl);
                } else if (view == WriteActivity.this.fYl) {
                    WriteActivity.this.fYo.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bzf && z) {
                WriteActivity.this.gWT = false;
                WriteActivity.this.bEu();
                WriteActivity.this.aBl.AQ();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.bzf);
            }
        }
    };
    private TextWatcher bzo = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnT();
            if (WriteActivity.this.gWO != null) {
                if (!WriteActivity.this.gWO.bCg()) {
                    WriteActivity.this.nw(false);
                }
                WriteActivity.this.gWO.nj(false);
            }
        }
    };
    private TextWatcher gWU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnT();
            if (WriteActivity.this.gTB != null) {
                if (!WriteActivity.this.gTB.bCg()) {
                    WriteActivity.this.nr(false);
                }
                WriteActivity.this.gTB.nj(false);
            }
        }
    };
    private final a.InterfaceC0124a eTO = new a.InterfaceC0124a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void kW() {
            WriteActivity.this.epE = null;
            WriteActivity.this.nx(false);
            WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aiB)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(boolean z) {
        if (bEL() != null && bEL().getVisibility() == 0 && bEL().getText() != null) {
            int selectionEnd = bEL().getSelectionEnd();
            SpannableStringBuilder b = this.gWO.b(bEL().getText());
            if (b != null) {
                this.gWO.nj(true);
                bEL().setText(b);
                if (z && this.gWO.bCe() >= 0) {
                    bEL().requestFocus();
                    bEL().setSelection(this.gWO.bCe());
                } else {
                    bEL().setSelection(selectionEnd);
                }
                this.gWO.ni(this.gWO.bCe() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (bEK() != null && bEK().getText() != null) {
            int selectionEnd = bEK().getSelectionEnd();
            SpannableStringBuilder b = this.gTB.b(bEK().getText());
            if (b != null) {
                this.gTB.nj(true);
                bEK().setText(b);
                if (z && this.gTB.bCe() >= 0) {
                    bEK().requestFocus();
                    bEK().setSelection(this.gTB.bCe());
                } else {
                    bEK().setSelection(selectionEnd);
                }
                this.gTB.ni(this.gTB.bCe() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dm();
        } else if (this.aCW.bve()) {
            Dk();
        } else {
            this.aCW.mz(false);
            a(1, true, (String) null);
            this.aCW.bvc();
        }
    }

    private void Dm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aCW.WO();
                } else {
                    WriteActivity.this.aDm.Dz();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEt() {
        int selectionEnd = bEK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bEK().getText().getSpans(0, bEK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bEK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bEK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        if (this.aBl != null) {
            this.aBl.setBarLauncherEnabled(!this.gWT);
            this.aBl.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gWr) {
            this.fYl.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gWl.setVisibility(8);
            } else {
                this.gWl.setVisibility(0);
            }
            b(this.gWo, this.gWi);
            b(this.gWn, this.gWm);
            bnT();
        }
        if (this.gVC) {
            this.gWT = true;
            bEu();
            if (this.aBl != null) {
                this.aBl.AQ();
            }
            this.fYl.requestFocus();
            ShowSoftKeyPadDelay(this.fYl);
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
        this.gWO = new com.baidu.tieba.write.b();
        this.gWO.vc(d.C0080d.cp_cont_i);
        this.gWO.vd(d.C0080d.cp_cont_h_alpha85);
        this.gTB = new com.baidu.tieba.write.b();
        this.gTB.vc(d.C0080d.cp_cont_i);
        this.gTB.vd(d.C0080d.cp_cont_h_alpha85);
        initUI();
        bEG();
        this.aCW = new LocationModel(this);
        this.aCW.a(this.aDm);
        registerListener(this.grt);
        registerListener(this.gWR);
        initEditor();
        bEY();
        if (this.gWr) {
            this.gWg.setEditorTools(this.aBl);
        } else {
            this.bzf.requestFocus();
        }
        AS();
        Du();
        this.gTo = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBl = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aBl.setBarMaxLauCount(6);
        } else {
            this.aBl.setBarMaxLauCount(5);
        }
        this.aBl.setMoreButtonAtEnd(true);
        this.aBl.setBarLauncherType(1);
        this.aBl.bw(true);
        this.aBl.setMoreLauncherIcon(d.f.write_more);
        this.aBl.setBackgroundColorId(d.C0080d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bEx();
                break;
            default:
                bEy();
                break;
        }
        this.aBl.CJ();
        if (this.gVG != null) {
            this.gVG.addView(this.aBl);
        }
        bEz();
        this.aBl.lG();
        com.baidu.tbadk.editortools.l eN = this.aBl.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aDb)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDb);
                }
            });
        }
        if (!this.gWr) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBl.AQ();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.bzl = this.mData.getForumName() + getResources().getString(d.j.forum);
        }
        this.aBl.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.aiB);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bEv() {
        this.gWj = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.gWl = this.gWj.findViewById(d.g.live_post_title_container);
        this.gWi = (EditText) this.gWj.findViewById(d.g.live_post_content);
        this.gWf = (GridView) this.gWj.findViewById(d.g.photoLiveGridView);
        this.gWm = (EditText) this.gWj.findViewById(d.g.live_post_title);
        this.gWn = (TextView) this.gWj.findViewById(d.g.titleOverPlusNumber);
        this.gWo = (TextView) this.gWj.findViewById(d.g.contentOverPlusNumber);
        this.gWk = this.gWj.findViewById(d.g.live_interval_view);
        this.gWn.setText(String.valueOf(20));
        this.gWo.setText(String.valueOf(233));
        this.gWj.setVisibility(0);
        this.gWn.setVisibility(0);
        this.gWo.setVisibility(0);
        this.gWm.setHint(d.j.tips_title_limit_new);
        this.gWm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gWs = true;
                    WriteActivity.this.gWT = true;
                    WriteActivity.this.bEu();
                    if (WriteActivity.this.aBl != null) {
                        WriteActivity.this.aBl.AQ();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gWi.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gWi.setHint(d.j.live_write_input_content_update);
        }
        this.gWi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gWs = false;
                    WriteActivity.this.gWT = false;
                    WriteActivity.this.bEu();
                    if (WriteActivity.this.aBl != null) {
                        WriteActivity.this.aBl.AQ();
                    }
                }
            }
        });
        this.gWi.requestFocus();
        this.gWi.addTextChangedListener(bcg());
        this.gWm.requestFocus();
        this.gWm.addTextChangedListener(bcg());
        this.gWm.setOnClickListener(this.gWS);
        this.gWi.setOnClickListener(this.gWS);
        this.gWg = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gWf);
        this.gWg.vr(6);
        this.gWf.setAdapter((ListAdapter) this.gWg);
        View findViewById = this.gWj.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bDK() {
                WriteActivity.this.aJY();
            }
        });
        bEw();
    }

    private void bEw() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gWm.setText(this.mData.getTitle());
                this.gWm.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.gWr) {
            bEU();
        }
        if (this.aBl.CL()) {
            this.aBl.AQ();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", this.aiB);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bEx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBl.A(arrayList);
        r eP = this.aBl.eP(5);
        if (eP != null) {
            eP.aBS = 2;
            eP.aBQ = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBQ = d.f.write_at;
        this.aBl.b(aVar);
        this.aBl.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bEy() {
        CustomResponsedMessage runTask;
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBQ = d.f.write_picture;
            this.aBl.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aBl.b(aVar);
        aVar.aBQ = d.f.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.aBS = 6;
            rVar4.aBQ = d.f.write_privilege;
            this.aBl.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBQ = d.f.write_at;
        this.aBl.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.aBU = true;
            rVar3.aBS = 9;
            rVar3.aBQ = 0;
            this.aBl.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.aBU = true;
            rVar2.aBS = 10;
            rVar2.aBQ = 0;
            this.aBl.b(rVar2);
        }
        Boolean bEP = bEP();
        if (!this.gVC && bEP != null && bEP.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bvy() && n.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aBS = 2;
            rVar.aBQ = d.f.write_recorder;
            this.aBl.b(rVar);
        }
        if (this.gVS == null) {
            if (this.gWM == null) {
                this.gWM = new com.baidu.tieba.write.b.b(getActivity(), this.gSl);
            }
            this.aBl.b(this.gWM);
        }
        this.aBl.A(arrayList);
        r eP = this.aBl.eP(5);
        if (eP != null) {
            eP.aBS = 1;
            eP.aBQ = d.f.write_emotion;
        }
    }

    private void bEz() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bEJ()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bEJ()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bEM();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aCU = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bnT();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aCU = null;
                        WriteActivity.this.bnT();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bEW();
                        WriteActivity.this.bnT();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vF(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gVS == null) {
                            WriteActivity.this.Dn();
                            return;
                        }
                        switch (WriteActivity.this.aDd) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aI(pageActivity)) {
                                    WriteActivity.this.Dl();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Dk();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.epE = null;
                        } else {
                            WriteActivity.this.epE = (String) aVar.data;
                        }
                        WriteActivity.this.nx(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBl.CL()) {
                                        WriteActivity.this.aBl.AQ();
                                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bnT();
                        if (WriteActivity.this.bzf != null) {
                            WriteActivity.this.bzf.requestFocus();
                        }
                        WriteActivity.this.aBl.AQ();
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzf);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gVB = true;
                        WriteActivity.this.ny(true);
                        if (WriteActivity.this.bEL().isFocused()) {
                            WriteActivity.this.gVA = "from_title";
                        } else if (WriteActivity.this.bEK().isFocused()) {
                            WriteActivity.this.gVA = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gVH.setVisibility(0);
                        WriteActivity.this.gVH.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gTo.cj(WriteActivity.this.bcJ(), WriteActivity.this.bES());
                        TiebaStatic.log(new ak("c12258").ac("obj_locate", WriteActivity.this.gSl));
                    }
                }
            }
        };
        this.aBl.a(16, bVar);
        this.aBl.a(14, bVar);
        this.aBl.a(24, bVar);
        this.aBl.a(3, bVar);
        this.aBl.a(10, bVar);
        this.aBl.a(11, bVar);
        this.aBl.a(12, bVar);
        this.aBl.a(13, bVar);
        this.aBl.a(15, bVar);
        this.aBl.a(18, bVar);
        this.aBl.a(25, bVar);
        this.aBl.a(27, bVar);
        this.aBl.a(29, bVar);
        this.aBl.a(43, bVar);
        this.aBl.a(45, bVar);
        this.aBl.a(48, bVar);
        this.aBl.a(46, bVar);
        this.aBl.a(49, bVar);
        this.aBl.a(47, bVar);
        this.aBl.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        if (this.aCW.WK()) {
            if (this.aCW.bve()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bva().getLocationData().buW());
                return;
            }
            a(1, true, (String) null);
            this.aCW.bvc();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bnL() {
        if (this.aCX != null) {
            this.aCX.cancelLoadData();
        }
        if (this.gVI != null) {
            this.gVI.cancelLoadData();
        }
        if (this.aCW != null) {
            this.aCW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bnL();
        bEO();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gTo != null) {
            this.gTo.destroy();
        }
        if (this.gWe != null) {
            this.gWe.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        if (this.mData != null && this.mData.getType() == 2 && this.gVP) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bEL().getText().toString());
            this.mData.setContent(bEK().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    s.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    s.c("24591571", this.mData);
                }
            } else if (type == 1) {
                s.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                s.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                s.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fYp != null && this.fYp.isShowing()) {
                g.a(this.fYp, getPageContext().getPageActivity());
                return true;
            } else if (this.aBl.CL()) {
                this.aBl.AQ();
                return true;
            } else {
                bnL();
                bDT();
                return true;
            }
        }
        if (i == 67 && (text = bEK().getText()) != null) {
            int selectionStart = bEK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bEK().onKeyDown(67, this.gVM);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gWx);
        if (this.gWu != null && i == 1) {
            this.gWu.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0080d.cp_link_tip_a, 1);
        bEu();
        aj.k(this.gWj, d.C0080d.cp_bg_line_d);
        aj.k(this.fYm, d.C0080d.cp_bg_line_c);
        aj.k(this.gWk, d.C0080d.cp_bg_line_c);
        aj.k(bEL(), d.C0080d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.epE)) {
            aj.k(bEK(), d.C0080d.cp_bg_line_d);
        }
        bnT();
        this.aBl.onChangeSkinType(i);
        if (this.gWd != null) {
            this.gWd.wB();
        }
        aj.i(this.mName, d.C0080d.cp_cont_b);
        this.fYl.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.bzf.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        if (this.gTB != null) {
            this.gTB.onChangeSkinType();
        }
        if (this.gWO != null) {
            this.gWO.onChangeSkinType();
        }
    }

    private void initUI() {
        this.aLO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gWr = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aqh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqh.getLayoutParams();
            layoutParams.height = l.f(getPageContext().getPageActivity(), d.e.ds88);
            layoutParams.width = l.f(getPageContext().getPageActivity(), d.e.ds88);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqh != null && (this.aqh.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqh.getLayoutParams();
            layoutParams2.width = l.f(getPageContext().getPageActivity(), d.e.ds88);
            layoutParams2.height = l.f(getPageContext().getPageActivity(), d.e.ds88);
            this.aqh.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.C0080d.cp_cont_b);
        this.gVN = (TextView) findViewById(d.g.btn_image_problem);
        bEA();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.bzm);
        this.gWh = (ScrollView) findViewById(d.g.write_scrollview);
        this.gWh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bzf != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bzf);
                    }
                    if (WriteActivity.this.aBl != null) {
                        WriteActivity.this.aBl.AQ();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gVJ = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.gVK = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.gVG = (LinearLayout) findViewById(d.g.tool_view);
        this.gVG.setContentDescription("..");
        this.gVH = (LinearLayout) findViewById(d.g.title_view);
        this.fYm = findViewById(d.g.interval_view);
        this.gWE = findViewById(d.g.hot_topic_fourm_view);
        this.gWF = findViewById(d.g.hot_topic_divider);
        this.gWG = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.gWH = (TextView) findViewById(d.g.change_one_tv);
        bnS();
        if (this.gWr) {
            this.gWh.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bEv();
        } else {
            this.gWe = new d(getPageContext(), this.mRootView);
            this.gWe.nA(this.mData.getType() == 0);
        }
        VL();
        if (this.gVC || this.gVD) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aic) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bzg = (LinearLayout) findViewById(d.g.post_content_container);
        this.bzg.setDrawingCacheEnabled(false);
        this.bzg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bzf.requestFocus();
                WriteActivity.this.aBl.AQ();
            }
        });
        this.aqh.setOnFocusChangeListener(this.bzm);
        this.aqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bnL();
                WriteActivity.this.bDT();
            }
        });
        this.gVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bED();
        h(bEP());
        bEH();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gVC || this.gVD) {
                    if (this.gVE) {
                        this.mName.setText(d.j.feedback_vcode);
                    } else {
                        this.mName.setText(d.j.feedback);
                    }
                } else {
                    this.mName.setText(d.j.post_new_thread);
                }
                this.fYl.setVisibility(0);
                this.bzf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.j.send_reply);
                this.bzf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fYl.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.j.publish_photo_live);
                this.bzf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gWk.setVisibility(8);
                break;
            case 7:
                this.fYl.setVisibility(0);
                this.bzf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.j.post_drift_bottle);
                break;
        }
        bEI();
        bEN();
        bEu();
        bEF();
        bnR();
        bEQ();
        if (this.mData.getType() == 4 && this.fYr != null && this.gVL != null) {
            this.fYr.setVisibility(8);
            this.gVL.setVisibility(8);
        }
        bnT();
        ShowSoftKeyPad(this.mInputManager, this.fYl);
        bEE();
    }

    private void bEA() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bEB() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gVC && !this.gVD && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bEL() != null) {
                bEL().setText(d);
                bEL().setSelection(d.length());
            }
        }
    }

    private void bEC() {
        this.gVY = null;
        this.gWa = -1;
        this.gWc = -1;
        aa jw = z.ake().jw(1);
        if (jw != null) {
            this.gVY = jw.cAA;
            this.gWa = getIntent().getIntExtra("category_id", -1);
            if (this.gVY != null && !this.gVY.isEmpty() && this.gWa >= 0) {
                this.gVZ = new y();
                this.gVZ.cAw = 0;
                this.gVZ.name = getPageContext().getResources().getString(d.j.category_auto);
                this.gWc = this.gVZ.cAw;
                this.gWb = this.gVZ.name;
                for (y yVar : this.gVY) {
                    if (yVar.cAw == this.gWa) {
                        this.gWc = yVar.cAw;
                        this.gWb = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bED() {
        if (this.gVY != null && !this.gVY.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.gWd = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.gWd.setText(this.gWb);
            this.gWd.b(this.gVY, this.gVZ, this.gWc);
            this.gWd.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.gWd.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.cAw);
                        WriteActivity.this.gWc = atVar.cAw;
                        WriteActivity.this.gWd.bDM();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gWd.bDL();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEK());
                }
            });
        }
    }

    private void bEE() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gWV = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gWV.setTitle(d.j.no_disturb_start_time);
        this.gWV.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.gWV);
        this.gWV.setButton(-2, getPageContext().getString(d.j.cancel), this.gWV);
        return this.gWV;
    }

    private void bEF() {
        this.gVT = (RelativeLayout) findViewById(d.g.addition_container);
        this.gVU = (TextView) findViewById(d.g.addition_create_time);
        this.gVV = (TextView) findViewById(d.g.addition_last_time);
        this.gVW = (TextView) findViewById(d.g.addition_last_content);
        if (this.gVS != null) {
            this.gVT.setVisibility(0);
            this.gVU.setText(getPageContext().getString(d.j.write_addition_create) + am.r(this.gVS.getCreateTime() * 1000));
            if (this.gVS.getAlreadyCount() == 0) {
                this.gVV.setVisibility(8);
            } else {
                this.gVV.setText(getPageContext().getString(d.j.write_addition_last) + am.r(this.gVS.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gVS.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gVW.setText(lastAdditionContent);
            } else {
                this.gVW.setVisibility(8);
            }
            bEK().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.gVS.getAlreadyCount()), Integer.valueOf(this.gVS.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.gVT.setVisibility(8);
    }

    private void bnR() {
        this.fYr = findViewById(d.g.post_prefix_layout);
        this.fYo = (TextView) findViewById(d.g.post_prefix);
        this.gVL = findViewById(d.g.prefix_divider);
        this.fYq = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fYr.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fXU = 1;
            this.fYr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fYo.setVisibility(0);
                    WriteActivity.this.fYr.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fYp, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBl.AQ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fYl);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzf);
                }
            });
            this.fYq = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.fYq.setVisibility(0);
                this.fYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fYo.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fYp, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBl.AQ();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEL());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEK());
                    }
                });
            }
            this.fYp = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.fYp.a(this);
            this.fYp.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.fYp.setOutsideTouchable(true);
            this.fYp.setFocusable(true);
            this.fYp.setOnDismissListener(this);
            this.fYp.setBackgroundDrawable(aj.getDrawable(d.C0080d.cp_bg_line_d));
            int color = aj.getColor(d.C0080d.cp_cont_b);
            int color2 = aj.getColor(d.C0080d.cp_cont_c);
            aj.j(this.fYo, d.C0080d.cp_bg_line_d);
            aj.c(this.fYq, d.f.icon_frs_arrow_n);
            this.fYo.setTextColor(color);
            this.gUD.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.gUD.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.fYp.addView(dVar);
            }
            this.fYp.setCurrentIndex(0);
            this.fYo.setText(prefixs.get(1));
            vB(1);
            return;
        }
        this.fYr.setVisibility(8);
    }

    private void bEG() {
        if (this.gVC && this.mData != null) {
            this.gVJ.setVisibility(0);
            this.gVK.setVisibility(0);
            this.gVI = new FeedBackModel(this);
            this.gVI.ub(this.mData.getForumName());
            this.gVI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gVJ.setVisibility(8);
                        WriteActivity.this.gVK.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gVJ.setVisibility(8);
                        WriteActivity.this.gVK.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gVJ.a(feedBackModel.bEm(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bEH() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.hh()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.gWO.bCf()) {
                        WriteActivity.this.showToast(WriteActivity.this.gWO.bCh());
                        WriteActivity.this.nw(true);
                    } else if (WriteActivity.this.gTB.bCf()) {
                        WriteActivity.this.showToast(WriteActivity.this.gTB.bCh());
                        WriteActivity.this.nr(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEL());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEK());
                        WriteActivity.this.aBl.AQ();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.gVC) {
                                WriteActivity.this.bDU();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                if (WriteActivity.this.gTo.bCb()) {
                                    WriteActivity.this.bET();
                                } else {
                                    WriteActivity.this.gWC = true;
                                    WriteActivity.this.gTo.cj(WriteActivity.this.bcJ(), WriteActivity.this.bES());
                                }
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bDU();
                        }
                        TiebaStatic.log(new ak("c12262").ac("obj_locate", WriteActivity.this.gSl));
                    }
                }
            }
        });
    }

    protected void bEI() {
        this.gVO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gVO.cS(getPageContext().getString(d.j.is_save_draft)).ao(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bEL().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bEK().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    s.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    s.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    s.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    s.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.gVO.b(getPageContext());
    }

    protected void bnS() {
        this.gVF = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.gVF.setIsRound(true);
        this.gVF.setDrawBorder(false);
        this.gVF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dE = o.dE(currentPortrait);
            this.gVF.setUrl(dE);
            this.gVF.startLoad(dE, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gVF.setVisibility(0);
        }
        this.fYl = (EditText) findViewById(d.g.post_title);
        this.fYl.setOnClickListener(this.gWS);
        this.fYl.setOnFocusChangeListener(this.bzm);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fYl.setText(this.mData.getTitle());
                this.fYl.setSelection(this.mData.getTitle().length());
            } else if (this.gVE) {
                this.fYl.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fYl.addTextChangedListener(this.bzo);
        if (!this.mData.getHaveDraft()) {
            bEB();
            this.gWB = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fYl.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.fYl.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bcg() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            private int bzr;
            private EditText dMk = null;
            private TextView abE = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bnT();
                if (WriteActivity.this.gWr) {
                    this.bzr = this.dMk.getSelectionStart();
                    this.dMk.setSelection(this.bzr);
                    WriteActivity.this.b(this.abE, this.dMk);
                }
                if (this.dMk != WriteActivity.this.gWm || WriteActivity.this.gWO == null || WriteActivity.this.gWO.bCg()) {
                    if (this.dMk == WriteActivity.this.gWi && WriteActivity.this.gTB != null && !WriteActivity.this.gTB.bCg()) {
                        WriteActivity.this.nr(false);
                    }
                } else {
                    WriteActivity.this.nw(false);
                }
                if (WriteActivity.this.gWO != null) {
                    WriteActivity.this.gWO.nj(false);
                }
                if (WriteActivity.this.gTB != null) {
                    WriteActivity.this.gTB.nj(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gWr || !WriteActivity.this.gWs) {
                    if (WriteActivity.this.gWr) {
                        if (this.dMk != WriteActivity.this.gWi || this.abE != WriteActivity.this.gWo) {
                            this.dMk = WriteActivity.this.gWi;
                            this.abE = WriteActivity.this.gWo;
                        }
                    }
                } else if (this.dMk != WriteActivity.this.gWm || this.abE != WriteActivity.this.gWn) {
                    this.dMk = WriteActivity.this.gWm;
                    this.abE = WriteActivity.this.gWn;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gWr && this.gWs) {
            if (this.gWp != null) {
                this.gWm.removeTextChangedListener(this.gWp);
            }
            this.gWp = textWatcher;
        } else if (this.gWr) {
            if (this.gWq != null) {
                this.gWi.removeTextChangedListener(this.gWq);
            }
            this.gWq = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.gWi) {
            return 233L;
        }
        if (editText != this.gWm) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long h = j - h(editText);
            String valueOf = String.valueOf(h);
            if (j == 20) {
                if (h < 0) {
                    if (h < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0080d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                }
            } else if (h < 0) {
                if (h < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0080d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long h(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void VL() {
        this.bzf = (EditText) findViewById(d.g.post_content);
        this.bzf.setDrawingCacheEnabled(false);
        this.bzf.setOnClickListener(this.gWS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.Ef().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.bzf.setText(T);
            this.bzf.setSelection(T.length());
        } else if (this.mData.getType() == 2) {
            if (this.gVP) {
                if (this.gVQ != null && this.gVQ.length() > 0) {
                    this.bzf.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.gVQ}));
                    this.bzf.setSelection(this.bzf.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bzf.setText(format);
                this.bzf.setSelection(format.length());
            }
        }
        this.bzf.setOnFocusChangeListener(this.bzm);
        this.bzf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bzf.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bzf.addTextChangedListener(this.gWU);
        if (this.mData.getType() == 0) {
            this.gWN = true;
        } else {
            nx(true);
            this.gWN = false;
        }
        if (this.mData.isUserFeedback()) {
            this.bzf.setHint(d.j.write_input_content);
        } else {
            this.bzf.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nx(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gWr) {
            bEK().setPadding(0, 0, 0, 0);
            bEK().setBackgroundDrawable(null);
            aj.k(bEK(), d.C0080d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.epE) && this.gVS == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.epE, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass28) aVar, str, i);
                        if (aVar != null && aVar.kK() != null && aVar.kO() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kK(), aVar.kK().getNinePatchChunk(), aVar.kO(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bEK().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bEK(), true, WriteActivity.this.eTO);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEJ() {
        int i = 5000;
        if (this.gVS != null) {
            i = 1000;
        }
        return bEK().getText() != null && bEK().getText().length() >= i;
    }

    private void fN(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gVA)) {
                this.gVA = "";
                bEK().requestFocus();
                if (bEK().getText() != null && bEK().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bEK().getSelectionStart();
                    editable = bEK().getText();
                }
            } else if ("from_title".equals(this.gVA)) {
                this.gVA = "";
                bEL().requestFocus();
                if (bEL().getText() != null && bEL().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bEL().getSelectionStart();
                    editable = bEL().getText();
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
    public void ny(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bEK().getText().getSpans(0, bEK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gVR == null) {
                this.gVR = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.gVR.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType xR = lVar.xR();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass30) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bEK().getSelectionStart(), aVar, xR);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bEK() != null && bEK().getText() != null) {
            Bitmap kK = aVar.kK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
            int width = kK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bEK().getSelectionStart() - 1;
                if (bEK().getText().length() > 1 && selectionStart >= 0 && bEK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bEK().getText().insert(bEK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bEK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bEK().getText().insert(bEK().getSelectionStart(), spannableString2);
            }
            Editable text = bEK().getText();
            if (text != null) {
                this.gWL.clear();
                this.gWL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gWL);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bEK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bEK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bEK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bEK() {
        return this.gWr ? this.gWi : this.bzf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bEL() {
        return this.gWr ? this.gWm : this.fYl;
    }

    protected void bEM() {
        Editable text;
        if (bEK() != null && (text = bEK().getText()) != null) {
            int selectionStart = bEK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bEK().onKeyDown(67, this.gVM);
            }
            bEK().onKeyDown(67, this.gVM);
            int selectionStart2 = bEK().getSelectionStart();
            if (text != null) {
                this.gWL.clear();
                this.gWL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gWL);
                bEK().setSelection(selectionStart2);
            }
        }
    }

    private void h(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.gVC = true;
        }
    }

    private void bEN() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bEO() {
        try {
            if (this.gVO != null) {
                this.gVO.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLO.c(null);
        this.aLO.db(d.j.sending);
        this.aLO.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLO.aE(false);
    }

    private Boolean bEP() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDb = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bEL() != null) {
                str = bEL().getText().toString();
            }
            if (bEK() != null) {
                str2 = bEK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fXU == 0) {
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
                if (!this.gWr) {
                    dk(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dk(true);
                }
            }
            if (this.mData.getType() == 4) {
                dk(l(this.gWi) && k(this.gWm));
            } else if (this.mData.getType() == 5) {
                dk(l(this.gWi));
            } else if (!TextUtils.isEmpty(str2) || this.aCU != null) {
                dk(true);
            } else if (this.mData.getVideoInfo() != null) {
                dk(true);
            } else {
                dk(false);
            }
        }
    }

    private void dk(boolean z) {
        if (z) {
            aj.b(this.mPost, d.C0080d.cp_link_tip_a, d.C0080d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.C0080d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean k(EditText editText) {
        long h = h(editText);
        return h <= 20 && h > 0;
    }

    private boolean l(EditText editText) {
        long h = h(editText);
        if (h > 233) {
            return false;
        }
        return h > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aCX = new NewWriteModel(this);
        this.aCX.b(this.aDo);
        registerListener(this.gWP);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bnL();
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
            this.gVC = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gVE = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gVP = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gVQ = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aCV = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString(WriteActivityConfig.ADDITION_DATA);
            if (!StringUtils.isNull(string2)) {
                this.gVS = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.gVS != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.gVX = bundle.getInt("mem_type", 0);
            this.aiB = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gWI = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gSl = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gVC = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gVE = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gVP = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gVQ = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gVS = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gVS != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gVX = intent.getIntExtra("mem_type", 0);
            this.aiB = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gWI = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gSl = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gVC);
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
                s.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                s.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            s.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            s.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            s.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.epE = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gVD = true;
        }
        bEC();
        try {
            this.gWt = bEX();
        } catch (Throwable th) {
            this.gWt = null;
        }
    }

    private void bEQ() {
        if (v.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gVF.setVisibility(8);
            this.gWE.setVisibility(0);
            this.gWF.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fYl.setText(com.baidu.tbadk.plugins.a.gF(uc(this.mList.get(0).mTopicName)));
                this.fYl.setMovementMethod(com.baidu.tieba.view.c.bBh());
            }
            this.gWG.setText(this.mList.get(0).mForumName);
            this.fYl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gWJ.equals(charSequence.toString())) {
                        WriteActivity.this.gWK = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gF;
                    if (!WriteActivity.this.gWJ.equals(editable.toString()) && (gF = com.baidu.tbadk.plugins.a.gF(editable.toString())) != null) {
                        WriteActivity.this.gWJ = gF.toString();
                        WriteActivity.this.fYl.setText(gF);
                        if (WriteActivity.this.gWK <= WriteActivity.this.fYl.getText().length()) {
                            WriteActivity.this.fYl.setSelection(WriteActivity.this.gWK);
                        }
                    }
                }
            });
            this.gWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
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
            SpannableString gF = com.baidu.tbadk.plugins.a.gF(uc(hotTopicBussinessData.mTopicName));
            if (gF != null) {
                this.fYl.setText(gF);
            }
            this.gWG.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uc(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.s.a
    public void a(WriteData writeData) {
        String uc;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!k.isEmpty(writeData.getTitle())) {
                    this.gVH.setVisibility(0);
                    this.gVH.requestFocus();
                    this.aBl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (k.isEmpty(bEL().getText().toString()) || this.gWB || ((this.gVC || this.gVD) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            uc = this.mData.getTitle();
                        } else {
                            uc = uc(str);
                        }
                        SpannableString gF = com.baidu.tbadk.plugins.a.gF(uc);
                        if (gF != null) {
                            bEL().setText(gF);
                            bEL().setSelection(gF.length() > uc.length() ? uc.length() : gF.length());
                        }
                    } else {
                        SpannableString gF2 = com.baidu.tbadk.plugins.a.gF(this.mData.getTitle());
                        if (gF2 != null) {
                            bEL().setText(gF2);
                            bEL().setSelection(this.mData.getTitle().length() > gF2.length() ? gF2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bEB();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bEK().getText().toString()) || this.gVC || this.gVD) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ef().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gWQ);
                    bEK().setText(a2);
                    bEK().setSelection(a2.length());
                    if (this.gWr) {
                        b(this.gWo, this.gWi);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bEW();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Du();
                    }
                    nz(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bER();
                }
                bnT();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gVY != null) {
                    this.gWc = this.gVZ.cAw;
                    this.gWb = this.gVZ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gVY.size()) {
                            break;
                        }
                        y yVar = this.gVY.get(i);
                        if (categoryTo != yVar.cAw) {
                            i++;
                        } else {
                            this.gWc = categoryTo;
                            this.gWb = yVar.name;
                            this.mData.setCategoryTo(this.gWc);
                            break;
                        }
                    }
                    if (this.gWd != null) {
                        this.gWd.setText(this.gWb);
                        this.gWd.b(this.gVY, this.gVZ, this.gWc);
                    }
                }
                this.aBl.AQ();
                return;
            }
            return;
        }
        bER();
        bEB();
    }

    private void bER() {
        if ((!this.gWr || this.gWg != null) && this.gWf != null) {
            this.gWg.c(this.writeImagesInfo);
            aJY();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gVP);
        if (this.gVC) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCV);
        if (this.gVS != null) {
            bundle.putString(WriteActivityConfig.ADDITION_DATA, OrmObject.jsonStrWithObject(this.gVS));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.gVX);
        bundle.putString("from", this.aiB);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gSl);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bEK().getEditableText().toString();
        if (obj != null) {
            bEK().setText(TbFaceManager.Ef().a(getPageContext().getPageActivity(), obj, this.gWQ));
            bEK().setSelection(bEK().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bES() {
        return (bEK() == null || bEK().getText() == null) ? "" : bEK().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcJ() {
        if (this.mData == null || bEL() == null || bEL().getText() == null) {
            return "";
        }
        String obj = bEL().getText().toString();
        if (this.mPrefixData != null && v.u(this.mPrefixData.getPrefixs()) > 0 && this.fXU != 0 && this.mData.getType() != 4 && this.fYo != null && this.fYo.getText() != null) {
            obj = this.fYo.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        bnL();
        this.mData.setContent(bES());
        this.mData.setTitle(bcJ());
        if (this.gVC || this.gVD) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
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
                if (j.hh()) {
                    sb.append(j.hp());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gWa >= 0) {
            this.mData.setCategoryFrom(this.gWa);
        }
        if (this.gWc >= 0) {
            this.mData.setCategoryTo(this.gWc);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aCW != null && this.aCW.WK());
        this.aCX.mB(this.writeImagesInfo.size() > 0);
        if (!v.v(this.mList) && this.gWD != null && this.gWD.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gWD.mForumId));
            this.mData.setForumName(this.gWD.mForumName);
        }
        this.aCX.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aCU != null) {
            if (this.aCU.getId() != null) {
                this.aCX.getWriteData().setVoice(this.aCU.getId());
                this.aCX.getWriteData().setVoiceDuringTime(this.aCU.duration);
            } else {
                this.aCX.getWriteData().setVoice(null);
                this.aCX.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aCX.getWriteData().setVoice(null);
            this.aCX.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aCX.bvz()) {
            showToast(d.j.write_img_limit);
        } else if (!j.hh()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.aCX.startPostWrite();
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
            if (this.gVS != null) {
                i2 = this.gVS.getTotalCount();
                i = this.gVS.getAlreadyCount() + 1;
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

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aBl != null && !this.aBl.CL()) {
                    bEK().requestFocus();
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
                            bEK().getText().insert(bEK().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    s.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    s.d(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    s.c(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                i(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bdE();
                            } else {
                                ad(intent);
                            }
                        } else if (intExtra == 1) {
                            T(intent);
                        } else {
                            ac(intent);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.gWN) {
                            nx(true);
                            this.gWN = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gWr) {
                        A(intent);
                        bnT();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bnT();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gVB) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gVB = false;
                            }
                            sb2.append(stringExtra);
                            fN(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.v(this.mList)) {
                    if (!v.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gWD = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gWD);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gTo.aa(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.bzl = this.gTo.bCa();
                        this.aBl.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gWC) {
                        bET();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aBl != null && !this.aBl.CL()) {
                this.bzf.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dq();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bEV();
                    if (this.gWN) {
                        nx(true);
                        this.gWN = false;
                        return;
                    }
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA)) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.gTB.aB(postWriteCallBackData.getSensitiveWords());
                        this.gWO.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.v(this.gTB.bCd())) {
                            nr(true);
                            nw(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.aCV = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aCV);
                    return;
                case 12012:
                    bEV();
                    return;
                case 25004:
                    if ("from_title".equals(this.gVA)) {
                        bEL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gVA)) {
                        bEK().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gTo.bBZ());
        this.mData.setCallFrom(this.gSl);
        this.mData.setRecommendExt(this.gTo.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bDU();
    }

    private void bEU() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bEV() {
        if (this.gWr) {
            this.gWg.c(this.writeImagesInfo);
            aJY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJY() {
        this.gWg.notifyDataSetChanged();
        this.gWf.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gWg.notifyDataSetChanged();
                WriteActivity.this.gWf.invalidateViews();
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
        bnT();
    }

    private void ac(Intent intent) {
        if (this.gWr) {
            af(intent);
            bEV();
        } else {
            ag(intent);
        }
        bnT();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bEV();
            nz(true);
        }
    }

    private void ad(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bdE() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fyx.parseJson(stringExtra);
            this.fyx.updateQuality();
            if (this.fyx.getChosedFiles() != null && this.fyx.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fyx.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fyx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bEL());
        HidenSoftKeyPad(this.mInputManager, bEK());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ag(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aCV = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCV;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ac(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCV, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bEW();
            Du();
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
                bEW();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Du();
                }
            }
            nz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEW() {
        if (this.aBl.eP(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Dq() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aCV));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nz(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.gWe != null) {
            this.gWe.a(this.writeImagesInfo, this.aiB, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cxA == null) {
            this.cxA = VoiceManager.instance();
        }
        return this.cxA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ajk() {
        this.cxA = getVoiceManager();
        this.cxA.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tW(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cys) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahs));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gVS == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDd = i;
        if (this.aBl != null) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aBl.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Du() {
        if (!this.gWr) {
            if (this.aBl != null) {
                this.aBl.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.gWe != null) {
                this.gWe.a(this.writeImagesInfo, this.aiB, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aBl != null) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vB(int i) {
        if (i < this.gUD.size()) {
            for (int i2 = 0; i2 < this.gUD.size(); i2++) {
                this.gUD.get(i2).nl(false);
            }
            this.gUD.get(i).nl(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void tj(int i) {
        this.fXU = i;
        this.fYp.setCurrentIndex(i);
        vB(i);
        this.fYo.setText(this.mPrefixData.getPrefixs().get(i));
        bnT();
        g.a(this.fYp, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fYr.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dl();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.aCV);
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
        if (this.gWz && System.currentTimeMillis() - this.gWA < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gWz = false;
        }
        if (this.gWM != null && !z) {
            this.gWM.aUy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(String str) {
        if (!k.isEmpty(str) && this.gWw != null) {
            ue(str);
            this.gWw.dismiss();
        }
    }

    private void ca(Context context) {
        gWy = l.ae(context);
    }

    private void ue(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gWz = true;
        bEW();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Du();
        }
        nz(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4035=4] */
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

    private File bEX() {
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

    private void bEY() {
        if (this.gWt != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ca(getActivity());
            this.gWv = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.gWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gWt != null) {
                        WriteActivity.this.ud(WriteActivity.this.gWt.getAbsolutePath());
                    }
                }
            });
            this.gWu = (TbImageView) this.gWv.findViewById(d.g.rec_img_view);
            this.gWx = (LinearLayout) this.gWv.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gWt.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gWt.getAbsolutePath());
                Bitmap d = d(this.gWt.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.gWu.setImageBitmap(d);
                    this.gWu.setDrawBorder(true);
                    this.gWu.setBorderWidth(2);
                    this.gWu.setBorderColor(aj.getColor(d.C0080d.common_color_10264));
                    this.gWw = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.gWw.setCanceledOnTouchOutside(true);
                    this.gWw.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gWz) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gWA = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gWw.setContentView(this.gWv);
                    this.gWw.show();
                    Window window = this.gWw.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (gWy / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.gVB = false;
            this.gVA = "";
            if ("from_content".equals(str)) {
                this.gVA = "from_content";
            } else if ("from_title".equals(str)) {
                this.gVA = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                ny(false);
            }
        }
    }

    public void AS() {
        if (this.gVC || !v.v(this.mList)) {
            this.gVH.setVisibility(0);
            this.gVH.requestFocus();
            this.aBl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gVH.setVisibility(8);
    }
}
