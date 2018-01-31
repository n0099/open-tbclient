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
    private static int hKm = 0;
    private com.baidu.tbadk.editortools.i bqp;
    private String brR;
    private LocationModel brS;
    private NewWriteModel brT;
    private VoiceManager dBC;
    private LinearLayout fMg;
    private PlayVoiceBntNew fMh;
    private ImageView fMj;
    private int gNZ;
    private TextView gOt;
    private com.baidu.tieba.write.e gOu;
    private ImageView gOv;
    private View gOw;
    private com.baidu.tieba.write.b hGH;
    private com.baidu.tieba.write.editor.d hJA;
    private com.baidu.tieba.write.b hJB;
    private com.baidu.tieba.view.d hJH;
    private View hJN;
    private f hJU;
    private LinearLayout hJa;
    private LinearLayout hJb;
    private View hJd;
    private Toast hJe;
    private AdditionData hJf;
    private RelativeLayout hJg;
    private TextView hJh;
    private TextView hJi;
    private TextView hJj;
    List<z> hJk;
    z hJl;
    private int hJm;
    private String hJn;
    private int hJo;
    private PostCategoryView hJp;
    private HotTopicBussinessData hJs;
    private View hJt;
    private View hJu;
    private TextView hJv;
    private TextView hJw;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hIX = "";
    private boolean hIY = false;
    private WriteData mData = null;
    private boolean hJJ = false;
    private boolean hIZ = false;
    private boolean hJK = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gOq = null;
    private HeadImageView hJL = null;
    private View gOr = null;
    private LinearLayout cwA = null;
    private EditText cwz = null;
    private FeedBackModel hJc = null;
    private FeedBackTopListView hJM = null;
    private ArrayList<com.baidu.tieba.write.d> hHT = new ArrayList<>();
    private String fkC = null;
    private final KeyEvent doI = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View beR = null;
    private TextView hJO = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hJP = null;
    private final Handler mHandler = new Handler();
    private boolean hJQ = false;
    private String hJR = null;
    private RelativeLayout mParent = null;
    private String brX = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brY = 0;
    private int hJS = 0;
    private WriteImagesInfo hJT = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hJV = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hJW = null;
    private ScrollView hJq = null;
    private EditText hJX = null;
    private View hJY = null;
    private View hJZ = null;
    private View hKa = null;
    private EditText hKb = null;
    private TextView hKc = null;
    private TextView hKd = null;
    private TextWatcher hKe = null;
    private TextWatcher hKf = null;
    private boolean hJr = false;
    private boolean hKg = false;
    private com.baidu.tbadk.core.view.b bAI = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hKh = null;
    private TbImageView hKi = null;
    private View hKj = null;
    private Dialog hKk = null;
    private LinearLayout hKl = null;
    private boolean hKn = false;
    private long hKo = -1000;
    private boolean hKp = false;
    private String hoo = "2";
    private int hDf = 0;
    private String hKq = "";
    private String hJx = "";
    private int hJy = 0;
    private SpannableStringBuilder hJz = new SpannableStringBuilder();
    private boolean hKr = false;
    private final HttpMessageListener hKs = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fkC)) {
                    WriteActivity.this.fkC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nJ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fkC)) {
                    WriteActivity.this.fkC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fkC);
                    WriteActivity.this.nJ(true);
                }
            }
        }
    };
    private TbFaceManager.a hJC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gB(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.sj());
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
    private final AntiHelper.a dCx = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVY));
        }
    };
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.aus();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hGH.av(null);
                WriteActivity.this.hGH.ns(false);
                WriteActivity.this.hJB.av(null);
                WriteActivity.this.hJB.ns(false);
                if (z) {
                    WriteActivity.this.cj(z);
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
                        if (!v.E(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hKq)) {
                            TiebaStatic.log(new ak("c11731").aa("obj_id", WriteActivity.this.hKq));
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
                    WriteActivity.this.hGH.av(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hJB.av(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hGH.ug(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hJB.ug(postWriteCallBackData.getErrorString());
                    if (!v.E(WriteActivity.this.hGH.bEO())) {
                        WriteActivity.this.nB(true);
                        WriteActivity.this.nH(true);
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
                    writeData.setVcodeExtra(tVar.FC());
                    if (com.baidu.tbadk.p.a.hn(tVar.FB())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FB());
                        if (WriteActivity.this.hJK) {
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
    private final LocationModel.a bsf = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ll() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gp(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwn())) {
                WriteActivity.this.b(2, true, aVar.bwn());
            } else {
                gp(null);
            }
        }
    };
    private final CustomMessageListener haP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.brS.mE(false);
                    WriteActivity.this.brS.ce(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.brS.mE(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hJD = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hJE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHw = WriteActivity.this.bHw();
            if (bHw >= 0 && bHw < WriteActivity.this.cwz.getText().length()) {
                WriteActivity.this.cwz.setSelection(bHw);
            }
        }
    };
    private boolean hJF = true;
    private final View.OnFocusChangeListener cwG = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gOq || view == WriteActivity.this.beR || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hJF = true;
                    WriteActivity.this.bHx();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gOq);
                    if (WriteActivity.this.bqp != null) {
                        WriteActivity.this.bqp.IG();
                    }
                } else if (view == WriteActivity.this.gOq) {
                    WriteActivity.this.gOt.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.cwz && z) {
                WriteActivity.this.hJF = false;
                WriteActivity.this.bHx();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.cwz);
                if (WriteActivity.this.bqp != null) {
                    WriteActivity.this.bqp.IG();
                }
            }
            WriteActivity.this.bHA();
        }
    };
    private TextWatcher cwI = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brw();
            if (WriteActivity.this.hJB != null) {
                if (!WriteActivity.this.hJB.bER()) {
                    WriteActivity.this.nH(false);
                }
                WriteActivity.this.hJB.nt(false);
                WriteActivity.this.bHB();
            }
        }
    };
    private TextWatcher hJG = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.brw();
            if (WriteActivity.this.hGH != null) {
                if (!WriteActivity.this.hGH.bER()) {
                    WriteActivity.this.nB(false);
                }
                WriteActivity.this.hGH.nt(false);
            }
        }
    };
    private final a.InterfaceC0153a fSP = new a.InterfaceC0153a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0153a
        public void onRefresh() {
            WriteActivity.this.fkC = null;
            WriteActivity.this.nJ(false);
            WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void nH(boolean z) {
        if (bHM() != null && bHM().getVisibility() == 0 && bHM().getText() != null) {
            int selectionEnd = bHM().getSelectionEnd();
            SpannableStringBuilder b = this.hJB.b(bHM().getText());
            if (b != null) {
                this.hJB.nt(true);
                bHM().setText(b);
                if (z && this.hJB.bEP() >= 0) {
                    bHM().requestFocus();
                    bHM().setSelection(this.hJB.bEP());
                } else {
                    bHM().setSelection(selectionEnd);
                }
                this.hJB.ns(this.hJB.bEP() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(boolean z) {
        if (bHL() != null && bHL().getText() != null) {
            int selectionEnd = bHL().getSelectionEnd();
            SpannableStringBuilder b = this.hGH.b(bHL().getText());
            if (b != null) {
                this.hGH.nt(true);
                bHL().setText(b);
                if (z && this.hGH.bEP() >= 0) {
                    bHL().requestFocus();
                    bHL().setSelection(this.hGH.bEP());
                } else {
                    bHL().setSelection(selectionEnd);
                }
                this.hGH.ns(this.hGH.bEP() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void KX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            KY();
        } else if (this.brS.bwv()) {
            KW();
        } else {
            this.brS.mE(false);
            b(1, true, null);
            this.brS.bwt();
        }
    }

    private void KY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.brS.agm();
                } else {
                    WriteActivity.this.bsf.Ll();
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
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHw() {
        int selectionEnd = bHL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHL().getText().getSpans(0, bHL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHx() {
        if (this.bqp != null) {
            this.bqp.setBarLauncherEnabled(!this.hJF);
            this.bqp.g(true, 26);
            this.bqp.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hJr) {
            this.gOq.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hKa.setVisibility(8);
            } else {
                this.hKa.setVisibility(0);
            }
            a(this.hKd, this.hJX);
            a(this.hKc, this.hKb);
            brw();
        }
        if (this.hJJ) {
            this.hJF = true;
            bHx();
            if (this.bqp != null) {
                this.bqp.IG();
            }
            this.gOq.requestFocus();
            ShowSoftKeyPadDelay(this.gOq);
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
            bIi();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bHT();
            }
            nK(true);
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
        this.hJB = new com.baidu.tieba.write.b();
        this.hJB.xg(d.C0108d.cp_cont_i);
        this.hJB.xh(d.C0108d.cp_cont_h_alpha85);
        this.hGH = new com.baidu.tieba.write.b();
        this.hGH.xg(d.C0108d.cp_cont_i);
        this.hGH.xh(d.C0108d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            xM(this.hDf);
        }
        initUI();
        bHY();
        this.brS = new LocationModel(this);
        this.brS.a(this.bsf);
        registerListener(this.haP);
        registerListener(this.hJD);
        initEditor();
        bIk();
        if (this.hJr) {
            this.hJW.setEditorTools(this.bqp);
        } else {
            this.cwz.requestFocus();
        }
        II();
        bHT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bqp = new com.baidu.tbadk.editortools.i(getActivity());
        this.bqp.setBarMaxLauCount(5);
        this.bqp.setMoreButtonAtEnd(true);
        this.bqp.setBarLauncherType(1);
        this.bqp.cb(true);
        this.bqp.cc(true);
        this.bqp.setMoreLauncherIcon(d.f.write_more);
        this.bqp.setBackgroundColorId(d.C0108d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bHW();
                break;
            default:
                bHy();
                break;
        }
        this.bqp.Kx();
        if (this.hJa != null) {
            this.hJa.addView(this.bqp);
        }
        bHz();
        this.bqp.ti();
        com.baidu.tbadk.editortools.l hH = this.bqp.hH(6);
        if (hH != null && !TextUtils.isEmpty(this.brX)) {
            ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.brX);
                }
            });
        }
        if (!this.hJr) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bqp.IG();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bHU() {
        this.hJY = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hKa = this.hJY.findViewById(d.g.live_post_title_container);
        this.hJX = (EditText) this.hJY.findViewById(d.g.live_post_content);
        this.hJV = (GridView) this.hJY.findViewById(d.g.photoLiveGridView);
        this.hKb = (EditText) this.hJY.findViewById(d.g.live_post_title);
        this.hKc = (TextView) this.hJY.findViewById(d.g.titleOverPlusNumber);
        this.hKd = (TextView) this.hJY.findViewById(d.g.contentOverPlusNumber);
        this.hJZ = this.hJY.findViewById(d.g.live_interval_view);
        this.hKc.setText(String.valueOf(20));
        this.hKd.setText(String.valueOf(233));
        this.hJY.setVisibility(0);
        this.hKc.setVisibility(0);
        this.hKd.setVisibility(0);
        this.hKb.setHint(d.j.tips_title_limit_new);
        this.hKb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hKg = true;
                    WriteActivity.this.hJF = true;
                    WriteActivity.this.bHx();
                    if (WriteActivity.this.bqp != null) {
                        WriteActivity.this.bqp.IG();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hJX.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hJX.setHint(d.j.live_write_input_content_update);
        }
        this.hJX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hKg = false;
                    WriteActivity.this.hJF = false;
                    WriteActivity.this.bHx();
                    if (WriteActivity.this.bqp != null) {
                        WriteActivity.this.bqp.IG();
                    }
                }
            }
        });
        this.hJX.requestFocus();
        this.hJX.addTextChangedListener(bIa());
        this.hKb.requestFocus();
        this.hKb.addTextChangedListener(bIa());
        this.hKb.setOnClickListener(this.hJE);
        this.hJX.setOnClickListener(this.hJE);
        this.hJW = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hJV);
        this.hJW.xy(6);
        this.hJV.setAdapter((ListAdapter) this.hJW);
        View findViewById = this.hJY.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bGG() {
                WriteActivity.this.aSf();
            }
        });
        bHV();
    }

    private void bHV() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hKb.setText(this.mData.getTitle());
                this.hKb.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hJr) {
            bIf();
        }
        if (this.bqp.Kz()) {
            this.bqp.IG();
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
            albumActivityConfig.setCallFrom(this.hoo);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bqp.I(arrayList);
        r hJ = this.bqp.hJ(5);
        if (hJ != null) {
            hJ.bqY = 2;
            hJ.bqW = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.bqW = d.f.write_at;
        this.bqp.b(aVar);
        this.bqp.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bHy() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.bqW = d.f.write_picture;
        this.bqp.b(dVar);
        Boolean bId = bId();
        if (!this.hJJ && bId != null && bId.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bwS() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.bqY = 3;
            rVar5.bqW = d.f.write_recorder;
            this.bqp.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.bqW = d.f.write_at;
        this.bqp.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.bqY = 5;
            rVar4.bqW = d.f.write_privilege;
            this.bqp.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.bqY = 6;
            rVar3.bqW = this.hJJ ? d.f.write_location : d.f.icon_post_more_location;
            this.bqp.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bqp.b(aVar2);
        aVar2.bqW = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.bra = true;
            rVar2.bqY = 9;
            rVar2.bqW = 0;
            this.bqp.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.bra = true;
            rVar.bqY = 10;
            rVar.bqW = 0;
            this.bqp.b(rVar);
        }
        if (this.hJf == null) {
            if (this.hJA == null) {
                this.hJA = new com.baidu.tieba.write.editor.d(getActivity(), this.hoo);
                this.hJA.aN(this.mData.getForumId(), this.privateThread);
            }
            this.bqp.b(this.hJA);
        }
        this.bqp.I(arrayList);
        r hJ = this.bqp.hJ(5);
        if (hJ != null) {
            hJ.bqY = 1;
            hJ.bqW = d.f.write_emotion;
        }
    }

    private void bHz() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bHK()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bHK()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bHN();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bbE();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIi();
                        WriteActivity.this.brw();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xN(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hJf == null) {
                            WriteActivity.this.KZ();
                            return;
                        }
                        switch (WriteActivity.this.brY) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    WriteActivity.this.KX();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.KW();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.brS != null) {
                            WriteActivity.this.brS.mE(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fkC = null;
                        } else {
                            WriteActivity.this.fkC = (String) aVar.data;
                        }
                        WriteActivity.this.nJ(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.aa(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bqp.Kz()) {
                                        WriteActivity.this.bqp.IG();
                                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.brw();
                        if (WriteActivity.this.cwz != null) {
                            WriteActivity.this.cwz.requestFocus();
                        }
                        WriteActivity.this.bqp.IG();
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwz);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hIY = true;
                        WriteActivity.this.nI(true);
                        if (WriteActivity.this.bHM().isFocused()) {
                            WriteActivity.this.hIX = "from_title";
                        } else if (WriteActivity.this.bHL().isFocused()) {
                            WriteActivity.this.hIX = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hJb.setVisibility(0);
                        WriteActivity.this.hJb.requestFocus();
                        WriteActivity.this.brw();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hJb.hasFocus()) {
                            WriteActivity.this.cwz.requestFocus();
                            WriteActivity.this.cwz.setSelection(WriteActivity.this.cwz.getText().toString().length());
                        }
                        WriteActivity.this.hJb.setVisibility(8);
                        WriteActivity.this.brw();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bqp.a(16, bVar);
        this.bqp.a(14, bVar);
        this.bqp.a(24, bVar);
        this.bqp.a(3, bVar);
        this.bqp.a(10, bVar);
        this.bqp.a(11, bVar);
        this.bqp.a(12, bVar);
        this.bqp.a(13, bVar);
        this.bqp.a(15, bVar);
        this.bqp.a(18, bVar);
        this.bqp.a(20, bVar);
        this.bqp.a(25, bVar);
        this.bqp.a(27, bVar);
        this.bqp.a(29, bVar);
        this.bqp.a(43, bVar);
        this.bqp.a(45, bVar);
        this.bqp.a(53, bVar);
        this.bqp.a(48, bVar);
        this.bqp.a(46, bVar);
        this.bqp.a(49, bVar);
        this.bqp.a(47, bVar);
        this.bqp.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZ() {
        if (this.brS.agi()) {
            if (this.brS.bwv()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwr().getLocationData().bwn());
                return;
            }
            b(1, true, null);
            this.brS.bwt();
            return;
        }
        b(0, true, null);
    }

    protected void bro() {
        if (this.brT != null) {
            this.brT.cancelLoadData();
        }
        if (this.hJc != null) {
            this.hJc.cancelLoadData();
        }
        if (this.brS != null) {
            this.brS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bro();
        bIc();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hJU != null) {
            this.hJU.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        if (this.mData != null && this.mData.getType() == 2 && this.hJQ) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bHM().getText().toString());
            this.mData.setContent(bHL().getText().toString());
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
            if (this.gOu != null && this.gOu.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gOu, getPageContext().getPageActivity());
                return true;
            } else if (this.bqp.Kz()) {
                this.bqp.IG();
                return true;
            } else {
                bro();
                bGR();
                return true;
            }
        }
        if (i == 67 && (text = bHL().getText()) != null) {
            int selectionStart = bHL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHL().onKeyDown(67, this.doI);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.mParent);
        getLayoutMode().aM(this.hKl);
        if (this.hKi != null && i == 1) {
            this.hKi.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0108d.cp_link_tip_a, 1);
        bHx();
        aj.t(this.hJY, d.C0108d.cp_bg_line_d);
        aj.t(this.gOr, d.C0108d.cp_bg_line_c);
        aj.t(this.hJZ, d.C0108d.cp_bg_line_c);
        aj.t(bHM(), d.C0108d.cp_bg_line_d);
        aj.c(this.fMj, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fkC)) {
            aj.t(bHL(), d.C0108d.cp_bg_line_d);
        }
        brw();
        this.bqp.onChangeSkinType(i);
        if (this.hJp != null) {
            this.hJp.DT();
        }
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bHA();
        bHB();
        if (this.hGH != null) {
            this.hGH.onChangeSkinType();
        }
        if (this.hJB != null) {
            this.hJB.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHA() {
        if (this.gOq.hasFocus()) {
            this.gOq.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.gOq.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
        if (this.cwz.hasFocus()) {
            this.cwz.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.cwz.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHB() {
        if (this.gOq != null && this.gOq.getText() != null && this.gOq.getText().toString() != null && this.gOq.getPaint() != null) {
            if (this.gOq.getText().toString().length() == 0) {
                this.gOq.getPaint().setFakeBoldText(false);
            } else if (this.gOq.getText().toString().length() > 0) {
                this.gOq.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bAI = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hJr = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0108d.cp_cont_b);
        this.hJO = (TextView) findViewById(d.g.btn_image_problem);
        bHD();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwG);
        this.hJq = (ScrollView) findViewById(d.g.write_scrollview);
        this.hJq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.cwz != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.cwz);
                    }
                    if (WriteActivity.this.bqp != null) {
                        WriteActivity.this.bqp.IG();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hJM = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hJN = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hJa = (LinearLayout) findViewById(d.g.tool_view);
        this.hJa.setContentDescription("..");
        this.hJb = (LinearLayout) findViewById(d.g.title_view);
        this.gOr = findViewById(d.g.interval_view);
        this.hJt = findViewById(d.g.hot_topic_fourm_view);
        this.hJu = findViewById(d.g.hot_topic_divider);
        this.hJv = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hJw = (TextView) findViewById(d.g.change_one_tv);
        brv();
        if (this.hJr) {
            this.hJq.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bHU();
        } else {
            this.hJU = new f(getPageContext(), this.mRootView);
            f fVar = this.hJU;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nz(z);
        }
        afg();
        if (this.hJJ || this.hIZ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWH) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.cwA = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwA.setDrawingCacheEnabled(false);
        this.cwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cwz.requestFocus();
                WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fMg = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fMh = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fMj = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bbE();
            }
        });
        this.beR.setOnFocusChangeListener(this.cwG);
        this.beR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bro();
                WriteActivity.this.bGR();
            }
        });
        this.hJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bHG();
        i(bId());
        bHI();
        bHC();
        bHZ();
        bIb();
        bHx();
        bHH();
        bru();
        bHO();
        if (this.mData.getType() == 4 && this.gOw != null && this.hJd != null) {
            this.gOw.setVisibility(8);
            this.hJd.setVisibility(8);
        }
        brw();
        bHX();
    }

    private void bHC() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hJJ || this.hIZ) {
                        if (this.hJK) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hoo != null && this.hoo.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hoo != null && this.hoo.equals("2")) {
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
                    this.gOq.setVisibility(0);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gOq.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hJZ.setVisibility(8);
                    return;
                case 7:
                    this.gOq.setVisibility(0);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bHD() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bHE() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hJJ && !this.hIZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHM() != null) {
                bHM().setText(d);
                bHM().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fMg.setVisibility(0);
            this.fMh.setVoiceModel(voiceModel);
            this.fMh.bwR();
            brw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbE() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eN(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fMg.setVisibility(8);
        this.fMh.aCG();
        this.fMh.setVoiceModel(null);
        r hJ = this.bqp.hJ(6);
        if (hJ != null && hJ.bqj != null) {
            hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        brw();
    }

    private void bHF() {
        this.hJk = null;
        this.hJm = -1;
        this.hJo = -1;
        com.baidu.tieba.frs.ab mZ = aa.avn().mZ(1);
        if (mZ != null) {
            this.hJk = mZ.dEo;
            this.hJm = getIntent().getIntExtra("category_id", -1);
            if (this.hJk != null && !this.hJk.isEmpty() && this.hJm >= 0) {
                this.hJl = new z();
                this.hJl.dEk = 0;
                this.hJl.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hJo = this.hJl.dEk;
                this.hJn = this.hJl.name;
                for (z zVar : this.hJk) {
                    if (zVar.dEk == this.hJm) {
                        this.hJo = zVar.dEk;
                        this.hJn = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHG() {
        if (this.hJk != null && !this.hJk.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hJp = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hJp.setText(this.hJn);
            this.hJp.b(this.hJk, this.hJl, this.hJo);
            this.hJp.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hJp.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dEk);
                        WriteActivity.this.hJo = avVar.dEk;
                        WriteActivity.this.hJp.bGJ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hJp.bGI();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
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
        this.hJH = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hJH.setTitle(d.j.no_disturb_start_time);
        this.hJH.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hJH);
        this.hJH.setButton(-2, getPageContext().getString(d.j.cancel), this.hJH);
        return this.hJH;
    }

    private void bHH() {
        this.hJg = (RelativeLayout) findViewById(d.g.addition_container);
        this.hJh = (TextView) findViewById(d.g.addition_create_time);
        this.hJi = (TextView) findViewById(d.g.addition_last_time);
        this.hJj = (TextView) findViewById(d.g.addition_last_content);
        if (this.hJf != null) {
            this.hJg.setVisibility(0);
            this.hJh.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hJf.getCreateTime() * 1000));
            if (this.hJf.getAlreadyCount() == 0) {
                this.hJi.setVisibility(8);
            } else {
                this.hJi.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hJf.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hJf.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hJj.setText(lastAdditionContent);
            } else {
                this.hJj.setVisibility(8);
            }
            bHL().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hJf.getAlreadyCount()), Integer.valueOf(this.hJf.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hJg.setVisibility(8);
    }

    private void bru() {
        this.gOw = findViewById(d.g.post_prefix_layout);
        this.gOt = (TextView) findViewById(d.g.post_prefix);
        this.hJd = findViewById(d.g.prefix_divider);
        this.gOv = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gOw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gNZ = 1;
            this.gOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gOt.setVisibility(0);
                    WriteActivity.this.gOw.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gOu, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bqp.IG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gOq);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cwz);
                }
            });
            this.gOv = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gOv.setVisibility(0);
                this.gOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gOt.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gOu, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bqp.IG();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHM());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
                    }
                });
            }
            this.gOu = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gOu.a(this);
            this.gOu.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gOu.setOutsideTouchable(true);
            this.gOu.setFocusable(true);
            this.gOu.setOnDismissListener(this);
            this.gOu.setBackgroundDrawable(aj.getDrawable(d.C0108d.cp_bg_line_d));
            int color = aj.getColor(d.C0108d.cp_cont_b);
            int color2 = aj.getColor(d.C0108d.cp_cont_c);
            aj.s(this.gOt, d.C0108d.cp_bg_line_d);
            aj.c(this.gOv, d.f.icon_frs_arrow_n);
            this.gOt.setTextColor(color);
            this.hHT.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hHT.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gOu.addView(dVar);
            }
            this.gOu.setCurrentIndex(0);
            this.gOt.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gOw.setVisibility(8);
    }

    private void bHY() {
        if (this.hJJ && this.mData != null) {
            this.hJM.setVisibility(0);
            this.hJN.setVisibility(0);
            this.hJc = new FeedBackModel(getPageContext());
            this.hJc.uD(this.mData.getForumName());
            this.hJc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hJM.setVisibility(8);
                        WriteActivity.this.hJN.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hJM.setVisibility(8);
                        WriteActivity.this.hJN.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hJM.a(feedBackModel.bHl(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bHI() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hJB.bEQ()) {
                        WriteActivity.this.showToast(WriteActivity.this.hJB.bES());
                        WriteActivity.this.nH(true);
                    } else if (WriteActivity.this.hGH.bEQ()) {
                        WriteActivity.this.showToast(WriteActivity.this.hGH.bES());
                        WriteActivity.this.nB(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHM());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHL());
                        WriteActivity.this.bqp.IG();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hJJ) {
                                WriteActivity.this.bGS();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bHR();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bGS();
                        }
                        TiebaStatic.log(new ak("c12262").aa("obj_locate", WriteActivity.this.hoo));
                    }
                }
            }
        });
    }

    protected void bHZ() {
        this.hJP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hJP.cZ(getPageContext().getString(d.j.is_save_draft)).aW(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bHM().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bHL().getText().toString());
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
        this.hJP.b(getPageContext());
    }

    protected void brv() {
        this.hJL = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hJL.setIsRound(true);
        this.hJL.setDrawBorder(false);
        this.hJL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dQ = o.dQ(currentPortrait);
            this.hJL.setUrl(dQ);
            this.hJL.startLoad(dQ, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hJL.setVisibility(0);
        }
        this.gOq = (EditText) findViewById(d.g.post_title);
        this.gOq.setOnClickListener(this.hJE);
        this.gOq.setOnFocusChangeListener(this.cwG);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gOq.setText(this.mData.getTitle());
                this.gOq.setSelection(this.mData.getTitle().length());
            } else if (this.hJK) {
                this.gOq.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gOq.addTextChangedListener(this.cwI);
        if (!this.mData.getHaveDraft()) {
            bHE();
            this.hKp = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gOq.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gOq.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bIa() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int cwL;
            private EditText rE = null;
            private TextView rz = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.brw();
                if (WriteActivity.this.hJr) {
                    this.cwL = this.rE.getSelectionStart();
                    this.rE.setSelection(this.cwL);
                    WriteActivity.this.a(this.rz, this.rE);
                }
                if (this.rE != WriteActivity.this.hKb || WriteActivity.this.hJB == null || WriteActivity.this.hJB.bER()) {
                    if (this.rE == WriteActivity.this.hJX && WriteActivity.this.hGH != null && !WriteActivity.this.hGH.bER()) {
                        WriteActivity.this.nB(false);
                    }
                } else {
                    WriteActivity.this.nH(false);
                }
                if (WriteActivity.this.hJB != null) {
                    WriteActivity.this.hJB.nt(false);
                }
                if (WriteActivity.this.hGH != null) {
                    WriteActivity.this.hGH.nt(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hJr || !WriteActivity.this.hKg) {
                    if (WriteActivity.this.hJr) {
                        if (this.rE != WriteActivity.this.hJX || this.rz != WriteActivity.this.hKd) {
                            this.rE = WriteActivity.this.hJX;
                            this.rz = WriteActivity.this.hKd;
                        }
                    }
                } else if (this.rE != WriteActivity.this.hKb || this.rz != WriteActivity.this.hKc) {
                    this.rE = WriteActivity.this.hKb;
                    this.rz = WriteActivity.this.hKc;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hJr && this.hKg) {
            if (this.hKe != null) {
                this.hKb.removeTextChangedListener(this.hKe);
            }
            this.hKe = textWatcher;
        } else if (this.hJr) {
            if (this.hKf != null) {
                this.hJX.removeTextChangedListener(this.hKf);
            }
            this.hKf = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.hJX) {
            return 233L;
        }
        if (editText != this.hKb) {
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
                    textView.setTextColor(aj.getColor(d.C0108d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0108d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.b.a.u(editText.getText().toString().trim());
    }

    protected void afg() {
        this.cwz = (EditText) findViewById(d.g.post_content);
        this.cwz.setDrawingCacheEnabled(false);
        this.cwz.setOnClickListener(this.hJE);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.LQ().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwz.setText(U);
            this.cwz.setSelection(U.length());
        } else if (this.mData.getType() == 2) {
            if (this.hJQ) {
                if (this.hJR != null && this.hJR.length() > 0) {
                    this.cwz.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hJR}));
                    this.cwz.setSelection(this.cwz.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.cwz.setText(format);
                this.cwz.setSelection(format.length());
            }
        }
        this.cwz.setOnFocusChangeListener(this.cwG);
        this.cwz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.cwz.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwz.addTextChangedListener(this.hJG);
        if (this.mData.getType() == 0) {
            this.hKr = true;
        } else {
            nJ(true);
            this.hKr = false;
        }
        if (this.mData.isUserFeedback()) {
            this.cwz.setHint(d.j.write_input_content);
        } else {
            this.cwz.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nJ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hJr) {
            bHL().setPadding(0, 0, 0, 0);
            bHL().setBackgroundDrawable(null);
            aj.t(bHL(), d.C0108d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fkC) && this.hJf == null) {
                com.baidu.adp.lib.f.c.nm().a(this.fkC, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.sj() != null && aVar.sn() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.sj(), aVar.sj().getNinePatchChunk(), aVar.sn(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bHL().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bHL(), true, WriteActivity.this.fSP);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHK() {
        int i = 5000;
        if (this.hJf != null) {
            i = 1000;
        }
        return bHL().getText() != null && bHL().getText().length() >= i;
    }

    private void gg(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hIX)) {
                this.hIX = "";
                bHL().requestFocus();
                if (bHL().getText() != null && bHL().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHL().getSelectionStart();
                    editable = bHL().getText();
                }
            } else if ("from_title".equals(this.hIX)) {
                this.hIX = "";
                bHM().requestFocus();
                if (bHM().getText() != null && bHM().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHM().getSelectionStart();
                    editable = bHM().getText();
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
    public void nI(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHL().getText().getSpans(0, bHL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hJe == null) {
                this.hJe = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hJe.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ft = nVar.Ft();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bHL().getSelectionStart(), aVar, Ft);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHL() != null && bHL().getText() != null) {
            Bitmap sj = aVar.sj();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(sj);
            int width = sj.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, sj.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHL().getSelectionStart() - 1;
                if (bHL().getText().length() > 1 && selectionStart >= 0 && bHL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHL().getText().insert(bHL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHL().getText().insert(bHL().getSelectionStart(), spannableString2);
            }
            Editable text = bHL().getText();
            if (text != null) {
                this.hJz.clear();
                this.hJz.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJz);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHL() {
        return this.hJr ? this.hJX : this.cwz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHM() {
        return this.hJr ? this.hKb : this.gOq;
    }

    protected void bHN() {
        Editable text;
        if (bHL() != null && (text = bHL().getText()) != null) {
            int selectionStart = bHL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHL().onKeyDown(67, this.doI);
            }
            bHL().onKeyDown(67, this.doI);
            int selectionStart2 = bHL().getSelectionStart();
            if (text != null) {
                this.hJz.clear();
                this.hJz.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJz);
                bHL().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hJJ = true;
        }
    }

    private void bIb() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIc() {
        try {
            if (this.hJP != null) {
                this.hJP.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAI.c(null);
        this.bAI.fY(d.j.sending);
        this.bAI.bn(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAI.bn(false);
    }

    private Boolean bId() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.brX = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHM() != null) {
                str = bHM().getText().toString();
            }
            if (bHL() != null) {
                str2 = bHL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gNZ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hJb.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ef(true);
                            return;
                        }
                    } else if (this.hJb.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ef(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hJb.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ef(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hJr) {
                    ef(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ef(true);
                }
            }
            if (this.mData.getType() == 4) {
                ef(l(this.hJX) && k(this.hKb));
            } else if (this.mData.getType() == 5) {
                ef(l(this.hJX));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                ef(true);
            } else if (this.mData.getVideoInfo() != null) {
                ef(true);
            } else {
                ef(false);
            }
        }
    }

    public void ef(boolean z) {
        if (z) {
            aj.d(this.mPost, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.e(this.mPost, d.C0108d.cp_cont_d, 1);
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
        this.brT = new NewWriteModel(this);
        this.brT.b(this.bsh);
        registerListener(this.hKs);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bro();
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
            this.hJJ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hJK = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hJQ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hJR = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.brR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hJf = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hJf != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hJS = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hKq = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hoo = bundle.getString("KEY_CALL_FROM");
            this.hDf = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hJJ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hJK = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hJQ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hJR = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hJf = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hJf != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hJS = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hKq = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hoo = intent.getStringExtra("KEY_CALL_FROM");
            this.hDf = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hJJ);
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
        this.fkC = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hIZ = true;
        }
        bHF();
        try {
            this.hKh = bIj();
        } catch (Throwable th) {
            this.hKh = null;
        }
    }

    private void bHO() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hJL.setVisibility(8);
            this.hJt.setVisibility(0);
            this.hJu.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gOq.setText(com.baidu.tbadk.plugins.a.gT(uE(this.mList.get(0).mTopicName)));
                this.gOq.setMovementMethod(com.baidu.tieba.view.e.bDW());
            }
            this.hJv.setText(this.mList.get(0).mForumName);
            this.gOq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hJx.equals(charSequence.toString())) {
                        WriteActivity.this.hJy = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gT;
                    if (!WriteActivity.this.hJx.equals(editable.toString()) && (gT = com.baidu.tbadk.plugins.a.gT(editable.toString())) != null) {
                        WriteActivity.this.hJx = gT.toString();
                        WriteActivity.this.gOq.setText(gT);
                        if (WriteActivity.this.hJy <= WriteActivity.this.gOq.getText().length()) {
                            WriteActivity.this.gOq.setSelection(WriteActivity.this.hJy);
                        }
                    }
                }
            });
            this.hJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
            SpannableString gT = com.baidu.tbadk.plugins.a.gT(uE(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.gOq.setText(gT);
            }
            this.hJv.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uE(String str) {
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
        String uE;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bHM().getText().toString()) || this.hKp || ((this.hJJ || this.hIZ) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.E(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.f(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            uE = this.mData.getTitle();
                        } else {
                            uE = uE(str);
                        }
                        SpannableString gT = com.baidu.tbadk.plugins.a.gT(uE);
                        if (gT != null) {
                            bHM().setText(gT);
                            bHM().setSelection(gT.length() > uE.length() ? uE.length() : gT.length());
                        }
                    } else {
                        SpannableString gT2 = com.baidu.tbadk.plugins.a.gT(this.mData.getTitle());
                        if (gT2 != null) {
                            bHM().setText(gT2);
                            bHM().setSelection(this.mData.getTitle().length() > gT2.length() ? gT2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bHE();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bHL().getText().toString()) || this.hJJ || this.hIZ) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.LQ().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hJC);
                    bHL().setText(a2);
                    bHL().setSelection(a2.length());
                    if (this.hJr) {
                        a(this.hKd, this.hJX);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIi();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bHT();
                    }
                    nK(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIe();
                }
                brw();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hJk != null) {
                    this.hJo = this.hJl.dEk;
                    this.hJn = this.hJl.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hJk.size()) {
                            break;
                        }
                        z zVar = this.hJk.get(i);
                        if (categoryTo != zVar.dEk) {
                            i++;
                        } else {
                            this.hJo = categoryTo;
                            this.hJn = zVar.name;
                            this.mData.setCategoryTo(this.hJo);
                            break;
                        }
                    }
                    if (this.hJp != null) {
                        this.hJp.setText(this.hJn);
                        this.hJp.b(this.hJk, this.hJl, this.hJo);
                    }
                }
                this.bqp.IG();
                return;
            }
            return;
        }
        bIe();
        bHE();
    }

    private void bIe() {
        if ((!this.hJr || this.hJW != null) && this.hJV != null) {
            this.hJW.c(this.writeImagesInfo);
            aSf();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hJQ);
        if (this.hJJ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.brR);
        if (this.hJf != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hJf));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hJS);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hoo);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hDf);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHL().getEditableText().toString();
        if (obj != null) {
            bHL().setText(TbFaceManager.LQ().a(getPageContext().getPageActivity(), obj, this.hJC));
            bHL().setSelection(bHL().getText().length());
        }
    }

    private String bHP() {
        return (bHL() == null || bHL().getText() == null) ? "" : bHL().getText().toString();
    }

    private String bHQ() {
        if (this.mData == null || bHM() == null || bHM().getVisibility() != 0 || bHM().getText() == null) {
            return "";
        }
        String obj = bHM().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gNZ != 0 && this.mData.getType() != 4 && this.gOt != null && this.gOt.getText() != null) {
            obj = this.gOt.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uF(String str) {
        if (this.mData != null && this.hJb != null) {
            if (this.hJb.getVisibility() == 0) {
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
    public void bGS() {
        bro();
        this.mData.setContent(bHP());
        uF(bHQ());
        if (this.hJJ || this.hIZ) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uF(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.oJ()) {
                    sb.append(com.baidu.adp.lib.util.j.oR());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hJm >= 0) {
            this.mData.setCategoryFrom(this.hJm);
        }
        if (this.hJo >= 0) {
            this.mData.setCategoryTo(this.hJo);
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
        this.mData.setHasLocationData(this.brS != null && this.brS.agi());
        if (this.writeImagesInfo != null) {
            this.brT.mG(this.writeImagesInfo.size() > 0);
        }
        if (!v.E(this.mList) && this.hJs != null && this.hJs.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hJs.mForumId));
            this.mData.setForumName(this.hJs.mForumName);
        }
        this.brT.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.brT.getWriteData().setVoice(this.mVoiceModel.getId());
                this.brT.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.brT.getWriteData().setVoice(null);
                this.brT.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.brT.getWriteData().setVoice(null);
            this.brT.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.brT.bwT()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.brT.startPostWrite();
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
            if (this.hJf != null) {
                i2 = this.hJf.getTotalCount();
                i = this.hJf.getAlreadyCount() + 1;
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
                if (this.gOq == getCurrentFocus()) {
                    bHL().clearFocus();
                    this.gOq.requestFocus();
                    if (this.bqp != null) {
                        this.bqp.IG();
                    }
                    ShowSoftKeyPadDelay(this.gOq);
                } else {
                    bHL().requestFocus();
                    if (this.bqp != null) {
                        this.bqp.IG();
                    }
                    ShowSoftKeyPadDelay(this.cwz);
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
                            bHL().getText().insert(bHL().getSelectionStart(), sb.toString());
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
                                bIh();
                            } else {
                                ai(intent);
                            }
                        } else if (intExtra == 1) {
                            al(intent);
                        } else {
                            ah(intent);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hKr) {
                            nJ(true);
                            this.hKr = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hJr) {
                        C(intent);
                        brw();
                        return;
                    }
                    ak(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bqp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    brw();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hIY) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hIY = false;
                            }
                            sb2.append(stringExtra);
                            gg(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hJs = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hJs);
                }
            }
        } else if (i2 == 0) {
            if (this.bqp != null && !this.bqp.Kz()) {
                this.cwz.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bqp.IG();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    Lc();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIg();
                    if (this.hKr) {
                        nJ(true);
                        this.hKr = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gOq == getCurrentFocus()) {
                        bHL().clearFocus();
                        this.gOq.requestFocus();
                        if (this.bqp != null) {
                            this.bqp.IG();
                        }
                        ShowSoftKeyPadDelay(this.gOq);
                        return;
                    }
                    bHL().requestFocus();
                    if (this.bqp != null) {
                        this.bqp.IG();
                    }
                    ShowSoftKeyPadDelay(this.cwz);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hGH.av(postWriteCallBackData.getSensitiveWords());
                        this.hJB.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hGH.bEO())) {
                            nB(true);
                            nH(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.brR = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.brR);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIg();
                    return;
                case 25004:
                    if ("from_title".equals(this.hIX)) {
                        bHM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hIX)) {
                        bHL().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHR() {
        if ("1".equals(this.hoo)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hoo)) {
            this.mData.setCanNoForum(false);
        }
        bHS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hoo);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bGS();
    }

    private void bHS() {
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIf() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIg() {
        if (this.hJr) {
            this.hJW.c(this.writeImagesInfo);
            aSf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSf() {
        this.hJW.notifyDataSetChanged();
        this.hJV.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hJW.notifyDataSetChanged();
                WriteActivity.this.hJV.invalidateViews();
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
        brw();
    }

    private void ah(Intent intent) {
        if (this.hJr) {
            ak(intent);
            bIg();
        } else {
            am(intent);
        }
        brw();
    }

    private void ak(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIg();
            nK(true);
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

    private void bIh() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void al(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hJT.parseJson(stringExtra);
            this.hJT.updateQuality();
            if (this.hJT.getChosedFiles() != null && this.hJT.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hJT.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hJT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHM());
        HidenSoftKeyPad(this.mInputManager, bHL());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void am(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.brR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.brR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.brR, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIi();
            bHT();
        }
        nK(true);
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
                bIi();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bHT();
                }
            }
            nK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (this.bqp.hJ(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Lc() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.brR));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nK(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hJU != null) {
            this.hJU.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dBC == null) {
            this.dBC = VoiceManager.instance();
        }
        return this.dBC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aus() {
        this.dBC = getVoiceManager();
        this.dBC.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCx) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVY));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hJf == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brY = i;
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHT() {
        if (!this.hJr) {
            if (this.bqp != null) {
                this.bqp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bqp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hJU != null) {
                this.hJU.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(boolean z) {
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hHT.size()) {
            for (int i2 = 0; i2 < this.hHT.size(); i2++) {
                this.hHT.get(i2).nv(false);
            }
            this.hHT.get(i).nv(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gNZ = i;
        this.gOu.setCurrentIndex(i);
        xI(i);
        this.gOt.setText(this.mPrefixData.getPrefixs().get(i));
        brw();
        com.baidu.adp.lib.g.g.a(this.gOu, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gOw.setSelected(false);
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
            KX();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aU(getApplicationContext())) {
                ai.b(getPageContext(), this.brR);
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
        if (this.hKn && System.currentTimeMillis() - this.hKo < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hKn = false;
        }
        if (this.hJA != null && !z) {
            this.hJA.bdL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(String str) {
        if (!k.isEmpty(str) && this.hKk != null) {
            uH(str);
            this.hKk.dismiss();
        }
    }

    private void cp(Context context) {
        hKm = l.aq(context);
    }

    private void uH(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hKn = true;
        bIi();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bHT();
        }
        nK(true);
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

    private File bIj() {
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

    private void bIk() {
        if (this.hKh != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cp(getActivity());
            this.hKj = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hKh != null) {
                        WriteActivity.this.uG(WriteActivity.this.hKh.getAbsolutePath());
                    }
                }
            });
            this.hKi = (TbImageView) this.hKj.findViewById(d.g.rec_img_view);
            this.hKl = (LinearLayout) this.hKj.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hKh.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hKh.getAbsolutePath());
                Bitmap d = d(this.hKh.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.hKi.setImageBitmap(d);
                    this.hKi.setDrawBorder(true);
                    this.hKi.setBorderWidth(2);
                    this.hKi.setBorderColor(aj.getColor(d.C0108d.common_color_10264));
                    this.hKk = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hKk.setCanceledOnTouchOutside(true);
                    this.hKk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hKn) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hKo = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hKk.setContentView(this.hKj);
                    this.hKk.show();
                    Window window = this.hKk.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hKm / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.hIY = false;
            this.hIX = "";
            if ("from_content".equals(str)) {
                this.hIX = "from_content";
            } else if ("from_title".equals(str)) {
                this.hIX = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nI(false);
            }
        }
    }

    public void II() {
        if (this.hJJ || !v.E(this.mList)) {
            this.hJb.setVisibility(0);
            this.hJb.requestFocus();
            this.bqp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hJb.setVisibility(8);
    }
}
