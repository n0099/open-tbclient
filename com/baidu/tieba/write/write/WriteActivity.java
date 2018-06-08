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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.x;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0061a, VoiceManager.c, t.a, d.a {
    private static int huD = 0;
    private EditorTools aLp;
    private String aMR;
    private LocationModel aMS;
    private NewWriteModel aMT;
    private VoiceManager dhB;
    private LinearLayout fvS;
    private PlayVoiceBntNew fvT;
    private ImageView fvV;
    private int gxX;
    private TextView gyu;
    private com.baidu.tieba.write.d gyv;
    private ImageView gyw;
    private View gyx;
    private TextView htA;
    List<v> htB;
    v htC;
    private int htD;
    private String htE;
    private int htF;
    private PostCategoryView htG;
    private HotTopicBussinessData htJ;
    private TextView htK;
    private com.baidu.tieba.write.editor.b htM;
    private e htP;
    private com.baidu.tieba.view.b htW;
    private LinearLayout htq;
    private LinearLayout htr;
    private View htt;
    private Toast htv;
    private AdditionData htw;
    private RelativeLayout htx;
    private TextView hty;
    private TextView htz;
    private View huH;
    private View huI;
    private TextView huJ;
    private com.baidu.tieba.c.d huM;
    private View huf;
    private g hum;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String htn = "";
    private boolean hto = false;
    private WriteData mData = null;
    private boolean hub = false;
    private boolean htp = false;
    private boolean huc = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gyp = null;
    private HeadImageView hud = null;
    private View gyq = null;
    private LinearLayout gys = null;
    private EditText gyt = null;
    private FeedBackModel hts = null;
    private FeedBackTopListView hue = null;
    private ArrayList<WritePrefixItemLayout> htu = new ArrayList<>();
    private String eVh = null;
    private final KeyEvent cUv = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aAn = null;
    private TextView hug = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a huh = null;
    private final Handler mHandler = new Handler();
    private boolean hui = false;
    private String huj = null;
    private RelativeLayout mParent = null;
    private String aMX = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aMY = 0;
    private int huk = 0;
    private WriteImagesInfo hul = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hun = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a huo = null;
    private ScrollView htH = null;
    private EditText hup = null;
    private View huq = null;
    private View hur = null;
    private View hus = null;
    private EditText hut = null;
    private TextView huu = null;
    private TextView huv = null;
    private TextWatcher huw = null;
    private TextWatcher hux = null;
    private boolean htI = false;
    private boolean huy = false;
    private com.baidu.tbadk.core.view.a aVb = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File huz = null;
    private TbImageView huA = null;
    private View mBubbleView = null;
    private Dialog huB = null;
    private LinearLayout huC = null;
    private boolean huE = false;
    private long huF = -1000;
    private boolean huG = false;
    private String gYa = "2";
    private int hoo = 0;
    private String huK = "";
    private SpannableStringBuilder htL = new SpannableStringBuilder();
    private boolean huL = false;
    private boolean htN = false;
    private final b htO = new b();
    private final HttpMessageListener huN = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eVh)) {
                    WriteActivity.this.eVh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nG(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eVh)) {
                    WriteActivity.this.eVh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eVh);
                    WriteActivity.this.nG(true);
                }
            }
        }
    };
    private TbFaceManager.a htQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ha(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.mZ());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.e(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a diC = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arj));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arj));
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.atG();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.htO.ax(null);
                if (z) {
                    WriteActivity.this.bJ(z);
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
                        if (!w.z(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.huK)) {
                            TiebaStatic.log(new am("c11731").ah(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.huK));
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
                    WriteActivity.this.htO.ax(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.htO.vy(postWriteCallBackData.getErrorString());
                    WriteActivity.this.htO.b(WriteActivity.this.gyp, WriteActivity.this.gyt);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Ck());
                    if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj());
                        if (WriteActivity.this.huc) {
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
    private final LocationModel.a aNf = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void HW() {
            WriteActivity.this.showToast(d.k.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.k.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxD())) {
                WriteActivity.this.b(2, true, aVar.bxD());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gLk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aMS.mA(false);
                    WriteActivity.this.aMS.cn(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aMS.mA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener htR = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener htS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIb = WriteActivity.this.bIb();
            if (bIb >= 0 && bIb < WriteActivity.this.gyt.getText().length()) {
                WriteActivity.this.gyt.setSelection(bIb);
            }
        }
    };
    private boolean htT = true;
    private final View.OnFocusChangeListener gyn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gyp || view == WriteActivity.this.aAn || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.htT = true;
                    WriteActivity.this.bIc();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.gyp);
                    if (WriteActivity.this.aLp != null) {
                        WriteActivity.this.aLp.FB();
                    }
                } else if (view == WriteActivity.this.gyp) {
                    WriteActivity.this.gyu.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gyt && z) {
                WriteActivity.this.htT = false;
                WriteActivity.this.bIc();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.gyt);
                if (WriteActivity.this.aLp != null) {
                    WriteActivity.this.aLp.FB();
                }
            }
            WriteActivity.this.bIi();
        }
    };
    private TextWatcher htU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String htY = "";
        private String htZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.htZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.htZ != null ? this.htZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsQ();
            WriteActivity.this.bIj();
            EditText bIu = WriteActivity.this.bIu();
            if (editable != null && bIu != null && bIu.getText() != null) {
                if (this.htY == null || !this.htY.equals(editable.toString())) {
                    if (WriteActivity.this.htO != null) {
                        this.htY = bIu.getText().toString();
                        WriteActivity.this.htO.k(bIu);
                        return;
                    }
                    return;
                }
                bIu.setSelection(bIu.getSelectionEnd());
            }
        }
    };
    private TextWatcher htV = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String htZ;
        private String hua = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.htZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.htZ != null ? this.htZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsQ();
            EditText bIt = WriteActivity.this.bIt();
            if (editable != null && bIt != null && bIt.getText() != null) {
                if (this.hua == null || !this.hua.equals(editable.toString())) {
                    if (WriteActivity.this.htO != null) {
                        this.hua = bIt.getText().toString();
                        WriteActivity.this.htO.k(bIt);
                        return;
                    }
                    return;
                }
                bIt.setSelection(bIt.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0232a fCJ = new a.InterfaceC0232a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0232a
        public void onRefresh() {
            WriteActivity.this.eVh = null;
            WriteActivity.this.nG(false);
            WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void HH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void HI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HK();
        } else if (this.aMS.bxL()) {
            HH();
        } else {
            this.aMS.mA(false);
            b(1, true, null);
            this.aMS.bxJ();
        }
    }

    private void HK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aMS.aeS();
                } else {
                    WriteActivity.this.aNf.HW();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIb() {
        int selectionEnd = bIt().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIt().getText().getSpans(0, bIt().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIt().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIt().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIc() {
        if (this.aLp != null) {
            this.aLp.setBarLauncherEnabled(!this.htT);
            this.aLp.setBarLauncherEnabled(true, 26);
            this.aLp.setBarLauncherEnabled(true, 2);
            K(9, this.htT ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g eJ;
        if (this.aLp != null && (eJ = this.aLp.eJ(i)) != null) {
            if (z) {
                eJ.oD();
            } else {
                eJ.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.htI) {
            this.gyp.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hus.setVisibility(8);
            } else {
                this.hus.setVisibility(0);
            }
            a(this.huv, this.hup);
            a(this.huu, this.hut);
            bsQ();
        }
        if (this.hub) {
            this.htT = true;
            bIc();
            if (this.aLp != null) {
                this.aLp.FB();
            }
            this.gyp.requestFocus();
            ShowSoftKeyPadDelay(this.gyp);
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
            bIR();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bIC();
            }
            nH(true);
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
            vz(this.hoo);
        }
        initUI();
        bIH();
        this.aMS = new LocationModel(this);
        this.aMS.a(this.aNf);
        registerListener(this.gLk);
        registerListener(this.htR);
        initEditor();
        bIT();
        if (this.htI) {
            this.huo.setEditorTools(this.aLp);
        } else {
            this.gyt.requestFocus();
        }
        boU();
        bIC();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aLp = new EditorTools(getActivity());
        this.aLp.setBarMaxLauCount(5);
        this.aLp.setMoreButtonAtEnd(true);
        this.aLp.setBarLauncherType(1);
        this.aLp.bB(true);
        this.aLp.bC(true);
        this.aLp.setMoreLauncherIcon(d.f.write_more);
        this.aLp.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bIF();
                break;
            default:
                bId();
                break;
        }
        this.aLp.Hh();
        if (this.htq != null) {
            this.htq.addView(this.aLp);
        }
        bIe();
        this.aLp.oD();
        com.baidu.tbadk.editortools.g eJ = this.aLp.eJ(6);
        if (eJ != null && !TextUtils.isEmpty(this.aMX)) {
            ((View) eJ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aMX);
                }
            });
        }
        if (!this.htI) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aLp.FB();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bIg();
    }

    private void bID() {
        this.huq = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hus = this.huq.findViewById(d.g.live_post_title_container);
        this.hup = (EditText) this.huq.findViewById(d.g.live_post_content);
        this.hun = (GridView) this.huq.findViewById(d.g.photoLiveGridView);
        this.hut = (EditText) this.huq.findViewById(d.g.live_post_title);
        this.huu = (TextView) this.huq.findViewById(d.g.titleOverPlusNumber);
        this.huv = (TextView) this.huq.findViewById(d.g.contentOverPlusNumber);
        this.hur = this.huq.findViewById(d.g.live_interval_view);
        this.huu.setText(String.valueOf(20));
        this.huv.setText(String.valueOf(233));
        this.huq.setVisibility(0);
        this.huu.setVisibility(0);
        this.huv.setVisibility(0);
        this.hut.setHint(d.k.tips_title_limit_new);
        this.hut.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.huy = true;
                    WriteActivity.this.htT = true;
                    WriteActivity.this.bIc();
                    if (WriteActivity.this.aLp != null) {
                        WriteActivity.this.aLp.FB();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hup.setHint(d.k.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hup.setHint(d.k.live_write_input_content_update);
        }
        this.hup.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.huy = false;
                    WriteActivity.this.htT = false;
                    WriteActivity.this.bIc();
                    if (WriteActivity.this.aLp != null) {
                        WriteActivity.this.aLp.FB();
                    }
                }
            }
        });
        this.hup.requestFocus();
        this.hup.addTextChangedListener(bIJ());
        this.hut.requestFocus();
        this.hut.addTextChangedListener(bIJ());
        this.hut.setOnClickListener(this.htS);
        this.hup.setOnClickListener(this.htS);
        this.huo = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hun);
        this.huo.vt(6);
        this.hun.setAdapter((ListAdapter) this.huo);
        View findViewById = this.huq.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHN() {
                WriteActivity.this.aTG();
            }
        });
        bIE();
    }

    private void bIE() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hut.setText(this.mData.getTitle());
                this.hut.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.htI) {
            bIO();
        }
        if (this.aLp.Hj()) {
            this.aLp.FB();
        }
        vz(0);
    }

    private void vz(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gYa);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIF() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aLp.F(arrayList);
        com.baidu.tbadk.editortools.k eM = this.aLp.eM(5);
        if (eM != null) {
            eM.aLY = 2;
            eM.aLW = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aLW = d.f.write_at;
        this.aLp.b(aVar);
        this.aLp.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bId() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aLW = d.f.write_picture;
        this.aLp.b(dVar);
        Boolean bIM = bIM();
        if (!this.hub && bIM != null && bIM.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byj() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aLY = 3;
            kVar5.aLW = d.f.write_recorder;
            this.aLp.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aLW = d.f.icon_post_topic_selector;
        this.aLp.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aLY = 5;
            kVar4.aLW = d.f.write_privilege;
            this.aLp.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aLY = 6;
            kVar3.aLW = this.hub ? d.f.write_location : d.f.icon_post_more_location;
            this.aLp.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aLW = d.f.icon_post_more_at;
        this.aLp.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aMa = true;
            kVar2.aLY = 9;
            kVar2.aLW = 0;
            this.aLp.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aMa = true;
            kVar.aLY = 10;
            kVar.aLW = 0;
            this.aLp.b(kVar);
        }
        if (this.htw == null) {
            if (this.htM == null) {
                this.htM = new com.baidu.tieba.write.editor.b(getActivity(), this.gYa);
                this.htM.aS(this.mData.getForumId(), this.privateThread);
            }
            this.aLp.b(this.htM);
        }
        this.aLp.F(arrayList);
        com.baidu.tbadk.editortools.k eM = this.aLp.eM(5);
        if (eM != null) {
            eM.aLY = 1;
            eM.aLW = d.f.write_emotion;
        }
    }

    private void bIf() {
        if (this.htP != null) {
            this.htP.hideTip();
        }
    }

    private void bIg() {
        if (this.htP == null) {
            this.htP = new e(getPageContext());
        }
        this.htP.c(this.aLp);
    }

    private void bIe() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIs()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIs()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIv();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bdb();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIR();
                        WriteActivity.this.bsQ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vA(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.htw == null) {
                            WriteActivity.this.HL();
                            return;
                        }
                        switch (WriteActivity.this.aMY) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
                                    WriteActivity.this.HI();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.HH();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aMS != null) {
                            WriteActivity.this.aMS.mA(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eVh = null;
                        } else {
                            WriteActivity.this.eVh = (String) aVar.data;
                        }
                        WriteActivity.this.nG(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.ah(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aLp.Hj()) {
                                        WriteActivity.this.aLp.FB();
                                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.k.plugin_video_not_active), WriteActivity.this.getResources().getString(d.k.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.k.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.k.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bsQ();
                        if (WriteActivity.this.gyt != null) {
                            WriteActivity.this.gyt.requestFocus();
                        }
                        WriteActivity.this.aLp.FB();
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gyt);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hto = true;
                        WriteActivity.this.nE(true);
                        if (WriteActivity.this.bIu().isFocused()) {
                            WriteActivity.this.htn = "from_title";
                        } else if (WriteActivity.this.bIt().isFocused()) {
                            WriteActivity.this.htn = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.htr.setVisibility(0);
                        WriteActivity.this.htr.requestFocus();
                        WriteActivity.this.bsQ();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.htr.hasFocus()) {
                            WriteActivity.this.gyt.requestFocus();
                            WriteActivity.this.gyt.setSelection(WriteActivity.this.gyt.getText().toString().length());
                        }
                        WriteActivity.this.htr.setVisibility(8);
                        WriteActivity.this.bsQ();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aLp.setActionListener(16, bVar);
        this.aLp.setActionListener(14, bVar);
        this.aLp.setActionListener(24, bVar);
        this.aLp.setActionListener(3, bVar);
        this.aLp.setActionListener(10, bVar);
        this.aLp.setActionListener(11, bVar);
        this.aLp.setActionListener(12, bVar);
        this.aLp.setActionListener(13, bVar);
        this.aLp.setActionListener(15, bVar);
        this.aLp.setActionListener(18, bVar);
        this.aLp.setActionListener(20, bVar);
        this.aLp.setActionListener(25, bVar);
        this.aLp.setActionListener(27, bVar);
        this.aLp.setActionListener(29, bVar);
        this.aLp.setActionListener(43, bVar);
        this.aLp.setActionListener(45, bVar);
        this.aLp.setActionListener(53, bVar);
        this.aLp.setActionListener(48, bVar);
        this.aLp.setActionListener(46, bVar);
        this.aLp.setActionListener(49, bVar);
        this.aLp.setActionListener(47, bVar);
        this.aLp.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aMS.aeO()) {
            if (this.aMS.bxL()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxH().getLocationData().bxD());
                return;
            }
            b(1, true, null);
            this.aMS.bxJ();
            return;
        }
        b(0, true, null);
    }

    protected void bsI() {
        if (this.aMT != null) {
            this.aMT.cancelLoadData();
        }
        if (this.hts != null) {
            this.hts.cancelLoadData();
        }
        if (this.aMS != null) {
            this.aMS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bIf();
        TiebaPrepareImageService.StopService();
        bsI();
        bIL();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hum != null) {
            this.hum.destroy();
        }
        if (this.huM != null) {
            this.huM.akT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (this.mData != null && this.mData.getType() == 2 && this.hui) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIu().getText().toString());
            this.mData.setContent(bIt().getText().toString());
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
            if (this.gyv != null && this.gyv.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gyv, getPageContext().getPageActivity());
                return true;
            } else if (this.aLp.Hj()) {
                this.aLp.FB();
                return true;
            } else {
                bsI();
                bIh();
                return true;
            }
        }
        if (i == 67 && (text = bIt().getText()) != null) {
            int selectionStart = bIt().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIt().onKeyDown(67, this.cUv);
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
        getLayoutMode().onModeChanged(this.huC);
        if (this.huA != null && i == 1) {
            this.huA.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, d.C0141d.cp_link_tip_a, 1);
        bIc();
        al.j(this.huq, d.C0141d.cp_bg_line_d);
        al.j(this.gyq, d.C0141d.cp_bg_line_c);
        al.j(this.hur, d.C0141d.cp_bg_line_c);
        al.j(bIu(), d.C0141d.cp_bg_line_d);
        al.c(this.fvV, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eVh)) {
            al.j(bIt(), d.C0141d.cp_bg_line_d);
        }
        bsQ();
        this.aLp.onChangeSkinType(i);
        if (this.htG != null) {
            this.htG.Ay();
        }
        al.h(this.mName, d.C0141d.cp_cont_b);
        bIi();
        bIj();
        if (this.htO != null) {
            this.htO.c(bIu(), bIt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (this.gyp.hasFocus()) {
            this.gyp.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gyp.setHintTextColor(al.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gyt.hasFocus()) {
            this.gyt.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gyt.setHintTextColor(al.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (this.gyp != null && this.gyp.getText() != null && this.gyp.getText().toString() != null && this.gyp.getPaint() != null) {
            if (this.gyp.getText().toString().length() == 0) {
                this.gyp.getPaint().setFakeBoldText(false);
            } else if (this.gyp.getText().toString().length() > 0) {
                this.gyp.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aVb = new com.baidu.tbadk.core.view.a(getPageContext());
        this.htI = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, d.C0141d.cp_cont_b);
        this.hug = (TextView) findViewById(d.g.btn_image_problem);
        bIl();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gyn);
        this.htH = (ScrollView) findViewById(d.g.write_scrollview);
        this.htH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gyt != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gyt);
                    }
                    if (WriteActivity.this.aLp != null) {
                        WriteActivity.this.aLp.FB();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hue = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.huf = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.htq = (LinearLayout) findViewById(d.g.tool_view);
        this.htq.setContentDescription("..");
        this.htr = (LinearLayout) findViewById(d.g.title_view);
        this.gyq = findViewById(d.g.interval_view);
        this.huH = findViewById(d.g.hot_topic_fourm_view);
        this.huI = findViewById(d.g.hot_topic_divider);
        this.htK = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.huJ = (TextView) findViewById(d.g.change_one_tv);
        bsP();
        if (this.htI) {
            this.htH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bID();
        } else {
            this.hum = new g(getPageContext(), this.mRootView);
            g gVar = this.hum;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nz(z);
        }
        bsR();
        if (this.hub || this.htp) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().arR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gys = (LinearLayout) findViewById(d.g.post_content_container);
        this.gys.setDrawingCacheEnabled(false);
        this.gys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gyt.requestFocus();
            }
        });
        this.fvS = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fvT = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fvV = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bdb();
            }
        });
        this.aAn.setOnFocusChangeListener(this.gyn);
        this.aAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bsI();
                WriteActivity.this.bIh();
            }
        });
        this.hug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIo();
        i(bIM());
        bIq();
        bIk();
        bII();
        bIK();
        bIc();
        bIp();
        bsO();
        bIw();
        if (this.mData.getType() == 4 && this.gyx != null && this.htt != null) {
            this.gyx.setVisibility(8);
            this.htt.setVisibility(8);
        }
        bsQ();
        bIG();
    }

    private void bIk() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hub || this.htp) {
                        if (this.huc) {
                            this.mName.setText(d.k.feedback_vcode);
                        } else {
                            this.mName.setText(d.k.feedback);
                        }
                    } else if (this.gYa != null && this.gYa.equals("1")) {
                        this.mName.setText(d.k.post_to_home_page);
                    } else if (this.gYa != null && this.gYa.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.k.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.k.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.k.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gyp.setVisibility(0);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gyp.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.k.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hur.setVisibility(8);
                    return;
                case 7:
                    this.gyp.setVisibility(0);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.k.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIl() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
    }

    private void bIm() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hub && !this.htp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ao.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bIu() != null) {
                bIu().setText(d);
                bIu().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fvS.setVisibility(0);
            this.fvT.setVoiceModel(voiceModel);
            this.fvT.byi();
            bsQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdb() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aV(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fvS.setVisibility(8);
        this.fvT.aDT();
        this.fvT.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eM = this.aLp.eM(6);
        if (eM != null && eM.aLj != null) {
            eM.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bsQ();
    }

    private void bIn() {
        this.htB = null;
        this.htD = -1;
        this.htF = -1;
        x ko = com.baidu.tieba.frs.w.auJ().ko(1);
        if (ko != null) {
            this.htB = ko.dkz;
            this.htD = getIntent().getIntExtra("category_id", -1);
            if (this.htB != null && !this.htB.isEmpty() && this.htD >= 0) {
                this.htC = new v();
                this.htC.dkv = 0;
                this.htC.name = getPageContext().getResources().getString(d.k.category_auto);
                this.htF = this.htC.dkv;
                this.htE = this.htC.name;
                for (v vVar : this.htB) {
                    if (vVar.dkv == this.htD) {
                        this.htF = vVar.dkv;
                        this.htE = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIo() {
        if (this.htB != null && !this.htB.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.htG = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.htG.setText(this.htE);
            this.htG.setCategoryContainerData(this.htB, this.htC, this.htF);
            this.htG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.htG.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.dkv);
                        WriteActivity.this.htF = arVar.dkv;
                        WriteActivity.this.htG.bHQ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.htG.bHP();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIu());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIt());
                }
            });
        }
    }

    private void bIG() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.htW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.htW.setTitle(d.k.no_disturb_start_time);
        this.htW.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.htW);
        this.htW.setButton(-2, getPageContext().getString(d.k.cancel), this.htW);
        return this.htW;
    }

    private void bIp() {
        this.htx = (RelativeLayout) findViewById(d.g.addition_container);
        this.hty = (TextView) findViewById(d.g.addition_create_time);
        this.htz = (TextView) findViewById(d.g.addition_last_time);
        this.htA = (TextView) findViewById(d.g.addition_last_content);
        if (this.htw != null) {
            this.htx.setVisibility(0);
            this.hty.setText(getPageContext().getString(d.k.write_addition_create) + ao.v(this.htw.getCreateTime() * 1000));
            if (this.htw.getAlreadyCount() == 0) {
                this.htz.setVisibility(8);
            } else {
                this.htz.setText(getPageContext().getString(d.k.write_addition_last) + ao.v(this.htw.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.htw.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.htA.setText(lastAdditionContent);
            } else {
                this.htA.setVisibility(8);
            }
            bIt().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.htw.getAlreadyCount()), Integer.valueOf(this.htw.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.htx.setVisibility(8);
    }

    private void bsO() {
        this.gyx = findViewById(d.g.post_prefix_layout);
        if (this.huM == null) {
            this.huM = new com.baidu.tieba.c.d(getPageContext(), this.gyx);
            this.huM.jf(d.f.bg_tip_blue_up_left);
            this.huM.je(16);
            this.huM.eK(true);
            this.huM.D(true);
            this.huM.ji(l.e(getActivity(), d.e.ds32));
        }
        this.gyu = (TextView) findViewById(d.g.post_prefix);
        this.htt = findViewById(d.g.prefix_divider);
        this.gyw = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gyx.setVisibility(0);
            this.huM.h(getString(d.k.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gxX = 0;
            this.gyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ah(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gyu.setVisibility(0);
                    WriteActivity.this.gyx.setSelected(true);
                    al.c(WriteActivity.this.gyw, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gyv, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aLp.FB();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gyp);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gyt);
                }
            });
            this.gyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").ah(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gyu.setSelected(true);
                    al.c(WriteActivity.this.gyw, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gyv, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aLp.FB();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIu());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIt());
                }
            });
            this.gyv = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gyv.a(this);
            this.gyv.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gyv.setOutsideTouchable(true);
            this.gyv.setFocusable(true);
            this.gyv.setOnDismissListener(this);
            this.gyv.setBackgroundDrawable(al.getDrawable(d.C0141d.cp_bg_line_d));
            int color = al.getColor(d.C0141d.cp_cont_b);
            al.getColor(d.C0141d.cp_cont_c);
            al.i(this.gyu, d.C0141d.cp_bg_line_d);
            al.c(this.gyw, d.f.icon_arrow_gray_down);
            this.gyu.setTextColor(color);
            this.htu.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.htu.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nu(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nu(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gyv.addView(writePrefixItemLayout);
            }
            this.gyv.setCurrentIndex(0);
            this.gyu.setText(prefixs.get(0));
            vy(0);
            return;
        }
        this.gyx.setVisibility(8);
    }

    private void bIH() {
        if (this.hub && this.mData != null) {
            this.hue.setVisibility(0);
            this.huf.setVisibility(0);
            this.hts = new FeedBackModel(getPageContext());
            this.hts.vR(this.mData.getForumName());
            this.hts.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hue.setVisibility(8);
                        WriteActivity.this.huf.setVisibility(8);
                        WriteActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hue.setVisibility(8);
                        WriteActivity.this.huf.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hue.a(feedBackModel.bHS(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIq() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    WriteActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.htO.a(WriteActivity.this.gyp, WriteActivity.this.gyt)) {
                        WriteActivity.this.showToast(WriteActivity.this.htO.bGc());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIu());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIt());
                    WriteActivity.this.aLp.FB();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hub) {
                            WriteActivity.this.bIz();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bIA();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bIz();
                    }
                    TiebaStatic.log(new am("c12262").ah("obj_locate", WriteActivity.this.gYa));
                }
            }
        });
    }

    protected void bII() {
        this.huh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.huh.dB(getPageContext().getString(d.k.is_save_draft)).au(false).a(getPageContext().getString(d.k.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIu().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bIt().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.k.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.k.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
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
        this.huh.b(getPageContext());
    }

    protected void bsP() {
        this.hud = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hud.setIsRound(true);
        this.hud.setDrawBorder(false);
        this.hud.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String eu = com.baidu.tbadk.core.util.p.eu(currentPortrait);
            this.hud.setUrl(eu);
            this.hud.startLoad(eu, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hud.setVisibility(0);
        }
        this.gyp = (EditText) findViewById(d.g.post_title);
        this.gyp.setOnClickListener(this.htS);
        this.gyp.setOnFocusChangeListener(this.gyn);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gyp.setText(this.mData.getTitle());
                this.gyp.setSelection(this.mData.getTitle().length());
            } else if (this.huc) {
                this.gyp.setText(getResources().getString(d.k.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gyp.addTextChangedListener(this.htU);
        if (!this.mData.getHaveDraft()) {
            bIm();
            this.huG = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gyp.setHint(getResources().getString(d.k.feedback_title_hint));
        } else {
            this.gyp.setHint(getResources().getString(d.k.post_title_hint));
        }
    }

    private TextWatcher bIJ() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int huQ;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bsQ();
                if (WriteActivity.this.htI) {
                    this.huQ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.huQ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.htI || !WriteActivity.this.huy) {
                    if (WriteActivity.this.htI) {
                        if (this.mEditText != WriteActivity.this.hup || this.mTextView != WriteActivity.this.huv) {
                            this.mEditText = WriteActivity.this.hup;
                            this.mTextView = WriteActivity.this.huv;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hut || this.mTextView != WriteActivity.this.huu) {
                    this.mEditText = WriteActivity.this.hut;
                    this.mTextView = WriteActivity.this.huu;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.htI && this.huy) {
            if (this.huw != null) {
                this.hut.removeTextChangedListener(this.huw);
            }
            this.huw = textWatcher;
        } else if (this.htI) {
            if (this.hux != null) {
                this.hup.removeTextChangedListener(this.hux);
            }
            this.hux = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hup) {
            return 233L;
        }
        if (editText != this.hut) {
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
                    textView.setTextColor(al.getColor(d.C0141d.common_color_10159));
                } else {
                    textView.setTextColor(al.getColor(d.C0141d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(al.getColor(d.C0141d.common_color_10159));
            } else {
                textView.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.l(editText.getText().toString().trim());
    }

    protected void bsR() {
        this.gyt = (EditText) findViewById(d.g.post_content);
        this.gyt.setDrawingCacheEnabled(false);
        this.gyt.setOnClickListener(this.htS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IC().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.gyt.setText(U);
            this.gyt.setSelection(U.length());
        } else if (this.mData.getType() == 2) {
            if (this.hui) {
                if (this.huj != null && this.huj.length() > 0) {
                    this.gyt.setText(getPageContext().getPageActivity().getString(d.k.reply_sub_floor, new Object[]{this.huj}));
                    this.gyt.setSelection(this.gyt.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.k.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gyt.setText(format);
                this.gyt.setSelection(format.length());
            }
        }
        this.gyt.setOnFocusChangeListener(this.gyn);
        this.gyt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gyt.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gyt.addTextChangedListener(this.htV);
        if (this.mData.getType() == 0) {
            this.huL = true;
        } else {
            nG(true);
            this.huL = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gyt.setHint(d.k.write_input_content);
        } else {
            this.gyt.setHint(d.k.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nG(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.htI) {
            bIt().setPadding(0, 0, 0, 0);
            bIt().setBackgroundDrawable(null);
            al.j(bIt(), d.C0141d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eVh) && this.htw == null) {
                com.baidu.adp.lib.f.c.ig().a(this.eVh, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.mZ() != null && aVar.nd() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.mZ(), aVar.mZ().getNinePatchChunk(), aVar.nd(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bIt().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bIt(), true, WriteActivity.this.fCJ);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIs() {
        int i = 5000;
        if (this.htw != null) {
            i = 1000;
        }
        return bIt().getText() != null && bIt().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.htn)) {
                this.htn = "";
                bIt().requestFocus();
                if (bIt().getText() != null && bIt().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIt().getSelectionStart();
                    editable = bIt().getText();
                }
            } else if ("from_title".equals(this.htn)) {
                this.htn = "";
                bIu().requestFocus();
                if (bIu().getText() != null && bIu().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIu().getSelectionStart();
                    editable = bIu().getText();
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
    public void nE(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIt().getText().getSpans(0, bIt().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.htv == null) {
                this.htv = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.htv.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Cb = nVar.Cb();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ig().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bIt().getSelectionStart(), aVar, Cb);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIt() != null && bIt().getText() != null) {
            Bitmap mZ = aVar.mZ();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
            int width = mZ.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, mZ.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIt().getSelectionStart() - 1;
                if (bIt().getText().length() > 1 && selectionStart >= 0 && bIt().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIt().getText().insert(bIt().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIt().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIt().getText().insert(bIt().getSelectionStart(), spannableString2);
            }
            Editable text = bIt().getText();
            if (text != null) {
                this.htL.clear();
                this.htL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.htL);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIt().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIt().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIt().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIt() {
        return this.htI ? this.hup : this.gyt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIu() {
        return this.htI ? this.hut : this.gyp;
    }

    protected void bIv() {
        Editable text;
        if (bIt() != null && (text = bIt().getText()) != null) {
            int selectionStart = bIt().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIt().onKeyDown(67, this.cUv);
            }
            bIt().onKeyDown(67, this.cUv);
            int selectionStart2 = bIt().getSelectionStart();
            if (text != null) {
                this.htL.clear();
                this.htL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.htL);
                bIt().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.k.feedback_bar_name).equals(str)) {
            this.hub = true;
        }
    }

    private void bIK() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIL() {
        try {
            if (this.huh != null) {
                this.huh.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVb.d(null);
        this.aVb.dc(d.k.sending);
        this.aVb.aM(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVb.aM(false);
    }

    private Boolean bIM() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aMX = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsQ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIu() != null) {
                str = bIu().getText().toString();
            }
            if (bIt() != null) {
                str2 = bIt().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gxX == w.y(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.htr.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nF(true);
                            return;
                        }
                    } else if (this.htr.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nF(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.htr.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nF(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.htI) {
                    nF(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nF(true);
                }
            }
            if (this.mData.getType() == 4) {
                nF(o(this.hup) && n(this.hut));
            } else if (this.mData.getType() == 5) {
                nF(o(this.hup));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nF(true);
            } else if (this.mData.getVideoInfo() != null) {
                nF(true);
            } else {
                nF(false);
            }
        }
    }

    public void nF(boolean z) {
        if (z) {
            al.b(this.mPost, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        al.c(this.mPost, d.C0141d.cp_cont_d, 1);
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
        this.aMT = new NewWriteModel(this);
        this.aMT.b(this.aNh);
        registerListener(this.huN);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bsI();
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
            this.hub = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.huc = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hui = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.huj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aMR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.htw = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.htw != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.huk = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.huK = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gYa = bundle.getString("KEY_CALL_FROM");
            this.hoo = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hub = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.huc = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hui = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.huj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.htw = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.htw != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.huk = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.huK = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gYa = intent.getStringExtra("KEY_CALL_FROM");
            this.hoo = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hub);
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
            this.mPrefixData.getPrefixs().add(getPageContext().getString(d.k.write_no_prefix));
        }
        this.eVh = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.htp = true;
        }
        bIn();
        try {
            this.huz = bIS();
        } catch (Throwable th) {
            this.huz = null;
        }
    }

    private void bIw() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gyp.setText(com.baidu.tbadk.plugins.b.ho(com.baidu.tbadk.plugins.b.hp(hotTopicBussinessData.mTopicName)));
            this.gyp.setMovementMethod(com.baidu.tieba.view.c.bFg());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) w.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString ho = com.baidu.tbadk.plugins.b.ho(com.baidu.tbadk.plugins.b.hp(hotTopicBussinessData.mTopicName));
            if (ho != null) {
                this.gyp.setText(ho);
            }
            this.htK.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String hp;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bIu().getText().toString()) || this.huG || ((this.hub || this.htp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!w.z(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            hp = this.mData.getTitle();
                        } else {
                            hp = com.baidu.tbadk.plugins.b.hp(str);
                        }
                        SpannableString ho = com.baidu.tbadk.plugins.b.ho(hp);
                        if (ho != null) {
                            bIu().setText(ho);
                            bIu().setSelection(ho.length() > hp.length() ? hp.length() : ho.length());
                        }
                    } else {
                        SpannableString ho2 = com.baidu.tbadk.plugins.b.ho(this.mData.getTitle());
                        if (ho2 != null) {
                            bIu().setText(ho2);
                            bIu().setSelection(this.mData.getTitle().length() > ho2.length() ? ho2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIm();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bIt().getText().toString()) || this.hub || this.htp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.IC().a(getPageContext().getPageActivity(), this.mData.getContent(), this.htQ);
                    bIt().setText(a2);
                    bIt().setSelection(a2.length());
                    if (this.htI) {
                        a(this.huv, this.hup);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIR();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bIC();
                    }
                    nH(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIN();
                }
                bsQ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.htB != null) {
                    this.htF = this.htC.dkv;
                    this.htE = this.htC.name;
                    int i = 0;
                    while (true) {
                        if (i == this.htB.size()) {
                            break;
                        }
                        v vVar = this.htB.get(i);
                        if (categoryTo != vVar.dkv) {
                            i++;
                        } else {
                            this.htF = categoryTo;
                            this.htE = vVar.name;
                            this.mData.setCategoryTo(this.htF);
                            break;
                        }
                    }
                    if (this.htG != null) {
                        this.htG.setText(this.htE);
                        this.htG.setCategoryContainerData(this.htB, this.htC, this.htF);
                    }
                }
                this.aLp.FB();
                return;
            }
            return;
        }
        bIN();
        bIm();
    }

    private void bIN() {
        if ((!this.htI || this.huo != null) && this.hun != null) {
            this.huo.c(this.writeImagesInfo);
            aTG();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hui);
        if (this.hub) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aMR);
        if (this.htw != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.htw));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.huk);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gYa);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hoo);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIt().getEditableText().toString();
        if (obj != null) {
            bIt().setText(TbFaceManager.IC().a(getPageContext().getPageActivity(), obj, this.htQ));
            bIt().setSelection(bIt().getText().length());
        }
    }

    private String bIx() {
        return (bIt() == null || bIt().getText() == null) ? "" : bIt().getText().toString();
    }

    private String bIy() {
        if (this.mData == null || bIu() == null || bIu().getVisibility() != 0 || bIu().getText() == null) {
            return "";
        }
        String obj = bIu().getText().toString();
        if (this.mPrefixData != null && w.y(this.mPrefixData.getPrefixs()) > 0 && this.gxX != w.y(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gyu != null && this.gyu.getText() != null) {
            this.mData.setPostPrefix(this.gyu.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void vS(String str) {
        if (this.mData != null && this.htr != null) {
            if (this.htr.getVisibility() == 0) {
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
    public void bIz() {
        bsI();
        this.mData.setContent(bIx());
        vS(bIy());
        if (this.hub || this.htp) {
            String string = getResources().getString(d.k.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                vS(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.k.app_name) + getResources().getString(d.k.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.jD()) {
                    sb.append(com.baidu.adp.lib.util.j.jL());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(SystemInfoUtil.COLON);
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.htD >= 0) {
            this.mData.setCategoryFrom(this.htD);
        }
        if (this.htF >= 0) {
            this.mData.setCategoryTo(this.htF);
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
        this.mData.setHasLocationData(this.aMS != null && this.aMS.aeO());
        if (this.writeImagesInfo != null) {
            this.aMT.mC(this.writeImagesInfo.size() > 0);
        }
        if (!w.z(this.mList) && this.htJ != null && this.htJ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.htJ.mForumId));
            this.mData.setForumName(this.htJ.mForumName);
        }
        this.aMT.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aMT.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aMT.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aMT.getWriteData().setVoice(null);
                this.aMT.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aMT.getWriteData().setVoice(null);
            this.aMT.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aMT.byk()) {
            showToast(d.k.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
            this.aMT.startPostWrite();
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
            if (this.htw != null) {
                i2 = this.htw.getTotalCount();
                i = this.htw.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.k.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.gyp == getCurrentFocus()) {
                    bIt().clearFocus();
                    this.gyp.requestFocus();
                    if (this.aLp != null) {
                        this.aLp.FB();
                    }
                    ShowSoftKeyPadDelay(this.gyp);
                } else {
                    bIt().requestFocus();
                    if (this.aLp != null) {
                        this.aLp.FB();
                    }
                    ShowSoftKeyPadDelay(this.gyt);
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
                            bIt().getText().insert(bIt().getSelectionStart(), sb.toString());
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
                                bIQ();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            ah(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.huL) {
                            nG(true);
                            this.huL = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.htI) {
                        A(intent);
                        bsQ();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aLp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bsQ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hto) {
                                sb2.append(com.baidu.tbadk.plugins.b.aUy);
                                this.hto = false;
                            }
                            sb2.append(stringExtra);
                            gG(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !w.z(this.mList) && !w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.htJ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.htJ);
                }
            }
        } else if (i2 == 0) {
            if (this.aLp != null && !this.aLp.Hj()) {
                this.gyt.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aLp.FB();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    HO();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIP();
                    if (this.huL) {
                        nG(true);
                        this.huL = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gyp == getCurrentFocus()) {
                        bIt().clearFocus();
                        this.gyp.requestFocus();
                        if (this.aLp != null) {
                            this.aLp.FB();
                        }
                        ShowSoftKeyPadDelay(this.gyp);
                        return;
                    }
                    bIt().requestFocus();
                    if (this.aLp != null) {
                        this.aLp.FB();
                    }
                    ShowSoftKeyPadDelay(this.gyt);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.htO.vy(postWriteCallBackData.getErrorString());
                        this.htO.ax(postWriteCallBackData.getSensitiveWords());
                        this.htO.b(this.gyp, this.gyt);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aMR = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.aMR);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIP();
                    return;
                case 25004:
                    if ("from_title".equals(this.htn)) {
                        bIu().requestFocus();
                        return;
                    } else if ("from_content".equals(this.htn)) {
                        bIt().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if ("1".equals(this.gYa)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gYa)) {
            this.mData.setCanNoForum(false);
        }
        bIB();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.gYa);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bIz();
    }

    private void bIB() {
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIO() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIP() {
        if (this.htI) {
            this.huo.c(this.writeImagesInfo);
            aTG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTG() {
        this.huo.notifyDataSetChanged();
        this.hun.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.huo.notifyDataSetChanged();
                WriteActivity.this.hun.invalidateViews();
            }
        }, 550L);
    }

    public void v(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bsQ();
    }

    private void ae(Intent intent) {
        if (this.htI) {
            af(intent);
            bIP();
        } else {
            ai(intent);
        }
        bsQ();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIP();
            nH(true);
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

    private void bIQ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hul.parseJson(stringExtra);
            this.hul.updateQuality();
            if (this.hul.getChosedFiles() != null && this.hul.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hul.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hul.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIu());
        HidenSoftKeyPad(this.mInputManager, bIt());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aMR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aMR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aj(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aMR, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIR();
            bIC();
        }
        nH(true);
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
                bIR();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bIC();
                }
            }
            nH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIR() {
        if (this.aLp.eM(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void HO() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aMR));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nH(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hum != null) {
            this.hum.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atG() {
        this.dhB = getVoiceManager();
        this.dhB.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tE(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.diC) != null) {
                    TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arj));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.htw == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aMY = i;
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIC() {
        if (!this.htI) {
            if (this.aLp != null) {
                this.aLp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aLp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hum != null) {
                this.hum.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vy(int i) {
        if (i < this.htu.size()) {
            for (int i2 = 0; i2 < this.htu.size(); i2++) {
                this.htu.get(i2).nv(false);
            }
            this.htu.get(i).nv(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sZ(int i) {
        if (i == w.y(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").r("obj_type", 2));
        }
        this.gxX = i;
        this.gyv.setCurrentIndex(i);
        vy(i);
        this.gyu.setText(this.mPrefixData.getPrefixs().get(i));
        bsQ();
        com.baidu.adp.lib.g.g.a(this.gyv, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gyx.setSelected(false);
        al.c(this.gyw, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gyt);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0061a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            HI();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (ac.aN(getApplicationContext())) {
                ak.a(getPageContext(), this.aMR);
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.htN = z;
        if (this.huE && System.currentTimeMillis() - this.huF < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.huE = false;
        }
        if (this.htM != null && !z) {
            this.htM.apc();
        }
        if (this.htP != null && !z) {
            bIf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.huB != null) {
            vU(str);
            this.huB.dismiss();
        }
    }

    private void ct(Context context) {
        huD = l.aj(context);
    }

    private void vU(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.huE = true;
        bIR();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bIC();
        }
        nH(true);
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

    private File bIS() {
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

    private void bIT() {
        if (this.huz != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ct(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(d.i.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.huz != null) {
                        WriteActivity.this.vT(WriteActivity.this.huz.getAbsolutePath());
                    }
                }
            });
            this.huA = (TbImageView) this.mBubbleView.findViewById(d.g.rec_img_view);
            this.huC = (LinearLayout) this.mBubbleView.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.huz.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.huz.getAbsolutePath());
                Bitmap f = f(this.huz.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.huA.setImageBitmap(f);
                    this.huA.setDrawBorder(true);
                    this.huA.setBorderWidth(2);
                    this.huA.setBorderColor(al.getColor(d.C0141d.common_color_10264));
                    this.huB = new Dialog(getActivity(), d.l.bubble_dialog);
                    this.huB.setCanceledOnTouchOutside(true);
                    this.huB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.huE) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.huF = System.currentTimeMillis();
                            }
                        }
                    });
                    this.huB.setContentView(this.mBubbleView);
                    this.huB.show();
                    Window window = this.huB.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (huD / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.htN && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hto = false;
            this.htn = "";
            if ("from_content".equals(str)) {
                this.htn = "from_content";
            } else if ("from_title".equals(str)) {
                this.htn = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hn(String.valueOf(charSequence.charAt(i)))) {
                nE(false);
            }
        }
    }

    public void boU() {
        if (this.hub || !w.z(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.htr.setVisibility(0);
            this.htr.requestFocus();
            this.aLp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.htr.setVisibility(8);
    }
}
