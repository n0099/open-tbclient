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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0125a, VoiceManager.c, w.a, i.a {
    private static int lZP = 0;
    private EditorTools elb;
    private String emF;
    private LocationModel emG;
    private NewWriteModel emH;
    List<aa> fnD;
    private String hlx;
    private String hly;
    private String hlz;
    private VoiceManager hns;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private ImageView jNB;
    private LinearLayout jNy;
    private PlayVoiceBntNew jNz;
    private FrsTabInfoData lSC;
    private ForumTabSelectedView lXd;
    private LinearLayout lYD;
    private LinearLayout lYE;
    private View lYG;
    private Toast lYI;
    private AdditionData lYJ;
    private RelativeLayout lYK;
    private TextView lYL;
    private TextView lYM;
    private TextView lYN;
    aa lYO;
    private int lYP;
    private String lYQ;
    private int lYR;
    private PostCategoryView lYS;
    private HotTopicBussinessData lYV;
    private TextView lYW;
    private com.baidu.tieba.write.editor.b lYY;
    private View lZT;
    private View lZU;
    private TextView lZV;
    private com.baidu.tieba.c.d lZX;
    private e lZa;
    private com.baidu.tieba.view.b lZh;
    private View lZr;
    private g lZy;
    private TextView lbJ;
    private com.baidu.tieba.write.i lbK;
    private ImageView lbL;
    private View lbM;
    private int lbm;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String lYz = "";
    private boolean lYA = false;
    private WriteData lbl = null;
    private boolean lZm = false;
    private boolean lZn = false;
    private boolean lYC = false;
    private boolean lZo = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lbD = null;
    private HeadImageView lZp = null;
    private View lbE = null;
    private LinearLayout lbG = null;
    private EditText lbH = null;
    private FeedBackModel lYF = null;
    private FeedBackTopListView lZq = null;
    private ArrayList<WritePrefixItemLayout> lYH = new ArrayList<>();
    private String jjn = null;
    private final KeyEvent gZC = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lZs = null;
    private TextView lbI = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hes = null;
    private com.baidu.tbadk.core.dialog.a lZt = null;
    private final Handler mHandler = new Handler();
    private boolean lZu = false;
    private String lZv = null;
    private RelativeLayout ita = null;
    private String emL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int emM = 0;
    private int lZw = 0;
    private WriteImagesInfo lZx = new WriteImagesInfo();
    private View mRootView = null;
    private GridView lZz = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a lZA = null;
    private ScrollView lYT = null;
    private EditText lZB = null;
    private View lZC = null;
    private View lZD = null;
    private View lZE = null;
    private EditText lZF = null;
    private TextView lZG = null;
    private TextView lZH = null;
    private TextWatcher lZI = null;
    private TextWatcher lZJ = null;
    private boolean lYU = false;
    private boolean lZK = false;
    private com.baidu.tbadk.core.view.a euw = null;
    private String mFrom = "write";
    private File lZL = null;
    private TbImageView lZM = null;
    private View mBubbleView = null;
    private Dialog lZN = null;
    private LinearLayout lZO = null;
    private boolean lZQ = false;
    private long lZR = -1000;
    private boolean lZS = false;
    private String hOW = "2";
    private int bdm = 0;
    private String mTopicId = "";
    private SpannableStringBuilder lYX = new SpannableStringBuilder();
    private boolean lZW = false;
    private boolean aUD = false;
    private final b lYZ = new b();
    private boolean lWI = false;
    private final HttpMessageListener lZY = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jjn)) {
                    WriteActivity.this.jjn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.vD(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jjn)) {
                    WriteActivity.this.jjn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jjn);
                    WriteActivity.this.vD(true);
                }
            }
        }
    };
    private TbFaceManager.a lZb = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan yt(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
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
    private final AntiHelper.a hoB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bVp();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.lbl != null) {
                WriteActivity.this.lYZ.aX(null);
                if (z) {
                    WriteActivity.this.ie(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.lbl.getType() != 0 && WriteActivity.this.lbl.getType() != 9) {
                        if (WriteActivity.this.lbl.getType() != 7) {
                            if (WriteActivity.this.lbl.getType() == 1) {
                                w.e(WriteActivity.this.lbl.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.lbl.getType() == 5) {
                                w.e(WriteActivity.this.lbl.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            if (WriteActivity.this.lWI) {
                                w.d(WriteActivity.this.lbl.getForumId(), (WriteData) null);
                            } else {
                                w.c(WriteActivity.this.lbl.getForumId(), (WriteData) null);
                            }
                        }
                        if (!v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").dh("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.lYZ.aX(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.lYZ.Og(postWriteCallBackData.getErrorString());
                    WriteActivity.this.lYZ.b(WriteActivity.this.lbD, WriteActivity.this.lbH);
                } else if ((abVar == null || writeData == null || abVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (abVar != null && writeData != null && abVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(abVar.getVcode_md5());
                    writeData.setVcodeUrl(abVar.getVcode_pic_url());
                    writeData.setVcodeExtra(abVar.aYn());
                    if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm());
                        if (WriteActivity.this.lZo) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a emT = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bdO() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.dep())) {
                WriteActivity.this.a(2, true, aVar.dep());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener loD = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.emG.uw(false);
                    WriteActivity.this.emG.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.emG.uw(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener lZc = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lZd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dot = WriteActivity.this.dot();
            if (dot >= 0 && dot < WriteActivity.this.lbH.getText().length()) {
                WriteActivity.this.lbH.setSelection(dot);
            }
        }
    };
    private boolean lZe = true;
    private final View.OnFocusChangeListener fPo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lbD || view == WriteActivity.this.mBack || view == WriteActivity.this.lbI) {
                if (z) {
                    WriteActivity.this.lZe = true;
                    WriteActivity.this.dou();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lbD);
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbA();
                    }
                } else if (view == WriteActivity.this.lbD) {
                    WriteActivity.this.lbJ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.lbH && z) {
                WriteActivity.this.lZe = false;
                WriteActivity.this.dou();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lbH);
                if (WriteActivity.this.elb != null) {
                    WriteActivity.this.elb.bbA();
                }
            }
            WriteActivity.this.doz();
        }
    };
    private TextWatcher lZf = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String lZj = "";
        private String lZk;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lZk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lZk != null ? this.lZk.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dam();
            WriteActivity.this.doA();
            EditText doM = WriteActivity.this.doM();
            if (editable != null && doM != null && doM.getText() != null) {
                if (this.lZj == null || !this.lZj.equals(editable.toString())) {
                    if (WriteActivity.this.lYZ != null) {
                        this.lZj = doM.getText().toString();
                        WriteActivity.this.lYZ.b(doM, true);
                        return;
                    }
                    return;
                }
                doM.setSelection(doM.getSelectionEnd());
            }
        }
    };
    private TextWatcher lZg = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String lZk;
        private String lZl = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lZk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lZk != null ? this.lZk.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dam();
            EditText doL = WriteActivity.this.doL();
            if (editable != null && doL != null && doL.getText() != null) {
                if (this.lZl == null || !this.lZl.equals(editable.toString())) {
                    if (WriteActivity.this.lYZ != null) {
                        this.lZl = doL.getText().toString();
                        WriteActivity.this.lYZ.b(doL, false);
                        return;
                    }
                    return;
                }
                doL.setSelection(doL.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0727a jTX = new a.InterfaceC0727a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0727a
        public void onRefresh() {
            WriteActivity.this.jjn = null;
            WriteActivity.this.vD(false);
            WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bdz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdB();
        } else if (this.emG.dew()) {
            bdy();
        } else {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.deu();
        }
    }

    public void doV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.lYY != null) {
                this.lYY.dnm();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdB();
        } else if (this.emG != null) {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.deu();
        }
    }

    private void bdB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.emG.dey();
                } else {
                    WriteActivity.this.emT.bdO();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dot() {
        int selectionEnd = doL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) doL().getText().getSpans(0, doL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = doL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = doL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dou() {
        if (this.elb != null) {
            this.elb.setBarLauncherEnabled(!this.lZe);
            this.elb.setBarLauncherEnabled(true, 26);
            this.elb.setBarLauncherEnabled(true, 2);
            this.elb.setBarLauncherEnabled(true, 30);
            ag(9, this.lZe ? false : true);
        }
    }

    private void ag(int i, boolean z) {
        com.baidu.tbadk.editortools.g ne;
        if (this.elb != null && (ne = this.elb.ne(i)) != null) {
            if (z) {
                ne.display();
            } else {
                ne.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.lYU) {
            this.lbD.setVisibility(8);
            if (this.lbl.getType() == 5) {
                this.lZE.setVisibility(8);
            } else {
                this.lZE.setVisibility(0);
            }
            a(this.lZH, this.lZB);
            a(this.lZG, this.lZF);
            dam();
        }
        if (this.lZm) {
            this.lZe = true;
            dou();
            if (this.elb != null) {
                this.elb.bbA();
            }
            this.lbD.requestFocus();
            ShowSoftKeyPadDelay(this.lbD);
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
            dpl();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                doT();
            }
            vE(true);
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
        if (this.lbl.getType() == 0) {
            FQ(this.bdm);
        }
        initUI();
        dpa();
        this.emG = new LocationModel(getPageContext());
        this.emG.a(this.emT);
        registerListener(this.loD);
        registerListener(this.lZc);
        cxG();
        dpo();
        if (this.lYU) {
            this.lZA.setEditorTools(this.elb);
        } else {
            this.lbH.requestFocus();
        }
        cVm();
        doT();
        dpm();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cxG() {
        this.elb = new EditorTools(getActivity());
        this.elb.setBarMaxLauCount(5);
        this.elb.setMoreButtonAtEnd(true);
        this.elb.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.elb.setBarLauncherType(1);
        this.elb.hW(true);
        this.elb.hX(true);
        switch (this.lbl.getType()) {
            case 4:
            case 5:
                doY();
                break;
            default:
                dov();
                break;
        }
        this.elb.build();
        if (this.lYD != null) {
            this.lYD.addView(this.elb);
        }
        crq();
        this.elb.display();
        com.baidu.tbadk.editortools.g ne = this.elb.ne(6);
        if (ne != null && !TextUtils.isEmpty(this.emL)) {
            ((View) ne).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.emL);
                }
            });
        }
        if (!this.lYU) {
            this.elb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.elb.bbA();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (!this.lWI) {
            dox();
        }
    }

    private void doW() {
        this.lZC = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.lZE = this.lZC.findViewById(R.id.live_post_title_container);
        this.lZB = (EditText) this.lZC.findViewById(R.id.live_post_content);
        this.lZz = (GridView) this.lZC.findViewById(R.id.photoLiveGridView);
        this.lZF = (EditText) this.lZC.findViewById(R.id.live_post_title);
        this.lZG = (TextView) this.lZC.findViewById(R.id.titleOverPlusNumber);
        this.lZH = (TextView) this.lZC.findViewById(R.id.contentOverPlusNumber);
        this.lZD = this.lZC.findViewById(R.id.live_interval_view);
        this.lZG.setText(String.valueOf(20));
        this.lZH.setText(String.valueOf(233));
        this.lZC.setVisibility(0);
        this.lZG.setVisibility(0);
        this.lZH.setVisibility(0);
        this.lZF.setHint(R.string.tips_title_limit_new);
        this.lZF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lZK = true;
                    WriteActivity.this.lZe = true;
                    WriteActivity.this.dou();
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbA();
                    }
                }
            }
        });
        if (this.lbl.getType() == 4) {
            this.lZB.setHint(R.string.live_write_input_content_new);
        } else if (this.lbl.getType() == 5) {
            this.lZB.setHint(R.string.live_write_input_content_update);
        }
        this.lZB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lZK = false;
                    WriteActivity.this.lZe = false;
                    WriteActivity.this.dou();
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbA();
                    }
                }
            }
        });
        this.lZB.requestFocus();
        this.lZB.addTextChangedListener(aeH());
        this.lZF.requestFocus();
        this.lZF.addTextChangedListener(aeH());
        this.lZF.setOnClickListener(this.lZd);
        this.lZB.setOnClickListener(this.lZd);
        this.lZA = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.lZz);
        this.lZA.FK(6);
        this.lZz.setAdapter((ListAdapter) this.lZA);
        View findViewById = this.lZC.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dof() {
                WriteActivity.this.dpj();
            }
        });
        doX();
    }

    private void doX() {
        if (this.lbl.getType() == 0) {
            if (this.lbl.getTitle() != null) {
                this.lZF.setText(this.lbl.getTitle());
                this.lZF.setSelection(this.lbl.getTitle().length());
                return;
            }
            return;
        }
        if (this.lbl.getType() == 1 || this.lbl.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.lYU) {
            dph();
        }
        if (this.elb.bcZ()) {
            this.elb.bbA();
        }
        FQ(0);
    }

    private void FQ(int i) {
        if (this.writeImagesInfo != null && this.lbl != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lbl.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.lbl.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hOW);
            albumActivityConfig.setProfessionZone(this.lbl.getProZone());
            albumActivityConfig.setFrsTabInfo(this.lSC);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void doY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nh = this.elb.nh(5);
        if (nh != null) {
            nh.elL = 2;
        }
        this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.elb.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dov() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.l lVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.l lVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.l lVar4;
        CustomResponsedMessage runTask5;
        com.baidu.tbadk.editortools.l lVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.elb.b(dVar);
        }
        if (!this.lWI) {
            Boolean dpe = dpe();
            if (!this.lZm && dpe != null && dpe.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dfb() && s.d(this.lbl.getForumName(), true) && (runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
                lVar5.elL = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.elb.b(lVar5);
                }
            }
        }
        if (!this.lWI) {
            this.elb.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        }
        if (!this.lWI && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar4.elL = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar4);
            }
        }
        if (!this.lWI) {
            this.elb.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.lWI && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.elL = 7;
            this.elb.b(lVar3);
        }
        if (!this.lWI) {
            this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        } else {
            this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (!this.lWI && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.elN = true;
            lVar2.elL = 9;
            lVar2.elH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar2);
            }
        }
        if (!this.lWI && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.elN = true;
            lVar.elL = 10;
            lVar.elH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar);
            }
        }
        if (!this.lWI && this.lYJ == null) {
            if (this.lYY == null) {
                this.lYY = new com.baidu.tieba.write.editor.b(getActivity(), this.hOW);
                this.lYY.bK(this.lbl.getForumId(), this.privateThread);
                this.lYY.vv(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lYY.dni();
                this.lYY.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                doV();
            }
            if (!v.isEmpty(this.mList)) {
                this.lYY.dni();
            }
            this.elb.b(this.lYY);
        }
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nh = this.elb.nh(5);
        if (nh != null) {
            nh.elL = 1;
        }
    }

    private void dow() {
        if (this.lZa != null) {
            this.lZa.hideTip();
        }
    }

    private void dox() {
        if (this.lZa == null) {
            this.lZa = new e(getPageContext());
        }
        this.lZa.c(this.elb);
    }

    private void crq() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.doK()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").ag("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof q)) {
                            q qVar = (q) aVar.data;
                            if (qVar.aYd() == EmotionGroupType.BIG_EMOTION || qVar.aYd() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(qVar.getName());
                                    imageFileInfo.width = qVar.getWidth();
                                    imageFileInfo.height = qVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.vE(true);
                                    WriteActivity.this.dam();
                                }
                            } else if (WriteActivity.this.doK()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.doN();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cFA();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dpl();
                        WriteActivity.this.dam();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.FR(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").ag("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.lYJ == null) {
                            WriteActivity.this.bdC();
                            return;
                        }
                        switch (WriteActivity.this.emM) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bdz();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bdy();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.emG != null) {
                            WriteActivity.this.emG.uw(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jjn = null;
                        } else {
                            WriteActivity.this.jjn = (String) aVar.data;
                        }
                        WriteActivity.this.vD(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.lbl != null) {
                            str = WriteActivity.this.lbl.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.dh("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.lbl == null || (videoInfo = WriteActivity.this.lbl.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.elb.bcZ()) {
                                        WriteActivity.this.elb.bbA();
                                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.lbl.setVideoInfo(null);
                        WriteActivity.this.dam();
                        if (WriteActivity.this.lbH != null) {
                            WriteActivity.this.lbH.requestFocus();
                        }
                        WriteActivity.this.elb.bbA();
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lbH);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").ag("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.lYA = true;
                        WriteActivity.this.vB(true);
                        if (!WriteActivity.this.doM().isFocused() || WriteActivity.this.lYE.getVisibility() != 0) {
                            WriteActivity.this.lYz = "from_content";
                        } else {
                            WriteActivity.this.lYz = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.lYE.getVisibility() == 0) {
                            if (WriteActivity.this.lYE.hasFocus()) {
                                WriteActivity.this.lbH.requestFocus();
                                WriteActivity.this.lbH.setSelection(WriteActivity.this.lbH.getText().toString().length());
                            }
                            WriteActivity.this.lYE.setVisibility(8);
                            WriteActivity.this.elb.ne(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.lYE.setVisibility(0);
                            WriteActivity.this.lYE.requestFocus();
                            WriteActivity.this.elb.ne(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dam();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.elb.setActionListener(16, bVar);
        this.elb.setActionListener(14, bVar);
        this.elb.setActionListener(24, bVar);
        this.elb.setActionListener(3, bVar);
        this.elb.setActionListener(10, bVar);
        this.elb.setActionListener(11, bVar);
        this.elb.setActionListener(12, bVar);
        this.elb.setActionListener(13, bVar);
        this.elb.setActionListener(15, bVar);
        this.elb.setActionListener(18, bVar);
        this.elb.setActionListener(20, bVar);
        this.elb.setActionListener(25, bVar);
        this.elb.setActionListener(27, bVar);
        this.elb.setActionListener(29, bVar);
        this.elb.setActionListener(43, bVar);
        this.elb.setActionListener(56, bVar);
        this.elb.setActionListener(48, bVar);
        this.elb.setActionListener(46, bVar);
        this.elb.setActionListener(49, bVar);
        this.elb.setActionListener(47, bVar);
        this.elb.setActionListener(55, bVar);
        this.elb.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdC() {
        if (this.emG.bHo()) {
            if (this.emG.dew()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.der().getLocationData().dep());
                return;
            }
            a(1, true, (String) null);
            this.emG.deu();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dad() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lYF != null) {
            this.lYF.cancelLoadData();
        }
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dow();
        TiebaPrepareImageService.StopService();
        dad();
        dpd();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.lZy != null) {
            this.lZy.destroy();
        }
        if (this.lZX != null) {
            this.lZX.Gu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        if (this.lbl != null && this.lbl.getType() == 2 && this.lZu) {
            finish();
        } else if (this.lbl == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lbl.setTitle(doM().getText().toString());
            this.lbl.setContent(doL().getText().toString());
            int type = this.lbl.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.lWI) {
                        w.d(this.lbl.getForumId(), this.lbl);
                    } else {
                        w.c(this.lbl.getForumId(), this.lbl);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c("24591571", this.lbl);
                }
            } else if (type == 1) {
                w.e(this.lbl.getThreadId(), this.lbl);
            } else if (type == 4) {
                w.c(this.lbl.getForumId() + "photolive", this.lbl);
            } else if (type == 5) {
                w.e(this.lbl.getThreadId() + "updatephotolive", this.lbl);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lbK != null && this.lbK.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lbK, getPageContext().getPageActivity());
                return true;
            } else if (this.elb.bcZ()) {
                this.elb.bbA();
                return true;
            } else {
                dad();
                doy();
                return true;
            }
        }
        if (i == 67 && (text = doL().getText()) != null) {
            int selectionStart = doL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                doL().onKeyDown(67, this.gZC);
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
        getLayoutMode().onModeChanged(this.ita);
        getLayoutMode().onModeChanged(this.lZO);
        am.setBackgroundColor(this.ita, R.color.cp_bg_line_e);
        if (this.lZM != null && (i == 1 || i == 4)) {
            this.lZM.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.lbI, R.color.cp_link_tip_a, 1);
        dou();
        am.setBackgroundColor(this.lbE, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.lZD, R.color.cp_bg_line_c);
        am.setBackgroundColor(doM(), R.color.cp_bg_line_e);
        am.setImageResource(this.jNB, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jjn)) {
            am.setBackgroundColor(doL(), R.color.cp_bg_line_e);
        }
        dam();
        this.elb.onChangeSkinType(i);
        if (this.lYS != null) {
            this.lYS.aWr();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lZy.maw.notifyDataSetChanged();
        doz();
        doA();
        vD(false);
        if (this.lYZ != null) {
            this.lYZ.c(doM(), doL());
        }
        if (this.lXd != null) {
            this.lXd.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doz() {
        if (this.lbD.hasFocus()) {
            this.lbD.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lbD.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.lbH.hasFocus()) {
            this.lbH.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lbH.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doA() {
        if (this.lbD != null && this.lbD.getText() != null && this.lbD.getText().toString() != null && this.lbD.getPaint() != null) {
            if (this.lbD.getText().toString().length() == 0) {
                this.lbD.getPaint().setFakeBoldText(false);
            } else if (this.lbD.getText().toString().length() > 0) {
                this.lbD.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.euw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lYU = this.lbl.getType() == 4 || 5 == this.lbl.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lZs = (TextView) findViewById(R.id.btn_image_problem);
        doD();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lbI.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lbI.setLayoutParams(layoutParams);
        this.lbI.setOnFocusChangeListener(this.fPo);
        this.lYT = (ScrollView) findViewById(R.id.write_scrollview);
        this.lYT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.lbH != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.lbH);
                    }
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbA();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lZq = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.lZr = findViewById(R.id.feedback_divider);
        this.ita = (RelativeLayout) findViewById(R.id.parent);
        this.lYD = (LinearLayout) findViewById(R.id.tool_view);
        this.lYD.setContentDescription(IStringUtil.TOP_PATH);
        this.lYE = (LinearLayout) findViewById(R.id.title_view);
        this.lbE = findViewById(R.id.interval_view);
        this.lZT = findViewById(R.id.hot_topic_fourm_view);
        this.lZU = findViewById(R.id.hot_topic_divider);
        this.lYW = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.lZV = (TextView) findViewById(R.id.change_one_tv);
        dal();
        if (this.lYU) {
            this.lYT.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            doW();
        } else {
            this.lZy = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lZy.vt(false);
            } else {
                g gVar = this.lZy;
                if (this.lbl.getType() != 0 && this.lbl.getType() != 9) {
                    z = false;
                }
                gVar.vt(z);
            }
        }
        dan();
        if (this.lZm || this.lYC) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dOB) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.lbG = (LinearLayout) findViewById(R.id.post_content_container);
        this.lbG.setDrawingCacheEnabled(false);
        this.lbG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.lbH.requestFocus();
            }
        });
        this.jNy = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jNz = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jNB = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jNB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cFA();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fPo);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dad();
                WriteActivity.this.doy();
            }
        });
        this.lZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        doG();
        o(dpe());
        doI();
        doC();
        dpb();
        dpc();
        dou();
        doH();
        dak();
        doO();
        if (this.lbl.getType() == 4 && this.lbM != null && this.lYG != null) {
            this.lbM.setVisibility(8);
            this.lYG.setVisibility(8);
        }
        dam();
        doZ();
        dnM();
        doB();
    }

    private void doB() {
        this.lXd = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lXd.setData(this.lSC);
        this.lXd.setActivity(this);
    }

    private void dnM() {
        if (this.mName != null && this.lbl != null && this.lbl.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void doC() {
        String str;
        String str2;
        if (this.lbl != null) {
            switch (this.lbl.getType()) {
                case 0:
                case 9:
                    if (this.lZm || this.lYC) {
                        if (this.lZo) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.hOW != null && this.hOW.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.lWI) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.hOW != null && this.hOW.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lbl.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lbl.getForumName() + getResources().getString(R.string.bar));
                        this.lbD.setVisibility(8);
                        String str3 = this.hlz + " " + this.hlx;
                        if (!StringUtils.isNull(str3)) {
                            this.lbH.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lbD.setVisibility(0);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lbD.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lbl.getFloorNum() + 1)));
                    this.lZD.setVisibility(8);
                    return;
                case 7:
                    this.lbD.setVisibility(0);
                    this.lbH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void doD() {
        if (this.lbl.getType() == 7) {
            this.lbI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lbI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void doE() {
        if (this.lbl != null && this.lbl.getType() == 0 && this.lbl.getType() == 9 && !this.lZm && !this.lYC && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && doM() != null) {
                doM().setText(cutStringWithSuffix);
                doM().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.jNy.setVisibility(0);
            this.jNz.setVoiceModel(voiceModel);
            this.jNz.dfa();
            dam();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFA() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.wY(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.jNy.setVisibility(8);
        this.jNz.cfI();
        this.jNz.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nh = this.elb.nh(6);
        if (nh != null && nh.ekV != null) {
            nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dam();
    }

    private void doF() {
        this.fnD = null;
        this.lYP = -1;
        this.lYR = -1;
        ac uf = com.baidu.tieba.frs.ab.bWN().uf(1);
        if (uf != null) {
            this.fnD = uf.hri;
            this.lYP = getIntent().getIntExtra("category_id", -1);
            if (this.fnD != null && !this.fnD.isEmpty() && this.lYP >= 0) {
                this.lYO = new aa();
                this.lYO.hre = 0;
                this.lYO.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lYR = this.lYO.hre;
                this.lYQ = this.lYO.name;
                for (aa aaVar : this.fnD) {
                    if (aaVar.hre == this.lYP) {
                        this.lYR = aaVar.hre;
                        this.lYQ = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void doG() {
        if (this.fnD != null && !this.fnD.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lYS = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lYS.setText(this.lYQ);
            this.lYS.setCategoryContainerData(this.fnD, this.lYO, this.lYR);
            this.lYS.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        WriteActivity.this.lYS.setText(axVar.name);
                        WriteActivity.this.lbl.setCategoryTo(axVar.hre);
                        WriteActivity.this.lYR = axVar.hre;
                        WriteActivity.this.lYS.doh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.lYS.dog();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doL());
                }
            });
        }
    }

    private void doZ() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lZh = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lZh.setTitle(R.string.no_disturb_start_time);
        this.lZh.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lZh);
        this.lZh.setButton(-2, getPageContext().getString(R.string.cancel), this.lZh);
        return this.lZh;
    }

    private void doH() {
        this.lYK = (RelativeLayout) findViewById(R.id.addition_container);
        this.lYL = (TextView) findViewById(R.id.addition_create_time);
        this.lYM = (TextView) findViewById(R.id.addition_last_time);
        this.lYN = (TextView) findViewById(R.id.addition_last_content);
        if (this.lYJ != null) {
            this.lYK.setVisibility(0);
            this.lYL.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lYJ.getCreateTime() * 1000));
            if (this.lYJ.getAlreadyCount() == 0) {
                this.lYM.setVisibility(8);
            } else {
                this.lYM.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lYJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lYJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lYN.setText(lastAdditionContent);
            } else {
                this.lYN.setVisibility(8);
            }
            doL().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lYJ.getAlreadyCount()), Integer.valueOf(this.lYJ.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lYK.setVisibility(8);
    }

    private void dak() {
        this.lbM = findViewById(R.id.post_prefix_layout);
        if (this.lZX == null) {
            this.lZX = new com.baidu.tieba.c.d(getPageContext(), this.lbM);
            this.lZX.cI(R.drawable.bg_tip_blue_up_left);
            this.lZX.cH(16);
            this.lZX.ma(true);
            this.lZX.setUseDirectOffset(true);
            this.lZX.sz(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lbJ = (TextView) findViewById(R.id.post_prefix);
        this.lYG = findViewById(R.id.prefix_divider);
        this.lbL = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lbM.setVisibility(0);
            this.lZX.f(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lbm = 0;
            this.lbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").dh("fid", WriteActivity.this.lbl.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lbJ.setVisibility(0);
                    WriteActivity.this.lbM.setSelected(true);
                    am.setImageResource(WriteActivity.this.lbL, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lbK, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.elb.bbA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lbD);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lbH);
                }
            });
            this.lbJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").dh("fid", WriteActivity.this.lbl.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lbJ.setSelected(true);
                    am.setImageResource(WriteActivity.this.lbL, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lbK, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.elb.bbA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doL());
                }
            });
            this.lbK = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lbK.a(this);
            this.lbK.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lbK.setOutsideTouchable(true);
            this.lbK.setFocusable(true);
            this.lbK.setOnDismissListener(this);
            this.lbK.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.lbJ, R.color.cp_bg_line_d);
            am.setImageResource(this.lbL, R.drawable.icon_arrow_gray_down);
            this.lbJ.setTextColor(color);
            this.lYH.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lYH.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vq(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vq(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lbK.addView(writePrefixItemLayout);
            }
            this.lbK.setCurrentIndex(0);
            this.lbJ.setText(prefixs.get(0));
            FP(0);
            return;
        }
        this.lbM.setVisibility(8);
    }

    private void dpa() {
        if (this.lZm && this.lbl != null) {
            this.lZq.setVisibility(0);
            this.lZr.setVisibility(0);
            this.lYF = new FeedBackModel(getPageContext());
            this.lYF.OA(this.lbl.getForumName());
            this.lYF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.lZq.setVisibility(8);
                        WriteActivity.this.lZr.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.lZq.setVisibility(8);
                        WriteActivity.this.lZr.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.lZq.a(feedBackModel.doj(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void doI() {
        this.lbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.lYZ.a(WriteActivity.this.lbD, WriteActivity.this.lbH)) {
                        WriteActivity.this.showToast(WriteActivity.this.lYZ.dmz());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.doL());
                    WriteActivity.this.elb.bbA();
                    if (WriteActivity.this.lbl.getType() != 7) {
                        if (WriteActivity.this.lZm) {
                            WriteActivity.this.bYH();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.ag("obj_type", StringUtils.isNull(WriteActivity.this.lbl.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.doR();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bYH();
                    }
                    MercatorModel.deJ().startLoad();
                    TiebaStatic.log(new an("c12262").dh("obj_locate", WriteActivity.this.hOW));
                }
            }
        });
    }

    protected void dpb() {
        this.lZt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.lZt.vO(getPageContext().getString(R.string.is_save_draft)).gW(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.lbl.setTitle(WriteActivity.this.doM().getText().toString());
                WriteActivity.this.lbl.setContent(WriteActivity.this.doL().getText().toString());
                int type = WriteActivity.this.lbl.getType();
                if (type == 0 || type == 9) {
                    if (WriteActivity.this.lWI) {
                        w.d(WriteActivity.this.lbl.getForumId(), WriteActivity.this.lbl);
                    } else {
                        w.c(WriteActivity.this.lbl.getForumId(), WriteActivity.this.lbl);
                    }
                } else if (type == 1) {
                    w.e(WriteActivity.this.lbl.getThreadId(), WriteActivity.this.lbl);
                }
                WriteActivity.this.showToast(R.string.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(R.string.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.lbl.getType();
                if (type == 0 || type == 9) {
                    if (WriteActivity.this.lWI) {
                        w.d(WriteActivity.this.lbl.getForumId(), (WriteData) null);
                    } else {
                        w.c(WriteActivity.this.lbl.getForumId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    w.e(WriteActivity.this.lbl.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.lZt.b(getPageContext());
    }

    protected void dal() {
        this.lZp = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.lZp.setIsRound(true);
        this.lZp.setDrawBorder(false);
        this.lZp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String wj = o.wj(currentPortrait);
            this.lZp.setUrl(wj);
            this.lZp.startLoad(wj, 12, false);
        }
        if (this.lbl.isUserFeedback()) {
            this.lZp.setVisibility(0);
        }
        this.lbD = (EditText) findViewById(R.id.post_title);
        this.lbD.setOnClickListener(this.lZd);
        this.lbD.setOnFocusChangeListener(this.fPo);
        if (this.lbl.getType() == 0 || this.lbl.getType() == 9 || this.lbl.getType() == 7) {
            if (this.lbl.getTitle() != null) {
                this.lbD.setText(this.lbl.getTitle());
                this.lbD.setSelection(this.lbl.getTitle().length());
            } else if (this.lZo) {
                this.lbD.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lbl.getType() == 1 || this.lbl.getType() != 2) {
        }
        this.lbD.addTextChangedListener(this.lZf);
        if (!this.lbl.getHaveDraft()) {
            doE();
            this.lZS = true;
        }
        if (this.lbl.isUserFeedback()) {
            this.lbD.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lbD.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher aeH() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int mab;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dam();
                if (WriteActivity.this.lYU) {
                    this.mab = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.mab);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.lYU || !WriteActivity.this.lZK) {
                    if (WriteActivity.this.lYU) {
                        if (this.mEditText != WriteActivity.this.lZB || this.mTextView != WriteActivity.this.lZH) {
                            this.mEditText = WriteActivity.this.lZB;
                            this.mTextView = WriteActivity.this.lZH;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.lZF || this.mTextView != WriteActivity.this.lZG) {
                    this.mEditText = WriteActivity.this.lZF;
                    this.mTextView = WriteActivity.this.lZG;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.lYU && this.lZK) {
            if (this.lZI != null) {
                this.lZF.removeTextChangedListener(this.lZI);
            }
            this.lZI = textWatcher;
        } else if (this.lYU) {
            if (this.lZJ != null) {
                this.lZB.removeTextChangedListener(this.lZJ);
            }
            this.lZJ = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.lZB) {
            return 233L;
        }
        if (editText != this.lZF) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long k = j - k(editText);
            String valueOf = String.valueOf(k);
            if (j == 20) {
                if (k < 0) {
                    if (k < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.q(editText.getText().toString().trim());
    }

    protected void dan() {
        this.lbH = (EditText) findViewById(R.id.post_content);
        this.lbH.setDrawingCacheEnabled(false);
        this.lbH.setOnClickListener(this.lZd);
        if (this.lbl.getContent() != null && this.lbl.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bet().ak(getPageContext().getPageActivity(), this.lbl.getContent());
            this.lbH.setText(ak);
            this.lbH.setSelection(ak.length());
        } else if (this.lbl.getType() == 2) {
            if (this.lZu) {
                if (this.lZv != null && this.lZv.length() > 0) {
                    this.lbH.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.lZv}));
                    this.lbH.setSelection(this.lbH.getText().length());
                }
            } else if (this.lbl.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lbl.getFloorNum()));
                this.lbH.setText(format);
                this.lbH.setSelection(format.length());
            }
        }
        this.lbH.setOnFocusChangeListener(this.fPo);
        this.lbH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.lbH.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lbH.addTextChangedListener(this.lZg);
        if (this.lbl.getType() == 0) {
            this.lZW = true;
        } else {
            vD(true);
            this.lZW = false;
        }
        if (this.lbl.isUserFeedback()) {
            this.lbH.setHint(R.string.write_input_content);
        } else {
            this.lbH.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void vD(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.lYU && !this.lWI) {
            doL().setPadding(0, 0, 0, 0);
            doL().setBackgroundDrawable(null);
            am.setBackgroundColor(doL(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.jjn) && this.lYJ == null) {
                com.baidu.adp.lib.e.c.kX().a(this.jjn, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.doL().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.doL(), true, WriteActivity.this.jTX);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doK() {
        int i = 5000;
        if (this.lYJ != null) {
            i = 1000;
        }
        return doL().getText() != null && doL().getText().length() >= i;
    }

    private void ye(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lYz)) {
                this.lYz = "";
                doL().requestFocus();
                if (doL().getText() != null && doL().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = doL().getSelectionStart();
                    editable = doL().getText();
                }
            } else if ("from_title".equals(this.lYz)) {
                this.lYz = "";
                doM().requestFocus();
                if (doM().getText() != null && doM().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = doM().getSelectionStart();
                    editable = doM().getText();
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
    public void vB(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lbl != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lbl.getForumId(), 0L), this.lbl.getFirstDir(), this.lbl.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) doL().getText().getSpans(0, doL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lYI == null) {
                this.lYI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.lYI.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aYd = qVar.aYd();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kX().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.doL().getSelectionStart(), aVar, aYd);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && doL() != null && doL().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = doL().getSelectionStart() - 1;
                if (doL().getText().length() > 1 && selectionStart >= 0 && doL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    doL().getText().insert(doL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            doL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                doL().getText().insert(doL().getSelectionStart(), spannableString2);
            }
            Editable text = doL().getText();
            if (text != null) {
                this.lYX.clear();
                this.lYX.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lYX);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && doL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    doL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                doL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText doL() {
        return this.lYU ? this.lZB : this.lbH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText doM() {
        return this.lYU ? this.lZF : this.lbD;
    }

    protected void doN() {
        Editable text;
        if (doL() != null && (text = doL().getText()) != null) {
            int selectionStart = doL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                doL().onKeyDown(67, this.gZC);
            }
            doL().onKeyDown(67, this.gZC);
            int selectionStart2 = doL().getSelectionStart();
            if (text != null) {
                this.lYX.clear();
                this.lYX.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lYX);
                doL().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.lbl != null) {
            str = this.lbl.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.lZm = true;
        }
    }

    private void dpc() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dpd() {
        try {
            if (this.lZt != null) {
                this.lZt.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }

    private Boolean dpe() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.emL = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void dam() {
        if (this.lbl != null) {
            String str = "";
            String str2 = "";
            if (doM() != null) {
                str = doM().getText().toString();
            }
            if (doL() != null) {
                str2 = doL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lbl.getType() == 0 || this.lbl.getType() == 9 || this.lbl.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.lbm == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lbl.setIsNoTitle(true);
                        } else if (this.lYE.getVisibility() == 0) {
                            this.lbl.setIsNoTitle(false);
                            vC(true);
                            return;
                        }
                    } else if (this.lYE.getVisibility() == 0) {
                        this.lbl.setIsNoTitle(false);
                        vC(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lbl.setIsNoTitle(true);
                } else if (this.lYE.getVisibility() == 0) {
                    this.lbl.setIsNoTitle(false);
                    vC(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lYU) {
                    vC(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vC(true);
                }
            }
            if (this.lbl.getType() == 4) {
                vC(m(this.lZB) && l(this.lZF));
            } else if (this.lbl.getType() == 5) {
                vC(m(this.lZB));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                vC(true);
            } else if (this.lbl.getVideoInfo() != null) {
                vC(true);
            } else {
                vC(false);
            }
        }
    }

    public void vC(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.lbI, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.lbI.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.lbI, R.color.cp_cont_d, 1);
        this.lbI.setEnabled(false);
    }

    private boolean l(EditText editText) {
        long k = k(editText);
        return k <= 20 && k > 0;
    }

    private boolean m(EditText editText) {
        long k = k(editText);
        if (k > 233) {
            return false;
        }
        return k > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String str;
        this.emH = new NewWriteModel(this);
        this.emH.b(this.emV);
        registerListener(this.lZY);
        this.hes = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dad();
            }
        };
        this.lbl = new WriteData();
        if (bundle != null) {
            this.lbl.setType(bundle.getInt("type", 0));
            this.lbl.setForumId(bundle.getString("forum_id"));
            this.lbl.setForumName(bundle.getString("forum_name"));
            this.lbl.setFirstDir(bundle.getString("forum_first_dir"));
            this.lbl.setSecondDir(bundle.getString("forum_second_dir"));
            this.lbl.setThreadId(bundle.getString("thread_id"));
            this.lbl.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lbl.setFloorNum(bundle.getInt("floor_num", 0));
            this.lZm = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.lZn = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.lZo = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lZu = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lZv = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.emF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lYJ = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lbl.setIsAddition(this.lYJ != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.lZw = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lbl.setTitle(bundle.getString("write_title"));
            this.lbl.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lbl.setTopicId(this.mTopicId);
            this.hOW = bundle.getString("KEY_CALL_FROM");
            this.bdm = bundle.getInt("album_thread");
            this.lSC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.lbl.setType(intent.getIntExtra("type", 0));
            this.lbl.setForumId(intent.getStringExtra("forum_id"));
            this.lbl.setForumName(intent.getStringExtra("forum_name"));
            this.lbl.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lbl.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lbl.setThreadId(intent.getStringExtra("thread_id"));
            this.lbl.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lbl.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.lZm = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.lZn = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.lZo = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lZu = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lZv = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.lYJ = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lbl.setIsAddition(this.lYJ != null);
            this.lbl.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.lZw = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hly = intent.getStringExtra("more_forum_img");
            this.hlz = intent.getStringExtra("more_forum_title");
            this.hlx = intent.getStringExtra("more_forum_url");
            this.lbl.setTitle(intent.getStringExtra("write_title"));
            this.lbl.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lbl.setTopicId(this.mTopicId);
            this.hOW = intent.getStringExtra("KEY_CALL_FROM");
            this.bdm = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.lSC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lbl.mDynamicImageTextData = new ImageTextUploadData();
            this.lWI = true;
        }
        if (this.lbl.getType() == 9) {
            this.lbl.setEntranceType(1);
        } else if (this.lbl.getType() == 10) {
            this.lbl.setEntranceType(2);
            this.lbl.setType(9);
        } else if (this.lbl.getType() == 0) {
            this.lbl.setEntranceType(3);
        }
        this.lbl.setIsUserFeedback(this.lZm);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lbl.getType() == 4 ? 6 : 9);
        this.lbl.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lbl.getType() == 0 || this.lbl.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.lWI) {
                    w.d(this.lbl.getForumId(), this);
                } else {
                    w.c(this.lbl.getForumId(), this);
                }
            }
        } else if (this.lbl.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.lbl.getType() == 1) {
            w.a(this.lbl.getThreadId(), this);
        } else if (this.lbl.getType() == 4) {
            w.c(this.lbl.getForumId() + "photolive", this);
        } else if (this.lbl.getType() == 5) {
            w.a(this.lbl.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jjn = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lbl != null && this.lbl.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lbl.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lYC = true;
        }
        doF();
        try {
            this.lZL = dpn();
        } catch (Throwable th) {
            this.lZL = null;
        }
    }

    private void doO() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lbD.setText(com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName)));
            this.lbD.setMovementMethod(com.baidu.tieba.view.c.dmf());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString yI = com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName));
            if (yI != null) {
                this.lbD.setText(yI);
            }
            this.lYW.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        String str;
        String yJ;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.lbl != null) {
                    this.lbl.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(doM().getText().toString()) || this.lZS || ((this.lZm || this.lYC) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.lbl.getTitle())) {
                            this.lbl.setTitle(writeData.getTitle());
                        }
                        if (!v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                yJ = this.lbl.getTitle();
                            } else {
                                yJ = com.baidu.tbadk.plugins.b.yJ(str);
                            }
                            SpannableString yI = com.baidu.tbadk.plugins.b.yI(yJ);
                            if (yI != null) {
                                doM().setText(yI);
                                doM().setSelection(yI.length() > yJ.length() ? yJ.length() : yI.length());
                            }
                        } else {
                            SpannableString yI2 = com.baidu.tbadk.plugins.b.yI(this.lbl.getTitle());
                            if (yI2 != null) {
                                doM().setText(yI2);
                                doM().setSelection(this.lbl.getTitle().length() > yI2.length() ? yI2.length() : this.lbl.getTitle().length());
                            }
                        }
                    }
                    if (this.lbl != null && !this.lbl.getHaveDraft()) {
                        doE();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.lbl.setVideoInfo(videoInfo);
                        this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(doL().getText().toString()) || this.lZm || this.lYC) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.lbl.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.bet().a(getPageContext().getPageActivity(), this.lbl.getContent(), this.lZb);
                        doL().setText(a2);
                        doL().setSelection(a2.length());
                        if (this.lYU) {
                            a(this.lZH, this.lZB);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.lbl.setWriteImagesInfo(this.writeImagesInfo);
                        dpl();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            doT();
                        }
                        vE(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dpf();
                    }
                    dam();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.fnD != null) {
                        this.lYR = this.lYO.hre;
                        this.lYQ = this.lYO.name;
                        int i = 0;
                        while (true) {
                            if (i == this.fnD.size()) {
                                break;
                            }
                            aa aaVar = this.fnD.get(i);
                            if (categoryTo != aaVar.hre) {
                                i++;
                            } else {
                                this.lYR = categoryTo;
                                this.lYQ = aaVar.name;
                                this.lbl.setCategoryTo(this.lYR);
                                break;
                            }
                        }
                        if (this.lYS != null) {
                            this.lYS.setText(this.lYQ);
                            this.lYS.setCategoryContainerData(this.fnD, this.lYO, this.lYR);
                        }
                    }
                    this.elb.bbA();
                    return;
                }
                return;
            }
            dpf();
            doE();
        }
    }

    private void dpf() {
        if ((!this.lYU || this.lZA != null) && this.lZz != null) {
            this.lZA.b(this.writeImagesInfo);
            dpj();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lbl.getType());
        bundle.putString("forum_id", this.lbl.getForumId());
        bundle.putString("forum_name", this.lbl.getForumName());
        bundle.putString("forum_first_dir", this.lbl.getFirstDir());
        bundle.putString("forum_second_dir", this.lbl.getSecondDir());
        bundle.putString("thread_id", this.lbl.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lbl.getFloor());
        bundle.putInt("floor_num", this.lbl.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.lZu);
        if (this.lZm) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.emF);
        if (this.lYJ != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lYJ));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.lZw);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOW);
        bundle.putInt("album_thread", this.bdm);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.lSC);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = doL().getEditableText().toString();
        if (obj != null) {
            doL().setText(TbFaceManager.bet().a(getPageContext().getPageActivity(), obj, this.lZb));
            doL().setSelection(doL().getText().length());
        }
    }

    private String doP() {
        return (doL() == null || doL().getText() == null) ? "" : doL().getText().toString();
    }

    private String doQ() {
        if (this.lbl == null || doM() == null || doM().getVisibility() != 0 || doM().getText() == null) {
            return "";
        }
        String obj = doM().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lbm != v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lbl.getType() != 4 && this.lbJ != null && this.lbJ.getText() != null) {
            this.lbl.setPostPrefix(this.lbJ.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lbl.getTitle();
        }
        return obj;
    }

    private void OB(String str) {
        if (this.lbl != null && this.lYE != null) {
            if (this.lYE.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lbl.setIsNoTitle(true);
                    this.lbl.setTitle("");
                    return;
                }
                this.lbl.setIsNoTitle(false);
                this.lbl.setTitle(str);
                return;
            }
            this.lbl.setIsNoTitle(true);
            this.lbl.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYH() {
        dad();
        this.lbl.setContent(doP());
        OB(doQ());
        if (this.lZm || this.lYC) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lbl.getTitle()) || !this.lbl.getTitle().startsWith(string)) {
                OB(string + this.lbl.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lbl.getContent()) || !this.lbl.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    sb.append(com.baidu.adp.lib.util.j.netTypeNameInUpperCase());
                } else {
                    sb.append(RomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.lbl.getContent());
                this.lbl.setContent(sb.toString());
            }
        }
        if (this.lZn) {
            this.lbl.setContent(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE) + "\n" + this.lbl.getContent());
        }
        if (this.lYP >= 0) {
            this.lbl.setCategoryFrom(this.lYP);
        }
        if (this.lYR >= 0) {
            this.lbl.setCategoryTo(this.lYR);
        }
        this.lbl.setWriteImagesInfo(this.writeImagesInfo);
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
            this.lbl.setTakePhotoNum(i);
        }
        this.lbl.setHasLocationData(this.emG != null && this.emG.bHo());
        if (this.writeImagesInfo != null) {
            this.emH.uy(this.writeImagesInfo.size() > 0);
        }
        if (!v.isEmpty(this.mList) && this.lYV != null && this.lYV.mIsGlobalBlock == 0) {
            this.lbl.setForumId(String.valueOf(this.lYV.mForumId));
            this.lbl.setForumName(this.lYV.mForumName);
        }
        dnP();
        this.emH.d(this.lbl);
        this.lbl.setContent(this.lbl.getContent().replaceAll("\u0000\n", ""));
        this.lbl.setContent(this.lbl.getContent().replaceAll("\u0000", ""));
        this.lbl.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.emH.daf().setVoice(this.mVoiceModel.getId());
                this.emH.daf().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.emH.daf().setVoice(null);
                this.emH.daf().setVoiceDuringTime(-1);
            }
        } else {
            this.emH.daf().setVoice(null);
            this.emH.daf().setVoiceDuringTime(-1);
        }
        if (!this.emH.dff()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lbl.mDynamicImageTextData != null) {
            dnO();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hes);
            this.emH.dfc();
        }
    }

    private void dnP() {
        FrsTabItemData selectedTabItemData;
        if (this.lbl != null && this.lXd != null && (selectedTabItemData = this.lXd.getSelectedTabItemData()) != null) {
            this.lbl.setTabId(selectedTabItemData.tabId);
            this.lbl.setTabName(selectedTabItemData.name);
            this.lbl.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dnO() {
        if (this.lbl.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lbl, new a.InterfaceC0749a() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // com.baidu.tieba.write.b.a.InterfaceC0749a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dnA().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.33.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            w.d(WriteActivity.this.lbl.getForumId(), (WriteData) null);
                            com.baidu.tieba.write.b.a.dnq();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.f(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.ie(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dnq();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0749a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void C(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.lYJ != null) {
                i2 = this.lYJ.getTotalCount();
                i = this.lYJ.getAlreadyCount() + 1;
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
                if (this.lbD == getCurrentFocus()) {
                    doL().clearFocus();
                    this.lbD.requestFocus();
                    if (this.elb != null) {
                        this.elb.bbA();
                    }
                    ShowSoftKeyPadDelay(this.lbD);
                } else {
                    doL().requestFocus();
                    if (this.elb != null) {
                        this.elb.bbA();
                    }
                    ShowSoftKeyPadDelay(this.lbH);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append(UgcConstant.AT_RULE_TAG);
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            doL().getText().insert(doL().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.lbl.getType() == 0 || this.lbl.getType() == 9) {
                    if (this.lWI) {
                        w.d(this.lbl.getForumId(), (WriteData) null);
                    } else {
                        w.c(this.lbl.getForumId(), (WriteData) null);
                    }
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.lbl.getType() == 1) {
                    w.e(this.lbl.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                dpk();
                            } else {
                                ao(intent);
                            }
                        } else if (intExtra == 1) {
                            ap(intent);
                        } else {
                            am(intent);
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.lZW) {
                            vD(true);
                            this.lZW = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.lYU) {
                        D(intent);
                        dam();
                        return;
                    }
                    an(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lbl.setVideoInfo(videoInfo);
                        this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.elb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dam();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.lYA) {
                                sb2.append(com.baidu.tbadk.plugins.b.euc);
                                this.lYA = false;
                            }
                            sb2.append(stringExtra);
                            ye(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.lYV = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.lYV);
                }
            }
        } else if (i2 == 0) {
            if (this.elb != null && !this.elb.bcZ()) {
                this.lbH.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.elb.bbA();
            }
            switch (i) {
                case 12001:
                    bdF();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dpi();
                    if (this.lZW) {
                        vD(true);
                        this.lZW = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lbD == getCurrentFocus()) {
                        doL().clearFocus();
                        this.lbD.requestFocus();
                        if (this.elb != null) {
                            this.elb.bbA();
                        }
                        ShowSoftKeyPadDelay(this.lbD);
                        return;
                    }
                    doL().requestFocus();
                    if (this.elb != null) {
                        this.elb.bbA();
                    }
                    ShowSoftKeyPadDelay(this.lbH);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.lYZ.Og(postWriteCallBackData.getErrorString());
                        this.lYZ.aX(postWriteCallBackData.getSensitiveWords());
                        this.lYZ.b(this.lbD, this.lbH);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.emF = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.emF);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dpi();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lYz)) {
                        doM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lYz)) {
                        doL().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doR() {
        if ("1".equals(this.hOW)) {
            this.lbl.setCanNoForum(true);
            this.lbl.setTransmitForumData("[]");
        } else if ("2".equals(this.hOW)) {
            this.lbl.setCanNoForum(false);
        }
        doS();
        this.lbl.setPrivacy(this.isPrivacy);
        dpg();
        this.lbl.setToDynamic(this.isToDynamic);
        this.lbl.setCallFrom(this.hOW);
        if (this.lbl.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bYH();
    }

    private void doS() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dpg() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dph() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dpi() {
        if (this.lYU) {
            this.lZA.b(this.writeImagesInfo);
            dpj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpj() {
        this.lZA.notifyDataSetChanged();
        this.lZz.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.lZA.notifyDataSetChanged();
                WriteActivity.this.lZz.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        dam();
    }

    private void am(Intent intent) {
        if (this.lYU) {
            an(intent);
            dpi();
        } else {
            aq(intent);
        }
        dam();
    }

    private void an(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dpi();
            vE(true);
        }
    }

    private void ao(Intent intent) {
        if (this.writeImagesInfo != null) {
            C(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dpk() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ap(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.lZx.parseJson(stringExtra);
            this.lZx.updateQuality();
            if (this.lZx.getChosedFiles() != null && this.lZx.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.lZx.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.lZx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, doM());
        HidenSoftKeyPad(this.mInputManager, doL());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aq(Intent intent) {
        c(intent, true);
    }

    private void C(Intent intent) {
        this.emF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.emF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.emF, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dpl();
            doT();
        }
        vE(true);
    }

    private void D(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dpl();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    doT();
                }
            }
            vE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpl() {
        if (this.elb.nh(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void bdF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.emF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dpm() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hly)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.hly, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                    @Override // com.baidu.tbadk.util.o.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.o.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.vE(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE(boolean z) {
        String forumId = this.lbl == null ? "" : this.lbl.getForumId();
        if (this.lZy != null) {
            this.lZy.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bVp() {
        this.hns = getVoiceManager();
        this.hns.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hoB) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lbl.getType() != 7) {
                if (this.lYJ == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                C(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void doT() {
        if (!this.lYU) {
            if (this.elb != null) {
                this.elb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.elb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lbl == null ? "" : this.lbl.getForumId();
            if (this.lZy != null) {
                this.lZy.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void FP(int i) {
        if (i < this.lYH.size()) {
            for (int i2 = 0; i2 < this.lYH.size(); i2++) {
                this.lYH.get(i2).vr(false);
            }
            this.lYH.get(i).vr(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Dx(int i) {
        if (i == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").ag("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").ag("obj_type", 2));
        }
        this.lbm = i;
        this.lbK.setCurrentIndex(i);
        FP(i);
        this.lbJ.setText(this.mPrefixData.getPrefixs().get(i));
        dam();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lbK, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lbM.setSelected(false);
        am.setImageResource(this.lbL, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.lbH);
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
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.lbl != null) {
            if (this.lbl.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lbl.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            bdz();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = com.baidu.tbadk.core.util.ab.transformPermissionResult(strArr, iArr);
            if (com.baidu.tbadk.core.util.ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.emF);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aUD = z;
        if (this.lZQ && System.currentTimeMillis() - this.lZR < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.lZQ = false;
        }
        if (this.lYY != null && !z) {
            this.lYY.bPh();
        }
        if (this.lZa != null && !z) {
            dow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.lZN != null) {
            OD(str);
            this.lZN.dismiss();
        }
    }

    private void fy(Context context) {
        lZP = l.getEquipmentHeight(context);
    }

    private void OD(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.lZQ = true;
        dpl();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            doT();
        }
        vE(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4613=4] */
    private static Bitmap g(String str, float f) {
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

    private File dpn() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
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

    private void dpo() {
        if (this.lZL != null && this.lbl.getType() == 0 && this.lbl.getType() == 9) {
            fy(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.lZL != null) {
                        WriteActivity.this.OC(WriteActivity.this.lZL.getAbsolutePath());
                    }
                }
            });
            this.lZM = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.lZO = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.lZL.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.lZL.getAbsolutePath());
                Bitmap g = g(this.lZL.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.lZM.setImageBitmap(g);
                    this.lZM.setDrawBorder(true);
                    this.lZM.setBorderWidth(2);
                    this.lZM.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.lZN = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.lZN.setCanceledOnTouchOutside(true);
                    this.lZN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.lZQ) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.lZR = System.currentTimeMillis();
                            }
                        }
                    });
                    this.lZN.setContentView(this.mBubbleView);
                    this.lZN.show();
                    Window window = this.lZN.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (lZP / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aUD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.lYA = false;
            this.lYz = "";
            if ("from_content".equals(str)) {
                this.lYz = "from_content";
            } else if ("from_title".equals(str)) {
                this.lYz = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.yH(String.valueOf(charSequence.charAt(i)))) {
                vB(false);
            }
        }
    }

    public void cVm() {
        if (this.lZm || !v.isEmpty(this.mList) || !StringUtils.isNull(this.lbl.getTitle())) {
            this.lYE.setVisibility(0);
            this.lYE.requestFocus();
            return;
        }
        this.lYE.setVisibility(8);
    }
}
