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
import com.baidu.e.a.a;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0073a, VoiceManager.c, t.a, d.a {
    private static int hYA = 0;
    private EditorTools aYo;
    private String aZP;
    private LocationModel aZQ;
    private NewWriteModel aZR;
    private VoiceManager dIc;
    private ImageView fXB;
    private LinearLayout fXy;
    private PlayVoiceBntNew fXz;
    private String hXA;
    private int hXB;
    private PostCategoryView hXC;
    private HotTopicBussinessData hXF;
    private TextView hXG;
    private com.baidu.tieba.write.editor.b hXI;
    private e hXL;
    private com.baidu.tieba.view.b hXS;
    private LinearLayout hXm;
    private LinearLayout hXn;
    private View hXp;
    private Toast hXr;
    private AdditionData hXs;
    private RelativeLayout hXt;
    private TextView hXu;
    private TextView hXv;
    private TextView hXw;
    List<x> hXx;
    x hXy;
    private int hXz;
    private View hYE;
    private View hYF;
    private TextView hYG;
    private com.baidu.tieba.c.d hYJ;
    private View hYb;
    private g hYi;
    private TextView haR;
    private com.baidu.tieba.write.d haS;
    private ImageView haT;
    private View haU;
    private int hau;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hXj = "";
    private boolean hXk = false;
    private WriteData mData = null;
    private boolean hXX = false;
    private boolean hXl = false;
    private boolean hXY = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText haM = null;
    private HeadImageView hXZ = null;
    private View haN = null;
    private LinearLayout haP = null;
    private EditText haQ = null;
    private FeedBackModel hXo = null;
    private FeedBackTopListView hYa = null;
    private ArrayList<WritePrefixItemLayout> hXq = new ArrayList<>();
    private String fvy = null;
    private final KeyEvent dqR = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aMU = null;
    private TextView hYc = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hYd = null;
    private final Handler mHandler = new Handler();
    private boolean hYe = false;
    private String hYf = null;
    private RelativeLayout mParent = null;
    private String aZV = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aZW = 0;
    private int hYg = 0;
    private WriteImagesInfo hYh = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hYj = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hYk = null;
    private ScrollView hXD = null;
    private EditText hYl = null;
    private View hYm = null;
    private View hYn = null;
    private View hYo = null;
    private EditText hYp = null;
    private TextView hYq = null;
    private TextView hYr = null;
    private TextWatcher hYs = null;
    private TextWatcher hYt = null;
    private boolean hXE = false;
    private boolean hYu = false;
    private com.baidu.tbadk.core.view.d bib = null;
    private String mFrom = "write";
    private File hYv = null;
    private TbImageView hYw = null;
    private View hYx = null;
    private Dialog hYy = null;
    private LinearLayout hYz = null;
    private boolean hYB = false;
    private long hYC = -1000;
    private boolean hYD = false;
    private String eeJ = "2";
    private int hRK = 0;
    private String hYH = "";
    private SpannableStringBuilder hXH = new SpannableStringBuilder();
    private boolean hYI = false;
    private boolean hXJ = false;
    private final b hXK = new b();
    private final HttpMessageListener hYK = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fvy)) {
                    WriteActivity.this.fvy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oF(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fvy)) {
                    WriteActivity.this.fvy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fvy);
                    WriteActivity.this.oF(true);
                }
            }
        }
    };
    private TbFaceManager.a hXM = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ic(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.op());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.i(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dJg = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCK));
        }
    };
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.aAX();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hXK.az(null);
                if (z) {
                    WriteActivity.this.cy(z);
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
                        if (!v.I(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hYH)) {
                            TiebaStatic.log(new am("c11731").aA(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hYH));
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
                    WriteActivity.this.hXK.az(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hXK.xr(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hXK.b(WriteActivity.this.haM, WriteActivity.this.haQ);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GW());
                    if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GV());
                        if (WriteActivity.this.hXY) {
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
    private final LocationModel.a bad = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void MN() {
            WriteActivity.this.showToast(e.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void dj(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(e.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bDT())) {
                WriteActivity.this.b(2, true, aVar.bDT());
            } else {
                dj(null);
            }
        }
    };
    private final CustomMessageListener hnA = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aZQ.nx(false);
                    WriteActivity.this.aZQ.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aZQ.nx(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hXN = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hXO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bOZ = WriteActivity.this.bOZ();
            if (bOZ >= 0 && bOZ < WriteActivity.this.haQ.getText().length()) {
                WriteActivity.this.haQ.setSelection(bOZ);
            }
        }
    };
    private boolean hXP = true;
    private final View.OnFocusChangeListener haK = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.haM || view == WriteActivity.this.aMU || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hXP = true;
                    WriteActivity.this.bPa();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.haM);
                    if (WriteActivity.this.aYo != null) {
                        WriteActivity.this.aYo.Kw();
                    }
                } else if (view == WriteActivity.this.haM) {
                    WriteActivity.this.haR.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.haQ && z) {
                WriteActivity.this.hXP = false;
                WriteActivity.this.bPa();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.haQ);
                if (WriteActivity.this.aYo != null) {
                    WriteActivity.this.aYo.Kw();
                }
            }
            WriteActivity.this.bPg();
        }
    };
    private TextWatcher hXQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hXU = "";
        private String hXV;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hXV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hXV != null ? this.hXV.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bzd();
            WriteActivity.this.bPh();
            EditText bPs = WriteActivity.this.bPs();
            if (editable != null && bPs != null && bPs.getText() != null) {
                if (this.hXU == null || !this.hXU.equals(editable.toString())) {
                    if (WriteActivity.this.hXK != null) {
                        this.hXU = bPs.getText().toString();
                        WriteActivity.this.hXK.k(bPs);
                        return;
                    }
                    return;
                }
                bPs.setSelection(bPs.getSelectionEnd());
            }
        }
    };
    private TextWatcher hXR = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hXV;
        private String hXW = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hXV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hXV != null ? this.hXV.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bzd();
            EditText bPr = WriteActivity.this.bPr();
            if (editable != null && bPr != null && bPr.getText() != null) {
                if (this.hXW == null || !this.hXW.equals(editable.toString())) {
                    if (WriteActivity.this.hXK != null) {
                        this.hXW = bPr.getText().toString();
                        WriteActivity.this.hXK.k(bPr);
                        return;
                    }
                    return;
                }
                bPr.setSelection(bPr.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0314a geh = new a.InterfaceC0314a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
            WriteActivity.this.fvy = null;
            WriteActivity.this.oF(false);
            WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void My() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Mz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MB();
        } else if (this.aZQ.bEa()) {
            My();
        } else {
            this.aZQ.nx(false);
            b(1, true, null);
            this.aZQ.bDY();
        }
    }

    private void MB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aZQ.alQ();
                } else {
                    WriteActivity.this.bad.MN();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bOZ() {
        int selectionEnd = bPr().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bPr().getText().getSpans(0, bPr().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bPr().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bPr().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        if (this.aYo != null) {
            this.aYo.setBarLauncherEnabled(!this.hXP);
            this.aYo.setBarLauncherEnabled(true, 26);
            this.aYo.setBarLauncherEnabled(true, 2);
            K(9, this.hXP ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g fH;
        if (this.aYo != null && (fH = this.aYo.fH(i)) != null) {
            if (z) {
                fH.pN();
            } else {
                fH.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hXE) {
            this.haM.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hYo.setVisibility(8);
            } else {
                this.hYo.setVisibility(0);
            }
            a(this.hYr, this.hYl);
            a(this.hYq, this.hYp);
            bzd();
        }
        if (this.hXX) {
            this.hXP = true;
            bPa();
            if (this.aYo != null) {
                this.aYo.Kw();
            }
            this.haM.requestFocus();
            ShowSoftKeyPadDelay(this.haM);
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
            bPP();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bPA();
            }
            oG(true);
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
            xu(this.hRK);
        }
        initUI();
        bPF();
        this.aZQ = new LocationModel(this);
        this.aZQ.a(this.bad);
        registerListener(this.hnA);
        registerListener(this.hXN);
        initEditor();
        bPR();
        if (this.hXE) {
            this.hYk.setEditorTools(this.aYo);
        } else {
            this.haQ.requestFocus();
        }
        bvl();
        bPA();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aYo = new EditorTools(getActivity());
        this.aYo.setBarMaxLauCount(5);
        this.aYo.setMoreButtonAtEnd(true);
        this.aYo.setBarLauncherType(1);
        this.aYo.cq(true);
        this.aYo.cr(true);
        this.aYo.setMoreLauncherIcon(e.f.write_more);
        this.aYo.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bPD();
                break;
            default:
                bPb();
                break;
        }
        this.aYo.LY();
        if (this.hXm != null) {
            this.hXm.addView(this.aYo);
        }
        bPc();
        this.aYo.pN();
        com.baidu.tbadk.editortools.g fH = this.aYo.fH(6);
        if (fH != null && !TextUtils.isEmpty(this.aZV)) {
            ((View) fH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aZV);
                }
            });
        }
        if (!this.hXE) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aYo.Kw();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bPe();
    }

    private void bPB() {
        this.hYm = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.hYo = this.hYm.findViewById(e.g.live_post_title_container);
        this.hYl = (EditText) this.hYm.findViewById(e.g.live_post_content);
        this.hYj = (GridView) this.hYm.findViewById(e.g.photoLiveGridView);
        this.hYp = (EditText) this.hYm.findViewById(e.g.live_post_title);
        this.hYq = (TextView) this.hYm.findViewById(e.g.titleOverPlusNumber);
        this.hYr = (TextView) this.hYm.findViewById(e.g.contentOverPlusNumber);
        this.hYn = this.hYm.findViewById(e.g.live_interval_view);
        this.hYq.setText(String.valueOf(20));
        this.hYr.setText(String.valueOf(233));
        this.hYm.setVisibility(0);
        this.hYq.setVisibility(0);
        this.hYr.setVisibility(0);
        this.hYp.setHint(e.j.tips_title_limit_new);
        this.hYp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hYu = true;
                    WriteActivity.this.hXP = true;
                    WriteActivity.this.bPa();
                    if (WriteActivity.this.aYo != null) {
                        WriteActivity.this.aYo.Kw();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hYl.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hYl.setHint(e.j.live_write_input_content_update);
        }
        this.hYl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hYu = false;
                    WriteActivity.this.hXP = false;
                    WriteActivity.this.bPa();
                    if (WriteActivity.this.aYo != null) {
                        WriteActivity.this.aYo.Kw();
                    }
                }
            }
        });
        this.hYl.requestFocus();
        this.hYl.addTextChangedListener(getTextWatcher());
        this.hYp.requestFocus();
        this.hYp.addTextChangedListener(getTextWatcher());
        this.hYp.setOnClickListener(this.hXO);
        this.hYl.setOnClickListener(this.hXO);
        this.hYk = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hYj);
        this.hYk.xo(6);
        this.hYj.setAdapter((ListAdapter) this.hYk);
        View findViewById = this.hYm.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bOK() {
                WriteActivity.this.bPN();
            }
        });
        bPC();
    }

    private void bPC() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hYp.setText(this.mData.getTitle());
                this.hYp.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hXE) {
            bPL();
        }
        if (this.aYo.Ma()) {
            this.aYo.Kw();
        }
        xu(0);
    }

    private void xu(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.eeJ);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bPD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aYo.w(arrayList);
        com.baidu.tbadk.editortools.k fK = this.aYo.fK(5);
        if (fK != null) {
            fK.aYX = 2;
            fK.aYV = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aYV = e.f.write_at;
        this.aYo.b(aVar);
        this.aYo.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bPb() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aYV = e.f.write_picture;
        this.aYo.b(dVar);
        Boolean bPJ = bPJ();
        if (!this.hXX && bPJ != null && bPJ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bEC() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aYX = 3;
            kVar5.aYV = e.f.write_recorder;
            this.aYo.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aYV = e.f.icon_post_topic_selector;
        this.aYo.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aYX = 5;
            kVar4.aYV = e.f.write_privilege;
            this.aYo.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aYX = 6;
            kVar3.aYV = this.hXX ? e.f.write_location : e.f.icon_post_more_location;
            this.aYo.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aYV = e.f.icon_post_more_at;
        this.aYo.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aYZ = true;
            kVar2.aYX = 9;
            kVar2.aYV = 0;
            this.aYo.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aYZ = true;
            kVar.aYX = 10;
            kVar.aYV = 0;
            this.aYo.b(kVar);
        }
        if (this.hXs == null) {
            if (this.hXI == null) {
                this.hXI = new com.baidu.tieba.write.editor.b(getActivity(), this.eeJ);
                this.hXI.aZ(this.mData.getForumId(), this.privateThread);
            }
            this.aYo.b(this.hXI);
        }
        this.aYo.w(arrayList);
        com.baidu.tbadk.editortools.k fK = this.aYo.fK(5);
        if (fK != null) {
            fK.aYX = 1;
            fK.aYV = e.f.write_emotion;
        }
    }

    private void bPd() {
        if (this.hXL != null) {
            this.hXL.hideTip();
        }
    }

    private void bPe() {
        if (this.hXL == null) {
            this.hXL = new e(getPageContext());
        }
        this.hXL.c(this.aYo);
    }

    private void bPc() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bPq()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bPq()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bPt();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.biY();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bPP();
                        WriteActivity.this.bzd();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xv(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hXs == null) {
                            WriteActivity.this.MC();
                            return;
                        }
                        switch (WriteActivity.this.aZW) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    WriteActivity.this.Mz();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.My();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aZQ != null) {
                            WriteActivity.this.aZQ.nx(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fvy = null;
                        } else {
                            WriteActivity.this.fvy = (String) aVar.data;
                        }
                        WriteActivity.this.oF(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.aA(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aYo.Ma()) {
                                        WriteActivity.this.aYo.Kw();
                                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(e.j.plugin_video_not_active), WriteActivity.this.getResources().getString(e.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(e.j.plugin_video_install_tips), WriteActivity.this.getResources().getString(e.j.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bzd();
                        if (WriteActivity.this.haQ != null) {
                            WriteActivity.this.haQ.requestFocus();
                        }
                        WriteActivity.this.aYo.Kw();
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.haQ);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hXk = true;
                        WriteActivity.this.oD(true);
                        if (!WriteActivity.this.bPs().isFocused() || WriteActivity.this.hXn.getVisibility() != 0) {
                            WriteActivity.this.hXj = "from_content";
                        } else {
                            WriteActivity.this.hXj = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hXn.setVisibility(0);
                        WriteActivity.this.hXn.requestFocus();
                        WriteActivity.this.bzd();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hXn.hasFocus()) {
                            WriteActivity.this.haQ.requestFocus();
                            WriteActivity.this.haQ.setSelection(WriteActivity.this.haQ.getText().toString().length());
                        }
                        WriteActivity.this.hXn.setVisibility(8);
                        WriteActivity.this.bzd();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aYo.setActionListener(16, bVar);
        this.aYo.setActionListener(14, bVar);
        this.aYo.setActionListener(24, bVar);
        this.aYo.setActionListener(3, bVar);
        this.aYo.setActionListener(10, bVar);
        this.aYo.setActionListener(11, bVar);
        this.aYo.setActionListener(12, bVar);
        this.aYo.setActionListener(13, bVar);
        this.aYo.setActionListener(15, bVar);
        this.aYo.setActionListener(18, bVar);
        this.aYo.setActionListener(20, bVar);
        this.aYo.setActionListener(25, bVar);
        this.aYo.setActionListener(27, bVar);
        this.aYo.setActionListener(29, bVar);
        this.aYo.setActionListener(43, bVar);
        this.aYo.setActionListener(45, bVar);
        this.aYo.setActionListener(53, bVar);
        this.aYo.setActionListener(48, bVar);
        this.aYo.setActionListener(46, bVar);
        this.aYo.setActionListener(49, bVar);
        this.aYo.setActionListener(47, bVar);
        this.aYo.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC() {
        if (this.aZQ.alM()) {
            if (this.aZQ.bEa()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bDW().getLocationData().bDT());
                return;
            }
            b(1, true, null);
            this.aZQ.bDY();
            return;
        }
        b(0, true, null);
    }

    protected void byV() {
        if (this.aZR != null) {
            this.aZR.cancelLoadData();
        }
        if (this.hXo != null) {
            this.hXo.cancelLoadData();
        }
        if (this.aZQ != null) {
            this.aZQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bPd();
        TiebaPrepareImageService.StopService();
        byV();
        bPI();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hYi != null) {
            this.hYi.destroy();
        }
        if (this.hYJ != null) {
            this.hYJ.arm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPf() {
        if (this.mData != null && this.mData.getType() == 2 && this.hYe) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bPs().getText().toString());
            this.mData.setContent(bPr().getText().toString());
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
            if (this.haS != null && this.haS.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.haS, getPageContext().getPageActivity());
                return true;
            } else if (this.aYo.Ma()) {
                this.aYo.Kw();
                return true;
            } else {
                byV();
                bPf();
                return true;
            }
        }
        if (i == 67 && (text = bPr().getText()) != null) {
            int selectionStart = bPr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bPr().onKeyDown(67, this.dqR);
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
        getLayoutMode().onModeChanged(this.mParent);
        getLayoutMode().onModeChanged(this.hYz);
        if (this.hYw != null && i == 1) {
            this.hYw.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bPa();
        al.j(this.hYm, e.d.cp_bg_line_d);
        al.j(this.haN, e.d.cp_bg_line_c);
        al.j(this.hYn, e.d.cp_bg_line_c);
        al.j(bPs(), e.d.cp_bg_line_d);
        al.c(this.fXB, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fvy)) {
            al.j(bPr(), e.d.cp_bg_line_d);
        }
        bzd();
        this.aYo.onChangeSkinType(i);
        if (this.hXC != null) {
            this.hXC.Fj();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bPg();
        bPh();
        if (this.hXK != null) {
            this.hXK.c(bPs(), bPr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPg() {
        if (this.haM.hasFocus()) {
            this.haM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.haM.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.haQ.hasFocus()) {
            this.haQ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.haQ.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        if (this.haM != null && this.haM.getText() != null && this.haM.getText().toString() != null && this.haM.getPaint() != null) {
            if (this.haM.getText().toString().length() == 0) {
                this.haM.getPaint().setFakeBoldText(false);
            } else if (this.haM.getText().toString().length() > 0) {
                this.haM.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bib = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hXE = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.hYc = (TextView) findViewById(e.g.btn_image_problem);
        bPj();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.haK);
        this.hXD = (ScrollView) findViewById(e.g.write_scrollview);
        this.hXD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.haQ != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.haQ);
                    }
                    if (WriteActivity.this.aYo != null) {
                        WriteActivity.this.aYo.Kw();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hYa = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.hYb = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hXm = (LinearLayout) findViewById(e.g.tool_view);
        this.hXm.setContentDescription("..");
        this.hXn = (LinearLayout) findViewById(e.g.title_view);
        this.haN = findViewById(e.g.interval_view);
        this.hYE = findViewById(e.g.hot_topic_fourm_view);
        this.hYF = findViewById(e.g.hot_topic_divider);
        this.hXG = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.hYG = (TextView) findViewById(e.g.change_one_tv);
        bzc();
        if (this.hXE) {
            this.hXD.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bPB();
        } else {
            this.hYi = new g(getPageContext(), this.mRootView);
            g gVar = this.hYi;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.oy(z);
        }
        bze();
        if (this.hXX || this.hXl) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aDw) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.haP = (LinearLayout) findViewById(e.g.post_content_container);
        this.haP.setDrawingCacheEnabled(false);
        this.haP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.haQ.requestFocus();
            }
        });
        this.fXy = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fXz = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fXB = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.biY();
            }
        });
        this.aMU.setOnFocusChangeListener(this.haK);
        this.aMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.byV();
                WriteActivity.this.bPf();
            }
        });
        this.hYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bPm();
        j(bPJ());
        bPo();
        bPi();
        bPG();
        bPH();
        bPa();
        bPn();
        bzb();
        bPu();
        if (this.mData.getType() == 4 && this.haU != null && this.hXp != null) {
            this.haU.setVisibility(8);
            this.hXp.setVisibility(8);
        }
        bzd();
        bPE();
    }

    private void bPi() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hXX || this.hXl) {
                        if (this.hXY) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.eeJ != null && this.eeJ.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.eeJ != null && this.eeJ.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(e.j.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(e.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(e.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.haM.setVisibility(0);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.haM.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hYn.setVisibility(8);
                    return;
                case 7:
                    this.haM.setVisibility(0);
                    this.haQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bPj() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bPk() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hXX && !this.hXl && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bPs() != null) {
                bPs().setText(c);
                bPs().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fXy.setVisibility(0);
            this.fXz.setVoiceModel(voiceModel);
            this.fXz.bEB();
            bzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biY() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fXy.setVisibility(8);
        this.fXz.aMw();
        this.fXz.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fK = this.aYo.fK(6);
        if (fK != null && fK.aYi != null) {
            fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bzd();
    }

    private void bPl() {
        this.hXx = null;
        this.hXz = -1;
        this.hXB = -1;
        z mn = y.aCr().mn(1);
        if (mn != null) {
            this.hXx = mn.dLt;
            this.hXz = getIntent().getIntExtra("category_id", -1);
            if (this.hXx != null && !this.hXx.isEmpty() && this.hXz >= 0) {
                this.hXy = new x();
                this.hXy.dLp = 0;
                this.hXy.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hXB = this.hXy.dLp;
                this.hXA = this.hXy.name;
                for (x xVar : this.hXx) {
                    if (xVar.dLp == this.hXz) {
                        this.hXB = xVar.dLp;
                        this.hXA = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bPm() {
        if (this.hXx != null && !this.hXx.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hXC = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hXC.setText(this.hXA);
            this.hXC.setCategoryContainerData(this.hXx, this.hXy, this.hXB);
            this.hXC.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hXC.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dLp);
                        WriteActivity.this.hXB = atVar.dLp;
                        WriteActivity.this.hXC.bON();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hXC.bOM();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPs());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPr());
                }
            });
        }
    }

    private void bPE() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hXS = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hXS.setTitle(e.j.no_disturb_start_time);
        this.hXS.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hXS);
        this.hXS.setButton(-2, getPageContext().getString(e.j.cancel), this.hXS);
        return this.hXS;
    }

    private void bPn() {
        this.hXt = (RelativeLayout) findViewById(e.g.addition_container);
        this.hXu = (TextView) findViewById(e.g.addition_create_time);
        this.hXv = (TextView) findViewById(e.g.addition_last_time);
        this.hXw = (TextView) findViewById(e.g.addition_last_content);
        if (this.hXs != null) {
            this.hXt.setVisibility(0);
            this.hXu.setText(getPageContext().getString(e.j.write_addition_create) + ao.L(this.hXs.getCreateTime() * 1000));
            if (this.hXs.getAlreadyCount() == 0) {
                this.hXv.setVisibility(8);
            } else {
                this.hXv.setText(getPageContext().getString(e.j.write_addition_last) + ao.L(this.hXs.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hXs.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hXw.setText(lastAdditionContent);
            } else {
                this.hXw.setVisibility(8);
            }
            bPr().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hXs.getAlreadyCount()), Integer.valueOf(this.hXs.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hXt.setVisibility(8);
    }

    private void bzb() {
        this.haU = findViewById(e.g.post_prefix_layout);
        if (this.hYJ == null) {
            this.hYJ = new com.baidu.tieba.c.d(getPageContext(), this.haU);
            this.hYJ.kU(e.f.bg_tip_blue_up_left);
            this.hYJ.kT(16);
            this.hYJ.fG(true);
            this.hYJ.aa(true);
            this.hYJ.kX(l.h(getActivity(), e.C0210e.ds32));
        }
        this.haR = (TextView) findViewById(e.g.post_prefix);
        this.hXp = findViewById(e.g.prefix_divider);
        this.haT = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.haU.setVisibility(0);
            this.hYJ.h(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hau = 0;
            this.haU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aA(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.haR.setVisibility(0);
                    WriteActivity.this.haU.setSelected(true);
                    al.c(WriteActivity.this.haT, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.haS, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aYo.Kw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.haM);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.haQ);
                }
            });
            this.haR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aA(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.haR.setSelected(true);
                    al.c(WriteActivity.this.haT, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.haS, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aYo.Kw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPs());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPr());
                }
            });
            this.haS = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.haS.a(this);
            this.haS.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.haS.setOutsideTouchable(true);
            this.haS.setFocusable(true);
            this.haS.setOnDismissListener(this);
            this.haS.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.haR, e.d.cp_bg_line_d);
            al.c(this.haT, e.f.icon_arrow_gray_down);
            this.haR.setTextColor(color);
            this.hXq.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hXq.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ot(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ot(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.haS.addView(writePrefixItemLayout);
            }
            this.haS.setCurrentIndex(0);
            this.haR.setText(prefixs.get(0));
            xt(0);
            return;
        }
        this.haU.setVisibility(8);
    }

    private void bPF() {
        if (this.hXX && this.mData != null) {
            this.hYa.setVisibility(0);
            this.hYb.setVisibility(0);
            this.hXo = new FeedBackModel(getPageContext());
            this.hXo.xM(this.mData.getForumName());
            this.hXo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hYa.setVisibility(8);
                        WriteActivity.this.hYb.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hYa.setVisibility(8);
                        WriteActivity.this.hYb.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hYa.a(feedBackModel.bOP(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bPo() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hXK.a(WriteActivity.this.haM, WriteActivity.this.haQ)) {
                        WriteActivity.this.showToast(WriteActivity.this.hXK.bMY());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPs());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bPr());
                    WriteActivity.this.aYo.Kw();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hXX) {
                            WriteActivity.this.bPx();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.x("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bPy();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bPx();
                    }
                    TiebaStatic.log(new am("c12262").aA("obj_locate", WriteActivity.this.eeJ));
                }
            }
        });
    }

    protected void bPG() {
        this.hYd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hYd.eB(getPageContext().getString(e.j.is_save_draft)).bf(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bPs().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bPr().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(e.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(e.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
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
        this.hYd.b(getPageContext());
    }

    protected void bzc() {
        this.hXZ = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.hXZ.setIsRound(true);
        this.hXZ.setDrawBorder(false);
        this.hXZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String fu = o.fu(currentPortrait);
            this.hXZ.setUrl(fu);
            this.hXZ.startLoad(fu, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hXZ.setVisibility(0);
        }
        this.haM = (EditText) findViewById(e.g.post_title);
        this.haM.setOnClickListener(this.hXO);
        this.haM.setOnFocusChangeListener(this.haK);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.haM.setText(this.mData.getTitle());
                this.haM.setSelection(this.mData.getTitle().length());
            } else if (this.hXY) {
                this.haM.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.haM.addTextChangedListener(this.hXQ);
        if (!this.mData.getHaveDraft()) {
            bPk();
            this.hYD = true;
        }
        if (this.mData.isUserFeedback()) {
            this.haM.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.haM.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher getTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hYN;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bzd();
                if (WriteActivity.this.hXE) {
                    this.hYN = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hYN);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hXE || !WriteActivity.this.hYu) {
                    if (WriteActivity.this.hXE) {
                        if (this.mEditText != WriteActivity.this.hYl || this.mTextView != WriteActivity.this.hYr) {
                            this.mEditText = WriteActivity.this.hYl;
                            this.mTextView = WriteActivity.this.hYr;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hYp || this.mTextView != WriteActivity.this.hYq) {
                    this.mEditText = WriteActivity.this.hYp;
                    this.mTextView = WriteActivity.this.hYq;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hXE && this.hYu) {
            if (this.hYs != null) {
                this.hYp.removeTextChangedListener(this.hYs);
            }
            this.hYs = textWatcher;
        } else if (this.hXE) {
            if (this.hYt != null) {
                this.hYl.removeTextChangedListener(this.hYt);
            }
            this.hYt = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hYl) {
            return 233L;
        }
        if (editText != this.hYp) {
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
                    textView.setTextColor(al.getColor(e.d.common_color_10159));
                } else {
                    textView.setTextColor(al.getColor(e.d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(al.getColor(e.d.common_color_10159));
            } else {
                textView.setTextColor(al.getColor(e.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.h(editText.getText().toString().trim());
    }

    protected void bze() {
        this.haQ = (EditText) findViewById(e.g.post_content);
        this.haQ.setDrawingCacheEnabled(false);
        this.haQ.setOnClickListener(this.hXO);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nt().am(getPageContext().getPageActivity(), this.mData.getContent());
            this.haQ.setText(am);
            this.haQ.setSelection(am.length());
        } else if (this.mData.getType() == 2) {
            if (this.hYe) {
                if (this.hYf != null && this.hYf.length() > 0) {
                    this.haQ.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.hYf}));
                    this.haQ.setSelection(this.haQ.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.haQ.setText(format);
                this.haQ.setSelection(format.length());
            }
        }
        this.haQ.setOnFocusChangeListener(this.haK);
        this.haQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.haQ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.haQ.addTextChangedListener(this.hXR);
        if (this.mData.getType() == 0) {
            this.hYI = true;
        } else {
            oF(true);
            this.hYI = false;
        }
        if (this.mData.isUserFeedback()) {
            this.haQ.setHint(e.j.write_input_content);
        } else {
            this.haQ.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oF(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hXE) {
            bPr().setPadding(0, 0, 0, 0);
            bPr().setBackgroundDrawable(null);
            al.j(bPr(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fvy) && this.hXs == null) {
                com.baidu.adp.lib.f.c.jA().a(this.fvy, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.op() != null && aVar.ot() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.op(), aVar.op().getNinePatchChunk(), aVar.ot(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bPr().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bPr(), true, WriteActivity.this.geh);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPq() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.hXs != null) {
            i = 1000;
        }
        return bPr().getText() != null && bPr().getText().length() >= i;
    }

    private void hJ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hXj)) {
                this.hXj = "";
                bPr().requestFocus();
                if (bPr().getText() != null && bPr().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bPr().getSelectionStart();
                    editable = bPr().getText();
                }
            } else if ("from_title".equals(this.hXj)) {
                this.hXj = "";
                bPs().requestFocus();
                if (bPs().getText() != null && bPs().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bPs().getSelectionStart();
                    editable = bPs().getText();
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
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) bPr().getText().getSpans(0, bPr().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hXr == null) {
                this.hXr = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hXr.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType GM = pVar.GM();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bPr().getSelectionStart(), aVar, GM);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bPr() != null && bPr().getText() != null) {
            Bitmap op = aVar.op();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(op);
            int width = op.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, op.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bPr().getSelectionStart() - 1;
                if (bPr().getText().length() > 1 && selectionStart >= 0 && bPr().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bPr().getText().insert(bPr().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bPr().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bPr().getText().insert(bPr().getSelectionStart(), spannableString2);
            }
            Editable text = bPr().getText();
            if (text != null) {
                this.hXH.clear();
                this.hXH.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hXH);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bPr().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bPr().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bPr().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bPr() {
        return this.hXE ? this.hYl : this.haQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bPs() {
        return this.hXE ? this.hYp : this.haM;
    }

    protected void bPt() {
        Editable text;
        if (bPr() != null && (text = bPr().getText()) != null) {
            int selectionStart = bPr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bPr().onKeyDown(67, this.dqR);
            }
            bPr().onKeyDown(67, this.dqR);
            int selectionStart2 = bPr().getSelectionStart();
            if (text != null) {
                this.hXH.clear();
                this.hXH.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hXH);
                bPr().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.hXX = true;
        }
    }

    private void bPH() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bPI() {
        try {
            if (this.hYd != null) {
                this.hYd.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bib.d(null);
        this.bib.ec(e.j.sending);
        this.bib.bA(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bib.bA(false);
    }

    private Boolean bPJ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aZV = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void bzd() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bPs() != null) {
                str = bPs().getText().toString();
            }
            if (bPr() != null) {
                str2 = bPr().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.hau == v.H(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hXn.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            oE(true);
                            return;
                        }
                    } else if (this.hXn.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        oE(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hXn.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    oE(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hXE) {
                    oE(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oE(true);
                }
            }
            if (this.mData.getType() == 4) {
                oE(o(this.hYl) && n(this.hYp));
            } else if (this.mData.getType() == 5) {
                oE(o(this.hYl));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                oE(true);
            } else if (this.mData.getVideoInfo() != null) {
                oE(true);
            } else {
                oE(false);
            }
        }
    }

    public void oE(boolean z) {
        if (z) {
            al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        al.c(this.mPost, e.d.cp_cont_d, 1);
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
        this.aZR = new NewWriteModel(this);
        this.aZR.b(this.baf);
        registerListener(this.hYK);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.byV();
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
            this.hXX = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hXY = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hYe = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hYf = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aZP = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hXs = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hXs != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hYg = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hYH = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.eeJ = bundle.getString("KEY_CALL_FROM");
            this.hRK = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hXX = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hXY = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hYe = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hYf = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hXs = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hXs != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hYg = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hYH = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.eeJ = intent.getStringExtra("KEY_CALL_FROM");
            this.hRK = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hXX);
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
            this.mPrefixData.getPrefixs().add(getPageContext().getString(e.j.write_no_prefix));
        }
        this.fvy = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hXl = true;
        }
        bPl();
        try {
            this.hYv = bPQ();
        } catch (Throwable th) {
            this.hYv = null;
        }
    }

    private void bPu() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.haM.setText(com.baidu.tbadk.plugins.b.is(com.baidu.tbadk.plugins.b.it(hotTopicBussinessData.mTopicName)));
            this.haM.setMovementMethod(com.baidu.tieba.view.c.bLZ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString is = com.baidu.tbadk.plugins.b.is(com.baidu.tbadk.plugins.b.it(hotTopicBussinessData.mTopicName));
            if (is != null) {
                this.haM.setText(is);
            }
            this.hXG.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String it;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bPs().getText().toString()) || this.hYD || ((this.hXX || this.hXl) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!v.I(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            it = this.mData.getTitle();
                        } else {
                            it = com.baidu.tbadk.plugins.b.it(str);
                        }
                        SpannableString is = com.baidu.tbadk.plugins.b.is(it);
                        if (is != null) {
                            bPs().setText(is);
                            bPs().setSelection(is.length() > it.length() ? it.length() : is.length());
                        }
                    } else {
                        SpannableString is2 = com.baidu.tbadk.plugins.b.is(this.mData.getTitle());
                        if (is2 != null) {
                            bPs().setText(is2);
                            bPs().setSelection(this.mData.getTitle().length() > is2.length() ? is2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bPk();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bPr().getText().toString()) || this.hXX || this.hXl) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Nt().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hXM);
                    bPr().setText(a2);
                    bPr().setSelection(a2.length());
                    if (this.hXE) {
                        a(this.hYr, this.hYl);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bPP();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bPA();
                    }
                    oG(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bPK();
                }
                bzd();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hXx != null) {
                    this.hXB = this.hXy.dLp;
                    this.hXA = this.hXy.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hXx.size()) {
                            break;
                        }
                        x xVar = this.hXx.get(i);
                        if (categoryTo != xVar.dLp) {
                            i++;
                        } else {
                            this.hXB = categoryTo;
                            this.hXA = xVar.name;
                            this.mData.setCategoryTo(this.hXB);
                            break;
                        }
                    }
                    if (this.hXC != null) {
                        this.hXC.setText(this.hXA);
                        this.hXC.setCategoryContainerData(this.hXx, this.hXy, this.hXB);
                    }
                }
                this.aYo.Kw();
                return;
            }
            return;
        }
        bPK();
        bPk();
    }

    private void bPK() {
        if ((!this.hXE || this.hYk != null) && this.hYj != null) {
            this.hYk.c(this.writeImagesInfo);
            bPN();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hYe);
        if (this.hXX) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aZP);
        if (this.hXs != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hXs));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hYg);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.eeJ);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hRK);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bPr().getEditableText().toString();
        if (obj != null) {
            bPr().setText(TbFaceManager.Nt().a(getPageContext().getPageActivity(), obj, this.hXM));
            bPr().setSelection(bPr().getText().length());
        }
    }

    private String bPv() {
        return (bPr() == null || bPr().getText() == null) ? "" : bPr().getText().toString();
    }

    private String bPw() {
        if (this.mData == null || bPs() == null || bPs().getVisibility() != 0 || bPs().getText() == null) {
            return "";
        }
        String obj = bPs().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.hau != v.H(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.haR != null && this.haR.getText() != null) {
            this.mData.setPostPrefix(this.haR.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void xN(String str) {
        if (this.mData != null && this.hXn != null) {
            if (this.hXn.getVisibility() == 0) {
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
    public void bPx() {
        byV();
        this.mData.setContent(bPv());
        xN(bPw());
        if (this.hXX || this.hXl) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                xN(string + this.mData.getTitle());
            }
            String str = getResources().getString(e.j.app_name) + getResources().getString(e.j.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.kV()) {
                    sb.append(com.baidu.adp.lib.util.j.lc());
                } else {
                    sb.append(AiAppRomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hXz >= 0) {
            this.mData.setCategoryFrom(this.hXz);
        }
        if (this.hXB >= 0) {
            this.mData.setCategoryTo(this.hXB);
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
        this.mData.setHasLocationData(this.aZQ != null && this.aZQ.alM());
        if (this.writeImagesInfo != null) {
            this.aZR.nz(this.writeImagesInfo.size() > 0);
        }
        if (!v.I(this.mList) && this.hXF != null && this.hXF.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hXF.mForumId));
            this.mData.setForumName(this.hXF.mForumName);
        }
        this.aZR.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aZR.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aZR.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aZR.getWriteData().setVoice(null);
                this.aZR.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aZR.getWriteData().setVoice(null);
            this.aZR.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aZR.bED()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.aZR.startPostWrite();
        }
    }

    private void u(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hXs != null) {
                i2 = this.hXs.getTotalCount();
                i = this.hXs.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(e.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.haM == getCurrentFocus()) {
                    bPr().clearFocus();
                    this.haM.requestFocus();
                    if (this.aYo != null) {
                        this.aYo.Kw();
                    }
                    ShowSoftKeyPadDelay(this.haM);
                } else {
                    bPr().requestFocus();
                    if (this.aYo != null) {
                        this.aYo.Kw();
                    }
                    ShowSoftKeyPadDelay(this.haQ);
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
                            bPr().getText().insert(bPr().getSelectionStart(), sb.toString());
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
                                bPO();
                            } else {
                                ak(intent);
                            }
                        } else if (intExtra == 1) {
                            al(intent);
                        } else {
                            ai(intent);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hYI) {
                            oF(true);
                            this.hYI = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hXE) {
                        B(intent);
                        bzd();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aYo.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aYo.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aYo.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bzd();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hXk) {
                                sb2.append(com.baidu.tbadk.plugins.b.bhy);
                                this.hXk = false;
                            }
                            sb2.append(stringExtra);
                            hJ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hXF = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hXF);
                }
            }
        } else if (i2 == 0) {
            if (this.aYo != null && !this.aYo.Ma()) {
                this.haQ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aYo.Kw();
            }
            switch (i) {
                case 12001:
                    MF();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bPM();
                    if (this.hYI) {
                        oF(true);
                        this.hYI = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.haM == getCurrentFocus()) {
                        bPr().clearFocus();
                        this.haM.requestFocus();
                        if (this.aYo != null) {
                            this.aYo.Kw();
                        }
                        ShowSoftKeyPadDelay(this.haM);
                        return;
                    }
                    bPr().requestFocus();
                    if (this.aYo != null) {
                        this.aYo.Kw();
                    }
                    ShowSoftKeyPadDelay(this.haQ);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hXK.xr(postWriteCallBackData.getErrorString());
                        this.hXK.az(postWriteCallBackData.getSensitiveWords());
                        this.hXK.b(this.haM, this.haQ);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aZP = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aZP);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bPM();
                    return;
                case 25004:
                    if ("from_title".equals(this.hXj)) {
                        bPs().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hXj)) {
                        bPr().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if ("1".equals(this.eeJ)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.eeJ)) {
            this.mData.setCanNoForum(false);
        }
        bPz();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.eeJ);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bPx();
    }

    private void bPz() {
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bPL() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bPM() {
        if (this.hXE) {
            this.hYk.c(this.writeImagesInfo);
            bPN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPN() {
        this.hYk.notifyDataSetChanged();
        this.hYj.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hYk.notifyDataSetChanged();
                WriteActivity.this.hYj.invalidateViews();
            }
        }, 550L);
    }

    public void t(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bzd();
    }

    private void ai(Intent intent) {
        if (this.hXE) {
            aj(intent);
            bPM();
        } else {
            am(intent);
        }
        bzd();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bPM();
            oG(true);
        }
    }

    private void ak(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bPO() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hYh.parseJson(stringExtra);
            this.hYh.updateQuality();
            if (this.hYh.getChosedFiles() != null && this.hYh.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hYh.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hYh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bPs());
        HidenSoftKeyPad(this.mInputManager, bPr());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aZP = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aZP;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aZP, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bPP();
            bPA();
        }
        oG(true);
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
                bPP();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bPA();
                }
            }
            oG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPP() {
        if (this.aYo.fK(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void MF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aZP));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oG(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hYi != null) {
            this.hYi.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aAX() {
        this.dIc = getVoiceManager();
        this.dIc.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dJg) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCK));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hXs == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZW = i;
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bPA() {
        if (!this.hXE) {
            if (this.aYo != null) {
                this.aYo.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aYo.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hYi != null) {
                this.hYi.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.aYo != null) {
            this.aYo.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xt(int i) {
        if (i < this.hXq.size()) {
            for (int i2 = 0; i2 < this.hXq.size(); i2++) {
                this.hXq.get(i2).ou(false);
            }
            this.hXq.get(i).ou(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void uT(int i) {
        if (i == v.H(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").x("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").x("obj_type", 2));
        }
        this.hau = i;
        this.haS.setCurrentIndex(i);
        xt(i);
        this.haR.setText(this.mPrefixData.getPrefixs().get(i));
        bzd();
        com.baidu.adp.lib.g.g.a(this.haS, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.haU.setSelected(false);
        al.c(this.haT, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.haQ);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Mz();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.aX(getApplicationContext())) {
                ak.a(getPageContext(), this.aZP);
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hXJ = z;
        if (this.hYB && System.currentTimeMillis() - this.hYC < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.hYB = false;
        }
        if (this.hXI != null && !z) {
            this.hXI.blc();
        }
        if (this.hXL != null && !z) {
            bPd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hYy != null) {
            xP(str);
            this.hYy.dismiss();
        }
    }

    private void dj(Context context) {
        hYA = l.aQ(context);
    }

    private void xP(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hYB = true;
        bPP();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bPA();
        }
        oG(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4240=4] */
    private static Bitmap f(String str, float f) {
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

    private File bPQ() {
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

    private void bPR() {
        if (this.hYv != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            dj(getActivity());
            this.hYx = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.hYx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hYv != null) {
                        WriteActivity.this.xO(WriteActivity.this.hYv.getAbsolutePath());
                    }
                }
            });
            this.hYw = (TbImageView) this.hYx.findViewById(e.g.rec_img_view);
            this.hYz = (LinearLayout) this.hYx.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hYv.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hYv.getAbsolutePath());
                Bitmap f = f(this.hYv.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0210e.ds160));
                if (f != null) {
                    this.hYw.setImageBitmap(f);
                    this.hYw.setDrawBorder(true);
                    this.hYw.setBorderWidth(2);
                    this.hYw.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.hYy = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.hYy.setCanceledOnTouchOutside(true);
                    this.hYy.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hYB) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hYC = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hYy.setContentView(this.hYx);
                    this.hYy.show();
                    Window window = this.hYy.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0210e.ds28);
                    attributes.y = (hYA / 18) + getResources().getDimensionPixelSize(e.C0210e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(e.C0210e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(e.C0210e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hXJ && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hXk = false;
            this.hXj = "";
            if ("from_content".equals(str)) {
                this.hXj = "from_content";
            } else if ("from_title".equals(str)) {
                this.hXj = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ir(String.valueOf(charSequence.charAt(i)))) {
                oD(false);
            }
        }
    }

    public void bvl() {
        if (this.hXX || !v.I(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hXn.setVisibility(0);
            this.hXn.requestFocus();
            this.aYo.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hXn.setVisibility(8);
    }
}
