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
    private static int icS = 0;
    private EditorTools aZb;
    private String baD;
    private LocationModel baE;
    private NewWriteModel baF;
    private VoiceManager dLz;
    private LinearLayout gbn;
    private PlayVoiceBntNew gbo;
    private ImageView gbq;
    private int heC;
    private TextView heZ;
    private com.baidu.tieba.write.d hfa;
    private ImageView hfb;
    private View hfc;
    private LinearLayout ibE;
    private LinearLayout ibF;
    private View ibH;
    private Toast ibJ;
    private AdditionData ibK;
    private RelativeLayout ibL;
    private TextView ibM;
    private TextView ibN;
    private TextView ibO;
    List<x> ibP;
    x ibQ;
    private int ibR;
    private String ibS;
    private int ibT;
    private PostCategoryView ibU;
    private HotTopicBussinessData ibX;
    private TextView ibY;
    private g icA;
    private View icW;
    private View icX;
    private TextView icY;
    private com.baidu.tieba.write.editor.b ica;
    private e icd;
    private com.baidu.tieba.view.b ick;
    private View ict;
    private com.baidu.tieba.c.d idb;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String ibB = "";
    private boolean ibC = false;
    private WriteData mData = null;
    private boolean icp = false;
    private boolean ibD = false;
    private boolean icq = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText heU = null;
    private HeadImageView icr = null;
    private View heV = null;
    private LinearLayout heX = null;
    private EditText heY = null;
    private FeedBackModel ibG = null;
    private FeedBackTopListView ics = null;
    private ArrayList<WritePrefixItemLayout> ibI = new ArrayList<>();
    private String fzk = null;
    private final KeyEvent duo = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aNy = null;
    private TextView icu = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a icv = null;
    private final Handler mHandler = new Handler();
    private boolean icw = false;
    private String icx = null;
    private RelativeLayout mParent = null;
    private String baJ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int baK = 0;
    private int icy = 0;
    private WriteImagesInfo icz = new WriteImagesInfo();
    private View mRootView = null;
    private GridView icB = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a icC = null;
    private ScrollView ibV = null;
    private EditText icD = null;
    private View icE = null;
    private View icF = null;
    private View icG = null;
    private EditText icH = null;
    private TextView icI = null;
    private TextView icJ = null;
    private TextWatcher icK = null;
    private TextWatcher icL = null;
    private boolean ibW = false;
    private boolean icM = false;
    private com.baidu.tbadk.core.view.d biP = null;
    private String mFrom = "write";
    private File icN = null;
    private TbImageView icO = null;
    private View icP = null;
    private Dialog icQ = null;
    private LinearLayout icR = null;
    private boolean icT = false;
    private long icU = -1000;
    private boolean icV = false;
    private String eig = "2";
    private int hWc = 0;
    private String icZ = "";
    private SpannableStringBuilder ibZ = new SpannableStringBuilder();
    private boolean ida = false;
    private boolean icb = false;
    private final b icc = new b();
    private final HttpMessageListener idc = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fzk)) {
                    WriteActivity.this.fzk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oJ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fzk)) {
                    WriteActivity.this.fzk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fzk);
                    WriteActivity.this.oJ(true);
                }
            }
        }
    };
    private TbFaceManager.a ice = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan is(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.ot());
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
    private final AntiHelper.a dMD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDn));
        }
    };
    private final NewWriteModel.d baT = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.aCj();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.icc.aA(null);
                if (z) {
                    WriteActivity.this.cB(z);
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
                        if (!v.I(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.icZ)) {
                            TiebaStatic.log(new am("c11731").aB(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.icZ));
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
                    WriteActivity.this.icc.aA(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.icc.xK(postWriteCallBackData.getErrorString());
                    WriteActivity.this.icc.b(WriteActivity.this.heU, WriteActivity.this.heY);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.Hl());
                    if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.Hk());
                        if (WriteActivity.this.icq) {
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
    private final LocationModel.a baR = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Nf() {
            WriteActivity.this.showToast(e.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void dk(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(e.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bFu())) {
                WriteActivity.this.b(2, true, aVar.bFu());
            } else {
                dk(null);
            }
        }
    };
    private final CustomMessageListener hrU = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.baE.nB(false);
                    WriteActivity.this.baE.cQ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.baE.nB(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener icf = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener icg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bQy = WriteActivity.this.bQy();
            if (bQy >= 0 && bQy < WriteActivity.this.heY.getText().length()) {
                WriteActivity.this.heY.setSelection(bQy);
            }
        }
    };
    private boolean ich = true;
    private final View.OnFocusChangeListener heS = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.heU || view == WriteActivity.this.aNy || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.ich = true;
                    WriteActivity.this.bQz();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.heU);
                    if (WriteActivity.this.aZb != null) {
                        WriteActivity.this.aZb.KM();
                    }
                } else if (view == WriteActivity.this.heU) {
                    WriteActivity.this.heZ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.heY && z) {
                WriteActivity.this.ich = false;
                WriteActivity.this.bQz();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.heY);
                if (WriteActivity.this.aZb != null) {
                    WriteActivity.this.aZb.KM();
                }
            }
            WriteActivity.this.bQF();
        }
    };
    private TextWatcher ici = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String icm = "";
        private String icn;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.icn = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.icn != null ? this.icn.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bAC();
            WriteActivity.this.bQG();
            EditText bQR = WriteActivity.this.bQR();
            if (editable != null && bQR != null && bQR.getText() != null) {
                if (this.icm == null || !this.icm.equals(editable.toString())) {
                    if (WriteActivity.this.icc != null) {
                        this.icm = bQR.getText().toString();
                        WriteActivity.this.icc.k(bQR);
                        return;
                    }
                    return;
                }
                bQR.setSelection(bQR.getSelectionEnd());
            }
        }
    };
    private TextWatcher icj = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String icn;
        private String ico = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.icn = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.icn != null ? this.icn.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bAC();
            EditText bQQ = WriteActivity.this.bQQ();
            if (editable != null && bQQ != null && bQQ.getText() != null) {
                if (this.ico == null || !this.ico.equals(editable.toString())) {
                    if (WriteActivity.this.icc != null) {
                        this.ico = bQQ.getText().toString();
                        WriteActivity.this.icc.k(bQQ);
                        return;
                    }
                    return;
                }
                bQQ.setSelection(bQQ.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0314a gie = new a.InterfaceC0314a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
            WriteActivity.this.fzk = null;
            WriteActivity.this.oJ(false);
            WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void MQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void MR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MT();
        } else if (this.baE.bFB()) {
            MQ();
        } else {
            this.baE.nB(false);
            b(1, true, null);
            this.baE.bFz();
        }
    }

    private void MT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.baE.amP();
                } else {
                    WriteActivity.this.baR.Nf();
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
        aVar.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bQy() {
        int selectionEnd = bQQ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bQQ().getText().getSpans(0, bQQ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bQQ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bQQ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQz() {
        if (this.aZb != null) {
            this.aZb.setBarLauncherEnabled(!this.ich);
            this.aZb.setBarLauncherEnabled(true, 26);
            this.aZb.setBarLauncherEnabled(true, 2);
            K(9, this.ich ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g fI;
        if (this.aZb != null && (fI = this.aZb.fI(i)) != null) {
            if (z) {
                fI.pR();
            } else {
                fI.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.ibW) {
            this.heU.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.icG.setVisibility(8);
            } else {
                this.icG.setVisibility(0);
            }
            a(this.icJ, this.icD);
            a(this.icI, this.icH);
            bAC();
        }
        if (this.icp) {
            this.ich = true;
            bQz();
            if (this.aZb != null) {
                this.aZb.KM();
            }
            this.heU.requestFocus();
            ShowSoftKeyPadDelay(this.heU);
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
            bRo();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bQZ();
            }
            oK(true);
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
            xJ(this.hWc);
        }
        initUI();
        bRe();
        this.baE = new LocationModel(this);
        this.baE.a(this.baR);
        registerListener(this.hrU);
        registerListener(this.icf);
        initEditor();
        bRq();
        if (this.ibW) {
            this.icC.setEditorTools(this.aZb);
        } else {
            this.heY.requestFocus();
        }
        bwG();
        bQZ();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aZb = new EditorTools(getActivity());
        this.aZb.setBarMaxLauCount(5);
        this.aZb.setMoreButtonAtEnd(true);
        this.aZb.setBarLauncherType(1);
        this.aZb.ct(true);
        this.aZb.cu(true);
        this.aZb.setMoreLauncherIcon(e.f.write_more);
        this.aZb.setBackgroundColorId(e.d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bRc();
                break;
            default:
                bQA();
                break;
        }
        this.aZb.Mq();
        if (this.ibE != null) {
            this.ibE.addView(this.aZb);
        }
        bQB();
        this.aZb.pR();
        com.baidu.tbadk.editortools.g fI = this.aZb.fI(6);
        if (fI != null && !TextUtils.isEmpty(this.baJ)) {
            ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.baJ);
                }
            });
        }
        if (!this.ibW) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aZb.KM();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bQD();
    }

    private void bRa() {
        this.icE = this.mRootView.findViewById(e.g.photo_live_scroll);
        this.icG = this.icE.findViewById(e.g.live_post_title_container);
        this.icD = (EditText) this.icE.findViewById(e.g.live_post_content);
        this.icB = (GridView) this.icE.findViewById(e.g.photoLiveGridView);
        this.icH = (EditText) this.icE.findViewById(e.g.live_post_title);
        this.icI = (TextView) this.icE.findViewById(e.g.titleOverPlusNumber);
        this.icJ = (TextView) this.icE.findViewById(e.g.contentOverPlusNumber);
        this.icF = this.icE.findViewById(e.g.live_interval_view);
        this.icI.setText(String.valueOf(20));
        this.icJ.setText(String.valueOf(233));
        this.icE.setVisibility(0);
        this.icI.setVisibility(0);
        this.icJ.setVisibility(0);
        this.icH.setHint(e.j.tips_title_limit_new);
        this.icH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.icM = true;
                    WriteActivity.this.ich = true;
                    WriteActivity.this.bQz();
                    if (WriteActivity.this.aZb != null) {
                        WriteActivity.this.aZb.KM();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.icD.setHint(e.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.icD.setHint(e.j.live_write_input_content_update);
        }
        this.icD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.icM = false;
                    WriteActivity.this.ich = false;
                    WriteActivity.this.bQz();
                    if (WriteActivity.this.aZb != null) {
                        WriteActivity.this.aZb.KM();
                    }
                }
            }
        });
        this.icD.requestFocus();
        this.icD.addTextChangedListener(getTextWatcher());
        this.icH.requestFocus();
        this.icH.addTextChangedListener(getTextWatcher());
        this.icH.setOnClickListener(this.icg);
        this.icD.setOnClickListener(this.icg);
        this.icC = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.icB);
        this.icC.xD(6);
        this.icB.setAdapter((ListAdapter) this.icC);
        View findViewById = this.icE.findViewById(e.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bQj() {
                WriteActivity.this.bRm();
            }
        });
        bRb();
    }

    private void bRb() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.icH.setText(this.mData.getTitle());
                this.icH.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.ibW) {
            bRk();
        }
        if (this.aZb.Ms()) {
            this.aZb.KM();
        }
        xJ(0);
    }

    private void xJ(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.eig);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bRc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aZb.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aZb.fL(5);
        if (fL != null) {
            fL.aZK = 2;
            fL.aZI = e.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aZI = e.f.write_at;
        this.aZb.b(aVar);
        this.aZb.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bQA() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aZI = e.f.write_picture;
        this.aZb.b(dVar);
        Boolean bRi = bRi();
        if (!this.icp && bRi != null && bRi.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bGd() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aZK = 3;
            kVar5.aZI = e.f.write_recorder;
            this.aZb.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aZI = e.f.icon_post_topic_selector;
        this.aZb.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aZK = 5;
            kVar4.aZI = e.f.write_privilege;
            this.aZb.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aZK = 6;
            kVar3.aZI = this.icp ? e.f.write_location : e.f.icon_post_more_location;
            this.aZb.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aZI = e.f.icon_post_more_at;
        this.aZb.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aZM = true;
            kVar2.aZK = 9;
            kVar2.aZI = 0;
            this.aZb.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aZM = true;
            kVar.aZK = 10;
            kVar.aZI = 0;
            this.aZb.b(kVar);
        }
        if (this.ibK == null) {
            if (this.ica == null) {
                this.ica = new com.baidu.tieba.write.editor.b(getActivity(), this.eig);
                this.ica.ba(this.mData.getForumId(), this.privateThread);
            }
            this.aZb.b(this.ica);
        }
        this.aZb.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aZb.fL(5);
        if (fL != null) {
            fL.aZK = 1;
            fL.aZI = e.f.write_emotion;
        }
    }

    private void bQC() {
        if (this.icd != null) {
            this.icd.hideTip();
        }
    }

    private void bQD() {
        if (this.icd == null) {
            this.icd = new e(getPageContext());
        }
        this.icd.c(this.aZb);
    }

    private void bQB() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bQP()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").y("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bQP()) {
                            WriteActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bQS();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bko();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bRo();
                        WriteActivity.this.bAC();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xK(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").y("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.ibK == null) {
                            WriteActivity.this.MU();
                            return;
                        }
                        switch (WriteActivity.this.baK) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    WriteActivity.this.MR();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.MQ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.baE != null) {
                            WriteActivity.this.baE.nB(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fzk = null;
                        } else {
                            WriteActivity.this.fzk = (String) aVar.data;
                        }
                        WriteActivity.this.oJ(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.aB(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aZb.Ms()) {
                                        WriteActivity.this.aZb.KM();
                                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bAC();
                        if (WriteActivity.this.heY != null) {
                            WriteActivity.this.heY.requestFocus();
                        }
                        WriteActivity.this.aZb.KM();
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.heY);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").y("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.ibC = true;
                        WriteActivity.this.oH(true);
                        if (!WriteActivity.this.bQR().isFocused() || WriteActivity.this.ibF.getVisibility() != 0) {
                            WriteActivity.this.ibB = "from_content";
                        } else {
                            WriteActivity.this.ibB = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.ibF.setVisibility(0);
                        WriteActivity.this.ibF.requestFocus();
                        WriteActivity.this.bAC();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.ibF.hasFocus()) {
                            WriteActivity.this.heY.requestFocus();
                            WriteActivity.this.heY.setSelection(WriteActivity.this.heY.getText().toString().length());
                        }
                        WriteActivity.this.ibF.setVisibility(8);
                        WriteActivity.this.bAC();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aZb.setActionListener(16, bVar);
        this.aZb.setActionListener(14, bVar);
        this.aZb.setActionListener(24, bVar);
        this.aZb.setActionListener(3, bVar);
        this.aZb.setActionListener(10, bVar);
        this.aZb.setActionListener(11, bVar);
        this.aZb.setActionListener(12, bVar);
        this.aZb.setActionListener(13, bVar);
        this.aZb.setActionListener(15, bVar);
        this.aZb.setActionListener(18, bVar);
        this.aZb.setActionListener(20, bVar);
        this.aZb.setActionListener(25, bVar);
        this.aZb.setActionListener(27, bVar);
        this.aZb.setActionListener(29, bVar);
        this.aZb.setActionListener(43, bVar);
        this.aZb.setActionListener(45, bVar);
        this.aZb.setActionListener(53, bVar);
        this.aZb.setActionListener(48, bVar);
        this.aZb.setActionListener(46, bVar);
        this.aZb.setActionListener(49, bVar);
        this.aZb.setActionListener(47, bVar);
        this.aZb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (this.baE.amL()) {
            if (this.baE.bFB()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bFx().getLocationData().bFu());
                return;
            }
            b(1, true, null);
            this.baE.bFz();
            return;
        }
        b(0, true, null);
    }

    protected void bAu() {
        if (this.baF != null) {
            this.baF.cancelLoadData();
        }
        if (this.ibG != null) {
            this.ibG.cancelLoadData();
        }
        if (this.baE != null) {
            this.baE.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bQC();
        TiebaPrepareImageService.StopService();
        bAu();
        bRh();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.icA != null) {
            this.icA.destroy();
        }
        if (this.idb != null) {
            this.idb.asz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQE() {
        if (this.mData != null && this.mData.getType() == 2 && this.icw) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bQR().getText().toString());
            this.mData.setContent(bQQ().getText().toString());
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
            if (this.hfa != null && this.hfa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.hfa, getPageContext().getPageActivity());
                return true;
            } else if (this.aZb.Ms()) {
                this.aZb.KM();
                return true;
            } else {
                bAu();
                bQE();
                return true;
            }
        }
        if (i == 67 && (text = bQQ().getText()) != null) {
            int selectionStart = bQQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQQ().onKeyDown(67, this.duo);
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
        getLayoutMode().onModeChanged(this.icR);
        if (this.icO != null && i == 1) {
            this.icO.setBorderColor(al.getColor(e.d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bQz();
        al.j(this.icE, e.d.cp_bg_line_d);
        al.j(this.heV, e.d.cp_bg_line_c);
        al.j(this.icF, e.d.cp_bg_line_c);
        al.j(bQR(), e.d.cp_bg_line_d);
        al.c(this.gbq, e.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fzk)) {
            al.j(bQQ(), e.d.cp_bg_line_d);
        }
        bAC();
        this.aZb.onChangeSkinType(i);
        if (this.ibU != null) {
            this.ibU.Fw();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bQF();
        bQG();
        if (this.icc != null) {
            this.icc.c(bQR(), bQQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQF() {
        if (this.heU.hasFocus()) {
            this.heU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.heY.hasFocus()) {
            this.heY.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heY.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        if (this.heU != null && this.heU.getText() != null && this.heU.getText().toString() != null && this.heU.getPaint() != null) {
            if (this.heU.getText().toString().length() == 0) {
                this.heU.getPaint().setFakeBoldText(false);
            } else if (this.heU.getText().toString().length() > 0) {
                this.heU.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.biP = new com.baidu.tbadk.core.view.d(getPageContext());
        this.ibW = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        this.icu = (TextView) findViewById(e.g.btn_image_problem);
        bQI();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.heS);
        this.ibV = (ScrollView) findViewById(e.g.write_scrollview);
        this.ibV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.heY != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.heY);
                    }
                    if (WriteActivity.this.aZb != null) {
                        WriteActivity.this.aZb.KM();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ics = (FeedBackTopListView) findViewById(e.g.feedback_top_list);
        this.ict = findViewById(e.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.ibE = (LinearLayout) findViewById(e.g.tool_view);
        this.ibE.setContentDescription("..");
        this.ibF = (LinearLayout) findViewById(e.g.title_view);
        this.heV = findViewById(e.g.interval_view);
        this.icW = findViewById(e.g.hot_topic_fourm_view);
        this.icX = findViewById(e.g.hot_topic_divider);
        this.ibY = (TextView) findViewById(e.g.hot_topic_title_edt);
        this.icY = (TextView) findViewById(e.g.change_one_tv);
        bAB();
        if (this.ibW) {
            this.ibV.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bRa();
        } else {
            this.icA = new g(getPageContext(), this.mRootView);
            g gVar = this.icA;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.oC(z);
        }
        bAD();
        if (this.icp || this.ibD) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aDZ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(e.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(e.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.heX = (LinearLayout) findViewById(e.g.post_content_container);
        this.heX.setDrawingCacheEnabled(false);
        this.heX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.heY.requestFocus();
            }
        });
        this.gbn = (LinearLayout) findViewById(e.g.layout_voice_play);
        this.gbo = (PlayVoiceBntNew) findViewById(e.g.btn_play_voice);
        this.gbq = (ImageView) findViewById(e.g.iv_delete_voice);
        this.gbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bko();
            }
        });
        this.aNy.setOnFocusChangeListener(this.heS);
        this.aNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bAu();
                WriteActivity.this.bQE();
            }
        });
        this.icu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bQL();
        j(bRi());
        bQN();
        bQH();
        bRf();
        bRg();
        bQz();
        bQM();
        bAA();
        bQT();
        if (this.mData.getType() == 4 && this.hfc != null && this.ibH != null) {
            this.hfc.setVisibility(8);
            this.ibH.setVisibility(8);
        }
        bAC();
        bRd();
    }

    private void bQH() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.icp || this.ibD) {
                        if (this.icq) {
                            this.mName.setText(e.j.feedback_vcode);
                        } else {
                            this.mName.setText(e.j.feedback);
                        }
                    } else if (this.eig != null && this.eig.equals("1")) {
                        this.mName.setText(e.j.post_to_home_page);
                    } else if (this.eig != null && this.eig.equals("2")) {
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
                    this.heU.setVisibility(0);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(e.j.send_reply);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.heU.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(e.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.icF.setVisibility(8);
                    return;
                case 7:
                    this.heU.setVisibility(0);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(e.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bQI() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_post));
    }

    private void bQJ() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.icp && !this.ibD && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bQR() != null) {
                bQR().setText(c);
                bQR().setSelection(c.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.gbn.setVisibility(0);
            this.gbo.setVoiceModel(voiceModel);
            this.gbo.bGc();
            bAC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.gbn.setVisibility(8);
        this.gbo.aNK();
        this.gbo.setVoiceModel(null);
        com.baidu.tbadk.editortools.k fL = this.aZb.fL(6);
        if (fL != null && fL.aYV != null) {
            fL.aYV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bAC();
    }

    private void bQK() {
        this.ibP = null;
        this.ibR = -1;
        this.ibT = -1;
        z mB = y.aDD().mB(1);
        if (mB != null) {
            this.ibP = mB.dOQ;
            this.ibR = getIntent().getIntExtra("category_id", -1);
            if (this.ibP != null && !this.ibP.isEmpty() && this.ibR >= 0) {
                this.ibQ = new x();
                this.ibQ.dOM = 0;
                this.ibQ.name = getPageContext().getResources().getString(e.j.category_auto);
                this.ibT = this.ibQ.dOM;
                this.ibS = this.ibQ.name;
                for (x xVar : this.ibP) {
                    if (xVar.dOM == this.ibR) {
                        this.ibT = xVar.dOM;
                        this.ibS = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bQL() {
        if (this.ibP != null && !this.ibP.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.ibU = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.ibU.setText(this.ibS);
            this.ibU.setCategoryContainerData(this.ibP, this.ibQ, this.ibT);
            this.ibU.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.ibU.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dOM);
                        WriteActivity.this.ibT = atVar.dOM;
                        WriteActivity.this.ibU.bQm();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.ibU.bQl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQR());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQQ());
                }
            });
        }
    }

    private void bRd() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ick = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ick.setTitle(e.j.no_disturb_start_time);
        this.ick.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.ick);
        this.ick.setButton(-2, getPageContext().getString(e.j.cancel), this.ick);
        return this.ick;
    }

    private void bQM() {
        this.ibL = (RelativeLayout) findViewById(e.g.addition_container);
        this.ibM = (TextView) findViewById(e.g.addition_create_time);
        this.ibN = (TextView) findViewById(e.g.addition_last_time);
        this.ibO = (TextView) findViewById(e.g.addition_last_content);
        if (this.ibK != null) {
            this.ibL.setVisibility(0);
            this.ibM.setText(getPageContext().getString(e.j.write_addition_create) + ao.M(this.ibK.getCreateTime() * 1000));
            if (this.ibK.getAlreadyCount() == 0) {
                this.ibN.setVisibility(8);
            } else {
                this.ibN.setText(getPageContext().getString(e.j.write_addition_last) + ao.M(this.ibK.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ibK.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ibO.setText(lastAdditionContent);
            } else {
                this.ibO.setVisibility(8);
            }
            bQQ().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.ibK.getAlreadyCount()), Integer.valueOf(this.ibK.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.ibL.setVisibility(8);
    }

    private void bAA() {
        this.hfc = findViewById(e.g.post_prefix_layout);
        if (this.idb == null) {
            this.idb = new com.baidu.tieba.c.d(getPageContext(), this.hfc);
            this.idb.li(e.f.bg_tip_blue_up_left);
            this.idb.lh(16);
            this.idb.fL(true);
            this.idb.aa(true);
            this.idb.ll(l.h(getActivity(), e.C0210e.ds32));
        }
        this.heZ = (TextView) findViewById(e.g.post_prefix);
        this.ibH = findViewById(e.g.prefix_divider);
        this.hfb = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.hfc.setVisibility(0);
            this.idb.h(getString(e.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.heC = 0;
            this.hfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aB(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.heZ.setVisibility(0);
                    WriteActivity.this.hfc.setSelected(true);
                    al.c(WriteActivity.this.hfb, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.hfa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aZb.KM();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.heU);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.heY);
                }
            });
            this.heZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").aB(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).i("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.heZ.setSelected(true);
                    al.c(WriteActivity.this.hfb, e.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.hfa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aZb.KM();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQR());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQQ());
                }
            });
            this.hfa = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.hfa.a(this);
            this.hfa.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.hfa.setOutsideTouchable(true);
            this.hfa.setFocusable(true);
            this.hfa.setOnDismissListener(this);
            this.hfa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            al.getColor(e.d.cp_cont_c);
            al.i(this.heZ, e.d.cp_bg_line_d);
            al.c(this.hfb, e.f.icon_arrow_gray_down);
            this.heZ.setTextColor(color);
            this.ibI.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ibI.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ox(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.ox(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.hfa.addView(writePrefixItemLayout);
            }
            this.hfa.setCurrentIndex(0);
            this.heZ.setText(prefixs.get(0));
            xI(0);
            return;
        }
        this.hfc.setVisibility(8);
    }

    private void bRe() {
        if (this.icp && this.mData != null) {
            this.ics.setVisibility(0);
            this.ict.setVisibility(0);
            this.ibG = new FeedBackModel(getPageContext());
            this.ibG.yf(this.mData.getForumName());
            this.ibG.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.ics.setVisibility(8);
                        WriteActivity.this.ict.setVisibility(8);
                        WriteActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.ics.setVisibility(8);
                        WriteActivity.this.ict.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.ics.a(feedBackModel.bQo(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bQN() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    WriteActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.icc.a(WriteActivity.this.heU, WriteActivity.this.heY)) {
                        WriteActivity.this.showToast(WriteActivity.this.icc.bOx());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQR());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bQQ());
                    WriteActivity.this.aZb.KM();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.icp) {
                            WriteActivity.this.bQW();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.y("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.bQX();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bQW();
                    }
                    TiebaStatic.log(new am("c12262").aB("obj_locate", WriteActivity.this.eig));
                }
            }
        });
    }

    protected void bRf() {
        this.icv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.icv.eK(getPageContext().getString(e.j.is_save_draft)).bg(false).a(getPageContext().getString(e.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bQR().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bQQ().getText().toString());
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
        this.icv.b(getPageContext());
    }

    protected void bAB() {
        this.icr = (HeadImageView) findViewById(e.g.user_head_portrait);
        this.icr.setIsRound(true);
        this.icr.setDrawBorder(false);
        this.icr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String fH = o.fH(currentPortrait);
            this.icr.setUrl(fH);
            this.icr.startLoad(fH, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.icr.setVisibility(0);
        }
        this.heU = (EditText) findViewById(e.g.post_title);
        this.heU.setOnClickListener(this.icg);
        this.heU.setOnFocusChangeListener(this.heS);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.heU.setText(this.mData.getTitle());
                this.heU.setSelection(this.mData.getTitle().length());
            } else if (this.icq) {
                this.heU.setText(getResources().getString(e.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.heU.addTextChangedListener(this.ici);
        if (!this.mData.getHaveDraft()) {
            bQJ();
            this.icV = true;
        }
        if (this.mData.isUserFeedback()) {
            this.heU.setHint(getResources().getString(e.j.feedback_title_hint));
        } else {
            this.heU.setHint(getResources().getString(e.j.post_title_hint));
        }
    }

    private TextWatcher getTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int idf;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bAC();
                if (WriteActivity.this.ibW) {
                    this.idf = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.idf);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.ibW || !WriteActivity.this.icM) {
                    if (WriteActivity.this.ibW) {
                        if (this.mEditText != WriteActivity.this.icD || this.mTextView != WriteActivity.this.icJ) {
                            this.mEditText = WriteActivity.this.icD;
                            this.mTextView = WriteActivity.this.icJ;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.icH || this.mTextView != WriteActivity.this.icI) {
                    this.mEditText = WriteActivity.this.icH;
                    this.mTextView = WriteActivity.this.icI;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.ibW && this.icM) {
            if (this.icK != null) {
                this.icH.removeTextChangedListener(this.icK);
            }
            this.icK = textWatcher;
        } else if (this.ibW) {
            if (this.icL != null) {
                this.icD.removeTextChangedListener(this.icL);
            }
            this.icL = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.icD) {
            return 233L;
        }
        if (editText != this.icH) {
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

    protected void bAD() {
        this.heY = (EditText) findViewById(e.g.post_content);
        this.heY.setDrawingCacheEnabled(false);
        this.heY.setOnClickListener(this.icg);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.NL().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.heY.setText(ak);
            this.heY.setSelection(ak.length());
        } else if (this.mData.getType() == 2) {
            if (this.icw) {
                if (this.icx != null && this.icx.length() > 0) {
                    this.heY.setText(getPageContext().getPageActivity().getString(e.j.reply_sub_floor, new Object[]{this.icx}));
                    this.heY.setSelection(this.heY.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(e.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.heY.setText(format);
                this.heY.setSelection(format.length());
            }
        }
        this.heY.setOnFocusChangeListener(this.heS);
        this.heY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.heY.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.heY.addTextChangedListener(this.icj);
        if (this.mData.getType() == 0) {
            this.ida = true;
        } else {
            oJ(true);
            this.ida = false;
        }
        if (this.mData.isUserFeedback()) {
            this.heY.setHint(e.j.write_input_content);
        } else {
            this.heY.setHint(e.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oJ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.ibW) {
            bQQ().setPadding(0, 0, 0, 0);
            bQQ().setBackgroundDrawable(null);
            al.j(bQQ(), e.d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fzk) && this.ibK == null) {
                com.baidu.adp.lib.f.c.jA().a(this.fzk, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.ot() != null && aVar.ox() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.ot(), aVar.ot().getNinePatchChunk(), aVar.ox(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bQQ().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bQQ(), true, WriteActivity.this.gie);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQP() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.ibK != null) {
            i = 1000;
        }
        return bQQ().getText() != null && bQQ().getText().length() >= i;
    }

    private void hY(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ibB)) {
                this.ibB = "";
                bQQ().requestFocus();
                if (bQQ().getText() != null && bQQ().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQQ().getSelectionStart();
                    editable = bQQ().getText();
                }
            } else if ("from_title".equals(this.ibB)) {
                this.ibB = "";
                bQR().requestFocus();
                if (bQR().getText() != null && bQR().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQR().getSelectionStart();
                    editable = bQR().getText();
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
    public void oH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) bQQ().getText().getSpans(0, bQQ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ibJ == null) {
                this.ibJ = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.ibJ.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType Ha = pVar.Ha();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bQQ().getSelectionStart(), aVar, Ha);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bQQ() != null && bQQ().getText() != null) {
            Bitmap ot = aVar.ot();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ot);
            int width = ot.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, ot.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bQQ().getSelectionStart() - 1;
                if (bQQ().getText().length() > 1 && selectionStart >= 0 && bQQ().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bQQ().getText().insert(bQQ().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bQQ().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bQQ().getText().insert(bQQ().getSelectionStart(), spannableString2);
            }
            Editable text = bQQ().getText();
            if (text != null) {
                this.ibZ.clear();
                this.ibZ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.ibZ);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bQQ().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bQQ().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bQQ().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQQ() {
        return this.ibW ? this.icD : this.heY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQR() {
        return this.ibW ? this.icH : this.heU;
    }

    protected void bQS() {
        Editable text;
        if (bQQ() != null && (text = bQQ().getText()) != null) {
            int selectionStart = bQQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQQ().onKeyDown(67, this.duo);
            }
            bQQ().onKeyDown(67, this.duo);
            int selectionStart2 = bQQ().getSelectionStart();
            if (text != null) {
                this.ibZ.clear();
                this.ibZ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.ibZ);
                bQQ().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(e.j.feedback_bar_name).equals(str)) {
            this.icp = true;
        }
    }

    private void bRg() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bRh() {
        try {
            if (this.icv != null) {
                this.icv.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.biP.d(null);
        this.biP.ec(e.j.sending);
        this.biP.bB(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.biP.bB(false);
    }

    private Boolean bRi() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.baJ = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void bAC() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bQR() != null) {
                str = bQR().getText().toString();
            }
            if (bQQ() != null) {
                str2 = bQQ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.heC == v.H(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.ibF.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            oI(true);
                            return;
                        }
                    } else if (this.ibF.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        oI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.ibF.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    oI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ibW) {
                    oI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oI(true);
                }
            }
            if (this.mData.getType() == 4) {
                oI(o(this.icD) && n(this.icH));
            } else if (this.mData.getType() == 5) {
                oI(o(this.icD));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                oI(true);
            } else if (this.mData.getVideoInfo() != null) {
                oI(true);
            } else {
                oI(false);
            }
        }
    }

    public void oI(boolean z) {
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
        this.baF = new NewWriteModel(this);
        this.baF.b(this.baT);
        registerListener(this.idc);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bAu();
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
            this.icp = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.icq = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.icw = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.icx = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.baD = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.ibK = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.ibK != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.icy = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.icZ = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.eig = bundle.getString("KEY_CALL_FROM");
            this.hWc = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.icp = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.icq = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.icw = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.icx = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.ibK = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.ibK != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.icy = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.icZ = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.eig = intent.getStringExtra("KEY_CALL_FROM");
            this.hWc = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.icp);
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
        this.fzk = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ibD = true;
        }
        bQK();
        try {
            this.icN = bRp();
        } catch (Throwable th) {
            this.icN = null;
        }
    }

    private void bQT() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.heU.setText(com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName)));
            this.heU.setMovementMethod(com.baidu.tieba.view.c.bNx());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString iH = com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName));
            if (iH != null) {
                this.heU.setText(iH);
            }
            this.ibY.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String iI;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bQR().getText().toString()) || this.icV || ((this.icp || this.ibD) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            iI = this.mData.getTitle();
                        } else {
                            iI = com.baidu.tbadk.plugins.b.iI(str);
                        }
                        SpannableString iH = com.baidu.tbadk.plugins.b.iH(iI);
                        if (iH != null) {
                            bQR().setText(iH);
                            bQR().setSelection(iH.length() > iI.length() ? iI.length() : iH.length());
                        }
                    } else {
                        SpannableString iH2 = com.baidu.tbadk.plugins.b.iH(this.mData.getTitle());
                        if (iH2 != null) {
                            bQR().setText(iH2);
                            bQR().setSelection(this.mData.getTitle().length() > iH2.length() ? iH2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bQJ();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bQQ().getText().toString()) || this.icp || this.ibD) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.NL().a(getPageContext().getPageActivity(), this.mData.getContent(), this.ice);
                    bQQ().setText(a2);
                    bQQ().setSelection(a2.length());
                    if (this.ibW) {
                        a(this.icJ, this.icD);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bRo();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bQZ();
                    }
                    oK(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bRj();
                }
                bAC();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.ibP != null) {
                    this.ibT = this.ibQ.dOM;
                    this.ibS = this.ibQ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.ibP.size()) {
                            break;
                        }
                        x xVar = this.ibP.get(i);
                        if (categoryTo != xVar.dOM) {
                            i++;
                        } else {
                            this.ibT = categoryTo;
                            this.ibS = xVar.name;
                            this.mData.setCategoryTo(this.ibT);
                            break;
                        }
                    }
                    if (this.ibU != null) {
                        this.ibU.setText(this.ibS);
                        this.ibU.setCategoryContainerData(this.ibP, this.ibQ, this.ibT);
                    }
                }
                this.aZb.KM();
                return;
            }
            return;
        }
        bRj();
        bQJ();
    }

    private void bRj() {
        if ((!this.ibW || this.icC != null) && this.icB != null) {
            this.icC.c(this.writeImagesInfo);
            bRm();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.icw);
        if (this.icp) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.baD);
        if (this.ibK != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ibK));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.icy);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.eig);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hWc);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bQQ().getEditableText().toString();
        if (obj != null) {
            bQQ().setText(TbFaceManager.NL().a(getPageContext().getPageActivity(), obj, this.ice));
            bQQ().setSelection(bQQ().getText().length());
        }
    }

    private String bQU() {
        return (bQQ() == null || bQQ().getText() == null) ? "" : bQQ().getText().toString();
    }

    private String bQV() {
        if (this.mData == null || bQR() == null || bQR().getVisibility() != 0 || bQR().getText() == null) {
            return "";
        }
        String obj = bQR().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.heC != v.H(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.heZ != null && this.heZ.getText() != null) {
            this.mData.setPostPrefix(this.heZ.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void yg(String str) {
        if (this.mData != null && this.ibF != null) {
            if (this.ibF.getVisibility() == 0) {
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
    public void bQW() {
        bAu();
        this.mData.setContent(bQU());
        yg(bQV());
        if (this.icp || this.ibD) {
            String string = getResources().getString(e.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                yg(string + this.mData.getTitle());
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
        if (this.ibR >= 0) {
            this.mData.setCategoryFrom(this.ibR);
        }
        if (this.ibT >= 0) {
            this.mData.setCategoryTo(this.ibT);
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
        this.mData.setHasLocationData(this.baE != null && this.baE.amL());
        if (this.writeImagesInfo != null) {
            this.baF.nD(this.writeImagesInfo.size() > 0);
        }
        if (!v.I(this.mList) && this.ibX != null && this.ibX.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.ibX.mForumId));
            this.mData.setForumName(this.ibX.mForumName);
        }
        this.baF.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.baF.getWriteData().setVoice(this.mVoiceModel.getId());
                this.baF.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.baF.getWriteData().setVoice(null);
                this.baF.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.baF.getWriteData().setVoice(null);
            this.baF.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.baF.bGe()) {
            showToast(e.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
            this.baF.startPostWrite();
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
            if (this.ibK != null) {
                i2 = this.ibK.getTotalCount();
                i = this.ibK.getAlreadyCount() + 1;
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
                if (this.heU == getCurrentFocus()) {
                    bQQ().clearFocus();
                    this.heU.requestFocus();
                    if (this.aZb != null) {
                        this.aZb.KM();
                    }
                    ShowSoftKeyPadDelay(this.heU);
                } else {
                    bQQ().requestFocus();
                    if (this.aZb != null) {
                        this.aZb.KM();
                    }
                    ShowSoftKeyPadDelay(this.heY);
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
                            bQQ().getText().insert(bQQ().getSelectionStart(), sb.toString());
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
                                bRn();
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
                        if (this.ida) {
                            oJ(true);
                            this.ida = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.ibW) {
                        B(intent);
                        bAC();
                        return;
                    }
                    aj(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aZb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bAC();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ibC) {
                                sb2.append(com.baidu.tbadk.plugins.b.bin);
                                this.ibC = false;
                            }
                            sb2.append(stringExtra);
                            hY(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.ibX = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.ibX);
                }
            }
        } else if (i2 == 0) {
            if (this.aZb != null && !this.aZb.Ms()) {
                this.heY.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aZb.KM();
            }
            switch (i) {
                case 12001:
                    MX();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bRl();
                    if (this.ida) {
                        oJ(true);
                        this.ida = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.heU == getCurrentFocus()) {
                        bQQ().clearFocus();
                        this.heU.requestFocus();
                        if (this.aZb != null) {
                            this.aZb.KM();
                        }
                        ShowSoftKeyPadDelay(this.heU);
                        return;
                    }
                    bQQ().requestFocus();
                    if (this.aZb != null) {
                        this.aZb.KM();
                    }
                    ShowSoftKeyPadDelay(this.heY);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.icc.xK(postWriteCallBackData.getErrorString());
                        this.icc.aA(postWriteCallBackData.getSensitiveWords());
                        this.icc.b(this.heU, this.heY);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.baD = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.baD);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bRl();
                    return;
                case 25004:
                    if ("from_title".equals(this.ibB)) {
                        bQR().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ibB)) {
                        bQQ().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQX() {
        if ("1".equals(this.eig)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.eig)) {
            this.mData.setCanNoForum(false);
        }
        bQY();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.eig);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bQW();
    }

    private void bQY() {
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bRk() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bRl() {
        if (this.ibW) {
            this.icC.c(this.writeImagesInfo);
            bRm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRm() {
        this.icC.notifyDataSetChanged();
        this.icB.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.icC.notifyDataSetChanged();
                WriteActivity.this.icB.invalidateViews();
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
        bAC();
    }

    private void ai(Intent intent) {
        if (this.ibW) {
            aj(intent);
            bRl();
        } else {
            am(intent);
        }
        bAC();
    }

    private void aj(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bRl();
            oK(true);
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

    private void bRn() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.icz.parseJson(stringExtra);
            this.icz.updateQuality();
            if (this.icz.getChosedFiles() != null && this.icz.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.icz.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.icz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bQR());
        HidenSoftKeyPad(this.mInputManager, bQQ());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.baD = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.baD;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.baD, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bRo();
            bQZ();
        }
        oK(true);
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
                bRo();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bQZ();
                }
            }
            oK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRo() {
        if (this.aZb.fL(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void MX() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.baD));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oK(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.icA != null) {
            this.icA.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aCj() {
        this.dLz = getVoiceManager();
        this.dLz.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dMD) != null) {
                    TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDn));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.ibK == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.baK = i;
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bQZ() {
        if (!this.ibW) {
            if (this.aZb != null) {
                this.aZb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aZb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.icA != null) {
                this.icA.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.ibI.size()) {
            for (int i2 = 0; i2 < this.ibI.size(); i2++) {
                this.ibI.get(i2).oy(false);
            }
            this.ibI.get(i).oy(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void vj(int i) {
        if (i == v.H(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").y("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").y("obj_type", 2));
        }
        this.heC = i;
        this.hfa.setCurrentIndex(i);
        xI(i);
        this.heZ.setText(this.mPrefixData.getPrefixs().get(i));
        bAC();
        com.baidu.adp.lib.g.g.a(this.hfa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.hfc.setSelected(false);
        al.c(this.hfb, e.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.heY);
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
            MR();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.aX(getApplicationContext())) {
                ak.a(getPageContext(), this.baD);
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
        this.icb = z;
        if (this.icT && System.currentTimeMillis() - this.icU < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.icT = false;
        }
        if (this.ica != null && !z) {
            this.ica.bmw();
        }
        if (this.icd != null && !z) {
            bQC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.icQ != null) {
            yi(str);
            this.icQ.dismiss();
        }
    }

    private void dj(Context context) {
        icS = l.aQ(context);
    }

    private void yi(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.icT = true;
        bRo();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bQZ();
        }
        oK(true);
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

    private File bRp() {
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

    private void bRq() {
        if (this.icN != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            dj(getActivity());
            this.icP = getPageContext().getPageActivity().getLayoutInflater().inflate(e.h.rec_dialog, (ViewGroup) null);
            this.icP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.icN != null) {
                        WriteActivity.this.yh(WriteActivity.this.icN.getAbsolutePath());
                    }
                }
            });
            this.icO = (TbImageView) this.icP.findViewById(e.g.rec_img_view);
            this.icR = (LinearLayout) this.icP.findViewById(e.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.icN.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.icN.getAbsolutePath());
                Bitmap f = f(this.icN.getAbsolutePath(), getResources().getDimensionPixelSize(e.C0210e.ds160));
                if (f != null) {
                    this.icO.setImageBitmap(f);
                    this.icO.setDrawBorder(true);
                    this.icO.setBorderWidth(2);
                    this.icO.setBorderColor(al.getColor(e.d.common_color_10264));
                    this.icQ = new Dialog(getActivity(), e.k.bubble_dialog);
                    this.icQ.setCanceledOnTouchOutside(true);
                    this.icQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.icT) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.icU = System.currentTimeMillis();
                            }
                        }
                    });
                    this.icQ.setContentView(this.icP);
                    this.icQ.show();
                    Window window = this.icQ.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(e.C0210e.ds28);
                    attributes.y = (icS / 18) + getResources().getDimensionPixelSize(e.C0210e.ds12);
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
        if (this.icb && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ibC = false;
            this.ibB = "";
            if ("from_content".equals(str)) {
                this.ibB = "from_content";
            } else if ("from_title".equals(str)) {
                this.ibB = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.iG(String.valueOf(charSequence.charAt(i)))) {
                oH(false);
            }
        }
    }

    public void bwG() {
        if (this.icp || !v.I(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.ibF.setVisibility(0);
            this.ibF.requestFocus();
            this.aZb.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.ibF.setVisibility(8);
    }
}
