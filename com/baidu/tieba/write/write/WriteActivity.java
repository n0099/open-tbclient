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
    private static int ibL = 0;
    private EditorTools aYr;
    private String aZS;
    private LocationModel aZT;
    private NewWriteModel aZU;
    private VoiceManager dKQ;
    private LinearLayout gaq;
    private PlayVoiceBntNew gar;
    private ImageView gat;
    private TextView hdV;
    private com.baidu.tieba.write.d hdW;
    private ImageView hdX;
    private View hdY;
    private int hdy;
    private View iaA;
    private Toast iaC;
    private AdditionData iaD;
    private RelativeLayout iaE;
    private TextView iaF;
    private TextView iaG;
    private TextView iaH;
    List<x> iaI;
    x iaJ;
    private int iaK;
    private String iaL;
    private int iaM;
    private PostCategoryView iaN;
    private HotTopicBussinessData iaQ;
    private TextView iaR;
    private com.baidu.tieba.write.editor.b iaT;
    private e iaW;
    private LinearLayout iax;
    private LinearLayout iay;
    private View ibP;
    private View ibQ;
    private TextView ibR;
    private com.baidu.tieba.c.d ibU;
    private com.baidu.tieba.view.b ibd;
    private View ibm;
    private g ibt;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String iau = "";
    private boolean iav = false;
    private WriteData mData = null;
    private boolean ibi = false;
    private boolean iaw = false;
    private boolean ibj = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText hdQ = null;
    private HeadImageView ibk = null;
    private View hdR = null;
    private LinearLayout hdT = null;
    private EditText hdU = null;
    private FeedBackModel iaz = null;
    private FeedBackTopListView ibl = null;
    private ArrayList<WritePrefixItemLayout> iaB = new ArrayList<>();
    private String fyq = null;
    private final KeyEvent dtF = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aMW = null;
    private TextView ibn = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a ibo = null;
    private final Handler mHandler = new Handler();
    private boolean ibp = false;
    private String ibq = null;
    private RelativeLayout mParent = null;
    private String aZY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aZZ = 0;
    private int ibr = 0;
    private WriteImagesInfo ibs = new WriteImagesInfo();
    private View mRootView = null;
    private GridView ibu = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a ibv = null;
    private ScrollView iaO = null;
    private EditText ibw = null;
    private View ibx = null;
    private View iby = null;
    private View ibz = null;
    private EditText ibA = null;
    private TextView ibB = null;
    private TextView ibC = null;
    private TextWatcher ibD = null;
    private TextWatcher ibE = null;
    private boolean iaP = false;
    private boolean ibF = false;
    private com.baidu.tbadk.core.view.d bif = null;
    private String mFrom = "write";
    private File ibG = null;
    private TbImageView ibH = null;
    private View ibI = null;
    private Dialog ibJ = null;
    private LinearLayout ibK = null;
    private boolean ibM = false;
    private long ibN = -1000;
    private boolean ibO = false;
    private String ehA = "2";
    private int hUV = 0;
    private String ibS = "";
    private SpannableStringBuilder iaS = new SpannableStringBuilder();
    private boolean ibT = false;
    private boolean iaU = false;
    private final b iaV = new b();
    private final HttpMessageListener ibV = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fyq)) {
                    WriteActivity.this.fyq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oI(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fyq)) {
                    WriteActivity.this.fyq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fyq);
                    WriteActivity.this.oI(true);
                }
            }
        }
    };
    private TbFaceManager.a iaX = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ie(String str) {
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
    private final AntiHelper.a dLU = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCL));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCL));
        }
    };
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.aBM();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.iaV.aA(null);
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
                        if (!v.I(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.ibS)) {
                            TiebaStatic.log(new am("c11731").aA(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.ibS));
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
                    WriteActivity.this.iaV.aA(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.iaV.xu(postWriteCallBackData.getErrorString());
                    WriteActivity.this.iaV.b(WriteActivity.this.hdQ, WriteActivity.this.hdU);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GX());
                    if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GW());
                        if (WriteActivity.this.ibj) {
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
    private final LocationModel.a bag = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void MO() {
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
            if (aVar != null && !StringUtils.isNull(aVar.bEL())) {
                WriteActivity.this.b(2, true, aVar.bEL());
            } else {
                dj(null);
            }
        }
    };
    private final CustomMessageListener hqM = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aZT.nA(false);
                    WriteActivity.this.aZT.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aZT.nA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener iaY = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener iaZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bPQ = WriteActivity.this.bPQ();
            if (bPQ >= 0 && bPQ < WriteActivity.this.hdU.getText().length()) {
                WriteActivity.this.hdU.setSelection(bPQ);
            }
        }
    };
    private boolean iba = true;
    private final View.OnFocusChangeListener hdO = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.hdQ || view == WriteActivity.this.aMW || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.iba = true;
                    WriteActivity.this.bPR();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.hdQ);
                    if (WriteActivity.this.aYr != null) {
                        WriteActivity.this.aYr.Kx();
                    }
                } else if (view == WriteActivity.this.hdQ) {
                    WriteActivity.this.hdV.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.hdU && z) {
                WriteActivity.this.iba = false;
                WriteActivity.this.bPR();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.hdU);
                if (WriteActivity.this.aYr != null) {
                    WriteActivity.this.aYr.Kx();
                }
            }
            WriteActivity.this.bPX();
        }
    };
    private TextWatcher ibb = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String ibf = "";
        private String ibg;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ibg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ibg != null ? this.ibg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bzT();
            WriteActivity.this.bPY();
            EditText bQj = WriteActivity.this.bQj();
            if (editable != null && bQj != null && bQj.getText() != null) {
                if (this.ibf == null || !this.ibf.equals(editable.toString())) {
                    if (WriteActivity.this.iaV != null) {
                        this.ibf = bQj.getText().toString();
                        WriteActivity.this.iaV.k(bQj);
                        return;
                    }
                    return;
                }
                bQj.setSelection(bQj.getSelectionEnd());
            }
        }
    };
    private TextWatcher ibc = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String ibg;
        private String ibh = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ibg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ibg != null ? this.ibg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bzT();
            EditText bQi = WriteActivity.this.bQi();
            if (editable != null && bQi != null && bQi.getText() != null) {
                if (this.ibh == null || !this.ibh.equals(editable.toString())) {
                    if (WriteActivity.this.iaV != null) {
                        this.ibh = bQi.getText().toString();
                        WriteActivity.this.iaV.k(bQi);
                        return;
                    }
                    return;
                }
                bQi.setSelection(bQi.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0314a gha = new a.InterfaceC0314a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
            WriteActivity.this.fyq = null;
            WriteActivity.this.oI(false);
            WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void Mz() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void MA() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MC();
        } else if (this.aZT.bES()) {
            Mz();
        } else {
            this.aZT.nA(false);
            b(1, true, null);
            this.aZT.bEQ();
        }
    }

    private void MC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aZT.ams();
                } else {
                    WriteActivity.this.bag.MO();
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
    public int bPQ() {
        int selectionEnd = bQi().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bQi().getText().getSpans(0, bQi().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bQi().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bQi().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPR() {
        if (this.aYr != null) {
            this.aYr.setBarLauncherEnabled(!this.iba);
            this.aYr.setBarLauncherEnabled(true, 26);
            this.aYr.setBarLauncherEnabled(true, 2);
            K(9, this.iba ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g fI;
        if (this.aYr != null && (fI = this.aYr.fI(i)) != null) {
            if (z) {
                fI.pN();
            } else {
                fI.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.iaP) {
            this.hdQ.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.ibz.setVisibility(8);
            } else {
                this.ibz.setVisibility(0);
            }
            a(this.ibC, this.ibw);
            a(this.ibB, this.ibA);
            bzT();
        }
        if (this.ibi) {
            this.iba = true;
            bPR();
            if (this.aYr != null) {
                this.aYr.Kx();
            }
            this.hdQ.requestFocus();
            ShowSoftKeyPadDelay(this.hdQ);
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
            bQG();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bQr();
            }
            oJ(true);
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
            xH(this.hUV);
        }
        initUI();
        bQw();
        this.aZT = new LocationModel(this);
        this.aZT.a(this.bag);
        registerListener(this.hqM);
        registerListener(this.iaY);
        initEditor();
        bQI();
        if (this.iaP) {
            this.ibv.setEditorTools(this.aYr);
        } else {
            this.hdU.requestFocus();
        }
        bvX();
        bQr();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aYr = new EditorTools(getActivity());
        this.aYr.setBarMaxLauCount(5);
        this.aYr.setMoreButtonAtEnd(true);
        this.aYr.setBarLauncherType(1);
        this.aYr.cq(true);
        this.aYr.cr(true);
        this.aYr.setMoreLauncherIcon(e.f.write_more);
        this.aYr.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bQu();
                break;
            default:
                bPS();
                break;
        }
        this.aYr.LZ();
        if (this.iax != null) {
            this.iax.addView(this.aYr);
        }
        bPT();
        this.aYr.pN();
        com.baidu.tbadk.editortools.g fI = this.aYr.fI(6);
        if (fI != null && !TextUtils.isEmpty(this.aZY)) {
            ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aZY);
                }
            });
        }
        if (!this.iaP) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aYr.Kx();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bPV();
    }

    private void bQs() {
        this.ibx = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.ibz = this.ibx.findViewById(e.g.live_post_title_container);
        this.ibw = (EditText) this.ibx.findViewById(e.g.live_post_content);
        this.ibu = (GridView) this.ibx.findViewById(e.g.photoLiveGridView);
        this.ibA = (EditText) this.ibx.findViewById(e.g.live_post_title);
        this.ibB = (TextView) this.ibx.findViewById(e.g.titleOverPlusNumber);
        this.ibC = (TextView) this.ibx.findViewById(e.g.contentOverPlusNumber);
        this.iby = this.ibx.findViewById(e.g.live_interval_view);
        this.ibB.setText(String.valueOf(20));
        this.ibC.setText(String.valueOf(233));
        this.ibx.setVisibility(0);
        this.ibB.setVisibility(0);
        this.ibC.setVisibility(0);
        this.ibA.setHint(e.j.tips_title_limit_new);
        this.ibA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.ibF = true;
                    WriteActivity.this.iba = true;
                    WriteActivity.this.bPR();
                    if (WriteActivity.this.aYr != null) {
                        WriteActivity.this.aYr.Kx();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.ibw.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.ibw.setHint(e.j.live_write_input_content_update);
        }
        this.ibw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.ibF = false;
                    WriteActivity.this.iba = false;
                    WriteActivity.this.bPR();
                    if (WriteActivity.this.aYr != null) {
                        WriteActivity.this.aYr.Kx();
                    }
                }
            }
        });
        this.ibw.requestFocus();
        this.ibw.addTextChangedListener(getTextWatcher());
        this.ibA.requestFocus();
        this.ibA.addTextChangedListener(getTextWatcher());
        this.ibA.setOnClickListener(this.iaZ);
        this.ibw.setOnClickListener(this.iaZ);
        this.ibv = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.ibu);
        this.ibv.xB(6);
        this.ibu.setAdapter((ListAdapter) this.ibv);
        View findViewById = this.ibx.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bPB() {
                WriteActivity.this.bQE();
            }
        });
        bQt();
    }

    private void bQt() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.ibA.setText(this.mData.getTitle());
                this.ibA.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.iaP) {
            bQC();
        }
        if (this.aYr.Mb()) {
            this.aYr.Kx();
        }
        xH(0);
    }

    private void xH(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.ehA);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bQu() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aYr.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aYr.fL(5);
        if (fL != null) {
            fL.aZa = 2;
            fL.aYY = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aYY = e.f.write_at;
        this.aYr.b(aVar);
        this.aYr.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bPS() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aYY = e.f.write_picture;
        this.aYr.b(dVar);
        Boolean bQA = bQA();
        if (!this.ibi && bQA != null && bQA.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bFu() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aZa = 3;
            kVar5.aYY = e.f.write_recorder;
            this.aYr.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aYY = e.f.icon_post_topic_selector;
        this.aYr.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aZa = 5;
            kVar4.aYY = e.f.write_privilege;
            this.aYr.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aZa = 6;
            kVar3.aYY = this.ibi ? e.f.write_location : e.f.icon_post_more_location;
            this.aYr.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aYY = e.f.icon_post_more_at;
        this.aYr.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aZc = true;
            kVar2.aZa = 9;
            kVar2.aYY = 0;
            this.aYr.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aZc = true;
            kVar.aZa = 10;
            kVar.aYY = 0;
            this.aYr.b(kVar);
        }
        if (this.iaD == null) {
            if (this.iaT == null) {
                this.iaT = new com.baidu.tieba.write.editor.b(getActivity(), this.ehA);
                this.iaT.ba(this.mData.getForumId(), this.privateThread);
            }
            this.aYr.b(this.iaT);
        }
        this.aYr.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aYr.fL(5);
        if (fL != null) {
            fL.aZa = 1;
            fL.aYY = e.f.write_emotion;
        }
    }

    private void bPU() {
        if (this.iaW != null) {
            this.iaW.hideTip();
        }
    }

    private void bPV() {
        if (this.iaW == null) {
            this.iaW = new e(getPageContext());
        }
        this.iaW.c(this.aYr);
    }

    private void bPT() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bQh()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bQh()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bQk();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bjK();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bQG();
                        WriteActivity.this.bzT();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xI(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.iaD == null) {
                            WriteActivity.this.MD();
                            return;
                        }
                        switch (WriteActivity.this.aZZ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    WriteActivity.this.MA();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Mz();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aZT != null) {
                            WriteActivity.this.aZT.nA(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fyq = null;
                        } else {
                            WriteActivity.this.fyq = (String) aVar.data;
                        }
                        WriteActivity.this.oI(false);
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
                            WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aYr.Mb()) {
                                        WriteActivity.this.aYr.Kx();
                                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bzT();
                        if (WriteActivity.this.hdU != null) {
                            WriteActivity.this.hdU.requestFocus();
                        }
                        WriteActivity.this.aYr.Kx();
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.hdU);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").x("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.iav = true;
                        WriteActivity.this.oG(true);
                        if (!WriteActivity.this.bQj().isFocused() || WriteActivity.this.iay.getVisibility() != 0) {
                            WriteActivity.this.iau = "from_content";
                        } else {
                            WriteActivity.this.iau = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.iay.setVisibility(0);
                        WriteActivity.this.iay.requestFocus();
                        WriteActivity.this.bzT();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.iay.hasFocus()) {
                            WriteActivity.this.hdU.requestFocus();
                            WriteActivity.this.hdU.setSelection(WriteActivity.this.hdU.getText().toString().length());
                        }
                        WriteActivity.this.iay.setVisibility(8);
                        WriteActivity.this.bzT();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aYr.setActionListener(16, bVar);
        this.aYr.setActionListener(14, bVar);
        this.aYr.setActionListener(24, bVar);
        this.aYr.setActionListener(3, bVar);
        this.aYr.setActionListener(10, bVar);
        this.aYr.setActionListener(11, bVar);
        this.aYr.setActionListener(12, bVar);
        this.aYr.setActionListener(13, bVar);
        this.aYr.setActionListener(15, bVar);
        this.aYr.setActionListener(18, bVar);
        this.aYr.setActionListener(20, bVar);
        this.aYr.setActionListener(25, bVar);
        this.aYr.setActionListener(27, bVar);
        this.aYr.setActionListener(29, bVar);
        this.aYr.setActionListener(43, bVar);
        this.aYr.setActionListener(45, bVar);
        this.aYr.setActionListener(53, bVar);
        this.aYr.setActionListener(48, bVar);
        this.aYr.setActionListener(46, bVar);
        this.aYr.setActionListener(49, bVar);
        this.aYr.setActionListener(47, bVar);
        this.aYr.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        if (this.aZT.amo()) {
            if (this.aZT.bES()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bEO().getLocationData().bEL());
                return;
            }
            b(1, true, null);
            this.aZT.bEQ();
            return;
        }
        b(0, true, null);
    }

    protected void bzL() {
        if (this.aZU != null) {
            this.aZU.cancelLoadData();
        }
        if (this.iaz != null) {
            this.iaz.cancelLoadData();
        }
        if (this.aZT != null) {
            this.aZT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bPU();
        TiebaPrepareImageService.StopService();
        bzL();
        bQz();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ibt != null) {
            this.ibt.destroy();
        }
        if (this.ibU != null) {
            this.ibU.asb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        if (this.mData != null && this.mData.getType() == 2 && this.ibp) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bQj().getText().toString());
            this.mData.setContent(bQi().getText().toString());
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
            if (this.hdW != null && this.hdW.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.hdW, getPageContext().getPageActivity());
                return true;
            } else if (this.aYr.Mb()) {
                this.aYr.Kx();
                return true;
            } else {
                bzL();
                bPW();
                return true;
            }
        }
        if (i == 67 && (text = bQi().getText()) != null) {
            int selectionStart = bQi().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQi().onKeyDown(67, this.dtF);
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
        getLayoutMode().onModeChanged(this.ibK);
        if (this.ibH != null && i == 1) {
            this.ibH.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bPR();
        al.j(this.ibx, e.d.cp_bg_line_d);
        al.j(this.hdR, e.d.cp_bg_line_c);
        al.j(this.iby, e.d.cp_bg_line_c);
        al.j(bQj(), e.d.cp_bg_line_d);
        al.c(this.gat, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fyq)) {
            al.j(bQi(), e.d.cp_bg_line_d);
        }
        bzT();
        this.aYr.onChangeSkinType(i);
        if (this.iaN != null) {
            this.iaN.Fj();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bPX();
        bPY();
        if (this.iaV != null) {
            this.iaV.c(bQj(), bQi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPX() {
        if (this.hdQ.hasFocus()) {
            this.hdQ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.hdQ.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.hdU.hasFocus()) {
            this.hdU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.hdU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPY() {
        if (this.hdQ != null && this.hdQ.getText() != null && this.hdQ.getText().toString() != null && this.hdQ.getPaint() != null) {
            if (this.hdQ.getText().toString().length() == 0) {
                this.hdQ.getPaint().setFakeBoldText(false);
            } else if (this.hdQ.getText().toString().length() > 0) {
                this.hdQ.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bif = new com.baidu.tbadk.core.view.d(getPageContext());
        this.iaP = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.ibn = (TextView) findViewById(e.g.btn_image_problem);
        bQa();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.hdO);
        this.iaO = (ScrollView) findViewById(e.g.write_scrollview);
        this.iaO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.hdU != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.hdU);
                    }
                    if (WriteActivity.this.aYr != null) {
                        WriteActivity.this.aYr.Kx();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ibl = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.ibm = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.iax = (LinearLayout) findViewById(e.g.tool_view);
        this.iax.setContentDescription("..");
        this.iay = (LinearLayout) findViewById(e.g.title_view);
        this.hdR = findViewById(e.g.interval_view);
        this.ibP = findViewById(e.g.hot_topic_fourm_view);
        this.ibQ = findViewById(e.g.hot_topic_divider);
        this.iaR = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.ibR = (TextView) findViewById(e.g.change_one_tv);
        bzS();
        if (this.iaP) {
            this.iaO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bQs();
        } else {
            this.ibt = new g(getPageContext(), this.mRootView);
            g gVar = this.ibt;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.oB(z);
        }
        bzU();
        if (this.ibi || this.iaw) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aDx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.hdT = (LinearLayout) findViewById(e.g.post_content_container);
        this.hdT.setDrawingCacheEnabled(false);
        this.hdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.hdU.requestFocus();
            }
        });
        this.gaq = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.gar = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.gat = (ImageView) findViewById(e.g.iv_delete_voice);
        this.gat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bjK();
            }
        });
        this.aMW.setOnFocusChangeListener(this.hdO);
        this.aMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bzL();
                WriteActivity.this.bPW();
            }
        });
        this.ibn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bQd();
        j(bQA());
        bQf();
        bPZ();
        bQx();
        bQy();
        bPR();
        bQe();
        bzR();
        bQl();
        if (this.mData.getType() == 4 && this.hdY != null && this.iaA != null) {
            this.hdY.setVisibility(8);
            this.iaA.setVisibility(8);
        }
        bzT();
        bQv();
    }

    private void bPZ() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.ibi || this.iaw) {
                        if (this.ibj) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.ehA != null && this.ehA.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.ehA != null && this.ehA.equals("2")) {
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
                    this.hdQ.setVisibility(0);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.hdQ.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.iby.setVisibility(8);
                    return;
                case 7:
                    this.hdQ.setVisibility(0);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bQa() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bQb() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.ibi && !this.iaw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bQj() != null) {
                bQj().setText(c);
                bQj().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.gaq.setVisibility(0);
            this.gar.setVoiceModel(voiceModel);
            this.gar.bFt();
            bzT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjK() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.gaq.setVisibility(8);
        this.gar.aNk();
        this.gar.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fL = this.aYr.fL(6);
        if (fL != null && fL.aYl != null) {
            fL.aYl.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bzT();
    }

    private void bQc() {
        this.iaI = null;
        this.iaK = -1;
        this.iaM = -1;
        z mA = y.aDg().mA(1);
        if (mA != null) {
            this.iaI = mA.dOh;
            this.iaK = getIntent().getIntExtra("category_id", -1);
            if (this.iaI != null && !this.iaI.isEmpty() && this.iaK >= 0) {
                this.iaJ = new x();
                this.iaJ.dOd = 0;
                this.iaJ.name = getPageContext().getResources().getString(e.j.category_auto);
                this.iaM = this.iaJ.dOd;
                this.iaL = this.iaJ.name;
                for (x xVar : this.iaI) {
                    if (xVar.dOd == this.iaK) {
                        this.iaM = xVar.dOd;
                        this.iaL = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bQd() {
        if (this.iaI != null && !this.iaI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.iaN = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.iaN.setText(this.iaL);
            this.iaN.setCategoryContainerData(this.iaI, this.iaJ, this.iaM);
            this.iaN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.iaN.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dOd);
                        WriteActivity.this.iaM = atVar.dOd;
                        WriteActivity.this.iaN.bPE();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.iaN.bPD();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQj());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQi());
                }
            });
        }
    }

    private void bQv() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ibd = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ibd.setTitle(e.j.no_disturb_start_time);
        this.ibd.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.ibd);
        this.ibd.setButton(-2, getPageContext().getString(e.j.cancel), this.ibd);
        return this.ibd;
    }

    private void bQe() {
        this.iaE = (RelativeLayout) findViewById(e.g.addition_container);
        this.iaF = (TextView) findViewById(e.g.addition_create_time);
        this.iaG = (TextView) findViewById(e.g.addition_last_time);
        this.iaH = (TextView) findViewById(e.g.addition_last_content);
        if (this.iaD != null) {
            this.iaE.setVisibility(0);
            this.iaF.setText(getPageContext().getString(e.j.write_addition_create) + ao.M(this.iaD.getCreateTime() * 1000));
            if (this.iaD.getAlreadyCount() == 0) {
                this.iaG.setVisibility(8);
            } else {
                this.iaG.setText(getPageContext().getString(e.j.write_addition_last) + ao.M(this.iaD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.iaD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.iaH.setText(lastAdditionContent);
            } else {
                this.iaH.setVisibility(8);
            }
            bQi().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.iaD.getAlreadyCount()), Integer.valueOf(this.iaD.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.iaE.setVisibility(8);
    }

    private void bzR() {
        this.hdY = findViewById(e.g.post_prefix_layout);
        if (this.ibU == null) {
            this.ibU = new com.baidu.tieba.c.d(getPageContext(), this.hdY);
            this.ibU.lh(e.f.bg_tip_blue_up_left);
            this.ibU.lg(16);
            this.ibU.fI(true);
            this.ibU.aa(true);
            this.ibU.lk(l.h(getActivity(), e.C0210e.ds32));
        }
        this.hdV = (TextView) findViewById(e.g.post_prefix);
        this.iaA = findViewById(e.g.prefix_divider);
        this.hdX = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.hdY.setVisibility(0);
            this.ibU.h(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hdy = 0;
            this.hdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aA(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.hdV.setVisibility(0);
                    WriteActivity.this.hdY.setSelected(true);
                    al.c(WriteActivity.this.hdX, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.hdW, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aYr.Kx();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.hdQ);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.hdU);
                }
            });
            this.hdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aA(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.hdV.setSelected(true);
                    al.c(WriteActivity.this.hdX, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.hdW, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aYr.Kx();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQj());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQi());
                }
            });
            this.hdW = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.hdW.a(this);
            this.hdW.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.hdW.setOutsideTouchable(true);
            this.hdW.setFocusable(true);
            this.hdW.setOnDismissListener(this);
            this.hdW.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.hdV, e.d.cp_bg_line_d);
            al.c(this.hdX, e.f.icon_arrow_gray_down);
            this.hdV.setTextColor(color);
            this.iaB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.iaB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ow(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ow(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.hdW.addView(writePrefixItemLayout);
            }
            this.hdW.setCurrentIndex(0);
            this.hdV.setText(prefixs.get(0));
            xG(0);
            return;
        }
        this.hdY.setVisibility(8);
    }

    private void bQw() {
        if (this.ibi && this.mData != null) {
            this.ibl.setVisibility(0);
            this.ibm.setVisibility(0);
            this.iaz = new FeedBackModel(getPageContext());
            this.iaz.xP(this.mData.getForumName());
            this.iaz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.ibl.setVisibility(8);
                        WriteActivity.this.ibm.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.ibl.setVisibility(8);
                        WriteActivity.this.ibm.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.ibl.a(feedBackModel.bPG(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bQf() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.iaV.a(WriteActivity.this.hdQ, WriteActivity.this.hdU)) {
                        WriteActivity.this.showToast(WriteActivity.this.iaV.bNP());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQj());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQi());
                    WriteActivity.this.aYr.Kx();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.ibi) {
                            WriteActivity.this.bQo();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.x("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bQp();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bQo();
                    }
                    TiebaStatic.log(new am("c12262").aA("obj_locate", WriteActivity.this.ehA));
                }
            }
        });
    }

    protected void bQx() {
        this.ibo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ibo.eB(getPageContext().getString(e.j.is_save_draft)).bf(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bQj().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bQi().getText().toString());
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
        this.ibo.b(getPageContext());
    }

    protected void bzS() {
        this.ibk = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.ibk.setIsRound(true);
        this.ibk.setDrawBorder(false);
        this.ibk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String fu = o.fu(currentPortrait);
            this.ibk.setUrl(fu);
            this.ibk.startLoad(fu, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.ibk.setVisibility(0);
        }
        this.hdQ = (EditText) findViewById(e.g.post_title);
        this.hdQ.setOnClickListener(this.iaZ);
        this.hdQ.setOnFocusChangeListener(this.hdO);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.hdQ.setText(this.mData.getTitle());
                this.hdQ.setSelection(this.mData.getTitle().length());
            } else if (this.ibj) {
                this.hdQ.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.hdQ.addTextChangedListener(this.ibb);
        if (!this.mData.getHaveDraft()) {
            bQb();
            this.ibO = true;
        }
        if (this.mData.isUserFeedback()) {
            this.hdQ.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.hdQ.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher getTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int ibY;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bzT();
                if (WriteActivity.this.iaP) {
                    this.ibY = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.ibY);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.iaP || !WriteActivity.this.ibF) {
                    if (WriteActivity.this.iaP) {
                        if (this.mEditText != WriteActivity.this.ibw || this.mTextView != WriteActivity.this.ibC) {
                            this.mEditText = WriteActivity.this.ibw;
                            this.mTextView = WriteActivity.this.ibC;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.ibA || this.mTextView != WriteActivity.this.ibB) {
                    this.mEditText = WriteActivity.this.ibA;
                    this.mTextView = WriteActivity.this.ibB;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.iaP && this.ibF) {
            if (this.ibD != null) {
                this.ibA.removeTextChangedListener(this.ibD);
            }
            this.ibD = textWatcher;
        } else if (this.iaP) {
            if (this.ibE != null) {
                this.ibw.removeTextChangedListener(this.ibE);
            }
            this.ibE = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.ibw) {
            return 233L;
        }
        if (editText != this.ibA) {
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

    protected void bzU() {
        this.hdU = (EditText) findViewById(e.g.post_content);
        this.hdU.setDrawingCacheEnabled(false);
        this.hdU.setOnClickListener(this.iaZ);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nu().am(getPageContext().getPageActivity(), this.mData.getContent());
            this.hdU.setText(am);
            this.hdU.setSelection(am.length());
        } else if (this.mData.getType() == 2) {
            if (this.ibp) {
                if (this.ibq != null && this.ibq.length() > 0) {
                    this.hdU.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.ibq}));
                    this.hdU.setSelection(this.hdU.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.hdU.setText(format);
                this.hdU.setSelection(format.length());
            }
        }
        this.hdU.setOnFocusChangeListener(this.hdO);
        this.hdU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.hdU.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.hdU.addTextChangedListener(this.ibc);
        if (this.mData.getType() == 0) {
            this.ibT = true;
        } else {
            oI(true);
            this.ibT = false;
        }
        if (this.mData.isUserFeedback()) {
            this.hdU.setHint(e.j.write_input_content);
        } else {
            this.hdU.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oI(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.iaP) {
            bQi().setPadding(0, 0, 0, 0);
            bQi().setBackgroundDrawable(null);
            al.j(bQi(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fyq) && this.iaD == null) {
                com.baidu.adp.lib.f.c.jA().a(this.fyq, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bQi().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bQi(), true, WriteActivity.this.gha);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQh() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.iaD != null) {
            i = 1000;
        }
        return bQi().getText() != null && bQi().getText().length() >= i;
    }

    private void hK(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.iau)) {
                this.iau = "";
                bQi().requestFocus();
                if (bQi().getText() != null && bQi().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQi().getSelectionStart();
                    editable = bQi().getText();
                }
            } else if ("from_title".equals(this.iau)) {
                this.iau = "";
                bQj().requestFocus();
                if (bQj().getText() != null && bQj().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQj().getSelectionStart();
                    editable = bQj().getText();
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
    public void oG(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) bQi().getText().getSpans(0, bQi().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.iaC == null) {
                this.iaC = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.iaC.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType GN = pVar.GN();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bQi().getSelectionStart(), aVar, GN);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bQi() != null && bQi().getText() != null) {
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
                int selectionStart = bQi().getSelectionStart() - 1;
                if (bQi().getText().length() > 1 && selectionStart >= 0 && bQi().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bQi().getText().insert(bQi().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bQi().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bQi().getText().insert(bQi().getSelectionStart(), spannableString2);
            }
            Editable text = bQi().getText();
            if (text != null) {
                this.iaS.clear();
                this.iaS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.iaS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bQi().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bQi().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bQi().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQi() {
        return this.iaP ? this.ibw : this.hdU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQj() {
        return this.iaP ? this.ibA : this.hdQ;
    }

    protected void bQk() {
        Editable text;
        if (bQi() != null && (text = bQi().getText()) != null) {
            int selectionStart = bQi().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQi().onKeyDown(67, this.dtF);
            }
            bQi().onKeyDown(67, this.dtF);
            int selectionStart2 = bQi().getSelectionStart();
            if (text != null) {
                this.iaS.clear();
                this.iaS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.iaS);
                bQi().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.ibi = true;
        }
    }

    private void bQy() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bQz() {
        try {
            if (this.ibo != null) {
                this.ibo.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bif.d(null);
        this.bif.ec(e.j.sending);
        this.bif.bA(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bif.bA(false);
    }

    private Boolean bQA() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aZY = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void bzT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bQj() != null) {
                str = bQj().getText().toString();
            }
            if (bQi() != null) {
                str2 = bQi().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.hdy == v.H(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.iay.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            oH(true);
                            return;
                        }
                    } else if (this.iay.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        oH(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.iay.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    oH(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.iaP) {
                    oH(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oH(true);
                }
            }
            if (this.mData.getType() == 4) {
                oH(o(this.ibw) && n(this.ibA));
            } else if (this.mData.getType() == 5) {
                oH(o(this.ibw));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                oH(true);
            } else if (this.mData.getVideoInfo() != null) {
                oH(true);
            } else {
                oH(false);
            }
        }
    }

    public void oH(boolean z) {
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
        this.aZU = new NewWriteModel(this);
        this.aZU.b(this.bai);
        registerListener(this.ibV);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bzL();
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
            this.ibi = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ibj = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ibp = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ibq = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aZS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.iaD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.iaD != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.ibr = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.ibS = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.ehA = bundle.getString("KEY_CALL_FROM");
            this.hUV = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.ibi = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ibj = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ibp = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ibq = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.iaD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.iaD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.ibr = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.ibS = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.ehA = intent.getStringExtra("KEY_CALL_FROM");
            this.hUV = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.ibi);
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
        this.fyq = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.iaw = true;
        }
        bQc();
        try {
            this.ibG = bQH();
        } catch (Throwable th) {
            this.ibG = null;
        }
    }

    private void bQl() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.hdQ.setText(com.baidu.tbadk.plugins.b.it(com.baidu.tbadk.plugins.b.iu(hotTopicBussinessData.mTopicName)));
            this.hdQ.setMovementMethod(com.baidu.tieba.view.c.bMP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString it = com.baidu.tbadk.plugins.b.it(com.baidu.tbadk.plugins.b.iu(hotTopicBussinessData.mTopicName));
            if (it != null) {
                this.hdQ.setText(it);
            }
            this.iaR.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String iu;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bQj().getText().toString()) || this.ibO || ((this.ibi || this.iaw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            iu = this.mData.getTitle();
                        } else {
                            iu = com.baidu.tbadk.plugins.b.iu(str);
                        }
                        SpannableString it = com.baidu.tbadk.plugins.b.it(iu);
                        if (it != null) {
                            bQj().setText(it);
                            bQj().setSelection(it.length() > iu.length() ? iu.length() : it.length());
                        }
                    } else {
                        SpannableString it2 = com.baidu.tbadk.plugins.b.it(this.mData.getTitle());
                        if (it2 != null) {
                            bQj().setText(it2);
                            bQj().setSelection(this.mData.getTitle().length() > it2.length() ? it2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bQb();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bQi().getText().toString()) || this.ibi || this.iaw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Nu().a(getPageContext().getPageActivity(), this.mData.getContent(), this.iaX);
                    bQi().setText(a2);
                    bQi().setSelection(a2.length());
                    if (this.iaP) {
                        a(this.ibC, this.ibw);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bQG();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bQr();
                    }
                    oJ(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bQB();
                }
                bzT();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.iaI != null) {
                    this.iaM = this.iaJ.dOd;
                    this.iaL = this.iaJ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.iaI.size()) {
                            break;
                        }
                        x xVar = this.iaI.get(i);
                        if (categoryTo != xVar.dOd) {
                            i++;
                        } else {
                            this.iaM = categoryTo;
                            this.iaL = xVar.name;
                            this.mData.setCategoryTo(this.iaM);
                            break;
                        }
                    }
                    if (this.iaN != null) {
                        this.iaN.setText(this.iaL);
                        this.iaN.setCategoryContainerData(this.iaI, this.iaJ, this.iaM);
                    }
                }
                this.aYr.Kx();
                return;
            }
            return;
        }
        bQB();
        bQb();
    }

    private void bQB() {
        if ((!this.iaP || this.ibv != null) && this.ibu != null) {
            this.ibv.c(this.writeImagesInfo);
            bQE();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ibp);
        if (this.ibi) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aZS);
        if (this.iaD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.iaD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.ibr);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.ehA);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hUV);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bQi().getEditableText().toString();
        if (obj != null) {
            bQi().setText(TbFaceManager.Nu().a(getPageContext().getPageActivity(), obj, this.iaX));
            bQi().setSelection(bQi().getText().length());
        }
    }

    private String bQm() {
        return (bQi() == null || bQi().getText() == null) ? "" : bQi().getText().toString();
    }

    private String bQn() {
        if (this.mData == null || bQj() == null || bQj().getVisibility() != 0 || bQj().getText() == null) {
            return "";
        }
        String obj = bQj().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.hdy != v.H(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.hdV != null && this.hdV.getText() != null) {
            this.mData.setPostPrefix(this.hdV.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void xQ(String str) {
        if (this.mData != null && this.iay != null) {
            if (this.iay.getVisibility() == 0) {
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
    public void bQo() {
        bzL();
        this.mData.setContent(bQm());
        xQ(bQn());
        if (this.ibi || this.iaw) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                xQ(string + this.mData.getTitle());
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
        if (this.iaK >= 0) {
            this.mData.setCategoryFrom(this.iaK);
        }
        if (this.iaM >= 0) {
            this.mData.setCategoryTo(this.iaM);
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
        this.mData.setHasLocationData(this.aZT != null && this.aZT.amo());
        if (this.writeImagesInfo != null) {
            this.aZU.nC(this.writeImagesInfo.size() > 0);
        }
        if (!v.I(this.mList) && this.iaQ != null && this.iaQ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.iaQ.mForumId));
            this.mData.setForumName(this.iaQ.mForumName);
        }
        this.aZU.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aZU.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aZU.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aZU.getWriteData().setVoice(null);
                this.aZU.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aZU.getWriteData().setVoice(null);
            this.aZU.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aZU.bFv()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.aZU.startPostWrite();
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
            if (this.iaD != null) {
                i2 = this.iaD.getTotalCount();
                i = this.iaD.getAlreadyCount() + 1;
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
                if (this.hdQ == getCurrentFocus()) {
                    bQi().clearFocus();
                    this.hdQ.requestFocus();
                    if (this.aYr != null) {
                        this.aYr.Kx();
                    }
                    ShowSoftKeyPadDelay(this.hdQ);
                } else {
                    bQi().requestFocus();
                    if (this.aYr != null) {
                        this.aYr.Kx();
                    }
                    ShowSoftKeyPadDelay(this.hdU);
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
                            bQi().getText().insert(bQi().getSelectionStart(), sb.toString());
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
                                bQF();
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
                        if (this.ibT) {
                            oI(true);
                            this.ibT = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.iaP) {
                        B(intent);
                        bzT();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aYr.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bzT();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.iav) {
                                sb2.append(com.baidu.tbadk.plugins.b.bhB);
                                this.iav = false;
                            }
                            sb2.append(stringExtra);
                            hK(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.iaQ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.iaQ);
                }
            }
        } else if (i2 == 0) {
            if (this.aYr != null && !this.aYr.Mb()) {
                this.hdU.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aYr.Kx();
            }
            switch (i) {
                case 12001:
                    MG();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bQD();
                    if (this.ibT) {
                        oI(true);
                        this.ibT = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.hdQ == getCurrentFocus()) {
                        bQi().clearFocus();
                        this.hdQ.requestFocus();
                        if (this.aYr != null) {
                            this.aYr.Kx();
                        }
                        ShowSoftKeyPadDelay(this.hdQ);
                        return;
                    }
                    bQi().requestFocus();
                    if (this.aYr != null) {
                        this.aYr.Kx();
                    }
                    ShowSoftKeyPadDelay(this.hdU);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.iaV.xu(postWriteCallBackData.getErrorString());
                        this.iaV.aA(postWriteCallBackData.getSensitiveWords());
                        this.iaV.b(this.hdQ, this.hdU);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aZS = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aZS);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bQD();
                    return;
                case 25004:
                    if ("from_title".equals(this.iau)) {
                        bQj().requestFocus();
                        return;
                    } else if ("from_content".equals(this.iau)) {
                        bQi().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQp() {
        if ("1".equals(this.ehA)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.ehA)) {
            this.mData.setCanNoForum(false);
        }
        bQq();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.ehA);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bQo();
    }

    private void bQq() {
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bQC() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bQD() {
        if (this.iaP) {
            this.ibv.c(this.writeImagesInfo);
            bQE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQE() {
        this.ibv.notifyDataSetChanged();
        this.ibu.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.ibv.notifyDataSetChanged();
                WriteActivity.this.ibu.invalidateViews();
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
        bzT();
    }

    private void ai(Intent intent) {
        if (this.iaP) {
            aj(intent);
            bQD();
        } else {
            am(intent);
        }
        bzT();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bQD();
            oJ(true);
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

    private void bQF() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.ibs.parseJson(stringExtra);
            this.ibs.updateQuality();
            if (this.ibs.getChosedFiles() != null && this.ibs.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ibs.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.ibs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bQj());
        HidenSoftKeyPad(this.mInputManager, bQi());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aZS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aZS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aZS, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bQG();
            bQr();
        }
        oJ(true);
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
                bQG();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bQr();
                }
            }
            oJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        if (this.aYr.fL(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void MG() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aZS));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oJ(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.ibt != null) {
            this.ibt.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aBM() {
        this.dKQ = getVoiceManager();
        this.dKQ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aj(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dLU) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCL));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.iaD == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                v(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZZ = i;
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bQr() {
        if (!this.iaP) {
            if (this.aYr != null) {
                this.aYr.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aYr.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.ibt != null) {
                this.ibt.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xG(int i) {
        if (i < this.iaB.size()) {
            for (int i2 = 0; i2 < this.iaB.size(); i2++) {
                this.iaB.get(i2).ox(false);
            }
            this.iaB.get(i).ox(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void vg(int i) {
        if (i == v.H(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").x("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").x("obj_type", 2));
        }
        this.hdy = i;
        this.hdW.setCurrentIndex(i);
        xG(i);
        this.hdV.setText(this.mPrefixData.getPrefixs().get(i));
        bzT();
        com.baidu.adp.lib.g.g.a(this.hdW, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.hdY.setSelected(false);
        al.c(this.hdX, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.hdU);
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
            MA();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.aX(getApplicationContext())) {
                ak.a(getPageContext(), this.aZS);
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
        this.iaU = z;
        if (this.ibM && System.currentTimeMillis() - this.ibN < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.ibM = false;
        }
        if (this.iaT != null && !z) {
            this.iaT.blO();
        }
        if (this.iaW != null && !z) {
            bPU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.ibJ != null) {
            xS(str);
            this.ibJ.dismiss();
        }
    }

    private void dj(Context context) {
        ibL = l.aQ(context);
    }

    private void xS(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.ibM = true;
        bQG();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bQr();
        }
        oJ(true);
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

    private File bQH() {
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

    private void bQI() {
        if (this.ibG != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            dj(getActivity());
            this.ibI = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.ibI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.ibG != null) {
                        WriteActivity.this.xR(WriteActivity.this.ibG.getAbsolutePath());
                    }
                }
            });
            this.ibH = (TbImageView) this.ibI.findViewById(e.g.rec_img_view);
            this.ibK = (LinearLayout) this.ibI.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.ibG.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.ibG.getAbsolutePath());
                Bitmap f = f(this.ibG.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0210e.ds160));
                if (f != null) {
                    this.ibH.setImageBitmap(f);
                    this.ibH.setDrawBorder(true);
                    this.ibH.setBorderWidth(2);
                    this.ibH.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.ibJ = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.ibJ.setCanceledOnTouchOutside(true);
                    this.ibJ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.ibM) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.ibN = System.currentTimeMillis();
                            }
                        }
                    });
                    this.ibJ.setContentView(this.ibI);
                    this.ibJ.show();
                    Window window = this.ibJ.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0210e.ds28);
                    attributes.y = (ibL / 18) + getResources().getDimensionPixelSize(e.C0210e.ds12);
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
        if (this.iaU && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.iav = false;
            this.iau = "";
            if ("from_content".equals(str)) {
                this.iau = "from_content";
            } else if ("from_title".equals(str)) {
                this.iau = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.is(String.valueOf(charSequence.charAt(i)))) {
                oG(false);
            }
        }
    }

    public void bvX() {
        if (this.ibi || !v.I(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.iay.setVisibility(0);
            this.iay.requestFocus();
            this.aYr.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.iay.setVisibility(8);
    }
}
