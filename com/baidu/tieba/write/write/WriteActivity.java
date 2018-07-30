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
import com.baidu.ar.util.SystemInfoUtil;
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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
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
    private static int hzU = 0;
    private EditorTools aMl;
    private String aNM;
    private LocationModel aNN;
    private NewWriteModel aNO;
    private VoiceManager dmp;
    private LinearLayout fAf;
    private PlayVoiceBntNew fAg;
    private ImageView fAi;
    private int gCY;
    private TextView gDv;
    private com.baidu.tieba.write.d gDw;
    private ImageView gDx;
    private View gDy;
    private TextView hAa;
    private com.baidu.tieba.c.d hAd;
    private LinearLayout hyG;
    private LinearLayout hyH;
    private View hyJ;
    private Toast hyL;
    private AdditionData hyM;
    private RelativeLayout hyN;
    private TextView hyO;
    private TextView hyP;
    private TextView hyQ;
    List<x> hyR;
    x hyS;
    private int hyT;
    private String hyU;
    private int hyV;
    private PostCategoryView hyW;
    private HotTopicBussinessData hyZ;
    private g hzC;
    private View hzY;
    private View hzZ;
    private TextView hza;
    private com.baidu.tieba.write.editor.b hzc;
    private e hzf;
    private com.baidu.tieba.view.b hzm;
    private View hzv;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hyD = "";
    private boolean hyE = false;
    private WriteData mData = null;
    private boolean hzr = false;
    private boolean hyF = false;
    private boolean hzs = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gDq = null;
    private HeadImageView hzt = null;
    private View gDr = null;
    private LinearLayout gDt = null;
    private EditText gDu = null;
    private FeedBackModel hyI = null;
    private FeedBackTopListView hzu = null;
    private ArrayList<WritePrefixItemLayout> hyK = new ArrayList<>();
    private String eYq = null;
    private final KeyEvent cVk = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aAZ = null;
    private TextView hzw = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hzx = null;
    private final Handler mHandler = new Handler();
    private boolean hzy = false;
    private String hzz = null;
    private RelativeLayout mParent = null;
    private String aNS = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNT = 0;
    private int hzA = 0;
    private WriteImagesInfo hzB = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hzD = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hzE = null;
    private ScrollView hyX = null;
    private EditText hzF = null;
    private View hzG = null;
    private View hzH = null;
    private View hzI = null;
    private EditText hzJ = null;
    private TextView hzK = null;
    private TextView hzL = null;
    private TextWatcher hzM = null;
    private TextWatcher hzN = null;
    private boolean hyY = false;
    private boolean hzO = false;
    private com.baidu.tbadk.core.view.a aVY = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hzP = null;
    private TbImageView hzQ = null;
    private View hzR = null;
    private Dialog hzS = null;
    private LinearLayout hzT = null;
    private boolean hzV = false;
    private long hzW = -1000;
    private boolean hzX = false;
    private String dHW = "2";
    private int htF = 0;
    private String hAb = "";
    private SpannableStringBuilder hzb = new SpannableStringBuilder();
    private boolean hAc = false;
    private boolean hzd = false;
    private final b hze = new b();
    private final HttpMessageListener hAe = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eYq)) {
                    WriteActivity.this.eYq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nC(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eYq)) {
                    WriteActivity.this.eYq = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eYq);
                    WriteActivity.this.nC(true);
                }
            }
        }
    };
    private TbFaceManager.a hzg = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ha(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nb());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.f(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dnt = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arn));
        }
    };
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.auB();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hze.az(null);
                if (z) {
                    WriteActivity.this.bK(z);
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
                        if (!w.z(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hAb)) {
                            TiebaStatic.log(new an("c11731").af(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hAb));
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
                    WriteActivity.this.hze.az(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hze.vv(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hze.b(WriteActivity.this.gDq, WriteActivity.this.gDu);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Cu());
                    if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Ct());
                        if (WriteActivity.this.hzs) {
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
    private final LocationModel.a aOa = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ij() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwJ())) {
                WriteActivity.this.b(2, true, aVar.bwJ());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gQj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aNN.mw(false);
                    WriteActivity.this.aNN.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aNN.mw(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hzh = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hzi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHo = WriteActivity.this.bHo();
            if (bHo >= 0 && bHo < WriteActivity.this.gDu.getText().length()) {
                WriteActivity.this.gDu.setSelection(bHo);
            }
        }
    };
    private boolean hzj = true;
    private final View.OnFocusChangeListener gDo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gDq || view == WriteActivity.this.aAZ || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hzj = true;
                    WriteActivity.this.bHp();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gDq);
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FP();
                    }
                } else if (view == WriteActivity.this.gDq) {
                    WriteActivity.this.gDv.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gDu && z) {
                WriteActivity.this.hzj = false;
                WriteActivity.this.bHp();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gDu);
                if (WriteActivity.this.aMl != null) {
                    WriteActivity.this.aMl.FP();
                }
            }
            WriteActivity.this.bHv();
        }
    };
    private TextWatcher hzk = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hzo = "";
        private String hzp;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzp = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzp != null ? this.hzp.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brT();
            WriteActivity.this.bHw();
            EditText bHH = WriteActivity.this.bHH();
            if (editable != null && bHH != null && bHH.getText() != null) {
                if (this.hzo == null || !this.hzo.equals(editable.toString())) {
                    if (WriteActivity.this.hze != null) {
                        this.hzo = bHH.getText().toString();
                        WriteActivity.this.hze.k(bHH);
                        return;
                    }
                    return;
                }
                bHH.setSelection(bHH.getSelectionEnd());
            }
        }
    };
    private TextWatcher hzl = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hzp;
        private String hzq = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzp = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzp != null ? this.hzp.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brT();
            EditText bHG = WriteActivity.this.bHG();
            if (editable != null && bHG != null && bHG.getText() != null) {
                if (this.hzq == null || !this.hzq.equals(editable.toString())) {
                    if (WriteActivity.this.hze != null) {
                        this.hzq = bHG.getText().toString();
                        WriteActivity.this.hze.k(bHG);
                        return;
                    }
                    return;
                }
                bHG.setSelection(bHG.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0234a fGX = new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
            WriteActivity.this.eYq = null;
            WriteActivity.this.nC(false);
            WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void HU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void HV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNN.bwR()) {
            HU();
        } else {
            this.aNN.mw(false);
            b(1, true, null);
            this.aNN.bwP();
        }
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aNN.afU();
                } else {
                    WriteActivity.this.aOa.Ij();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHo() {
        int selectionEnd = bHG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHG().getText().getSpans(0, bHG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHp() {
        if (this.aMl != null) {
            this.aMl.setBarLauncherEnabled(!this.hzj);
            this.aMl.setBarLauncherEnabled(true, 26);
            this.aMl.setBarLauncherEnabled(true, 2);
            J(9, this.hzj ? false : true);
        }
    }

    private void J(int i, boolean z) {
        com.baidu.tbadk.editortools.g eL;
        if (this.aMl != null && (eL = this.aMl.eL(i)) != null) {
            if (z) {
                eL.oF();
            } else {
                eL.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hyY) {
            this.gDq.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hzI.setVisibility(8);
            } else {
                this.hzI.setVisibility(0);
            }
            a(this.hzL, this.hzF);
            a(this.hzK, this.hzJ);
            brT();
        }
        if (this.hzr) {
            this.hzj = true;
            bHp();
            if (this.aMl != null) {
                this.aMl.FP();
            }
            this.gDq.requestFocus();
            ShowSoftKeyPadDelay(this.gDq);
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
            bIf();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bHP();
            }
            nD(true);
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
            vH(this.htF);
        }
        initUI();
        bHU();
        this.aNN = new LocationModel(this);
        this.aNN.a(this.aOa);
        registerListener(this.gQj);
        registerListener(this.hzh);
        initEditor();
        bIh();
        if (this.hyY) {
            this.hzE.setEditorTools(this.aMl);
        } else {
            this.gDu.requestFocus();
        }
        boa();
        bHP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMl = new EditorTools(getActivity());
        this.aMl.setBarMaxLauCount(5);
        this.aMl.setMoreButtonAtEnd(true);
        this.aMl.setBarLauncherType(1);
        this.aMl.bC(true);
        this.aMl.bD(true);
        this.aMl.setMoreLauncherIcon(d.f.write_more);
        this.aMl.setBackgroundColorId(d.C0140d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bHS();
                break;
            default:
                bHq();
                break;
        }
        this.aMl.Hu();
        if (this.hyG != null) {
            this.hyG.addView(this.aMl);
        }
        bHr();
        this.aMl.oF();
        com.baidu.tbadk.editortools.g eL = this.aMl.eL(6);
        if (eL != null && !TextUtils.isEmpty(this.aNS)) {
            ((View) eL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aNS);
                }
            });
        }
        if (!this.hyY) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMl.FP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bHt();
    }

    private void bHQ() {
        this.hzG = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hzI = this.hzG.findViewById(d.g.live_post_title_container);
        this.hzF = (EditText) this.hzG.findViewById(d.g.live_post_content);
        this.hzD = (GridView) this.hzG.findViewById(d.g.photoLiveGridView);
        this.hzJ = (EditText) this.hzG.findViewById(d.g.live_post_title);
        this.hzK = (TextView) this.hzG.findViewById(d.g.titleOverPlusNumber);
        this.hzL = (TextView) this.hzG.findViewById(d.g.contentOverPlusNumber);
        this.hzH = this.hzG.findViewById(d.g.live_interval_view);
        this.hzK.setText(String.valueOf(20));
        this.hzL.setText(String.valueOf(233));
        this.hzG.setVisibility(0);
        this.hzK.setVisibility(0);
        this.hzL.setVisibility(0);
        this.hzJ.setHint(d.j.tips_title_limit_new);
        this.hzJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hzO = true;
                    WriteActivity.this.hzj = true;
                    WriteActivity.this.bHp();
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FP();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hzF.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hzF.setHint(d.j.live_write_input_content_update);
        }
        this.hzF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hzO = false;
                    WriteActivity.this.hzj = false;
                    WriteActivity.this.bHp();
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FP();
                    }
                }
            }
        });
        this.hzF.requestFocus();
        this.hzF.addTextChangedListener(bHW());
        this.hzJ.requestFocus();
        this.hzJ.addTextChangedListener(bHW());
        this.hzJ.setOnClickListener(this.hzi);
        this.hzF.setOnClickListener(this.hzi);
        this.hzE = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hzD);
        this.hzE.vB(6);
        this.hzD.setAdapter((ListAdapter) this.hzE);
        View findViewById = this.hzG.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bGZ() {
                WriteActivity.this.bId();
            }
        });
        bHR();
    }

    private void bHR() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hzJ.setText(this.mData.getTitle());
                this.hzJ.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hyY) {
            bIb();
        }
        if (this.aMl.Hw()) {
            this.aMl.FP();
        }
        vH(0);
    }

    private void vH(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.dHW);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bHS() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aMl.F(arrayList);
        com.baidu.tbadk.editortools.k eO = this.aMl.eO(5);
        if (eO != null) {
            eO.aMU = 2;
            eO.aMS = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aMS = d.f.write_at;
        this.aMl.b(aVar);
        this.aMl.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bHq() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aMS = d.f.write_picture;
        this.aMl.b(dVar);
        Boolean bHZ = bHZ();
        if (!this.hzr && bHZ != null && bHZ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bxq() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aMU = 3;
            kVar5.aMS = d.f.write_recorder;
            this.aMl.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aMS = d.f.icon_post_topic_selector;
        this.aMl.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aMU = 5;
            kVar4.aMS = d.f.write_privilege;
            this.aMl.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aMU = 6;
            kVar3.aMS = this.hzr ? d.f.write_location : d.f.icon_post_more_location;
            this.aMl.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aMS = d.f.icon_post_more_at;
        this.aMl.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aMW = true;
            kVar2.aMU = 9;
            kVar2.aMS = 0;
            this.aMl.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aMW = true;
            kVar.aMU = 10;
            kVar.aMS = 0;
            this.aMl.b(kVar);
        }
        if (this.hyM == null) {
            if (this.hzc == null) {
                this.hzc = new com.baidu.tieba.write.editor.b(getActivity(), this.dHW);
                this.hzc.aP(this.mData.getForumId(), this.privateThread);
            }
            this.aMl.b(this.hzc);
        }
        this.aMl.F(arrayList);
        com.baidu.tbadk.editortools.k eO = this.aMl.eO(5);
        if (eO != null) {
            eO.aMU = 1;
            eO.aMS = d.f.write_emotion;
        }
    }

    private void bHs() {
        if (this.hzf != null) {
            this.hzf.hideTip();
        }
    }

    private void bHt() {
        if (this.hzf == null) {
            this.hzf = new e(getPageContext());
        }
        this.hzf.c(this.aMl);
    }

    private void bHr() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bHF()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bHF()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bHI();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bcc();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIf();
                        WriteActivity.this.brT();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vI(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hyM == null) {
                            WriteActivity.this.HY();
                            return;
                        }
                        switch (WriteActivity.this.aNT) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ac.aN(pageActivity)) {
                                    WriteActivity.this.HV();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.HU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aNN != null) {
                            WriteActivity.this.aNN.mw(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eYq = null;
                        } else {
                            WriteActivity.this.eYq = (String) aVar.data;
                        }
                        WriteActivity.this.nC(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.af(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aMl.Hw()) {
                                        WriteActivity.this.aMl.FP();
                                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.brT();
                        if (WriteActivity.this.gDu != null) {
                            WriteActivity.this.gDu.requestFocus();
                        }
                        WriteActivity.this.aMl.FP();
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDu);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hyE = true;
                        WriteActivity.this.nA(true);
                        if (WriteActivity.this.bHH().isFocused()) {
                            WriteActivity.this.hyD = "from_title";
                        } else if (WriteActivity.this.bHG().isFocused()) {
                            WriteActivity.this.hyD = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hyH.setVisibility(0);
                        WriteActivity.this.hyH.requestFocus();
                        WriteActivity.this.brT();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hyH.hasFocus()) {
                            WriteActivity.this.gDu.requestFocus();
                            WriteActivity.this.gDu.setSelection(WriteActivity.this.gDu.getText().toString().length());
                        }
                        WriteActivity.this.hyH.setVisibility(8);
                        WriteActivity.this.brT();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aMl.setActionListener(16, bVar);
        this.aMl.setActionListener(14, bVar);
        this.aMl.setActionListener(24, bVar);
        this.aMl.setActionListener(3, bVar);
        this.aMl.setActionListener(10, bVar);
        this.aMl.setActionListener(11, bVar);
        this.aMl.setActionListener(12, bVar);
        this.aMl.setActionListener(13, bVar);
        this.aMl.setActionListener(15, bVar);
        this.aMl.setActionListener(18, bVar);
        this.aMl.setActionListener(20, bVar);
        this.aMl.setActionListener(25, bVar);
        this.aMl.setActionListener(27, bVar);
        this.aMl.setActionListener(29, bVar);
        this.aMl.setActionListener(43, bVar);
        this.aMl.setActionListener(45, bVar);
        this.aMl.setActionListener(53, bVar);
        this.aMl.setActionListener(48, bVar);
        this.aMl.setActionListener(46, bVar);
        this.aMl.setActionListener(49, bVar);
        this.aMl.setActionListener(47, bVar);
        this.aMl.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        if (this.aNN.afQ()) {
            if (this.aNN.bwR()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwN().getLocationData().bwJ());
                return;
            }
            b(1, true, null);
            this.aNN.bwP();
            return;
        }
        b(0, true, null);
    }

    protected void brL() {
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
        if (this.hyI != null) {
            this.hyI.cancelLoadData();
        }
        if (this.aNN != null) {
            this.aNN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bHs();
        TiebaPrepareImageService.StopService();
        brL();
        bHY();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hzC != null) {
            this.hzC.destroy();
        }
        if (this.hAd != null) {
            this.hAd.akM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
        if (this.mData != null && this.mData.getType() == 2 && this.hzy) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bHH().getText().toString());
            this.mData.setContent(bHG().getText().toString());
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
            if (this.gDw != null && this.gDw.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gDw, getPageContext().getPageActivity());
                return true;
            } else if (this.aMl.Hw()) {
                this.aMl.FP();
                return true;
            } else {
                brL();
                bHu();
                return true;
            }
        }
        if (i == 67 && (text = bHG().getText()) != null) {
            int selectionStart = bHG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHG().onKeyDown(67, this.cVk);
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
        getLayoutMode().onModeChanged(this.hzT);
        if (this.hzQ != null && i == 1) {
            this.hzQ.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.c(this.mPost, d.C0140d.cp_link_tip_a, 1);
        bHp();
        am.j(this.hzG, d.C0140d.cp_bg_line_d);
        am.j(this.gDr, d.C0140d.cp_bg_line_c);
        am.j(this.hzH, d.C0140d.cp_bg_line_c);
        am.j(bHH(), d.C0140d.cp_bg_line_d);
        am.c(this.fAi, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eYq)) {
            am.j(bHG(), d.C0140d.cp_bg_line_d);
        }
        brT();
        this.aMl.onChangeSkinType(i);
        if (this.hyW != null) {
            this.hyW.AG();
        }
        am.h(this.mName, d.C0140d.cp_cont_b);
        bHv();
        bHw();
        if (this.hze != null) {
            this.hze.c(bHH(), bHG());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        if (this.gDq.hasFocus()) {
            this.gDq.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gDq.setHintTextColor(am.getColor(d.C0140d.cp_cont_d));
        }
        if (this.gDu.hasFocus()) {
            this.gDu.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gDu.setHintTextColor(am.getColor(d.C0140d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHw() {
        if (this.gDq != null && this.gDq.getText() != null && this.gDq.getText().toString() != null && this.gDq.getPaint() != null) {
            if (this.gDq.getText().toString().length() == 0) {
                this.gDq.getPaint().setFakeBoldText(false);
            } else if (this.gDq.getText().toString().length() > 0) {
                this.gDq.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hyY = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, d.C0140d.cp_cont_b);
        this.hzw = (TextView) findViewById(d.g.btn_image_problem);
        bHy();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gDo);
        this.hyX = (ScrollView) findViewById(d.g.write_scrollview);
        this.hyX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gDu != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gDu);
                    }
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FP();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hzu = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hzv = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hyG = (LinearLayout) findViewById(d.g.tool_view);
        this.hyG.setContentDescription("..");
        this.hyH = (LinearLayout) findViewById(d.g.title_view);
        this.gDr = findViewById(d.g.interval_view);
        this.hzY = findViewById(d.g.hot_topic_fourm_view);
        this.hzZ = findViewById(d.g.hot_topic_divider);
        this.hza = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hAa = (TextView) findViewById(d.g.change_one_tv);
        brS();
        if (this.hyY) {
            this.hyX.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bHQ();
        } else {
            this.hzC = new g(getPageContext(), this.mRootView);
            g gVar = this.hzC;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nv(z);
        }
        brU();
        if (this.hzr || this.hyF) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().arX) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gDt = (LinearLayout) findViewById(d.g.post_content_container);
        this.gDt.setDrawingCacheEnabled(false);
        this.gDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gDu.requestFocus();
            }
        });
        this.fAf = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fAg = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fAi = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bcc();
            }
        });
        this.aAZ.setOnFocusChangeListener(this.gDo);
        this.aAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.brL();
                WriteActivity.this.bHu();
            }
        });
        this.hzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bHB();
        j(bHZ());
        bHD();
        bHx();
        bHV();
        bHX();
        bHp();
        bHC();
        brR();
        bHJ();
        if (this.mData.getType() == 4 && this.gDy != null && this.hyJ != null) {
            this.gDy.setVisibility(8);
            this.hyJ.setVisibility(8);
        }
        brT();
        bHT();
    }

    private void bHx() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hzr || this.hyF) {
                        if (this.hzs) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.dHW != null && this.dHW.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.dHW != null && this.dHW.equals("2")) {
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
                    this.gDq.setVisibility(0);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gDq.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hzH.setVisibility(8);
                    return;
                case 7:
                    this.gDq.setVisibility(0);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bHy() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bHz() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hzr && !this.hyF && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ap.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bHH() != null) {
                bHH().setText(d);
                bHH().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fAf.setVisibility(0);
            this.fAg.setVoiceModel(voiceModel);
            this.fAg.bxp();
            brT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcc() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fAf.setVisibility(8);
        this.fAg.aFD();
        this.fAg.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eO = this.aMl.eO(6);
        if (eO != null && eO.aMf != null) {
            eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        brT();
    }

    private void bHA() {
        this.hyR = null;
        this.hyT = -1;
        this.hyV = -1;
        z kF = y.avI().kF(1);
        if (kF != null) {
            this.hyR = kF.dpy;
            this.hyT = getIntent().getIntExtra("category_id", -1);
            if (this.hyR != null && !this.hyR.isEmpty() && this.hyT >= 0) {
                this.hyS = new x();
                this.hyS.dpu = 0;
                this.hyS.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hyV = this.hyS.dpu;
                this.hyU = this.hyS.name;
                for (x xVar : this.hyR) {
                    if (xVar.dpu == this.hyT) {
                        this.hyV = xVar.dpu;
                        this.hyU = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHB() {
        if (this.hyR != null && !this.hyR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hyW = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hyW.setText(this.hyU);
            this.hyW.setCategoryContainerData(this.hyR, this.hyS, this.hyV);
            this.hyW.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hyW.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dpu);
                        WriteActivity.this.hyV = atVar.dpu;
                        WriteActivity.this.hyW.bHc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hyW.bHb();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHG());
                }
            });
        }
    }

    private void bHT() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hzm = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hzm.setTitle(d.j.no_disturb_start_time);
        this.hzm.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hzm);
        this.hzm.setButton(-2, getPageContext().getString(d.j.cancel), this.hzm);
        return this.hzm;
    }

    private void bHC() {
        this.hyN = (RelativeLayout) findViewById(d.g.addition_container);
        this.hyO = (TextView) findViewById(d.g.addition_create_time);
        this.hyP = (TextView) findViewById(d.g.addition_last_time);
        this.hyQ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hyM != null) {
            this.hyN.setVisibility(0);
            this.hyO.setText(getPageContext().getString(d.j.write_addition_create) + ap.w(this.hyM.getCreateTime() * 1000));
            if (this.hyM.getAlreadyCount() == 0) {
                this.hyP.setVisibility(8);
            } else {
                this.hyP.setText(getPageContext().getString(d.j.write_addition_last) + ap.w(this.hyM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hyM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hyQ.setText(lastAdditionContent);
            } else {
                this.hyQ.setVisibility(8);
            }
            bHG().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hyM.getAlreadyCount()), Integer.valueOf(this.hyM.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hyN.setVisibility(8);
    }

    private void brR() {
        this.gDy = findViewById(d.g.post_prefix_layout);
        if (this.hAd == null) {
            this.hAd = new com.baidu.tieba.c.d(getPageContext(), this.gDy);
            this.hAd.jp(d.f.bg_tip_blue_up_left);
            this.hAd.jo(16);
            this.hAd.eL(true);
            this.hAd.C(true);
            this.hAd.js(l.f(getActivity(), d.e.ds32));
        }
        this.gDv = (TextView) findViewById(d.g.post_prefix);
        this.hyJ = findViewById(d.g.prefix_divider);
        this.gDx = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gDy.setVisibility(0);
            this.hAd.g(getString(d.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gCY = 0;
            this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").af(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gDv.setVisibility(0);
                    WriteActivity.this.gDy.setSelected(true);
                    am.c(WriteActivity.this.gDx, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gDw, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMl.FP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDq);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDu);
                }
            });
            this.gDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").af(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gDv.setSelected(true);
                    am.c(WriteActivity.this.gDx, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gDw, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMl.FP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHG());
                }
            });
            this.gDw = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gDw.a(this);
            this.gDw.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.gDw.setOutsideTouchable(true);
            this.gDw.setFocusable(true);
            this.gDw.setOnDismissListener(this);
            this.gDw.setBackgroundDrawable(am.getDrawable(d.C0140d.cp_bg_line_d));
            int color = am.getColor(d.C0140d.cp_cont_b);
            am.getColor(d.C0140d.cp_cont_c);
            am.i(this.gDv, d.C0140d.cp_bg_line_d);
            am.c(this.gDx, d.f.icon_arrow_gray_down);
            this.gDv.setTextColor(color);
            this.hyK.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hyK.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nq(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nq(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gDw.addView(writePrefixItemLayout);
            }
            this.gDw.setCurrentIndex(0);
            this.gDv.setText(prefixs.get(0));
            vG(0);
            return;
        }
        this.gDy.setVisibility(8);
    }

    private void bHU() {
        if (this.hzr && this.mData != null) {
            this.hzu.setVisibility(0);
            this.hzv.setVisibility(0);
            this.hyI = new FeedBackModel(getPageContext());
            this.hyI.vO(this.mData.getForumName());
            this.hyI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hzu.setVisibility(8);
                        WriteActivity.this.hzv.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hzu.setVisibility(8);
                        WriteActivity.this.hzv.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hzu.a(feedBackModel.bHe(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bHD() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hze.a(WriteActivity.this.gDq, WriteActivity.this.gDu)) {
                        WriteActivity.this.showToast(WriteActivity.this.hze.bFn());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHH());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHG());
                    WriteActivity.this.aMl.FP();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hzr) {
                            WriteActivity.this.bHM();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.bHN();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bHM();
                    }
                    TiebaStatic.log(new an("c12262").af("obj_locate", WriteActivity.this.dHW));
                }
            }
        });
    }

    protected void bHV() {
        this.hzx = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hzx.dB(getPageContext().getString(d.j.is_save_draft)).au(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bHH().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bHG().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                    t.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hzx.b(getPageContext());
    }

    protected void brS() {
        this.hzt = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hzt.setIsRound(true);
        this.hzt.setDrawBorder(false);
        this.hzt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ev = com.baidu.tbadk.core.util.p.ev(currentPortrait);
            this.hzt.setUrl(ev);
            this.hzt.startLoad(ev, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hzt.setVisibility(0);
        }
        this.gDq = (EditText) findViewById(d.g.post_title);
        this.gDq.setOnClickListener(this.hzi);
        this.gDq.setOnFocusChangeListener(this.gDo);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gDq.setText(this.mData.getTitle());
                this.gDq.setSelection(this.mData.getTitle().length());
            } else if (this.hzs) {
                this.gDq.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gDq.addTextChangedListener(this.hzk);
        if (!this.mData.getHaveDraft()) {
            bHz();
            this.hzX = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gDq.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gDq.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bHW() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hAh;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.brT();
                if (WriteActivity.this.hyY) {
                    this.hAh = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hAh);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hyY || !WriteActivity.this.hzO) {
                    if (WriteActivity.this.hyY) {
                        if (this.mEditText != WriteActivity.this.hzF || this.mTextView != WriteActivity.this.hzL) {
                            this.mEditText = WriteActivity.this.hzF;
                            this.mTextView = WriteActivity.this.hzL;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hzJ || this.mTextView != WriteActivity.this.hzK) {
                    this.mEditText = WriteActivity.this.hzJ;
                    this.mTextView = WriteActivity.this.hzK;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hyY && this.hzO) {
            if (this.hzM != null) {
                this.hzJ.removeTextChangedListener(this.hzM);
            }
            this.hzM = textWatcher;
        } else if (this.hyY) {
            if (this.hzN != null) {
                this.hzF.removeTextChangedListener(this.hzN);
            }
            this.hzN = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hzF) {
            return 233L;
        }
        if (editText != this.hzJ) {
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
                    textView.setTextColor(am.getColor(d.C0140d.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(d.C0140d.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.h(editText.getText().toString().trim());
    }

    protected void brU() {
        this.gDu = (EditText) findViewById(d.g.post_content);
        this.gDu.setDrawingCacheEnabled(false);
        this.gDu.setOnClickListener(this.hzi);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gDu.setText(W);
            this.gDu.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hzy) {
                if (this.hzz != null && this.hzz.length() > 0) {
                    this.gDu.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hzz}));
                    this.gDu.setSelection(this.gDu.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gDu.setText(format);
                this.gDu.setSelection(format.length());
            }
        }
        this.gDu.setOnFocusChangeListener(this.gDo);
        this.gDu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gDu.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDu.addTextChangedListener(this.hzl);
        if (this.mData.getType() == 0) {
            this.hAc = true;
        } else {
            nC(true);
            this.hAc = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gDu.setHint(d.j.write_input_content);
        } else {
            this.gDu.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nC(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hyY) {
            bHG().setPadding(0, 0, 0, 0);
            bHG().setBackgroundDrawable(null);
            am.j(bHG(), d.C0140d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eYq) && this.hyM == null) {
                com.baidu.adp.lib.f.c.ih().a(this.eYq, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.nb() != null && aVar.nf() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.nb(), aVar.nb().getNinePatchChunk(), aVar.nf(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bHG().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bHG(), true, WriteActivity.this.fGX);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHF() {
        int i = 5000;
        if (this.hyM != null) {
            i = 1000;
        }
        return bHG().getText() != null && bHG().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hyD)) {
                this.hyD = "";
                bHG().requestFocus();
                if (bHG().getText() != null && bHG().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHG().getSelectionStart();
                    editable = bHG().getText();
                }
            } else if ("from_title".equals(this.hyD)) {
                this.hyD = "";
                bHH().requestFocus();
                if (bHH().getText() != null && bHH().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHH().getSelectionStart();
                    editable = bHH().getText();
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
    public void nA(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHG().getText().getSpans(0, bHG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hyL == null) {
                this.hyL = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hyL.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Cl = nVar.Cl();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ih().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bHG().getSelectionStart(), aVar, Cl);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHG() != null && bHG().getText() != null) {
            Bitmap nb = aVar.nb();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
            int width = nb.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nb.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHG().getSelectionStart() - 1;
                if (bHG().getText().length() > 1 && selectionStart >= 0 && bHG().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHG().getText().insert(bHG().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHG().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHG().getText().insert(bHG().getSelectionStart(), spannableString2);
            }
            Editable text = bHG().getText();
            if (text != null) {
                this.hzb.clear();
                this.hzb.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzb);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHG().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHG().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHG().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHG() {
        return this.hyY ? this.hzF : this.gDu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHH() {
        return this.hyY ? this.hzJ : this.gDq;
    }

    protected void bHI() {
        Editable text;
        if (bHG() != null && (text = bHG().getText()) != null) {
            int selectionStart = bHG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHG().onKeyDown(67, this.cVk);
            }
            bHG().onKeyDown(67, this.cVk);
            int selectionStart2 = bHG().getSelectionStart();
            if (text != null) {
                this.hzb.clear();
                this.hzb.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzb);
                bHG().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hzr = true;
        }
    }

    private void bHX() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bHY() {
        try {
            if (this.hzx != null) {
                this.hzx.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVY.d(null);
        this.aVY.df(d.j.sending);
        this.aVY.aM(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVY.aM(false);
    }

    private Boolean bHZ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aNS = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHH() != null) {
                str = bHH().getText().toString();
            }
            if (bHG() != null) {
                str2 = bHG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gCY == w.y(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hyH.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nB(true);
                            return;
                        }
                    } else if (this.hyH.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nB(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hyH.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nB(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hyY) {
                    nB(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nB(true);
                }
            }
            if (this.mData.getType() == 4) {
                nB(o(this.hzF) && n(this.hzJ));
            } else if (this.mData.getType() == 5) {
                nB(o(this.hzF));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nB(true);
            } else if (this.mData.getVideoInfo() != null) {
                nB(true);
            } else {
                nB(false);
            }
        }
    }

    public void nB(boolean z) {
        if (z) {
            am.b(this.mPost, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        am.c(this.mPost, d.C0140d.cp_cont_d, 1);
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
        this.aNO = new NewWriteModel(this);
        this.aNO.b(this.aOc);
        registerListener(this.hAe);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.brL();
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
            this.hzr = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hzs = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hzy = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hzz = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aNM = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hyM = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hyM != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hzA = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hAb = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.dHW = bundle.getString("KEY_CALL_FROM");
            this.htF = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hzr = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hzs = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hzy = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hzz = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hyM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hyM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hzA = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hAb = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.dHW = intent.getStringExtra("KEY_CALL_FROM");
            this.htF = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hzr);
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
            this.mPrefixData.getPrefixs().add(getPageContext().getString(d.j.write_no_prefix));
        }
        this.eYq = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hyF = true;
        }
        bHA();
        try {
            this.hzP = bIg();
        } catch (Throwable th) {
            this.hzP = null;
        }
    }

    private void bHJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gDq.setText(com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName)));
            this.gDq.setMovementMethod(com.baidu.tieba.view.c.bEr());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) w.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString hp = com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName));
            if (hp != null) {
                this.gDq.setText(hp);
            }
            this.hza.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String hq;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bHH().getText().toString()) || this.hzX || ((this.hzr || this.hyF) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!w.z(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            hq = this.mData.getTitle();
                        } else {
                            hq = com.baidu.tbadk.plugins.b.hq(str);
                        }
                        SpannableString hp = com.baidu.tbadk.plugins.b.hp(hq);
                        if (hp != null) {
                            bHH().setText(hp);
                            bHH().setSelection(hp.length() > hq.length() ? hq.length() : hp.length());
                        }
                    } else {
                        SpannableString hp2 = com.baidu.tbadk.plugins.b.hp(this.mData.getTitle());
                        if (hp2 != null) {
                            bHH().setText(hp2);
                            bHH().setSelection(this.mData.getTitle().length() > hp2.length() ? hp2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bHz();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bHG().getText().toString()) || this.hzr || this.hyF) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.IP().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hzg);
                    bHG().setText(a2);
                    bHG().setSelection(a2.length());
                    if (this.hyY) {
                        a(this.hzL, this.hzF);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIf();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bHP();
                    }
                    nD(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIa();
                }
                brT();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hyR != null) {
                    this.hyV = this.hyS.dpu;
                    this.hyU = this.hyS.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hyR.size()) {
                            break;
                        }
                        x xVar = this.hyR.get(i);
                        if (categoryTo != xVar.dpu) {
                            i++;
                        } else {
                            this.hyV = categoryTo;
                            this.hyU = xVar.name;
                            this.mData.setCategoryTo(this.hyV);
                            break;
                        }
                    }
                    if (this.hyW != null) {
                        this.hyW.setText(this.hyU);
                        this.hyW.setCategoryContainerData(this.hyR, this.hyS, this.hyV);
                    }
                }
                this.aMl.FP();
                return;
            }
            return;
        }
        bIa();
        bHz();
    }

    private void bIa() {
        if ((!this.hyY || this.hzE != null) && this.hzD != null) {
            this.hzE.c(this.writeImagesInfo);
            bId();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hzy);
        if (this.hzr) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aNM);
        if (this.hyM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hyM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hzA);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dHW);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.htF);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHG().getEditableText().toString();
        if (obj != null) {
            bHG().setText(TbFaceManager.IP().a(getPageContext().getPageActivity(), obj, this.hzg));
            bHG().setSelection(bHG().getText().length());
        }
    }

    private String bHK() {
        return (bHG() == null || bHG().getText() == null) ? "" : bHG().getText().toString();
    }

    private String bHL() {
        if (this.mData == null || bHH() == null || bHH().getVisibility() != 0 || bHH().getText() == null) {
            return "";
        }
        String obj = bHH().getText().toString();
        if (this.mPrefixData != null && w.y(this.mPrefixData.getPrefixs()) > 0 && this.gCY != w.y(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gDv != null && this.gDv.getText() != null) {
            this.mData.setPostPrefix(this.gDv.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void vP(String str) {
        if (this.mData != null && this.hyH != null) {
            if (this.hyH.getVisibility() == 0) {
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
    public void bHM() {
        brL();
        this.mData.setContent(bHK());
        vP(bHL());
        if (this.hzr || this.hyF) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                vP(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.jE()) {
                    sb.append(com.baidu.adp.lib.util.j.jM());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(SystemInfoUtil.COLON);
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hyT >= 0) {
            this.mData.setCategoryFrom(this.hyT);
        }
        if (this.hyV >= 0) {
            this.mData.setCategoryTo(this.hyV);
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
        this.mData.setHasLocationData(this.aNN != null && this.aNN.afQ());
        if (this.writeImagesInfo != null) {
            this.aNO.my(this.writeImagesInfo.size() > 0);
        }
        if (!w.z(this.mList) && this.hyZ != null && this.hyZ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hyZ.mForumId));
            this.mData.setForumName(this.hyZ.mForumName);
        }
        this.aNO.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aNO.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aNO.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aNO.getWriteData().setVoice(null);
                this.aNO.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aNO.getWriteData().setVoice(null);
            this.aNO.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aNO.bxr()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.aNO.startPostWrite();
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
            if (this.hyM != null) {
                i2 = this.hyM.getTotalCount();
                i = this.hyM.getAlreadyCount() + 1;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.gDq == getCurrentFocus()) {
                    bHG().clearFocus();
                    this.gDq.requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDq);
                } else {
                    bHG().requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDu);
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
                            bHG().getText().insert(bHG().getSelectionStart(), sb.toString());
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
                                bIe();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            ah(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hAc) {
                            nC(true);
                            this.hAc = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hyY) {
                        A(intent);
                        brT();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aMl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    brT();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hyE) {
                                sb2.append(com.baidu.tbadk.plugins.b.aVv);
                                this.hyE = false;
                            }
                            sb2.append(stringExtra);
                            gG(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !w.z(this.mList) && !w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hyZ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hyZ);
                }
            }
        } else if (i2 == 0) {
            if (this.aMl != null && !this.aMl.Hw()) {
                this.gDu.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aMl.FP();
            }
            switch (i) {
                case 12001:
                    Ib();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIc();
                    if (this.hAc) {
                        nC(true);
                        this.hAc = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gDq == getCurrentFocus()) {
                        bHG().clearFocus();
                        this.gDq.requestFocus();
                        if (this.aMl != null) {
                            this.aMl.FP();
                        }
                        ShowSoftKeyPadDelay(this.gDq);
                        return;
                    }
                    bHG().requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDu);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hze.vv(postWriteCallBackData.getErrorString());
                        this.hze.az(postWriteCallBackData.getSensitiveWords());
                        this.hze.b(this.gDq, this.gDu);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aNM = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.aNM);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIc();
                    return;
                case 25004:
                    if ("from_title".equals(this.hyD)) {
                        bHH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hyD)) {
                        bHG().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        if ("1".equals(this.dHW)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dHW)) {
            this.mData.setCanNoForum(false);
        }
        bHO();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.dHW);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHM();
    }

    private void bHO() {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIb() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIc() {
        if (this.hyY) {
            this.hzE.c(this.writeImagesInfo);
            bId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bId() {
        this.hzE.notifyDataSetChanged();
        this.hzD.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hzE.notifyDataSetChanged();
                WriteActivity.this.hzD.invalidateViews();
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
        brT();
    }

    private void ae(Intent intent) {
        if (this.hyY) {
            af(intent);
            bIc();
        } else {
            ai(intent);
        }
        brT();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIc();
            nD(true);
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

    private void bIe() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hzB.parseJson(stringExtra);
            this.hzB.updateQuality();
            if (this.hzB.getChosedFiles() != null && this.hzB.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hzB.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hzB.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHH());
        HidenSoftKeyPad(this.mInputManager, bHG());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aNM = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aNM;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aj(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aNM, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIf();
            bHP();
        }
        nD(true);
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
                bIf();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bHP();
                }
            }
            nD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIf() {
        if (this.aMl.eO(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Ib() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aNM));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nD(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hzC != null) {
            this.hzC.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auB() {
        this.dmp = getVoiceManager();
        this.dmp.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dnt) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arn));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hyM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNT = i;
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHP() {
        if (!this.hyY) {
            if (this.aMl != null) {
                this.aMl.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aMl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hzC != null) {
                this.hzC.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vG(int i) {
        if (i < this.hyK.size()) {
            for (int i2 = 0; i2 < this.hyK.size(); i2++) {
                this.hyK.get(i2).nr(false);
            }
            this.hyK.get(i).nr(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void th(int i) {
        if (i == w.y(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").r("obj_type", 2));
        }
        this.gCY = i;
        this.gDw.setCurrentIndex(i);
        vG(i);
        this.gDv.setText(this.mPrefixData.getPrefixs().get(i));
        brT();
        com.baidu.adp.lib.g.g.a(this.gDw, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gDy.setSelected(false);
        am.c(this.gDx, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gDu);
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
            HV();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (ac.aO(getApplicationContext())) {
                al.a(getPageContext(), this.aNM);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hzd = z;
        if (this.hzV && System.currentTimeMillis() - this.hzW < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hzV = false;
        }
        if (this.hzc != null && !z) {
            this.hzc.aoX();
        }
        if (this.hzf != null && !z) {
            bHs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hzS != null) {
            vR(str);
            this.hzS.dismiss();
        }
    }

    private void cs(Context context) {
        hzU = l.aj(context);
    }

    private void vR(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hzV = true;
        bIf();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bHP();
        }
        nD(true);
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

    private File bIg() {
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

    private void bIh() {
        if (this.hzP != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cs(getActivity());
            this.hzR = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hzR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hzP != null) {
                        WriteActivity.this.vQ(WriteActivity.this.hzP.getAbsolutePath());
                    }
                }
            });
            this.hzQ = (TbImageView) this.hzR.findViewById(d.g.rec_img_view);
            this.hzT = (LinearLayout) this.hzR.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hzP.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hzP.getAbsolutePath());
                Bitmap f = f(this.hzP.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.hzQ.setImageBitmap(f);
                    this.hzQ.setDrawBorder(true);
                    this.hzQ.setBorderWidth(2);
                    this.hzQ.setBorderColor(am.getColor(d.C0140d.common_color_10264));
                    this.hzS = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hzS.setCanceledOnTouchOutside(true);
                    this.hzS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hzV) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hzW = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hzS.setContentView(this.hzR);
                    this.hzS.show();
                    Window window = this.hzS.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hzU / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.hzd && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hyE = false;
            this.hyD = "";
            if ("from_content".equals(str)) {
                this.hyD = "from_content";
            } else if ("from_title".equals(str)) {
                this.hyD = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ho(String.valueOf(charSequence.charAt(i)))) {
                nA(false);
            }
        }
    }

    public void boa() {
        if (this.hzr || !w.z(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hyH.setVisibility(0);
            this.hyH.requestFocus();
            this.aMl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hyH.setVisibility(8);
    }
}
