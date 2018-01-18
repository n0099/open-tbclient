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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.a;
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
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0036a, VoiceManager.c, u.a, e.a {
    private static int hJS = 0;
    private com.baidu.tbadk.editortools.i bqg;
    private String brI;
    private LocationModel brJ;
    private NewWriteModel brK;
    private VoiceManager dBh;
    private LinearLayout fLL;
    private PlayVoiceBntNew fLM;
    private ImageView fLO;
    private int gNF;
    private TextView gNZ;
    private com.baidu.tieba.write.e gOa;
    private ImageView gOb;
    private View gOc;
    private com.baidu.tieba.write.b hGn;
    private LinearLayout hIG;
    private LinearLayout hIH;
    private View hIJ;
    private Toast hIK;
    private AdditionData hIL;
    private RelativeLayout hIM;
    private TextView hIN;
    private TextView hIO;
    private TextView hIP;
    List<z> hIQ;
    z hIR;
    private int hIS;
    private String hIT;
    private int hIU;
    private PostCategoryView hIV;
    private HotTopicBussinessData hIY;
    private View hIZ;
    private f hJA;
    private View hJa;
    private TextView hJb;
    private TextView hJc;
    private com.baidu.tieba.write.editor.d hJg;
    private com.baidu.tieba.write.b hJh;
    private com.baidu.tieba.view.d hJn;
    private View hJt;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hID = "";
    private boolean hIE = false;
    private WriteData mData = null;
    private boolean hJp = false;
    private boolean hIF = false;
    private boolean hJq = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gNW = null;
    private HeadImageView hJr = null;
    private View gNX = null;
    private LinearLayout cwp = null;
    private EditText cwo = null;
    private FeedBackModel hII = null;
    private FeedBackTopListView hJs = null;
    private ArrayList<com.baidu.tieba.write.d> hHz = new ArrayList<>();
    private String fkh = null;
    private final KeyEvent don = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View beJ = null;
    private TextView hJu = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hJv = null;
    private final Handler mHandler = new Handler();
    private boolean hJw = false;
    private String hJx = null;
    private RelativeLayout mParent = null;
    private String brO = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brP = 0;
    private int hJy = 0;
    private WriteImagesInfo hJz = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hJB = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hJC = null;
    private ScrollView hIW = null;
    private EditText hJD = null;
    private View hJE = null;
    private View hJF = null;
    private View hJG = null;
    private EditText hJH = null;
    private TextView hJI = null;
    private TextView hJJ = null;
    private TextWatcher hJK = null;
    private TextWatcher hJL = null;
    private boolean hIX = false;
    private boolean hJM = false;
    private com.baidu.tbadk.core.view.b bAA = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hJN = null;
    private TbImageView hJO = null;
    private View hJP = null;
    private Dialog hJQ = null;
    private LinearLayout hJR = null;
    private boolean hJT = false;
    private long hJU = -1000;
    private boolean hJV = false;
    private String hnU = "2";
    private int hCL = 0;
    private String hJW = "";
    private String hJd = "";
    private int hJe = 0;
    private SpannableStringBuilder hJf = new SpannableStringBuilder();
    private boolean hJX = false;
    private final HttpMessageListener hJY = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fkh)) {
                    WriteActivity.this.fkh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nH(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fkh)) {
                    WriteActivity.this.fkh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fkh);
                    WriteActivity.this.nH(true);
                }
            }
        }
    };
    private TbFaceManager.a hJi = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gu(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.si());
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
    private final AntiHelper.a dCc = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVV));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVV));
        }
    };
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.aun();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hGn.av(null);
                WriteActivity.this.hGn.nq(false);
                WriteActivity.this.hJh.av(null);
                WriteActivity.this.hJh.nq(false);
                if (z) {
                    WriteActivity.this.ci(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                u.b(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                u.c(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.E(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hJW)) {
                            TiebaStatic.log(new ak("c11731").ab("obj_id", WriteActivity.this.hJW));
                        }
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hGn.av(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hJh.av(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hGn.tZ(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hJh.tZ(postWriteCallBackData.getErrorString());
                    if (!v.E(WriteActivity.this.hGn.bEM())) {
                        WriteActivity.this.nz(true);
                        WriteActivity.this.nF(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FA());
                    if (com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Fz());
                        if (WriteActivity.this.hJq) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a brW = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Lj() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gi(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwl())) {
                WriteActivity.this.b(2, true, aVar.bwl());
            } else {
                gi(null);
            }
        }
    };
    private final CustomMessageListener hav = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.brJ.mC(false);
                    WriteActivity.this.brJ.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.brJ.mC(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hJj = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hJk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHu = WriteActivity.this.bHu();
            if (bHu >= 0 && bHu < WriteActivity.this.cwo.getText().length()) {
                WriteActivity.this.cwo.setSelection(bHu);
            }
        }
    };
    private boolean hJl = true;
    private final View.OnFocusChangeListener cwv = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gNW || view == WriteActivity.this.beJ || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hJl = true;
                    WriteActivity.this.bHv();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gNW);
                    if (WriteActivity.this.bqg != null) {
                        WriteActivity.this.bqg.IE();
                    }
                } else if (view == WriteActivity.this.gNW) {
                    WriteActivity.this.gNZ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.cwo && z) {
                WriteActivity.this.hJl = false;
                WriteActivity.this.bHv();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.cwo);
                if (WriteActivity.this.bqg != null) {
                    WriteActivity.this.bqg.IE();
                }
            }
            WriteActivity.this.bHy();
        }
    };
    private TextWatcher cwx = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bru();
            if (WriteActivity.this.hJh != null) {
                if (!WriteActivity.this.hJh.bEP()) {
                    WriteActivity.this.nF(false);
                }
                WriteActivity.this.hJh.nr(false);
                WriteActivity.this.bHz();
            }
        }
    };
    private TextWatcher hJm = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bru();
            if (WriteActivity.this.hGn != null) {
                if (!WriteActivity.this.hGn.bEP()) {
                    WriteActivity.this.nz(false);
                }
                WriteActivity.this.hGn.nr(false);
            }
        }
    };
    private final a.InterfaceC0152a fSu = new a.InterfaceC0152a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0152a
        public void onRefresh() {
            WriteActivity.this.fkh = null;
            WriteActivity.this.nH(false);
            WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(boolean z) {
        if (bHK() != null && bHK().getVisibility() == 0 && bHK().getText() != null) {
            int selectionEnd = bHK().getSelectionEnd();
            SpannableStringBuilder b = this.hJh.b(bHK().getText());
            if (b != null) {
                this.hJh.nr(true);
                bHK().setText(b);
                if (z && this.hJh.bEN() >= 0) {
                    bHK().requestFocus();
                    bHK().setSelection(this.hJh.bEN());
                } else {
                    bHK().setSelection(selectionEnd);
                }
                this.hJh.nq(this.hJh.bEN() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (bHJ() != null && bHJ().getText() != null) {
            int selectionEnd = bHJ().getSelectionEnd();
            SpannableStringBuilder b = this.hGn.b(bHJ().getText());
            if (b != null) {
                this.hGn.nr(true);
                bHJ().setText(b);
                if (z && this.hGn.bEN() >= 0) {
                    bHJ().requestFocus();
                    bHJ().setSelection(this.hGn.bEN());
                } else {
                    bHJ().setSelection(selectionEnd);
                }
                this.hGn.nq(this.hGn.bEN() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void KV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            KW();
        } else if (this.brJ.bwt()) {
            KU();
        } else {
            this.brJ.mC(false);
            b(1, true, null);
            this.brJ.bwr();
        }
    }

    private void KW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oI()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.brJ.agj();
                } else {
                    WriteActivity.this.brW.Lj();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHu() {
        int selectionEnd = bHJ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHJ().getText().getSpans(0, bHJ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHJ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHJ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        if (this.bqg != null) {
            this.bqg.setBarLauncherEnabled(!this.hJl);
            this.bqg.g(true, 26);
            this.bqg.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hIX) {
            this.gNW.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hJG.setVisibility(8);
            } else {
                this.hJG.setVisibility(0);
            }
            a(this.hJJ, this.hJD);
            a(this.hJI, this.hJH);
            bru();
        }
        if (this.hJp) {
            this.hJl = true;
            bHv();
            if (this.bqg != null) {
                this.bqg.IE();
            }
            this.gNW.requestFocus();
            ShowSoftKeyPadDelay(this.gNW);
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
            bIg();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bHR();
            }
            nI(true);
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
        this.hJh = new com.baidu.tieba.write.b();
        this.hJh.xg(d.C0107d.cp_cont_i);
        this.hJh.xh(d.C0107d.cp_cont_h_alpha85);
        this.hGn = new com.baidu.tieba.write.b();
        this.hGn.xg(d.C0107d.cp_cont_i);
        this.hGn.xh(d.C0107d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            xM(this.hCL);
        }
        initUI();
        bHW();
        this.brJ = new LocationModel(this);
        this.brJ.a(this.brW);
        registerListener(this.hav);
        registerListener(this.hJj);
        initEditor();
        bIi();
        if (this.hIX) {
            this.hJC.setEditorTools(this.bqg);
        } else {
            this.cwo.requestFocus();
        }
        IG();
        bHR();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bqg = new com.baidu.tbadk.editortools.i(getActivity());
        this.bqg.setBarMaxLauCount(5);
        this.bqg.setMoreButtonAtEnd(true);
        this.bqg.setBarLauncherType(1);
        this.bqg.ca(true);
        this.bqg.cb(true);
        this.bqg.setMoreLauncherIcon(d.f.write_more);
        this.bqg.setBackgroundColorId(d.C0107d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bHU();
                break;
            default:
                bHw();
                break;
        }
        this.bqg.Kv();
        if (this.hIG != null) {
            this.hIG.addView(this.bqg);
        }
        bHx();
        this.bqg.th();
        com.baidu.tbadk.editortools.l hH = this.bqg.hH(6);
        if (hH != null && !TextUtils.isEmpty(this.brO)) {
            ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.brO);
                }
            });
        }
        if (!this.hIX) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bqg.IE();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bHS() {
        this.hJE = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hJG = this.hJE.findViewById(d.g.live_post_title_container);
        this.hJD = (EditText) this.hJE.findViewById(d.g.live_post_content);
        this.hJB = (GridView) this.hJE.findViewById(d.g.photoLiveGridView);
        this.hJH = (EditText) this.hJE.findViewById(d.g.live_post_title);
        this.hJI = (TextView) this.hJE.findViewById(d.g.titleOverPlusNumber);
        this.hJJ = (TextView) this.hJE.findViewById(d.g.contentOverPlusNumber);
        this.hJF = this.hJE.findViewById(d.g.live_interval_view);
        this.hJI.setText(String.valueOf(20));
        this.hJJ.setText(String.valueOf(233));
        this.hJE.setVisibility(0);
        this.hJI.setVisibility(0);
        this.hJJ.setVisibility(0);
        this.hJH.setHint(d.j.tips_title_limit_new);
        this.hJH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hJM = true;
                    WriteActivity.this.hJl = true;
                    WriteActivity.this.bHv();
                    if (WriteActivity.this.bqg != null) {
                        WriteActivity.this.bqg.IE();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hJD.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hJD.setHint(d.j.live_write_input_content_update);
        }
        this.hJD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hJM = false;
                    WriteActivity.this.hJl = false;
                    WriteActivity.this.bHv();
                    if (WriteActivity.this.bqg != null) {
                        WriteActivity.this.bqg.IE();
                    }
                }
            }
        });
        this.hJD.requestFocus();
        this.hJD.addTextChangedListener(bHY());
        this.hJH.requestFocus();
        this.hJH.addTextChangedListener(bHY());
        this.hJH.setOnClickListener(this.hJk);
        this.hJD.setOnClickListener(this.hJk);
        this.hJC = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hJB);
        this.hJC.xy(6);
        this.hJB.setAdapter((ListAdapter) this.hJC);
        View findViewById = this.hJE.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bGE() {
                WriteActivity.this.aSa();
            }
        });
        bHT();
    }

    private void bHT() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hJH.setText(this.mData.getTitle());
                this.hJH.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hIX) {
            bId();
        }
        if (this.bqg.Kx()) {
            this.bqg.IE();
        }
        xM(0);
    }

    private void xM(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hnU);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHU() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bqg.I(arrayList);
        r hJ = this.bqg.hJ(5);
        if (hJ != null) {
            hJ.bqP = 2;
            hJ.bqN = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.bqN = d.f.write_at;
        this.bqg.b(aVar);
        this.bqg.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bHw() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.bqN = d.f.write_picture;
        this.bqg.b(dVar);
        Boolean bIb = bIb();
        if (!this.hJp && bIb != null && bIb.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bwQ() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.bqP = 3;
            rVar5.bqN = d.f.write_recorder;
            this.bqg.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.bqN = d.f.write_at;
        this.bqg.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.bqP = 5;
            rVar4.bqN = d.f.write_privilege;
            this.bqg.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.bqP = 6;
            rVar3.bqN = this.hJp ? d.f.write_location : d.f.icon_post_more_location;
            this.bqg.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bqg.b(aVar2);
        aVar2.bqN = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.bqR = true;
            rVar2.bqP = 9;
            rVar2.bqN = 0;
            this.bqg.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.bqR = true;
            rVar.bqP = 10;
            rVar.bqN = 0;
            this.bqg.b(rVar);
        }
        if (this.hIL == null) {
            if (this.hJg == null) {
                this.hJg = new com.baidu.tieba.write.editor.d(getActivity(), this.hnU);
                this.hJg.aN(this.mData.getForumId(), this.privateThread);
            }
            this.bqg.b(this.hJg);
        }
        this.bqg.I(arrayList);
        r hJ = this.bqg.hJ(5);
        if (hJ != null) {
            hJ.bqP = 1;
            hJ.bqN = d.f.write_emotion;
        }
    }

    private void bHx() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bHI()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bHI()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bHL();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bbz();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIg();
                        WriteActivity.this.bru();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xN(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hIL == null) {
                            WriteActivity.this.KX();
                            return;
                        }
                        switch (WriteActivity.this.brP) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    WriteActivity.this.KV();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.KU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.brJ != null) {
                            WriteActivity.this.brJ.mC(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fkh = null;
                        } else {
                            WriteActivity.this.fkh = (String) aVar.data;
                        }
                        WriteActivity.this.nH(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ab(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bqg.Kx()) {
                                        WriteActivity.this.bqg.IE();
                                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bru();
                        if (WriteActivity.this.cwo != null) {
                            WriteActivity.this.cwo.requestFocus();
                        }
                        WriteActivity.this.bqg.IE();
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwo);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hIE = true;
                        WriteActivity.this.nG(true);
                        if (WriteActivity.this.bHK().isFocused()) {
                            WriteActivity.this.hID = "from_title";
                        } else if (WriteActivity.this.bHJ().isFocused()) {
                            WriteActivity.this.hID = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hIH.setVisibility(0);
                        WriteActivity.this.hIH.requestFocus();
                        WriteActivity.this.bru();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hIH.hasFocus()) {
                            WriteActivity.this.cwo.requestFocus();
                            WriteActivity.this.cwo.setSelection(WriteActivity.this.cwo.getText().toString().length());
                        }
                        WriteActivity.this.hIH.setVisibility(8);
                        WriteActivity.this.bru();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bqg.a(16, bVar);
        this.bqg.a(14, bVar);
        this.bqg.a(24, bVar);
        this.bqg.a(3, bVar);
        this.bqg.a(10, bVar);
        this.bqg.a(11, bVar);
        this.bqg.a(12, bVar);
        this.bqg.a(13, bVar);
        this.bqg.a(15, bVar);
        this.bqg.a(18, bVar);
        this.bqg.a(20, bVar);
        this.bqg.a(25, bVar);
        this.bqg.a(27, bVar);
        this.bqg.a(29, bVar);
        this.bqg.a(43, bVar);
        this.bqg.a(45, bVar);
        this.bqg.a(53, bVar);
        this.bqg.a(48, bVar);
        this.bqg.a(46, bVar);
        this.bqg.a(49, bVar);
        this.bqg.a(47, bVar);
        this.bqg.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        if (this.brJ.agf()) {
            if (this.brJ.bwt()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwp().getLocationData().bwl());
                return;
            }
            b(1, true, null);
            this.brJ.bwr();
            return;
        }
        b(0, true, null);
    }

    protected void brm() {
        if (this.brK != null) {
            this.brK.cancelLoadData();
        }
        if (this.hII != null) {
            this.hII.cancelLoadData();
        }
        if (this.brJ != null) {
            this.brJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        brm();
        bIa();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hJA != null) {
            this.hJA.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGP() {
        if (this.mData != null && this.mData.getType() == 2 && this.hJw) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bHK().getText().toString());
            this.mData.setContent(bHJ().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b("24591571", this.mData);
                }
            } else if (type == 1) {
                u.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                u.b(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                u.c(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gOa != null && this.gOa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gOa, getPageContext().getPageActivity());
                return true;
            } else if (this.bqg.Kx()) {
                this.bqg.IE();
                return true;
            } else {
                brm();
                bGP();
                return true;
            }
        }
        if (i == 67 && (text = bHJ().getText()) != null) {
            int selectionStart = bHJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHJ().onKeyDown(67, this.don);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.mParent);
        getLayoutMode().aM(this.hJR);
        if (this.hJO != null && i == 1) {
            this.hJO.setBorderColor(aj.getColor(d.C0107d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0107d.cp_link_tip_a, 1);
        bHv();
        aj.t(this.hJE, d.C0107d.cp_bg_line_d);
        aj.t(this.gNX, d.C0107d.cp_bg_line_c);
        aj.t(this.hJF, d.C0107d.cp_bg_line_c);
        aj.t(bHK(), d.C0107d.cp_bg_line_d);
        aj.c(this.fLO, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fkh)) {
            aj.t(bHJ(), d.C0107d.cp_bg_line_d);
        }
        bru();
        this.bqg.onChangeSkinType(i);
        if (this.hIV != null) {
            this.hIV.DR();
        }
        aj.r(this.mName, d.C0107d.cp_cont_b);
        bHy();
        bHz();
        if (this.hGn != null) {
            this.hGn.onChangeSkinType();
        }
        if (this.hJh != null) {
            this.hJh.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.gNW.hasFocus()) {
            this.gNW.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        } else {
            this.gNW.setHintTextColor(aj.getColor(d.C0107d.cp_cont_d));
        }
        if (this.cwo.hasFocus()) {
            this.cwo.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        } else {
            this.cwo.setHintTextColor(aj.getColor(d.C0107d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHz() {
        if (this.gNW != null && this.gNW.getText() != null && this.gNW.getText().toString() != null && this.gNW.getPaint() != null) {
            if (this.gNW.getText().toString().length() == 0) {
                this.gNW.getPaint().setFakeBoldText(false);
            } else if (this.gNW.getText().toString().length() > 0) {
                this.gNW.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bAA = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hIX = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0107d.cp_cont_b);
        this.hJu = (TextView) findViewById(d.g.btn_image_problem);
        bHB();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwv);
        this.hIW = (ScrollView) findViewById(d.g.write_scrollview);
        this.hIW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.cwo != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.cwo);
                    }
                    if (WriteActivity.this.bqg != null) {
                        WriteActivity.this.bqg.IE();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hJs = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hJt = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hIG = (LinearLayout) findViewById(d.g.tool_view);
        this.hIG.setContentDescription("..");
        this.hIH = (LinearLayout) findViewById(d.g.title_view);
        this.gNX = findViewById(d.g.interval_view);
        this.hIZ = findViewById(d.g.hot_topic_fourm_view);
        this.hJa = findViewById(d.g.hot_topic_divider);
        this.hJb = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hJc = (TextView) findViewById(d.g.change_one_tv);
        brt();
        if (this.hIX) {
            this.hIW.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bHS();
        } else {
            this.hJA = new f(getPageContext(), this.mRootView);
            f fVar = this.hJA;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nx(z);
        }
        afd();
        if (this.hJp || this.hIF) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWE) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.cwp = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwp.setDrawingCacheEnabled(false);
        this.cwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cwo.requestFocus();
                WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fLL = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fLM = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fLO = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bbz();
            }
        });
        this.beJ.setOnFocusChangeListener(this.cwv);
        this.beJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.brm();
                WriteActivity.this.bGP();
            }
        });
        this.hJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bHE();
        i(bIb());
        bHG();
        bHA();
        bHX();
        bHZ();
        bHv();
        bHF();
        brs();
        bHM();
        if (this.mData.getType() == 4 && this.gOc != null && this.hIJ != null) {
            this.gOc.setVisibility(8);
            this.hIJ.setVisibility(8);
        }
        bru();
        bHV();
    }

    private void bHA() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hJp || this.hIF) {
                        if (this.hJq) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hnU != null && this.hnU.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hnU != null && this.hnU.equals("2")) {
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
                    this.gNW.setVisibility(0);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gNW.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hJF.setVisibility(8);
                    return;
                case 7:
                    this.gNW.setVisibility(0);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bHB() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bHC() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hJp && !this.hIF && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHK() != null) {
                bHK().setText(d);
                bHK().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fLL.setVisibility(0);
            this.fLM.setVoiceModel(voiceModel);
            this.fLM.bwP();
            bru();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbz() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eG(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fLL.setVisibility(8);
        this.fLM.aCB();
        this.fLM.setVoiceModel(null);
        r hJ = this.bqg.hJ(6);
        if (hJ != null && hJ.bqa != null) {
            hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bru();
    }

    private void bHD() {
        this.hIQ = null;
        this.hIS = -1;
        this.hIU = -1;
        com.baidu.tieba.frs.ab mZ = aa.avi().mZ(1);
        if (mZ != null) {
            this.hIQ = mZ.dDT;
            this.hIS = getIntent().getIntExtra("category_id", -1);
            if (this.hIQ != null && !this.hIQ.isEmpty() && this.hIS >= 0) {
                this.hIR = new z();
                this.hIR.dDP = 0;
                this.hIR.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hIU = this.hIR.dDP;
                this.hIT = this.hIR.name;
                for (z zVar : this.hIQ) {
                    if (zVar.dDP == this.hIS) {
                        this.hIU = zVar.dDP;
                        this.hIT = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHE() {
        if (this.hIQ != null && !this.hIQ.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hIV = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hIV.setText(this.hIT);
            this.hIV.b(this.hIQ, this.hIR, this.hIU);
            this.hIV.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hIV.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dDP);
                        WriteActivity.this.hIU = avVar.dDP;
                        WriteActivity.this.hIV.bGH();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hIV.bGG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                }
            });
        }
    }

    private void bHV() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hJn = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hJn.setTitle(d.j.no_disturb_start_time);
        this.hJn.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hJn);
        this.hJn.setButton(-2, getPageContext().getString(d.j.cancel), this.hJn);
        return this.hJn;
    }

    private void bHF() {
        this.hIM = (RelativeLayout) findViewById(d.g.addition_container);
        this.hIN = (TextView) findViewById(d.g.addition_create_time);
        this.hIO = (TextView) findViewById(d.g.addition_last_time);
        this.hIP = (TextView) findViewById(d.g.addition_last_content);
        if (this.hIL != null) {
            this.hIM.setVisibility(0);
            this.hIN.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hIL.getCreateTime() * 1000));
            if (this.hIL.getAlreadyCount() == 0) {
                this.hIO.setVisibility(8);
            } else {
                this.hIO.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hIL.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hIL.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hIP.setText(lastAdditionContent);
            } else {
                this.hIP.setVisibility(8);
            }
            bHJ().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hIL.getAlreadyCount()), Integer.valueOf(this.hIL.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hIM.setVisibility(8);
    }

    private void brs() {
        this.gOc = findViewById(d.g.post_prefix_layout);
        this.gNZ = (TextView) findViewById(d.g.post_prefix);
        this.hIJ = findViewById(d.g.prefix_divider);
        this.gOb = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gOc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gNF = 1;
            this.gOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gNZ.setVisibility(0);
                    WriteActivity.this.gOc.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gOa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bqg.IE();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gNW);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwo);
                }
            });
            this.gOb = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gOb.setVisibility(0);
                this.gNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gNZ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gOa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bqg.IE();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                    }
                });
            }
            this.gOa = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gOa.a(this);
            this.gOa.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gOa.setOutsideTouchable(true);
            this.gOa.setFocusable(true);
            this.gOa.setOnDismissListener(this);
            this.gOa.setBackgroundDrawable(aj.getDrawable(d.C0107d.cp_bg_line_d));
            int color = aj.getColor(d.C0107d.cp_cont_b);
            int color2 = aj.getColor(d.C0107d.cp_cont_c);
            aj.s(this.gNZ, d.C0107d.cp_bg_line_d);
            aj.c(this.gOb, d.f.icon_frs_arrow_n);
            this.gNZ.setTextColor(color);
            this.hHz.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hHz.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gOa.addView(dVar);
            }
            this.gOa.setCurrentIndex(0);
            this.gNZ.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gOc.setVisibility(8);
    }

    private void bHW() {
        if (this.hJp && this.mData != null) {
            this.hJs.setVisibility(0);
            this.hJt.setVisibility(0);
            this.hII = new FeedBackModel(getPageContext());
            this.hII.uw(this.mData.getForumName());
            this.hII.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hJs.setVisibility(8);
                        WriteActivity.this.hJt.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hJs.setVisibility(8);
                        WriteActivity.this.hJt.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hJs.a(feedBackModel.bHj(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bHG() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hJh.bEO()) {
                        WriteActivity.this.showToast(WriteActivity.this.hJh.bEQ());
                        WriteActivity.this.nF(true);
                    } else if (WriteActivity.this.hGn.bEO()) {
                        WriteActivity.this.showToast(WriteActivity.this.hGn.bEQ());
                        WriteActivity.this.nz(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHK());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                        WriteActivity.this.bqg.IE();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hJp) {
                                WriteActivity.this.bGQ();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bHP();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bGQ();
                        }
                        TiebaStatic.log(new ak("c12262").ab("obj_locate", WriteActivity.this.hnU));
                    }
                }
            }
        });
    }

    protected void bHX() {
        this.hJv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hJv.cZ(getPageContext().getString(d.j.is_save_draft)).aV(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bHK().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bHJ().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    u.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                    u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hJv.b(getPageContext());
    }

    protected void brt() {
        this.hJr = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hJr.setIsRound(true);
        this.hJr.setDrawBorder(false);
        this.hJr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dL = o.dL(currentPortrait);
            this.hJr.setUrl(dL);
            this.hJr.startLoad(dL, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hJr.setVisibility(0);
        }
        this.gNW = (EditText) findViewById(d.g.post_title);
        this.gNW.setOnClickListener(this.hJk);
        this.gNW.setOnFocusChangeListener(this.cwv);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gNW.setText(this.mData.getTitle());
                this.gNW.setSelection(this.mData.getTitle().length());
            } else if (this.hJq) {
                this.gNW.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gNW.addTextChangedListener(this.cwx);
        if (!this.mData.getHaveDraft()) {
            bHC();
            this.hJV = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gNW.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gNW.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bHY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int cwA;
            private EditText rE = null;
            private TextView rz = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bru();
                if (WriteActivity.this.hIX) {
                    this.cwA = this.rE.getSelectionStart();
                    this.rE.setSelection(this.cwA);
                    WriteActivity.this.a(this.rz, this.rE);
                }
                if (this.rE != WriteActivity.this.hJH || WriteActivity.this.hJh == null || WriteActivity.this.hJh.bEP()) {
                    if (this.rE == WriteActivity.this.hJD && WriteActivity.this.hGn != null && !WriteActivity.this.hGn.bEP()) {
                        WriteActivity.this.nz(false);
                    }
                } else {
                    WriteActivity.this.nF(false);
                }
                if (WriteActivity.this.hJh != null) {
                    WriteActivity.this.hJh.nr(false);
                }
                if (WriteActivity.this.hGn != null) {
                    WriteActivity.this.hGn.nr(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hIX || !WriteActivity.this.hJM) {
                    if (WriteActivity.this.hIX) {
                        if (this.rE != WriteActivity.this.hJD || this.rz != WriteActivity.this.hJJ) {
                            this.rE = WriteActivity.this.hJD;
                            this.rz = WriteActivity.this.hJJ;
                        }
                    }
                } else if (this.rE != WriteActivity.this.hJH || this.rz != WriteActivity.this.hJI) {
                    this.rE = WriteActivity.this.hJH;
                    this.rz = WriteActivity.this.hJI;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hIX && this.hJM) {
            if (this.hJK != null) {
                this.hJH.removeTextChangedListener(this.hJK);
            }
            this.hJK = textWatcher;
        } else if (this.hIX) {
            if (this.hJL != null) {
                this.hJD.removeTextChangedListener(this.hJL);
            }
            this.hJL = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.hJD) {
            return 233L;
        }
        if (editText != this.hJH) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long i = i(editText);
            long j = i - j(editText);
            String valueOf = String.valueOf(j);
            if (i == 20) {
                if (j < 0) {
                    if (j < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0107d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0107d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.b.a.u(editText.getText().toString().trim());
    }

    protected void afd() {
        this.cwo = (EditText) findViewById(d.g.post_content);
        this.cwo.setDrawingCacheEnabled(false);
        this.cwo.setOnClickListener(this.hJk);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString V = TbFaceManager.LO().V(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwo.setText(V);
            this.cwo.setSelection(V.length());
        } else if (this.mData.getType() == 2) {
            if (this.hJw) {
                if (this.hJx != null && this.hJx.length() > 0) {
                    this.cwo.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hJx}));
                    this.cwo.setSelection(this.cwo.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.cwo.setText(format);
                this.cwo.setSelection(format.length());
            }
        }
        this.cwo.setOnFocusChangeListener(this.cwv);
        this.cwo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.cwo.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwo.addTextChangedListener(this.hJm);
        if (this.mData.getType() == 0) {
            this.hJX = true;
        } else {
            nH(true);
            this.hJX = false;
        }
        if (this.mData.isUserFeedback()) {
            this.cwo.setHint(d.j.write_input_content);
        } else {
            this.cwo.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nH(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hIX) {
            bHJ().setPadding(0, 0, 0, 0);
            bHJ().setBackgroundDrawable(null);
            aj.t(bHJ(), d.C0107d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fkh) && this.hIL == null) {
                com.baidu.adp.lib.f.c.nl().a(this.fkh, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.si() != null && aVar.sm() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.si(), aVar.si().getNinePatchChunk(), aVar.sm(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bHJ().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bHJ(), true, WriteActivity.this.fSu);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHI() {
        int i = 5000;
        if (this.hIL != null) {
            i = 1000;
        }
        return bHJ().getText() != null && bHJ().getText().length() >= i;
    }

    private void fZ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hID)) {
                this.hID = "";
                bHJ().requestFocus();
                if (bHJ().getText() != null && bHJ().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHJ().getSelectionStart();
                    editable = bHJ().getText();
                }
            } else if ("from_title".equals(this.hID)) {
                this.hID = "";
                bHK().requestFocus();
                if (bHK().getText() != null && bHK().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHK().getSelectionStart();
                    editable = bHK().getText();
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
    public void nG(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHJ().getText().getSpans(0, bHJ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hIK == null) {
                this.hIK = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hIK.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Fr = nVar.Fr();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nl().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bHJ().getSelectionStart(), aVar, Fr);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHJ() != null && bHJ().getText() != null) {
            Bitmap si = aVar.si();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(si);
            int width = si.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, si.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHJ().getSelectionStart() - 1;
                if (bHJ().getText().length() > 1 && selectionStart >= 0 && bHJ().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHJ().getText().insert(bHJ().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHJ().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHJ().getText().insert(bHJ().getSelectionStart(), spannableString2);
            }
            Editable text = bHJ().getText();
            if (text != null) {
                this.hJf.clear();
                this.hJf.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJf);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHJ().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHJ().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHJ().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHJ() {
        return this.hIX ? this.hJD : this.cwo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHK() {
        return this.hIX ? this.hJH : this.gNW;
    }

    protected void bHL() {
        Editable text;
        if (bHJ() != null && (text = bHJ().getText()) != null) {
            int selectionStart = bHJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHJ().onKeyDown(67, this.don);
            }
            bHJ().onKeyDown(67, this.don);
            int selectionStart2 = bHJ().getSelectionStart();
            if (text != null) {
                this.hJf.clear();
                this.hJf.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJf);
                bHJ().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hJp = true;
        }
    }

    private void bHZ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIa() {
        try {
            if (this.hJv != null) {
                this.hJv.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAA.c(null);
        this.bAA.fY(d.j.sending);
        this.bAA.bm(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAA.bm(false);
    }

    private Boolean bIb() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.brO = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bru() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHK() != null) {
                str = bHK().getText().toString();
            }
            if (bHJ() != null) {
                str2 = bHJ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gNF == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hIH.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ee(true);
                            return;
                        }
                    } else if (this.hIH.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ee(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hIH.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ee(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hIX) {
                    ee(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ee(true);
                }
            }
            if (this.mData.getType() == 4) {
                ee(l(this.hJD) && k(this.hJH));
            } else if (this.mData.getType() == 5) {
                ee(l(this.hJD));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                ee(true);
            } else if (this.mData.getVideoInfo() != null) {
                ee(true);
            } else {
                ee(false);
            }
        }
    }

    public void ee(boolean z) {
        if (z) {
            aj.d(this.mPost, d.C0107d.cp_link_tip_a, d.C0107d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.e(this.mPost, d.C0107d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean k(EditText editText) {
        long j = j(editText);
        return j <= 20 && j > 0;
    }

    private boolean l(EditText editText) {
        long j = j(editText);
        if (j > 233) {
            return false;
        }
        return j > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.brK = new NewWriteModel(this);
        this.brK.b(this.brY);
        registerListener(this.hJY);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.brm();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.hJp = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hJq = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hJw = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hJx = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.brI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hIL = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hIL != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hJy = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hJW = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hnU = bundle.getString("KEY_CALL_FROM");
            this.hCL = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hJp = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hJq = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hJw = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hJx = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hIL = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hIL != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hJy = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hJW = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hnU = intent.getStringExtra("KEY_CALL_FROM");
            this.hCL = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hJp);
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
                u.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                u.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            u.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            u.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            u.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.fkh = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hIF = true;
        }
        bHD();
        try {
            this.hJN = bIh();
        } catch (Throwable th) {
            this.hJN = null;
        }
    }

    private void bHM() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hJr.setVisibility(8);
            this.hIZ.setVisibility(0);
            this.hJa.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gNW.setText(com.baidu.tbadk.plugins.a.gM(ux(this.mList.get(0).mTopicName)));
                this.gNW.setMovementMethod(com.baidu.tieba.view.e.bDU());
            }
            this.hJb.setText(this.mList.get(0).mForumName);
            this.gNW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hJd.equals(charSequence.toString())) {
                        WriteActivity.this.hJe = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gM;
                    if (!WriteActivity.this.hJd.equals(editable.toString()) && (gM = com.baidu.tbadk.plugins.a.gM(editable.toString())) != null) {
                        WriteActivity.this.hJd = gM.toString();
                        WriteActivity.this.gNW.setText(gM);
                        if (WriteActivity.this.hJe <= WriteActivity.this.gNW.getText().length()) {
                            WriteActivity.this.gNW.setSelection(WriteActivity.this.hJe);
                        }
                    }
                }
            });
            this.hJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mData.getType() == 7) {
                        TiebaStatic.log("c12016");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 25005, WriteActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gM = com.baidu.tbadk.plugins.a.gM(ux(hotTopicBussinessData.mTopicName));
            if (gM != null) {
                this.gNW.setText(gM);
            }
            this.hJb.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String ux(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.u.a
    public void a(WriteData writeData) {
        String str;
        String ux;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bHK().getText().toString()) || this.hJV || ((this.hJp || this.hIF) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.E(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.f(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            ux = this.mData.getTitle();
                        } else {
                            ux = ux(str);
                        }
                        SpannableString gM = com.baidu.tbadk.plugins.a.gM(ux);
                        if (gM != null) {
                            bHK().setText(gM);
                            bHK().setSelection(gM.length() > ux.length() ? ux.length() : gM.length());
                        }
                    } else {
                        SpannableString gM2 = com.baidu.tbadk.plugins.a.gM(this.mData.getTitle());
                        if (gM2 != null) {
                            bHK().setText(gM2);
                            bHK().setSelection(this.mData.getTitle().length() > gM2.length() ? gM2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bHC();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bHJ().getText().toString()) || this.hJp || this.hIF) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.LO().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hJi);
                    bHJ().setText(a2);
                    bHJ().setSelection(a2.length());
                    if (this.hIX) {
                        a(this.hJJ, this.hJD);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIg();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bHR();
                    }
                    nI(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIc();
                }
                bru();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hIQ != null) {
                    this.hIU = this.hIR.dDP;
                    this.hIT = this.hIR.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hIQ.size()) {
                            break;
                        }
                        z zVar = this.hIQ.get(i);
                        if (categoryTo != zVar.dDP) {
                            i++;
                        } else {
                            this.hIU = categoryTo;
                            this.hIT = zVar.name;
                            this.mData.setCategoryTo(this.hIU);
                            break;
                        }
                    }
                    if (this.hIV != null) {
                        this.hIV.setText(this.hIT);
                        this.hIV.b(this.hIQ, this.hIR, this.hIU);
                    }
                }
                this.bqg.IE();
                return;
            }
            return;
        }
        bIc();
        bHC();
    }

    private void bIc() {
        if ((!this.hIX || this.hJC != null) && this.hJB != null) {
            this.hJC.c(this.writeImagesInfo);
            aSa();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hJw);
        if (this.hJp) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.brI);
        if (this.hIL != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hIL));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hJy);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hnU);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hCL);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHJ().getEditableText().toString();
        if (obj != null) {
            bHJ().setText(TbFaceManager.LO().a(getPageContext().getPageActivity(), obj, this.hJi));
            bHJ().setSelection(bHJ().getText().length());
        }
    }

    private String bHN() {
        return (bHJ() == null || bHJ().getText() == null) ? "" : bHJ().getText().toString();
    }

    private String bHO() {
        if (this.mData == null || bHK() == null || bHK().getVisibility() != 0 || bHK().getText() == null) {
            return "";
        }
        String obj = bHK().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gNF != 0 && this.mData.getType() != 4 && this.gNZ != null && this.gNZ.getText() != null) {
            obj = this.gNZ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uy(String str) {
        if (this.mData != null && this.hIH != null) {
            if (this.hIH.getVisibility() == 0) {
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
    public void bGQ() {
        brm();
        this.mData.setContent(bHN());
        uy(bHO());
        if (this.hJp || this.hIF) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uy(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.oI()) {
                    sb.append(com.baidu.adp.lib.util.j.oQ());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hIS >= 0) {
            this.mData.setCategoryFrom(this.hIS);
        }
        if (this.hIU >= 0) {
            this.mData.setCategoryTo(this.hIU);
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
        this.mData.setHasLocationData(this.brJ != null && this.brJ.agf());
        if (this.writeImagesInfo != null) {
            this.brK.mE(this.writeImagesInfo.size() > 0);
        }
        if (!v.E(this.mList) && this.hIY != null && this.hIY.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hIY.mForumId));
            this.mData.setForumName(this.hIY.mForumName);
        }
        this.brK.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.brK.getWriteData().setVoice(this.mVoiceModel.getId());
                this.brK.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.brK.getWriteData().setVoice(null);
                this.brK.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.brK.getWriteData().setVoice(null);
            this.brK.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.brK.bwR()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oI()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.brK.startPostWrite();
        }
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hIL != null) {
                i2 = this.hIL.getTotalCount();
                i = this.hIL.getAlreadyCount() + 1;
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

    private void a(PostWriteCallBackData postWriteCallBackData, String str) {
        if (postWriteCallBackData != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
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
                if (this.gNW == getCurrentFocus()) {
                    bHJ().clearFocus();
                    this.gNW.requestFocus();
                    if (this.bqg != null) {
                        this.bqg.IE();
                    }
                    ShowSoftKeyPadDelay(this.gNW);
                } else {
                    bHJ().requestFocus();
                    if (this.bqg != null) {
                        this.bqg.IE();
                    }
                    ShowSoftKeyPadDelay(this.cwo);
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
                            bHJ().getText().insert(bHJ().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    u.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    u.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    u.b(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData2, "from_write");
                }
                j(postWriteCallBackData2);
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
                                bIf();
                            } else {
                                ai(intent);
                            }
                        } else if (intExtra == 1) {
                            al(intent);
                        } else {
                            ah(intent);
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hJX) {
                            nH(true);
                            this.hJX = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hIX) {
                        C(intent);
                        bru();
                        return;
                    }
                    ak(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bqg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bru();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hIE) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hIE = false;
                            }
                            sb2.append(stringExtra);
                            fZ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hIY = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hIY);
                }
            }
        } else if (i2 == 0) {
            if (this.bqg != null && !this.bqg.Kx()) {
                this.cwo.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bqg.IE();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    La();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIe();
                    if (this.hJX) {
                        nH(true);
                        this.hJX = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gNW == getCurrentFocus()) {
                        bHJ().clearFocus();
                        this.gNW.requestFocus();
                        if (this.bqg != null) {
                            this.bqg.IE();
                        }
                        ShowSoftKeyPadDelay(this.gNW);
                        return;
                    }
                    bHJ().requestFocus();
                    if (this.bqg != null) {
                        this.bqg.IE();
                    }
                    ShowSoftKeyPadDelay(this.cwo);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hGn.av(postWriteCallBackData.getSensitiveWords());
                        this.hJh.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hGn.bEM())) {
                            nz(true);
                            nF(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.brI = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.brI);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIe();
                    return;
                case 25004:
                    if ("from_title".equals(this.hID)) {
                        bHK().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hID)) {
                        bHJ().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        if ("1".equals(this.hnU)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hnU)) {
            this.mData.setCanNoForum(false);
        }
        bHQ();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hnU);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bGQ();
    }

    private void bHQ() {
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bId() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIe() {
        if (this.hIX) {
            this.hJC.c(this.writeImagesInfo);
            aSa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSa() {
        this.hJC.notifyDataSetChanged();
        this.hJB.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hJC.notifyDataSetChanged();
                WriteActivity.this.hJB.invalidateViews();
            }
        }, 550L);
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bru();
    }

    private void ah(Intent intent) {
        if (this.hIX) {
            ak(intent);
            bIe();
        } else {
            am(intent);
        }
        bru();
    }

    private void ak(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIe();
            nI(true);
        }
    }

    private void ai(Intent intent) {
        if (this.writeImagesInfo != null) {
            B(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bIf() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hJz.parseJson(stringExtra);
            this.hJz.updateQuality();
            if (this.hJz.getChosedFiles() != null && this.hJz.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hJz.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hJz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHK());
        HidenSoftKeyPad(this.mInputManager, bHJ());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.brI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.brI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.brI, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIg();
            bHR();
        }
        nI(true);
    }

    private void C(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bIg();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bHR();
                }
            }
            nI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIg() {
        if (this.bqg.hJ(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void La() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.brI));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nI(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hJA != null) {
            this.hJA.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dBh == null) {
            this.dBh = VoiceManager.instance();
        }
        return this.dBh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aun() {
        this.dBh = getVoiceManager();
        this.dBh.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCc) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVV));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hIL == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brP = i;
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHR() {
        if (!this.hIX) {
            if (this.bqg != null) {
                this.bqg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bqg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hJA != null) {
                this.hJA.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hHz.size()) {
            for (int i2 = 0; i2 < this.hHz.size(); i2++) {
                this.hHz.get(i2).nt(false);
            }
            this.hHz.get(i).nt(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gNF = i;
        this.gOa.setCurrentIndex(i);
        xI(i);
        this.gNZ.setText(this.mPrefixData.getPrefixs().get(i));
        bru();
        com.baidu.adp.lib.g.g.a(this.gOa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gOc.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0036a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            KV();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aU(getApplicationContext())) {
                ai.b(getPageContext(), this.brI);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJT && System.currentTimeMillis() - this.hJU < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hJT = false;
        }
        if (this.hJg != null && !z) {
            this.hJg.bdG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(String str) {
        if (!k.isEmpty(str) && this.hJQ != null) {
            uA(str);
            this.hJQ.dismiss();
        }
    }

    private void cs(Context context) {
        hJS = l.aq(context);
    }

    private void uA(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hJT = true;
        bIg();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bHR();
        }
        nI(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4300=4] */
    private static Bitmap d(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!k.isEmpty(str) && i > 0) {
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

    private File bIh() {
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

    private void bIi() {
        if (this.hJN != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cs(getActivity());
            this.hJP = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hJN != null) {
                        WriteActivity.this.uz(WriteActivity.this.hJN.getAbsolutePath());
                    }
                }
            });
            this.hJO = (TbImageView) this.hJP.findViewById(d.g.rec_img_view);
            this.hJR = (LinearLayout) this.hJP.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hJN.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hJN.getAbsolutePath());
                Bitmap d = d(this.hJN.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.hJO.setImageBitmap(d);
                    this.hJO.setDrawBorder(true);
                    this.hJO.setBorderWidth(2);
                    this.hJO.setBorderColor(aj.getColor(d.C0107d.common_color_10264));
                    this.hJQ = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hJQ.setCanceledOnTouchOutside(true);
                    this.hJQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hJT) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hJU = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hJQ.setContentView(this.hJP);
                    this.hJQ.show();
                    Window window = this.hJQ.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hJS / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hIE = false;
            this.hID = "";
            if ("from_content".equals(str)) {
                this.hID = "from_content";
            } else if ("from_title".equals(str)) {
                this.hID = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nG(false);
            }
        }
    }

    public void IG() {
        if (this.hJp || !v.E(this.mList)) {
            this.hIH.setVisibility(0);
            this.hIH.requestFocus();
            this.bqg.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hIH.setVisibility(8);
    }
}
