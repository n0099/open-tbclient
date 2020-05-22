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
import com.baidu.tbadk.core.util.ab;
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
    private static int lYE = 0;
    private EditorTools elb;
    private String emF;
    private LocationModel emG;
    private NewWriteModel emH;
    List<aa> fns;
    private String hlm;
    private String hln;
    private String hlo;
    private VoiceManager hnh;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout jMs;
    private PlayVoiceBntNew jMt;
    private ImageView jMv;
    private FrsTabInfoData lRr;
    private ForumTabSelectedView lVS;
    private TextView lXA;
    private TextView lXB;
    private TextView lXC;
    aa lXD;
    private int lXE;
    private String lXF;
    private int lXG;
    private PostCategoryView lXH;
    private HotTopicBussinessData lXK;
    private TextView lXL;
    private com.baidu.tieba.write.editor.b lXN;
    private e lXP;
    private com.baidu.tieba.view.b lXW;
    private LinearLayout lXs;
    private LinearLayout lXt;
    private View lXv;
    private Toast lXx;
    private AdditionData lXy;
    private RelativeLayout lXz;
    private View lYI;
    private View lYJ;
    private TextView lYK;
    private com.baidu.tieba.c.d lYM;
    private View lYg;
    private g lYn;
    private TextView laA;
    private com.baidu.tieba.write.i laB;
    private ImageView laC;
    private View laD;
    private int lac;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String lXo = "";
    private boolean lXp = false;
    private WriteData lab = null;
    private boolean lYb = false;
    private boolean lYc = false;
    private boolean lXr = false;
    private boolean lYd = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lau = null;
    private HeadImageView lYe = null;
    private View lav = null;
    private LinearLayout lax = null;
    private EditText lay = null;
    private FeedBackModel lXu = null;
    private FeedBackTopListView lYf = null;
    private ArrayList<WritePrefixItemLayout> lXw = new ArrayList<>();
    private String jih = null;
    private final KeyEvent gZr = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lYh = null;
    private TextView laz = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener heh = null;
    private com.baidu.tbadk.core.dialog.a lYi = null;
    private final Handler mHandler = new Handler();
    private boolean lYj = false;
    private String lYk = null;
    private RelativeLayout isn = null;
    private String emL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int emM = 0;
    private int lYl = 0;
    private WriteImagesInfo lYm = new WriteImagesInfo();
    private View mRootView = null;
    private GridView lYo = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a lYp = null;
    private ScrollView lXI = null;
    private EditText lYq = null;
    private View lYr = null;
    private View lYs = null;
    private View lYt = null;
    private EditText lYu = null;
    private TextView lYv = null;
    private TextView lYw = null;
    private TextWatcher lYx = null;
    private TextWatcher lYy = null;
    private boolean lXJ = false;
    private boolean lYz = false;
    private com.baidu.tbadk.core.view.a euw = null;
    private String mFrom = "write";
    private File lYA = null;
    private TbImageView lYB = null;
    private View mBubbleView = null;
    private Dialog lYC = null;
    private LinearLayout lYD = null;
    private boolean lYF = false;
    private long lYG = -1000;
    private boolean lYH = false;
    private String hOj = "2";
    private int bdm = 0;
    private String mTopicId = "";
    private SpannableStringBuilder lXM = new SpannableStringBuilder();
    private boolean lYL = false;
    private boolean aUD = false;
    private final b lXO = new b();
    private boolean lVx = false;
    private final HttpMessageListener lYN = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jih)) {
                    WriteActivity.this.jih = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.vB(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jih)) {
                    WriteActivity.this.jih = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jih);
                    WriteActivity.this.vB(true);
                }
            }
        }
    };
    private TbFaceManager.a lXQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a hoq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bVn();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.lab != null) {
                WriteActivity.this.lXO.aX(null);
                if (z) {
                    WriteActivity.this.ie(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.lab.getType() != 0 && WriteActivity.this.lab.getType() != 9) {
                        if (WriteActivity.this.lab.getType() != 7) {
                            if (WriteActivity.this.lab.getType() == 1) {
                                w.e(WriteActivity.this.lab.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.lab.getType() == 5) {
                                w.e(WriteActivity.this.lab.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            if (WriteActivity.this.lVx) {
                                w.d(WriteActivity.this.lab.getForumId(), (WriteData) null);
                            } else {
                                w.c(WriteActivity.this.lab.getForumId(), (WriteData) null);
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
                    WriteActivity.this.lXO.aX(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.lXO.Of(postWriteCallBackData.getErrorString());
                    WriteActivity.this.lXO.b(WriteActivity.this.lau, WriteActivity.this.lay);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aYm());
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl());
                        if (WriteActivity.this.lYd) {
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
        public void bdN() {
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
            if (aVar != null && !StringUtils.isNull(aVar.dea())) {
                WriteActivity.this.a(2, true, aVar.dea());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lnq = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
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
    private CustomMessageListener lXR = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lXS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int doe = WriteActivity.this.doe();
            if (doe >= 0 && doe < WriteActivity.this.lay.getText().length()) {
                WriteActivity.this.lay.setSelection(doe);
            }
        }
    };
    private boolean lXT = true;
    private final View.OnFocusChangeListener fPd = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lau || view == WriteActivity.this.mBack || view == WriteActivity.this.laz) {
                if (z) {
                    WriteActivity.this.lXT = true;
                    WriteActivity.this.dof();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lau);
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbz();
                    }
                } else if (view == WriteActivity.this.lau) {
                    WriteActivity.this.laA.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.lay && z) {
                WriteActivity.this.lXT = false;
                WriteActivity.this.dof();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lay);
                if (WriteActivity.this.elb != null) {
                    WriteActivity.this.elb.bbz();
                }
            }
            WriteActivity.this.dok();
        }
    };
    private TextWatcher lXU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String lXY = "";
        private String lXZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lXZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lXZ != null ? this.lXZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cZW();
            WriteActivity.this.dol();
            EditText dox = WriteActivity.this.dox();
            if (editable != null && dox != null && dox.getText() != null) {
                if (this.lXY == null || !this.lXY.equals(editable.toString())) {
                    if (WriteActivity.this.lXO != null) {
                        this.lXY = dox.getText().toString();
                        WriteActivity.this.lXO.b(dox, true);
                        return;
                    }
                    return;
                }
                dox.setSelection(dox.getSelectionEnd());
            }
        }
    };
    private TextWatcher lXV = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String lXZ;
        private String lYa = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lXZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lXZ != null ? this.lXZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cZW();
            EditText dow = WriteActivity.this.dow();
            if (editable != null && dow != null && dow.getText() != null) {
                if (this.lYa == null || !this.lYa.equals(editable.toString())) {
                    if (WriteActivity.this.lXO != null) {
                        this.lYa = dow.getText().toString();
                        WriteActivity.this.lXO.b(dow, false);
                        return;
                    }
                    return;
                }
                dow.setSelection(dow.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0726a jSR = new a.InterfaceC0726a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0726a
        public void onRefresh() {
            WriteActivity.this.jih = null;
            WriteActivity.this.vB(false);
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
    public void bdx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bdy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG.deh()) {
            bdx();
        } else {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.def();
        }
    }

    public void doH() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.lXN != null) {
                this.lXN.dmW();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG != null) {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.def();
        }
    }

    private void bdA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kD(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.emG.dej();
                } else {
                    WriteActivity.this.emT.bdN();
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
    public int doe() {
        int selectionEnd = dow().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dow().getText().getSpans(0, dow().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dow().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dow().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dof() {
        if (this.elb != null) {
            this.elb.setBarLauncherEnabled(!this.lXT);
            this.elb.setBarLauncherEnabled(true, 26);
            this.elb.setBarLauncherEnabled(true, 2);
            this.elb.setBarLauncherEnabled(true, 30);
            ag(9, this.lXT ? false : true);
        }
    }

    private void ag(int i, boolean z) {
        com.baidu.tbadk.editortools.g nc;
        if (this.elb != null && (nc = this.elb.nc(i)) != null) {
            if (z) {
                nc.display();
            } else {
                nc.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.lXJ) {
            this.lau.setVisibility(8);
            if (this.lab.getType() == 5) {
                this.lYt.setVisibility(8);
            } else {
                this.lYt.setVisibility(0);
            }
            a(this.lYw, this.lYq);
            a(this.lYv, this.lYu);
            cZW();
        }
        if (this.lYb) {
            this.lXT = true;
            dof();
            if (this.elb != null) {
                this.elb.bbz();
            }
            this.lau.requestFocus();
            ShowSoftKeyPadDelay(this.lau);
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
            doX();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                doF();
            }
            vC(true);
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
        if (this.lab.getType() == 0) {
            FO(this.bdm);
        }
        initUI();
        doM();
        this.emG = new LocationModel(getPageContext());
        this.emG.a(this.emT);
        registerListener(this.lnq);
        registerListener(this.lXR);
        cxp();
        dpa();
        if (this.lXJ) {
            this.lYp.setEditorTools(this.elb);
        } else {
            this.lay.requestFocus();
        }
        cUW();
        doF();
        doY();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cxp() {
        this.elb = new EditorTools(getActivity());
        this.elb.setBarMaxLauCount(5);
        this.elb.setMoreButtonAtEnd(true);
        this.elb.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.elb.setBarLauncherType(1);
        this.elb.hW(true);
        this.elb.hX(true);
        switch (this.lab.getType()) {
            case 4:
            case 5:
                doK();
                break;
            default:
                dog();
                break;
        }
        this.elb.build();
        if (this.lXs != null) {
            this.lXs.addView(this.elb);
        }
        crh();
        this.elb.display();
        com.baidu.tbadk.editortools.g nc = this.elb.nc(6);
        if (nc != null && !TextUtils.isEmpty(this.emL)) {
            ((View) nc).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.emL);
                }
            });
        }
        if (!this.lXJ) {
            this.elb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.elb.bbz();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (!this.lVx) {
            doi();
        }
    }

    private void doI() {
        this.lYr = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.lYt = this.lYr.findViewById(R.id.live_post_title_container);
        this.lYq = (EditText) this.lYr.findViewById(R.id.live_post_content);
        this.lYo = (GridView) this.lYr.findViewById(R.id.photoLiveGridView);
        this.lYu = (EditText) this.lYr.findViewById(R.id.live_post_title);
        this.lYv = (TextView) this.lYr.findViewById(R.id.titleOverPlusNumber);
        this.lYw = (TextView) this.lYr.findViewById(R.id.contentOverPlusNumber);
        this.lYs = this.lYr.findViewById(R.id.live_interval_view);
        this.lYv.setText(String.valueOf(20));
        this.lYw.setText(String.valueOf(233));
        this.lYr.setVisibility(0);
        this.lYv.setVisibility(0);
        this.lYw.setVisibility(0);
        this.lYu.setHint(R.string.tips_title_limit_new);
        this.lYu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lYz = true;
                    WriteActivity.this.lXT = true;
                    WriteActivity.this.dof();
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbz();
                    }
                }
            }
        });
        if (this.lab.getType() == 4) {
            this.lYq.setHint(R.string.live_write_input_content_new);
        } else if (this.lab.getType() == 5) {
            this.lYq.setHint(R.string.live_write_input_content_update);
        }
        this.lYq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lYz = false;
                    WriteActivity.this.lXT = false;
                    WriteActivity.this.dof();
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbz();
                    }
                }
            }
        });
        this.lYq.requestFocus();
        this.lYq.addTextChangedListener(aeH());
        this.lYu.requestFocus();
        this.lYu.addTextChangedListener(aeH());
        this.lYu.setOnClickListener(this.lXS);
        this.lYq.setOnClickListener(this.lXS);
        this.lYp = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.lYo);
        this.lYp.FI(6);
        this.lYo.setAdapter((ListAdapter) this.lYp);
        View findViewById = this.lYr.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dnQ() {
                WriteActivity.this.doV();
            }
        });
        doJ();
    }

    private void doJ() {
        if (this.lab.getType() == 0) {
            if (this.lab.getTitle() != null) {
                this.lYu.setText(this.lab.getTitle());
                this.lYu.setSelection(this.lab.getTitle().length());
                return;
            }
            return;
        }
        if (this.lab.getType() == 1 || this.lab.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.lXJ) {
            doT();
        }
        if (this.elb.bcY()) {
            this.elb.bbz();
        }
        FO(0);
    }

    private void FO(int i) {
        if (this.writeImagesInfo != null && this.lab != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lab.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.lab.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hOj);
            albumActivityConfig.setProfessionZone(this.lab.getProZone());
            albumActivityConfig.setFrsTabInfo(this.lRr);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void doK() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nf = this.elb.nf(5);
        if (nf != null) {
            nf.elL = 2;
        }
        this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.elb.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dog() {
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
        if (!this.lVx) {
            Boolean doQ = doQ();
            if (!this.lYb && doQ != null && doQ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.deM() && s.d(this.lab.getForumName(), true) && (runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
                lVar5.elL = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.elb.b(lVar5);
                }
            }
        }
        if (!this.lVx) {
            this.elb.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        }
        if (!this.lVx && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar4.elL = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar4);
            }
        }
        if (!this.lVx) {
            this.elb.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.lVx && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.elL = 7;
            this.elb.b(lVar3);
        }
        if (!this.lVx) {
            this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        } else {
            this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (!this.lVx && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.elN = true;
            lVar2.elL = 9;
            lVar2.elH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar2);
            }
        }
        if (!this.lVx && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.elN = true;
            lVar.elL = 10;
            lVar.elH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.elb.b(lVar);
            }
        }
        if (!this.lVx && this.lXy == null) {
            if (this.lXN == null) {
                this.lXN = new com.baidu.tieba.write.editor.b(getActivity(), this.hOj);
                this.lXN.bK(this.lab.getForumId(), this.privateThread);
                this.lXN.vt(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lXN.dmS();
                this.lXN.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                doH();
            }
            if (!v.isEmpty(this.mList)) {
                this.lXN.dmS();
            }
            this.elb.b(this.lXN);
        }
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nf = this.elb.nf(5);
        if (nf != null) {
            nf.elL = 1;
        }
    }

    private void doh() {
        if (this.lXP != null) {
            this.lXP.hideTip();
        }
    }

    private void doi() {
        if (this.lXP == null) {
            this.lXP = new e(getPageContext());
        }
        this.lXP.c(this.elb);
    }

    private void crh() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.dov()) {
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
                            if (qVar.aYc() == EmotionGroupType.BIG_EMOTION || qVar.aYc() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.vC(true);
                                    WriteActivity.this.cZW();
                                }
                            } else if (WriteActivity.this.dov()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.doy();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cFk();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.doX();
                        WriteActivity.this.cZW();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.FP(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").ag("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.lXy == null) {
                            WriteActivity.this.bdB();
                            return;
                        }
                        switch (WriteActivity.this.emM) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bdy();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bdx();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.emG != null) {
                            WriteActivity.this.emG.uw(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jih = null;
                        } else {
                            WriteActivity.this.jih = (String) aVar.data;
                        }
                        WriteActivity.this.vB(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.lab != null) {
                            str = WriteActivity.this.lab.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.dh("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.lab == null || (videoInfo = WriteActivity.this.lab.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.elb.bcY()) {
                                        WriteActivity.this.elb.bbz();
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
                        WriteActivity.this.lab.setVideoInfo(null);
                        WriteActivity.this.cZW();
                        if (WriteActivity.this.lay != null) {
                            WriteActivity.this.lay.requestFocus();
                        }
                        WriteActivity.this.elb.bbz();
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lay);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").ag("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.lXp = true;
                        WriteActivity.this.vz(true);
                        if (!WriteActivity.this.dox().isFocused() || WriteActivity.this.lXt.getVisibility() != 0) {
                            WriteActivity.this.lXo = "from_content";
                        } else {
                            WriteActivity.this.lXo = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.lXt.getVisibility() == 0) {
                            if (WriteActivity.this.lXt.hasFocus()) {
                                WriteActivity.this.lay.requestFocus();
                                WriteActivity.this.lay.setSelection(WriteActivity.this.lay.getText().toString().length());
                            }
                            WriteActivity.this.lXt.setVisibility(8);
                            WriteActivity.this.elb.nc(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.lXt.setVisibility(0);
                            WriteActivity.this.lXt.requestFocus();
                            WriteActivity.this.elb.nc(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cZW();
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
    public void FP(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdB() {
        if (this.emG.bHm()) {
            if (this.emG.deh()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.dec().getLocationData().dea());
                return;
            }
            a(1, true, (String) null);
            this.emG.def();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cZN() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lXu != null) {
            this.lXu.cancelLoadData();
        }
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        doh();
        TiebaPrepareImageService.StopService();
        cZN();
        doP();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.lYn != null) {
            this.lYn.destroy();
        }
        if (this.lYM != null) {
            this.lYM.Gu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doj() {
        if (this.lab != null && this.lab.getType() == 2 && this.lYj) {
            finish();
        } else if (this.lab == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lab.setTitle(dox().getText().toString());
            this.lab.setContent(dow().getText().toString());
            int type = this.lab.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.lVx) {
                        w.d(this.lab.getForumId(), this.lab);
                    } else {
                        w.c(this.lab.getForumId(), this.lab);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c("24591571", this.lab);
                }
            } else if (type == 1) {
                w.e(this.lab.getThreadId(), this.lab);
            } else if (type == 4) {
                w.c(this.lab.getForumId() + "photolive", this.lab);
            } else if (type == 5) {
                w.e(this.lab.getThreadId() + "updatephotolive", this.lab);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.laB != null && this.laB.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.laB, getPageContext().getPageActivity());
                return true;
            } else if (this.elb.bcY()) {
                this.elb.bbz();
                return true;
            } else {
                cZN();
                doj();
                return true;
            }
        }
        if (i == 67 && (text = dow().getText()) != null) {
            int selectionStart = dow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dow().onKeyDown(67, this.gZr);
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
        getLayoutMode().onModeChanged(this.isn);
        getLayoutMode().onModeChanged(this.lYD);
        am.setBackgroundColor(this.isn, R.color.cp_bg_line_e);
        if (this.lYB != null && (i == 1 || i == 4)) {
            this.lYB.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.laz, R.color.cp_link_tip_a, 1);
        dof();
        am.setBackgroundColor(this.lav, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.lYs, R.color.cp_bg_line_c);
        am.setBackgroundColor(dox(), R.color.cp_bg_line_e);
        am.setImageResource(this.jMv, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jih)) {
            am.setBackgroundColor(dow(), R.color.cp_bg_line_e);
        }
        cZW();
        this.elb.onChangeSkinType(i);
        if (this.lXH != null) {
            this.lXH.aWq();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lYn.lZj.notifyDataSetChanged();
        dok();
        dol();
        vB(false);
        if (this.lXO != null) {
            this.lXO.c(dox(), dow());
        }
        if (this.lVS != null) {
            this.lVS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dok() {
        if (this.lau.hasFocus()) {
            this.lau.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lau.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.lay.hasFocus()) {
            this.lay.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lay.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dol() {
        if (this.lau != null && this.lau.getText() != null && this.lau.getText().toString() != null && this.lau.getPaint() != null) {
            if (this.lau.getText().toString().length() == 0) {
                this.lau.getPaint().setFakeBoldText(false);
            } else if (this.lau.getText().toString().length() > 0) {
                this.lau.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.euw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lXJ = this.lab.getType() == 4 || 5 == this.lab.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lYh = (TextView) findViewById(R.id.btn_image_problem);
        doo();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laz.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.laz.setLayoutParams(layoutParams);
        this.laz.setOnFocusChangeListener(this.fPd);
        this.lXI = (ScrollView) findViewById(R.id.write_scrollview);
        this.lXI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.lay != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.lay);
                    }
                    if (WriteActivity.this.elb != null) {
                        WriteActivity.this.elb.bbz();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lYf = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.lYg = findViewById(R.id.feedback_divider);
        this.isn = (RelativeLayout) findViewById(R.id.parent);
        this.lXs = (LinearLayout) findViewById(R.id.tool_view);
        this.lXs.setContentDescription(IStringUtil.TOP_PATH);
        this.lXt = (LinearLayout) findViewById(R.id.title_view);
        this.lav = findViewById(R.id.interval_view);
        this.lYI = findViewById(R.id.hot_topic_fourm_view);
        this.lYJ = findViewById(R.id.hot_topic_divider);
        this.lXL = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.lYK = (TextView) findViewById(R.id.change_one_tv);
        cZV();
        if (this.lXJ) {
            this.lXI.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            doI();
        } else {
            this.lYn = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lYn.vr(false);
            } else {
                g gVar = this.lYn;
                if (this.lab.getType() != 0 && this.lab.getType() != 9) {
                    z = false;
                }
                gVar.vr(z);
            }
        }
        cZX();
        if (this.lYb || this.lXr) {
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
        this.lax = (LinearLayout) findViewById(R.id.post_content_container);
        this.lax.setDrawingCacheEnabled(false);
        this.lax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.lay.requestFocus();
            }
        });
        this.jMs = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jMt = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jMv = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cFk();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fPd);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cZN();
                WriteActivity.this.doj();
            }
        });
        this.lYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dor();
        o(doQ());
        dot();
        don();
        doN();
        doO();
        dof();
        dos();
        cZU();
        doz();
        if (this.lab.getType() == 4 && this.laD != null && this.lXv != null) {
            this.laD.setVisibility(8);
            this.lXv.setVisibility(8);
        }
        cZW();
        doL();
        dnw();
        dom();
    }

    private void dom() {
        this.lVS = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lVS.setData(this.lRr);
        this.lVS.setActivity(this);
    }

    private void dnw() {
        if (this.mName != null && this.lab != null && this.lab.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void don() {
        String str;
        String str2;
        if (this.lab != null) {
            switch (this.lab.getType()) {
                case 0:
                case 9:
                    if (this.lYb || this.lXr) {
                        if (this.lYd) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.hOj != null && this.hOj.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.lVx) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.hOj != null && this.hOj.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lab.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lab.getForumName() + getResources().getString(R.string.bar));
                        this.lau.setVisibility(8);
                        String str3 = this.hlo + " " + this.hlm;
                        if (!StringUtils.isNull(str3)) {
                            this.lay.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lau.setVisibility(0);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lau.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lab.getFloorNum() + 1)));
                    this.lYs.setVisibility(8);
                    return;
                case 7:
                    this.lau.setVisibility(0);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void doo() {
        if (this.lab.getType() == 7) {
            this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dop() {
        if (this.lab != null && this.lab.getType() == 0 && this.lab.getType() == 9 && !this.lYb && !this.lXr && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dox() != null) {
                dox().setText(cutStringWithSuffix);
                dox().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.jMs.setVisibility(0);
            this.jMt.setVoiceModel(voiceModel);
            this.jMt.deL();
            cZW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFk() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.wY(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.jMs.setVisibility(8);
        this.jMt.cfz();
        this.jMt.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nf = this.elb.nf(6);
        if (nf != null && nf.ekV != null) {
            nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cZW();
    }

    private void doq() {
        this.fns = null;
        this.lXE = -1;
        this.lXG = -1;
        ac ud = com.baidu.tieba.frs.ab.bWL().ud(1);
        if (ud != null) {
            this.fns = ud.hqX;
            this.lXE = getIntent().getIntExtra("category_id", -1);
            if (this.fns != null && !this.fns.isEmpty() && this.lXE >= 0) {
                this.lXD = new aa();
                this.lXD.hqT = 0;
                this.lXD.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lXG = this.lXD.hqT;
                this.lXF = this.lXD.name;
                for (aa aaVar : this.fns) {
                    if (aaVar.hqT == this.lXE) {
                        this.lXG = aaVar.hqT;
                        this.lXF = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dor() {
        if (this.fns != null && !this.fns.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lXH = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lXH.setText(this.lXF);
            this.lXH.setCategoryContainerData(this.fns, this.lXD, this.lXG);
            this.lXH.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        WriteActivity.this.lXH.setText(axVar.name);
                        WriteActivity.this.lab.setCategoryTo(axVar.hqT);
                        WriteActivity.this.lXG = axVar.hqT;
                        WriteActivity.this.lXH.dnS();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.lXH.dnR();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dox());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dow());
                }
            });
        }
    }

    private void doL() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lXW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lXW.setTitle(R.string.no_disturb_start_time);
        this.lXW.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lXW);
        this.lXW.setButton(-2, getPageContext().getString(R.string.cancel), this.lXW);
        return this.lXW;
    }

    private void dos() {
        this.lXz = (RelativeLayout) findViewById(R.id.addition_container);
        this.lXA = (TextView) findViewById(R.id.addition_create_time);
        this.lXB = (TextView) findViewById(R.id.addition_last_time);
        this.lXC = (TextView) findViewById(R.id.addition_last_content);
        if (this.lXy != null) {
            this.lXz.setVisibility(0);
            this.lXA.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lXy.getCreateTime() * 1000));
            if (this.lXy.getAlreadyCount() == 0) {
                this.lXB.setVisibility(8);
            } else {
                this.lXB.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lXy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lXy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lXC.setText(lastAdditionContent);
            } else {
                this.lXC.setVisibility(8);
            }
            dow().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lXy.getAlreadyCount()), Integer.valueOf(this.lXy.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lXz.setVisibility(8);
    }

    private void cZU() {
        this.laD = findViewById(R.id.post_prefix_layout);
        if (this.lYM == null) {
            this.lYM = new com.baidu.tieba.c.d(getPageContext(), this.laD);
            this.lYM.cG(R.drawable.bg_tip_blue_up_left);
            this.lYM.cF(16);
            this.lYM.ma(true);
            this.lYM.setUseDirectOffset(true);
            this.lYM.sx(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.laA = (TextView) findViewById(R.id.post_prefix);
        this.lXv = findViewById(R.id.prefix_divider);
        this.laC = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.laD.setVisibility(0);
            this.lYM.f(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lac = 0;
            this.laD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").dh("fid", WriteActivity.this.lab.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.laA.setVisibility(0);
                    WriteActivity.this.laD.setSelected(true);
                    am.setImageResource(WriteActivity.this.laC, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.laB, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.elb.bbz();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lau);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lay);
                }
            });
            this.laA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").dh("fid", WriteActivity.this.lab.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.laA.setSelected(true);
                    am.setImageResource(WriteActivity.this.laC, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.laB, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.elb.bbz();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dox());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dow());
                }
            });
            this.laB = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.laB.a(this);
            this.laB.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.laB.setOutsideTouchable(true);
            this.laB.setFocusable(true);
            this.laB.setOnDismissListener(this);
            this.laB.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.laA, R.color.cp_bg_line_d);
            am.setImageResource(this.laC, R.drawable.icon_arrow_gray_down);
            this.laA.setTextColor(color);
            this.lXw.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lXw.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vo(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vo(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.laB.addView(writePrefixItemLayout);
            }
            this.laB.setCurrentIndex(0);
            this.laA.setText(prefixs.get(0));
            FN(0);
            return;
        }
        this.laD.setVisibility(8);
    }

    private void doM() {
        if (this.lYb && this.lab != null) {
            this.lYf.setVisibility(0);
            this.lYg.setVisibility(0);
            this.lXu = new FeedBackModel(getPageContext());
            this.lXu.Oz(this.lab.getForumName());
            this.lXu.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.lYf.setVisibility(8);
                        WriteActivity.this.lYg.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.lYf.setVisibility(8);
                        WriteActivity.this.lYg.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.lYf.a(feedBackModel.dnU(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dot() {
        this.laz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.lXO.a(WriteActivity.this.lau, WriteActivity.this.lay)) {
                        WriteActivity.this.showToast(WriteActivity.this.lXO.dmk());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dox());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dow());
                    WriteActivity.this.elb.bbz();
                    if (WriteActivity.this.lab.getType() != 7) {
                        if (WriteActivity.this.lYb) {
                            WriteActivity.this.doC();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.ag("obj_type", StringUtils.isNull(WriteActivity.this.lab.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.doD();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.doC();
                    }
                    MercatorModel.deu().startLoad();
                    TiebaStatic.log(new an("c12262").dh("obj_locate", WriteActivity.this.hOj));
                }
            }
        });
    }

    protected void doN() {
        this.lYi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.lYi.vO(getPageContext().getString(R.string.is_save_draft)).gW(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.lab.setTitle(WriteActivity.this.dox().getText().toString());
                WriteActivity.this.lab.setContent(WriteActivity.this.dow().getText().toString());
                int type = WriteActivity.this.lab.getType();
                if (type == 0 || type == 9) {
                    if (WriteActivity.this.lVx) {
                        w.d(WriteActivity.this.lab.getForumId(), WriteActivity.this.lab);
                    } else {
                        w.c(WriteActivity.this.lab.getForumId(), WriteActivity.this.lab);
                    }
                } else if (type == 1) {
                    w.e(WriteActivity.this.lab.getThreadId(), WriteActivity.this.lab);
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
                int type = WriteActivity.this.lab.getType();
                if (type == 0 || type == 9) {
                    if (WriteActivity.this.lVx) {
                        w.d(WriteActivity.this.lab.getForumId(), (WriteData) null);
                    } else {
                        w.c(WriteActivity.this.lab.getForumId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    w.e(WriteActivity.this.lab.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.lYi.b(getPageContext());
    }

    protected void cZV() {
        this.lYe = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.lYe.setIsRound(true);
        this.lYe.setDrawBorder(false);
        this.lYe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String wj = o.wj(currentPortrait);
            this.lYe.setUrl(wj);
            this.lYe.startLoad(wj, 12, false);
        }
        if (this.lab.isUserFeedback()) {
            this.lYe.setVisibility(0);
        }
        this.lau = (EditText) findViewById(R.id.post_title);
        this.lau.setOnClickListener(this.lXS);
        this.lau.setOnFocusChangeListener(this.fPd);
        if (this.lab.getType() == 0 || this.lab.getType() == 9 || this.lab.getType() == 7) {
            if (this.lab.getTitle() != null) {
                this.lau.setText(this.lab.getTitle());
                this.lau.setSelection(this.lab.getTitle().length());
            } else if (this.lYd) {
                this.lau.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lab.getType() == 1 || this.lab.getType() != 2) {
        }
        this.lau.addTextChangedListener(this.lXU);
        if (!this.lab.getHaveDraft()) {
            dop();
            this.lYH = true;
        }
        if (this.lab.isUserFeedback()) {
            this.lau.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lau.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher aeH() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int lYQ;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cZW();
                if (WriteActivity.this.lXJ) {
                    this.lYQ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.lYQ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.lXJ || !WriteActivity.this.lYz) {
                    if (WriteActivity.this.lXJ) {
                        if (this.mEditText != WriteActivity.this.lYq || this.mTextView != WriteActivity.this.lYw) {
                            this.mEditText = WriteActivity.this.lYq;
                            this.mTextView = WriteActivity.this.lYw;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.lYu || this.mTextView != WriteActivity.this.lYv) {
                    this.mEditText = WriteActivity.this.lYu;
                    this.mTextView = WriteActivity.this.lYv;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.lXJ && this.lYz) {
            if (this.lYx != null) {
                this.lYu.removeTextChangedListener(this.lYx);
            }
            this.lYx = textWatcher;
        } else if (this.lXJ) {
            if (this.lYy != null) {
                this.lYq.removeTextChangedListener(this.lYy);
            }
            this.lYy = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.lYq) {
            return 233L;
        }
        if (editText != this.lYu) {
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
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.c.a.q(editText.getText().toString().trim());
    }

    protected void cZX() {
        this.lay = (EditText) findViewById(R.id.post_content);
        this.lay.setDrawingCacheEnabled(false);
        this.lay.setOnClickListener(this.lXS);
        if (this.lab.getContent() != null && this.lab.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bes().ak(getPageContext().getPageActivity(), this.lab.getContent());
            this.lay.setText(ak);
            this.lay.setSelection(ak.length());
        } else if (this.lab.getType() == 2) {
            if (this.lYj) {
                if (this.lYk != null && this.lYk.length() > 0) {
                    this.lay.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.lYk}));
                    this.lay.setSelection(this.lay.getText().length());
                }
            } else if (this.lab.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lab.getFloorNum()));
                this.lay.setText(format);
                this.lay.setSelection(format.length());
            }
        }
        this.lay.setOnFocusChangeListener(this.fPd);
        this.lay.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.lay.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lay.addTextChangedListener(this.lXV);
        if (this.lab.getType() == 0) {
            this.lYL = true;
        } else {
            vB(true);
            this.lYL = false;
        }
        if (this.lab.isUserFeedback()) {
            this.lay.setHint(R.string.write_input_content);
        } else {
            this.lay.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void vB(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.lXJ && !this.lVx) {
            dow().setPadding(0, 0, 0, 0);
            dow().setBackgroundDrawable(null);
            am.setBackgroundColor(dow(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.jih) && this.lXy == null) {
                com.baidu.adp.lib.e.c.kX().a(this.jih, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.dow().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dow(), true, WriteActivity.this.jSR);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dov() {
        int i = 5000;
        if (this.lXy != null) {
            i = 1000;
        }
        return dow().getText() != null && dow().getText().length() >= i;
    }

    private void ye(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lXo)) {
                this.lXo = "";
                dow().requestFocus();
                if (dow().getText() != null && dow().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dow().getSelectionStart();
                    editable = dow().getText();
                }
            } else if ("from_title".equals(this.lXo)) {
                this.lXo = "";
                dox().requestFocus();
                if (dox().getText() != null && dox().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dox().getSelectionStart();
                    editable = dox().getText();
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
    public void vz(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lab != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lab.getForumId(), 0L), this.lab.getFirstDir(), this.lab.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dow().getText().getSpans(0, dow().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lXx == null) {
                this.lXx = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.lXx.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aYc = qVar.aYc();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kX().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.dow().getSelectionStart(), aVar, aYc);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && dow() != null && dow().getText() != null) {
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
                int selectionStart = dow().getSelectionStart() - 1;
                if (dow().getText().length() > 1 && selectionStart >= 0 && dow().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    dow().getText().insert(dow().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            dow().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                dow().getText().insert(dow().getSelectionStart(), spannableString2);
            }
            Editable text = dow().getText();
            if (text != null) {
                this.lXM.clear();
                this.lXM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lXM);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && dow().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    dow().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                dow().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dow() {
        return this.lXJ ? this.lYq : this.lay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dox() {
        return this.lXJ ? this.lYu : this.lau;
    }

    protected void doy() {
        Editable text;
        if (dow() != null && (text = dow().getText()) != null) {
            int selectionStart = dow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dow().onKeyDown(67, this.gZr);
            }
            dow().onKeyDown(67, this.gZr);
            int selectionStart2 = dow().getSelectionStart();
            if (text != null) {
                this.lXM.clear();
                this.lXM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lXM);
                dow().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.lab != null) {
            str = this.lab.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.lYb = true;
        }
    }

    private void doO() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void doP() {
        try {
            if (this.lYi != null) {
                this.lYi.dismiss();
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

    private Boolean doQ() {
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

    public void cZW() {
        if (this.lab != null) {
            String str = "";
            String str2 = "";
            if (dox() != null) {
                str = dox().getText().toString();
            }
            if (dow() != null) {
                str2 = dow().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lab.getType() == 0 || this.lab.getType() == 9 || this.lab.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.lac == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lab.setIsNoTitle(true);
                        } else if (this.lXt.getVisibility() == 0) {
                            this.lab.setIsNoTitle(false);
                            vA(true);
                            return;
                        }
                    } else if (this.lXt.getVisibility() == 0) {
                        this.lab.setIsNoTitle(false);
                        vA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lab.setIsNoTitle(true);
                } else if (this.lXt.getVisibility() == 0) {
                    this.lab.setIsNoTitle(false);
                    vA(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lXJ) {
                    vA(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vA(true);
                }
            }
            if (this.lab.getType() == 4) {
                vA(l(this.lYq) && k(this.lYu));
            } else if (this.lab.getType() == 5) {
                vA(l(this.lYq));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                vA(true);
            } else if (this.lab.getVideoInfo() != null) {
                vA(true);
            } else {
                vA(false);
            }
        }
    }

    public void vA(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.laz, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.laz.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.laz, R.color.cp_cont_d, 1);
        this.laz.setEnabled(false);
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
        String str;
        this.emH = new NewWriteModel(this);
        this.emH.b(this.emV);
        registerListener(this.lYN);
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cZN();
            }
        };
        this.lab = new WriteData();
        if (bundle != null) {
            this.lab.setType(bundle.getInt("type", 0));
            this.lab.setForumId(bundle.getString("forum_id"));
            this.lab.setForumName(bundle.getString("forum_name"));
            this.lab.setFirstDir(bundle.getString("forum_first_dir"));
            this.lab.setSecondDir(bundle.getString("forum_second_dir"));
            this.lab.setThreadId(bundle.getString("thread_id"));
            this.lab.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lab.setFloorNum(bundle.getInt("floor_num", 0));
            this.lYb = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.lYc = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.lYd = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lYj = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lYk = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.emF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lXy = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lab.setIsAddition(this.lXy != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.lYl = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lab.setTitle(bundle.getString("write_title"));
            this.lab.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lab.setTopicId(this.mTopicId);
            this.hOj = bundle.getString("KEY_CALL_FROM");
            this.bdm = bundle.getInt("album_thread");
            this.lRr = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.lab.setType(intent.getIntExtra("type", 0));
            this.lab.setForumId(intent.getStringExtra("forum_id"));
            this.lab.setForumName(intent.getStringExtra("forum_name"));
            this.lab.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lab.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lab.setThreadId(intent.getStringExtra("thread_id"));
            this.lab.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lab.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.lYb = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.lYc = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.lYd = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lYj = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lYk = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.lXy = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lab.setIsAddition(this.lXy != null);
            this.lab.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.lYl = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hln = intent.getStringExtra("more_forum_img");
            this.hlo = intent.getStringExtra("more_forum_title");
            this.hlm = intent.getStringExtra("more_forum_url");
            this.lab.setTitle(intent.getStringExtra("write_title"));
            this.lab.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lab.setTopicId(this.mTopicId);
            this.hOj = intent.getStringExtra("KEY_CALL_FROM");
            this.bdm = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.lRr = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lab.mDynamicImageTextData = new ImageTextUploadData();
            this.lVx = true;
        }
        if (this.lab.getType() == 9) {
            this.lab.setEntranceType(1);
        } else if (this.lab.getType() == 10) {
            this.lab.setEntranceType(2);
            this.lab.setType(9);
        } else if (this.lab.getType() == 0) {
            this.lab.setEntranceType(3);
        }
        this.lab.setIsUserFeedback(this.lYb);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lab.getType() == 4 ? 6 : 9);
        this.lab.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lab.getType() == 0 || this.lab.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.lVx) {
                    w.d(this.lab.getForumId(), this);
                } else {
                    w.c(this.lab.getForumId(), this);
                }
            }
        } else if (this.lab.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.lab.getType() == 1) {
            w.a(this.lab.getThreadId(), this);
        } else if (this.lab.getType() == 4) {
            w.c(this.lab.getForumId() + "photolive", this);
        } else if (this.lab.getType() == 5) {
            w.a(this.lab.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jih = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lab != null && this.lab.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lab.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lXr = true;
        }
        doq();
        try {
            this.lYA = doZ();
        } catch (Throwable th) {
            this.lYA = null;
        }
    }

    private void doz() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lau.setText(com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName)));
            this.lau.setMovementMethod(com.baidu.tieba.view.c.dlQ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString yI = com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName));
            if (yI != null) {
                this.lau.setText(yI);
            }
            this.lXL.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        String str;
        String yJ;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.lab != null) {
                    this.lab.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(dox().getText().toString()) || this.lYH || ((this.lYb || this.lXr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.lab.getTitle())) {
                            this.lab.setTitle(writeData.getTitle());
                        }
                        if (!v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                yJ = this.lab.getTitle();
                            } else {
                                yJ = com.baidu.tbadk.plugins.b.yJ(str);
                            }
                            SpannableString yI = com.baidu.tbadk.plugins.b.yI(yJ);
                            if (yI != null) {
                                dox().setText(yI);
                                dox().setSelection(yI.length() > yJ.length() ? yJ.length() : yI.length());
                            }
                        } else {
                            SpannableString yI2 = com.baidu.tbadk.plugins.b.yI(this.lab.getTitle());
                            if (yI2 != null) {
                                dox().setText(yI2);
                                dox().setSelection(this.lab.getTitle().length() > yI2.length() ? yI2.length() : this.lab.getTitle().length());
                            }
                        }
                    }
                    if (this.lab != null && !this.lab.getHaveDraft()) {
                        dop();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.lab.setVideoInfo(videoInfo);
                        this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(dow().getText().toString()) || this.lYb || this.lXr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.lab.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.bes().a(getPageContext().getPageActivity(), this.lab.getContent(), this.lXQ);
                        dow().setText(a2);
                        dow().setSelection(a2.length());
                        if (this.lXJ) {
                            a(this.lYw, this.lYq);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.lab.setWriteImagesInfo(this.writeImagesInfo);
                        doX();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            doF();
                        }
                        vC(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        doR();
                    }
                    cZW();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.fns != null) {
                        this.lXG = this.lXD.hqT;
                        this.lXF = this.lXD.name;
                        int i = 0;
                        while (true) {
                            if (i == this.fns.size()) {
                                break;
                            }
                            aa aaVar = this.fns.get(i);
                            if (categoryTo != aaVar.hqT) {
                                i++;
                            } else {
                                this.lXG = categoryTo;
                                this.lXF = aaVar.name;
                                this.lab.setCategoryTo(this.lXG);
                                break;
                            }
                        }
                        if (this.lXH != null) {
                            this.lXH.setText(this.lXF);
                            this.lXH.setCategoryContainerData(this.fns, this.lXD, this.lXG);
                        }
                    }
                    this.elb.bbz();
                    return;
                }
                return;
            }
            doR();
            dop();
        }
    }

    private void doR() {
        if ((!this.lXJ || this.lYp != null) && this.lYo != null) {
            this.lYp.b(this.writeImagesInfo);
            doV();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lab.getType());
        bundle.putString("forum_id", this.lab.getForumId());
        bundle.putString("forum_name", this.lab.getForumName());
        bundle.putString("forum_first_dir", this.lab.getFirstDir());
        bundle.putString("forum_second_dir", this.lab.getSecondDir());
        bundle.putString("thread_id", this.lab.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lab.getFloor());
        bundle.putInt("floor_num", this.lab.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.lYj);
        if (this.lYb) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.emF);
        if (this.lXy != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lXy));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.lYl);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOj);
        bundle.putInt("album_thread", this.bdm);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.lRr);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dow().getEditableText().toString();
        if (obj != null) {
            dow().setText(TbFaceManager.bes().a(getPageContext().getPageActivity(), obj, this.lXQ));
            dow().setSelection(dow().getText().length());
        }
    }

    private String doA() {
        return (dow() == null || dow().getText() == null) ? "" : dow().getText().toString();
    }

    private String doB() {
        if (this.lab == null || dox() == null || dox().getVisibility() != 0 || dox().getText() == null) {
            return "";
        }
        String obj = dox().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lac != v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lab.getType() != 4 && this.laA != null && this.laA.getText() != null) {
            this.lab.setPostPrefix(this.laA.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lab.getTitle();
        }
        return obj;
    }

    private void OA(String str) {
        if (this.lab != null && this.lXt != null) {
            if (this.lXt.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lab.setIsNoTitle(true);
                    this.lab.setTitle("");
                    return;
                }
                this.lab.setIsNoTitle(false);
                this.lab.setTitle(str);
                return;
            }
            this.lab.setIsNoTitle(true);
            this.lab.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doC() {
        cZN();
        this.lab.setContent(doA());
        OA(doB());
        if (this.lYb || this.lXr) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lab.getTitle()) || !this.lab.getTitle().startsWith(string)) {
                OA(string + this.lab.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lab.getContent()) || !this.lab.getContent().startsWith(str)) {
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
                sb.append(this.lab.getContent());
                this.lab.setContent(sb.toString());
            }
        }
        if (this.lYc) {
            this.lab.setContent(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE) + "\n" + this.lab.getContent());
        }
        if (this.lXE >= 0) {
            this.lab.setCategoryFrom(this.lXE);
        }
        if (this.lXG >= 0) {
            this.lab.setCategoryTo(this.lXG);
        }
        this.lab.setWriteImagesInfo(this.writeImagesInfo);
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
            this.lab.setTakePhotoNum(i);
        }
        this.lab.setHasLocationData(this.emG != null && this.emG.bHm());
        if (this.writeImagesInfo != null) {
            this.emH.uy(this.writeImagesInfo.size() > 0);
        }
        if (!v.isEmpty(this.mList) && this.lXK != null && this.lXK.mIsGlobalBlock == 0) {
            this.lab.setForumId(String.valueOf(this.lXK.mForumId));
            this.lab.setForumName(this.lXK.mForumName);
        }
        dnz();
        this.emH.d(this.lab);
        this.lab.setContent(this.lab.getContent().replaceAll("\u0000\n", ""));
        this.lab.setContent(this.lab.getContent().replaceAll("\u0000", ""));
        this.lab.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.emH.cZP().setVoice(this.mVoiceModel.getId());
                this.emH.cZP().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.emH.cZP().setVoice(null);
                this.emH.cZP().setVoiceDuringTime(-1);
            }
        } else {
            this.emH.cZP().setVoice(null);
            this.emH.cZP().setVoiceDuringTime(-1);
        }
        if (!this.emH.deQ()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lab.mDynamicImageTextData != null) {
            dny();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.heh);
            this.emH.deN();
        }
    }

    private void dnz() {
        FrsTabItemData selectedTabItemData;
        if (this.lab != null && this.lVS != null && (selectedTabItemData = this.lVS.getSelectedTabItemData()) != null) {
            this.lab.setTabId(selectedTabItemData.tabId);
            this.lab.setTabName(selectedTabItemData.name);
            this.lab.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dny() {
        if (this.lab.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lab, new a.InterfaceC0748a() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // com.baidu.tieba.write.b.a.InterfaceC0748a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dnj().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.33.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            w.d(WriteActivity.this.lab.getForumId(), (WriteData) null);
                            com.baidu.tieba.write.b.a.dna();
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
                            com.baidu.tieba.write.b.a.dna();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0748a
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
            if (this.lXy != null) {
                i2 = this.lXy.getTotalCount();
                i = this.lXy.getAlreadyCount() + 1;
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
                if (this.lau == getCurrentFocus()) {
                    dow().clearFocus();
                    this.lau.requestFocus();
                    if (this.elb != null) {
                        this.elb.bbz();
                    }
                    ShowSoftKeyPadDelay(this.lau);
                } else {
                    dow().requestFocus();
                    if (this.elb != null) {
                        this.elb.bbz();
                    }
                    ShowSoftKeyPadDelay(this.lay);
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
                            dow().getText().insert(dow().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.lab.getType() == 0 || this.lab.getType() == 9) {
                    if (this.lVx) {
                        w.d(this.lab.getForumId(), (WriteData) null);
                    } else {
                        w.c(this.lab.getForumId(), (WriteData) null);
                    }
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.lab.getType() == 1) {
                    w.e(this.lab.getThreadId(), (WriteData) null);
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
                                doW();
                            } else {
                                an(intent);
                            }
                        } else if (intExtra == 1) {
                            ao(intent);
                        } else {
                            al(intent);
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.lYL) {
                            vB(true);
                            this.lYL = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.lXJ) {
                        D(intent);
                        cZW();
                        return;
                    }
                    am(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lab.setVideoInfo(videoInfo);
                        this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.elb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cZW();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.lXp) {
                                sb2.append(com.baidu.tbadk.plugins.b.euc);
                                this.lXp = false;
                            }
                            sb2.append(stringExtra);
                            ye(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.lXK = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.lXK);
                }
            }
        } else if (i2 == 0) {
            if (this.elb != null && !this.elb.bcY()) {
                this.lay.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.elb.bbz();
            }
            switch (i) {
                case 12001:
                    bdE();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    doU();
                    if (this.lYL) {
                        vB(true);
                        this.lYL = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lau == getCurrentFocus()) {
                        dow().clearFocus();
                        this.lau.requestFocus();
                        if (this.elb != null) {
                            this.elb.bbz();
                        }
                        ShowSoftKeyPadDelay(this.lau);
                        return;
                    }
                    dow().requestFocus();
                    if (this.elb != null) {
                        this.elb.bbz();
                    }
                    ShowSoftKeyPadDelay(this.lay);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.lXO.Of(postWriteCallBackData.getErrorString());
                        this.lXO.aX(postWriteCallBackData.getSensitiveWords());
                        this.lXO.b(this.lau, this.lay);
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
                    doU();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lXo)) {
                        dox().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lXo)) {
                        dow().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doD() {
        if ("1".equals(this.hOj)) {
            this.lab.setCanNoForum(true);
            this.lab.setTransmitForumData("[]");
        } else if ("2".equals(this.hOj)) {
            this.lab.setCanNoForum(false);
        }
        doE();
        this.lab.setPrivacy(this.isPrivacy);
        doS();
        this.lab.setToDynamic(this.isToDynamic);
        this.lab.setCallFrom(this.hOj);
        if (this.lab.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        doC();
    }

    private void doE() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void doS() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void doT() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void doU() {
        if (this.lXJ) {
            this.lYp.b(this.writeImagesInfo);
            doV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doV() {
        this.lYp.notifyDataSetChanged();
        this.lYo.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.lYp.notifyDataSetChanged();
                WriteActivity.this.lYo.invalidateViews();
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
        cZW();
    }

    private void al(Intent intent) {
        if (this.lXJ) {
            am(intent);
            doU();
        } else {
            ap(intent);
        }
        cZW();
    }

    private void am(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            doU();
            vC(true);
        }
    }

    private void an(Intent intent) {
        if (this.writeImagesInfo != null) {
            C(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void doW() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ao(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.lYm.parseJson(stringExtra);
            this.lYm.updateQuality();
            if (this.lYm.getChosedFiles() != null && this.lYm.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.lYm.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.lYm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dox());
        HidenSoftKeyPad(this.mInputManager, dow());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ap(Intent intent) {
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
            doX();
            doF();
        }
        vC(true);
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
                doX();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    doF();
                }
            }
            vC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doX() {
        if (this.elb.nf(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void bdE() {
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

    private void doY() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hln)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.hln, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.vC(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(boolean z) {
        String forumId = this.lab == null ? "" : this.lab.getForumId();
        if (this.lYn != null) {
            this.lYn.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bVn() {
        this.hnh = getVoiceManager();
        this.hnh.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hoq) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lab.getType() != 7) {
                if (this.lXy == null) {
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

    private void doF() {
        if (!this.lXJ) {
            if (this.elb != null) {
                this.elb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.elb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lab == null ? "" : this.lab.getForumId();
            if (this.lYn != null) {
                this.lYn.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void FN(int i) {
        if (i < this.lXw.size()) {
            for (int i2 = 0; i2 < this.lXw.size(); i2++) {
                this.lXw.get(i2).vp(false);
            }
            this.lXw.get(i).vp(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Dv(int i) {
        if (i == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").ag("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").ag("obj_type", 2));
        }
        this.lac = i;
        this.laB.setCurrentIndex(i);
        FN(i);
        this.laA.setText(this.mPrefixData.getPrefixs().get(i));
        cZW();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.laB, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.laD.setSelected(false);
        am.setImageResource(this.laC, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.lay);
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
        if (this.lab != null) {
            if (this.lab.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lab.getType() == 5) {
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
            bdy();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
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
        if (this.lYF && System.currentTimeMillis() - this.lYG < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.lYF = false;
        }
        if (this.lXN != null && !z) {
            this.lXN.bPf();
        }
        if (this.lXP != null && !z) {
            doh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.lYC != null) {
            OC(str);
            this.lYC.dismiss();
        }
    }

    private void fy(Context context) {
        lYE = l.getEquipmentHeight(context);
    }

    private void OC(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.lYF = true;
        doX();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            doF();
        }
        vC(true);
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

    private File doZ() {
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

    private void dpa() {
        if (this.lYA != null && this.lab.getType() == 0 && this.lab.getType() == 9) {
            fy(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.lYA != null) {
                        WriteActivity.this.OB(WriteActivity.this.lYA.getAbsolutePath());
                    }
                }
            });
            this.lYB = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.lYD = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.lYA.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.lYA.getAbsolutePath());
                Bitmap g = g(this.lYA.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.lYB.setImageBitmap(g);
                    this.lYB.setDrawBorder(true);
                    this.lYB.setBorderWidth(2);
                    this.lYB.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.lYC = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.lYC.setCanceledOnTouchOutside(true);
                    this.lYC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.lYF) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.lYG = System.currentTimeMillis();
                            }
                        }
                    });
                    this.lYC.setContentView(this.mBubbleView);
                    this.lYC.show();
                    Window window = this.lYC.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (lYE / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
            this.lXp = false;
            this.lXo = "";
            if ("from_content".equals(str)) {
                this.lXo = "from_content";
            } else if ("from_title".equals(str)) {
                this.lXo = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.yH(String.valueOf(charSequence.charAt(i)))) {
                vz(false);
            }
        }
    }

    public void cUW() {
        if (this.lYb || !v.isEmpty(this.mList) || !StringUtils.isNull(this.lab.getTitle())) {
            this.lXt.setVisibility(0);
            this.lXt.requestFocus();
            return;
        }
        this.lXt.setVisibility(8);
    }
}
