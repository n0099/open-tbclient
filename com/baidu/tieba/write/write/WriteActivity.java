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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
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
    private static int hzW = 0;
    private EditorTools aMi;
    private String aNJ;
    private LocationModel aNK;
    private NewWriteModel aNL;
    private VoiceManager dmn;
    private ImageView fAb;
    private LinearLayout fzY;
    private PlayVoiceBntNew fzZ;
    private ImageView gDA;
    private View gDB;
    private int gDb;
    private TextView gDy;
    private com.baidu.tieba.write.d gDz;
    private View hAa;
    private View hAb;
    private TextView hAc;
    private com.baidu.tieba.c.d hAf;
    private LinearLayout hyI;
    private LinearLayout hyJ;
    private View hyL;
    private Toast hyN;
    private AdditionData hyO;
    private RelativeLayout hyP;
    private TextView hyQ;
    private TextView hyR;
    private TextView hyS;
    List<x> hyT;
    x hyU;
    private int hyV;
    private String hyW;
    private int hyX;
    private PostCategoryView hyY;
    private g hzE;
    private HotTopicBussinessData hzb;
    private TextView hzc;
    private com.baidu.tieba.write.editor.b hze;
    private e hzh;
    private com.baidu.tieba.view.b hzo;
    private View hzx;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hyF = "";
    private boolean hyG = false;
    private WriteData mData = null;
    private boolean hzt = false;
    private boolean hyH = false;
    private boolean hzu = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gDt = null;
    private HeadImageView hzv = null;
    private View gDu = null;
    private LinearLayout gDw = null;
    private EditText gDx = null;
    private FeedBackModel hyK = null;
    private FeedBackTopListView hzw = null;
    private ArrayList<WritePrefixItemLayout> hyM = new ArrayList<>();
    private String eYk = null;
    private final KeyEvent cVg = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aAW = null;
    private TextView hzy = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hzz = null;
    private final Handler mHandler = new Handler();
    private boolean hzA = false;
    private String hzB = null;
    private RelativeLayout mParent = null;
    private String aNP = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNQ = 0;
    private int hzC = 0;
    private WriteImagesInfo hzD = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hzF = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hzG = null;
    private ScrollView hyZ = null;
    private EditText hzH = null;
    private View hzI = null;
    private View hzJ = null;
    private View hzK = null;
    private EditText hzL = null;
    private TextView hzM = null;
    private TextView hzN = null;
    private TextWatcher hzO = null;
    private TextWatcher hzP = null;
    private boolean hza = false;
    private boolean hzQ = false;
    private com.baidu.tbadk.core.view.a aVY = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hzR = null;
    private TbImageView hzS = null;
    private View hzT = null;
    private Dialog hzU = null;
    private LinearLayout hzV = null;
    private boolean hzX = false;
    private long hzY = -1000;
    private boolean hzZ = false;
    private String dHS = "2";
    private int htH = 0;
    private String hAd = "";
    private SpannableStringBuilder hzd = new SpannableStringBuilder();
    private boolean hAe = false;
    private boolean hzf = false;
    private final b hzg = new b();
    private final HttpMessageListener hAg = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eYk)) {
                    WriteActivity.this.eYk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nC(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eYk)) {
                    WriteActivity.this.eYk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eYk);
                    WriteActivity.this.nC(true);
                }
            }
        }
    };
    private TbFaceManager.a hzi = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a dnr = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.aro));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.aro));
        }
    };
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.auA();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hzg.az(null);
                if (z) {
                    WriteActivity.this.bL(z);
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
                        if (!w.z(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hAd)) {
                            TiebaStatic.log(new an("c11731").ae(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hAd));
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
                    WriteActivity.this.hzg.az(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hzg.vz(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hzg.b(WriteActivity.this.gDt, WriteActivity.this.gDx);
                } else if ((uVar == null || writeData == null || uVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (uVar != null && writeData != null && uVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(uVar.getVcode_md5());
                    writeData.setVcodeUrl(uVar.getVcode_pic_url());
                    writeData.setVcodeExtra(uVar.Cs());
                    if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr());
                        if (WriteActivity.this.hzu) {
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
    private final LocationModel.a aNX = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ij() {
            WriteActivity.this.showToast(f.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(f.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwK())) {
                WriteActivity.this.b(2, true, aVar.bwK());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gQk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aNK.mw(false);
                    WriteActivity.this.aNK.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aNK.mw(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hzj = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hzk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHs = WriteActivity.this.bHs();
            if (bHs >= 0 && bHs < WriteActivity.this.gDx.getText().length()) {
                WriteActivity.this.gDx.setSelection(bHs);
            }
        }
    };
    private boolean hzl = true;
    private final View.OnFocusChangeListener gDr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gDt || view == WriteActivity.this.aAW || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hzl = true;
                    WriteActivity.this.bHt();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gDt);
                    if (WriteActivity.this.aMi != null) {
                        WriteActivity.this.aMi.FP();
                    }
                } else if (view == WriteActivity.this.gDt) {
                    WriteActivity.this.gDy.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gDx && z) {
                WriteActivity.this.hzl = false;
                WriteActivity.this.bHt();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gDx);
                if (WriteActivity.this.aMi != null) {
                    WriteActivity.this.aMi.FP();
                }
            }
            WriteActivity.this.bHz();
        }
    };
    private TextWatcher hzm = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hzq = "";
        private String hzr;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzr = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzr != null ? this.hzr.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brU();
            WriteActivity.this.bHA();
            EditText bHL = WriteActivity.this.bHL();
            if (editable != null && bHL != null && bHL.getText() != null) {
                if (this.hzq == null || !this.hzq.equals(editable.toString())) {
                    if (WriteActivity.this.hzg != null) {
                        this.hzq = bHL.getText().toString();
                        WriteActivity.this.hzg.k(bHL);
                        return;
                    }
                    return;
                }
                bHL.setSelection(bHL.getSelectionEnd());
            }
        }
    };
    private TextWatcher hzn = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hzr;
        private String hzs = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzr = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzr != null ? this.hzr.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brU();
            EditText bHK = WriteActivity.this.bHK();
            if (editable != null && bHK != null && bHK.getText() != null) {
                if (this.hzs == null || !this.hzs.equals(editable.toString())) {
                    if (WriteActivity.this.hzg != null) {
                        this.hzs = bHK.getText().toString();
                        WriteActivity.this.hzg.k(bHK);
                        return;
                    }
                    return;
                }
                bHK.setSelection(bHK.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0234a fGQ = new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
            WriteActivity.this.eYk = null;
            WriteActivity.this.nC(false);
            WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
            showToast(f.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNK.bwS()) {
            HU();
        } else {
            this.aNK.mw(false);
            b(1, true, null);
            this.aNK.bwQ();
        }
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(f.j.location_app_permission_prompt).a(f.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aNK.afW();
                } else {
                    WriteActivity.this.aNX.Ij();
                }
                aVar2.dismiss();
            }
        }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHs() {
        int selectionEnd = bHK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHK().getText().getSpans(0, bHK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHt() {
        if (this.aMi != null) {
            this.aMi.setBarLauncherEnabled(!this.hzl);
            this.aMi.setBarLauncherEnabled(true, 26);
            this.aMi.setBarLauncherEnabled(true, 2);
            J(9, this.hzl ? false : true);
        }
    }

    private void J(int i, boolean z) {
        com.baidu.tbadk.editortools.g eK;
        if (this.aMi != null && (eK = this.aMi.eK(i)) != null) {
            if (z) {
                eK.oC();
            } else {
                eK.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hza) {
            this.gDt.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hzK.setVisibility(8);
            } else {
                this.hzK.setVisibility(0);
            }
            a(this.hzN, this.hzH);
            a(this.hzM, this.hzL);
            brU();
        }
        if (this.hzt) {
            this.hzl = true;
            bHt();
            if (this.aMi != null) {
                this.aMi.FP();
            }
            this.gDt.requestFocus();
            ShowSoftKeyPadDelay(this.gDt);
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
            bIj();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bHT();
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
            vH(this.htH);
        }
        initUI();
        bHY();
        this.aNK = new LocationModel(this);
        this.aNK.a(this.aNX);
        registerListener(this.gQk);
        registerListener(this.hzj);
        initEditor();
        bIl();
        if (this.hza) {
            this.hzG.setEditorTools(this.aMi);
        } else {
            this.gDx.requestFocus();
        }
        bob();
        bHT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMi = new EditorTools(getActivity());
        this.aMi.setBarMaxLauCount(5);
        this.aMi.setMoreButtonAtEnd(true);
        this.aMi.setBarLauncherType(1);
        this.aMi.bD(true);
        this.aMi.bE(true);
        this.aMi.setMoreLauncherIcon(f.C0146f.write_more);
        this.aMi.setBackgroundColorId(f.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bHW();
                break;
            default:
                bHu();
                break;
        }
        this.aMi.Hu();
        if (this.hyI != null) {
            this.hyI.addView(this.aMi);
        }
        bHv();
        this.aMi.oC();
        com.baidu.tbadk.editortools.g eK = this.aMi.eK(6);
        if (eK != null && !TextUtils.isEmpty(this.aNP)) {
            ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aNP);
                }
            });
        }
        if (!this.hza) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMi.FP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bHx();
    }

    private void bHU() {
        this.hzI = this.mRootView.findViewById(f.g.photo_live_scroll);
        this.hzK = this.hzI.findViewById(f.g.live_post_title_container);
        this.hzH = (EditText) this.hzI.findViewById(f.g.live_post_content);
        this.hzF = (GridView) this.hzI.findViewById(f.g.photoLiveGridView);
        this.hzL = (EditText) this.hzI.findViewById(f.g.live_post_title);
        this.hzM = (TextView) this.hzI.findViewById(f.g.titleOverPlusNumber);
        this.hzN = (TextView) this.hzI.findViewById(f.g.contentOverPlusNumber);
        this.hzJ = this.hzI.findViewById(f.g.live_interval_view);
        this.hzM.setText(String.valueOf(20));
        this.hzN.setText(String.valueOf(233));
        this.hzI.setVisibility(0);
        this.hzM.setVisibility(0);
        this.hzN.setVisibility(0);
        this.hzL.setHint(f.j.tips_title_limit_new);
        this.hzL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hzQ = true;
                    WriteActivity.this.hzl = true;
                    WriteActivity.this.bHt();
                    if (WriteActivity.this.aMi != null) {
                        WriteActivity.this.aMi.FP();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hzH.setHint(f.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hzH.setHint(f.j.live_write_input_content_update);
        }
        this.hzH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hzQ = false;
                    WriteActivity.this.hzl = false;
                    WriteActivity.this.bHt();
                    if (WriteActivity.this.aMi != null) {
                        WriteActivity.this.aMi.FP();
                    }
                }
            }
        });
        this.hzH.requestFocus();
        this.hzH.addTextChangedListener(bIa());
        this.hzL.requestFocus();
        this.hzL.addTextChangedListener(bIa());
        this.hzL.setOnClickListener(this.hzk);
        this.hzH.setOnClickListener(this.hzk);
        this.hzG = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hzF);
        this.hzG.vB(6);
        this.hzF.setAdapter((ListAdapter) this.hzG);
        View findViewById = this.hzI.findViewById(f.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHd() {
                WriteActivity.this.bIh();
            }
        });
        bHV();
    }

    private void bHV() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hzL.setText(this.mData.getTitle());
                this.hzL.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hza) {
            bIf();
        }
        if (this.aMi.Hw()) {
            this.aMi.FP();
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
            albumActivityConfig.setCallFrom(this.dHS);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bHW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aMi.F(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMi.eN(5);
        if (eN != null) {
            eN.aMR = 2;
            eN.aMP = f.C0146f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aMP = f.C0146f.write_at;
        this.aMi.b(aVar);
        this.aMi.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bHu() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aMP = f.C0146f.write_picture;
        this.aMi.b(dVar);
        Boolean bId = bId();
        if (!this.hzt && bId != null && bId.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bxr() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aMR = 3;
            kVar5.aMP = f.C0146f.write_recorder;
            this.aMi.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aMP = f.C0146f.icon_post_topic_selector;
        this.aMi.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aMR = 5;
            kVar4.aMP = f.C0146f.write_privilege;
            this.aMi.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aMR = 6;
            kVar3.aMP = this.hzt ? f.C0146f.write_location : f.C0146f.icon_post_more_location;
            this.aMi.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aMP = f.C0146f.icon_post_more_at;
        this.aMi.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aMT = true;
            kVar2.aMR = 9;
            kVar2.aMP = 0;
            this.aMi.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aMT = true;
            kVar.aMR = 10;
            kVar.aMP = 0;
            this.aMi.b(kVar);
        }
        if (this.hyO == null) {
            if (this.hze == null) {
                this.hze = new com.baidu.tieba.write.editor.b(getActivity(), this.dHS);
                this.hze.aP(this.mData.getForumId(), this.privateThread);
            }
            this.aMi.b(this.hze);
        }
        this.aMi.F(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMi.eN(5);
        if (eN != null) {
            eN.aMR = 1;
            eN.aMP = f.C0146f.write_emotion;
        }
    }

    private void bHw() {
        if (this.hzh != null) {
            this.hzh.hideTip();
        }
    }

    private void bHx() {
        if (this.hzh == null) {
            this.hzh = new e(getPageContext());
        }
        this.hzh.c(this.aMi);
    }

    private void bHv() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bHJ()) {
                            WriteActivity.this.showToast(f.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bHJ()) {
                            WriteActivity.this.showToast(f.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bHM();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bbX();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIj();
                        WriteActivity.this.brU();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vI(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hyO == null) {
                            WriteActivity.this.HY();
                            return;
                        }
                        switch (WriteActivity.this.aNQ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
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
                        if (WriteActivity.this.aNK != null) {
                            WriteActivity.this.aNK.mw(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eYk = null;
                        } else {
                            WriteActivity.this.eYk = (String) aVar.data;
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
                        anVar.ae(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aMi.Hw()) {
                                        WriteActivity.this.aMi.FP();
                                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(f.j.plugin_video_not_active), WriteActivity.this.getResources().getString(f.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(f.j.plugin_video_install_tips), WriteActivity.this.getResources().getString(f.j.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.brU();
                        if (WriteActivity.this.gDx != null) {
                            WriteActivity.this.gDx.requestFocus();
                        }
                        WriteActivity.this.aMi.FP();
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDx);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hyG = true;
                        WriteActivity.this.nA(true);
                        if (WriteActivity.this.bHL().isFocused()) {
                            WriteActivity.this.hyF = "from_title";
                        } else if (WriteActivity.this.bHK().isFocused()) {
                            WriteActivity.this.hyF = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hyJ.setVisibility(0);
                        WriteActivity.this.hyJ.requestFocus();
                        WriteActivity.this.brU();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hyJ.hasFocus()) {
                            WriteActivity.this.gDx.requestFocus();
                            WriteActivity.this.gDx.setSelection(WriteActivity.this.gDx.getText().toString().length());
                        }
                        WriteActivity.this.hyJ.setVisibility(8);
                        WriteActivity.this.brU();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aMi.setActionListener(16, bVar);
        this.aMi.setActionListener(14, bVar);
        this.aMi.setActionListener(24, bVar);
        this.aMi.setActionListener(3, bVar);
        this.aMi.setActionListener(10, bVar);
        this.aMi.setActionListener(11, bVar);
        this.aMi.setActionListener(12, bVar);
        this.aMi.setActionListener(13, bVar);
        this.aMi.setActionListener(15, bVar);
        this.aMi.setActionListener(18, bVar);
        this.aMi.setActionListener(20, bVar);
        this.aMi.setActionListener(25, bVar);
        this.aMi.setActionListener(27, bVar);
        this.aMi.setActionListener(29, bVar);
        this.aMi.setActionListener(43, bVar);
        this.aMi.setActionListener(45, bVar);
        this.aMi.setActionListener(53, bVar);
        this.aMi.setActionListener(48, bVar);
        this.aMi.setActionListener(46, bVar);
        this.aMi.setActionListener(49, bVar);
        this.aMi.setActionListener(47, bVar);
        this.aMi.setActionListener(55, bVar);
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
        if (this.aNK.afS()) {
            if (this.aNK.bwS()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwO().getLocationData().bwK());
                return;
            }
            b(1, true, null);
            this.aNK.bwQ();
            return;
        }
        b(0, true, null);
    }

    protected void brM() {
        if (this.aNL != null) {
            this.aNL.cancelLoadData();
        }
        if (this.hyK != null) {
            this.hyK.cancelLoadData();
        }
        if (this.aNK != null) {
            this.aNK.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bHw();
        TiebaPrepareImageService.StopService();
        brM();
        bIc();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hzE != null) {
            this.hzE.destroy();
        }
        if (this.hAf != null) {
            this.hAf.akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.mData != null && this.mData.getType() == 2 && this.hzA) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bHL().getText().toString());
            this.mData.setContent(bHK().getText().toString());
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
            if (this.gDz != null && this.gDz.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gDz, getPageContext().getPageActivity());
                return true;
            } else if (this.aMi.Hw()) {
                this.aMi.FP();
                return true;
            } else {
                brM();
                bHy();
                return true;
            }
        }
        if (i == 67 && (text = bHK().getText()) != null) {
            int selectionStart = bHK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHK().onKeyDown(67, this.cVg);
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
        getLayoutMode().onModeChanged(this.hzV);
        if (this.hzS != null && i == 1) {
            this.hzS.setBorderColor(am.getColor(f.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.c(this.mPost, f.d.cp_link_tip_a, 1);
        bHt();
        am.j(this.hzI, f.d.cp_bg_line_d);
        am.j(this.gDu, f.d.cp_bg_line_c);
        am.j(this.hzJ, f.d.cp_bg_line_c);
        am.j(bHL(), f.d.cp_bg_line_d);
        am.c(this.fAb, f.C0146f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eYk)) {
            am.j(bHK(), f.d.cp_bg_line_d);
        }
        brU();
        this.aMi.onChangeSkinType(i);
        if (this.hyY != null) {
            this.hyY.AD();
        }
        am.h(this.mName, f.d.cp_cont_b);
        bHz();
        bHA();
        if (this.hzg != null) {
            this.hzg.c(bHL(), bHK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHz() {
        if (this.gDt.hasFocus()) {
            this.gDt.setHintTextColor(am.getColor(f.d.cp_cont_e));
        } else {
            this.gDt.setHintTextColor(am.getColor(f.d.cp_cont_d));
        }
        if (this.gDx.hasFocus()) {
            this.gDx.setHintTextColor(am.getColor(f.d.cp_cont_e));
        } else {
            this.gDx.setHintTextColor(am.getColor(f.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHA() {
        if (this.gDt != null && this.gDt.getText() != null && this.gDt.getText().toString() != null && this.gDt.getPaint() != null) {
            if (this.gDt.getText().toString().length() == 0) {
                this.gDt.getPaint().setFakeBoldText(false);
            } else if (this.gDt.getText().toString().length() > 0) {
                this.gDt.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hza = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(f.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.icon_topbar_close, f.C0146f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, f.d.cp_cont_b);
        this.hzy = (TextView) findViewById(f.g.btn_image_problem);
        bHC();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), f.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gDr);
        this.hyZ = (ScrollView) findViewById(f.g.write_scrollview);
        this.hyZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gDx != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gDx);
                    }
                    if (WriteActivity.this.aMi != null) {
                        WriteActivity.this.aMi.FP();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hzw = (FeedBackTopListView) findViewById(f.g.feedback_top_list);
        this.hzx = findViewById(f.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(f.g.parent);
        this.hyI = (LinearLayout) findViewById(f.g.tool_view);
        this.hyI.setContentDescription("..");
        this.hyJ = (LinearLayout) findViewById(f.g.title_view);
        this.gDu = findViewById(f.g.interval_view);
        this.hAa = findViewById(f.g.hot_topic_fourm_view);
        this.hAb = findViewById(f.g.hot_topic_divider);
        this.hzc = (TextView) findViewById(f.g.hot_topic_title_edt);
        this.hAc = (TextView) findViewById(f.g.change_one_tv);
        brT();
        if (this.hza) {
            this.hyZ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bHU();
        } else {
            this.hzE = new g(getPageContext(), this.mRootView);
            g gVar = this.hzE;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nv(z);
        }
        brV();
        if (this.hzt || this.hyH) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().arY) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(f.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(f.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gDw = (LinearLayout) findViewById(f.g.post_content_container);
        this.gDw.setDrawingCacheEnabled(false);
        this.gDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gDx.requestFocus();
            }
        });
        this.fzY = (LinearLayout) findViewById(f.g.layout_voice_play);
        this.fzZ = (PlayVoiceBntNew) findViewById(f.g.btn_play_voice);
        this.fAb = (ImageView) findViewById(f.g.iv_delete_voice);
        this.fAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bbX();
            }
        });
        this.aAW.setOnFocusChangeListener(this.gDr);
        this.aAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.brM();
                WriteActivity.this.bHy();
            }
        });
        this.hzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bHF();
        j(bId());
        bHH();
        bHB();
        bHZ();
        bIb();
        bHt();
        bHG();
        brS();
        bHN();
        if (this.mData.getType() == 4 && this.gDB != null && this.hyL != null) {
            this.gDB.setVisibility(8);
            this.hyL.setVisibility(8);
        }
        brU();
        bHX();
    }

    private void bHB() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hzt || this.hyH) {
                        if (this.hzu) {
                            this.mName.setText(f.j.feedback_vcode);
                        } else {
                            this.mName.setText(f.j.feedback);
                        }
                    } else if (this.dHS != null && this.dHS.equals("1")) {
                        this.mName.setText(f.j.post_to_home_page);
                    } else if (this.dHS != null && this.dHS.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(f.j.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(f.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(f.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gDt.setVisibility(0);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(f.j.send_reply);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gDt.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(f.j.publish_photo_live);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(f.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hzJ.setVisibility(8);
                    return;
                case 7:
                    this.gDt.setVisibility(0);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(f.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bHC() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.send_post));
    }

    private void bHD() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hzt && !this.hyH && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ap.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bHL() != null) {
                bHL().setText(c);
                bHL().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fzY.setVisibility(0);
            this.fzZ.setVoiceModel(voiceModel);
            this.fzZ.bxq();
            brU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbX() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fzY.setVisibility(8);
        this.fzZ.aFA();
        this.fzZ.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eN = this.aMi.eN(6);
        if (eN != null && eN.aMc != null) {
            eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        brU();
    }

    private void bHE() {
        this.hyT = null;
        this.hyV = -1;
        this.hyX = -1;
        z kE = y.avH().kE(1);
        if (kE != null) {
            this.hyT = kE.dpw;
            this.hyV = getIntent().getIntExtra("category_id", -1);
            if (this.hyT != null && !this.hyT.isEmpty() && this.hyV >= 0) {
                this.hyU = new x();
                this.hyU.dps = 0;
                this.hyU.name = getPageContext().getResources().getString(f.j.category_auto);
                this.hyX = this.hyU.dps;
                this.hyW = this.hyU.name;
                for (x xVar : this.hyT) {
                    if (xVar.dps == this.hyV) {
                        this.hyX = xVar.dps;
                        this.hyW = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHF() {
        if (this.hyT != null && !this.hyT.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(f.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(f.g.interval_view_cate).setVisibility(0);
            this.hyY = (PostCategoryView) linearLayout.findViewById(f.g.category_selected);
            this.hyY.setText(this.hyW);
            this.hyY.setCategoryContainerData(this.hyT, this.hyU, this.hyX);
            this.hyY.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hyY.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dps);
                        WriteActivity.this.hyX = atVar.dps;
                        WriteActivity.this.hyY.bHg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hyY.bHf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                }
            });
        }
    }

    private void bHX() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hzo = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hzo.setTitle(f.j.no_disturb_start_time);
        this.hzo.setButton(-1, getPageContext().getString(f.j.alert_yes_button), this.hzo);
        this.hzo.setButton(-2, getPageContext().getString(f.j.cancel), this.hzo);
        return this.hzo;
    }

    private void bHG() {
        this.hyP = (RelativeLayout) findViewById(f.g.addition_container);
        this.hyQ = (TextView) findViewById(f.g.addition_create_time);
        this.hyR = (TextView) findViewById(f.g.addition_last_time);
        this.hyS = (TextView) findViewById(f.g.addition_last_content);
        if (this.hyO != null) {
            this.hyP.setVisibility(0);
            this.hyQ.setText(getPageContext().getString(f.j.write_addition_create) + ap.w(this.hyO.getCreateTime() * 1000));
            if (this.hyO.getAlreadyCount() == 0) {
                this.hyR.setVisibility(8);
            } else {
                this.hyR.setText(getPageContext().getString(f.j.write_addition_last) + ap.w(this.hyO.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hyO.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hyS.setText(lastAdditionContent);
            } else {
                this.hyS.setVisibility(8);
            }
            bHK().setHint(String.format(getPageContext().getString(f.j.write_addition_hint), Integer.valueOf(this.hyO.getAlreadyCount()), Integer.valueOf(this.hyO.getTotalCount())));
            this.mName.setText(f.j.write_addition_title);
            return;
        }
        this.hyP.setVisibility(8);
    }

    private void brS() {
        this.gDB = findViewById(f.g.post_prefix_layout);
        if (this.hAf == null) {
            this.hAf = new com.baidu.tieba.c.d(getPageContext(), this.gDB);
            this.hAf.jo(f.C0146f.bg_tip_blue_up_left);
            this.hAf.jn(16);
            this.hAf.eL(true);
            this.hAf.C(true);
            this.hAf.jr(l.f(getActivity(), f.e.ds32));
        }
        this.gDy = (TextView) findViewById(f.g.post_prefix);
        this.hyL = findViewById(f.g.prefix_divider);
        this.gDA = (ImageView) findViewById(f.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gDB.setVisibility(0);
            this.hAf.g(getString(f.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gDb = 0;
            this.gDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").ae(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gDy.setVisibility(0);
                    WriteActivity.this.gDB.setSelected(true);
                    am.c(WriteActivity.this.gDA, f.C0146f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gDz, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMi.FP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDt);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gDx);
                }
            });
            this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").ae(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gDy.setSelected(true);
                    am.c(WriteActivity.this.gDA, f.C0146f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gDz, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMi.FP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                }
            });
            this.gDz = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gDz.a(this);
            this.gDz.setMaxHeight(l.f(getActivity(), f.e.ds510));
            this.gDz.setOutsideTouchable(true);
            this.gDz.setFocusable(true);
            this.gDz.setOnDismissListener(this);
            this.gDz.setBackgroundDrawable(am.getDrawable(f.d.cp_bg_line_d));
            int color = am.getColor(f.d.cp_cont_b);
            am.getColor(f.d.cp_cont_c);
            am.i(this.gDy, f.d.cp_bg_line_d);
            am.c(this.gDA, f.C0146f.icon_arrow_gray_down);
            this.gDy.setTextColor(color);
            this.hyM.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hyM.add(writePrefixItemLayout);
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
                this.gDz.addView(writePrefixItemLayout);
            }
            this.gDz.setCurrentIndex(0);
            this.gDy.setText(prefixs.get(0));
            vG(0);
            return;
        }
        this.gDB.setVisibility(8);
    }

    private void bHY() {
        if (this.hzt && this.mData != null) {
            this.hzw.setVisibility(0);
            this.hzx.setVisibility(0);
            this.hyK = new FeedBackModel(getPageContext());
            this.hyK.vS(this.mData.getForumName());
            this.hyK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hzw.setVisibility(8);
                        WriteActivity.this.hzx.setVisibility(8);
                        WriteActivity.this.showToast(f.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hzw.setVisibility(8);
                        WriteActivity.this.hzx.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hzw.a(feedBackModel.bHi(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bHH() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    WriteActivity.this.showToast(f.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hzg.a(WriteActivity.this.gDt, WriteActivity.this.gDx)) {
                        WriteActivity.this.showToast(WriteActivity.this.hzg.bFr());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                    WriteActivity.this.aMi.FP();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hzt) {
                            WriteActivity.this.bHQ();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.bHR();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bHQ();
                    }
                    TiebaStatic.log(new an("c12262").ae("obj_locate", WriteActivity.this.dHS));
                }
            }
        });
    }

    protected void bHZ() {
        this.hzz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hzz.dB(getPageContext().getString(f.j.is_save_draft)).av(false).a(getPageContext().getString(f.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bHL().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bHK().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(f.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(f.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
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
        this.hzz.b(getPageContext());
    }

    protected void brT() {
        this.hzv = (HeadImageView) findViewById(f.g.user_head_portrait);
        this.hzv.setIsRound(true);
        this.hzv.setDrawBorder(false);
        this.hzv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ev = com.baidu.tbadk.core.util.p.ev(currentPortrait);
            this.hzv.setUrl(ev);
            this.hzv.startLoad(ev, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hzv.setVisibility(0);
        }
        this.gDt = (EditText) findViewById(f.g.post_title);
        this.gDt.setOnClickListener(this.hzk);
        this.gDt.setOnFocusChangeListener(this.gDr);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gDt.setText(this.mData.getTitle());
                this.gDt.setSelection(this.mData.getTitle().length());
            } else if (this.hzu) {
                this.gDt.setText(getResources().getString(f.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gDt.addTextChangedListener(this.hzm);
        if (!this.mData.getHaveDraft()) {
            bHD();
            this.hzZ = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gDt.setHint(getResources().getString(f.j.feedback_title_hint));
        } else {
            this.gDt.setHint(getResources().getString(f.j.post_title_hint));
        }
    }

    private TextWatcher bIa() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hAj;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.brU();
                if (WriteActivity.this.hza) {
                    this.hAj = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hAj);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hza || !WriteActivity.this.hzQ) {
                    if (WriteActivity.this.hza) {
                        if (this.mEditText != WriteActivity.this.hzH || this.mTextView != WriteActivity.this.hzN) {
                            this.mEditText = WriteActivity.this.hzH;
                            this.mTextView = WriteActivity.this.hzN;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hzL || this.mTextView != WriteActivity.this.hzM) {
                    this.mEditText = WriteActivity.this.hzL;
                    this.mTextView = WriteActivity.this.hzM;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hza && this.hzQ) {
            if (this.hzO != null) {
                this.hzL.removeTextChangedListener(this.hzO);
            }
            this.hzO = textWatcher;
        } else if (this.hza) {
            if (this.hzP != null) {
                this.hzH.removeTextChangedListener(this.hzP);
            }
            this.hzP = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hzH) {
            return 233L;
        }
        if (editText != this.hzL) {
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
                    textView.setTextColor(am.getColor(f.d.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(f.d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(f.d.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(f.d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.h(editText.getText().toString().trim());
    }

    protected void brV() {
        this.gDx = (EditText) findViewById(f.g.post_content);
        this.gDx.setDrawingCacheEnabled(false);
        this.gDx.setOnClickListener(this.hzk);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gDx.setText(W);
            this.gDx.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hzA) {
                if (this.hzB != null && this.hzB.length() > 0) {
                    this.gDx.setText(getPageContext().getPageActivity().getString(f.j.reply_sub_floor, new Object[]{this.hzB}));
                    this.gDx.setSelection(this.gDx.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(f.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gDx.setText(format);
                this.gDx.setSelection(format.length());
            }
        }
        this.gDx.setOnFocusChangeListener(this.gDr);
        this.gDx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gDx.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDx.addTextChangedListener(this.hzn);
        if (this.mData.getType() == 0) {
            this.hAe = true;
        } else {
            nC(true);
            this.hAe = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gDx.setHint(f.j.write_input_content);
        } else {
            this.gDx.setHint(f.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nC(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hza) {
            bHK().setPadding(0, 0, 0, 0);
            bHK().setBackgroundDrawable(null);
            am.j(bHK(), f.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eYk) && this.hyO == null) {
                com.baidu.adp.lib.f.c.ih().a(this.eYk, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bHK().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bHK(), true, WriteActivity.this.fGQ);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHJ() {
        int i = 5000;
        if (this.hyO != null) {
            i = 1000;
        }
        return bHK().getText() != null && bHK().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hyF)) {
                this.hyF = "";
                bHK().requestFocus();
                if (bHK().getText() != null && bHK().getText().length() + str.length() > 5000) {
                    showToast(f.j.over_limit_tip);
                    return;
                } else {
                    i = bHK().getSelectionStart();
                    editable = bHK().getText();
                }
            } else if ("from_title".equals(this.hyF)) {
                this.hyF = "";
                bHL().requestFocus();
                if (bHL().getText() != null && bHL().getText().length() + str.length() > 31) {
                    showToast(f.j.over_limit_tip);
                    return;
                } else {
                    i = bHL().getSelectionStart();
                    editable = bHL().getText();
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
        if (((ImageSpan[]) bHK().getText().getSpans(0, bHK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hyN == null) {
                this.hyN = Toast.makeText(getPageContext().getPageActivity(), f.j.too_many_face, 0);
            }
            this.hyN.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ci = nVar.Ci();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ih().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bHK().getSelectionStart(), aVar, Ci);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHK() != null && bHK().getText() != null) {
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
                int selectionStart = bHK().getSelectionStart() - 1;
                if (bHK().getText().length() > 1 && selectionStart >= 0 && bHK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHK().getText().insert(bHK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHK().getText().insert(bHK().getSelectionStart(), spannableString2);
            }
            Editable text = bHK().getText();
            if (text != null) {
                this.hzd.clear();
                this.hzd.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzd);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHK() {
        return this.hza ? this.hzH : this.gDx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHL() {
        return this.hza ? this.hzL : this.gDt;
    }

    protected void bHM() {
        Editable text;
        if (bHK() != null && (text = bHK().getText()) != null) {
            int selectionStart = bHK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHK().onKeyDown(67, this.cVg);
            }
            bHK().onKeyDown(67, this.cVg);
            int selectionStart2 = bHK().getSelectionStart();
            if (text != null) {
                this.hzd.clear();
                this.hzd.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzd);
                bHK().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(f.j.feedback_bar_name).equals(str)) {
            this.hzt = true;
        }
    }

    private void bIb() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIc() {
        try {
            if (this.hzz != null) {
                this.hzz.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVY.d(null);
        this.aVY.df(f.j.sending);
        this.aVY.aN(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVY.aN(false);
    }

    private Boolean bId() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aNP = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brU() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHL() != null) {
                str = bHL().getText().toString();
            }
            if (bHK() != null) {
                str2 = bHK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gDb == w.y(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hyJ.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nB(true);
                            return;
                        }
                    } else if (this.hyJ.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nB(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hyJ.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nB(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hza) {
                    nB(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nB(true);
                }
            }
            if (this.mData.getType() == 4) {
                nB(o(this.hzH) && n(this.hzL));
            } else if (this.mData.getType() == 5) {
                nB(o(this.hzH));
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
            am.b(this.mPost, f.d.cp_link_tip_a, f.d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        am.c(this.mPost, f.d.cp_cont_d, 1);
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
        this.aNL = new NewWriteModel(this);
        this.aNL.b(this.aNZ);
        registerListener(this.hAg);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.brM();
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
            this.hzt = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hzu = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hzA = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hzB = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aNJ = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hyO = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hyO != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hzC = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hAd = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.dHS = bundle.getString("KEY_CALL_FROM");
            this.htH = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hzt = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hzu = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hzA = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hzB = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hyO = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hyO != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hzC = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hAd = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.dHS = intent.getStringExtra("KEY_CALL_FROM");
            this.htH = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hzt);
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
            this.mPrefixData.getPrefixs().add(getPageContext().getString(f.j.write_no_prefix));
        }
        this.eYk = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hyH = true;
        }
        bHE();
        try {
            this.hzR = bIk();
        } catch (Throwable th) {
            this.hzR = null;
        }
    }

    private void bHN() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gDt.setText(com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName)));
            this.gDt.setMovementMethod(com.baidu.tieba.view.c.bEt());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) w.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString hp = com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName));
            if (hp != null) {
                this.gDt.setText(hp);
            }
            this.hzc.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String hq;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bHL().getText().toString()) || this.hzZ || ((this.hzt || this.hyH) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            bHL().setText(hp);
                            bHL().setSelection(hp.length() > hq.length() ? hq.length() : hp.length());
                        }
                    } else {
                        SpannableString hp2 = com.baidu.tbadk.plugins.b.hp(this.mData.getTitle());
                        if (hp2 != null) {
                            bHL().setText(hp2);
                            bHL().setSelection(this.mData.getTitle().length() > hp2.length() ? hp2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bHD();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bHK().getText().toString()) || this.hzt || this.hyH) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.IP().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hzi);
                    bHK().setText(a2);
                    bHK().setSelection(a2.length());
                    if (this.hza) {
                        a(this.hzN, this.hzH);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIj();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bHT();
                    }
                    nD(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIe();
                }
                brU();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hyT != null) {
                    this.hyX = this.hyU.dps;
                    this.hyW = this.hyU.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hyT.size()) {
                            break;
                        }
                        x xVar = this.hyT.get(i);
                        if (categoryTo != xVar.dps) {
                            i++;
                        } else {
                            this.hyX = categoryTo;
                            this.hyW = xVar.name;
                            this.mData.setCategoryTo(this.hyX);
                            break;
                        }
                    }
                    if (this.hyY != null) {
                        this.hyY.setText(this.hyW);
                        this.hyY.setCategoryContainerData(this.hyT, this.hyU, this.hyX);
                    }
                }
                this.aMi.FP();
                return;
            }
            return;
        }
        bIe();
        bHD();
    }

    private void bIe() {
        if ((!this.hza || this.hzG != null) && this.hzF != null) {
            this.hzG.c(this.writeImagesInfo);
            bIh();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hzA);
        if (this.hzt) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aNJ);
        if (this.hyO != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hyO));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hzC);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dHS);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.htH);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHK().getEditableText().toString();
        if (obj != null) {
            bHK().setText(TbFaceManager.IP().a(getPageContext().getPageActivity(), obj, this.hzi));
            bHK().setSelection(bHK().getText().length());
        }
    }

    private String bHO() {
        return (bHK() == null || bHK().getText() == null) ? "" : bHK().getText().toString();
    }

    private String bHP() {
        if (this.mData == null || bHL() == null || bHL().getVisibility() != 0 || bHL().getText() == null) {
            return "";
        }
        String obj = bHL().getText().toString();
        if (this.mPrefixData != null && w.y(this.mPrefixData.getPrefixs()) > 0 && this.gDb != w.y(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gDy != null && this.gDy.getText() != null) {
            this.mData.setPostPrefix(this.gDy.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void vT(String str) {
        if (this.mData != null && this.hyJ != null) {
            if (this.hyJ.getVisibility() == 0) {
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
    public void bHQ() {
        brM();
        this.mData.setContent(bHO());
        vT(bHP());
        if (this.hzt || this.hyH) {
            String string = getResources().getString(f.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                vT(string + this.mData.getTitle());
            }
            String str = getResources().getString(f.j.app_name) + getResources().getString(f.j.tieba_client);
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
        if (this.hyV >= 0) {
            this.mData.setCategoryFrom(this.hyV);
        }
        if (this.hyX >= 0) {
            this.mData.setCategoryTo(this.hyX);
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
        this.mData.setHasLocationData(this.aNK != null && this.aNK.afS());
        if (this.writeImagesInfo != null) {
            this.aNL.my(this.writeImagesInfo.size() > 0);
        }
        if (!w.z(this.mList) && this.hzb != null && this.hzb.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hzb.mForumId));
            this.mData.setForumName(this.hzb.mForumName);
        }
        this.aNL.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aNL.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aNL.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aNL.getWriteData().setVoice(null);
                this.aNL.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aNL.getWriteData().setVoice(null);
            this.aNL.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aNL.bxs()) {
            showToast(f.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(f.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(f.j.sending), this.mDialogCancelListener);
            this.aNL.startPostWrite();
        }
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hyO != null) {
                i2 = this.hyO.getTotalCount();
                i = this.hyO.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(f.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.gDt == getCurrentFocus()) {
                    bHK().clearFocus();
                    this.gDt.requestFocus();
                    if (this.aMi != null) {
                        this.aMi.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDt);
                } else {
                    bHK().requestFocus();
                    if (this.aMi != null) {
                        this.aMi.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDx);
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
                            bHK().getText().insert(bHK().getSelectionStart(), sb.toString());
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
                                bIi();
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
                        if (this.hAe) {
                            nC(true);
                            this.hAe = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hza) {
                        A(intent);
                        brU();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aMi.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    brU();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hyG) {
                                sb2.append(com.baidu.tbadk.plugins.b.aVv);
                                this.hyG = false;
                            }
                            sb2.append(stringExtra);
                            gG(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !w.z(this.mList) && !w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hzb = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hzb);
                }
            }
        } else if (i2 == 0) {
            if (this.aMi != null && !this.aMi.Hw()) {
                this.gDx.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aMi.FP();
            }
            switch (i) {
                case 12001:
                    Ib();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIg();
                    if (this.hAe) {
                        nC(true);
                        this.hAe = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gDt == getCurrentFocus()) {
                        bHK().clearFocus();
                        this.gDt.requestFocus();
                        if (this.aMi != null) {
                            this.aMi.FP();
                        }
                        ShowSoftKeyPadDelay(this.gDt);
                        return;
                    }
                    bHK().requestFocus();
                    if (this.aMi != null) {
                        this.aMi.FP();
                    }
                    ShowSoftKeyPadDelay(this.gDx);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hzg.vz(postWriteCallBackData.getErrorString());
                        this.hzg.az(postWriteCallBackData.getSensitiveWords());
                        this.hzg.b(this.gDt, this.gDx);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aNJ = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.aNJ);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIg();
                    return;
                case 25004:
                    if ("from_title".equals(this.hyF)) {
                        bHL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hyF)) {
                        bHK().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHR() {
        if ("1".equals(this.dHS)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dHS)) {
            this.mData.setCanNoForum(false);
        }
        bHS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.dHS);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHQ();
    }

    private void bHS() {
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIf() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIg() {
        if (this.hza) {
            this.hzG.c(this.writeImagesInfo);
            bIh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        this.hzG.notifyDataSetChanged();
        this.hzF.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hzG.notifyDataSetChanged();
                WriteActivity.this.hzF.invalidateViews();
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
        brU();
    }

    private void ae(Intent intent) {
        if (this.hza) {
            af(intent);
            bIg();
        } else {
            ai(intent);
        }
        brU();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIg();
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

    private void bIi() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hzD.parseJson(stringExtra);
            this.hzD.updateQuality();
            if (this.hzD.getChosedFiles() != null && this.hzD.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hzD.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hzD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHL());
        HidenSoftKeyPad(this.mInputManager, bHK());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aNJ = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aNJ;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aj(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aNJ, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIj();
            bHT();
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
                bIj();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bHT();
                }
            }
            nD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (this.aMi.eN(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Ib() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aNJ));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nD(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hzE != null) {
            this.hzE.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auA() {
        this.dmn = getVoiceManager();
        this.dmn.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dnr) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.aro));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(f.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hyO == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNQ = i;
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHT() {
        if (!this.hza) {
            if (this.aMi != null) {
                this.aMi.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aMi.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hzE != null) {
                this.hzE.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vG(int i) {
        if (i < this.hyM.size()) {
            for (int i2 = 0; i2 < this.hyM.size(); i2++) {
                this.hyM.get(i2).nr(false);
            }
            this.hyM.get(i).nr(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void th(int i) {
        if (i == w.y(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").r("obj_type", 2));
        }
        this.gDb = i;
        this.gDz.setCurrentIndex(i);
        vG(i);
        this.gDy.setText(this.mPrefixData.getPrefixs().get(i));
        brU();
        com.baidu.adp.lib.g.g.a(this.gDz, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gDB.setSelected(false);
        am.c(this.gDA, f.C0146f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gDx);
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
            if (ac.aN(getApplicationContext())) {
                al.a(getPageContext(), this.aNJ);
            } else {
                showToast(f.j.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(f.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hzf = z;
        if (this.hzX && System.currentTimeMillis() - this.hzY < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hzX = false;
        }
        if (this.hze != null && !z) {
            this.hze.aoX();
        }
        if (this.hzh != null && !z) {
            bHw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hzU != null) {
            vV(str);
            this.hzU.dismiss();
        }
    }

    private void cr(Context context) {
        hzW = l.aj(context);
    }

    private void vV(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(f.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hzX = true;
        bIj();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bHT();
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

    private File bIk() {
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

    private void bIl() {
        if (this.hzR != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cr(getActivity());
            this.hzT = getPageContext().getPageActivity().getLayoutInflater().inflate(f.h.rec_dialog, (ViewGroup) null);
            this.hzT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hzR != null) {
                        WriteActivity.this.vU(WriteActivity.this.hzR.getAbsolutePath());
                    }
                }
            });
            this.hzS = (TbImageView) this.hzT.findViewById(f.g.rec_img_view);
            this.hzV = (LinearLayout) this.hzT.findViewById(f.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hzR.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hzR.getAbsolutePath());
                Bitmap f = f(this.hzR.getAbsolutePath(), getResources().getDimensionPixelSize(f.e.ds160));
                if (f != null) {
                    this.hzS.setImageBitmap(f);
                    this.hzS.setDrawBorder(true);
                    this.hzS.setBorderWidth(2);
                    this.hzS.setBorderColor(am.getColor(f.d.common_color_10264));
                    this.hzU = new Dialog(getActivity(), f.k.bubble_dialog);
                    this.hzU.setCanceledOnTouchOutside(true);
                    this.hzU.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hzX) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hzY = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hzU.setContentView(this.hzT);
                    this.hzU.show();
                    Window window = this.hzU.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(f.e.ds28);
                    attributes.y = (hzW / 18) + getResources().getDimensionPixelSize(f.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(f.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(f.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(f.a.activity_open_from_bottom, f.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hzf && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hyG = false;
            this.hyF = "";
            if ("from_content".equals(str)) {
                this.hyF = "from_content";
            } else if ("from_title".equals(str)) {
                this.hyF = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ho(String.valueOf(charSequence.charAt(i)))) {
                nA(false);
            }
        }
    }

    public void bob() {
        if (this.hzt || !w.z(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hyJ.setVisibility(0);
            this.hyJ.requestFocus();
            this.aMi.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hyJ.setVisibility(8);
    }
}
