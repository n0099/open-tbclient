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
    private static int hRq = 0;
    private EditorTools aUR;
    private String aWs;
    private LocationModel aWt;
    private NewWriteModel aWu;
    private VoiceManager dBD;
    private LinearLayout fQI;
    private PlayVoiceBntNew fQJ;
    private ImageView fQL;
    private int gTC;
    private TextView gTZ;
    private com.baidu.tieba.write.d gUa;
    private ImageView gUb;
    private View gUc;
    private e hQB;
    private com.baidu.tieba.view.b hQI;
    private View hQR;
    private g hQY;
    private LinearLayout hQc;
    private LinearLayout hQd;
    private View hQf;
    private Toast hQh;
    private AdditionData hQi;
    private RelativeLayout hQj;
    private TextView hQk;
    private TextView hQl;
    private TextView hQm;
    List<x> hQn;
    x hQo;
    private int hQp;
    private String hQq;
    private int hQr;
    private PostCategoryView hQs;
    private HotTopicBussinessData hQv;
    private TextView hQw;
    private com.baidu.tieba.write.editor.b hQy;
    private View hRu;
    private View hRv;
    private TextView hRw;
    private com.baidu.tieba.c.d hRz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hPZ = "";
    private boolean hQa = false;
    private WriteData mData = null;
    private boolean hQN = false;
    private boolean hQb = false;
    private boolean hQO = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gTU = null;
    private HeadImageView hQP = null;
    private View gTV = null;
    private LinearLayout gTX = null;
    private EditText gTY = null;
    private FeedBackModel hQe = null;
    private FeedBackTopListView hQQ = null;
    private ArrayList<WritePrefixItemLayout> hQg = new ArrayList<>();
    private String foG = null;
    private final KeyEvent dkp = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aJu = null;
    private TextView hQS = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hQT = null;
    private final Handler mHandler = new Handler();
    private boolean hQU = false;
    private String hQV = null;
    private RelativeLayout mParent = null;
    private String aWy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aWz = 0;
    private int hQW = 0;
    private WriteImagesInfo hQX = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hQZ = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hRa = null;
    private ScrollView hQt = null;
    private EditText hRb = null;
    private View hRc = null;
    private View hRd = null;
    private View hRe = null;
    private EditText hRf = null;
    private TextView hRg = null;
    private TextView hRh = null;
    private TextWatcher hRi = null;
    private TextWatcher hRj = null;
    private boolean hQu = false;
    private boolean hRk = false;
    private com.baidu.tbadk.core.view.d beC = null;
    private String mFrom = "write";
    private File hRl = null;
    private TbImageView hRm = null;
    private View hRn = null;
    private Dialog hRo = null;
    private LinearLayout hRp = null;
    private boolean hRr = false;
    private long hRs = -1000;
    private boolean hRt = false;
    private String dYg = "2";
    private int hKz = 0;
    private String hRx = "";
    private SpannableStringBuilder hQx = new SpannableStringBuilder();
    private boolean hRy = false;
    private boolean hQz = false;
    private final b hQA = new b();
    private final HttpMessageListener hRA = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.foG)) {
                    WriteActivity.this.foG = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oD(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.foG)) {
                    WriteActivity.this.foG = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.foG);
                    WriteActivity.this.oD(true);
                }
            }
        }
    };
    private TbFaceManager.a hQC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan hL(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oq());
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
    private final AntiHelper.a dCH = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azk));
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.azn();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hQA.az(null);
                if (z) {
                    WriteActivity.this.cx(z);
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
                        if (!v.I(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hRx)) {
                            TiebaStatic.log(new am("c11731").ax(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hRx));
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
                    WriteActivity.this.hQA.az(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hQA.wO(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hQA.b(WriteActivity.this.gTU, WriteActivity.this.gTY);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.FS());
                    if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.FR());
                        if (WriteActivity.this.hQO) {
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
    private final LocationModel.a aWG = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LJ() {
            WriteActivity.this.showToast(e.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void hA(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(e.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bBZ())) {
                WriteActivity.this.b(2, true, aVar.bBZ());
            } else {
                hA(null);
            }
        }
    };
    private final CustomMessageListener hgG = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aWt.nv(false);
                    WriteActivity.this.aWt.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aWt.nv(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hQD = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hQE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bMU = WriteActivity.this.bMU();
            if (bMU >= 0 && bMU < WriteActivity.this.gTY.getText().length()) {
                WriteActivity.this.gTY.setSelection(bMU);
            }
        }
    };
    private boolean hQF = true;
    private final View.OnFocusChangeListener gTS = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gTU || view == WriteActivity.this.aJu || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hQF = true;
                    WriteActivity.this.bMV();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.gTU);
                    if (WriteActivity.this.aUR != null) {
                        WriteActivity.this.aUR.Js();
                    }
                } else if (view == WriteActivity.this.gTU) {
                    WriteActivity.this.gTZ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gTY && z) {
                WriteActivity.this.hQF = false;
                WriteActivity.this.bMV();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.gTY);
                if (WriteActivity.this.aUR != null) {
                    WriteActivity.this.aUR.Js();
                }
            }
            WriteActivity.this.bNb();
        }
    };
    private TextWatcher hQG = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hQK = "";
        private String hQL;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hQL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hQL != null ? this.hQL.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bxk();
            WriteActivity.this.bNc();
            EditText bNn = WriteActivity.this.bNn();
            if (editable != null && bNn != null && bNn.getText() != null) {
                if (this.hQK == null || !this.hQK.equals(editable.toString())) {
                    if (WriteActivity.this.hQA != null) {
                        this.hQK = bNn.getText().toString();
                        WriteActivity.this.hQA.k(bNn);
                        return;
                    }
                    return;
                }
                bNn.setSelection(bNn.getSelectionEnd());
            }
        }
    };
    private TextWatcher hQH = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hQL;
        private String hQM = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hQL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hQL != null ? this.hQL.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bxk();
            EditText bNm = WriteActivity.this.bNm();
            if (editable != null && bNm != null && bNm.getText() != null) {
                if (this.hQM == null || !this.hQM.equals(editable.toString())) {
                    if (WriteActivity.this.hQA != null) {
                        this.hQM = bNm.getText().toString();
                        WriteActivity.this.hQA.k(bNm);
                        return;
                    }
                    return;
                }
                bNm.setSelection(bNm.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0303a fXr = new a.InterfaceC0303a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0303a
        public void onRefresh() {
            WriteActivity.this.foG = null;
            WriteActivity.this.oD(false);
            WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void Lu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Lv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lx();
        } else if (this.aWt.bCg()) {
            Lu();
        } else {
            this.aWt.nv(false);
            b(1, true, null);
            this.aWt.bCe();
        }
    }

    private void Lx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cN(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aWt.akJ();
                } else {
                    WriteActivity.this.aWG.LJ();
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
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMU() {
        int selectionEnd = bNm().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bNm().getText().getSpans(0, bNm().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bNm().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bNm().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMV() {
        if (this.aUR != null) {
            this.aUR.setBarLauncherEnabled(!this.hQF);
            this.aUR.setBarLauncherEnabled(true, 26);
            this.aUR.setBarLauncherEnabled(true, 2);
            K(9, this.hQF ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g ft;
        if (this.aUR != null && (ft = this.aUR.ft(i)) != null) {
            if (z) {
                ft.pO();
            } else {
                ft.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hQu) {
            this.gTU.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hRe.setVisibility(8);
            } else {
                this.hRe.setVisibility(0);
            }
            a(this.hRh, this.hRb);
            a(this.hRg, this.hRf);
            bxk();
        }
        if (this.hQN) {
            this.hQF = true;
            bMV();
            if (this.aUR != null) {
                this.aUR.Js();
            }
            this.gTU.requestFocus();
            ShowSoftKeyPadDelay(this.gTU);
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
            bNK();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bNv();
            }
            oE(true);
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
            wX(this.hKz);
        }
        initUI();
        bNA();
        this.aWt = new LocationModel(this);
        this.aWt.a(this.aWG);
        registerListener(this.hgG);
        registerListener(this.hQD);
        initEditor();
        bNM();
        if (this.hQu) {
            this.hRa.setEditorTools(this.aUR);
        } else {
            this.gTY.requestFocus();
        }
        btt();
        bNv();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aUR = new EditorTools(getActivity());
        this.aUR.setBarMaxLauCount(5);
        this.aUR.setMoreButtonAtEnd(true);
        this.aUR.setBarLauncherType(1);
        this.aUR.cp(true);
        this.aUR.cq(true);
        this.aUR.setMoreLauncherIcon(e.f.write_more);
        this.aUR.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bNy();
                break;
            default:
                bMW();
                break;
        }
        this.aUR.KU();
        if (this.hQc != null) {
            this.hQc.addView(this.aUR);
        }
        bMX();
        this.aUR.pO();
        com.baidu.tbadk.editortools.g ft = this.aUR.ft(6);
        if (ft != null && !TextUtils.isEmpty(this.aWy)) {
            ((View) ft).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aWy);
                }
            });
        }
        if (!this.hQu) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aUR.Js();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bMZ();
    }

    private void bNw() {
        this.hRc = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.hRe = this.hRc.findViewById(e.g.live_post_title_container);
        this.hRb = (EditText) this.hRc.findViewById(e.g.live_post_content);
        this.hQZ = (GridView) this.hRc.findViewById(e.g.photoLiveGridView);
        this.hRf = (EditText) this.hRc.findViewById(e.g.live_post_title);
        this.hRg = (TextView) this.hRc.findViewById(e.g.titleOverPlusNumber);
        this.hRh = (TextView) this.hRc.findViewById(e.g.contentOverPlusNumber);
        this.hRd = this.hRc.findViewById(e.g.live_interval_view);
        this.hRg.setText(String.valueOf(20));
        this.hRh.setText(String.valueOf(233));
        this.hRc.setVisibility(0);
        this.hRg.setVisibility(0);
        this.hRh.setVisibility(0);
        this.hRf.setHint(e.j.tips_title_limit_new);
        this.hRf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hRk = true;
                    WriteActivity.this.hQF = true;
                    WriteActivity.this.bMV();
                    if (WriteActivity.this.aUR != null) {
                        WriteActivity.this.aUR.Js();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hRb.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hRb.setHint(e.j.live_write_input_content_update);
        }
        this.hRb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hRk = false;
                    WriteActivity.this.hQF = false;
                    WriteActivity.this.bMV();
                    if (WriteActivity.this.aUR != null) {
                        WriteActivity.this.aUR.Js();
                    }
                }
            }
        });
        this.hRb.requestFocus();
        this.hRb.addTextChangedListener(getTextWatcher());
        this.hRf.requestFocus();
        this.hRf.addTextChangedListener(getTextWatcher());
        this.hRf.setOnClickListener(this.hQE);
        this.hRb.setOnClickListener(this.hQE);
        this.hRa = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hQZ);
        this.hRa.wR(6);
        this.hQZ.setAdapter((ListAdapter) this.hRa);
        View findViewById = this.hRc.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bMF() {
                WriteActivity.this.bNI();
            }
        });
        bNx();
    }

    private void bNx() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hRf.setText(this.mData.getTitle());
                this.hRf.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hQu) {
            bNG();
        }
        if (this.aUR.KW()) {
            this.aUR.Js();
        }
        wX(0);
    }

    private void wX(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.dYg);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bNy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aUR.w(arrayList);
        com.baidu.tbadk.editortools.k fw = this.aUR.fw(5);
        if (fw != null) {
            fw.aVA = 2;
            fw.aVy = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aVy = e.f.write_at;
        this.aUR.b(aVar);
        this.aUR.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bMW() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aVy = e.f.write_picture;
        this.aUR.b(dVar);
        Boolean bNE = bNE();
        if (!this.hQN && bNE != null && bNE.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bCI() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aVA = 3;
            kVar5.aVy = e.f.write_recorder;
            this.aUR.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aVy = e.f.icon_post_topic_selector;
        this.aUR.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aVA = 5;
            kVar4.aVy = e.f.write_privilege;
            this.aUR.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aVA = 6;
            kVar3.aVy = this.hQN ? e.f.write_location : e.f.icon_post_more_location;
            this.aUR.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aVy = e.f.icon_post_more_at;
        this.aUR.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aVC = true;
            kVar2.aVA = 9;
            kVar2.aVy = 0;
            this.aUR.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aVC = true;
            kVar.aVA = 10;
            kVar.aVy = 0;
            this.aUR.b(kVar);
        }
        if (this.hQi == null) {
            if (this.hQy == null) {
                this.hQy = new com.baidu.tieba.write.editor.b(getActivity(), this.dYg);
                this.hQy.aY(this.mData.getForumId(), this.privateThread);
            }
            this.aUR.b(this.hQy);
        }
        this.aUR.w(arrayList);
        com.baidu.tbadk.editortools.k fw = this.aUR.fw(5);
        if (fw != null) {
            fw.aVA = 1;
            fw.aVy = e.f.write_emotion;
        }
    }

    private void bMY() {
        if (this.hQB != null) {
            this.hQB.hideTip();
        }
    }

    private void bMZ() {
        if (this.hQB == null) {
            this.hQB = new e(getPageContext());
        }
        this.hQB.c(this.aUR);
    }

    private void bMX() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bNl()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bNl()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bNo();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bhh();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bNK();
                        WriteActivity.this.bxk();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.wY(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hQi == null) {
                            WriteActivity.this.Ly();
                            return;
                        }
                        switch (WriteActivity.this.aWz) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bz(pageActivity)) {
                                    WriteActivity.this.Lv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Lu();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aWt != null) {
                            WriteActivity.this.aWt.nv(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.foG = null;
                        } else {
                            WriteActivity.this.foG = (String) aVar.data;
                        }
                        WriteActivity.this.oD(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.ax(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aUR.KW()) {
                                        WriteActivity.this.aUR.Js();
                                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bxk();
                        if (WriteActivity.this.gTY != null) {
                            WriteActivity.this.gTY.requestFocus();
                        }
                        WriteActivity.this.aUR.Js();
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gTY);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hQa = true;
                        WriteActivity.this.oB(true);
                        if (!WriteActivity.this.bNn().isFocused() || WriteActivity.this.hQd.getVisibility() != 0) {
                            WriteActivity.this.hPZ = "from_content";
                        } else {
                            WriteActivity.this.hPZ = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hQd.setVisibility(0);
                        WriteActivity.this.hQd.requestFocus();
                        WriteActivity.this.bxk();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hQd.hasFocus()) {
                            WriteActivity.this.gTY.requestFocus();
                            WriteActivity.this.gTY.setSelection(WriteActivity.this.gTY.getText().toString().length());
                        }
                        WriteActivity.this.hQd.setVisibility(8);
                        WriteActivity.this.bxk();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aUR.setActionListener(16, bVar);
        this.aUR.setActionListener(14, bVar);
        this.aUR.setActionListener(24, bVar);
        this.aUR.setActionListener(3, bVar);
        this.aUR.setActionListener(10, bVar);
        this.aUR.setActionListener(11, bVar);
        this.aUR.setActionListener(12, bVar);
        this.aUR.setActionListener(13, bVar);
        this.aUR.setActionListener(15, bVar);
        this.aUR.setActionListener(18, bVar);
        this.aUR.setActionListener(20, bVar);
        this.aUR.setActionListener(25, bVar);
        this.aUR.setActionListener(27, bVar);
        this.aUR.setActionListener(29, bVar);
        this.aUR.setActionListener(43, bVar);
        this.aUR.setActionListener(45, bVar);
        this.aUR.setActionListener(53, bVar);
        this.aUR.setActionListener(48, bVar);
        this.aUR.setActionListener(46, bVar);
        this.aUR.setActionListener(49, bVar);
        this.aUR.setActionListener(47, bVar);
        this.aUR.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ly() {
        if (this.aWt.akF()) {
            if (this.aWt.bCg()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bCc().getLocationData().bBZ());
                return;
            }
            b(1, true, null);
            this.aWt.bCe();
            return;
        }
        b(0, true, null);
    }

    protected void bxc() {
        if (this.aWu != null) {
            this.aWu.cancelLoadData();
        }
        if (this.hQe != null) {
            this.hQe.cancelLoadData();
        }
        if (this.aWt != null) {
            this.aWt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bMY();
        TiebaPrepareImageService.StopService();
        bxc();
        bND();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hQY != null) {
            this.hQY.destroy();
        }
        if (this.hRz != null) {
            this.hRz.apA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNa() {
        if (this.mData != null && this.mData.getType() == 2 && this.hQU) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bNn().getText().toString());
            this.mData.setContent(bNm().getText().toString());
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
            if (this.gUa != null && this.gUa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gUa, getPageContext().getPageActivity());
                return true;
            } else if (this.aUR.KW()) {
                this.aUR.Js();
                return true;
            } else {
                bxc();
                bNa();
                return true;
            }
        }
        if (i == 67 && (text = bNm().getText()) != null) {
            int selectionStart = bNm().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNm().onKeyDown(67, this.dkp);
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
        getLayoutMode().onModeChanged(this.hRp);
        if (this.hRm != null && i == 1) {
            this.hRm.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bMV();
        al.j(this.hRc, e.d.cp_bg_line_d);
        al.j(this.gTV, e.d.cp_bg_line_c);
        al.j(this.hRd, e.d.cp_bg_line_c);
        al.j(bNn(), e.d.cp_bg_line_d);
        al.c(this.fQL, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.foG)) {
            al.j(bNm(), e.d.cp_bg_line_d);
        }
        bxk();
        this.aUR.onChangeSkinType(i);
        if (this.hQs != null) {
            this.hQs.Ef();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bNb();
        bNc();
        if (this.hQA != null) {
            this.hQA.c(bNn(), bNm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNb() {
        if (this.gTU.hasFocus()) {
            this.gTU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gTU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.gTY.hasFocus()) {
            this.gTY.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gTY.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNc() {
        if (this.gTU != null && this.gTU.getText() != null && this.gTU.getText().toString() != null && this.gTU.getPaint() != null) {
            if (this.gTU.getText().toString().length() == 0) {
                this.gTU.getPaint().setFakeBoldText(false);
            } else if (this.gTU.getText().toString().length() > 0) {
                this.gTU.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.beC = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hQu = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.hQS = (TextView) findViewById(e.g.btn_image_problem);
        bNe();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0200e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gTS);
        this.hQt = (ScrollView) findViewById(e.g.write_scrollview);
        this.hQt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gTY != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gTY);
                    }
                    if (WriteActivity.this.aUR != null) {
                        WriteActivity.this.aUR.Js();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hQQ = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.hQR = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hQc = (LinearLayout) findViewById(e.g.tool_view);
        this.hQc.setContentDescription("..");
        this.hQd = (LinearLayout) findViewById(e.g.title_view);
        this.gTV = findViewById(e.g.interval_view);
        this.hRu = findViewById(e.g.hot_topic_fourm_view);
        this.hRv = findViewById(e.g.hot_topic_divider);
        this.hQw = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.hRw = (TextView) findViewById(e.g.change_one_tv);
        bxj();
        if (this.hQu) {
            this.hQt.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bNw();
        } else {
            this.hQY = new g(getPageContext(), this.mRootView);
            g gVar = this.hQY;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.ow(z);
        }
        bxl();
        if (this.hQN || this.hQb) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().azW) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gTX = (LinearLayout) findViewById(e.g.post_content_container);
        this.gTX.setDrawingCacheEnabled(false);
        this.gTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gTY.requestFocus();
            }
        });
        this.fQI = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fQJ = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fQL = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bhh();
            }
        });
        this.aJu.setOnFocusChangeListener(this.gTS);
        this.aJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bxc();
                WriteActivity.this.bNa();
            }
        });
        this.hQS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bNh();
        j(bNE());
        bNj();
        bNd();
        bNB();
        bNC();
        bMV();
        bNi();
        bxi();
        bNp();
        if (this.mData.getType() == 4 && this.gUc != null && this.hQf != null) {
            this.gUc.setVisibility(8);
            this.hQf.setVisibility(8);
        }
        bxk();
        bNz();
    }

    private void bNd() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hQN || this.hQb) {
                        if (this.hQO) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.dYg != null && this.dYg.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.dYg != null && this.dYg.equals("2")) {
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
                    this.gTU.setVisibility(0);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gTU.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hRd.setVisibility(8);
                    return;
                case 7:
                    this.gTU.setVisibility(0);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bNe() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bNf() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hQN && !this.hQb && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bNn() != null) {
                bNn().setText(c);
                bNn().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fQI.setVisibility(0);
            this.fQJ.setVoiceModel(voiceModel);
            this.fQJ.bCH();
            bxk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhh() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fQI.setVisibility(8);
        this.fQJ.aKF();
        this.fQJ.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fw = this.aUR.fw(6);
        if (fw != null && fw.aUL != null) {
            fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bxk();
    }

    private void bNg() {
        this.hQn = null;
        this.hQp = -1;
        this.hQr = -1;
        z lX = y.aAH().lX(1);
        if (lX != null) {
            this.hQn = lX.dEU;
            this.hQp = getIntent().getIntExtra("category_id", -1);
            if (this.hQn != null && !this.hQn.isEmpty() && this.hQp >= 0) {
                this.hQo = new x();
                this.hQo.dEQ = 0;
                this.hQo.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hQr = this.hQo.dEQ;
                this.hQq = this.hQo.name;
                for (x xVar : this.hQn) {
                    if (xVar.dEQ == this.hQp) {
                        this.hQr = xVar.dEQ;
                        this.hQq = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bNh() {
        if (this.hQn != null && !this.hQn.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hQs = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hQs.setText(this.hQq);
            this.hQs.setCategoryContainerData(this.hQn, this.hQo, this.hQr);
            this.hQs.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hQs.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dEQ);
                        WriteActivity.this.hQr = atVar.dEQ;
                        WriteActivity.this.hQs.bMI();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hQs.bMH();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNn());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNm());
                }
            });
        }
    }

    private void bNz() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hQI = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hQI.setTitle(e.j.no_disturb_start_time);
        this.hQI.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hQI);
        this.hQI.setButton(-2, getPageContext().getString(e.j.cancel), this.hQI);
        return this.hQI;
    }

    private void bNi() {
        this.hQj = (RelativeLayout) findViewById(e.g.addition_container);
        this.hQk = (TextView) findViewById(e.g.addition_create_time);
        this.hQl = (TextView) findViewById(e.g.addition_last_time);
        this.hQm = (TextView) findViewById(e.g.addition_last_content);
        if (this.hQi != null) {
            this.hQj.setVisibility(0);
            this.hQk.setText(getPageContext().getString(e.j.write_addition_create) + ao.E(this.hQi.getCreateTime() * 1000));
            if (this.hQi.getAlreadyCount() == 0) {
                this.hQl.setVisibility(8);
            } else {
                this.hQl.setText(getPageContext().getString(e.j.write_addition_last) + ao.E(this.hQi.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hQi.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hQm.setText(lastAdditionContent);
            } else {
                this.hQm.setVisibility(8);
            }
            bNm().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hQi.getAlreadyCount()), Integer.valueOf(this.hQi.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hQj.setVisibility(8);
    }

    private void bxi() {
        this.gUc = findViewById(e.g.post_prefix_layout);
        if (this.hRz == null) {
            this.hRz = new com.baidu.tieba.c.d(getPageContext(), this.gUc);
            this.hRz.kE(e.f.bg_tip_blue_up_left);
            this.hRz.kD(16);
            this.hRz.fF(true);
            this.hRz.aa(true);
            this.hRz.kH(l.h(getActivity(), e.C0200e.ds32));
        }
        this.gTZ = (TextView) findViewById(e.g.post_prefix);
        this.hQf = findViewById(e.g.prefix_divider);
        this.gUb = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gUc.setVisibility(0);
            this.hRz.h(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gTC = 0;
            this.gUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ax(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).h("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gTZ.setVisibility(0);
                    WriteActivity.this.gUc.setSelected(true);
                    al.c(WriteActivity.this.gUb, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gUa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aUR.Js();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gTU);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gTY);
                }
            });
            this.gTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ax(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).h("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gTZ.setSelected(true);
                    al.c(WriteActivity.this.gUb, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gUa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aUR.Js();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNn());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNm());
                }
            });
            this.gUa = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gUa.a(this);
            this.gUa.setMaxHeight(l.h(getActivity(), e.C0200e.ds510));
            this.gUa.setOutsideTouchable(true);
            this.gUa.setFocusable(true);
            this.gUa.setOnDismissListener(this);
            this.gUa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.gTZ, e.d.cp_bg_line_d);
            al.c(this.gUb, e.f.icon_arrow_gray_down);
            this.gTZ.setTextColor(color);
            this.hQg.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hQg.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.or(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.or(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gUa.addView(writePrefixItemLayout);
            }
            this.gUa.setCurrentIndex(0);
            this.gTZ.setText(prefixs.get(0));
            wW(0);
            return;
        }
        this.gUc.setVisibility(8);
    }

    private void bNA() {
        if (this.hQN && this.mData != null) {
            this.hQQ.setVisibility(0);
            this.hQR.setVisibility(0);
            this.hQe = new FeedBackModel(getPageContext());
            this.hQe.xj(this.mData.getForumName());
            this.hQe.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hQQ.setVisibility(8);
                        WriteActivity.this.hQR.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hQQ.setVisibility(8);
                        WriteActivity.this.hQR.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hQQ.a(feedBackModel.bMK(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bNj() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hQA.a(WriteActivity.this.gTU, WriteActivity.this.gTY)) {
                        WriteActivity.this.showToast(WriteActivity.this.hQA.bKT());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNn());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNm());
                    WriteActivity.this.aUR.Js();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hQN) {
                            WriteActivity.this.bNs();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.x("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bNt();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bNs();
                    }
                    TiebaStatic.log(new am("c12262").ax("obj_locate", WriteActivity.this.dYg));
                }
            }
        });
    }

    protected void bNB() {
        this.hQT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hQT.ej(getPageContext().getString(e.j.is_save_draft)).be(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bNn().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bNm().getText().toString());
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
        this.hQT.b(getPageContext());
    }

    protected void bxj() {
        this.hQP = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.hQP.setIsRound(true);
        this.hQP.setDrawBorder(false);
        this.hQP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String fc = o.fc(currentPortrait);
            this.hQP.setUrl(fc);
            this.hQP.startLoad(fc, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hQP.setVisibility(0);
        }
        this.gTU = (EditText) findViewById(e.g.post_title);
        this.gTU.setOnClickListener(this.hQE);
        this.gTU.setOnFocusChangeListener(this.gTS);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gTU.setText(this.mData.getTitle());
                this.gTU.setSelection(this.mData.getTitle().length());
            } else if (this.hQO) {
                this.gTU.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gTU.addTextChangedListener(this.hQG);
        if (!this.mData.getHaveDraft()) {
            bNf();
            this.hRt = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gTU.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.gTU.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher getTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hRD;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bxk();
                if (WriteActivity.this.hQu) {
                    this.hRD = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hRD);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hQu || !WriteActivity.this.hRk) {
                    if (WriteActivity.this.hQu) {
                        if (this.mEditText != WriteActivity.this.hRb || this.mTextView != WriteActivity.this.hRh) {
                            this.mEditText = WriteActivity.this.hRb;
                            this.mTextView = WriteActivity.this.hRh;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hRf || this.mTextView != WriteActivity.this.hRg) {
                    this.mEditText = WriteActivity.this.hRf;
                    this.mTextView = WriteActivity.this.hRg;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hQu && this.hRk) {
            if (this.hRi != null) {
                this.hRf.removeTextChangedListener(this.hRi);
            }
            this.hRi = textWatcher;
        } else if (this.hQu) {
            if (this.hRj != null) {
                this.hRb.removeTextChangedListener(this.hRj);
            }
            this.hRj = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hRb) {
            return 233L;
        }
        if (editText != this.hRf) {
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

    protected void bxl() {
        this.gTY = (EditText) findViewById(e.g.post_content);
        this.gTY.setDrawingCacheEnabled(false);
        this.gTY.setOnClickListener(this.hQE);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString aj = TbFaceManager.Mp().aj(getPageContext().getPageActivity(), this.mData.getContent());
            this.gTY.setText(aj);
            this.gTY.setSelection(aj.length());
        } else if (this.mData.getType() == 2) {
            if (this.hQU) {
                if (this.hQV != null && this.hQV.length() > 0) {
                    this.gTY.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.hQV}));
                    this.gTY.setSelection(this.gTY.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gTY.setText(format);
                this.gTY.setSelection(format.length());
            }
        }
        this.gTY.setOnFocusChangeListener(this.gTS);
        this.gTY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gTY.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gTY.addTextChangedListener(this.hQH);
        if (this.mData.getType() == 0) {
            this.hRy = true;
        } else {
            oD(true);
            this.hRy = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gTY.setHint(e.j.write_input_content);
        } else {
            this.gTY.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oD(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hQu) {
            bNm().setPadding(0, 0, 0, 0);
            bNm().setBackgroundDrawable(null);
            al.j(bNm(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.foG) && this.hQi == null) {
                com.baidu.adp.lib.f.c.jA().a(this.foG, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.oq() != null && aVar.ou() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.oq(), aVar.oq().getNinePatchChunk(), aVar.ou(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bNm().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bNm(), true, WriteActivity.this.fXr);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNl() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.hQi != null) {
            i = 1000;
        }
        return bNm().getText() != null && bNm().getText().length() >= i;
    }

    private void hr(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hPZ)) {
                this.hPZ = "";
                bNm().requestFocus();
                if (bNm().getText() != null && bNm().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNm().getSelectionStart();
                    editable = bNm().getText();
                }
            } else if ("from_title".equals(this.hPZ)) {
                this.hPZ = "";
                bNn().requestFocus();
                if (bNn().getText() != null && bNn().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNn().getSelectionStart();
                    editable = bNn().getText();
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
    public void oB(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) bNm().getText().getSpans(0, bNm().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hQh == null) {
                this.hQh = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hQh.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType FI = pVar.FI();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bNm().getSelectionStart(), aVar, FI);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bNm() != null && bNm().getText() != null) {
            Bitmap oq = aVar.oq();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oq);
            int width = oq.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oq.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bNm().getSelectionStart() - 1;
                if (bNm().getText().length() > 1 && selectionStart >= 0 && bNm().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bNm().getText().insert(bNm().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bNm().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bNm().getText().insert(bNm().getSelectionStart(), spannableString2);
            }
            Editable text = bNm().getText();
            if (text != null) {
                this.hQx.clear();
                this.hQx.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hQx);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bNm().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bNm().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bNm().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNm() {
        return this.hQu ? this.hRb : this.gTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNn() {
        return this.hQu ? this.hRf : this.gTU;
    }

    protected void bNo() {
        Editable text;
        if (bNm() != null && (text = bNm().getText()) != null) {
            int selectionStart = bNm().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNm().onKeyDown(67, this.dkp);
            }
            bNm().onKeyDown(67, this.dkp);
            int selectionStart2 = bNm().getSelectionStart();
            if (text != null) {
                this.hQx.clear();
                this.hQx.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hQx);
                bNm().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.hQN = true;
        }
    }

    private void bNC() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bND() {
        try {
            if (this.hQT != null) {
                this.hQT.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.beC.d(null);
        this.beC.dO(e.j.sending);
        this.beC.bz(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.beC.bz(false);
    }

    private Boolean bNE() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aWy = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void bxk() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bNn() != null) {
                str = bNn().getText().toString();
            }
            if (bNm() != null) {
                str2 = bNm().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gTC == v.H(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hQd.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            oC(true);
                            return;
                        }
                    } else if (this.hQd.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        oC(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hQd.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    oC(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hQu) {
                    oC(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oC(true);
                }
            }
            if (this.mData.getType() == 4) {
                oC(o(this.hRb) && n(this.hRf));
            } else if (this.mData.getType() == 5) {
                oC(o(this.hRb));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                oC(true);
            } else if (this.mData.getVideoInfo() != null) {
                oC(true);
            } else {
                oC(false);
            }
        }
    }

    public void oC(boolean z) {
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
        this.aWu = new NewWriteModel(this);
        this.aWu.b(this.aWI);
        registerListener(this.hRA);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bxc();
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
            this.hQN = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hQO = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hQU = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hQV = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aWs = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hQi = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hQi != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hQW = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hRx = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.dYg = bundle.getString("KEY_CALL_FROM");
            this.hKz = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hQN = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hQO = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hQU = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hQV = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hQi = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hQi != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hQW = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hRx = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.dYg = intent.getStringExtra("KEY_CALL_FROM");
            this.hKz = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hQN);
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
        this.foG = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hQb = true;
        }
        bNg();
        try {
            this.hRl = bNL();
        } catch (Throwable th) {
            this.hRl = null;
        }
    }

    private void bNp() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gTU.setText(com.baidu.tbadk.plugins.b.ia(com.baidu.tbadk.plugins.b.ib(hotTopicBussinessData.mTopicName)));
            this.gTU.setMovementMethod(com.baidu.tieba.view.c.bJV());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString ia = com.baidu.tbadk.plugins.b.ia(com.baidu.tbadk.plugins.b.ib(hotTopicBussinessData.mTopicName));
            if (ia != null) {
                this.gTU.setText(ia);
            }
            this.hQw.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String ib;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bNn().getText().toString()) || this.hRt || ((this.hQN || this.hQb) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            ib = this.mData.getTitle();
                        } else {
                            ib = com.baidu.tbadk.plugins.b.ib(str);
                        }
                        SpannableString ia = com.baidu.tbadk.plugins.b.ia(ib);
                        if (ia != null) {
                            bNn().setText(ia);
                            bNn().setSelection(ia.length() > ib.length() ? ib.length() : ia.length());
                        }
                    } else {
                        SpannableString ia2 = com.baidu.tbadk.plugins.b.ia(this.mData.getTitle());
                        if (ia2 != null) {
                            bNn().setText(ia2);
                            bNn().setSelection(this.mData.getTitle().length() > ia2.length() ? ia2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bNf();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bNm().getText().toString()) || this.hQN || this.hQb) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Mp().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hQC);
                    bNm().setText(a2);
                    bNm().setSelection(a2.length());
                    if (this.hQu) {
                        a(this.hRh, this.hRb);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bNK();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bNv();
                    }
                    oE(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bNF();
                }
                bxk();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hQn != null) {
                    this.hQr = this.hQo.dEQ;
                    this.hQq = this.hQo.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hQn.size()) {
                            break;
                        }
                        x xVar = this.hQn.get(i);
                        if (categoryTo != xVar.dEQ) {
                            i++;
                        } else {
                            this.hQr = categoryTo;
                            this.hQq = xVar.name;
                            this.mData.setCategoryTo(this.hQr);
                            break;
                        }
                    }
                    if (this.hQs != null) {
                        this.hQs.setText(this.hQq);
                        this.hQs.setCategoryContainerData(this.hQn, this.hQo, this.hQr);
                    }
                }
                this.aUR.Js();
                return;
            }
            return;
        }
        bNF();
        bNf();
    }

    private void bNF() {
        if ((!this.hQu || this.hRa != null) && this.hQZ != null) {
            this.hRa.c(this.writeImagesInfo);
            bNI();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hQU);
        if (this.hQN) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aWs);
        if (this.hQi != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hQi));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hQW);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dYg);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hKz);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bNm().getEditableText().toString();
        if (obj != null) {
            bNm().setText(TbFaceManager.Mp().a(getPageContext().getPageActivity(), obj, this.hQC));
            bNm().setSelection(bNm().getText().length());
        }
    }

    private String bNq() {
        return (bNm() == null || bNm().getText() == null) ? "" : bNm().getText().toString();
    }

    private String bNr() {
        if (this.mData == null || bNn() == null || bNn().getVisibility() != 0 || bNn().getText() == null) {
            return "";
        }
        String obj = bNn().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.gTC != v.H(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gTZ != null && this.gTZ.getText() != null) {
            this.mData.setPostPrefix(this.gTZ.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void xk(String str) {
        if (this.mData != null && this.hQd != null) {
            if (this.hQd.getVisibility() == 0) {
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
    public void bNs() {
        bxc();
        this.mData.setContent(bNq());
        xk(bNr());
        if (this.hQN || this.hQb) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                xk(string + this.mData.getTitle());
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
                    sb.append(com.baidu.adp.lib.util.j.ld());
                } else {
                    sb.append(AiAppRomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hQp >= 0) {
            this.mData.setCategoryFrom(this.hQp);
        }
        if (this.hQr >= 0) {
            this.mData.setCategoryTo(this.hQr);
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
        this.mData.setHasLocationData(this.aWt != null && this.aWt.akF());
        if (this.writeImagesInfo != null) {
            this.aWu.nx(this.writeImagesInfo.size() > 0);
        }
        if (!v.I(this.mList) && this.hQv != null && this.hQv.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hQv.mForumId));
            this.mData.setForumName(this.hQv.mForumName);
        }
        this.aWu.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aWu.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aWu.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aWu.getWriteData().setVoice(null);
                this.aWu.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aWu.getWriteData().setVoice(null);
            this.aWu.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aWu.bCJ()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.aWu.startPostWrite();
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
            if (this.hQi != null) {
                i2 = this.hQi.getTotalCount();
                i = this.hQi.getAlreadyCount() + 1;
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
                if (this.gTU == getCurrentFocus()) {
                    bNm().clearFocus();
                    this.gTU.requestFocus();
                    if (this.aUR != null) {
                        this.aUR.Js();
                    }
                    ShowSoftKeyPadDelay(this.gTU);
                } else {
                    bNm().requestFocus();
                    if (this.aUR != null) {
                        this.aUR.Js();
                    }
                    ShowSoftKeyPadDelay(this.gTY);
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
                            bNm().getText().insert(bNm().getSelectionStart(), sb.toString());
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
                                bNJ();
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
                        if (this.hRy) {
                            oD(true);
                            this.hRy = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hQu) {
                        B(intent);
                        bxk();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aUR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bxk();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hQa) {
                                sb2.append(com.baidu.tbadk.plugins.b.bdX);
                                this.hQa = false;
                            }
                            sb2.append(stringExtra);
                            hr(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hQv = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hQv);
                }
            }
        } else if (i2 == 0) {
            if (this.aUR != null && !this.aUR.KW()) {
                this.gTY.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aUR.Js();
            }
            switch (i) {
                case 12001:
                    LB();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bNH();
                    if (this.hRy) {
                        oD(true);
                        this.hRy = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gTU == getCurrentFocus()) {
                        bNm().clearFocus();
                        this.gTU.requestFocus();
                        if (this.aUR != null) {
                            this.aUR.Js();
                        }
                        ShowSoftKeyPadDelay(this.gTU);
                        return;
                    }
                    bNm().requestFocus();
                    if (this.aUR != null) {
                        this.aUR.Js();
                    }
                    ShowSoftKeyPadDelay(this.gTY);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hQA.wO(postWriteCallBackData.getErrorString());
                        this.hQA.az(postWriteCallBackData.getSensitiveWords());
                        this.hQA.b(this.gTU, this.gTY);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aWs = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aWs);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bNH();
                    return;
                case 25004:
                    if ("from_title".equals(this.hPZ)) {
                        bNn().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hPZ)) {
                        bNm().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNt() {
        if ("1".equals(this.dYg)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dYg)) {
            this.mData.setCanNoForum(false);
        }
        bNu();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.dYg);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bNs();
    }

    private void bNu() {
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bNG() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bNH() {
        if (this.hQu) {
            this.hRa.c(this.writeImagesInfo);
            bNI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNI() {
        this.hRa.notifyDataSetChanged();
        this.hQZ.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hRa.notifyDataSetChanged();
                WriteActivity.this.hQZ.invalidateViews();
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
        bxk();
    }

    private void ai(Intent intent) {
        if (this.hQu) {
            aj(intent);
            bNH();
        } else {
            am(intent);
        }
        bxk();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bNH();
            oE(true);
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

    private void bNJ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hQX.parseJson(stringExtra);
            this.hQX.updateQuality();
            if (this.hQX.getChosedFiles() != null && this.hQX.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hQX.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hQX.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bNn());
        HidenSoftKeyPad(this.mInputManager, bNm());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aWs = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aWs;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aWs, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bNK();
            bNv();
        }
        oE(true);
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
                bNK();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bNv();
                }
            }
            oE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNK() {
        if (this.aUR.fw(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void LB() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aWs));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oE(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hQY != null) {
            this.hQY.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void azn() {
        this.dBD = getVoiceManager();
        this.dBD.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCH) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azk));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hQi == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aWz = i;
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bNv() {
        if (!this.hQu) {
            if (this.aUR != null) {
                this.aUR.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aUR.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hQY != null) {
                this.hQY.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wW(int i) {
        if (i < this.hQg.size()) {
            for (int i2 = 0; i2 < this.hQg.size(); i2++) {
                this.hQg.get(i2).os(false);
            }
            this.hQg.get(i).os(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void ux(int i) {
        if (i == v.H(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").x("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").x("obj_type", 2));
        }
        this.gTC = i;
        this.gUa.setCurrentIndex(i);
        wW(i);
        this.gTZ.setText(this.mPrefixData.getPrefixs().get(i));
        bxk();
        com.baidu.adp.lib.g.g.a(this.gUa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gUc.setSelected(false);
        al.c(this.gUb, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gTY);
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
            Lv();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.aX(getApplicationContext())) {
                ak.a(getPageContext(), this.aWs);
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
        this.hQz = z;
        if (this.hRr && System.currentTimeMillis() - this.hRs < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.hRr = false;
        }
        if (this.hQy != null && !z) {
            this.hQy.atH();
        }
        if (this.hQB != null && !z) {
            bMY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hRo != null) {
            xm(str);
            this.hRo.dismiss();
        }
    }

    private void df(Context context) {
        hRq = l.aQ(context);
    }

    private void xm(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hRr = true;
        bNK();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bNv();
        }
        oE(true);
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

    private File bNL() {
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

    private void bNM() {
        if (this.hRl != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            df(getActivity());
            this.hRn = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.hRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hRl != null) {
                        WriteActivity.this.xl(WriteActivity.this.hRl.getAbsolutePath());
                    }
                }
            });
            this.hRm = (TbImageView) this.hRn.findViewById(e.g.rec_img_view);
            this.hRp = (LinearLayout) this.hRn.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hRl.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hRl.getAbsolutePath());
                Bitmap f = f(this.hRl.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0200e.ds160));
                if (f != null) {
                    this.hRm.setImageBitmap(f);
                    this.hRm.setDrawBorder(true);
                    this.hRm.setBorderWidth(2);
                    this.hRm.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.hRo = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.hRo.setCanceledOnTouchOutside(true);
                    this.hRo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hRr) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hRs = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hRo.setContentView(this.hRn);
                    this.hRo.show();
                    Window window = this.hRo.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0200e.ds28);
                    attributes.y = (hRq / 18) + getResources().getDimensionPixelSize(e.C0200e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(e.C0200e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(e.C0200e.ds278);
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
        if (this.hQz && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hQa = false;
            this.hPZ = "";
            if ("from_content".equals(str)) {
                this.hPZ = "from_content";
            } else if ("from_title".equals(str)) {
                this.hPZ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hZ(String.valueOf(charSequence.charAt(i)))) {
                oB(false);
            }
        }
    }

    public void btt() {
        if (this.hQN || !v.I(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hQd.setVisibility(0);
            this.hQd.requestFocus();
            this.aUR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hQd.setVisibility(8);
    }
}
