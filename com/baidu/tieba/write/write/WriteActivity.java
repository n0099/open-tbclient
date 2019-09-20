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
import com.baidu.sapi2.utils.SapiGIDEvent;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0049a, VoiceManager.c, v.a, h.a {
    private static int jXo = 0;
    private EditorTools ctb;
    private String cuF;
    private LocationModel cuG;
    private NewWriteModel cuH;
    private String fum;
    private String fun;
    private String fuo;
    private VoiceManager fwa;
    private LinearLayout hRS;
    private PlayVoiceBntNew hRT;
    private ImageView hRV;
    private int iYI;
    private TextView iZf;
    private com.baidu.tieba.write.h iZg;
    private ImageView iZh;
    private View iZi;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jUj;
    private com.baidu.tieba.view.b jWG;
    private View jWP;
    private g jWW;
    private LinearLayout jWa;
    private LinearLayout jWb;
    private View jWd;
    private Toast jWf;
    private AdditionData jWg;
    private RelativeLayout jWh;
    private TextView jWi;
    private TextView jWj;
    private TextView jWk;
    List<com.baidu.tieba.frs.v> jWl;
    com.baidu.tieba.frs.v jWm;
    private int jWn;
    private String jWo;
    private int jWp;
    private PostCategoryView jWq;
    private HotTopicBussinessData jWt;
    private TextView jWu;
    private com.baidu.tieba.write.editor.b jWw;
    private e jWz;
    private View jXs;
    private View jXt;
    private TextView jXu;
    private com.baidu.tieba.c.d jXw;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jVX = "";
    private boolean jVY = false;
    private WriteData mData = null;
    private boolean jWL = false;
    private boolean jVZ = false;
    private boolean jWM = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iZa = null;
    private HeadImageView jWN = null;
    private View iZb = null;
    private LinearLayout iZd = null;
    private EditText iZe = null;
    private FeedBackModel jWc = null;
    private FeedBackTopListView jWO = null;
    private ArrayList<WritePrefixItemLayout> jWe = new ArrayList<>();
    private String hpE = null;
    private final KeyEvent feN = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View cgb = null;
    private TextView jWQ = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jWR = null;
    private final Handler mHandler = new Handler();
    private boolean jWS = false;
    private String jWT = null;
    private RelativeLayout mParent = null;
    private String cuL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int cuM = 0;
    private int jWU = 0;
    private WriteImagesInfo jWV = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jWX = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jWY = null;
    private ScrollView jWr = null;
    private EditText jWZ = null;
    private View jXa = null;
    private View jXb = null;
    private View jXc = null;
    private EditText jXd = null;
    private TextView jXe = null;
    private TextView jXf = null;
    private TextWatcher jXg = null;
    private TextWatcher jXh = null;
    private boolean jWs = false;
    private boolean jXi = false;
    private com.baidu.tbadk.core.view.b cDr = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jXj = null;
    private TbImageView jXk = null;
    private View jXl = null;
    private Dialog jXm = null;
    private LinearLayout jXn = null;
    private boolean jXp = false;
    private long jXq = -1000;
    private boolean jXr = false;
    private String fVH = "2";
    private int jQo = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jWv = new SpannableStringBuilder();
    private boolean jXv = false;
    private boolean jWx = false;
    private final b jWy = new b();
    private final HttpMessageListener jXx = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hpE)) {
                    WriteActivity.this.hpE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.ss(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hpE)) {
                    WriteActivity.this.hpE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hpE);
                    WriteActivity.this.ss(true);
                }
            }
        }
    };
    private TbFaceManager.a jWA = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qO(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nK());
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
    private final AntiHelper.a fxo = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUK));
        }
    };
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bne();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jWy.aI(null);
                if (z) {
                    WriteActivity.this.fs(z);
                    if (WriteActivity.this.d(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                v.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                v.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.aa(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").bT(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.mTopicId));
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
                    WriteActivity.this.jWy.aI(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jWy.Hb(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jWy.b(WriteActivity.this.iZa, WriteActivity.this.iZe);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.amT());
                    if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, yVar.amS());
                        if (WriteActivity.this.jWM) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cuT = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void atd() {
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
            if (aVar != null && !StringUtils.isNull(aVar.crd())) {
                WriteActivity.this.b(2, true, aVar.crd());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jla = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.cuG.rk(false);
                    WriteActivity.this.cuG.eq(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.cuG.rk(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jWB = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jWC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cCG = WriteActivity.this.cCG();
            if (cCG >= 0 && cCG < WriteActivity.this.iZe.getText().length()) {
                WriteActivity.this.iZe.setSelection(cCG);
            }
        }
    };
    private boolean jWD = true;
    private final View.OnFocusChangeListener iYY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iZa || view == WriteActivity.this.cgb || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jWD = true;
                    WriteActivity.this.cCH();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iZa);
                    if (WriteActivity.this.ctb != null) {
                        WriteActivity.this.ctb.aqI();
                    }
                } else if (view == WriteActivity.this.iZa) {
                    WriteActivity.this.iZf.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iZe && z) {
                WriteActivity.this.jWD = false;
                WriteActivity.this.cCH();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iZe);
                if (WriteActivity.this.ctb != null) {
                    WriteActivity.this.ctb.aqI();
                }
            }
            WriteActivity.this.cCN();
        }
    };
    private TextWatcher jWE = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jWI = "";
        private String jWJ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jWJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jWJ != null ? this.jWJ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cnt();
            WriteActivity.this.cCO();
            EditText cCZ = WriteActivity.this.cCZ();
            if (editable != null && cCZ != null && cCZ.getText() != null) {
                if (this.jWI == null || !this.jWI.equals(editable.toString())) {
                    if (WriteActivity.this.jWy != null) {
                        this.jWI = cCZ.getText().toString();
                        WriteActivity.this.jWy.o(cCZ);
                        return;
                    }
                    return;
                }
                cCZ.setSelection(cCZ.getSelectionEnd());
            }
        }
    };
    private TextWatcher jWF = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jWJ;
        private String jWK = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jWJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jWJ != null ? this.jWJ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cnt();
            EditText cCY = WriteActivity.this.cCY();
            if (editable != null && cCY != null && cCY.getText() != null) {
                if (this.jWK == null || !this.jWK.equals(editable.toString())) {
                    if (WriteActivity.this.jWy != null) {
                        this.jWK = cCY.getText().toString();
                        WriteActivity.this.jWy.o(cCY);
                        return;
                    }
                    return;
                }
                cCY.setSelection(cCY.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0423a hYH = new a.InterfaceC0423a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0423a
        public void onRefresh() {
            WriteActivity.this.hpE = null;
            WriteActivity.this.ss(false);
            WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void asO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void asP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asR();
        } else if (this.cuG.crj()) {
            asO();
        } else {
            this.cuG.rk(false);
            b(1, true, null);
            this.cuG.crh();
        }
    }

    public void cDi() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jWw != null) {
                this.jWw.cBL();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asR();
        } else if (this.cuG != null) {
            this.cuG.rk(false);
            b(1, true, null);
            this.cuG.crh();
        }
    }

    private void asR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hv(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.cuG.aWk();
                } else {
                    WriteActivity.this.cuT.atd();
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
        aVar.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCG() {
        int selectionEnd = cCY().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cCY().getText().getSpans(0, cCY().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cCY().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cCY().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCH() {
        if (this.ctb != null) {
            this.ctb.setBarLauncherEnabled(!this.jWD);
            this.ctb.setBarLauncherEnabled(true, 26);
            this.ctb.setBarLauncherEnabled(true, 2);
            Y(9, this.jWD ? false : true);
        }
    }

    private void Y(int i, boolean z) {
        com.baidu.tbadk.editortools.g kq;
        if (this.ctb != null && (kq = this.ctb.kq(i)) != null) {
            if (z) {
                kq.ql();
            } else {
                kq.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jWs) {
            this.iZa.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jXc.setVisibility(8);
            } else {
                this.jXc.setVisibility(0);
            }
            a(this.jXf, this.jWZ);
            a(this.jXe, this.jXd);
            cnt();
        }
        if (this.jWL) {
            this.jWD = true;
            cCH();
            if (this.ctb != null) {
                this.ctb.aqI();
            }
            this.iZa.requestFocus();
            ShowSoftKeyPadDelay(this.iZa);
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
            cDx();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cDh();
            }
            st(true);
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
            Dr(this.jQo);
        }
        initUI();
        cDn();
        this.cuG = new LocationModel(this);
        this.cuG.a(this.cuT);
        registerListener(this.jla);
        registerListener(this.jWB);
        initEditor();
        cDA();
        if (this.jWs) {
            this.jWY.setEditorTools(this.ctb);
        } else {
            this.iZe.requestFocus();
        }
        cjw();
        cDh();
        cDy();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.ctb = new EditorTools(getActivity());
        this.ctb.setBarMaxLauCount(5);
        this.ctb.setMoreButtonAtEnd(true);
        this.ctb.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.ctb.setBarLauncherType(1);
        this.ctb.fk(true);
        this.ctb.fl(true);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cDl();
                break;
            default:
                cCI();
                break;
        }
        this.ctb.asn();
        if (this.jWa != null) {
            this.jWa.addView(this.ctb);
        }
        cCJ();
        this.ctb.ql();
        com.baidu.tbadk.editortools.g kq = this.ctb.kq(6);
        if (kq != null && !TextUtils.isEmpty(this.cuL)) {
            ((View) kq).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.cuL);
                }
            });
        }
        if (!this.jWs) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ctb.aqI();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("xiaoying_has_click", false)) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("hot_topic_has_click", false)) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cCL();
    }

    private void cDj() {
        this.jXa = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jXc = this.jXa.findViewById(R.id.live_post_title_container);
        this.jWZ = (EditText) this.jXa.findViewById(R.id.live_post_content);
        this.jWX = (GridView) this.jXa.findViewById(R.id.photoLiveGridView);
        this.jXd = (EditText) this.jXa.findViewById(R.id.live_post_title);
        this.jXe = (TextView) this.jXa.findViewById(R.id.titleOverPlusNumber);
        this.jXf = (TextView) this.jXa.findViewById(R.id.contentOverPlusNumber);
        this.jXb = this.jXa.findViewById(R.id.live_interval_view);
        this.jXe.setText(String.valueOf(20));
        this.jXf.setText(String.valueOf(233));
        this.jXa.setVisibility(0);
        this.jXe.setVisibility(0);
        this.jXf.setVisibility(0);
        this.jXd.setHint(R.string.tips_title_limit_new);
        this.jXd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jXi = true;
                    WriteActivity.this.jWD = true;
                    WriteActivity.this.cCH();
                    if (WriteActivity.this.ctb != null) {
                        WriteActivity.this.ctb.aqI();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jWZ.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jWZ.setHint(R.string.live_write_input_content_update);
        }
        this.jWZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jXi = false;
                    WriteActivity.this.jWD = false;
                    WriteActivity.this.cCH();
                    if (WriteActivity.this.ctb != null) {
                        WriteActivity.this.ctb.aqI();
                    }
                }
            }
        });
        this.jWZ.requestFocus();
        this.jWZ.addTextChangedListener(Ec());
        this.jXd.requestFocus();
        this.jXd.addTextChangedListener(Ec());
        this.jXd.setOnClickListener(this.jWC);
        this.jWZ.setOnClickListener(this.jWC);
        this.jWY = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jWX);
        this.jWY.Dl(6);
        this.jWX.setAdapter((ListAdapter) this.jWY);
        View findViewById = this.jXa.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cCr() {
                WriteActivity.this.cDv();
            }
        });
        cDk();
    }

    private void cDk() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jXd.setText(this.mData.getTitle());
                this.jXd.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jWs) {
            cDt();
        }
        if (this.ctb.asp()) {
            this.ctb.aqI();
        }
        Dr(0);
    }

    private void Dr(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fVH);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cDl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ctb.ai(arrayList);
        com.baidu.tbadk.editortools.k kt = this.ctb.kt(5);
        if (kt != null) {
            kt.ctM = 2;
        }
        this.ctb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.ctb.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cCI() {
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
            this.ctb.b(dVar);
        }
        Boolean cDr = cDr();
        if (!this.jWL && cDr != null && cDr.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.crK() && r.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.ctM = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ctb.b(kVar5);
            }
        }
        this.ctb.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.ctM = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ctb.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.ctM = 6;
            kVar3.ctI = this.jWL ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.ctb.b(kVar3);
        }
        this.ctb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.ctO = true;
            kVar2.ctM = 9;
            kVar2.ctI = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ctb.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.ctO = true;
            kVar.ctM = 10;
            kVar.ctI = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ctb.b(kVar);
            }
        }
        if (this.jWg == null) {
            if (this.jWw == null) {
                this.jWw = new com.baidu.tieba.write.editor.b(getActivity(), this.fVH);
                this.jWw.bv(this.mData.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jWw.cBH();
                this.jWw.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cDi();
            }
            this.ctb.b(this.jWw);
        }
        this.ctb.ai(arrayList);
        com.baidu.tbadk.editortools.k kt = this.ctb.kt(5);
        if (kt != null) {
            kt.ctM = 1;
        }
    }

    private void cCK() {
        if (this.jWz != null) {
            this.jWz.hideTip();
        }
    }

    private void cCL() {
        if (this.jWz == null) {
            this.jWz = new e(getPageContext());
        }
        this.jWz.c(this.ctb);
    }

    private void cCJ() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cCX()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof p)) {
                            p pVar = (p) aVar.data;
                            if (pVar.amI() == EmotionGroupType.BIG_EMOTION || pVar.amI() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.ake();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.e(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.ad(WriteActivity.this)) {
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
                                    WriteActivity.this.st(true);
                                    WriteActivity.this.cnt();
                                }
                            } else if (WriteActivity.this.cCX()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cDa();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bWs();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cDx();
                        WriteActivity.this.cnt();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Ds(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jWg == null) {
                            WriteActivity.this.asS();
                            return;
                        }
                        switch (WriteActivity.this.cuM) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cx(pageActivity)) {
                                    WriteActivity.this.asP();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.asO();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.cuG != null) {
                            WriteActivity.this.cuG.rk(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hpE = null;
                        } else {
                            WriteActivity.this.hpE = (String) aVar.data;
                        }
                        WriteActivity.this.ss(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bT("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.ctb.asp()) {
                                        WriteActivity.this.ctb.aqI();
                                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cnt();
                        if (WriteActivity.this.iZe != null) {
                            WriteActivity.this.iZe.requestFocus();
                        }
                        WriteActivity.this.ctb.aqI();
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iZe);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jVY = true;
                        WriteActivity.this.sq(true);
                        if (!WriteActivity.this.cCZ().isFocused() || WriteActivity.this.jWb.getVisibility() != 0) {
                            WriteActivity.this.jVX = "from_content";
                        } else {
                            WriteActivity.this.jVX = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jWb.setVisibility(0);
                        WriteActivity.this.jWb.requestFocus();
                        WriteActivity.this.cnt();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jWb.hasFocus()) {
                            WriteActivity.this.iZe.requestFocus();
                            WriteActivity.this.iZe.setSelection(WriteActivity.this.iZe.getText().toString().length());
                        }
                        WriteActivity.this.jWb.setVisibility(8);
                        WriteActivity.this.cnt();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.ctb.setActionListener(16, bVar);
        this.ctb.setActionListener(14, bVar);
        this.ctb.setActionListener(24, bVar);
        this.ctb.setActionListener(3, bVar);
        this.ctb.setActionListener(10, bVar);
        this.ctb.setActionListener(11, bVar);
        this.ctb.setActionListener(12, bVar);
        this.ctb.setActionListener(13, bVar);
        this.ctb.setActionListener(15, bVar);
        this.ctb.setActionListener(18, bVar);
        this.ctb.setActionListener(20, bVar);
        this.ctb.setActionListener(25, bVar);
        this.ctb.setActionListener(27, bVar);
        this.ctb.setActionListener(29, bVar);
        this.ctb.setActionListener(43, bVar);
        this.ctb.setActionListener(45, bVar);
        this.ctb.setActionListener(53, bVar);
        this.ctb.setActionListener(48, bVar);
        this.ctb.setActionListener(46, bVar);
        this.ctb.setActionListener(49, bVar);
        this.ctb.setActionListener(47, bVar);
        this.ctb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asS() {
        if (this.cuG.aWg()) {
            if (this.cuG.crj()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.crf().getLocationData().crd());
                return;
            }
            b(1, true, null);
            this.cuG.crh();
            return;
        }
        b(0, true, null);
    }

    protected void cnl() {
        if (this.cuH != null) {
            this.cuH.cancelLoadData();
        }
        if (this.jWc != null) {
            this.jWc.cancelLoadData();
        }
        if (this.cuG != null) {
            this.cuG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cCK();
        TiebaPrepareImageService.StopService();
        cnl();
        cDq();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jWW != null) {
            this.jWW.destroy();
        }
        if (this.jXw != null) {
            this.jXw.bcf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCM() {
        if (this.mData != null && this.mData.getType() == 2 && this.jWS) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(cCZ().getText().toString());
            this.mData.setContent(cCY().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.mData);
                }
            } else if (type == 1) {
                v.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                v.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                v.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iZg != null && this.iZg.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iZg, getPageContext().getPageActivity());
                return true;
            } else if (this.ctb.asp()) {
                this.ctb.aqI();
                return true;
            } else {
                cnl();
                cCM();
                return true;
            }
        }
        if (i == 67 && (text = cCY().getText()) != null) {
            int selectionStart = cCY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCY().onKeyDown(67, this.feN);
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
        getLayoutMode().onModeChanged(this.jXn);
        am.l(this.mParent, R.color.cp_bg_line_e);
        if (this.jXk != null && (i == 1 || i == 4)) {
            this.jXk.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.mPost, R.color.cp_link_tip_a, 1);
        cCH();
        am.l(this.iZb, R.color.cp_bg_line_c);
        am.l(this.jXb, R.color.cp_bg_line_c);
        am.l(cCZ(), R.color.cp_bg_line_e);
        am.c(this.hRV, (int) R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hpE)) {
            am.l(cCY(), R.color.cp_bg_line_e);
        }
        cnt();
        this.ctb.onChangeSkinType(i);
        if (this.jWq != null) {
            this.jWq.akZ();
        }
        am.j(this.mName, R.color.cp_cont_b);
        this.jWW.jXS.notifyDataSetChanged();
        cCN();
        cCO();
        ss(false);
        if (this.jWy != null) {
            this.jWy.c(cCZ(), cCY());
        }
        this.jUj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCN() {
        if (this.iZa.hasFocus()) {
            this.iZa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iZa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iZe.hasFocus()) {
            this.iZe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iZe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        if (this.iZa != null && this.iZa.getText() != null && this.iZa.getText().toString() != null && this.iZa.getPaint() != null) {
            if (this.iZa.getText().toString().length() == 0) {
                this.iZa.getPaint().setFakeBoldText(false);
            } else if (this.iZa.getText().toString().length() > 0) {
                this.iZa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cDr = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jWs = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.j(this.mName, R.color.cp_cont_b);
        this.jWQ = (TextView) findViewById(R.id.btn_image_problem);
        cCQ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iYY);
        this.jWr = (ScrollView) findViewById(R.id.write_scrollview);
        this.jWr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iZe != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iZe);
                    }
                    if (WriteActivity.this.ctb != null) {
                        WriteActivity.this.ctb.aqI();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jWO = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jWP = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jWa = (LinearLayout) findViewById(R.id.tool_view);
        this.jWa.setContentDescription("..");
        this.jWb = (LinearLayout) findViewById(R.id.title_view);
        this.iZb = findViewById(R.id.interval_view);
        this.jXs = findViewById(R.id.hot_topic_fourm_view);
        this.jXt = findViewById(R.id.hot_topic_divider);
        this.jWu = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jXu = (TextView) findViewById(R.id.change_one_tv);
        cns();
        if (this.jWs) {
            this.jWr.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cDj();
        } else {
            this.jWW = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jWW.sl(false);
            } else {
                g gVar = this.jWW;
                if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                    z = false;
                }
                gVar.sl(z);
            }
        }
        cnu();
        if (this.jWL || this.jVZ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bVu) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iZd = (LinearLayout) findViewById(R.id.post_content_container);
        this.iZd.setDrawingCacheEnabled(false);
        this.iZd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iZe.requestFocus();
            }
        });
        this.hRS = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hRT = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hRV = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bWs();
            }
        });
        this.cgb.setOnFocusChangeListener(this.iYY);
        this.cgb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cnl();
                WriteActivity.this.cCM();
            }
        });
        this.jWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cCT();
        l(cDr());
        cCV();
        cCP();
        cDo();
        cDp();
        cCH();
        cCU();
        cnr();
        cDb();
        if (this.mData.getType() == 4 && this.iZi != null && this.jWd != null) {
            this.iZi.setVisibility(8);
            this.jWd.setVisibility(8);
        }
        cnt();
        cDm();
        cBY();
    }

    private void cBY() {
        this.jUj = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jUj.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Dg(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jUj.bgA();
    }

    private void cCP() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jWL || this.jVZ) {
                        if (this.jWM) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fVH != null && this.fVH.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fVH != null && this.fVH.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                        this.iZa.setVisibility(8);
                        String str3 = this.fuo + " " + this.fum;
                        if (!StringUtils.isNull(str3)) {
                            this.iZe.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iZa.setVisibility(0);
                    this.iZe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iZe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iZa.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iZe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jXb.setVisibility(8);
                    return;
                case 7:
                    this.iZa.setVisibility(0);
                    this.iZe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cCQ() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cCR() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jWL && !this.jVZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = aq.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cCZ() != null) {
                cCZ().setText(i);
                cCZ().setSelection(i.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hRS.setVisibility(0);
            this.hRT.setVoiceModel(voiceModel);
            this.hRT.crJ();
            cnt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWs() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hRS.setVisibility(8);
        this.hRT.bxn();
        this.hRT.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kt = this.ctb.kt(6);
        if (kt != null && kt.csV != null) {
            kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cnt();
    }

    private void cCS() {
        this.jWl = null;
        this.jWn = -1;
        this.jWp = -1;
        x rP = w.boy().rP(1);
        if (rP != null) {
            this.jWl = rP.fzO;
            this.jWn = getIntent().getIntExtra("category_id", -1);
            if (this.jWl != null && !this.jWl.isEmpty() && this.jWn >= 0) {
                this.jWm = new com.baidu.tieba.frs.v();
                this.jWm.fzK = 0;
                this.jWm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jWp = this.jWm.fzK;
                this.jWo = this.jWm.name;
                for (com.baidu.tieba.frs.v vVar : this.jWl) {
                    if (vVar.fzK == this.jWn) {
                        this.jWp = vVar.fzK;
                        this.jWo = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cCT() {
        if (this.jWl != null && !this.jWl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jWq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jWq.setText(this.jWo);
            this.jWq.setCategoryContainerData(this.jWl, this.jWm, this.jWp);
            this.jWq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jWq.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fzK);
                        WriteActivity.this.jWp = arVar.fzK;
                        WriteActivity.this.jWq.cCu();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jWq.cCt();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCY());
                }
            });
        }
    }

    private void cDm() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jWG = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jWG.setTitle(R.string.no_disturb_start_time);
        this.jWG.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jWG);
        this.jWG.setButton(-2, getPageContext().getString(R.string.cancel), this.jWG);
        return this.jWG;
    }

    private void cCU() {
        this.jWh = (RelativeLayout) findViewById(R.id.addition_container);
        this.jWi = (TextView) findViewById(R.id.addition_create_time);
        this.jWj = (TextView) findViewById(R.id.addition_last_time);
        this.jWk = (TextView) findViewById(R.id.addition_last_content);
        if (this.jWg != null) {
            this.jWh.setVisibility(0);
            this.jWi.setText(getPageContext().getString(R.string.write_addition_create) + aq.aD(this.jWg.getCreateTime() * 1000));
            if (this.jWg.getAlreadyCount() == 0) {
                this.jWj.setVisibility(8);
            } else {
                this.jWj.setText(getPageContext().getString(R.string.write_addition_last) + aq.aD(this.jWg.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jWg.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jWk.setText(lastAdditionContent);
            } else {
                this.jWk.setVisibility(8);
            }
            cCY().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jWg.getAlreadyCount()), Integer.valueOf(this.jWg.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jWh.setVisibility(8);
    }

    private void cnr() {
        this.iZi = findViewById(R.id.post_prefix_layout);
        if (this.jXw == null) {
            this.jXw = new com.baidu.tieba.c.d(getPageContext(), this.iZi);
            this.jXw.qf(R.drawable.bg_tip_blue_up_left);
            this.jXw.qe(16);
            this.jXw.iU(true);
            this.jXw.S(true);
            this.jXw.qi(l.g(getActivity(), R.dimen.ds32));
        }
        this.iZf = (TextView) findViewById(R.id.post_prefix);
        this.jWd = findViewById(R.id.prefix_divider);
        this.iZh = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iZi.setVisibility(0);
            this.jXw.v(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iYI = 0;
            this.iZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).n("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iZf.setVisibility(0);
                    WriteActivity.this.iZi.setSelected(true);
                    am.c(WriteActivity.this.iZh, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iZg, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ctb.aqI();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iZa);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iZe);
                }
            });
            this.iZf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).n("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iZf.setSelected(true);
                    am.c(WriteActivity.this.iZh, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iZg, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ctb.aqI();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCY());
                }
            });
            this.iZg = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iZg.a(this);
            this.iZg.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iZg.setOutsideTouchable(true);
            this.iZg.setFocusable(true);
            this.iZg.setOnDismissListener(this);
            this.iZg.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.k(this.iZf, R.color.cp_bg_line_d);
            am.c(this.iZh, (int) R.drawable.icon_arrow_gray_down);
            this.iZf.setTextColor(color);
            this.jWe.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jWe.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sg(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sg(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iZg.addView(writePrefixItemLayout);
            }
            this.iZg.setCurrentIndex(0);
            this.iZf.setText(prefixs.get(0));
            Dq(0);
            return;
        }
        this.iZi.setVisibility(8);
    }

    private void cDn() {
        if (this.jWL && this.mData != null) {
            this.jWO.setVisibility(0);
            this.jWP.setVisibility(0);
            this.jWc = new FeedBackModel(getPageContext());
            this.jWc.Hw(this.mData.getForumName());
            this.jWc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jWO.setVisibility(8);
                        WriteActivity.this.jWP.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jWO.setVisibility(8);
                        WriteActivity.this.jWP.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jWO.a(feedBackModel.cCw(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cCV() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jWy.a(WriteActivity.this.iZa, WriteActivity.this.iZe)) {
                        WriteActivity.this.showToast(WriteActivity.this.jWy.cAr());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCY());
                    WriteActivity.this.ctb.aqI();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jWL) {
                            WriteActivity.this.cDe();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.P("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cDf();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cDe();
                    }
                    TiebaStatic.log(new an("c12262").bT("obj_locate", WriteActivity.this.fVH));
                }
            }
        });
    }

    protected void cDo() {
        this.jWR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jWR.mQ(getPageContext().getString(R.string.is_save_draft)).dQ(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cCZ().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cCY().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    v.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.jWR.b(getPageContext());
    }

    protected void cns() {
        this.jWN = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jWN.setIsRound(true);
        this.jWN.setDrawBorder(false);
        this.jWN.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nO = o.nO(currentPortrait);
            this.jWN.setUrl(nO);
            this.jWN.startLoad(nO, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jWN.setVisibility(0);
        }
        this.iZa = (EditText) findViewById(R.id.post_title);
        this.iZa.setOnClickListener(this.jWC);
        this.iZa.setOnFocusChangeListener(this.iYY);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iZa.setText(this.mData.getTitle());
                this.iZa.setSelection(this.mData.getTitle().length());
            } else if (this.jWM) {
                this.iZa.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iZa.addTextChangedListener(this.jWE);
        if (!this.mData.getHaveDraft()) {
            cCR();
            this.jXr = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iZa.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iZa.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher Ec() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jXA;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cnt();
                if (WriteActivity.this.jWs) {
                    this.jXA = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jXA);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jWs || !WriteActivity.this.jXi) {
                    if (WriteActivity.this.jWs) {
                        if (this.mEditText != WriteActivity.this.jWZ || this.mTextView != WriteActivity.this.jXf) {
                            this.mEditText = WriteActivity.this.jWZ;
                            this.mTextView = WriteActivity.this.jXf;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jXd || this.mTextView != WriteActivity.this.jXe) {
                    this.mEditText = WriteActivity.this.jXd;
                    this.mTextView = WriteActivity.this.jXe;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jWs && this.jXi) {
            if (this.jXg != null) {
                this.jXd.removeTextChangedListener(this.jXg);
            }
            this.jXg = textWatcher;
        } else if (this.jWs) {
            if (this.jXh != null) {
                this.jWZ.removeTextChangedListener(this.jXh);
            }
            this.jXh = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jWZ) {
            return 233L;
        }
        if (editText != this.jXd) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long p = p(editText);
            long q = p - q(editText);
            String valueOf = String.valueOf(q);
            if (p == 20) {
                if (q < 0) {
                    if (q < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (q < 0) {
                if (q < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long q(EditText editText) {
        return com.baidu.tieba.write.c.a.m(editText.getText().toString().trim());
    }

    protected void cnu() {
        this.iZe = (EditText) findViewById(R.id.post_content);
        this.iZe.setDrawingCacheEnabled(false);
        this.iZe.setOnClickListener(this.jWC);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atJ().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.iZe.setText(ak);
            this.iZe.setSelection(ak.length());
        } else if (this.mData.getType() == 2) {
            if (this.jWS) {
                if (this.jWT != null && this.jWT.length() > 0) {
                    this.iZe.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jWT}));
                    this.iZe.setSelection(this.iZe.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iZe.setText(format);
                this.iZe.setSelection(format.length());
            }
        }
        this.iZe.setOnFocusChangeListener(this.iYY);
        this.iZe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iZe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iZe.addTextChangedListener(this.jWF);
        if (this.mData.getType() == 0) {
            this.jXv = true;
        } else {
            ss(true);
            this.jXv = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iZe.setHint(R.string.write_input_content);
        } else {
            this.iZe.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void ss(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jWs) {
            cCY().setPadding(0, 0, 0, 0);
            cCY().setBackgroundDrawable(null);
            am.l(cCY(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hpE) && this.jWg == null) {
                com.baidu.adp.lib.f.c.iE().a(this.hpE, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.nK() != null && aVar.nO() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.nK(), aVar.nK().getNinePatchChunk(), aVar.nO(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cCY().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cCY(), true, WriteActivity.this.hYH);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cCX() {
        int i = 5000;
        if (this.jWg != null) {
            i = 1000;
        }
        return cCY().getText() != null && cCY().getText().length() >= i;
    }

    private void qw(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jVX)) {
                this.jVX = "";
                cCY().requestFocus();
                if (cCY().getText() != null && cCY().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCY().getSelectionStart();
                    editable = cCY().getText();
                }
            } else if ("from_title".equals(this.jVX)) {
                this.jVX = "";
                cCZ().requestFocus();
                if (cCZ().getText() != null && cCZ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCZ().getSelectionStart();
                    editable = cCZ().getText();
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
    public void sq(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.e(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cCY().getText().getSpans(0, cCY().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jWf == null) {
                this.jWf = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jWf.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType amI = pVar.amI();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iE().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cCY().getSelectionStart(), aVar, amI);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cCY() != null && cCY().getText() != null) {
            Bitmap nK = aVar.nK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nK);
            int width = nK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cCY().getSelectionStart() - 1;
                if (cCY().getText().length() > 1 && selectionStart >= 0 && cCY().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cCY().getText().insert(cCY().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cCY().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cCY().getText().insert(cCY().getSelectionStart(), spannableString2);
            }
            Editable text = cCY().getText();
            if (text != null) {
                this.jWv.clear();
                this.jWv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jWv);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cCY().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cCY().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cCY().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCY() {
        return this.jWs ? this.jWZ : this.iZe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCZ() {
        return this.jWs ? this.jXd : this.iZa;
    }

    protected void cDa() {
        Editable text;
        if (cCY() != null && (text = cCY().getText()) != null) {
            int selectionStart = cCY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCY().onKeyDown(67, this.feN);
            }
            cCY().onKeyDown(67, this.feN);
            int selectionStart2 = cCY().getSelectionStart();
            if (text != null) {
                this.jWv.clear();
                this.jWv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jWv);
                cCY().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jWL = true;
        }
    }

    private void cDp() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cDq() {
        try {
            if (this.jWR != null) {
                this.jWR.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cDr.e(null);
        this.cDr.iC(R.string.sending);
        this.cDr.em(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cDr.em(false);
    }

    private Boolean cDr() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.cuL = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cnt() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cCZ() != null) {
                str = cCZ().getText().toString();
            }
            if (cCY() != null) {
                str2 = cCY().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iYI == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jWb.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            sr(true);
                            return;
                        }
                    } else if (this.jWb.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        sr(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jWb.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    sr(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jWs) {
                    sr(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    sr(true);
                }
            }
            if (this.mData.getType() == 4) {
                sr(s(this.jWZ) && r(this.jXd));
            } else if (this.mData.getType() == 5) {
                sr(s(this.jWZ));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                sr(true);
            } else if (this.mData.getVideoInfo() != null) {
                sr(true);
            } else {
                sr(false);
            }
        }
    }

    public void sr(boolean z) {
        if (z) {
            am.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        am.f(this.mPost, R.color.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean r(EditText editText) {
        long q = q(editText);
        return q <= 20 && q > 0;
    }

    private boolean s(EditText editText) {
        long q = q(editText);
        if (q > 233) {
            return false;
        }
        return q > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.cuH = new NewWriteModel(this);
        this.cuH.b(this.cuV);
        registerListener(this.jXx);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cnl();
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
            this.jWL = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jWM = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jWS = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jWT = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.cuF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jWg = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jWg != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jWU = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fVH = bundle.getString("KEY_CALL_FROM");
            this.jQo = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jWL = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jWM = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jWS = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jWT = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jWg = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jWg != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jWU = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fun = intent.getStringExtra("more_forum_img");
            this.fuo = intent.getStringExtra("more_forum_title");
            this.fum = intent.getStringExtra("more_forum_url");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fVH = intent.getStringExtra("KEY_CALL_FROM");
            this.jQo = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jWL);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0 || this.mData.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            v.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            v.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            v.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.hpE = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jVZ = true;
        }
        cCS();
        try {
            this.jXj = cDz();
        } catch (Throwable th) {
            this.jXj = null;
        }
    }

    private void cDb() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iZa.setText(com.baidu.tbadk.plugins.b.rh(com.baidu.tbadk.plugins.b.ri(hotTopicBussinessData.mTopicName)));
            this.iZa.setMovementMethod(com.baidu.tieba.view.c.czb());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString rh = com.baidu.tbadk.plugins.b.rh(com.baidu.tbadk.plugins.b.ri(hotTopicBussinessData.mTopicName));
            if (rh != null) {
                this.iZa.setText(rh);
            }
            this.jWu.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String ri;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.mData != null) {
                    this.mData.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cCZ().getText().toString()) || this.jXr || ((this.jWL || this.jVZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                            this.mData.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                ri = this.mData.getTitle();
                            } else {
                                ri = com.baidu.tbadk.plugins.b.ri(str);
                            }
                            SpannableString rh = com.baidu.tbadk.plugins.b.rh(ri);
                            if (rh != null) {
                                cCZ().setText(rh);
                                cCZ().setSelection(rh.length() > ri.length() ? ri.length() : rh.length());
                            }
                        } else {
                            SpannableString rh2 = com.baidu.tbadk.plugins.b.rh(this.mData.getTitle());
                            if (rh2 != null) {
                                cCZ().setText(rh2);
                                cCZ().setSelection(this.mData.getTitle().length() > rh2.length() ? rh2.length() : this.mData.getTitle().length());
                            }
                        }
                    }
                    if (this.mData != null && !this.mData.getHaveDraft()) {
                        cCR();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.mData.setVideoInfo(videoInfo);
                        this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cCY().getText().toString()) || this.jWL || this.jVZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.mData.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.atJ().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jWA);
                        cCY().setText(a2);
                        cCY().setSelection(a2.length());
                        if (this.jWs) {
                            a(this.jXf, this.jWZ);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.mData.setWriteImagesInfo(this.writeImagesInfo);
                        cDx();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cDh();
                        }
                        st(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cDs();
                    }
                    cnt();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jWl != null) {
                        this.jWp = this.jWm.fzK;
                        this.jWo = this.jWm.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jWl.size()) {
                                break;
                            }
                            com.baidu.tieba.frs.v vVar = this.jWl.get(i);
                            if (categoryTo != vVar.fzK) {
                                i++;
                            } else {
                                this.jWp = categoryTo;
                                this.jWo = vVar.name;
                                this.mData.setCategoryTo(this.jWp);
                                break;
                            }
                        }
                        if (this.jWq != null) {
                            this.jWq.setText(this.jWo);
                            this.jWq.setCategoryContainerData(this.jWl, this.jWm, this.jWp);
                        }
                    }
                    this.ctb.aqI();
                    return;
                }
                return;
            }
            cDs();
            cCR();
        }
    }

    private void cDs() {
        if ((!this.jWs || this.jWY != null) && this.jWX != null) {
            this.jWY.c(this.writeImagesInfo);
            cDv();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jWS);
        if (this.jWL) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cuF);
        if (this.jWg != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jWg));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jWU);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fVH);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jQo);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cCY().getEditableText().toString();
        if (obj != null) {
            cCY().setText(TbFaceManager.atJ().a(getPageContext().getPageActivity(), obj, this.jWA));
            cCY().setSelection(cCY().getText().length());
        }
    }

    private String cDc() {
        return (cCY() == null || cCY().getText() == null) ? "" : cCY().getText().toString();
    }

    private String cDd() {
        if (this.mData == null || cCZ() == null || cCZ().getVisibility() != 0 || cCZ().getText() == null) {
            return "";
        }
        String obj = cCZ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iYI != com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iZf != null && this.iZf.getText() != null) {
            this.mData.setPostPrefix(this.iZf.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void Hx(String str) {
        if (this.mData != null && this.jWb != null) {
            if (this.jWb.getVisibility() == 0) {
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
    public void cDe() {
        cnl();
        this.mData.setContent(cDc());
        Hx(cDd());
        if (this.jWL || this.jVZ) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                Hx(string + this.mData.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.kc()) {
                    sb.append(com.baidu.adp.lib.util.j.kj());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.jWn >= 0) {
            this.mData.setCategoryFrom(this.jWn);
        }
        if (this.jWp >= 0) {
            this.mData.setCategoryTo(this.jWp);
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
        this.mData.setHasLocationData(this.cuG != null && this.cuG.aWg());
        if (this.writeImagesInfo != null) {
            this.cuH.rm(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jWt != null && this.jWt.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jWt.mForumId));
            this.mData.setForumName(this.jWt.mForumName);
        }
        this.cuH.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.cuH.getWriteData().setVoice(this.mVoiceModel.getId());
                this.cuH.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.cuH.getWriteData().setVoice(null);
                this.cuH.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.cuH.getWriteData().setVoice(null);
            this.cuH.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.cuH.crL()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.cuH.startPostWrite();
        }
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jWg != null) {
                i2 = this.jWg.getTotalCount();
                i = this.jWg.getAlreadyCount() + 1;
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
                if (this.iZa == getCurrentFocus()) {
                    cCY().clearFocus();
                    this.iZa.requestFocus();
                    if (this.ctb != null) {
                        this.ctb.aqI();
                    }
                    ShowSoftKeyPadDelay(this.iZa);
                } else {
                    cCY().requestFocus();
                    if (this.ctb != null) {
                        this.ctb.aqI();
                    }
                    ShowSoftKeyPadDelay(this.iZe);
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
                            cCY().getText().insert(cCY().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    v.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.mData.getType() == 1) {
                    v.d(this.mData.getThreadId(), (WriteData) null);
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
                                cDw();
                            } else {
                                aG(intent);
                            }
                        } else if (intExtra == 1) {
                            aH(intent);
                        } else {
                            aE(intent);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jXv) {
                            ss(true);
                            this.jXv = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jWs) {
                        R(intent);
                        cnt();
                        return;
                    }
                    aF(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ctb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ctb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ctb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cnt();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jVY) {
                                sb2.append(com.baidu.tbadk.plugins.b.cCL);
                                this.jVY = false;
                            }
                            sb2.append(stringExtra);
                            qw(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jWt = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jWt);
                }
            }
        } else if (i2 == 0) {
            if (this.ctb != null && !this.ctb.asp()) {
                this.iZe.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.ctb.aqI();
            }
            switch (i) {
                case SapiGIDEvent.TIME_FREQ /* 12001 */:
                    asV();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    cDu();
                    if (this.jXv) {
                        ss(true);
                        this.jXv = false;
                        return;
                    }
                    return;
                case 12004:
                    if (this.iZa == getCurrentFocus()) {
                        cCY().clearFocus();
                        this.iZa.requestFocus();
                        if (this.ctb != null) {
                            this.ctb.aqI();
                        }
                        ShowSoftKeyPadDelay(this.iZa);
                        return;
                    }
                    cCY().requestFocus();
                    if (this.ctb != null) {
                        this.ctb.aqI();
                    }
                    ShowSoftKeyPadDelay(this.iZe);
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jWy.Hb(postWriteCallBackData.getErrorString());
                        this.jWy.aI(postWriteCallBackData.getSensitiveWords());
                        this.jWy.b(this.iZa, this.iZe);
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.cuF = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.cuF);
                    return;
                case 12012:
                    cDu();
                    return;
                case 25004:
                    if ("from_title".equals(this.jVX)) {
                        cCZ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jVX)) {
                        cCY().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDf() {
        if ("1".equals(this.fVH)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fVH)) {
            this.mData.setCanNoForum(false);
        }
        cDg();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fVH);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cDe();
    }

    private void cDg() {
        if (this.ctb != null) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cDt() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cDu() {
        if (this.jWs) {
            this.jWY.c(this.writeImagesInfo);
            cDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDv() {
        this.jWY.notifyDataSetChanged();
        this.jWX.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jWY.notifyDataSetChanged();
                WriteActivity.this.jWX.invalidateViews();
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
        cnt();
    }

    private void aE(Intent intent) {
        if (this.jWs) {
            aF(intent);
            cDu();
        } else {
            aI(intent);
        }
        cnt();
    }

    private void aF(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cDu();
            st(true);
        }
    }

    private void aG(Intent intent) {
        if (this.writeImagesInfo != null) {
            Q(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void cDw() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) SapiGIDEvent.TIME_FREQ, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aH(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jWV.parseJson(stringExtra);
            this.jWV.updateQuality();
            if (this.jWV.getChosedFiles() != null && this.jWV.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jWV.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jWV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cCZ());
        HidenSoftKeyPad(this.mInputManager, cCY());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aI(Intent intent) {
        c(intent, true);
    }

    private void Q(Intent intent) {
        this.cuF = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.cuF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.cuF, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cDx();
            cDh();
        }
        st(true);
    }

    private void R(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                cDx();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cDh();
                }
            }
            st(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDx() {
        if (this.ctb.kt(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void asV() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.cuF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cDy() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.fun)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mCurrentPermissionJudgePolicy.ake();
            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.ad(this)) {
                com.baidu.tbadk.util.m mVar = new com.baidu.tbadk.util.m(this, this.fun, new m.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.st(true);
                        }
                    }
                });
                mVar.setFrom(1);
                mVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jWW != null) {
            this.jWW.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bne() {
        this.fwa = getVoiceManager();
        this.fwa.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fxo) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUK));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jWg == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cuM = i;
        if (this.ctb != null) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cDh() {
        if (!this.jWs) {
            if (this.ctb != null) {
                this.ctb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.ctb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jWW != null) {
                this.jWW.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.ctb != null) {
            this.ctb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dq(int i) {
        if (i < this.jWe.size()) {
            for (int i2 = 0; i2 < this.jWe.size(); i2++) {
                this.jWe.get(i2).sh(false);
            }
            this.jWe.get(i).sh(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void AO(int i) {
        if (i == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").P("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").P("obj_type", 2));
        }
        this.iYI = i;
        this.iZg.setCurrentIndex(i);
        Dq(i);
        this.iZf.setText(this.mPrefixData.getPrefixs().get(i));
        cnt();
        com.baidu.adp.lib.g.g.a(this.iZg, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iZi.setSelected(false);
        am.c(this.iZh, (int) R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iZe);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
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
            asP();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cy(getApplicationContext())) {
                al.a(getPageContext(), this.cuF);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jWx = z;
        if (this.jXp && System.currentTimeMillis() - this.jXq < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jXp = false;
        }
        if (this.jWw != null && !z) {
            this.jWw.bgP();
        }
        if (this.jWz != null && !z) {
            cCK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jXm != null) {
            Hz(str);
            this.jXm.dismiss();
        }
    }

    private void ex(Context context) {
        jXo = l.ah(context);
    }

    private void Hz(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jXp = true;
        cDx();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cDh();
        }
        st(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4412=4] */
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

    private File cDz() {
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

    private void cDA() {
        if (this.jXj != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ex(getActivity());
            this.jXl = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jXj != null) {
                        WriteActivity.this.Hy(WriteActivity.this.jXj.getAbsolutePath());
                    }
                }
            });
            this.jXk = (TbImageView) this.jXl.findViewById(R.id.rec_img_view);
            this.jXn = (LinearLayout) this.jXl.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.ahU().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jXj.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("write_rec_pic_path", this.jXj.getAbsolutePath());
                Bitmap f = f(this.jXj.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (f != null) {
                    this.jXk.setImageBitmap(f);
                    this.jXk.setDrawBorder(true);
                    this.jXk.setBorderWidth(2);
                    this.jXk.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.jXm = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jXm.setCanceledOnTouchOutside(true);
                    this.jXm.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jXp) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jXq = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jXm.setContentView(this.jXl);
                    this.jXm.show();
                    Window window = this.jXm.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jXo / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.jWx && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jVY = false;
            this.jVX = "";
            if ("from_content".equals(str)) {
                this.jVX = "from_content";
            } else if ("from_title".equals(str)) {
                this.jVX = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.rg(String.valueOf(charSequence.charAt(i)))) {
                sq(false);
            }
        }
    }

    public void cjw() {
        if (this.jWL || !com.baidu.tbadk.core.util.v.aa(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jWb.setVisibility(0);
            this.jWb.requestFocus();
            this.ctb.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jWb.setVisibility(8);
    }
}
