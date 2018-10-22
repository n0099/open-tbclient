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
import com.baidu.f.a.a;
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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.v;
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
    private static int hPG = 0;
    private EditorTools aUb;
    private String aVC;
    private LocationModel aVD;
    private NewWriteModel aVE;
    private VoiceManager dAm;
    private LinearLayout fPj;
    private PlayVoiceBntNew fPk;
    private ImageView fPm;
    private com.baidu.tieba.write.d gSA;
    private ImageView gSB;
    private View gSC;
    private int gSc;
    private TextView gSz;
    private TextView hOA;
    private TextView hOB;
    private TextView hOC;
    List<x> hOD;
    x hOE;
    private int hOF;
    private String hOG;
    private int hOH;
    private PostCategoryView hOI;
    private HotTopicBussinessData hOL;
    private TextView hOM;
    private com.baidu.tieba.write.editor.b hOO;
    private e hOR;
    private com.baidu.tieba.view.b hOY;
    private LinearLayout hOs;
    private LinearLayout hOt;
    private View hOv;
    private Toast hOx;
    private AdditionData hOy;
    private RelativeLayout hOz;
    private View hPK;
    private View hPL;
    private TextView hPM;
    private com.baidu.tieba.c.d hPP;
    private View hPh;
    private g hPo;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hOp = "";
    private boolean hOq = false;
    private WriteData mData = null;
    private boolean hPd = false;
    private boolean hOr = false;
    private boolean hPe = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gSu = null;
    private HeadImageView hPf = null;
    private View gSv = null;
    private LinearLayout gSx = null;
    private EditText gSy = null;
    private FeedBackModel hOu = null;
    private FeedBackTopListView hPg = null;
    private ArrayList<WritePrefixItemLayout> hOw = new ArrayList<>();
    private String fnp = null;
    private final KeyEvent djk = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aIE = null;
    private TextView hPi = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hPj = null;
    private final Handler mHandler = new Handler();
    private boolean hPk = false;
    private String hPl = null;
    private RelativeLayout mParent = null;
    private String aVI = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aVJ = 0;
    private int hPm = 0;
    private WriteImagesInfo hPn = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hPp = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hPq = null;
    private ScrollView hOJ = null;
    private EditText hPr = null;
    private View hPs = null;
    private View hPt = null;
    private View hPu = null;
    private EditText hPv = null;
    private TextView hPw = null;
    private TextView hPx = null;
    private TextWatcher hPy = null;
    private TextWatcher hPz = null;
    private boolean hOK = false;
    private boolean hPA = false;
    private com.baidu.tbadk.core.view.d bdN = null;
    private String mFrom = "write";
    private File hPB = null;
    private TbImageView hPC = null;
    private View hPD = null;
    private Dialog hPE = null;
    private LinearLayout hPF = null;
    private boolean hPH = false;
    private long hPI = -1000;
    private boolean hPJ = false;
    private String dWT = "2";
    private int hIP = 0;
    private String hPN = "";
    private SpannableStringBuilder hON = new SpannableStringBuilder();
    private boolean hPO = false;
    private boolean hOP = false;
    private final b hOQ = new b();
    private final HttpMessageListener hPQ = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fnp)) {
                    WriteActivity.this.fnp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.op(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fnp)) {
                    WriteActivity.this.fnp = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fnp);
                    WriteActivity.this.op(true);
                }
            }
        }
    };
    private TbFaceManager.a hOS = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan hK(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.os());
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
    private final AntiHelper.a dBq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayx));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayx));
        }
    };
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.azQ();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hOQ.aA(null);
                if (z) {
                    WriteActivity.this.cg(z);
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
                        if (!com.baidu.tbadk.core.util.v.J(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hPN)) {
                            TiebaStatic.log(new am("c11731").ax(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hPN));
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
                    WriteActivity.this.hOQ.aA(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hOQ.wJ(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hOQ.b(WriteActivity.this.gSu, WriteActivity.this.gSy);
                } else if ((vVar == null || writeData == null || vVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (vVar != null && writeData != null && vVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.FG());
                    if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.FF());
                        if (WriteActivity.this.hPe) {
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
    private final LocationModel.a aVQ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Lx() {
            WriteActivity.this.showToast(e.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void hz(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(e.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bCD())) {
                WriteActivity.this.b(2, true, aVar.bCD());
            } else {
                hz(null);
            }
        }
    };
    private final CustomMessageListener hfj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aVD.nk(false);
                    WriteActivity.this.aVD.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aVD.nk(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hOT = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hOU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bNv = WriteActivity.this.bNv();
            if (bNv >= 0 && bNv < WriteActivity.this.gSy.getText().length()) {
                WriteActivity.this.gSy.setSelection(bNv);
            }
        }
    };
    private boolean hOV = true;
    private final View.OnFocusChangeListener gSs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gSu || view == WriteActivity.this.aIE || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hOV = true;
                    WriteActivity.this.bNw();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gSu);
                    if (WriteActivity.this.aUb != null) {
                        WriteActivity.this.aUb.Jg();
                    }
                } else if (view == WriteActivity.this.gSu) {
                    WriteActivity.this.gSz.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gSy && z) {
                WriteActivity.this.hOV = false;
                WriteActivity.this.bNw();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gSy);
                if (WriteActivity.this.aUb != null) {
                    WriteActivity.this.aUb.Jg();
                }
            }
            WriteActivity.this.bNC();
        }
    };
    private TextWatcher hOW = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hPa = "";
        private String hPb;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hPb = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hPb != null ? this.hPb.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bxO();
            WriteActivity.this.bND();
            EditText bNO = WriteActivity.this.bNO();
            if (editable != null && bNO != null && bNO.getText() != null) {
                if (this.hPa == null || !this.hPa.equals(editable.toString())) {
                    if (WriteActivity.this.hOQ != null) {
                        this.hPa = bNO.getText().toString();
                        WriteActivity.this.hOQ.k(bNO);
                        return;
                    }
                    return;
                }
                bNO.setSelection(bNO.getSelectionEnd());
            }
        }
    };
    private TextWatcher hOX = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hPb;
        private String hPc = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hPb = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hPb != null ? this.hPb.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bxO();
            EditText bNN = WriteActivity.this.bNN();
            if (editable != null && bNN != null && bNN.getText() != null) {
                if (this.hPc == null || !this.hPc.equals(editable.toString())) {
                    if (WriteActivity.this.hOQ != null) {
                        this.hPc = bNN.getText().toString();
                        WriteActivity.this.hOQ.k(bNN);
                        return;
                    }
                    return;
                }
                bNN.setSelection(bNN.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0275a fVS = new a.InterfaceC0275a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0275a
        public void onRefresh() {
            WriteActivity.this.fnp = null;
            WriteActivity.this.op(false);
            WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void Li() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Lj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ll();
        } else if (this.aVD.bCL()) {
            Li();
        } else {
            this.aVD.nk(false);
            b(1, true, null);
            this.aVD.bCJ();
        }
    }

    private void Ll() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kX()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aVD.alo();
                } else {
                    WriteActivity.this.aVQ.Lx();
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
        aVar.Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bNv() {
        int selectionEnd = bNN().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bNN().getText().getSpans(0, bNN().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bNN().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bNN().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        if (this.aUb != null) {
            this.aUb.setBarLauncherEnabled(!this.hOV);
            this.aUb.setBarLauncherEnabled(true, 26);
            this.aUb.setBarLauncherEnabled(true, 2);
            K(9, this.hOV ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g ff;
        if (this.aUb != null && (ff = this.aUb.ff(i)) != null) {
            if (z) {
                ff.pQ();
            } else {
                ff.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hOK) {
            this.gSu.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hPu.setVisibility(8);
            } else {
                this.hPu.setVisibility(0);
            }
            a(this.hPx, this.hPr);
            a(this.hPw, this.hPv);
            bxO();
        }
        if (this.hPd) {
            this.hOV = true;
            bNw();
            if (this.aUb != null) {
                this.aUb.Jg();
            }
            this.gSu.requestFocus();
            ShowSoftKeyPadDelay(this.gSu);
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
            bOl();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bNW();
            }
            oq(true);
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
            wE(this.hIP);
        }
        initUI();
        bOb();
        this.aVD = new LocationModel(this);
        this.aVD.a(this.aVQ);
        registerListener(this.hfj);
        registerListener(this.hOT);
        initEditor();
        bOn();
        if (this.hOK) {
            this.hPq.setEditorTools(this.aUb);
        } else {
            this.gSy.requestFocus();
        }
        btX();
        bNW();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aUb = new EditorTools(getActivity());
        this.aUb.setBarMaxLauCount(5);
        this.aUb.setMoreButtonAtEnd(true);
        this.aUb.setBarLauncherType(1);
        this.aUb.bY(true);
        this.aUb.bZ(true);
        this.aUb.setMoreLauncherIcon(e.f.write_more);
        this.aUb.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bNZ();
                break;
            default:
                bNx();
                break;
        }
        this.aUb.KI();
        if (this.hOs != null) {
            this.hOs.addView(this.aUb);
        }
        bNy();
        this.aUb.pQ();
        com.baidu.tbadk.editortools.g ff = this.aUb.ff(6);
        if (ff != null && !TextUtils.isEmpty(this.aVI)) {
            ((View) ff).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aVI);
                }
            });
        }
        if (!this.hOK) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aUb.Jg();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bNA();
    }

    private void bNX() {
        this.hPs = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.hPu = this.hPs.findViewById(e.g.live_post_title_container);
        this.hPr = (EditText) this.hPs.findViewById(e.g.live_post_content);
        this.hPp = (GridView) this.hPs.findViewById(e.g.photoLiveGridView);
        this.hPv = (EditText) this.hPs.findViewById(e.g.live_post_title);
        this.hPw = (TextView) this.hPs.findViewById(e.g.titleOverPlusNumber);
        this.hPx = (TextView) this.hPs.findViewById(e.g.contentOverPlusNumber);
        this.hPt = this.hPs.findViewById(e.g.live_interval_view);
        this.hPw.setText(String.valueOf(20));
        this.hPx.setText(String.valueOf(233));
        this.hPs.setVisibility(0);
        this.hPw.setVisibility(0);
        this.hPx.setVisibility(0);
        this.hPv.setHint(e.j.tips_title_limit_new);
        this.hPv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hPA = true;
                    WriteActivity.this.hOV = true;
                    WriteActivity.this.bNw();
                    if (WriteActivity.this.aUb != null) {
                        WriteActivity.this.aUb.Jg();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hPr.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hPr.setHint(e.j.live_write_input_content_update);
        }
        this.hPr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hPA = false;
                    WriteActivity.this.hOV = false;
                    WriteActivity.this.bNw();
                    if (WriteActivity.this.aUb != null) {
                        WriteActivity.this.aUb.Jg();
                    }
                }
            }
        });
        this.hPr.requestFocus();
        this.hPr.addTextChangedListener(getTextWatcher());
        this.hPv.requestFocus();
        this.hPv.addTextChangedListener(getTextWatcher());
        this.hPv.setOnClickListener(this.hOU);
        this.hPr.setOnClickListener(this.hOU);
        this.hPq = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hPp);
        this.hPq.wy(6);
        this.hPp.setAdapter((ListAdapter) this.hPq);
        View findViewById = this.hPs.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bNg() {
                WriteActivity.this.bOj();
            }
        });
        bNY();
    }

    private void bNY() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hPv.setText(this.mData.getTitle());
                this.hPv.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hOK) {
            bOh();
        }
        if (this.aUb.KK()) {
            this.aUb.Jg();
        }
        wE(0);
    }

    private void wE(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.dWT);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bNZ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aUb.w(arrayList);
        com.baidu.tbadk.editortools.k fi = this.aUb.fi(5);
        if (fi != null) {
            fi.aUK = 2;
            fi.aUI = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aUI = e.f.write_at;
        this.aUb.b(aVar);
        this.aUb.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bNx() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aUI = e.f.write_picture;
        this.aUb.b(dVar);
        Boolean bOf = bOf();
        if (!this.hPd && bOf != null && bOf.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bDn() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aUK = 3;
            kVar5.aUI = e.f.write_recorder;
            this.aUb.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aUI = e.f.icon_post_topic_selector;
        this.aUb.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aUK = 5;
            kVar4.aUI = e.f.write_privilege;
            this.aUb.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aUK = 6;
            kVar3.aUI = this.hPd ? e.f.write_location : e.f.icon_post_more_location;
            this.aUb.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aUI = e.f.icon_post_more_at;
        this.aUb.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aUM = true;
            kVar2.aUK = 9;
            kVar2.aUI = 0;
            this.aUb.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aUM = true;
            kVar.aUK = 10;
            kVar.aUI = 0;
            this.aUb.b(kVar);
        }
        if (this.hOy == null) {
            if (this.hOO == null) {
                this.hOO = new com.baidu.tieba.write.editor.b(getActivity(), this.dWT);
                this.hOO.aY(this.mData.getForumId(), this.privateThread);
            }
            this.aUb.b(this.hOO);
        }
        this.aUb.w(arrayList);
        com.baidu.tbadk.editortools.k fi = this.aUb.fi(5);
        if (fi != null) {
            fi.aUK = 1;
            fi.aUI = e.f.write_emotion;
        }
    }

    private void bNz() {
        if (this.hOR != null) {
            this.hOR.hideTip();
        }
    }

    private void bNA() {
        if (this.hOR == null) {
            this.hOR = new e(getPageContext());
        }
        this.hOR.c(this.aUb);
    }

    private void bNy() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bNM()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bNM()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof o)) {
                            WriteActivity.this.d((o) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bNP();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bhK();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bOl();
                        WriteActivity.this.bxO();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.wF(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hOy == null) {
                            WriteActivity.this.Lm();
                            return;
                        }
                        switch (WriteActivity.this.aVJ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bB(pageActivity)) {
                                    WriteActivity.this.Lj();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Li();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aVD != null) {
                            WriteActivity.this.aVD.nk(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fnp = null;
                        } else {
                            WriteActivity.this.fnp = (String) aVar.data;
                        }
                        WriteActivity.this.op(false);
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
                            WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aUb.KK()) {
                                        WriteActivity.this.aUb.Jg();
                                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bxO();
                        if (WriteActivity.this.gSy != null) {
                            WriteActivity.this.gSy.requestFocus();
                        }
                        WriteActivity.this.aUb.Jg();
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gSy);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hOq = true;
                        WriteActivity.this.on(true);
                        if (!WriteActivity.this.bNO().isFocused() || WriteActivity.this.hOt.getVisibility() != 0) {
                            WriteActivity.this.hOp = "from_content";
                        } else {
                            WriteActivity.this.hOp = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hOt.setVisibility(0);
                        WriteActivity.this.hOt.requestFocus();
                        WriteActivity.this.bxO();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hOt.hasFocus()) {
                            WriteActivity.this.gSy.requestFocus();
                            WriteActivity.this.gSy.setSelection(WriteActivity.this.gSy.getText().toString().length());
                        }
                        WriteActivity.this.hOt.setVisibility(8);
                        WriteActivity.this.bxO();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aUb.setActionListener(16, bVar);
        this.aUb.setActionListener(14, bVar);
        this.aUb.setActionListener(24, bVar);
        this.aUb.setActionListener(3, bVar);
        this.aUb.setActionListener(10, bVar);
        this.aUb.setActionListener(11, bVar);
        this.aUb.setActionListener(12, bVar);
        this.aUb.setActionListener(13, bVar);
        this.aUb.setActionListener(15, bVar);
        this.aUb.setActionListener(18, bVar);
        this.aUb.setActionListener(20, bVar);
        this.aUb.setActionListener(25, bVar);
        this.aUb.setActionListener(27, bVar);
        this.aUb.setActionListener(29, bVar);
        this.aUb.setActionListener(43, bVar);
        this.aUb.setActionListener(45, bVar);
        this.aUb.setActionListener(53, bVar);
        this.aUb.setActionListener(48, bVar);
        this.aUb.setActionListener(46, bVar);
        this.aUb.setActionListener(49, bVar);
        this.aUb.setActionListener(47, bVar);
        this.aUb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        if (this.aVD.alk()) {
            if (this.aVD.bCL()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bCH().getLocationData().bCD());
                return;
            }
            b(1, true, null);
            this.aVD.bCJ();
            return;
        }
        b(0, true, null);
    }

    protected void bxG() {
        if (this.aVE != null) {
            this.aVE.cancelLoadData();
        }
        if (this.hOu != null) {
            this.hOu.cancelLoadData();
        }
        if (this.aVD != null) {
            this.aVD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bNz();
        TiebaPrepareImageService.StopService();
        bxG();
        bOe();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hPo != null) {
            this.hPo.destroy();
        }
        if (this.hPP != null) {
            this.hPP.apZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNB() {
        if (this.mData != null && this.mData.getType() == 2 && this.hPk) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bNO().getText().toString());
            this.mData.setContent(bNN().getText().toString());
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
            if (this.gSA != null && this.gSA.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gSA, getPageContext().getPageActivity());
                return true;
            } else if (this.aUb.KK()) {
                this.aUb.Jg();
                return true;
            } else {
                bxG();
                bNB();
                return true;
            }
        }
        if (i == 67 && (text = bNN().getText()) != null) {
            int selectionStart = bNN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNN().onKeyDown(67, this.djk);
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
        getLayoutMode().onModeChanged(this.hPF);
        if (this.hPC != null && i == 1) {
            this.hPC.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bNw();
        al.j(this.hPs, e.d.cp_bg_line_d);
        al.j(this.gSv, e.d.cp_bg_line_c);
        al.j(this.hPt, e.d.cp_bg_line_c);
        al.j(bNO(), e.d.cp_bg_line_d);
        al.c(this.fPm, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fnp)) {
            al.j(bNN(), e.d.cp_bg_line_d);
        }
        bxO();
        this.aUb.onChangeSkinType(i);
        if (this.hOI != null) {
            this.hOI.DV();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bNC();
        bND();
        if (this.hOQ != null) {
            this.hOQ.c(bNO(), bNN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNC() {
        if (this.gSu.hasFocus()) {
            this.gSu.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gSu.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.gSy.hasFocus()) {
            this.gSy.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gSy.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bND() {
        if (this.gSu != null && this.gSu.getText() != null && this.gSu.getText().toString() != null && this.gSu.getPaint() != null) {
            if (this.gSu.getText().toString().length() == 0) {
                this.gSu.getPaint().setFakeBoldText(false);
            } else if (this.gSu.getText().toString().length() > 0) {
                this.gSu.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bdN = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hOK = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.hPi = (TextView) findViewById(e.g.btn_image_problem);
        bNF();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0175e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gSs);
        this.hOJ = (ScrollView) findViewById(e.g.write_scrollview);
        this.hOJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gSy != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gSy);
                    }
                    if (WriteActivity.this.aUb != null) {
                        WriteActivity.this.aUb.Jg();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hPg = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.hPh = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hOs = (LinearLayout) findViewById(e.g.tool_view);
        this.hOs.setContentDescription("..");
        this.hOt = (LinearLayout) findViewById(e.g.title_view);
        this.gSv = findViewById(e.g.interval_view);
        this.hPK = findViewById(e.g.hot_topic_fourm_view);
        this.hPL = findViewById(e.g.hot_topic_divider);
        this.hOM = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.hPM = (TextView) findViewById(e.g.change_one_tv);
        bxN();
        if (this.hOK) {
            this.hOJ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bNX();
        } else {
            this.hPo = new g(getPageContext(), this.mRootView);
            g gVar = this.hPo;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.oi(z);
        }
        bxP();
        if (this.hPd || this.hOr) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().azh) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gSx = (LinearLayout) findViewById(e.g.post_content_container);
        this.gSx.setDrawingCacheEnabled(false);
        this.gSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gSy.requestFocus();
            }
        });
        this.fPj = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fPk = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fPm = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bhK();
            }
        });
        this.aIE.setOnFocusChangeListener(this.gSs);
        this.aIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bxG();
                WriteActivity.this.bNB();
            }
        });
        this.hPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bNI();
        j(bOf());
        bNK();
        bNE();
        bOc();
        bOd();
        bNw();
        bNJ();
        bxM();
        bNQ();
        if (this.mData.getType() == 4 && this.gSC != null && this.hOv != null) {
            this.gSC.setVisibility(8);
            this.hOv.setVisibility(8);
        }
        bxO();
        bOa();
    }

    private void bNE() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hPd || this.hOr) {
                        if (this.hPe) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.dWT != null && this.dWT.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.dWT != null && this.dWT.equals("2")) {
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
                    this.gSu.setVisibility(0);
                    this.gSy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.gSy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gSu.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.gSy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hPt.setVisibility(8);
                    return;
                case 7:
                    this.gSu.setVisibility(0);
                    this.gSy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bNF() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bNG() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hPd && !this.hOr && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bNO() != null) {
                bNO().setText(c);
                bNO().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fPj.setVisibility(0);
            this.fPk.setVoiceModel(voiceModel);
            this.fPk.bDm();
            bxO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhK() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fPj.setVisibility(8);
        this.fPk.aLh();
        this.fPk.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fi = this.aUb.fi(6);
        if (fi != null && fi.aTV != null) {
            fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bxO();
    }

    private void bNH() {
        this.hOD = null;
        this.hOF = -1;
        this.hOH = -1;
        z lF = y.aBk().lF(1);
        if (lF != null) {
            this.hOD = lF.dDE;
            this.hOF = getIntent().getIntExtra("category_id", -1);
            if (this.hOD != null && !this.hOD.isEmpty() && this.hOF >= 0) {
                this.hOE = new x();
                this.hOE.dDA = 0;
                this.hOE.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hOH = this.hOE.dDA;
                this.hOG = this.hOE.name;
                for (x xVar : this.hOD) {
                    if (xVar.dDA == this.hOF) {
                        this.hOH = xVar.dDA;
                        this.hOG = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bNI() {
        if (this.hOD != null && !this.hOD.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hOI = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hOI.setText(this.hOG);
            this.hOI.setCategoryContainerData(this.hOD, this.hOE, this.hOH);
            this.hOI.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hOI.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dDA);
                        WriteActivity.this.hOH = atVar.dDA;
                        WriteActivity.this.hOI.bNj();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hOI.bNi();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNN());
                }
            });
        }
    }

    private void bOa() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hOY = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hOY.setTitle(e.j.no_disturb_start_time);
        this.hOY.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hOY);
        this.hOY.setButton(-2, getPageContext().getString(e.j.cancel), this.hOY);
        return this.hOY;
    }

    private void bNJ() {
        this.hOz = (RelativeLayout) findViewById(e.g.addition_container);
        this.hOA = (TextView) findViewById(e.g.addition_create_time);
        this.hOB = (TextView) findViewById(e.g.addition_last_time);
        this.hOC = (TextView) findViewById(e.g.addition_last_content);
        if (this.hOy != null) {
            this.hOz.setVisibility(0);
            this.hOA.setText(getPageContext().getString(e.j.write_addition_create) + ao.C(this.hOy.getCreateTime() * 1000));
            if (this.hOy.getAlreadyCount() == 0) {
                this.hOB.setVisibility(8);
            } else {
                this.hOB.setText(getPageContext().getString(e.j.write_addition_last) + ao.C(this.hOy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hOy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hOC.setText(lastAdditionContent);
            } else {
                this.hOC.setVisibility(8);
            }
            bNN().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hOy.getAlreadyCount()), Integer.valueOf(this.hOy.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hOz.setVisibility(8);
    }

    private void bxM() {
        this.gSC = findViewById(e.g.post_prefix_layout);
        if (this.hPP == null) {
            this.hPP = new com.baidu.tieba.c.d(getPageContext(), this.gSC);
            this.hPP.kl(e.f.bg_tip_blue_up_left);
            this.hPP.kk(16);
            this.hPP.fu(true);
            this.hPP.M(true);
            this.hPP.ko(l.h(getActivity(), e.C0175e.ds32));
        }
        this.gSz = (TextView) findViewById(e.g.post_prefix);
        this.hOv = findViewById(e.g.prefix_divider);
        this.gSB = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gSC.setVisibility(0);
            this.hPP.h(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gSc = 0;
            this.gSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ax(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).h("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gSz.setVisibility(0);
                    WriteActivity.this.gSC.setSelected(true);
                    al.c(WriteActivity.this.gSB, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gSA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aUb.Jg();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gSu);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gSy);
                }
            });
            this.gSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ax(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).h("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gSz.setSelected(true);
                    al.c(WriteActivity.this.gSB, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gSA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aUb.Jg();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNN());
                }
            });
            this.gSA = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gSA.a(this);
            this.gSA.setMaxHeight(l.h(getActivity(), e.C0175e.ds510));
            this.gSA.setOutsideTouchable(true);
            this.gSA.setFocusable(true);
            this.gSA.setOnDismissListener(this);
            this.gSA.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.gSz, e.d.cp_bg_line_d);
            al.c(this.gSB, e.f.icon_arrow_gray_down);
            this.gSz.setTextColor(color);
            this.hOw.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hOw.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.od(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.od(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gSA.addView(writePrefixItemLayout);
            }
            this.gSA.setCurrentIndex(0);
            this.gSz.setText(prefixs.get(0));
            wD(0);
            return;
        }
        this.gSC.setVisibility(8);
    }

    private void bOb() {
        if (this.hPd && this.mData != null) {
            this.hPg.setVisibility(0);
            this.hPh.setVisibility(0);
            this.hOu = new FeedBackModel(getPageContext());
            this.hOu.xe(this.mData.getForumName());
            this.hOu.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hPg.setVisibility(8);
                        WriteActivity.this.hPh.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hPg.setVisibility(8);
                        WriteActivity.this.hPh.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hPg.a(feedBackModel.bNl(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bNK() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kX()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hOQ.a(WriteActivity.this.gSu, WriteActivity.this.gSy)) {
                        WriteActivity.this.showToast(WriteActivity.this.hOQ.bLu());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bNN());
                    WriteActivity.this.aUb.Jg();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hPd) {
                            WriteActivity.this.bNT();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.x("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bNU();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bNT();
                    }
                    TiebaStatic.log(new am("c12262").ax("obj_locate", WriteActivity.this.dWT));
                }
            }
        });
    }

    protected void bOc() {
        this.hPj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hPj.ej(getPageContext().getString(e.j.is_save_draft)).aO(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bNO().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bNN().getText().toString());
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
        this.hPj.b(getPageContext());
    }

    protected void bxN() {
        this.hPf = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.hPf.setIsRound(true);
        this.hPf.setDrawBorder(false);
        this.hPf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String fc = com.baidu.tbadk.core.util.o.fc(currentPortrait);
            this.hPf.setUrl(fc);
            this.hPf.startLoad(fc, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hPf.setVisibility(0);
        }
        this.gSu = (EditText) findViewById(e.g.post_title);
        this.gSu.setOnClickListener(this.hOU);
        this.gSu.setOnFocusChangeListener(this.gSs);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gSu.setText(this.mData.getTitle());
                this.gSu.setSelection(this.mData.getTitle().length());
            } else if (this.hPe) {
                this.gSu.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gSu.addTextChangedListener(this.hOW);
        if (!this.mData.getHaveDraft()) {
            bNG();
            this.hPJ = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gSu.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.gSu.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher getTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hPT;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bxO();
                if (WriteActivity.this.hOK) {
                    this.hPT = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hPT);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hOK || !WriteActivity.this.hPA) {
                    if (WriteActivity.this.hOK) {
                        if (this.mEditText != WriteActivity.this.hPr || this.mTextView != WriteActivity.this.hPx) {
                            this.mEditText = WriteActivity.this.hPr;
                            this.mTextView = WriteActivity.this.hPx;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hPv || this.mTextView != WriteActivity.this.hPw) {
                    this.mEditText = WriteActivity.this.hPv;
                    this.mTextView = WriteActivity.this.hPw;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hOK && this.hPA) {
            if (this.hPy != null) {
                this.hPv.removeTextChangedListener(this.hPy);
            }
            this.hPy = textWatcher;
        } else if (this.hOK) {
            if (this.hPz != null) {
                this.hPr.removeTextChangedListener(this.hPz);
            }
            this.hPz = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hPr) {
            return 233L;
        }
        if (editText != this.hPv) {
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

    protected void bxP() {
        this.gSy = (EditText) findViewById(e.g.post_content);
        this.gSy.setDrawingCacheEnabled(false);
        this.gSy.setOnClickListener(this.hOU);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Md().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.gSy.setText(al);
            this.gSy.setSelection(al.length());
        } else if (this.mData.getType() == 2) {
            if (this.hPk) {
                if (this.hPl != null && this.hPl.length() > 0) {
                    this.gSy.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.hPl}));
                    this.gSy.setSelection(this.gSy.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gSy.setText(format);
                this.gSy.setSelection(format.length());
            }
        }
        this.gSy.setOnFocusChangeListener(this.gSs);
        this.gSy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gSy.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gSy.addTextChangedListener(this.hOX);
        if (this.mData.getType() == 0) {
            this.hPO = true;
        } else {
            op(true);
            this.hPO = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gSy.setHint(e.j.write_input_content);
        } else {
            this.gSy.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void op(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hOK) {
            bNN().setPadding(0, 0, 0, 0);
            bNN().setBackgroundDrawable(null);
            al.j(bNN(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fnp) && this.hOy == null) {
                com.baidu.adp.lib.f.c.jC().a(this.fnp, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.os() != null && aVar.ow() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.os(), aVar.os().getNinePatchChunk(), aVar.ow(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bNN().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bNN(), true, WriteActivity.this.fVS);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNM() {
        int i = 5000;
        if (this.hOy != null) {
            i = 1000;
        }
        return bNN().getText() != null && bNN().getText().length() >= i;
    }

    private void hq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hOp)) {
                this.hOp = "";
                bNN().requestFocus();
                if (bNN().getText() != null && bNN().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNN().getSelectionStart();
                    editable = bNN().getText();
                }
            } else if ("from_title".equals(this.hOp)) {
                this.hOp = "";
                bNO().requestFocus();
                if (bNO().getText() != null && bNO().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNO().getSelectionStart();
                    editable = bNO().getText();
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
    public void on(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(o oVar) {
        if (((ImageSpan[]) bNN().getText().getSpans(0, bNN().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hOx == null) {
                this.hOx = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hOx.show();
            return;
        }
        String name = oVar.getName();
        final EmotionGroupType Fw = oVar.Fw();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jC().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bNN().getSelectionStart(), aVar, Fw);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bNN() != null && bNN().getText() != null) {
            Bitmap os = aVar.os();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(os);
            int width = os.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, os.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bNN().getSelectionStart() - 1;
                if (bNN().getText().length() > 1 && selectionStart >= 0 && bNN().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bNN().getText().insert(bNN().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bNN().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bNN().getText().insert(bNN().getSelectionStart(), spannableString2);
            }
            Editable text = bNN().getText();
            if (text != null) {
                this.hON.clear();
                this.hON.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hON);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bNN().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bNN().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bNN().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNN() {
        return this.hOK ? this.hPr : this.gSy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNO() {
        return this.hOK ? this.hPv : this.gSu;
    }

    protected void bNP() {
        Editable text;
        if (bNN() != null && (text = bNN().getText()) != null) {
            int selectionStart = bNN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNN().onKeyDown(67, this.djk);
            }
            bNN().onKeyDown(67, this.djk);
            int selectionStart2 = bNN().getSelectionStart();
            if (text != null) {
                this.hON.clear();
                this.hON.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hON);
                bNN().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.hPd = true;
        }
    }

    private void bOd() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bOe() {
        try {
            if (this.hPj != null) {
                this.hPj.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bdN.d(null);
        this.bdN.dA(e.j.sending);
        this.bdN.bj(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bdN.bj(false);
    }

    private Boolean bOf() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aVI = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void bxO() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bNO() != null) {
                str = bNO().getText().toString();
            }
            if (bNN() != null) {
                str2 = bNN().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gSc == com.baidu.tbadk.core.util.v.I(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hOt.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            oo(true);
                            return;
                        }
                    } else if (this.hOt.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        oo(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hOt.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    oo(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hOK) {
                    oo(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oo(true);
                }
            }
            if (this.mData.getType() == 4) {
                oo(o(this.hPr) && n(this.hPv));
            } else if (this.mData.getType() == 5) {
                oo(o(this.hPr));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                oo(true);
            } else if (this.mData.getVideoInfo() != null) {
                oo(true);
            } else {
                oo(false);
            }
        }
    }

    public void oo(boolean z) {
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
        this.aVE = new NewWriteModel(this);
        this.aVE.b(this.aVS);
        registerListener(this.hPQ);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bxG();
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
            this.hPd = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hPe = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hPk = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hPl = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aVC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hOy = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hOy != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hPm = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hPN = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.dWT = bundle.getString("KEY_CALL_FROM");
            this.hIP = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hPd = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hPe = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hPk = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hPl = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hOy = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hOy != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hPm = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hPN = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.dWT = intent.getStringExtra("KEY_CALL_FROM");
            this.hIP = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hPd);
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
        this.fnp = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hOr = true;
        }
        bNH();
        try {
            this.hPB = bOm();
        } catch (Throwable th) {
            this.hPB = null;
        }
    }

    private void bNQ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gSu.setText(com.baidu.tbadk.plugins.b.hZ(com.baidu.tbadk.plugins.b.ia(hotTopicBussinessData.mTopicName)));
            this.gSu.setMovementMethod(com.baidu.tieba.view.c.bKw());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString hZ = com.baidu.tbadk.plugins.b.hZ(com.baidu.tbadk.plugins.b.ia(hotTopicBussinessData.mTopicName));
            if (hZ != null) {
                this.gSu.setText(hZ);
            }
            this.hOM.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String ia;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bNO().getText().toString()) || this.hPJ || ((this.hPd || this.hOr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!com.baidu.tbadk.core.util.v.J(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            ia = this.mData.getTitle();
                        } else {
                            ia = com.baidu.tbadk.plugins.b.ia(str);
                        }
                        SpannableString hZ = com.baidu.tbadk.plugins.b.hZ(ia);
                        if (hZ != null) {
                            bNO().setText(hZ);
                            bNO().setSelection(hZ.length() > ia.length() ? ia.length() : hZ.length());
                        }
                    } else {
                        SpannableString hZ2 = com.baidu.tbadk.plugins.b.hZ(this.mData.getTitle());
                        if (hZ2 != null) {
                            bNO().setText(hZ2);
                            bNO().setSelection(this.mData.getTitle().length() > hZ2.length() ? hZ2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bNG();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bNN().getText().toString()) || this.hPd || this.hOr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Md().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hOS);
                    bNN().setText(a2);
                    bNN().setSelection(a2.length());
                    if (this.hOK) {
                        a(this.hPx, this.hPr);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bOl();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bNW();
                    }
                    oq(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bOg();
                }
                bxO();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hOD != null) {
                    this.hOH = this.hOE.dDA;
                    this.hOG = this.hOE.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hOD.size()) {
                            break;
                        }
                        x xVar = this.hOD.get(i);
                        if (categoryTo != xVar.dDA) {
                            i++;
                        } else {
                            this.hOH = categoryTo;
                            this.hOG = xVar.name;
                            this.mData.setCategoryTo(this.hOH);
                            break;
                        }
                    }
                    if (this.hOI != null) {
                        this.hOI.setText(this.hOG);
                        this.hOI.setCategoryContainerData(this.hOD, this.hOE, this.hOH);
                    }
                }
                this.aUb.Jg();
                return;
            }
            return;
        }
        bOg();
        bNG();
    }

    private void bOg() {
        if ((!this.hOK || this.hPq != null) && this.hPp != null) {
            this.hPq.c(this.writeImagesInfo);
            bOj();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hPk);
        if (this.hPd) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aVC);
        if (this.hOy != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hOy));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hPm);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dWT);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hIP);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bNN().getEditableText().toString();
        if (obj != null) {
            bNN().setText(TbFaceManager.Md().a(getPageContext().getPageActivity(), obj, this.hOS));
            bNN().setSelection(bNN().getText().length());
        }
    }

    private String bNR() {
        return (bNN() == null || bNN().getText() == null) ? "" : bNN().getText().toString();
    }

    private String bNS() {
        if (this.mData == null || bNO() == null || bNO().getVisibility() != 0 || bNO().getText() == null) {
            return "";
        }
        String obj = bNO().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.I(this.mPrefixData.getPrefixs()) > 0 && this.gSc != com.baidu.tbadk.core.util.v.I(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gSz != null && this.gSz.getText() != null) {
            this.mData.setPostPrefix(this.gSz.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void xf(String str) {
        if (this.mData != null && this.hOt != null) {
            if (this.hOt.getVisibility() == 0) {
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
    public void bNT() {
        bxG();
        this.mData.setContent(bNR());
        xf(bNS());
        if (this.hPd || this.hOr) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                xf(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.kX()) {
                    sb.append(com.baidu.adp.lib.util.j.lf());
                } else {
                    sb.append(AiAppRomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hOF >= 0) {
            this.mData.setCategoryFrom(this.hOF);
        }
        if (this.hOH >= 0) {
            this.mData.setCategoryTo(this.hOH);
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
        this.mData.setHasLocationData(this.aVD != null && this.aVD.alk());
        if (this.writeImagesInfo != null) {
            this.aVE.nm(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.J(this.mList) && this.hOL != null && this.hOL.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hOL.mForumId));
            this.mData.setForumName(this.hOL.mForumName);
        }
        this.aVE.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aVE.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aVE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aVE.getWriteData().setVoice(null);
                this.aVE.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aVE.getWriteData().setVoice(null);
            this.aVE.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aVE.bDo()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kX()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.aVE.startPostWrite();
        }
    }

    private void v(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hOy != null) {
                i2 = this.hOy.getTotalCount();
                i = this.hOy.getAlreadyCount() + 1;
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
                if (this.gSu == getCurrentFocus()) {
                    bNN().clearFocus();
                    this.gSu.requestFocus();
                    if (this.aUb != null) {
                        this.aUb.Jg();
                    }
                    ShowSoftKeyPadDelay(this.gSu);
                } else {
                    bNN().requestFocus();
                    if (this.aUb != null) {
                        this.aUb.Jg();
                    }
                    ShowSoftKeyPadDelay(this.gSy);
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
                            bNN().getText().insert(bNN().getSelectionStart(), sb.toString());
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
                                bOk();
                            } else {
                                ak(intent);
                            }
                        } else if (intExtra == 1) {
                            al(intent);
                        } else {
                            ai(intent);
                            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hPO) {
                            op(true);
                            this.hPO = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hOK) {
                        B(intent);
                        bxO();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aUb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aUb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aUb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bxO();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hOq) {
                                sb2.append(com.baidu.tbadk.plugins.b.bdk);
                                this.hOq = false;
                            }
                            sb2.append(stringExtra);
                            hq(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.J(this.mList) && !com.baidu.tbadk.core.util.v.J(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hOL = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hOL);
                }
            }
        } else if (i2 == 0) {
            if (this.aUb != null && !this.aUb.KK()) {
                this.gSy.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aUb.Jg();
            }
            switch (i) {
                case 12001:
                    Lp();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bOi();
                    if (this.hPO) {
                        op(true);
                        this.hPO = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gSu == getCurrentFocus()) {
                        bNN().clearFocus();
                        this.gSu.requestFocus();
                        if (this.aUb != null) {
                            this.aUb.Jg();
                        }
                        ShowSoftKeyPadDelay(this.gSu);
                        return;
                    }
                    bNN().requestFocus();
                    if (this.aUb != null) {
                        this.aUb.Jg();
                    }
                    ShowSoftKeyPadDelay(this.gSy);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hOQ.wJ(postWriteCallBackData.getErrorString());
                        this.hOQ.aA(postWriteCallBackData.getSensitiveWords());
                        this.hOQ.b(this.gSu, this.gSy);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aVC = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aVC);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bOi();
                    return;
                case 25004:
                    if ("from_title".equals(this.hOp)) {
                        bNO().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hOp)) {
                        bNN().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNU() {
        if ("1".equals(this.dWT)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dWT)) {
            this.mData.setCanNoForum(false);
        }
        bNV();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.dWT);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bNT();
    }

    private void bNV() {
        if (this.aUb != null) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bOh() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bOi() {
        if (this.hOK) {
            this.hPq.c(this.writeImagesInfo);
            bOj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        this.hPq.notifyDataSetChanged();
        this.hPp.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hPq.notifyDataSetChanged();
                WriteActivity.this.hPp.invalidateViews();
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
        bxO();
    }

    private void ai(Intent intent) {
        if (this.hOK) {
            aj(intent);
            bOi();
        } else {
            am(intent);
        }
        bxO();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bOi();
            oq(true);
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

    private void bOk() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hPn.parseJson(stringExtra);
            this.hPn.updateQuality();
            if (this.hPn.getChosedFiles() != null && this.hPn.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hPn.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hPn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bNO());
        HidenSoftKeyPad(this.mInputManager, bNN());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aVC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aVC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aVC, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bOl();
            bNW();
        }
        oq(true);
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
                bOl();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bNW();
                }
            }
            oq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOl() {
        if (this.aUb.fi(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Lp() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aVC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oq(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hPo != null) {
            this.hPo.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void azQ() {
        this.dAm = getVoiceManager();
        this.dAm.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dBq) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayx));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hOy == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                v(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aVJ = i;
        if (this.aUb != null) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bNW() {
        if (!this.hOK) {
            if (this.aUb != null) {
                this.aUb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aUb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hPo != null) {
                this.hPo.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        if (this.aUb != null) {
            this.aUb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wD(int i) {
        if (i < this.hOw.size()) {
            for (int i2 = 0; i2 < this.hOw.size(); i2++) {
                this.hOw.get(i2).oe(false);
            }
            this.hOw.get(i).oe(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void ue(int i) {
        if (i == com.baidu.tbadk.core.util.v.I(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").x("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").x("obj_type", 2));
        }
        this.gSc = i;
        this.gSA.setCurrentIndex(i);
        wD(i);
        this.gSz.setText(this.mPrefixData.getPrefixs().get(i));
        bxO();
        com.baidu.adp.lib.g.g.a(this.gSA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gSC.setSelected(false);
        al.c(this.gSB, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gSy);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Lj();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.aX(getApplicationContext())) {
                ak.a(getPageContext(), this.aVC);
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
        this.hOP = z;
        if (this.hPH && System.currentTimeMillis() - this.hPI < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hPH = false;
        }
        if (this.hOO != null && !z) {
            this.hOO.auj();
        }
        if (this.hOR != null && !z) {
            bNz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hPE != null) {
            xh(str);
            this.hPE.dismiss();
        }
    }

    private void dk(Context context) {
        hPG = l.aQ(context);
    }

    private void xh(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hPH = true;
        bOl();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bNW();
        }
        oq(true);
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

    private File bOm() {
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

    private void bOn() {
        if (this.hPB != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            dk(getActivity());
            this.hPD = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.hPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hPB != null) {
                        WriteActivity.this.xg(WriteActivity.this.hPB.getAbsolutePath());
                    }
                }
            });
            this.hPC = (TbImageView) this.hPD.findViewById(e.g.rec_img_view);
            this.hPF = (LinearLayout) this.hPD.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hPB.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hPB.getAbsolutePath());
                Bitmap f = f(this.hPB.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0175e.ds160));
                if (f != null) {
                    this.hPC.setImageBitmap(f);
                    this.hPC.setDrawBorder(true);
                    this.hPC.setBorderWidth(2);
                    this.hPC.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.hPE = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.hPE.setCanceledOnTouchOutside(true);
                    this.hPE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hPH) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hPI = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hPE.setContentView(this.hPD);
                    this.hPE.show();
                    Window window = this.hPE.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0175e.ds28);
                    attributes.y = (hPG / 18) + getResources().getDimensionPixelSize(e.C0175e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(e.C0175e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(e.C0175e.ds278);
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
        if (this.hOP && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hOq = false;
            this.hOp = "";
            if ("from_content".equals(str)) {
                this.hOp = "from_content";
            } else if ("from_title".equals(str)) {
                this.hOp = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hY(String.valueOf(charSequence.charAt(i)))) {
                on(false);
            }
        }
    }

    public void btX() {
        if (this.hPd || !com.baidu.tbadk.core.util.v.J(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hOt.setVisibility(0);
            this.hOt.requestFocus();
            this.aUb.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hOt.setVisibility(8);
    }
}
