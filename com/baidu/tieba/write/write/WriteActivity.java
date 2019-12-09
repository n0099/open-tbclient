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
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
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
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.c;
import com.baidu.tieba.write.h;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0055a, VoiceManager.c, v.a, h.a {
    private static int jUv = 0;
    private EditorTools cEt;
    private String cFX;
    private LocationModel cFY;
    private NewWriteModel cFZ;
    private String fsI;
    private String fsJ;
    private String fsK;
    private VoiceManager fuw;
    private LinearLayout hPG;
    private PlayVoiceBntNew hPH;
    private ImageView hPJ;
    private int iXI;
    private TextView iYg;
    private com.baidu.tieba.write.h iYh;
    private ImageView iYi;
    private View iYj;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jRr;
    private HotTopicBussinessData jTB;
    private TextView jTC;
    private com.baidu.tieba.write.editor.b jTE;
    private e jTG;
    private com.baidu.tieba.view.b jTN;
    private View jTW;
    private LinearLayout jTi;
    private LinearLayout jTj;
    private View jTl;
    private Toast jTn;
    private AdditionData jTo;
    private RelativeLayout jTp;
    private TextView jTq;
    private TextView jTr;
    private TextView jTs;
    List<com.baidu.tieba.frs.v> jTt;
    com.baidu.tieba.frs.v jTu;
    private int jTv;
    private String jTw;
    private int jTx;
    private PostCategoryView jTy;
    private View jUA;
    private TextView jUB;
    private com.baidu.tieba.c.d jUD;
    private g jUd;
    private View jUz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jTf = "";
    private boolean jTg = false;
    private WriteData iXH = null;
    private boolean jTS = false;
    private boolean jTh = false;
    private boolean jTT = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iYa = null;
    private HeadImageView jTU = null;
    private View iYb = null;
    private LinearLayout iYd = null;
    private EditText iYe = null;
    private FeedBackModel jTk = null;
    private FeedBackTopListView jTV = null;
    private ArrayList<WritePrefixItemLayout> jTm = new ArrayList<>();
    private String hnC = null;
    private final KeyEvent fgG = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jTX = null;
    private TextView iYf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener flB = null;
    private com.baidu.tbadk.core.dialog.a jTY = null;
    private final Handler mHandler = new Handler();
    private boolean jTZ = false;
    private String jUa = null;
    private RelativeLayout gyn = null;
    private String cGe = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int cGf = 0;
    private int jUb = 0;
    private WriteImagesInfo jUc = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jUe = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jUf = null;
    private ScrollView jTz = null;
    private EditText jUg = null;
    private View jUh = null;
    private View jUi = null;
    private View jUj = null;
    private EditText jUk = null;
    private TextView jUl = null;
    private TextView jUm = null;
    private TextWatcher jUn = null;
    private TextWatcher jUo = null;
    private boolean jTA = false;
    private boolean jUp = false;
    private com.baidu.tbadk.core.view.b cNJ = null;
    private String mFrom = "write";
    private File jUq = null;
    private TbImageView jUr = null;
    private View jUs = null;
    private Dialog jUt = null;
    private LinearLayout jUu = null;
    private boolean jUw = false;
    private long jUx = -1000;
    private boolean jUy = false;
    private String fUk = "2";
    private int apf = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jTD = new SpannableStringBuilder();
    private boolean jUC = false;
    private boolean aii = false;
    private final b jTF = new b();
    private final HttpMessageListener jUE = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hnC)) {
                    WriteActivity.this.hnC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rX(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hnC)) {
                    WriteActivity.this.hnC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hnC);
                    WriteActivity.this.rX(true);
                }
            }
        }
    };
    private TbFaceManager.a jTH = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pW(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.g(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a fvK = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bki();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.iXH != null) {
                WriteActivity.this.jTF.aM(null);
                if (z) {
                    WriteActivity.this.fm(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.iXH.getType() != 0 && WriteActivity.this.iXH.getType() != 9) {
                        if (WriteActivity.this.iXH.getType() != 7) {
                            if (WriteActivity.this.iXH.getType() == 1) {
                                v.d(WriteActivity.this.iXH.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.iXH.getType() == 5) {
                                v.d(WriteActivity.this.iXH.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.iXH.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").bS("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.jTF.aM(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jTF.Fv(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jTF.b(WriteActivity.this.iYa, WriteActivity.this.iYe);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aps());
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr());
                        if (WriteActivity.this.jTT) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cGm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void auN() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.coS())) {
                WriteActivity.this.b(2, true, aVar.coS());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.cFY.qT(false);
                    WriteActivity.this.cFY.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.cFY.qT(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jTI = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jTJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int czo = WriteActivity.this.czo();
            if (czo >= 0 && czo < WriteActivity.this.iYe.getText().length()) {
                WriteActivity.this.iYe.setSelection(czo);
            }
        }
    };
    private boolean jTK = true;
    private final View.OnFocusChangeListener iXY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iYa || view == WriteActivity.this.mBack || view == WriteActivity.this.iYf) {
                if (z) {
                    WriteActivity.this.jTK = true;
                    WriteActivity.this.czp();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.iYa);
                    if (WriteActivity.this.cEt != null) {
                        WriteActivity.this.cEt.asA();
                    }
                } else if (view == WriteActivity.this.iYa) {
                    WriteActivity.this.iYg.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iYe && z) {
                WriteActivity.this.jTK = false;
                WriteActivity.this.czp();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.iYe);
                if (WriteActivity.this.cEt != null) {
                    WriteActivity.this.cEt.asA();
                }
            }
            WriteActivity.this.czv();
        }
    };
    private TextWatcher jTL = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jTP = "";
        private String jTQ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTQ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTQ != null ? this.jTQ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.clh();
            WriteActivity.this.czw();
            EditText czH = WriteActivity.this.czH();
            if (editable != null && czH != null && czH.getText() != null) {
                if (this.jTP == null || !this.jTP.equals(editable.toString())) {
                    if (WriteActivity.this.jTF != null) {
                        this.jTP = czH.getText().toString();
                        WriteActivity.this.jTF.m(czH);
                        return;
                    }
                    return;
                }
                czH.setSelection(czH.getSelectionEnd());
            }
        }
    };
    private TextWatcher jTM = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jTQ;
        private String jTR = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTQ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTQ != null ? this.jTQ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.clh();
            EditText czG = WriteActivity.this.czG();
            if (editable != null && czG != null && czG.getText() != null) {
                if (this.jTR == null || !this.jTR.equals(editable.toString())) {
                    if (WriteActivity.this.jTF != null) {
                        this.jTR = czG.getText().toString();
                        WriteActivity.this.jTF.m(czG);
                        return;
                    }
                    return;
                }
                czG.setSelection(czG.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0513a hWz = new a.InterfaceC0513a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0513a
        public void onRefresh() {
            WriteActivity.this.hnC = null;
            WriteActivity.this.rX(false);
            WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void auz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auB();
        } else if (this.cFY.coZ()) {
            auy();
        } else {
            this.cFY.qT(false);
            b(1, true, null);
            this.cFY.coX();
        }
    }

    public void czQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jTE != null) {
                this.jTE.cyt();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auB();
        } else if (this.cFY != null) {
            this.cFY.qT(false);
            b(1, true, null);
            this.cFY.coX();
        }
    }

    private void auB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.cFY.cpb();
                } else {
                    WriteActivity.this.cGm.auN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czo() {
        int selectionEnd = czG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) czG().getText().getSpans(0, czG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = czG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = czG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czp() {
        if (this.cEt != null) {
            this.cEt.setBarLauncherEnabled(!this.jTK);
            this.cEt.setBarLauncherEnabled(true, 26);
            this.cEt.setBarLauncherEnabled(true, 2);
            V(9, this.jTK ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g jH;
        if (this.cEt != null && (jH = this.cEt.jH(i)) != null) {
            if (z) {
                jH.le();
            } else {
                jH.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jTA) {
            this.iYa.setVisibility(8);
            if (this.iXH.getType() == 5) {
                this.jUj.setVisibility(8);
            } else {
                this.jUj.setVisibility(0);
            }
            a(this.jUm, this.jUg);
            a(this.jUl, this.jUk);
            clh();
        }
        if (this.jTS) {
            this.jTK = true;
            czp();
            if (this.cEt != null) {
                this.cEt.asA();
            }
            this.iYa.requestFocus();
            ShowSoftKeyPadDelay(this.iYa);
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
            cAf();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                czP();
            }
            rY(true);
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
        if (this.iXH.getType() == 0) {
            BM(this.apf);
        }
        initUI();
        czV();
        this.cFY = new LocationModel(this);
        this.cFY.a(this.cGm);
        registerListener(this.jjZ);
        registerListener(this.jTI);
        bLK();
        cAi();
        if (this.jTA) {
            this.jUf.setEditorTools(this.cEt);
        } else {
            this.iYe.requestFocus();
        }
        cgy();
        czP();
        cAg();
    }

    @SuppressLint({"ResourceAsColor"})
    private void bLK() {
        this.cEt = new EditorTools(getActivity());
        this.cEt.setBarMaxLauCount(5);
        this.cEt.setMoreButtonAtEnd(true);
        this.cEt.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.cEt.setBarLauncherType(1);
        this.cEt.fe(true);
        this.cEt.ff(true);
        switch (this.iXH.getType()) {
            case 4:
            case 5:
                czT();
                break;
            default:
                czq();
                break;
        }
        this.cEt.build();
        if (this.jTi != null) {
            this.jTi.addView(this.cEt);
        }
        czr();
        this.cEt.le();
        com.baidu.tbadk.editortools.g jH = this.cEt.jH(6);
        if (jH != null && !TextUtils.isEmpty(this.cGe)) {
            ((View) jH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.cGe);
                }
            });
        }
        if (!this.jTA) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cEt.asA();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        czt();
    }

    private void czR() {
        this.jUh = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jUj = this.jUh.findViewById(R.id.live_post_title_container);
        this.jUg = (EditText) this.jUh.findViewById(R.id.live_post_content);
        this.jUe = (GridView) this.jUh.findViewById(R.id.photoLiveGridView);
        this.jUk = (EditText) this.jUh.findViewById(R.id.live_post_title);
        this.jUl = (TextView) this.jUh.findViewById(R.id.titleOverPlusNumber);
        this.jUm = (TextView) this.jUh.findViewById(R.id.contentOverPlusNumber);
        this.jUi = this.jUh.findViewById(R.id.live_interval_view);
        this.jUl.setText(String.valueOf(20));
        this.jUm.setText(String.valueOf(233));
        this.jUh.setVisibility(0);
        this.jUl.setVisibility(0);
        this.jUm.setVisibility(0);
        this.jUk.setHint(R.string.tips_title_limit_new);
        this.jUk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jUp = true;
                    WriteActivity.this.jTK = true;
                    WriteActivity.this.czp();
                    if (WriteActivity.this.cEt != null) {
                        WriteActivity.this.cEt.asA();
                    }
                }
            }
        });
        if (this.iXH.getType() == 4) {
            this.jUg.setHint(R.string.live_write_input_content_new);
        } else if (this.iXH.getType() == 5) {
            this.jUg.setHint(R.string.live_write_input_content_update);
        }
        this.jUg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jUp = false;
                    WriteActivity.this.jTK = false;
                    WriteActivity.this.czp();
                    if (WriteActivity.this.cEt != null) {
                        WriteActivity.this.cEt.asA();
                    }
                }
            }
        });
        this.jUg.requestFocus();
        this.jUg.addTextChangedListener(IX());
        this.jUk.requestFocus();
        this.jUk.addTextChangedListener(IX());
        this.jUk.setOnClickListener(this.jTJ);
        this.jUg.setOnClickListener(this.jTJ);
        this.jUf = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jUe);
        this.jUf.BG(6);
        this.jUe.setAdapter((ListAdapter) this.jUf);
        View findViewById = this.jUh.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cza() {
                WriteActivity.this.cAd();
            }
        });
        czS();
    }

    private void czS() {
        if (this.iXH.getType() == 0) {
            if (this.iXH.getTitle() != null) {
                this.jUk.setText(this.iXH.getTitle());
                this.jUk.setSelection(this.iXH.getTitle().length());
                return;
            }
            return;
        }
        if (this.iXH.getType() == 1 || this.iXH.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jTA) {
            cAb();
        }
        if (this.cEt.atZ()) {
            this.cEt.asA();
        }
        BM(0);
    }

    private void BM(int i) {
        if (this.writeImagesInfo != null && this.iXH != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.iXH.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.iXH.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fUk);
            albumActivityConfig.setProfessionZone(this.iXH.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void czT() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.cEt.aC(arrayList);
        com.baidu.tbadk.editortools.k jK = this.cEt.jK(5);
        if (jK != null) {
            jK.cFe = 2;
        }
        this.cEt.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.cEt.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void czq() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.cEt.b(dVar);
        }
        Boolean czZ = czZ();
        if (!this.jTS && czZ != null && czZ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cpB() && r.b(this.iXH.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.cFe = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cEt.b(kVar5);
            }
        }
        this.cEt.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.cFe = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cEt.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.cFe = 6;
            kVar3.cFa = this.jTS ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.cEt.b(kVar3);
        }
        this.cEt.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.cFg = true;
            kVar2.cFe = 9;
            kVar2.cFa = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cEt.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.cFg = true;
            kVar.cFe = 10;
            kVar.cFa = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cEt.b(kVar);
            }
        }
        if (this.jTo == null) {
            if (this.jTE == null) {
                this.jTE = new com.baidu.tieba.write.editor.b(getActivity(), this.fUk);
                this.jTE.bq(this.iXH.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jTE.cyp();
                this.jTE.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                czQ();
            }
            this.cEt.b(this.jTE);
        }
        this.cEt.aC(arrayList);
        com.baidu.tbadk.editortools.k jK = this.cEt.jK(5);
        if (jK != null) {
            jK.cFe = 1;
        }
    }

    private void czs() {
        if (this.jTG != null) {
            this.jTG.hideTip();
        }
    }

    private void czt() {
        if (this.jTG == null) {
            this.jTG = new e(getPageContext());
        }
        this.jTG.c(this.cEt);
    }

    private void czr() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.czF()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof p)) {
                            p pVar = (p) aVar.data;
                            if (pVar.apk() == EmotionGroupType.BIG_EMOTION || pVar.apk() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(pVar.getName());
                                    imageFileInfo.width = pVar.getWidth();
                                    imageFileInfo.height = pVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.rY(true);
                                    WriteActivity.this.clh();
                                }
                            } else if (WriteActivity.this.czF()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.czI();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bTs();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cAf();
                        WriteActivity.this.clh();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.BN(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jTo == null) {
                            WriteActivity.this.auC();
                            return;
                        }
                        switch (WriteActivity.this.cGf) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.auz();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.auy();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.cFY != null) {
                            WriteActivity.this.cFY.qT(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hnC = null;
                        } else {
                            WriteActivity.this.hnC = (String) aVar.data;
                        }
                        WriteActivity.this.rX(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.iXH != null) {
                            str = WriteActivity.this.iXH.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bS("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.iXH == null || (videoInfo = WriteActivity.this.iXH.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.cEt.atZ()) {
                                        WriteActivity.this.cEt.asA();
                                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_not_active), WriteActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_install_tips), WriteActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.iXH.setVideoInfo(null);
                        WriteActivity.this.clh();
                        if (WriteActivity.this.iYe != null) {
                            WriteActivity.this.iYe.requestFocus();
                        }
                        WriteActivity.this.cEt.asA();
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYe);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jTg = true;
                        WriteActivity.this.rV(true);
                        if (!WriteActivity.this.czH().isFocused() || WriteActivity.this.jTj.getVisibility() != 0) {
                            WriteActivity.this.jTf = "from_content";
                        } else {
                            WriteActivity.this.jTf = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jTj.setVisibility(0);
                        WriteActivity.this.jTj.requestFocus();
                        WriteActivity.this.clh();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jTj.hasFocus()) {
                            WriteActivity.this.iYe.requestFocus();
                            WriteActivity.this.iYe.setSelection(WriteActivity.this.iYe.getText().toString().length());
                        }
                        WriteActivity.this.jTj.setVisibility(8);
                        WriteActivity.this.clh();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cEt.setActionListener(16, bVar);
        this.cEt.setActionListener(14, bVar);
        this.cEt.setActionListener(24, bVar);
        this.cEt.setActionListener(3, bVar);
        this.cEt.setActionListener(10, bVar);
        this.cEt.setActionListener(11, bVar);
        this.cEt.setActionListener(12, bVar);
        this.cEt.setActionListener(13, bVar);
        this.cEt.setActionListener(15, bVar);
        this.cEt.setActionListener(18, bVar);
        this.cEt.setActionListener(20, bVar);
        this.cEt.setActionListener(25, bVar);
        this.cEt.setActionListener(27, bVar);
        this.cEt.setActionListener(29, bVar);
        this.cEt.setActionListener(43, bVar);
        this.cEt.setActionListener(45, bVar);
        this.cEt.setActionListener(53, bVar);
        this.cEt.setActionListener(48, bVar);
        this.cEt.setActionListener(46, bVar);
        this.cEt.setActionListener(49, bVar);
        this.cEt.setActionListener(47, bVar);
        this.cEt.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auC() {
        if (this.cFY.aWP()) {
            if (this.cFY.coZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.coU().getLocationData().coS());
                return;
            }
            b(1, true, null);
            this.cFY.coX();
            return;
        }
        b(0, true, null);
    }

    protected void ckY() {
        if (this.cFZ != null) {
            this.cFZ.cancelLoadData();
        }
        if (this.jTk != null) {
            this.jTk.cancelLoadData();
        }
        if (this.cFY != null) {
            this.cFY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        czs();
        TiebaPrepareImageService.StopService();
        ckY();
        czY();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jUd != null) {
            this.jUd.destroy();
        }
        if (this.jUD != null) {
            this.jUD.uQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czu() {
        if (this.iXH != null && this.iXH.getType() == 2 && this.jTZ) {
            finish();
        } else if (this.iXH == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.iXH.setTitle(czH().getText().toString());
            this.iXH.setContent(czG().getText().toString());
            int type = this.iXH.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.iXH.getForumId(), this.iXH);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.iXH);
                }
            } else if (type == 1) {
                v.d(this.iXH.getThreadId(), this.iXH);
            } else if (type == 4) {
                v.c(this.iXH.getForumId() + "photolive", this.iXH);
            } else if (type == 5) {
                v.d(this.iXH.getThreadId() + "updatephotolive", this.iXH);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iYh != null && this.iYh.isShowing()) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYh, getPageContext().getPageActivity());
                return true;
            } else if (this.cEt.atZ()) {
                this.cEt.asA();
                return true;
            } else {
                ckY();
                czu();
                return true;
            }
        }
        if (i == 67 && (text = czG().getText()) != null) {
            int selectionStart = czG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czG().onKeyDown(67, this.fgG);
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
        getLayoutMode().onModeChanged(this.gyn);
        getLayoutMode().onModeChanged(this.jUu);
        am.setBackgroundColor(this.gyn, R.color.cp_bg_line_e);
        if (this.jUr != null && (i == 1 || i == 4)) {
            this.jUr.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iYf, R.color.cp_link_tip_a, 1);
        czp();
        am.setBackgroundColor(this.iYb, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.jUi, R.color.cp_bg_line_c);
        am.setBackgroundColor(czH(), R.color.cp_bg_line_e);
        am.setImageResource(this.hPJ, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hnC)) {
            am.setBackgroundColor(czG(), R.color.cp_bg_line_e);
        }
        clh();
        this.cEt.onChangeSkinType(i);
        if (this.jTy != null) {
            this.jTy.anM();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.jUd.jVa.notifyDataSetChanged();
        czv();
        czw();
        rX(false);
        if (this.jTF != null) {
            this.jTF.c(czH(), czG());
        }
        this.jRr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czv() {
        if (this.iYa.hasFocus()) {
            this.iYa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iYe.hasFocus()) {
            this.iYe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        if (this.iYa != null && this.iYa.getText() != null && this.iYa.getText().toString() != null && this.iYa.getPaint() != null) {
            if (this.iYa.getText().toString().length() == 0) {
                this.iYa.getPaint().setFakeBoldText(false);
            } else if (this.iYa.getText().toString().length() > 0) {
                this.iYa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cNJ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jTA = this.iXH.getType() == 4 || 5 == this.iXH.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.jTX = (TextView) findViewById(R.id.btn_image_problem);
        czy();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.iYf.setLayoutParams(layoutParams);
        this.iYf.setOnFocusChangeListener(this.iXY);
        this.jTz = (ScrollView) findViewById(R.id.write_scrollview);
        this.jTz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iYe != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iYe);
                    }
                    if (WriteActivity.this.cEt != null) {
                        WriteActivity.this.cEt.asA();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jTV = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jTW = findViewById(R.id.feedback_divider);
        this.gyn = (RelativeLayout) findViewById(R.id.parent);
        this.jTi = (LinearLayout) findViewById(R.id.tool_view);
        this.jTi.setContentDescription("..");
        this.jTj = (LinearLayout) findViewById(R.id.title_view);
        this.iYb = findViewById(R.id.interval_view);
        this.jUz = findViewById(R.id.hot_topic_fourm_view);
        this.jUA = findViewById(R.id.hot_topic_divider);
        this.jTC = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jUB = (TextView) findViewById(R.id.change_one_tv);
        clg();
        if (this.jTA) {
            this.jTz.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            czR();
        } else {
            this.jUd = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jUd.rQ(false);
            } else {
                g gVar = this.jUd;
                if (this.iXH.getType() != 0 && this.iXH.getType() != 9) {
                    z = false;
                }
                gVar.rQ(z);
            }
        }
        cli();
        if (this.jTS || this.jTh) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cjP) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iYd = (LinearLayout) findViewById(R.id.post_content_container);
        this.iYd.setDrawingCacheEnabled(false);
        this.iYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iYe.requestFocus();
            }
        });
        this.hPG = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPH = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPJ = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bTs();
            }
        });
        this.mBack.setOnFocusChangeListener(this.iXY);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.ckY();
                WriteActivity.this.czu();
            }
        });
        this.jTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        czB();
        k(czZ());
        czD();
        czx();
        czW();
        czX();
        czp();
        czC();
        clf();
        czJ();
        if (this.iXH.getType() == 4 && this.iYj != null && this.jTl != null) {
            this.iYj.setVisibility(8);
            this.jTl.setVisibility(8);
        }
        clh();
        czU();
        cyH();
    }

    private void cyH() {
        this.jRr = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.iXH.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jRr.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void BB(int i) {
                WriteActivity.this.iXH.setProZone(i);
            }
        });
        this.jRr.ber();
    }

    private void czx() {
        String str;
        String str2;
        if (this.iXH != null) {
            switch (this.iXH.getType()) {
                case 0:
                case 9:
                    if (this.jTS || this.jTh) {
                        if (this.jTT) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fUk != null && this.fUk.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fUk != null && this.fUk.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.iXH.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.iXH.getForumName() + getResources().getString(R.string.bar));
                        this.iYa.setVisibility(8);
                        String str3 = this.fsK + HanziToPinyin.Token.SEPARATOR + this.fsI;
                        if (!StringUtils.isNull(str3)) {
                            this.iYe.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iYa.setVisibility(0);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iYa.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.iXH.getFloorNum() + 1)));
                    this.jUi.setVisibility(8);
                    return;
                case 7:
                    this.iYa.setVisibility(0);
                    this.iYe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void czy() {
        if (this.iXH.getType() == 7) {
            this.iYf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.iYf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void czz() {
        if (this.iXH != null && this.iXH.getType() == 0 && this.iXH.getType() == 9 && !this.jTS && !this.jTh && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && czH() != null) {
                czH().setText(cutStringWithSuffix);
                czH().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hPG.setVisibility(0);
            this.hPH.setVoiceModel(voiceModel);
            this.hPH.cpA();
            clh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTs() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hPG.setVisibility(8);
        this.hPH.bup();
        this.hPH.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jK = this.cEt.jK(6);
        if (jK != null && jK.cEn != null) {
            jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        clh();
    }

    private void czA() {
        this.jTt = null;
        this.jTv = -1;
        this.jTx = -1;
        x qH = w.blA().qH(1);
        if (qH != null) {
            this.jTt = qH.fym;
            this.jTv = getIntent().getIntExtra("category_id", -1);
            if (this.jTt != null && !this.jTt.isEmpty() && this.jTv >= 0) {
                this.jTu = new com.baidu.tieba.frs.v();
                this.jTu.fyi = 0;
                this.jTu.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jTx = this.jTu.fyi;
                this.jTw = this.jTu.name;
                for (com.baidu.tieba.frs.v vVar : this.jTt) {
                    if (vVar.fyi == this.jTv) {
                        this.jTx = vVar.fyi;
                        this.jTw = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void czB() {
        if (this.jTt != null && !this.jTt.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jTy = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jTy.setText(this.jTw);
            this.jTy.setCategoryContainerData(this.jTt, this.jTu, this.jTx);
            this.jTy.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jTy.setText(arVar.name);
                        WriteActivity.this.iXH.setCategoryTo(arVar.fyi);
                        WriteActivity.this.jTx = arVar.fyi;
                        WriteActivity.this.jTy.czc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jTy.czb();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czG());
                }
            });
        }
    }

    private void czU() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jTN = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jTN.setTitle(R.string.no_disturb_start_time);
        this.jTN.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jTN);
        this.jTN.setButton(-2, getPageContext().getString(R.string.cancel), this.jTN);
        return this.jTN;
    }

    private void czC() {
        this.jTp = (RelativeLayout) findViewById(R.id.addition_container);
        this.jTq = (TextView) findViewById(R.id.addition_create_time);
        this.jTr = (TextView) findViewById(R.id.addition_last_time);
        this.jTs = (TextView) findViewById(R.id.addition_last_content);
        if (this.jTo != null) {
            this.jTp.setVisibility(0);
            this.jTq.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.jTo.getCreateTime() * 1000));
            if (this.jTo.getAlreadyCount() == 0) {
                this.jTr.setVisibility(8);
            } else {
                this.jTr.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.jTo.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jTo.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jTs.setText(lastAdditionContent);
            } else {
                this.jTs.setVisibility(8);
            }
            czG().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jTo.getAlreadyCount()), Integer.valueOf(this.jTo.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jTp.setVisibility(8);
    }

    private void clf() {
        this.iYj = findViewById(R.id.post_prefix_layout);
        if (this.jUD == null) {
            this.jUD = new com.baidu.tieba.c.d(getPageContext(), this.iYj);
            this.jUD.bB(R.drawable.bg_tip_blue_up_left);
            this.jUD.bA(16);
            this.jUD.iX(true);
            this.jUD.setUseDirectOffset(true);
            this.jUD.pg(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.iYg = (TextView) findViewById(R.id.post_prefix);
        this.jTl = findViewById(R.id.prefix_divider);
        this.iYi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iYj.setVisibility(0);
            this.jUD.c(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iXI = 0;
            this.iYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bS("fid", WriteActivity.this.iXH.getForumId()).p("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iYg.setVisibility(0);
                    WriteActivity.this.iYj.setSelected(true);
                    am.setImageResource(WriteActivity.this.iYi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iYh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cEt.asA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYa);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYe);
                }
            });
            this.iYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bS("fid", WriteActivity.this.iXH.getForumId()).p("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iYg.setSelected(true);
                    am.setImageResource(WriteActivity.this.iYi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iYh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cEt.asA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czG());
                }
            });
            this.iYh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iYh.a(this);
            this.iYh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.iYh.setOutsideTouchable(true);
            this.iYh.setFocusable(true);
            this.iYh.setOnDismissListener(this);
            this.iYh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.iYg, R.color.cp_bg_line_d);
            am.setImageResource(this.iYi, R.drawable.icon_arrow_gray_down);
            this.iYg.setTextColor(color);
            this.jTm.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jTm.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rN(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rN(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iYh.addView(writePrefixItemLayout);
            }
            this.iYh.setCurrentIndex(0);
            this.iYg.setText(prefixs.get(0));
            BL(0);
            return;
        }
        this.iYj.setVisibility(8);
    }

    private void czV() {
        if (this.jTS && this.iXH != null) {
            this.jTV.setVisibility(0);
            this.jTW.setVisibility(0);
            this.jTk = new FeedBackModel(getPageContext());
            this.jTk.FN(this.iXH.getForumName());
            this.jTk.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jTV.setVisibility(8);
                        WriteActivity.this.jTW.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jTV.setVisibility(8);
                        WriteActivity.this.jTW.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jTV.a(feedBackModel.cze(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void czD() {
        this.iYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jTF.a(WriteActivity.this.iYa, WriteActivity.this.iYe)) {
                        WriteActivity.this.showToast(WriteActivity.this.jTF.cxA());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czG());
                    WriteActivity.this.cEt.asA();
                    if (WriteActivity.this.iXH.getType() != 7) {
                        if (WriteActivity.this.jTS) {
                            WriteActivity.this.czM();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.O("obj_type", StringUtils.isNull(WriteActivity.this.iXH.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.czN();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.czM();
                    }
                    TiebaStatic.log(new an("c12262").bS("obj_locate", WriteActivity.this.fUk));
                }
            }
        });
    }

    protected void czW() {
        this.jTY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jTY.nn(getPageContext().getString(R.string.is_save_draft)).eg(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.iXH.setTitle(WriteActivity.this.czH().getText().toString());
                WriteActivity.this.iXH.setContent(WriteActivity.this.czG().getText().toString());
                int type = WriteActivity.this.iXH.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.iXH.getForumId(), WriteActivity.this.iXH);
                } else if (type == 1) {
                    v.d(WriteActivity.this.iXH.getThreadId(), WriteActivity.this.iXH);
                }
                WriteActivity.this.showToast(R.string.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(R.string.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.iXH.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.iXH.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.iXH.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.jTY.b(getPageContext());
    }

    protected void clg() {
        this.jTU = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jTU.setIsRound(true);
        this.jTU.setDrawBorder(false);
        this.jTU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nK = o.nK(currentPortrait);
            this.jTU.setUrl(nK);
            this.jTU.startLoad(nK, 12, false);
        }
        if (this.iXH.isUserFeedback()) {
            this.jTU.setVisibility(0);
        }
        this.iYa = (EditText) findViewById(R.id.post_title);
        this.iYa.setOnClickListener(this.jTJ);
        this.iYa.setOnFocusChangeListener(this.iXY);
        if (this.iXH.getType() == 0 || this.iXH.getType() == 9 || this.iXH.getType() == 7) {
            if (this.iXH.getTitle() != null) {
                this.iYa.setText(this.iXH.getTitle());
                this.iYa.setSelection(this.iXH.getTitle().length());
            } else if (this.jTT) {
                this.iYa.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.iXH.getType() == 1 || this.iXH.getType() != 2) {
        }
        this.iYa.addTextChangedListener(this.jTL);
        if (!this.iXH.getHaveDraft()) {
            czz();
            this.jUy = true;
        }
        if (this.iXH.isUserFeedback()) {
            this.iYa.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iYa.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher IX() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jUH;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.clh();
                if (WriteActivity.this.jTA) {
                    this.jUH = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jUH);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jTA || !WriteActivity.this.jUp) {
                    if (WriteActivity.this.jTA) {
                        if (this.mEditText != WriteActivity.this.jUg || this.mTextView != WriteActivity.this.jUm) {
                            this.mEditText = WriteActivity.this.jUg;
                            this.mTextView = WriteActivity.this.jUm;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jUk || this.mTextView != WriteActivity.this.jUl) {
                    this.mEditText = WriteActivity.this.jUk;
                    this.mTextView = WriteActivity.this.jUl;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jTA && this.jUp) {
            if (this.jUn != null) {
                this.jUk.removeTextChangedListener(this.jUn);
            }
            this.jUn = textWatcher;
        } else if (this.jTA) {
            if (this.jUo != null) {
                this.jUg.removeTextChangedListener(this.jUo);
            }
            this.jUo = textWatcher;
        }
        return textWatcher;
    }

    private long n(EditText editText) {
        if (editText == this.jUg) {
            return 233L;
        }
        if (editText != this.jUk) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long n = n(editText);
            long o = n - o(editText);
            String valueOf = String.valueOf(o);
            if (n == 20) {
                if (o < 0) {
                    if (o < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (o < 0) {
                if (o < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long o(EditText editText) {
        return com.baidu.tieba.write.c.a.l(editText.getText().toString().trim());
    }

    protected void cli() {
        this.iYe = (EditText) findViewById(R.id.post_content);
        this.iYe.setDrawingCacheEnabled(false);
        this.iYe.setOnClickListener(this.jTJ);
        if (this.iXH.getContent() != null && this.iXH.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avr().ah(getPageContext().getPageActivity(), this.iXH.getContent());
            this.iYe.setText(ah);
            this.iYe.setSelection(ah.length());
        } else if (this.iXH.getType() == 2) {
            if (this.jTZ) {
                if (this.jUa != null && this.jUa.length() > 0) {
                    this.iYe.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jUa}));
                    this.iYe.setSelection(this.iYe.getText().length());
                }
            } else if (this.iXH.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.iXH.getFloorNum()));
                this.iYe.setText(format);
                this.iYe.setSelection(format.length());
            }
        }
        this.iYe.setOnFocusChangeListener(this.iXY);
        this.iYe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iYe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYe.addTextChangedListener(this.jTM);
        if (this.iXH.getType() == 0) {
            this.jUC = true;
        } else {
            rX(true);
            this.jUC = false;
        }
        if (this.iXH.isUserFeedback()) {
            this.iYe.setHint(R.string.write_input_content);
        } else {
            this.iYe.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rX(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jTA) {
            czG().setPadding(0, 0, 0, 0);
            czG().setBackgroundDrawable(null);
            am.setBackgroundColor(czG(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hnC) && this.jTo == null) {
                com.baidu.adp.lib.f.c.fT().a(this.hnC, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.czG().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.czG(), true, WriteActivity.this.hWz);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czF() {
        int i = 5000;
        if (this.jTo != null) {
            i = 1000;
        }
        return czG().getText() != null && czG().getText().length() >= i;
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTf)) {
                this.jTf = "";
                czG().requestFocus();
                if (czG().getText() != null && czG().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czG().getSelectionStart();
                    editable = czG().getText();
                }
            } else if ("from_title".equals(this.jTf)) {
                this.jTf = "";
                czH().requestFocus();
                if (czH().getText() != null && czH().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czH().getSelectionStart();
                    editable = czH().getText();
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
    public void rV(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.iXH != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.toLong(this.iXH.getForumId(), 0L), this.iXH.getFirstDir(), this.iXH.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) czG().getText().getSpans(0, czG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jTn == null) {
                this.jTn = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jTn.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType apk = pVar.apk();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fT().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.czG().getSelectionStart(), aVar, apk);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && czG() != null && czG().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = czG().getSelectionStart() - 1;
                if (czG().getText().length() > 1 && selectionStart >= 0 && czG().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    czG().getText().insert(czG().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            czG().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                czG().getText().insert(czG().getSelectionStart(), spannableString2);
            }
            Editable text = czG().getText();
            if (text != null) {
                this.jTD.clear();
                this.jTD.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTD);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && czG().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    czG().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                czG().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czG() {
        return this.jTA ? this.jUg : this.iYe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czH() {
        return this.jTA ? this.jUk : this.iYa;
    }

    protected void czI() {
        Editable text;
        if (czG() != null && (text = czG().getText()) != null) {
            int selectionStart = czG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czG().onKeyDown(67, this.fgG);
            }
            czG().onKeyDown(67, this.fgG);
            int selectionStart2 = czG().getSelectionStart();
            if (text != null) {
                this.jTD.clear();
                this.jTD.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTD);
                czG().setSelection(selectionStart2);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.iXH != null) {
            str = this.iXH.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jTS = true;
        }
    }

    private void czX() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void czY() {
        try {
            if (this.jTY != null) {
                this.jTY.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cNJ.setCancelListener(null);
        this.cNJ.setTipString(R.string.sending);
        this.cNJ.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cNJ.setDialogVisiable(false);
    }

    private Boolean czZ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.cGe = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void clh() {
        if (this.iXH != null) {
            String str = "";
            String str2 = "";
            if (czH() != null) {
                str = czH().getText().toString();
            }
            if (czG() != null) {
                str2 = czG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.iXH.getType() == 0 || this.iXH.getType() == 9 || this.iXH.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iXI == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.iXH.setIsNoTitle(true);
                        } else if (this.jTj.getVisibility() == 0) {
                            this.iXH.setIsNoTitle(false);
                            rW(true);
                            return;
                        }
                    } else if (this.jTj.getVisibility() == 0) {
                        this.iXH.setIsNoTitle(false);
                        rW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.iXH.setIsNoTitle(true);
                } else if (this.jTj.getVisibility() == 0) {
                    this.iXH.setIsNoTitle(false);
                    rW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jTA) {
                    rW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rW(true);
                }
            }
            if (this.iXH.getType() == 4) {
                rW(q(this.jUg) && p(this.jUk));
            } else if (this.iXH.getType() == 5) {
                rW(q(this.jUg));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                rW(true);
            } else if (this.iXH.getVideoInfo() != null) {
                rW(true);
            } else {
                rW(false);
            }
        }
    }

    public void rW(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.iYf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.iYf.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.iYf, R.color.cp_cont_d, 1);
        this.iYf.setEnabled(false);
    }

    private boolean p(EditText editText) {
        long o = o(editText);
        return o <= 20 && o > 0;
    }

    private boolean q(EditText editText) {
        long o = o(editText);
        if (o > 233) {
            return false;
        }
        return o > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.cFZ = new NewWriteModel(this);
        this.cFZ.b(this.cGo);
        registerListener(this.jUE);
        this.flB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.ckY();
            }
        };
        this.iXH = new WriteData();
        if (bundle != null) {
            this.iXH.setType(bundle.getInt("type", 0));
            this.iXH.setForumId(bundle.getString("forum_id"));
            this.iXH.setForumName(bundle.getString("forum_name"));
            this.iXH.setFirstDir(bundle.getString("forum_first_dir"));
            this.iXH.setSecondDir(bundle.getString("forum_second_dir"));
            this.iXH.setThreadId(bundle.getString("thread_id"));
            this.iXH.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.iXH.setFloorNum(bundle.getInt("floor_num", 0));
            this.jTS = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jTT = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jTZ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUa = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.cFX = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jTo = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.iXH.setIsAddition(this.jTo != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jUb = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.iXH.setTitle(bundle.getString("write_title"));
            this.iXH.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.iXH.setTopicId(this.mTopicId);
            this.fUk = bundle.getString("KEY_CALL_FROM");
            this.apf = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.iXH.setType(intent.getIntExtra("type", 0));
            this.iXH.setForumId(intent.getStringExtra("forum_id"));
            this.iXH.setForumName(intent.getStringExtra("forum_name"));
            this.iXH.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.iXH.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.iXH.setThreadId(intent.getStringExtra("thread_id"));
            this.iXH.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.iXH.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.jTS = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jTT = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jTZ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUa = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jTo = (AdditionData) intent.getSerializableExtra("addition_data");
            this.iXH.setIsAddition(this.jTo != null);
            this.iXH.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jUb = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fsJ = intent.getStringExtra("more_forum_img");
            this.fsK = intent.getStringExtra("more_forum_title");
            this.fsI = intent.getStringExtra("more_forum_url");
            this.iXH.setTitle(intent.getStringExtra("write_title"));
            this.iXH.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.iXH.setTopicId(this.mTopicId);
            this.fUk = intent.getStringExtra("KEY_CALL_FROM");
            this.apf = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.iXH.getType() == 9) {
            this.iXH.setEntranceType(1);
        } else if (this.iXH.getType() == 10) {
            this.iXH.setEntranceType(2);
            this.iXH.setType(9);
        } else if (this.iXH.getType() == 0) {
            this.iXH.setEntranceType(3);
        }
        this.iXH.setIsUserFeedback(this.jTS);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.iXH.getType() == 4 ? 6 : 9);
        this.iXH.setWriteImagesInfo(this.writeImagesInfo);
        if (this.iXH.getType() == 0 || this.iXH.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.iXH.getForumId(), this);
            }
        } else if (this.iXH.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.iXH.getType() == 1) {
            v.a(this.iXH.getThreadId(), this);
        } else if (this.iXH.getType() == 4) {
            v.c(this.iXH.getForumId() + "photolive", this);
        } else if (this.iXH.getType() == 5) {
            v.a(this.iXH.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.hnC = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.iXH != null && this.iXH.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.iXH.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jTh = true;
        }
        czA();
        try {
            this.jUq = cAh();
        } catch (Throwable th) {
            this.jUq = null;
        }
    }

    private void czJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iYa.setText(com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName)));
            this.iYa.setMovementMethod(com.baidu.tieba.view.c.cwN());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qf = com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName));
            if (qf != null) {
                this.iYa.setText(qf);
            }
            this.jTC.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String qg;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.iXH != null) {
                    this.iXH.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(czH().getText().toString()) || this.jUy || ((this.jTS || this.jTh) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.iXH.getTitle())) {
                            this.iXH.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                qg = this.iXH.getTitle();
                            } else {
                                qg = com.baidu.tbadk.plugins.b.qg(str);
                            }
                            SpannableString qf = com.baidu.tbadk.plugins.b.qf(qg);
                            if (qf != null) {
                                czH().setText(qf);
                                czH().setSelection(qf.length() > qg.length() ? qg.length() : qf.length());
                            }
                        } else {
                            SpannableString qf2 = com.baidu.tbadk.plugins.b.qf(this.iXH.getTitle());
                            if (qf2 != null) {
                                czH().setText(qf2);
                                czH().setSelection(this.iXH.getTitle().length() > qf2.length() ? qf2.length() : this.iXH.getTitle().length());
                            }
                        }
                    }
                    if (this.iXH != null && !this.iXH.getHaveDraft()) {
                        czz();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.iXH.setVideoInfo(videoInfo);
                        this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(czG().getText().toString()) || this.jTS || this.jTh) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.iXH.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.avr().a(getPageContext().getPageActivity(), this.iXH.getContent(), this.jTH);
                        czG().setText(a2);
                        czG().setSelection(a2.length());
                        if (this.jTA) {
                            a(this.jUm, this.jUg);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.iXH.setWriteImagesInfo(this.writeImagesInfo);
                        cAf();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            czP();
                        }
                        rY(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cAa();
                    }
                    clh();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jTt != null) {
                        this.jTx = this.jTu.fyi;
                        this.jTw = this.jTu.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jTt.size()) {
                                break;
                            }
                            com.baidu.tieba.frs.v vVar = this.jTt.get(i);
                            if (categoryTo != vVar.fyi) {
                                i++;
                            } else {
                                this.jTx = categoryTo;
                                this.jTw = vVar.name;
                                this.iXH.setCategoryTo(this.jTx);
                                break;
                            }
                        }
                        if (this.jTy != null) {
                            this.jTy.setText(this.jTw);
                            this.jTy.setCategoryContainerData(this.jTt, this.jTu, this.jTx);
                        }
                    }
                    this.cEt.asA();
                    return;
                }
                return;
            }
            cAa();
            czz();
        }
    }

    private void cAa() {
        if ((!this.jTA || this.jUf != null) && this.jUe != null) {
            this.jUf.b(this.writeImagesInfo);
            cAd();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.iXH.getType());
        bundle.putString("forum_id", this.iXH.getForumId());
        bundle.putString("forum_name", this.iXH.getForumName());
        bundle.putString("forum_first_dir", this.iXH.getFirstDir());
        bundle.putString("forum_second_dir", this.iXH.getSecondDir());
        bundle.putString("thread_id", this.iXH.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.iXH.getFloor());
        bundle.putInt("floor_num", this.iXH.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jTZ);
        if (this.jTS) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cFX);
        if (this.jTo != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jTo));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jUb);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fUk);
        bundle.putInt("album_thread", this.apf);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = czG().getEditableText().toString();
        if (obj != null) {
            czG().setText(TbFaceManager.avr().a(getPageContext().getPageActivity(), obj, this.jTH));
            czG().setSelection(czG().getText().length());
        }
    }

    private String czK() {
        return (czG() == null || czG().getText() == null) ? "" : czG().getText().toString();
    }

    private String czL() {
        if (this.iXH == null || czH() == null || czH().getVisibility() != 0 || czH().getText() == null) {
            return "";
        }
        String obj = czH().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.iXI != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.iXH.getType() != 4 && this.iYg != null && this.iYg.getText() != null) {
            this.iXH.setPostPrefix(this.iYg.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.iXH.getTitle();
        }
        return obj;
    }

    private void FO(String str) {
        if (this.iXH != null && this.jTj != null) {
            if (this.jTj.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.iXH.setIsNoTitle(true);
                    this.iXH.setTitle("");
                    return;
                }
                this.iXH.setIsNoTitle(false);
                this.iXH.setTitle(str);
                return;
            }
            this.iXH.setIsNoTitle(true);
            this.iXH.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czM() {
        ckY();
        this.iXH.setContent(czK());
        FO(czL());
        if (this.jTS || this.jTh) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.iXH.getTitle()) || !this.iXH.getTitle().startsWith(string)) {
                FO(string + this.iXH.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.iXH.getContent()) || !this.iXH.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    sb.append(com.baidu.adp.lib.util.j.netTypeNameInUpperCase());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.iXH.getContent());
                this.iXH.setContent(sb.toString());
            }
        }
        if (this.jTv >= 0) {
            this.iXH.setCategoryFrom(this.jTv);
        }
        if (this.jTx >= 0) {
            this.iXH.setCategoryTo(this.jTx);
        }
        this.iXH.setWriteImagesInfo(this.writeImagesInfo);
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
            this.iXH.setTakePhotoNum(i);
        }
        this.iXH.setHasLocationData(this.cFY != null && this.cFY.aWP());
        if (this.writeImagesInfo != null) {
            this.cFZ.qV(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.jTB != null && this.jTB.mIsGlobalBlock == 0) {
            this.iXH.setForumId(String.valueOf(this.jTB.mForumId));
            this.iXH.setForumName(this.jTB.mForumName);
        }
        this.cFZ.d(this.iXH);
        this.iXH.setContent(this.iXH.getContent().replaceAll("\u0000\n", ""));
        this.iXH.setContent(this.iXH.getContent().replaceAll("\u0000", ""));
        this.iXH.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.cFZ.cla().setVoice(this.mVoiceModel.getId());
                this.cFZ.cla().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.cFZ.cla().setVoice(null);
                this.cFZ.cla().setVoiceDuringTime(-1);
            }
        } else {
            this.cFZ.cla().setVoice(null);
            this.cFZ.cla().setVoiceDuringTime(-1);
        }
        if (!this.cFZ.cpF()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.flB);
            this.cFZ.cpC();
        }
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jTo != null) {
                i2 = this.jTo.getTotalCount();
                i = this.jTo.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.iYa == getCurrentFocus()) {
                    czG().clearFocus();
                    this.iYa.requestFocus();
                    if (this.cEt != null) {
                        this.cEt.asA();
                    }
                    ShowSoftKeyPadDelay(this.iYa);
                } else {
                    czG().requestFocus();
                    if (this.cEt != null) {
                        this.cEt.asA();
                    }
                    ShowSoftKeyPadDelay(this.iYe);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(HanziToPinyin.Token.SEPARATOR);
                            i3 = i4 + 1;
                        } else {
                            czG().getText().insert(czG().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.iXH.getType() == 0 || this.iXH.getType() == 9) {
                    v.c(this.iXH.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.iXH.getType() == 1) {
                    v.d(this.iXH.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                cAe();
                            } else {
                                aK(intent);
                            }
                        } else if (intExtra == 1) {
                            aL(intent);
                        } else {
                            aI(intent);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jUC) {
                            rX(true);
                            this.jUC = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jTA) {
                        X(intent);
                        clh();
                        return;
                    }
                    aJ(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.iXH.setVideoInfo(videoInfo);
                        this.cEt.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.cEt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.cEt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    clh();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jTg) {
                                sb2.append(com.baidu.tbadk.plugins.b.cNd);
                                this.jTg = false;
                            }
                            sb2.append(stringExtra);
                            pF(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.jTB = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.jTB);
                }
            }
        } else if (i2 == 0) {
            if (this.cEt != null && !this.cEt.atZ()) {
                this.iYe.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.cEt.asA();
            }
            switch (i) {
                case 12001:
                    auF();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cAc();
                    if (this.jUC) {
                        rX(true);
                        this.jUC = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.iYa == getCurrentFocus()) {
                        czG().clearFocus();
                        this.iYa.requestFocus();
                        if (this.cEt != null) {
                            this.cEt.asA();
                        }
                        ShowSoftKeyPadDelay(this.iYa);
                        return;
                    }
                    czG().requestFocus();
                    if (this.cEt != null) {
                        this.cEt.asA();
                    }
                    ShowSoftKeyPadDelay(this.iYe);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jTF.Fv(postWriteCallBackData.getErrorString());
                        this.jTF.aM(postWriteCallBackData.getSensitiveWords());
                        this.jTF.b(this.iYa, this.iYe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.cFX = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.cFX);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cAc();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.jTf)) {
                        czH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTf)) {
                        czG().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czN() {
        if ("1".equals(this.fUk)) {
            this.iXH.setCanNoForum(true);
            this.iXH.setTransmitForumData("[]");
        } else if ("2".equals(this.fUk)) {
            this.iXH.setCanNoForum(false);
        }
        czO();
        this.iXH.setPrivacy(this.isPrivacy);
        this.iXH.setCallFrom(this.fUk);
        if (this.iXH.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        czM();
    }

    private void czO() {
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cAb() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cAc() {
        if (this.jTA) {
            this.jUf.b(this.writeImagesInfo);
            cAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAd() {
        this.jUf.notifyDataSetChanged();
        this.jUe.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jUf.notifyDataSetChanged();
                WriteActivity.this.jUe.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        clh();
    }

    private void aI(Intent intent) {
        if (this.jTA) {
            aJ(intent);
            cAc();
        } else {
            aM(intent);
        }
        clh();
    }

    private void aJ(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cAc();
            rY(true);
        }
    }

    private void aK(Intent intent) {
        if (this.writeImagesInfo != null) {
            W(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void cAe() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aL(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.jUc.parseJson(stringExtra);
            this.jUc.updateQuality();
            if (this.jUc.getChosedFiles() != null && this.jUc.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jUc.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jUc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, czH());
        HidenSoftKeyPad(this.mInputManager, czG());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aM(Intent intent) {
        c(intent, true);
    }

    private void W(Intent intent) {
        this.cFX = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cFX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cFX, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cAf();
            czP();
        }
        rY(true);
    }

    private void X(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                cAf();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    czP();
                }
            }
            rY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAf() {
        if (this.cEt.jK(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void auF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.cFX));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cAg() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.fsJ)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.m mVar = new com.baidu.tbadk.util.m(this, this.fsJ, new m.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                    @Override // com.baidu.tbadk.util.m.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.m.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.rY(true);
                        }
                    }
                });
                mVar.setFrom(1);
                mVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        String forumId = this.iXH == null ? "" : this.iXH.getForumId();
        if (this.jUd != null) {
            this.jUd.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bki() {
        this.fuw = getVoiceManager();
        this.fuw.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvK) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.iXH.getType() != 7) {
                if (this.jTo == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cGf = i;
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czP() {
        if (!this.jTA) {
            if (this.cEt != null) {
                this.cEt.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.cEt.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.iXH == null ? "" : this.iXH.getForumId();
            if (this.jUd != null) {
                this.jUd.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cEt != null) {
            this.cEt.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void BL(int i) {
        if (i < this.jTm.size()) {
            for (int i2 = 0; i2 < this.jTm.size(); i2++) {
                this.jTm.get(i2).rO(false);
            }
            this.jTm.get(i).rO(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void zv(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").O("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").O("obj_type", 2));
        }
        this.iXI = i;
        this.iYh.setCurrentIndex(i);
        BL(i);
        this.iYg.setText(this.mPrefixData.getPrefixs().get(i));
        clh();
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iYj.setSelected(false);
        am.setImageResource(this.iYi, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iYe);
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
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.iXH != null) {
            if (this.iXH.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.iXH.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            auz();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.cFX);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aii = z;
        if (this.jUw && System.currentTimeMillis() - this.jUx < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.jUw = false;
        }
        if (this.jTE != null && !z) {
            this.jTE.beG();
        }
        if (this.jTG != null && !z) {
            czs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jUt != null) {
            FQ(str);
            this.jUt.dismiss();
        }
    }

    private void em(Context context) {
        jUv = l.getEquipmentHeight(context);
    }

    private void FQ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jUw = true;
        cAf();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            czP();
        }
        rY(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4412=4] */
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

    private File cAh() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
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

    private void cAi() {
        if (this.jUq != null && this.iXH.getType() == 0 && this.iXH.getType() == 9) {
            em(getActivity());
            this.jUs = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jUq != null) {
                        WriteActivity.this.FP(WriteActivity.this.jUq.getAbsolutePath());
                    }
                }
            });
            this.jUr = (TbImageView) this.jUs.findViewById(R.id.rec_img_view);
            this.jUu = (LinearLayout) this.jUs.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.jUq.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.jUq.getAbsolutePath());
                Bitmap e = e(this.jUq.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (e != null) {
                    this.jUr.setImageBitmap(e);
                    this.jUr.setDrawBorder(true);
                    this.jUr.setBorderWidth(2);
                    this.jUr.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.jUt = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jUt.setCanceledOnTouchOutside(true);
                    this.jUt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jUw) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jUx = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jUt.setContentView(this.jUs);
                    this.jUt.show();
                    Window window = this.jUt.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jUv / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
                    attributes.width = getResources().getDimensionPixelSize(R.dimen.ds168);
                    attributes.height = getResources().getDimensionPixelSize(R.dimen.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aii && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTg = false;
            this.jTf = "";
            if ("from_content".equals(str)) {
                this.jTf = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTf = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qe(String.valueOf(charSequence.charAt(i)))) {
                rV(false);
            }
        }
    }

    public void cgy() {
        if (this.jTS || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.iXH.getTitle())) {
            this.jTj.setVisibility(0);
            this.jTj.requestFocus();
            this.cEt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jTj.setVisibility(8);
    }
}
