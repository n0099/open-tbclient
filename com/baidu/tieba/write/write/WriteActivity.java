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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.a;
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
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, VoiceManager.c, s.a, e.a {
    private static int gXI = 0;
    private i aBt;
    private VoiceData.VoiceModel aDc;
    private String aDd;
    private LocationModel aDe;
    private NewWriteModel aDf;
    private VoiceManager cxT;
    private int fYW;
    private TextView fZq;
    private com.baidu.tieba.write.e fZr;
    private ImageView fZs;
    private View fZt;
    private com.baidu.tieba.write.b gUL;
    private com.baidu.tieba.write.a gUw;
    private LinearLayout gWQ;
    private LinearLayout gWR;
    private View gWU;
    private View gWV;
    private HotTopicBussinessData gXN;
    private View gXO;
    private View gXP;
    private TextView gXQ;
    private TextView gXR;
    private com.baidu.tieba.write.b.b gXW;
    private com.baidu.tieba.write.b gXY;
    private Toast gXb;
    private AdditionData gXc;
    private RelativeLayout gXd;
    private TextView gXe;
    private TextView gXf;
    private TextView gXg;
    List<y> gXi;
    y gXj;
    private int gXk;
    private String gXl;
    private int gXm;
    private PostCategoryView gXn;
    private d gXo;
    private com.baidu.tieba.view.b gYf;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gWK = "";
    private boolean gWL = false;
    private WriteData mData = null;
    private boolean gWM = false;
    private boolean gWN = false;
    private boolean gWO = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fZn = null;
    private HeadImageView gWP = null;
    private View fZo = null;
    private LinearLayout bzs = null;
    private EditText bzr = null;
    private FeedBackModel gWS = null;
    private FeedBackTopListView gWT = null;
    private ArrayList<com.baidu.tieba.write.d> gVN = new ArrayList<>();
    private String epI = null;
    private final KeyEvent gWW = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqg = null;
    private TextView gWX = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gWY = null;
    private final Handler mHandler = new Handler();
    private boolean gWZ = false;
    private String gXa = null;
    private RelativeLayout mParent = null;
    private String aDj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDl = 0;
    private int gXh = 0;
    private WriteImagesInfo fyU = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gXp = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gXq = null;
    private ScrollView gXr = null;
    private EditText gXs = null;
    private View gXt = null;
    private View gXu = null;
    private View gXv = null;
    private EditText gXw = null;
    private TextView gXx = null;
    private TextView gXy = null;
    private TextWatcher gXz = null;
    private TextWatcher gXA = null;
    private boolean gXB = false;
    private boolean gXC = false;
    private com.baidu.tbadk.core.view.a aLW = null;
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private File gXD = null;
    private TbImageView gXE = null;
    private View gXF = null;
    private Dialog gXG = null;
    private LinearLayout gXH = null;
    private boolean gXJ = false;
    private long gXK = -1000;
    private boolean gXL = false;
    private String gTt = "2";
    private boolean gXM = false;
    private String gXS = "";
    private String gXT = "";
    private int gXU = 0;
    private SpannableStringBuilder gXV = new SpannableStringBuilder();
    private boolean gXX = false;
    private final HttpMessageListener gXZ = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.epI)) {
                    WriteActivity.this.epI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nF(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.epI)) {
                    WriteActivity.this.epI = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.epI);
                    WriteActivity.this.nF(true);
                }
            }
        }
    };
    private TbFaceManager.a gYa = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gj(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kK());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new ImageSpan(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cyL = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahs));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahs));
        }
    };
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ajy();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.gUL.aB(null);
                WriteActivity.this.gUL.nq(false);
                WriteActivity.this.gXY.aB(null);
                WriteActivity.this.gXY.nq(false);
                if (z) {
                    WriteActivity.this.bG(z);
                    if (WriteActivity.this.c(writeData)) {
                        WriteActivity.this.b(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                s.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                s.c(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                s.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            s.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            s.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gXS)) {
                            TiebaStatic.log(new ak("c11731").ac("obj_id", WriteActivity.this.gXS));
                        }
                    }
                    WriteActivity.this.i(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.gUL.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.gXY.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.gUL.tO(postWriteCallBackData.getErrorString());
                    WriteActivity.this.gXY.tO(postWriteCallBackData.getErrorString());
                    if (!v.v(WriteActivity.this.gUL.bCp())) {
                        WriteActivity.this.nz(true);
                        WriteActivity.this.nE(true);
                    }
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.b(false, postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yi());
                    if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, rVar.yh());
                        if (WriteActivity.this.gWO) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aDu = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DL() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fY(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bvi())) {
                WriteActivity.this.a(2, true, aVar.bvi());
            } else {
                fY(null);
            }
        }
    };
    private final CustomMessageListener gsw = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDe.mH(false);
                    WriteActivity.this.aDe.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDe.mH(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener gYb = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener gYc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bEG = WriteActivity.this.bEG();
            if (bEG >= 0 && bEG < WriteActivity.this.bzr.getText().length()) {
                WriteActivity.this.bzr.setSelection(bEG);
            }
        }
    };
    private boolean gYd = true;
    private final View.OnFocusChangeListener bzy = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fZn || view == WriteActivity.this.aqg || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gYd = true;
                    WriteActivity.this.bEH();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bc();
                    }
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.fZn);
                } else if (view == WriteActivity.this.fZn) {
                    WriteActivity.this.fZq.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bzr && z) {
                WriteActivity.this.gYd = false;
                WriteActivity.this.bEH();
                WriteActivity.this.aBt.Bc();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.bzr);
            }
        }
    };
    private TextWatcher bzA = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.boe();
            if (WriteActivity.this.gXY != null) {
                if (!WriteActivity.this.gXY.bCs()) {
                    WriteActivity.this.nE(false);
                }
                WriteActivity.this.gXY.nr(false);
            }
        }
    };
    private TextWatcher gYe = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.boe();
            if (WriteActivity.this.gUL != null) {
                if (!WriteActivity.this.gUL.bCs()) {
                    WriteActivity.this.nz(false);
                }
                WriteActivity.this.gUL.nr(false);
            }
        }
    };
    private final a.InterfaceC0127a eUj = new a.InterfaceC0127a() { // from class: com.baidu.tieba.write.write.WriteActivity.29
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0127a
        public void kW() {
            WriteActivity.this.epI = null;
            WriteActivity.this.nF(false);
            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aiB)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        if (bEY() != null && bEY().getVisibility() == 0 && bEY().getText() != null) {
            int selectionEnd = bEY().getSelectionEnd();
            SpannableStringBuilder b = this.gXY.b(bEY().getText());
            if (b != null) {
                this.gXY.nr(true);
                bEY().setText(b);
                if (z && this.gXY.bCq() >= 0) {
                    bEY().requestFocus();
                    bEY().setSelection(this.gXY.bCq());
                } else {
                    bEY().setSelection(selectionEnd);
                }
                this.gXY.nq(this.gXY.bCq() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (bEX() != null && bEX().getText() != null) {
            int selectionEnd = bEX().getSelectionEnd();
            SpannableStringBuilder b = this.gUL.b(bEX().getText());
            if (b != null) {
                this.gUL.nr(true);
                bEX().setText(b);
                if (z && this.gUL.bCq() >= 0) {
                    bEX().requestFocus();
                    bEX().setSelection(this.gUL.bCq());
                } else {
                    bEX().setSelection(selectionEnd);
                }
                this.gUL.nq(this.gUL.bCq() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dy();
        } else if (this.aDe.bvq()) {
            Dw();
        } else {
            this.aDe.mH(false);
            a(1, true, (String) null);
            this.aDe.bvo();
        }
    }

    private void Dy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aDe.WZ();
                } else {
                    WriteActivity.this.aDu.DL();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEG() {
        int selectionEnd = bEX().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bEX().getText().getSpans(0, bEX().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bEX().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bEX().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEH() {
        if (this.aBt != null) {
            this.aBt.setBarLauncherEnabled(!this.gYd);
            this.aBt.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gXB) {
            this.fZn.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gXv.setVisibility(8);
            } else {
                this.gXv.setVisibility(0);
            }
            b(this.gXy, this.gXs);
            b(this.gXx, this.gXw);
            boe();
        }
        if (this.gWM) {
            this.gYd = true;
            bEH();
            if (this.aBt != null) {
                this.aBt.Bc();
            }
            this.fZn.requestFocus();
            ShowSoftKeyPadDelay(this.fZn);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        this.gXY = new com.baidu.tieba.write.b();
        this.gXY.vg(d.C0080d.cp_cont_i);
        this.gXY.vh(d.C0080d.cp_cont_h_alpha85);
        this.gUL = new com.baidu.tieba.write.b();
        this.gUL.vg(d.C0080d.cp_cont_i);
        this.gUL.vh(d.C0080d.cp_cont_h_alpha85);
        initUI();
        bET();
        this.aDe = new LocationModel(this);
        this.aDe.a(this.aDu);
        registerListener(this.gsw);
        registerListener(this.gYb);
        initEditor();
        bFl();
        if (this.gXB) {
            this.gXq.setEditorTools(this.aBt);
        } else {
            this.bzr.requestFocus();
        }
        Be();
        DG();
        this.gUw = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBt = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aBt.setBarMaxLauCount(6);
        } else {
            this.aBt.setBarMaxLauCount(5);
        }
        this.aBt.setMoreButtonAtEnd(true);
        this.aBt.setBarLauncherType(1);
        this.aBt.bx(true);
        this.aBt.setMoreLauncherIcon(d.f.write_more);
        this.aBt.setBackgroundColorId(d.C0080d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bEK();
                break;
            default:
                bEL();
                break;
        }
        this.aBt.CV();
        if (this.gWQ != null) {
            this.gWQ.addView(this.aBt);
        }
        bEM();
        this.aBt.lG();
        com.baidu.tbadk.editortools.l eM = this.aBt.eM(6);
        if (eM != null && !TextUtils.isEmpty(this.aDj)) {
            ((View) eM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDj);
                }
            });
        }
        if (!this.gXB) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBt.Bc();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.bzx = this.mData.getForumName() + getResources().getString(d.j.forum);
        }
        this.aBt.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.aiB);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bEI() {
        this.gXt = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.gXv = this.gXt.findViewById(d.g.live_post_title_container);
        this.gXs = (EditText) this.gXt.findViewById(d.g.live_post_content);
        this.gXp = (GridView) this.gXt.findViewById(d.g.photoLiveGridView);
        this.gXw = (EditText) this.gXt.findViewById(d.g.live_post_title);
        this.gXx = (TextView) this.gXt.findViewById(d.g.titleOverPlusNumber);
        this.gXy = (TextView) this.gXt.findViewById(d.g.contentOverPlusNumber);
        this.gXu = this.gXt.findViewById(d.g.live_interval_view);
        this.gXx.setText(String.valueOf(20));
        this.gXy.setText(String.valueOf(233));
        this.gXt.setVisibility(0);
        this.gXx.setVisibility(0);
        this.gXy.setVisibility(0);
        this.gXw.setHint(d.j.tips_title_limit_new);
        this.gXw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gXC = true;
                    WriteActivity.this.gYd = true;
                    WriteActivity.this.bEH();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bc();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gXs.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gXs.setHint(d.j.live_write_input_content_update);
        }
        this.gXs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gXC = false;
                    WriteActivity.this.gYd = false;
                    WriteActivity.this.bEH();
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bc();
                    }
                }
            }
        });
        this.gXs.requestFocus();
        this.gXs.addTextChangedListener(bco());
        this.gXw.requestFocus();
        this.gXw.addTextChangedListener(bco());
        this.gXw.setOnClickListener(this.gYc);
        this.gXs.setOnClickListener(this.gYc);
        this.gXq = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gXp);
        this.gXq.vv(6);
        this.gXp.setAdapter((ListAdapter) this.gXq);
        View findViewById = this.gXt.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bDX() {
                WriteActivity.this.aKc();
            }
        });
        bEJ();
    }

    private void bEJ() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gXw.setText(this.mData.getTitle());
                this.gXw.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.gXB) {
            bFh();
        }
        if (this.aBt.CX()) {
            this.aBt.Bc();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", this.aiB);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bEK() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBt.A(arrayList);
        com.baidu.tbadk.editortools.r eO = this.aBt.eO(5);
        if (eO != null) {
            eO.aCa = 2;
            eO.aBY = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBY = d.f.write_at;
        this.aBt.b(aVar);
        this.aBt.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bEL() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBY = d.f.write_picture;
            this.aBt.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aBt.b(aVar);
        aVar.aBY = d.f.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCa = 6;
            rVar4.aBY = d.f.write_privilege;
            this.aBt.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBY = d.f.write_at;
        this.aBt.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCc = true;
            rVar3.aCa = 9;
            rVar3.aBY = 0;
            this.aBt.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCc = true;
            rVar2.aCa = 10;
            rVar2.aBY = 0;
            this.aBt.b(rVar2);
        }
        Boolean bFc = bFc();
        if (!this.gWM && bFc != null && bFc.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bvK() && n.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCa = 2;
            rVar.aBY = d.f.write_recorder;
            this.aBt.b(rVar);
        }
        if (this.gXc == null) {
            if (this.gXW == null) {
                this.gXW = new com.baidu.tieba.write.b.b(getActivity(), this.gTt);
            }
            this.aBt.b(this.gXW);
        }
        this.aBt.A(arrayList);
        com.baidu.tbadk.editortools.r eO = this.aBt.eO(5);
        if (eO != null) {
            eO.aCa = 1;
            eO.aBY = d.f.write_emotion;
        }
    }

    private void bEM() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bEW()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bEW()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof m)) {
                            WriteActivity.this.d((m) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bEZ();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aDc = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.boe();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aDc = null;
                        WriteActivity.this.boe();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bFj();
                        WriteActivity.this.boe();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vJ(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gXc == null) {
                            WriteActivity.this.Dz();
                            return;
                        }
                        switch (WriteActivity.this.aDl) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aI(pageActivity)) {
                                    WriteActivity.this.Dx();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Dw();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.epI = null;
                        } else {
                            WriteActivity.this.epI = (String) aVar.data;
                        }
                        WriteActivity.this.nF(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBt.CX()) {
                                        WriteActivity.this.aBt.Bc();
                                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.boe();
                        if (WriteActivity.this.bzr != null) {
                            WriteActivity.this.bzr.requestFocus();
                        }
                        WriteActivity.this.aBt.Bc();
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzr);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gWL = true;
                        WriteActivity.this.nG(true);
                        if (WriteActivity.this.bEY().isFocused()) {
                            WriteActivity.this.gWK = "from_title";
                        } else if (WriteActivity.this.bEX().isFocused()) {
                            WriteActivity.this.gWK = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gWR.setVisibility(0);
                        WriteActivity.this.gWR.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gUw.cn(WriteActivity.this.bcR(), WriteActivity.this.bFf());
                        TiebaStatic.log(new ak("c12258").ac("obj_locate", WriteActivity.this.gTt));
                    }
                }
            }
        };
        this.aBt.a(16, bVar);
        this.aBt.a(14, bVar);
        this.aBt.a(24, bVar);
        this.aBt.a(3, bVar);
        this.aBt.a(10, bVar);
        this.aBt.a(11, bVar);
        this.aBt.a(12, bVar);
        this.aBt.a(13, bVar);
        this.aBt.a(15, bVar);
        this.aBt.a(18, bVar);
        this.aBt.a(25, bVar);
        this.aBt.a(27, bVar);
        this.aBt.a(29, bVar);
        this.aBt.a(43, bVar);
        this.aBt.a(45, bVar);
        this.aBt.a(48, bVar);
        this.aBt.a(46, bVar);
        this.aBt.a(49, bVar);
        this.aBt.a(47, bVar);
        this.aBt.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vJ(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dz() {
        if (this.aDe.WV()) {
            if (this.aDe.bvq()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bvm().getLocationData().bvi());
                return;
            }
            a(1, true, (String) null);
            this.aDe.bvo();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bnW() {
        if (this.aDf != null) {
            this.aDf.cancelLoadData();
        }
        if (this.gWS != null) {
            this.gWS.cancelLoadData();
        }
        if (this.aDe != null) {
            this.aDe.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bnW();
        bFb();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gUw != null) {
            this.gUw.destroy();
        }
        if (this.gXo != null) {
            this.gXo.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        if (this.mData != null && this.mData.getType() == 2 && this.gWZ) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bEY().getText().toString());
            this.mData.setContent(bEX().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    s.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    s.c("24591571", this.mData);
                }
            } else if (type == 1) {
                s.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                s.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                s.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fZr != null && this.fZr.isShowing()) {
                g.a(this.fZr, getPageContext().getPageActivity());
                return true;
            } else if (this.aBt.CX()) {
                this.aBt.Bc();
                return true;
            } else {
                bnW();
                bEg();
                return true;
            }
        }
        if (i == 67 && (text = bEX().getText()) != null) {
            int selectionStart = bEX().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bEX().onKeyDown(67, this.gWW);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gXH);
        if (this.gXE != null && i == 1) {
            this.gXE.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0080d.cp_link_tip_a, 1);
        bEH();
        aj.k(this.gXt, d.C0080d.cp_bg_line_d);
        aj.k(this.fZo, d.C0080d.cp_bg_line_c);
        aj.k(this.gXu, d.C0080d.cp_bg_line_c);
        aj.k(bEY(), d.C0080d.cp_bg_line_d);
        if (TextUtils.isEmpty(this.epI)) {
            aj.k(bEX(), d.C0080d.cp_bg_line_d);
        }
        boe();
        this.aBt.onChangeSkinType(i);
        if (this.gXn != null) {
            this.gXn.wB();
        }
        aj.i(this.mName, d.C0080d.cp_cont_b);
        this.fZn.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.bzr.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        if (this.gUL != null) {
            this.gUL.onChangeSkinType();
        }
        if (this.gXY != null) {
            this.gXY.onChangeSkinType();
        }
    }

    private void initUI() {
        this.aLW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gXB = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aqg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqg.getLayoutParams();
            layoutParams.height = l.f(getPageContext().getPageActivity(), d.e.ds88);
            layoutParams.width = l.f(getPageContext().getPageActivity(), d.e.ds88);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqg != null && (this.aqg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqg.getLayoutParams();
            layoutParams2.width = l.f(getPageContext().getPageActivity(), d.e.ds88);
            layoutParams2.height = l.f(getPageContext().getPageActivity(), d.e.ds88);
            this.aqg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.write_close_selector, d.f.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.C0080d.cp_cont_b);
        this.gWX = (TextView) findViewById(d.g.btn_image_problem);
        bEN();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.bzy);
        this.gXr = (ScrollView) findViewById(d.g.write_scrollview);
        this.gXr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bzr != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bzr);
                    }
                    if (WriteActivity.this.aBt != null) {
                        WriteActivity.this.aBt.Bc();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gWT = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.gWU = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.gWQ = (LinearLayout) findViewById(d.g.tool_view);
        this.gWQ.setContentDescription("..");
        this.gWR = (LinearLayout) findViewById(d.g.title_view);
        this.fZo = findViewById(d.g.interval_view);
        this.gXO = findViewById(d.g.hot_topic_fourm_view);
        this.gXP = findViewById(d.g.hot_topic_divider);
        this.gXQ = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.gXR = (TextView) findViewById(d.g.change_one_tv);
        bod();
        if (this.gXB) {
            this.gXr.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bEI();
        } else {
            this.gXo = new d(getPageContext(), this.mRootView);
            this.gXo.nI(this.mData.getType() == 0);
        }
        VW();
        if (this.gWM || this.gWN) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aic) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bzs = (LinearLayout) findViewById(d.g.post_content_container);
        this.bzs.setDrawingCacheEnabled(false);
        this.bzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bzr.requestFocus();
                WriteActivity.this.aBt.Bc();
            }
        });
        this.aqg.setOnFocusChangeListener(this.bzy);
        this.aqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bnW();
                WriteActivity.this.bEg();
            }
        });
        this.gWX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bEQ();
        h(bFc());
        bEU();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gWM || this.gWN) {
                    if (this.gWO) {
                        this.mName.setText(d.j.feedback_vcode);
                    } else {
                        this.mName.setText(d.j.feedback);
                    }
                } else {
                    this.mName.setText(d.j.post_new_thread);
                }
                this.fZn.setVisibility(0);
                this.bzr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.j.send_reply);
                this.bzr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fZn.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.j.publish_photo_live);
                this.bzr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gXu.setVisibility(8);
                break;
            case 7:
                this.fZn.setVisibility(0);
                this.bzr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.j.post_drift_bottle);
                break;
        }
        bEV();
        bFa();
        bEH();
        bES();
        boc();
        bFd();
        if (this.mData.getType() == 4 && this.fZt != null && this.gWV != null) {
            this.fZt.setVisibility(8);
            this.gWV.setVisibility(8);
        }
        boe();
        ShowSoftKeyPad(this.mInputManager, this.fZn);
        bER();
    }

    private void bEN() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bEO() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gWM && !this.gWN && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bEY() != null) {
                bEY().setText(d);
                bEY().setSelection(d.length());
            }
        }
    }

    private void bEP() {
        this.gXi = null;
        this.gXk = -1;
        this.gXm = -1;
        aa jv = z.aks().jv(1);
        if (jv != null) {
            this.gXi = jv.cAT;
            this.gXk = getIntent().getIntExtra("category_id", -1);
            if (this.gXi != null && !this.gXi.isEmpty() && this.gXk >= 0) {
                this.gXj = new y();
                this.gXj.cAP = 0;
                this.gXj.name = getPageContext().getResources().getString(d.j.category_auto);
                this.gXm = this.gXj.cAP;
                this.gXl = this.gXj.name;
                for (y yVar : this.gXi) {
                    if (yVar.cAP == this.gXk) {
                        this.gXm = yVar.cAP;
                        this.gXl = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bEQ() {
        if (this.gXi != null && !this.gXi.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.gXn = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.gXn.setText(this.gXl);
            this.gXn.b(this.gXi, this.gXj, this.gXm);
            this.gXn.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.gXn.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.cAP);
                        WriteActivity.this.gXm = atVar.cAP;
                        WriteActivity.this.gXn.bDZ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gXn.bDY();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEY());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEX());
                }
            });
        }
    }

    private void bER() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gYf = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gYf.setTitle(d.j.no_disturb_start_time);
        this.gYf.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.gYf);
        this.gYf.setButton(-2, getPageContext().getString(d.j.cancel), this.gYf);
        return this.gYf;
    }

    private void bES() {
        this.gXd = (RelativeLayout) findViewById(d.g.addition_container);
        this.gXe = (TextView) findViewById(d.g.addition_create_time);
        this.gXf = (TextView) findViewById(d.g.addition_last_time);
        this.gXg = (TextView) findViewById(d.g.addition_last_content);
        if (this.gXc != null) {
            this.gXd.setVisibility(0);
            this.gXe.setText(getPageContext().getString(d.j.write_addition_create) + am.r(this.gXc.getCreateTime() * 1000));
            if (this.gXc.getAlreadyCount() == 0) {
                this.gXf.setVisibility(8);
            } else {
                this.gXf.setText(getPageContext().getString(d.j.write_addition_last) + am.r(this.gXc.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gXc.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gXg.setText(lastAdditionContent);
            } else {
                this.gXg.setVisibility(8);
            }
            bEX().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.gXc.getAlreadyCount()), Integer.valueOf(this.gXc.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.gXd.setVisibility(8);
    }

    private void boc() {
        this.fZt = findViewById(d.g.post_prefix_layout);
        this.fZq = (TextView) findViewById(d.g.post_prefix);
        this.gWV = findViewById(d.g.prefix_divider);
        this.fZs = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fZt.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fYW = 1;
            this.fZt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fZq.setVisibility(0);
                    WriteActivity.this.fZt.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fZr, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBt.Bc();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fZn);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bzr);
                }
            });
            this.fZs = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.fZs.setVisibility(0);
                this.fZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fZq.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fZr, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBt.Bc();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEY());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEX());
                    }
                });
            }
            this.fZr = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.fZr.a(this);
            this.fZr.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.fZr.setOutsideTouchable(true);
            this.fZr.setFocusable(true);
            this.fZr.setOnDismissListener(this);
            this.fZr.setBackgroundDrawable(aj.getDrawable(d.C0080d.cp_bg_line_d));
            int color = aj.getColor(d.C0080d.cp_cont_b);
            int color2 = aj.getColor(d.C0080d.cp_cont_c);
            aj.j(this.fZq, d.C0080d.cp_bg_line_d);
            aj.c(this.fZs, d.f.icon_frs_arrow_n);
            this.fZq.setTextColor(color);
            this.gVN.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.gVN.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.fZr.addView(dVar);
            }
            this.fZr.setCurrentIndex(0);
            this.fZq.setText(prefixs.get(1));
            vF(1);
            return;
        }
        this.fZt.setVisibility(8);
    }

    private void bET() {
        if (this.gWM && this.mData != null) {
            this.gWT.setVisibility(0);
            this.gWU.setVisibility(0);
            this.gWS = new FeedBackModel(this);
            this.gWS.ui(this.mData.getForumName());
            this.gWS.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gWT.setVisibility(8);
                        WriteActivity.this.gWU.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gWT.setVisibility(8);
                        WriteActivity.this.gWU.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gWT.a(feedBackModel.bEz(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bEU() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.hh()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.gXY.bCr()) {
                        WriteActivity.this.showToast(WriteActivity.this.gXY.bCt());
                        WriteActivity.this.nE(true);
                    } else if (WriteActivity.this.gUL.bCr()) {
                        WriteActivity.this.showToast(WriteActivity.this.gUL.bCt());
                        WriteActivity.this.nz(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEY());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bEX());
                        WriteActivity.this.aBt.Bc();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.gWM) {
                                WriteActivity.this.bEh();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                if (WriteActivity.this.gUw.bCn()) {
                                    WriteActivity.this.bFg();
                                } else {
                                    WriteActivity.this.gXM = true;
                                    WriteActivity.this.gUw.cn(WriteActivity.this.bcR(), WriteActivity.this.bFf());
                                }
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bEh();
                        }
                        TiebaStatic.log(new ak("c12262").ac("obj_locate", WriteActivity.this.gTt));
                    }
                }
            }
        });
    }

    protected void bEV() {
        this.gWY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gWY.cS(getPageContext().getString(d.j.is_save_draft)).ao(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bEY().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bEX().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    s.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    s.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    s.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    s.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.gWY.b(getPageContext());
    }

    protected void bod() {
        this.gWP = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.gWP.setIsRound(true);
        this.gWP.setDrawBorder(false);
        this.gWP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dE = o.dE(currentPortrait);
            this.gWP.setUrl(dE);
            this.gWP.startLoad(dE, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gWP.setVisibility(0);
        }
        this.fZn = (EditText) findViewById(d.g.post_title);
        this.fZn.setOnClickListener(this.gYc);
        this.fZn.setOnFocusChangeListener(this.bzy);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fZn.setText(this.mData.getTitle());
                this.fZn.setSelection(this.mData.getTitle().length());
            } else if (this.gWO) {
                this.fZn.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fZn.addTextChangedListener(this.bzA);
        if (!this.mData.getHaveDraft()) {
            bEO();
            this.gXL = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fZn.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.fZn.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bco() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            private int bzD;
            private EditText dMp = null;
            private TextView abE = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.boe();
                if (WriteActivity.this.gXB) {
                    this.bzD = this.dMp.getSelectionStart();
                    this.dMp.setSelection(this.bzD);
                    WriteActivity.this.b(this.abE, this.dMp);
                }
                if (this.dMp != WriteActivity.this.gXw || WriteActivity.this.gXY == null || WriteActivity.this.gXY.bCs()) {
                    if (this.dMp == WriteActivity.this.gXs && WriteActivity.this.gUL != null && !WriteActivity.this.gUL.bCs()) {
                        WriteActivity.this.nz(false);
                    }
                } else {
                    WriteActivity.this.nE(false);
                }
                if (WriteActivity.this.gXY != null) {
                    WriteActivity.this.gXY.nr(false);
                }
                if (WriteActivity.this.gUL != null) {
                    WriteActivity.this.gUL.nr(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gXB || !WriteActivity.this.gXC) {
                    if (WriteActivity.this.gXB) {
                        if (this.dMp != WriteActivity.this.gXs || this.abE != WriteActivity.this.gXy) {
                            this.dMp = WriteActivity.this.gXs;
                            this.abE = WriteActivity.this.gXy;
                        }
                    }
                } else if (this.dMp != WriteActivity.this.gXw || this.abE != WriteActivity.this.gXx) {
                    this.dMp = WriteActivity.this.gXw;
                    this.abE = WriteActivity.this.gXx;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gXB && this.gXC) {
            if (this.gXz != null) {
                this.gXw.removeTextChangedListener(this.gXz);
            }
            this.gXz = textWatcher;
        } else if (this.gXB) {
            if (this.gXA != null) {
                this.gXs.removeTextChangedListener(this.gXA);
            }
            this.gXA = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.gXs) {
            return 233L;
        }
        if (editText != this.gXw) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long h = j - h(editText);
            String valueOf = String.valueOf(h);
            if (j == 20) {
                if (h < 0) {
                    if (h < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0080d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                }
            } else if (h < 0) {
                if (h < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0080d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long h(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void VW() {
        this.bzr = (EditText) findViewById(d.g.post_content);
        this.bzr.setDrawingCacheEnabled(false);
        this.bzr.setOnClickListener(this.gYc);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.Er().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.bzr.setText(T);
            this.bzr.setSelection(T.length());
        } else if (this.mData.getType() == 2) {
            if (this.gWZ) {
                if (this.gXa != null && this.gXa.length() > 0) {
                    this.bzr.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.gXa}));
                    this.bzr.setSelection(this.bzr.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bzr.setText(format);
                this.bzr.setSelection(format.length());
            }
        }
        this.bzr.setOnFocusChangeListener(this.bzy);
        this.bzr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bzr.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bzr.addTextChangedListener(this.gYe);
        if (this.mData.getType() == 0) {
            this.gXX = true;
        } else {
            nF(true);
            this.gXX = false;
        }
        if (this.mData.isUserFeedback()) {
            this.bzr.setHint(d.j.write_input_content);
        } else {
            this.bzr.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nF(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gXB) {
            bEX().setPadding(0, 0, 0, 0);
            bEX().setBackgroundDrawable(null);
            aj.k(bEX(), d.C0080d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.epI) && this.gXc == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.epI, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass28) aVar, str, i);
                        if (aVar != null && aVar.kK() != null && aVar.kO() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kK(), aVar.kK().getNinePatchChunk(), aVar.kO(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bEX().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bEX(), true, WriteActivity.this.eUj);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEW() {
        int i = 5000;
        if (this.gXc != null) {
            i = 1000;
        }
        return bEX().getText() != null && bEX().getText().length() >= i;
    }

    private void fO(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gWK)) {
                this.gWK = "";
                bEX().requestFocus();
                if (bEX().getText() != null && bEX().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bEX().getSelectionStart();
                    editable = bEX().getText();
                }
            } else if ("from_title".equals(this.gWK)) {
                this.gWK = "";
                bEY().requestFocus();
                if (bEY().getText() != null && bEY().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bEY().getSelectionStart();
                    editable = bEY().getText();
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

    protected void d(m mVar) {
        if (((ImageSpan[]) bEX().getText().getSpans(0, bEX().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gXb == null) {
                this.gXb = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.gXb.show();
            return;
        }
        String name = mVar.getName();
        final EmotionGroupType xZ = mVar.xZ();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass30) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bEX().getSelectionStart(), aVar, xZ);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bEX() != null && bEX().getText() != null) {
            Bitmap kK = aVar.kK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
            int width = kK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bEX().getSelectionStart() - 1;
                if (bEX().getText().length() > 1 && selectionStart >= 0 && bEX().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bEX().getText().insert(bEX().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bEX().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bEX().getText().insert(bEX().getSelectionStart(), spannableString2);
            }
            Editable text = bEX().getText();
            if (text != null) {
                this.gXV.clear();
                this.gXV.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gXV);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bEX().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bEX().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bEX().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bEX() {
        return this.gXB ? this.gXs : this.bzr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bEY() {
        return this.gXB ? this.gXw : this.fZn;
    }

    protected void bEZ() {
        Editable text;
        if (bEX() != null && (text = bEX().getText()) != null) {
            int selectionStart = bEX().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bEX().onKeyDown(67, this.gWW);
            }
            bEX().onKeyDown(67, this.gWW);
            int selectionStart2 = bEX().getSelectionStart();
            if (text != null) {
                this.gXV.clear();
                this.gXV.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gXV);
                bEX().setSelection(selectionStart2);
            }
        }
    }

    private void h(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.gWM = true;
        }
    }

    private void bFa() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bFb() {
        try {
            if (this.gWY != null) {
                this.gWY.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLW.c(null);
        this.aLW.da(d.j.sending);
        this.aLW.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLW.aE(false);
    }

    private Boolean bFc() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDj = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boe() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bEY() != null) {
                str = bEY().getText().toString();
            }
            if (bEX() != null) {
                str2 = bEX().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fYW == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dn(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dn(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dn(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gXB) {
                    dn(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dn(true);
                }
            }
            if (this.mData.getType() == 4) {
                dn(l(this.gXs) && k(this.gXw));
            } else if (this.mData.getType() == 5) {
                dn(l(this.gXs));
            } else if (!TextUtils.isEmpty(str2) || this.aDc != null) {
                dn(true);
            } else if (this.mData.getVideoInfo() != null) {
                dn(true);
            } else {
                dn(false);
            }
        }
    }

    private void dn(boolean z) {
        if (z) {
            aj.b(this.mPost, d.C0080d.cp_link_tip_a, d.C0080d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.C0080d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean k(EditText editText) {
        long h = h(editText);
        return h <= 20 && h > 0;
    }

    private boolean l(EditText editText) {
        long h = h(editText);
        if (h > 233) {
            return false;
        }
        return h > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aDf = new NewWriteModel(this);
        this.aDf.b(this.aDw);
        registerListener(this.gXZ);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bnW();
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
            this.gWM = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gWO = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gWZ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gXa = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aDd = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString(WriteActivityConfig.ADDITION_DATA);
            if (!StringUtils.isNull(string2)) {
                this.gXc = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.gXc != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.gXh = bundle.getInt("mem_type", 0);
            this.aiB = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gXS = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gTt = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gWM = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gWO = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gWZ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gXa = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gXc = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gXc != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gXh = intent.getIntExtra("mem_type", 0);
            this.aiB = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gXS = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gTt = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gWM);
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
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                s.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                s.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            s.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            s.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            s.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.epI = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gWN = true;
        }
        bEP();
        try {
            this.gXD = bFk();
        } catch (Throwable th) {
            this.gXD = null;
        }
    }

    private void bFd() {
        if (v.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gWP.setVisibility(8);
            this.gXO.setVisibility(0);
            this.gXP.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fZn.setText(com.baidu.tbadk.plugins.a.gG(uj(this.mList.get(0).mTopicName)));
                this.fZn.setMovementMethod(com.baidu.tieba.view.c.bBt());
            }
            this.gXQ.setText(this.mList.get(0).mForumName);
            this.fZn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gXT.equals(charSequence.toString())) {
                        WriteActivity.this.gXU = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gG;
                    if (!WriteActivity.this.gXT.equals(editable.toString()) && (gG = com.baidu.tbadk.plugins.a.gG(editable.toString())) != null) {
                        WriteActivity.this.gXT = gG.toString();
                        WriteActivity.this.fZn.setText(gG);
                        if (WriteActivity.this.gXU <= WriteActivity.this.fZn.getText().length()) {
                            WriteActivity.this.fZn.setSelection(WriteActivity.this.gXU);
                        }
                    }
                }
            });
            this.gXR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
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
            SpannableString gG = com.baidu.tbadk.plugins.a.gG(uj(hotTopicBussinessData.mTopicName));
            if (gG != null) {
                this.fZn.setText(gG);
            }
            this.gXQ.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uj(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.s.a
    public void a(WriteData writeData) {
        String uj;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!k.isEmpty(writeData.getTitle())) {
                    this.gWR.setVisibility(0);
                    this.gWR.requestFocus();
                    this.aBt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (k.isEmpty(bEY().getText().toString()) || this.gXL || ((this.gWM || this.gWN) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            uj = this.mData.getTitle();
                        } else {
                            uj = uj(str);
                        }
                        SpannableString gG = com.baidu.tbadk.plugins.a.gG(uj);
                        if (gG != null) {
                            bEY().setText(gG);
                            bEY().setSelection(gG.length() > uj.length() ? uj.length() : gG.length());
                        }
                    } else {
                        SpannableString gG2 = com.baidu.tbadk.plugins.a.gG(this.mData.getTitle());
                        if (gG2 != null) {
                            bEY().setText(gG2);
                            bEY().setSelection(this.mData.getTitle().length() > gG2.length() ? gG2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bEO();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bEX().getText().toString()) || this.gWM || this.gWN) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Er().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gYa);
                    bEX().setText(a2);
                    bEX().setSelection(a2.length());
                    if (this.gXB) {
                        b(this.gXy, this.gXs);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bFj();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DG();
                    }
                    nH(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bFe();
                }
                boe();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gXi != null) {
                    this.gXm = this.gXj.cAP;
                    this.gXl = this.gXj.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gXi.size()) {
                            break;
                        }
                        y yVar = this.gXi.get(i);
                        if (categoryTo != yVar.cAP) {
                            i++;
                        } else {
                            this.gXm = categoryTo;
                            this.gXl = yVar.name;
                            this.mData.setCategoryTo(this.gXm);
                            break;
                        }
                    }
                    if (this.gXn != null) {
                        this.gXn.setText(this.gXl);
                        this.gXn.b(this.gXi, this.gXj, this.gXm);
                    }
                }
                this.aBt.Bc();
                return;
            }
            return;
        }
        bFe();
        bEO();
    }

    private void bFe() {
        if ((!this.gXB || this.gXq != null) && this.gXp != null) {
            this.gXq.c(this.writeImagesInfo);
            aKc();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gWZ);
        if (this.gWM) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDd);
        if (this.gXc != null) {
            bundle.putString(WriteActivityConfig.ADDITION_DATA, OrmObject.jsonStrWithObject(this.gXc));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.gXh);
        bundle.putString("from", this.aiB);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gTt);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bEX().getEditableText().toString();
        if (obj != null) {
            bEX().setText(TbFaceManager.Er().a(getPageContext().getPageActivity(), obj, this.gYa));
            bEX().setSelection(bEX().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bFf() {
        return (bEX() == null || bEX().getText() == null) ? "" : bEX().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcR() {
        if (this.mData == null || bEY() == null || bEY().getText() == null) {
            return "";
        }
        String obj = bEY().getText().toString();
        if (this.mPrefixData != null && v.u(this.mPrefixData.getPrefixs()) > 0 && this.fYW != 0 && this.mData.getType() != 4 && this.fZq != null && this.fZq.getText() != null) {
            obj = this.fZq.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        bnW();
        this.mData.setContent(bFf());
        this.mData.setTitle(bcR());
        if (this.gWM || this.gWN) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
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
                if (j.hh()) {
                    sb.append(j.hp());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gXk >= 0) {
            this.mData.setCategoryFrom(this.gXk);
        }
        if (this.gXm >= 0) {
            this.mData.setCategoryTo(this.gXm);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDe != null && this.aDe.WV());
        this.aDf.mJ(this.writeImagesInfo.size() > 0);
        if (!v.v(this.mList) && this.gXN != null && this.gXN.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gXN.mForumId));
            this.mData.setForumName(this.gXN.mForumName);
        }
        this.aDf.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aDc != null) {
            if (this.aDc.getId() != null) {
                this.aDf.getWriteData().setVoice(this.aDc.getId());
                this.aDf.getWriteData().setVoiceDuringTime(this.aDc.duration);
            } else {
                this.aDf.getWriteData().setVoice(null);
                this.aDf.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDf.getWriteData().setVoice(null);
            this.aDf.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDf.bvL()) {
            showToast(d.j.write_img_limit);
        } else if (!j.hh()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.aDf.startPostWrite();
        }
    }

    private void s(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.gXc != null) {
                i2 = this.gXc.getTotalCount();
                i = this.gXc.getAlreadyCount() + 1;
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

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aBt != null && !this.aBt.CX()) {
                    bEX().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
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
                            bEX().getText().insert(bEX().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    s.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    s.d(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    s.c(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                i(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bdM();
                            } else {
                                ad(intent);
                            }
                        } else if (intExtra == 1) {
                            T(intent);
                        } else {
                            ac(intent);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.gXX) {
                            nF(true);
                            this.gXX = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gXB) {
                        A(intent);
                        boe();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBt.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBt.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBt.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    boe();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gWL) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gWL = false;
                            }
                            sb2.append(stringExtra);
                            fO(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.v(this.mList)) {
                    if (!v.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gXN = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gXN);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gUw.aa(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.bzx = this.gUw.bCm();
                        this.aBt.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gXM) {
                        bFg();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aBt != null && !this.aBt.CX()) {
                this.bzr.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DC();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bFi();
                    if (this.gXX) {
                        nF(true);
                        this.gXX = false;
                        return;
                    }
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA)) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.gUL.aB(postWriteCallBackData.getSensitiveWords());
                        this.gXY.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.v(this.gUL.bCp())) {
                            nz(true);
                            nE(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDd = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aDd);
                    return;
                case 12012:
                    bFi();
                    return;
                case 25004:
                    if ("from_title".equals(this.gWK)) {
                        bEY().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gWK)) {
                        bEX().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFg() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gUw.bCl());
        this.mData.setCallFrom(this.gTt);
        this.mData.setRecommendExt(this.gUw.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bEh();
    }

    private void bFh() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bFi() {
        if (this.gXB) {
            this.gXq.c(this.writeImagesInfo);
            aKc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKc() {
        this.gXq.notifyDataSetChanged();
        this.gXp.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gXq.notifyDataSetChanged();
                WriteActivity.this.gXp.invalidateViews();
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
        boe();
    }

    private void ac(Intent intent) {
        if (this.gXB) {
            af(intent);
            bFi();
        } else {
            ag(intent);
        }
        boe();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bFi();
            nH(true);
        }
    }

    private void ad(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bdM() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fyU.parseJson(stringExtra);
            this.fyU.updateQuality();
            if (this.fyU.getChosedFiles() != null && this.fyU.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fyU.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fyU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bEY());
        HidenSoftKeyPad(this.mInputManager, bEX());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ag(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aDd = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDd;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ac(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDd, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bFj();
            DG();
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
                bFj();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DG();
                }
            }
            nH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFj() {
        if (this.aBt.eO(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DC() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDd));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nH(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.gXo != null) {
            this.gXo.a(this.writeImagesInfo, this.aiB, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cxT == null) {
            this.cxT = VoiceManager.instance();
        }
        return this.cxT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ajy() {
        this.cxT = getVoiceManager();
        this.cxT.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ua(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cyL) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahs));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gXc == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                s(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDl = i;
        if (this.aBt != null) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aBt.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DG() {
        if (!this.gXB) {
            if (this.aBt != null) {
                this.aBt.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBt.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.gXo != null) {
                this.gXo.a(this.writeImagesInfo, this.aiB, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (this.aBt != null) {
            this.aBt.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vF(int i) {
        if (i < this.gVN.size()) {
            for (int i2 = 0; i2 < this.gVN.size(); i2++) {
                this.gVN.get(i2).nt(false);
            }
            this.gVN.get(i).nt(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void tm(int i) {
        this.fYW = i;
        this.fZr.setCurrentIndex(i);
        vF(i);
        this.fZq.setText(this.mPrefixData.getPrefixs().get(i));
        boe();
        g.a(this.fZr, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fZt.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Dx();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.aDd);
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
        if (this.gXJ && System.currentTimeMillis() - this.gXK < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gXJ = false;
        }
        if (this.gXW != null && !z) {
            this.gXW.aUG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(String str) {
        if (!k.isEmpty(str) && this.gXG != null) {
            ul(str);
            this.gXG.dismiss();
        }
    }

    private void ca(Context context) {
        gXI = l.ae(context);
    }

    private void ul(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gXJ = true;
        bFj();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DG();
        }
        nH(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4035=4] */
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

    private File bFk() {
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

    private void bFl() {
        if (this.gXD != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ca(getActivity());
            this.gXF = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.gXF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gXD != null) {
                        WriteActivity.this.uk(WriteActivity.this.gXD.getAbsolutePath());
                    }
                }
            });
            this.gXE = (TbImageView) this.gXF.findViewById(d.g.rec_img_view);
            this.gXH = (LinearLayout) this.gXF.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gXD.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gXD.getAbsolutePath());
                Bitmap d = d(this.gXD.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.gXE.setImageBitmap(d);
                    this.gXE.setDrawBorder(true);
                    this.gXE.setBorderWidth(2);
                    this.gXE.setBorderColor(aj.getColor(d.C0080d.common_color_10264));
                    this.gXG = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.gXG.setCanceledOnTouchOutside(true);
                    this.gXG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gXJ) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gXK = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gXG.setContentView(this.gXF);
                    this.gXG.show();
                    Window window = this.gXG.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (gXI / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.gWL = false;
            this.gWK = "";
            if ("from_content".equals(str)) {
                this.gWK = "from_content";
            } else if ("from_title".equals(str)) {
                this.gWK = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nG(false);
            }
        }
    }

    public void Be() {
        if (this.gWM || !v.v(this.mList)) {
            this.gWR.setVisibility(0);
            this.gWR.requestFocus();
            this.aBt.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gWR.setVisibility(8);
    }
}
