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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0062a, VoiceManager.c, t.a, d.a {
    private static int hIt = 0;
    private EditorTools aPA;
    private String aRb;
    private LocationModel aRc;
    private NewWriteModel aRd;
    private VoiceManager dsk;
    private LinearLayout fHH;
    private PlayVoiceBntNew fHI;
    private ImageView fHK;
    private int gKE;
    private TextView gLb;
    private com.baidu.tieba.write.d gLc;
    private ImageView gLd;
    private View gLe;
    private com.baidu.tieba.write.editor.b hHB;
    private e hHE;
    private com.baidu.tieba.view.b hHL;
    private View hHU;
    private LinearLayout hHf;
    private LinearLayout hHg;
    private View hHi;
    private Toast hHk;
    private AdditionData hHl;
    private RelativeLayout hHm;
    private TextView hHn;
    private TextView hHo;
    private TextView hHp;
    List<x> hHq;
    x hHr;
    private int hHs;
    private String hHt;
    private int hHu;
    private PostCategoryView hHv;
    private HotTopicBussinessData hHy;
    private TextView hHz;
    private com.baidu.tieba.c.d hIC;
    private g hIb;
    private View hIx;
    private View hIy;
    private TextView hIz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hHc = "";
    private boolean hHd = false;
    private WriteData mData = null;
    private boolean hHQ = false;
    private boolean hHe = false;
    private boolean hHR = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gKW = null;
    private HeadImageView hHS = null;
    private View gKX = null;
    private LinearLayout gKZ = null;
    private EditText gLa = null;
    private FeedBackModel hHh = null;
    private FeedBackTopListView hHT = null;
    private ArrayList<WritePrefixItemLayout> hHj = new ArrayList<>();
    private String ffF = null;
    private final KeyEvent daZ = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aEa = null;
    private TextView hHV = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hHW = null;
    private final Handler mHandler = new Handler();
    private boolean hHX = false;
    private String hHY = null;
    private RelativeLayout mParent = null;
    private String aRh = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aRi = 0;
    private int hHZ = 0;
    private WriteImagesInfo hIa = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hIc = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hId = null;
    private ScrollView hHw = null;
    private EditText hIe = null;
    private View hIf = null;
    private View hIg = null;
    private View hIh = null;
    private EditText hIi = null;
    private TextView hIj = null;
    private TextView hIk = null;
    private TextWatcher hIl = null;
    private TextWatcher hIm = null;
    private boolean hHx = false;
    private boolean hIn = false;
    private com.baidu.tbadk.core.view.d aZn = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hIo = null;
    private TbImageView hIp = null;
    private View hIq = null;
    private Dialog hIr = null;
    private LinearLayout hIs = null;
    private boolean hIu = false;
    private long hIv = -1000;
    private boolean hIw = false;
    private String dOX = "2";
    private int hBC = 0;
    private String hIA = "";
    private SpannableStringBuilder hHA = new SpannableStringBuilder();
    private boolean hIB = false;
    private boolean hHC = false;
    private final b hHD = new b();
    private final HttpMessageListener hID = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ffF)) {
                    WriteActivity.this.ffF = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nZ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ffF)) {
                    WriteActivity.this.ffF = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ffF);
                    WriteActivity.this.nZ(true);
                }
            }
        }
    };
    private TbFaceManager.a hHF = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan hw(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oh());
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
    private final AntiHelper.a dtp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atM));
        }
    };
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.awt();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hHD.aA(null);
                if (z) {
                    WriteActivity.this.bX(z);
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
                        if (!com.baidu.tbadk.core.util.v.z(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hIA)) {
                            TiebaStatic.log(new am("c11731").al(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hIA));
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
                    WriteActivity.this.hHD.aA(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hHD.wi(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hHD.b(WriteActivity.this.gKW, WriteActivity.this.gLa);
                } else if ((vVar == null || writeData == null || vVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (vVar != null && writeData != null && vVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.DF());
                    if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.DE());
                        if (WriteActivity.this.hHR) {
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
    private final LocationModel.a aRp = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Jz() {
            WriteActivity.this.showToast(e.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void hl(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(e.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bzo())) {
                WriteActivity.this.b(2, true, aVar.bzo());
            } else {
                hl(null);
            }
        }
    };
    private final CustomMessageListener gXP = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aRc.mT(false);
                    WriteActivity.this.aRc.cy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aRc.mT(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hHG = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hHH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bKj = WriteActivity.this.bKj();
            if (bKj >= 0 && bKj < WriteActivity.this.gLa.getText().length()) {
                WriteActivity.this.gLa.setSelection(bKj);
            }
        }
    };
    private boolean hHI = true;
    private final View.OnFocusChangeListener gKU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gKW || view == WriteActivity.this.aEa || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hHI = true;
                    WriteActivity.this.bKk();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gKW);
                    if (WriteActivity.this.aPA != null) {
                        WriteActivity.this.aPA.Hf();
                    }
                } else if (view == WriteActivity.this.gKW) {
                    WriteActivity.this.gLb.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gLa && z) {
                WriteActivity.this.hHI = false;
                WriteActivity.this.bKk();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gLa);
                if (WriteActivity.this.aPA != null) {
                    WriteActivity.this.aPA.Hf();
                }
            }
            WriteActivity.this.bKq();
        }
    };
    private TextWatcher hHJ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hHN = "";
        private String hHO;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hHO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hHO != null ? this.hHO.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.buz();
            WriteActivity.this.bKr();
            EditText bKC = WriteActivity.this.bKC();
            if (editable != null && bKC != null && bKC.getText() != null) {
                if (this.hHN == null || !this.hHN.equals(editable.toString())) {
                    if (WriteActivity.this.hHD != null) {
                        this.hHN = bKC.getText().toString();
                        WriteActivity.this.hHD.k(bKC);
                        return;
                    }
                    return;
                }
                bKC.setSelection(bKC.getSelectionEnd());
            }
        }
    };
    private TextWatcher hHK = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hHO;
        private String hHP = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hHO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hHO != null ? this.hHO.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.buz();
            EditText bKB = WriteActivity.this.bKB();
            if (editable != null && bKB != null && bKB.getText() != null) {
                if (this.hHP == null || !this.hHP.equals(editable.toString())) {
                    if (WriteActivity.this.hHD != null) {
                        this.hHP = bKB.getText().toString();
                        WriteActivity.this.hHD.k(bKB);
                        return;
                    }
                    return;
                }
                bKB.setSelection(bKB.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0240a fOq = new a.InterfaceC0240a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0240a
        public void onRefresh() {
            WriteActivity.this.ffF = null;
            WriteActivity.this.nZ(false);
            WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void Jk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Jl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Jn();
        } else if (this.aRc.bzw()) {
            Jk();
        } else {
            this.aRc.mT(false);
            b(1, true, null);
            this.aRc.bzu();
        }
    }

    private void Jn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cp(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kK()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aRc.ahI();
                } else {
                    WriteActivity.this.aRp.Jz();
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
        aVar.yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bKj() {
        int selectionEnd = bKB().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bKB().getText().getSpans(0, bKB().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bKB().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bKB().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        if (this.aPA != null) {
            this.aPA.setBarLauncherEnabled(!this.hHI);
            this.aPA.setBarLauncherEnabled(true, 26);
            this.aPA.setBarLauncherEnabled(true, 2);
            K(9, this.hHI ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g eW;
        if (this.aPA != null && (eW = this.aPA.eW(i)) != null) {
            if (z) {
                eW.pI();
            } else {
                eW.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hHx) {
            this.gKW.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hIh.setVisibility(8);
            } else {
                this.hIh.setVisibility(0);
            }
            a(this.hIk, this.hIe);
            a(this.hIj, this.hIi);
            buz();
        }
        if (this.hHQ) {
            this.hHI = true;
            bKk();
            if (this.aPA != null) {
                this.aPA.Hf();
            }
            this.gKW.requestFocus();
            ShowSoftKeyPadDelay(this.gKW);
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
            bLa();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bKK();
            }
            oa(true);
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
            wh(this.hBC);
        }
        initUI();
        bKP();
        this.aRc = new LocationModel(this);
        this.aRc.a(this.aRp);
        registerListener(this.gXP);
        registerListener(this.hHG);
        initEditor();
        bLc();
        if (this.hHx) {
            this.hId.setEditorTools(this.aPA);
        } else {
            this.gLa.requestFocus();
        }
        bqI();
        bKK();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aPA = new EditorTools(getActivity());
        this.aPA.setBarMaxLauCount(5);
        this.aPA.setMoreButtonAtEnd(true);
        this.aPA.setBarLauncherType(1);
        this.aPA.bP(true);
        this.aPA.bQ(true);
        this.aPA.setMoreLauncherIcon(e.f.write_more);
        this.aPA.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bKN();
                break;
            default:
                bKl();
                break;
        }
        this.aPA.IK();
        if (this.hHf != null) {
            this.hHf.addView(this.aPA);
        }
        bKm();
        this.aPA.pI();
        com.baidu.tbadk.editortools.g eW = this.aPA.eW(6);
        if (eW != null && !TextUtils.isEmpty(this.aRh)) {
            ((View) eW).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aRh);
                }
            });
        }
        if (!this.hHx) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aPA.Hf();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bKo();
    }

    private void bKL() {
        this.hIf = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.hIh = this.hIf.findViewById(e.g.live_post_title_container);
        this.hIe = (EditText) this.hIf.findViewById(e.g.live_post_content);
        this.hIc = (GridView) this.hIf.findViewById(e.g.photoLiveGridView);
        this.hIi = (EditText) this.hIf.findViewById(e.g.live_post_title);
        this.hIj = (TextView) this.hIf.findViewById(e.g.titleOverPlusNumber);
        this.hIk = (TextView) this.hIf.findViewById(e.g.contentOverPlusNumber);
        this.hIg = this.hIf.findViewById(e.g.live_interval_view);
        this.hIj.setText(String.valueOf(20));
        this.hIk.setText(String.valueOf(233));
        this.hIf.setVisibility(0);
        this.hIj.setVisibility(0);
        this.hIk.setVisibility(0);
        this.hIi.setHint(e.j.tips_title_limit_new);
        this.hIi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hIn = true;
                    WriteActivity.this.hHI = true;
                    WriteActivity.this.bKk();
                    if (WriteActivity.this.aPA != null) {
                        WriteActivity.this.aPA.Hf();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hIe.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hIe.setHint(e.j.live_write_input_content_update);
        }
        this.hIe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hIn = false;
                    WriteActivity.this.hHI = false;
                    WriteActivity.this.bKk();
                    if (WriteActivity.this.aPA != null) {
                        WriteActivity.this.aPA.Hf();
                    }
                }
            }
        });
        this.hIe.requestFocus();
        this.hIe.addTextChangedListener(bKR());
        this.hIi.requestFocus();
        this.hIi.addTextChangedListener(bKR());
        this.hIi.setOnClickListener(this.hHH);
        this.hIe.setOnClickListener(this.hHH);
        this.hId = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hIc);
        this.hId.wb(6);
        this.hIc.setAdapter((ListAdapter) this.hId);
        View findViewById = this.hIf.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bJU() {
                WriteActivity.this.bKY();
            }
        });
        bKM();
    }

    private void bKM() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hIi.setText(this.mData.getTitle());
                this.hIi.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hHx) {
            bKW();
        }
        if (this.aPA.IM()) {
            this.aPA.Hf();
        }
        wh(0);
    }

    private void wh(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.dOX);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bKN() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aPA.G(arrayList);
        com.baidu.tbadk.editortools.k eZ = this.aPA.eZ(5);
        if (eZ != null) {
            eZ.aQj = 2;
            eZ.aQh = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aQh = e.f.write_at;
        this.aPA.b(aVar);
        this.aPA.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bKl() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aQh = e.f.write_picture;
        this.aPA.b(dVar);
        Boolean bKU = bKU();
        if (!this.hHQ && bKU != null && bKU.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bzZ() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aQj = 3;
            kVar5.aQh = e.f.write_recorder;
            this.aPA.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aQh = e.f.icon_post_topic_selector;
        this.aPA.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aQj = 5;
            kVar4.aQh = e.f.write_privilege;
            this.aPA.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aQj = 6;
            kVar3.aQh = this.hHQ ? e.f.write_location : e.f.icon_post_more_location;
            this.aPA.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aQh = e.f.icon_post_more_at;
        this.aPA.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aQl = true;
            kVar2.aQj = 9;
            kVar2.aQh = 0;
            this.aPA.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aQl = true;
            kVar.aQj = 10;
            kVar.aQh = 0;
            this.aPA.b(kVar);
        }
        if (this.hHl == null) {
            if (this.hHB == null) {
                this.hHB = new com.baidu.tieba.write.editor.b(getActivity(), this.dOX);
                this.hHB.aU(this.mData.getForumId(), this.privateThread);
            }
            this.aPA.b(this.hHB);
        }
        this.aPA.G(arrayList);
        com.baidu.tbadk.editortools.k eZ = this.aPA.eZ(5);
        if (eZ != null) {
            eZ.aQj = 1;
            eZ.aQh = e.f.write_emotion;
        }
    }

    private void bKn() {
        if (this.hHE != null) {
            this.hHE.hideTip();
        }
    }

    private void bKo() {
        if (this.hHE == null) {
            this.hHE = new e(getPageContext());
        }
        this.hHE.c(this.aPA);
    }

    private void bKm() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bKA()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").w("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bKA()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof o)) {
                            WriteActivity.this.d((o) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bKD();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bey();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bLa();
                        WriteActivity.this.buz();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.wi(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").w("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hHl == null) {
                            WriteActivity.this.Jo();
                            return;
                        }
                        switch (WriteActivity.this.aRi) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bs(pageActivity)) {
                                    WriteActivity.this.Jl();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Jk();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aRc != null) {
                            WriteActivity.this.aRc.mT(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ffF = null;
                        } else {
                            WriteActivity.this.ffF = (String) aVar.data;
                        }
                        WriteActivity.this.nZ(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.al(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aPA.IM()) {
                                        WriteActivity.this.aPA.Hf();
                                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.buz();
                        if (WriteActivity.this.gLa != null) {
                            WriteActivity.this.gLa.requestFocus();
                        }
                        WriteActivity.this.aPA.Hf();
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gLa);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").w("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hHd = true;
                        WriteActivity.this.nX(true);
                        if (!WriteActivity.this.bKC().isFocused() || WriteActivity.this.hHg.getVisibility() != 0) {
                            WriteActivity.this.hHc = "from_content";
                        } else {
                            WriteActivity.this.hHc = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hHg.setVisibility(0);
                        WriteActivity.this.hHg.requestFocus();
                        WriteActivity.this.buz();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hHg.hasFocus()) {
                            WriteActivity.this.gLa.requestFocus();
                            WriteActivity.this.gLa.setSelection(WriteActivity.this.gLa.getText().toString().length());
                        }
                        WriteActivity.this.hHg.setVisibility(8);
                        WriteActivity.this.buz();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aPA.setActionListener(16, bVar);
        this.aPA.setActionListener(14, bVar);
        this.aPA.setActionListener(24, bVar);
        this.aPA.setActionListener(3, bVar);
        this.aPA.setActionListener(10, bVar);
        this.aPA.setActionListener(11, bVar);
        this.aPA.setActionListener(12, bVar);
        this.aPA.setActionListener(13, bVar);
        this.aPA.setActionListener(15, bVar);
        this.aPA.setActionListener(18, bVar);
        this.aPA.setActionListener(20, bVar);
        this.aPA.setActionListener(25, bVar);
        this.aPA.setActionListener(27, bVar);
        this.aPA.setActionListener(29, bVar);
        this.aPA.setActionListener(43, bVar);
        this.aPA.setActionListener(45, bVar);
        this.aPA.setActionListener(53, bVar);
        this.aPA.setActionListener(48, bVar);
        this.aPA.setActionListener(46, bVar);
        this.aPA.setActionListener(49, bVar);
        this.aPA.setActionListener(47, bVar);
        this.aPA.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo() {
        if (this.aRc.ahE()) {
            if (this.aRc.bzw()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bzs().getLocationData().bzo());
                return;
            }
            b(1, true, null);
            this.aRc.bzu();
            return;
        }
        b(0, true, null);
    }

    protected void bur() {
        if (this.aRd != null) {
            this.aRd.cancelLoadData();
        }
        if (this.hHh != null) {
            this.hHh.cancelLoadData();
        }
        if (this.aRc != null) {
            this.aRc.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bKn();
        TiebaPrepareImageService.StopService();
        bur();
        bKT();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hIb != null) {
            this.hIb.destroy();
        }
        if (this.hIC != null) {
            this.hIC.amz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKp() {
        if (this.mData != null && this.mData.getType() == 2 && this.hHX) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bKC().getText().toString());
            this.mData.setContent(bKB().getText().toString());
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
            if (this.gLc != null && this.gLc.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gLc, getPageContext().getPageActivity());
                return true;
            } else if (this.aPA.IM()) {
                this.aPA.Hf();
                return true;
            } else {
                bur();
                bKp();
                return true;
            }
        }
        if (i == 67 && (text = bKB().getText()) != null) {
            int selectionStart = bKB().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bKB().onKeyDown(67, this.daZ);
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
        getLayoutMode().onModeChanged(this.hIs);
        if (this.hIp != null && i == 1) {
            this.hIp.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bKk();
        al.j(this.hIf, e.d.cp_bg_line_d);
        al.j(this.gKX, e.d.cp_bg_line_c);
        al.j(this.hIg, e.d.cp_bg_line_c);
        al.j(bKC(), e.d.cp_bg_line_d);
        al.c(this.fHK, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ffF)) {
            al.j(bKB(), e.d.cp_bg_line_d);
        }
        buz();
        this.aPA.onChangeSkinType(i);
        if (this.hHv != null) {
            this.hHv.BQ();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bKq();
        bKr();
        if (this.hHD != null) {
            this.hHD.c(bKC(), bKB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKq() {
        if (this.gKW.hasFocus()) {
            this.gKW.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gKW.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.gLa.hasFocus()) {
            this.gLa.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gLa.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        if (this.gKW != null && this.gKW.getText() != null && this.gKW.getText().toString() != null && this.gKW.getPaint() != null) {
            if (this.gKW.getText().toString().length() == 0) {
                this.gKW.getPaint().setFakeBoldText(false);
            } else if (this.gKW.getText().toString().length() > 0) {
                this.gKW.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aZn = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hHx = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.hHV = (TextView) findViewById(e.g.btn_image_problem);
        bKt();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0141e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gKU);
        this.hHw = (ScrollView) findViewById(e.g.write_scrollview);
        this.hHw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gLa != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gLa);
                    }
                    if (WriteActivity.this.aPA != null) {
                        WriteActivity.this.aPA.Hf();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hHT = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.hHU = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hHf = (LinearLayout) findViewById(e.g.tool_view);
        this.hHf.setContentDescription("..");
        this.hHg = (LinearLayout) findViewById(e.g.title_view);
        this.gKX = findViewById(e.g.interval_view);
        this.hIx = findViewById(e.g.hot_topic_fourm_view);
        this.hIy = findViewById(e.g.hot_topic_divider);
        this.hHz = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.hIz = (TextView) findViewById(e.g.change_one_tv);
        buy();
        if (this.hHx) {
            this.hHw.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bKL();
        } else {
            this.hIb = new g(getPageContext(), this.mRootView);
            g gVar = this.hIb;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nS(z);
        }
        buA();
        if (this.hHQ || this.hHe) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().auw) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gKZ = (LinearLayout) findViewById(e.g.post_content_container);
        this.gKZ.setDrawingCacheEnabled(false);
        this.gKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gLa.requestFocus();
            }
        });
        this.fHH = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.fHI = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.fHK = (ImageView) findViewById(e.g.iv_delete_voice);
        this.fHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bey();
            }
        });
        this.aEa.setOnFocusChangeListener(this.gKU);
        this.aEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bur();
                WriteActivity.this.bKp();
            }
        });
        this.hHV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bKw();
        j(bKU());
        bKy();
        bKs();
        bKQ();
        bKS();
        bKk();
        bKx();
        bux();
        bKE();
        if (this.mData.getType() == 4 && this.gLe != null && this.hHi != null) {
            this.gLe.setVisibility(8);
            this.hHi.setVisibility(8);
        }
        buz();
        bKO();
    }

    private void bKs() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hHQ || this.hHe) {
                        if (this.hHR) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.dOX != null && this.dOX.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.dOX != null && this.dOX.equals("2")) {
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
                    this.gKW.setVisibility(0);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gKW.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hIg.setVisibility(8);
                    return;
                case 7:
                    this.gKW.setVisibility(0);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bKt() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bKu() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hHQ && !this.hHe && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bKC() != null) {
                bKC().setText(c);
                bKC().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fHH.setVisibility(0);
            this.fHI.setVoiceModel(voiceModel);
            this.fHI.bzY();
            buz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bey() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bp(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fHH.setVisibility(8);
        this.fHI.aHP();
        this.fHI.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eZ = this.aPA.eZ(6);
        if (eZ != null && eZ.aPu != null) {
            eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        buz();
    }

    private void bKv() {
        this.hHq = null;
        this.hHs = -1;
        this.hHu = -1;
        z lh = y.axO().lh(1);
        if (lh != null) {
            this.hHq = lh.dvD;
            this.hHs = getIntent().getIntExtra("category_id", -1);
            if (this.hHq != null && !this.hHq.isEmpty() && this.hHs >= 0) {
                this.hHr = new x();
                this.hHr.dvz = 0;
                this.hHr.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hHu = this.hHr.dvz;
                this.hHt = this.hHr.name;
                for (x xVar : this.hHq) {
                    if (xVar.dvz == this.hHs) {
                        this.hHu = xVar.dvz;
                        this.hHt = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bKw() {
        if (this.hHq != null && !this.hHq.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hHv = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hHv.setText(this.hHt);
            this.hHv.setCategoryContainerData(this.hHq, this.hHr, this.hHu);
            this.hHv.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hHv.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dvz);
                        WriteActivity.this.hHu = atVar.dvz;
                        WriteActivity.this.hHv.bJX();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hHv.bJW();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKC());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKB());
                }
            });
        }
    }

    private void bKO() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hHL = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hHL.setTitle(e.j.no_disturb_start_time);
        this.hHL.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hHL);
        this.hHL.setButton(-2, getPageContext().getString(e.j.cancel), this.hHL);
        return this.hHL;
    }

    private void bKx() {
        this.hHm = (RelativeLayout) findViewById(e.g.addition_container);
        this.hHn = (TextView) findViewById(e.g.addition_create_time);
        this.hHo = (TextView) findViewById(e.g.addition_last_time);
        this.hHp = (TextView) findViewById(e.g.addition_last_content);
        if (this.hHl != null) {
            this.hHm.setVisibility(0);
            this.hHn.setText(getPageContext().getString(e.j.write_addition_create) + ao.A(this.hHl.getCreateTime() * 1000));
            if (this.hHl.getAlreadyCount() == 0) {
                this.hHo.setVisibility(8);
            } else {
                this.hHo.setText(getPageContext().getString(e.j.write_addition_last) + ao.A(this.hHl.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hHl.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hHp.setText(lastAdditionContent);
            } else {
                this.hHp.setVisibility(8);
            }
            bKB().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hHl.getAlreadyCount()), Integer.valueOf(this.hHl.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hHm.setVisibility(8);
    }

    private void bux() {
        this.gLe = findViewById(e.g.post_prefix_layout);
        if (this.hIC == null) {
            this.hIC = new com.baidu.tieba.c.d(getPageContext(), this.gLe);
            this.hIC.jN(e.f.bg_tip_blue_up_left);
            this.hIC.jM(16);
            this.hIC.fc(true);
            this.hIC.M(true);
            this.hIC.jQ(l.h(getActivity(), e.C0141e.ds32));
        }
        this.gLb = (TextView) findViewById(e.g.post_prefix);
        this.hHi = findViewById(e.g.prefix_divider);
        this.gLd = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gLe.setVisibility(0);
            this.hIC.g(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gKE = 0;
            this.gLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").al(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).g("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gLb.setVisibility(0);
                    WriteActivity.this.gLe.setSelected(true);
                    al.c(WriteActivity.this.gLd, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gLc, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aPA.Hf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gKW);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gLa);
                }
            });
            this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").al(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).g("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gLb.setSelected(true);
                    al.c(WriteActivity.this.gLd, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gLc, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aPA.Hf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKC());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKB());
                }
            });
            this.gLc = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gLc.a(this);
            this.gLc.setMaxHeight(l.h(getActivity(), e.C0141e.ds510));
            this.gLc.setOutsideTouchable(true);
            this.gLc.setFocusable(true);
            this.gLc.setOnDismissListener(this);
            this.gLc.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.gLb, e.d.cp_bg_line_d);
            al.c(this.gLd, e.f.icon_arrow_gray_down);
            this.gLb.setTextColor(color);
            this.hHj.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hHj.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nN(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nN(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gLc.addView(writePrefixItemLayout);
            }
            this.gLc.setCurrentIndex(0);
            this.gLb.setText(prefixs.get(0));
            wg(0);
            return;
        }
        this.gLe.setVisibility(8);
    }

    private void bKP() {
        if (this.hHQ && this.mData != null) {
            this.hHT.setVisibility(0);
            this.hHU.setVisibility(0);
            this.hHh = new FeedBackModel(getPageContext());
            this.hHh.wD(this.mData.getForumName());
            this.hHh.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void j(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hHT.setVisibility(8);
                        WriteActivity.this.hHU.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hHT.setVisibility(8);
                        WriteActivity.this.hHU.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hHT.a(feedBackModel.bJZ(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bKy() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kK()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hHD.a(WriteActivity.this.gKW, WriteActivity.this.gLa)) {
                        WriteActivity.this.showToast(WriteActivity.this.hHD.bIi());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKC());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bKB());
                    WriteActivity.this.aPA.Hf();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hHQ) {
                            WriteActivity.this.bKH();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.w("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bKI();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bKH();
                    }
                    TiebaStatic.log(new am("c12262").al("obj_locate", WriteActivity.this.dOX));
                }
            }
        });
    }

    protected void bKQ() {
        this.hHW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hHW.dT(getPageContext().getString(e.j.is_save_draft)).aE(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bKC().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bKB().getText().toString());
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
        this.hHW.b(getPageContext());
    }

    protected void buy() {
        this.hHS = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.hHS.setIsRound(true);
        this.hHS.setDrawBorder(false);
        this.hHS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String eN = com.baidu.tbadk.core.util.o.eN(currentPortrait);
            this.hHS.setUrl(eN);
            this.hHS.startLoad(eN, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hHS.setVisibility(0);
        }
        this.gKW = (EditText) findViewById(e.g.post_title);
        this.gKW.setOnClickListener(this.hHH);
        this.gKW.setOnFocusChangeListener(this.gKU);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gKW.setText(this.mData.getTitle());
                this.gKW.setSelection(this.mData.getTitle().length());
            } else if (this.hHR) {
                this.gKW.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gKW.addTextChangedListener(this.hHJ);
        if (!this.mData.getHaveDraft()) {
            bKu();
            this.hIw = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gKW.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.gKW.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher bKR() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hIG;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.buz();
                if (WriteActivity.this.hHx) {
                    this.hIG = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hIG);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hHx || !WriteActivity.this.hIn) {
                    if (WriteActivity.this.hHx) {
                        if (this.mEditText != WriteActivity.this.hIe || this.mTextView != WriteActivity.this.hIk) {
                            this.mEditText = WriteActivity.this.hIe;
                            this.mTextView = WriteActivity.this.hIk;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hIi || this.mTextView != WriteActivity.this.hIj) {
                    this.mEditText = WriteActivity.this.hIi;
                    this.mTextView = WriteActivity.this.hIj;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hHx && this.hIn) {
            if (this.hIl != null) {
                this.hIi.removeTextChangedListener(this.hIl);
            }
            this.hIl = textWatcher;
        } else if (this.hHx) {
            if (this.hIm != null) {
                this.hIe.removeTextChangedListener(this.hIm);
            }
            this.hIm = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hIe) {
            return 233L;
        }
        if (editText != this.hIi) {
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

    protected void buA() {
        this.gLa = (EditText) findViewById(e.g.post_content);
        this.gLa.setDrawingCacheEnabled(false);
        this.gLa.setOnClickListener(this.hHH);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Kf().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.gLa.setText(al);
            this.gLa.setSelection(al.length());
        } else if (this.mData.getType() == 2) {
            if (this.hHX) {
                if (this.hHY != null && this.hHY.length() > 0) {
                    this.gLa.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.hHY}));
                    this.gLa.setSelection(this.gLa.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gLa.setText(format);
                this.gLa.setSelection(format.length());
            }
        }
        this.gLa.setOnFocusChangeListener(this.gKU);
        this.gLa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gLa.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gLa.addTextChangedListener(this.hHK);
        if (this.mData.getType() == 0) {
            this.hIB = true;
        } else {
            nZ(true);
            this.hIB = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gLa.setHint(e.j.write_input_content);
        } else {
            this.gLa.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nZ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hHx) {
            bKB().setPadding(0, 0, 0, 0);
            bKB().setBackgroundDrawable(null);
            al.j(bKB(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ffF) && this.hHl == null) {
                com.baidu.adp.lib.f.c.jn().a(this.ffF, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.oh() != null && aVar.ol() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.oh(), aVar.oh().getNinePatchChunk(), aVar.ol(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bKB().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bKB(), true, WriteActivity.this.fOq);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKA() {
        int i = 5000;
        if (this.hHl != null) {
            i = 1000;
        }
        return bKB().getText() != null && bKB().getText().length() >= i;
    }

    private void hc(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hHc)) {
                this.hHc = "";
                bKB().requestFocus();
                if (bKB().getText() != null && bKB().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bKB().getSelectionStart();
                    editable = bKB().getText();
                }
            } else if ("from_title".equals(this.hHc)) {
                this.hHc = "";
                bKC().requestFocus();
                if (bKC().getText() != null && bKC().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bKC().getSelectionStart();
                    editable = bKC().getText();
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
    public void nX(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(o oVar) {
        if (((ImageSpan[]) bKB().getText().getSpans(0, bKB().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hHk == null) {
                this.hHk = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hHk.show();
            return;
        }
        String name = oVar.getName();
        final EmotionGroupType Dv = oVar.Dv();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jn().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bKB().getSelectionStart(), aVar, Dv);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bKB() != null && bKB().getText() != null) {
            Bitmap oh = aVar.oh();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oh);
            int width = oh.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oh.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bKB().getSelectionStart() - 1;
                if (bKB().getText().length() > 1 && selectionStart >= 0 && bKB().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bKB().getText().insert(bKB().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bKB().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bKB().getText().insert(bKB().getSelectionStart(), spannableString2);
            }
            Editable text = bKB().getText();
            if (text != null) {
                this.hHA.clear();
                this.hHA.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hHA);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bKB().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bKB().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bKB().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bKB() {
        return this.hHx ? this.hIe : this.gLa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bKC() {
        return this.hHx ? this.hIi : this.gKW;
    }

    protected void bKD() {
        Editable text;
        if (bKB() != null && (text = bKB().getText()) != null) {
            int selectionStart = bKB().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bKB().onKeyDown(67, this.daZ);
            }
            bKB().onKeyDown(67, this.daZ);
            int selectionStart2 = bKB().getSelectionStart();
            if (text != null) {
                this.hHA.clear();
                this.hHA.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hHA);
                bKB().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.hHQ = true;
        }
    }

    private void bKS() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bKT() {
        try {
            if (this.hHW != null) {
                this.hHW.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aZn.d(null);
        this.aZn.dq(e.j.sending);
        this.aZn.aZ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aZn.aZ(false);
    }

    private Boolean bKU() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aRh = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void buz() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bKC() != null) {
                str = bKC().getText().toString();
            }
            if (bKB() != null) {
                str2 = bKB().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gKE == com.baidu.tbadk.core.util.v.y(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hHg.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nY(true);
                            return;
                        }
                    } else if (this.hHg.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nY(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hHg.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nY(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hHx) {
                    nY(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nY(true);
                }
            }
            if (this.mData.getType() == 4) {
                nY(o(this.hIe) && n(this.hIi));
            } else if (this.mData.getType() == 5) {
                nY(o(this.hIe));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nY(true);
            } else if (this.mData.getVideoInfo() != null) {
                nY(true);
            } else {
                nY(false);
            }
        }
    }

    public void nY(boolean z) {
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
        this.aRd = new NewWriteModel(this);
        this.aRd.b(this.aRr);
        registerListener(this.hID);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bur();
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
            this.hHQ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hHR = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hHX = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hHY = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aRb = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hHl = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hHl != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hHZ = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hIA = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.dOX = bundle.getString("KEY_CALL_FROM");
            this.hBC = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hHQ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hHR = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hHX = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hHY = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hHl = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hHl != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hHZ = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hIA = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.dOX = intent.getStringExtra("KEY_CALL_FROM");
            this.hBC = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hHQ);
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
        this.ffF = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hHe = true;
        }
        bKv();
        try {
            this.hIo = bLb();
        } catch (Throwable th) {
            this.hIo = null;
        }
    }

    private void bKE() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gKW.setText(com.baidu.tbadk.plugins.b.hL(com.baidu.tbadk.plugins.b.hM(hotTopicBussinessData.mTopicName)));
            this.gKW.setMovementMethod(com.baidu.tieba.view.c.bHk());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString hL = com.baidu.tbadk.plugins.b.hL(com.baidu.tbadk.plugins.b.hM(hotTopicBussinessData.mTopicName));
            if (hL != null) {
                this.gKW.setText(hL);
            }
            this.hHz.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String hM;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bKC().getText().toString()) || this.hIw || ((this.hHQ || this.hHe) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!com.baidu.tbadk.core.util.v.z(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            hM = this.mData.getTitle();
                        } else {
                            hM = com.baidu.tbadk.plugins.b.hM(str);
                        }
                        SpannableString hL = com.baidu.tbadk.plugins.b.hL(hM);
                        if (hL != null) {
                            bKC().setText(hL);
                            bKC().setSelection(hL.length() > hM.length() ? hM.length() : hL.length());
                        }
                    } else {
                        SpannableString hL2 = com.baidu.tbadk.plugins.b.hL(this.mData.getTitle());
                        if (hL2 != null) {
                            bKC().setText(hL2);
                            bKC().setSelection(this.mData.getTitle().length() > hL2.length() ? hL2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bKu();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bKB().getText().toString()) || this.hHQ || this.hHe) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Kf().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hHF);
                    bKB().setText(a2);
                    bKB().setSelection(a2.length());
                    if (this.hHx) {
                        a(this.hIk, this.hIe);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bLa();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bKK();
                    }
                    oa(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bKV();
                }
                buz();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hHq != null) {
                    this.hHu = this.hHr.dvz;
                    this.hHt = this.hHr.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hHq.size()) {
                            break;
                        }
                        x xVar = this.hHq.get(i);
                        if (categoryTo != xVar.dvz) {
                            i++;
                        } else {
                            this.hHu = categoryTo;
                            this.hHt = xVar.name;
                            this.mData.setCategoryTo(this.hHu);
                            break;
                        }
                    }
                    if (this.hHv != null) {
                        this.hHv.setText(this.hHt);
                        this.hHv.setCategoryContainerData(this.hHq, this.hHr, this.hHu);
                    }
                }
                this.aPA.Hf();
                return;
            }
            return;
        }
        bKV();
        bKu();
    }

    private void bKV() {
        if ((!this.hHx || this.hId != null) && this.hIc != null) {
            this.hId.c(this.writeImagesInfo);
            bKY();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hHX);
        if (this.hHQ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aRb);
        if (this.hHl != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hHl));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hHZ);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dOX);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hBC);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bKB().getEditableText().toString();
        if (obj != null) {
            bKB().setText(TbFaceManager.Kf().a(getPageContext().getPageActivity(), obj, this.hHF));
            bKB().setSelection(bKB().getText().length());
        }
    }

    private String bKF() {
        return (bKB() == null || bKB().getText() == null) ? "" : bKB().getText().toString();
    }

    private String bKG() {
        if (this.mData == null || bKC() == null || bKC().getVisibility() != 0 || bKC().getText() == null) {
            return "";
        }
        String obj = bKC().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.y(this.mPrefixData.getPrefixs()) > 0 && this.gKE != com.baidu.tbadk.core.util.v.y(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gLb != null && this.gLb.getText() != null) {
            this.mData.setPostPrefix(this.gLb.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void wE(String str) {
        if (this.mData != null && this.hHg != null) {
            if (this.hHg.getVisibility() == 0) {
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
    public void bKH() {
        bur();
        this.mData.setContent(bKF());
        wE(bKG());
        if (this.hHQ || this.hHe) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                wE(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.kK()) {
                    sb.append(com.baidu.adp.lib.util.j.kS());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hHs >= 0) {
            this.mData.setCategoryFrom(this.hHs);
        }
        if (this.hHu >= 0) {
            this.mData.setCategoryTo(this.hHu);
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
        this.mData.setHasLocationData(this.aRc != null && this.aRc.ahE());
        if (this.writeImagesInfo != null) {
            this.aRd.mV(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.z(this.mList) && this.hHy != null && this.hHy.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hHy.mForumId));
            this.mData.setForumName(this.hHy.mForumName);
        }
        this.aRd.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aRd.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aRd.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aRd.getWriteData().setVoice(null);
                this.aRd.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aRd.getWriteData().setVoice(null);
            this.aRd.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aRd.bAa()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kK()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.aRd.startPostWrite();
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
            if (this.hHl != null) {
                i2 = this.hHl.getTotalCount();
                i = this.hHl.getAlreadyCount() + 1;
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
                if (this.gKW == getCurrentFocus()) {
                    bKB().clearFocus();
                    this.gKW.requestFocus();
                    if (this.aPA != null) {
                        this.aPA.Hf();
                    }
                    ShowSoftKeyPadDelay(this.gKW);
                } else {
                    bKB().requestFocus();
                    if (this.aPA != null) {
                        this.aPA.Hf();
                    }
                    ShowSoftKeyPadDelay(this.gLa);
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
                            bKB().getText().insert(bKB().getSelectionStart(), sb.toString());
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
                                bKZ();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            ah(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hIB) {
                            nZ(true);
                            this.hIB = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hHx) {
                        A(intent);
                        buz();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aPA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    buz();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hHd) {
                                sb2.append(com.baidu.tbadk.plugins.b.aYK);
                                this.hHd = false;
                            }
                            sb2.append(stringExtra);
                            hc(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.z(this.mList) && !com.baidu.tbadk.core.util.v.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hHy = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hHy);
                }
            }
        } else if (i2 == 0) {
            if (this.aPA != null && !this.aPA.IM()) {
                this.gLa.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aPA.Hf();
            }
            switch (i) {
                case 12001:
                    Jr();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bKX();
                    if (this.hIB) {
                        nZ(true);
                        this.hIB = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gKW == getCurrentFocus()) {
                        bKB().clearFocus();
                        this.gKW.requestFocus();
                        if (this.aPA != null) {
                            this.aPA.Hf();
                        }
                        ShowSoftKeyPadDelay(this.gKW);
                        return;
                    }
                    bKB().requestFocus();
                    if (this.aPA != null) {
                        this.aPA.Hf();
                    }
                    ShowSoftKeyPadDelay(this.gLa);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hHD.wi(postWriteCallBackData.getErrorString());
                        this.hHD.aA(postWriteCallBackData.getSensitiveWords());
                        this.hHD.b(this.gKW, this.gLa);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aRb = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aRb);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bKX();
                    return;
                case 25004:
                    if ("from_title".equals(this.hHc)) {
                        bKC().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hHc)) {
                        bKB().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        if ("1".equals(this.dOX)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dOX)) {
            this.mData.setCanNoForum(false);
        }
        bKJ();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.dOX);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bKH();
    }

    private void bKJ() {
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bKW() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bKX() {
        if (this.hHx) {
            this.hId.c(this.writeImagesInfo);
            bKY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        this.hId.notifyDataSetChanged();
        this.hIc.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hId.notifyDataSetChanged();
                WriteActivity.this.hIc.invalidateViews();
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
        buz();
    }

    private void ae(Intent intent) {
        if (this.hHx) {
            af(intent);
            bKX();
        } else {
            ai(intent);
        }
        buz();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bKX();
            oa(true);
        }
    }

    private void ag(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bKZ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hIa.parseJson(stringExtra);
            this.hIa.updateQuality();
            if (this.hIa.getChosedFiles() != null && this.hIa.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hIa.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hIa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bKC());
        HidenSoftKeyPad(this.mInputManager, bKB());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aRb = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aRb;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aRb, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bLa();
            bKK();
        }
        oa(true);
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
                bLa();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bKK();
                }
            }
            oa(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        if (this.aPA.eZ(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Jr() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aRb));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oa(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hIb != null) {
            this.hIb.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awt() {
        this.dsk = getVoiceManager();
        this.dsk.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dtp) != null) {
                    TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atM));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hHl == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                v(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aRi = i;
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bKK() {
        if (!this.hHx) {
            if (this.aPA != null) {
                this.aPA.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aPA.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hIb != null) {
                this.hIb.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wg(int i) {
        if (i < this.hHj.size()) {
            for (int i2 = 0; i2 < this.hHj.size(); i2++) {
                this.hHj.get(i2).nO(false);
            }
            this.hHj.get(i).nO(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void tH(int i) {
        if (i == com.baidu.tbadk.core.util.v.y(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").w("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").w("obj_type", 2));
        }
        this.gKE = i;
        this.gLc.setCurrentIndex(i);
        wg(i);
        this.gLb.setText(this.mPrefixData.getPrefixs().get(i));
        buz();
        com.baidu.adp.lib.g.g.a(this.gLc, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gLe.setSelected(false);
        al.c(this.gLd, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gLa);
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
            Jl();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.bt(getApplicationContext())) {
                ak.a(getPageContext(), this.aRb);
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
        this.hHC = z;
        if (this.hIu && System.currentTimeMillis() - this.hIv < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hIu = false;
        }
        if (this.hHB != null && !z) {
            this.hHB.aqM();
        }
        if (this.hHE != null && !z) {
            bKn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hIr != null) {
            wG(str);
            this.hIr.dismiss();
        }
    }

    private void cY(Context context) {
        hIt = l.aQ(context);
    }

    private void wG(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hIu = true;
        bLa();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bKK();
        }
        oa(true);
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

    private File bLb() {
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

    private void bLc() {
        if (this.hIo != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cY(getActivity());
            this.hIq = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.hIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hIo != null) {
                        WriteActivity.this.wF(WriteActivity.this.hIo.getAbsolutePath());
                    }
                }
            });
            this.hIp = (TbImageView) this.hIq.findViewById(e.g.rec_img_view);
            this.hIs = (LinearLayout) this.hIq.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hIo.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hIo.getAbsolutePath());
                Bitmap f = f(this.hIo.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0141e.ds160));
                if (f != null) {
                    this.hIp.setImageBitmap(f);
                    this.hIp.setDrawBorder(true);
                    this.hIp.setBorderWidth(2);
                    this.hIp.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.hIr = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.hIr.setCanceledOnTouchOutside(true);
                    this.hIr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hIu) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hIv = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hIr.setContentView(this.hIq);
                    this.hIr.show();
                    Window window = this.hIr.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0141e.ds28);
                    attributes.y = (hIt / 18) + getResources().getDimensionPixelSize(e.C0141e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(e.C0141e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(e.C0141e.ds278);
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
        if (this.hHC && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hHd = false;
            this.hHc = "";
            if ("from_content".equals(str)) {
                this.hHc = "from_content";
            } else if ("from_title".equals(str)) {
                this.hHc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hK(String.valueOf(charSequence.charAt(i)))) {
                nX(false);
            }
        }
    }

    public void bqI() {
        if (this.hHQ || !com.baidu.tbadk.core.util.v.z(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hHg.setVisibility(0);
            this.hHg.requestFocus();
            this.aPA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hHg.setVisibility(8);
    }
}
